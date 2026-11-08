/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class Converter<A, B>
implements Function<A, B> {
    private final boolean handleNullAutomatically;
    private transient Converter<B, A> reverse;

    protected Converter() {
        this(true);
    }

    Converter(boolean bl) {
        this.handleNullAutomatically = bl;
    }

    protected abstract B doForward(A var1);

    protected abstract A doBackward(B var1);

    @Nullable
    public final B convert(@Nullable A a) {
        return this.correctedDoForward(a);
    }

    @Nullable
    B correctedDoForward(@Nullable A a) {
        if (this.handleNullAutomatically) {
            return a == null ? null : (B)Preconditions.checkNotNull(this.doForward(a));
        }
        return this.doForward(a);
    }

    @Nullable
    A correctedDoBackward(@Nullable B b) {
        if (this.handleNullAutomatically) {
            return b == null ? null : (A)Preconditions.checkNotNull(this.doBackward(b));
        }
        return this.doBackward(b);
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>(){

            @Override
            public Iterator<B> iterator() {
                return new Iterator<B>(){
                    private final Iterator<? extends A> fromIterator;
                    {
                        this.fromIterator = iterable.iterator();
                    }

                    @Override
                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    @Override
                    public B next() {
                        return Converter.this.convert(this.fromIterator.next());
                    }

                    @Override
                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    public Converter<B, A> reverse() {
        Converter<A, B> converter = this.reverse;
        return converter == null ? (this.reverse = new ReverseConverter(this)) : converter;
    }

    public <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return new ConverterComposition(this, Preconditions.checkNotNull(converter));
    }

    @Override
    @Deprecated
    @Nullable
    public final B apply(@Nullable A a) {
        return this.convert(a);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    private static final class IdentityConverter<T>
    extends Converter<T, T>
    implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0L;

        private IdentityConverter() {
        }

        @Override
        protected T doForward(T t) {
            return t;
        }

        @Override
        protected T doBackward(T t) {
            return t;
        }

        public IdentityConverter<T> reverse() {
            return this;
        }

        @Override
        public <S> Converter<T, S> andThen(Converter<T, S> converter) {
            return Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class FunctionBasedConverter<A, B>
    extends Converter<A, B>
    implements Serializable {
        private final Function<? super A, ? extends B> forwardFunction;
        private final Function<? super B, ? extends A> backwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = Preconditions.checkNotNull(function);
            this.backwardFunction = Preconditions.checkNotNull(function2);
        }

        @Override
        protected B doForward(A a) {
            return this.forwardFunction.apply(a);
        }

        @Override
        protected A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter)object;
                return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
            }
            return false;
        }

        public int hashCode() {
            return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    private static final class ConverterComposition<A, B, C>
    extends Converter<A, C>
    implements Serializable {
        final Converter<A, B> first;
        final Converter<B, C> second;
        private static final long serialVersionUID = 0L;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override
        protected C doForward(A a) {
            throw new AssertionError();
        }

        @Override
        protected A doBackward(C c) {
            throw new AssertionError();
        }

        @Override
        @Nullable
        C correctedDoForward(@Nullable A a) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        @Override
        @Nullable
        A correctedDoBackward(@Nullable C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition)object;
                return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
            }
            return false;
        }

        public int hashCode() {
            return 31 * this.first.hashCode() + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    private static final class ReverseConverter<A, B>
    extends Converter<B, A>
    implements Serializable {
        final Converter<A, B> original;
        private static final long serialVersionUID = 0L;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override
        protected A doForward(B b) {
            throw new AssertionError();
        }

        @Override
        protected B doBackward(A a) {
            throw new AssertionError();
        }

        @Override
        @Nullable
        A correctedDoForward(@Nullable B b) {
            return this.original.correctedDoBackward(b);
        }

        @Override
        @Nullable
        B correctedDoBackward(@Nullable A a) {
            return this.original.correctedDoForward(a);
        }

        @Override
        public Converter<A, B> reverse() {
            return this.original;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof ReverseConverter) {
                ReverseConverter reverseConverter = (ReverseConverter)object;
                return this.original.equals(reverseConverter.original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }
}

