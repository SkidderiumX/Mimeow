package okio.internal;

import kotlin.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import java.io.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;
import okio.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\u0080\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0080\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\u0080\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\u0080\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\u0080\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\u0080\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\u0080\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\u0080\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\u0080\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\u0080\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\u0080\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\u0080\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\u0080\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\u0080\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\u0080\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0080\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\u0080\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\u0080\b\u00f8\u0001\u0000¢\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006n" }, d2 = { "HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio" })
@JvmName(name = "DBuffer")
@SourceDebugExtension({ "SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/internal/DBuffer\n+ 2 Util.kt\nokio/DSegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1730:1\n112#1,20:1753\n112#1,20:1786\n112#1:1806\n114#1,18:1808\n112#1,20:1826\n74#2:1731\n74#2:1732\n74#2:1733\n74#2:1734\n74#2:1735\n74#2:1736\n74#2:1737\n74#2:1738\n74#2:1739\n74#2:1740\n74#2:1741\n74#2:1742\n83#2:1743\n83#2:1744\n77#2:1745\n77#2:1746\n77#2:1747\n77#2:1748\n77#2:1749\n77#2:1750\n77#2:1751\n77#2:1752\n86#2:1773\n89#2:1775\n74#2:1776\n74#2:1777\n74#2:1778\n74#2:1779\n74#2:1780\n74#2:1781\n74#2:1782\n74#2:1783\n74#2:1784\n74#2:1785\n89#2:1807\n86#2:1846\n1#3:1774\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/internal/DBuffer\n*L\n415#1:1753,20\n1292#1:1786,20\n1323#1:1806\n1323#1:1808,18\n1357#1:1826,20\n178#1:1731\n202#1:1732\n321#1:1733\n326#1:1734\n349#1:1735\n350#1:1736\n351#1:1737\n352#1:1738\n358#1:1739\n359#1:1740\n360#1:1741\n361#1:1742\n385#1:1743\n386#1:1744\n392#1:1745\n393#1:1746\n394#1:1747\n395#1:1748\n396#1:1749\n397#1:1750\n398#1:1751\n399#1:1752\n427#1:1773\n888#1:1775\n906#1:1776\n908#1:1777\n912#1:1778\n914#1:1779\n918#1:1780\n920#1:1781\n924#1:1782\n926#1:1783\n946#1:1784\n949#1:1785\n1336#1:1807\n1676#1:1846\n*E\n" })
public class DBuffer
{
    @NotNull
    private static final byte[] HEX_DIGIT_BYTES;
    public static final int SEGMENTING_THRESHOLD = 4096;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final long OVERFLOW_DIGIT_START = -7L;
    
    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return DBuffer.HEX_DIGIT_BYTES;
    }
    
    public static final boolean rangeEquals(@NotNull final Segment segment, final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(array, "bytes");
        Segment segment2 = segment;
        int pos = n;
        int n4 = segment2.limit;
        byte[] array2 = segment2.data;
        for (int i = n2; i < n3; ++i) {
            if (pos == n4) {
                final Segment next = segment2.next;
                Intrinsics.checkNotNull(next);
                segment2 = next;
                array2 = segment2.data;
                pos = segment2.pos;
                n4 = segment2.limit;
            }
            if (array2[pos] != array[i]) {
                return false;
            }
            ++pos;
        }
        return true;
    }
    
    @NotNull
    public static final String readUtf8Line(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        String s;
        if (n > 0L && buffer.getByte(n - 1L) == 13) {
            final String utf8 = buffer.readUtf8(n - 1L);
            buffer.skip(2L);
            s = utf8;
        }
        else {
            final String utf9 = buffer.readUtf8(n);
            buffer.skip(1L);
            s = utf9;
        }
        return s;
    }
    
    public static final <T> T seek(@NotNull final Buffer buffer, final long n, @NotNull final Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        final Segment head = buffer.head;
        if (head == null) {
            return (T)function2.invoke(null, -1L);
        }
        Segment segment = head;
        if (buffer.size() - n < n) {
            long size;
            for (size = buffer.size(); size > n; size -= segment.limit - segment.pos) {
                final Segment prev = segment.prev;
                Intrinsics.checkNotNull(prev);
                segment = prev;
            }
            return (T)function2.invoke(segment, size);
        }
        long l = 0L;
        while (true) {
            final long n2 = l + (segment.limit - segment.pos);
            if (n2 > n) {
                break;
            }
            final Segment next = segment.next;
            Intrinsics.checkNotNull(next);
            segment = next;
            l = n2;
        }
        return (T)function2.invoke(segment, l);
    }
    
    public static final int selectPrefix(@NotNull final Buffer buffer, @NotNull final Options options, final boolean b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final Segment head = buffer.head;
        if (head == null) {
            return b ? -2 : -1;
        }
        Segment segment2;
        final Segment segment = segment2 = head;
        byte[] array = segment.data;
        int n = segment.pos;
        int n2 = segment.limit;
        final int[] trie$okio = options.getTrie$okio();
        int i = 0;
        int n3 = -1;
    Label_0394:
        while (true) {
            final int n4 = trie$okio[i++];
            final int n5 = trie$okio[i++];
            if (n5 != -1) {
                n3 = n5;
            }
            if (segment2 == null) {
                break;
            }
            int n7 = 0;
            Label_0378: {
                if (n4 < 0) {
                    final int n6 = i + -1 * n4;
                    while ((array[n++] & 0xFF) == trie$okio[i++]) {
                        final boolean b2 = i == n6;
                        if (n == n2) {
                            final Segment segment3 = segment2;
                            Intrinsics.checkNotNull(segment3);
                            final Segment next = segment3.next;
                            Intrinsics.checkNotNull(next);
                            segment2 = next;
                            n = segment2.pos;
                            array = segment2.data;
                            n2 = segment2.limit;
                            if (segment2 == segment) {
                                if (!b2) {
                                    break Label_0394;
                                }
                                segment2 = null;
                            }
                        }
                        if (b2) {
                            n7 = trie$okio[i];
                            break Label_0378;
                        }
                    }
                    return n3;
                }
                final int n8 = n4;
                final int n9 = array[n++] & 0xFF;
                while (i != i + n8) {
                    if (n9 == trie$okio[i]) {
                        n7 = trie$okio[i + n8];
                        if (n != n2) {
                            break Label_0378;
                        }
                        final Segment next2 = segment2.next;
                        Intrinsics.checkNotNull(next2);
                        segment2 = next2;
                        n = segment2.pos;
                        array = segment2.data;
                        n2 = segment2.limit;
                        if (segment2 == segment) {
                            segment2 = null;
                        }
                        break Label_0378;
                    }
                    else {
                        ++i;
                    }
                }
                return n3;
            }
            if (n7 >= 0) {
                return n7;
            }
            i = -n7;
        }
        if (b) {
            return -2;
        }
        return n3;
    }
    
    public static /* synthetic */ int selectPrefix$default(final Buffer buffer, final Options options, boolean b, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            b = false;
        }
        return selectPrefix(buffer, options, b);
    }
    
    @NotNull
    public static final Buffer commonCopyTo(@NotNull final Buffer buffer, @NotNull final Buffer buffer2, final long n, final long n2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "out");
        long n3 = n;
        long n4 = n2;
        DSegmentedByteString.checkOffsetAndCount(buffer.size(), n3, n4);
        if (n4 == 0L) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + n4);
        Segment segment = buffer.head;
        while (true) {
            final long n5 = n3;
            final Segment segment2 = segment;
            Intrinsics.checkNotNull(segment2);
            if (n5 < segment2.limit - segment.pos) {
                break;
            }
            n3 -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (n4 > 0L) {
            final Segment segment3 = segment;
            Intrinsics.checkNotNull(segment3);
            final Segment sharedCopy = segment3.sharedCopy();
            sharedCopy.pos += (int)n3;
            sharedCopy.limit = Math.min(sharedCopy.pos + (int)n4, sharedCopy.limit);
            if (buffer2.head == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                buffer2.head = sharedCopy.next;
            }
            else {
                final Segment head = buffer2.head;
                Intrinsics.checkNotNull(head);
                final Segment prev = head.prev;
                Intrinsics.checkNotNull(prev);
                prev.push(sharedCopy);
            }
            n4 -= sharedCopy.limit - sharedCopy.pos;
            n3 = 0L;
            segment = segment.next;
        }
        return buffer;
    }
    
    public static final long commonCompleteSegmentByteCount(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long size = buffer.size();
        if (size == 0L) {
            return 0L;
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment prev = head.prev;
        Intrinsics.checkNotNull(prev);
        final Segment segment = prev;
        if (segment.limit < 8192 && segment.owner) {
            size -= segment.limit - segment.pos;
        }
        return size;
    }
    
    public static final byte commonReadByte(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0L) {
            throw new EOFException();
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        final byte b = segment.data[pos++];
        buffer.setSize$okio(buffer.size() - 1L);
        if (pos == limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        else {
            segment.pos = pos;
        }
        return b;
    }
    
    public static final short commonReadShort(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 2L) {
            throw new EOFException();
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        if (limit - pos < 2) {
            return (short)((buffer.readByte() & 0xFF) << 8 | (buffer.readByte() & 0xFF));
        }
        final byte[] data = segment.data;
        final int n = (data[pos++] & 0xFF) << 8 | (data[pos++] & 0xFF);
        buffer.setSize$okio(buffer.size() - 2L);
        if (pos == limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        else {
            segment.pos = pos;
        }
        return (short)n;
    }
    
    public static final int commonReadInt(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 4L) {
            throw new EOFException();
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        if (limit - pos < 4L) {
            return (buffer.readByte() & 0xFF) << 24 | (buffer.readByte() & 0xFF) << 16 | (buffer.readByte() & 0xFF) << 8 | (buffer.readByte() & 0xFF);
        }
        final byte[] data = segment.data;
        final int n = (data[pos++] & 0xFF) << 24 | (data[pos++] & 0xFF) << 16 | (data[pos++] & 0xFF) << 8 | (data[pos++] & 0xFF);
        buffer.setSize$okio(buffer.size() - 4L);
        if (pos == limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        else {
            segment.pos = pos;
        }
        return n;
    }
    
    public static final long commonReadLong(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() < 8L) {
            throw new EOFException();
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        if (limit - pos < 8L) {
            return ((long)buffer.readInt() & 0xFFFFFFFFL) << 32 | ((long)buffer.readInt() & 0xFFFFFFFFL);
        }
        final byte[] data = segment.data;
        final long n = ((long)data[pos++] & 0xFFL) << 56 | ((long)data[pos++] & 0xFFL) << 48 | ((long)data[pos++] & 0xFFL) << 40 | ((long)data[pos++] & 0xFFL) << 32 | ((long)data[pos++] & 0xFFL) << 24 | ((long)data[pos++] & 0xFFL) << 16 | ((long)data[pos++] & 0xFFL) << 8 | ((long)data[pos++] & 0xFFL);
        buffer.setSize$okio(buffer.size() - 8L);
        if (pos == limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        else {
            segment.pos = pos;
        }
        return n;
    }
    
    public static final byte commonGet(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        DSegmentedByteString.checkOffsetAndCount(buffer.size(), n, 1L);
        final Segment head = buffer.head;
        if (head == null) {
            final Segment segment = null;
            final long n2 = -1L;
            final Segment segment3;
            final Segment segment2 = segment3 = segment;
            Intrinsics.checkNotNull(segment3);
            return segment3.data[(int)(segment2.pos + n - n2)];
        }
        Segment segment4 = head;
        if (buffer.size() - n < n) {
            long size;
            for (size = buffer.size(); size > n; size -= segment4.limit - segment4.pos) {
                final Segment prev = segment4.prev;
                Intrinsics.checkNotNull(prev);
                segment4 = prev;
            }
            final Segment segment5 = segment4;
            final long n3 = size;
            final Segment segment7;
            final Segment segment6 = segment7 = segment5;
            Intrinsics.checkNotNull(segment7);
            return segment7.data[(int)(segment6.pos + n - n3)];
        }
        long n4 = 0L;
        while (true) {
            final long n5 = n4 + (segment4.limit - segment4.pos);
            if (n5 > n) {
                break;
            }
            final Segment next = segment4.next;
            Intrinsics.checkNotNull(next);
            segment4 = next;
            n4 = n5;
        }
        final Segment segment8 = segment4;
        final long n6 = n4;
        final Segment segment10;
        final Segment segment9 = segment10 = segment8;
        Intrinsics.checkNotNull(segment10);
        return segment10.data[(int)(segment9.pos + n - n6)];
    }
    
    public static final void commonClear(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.skip(buffer.size());
    }
    
    public static final void commonSkip(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long a = n;
        while (a > 0L) {
            final Segment head = buffer.head;
            if (head == null) {
                throw new EOFException();
            }
            final Segment segment = head;
            final int n2 = (int)Math.min(a, segment.limit - segment.pos);
            buffer.setSize$okio(buffer.size() - n2);
            a -= n2;
            segment.pos += n2;
            if (segment.pos != segment.limit) {
                continue;
            }
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
    }
    
    @NotNull
    public static final Buffer commonWrite(@NotNull final Buffer buffer, @NotNull final ByteString byteString, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, n, n2);
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long n2 = n;
        if (n2 == 0L) {
            return buffer.writeByte(48);
        }
        boolean b = false;
        if (n2 < 0L) {
            n2 = -n2;
            if (n2 < 0L) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            b = true;
        }
        int n3 = (n2 < 100000000L) ? ((n2 < 10000L) ? ((n2 < 100L) ? ((n2 < 10L) ? 1 : 2) : ((n2 < 1000L) ? 3 : 4)) : ((n2 < 1000000L) ? ((n2 < 100000L) ? 5 : 6) : ((n2 < 10000000L) ? 7 : 8))) : ((n2 < 1000000000000L) ? ((n2 < 10000000000L) ? ((n2 < 1000000000L) ? 9 : 10) : ((n2 < 100000000000L) ? 11 : 12)) : ((n2 < 1000000000000000L) ? ((n2 < 10000000000000L) ? 13 : ((n2 < 100000000000000L) ? 14 : 15)) : ((n2 < 100000000000000000L) ? ((n2 < 10000000000000000L) ? 16 : 17) : ((n2 < 1000000000000000000L) ? 18 : 19))));
        if (b) {
            ++n3;
        }
        final Segment writableSegment$okio = buffer.writableSegment$okio(n3);
        final byte[] data = writableSegment$okio.data;
        int n4 = writableSegment$okio.limit + n3;
        while (n2 != 0L) {
            data[--n4] = getHEX_DIGIT_BYTES()[(int)(n2 % 10)];
            n2 /= 10;
        }
        if (b) {
            data[--n4] = 45;
        }
        writableSegment$okio.limit += n3;
        buffer.setSize$okio(buffer.size() + n3);
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long n2 = n;
        if (n2 == 0L) {
            return buffer.writeByte(48);
        }
        final long n3 = n2;
        final long n4 = n3 | n3 >>> 1;
        final long n5 = n4 | n4 >>> 2;
        final long n6 = n5 | n5 >>> 4;
        final long n7 = n6 | n6 >>> 8;
        final long n8 = n7 | n7 >>> 16;
        final long n9 = n8 | n8 >>> 32;
        final long n10 = n9 - (n9 >>> 1 & 0x5555555555555555L);
        final long n11 = (n10 >>> 2 & 0x3333333333333333L) + (n10 & 0x3333333333333333L);
        final long n12 = (n11 >>> 4) + n11 & 0xF0F0F0F0F0F0F0FL;
        final long n13 = n12 + (n12 >>> 8);
        final long n14 = n13 + (n13 >>> 16);
        final int n15 = (int)(((n14 & 0x3FL) + (n14 >>> 32 & 0x3FL) + 3) / 4);
        final Segment writableSegment$okio = buffer.writableSegment$okio(n15);
        final byte[] data = writableSegment$okio.data;
        for (int i = writableSegment$okio.limit + n15 - 1; i >= writableSegment$okio.limit; --i) {
            data[i] = getHEX_DIGIT_BYTES()[(int)(n2 & 0xFL)];
            n2 >>>= 4;
        }
        writableSegment$okio.limit += n15;
        buffer.setSize$okio(buffer.size() + n15);
        return buffer;
    }
    
    @NotNull
    public static final Segment commonWritableSegment(@NotNull final Buffer buffer, final int n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (n < 1 || n > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        if (buffer.head == null) {
            final Segment take = SegmentPool.take();
            buffer.head = take;
            take.prev = take;
            return take.next = take;
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment prev;
        Segment push = prev = head.prev;
        Intrinsics.checkNotNull(prev);
        if (prev.limit + n > 8192 || !push.owner) {
            push = push.push(SegmentPool.take());
        }
        return push;
    }
    
    @NotNull
    public static final Buffer commonWrite(@NotNull final Buffer buffer, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(array, "source");
        return buffer.write(array, 0, array.length);
    }
    
    @NotNull
    public static final Buffer commonWrite(@NotNull final Buffer buffer, @NotNull final byte[] array, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(array, "source");
        int i = n;
        DSegmentedByteString.checkOffsetAndCount(array.length, i, n2);
        Segment writableSegment$okio;
        int min;
        for (int n3 = i + n2; i < n3; i += min, writableSegment$okio.limit += min) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            min = Math.min(n3 - i, 8192 - writableSegment$okio.limit);
            ArraysKt___ArraysJvmKt.copyInto(array, writableSegment$okio.data, writableSegment$okio.limit, i, i + min);
        }
        buffer.setSize$okio(buffer.size() + n2);
        return buffer;
    }
    
    @NotNull
    public static final byte[] commonReadByteArray(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }
    
    @NotNull
    public static final byte[] commonReadByteArray(@NotNull final Buffer buffer, final long lng) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (buffer.size() < lng) {
            throw new EOFException();
        }
        final byte[] array = new byte[(int)lng];
        buffer.readFully(array);
        return array;
    }
    
    public static final int commonRead(@NotNull final Buffer buffer, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(array, "sink");
        return buffer.read(array, 0, array.length);
    }
    
    public static final void commonReadFully(@NotNull final Buffer buffer, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(array, "sink");
        int read;
        for (int i = 0; i < array.length; i += read) {
            read = buffer.read(array, i, array.length - i);
            if (read == -1) {
                throw new EOFException();
            }
        }
    }
    
    public static final int commonRead(@NotNull final Buffer buffer, @NotNull final byte[] array, final int n, final int a) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(array, "sink");
        DSegmentedByteString.checkOffsetAndCount(array.length, n, a);
        final Segment head = buffer.head;
        if (head == null) {
            return -1;
        }
        final Segment segment = head;
        final int min = Math.min(a, segment.limit - segment.pos);
        ArraysKt___ArraysJvmKt.copyInto(segment.data, array, n, segment.pos, segment.pos + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }
    
    public static final long commonReadDecimalLong(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0L) {
            throw new EOFException();
        }
        long n = 0L;
        int n2 = 0;
        int n3 = 0;
        boolean b = false;
        long n4 = -7L;
        do {
            final Segment head = buffer.head;
            Intrinsics.checkNotNull(head);
            final Segment segment = head;
            final byte[] data = segment.data;
            int i;
            int limit;
            for (i = segment.pos, limit = segment.limit; i < limit; ++i, ++n2) {
                final byte b2 = data[i];
                if (b2 >= 48 && b2 <= 57) {
                    final int n5 = 48 - b2;
                    if (n < -922337203685477580L || (n == -922337203685477580L && n5 < n4)) {
                        final Buffer writeByte = new Buffer().writeDecimalLong(n).writeByte((int)b2);
                        if (n3 == 0) {
                            writeByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    n = n * 10L + n5;
                }
                else {
                    if (b2 != 45 || n2 != 0) {
                        b = true;
                        break;
                    }
                    n3 = 1;
                    --n4;
                }
            }
            if (i == limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = i;
            }
        } while (!b && buffer.head != null);
        buffer.setSize$okio(buffer.size() - n2);
        if (n2 >= ((n3 != 0) ? 2 : 1)) {
            return (n3 != 0) ? n : (-n);
        }
        if (buffer.size() == 0L) {
            throw new EOFException();
        }
        throw new NumberFormatException(((n3 != 0) ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + DSegmentedByteString.toHexString(buffer.getByte(0L)));
    }
    
    public static final long commonReadHexadecimalUnsignedLong(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0L) {
            throw new EOFException();
        }
        long n = 0L;
        int n2 = 0;
        boolean b = false;
        do {
            final Segment head = buffer.head;
            Intrinsics.checkNotNull(head);
            final Segment segment = head;
            final byte[] data = segment.data;
            int i;
            int limit;
            for (i = segment.pos, limit = segment.limit; i < limit; ++i, ++n2) {
                final byte b2 = data[i];
                int n3;
                if (b2 >= 48 && b2 <= 57) {
                    n3 = b2 - 48;
                }
                else if (b2 >= 97 && b2 <= 102) {
                    n3 = b2 - 97 + 10;
                }
                else if (b2 >= 65 && b2 <= 70) {
                    n3 = b2 - 65 + 10;
                }
                else {
                    if (n2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + DSegmentedByteString.toHexString(b2));
                    }
                    b = true;
                    break;
                }
                if ((n & 0xF000000000000000L) != 0x0L) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(n).writeByte((int)b2).readUtf8());
                }
                n = (n << 4 | (long)n3);
            }
            if (i == limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = i;
            }
        } while (!b && buffer.head != null);
        buffer.setSize$okio(buffer.size() - n2);
        return n;
    }
    
    @NotNull
    public static final ByteString commonReadByteString(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }
    
    @NotNull
    public static final ByteString commonReadByteString(@NotNull final Buffer buffer, final long lng) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (buffer.size() < lng) {
            throw new EOFException();
        }
        if (lng >= 4096L) {
            final ByteString snapshot = buffer.snapshot((int)lng);
            buffer.skip(lng);
            return snapshot;
        }
        return new ByteString(buffer.readByteArray(lng));
    }
    
    public static final int commonSelect(@NotNull final Buffer buffer, @NotNull final Options options) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }
    
    public static final void commonReadFully(@NotNull final Buffer buffer, @NotNull final Buffer buffer2, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (buffer.size() < n) {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
        buffer2.write(buffer, n);
    }
    
    public static final long commonReadAll(@NotNull final Buffer buffer, @NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        final long size = buffer.size();
        if (size > 0L) {
            sink.write(buffer, size);
        }
        return size;
    }
    
    @NotNull
    public static final String commonReadUtf8(@NotNull final Buffer buffer, final long lng) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (buffer.size() < lng) {
            throw new EOFException();
        }
        if (lng == 0L) {
            return "";
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        if (segment.pos + lng > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(lng), 0, 0, 3, null);
        }
        final String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, segment.pos, segment.pos + (int)lng);
        segment.pos += (int)lng;
        buffer.setSize$okio(buffer.size() - lng);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return commonToUtf8String;
    }
    
    @Nullable
    public static final String commonReadUtf8Line(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final long index = buffer.indexOf((byte)10);
        return (index != -1L) ? readUtf8Line(buffer, index) : ((buffer.size() != 0L) ? buffer.readUtf8(buffer.size()) : null);
    }
    
    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (n < 0L) {
            throw new IllegalArgumentException(("limit < 0: " + n).toString());
        }
        final long n2 = (n == Long.MAX_VALUE) ? Long.MAX_VALUE : (n + 1L);
        final long index = buffer.indexOf((byte)10, 0L, n2);
        if (index != -1L) {
            return readUtf8Line(buffer, index);
        }
        if (n2 < buffer.size() && buffer.getByte(n2 - 1L) == 13 && buffer.getByte(n2) == 10) {
            return readUtf8Line(buffer, n2);
        }
        final Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), n) + " content=" + buffer2.readByteString().hex() + '\u2026');
    }
    
    public static final int commonReadUtf8CodePoint(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() == 0L) {
            throw new EOFException();
        }
        final byte byte1 = buffer.getByte(0L);
        int n;
        int i;
        if ((byte1 & 0x80) == 0x0) {
            n = (byte1 & 0x7F);
            i = 1;
            final int n2 = 0;
        }
        else if ((byte1 & 0xE0) == 0xC0) {
            n = (byte1 & 0x1F);
            i = 2;
            final int n2 = 128;
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            n = (byte1 & 0xF);
            i = 3;
            final int n2 = 2048;
        }
        else {
            if ((byte1 & 0xF8) != 0xF0) {
                buffer.skip(1L);
                return 65533;
            }
            n = (byte1 & 0x7);
            i = 4;
            final int n2 = 65536;
        }
        if (buffer.size() < i) {
            throw new EOFException("size < " + i + ": " + buffer.size() + " (to read code point prefixed 0x" + DSegmentedByteString.toHexString(byte1) + ')');
        }
        for (int j = 1; j < i; ++j) {
            final byte byte2 = buffer.getByte(j);
            if ((byte2 & 0xC0) != 0x80) {
                buffer.skip(j);
                return 65533;
            }
            n = (n << 6 | (byte2 & 0x3F));
        }
        buffer.skip(i);
        int n2;
        return (n > 1114111) ? 65533 : ((55296 <= n && n < 57344) ? 65533 : ((n < n2) ? 65533 : n));
    }
    
    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull final Buffer buffer, @NotNull final String s, final int n, final int a) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(s, "string");
        if (n < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + n).toString());
        }
        if (a < n) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + a + " < " + n).toString());
        }
        if (a > s.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + a + " > " + s.length()).toString());
        }
        int i = n;
        while (i < a) {
            final char char1 = s.charAt(i);
            if (char1 < '\u0080') {
                final Segment writableSegment$okio = buffer.writableSegment$okio(1);
                final byte[] data = writableSegment$okio.data;
                final int n2 = writableSegment$okio.limit - i;
                final int min = Math.min(a, 8192 - n2);
                data[n2 + i++] = (byte)char1;
                while (i < min) {
                    final char char2 = s.charAt(i);
                    if (char2 >= '\u0080') {
                        break;
                    }
                    data[n2 + i++] = (byte)char2;
                }
                final int n3 = i + n2 - writableSegment$okio.limit;
                writableSegment$okio.limit += n3;
                buffer.setSize$okio(buffer.size() + n3);
            }
            else if (char1 < '\u0800') {
                final Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte)(char1 >> 6 | 0xC0);
                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte)((char1 & '?') | 0x80);
                writableSegment$okio2.limit += 2;
                buffer.setSize$okio(buffer.size() + 2L);
                ++i;
            }
            else if (char1 < '\ud800' || char1 > '\udfff') {
                final Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte)(char1 >> 12 | 0xE0);
                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte)((char1 >> 6 & 0x3F) | 0x80);
                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte)((char1 & '?') | 0x80);
                writableSegment$okio3.limit += 3;
                buffer.setSize$okio(buffer.size() + 3L);
                ++i;
            }
            else {
                final char c = (i + 1 < a) ? s.charAt(i + 1) : '\0';
                if (char1 > '\udbff' || '\udc00' > c || c >= '\ue000') {
                    buffer.writeByte(63);
                    ++i;
                }
                else {
                    final int n4 = 65536 + ((char1 & '\u03ff') << 10 | (c & '\u03ff'));
                    final Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                    writableSegment$okio4.data[writableSegment$okio4.limit] = (byte)(n4 >> 18 | 0xF0);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte)((n4 >> 12 & 0x3F) | 0x80);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte)((n4 >> 6 & 0x3F) | 0x80);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte)((n4 & 0x3F) | 0x80);
                    writableSegment$okio4.limit += 4;
                    buffer.setSize$okio(buffer.size() + 4L);
                    i += 2;
                }
            }
        }
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull final Buffer buffer, final int n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (n < 128) {
            buffer.writeByte(n);
        }
        else if (n < 2048) {
            final Segment writableSegment$okio = buffer.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte)(n >> 6 | 0xC0);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio.limit += 2;
            buffer.setSize$okio(buffer.size() + 2L);
        }
        else if (55296 <= n && n < 57344) {
            buffer.writeByte(63);
        }
        else if (n < 65536) {
            final Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte)(n >> 12 | 0xE0);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte)((n >> 6 & 0x3F) | 0x80);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio2.limit += 3;
            buffer.setSize$okio(buffer.size() + 3L);
        }
        else {
            if (n > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + DSegmentedByteString.toHexString(n));
            }
            final Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte)(n >> 18 | 0xF0);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte)((n >> 12 & 0x3F) | 0x80);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte)((n >> 6 & 0x3F) | 0x80);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio3.limit += 4;
            buffer.setSize$okio(buffer.size() + 4L);
        }
        return buffer;
    }
    
    public static final long commonWriteAll(@NotNull final Buffer buffer, @NotNull final Source source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long n = 0L;
        while (true) {
            final long read = source.read(buffer, 8192L);
            if (read == -1L) {
                break;
            }
            n += read;
        }
        return n;
    }
    
    @NotNull
    public static final Buffer commonWrite(@NotNull final Buffer buffer, @NotNull final Source source, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long read;
        for (long n2 = n; n2 > 0L; n2 -= read) {
            read = source.read(buffer, n2);
            if (read == -1L) {
                throw new EOFException();
            }
        }
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteByte(@NotNull final Buffer buffer, final int n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Segment writableSegment$okio = buffer.writableSegment$okio(1);
        writableSegment$okio.data[writableSegment$okio.limit++] = (byte)n;
        buffer.setSize$okio(buffer.size() + 1L);
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteShort(@NotNull final Buffer buffer, final int n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Segment writableSegment$okio = buffer.writableSegment$okio(2);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 8 & 0xFF);
        data[limit++] = (byte)(n & 0xFF);
        writableSegment$okio.limit = limit;
        buffer.setSize$okio(buffer.size() + 2L);
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteInt(@NotNull final Buffer buffer, final int n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Segment writableSegment$okio = buffer.writableSegment$okio(4);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 24 & 0xFF);
        data[limit++] = (byte)(n >>> 16 & 0xFF);
        data[limit++] = (byte)(n >>> 8 & 0xFF);
        data[limit++] = (byte)(n & 0xFF);
        writableSegment$okio.limit = limit;
        buffer.setSize$okio(buffer.size() + 4L);
        return buffer;
    }
    
    @NotNull
    public static final Buffer commonWriteLong(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Segment writableSegment$okio = buffer.writableSegment$okio(8);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 56 & 0xFFL);
        data[limit++] = (byte)(n >>> 48 & 0xFFL);
        data[limit++] = (byte)(n >>> 40 & 0xFFL);
        data[limit++] = (byte)(n >>> 32 & 0xFFL);
        data[limit++] = (byte)(n >>> 24 & 0xFFL);
        data[limit++] = (byte)(n >>> 16 & 0xFFL);
        data[limit++] = (byte)(n >>> 8 & 0xFFL);
        data[limit++] = (byte)(n & 0xFFL);
        writableSegment$okio.limit = limit;
        buffer.setSize$okio(buffer.size() + 8L);
        return buffer;
    }
    
    public static final void commonWrite(@NotNull final Buffer buffer, @NotNull final Buffer buffer2, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "source");
        long n2 = n;
        if (buffer2 == buffer) {
            throw new IllegalArgumentException("source == this".toString());
        }
        DSegmentedByteString.checkOffsetAndCount(buffer2.size(), 0L, n2);
        while (n2 > 0L) {
            final long n3 = n2;
            final Segment head = buffer2.head;
            Intrinsics.checkNotNull(head);
            final int limit = head.limit;
            final Segment head2 = buffer2.head;
            Intrinsics.checkNotNull(head2);
            if (n3 < limit - head2.pos) {
                Segment prev;
                if (buffer.head != null) {
                    final Segment head3 = buffer.head;
                    Intrinsics.checkNotNull(head3);
                    prev = head3.prev;
                }
                else {
                    prev = null;
                }
                final Segment segment = prev;
                if (segment != null && segment.owner && n2 + segment.limit - (segment.shared ? 0 : segment.pos) <= 8192L) {
                    final Segment head4 = buffer2.head;
                    Intrinsics.checkNotNull(head4);
                    head4.writeTo(segment, (int)n2);
                    buffer2.setSize$okio(buffer2.size() - n2);
                    buffer.setSize$okio(buffer.size() + n2);
                    return;
                }
                final Segment head5 = buffer2.head;
                Intrinsics.checkNotNull(head5);
                buffer2.head = head5.split((int)n2);
            }
            final Segment head6;
            final Segment segment2 = head6 = buffer2.head;
            Intrinsics.checkNotNull(head6);
            final long n4 = head6.limit - segment2.pos;
            buffer2.head = segment2.pop();
            if (buffer.head == null) {
                buffer.head = segment2;
                segment2.prev = segment2;
                segment2.next = segment2.prev;
            }
            else {
                final Segment head7 = buffer.head;
                Intrinsics.checkNotNull(head7);
                final Segment prev2 = head7.prev;
                Intrinsics.checkNotNull(prev2);
                prev2.push(segment2).compact();
            }
            buffer2.setSize$okio(buffer2.size() - n4);
            buffer.setSize$okio(buffer.size() + n4);
            n2 -= n4;
        }
    }
    
    public static final long commonRead(@NotNull final Buffer buffer, @NotNull final Buffer buffer2, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        long size = n;
        if (size < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + size).toString());
        }
        if (buffer.size() == 0L) {
            return -1L;
        }
        if (size > buffer.size()) {
            size = buffer.size();
        }
        buffer2.write(buffer, size);
        return size;
    }
    
    public static final long commonIndexOf(@NotNull final Buffer buffer, final byte b, final long n, final long n2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long lng = n;
        long size = n2;
        if (0L > lng || lng > size) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + lng + " toIndex=" + size).toString());
        }
        if (size > buffer.size()) {
            size = buffer.size();
        }
        if (lng == size) {
            return -1L;
        }
        final long n3 = lng;
        final Segment head = buffer.head;
        if (head == null) {
            return -1L;
        }
        Segment segment = head;
        if (buffer.size() - n3 < n3) {
            long size2;
            for (size2 = buffer.size(); size2 > n3; size2 -= segment.limit - segment.pos) {
                final Segment prev = segment.prev;
                Intrinsics.checkNotNull(prev);
                segment = prev;
            }
            final Segment segment2 = segment;
            final long n4 = size2;
            final Segment segment3 = segment2;
            if (segment3 == null) {
                return -1L;
            }
            Segment segment4 = segment3;
            long n5 = n4;
            while (n5 < size) {
                final byte[] data = segment4.data;
                for (int n6 = (int)Math.min(segment4.limit, segment4.pos + size - n5), i = (int)(segment4.pos + lng - n5); i < n6; ++i) {
                    if (data[i] == b) {
                        return i - segment4.pos + n5;
                    }
                }
                n5 = (lng = n5 + (segment4.limit - segment4.pos));
                final Segment next = segment4.next;
                Intrinsics.checkNotNull(next);
                segment4 = next;
            }
            return -1L;
        }
        else {
            long n7 = 0L;
            while (true) {
                final long n8 = n7 + (segment.limit - segment.pos);
                if (n8 > n3) {
                    break;
                }
                final Segment next2 = segment.next;
                Intrinsics.checkNotNull(next2);
                segment = next2;
                n7 = n8;
            }
            final Segment segment5 = segment;
            final long n9 = n7;
            final Segment segment6 = segment5;
            if (segment6 == null) {
                return -1L;
            }
            Segment segment7 = segment6;
            long n10 = n9;
            while (n10 < size) {
                final byte[] data2 = segment7.data;
                for (int n11 = (int)Math.min(segment7.limit, segment7.pos + size - n10), j = (int)(segment7.pos + lng - n10); j < n11; ++j) {
                    if (data2[j] == b) {
                        return j - segment7.pos + n10;
                    }
                }
                n10 = (lng = n10 + (segment7.limit - segment7.pos));
                final Segment next3 = segment7.next;
                Intrinsics.checkNotNull(next3);
                segment7 = next3;
            }
            return -1L;
        }
    }
    
    public static final long commonIndexOf(@NotNull final Buffer buffer, @NotNull final ByteString byteString, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        long lng = n;
        if (byteString.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        if (lng < 0L) {
            throw new IllegalArgumentException(("fromIndex < 0: " + lng).toString());
        }
        final long n2 = lng;
        final Segment head = buffer.head;
        if (head == null) {
            return -1L;
        }
        Segment segment = head;
        if (buffer.size() - n2 < n2) {
            long size;
            for (size = buffer.size(); size > n2; size -= segment.limit - segment.pos) {
                final Segment prev = segment.prev;
                Intrinsics.checkNotNull(prev);
                segment = prev;
            }
            final Segment segment2 = segment;
            final long n3 = size;
            final Segment segment3 = segment2;
            if (segment3 == null) {
                return -1L;
            }
            Segment segment4 = segment3;
            long n4 = n3;
            final byte[] internalArray$okio = byteString.internalArray$okio();
            final byte b = internalArray$okio[0];
            final int size2 = byteString.size();
            final long n5 = buffer.size() - size2 + 1L;
            while (n4 < n5) {
                final byte[] data = segment4.data;
                for (int n6 = (int)Math.min(segment4.limit, segment4.pos + n5 - n4), i = (int)(segment4.pos + lng - n4); i < n6; ++i) {
                    if (data[i] == b && rangeEquals(segment4, i + 1, internalArray$okio, 1, size2)) {
                        return i - segment4.pos + n4;
                    }
                }
                n4 = (lng = n4 + (segment4.limit - segment4.pos));
                final Segment next = segment4.next;
                Intrinsics.checkNotNull(next);
                segment4 = next;
            }
            return -1L;
        }
        else {
            long n7 = 0L;
            while (true) {
                final long n8 = n7 + (segment.limit - segment.pos);
                if (n8 > n2) {
                    break;
                }
                final Segment next2 = segment.next;
                Intrinsics.checkNotNull(next2);
                segment = next2;
                n7 = n8;
            }
            final Segment segment5 = segment;
            final long n9 = n7;
            final Segment segment6 = segment5;
            if (segment6 == null) {
                return -1L;
            }
            Segment segment7 = segment6;
            long n10 = n9;
            final byte[] internalArray$okio2 = byteString.internalArray$okio();
            final byte b2 = internalArray$okio2[0];
            final int size3 = byteString.size();
            final long n11 = buffer.size() - size3 + 1L;
            while (n10 < n11) {
                final byte[] data2 = segment7.data;
                for (int n12 = (int)Math.min(segment7.limit, segment7.pos + n11 - n10), j = (int)(segment7.pos + lng - n10); j < n12; ++j) {
                    if (data2[j] == b2 && rangeEquals(segment7, j + 1, internalArray$okio2, 1, size3)) {
                        return j - segment7.pos + n10;
                    }
                }
                n10 = (lng = n10 + (segment7.limit - segment7.pos));
                final Segment next3 = segment7.next;
                Intrinsics.checkNotNull(next3);
                segment7 = next3;
            }
            return -1L;
        }
    }
    
    public static final long commonIndexOfElement(@NotNull final Buffer buffer, @NotNull final ByteString byteString, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long lng = n;
        if (lng < 0L) {
            throw new IllegalArgumentException(("fromIndex < 0: " + lng).toString());
        }
        final long n2 = lng;
        final Segment head = buffer.head;
        if (head == null) {
            return -1L;
        }
        Segment segment = head;
        if (buffer.size() - n2 < n2) {
            long size;
            for (size = buffer.size(); size > n2; size -= segment.limit - segment.pos) {
                final Segment prev = segment.prev;
                Intrinsics.checkNotNull(prev);
                segment = prev;
            }
            final Segment segment2 = segment;
            final long n3 = size;
            final Segment segment3 = segment2;
            if (segment3 == null) {
                return -1L;
            }
            Segment segment4 = segment3;
            long n4 = n3;
            if (byteString.size() == 2) {
                final byte byte1 = byteString.getByte(0);
                final byte byte2 = byteString.getByte(1);
                while (n4 < buffer.size()) {
                    final byte[] data = segment4.data;
                    for (int i = (int)(segment4.pos + lng - n4); i < segment4.limit; ++i) {
                        final byte b = data[i];
                        if (b == byte1 || b == byte2) {
                            return i - segment4.pos + n4;
                        }
                    }
                    n4 = (lng = n4 + (segment4.limit - segment4.pos));
                    final Segment next = segment4.next;
                    Intrinsics.checkNotNull(next);
                    segment4 = next;
                }
            }
            else {
                final byte[] internalArray$okio = byteString.internalArray$okio();
                while (n4 < buffer.size()) {
                    final byte[] data2 = segment4.data;
                    for (int j = (int)(segment4.pos + lng - n4); j < segment4.limit; ++j) {
                        final byte b2 = data2[j];
                        for (int k = 0; k < internalArray$okio.length; ++k) {
                            if (b2 == internalArray$okio[k]) {
                                return j - segment4.pos + n4;
                            }
                        }
                    }
                    n4 = (lng = n4 + (segment4.limit - segment4.pos));
                    final Segment next2 = segment4.next;
                    Intrinsics.checkNotNull(next2);
                    segment4 = next2;
                }
            }
            return -1L;
        }
        else {
            long n5 = 0L;
            while (true) {
                final long n6 = n5 + (segment.limit - segment.pos);
                if (n6 > n2) {
                    break;
                }
                final Segment next3 = segment.next;
                Intrinsics.checkNotNull(next3);
                segment = next3;
                n5 = n6;
            }
            final Segment segment5 = segment;
            final long n7 = n5;
            final Segment segment6 = segment5;
            if (segment6 == null) {
                return -1L;
            }
            Segment segment7 = segment6;
            long n8 = n7;
            if (byteString.size() == 2) {
                final byte byte3 = byteString.getByte(0);
                final byte byte4 = byteString.getByte(1);
                while (n8 < buffer.size()) {
                    final byte[] data3 = segment7.data;
                    for (int l = (int)(segment7.pos + lng - n8); l < segment7.limit; ++l) {
                        final byte b3 = data3[l];
                        if (b3 == byte3 || b3 == byte4) {
                            return l - segment7.pos + n8;
                        }
                    }
                    n8 = (lng = n8 + (segment7.limit - segment7.pos));
                    final Segment next4 = segment7.next;
                    Intrinsics.checkNotNull(next4);
                    segment7 = next4;
                }
            }
            else {
                final byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (n8 < buffer.size()) {
                    final byte[] data4 = segment7.data;
                    for (int n9 = (int)(segment7.pos + lng - n8); n9 < segment7.limit; ++n9) {
                        final byte b4 = data4[n9];
                        for (int n10 = 0; n10 < internalArray$okio2.length; ++n10) {
                            if (b4 == internalArray$okio2[n10]) {
                                return n9 - segment7.pos + n8;
                            }
                        }
                    }
                    n8 = (lng = n8 + (segment7.limit - segment7.pos));
                    final Segment next5 = segment7.next;
                    Intrinsics.checkNotNull(next5);
                    segment7 = next5;
                }
            }
            return -1L;
        }
    }
    
    public static final boolean commonRangeEquals(@NotNull final Buffer buffer, final long n, @NotNull final ByteString byteString, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (n < 0L || n2 < 0 || n3 < 0 || buffer.size() - n < n3 || byteString.size() - n2 < n3) {
            return false;
        }
        for (int i = 0; i < n3; ++i) {
            if (buffer.getByte(n + i) != byteString.getByte(n2 + i)) {
                return false;
            }
        }
        return true;
    }
    
    public static final boolean commonEquals(@NotNull final Buffer buffer, @Nullable final Object o) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer == o) {
            return true;
        }
        if (!(o instanceof Buffer)) {
            return false;
        }
        if (buffer.size() != ((Buffer)o).size()) {
            return false;
        }
        if (buffer.size() == 0L) {
            return true;
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        Segment segment = head;
        final Segment head2 = ((Buffer)o).head;
        Intrinsics.checkNotNull(head2);
        Segment segment2 = head2;
        int n = segment.pos;
        int n2 = segment2.pos;
        long n4;
        for (long n3 = 0L; n3 < buffer.size(); n3 += n4) {
            n4 = Math.min(segment.limit - n, segment2.limit - n2);
            for (long n5 = 0L; n5 < n4; ++n5) {
                if (segment.data[n++] != segment2.data[n2++]) {
                    return false;
                }
            }
            if (n == segment.limit) {
                final Segment next = segment.next;
                Intrinsics.checkNotNull(next);
                segment = next;
                n = segment.pos;
            }
            if (n2 == segment2.limit) {
                final Segment next2 = segment2.next;
                Intrinsics.checkNotNull(next2);
                segment2 = next2;
                n2 = segment2.pos;
            }
        }
        return true;
    }
    
    public static final int commonHashCode(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Segment head = buffer.head;
        if (head == null) {
            return 0;
        }
        Segment segment = head;
        int n = 1;
        do {
            for (int i = segment.pos; i < segment.limit; ++i) {
                n = 31 * n + segment.data[i];
            }
            final Segment next = segment.next;
            Intrinsics.checkNotNull(next);
            segment = next;
        } while (segment != buffer.head);
        return n;
    }
    
    @NotNull
    public static final Buffer commonCopy(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        final Buffer buffer2 = new Buffer();
        if (buffer.size() == 0L) {
            return buffer2;
        }
        final Segment head = buffer.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        final Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            final Segment prev = sharedCopy.prev;
            Intrinsics.checkNotNull(prev);
            final Segment segment3 = segment2;
            Intrinsics.checkNotNull(segment3);
            prev.push(segment3.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }
    
    @NotNull
    public static final ByteString commonSnapshot(@NotNull final Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() > 2147483647L) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
        }
        return buffer.snapshot((int)buffer.size());
    }
    
    @NotNull
    public static final ByteString commonSnapshot(@NotNull final Buffer buffer, final int b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (b == 0) {
            return ByteString.EMPTY;
        }
        DSegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, b);
        int i = 0;
        int n = 0;
        for (Segment segment = buffer.head; i < b; i += segment.limit - segment.pos, ++n, segment = segment.next) {
            final Segment segment2 = segment;
            Intrinsics.checkNotNull(segment2);
            if (segment2.limit == segment.pos) {
                throw new AssertionError((Object)"s.limit == s.pos");
            }
        }
        final byte[][] array = new byte[n][];
        final int[] array2 = new int[n * 2];
        int j = 0;
        int n2 = 0;
        for (Segment segment3 = buffer.head; j < b; j += segment3.limit - segment3.pos, array2[n2] = Math.min(j, b), array2[n2 + ((Object[])array).length] = segment3.pos, segment3.shared = true, ++n2, segment3 = segment3.next) {
            final byte[][] array3 = array;
            final int n3 = n2;
            final Segment segment4 = segment3;
            Intrinsics.checkNotNull(segment4);
            array3[n3] = segment4.data;
        }
        return new SegmentedByteString(array, array2);
    }
    
    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull final Buffer buffer, @NotNull final Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        final Buffer.UnsafeCursor resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = false;
        return resolveDefaultParameter;
    }
    
    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull final Buffer buffer, @NotNull final Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        final Buffer.UnsafeCursor resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = true;
        return resolveDefaultParameter;
    }
    
    public static final int commonNext(@NotNull final Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        final long offset = unsafeCursor.offset;
        final Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (offset == buffer.size()) {
            throw new IllegalStateException("no more bytes".toString());
        }
        return (unsafeCursor.offset == -1L) ? unsafeCursor.seek(0L) : unsafeCursor.seek(unsafeCursor.offset + (unsafeCursor.end - unsafeCursor.start));
    }
    
    public static final int commonSeek(@NotNull final Buffer.UnsafeCursor unsafeCursor, final long offset) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        final Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        final Buffer buffer2 = buffer;
        if (offset < -1L || offset > buffer2.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + buffer2.size());
        }
        if (offset == -1L || offset == buffer2.size()) {
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = offset;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            return unsafeCursor.end = -1;
        }
        long n = 0L;
        long size = buffer2.size();
        Segment segment = buffer2.head;
        Segment segment2 = buffer2.head;
        if (unsafeCursor.getSegment$okio() != null) {
            final long offset2 = unsafeCursor.offset;
            final int start = unsafeCursor.start;
            final Segment segment$okio = unsafeCursor.getSegment$okio();
            Intrinsics.checkNotNull(segment$okio);
            final long n2 = offset2 - (start - segment$okio.pos);
            if (n2 > offset) {
                size = n2;
                segment2 = unsafeCursor.getSegment$okio();
            }
            else {
                n = n2;
                segment = unsafeCursor.getSegment$okio();
            }
        }
        Segment segment$okio2;
        long n3;
        if (size - offset > offset - n) {
            segment$okio2 = segment;
            n3 = n;
            while (true) {
                final long n4 = n3;
                final Segment segment3 = segment$okio2;
                Intrinsics.checkNotNull(segment3);
                if (offset < n4 + (segment3.limit - segment$okio2.pos)) {
                    break;
                }
                n3 += segment$okio2.limit - segment$okio2.pos;
                segment$okio2 = segment$okio2.next;
            }
        }
        else {
            Segment segment4;
            long n5;
            Segment segment5;
            for (segment$okio2 = segment2, n3 = size; n3 > offset; n3 = n5 - (segment5.limit - segment$okio2.pos)) {
                segment4 = segment$okio2;
                Intrinsics.checkNotNull(segment4);
                segment$okio2 = segment4.prev;
                n5 = n3;
                segment5 = segment$okio2;
                Intrinsics.checkNotNull(segment5);
            }
        }
        if (unsafeCursor.readWrite) {
            final Segment segment6 = segment$okio2;
            Intrinsics.checkNotNull(segment6);
            if (segment6.shared) {
                final Segment unsharedCopy = segment$okio2.unsharedCopy();
                if (buffer2.head == segment$okio2) {
                    buffer2.head = unsharedCopy;
                }
                segment$okio2 = segment$okio2.push(unsharedCopy);
                final Segment prev = segment$okio2.prev;
                Intrinsics.checkNotNull(prev);
                prev.pop();
            }
        }
        unsafeCursor.setSegment$okio(segment$okio2);
        unsafeCursor.offset = offset;
        final Segment segment7 = segment$okio2;
        Intrinsics.checkNotNull(segment7);
        unsafeCursor.data = segment7.data;
        unsafeCursor.start = segment$okio2.pos + (int)(offset - n3);
        unsafeCursor.end = segment$okio2.limit;
        return unsafeCursor.end - unsafeCursor.start;
    }
    
    public static final long commonResizeBuffer(@NotNull final Buffer.UnsafeCursor unsafeCursor, final long size$okio) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        final Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        final Buffer buffer2 = buffer;
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        final long size = buffer2.size();
        if (size$okio <= size) {
            if (size$okio < 0L) {
                throw new IllegalArgumentException(("newSize < 0: " + size$okio).toString());
            }
            int n2;
            for (long n = size - size$okio; n > 0L; n -= n2) {
                final Segment head = buffer2.head;
                Intrinsics.checkNotNull(head);
                final Segment prev;
                final Segment segment = prev = head.prev;
                Intrinsics.checkNotNull(prev);
                n2 = prev.limit - segment.pos;
                if (n2 > n) {
                    segment.limit -= (int)n;
                    break;
                }
                buffer2.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = size$okio;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
        }
        else if (size$okio > size) {
            int n3 = 1;
            long a = size$okio - size;
            while (a > 0L) {
                final Segment writableSegment$okio = buffer2.writableSegment$okio(1);
                final int n4 = (int)Math.min(a, 8192 - writableSegment$okio.limit);
                writableSegment$okio.limit += n4;
                a -= n4;
                if (n3 != 0) {
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = writableSegment$okio.limit - n4;
                    unsafeCursor.end = writableSegment$okio.limit;
                    n3 = 0;
                }
            }
        }
        buffer2.setSize$okio(size$okio);
        return size;
    }
    
    public static final long commonExpandBuffer(@NotNull final Buffer.UnsafeCursor unsafeCursor, final int n) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (n <= 0) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + n).toString());
        }
        if (n > 8192) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + n).toString());
        }
        final Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        final Buffer buffer2 = buffer;
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        }
        final long size = buffer2.size();
        final Segment writableSegment$okio = buffer2.writableSegment$okio(n);
        final int n2 = 8192 - writableSegment$okio.limit;
        writableSegment$okio.limit = 8192;
        buffer2.setSize$okio(size + n2);
        unsafeCursor.setSegment$okio(writableSegment$okio);
        unsafeCursor.offset = size;
        unsafeCursor.data = writableSegment$okio.data;
        unsafeCursor.start = 8192 - n2;
        unsafeCursor.end = 8192;
        return n2;
    }
    
    public static final void commonClose(@NotNull final Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }
    
    static {
        HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    }
}
