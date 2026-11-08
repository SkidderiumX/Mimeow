package okio.internal;

import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import kotlin.*;
import kotlin.collections.*;
import okio.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\b\u00f8\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006(" }, d2 = { "binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio" })
@JvmName(name = "DSegmentedByteString")
@SourceDebugExtension({ "SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/DSegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n63#1,12:252\n85#1,14:264\n85#1,14:278\n85#1,14:292\n85#1,14:306\n63#1,12:320\n1#2:251\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/DSegmentedByteString\n*L\n147#1:252,12\n160#1:264,14\n182#1:278,14\n202#1:292,14\n219#1:306,14\n239#1:320,12\n*E\n" })
public class DSegmentedByteString
{
    public static final int binarySearch(@NotNull final int[] array, final int n, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        int i = n2;
        int n4 = n3 - 1;
        while (i <= n4) {
            final int n5 = i + n4 >>> 1;
            final int n6 = array[n5];
            if (n6 < n) {
                i = n5 + 1;
            }
            else {
                if (n6 <= n) {
                    return n5;
                }
                n4 = n5 - 1;
            }
        }
        return -i - 1;
    }
    
    public static final int segment(@NotNull final SegmentedByteString segmentedByteString, final int n) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        final int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), n + 1, 0, segmentedByteString.getSegments$okio().length);
        return (binarySearch >= 0) ? binarySearch : (~binarySearch);
    }
    
    public static final void forEachSegment(@NotNull final SegmentedByteString segmentedByteString, @NotNull final Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(function3, "action");
        final int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int j = segmentedByteString.getDirectory$okio()[length + i];
            final int n2 = segmentedByteString.getDirectory$okio()[i];
            function3.invoke(segmentedByteString.getSegments$okio()[i], j, n2 - n);
            n = n2;
            ++i;
        }
    }
    
    private static final void forEachSegment(final SegmentedByteString segmentedByteString, final int n, final int a, final Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int j;
        for (int segment = segment(segmentedByteString, n), i = n; i < a; i += j, ++segment) {
            final int n2 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            final int n3 = segmentedByteString.getDirectory$okio()[segment] - n2;
            final int n4 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            j = Math.min(a, n2 + n3) - i;
            function3.invoke(segmentedByteString.getSegments$okio()[segment], n4 + (i - n2), j);
        }
    }
    
    @NotNull
    public static final ByteString commonSubstring(@NotNull final SegmentedByteString segmentedByteString, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        final int resolveDefaultParameter = okio.DSegmentedByteString.resolveDefaultParameter(segmentedByteString, n2);
        if (n < 0) {
            throw new IllegalArgumentException(("beginIndex=" + n + " < 0").toString());
        }
        if (resolveDefaultParameter > segmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
        }
        final int b = resolveDefaultParameter - n;
        if (b < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + n).toString());
        }
        if (n == 0 && resolveDefaultParameter == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (n == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        final int segment = segment(segmentedByteString, n);
        final int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
        final byte[][] array = ArraysKt___ArraysJvmKt.copyOfRange(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
        final int[] array2 = new int[array.length * 2];
        int n3 = 0;
        int n4 = segment;
        if (n4 <= segment2) {
            while (true) {
                array2[n3] = Math.min(segmentedByteString.getDirectory$okio()[n4] - n, b);
                array2[n3++ + ((Object[])array).length] = segmentedByteString.getDirectory$okio()[n4 + segmentedByteString.getSegments$okio().length];
                if (n4 == segment2) {
                    break;
                }
                ++n4;
            }
        }
        final int n5 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
        final int length = array.length;
        array2[length] += n - n5;
        return new SegmentedByteString(array, array2);
    }
    
    public static final byte commonInternalGet(@NotNull final SegmentedByteString segmentedByteString, final int n) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        okio.DSegmentedByteString.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], n, 1L);
        final int segment = segment(segmentedByteString, n);
        return segmentedByteString.getSegments$okio()[segment][n - ((segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1]) + segmentedByteString.getDirectory$okio()[segment + segmentedByteString.getSegments$okio().length]];
    }
    
    public static final int commonGetSize(@NotNull final SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }
    
    @NotNull
    public static final byte[] commonToByteArray(@NotNull final SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        final byte[] array = new byte[segmentedByteString.size()];
        int n = 0;
        final int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int n2 = 0;
        while (i < length) {
            final int n3 = segmentedByteString.getDirectory$okio()[length + i];
            final int n4 = segmentedByteString.getDirectory$okio()[i];
            final byte[] array2 = segmentedByteString.getSegments$okio()[i];
            final int n5 = n3;
            final int n6 = n4 - n2;
            final int n7 = n5;
            ArraysKt___ArraysJvmKt.copyInto(array2, array, n, n7, n7 + n6);
            n += n6;
            n2 = n4;
            ++i;
        }
        return array;
    }
    
    public static final void commonWrite(@NotNull final SegmentedByteString segmentedByteString, @NotNull final Buffer buffer, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int n6;
        for (int a = n + n2, segment = segment(segmentedByteString, n), i = n; i < a; i += n6, ++segment) {
            final int n3 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            final int n4 = segmentedByteString.getDirectory$okio()[segment] - n3;
            final int n5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            n6 = Math.min(a, n3 + n4) - i;
            final int n7 = n5 + (i - n3);
            final byte[] array = segmentedByteString.getSegments$okio()[segment];
            final int n8 = n7;
            final int n9 = n6;
            final int n10 = n8;
            final Segment prev = new Segment(array, n10, n10 + n9, true, false);
            if (buffer.head == null) {
                prev.prev = prev;
                prev.next = prev.prev;
                buffer.head = prev.next;
            }
            else {
                final Segment head = buffer.head;
                Intrinsics.checkNotNull(head);
                final Segment prev2 = head.prev;
                Intrinsics.checkNotNull(prev2);
                prev2.push(prev);
            }
        }
        buffer.setSize$okio(buffer.size() + n2);
    }
    
    public static final boolean commonRangeEquals(@NotNull final SegmentedByteString segmentedByteString, final int n, @NotNull final ByteString byteString, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (n < 0 || n > segmentedByteString.size() - n3) {
            return false;
        }
        int n4 = n2;
        int n8;
        for (int a = n + n3, segment = segment(segmentedByteString, n), i = n; i < a; i += n8, ++segment) {
            final int n5 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            final int n6 = segmentedByteString.getDirectory$okio()[segment] - n5;
            final int n7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            n8 = Math.min(a, n5 + n6) - i;
            final int n9 = n7 + (i - n5);
            final byte[] array = segmentedByteString.getSegments$okio()[segment];
            final int n10 = n9;
            final int n11 = n8;
            if (!byteString.rangeEquals(n4, array, n10, n11)) {
                return false;
            }
            n4 += n11;
        }
        return true;
    }
    
    public static final boolean commonRangeEquals(@NotNull final SegmentedByteString segmentedByteString, final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "other");
        if (n < 0 || n > segmentedByteString.size() - n3 || n2 < 0 || n2 > array.length - n3) {
            return false;
        }
        int n4 = n2;
        int n8;
        for (int a = n + n3, segment = segment(segmentedByteString, n), i = n; i < a; i += n8, ++segment) {
            final int n5 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            final int n6 = segmentedByteString.getDirectory$okio()[segment] - n5;
            final int n7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            n8 = Math.min(a, n5 + n6) - i;
            final int n9 = n7 + (i - n5);
            final byte[] array2 = segmentedByteString.getSegments$okio()[segment];
            final int n10 = n9;
            final int n11 = n8;
            if (!okio.DSegmentedByteString.arrayRangeEquals(array2, n10, array, n4, n11)) {
                return false;
            }
            n4 += n11;
        }
        return true;
    }
    
    public static final void commonCopyInto(@NotNull final SegmentedByteString segmentedByteString, final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "target");
        okio.DSegmentedByteString.checkOffsetAndCount(segmentedByteString.size(), n, n3);
        okio.DSegmentedByteString.checkOffsetAndCount(array.length, n2, n3);
        int n4 = n2;
        int n8;
        for (int a = n + n3, segment = segment(segmentedByteString, n), i = n; i < a; i += n8, ++segment) {
            final int n5 = (segment == 0) ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            final int n6 = segmentedByteString.getDirectory$okio()[segment] - n5;
            final int n7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            n8 = Math.min(a, n5 + n6) - i;
            final int n9 = n7 + (i - n5);
            final byte[] array2 = segmentedByteString.getSegments$okio()[segment];
            final int n10 = n9;
            final int n11 = n8;
            final int n12 = n10;
            ArraysKt___ArraysJvmKt.copyInto(array2, array, n4, n12, n12 + n11);
            n4 += n11;
        }
    }
    
    public static final boolean commonEquals(@NotNull final SegmentedByteString segmentedByteString, @Nullable final Object o) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        return o == segmentedByteString || (o instanceof ByteString && (((ByteString)o).size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, (ByteString)o, 0, segmentedByteString.size())));
    }
    
    public static final int commonHashCode(@NotNull final SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        final int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode$okio2 = 1;
        final int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int n2 = segmentedByteString.getDirectory$okio()[length + i];
            final int n3 = segmentedByteString.getDirectory$okio()[i];
            final byte[] array = segmentedByteString.getSegments$okio()[i];
            final int n4 = n2;
            final int n5 = n3 - n;
            final int n6 = n4;
            final byte[] array2 = array;
            for (int j = n6; j < n6 + n5; ++j) {
                hashCode$okio2 = 31 * hashCode$okio2 + array2[j];
            }
            n = n3;
            ++i;
        }
        segmentedByteString.setHashCode$okio(hashCode$okio2);
        return hashCode$okio2;
    }
}
