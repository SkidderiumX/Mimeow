/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
@ExperimentalUnsignedTypes
@SourceDebugExtension(value={"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n62#1:87,3\n*E\n"})
public class ULongArray
implements Collection<ULong>,
KMappedMarker {
    @NotNull
    private final long[] storage;

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    @NotNull
    public static long[] m4c78decc63(int n) {
        return ULongArray.m8ed91122b9(new long[n]);
    }

    public static final long mc20eb45c93(long[] lArray, int n) {
        return ULong.mc76128828a(lArray[n]);
    }

    public static final void m5926563316(long[] lArray, int n, long l) {
        lArray[n] = l;
    }

    public static int m23e36e6a11(long[] lArray) {
        return lArray.length;
    }

    public int getSize() {
        return ULongArray.m23e36e6a11(this.storage);
    }

    @NotNull
    public static java.util.Iterator<ULong> m1ee26a5e06(long[] lArray) {
        return new Iterator(lArray);
    }

    @Override
    @NotNull
    public java.util.Iterator<ULong> iterator() {
        return ULongArray.m1ee26a5e06(this.storage);
    }

    public static boolean m3c991ae9c3(long[] lArray, long l) {
        return ArraysKt.contains(lArray, l);
    }

    public boolean m0d91319237(long l) {
        return ULongArray.m3c991ae9c3(this.storage, l);
    }

    public static boolean m3b54090318(long[] lArray, @NotNull Collection<ULong> collection) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter(collection, "elements");
            Iterable iterable = collection;
            boolean bl2 = false;
            if (((Collection)iterable).isEmpty()) {
                bl = true;
            } else {
                java.util.Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object t;
                    Object t2 = t = iterator2.next();
                    boolean bl3 = false;
                    if (t2 instanceof ULong && ArraysKt.contains(lArray, ((ULong)t2).m8c33c6a73b())) continue;
                    bl = false;
                    break block3;
                }
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return ULongArray.m3b54090318(this.storage, collection);
    }

    public static boolean m49d61fce71(long[] lArray) {
        return lArray.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return ULongArray.m49d61fce71(this.storage);
    }

    public static String mb6e80dc0dd(long[] lArray) {
        return "ULongArray(storage=" + Arrays.toString(lArray) + ')';
    }

    public String toString() {
        return ULongArray.mb6e80dc0dd(this.storage);
    }

    public static int m1def287383(long[] lArray) {
        return Arrays.hashCode(lArray);
    }

    @Override
    public int hashCode() {
        return ULongArray.m1def287383(this.storage);
    }

    public static boolean m76c6e3f726(long[] lArray, Object object) {
        if (!(object instanceof ULongArray)) {
            return false;
        }
        return Intrinsics.areEqual(lArray, ((ULongArray)object).mdcf8310d10());
    }

    @Override
    public boolean equals(Object object) {
        return ULongArray.m76c6e3f726(this.storage, object);
    }

    public boolean mb5e7e7478a(long l) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] lArray) {
        this.storage = lArray;
    }

    @PublishedApi
    @NotNull
    public static long[] m8ed91122b9(@NotNull long[] lArray) {
        Intrinsics.checkNotNullParameter(lArray, "storage");
        return lArray;
    }

    public static final /* synthetic */ ULongArray m5f4130000c(long[] lArray) {
        return new ULongArray(lArray);
    }

    public final /* synthetic */ long[] mdcf8310d10() {
        return this.storage;
    }

    public static final boolean m1ff40a96ab(long[] lArray, long[] lArray2) {
        return Intrinsics.areEqual(lArray, lArray2);
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, "array");
        return CollectionToArray.toArray(this, TArray);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00f8\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\r"}, d2={"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"})
    private static final class Iterator
    implements java.util.Iterator<ULong>,
    KMappedMarker {
        @NotNull
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] lArray) {
            Intrinsics.checkNotNullParameter(lArray, "array");
            this.array = lArray;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public long m83d483f098() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            int n = this.index;
            this.index = n + 1;
            return ULong.mc76128828a(this.array[n]);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}

