/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner {
    private final String separator;

    public static Joiner on(String string) {
        return new Joiner(string);
    }

    public static Joiner on(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String string) {
        this.separator = Preconditions.checkNotNull(string);
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public <A extends Appendable> A appendTo(A a, Iterable<?> iterable) throws IOException {
        return this.appendTo(a, iterable.iterator());
    }

    public <A extends Appendable> A appendTo(A a, Iterator<?> iterator2) throws IOException {
        Preconditions.checkNotNull(a);
        if (iterator2.hasNext()) {
            a.append(this.toString(iterator2.next()));
            while (iterator2.hasNext()) {
                a.append(this.separator);
                a.append(this.toString(iterator2.next()));
            }
        }
        return a;
    }

    public final <A extends Appendable> A appendTo(A a, Object[] objectArray) throws IOException {
        return this.appendTo(a, Arrays.asList(objectArray));
    }

    public final <A extends Appendable> A appendTo(A a, @Nullable Object object, @Nullable Object object2, Object ... objectArray) throws IOException {
        return this.appendTo(a, Joiner.iterable(object, object2, objectArray));
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterable<?> iterable) {
        return this.appendTo(stringBuilder, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator<?> iterator2) {
        try {
            this.appendTo((Appendable)stringBuilder, iterator2);
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
        return stringBuilder;
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Object[] objectArray) {
        return this.appendTo(stringBuilder, (Iterable<?>)Arrays.asList(objectArray));
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, @Nullable Object object, @Nullable Object object2, Object ... objectArray) {
        return this.appendTo(stringBuilder, Joiner.iterable(object, object2, objectArray));
    }

    public final String join(Iterable<?> iterable) {
        return this.join(iterable.iterator());
    }

    public final String join(Iterator<?> iterator2) {
        return this.appendTo(new StringBuilder(), iterator2).toString();
    }

    public final String join(Object[] objectArray) {
        return this.join(Arrays.asList(objectArray));
    }

    public final String join(@Nullable Object object, @Nullable Object object2, Object ... objectArray) {
        return this.join(Joiner.iterable(object, object2, objectArray));
    }

    @CheckReturnValue
    public Joiner useForNull(final String string) {
        Preconditions.checkNotNull(string);
        return new Joiner(this){

            @Override
            CharSequence toString(@Nullable Object object) {
                return object == null ? string : Joiner.this.toString(object);
            }

            @Override
            public Joiner useForNull(String string2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new Joiner(this){

            @Override
            public <A extends Appendable> A appendTo(A a, Iterator<?> iterator2) throws IOException {
                Object obj;
                Preconditions.checkNotNull(a, "appendable");
                Preconditions.checkNotNull(iterator2, "parts");
                while (iterator2.hasNext()) {
                    obj = iterator2.next();
                    if (obj == null) continue;
                    a.append(Joiner.this.toString(obj));
                    break;
                }
                while (iterator2.hasNext()) {
                    obj = iterator2.next();
                    if (obj == null) continue;
                    a.append(Joiner.this.separator);
                    a.append(Joiner.this.toString(obj));
                }
                return a;
            }

            @Override
            public Joiner useForNull(String string) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override
            public MapJoiner withKeyValueSeparator(String string) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    @CheckReturnValue
    public MapJoiner withKeyValueSeparator(String string) {
        return new MapJoiner(this, string);
    }

    CharSequence toString(Object object) {
        Preconditions.checkNotNull(object);
        return object instanceof CharSequence ? (CharSequence)object : object.toString();
    }

    private static Iterable<Object> iterable(final Object object, final Object object2, final Object[] objectArray) {
        Preconditions.checkNotNull(objectArray);
        return new AbstractList<Object>(){

            @Override
            public int size() {
                return objectArray.length + 2;
            }

            @Override
            public Object get(int n) {
                switch (n) {
                    case 0: {
                        return object;
                    }
                    case 1: {
                        return object2;
                    }
                }
                return objectArray[n - 2];
            }
        };
    }

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner, String string) {
            this.joiner = joiner;
            this.keyValueSeparator = Preconditions.checkNotNull(string);
        }

        public <A extends Appendable> A appendTo(A a, Map<?, ?> map) throws IOException {
            return this.appendTo(a, map.entrySet());
        }

        public StringBuilder appendTo(StringBuilder stringBuilder, Map<?, ?> map) {
            return this.appendTo(stringBuilder, (Iterable<? extends Map.Entry<?, ?>>)map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return this.join(map.entrySet());
        }

        @Beta
        public <A extends Appendable> A appendTo(A a, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return this.appendTo(a, iterable.iterator());
        }

        @Beta
        public <A extends Appendable> A appendTo(A a, Iterator<? extends Map.Entry<?, ?>> iterator2) throws IOException {
            Preconditions.checkNotNull(a);
            if (iterator2.hasNext()) {
                Map.Entry<?, ?> entry = iterator2.next();
                a.append(this.joiner.toString(entry.getKey()));
                a.append(this.keyValueSeparator);
                a.append(this.joiner.toString(entry.getValue()));
                while (iterator2.hasNext()) {
                    a.append(this.joiner.separator);
                    Map.Entry<?, ?> entry2 = iterator2.next();
                    a.append(this.joiner.toString(entry2.getKey()));
                    a.append(this.keyValueSeparator);
                    a.append(this.joiner.toString(entry2.getValue()));
                }
            }
            return a;
        }

        @Beta
        public StringBuilder appendTo(StringBuilder stringBuilder, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return this.appendTo(stringBuilder, iterable.iterator());
        }

        @Beta
        public StringBuilder appendTo(StringBuilder stringBuilder, Iterator<? extends Map.Entry<?, ?>> iterator2) {
            try {
                this.appendTo((Appendable)stringBuilder, iterator2);
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
            return stringBuilder;
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return this.join(iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> iterator2) {
            return this.appendTo(new StringBuilder(), iterator2).toString();
        }

        @CheckReturnValue
        public MapJoiner useForNull(String string) {
            return new MapJoiner(this.joiner.useForNull(string), this.keyValueSeparator);
        }
    }
}

