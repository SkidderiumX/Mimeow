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
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@JvmInline
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u00063"}, d2={"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", "get", "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
@ExperimentalUnsignedTypes
@SourceDebugExtension(value={"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
public class UShortArray
implements Collection<UShort>,
KMappedMarker {
    @NotNull
    private final short[] storage;

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    @NotNull
    public static short[] m015f96c810(int n) {
        return UShortArray.m58f7e26425(new short[n]);
    }

    public static final short me287ce0640(short[] sArray, int n) {
        return UShort.m96ff20ce19(sArray[n]);
    }

    public static final void m5084587a43(short[] sArray, int n, short s) {
        sArray[n] = s;
    }

    public static int m70c7c61d51(short[] sArray) {
        return sArray.length;
    }

    public int getSize() {
        return UShortArray.m70c7c61d51(this.storage);
    }

    @NotNull
    public static java.util.Iterator<UShort> m8a7235f2e3(short[] sArray) {
        return new Iterator(sArray);
    }

    @Override
    @NotNull
    public java.util.Iterator<UShort> iterator() {
        return UShortArray.m8a7235f2e3(this.storage);
    }

    public static boolean mc396c57d61(short[] sArray, short s) {
        return ArraysKt.contains(sArray, s);
    }

    public boolean mfb0576fa3c(short s) {
        return UShortArray.mc396c57d61(this.storage, s);
    }

    public static boolean m31f434a9bf(short[] sArray, @NotNull Collection<UShort> collection) {
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
                    if (t2 instanceof UShort && ArraysKt.contains(sArray, ((UShort)t2).m0dfe878ce1())) continue;
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
        return UShortArray.m31f434a9bf(this.storage, collection);
    }

    public static boolean m392535dd07(short[] sArray) {
        return sArray.length == 0;
    }

    @Override
    public boolean isEmpty() {
        return UShortArray.m392535dd07(this.storage);
    }

    public static String mfb1bf1a772(short[] sArray) {
        return "UShortArray(storage=" + Arrays.toString(sArray) + ')';
    }

    public String toString() {
        return UShortArray.mfb1bf1a772(this.storage);
    }

    public static int mb56b2611a1(short[] sArray) {
        return Arrays.hashCode(sArray);
    }

    @Override
    public int hashCode() {
        return UShortArray.mb56b2611a1(this.storage);
    }

    public static boolean mcb4f5704f7(short[] sArray, Object object) {
        if (!(object instanceof UShortArray)) {
            return false;
        }
        return Intrinsics.areEqual(sArray, ((UShortArray)object).m768f72efb9());
    }

    @Override
    public boolean equals(Object object) {
        return UShortArray.mcb4f5704f7(this.storage, object);
    }

    public boolean m260136beaa(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends UShort> collection) {
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
    private /* synthetic */ UShortArray(short[] sArray) {
        this.storage = sArray;
    }

    @PublishedApi
    @NotNull
    public static short[] m58f7e26425(@NotNull short[] sArray) {
        Intrinsics.checkNotNullParameter(sArray, "storage");
        return sArray;
    }

    public static final /* synthetic */ UShortArray ma21c09b083(short[] sArray) {
        return new UShortArray(sArray);
    }

    public final /* synthetic */ short[] m768f72efb9() {
        return this.storage;
    }

    public static final boolean m7015477dc1(short[] sArray, short[] sArray2) {
        return Intrinsics.areEqual(sArray, sArray2);
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

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00f8\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\r"}, d2={"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "array", "", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "kotlin-stdlib"})
    private static final class Iterator
    implements java.util.Iterator<UShort>,
    KMappedMarker {
        @NotNull
        private final short[] array;
        private int index;

        public Iterator(@NotNull short[] sArray) {
            Intrinsics.checkNotNullParameter(sArray, "array");
            this.array = sArray;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        public short m3813cce82b() {
            if (this.index >= this.array.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            int n = this.index;
            this.index = n + 1;
            return UShort.m96ff20ce19(this.array[n]);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}

