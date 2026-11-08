package kotlin.coroutines;

import java.io.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"" }, d2 = { "Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@SourceDebugExtension({ "SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n" })
public class CombinedContext implements CoroutineContext, Serializable
{
    @NotNull
    private final CoroutineContext left;
    @NotNull
    private final Element element;
    
    public CombinedContext(@NotNull final CoroutineContext left, @NotNull final Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }
    
    @Nullable
    @Override
    public <E extends Element> E get(@NotNull final Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            final Element value = combinedContext.element.get(key);
            if (value != null) {
                return (E)value;
            }
            final CoroutineContext left = combinedContext.left;
            if (!(left instanceof CombinedContext)) {
                return left.get(key);
            }
            combinedContext = (CombinedContext)left;
        }
    }
    
    @Override
    public <R> R fold(final R r, @NotNull final Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R)function2.invoke(this.left.fold(r, function2), this.element);
    }
    
    @NotNull
    @Override
    public CoroutineContext minusKey(@NotNull final Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        final CoroutineContext minusKey = this.left.minusKey(key);
        return (minusKey == this.left) ? this : ((minusKey == EmptyCoroutineContext.INSTANCE) ? this.element : ((CoroutineContext)new CombinedContext(minusKey, this.element)));
    }
    
    private final int size() {
        CombinedContext combinedContext = this;
        int n = 2;
        while (true) {
            final CoroutineContext left = combinedContext.left;
            final CombinedContext combinedContext2 = (left instanceof CombinedContext) ? ((CombinedContext)left) : null;
            if (combinedContext2 == null) {
                break;
            }
            combinedContext = combinedContext2;
            ++n;
        }
        return n;
    }
    
    private final boolean contains(final Element element) {
        return Intrinsics.areEqual(this.get(element.getKey()), element);
    }
    
    private final boolean containsAll(final CombinedContext combinedContext) {
        CoroutineContext left;
        for (CombinedContext combinedContext2 = combinedContext; this.contains(combinedContext2.element); combinedContext2 = (CombinedContext)left) {
            left = combinedContext2.left;
            if (!(left instanceof CombinedContext)) {
                Intrinsics.checkNotNull(left, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return this.contains((Element)left);
            }
        }
        return false;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return this == o || (o instanceof CombinedContext && ((CombinedContext)o).size() == this.size() && ((CombinedContext)o).containsAll(this));
    }
    
    @Override
    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return '[' + this.fold("", (Function2<? super String, ? super Element, ? extends String>)CombinedContext$toString.CombinedContext$toString$1.INSTANCE) + ']';
    }
    
    private final Object writeReplace() {
        final int size = this.size();
        final CoroutineContext[] array = new CoroutineContext[size];
        final Ref.IntRef intRef = new Ref.IntRef();
        this.fold(Unit.INSTANCE, (Function2<? super Unit, ? super Element, ? extends Unit>)new CombinedContext$writeReplace.CombinedContext$writeReplace$1(array, intRef));
        if (intRef.element != size) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return new Serialized(array);
    }
    
    @NotNull
    @Override
    public CoroutineContext plus(@NotNull final CoroutineContext coroutineContext) {
        return DefaultImpls.plus(this, coroutineContext);
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r" }, d2 = { "Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib" })
    @SourceDebugExtension({ "SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n" })
    private static final class Serialized implements Serializable
    {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final CoroutineContext[] elements;
        private static final long serialVersionUID = 0L;
        
        public Serialized(@NotNull final CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }
        
        @NotNull
        public final CoroutineContext[] getElements() {
            return this.elements;
        }
        
        private final Object readResolve() {
            final CoroutineContext[] elements = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (int i = 0; i < elements.length; ++i) {
                coroutineContext = coroutineContext.plus(elements[i]);
            }
            return coroutineContext;
        }
        
        static {
            Companion = new Companion(null);
        }
        
        @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib" })
        public static final class Companion
        {
            private Companion() {
            }
        }
    }
}
