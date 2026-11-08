/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2={"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"})
public class Options
extends AbstractList<ByteString>
implements RandomAccess {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteString[] byteStrings;
    @NotNull
    private final int[] trie;

    private Options(ByteString[] byteStringArray, int[] nArray) {
        this.byteStrings = byteStringArray;
        this.trie = nArray;
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override
    @NotNull
    public ByteString get(int n) {
        return this.byteStrings[n];
    }

    @JvmStatic
    @NotNull
    public static final Options of(ByteString ... byteStringArray) {
        return Companion.of(byteStringArray);
    }

    public /* synthetic */ Options(ByteString[] byteStringArray, int[] nArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArray, nArray);
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2={"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"})
    @SourceDebugExtension(value={"SMAP\nOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Options.kt\nokio/Options$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,236:1\n11065#2:237\n11400#2,3:238\n13374#2,3:243\n37#3,2:241\n1#4:246\n74#5:247\n74#5:248\n*S KotlinDebug\n*F\n+ 1 Options.kt\nokio/Options$Companion\n*L\n43#1:237\n43#1:238,3\n44#1:243,3\n43#1:241,2\n151#1:247\n208#1:248\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Options of(ByteString ... byteStringArray) {
            Intrinsics.checkNotNullParameter(byteStringArray, "byteStrings");
            if (byteStringArray.length == 0) {
                int[] nArray = new int[]{0, -1};
                return new Options(new ByteString[0], nArray, null);
            }
            List<ByteString> list = ArraysKt.toMutableList(byteStringArray);
            CollectionsKt.sort(list);
            Object object = byteStringArray;
            int n = 0;
            ByteString[] byteStringArray2 = object;
            Collection collection = new ArrayList(((ByteString[])object).length);
            boolean bl = false;
            int n2 = byteStringArray2.length;
            for (int i = 0; i < n2; ++i) {
                ByteString byteString;
                ByteString byteString2 = byteString = byteStringArray2[i];
                Collection collection2 = collection;
                boolean bl2 = false;
                collection2.add(-1);
            }
            object = (List)collection;
            n = 0;
            byteStringArray2 = object;
            Comparable<Integer>[] comparableArray = byteStringArray2.toArray(new Integer[0]);
            List<Integer> list2 = CollectionsKt.mutableListOf(Arrays.copyOf(comparableArray, comparableArray.length));
            comparableArray = byteStringArray;
            boolean bl3 = false;
            n = 0;
            for (Comparable<Integer> comparable : comparableArray) {
                int n3 = n++;
                Comparable<Integer> comparable2 = comparable;
                n2 = n3;
                boolean bl4 = false;
                int n4 = CollectionsKt.binarySearch$default(list, comparable2, 0, 0, 6, null);
                list2.set(n4, n2);
            }
            if (!(list.get(0).size() > 0)) {
                bl3 = false;
                String string = "the empty byte string is not a supported option";
                throw new IllegalArgumentException(string.toString());
            }
            for (int i = 0; i < list.size(); ++i) {
                ByteString byteString;
                ByteString byteString3 = list.get(i);
                n = i + 1;
                while (n < list.size() && (byteString = list.get(n)).startsWith(byteString3)) {
                    if (!(byteString.size() != byteString3.size())) {
                        bl = false;
                        String string = "duplicate option: " + byteString;
                        throw new IllegalArgumentException(string.toString());
                    }
                    if (((Number)list2.get(n)).intValue() > ((Number)list2.get(i)).intValue()) {
                        list.remove(n);
                        list2.remove(n);
                        continue;
                    }
                    ++n;
                }
            }
            Buffer buffer = new Buffer();
            okio.Options$Companion.buildTrieRecursive$default(this, 0L, buffer, 0, list, 0, 0, list2, 53, null);
            int[] nArray = new int[(int)this.getIntCount(buffer)];
            int n5 = 0;
            while (!buffer.exhausted()) {
                nArray[n5++] = buffer.readInt();
            }
            ByteString[] byteStringArray3 = Arrays.copyOf(byteStringArray, byteStringArray.length);
            Intrinsics.checkNotNullExpressionValue(byteStringArray3, "copyOf(this, size)");
            return new Options(byteStringArray3, nArray, null);
        }

        private final void buildTrieRecursive(long l, Buffer buffer, int n, List<? extends ByteString> list, int n2, int n3, List<Integer> list2) {
            int n4;
            if (!(n2 < n3)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            for (n4 = n2; n4 < n3; ++n4) {
                if (list.get(n4).size() >= n) continue;
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            n4 = n2;
            ByteString byteString = list.get(n4);
            ByteString byteString2 = list.get(n3 - 1);
            int n5 = -1;
            if (n == byteString.size()) {
                n5 = ((Number)list2.get(n4)).intValue();
                byteString = list.get(++n4);
            }
            if (byteString.getByte(n) != byteString2.getByte(n)) {
                int n6;
                int n7;
                int n8;
                int n9;
                int n10 = 1;
                for (int i = n4 + 1; i < n3; ++i) {
                    if (list.get(i - 1).getByte(n) == list.get(i).getByte(n)) continue;
                    ++n10;
                }
                long l2 = l + this.getIntCount(buffer) + (long)2 + (long)(n10 * 2);
                buffer.writeInt(n10);
                buffer.writeInt(n5);
                for (int i = n4; i < n3; ++i) {
                    n9 = list.get(i).getByte(n);
                    if (i != n4 && n9 == list.get(i - 1).getByte(n)) continue;
                    n8 = n9;
                    n7 = 255;
                    n6 = 0;
                    buffer.writeInt(n8 & n7);
                }
                Buffer buffer2 = new Buffer();
                n9 = n4;
                while (n9 < n3) {
                    n8 = list.get(n9).getByte(n);
                    n7 = n3;
                    for (n6 = n9 + 1; n6 < n3; ++n6) {
                        if (n8 == list.get(n6).getByte(n)) continue;
                        n7 = n6;
                        break;
                    }
                    if (n9 + 1 == n7 && n + 1 == list.get(n9).size()) {
                        buffer.writeInt(((Number)list2.get(n9)).intValue());
                    } else {
                        buffer.writeInt(-1 * (int)(l2 + this.getIntCount(buffer2)));
                        this.buildTrieRecursive(l2, buffer2, n + 1, list, n9, n7, list2);
                    }
                    n9 = n7;
                }
                buffer.writeAll(buffer2);
            } else {
                int n11 = 0;
                int n12 = Math.min(byteString.size(), byteString2.size());
                for (int i = n; i < n12 && byteString.getByte(i) == byteString2.getByte(i); ++i) {
                    ++n11;
                }
                long l3 = l + this.getIntCount(buffer) + (long)2 + (long)n11 + 1L;
                buffer.writeInt(-n11);
                buffer.writeInt(n5);
                int n13 = n + n11;
                for (int i = n; i < n13; ++i) {
                    byte by = byteString.getByte(i);
                    int n14 = 255;
                    boolean bl = false;
                    buffer.writeInt(by & n14);
                }
                if (n4 + 1 == n3) {
                    if (!(n + n11 == list.get(n4).size())) {
                        String string = "Check failed.";
                        throw new IllegalStateException(string.toString());
                    }
                    buffer.writeInt(((Number)list2.get(n4)).intValue());
                } else {
                    Buffer buffer3 = new Buffer();
                    buffer.writeInt(-1 * (int)(l3 + this.getIntCount(buffer3)));
                    this.buildTrieRecursive(l3, buffer3, n + n11, list, n4, n3, list2);
                    buffer.writeAll(buffer3);
                }
            }
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long l, Buffer buffer, int n, List list, int n2, int n3, List list2, int n4, Object object) {
            if ((n4 & 1) != 0) {
                l = 0L;
            }
            if ((n4 & 4) != 0) {
                n = 0;
            }
            if ((n4 & 0x10) != 0) {
                n2 = 0;
            }
            if ((n4 & 0x20) != 0) {
                n3 = list.size();
            }
            companion.buildTrieRecursive(l, buffer, n, list, n2, n3, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / (long)4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

