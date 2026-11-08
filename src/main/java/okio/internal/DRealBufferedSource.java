package okio.internal;

import kotlin.*;
import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import java.io.*;
import org.jetbrains.annotations.*;
import kotlin.text.*;
import okio.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068" }, d2 = { "commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio" })
@JvmName(name = "DRealBufferedSource")
@SourceDebugExtension({ "SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/DRealBufferedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,402:1\n1#2:403\n62#3:404\n62#3:405\n62#3:406\n62#3:407\n62#3:408\n62#3:409\n62#3:410\n62#3:411\n62#3:412\n62#3:413\n62#3:414\n62#3:415\n62#3:416\n62#3:417\n62#3:418\n62#3:419\n62#3:420\n62#3:421\n62#3:422\n62#3:423\n62#3:424\n62#3:425\n62#3:426\n62#3:428\n62#3:429\n62#3:430\n62#3:431\n62#3:432\n62#3:433\n62#3:434\n62#3:435\n62#3:436\n62#3:437\n62#3:438\n62#3:439\n62#3:440\n62#3:441\n62#3:442\n62#3:443\n62#3:444\n62#3:445\n62#3:446\n62#3:447\n62#3:449\n62#3:450\n62#3:451\n62#3:452\n62#3:453\n62#3:454\n62#3:455\n62#3:456\n62#3:457\n62#3:458\n62#3:459\n62#3:460\n62#3:461\n62#3:462\n62#3:463\n62#3:464\n62#3:465\n62#3:466\n62#3:467\n62#3:468\n62#3:469\n62#3:470\n62#3:471\n62#3:472\n62#3:473\n62#3:474\n62#3:475\n89#4:427\n89#4:448\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/DRealBufferedSource\n*L\n41#1:404\n42#1:405\n46#1:406\n47#1:407\n52#1:408\n62#1:409\n63#1:410\n70#1:411\n74#1:412\n75#1:413\n80#1:414\n87#1:415\n94#1:416\n99#1:417\n107#1:418\n108#1:419\n113#1:420\n122#1:421\n123#1:422\n130#1:423\n136#1:424\n137#1:425\n141#1:426\n142#1:428\n150#1:429\n154#1:430\n159#1:431\n160#1:432\n163#1:433\n166#1:434\n167#1:435\n168#1:436\n174#1:437\n175#1:438\n180#1:439\n187#1:440\n188#1:441\n193#1:442\n201#1:443\n203#1:444\n204#1:445\n206#1:446\n209#1:447\n211#1:449\n219#1:450\n226#1:451\n231#1:452\n236#1:453\n241#1:454\n246#1:455\n251#1:456\n256#1:457\n264#1:458\n275#1:459\n283#1:460\n297#1:461\n304#1:462\n307#1:463\n308#1:464\n319#1:465\n324#1:466\n325#1:467\n338#1:468\n341#1:469\n342#1:470\n354#1:471\n357#1:472\n358#1:473\n383#1:474\n396#1:475\n141#1:427\n209#1:448\n*E\n" })
public class DRealBufferedSource
{
    public static final long commonRead(@NotNull final RealBufferedSource realBufferedSource, @NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (n < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + n).toString());
        }
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSource.bufferField.size() == 0L && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
            return -1L;
        }
        return realBufferedSource.bufferField.read(buffer, Math.min(n, realBufferedSource.bufferField.size()));
    }
    
    public static final boolean commonExhausted(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L;
    }
    
    public static final void commonRequire(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (!realBufferedSource.request(n)) {
            throw new EOFException();
        }
    }
    
    public static final boolean commonRequest(@NotNull final RealBufferedSource realBufferedSource, final long lng) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (lng < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + lng).toString());
        }
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (realBufferedSource.bufferField.size() < lng) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                return false;
            }
        }
        return true;
    }
    
    public static final byte commonReadByte(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }
    
    @NotNull
    public static final ByteString commonReadByteString(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }
    
    @NotNull
    public static final ByteString commonReadByteString(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(n);
        return realBufferedSource.bufferField.readByteString(n);
    }
    
    public static final int commonSelect(@NotNull final RealBufferedSource realBufferedSource, @NotNull final Options options) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            final int selectPrefix = DBuffer.selectPrefix(realBufferedSource.bufferField, options, true);
            switch (selectPrefix) {
                case -1: {
                    return -1;
                }
                case -2: {
                    continue;
                }
                default: {
                    realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1L);
        return -1;
    }
    
    @NotNull
    public static final byte[] commonReadByteArray(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }
    
    @NotNull
    public static final byte[] commonReadByteArray(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(n);
        return realBufferedSource.bufferField.readByteArray(n);
    }
    
    public static final void commonReadFully(@NotNull final RealBufferedSource realBufferedSource, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(array, "sink");
        try {
            realBufferedSource.require(array.length);
        }
        catch (final EOFException ex) {
            int n = 0;
            while (realBufferedSource.bufferField.size() > 0L) {
                final int read = realBufferedSource.bufferField.read(array, n, (int)realBufferedSource.bufferField.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                n += read;
            }
            throw ex;
        }
        realBufferedSource.bufferField.readFully(array);
    }
    
    public static final int commonRead(@NotNull final RealBufferedSource realBufferedSource, @NotNull final byte[] array, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(array, "sink");
        DSegmentedByteString.checkOffsetAndCount(array.length, n, n2);
        if (realBufferedSource.bufferField.size() == 0L && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
            return -1;
        }
        return realBufferedSource.bufferField.read(array, n, (int)Math.min(n2, realBufferedSource.bufferField.size()));
    }
    
    public static final void commonReadFully(@NotNull final RealBufferedSource realBufferedSource, @NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            realBufferedSource.require(n);
        }
        catch (final EOFException ex) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw ex;
        }
        realBufferedSource.bufferField.readFully(buffer, n);
    }
    
    public static final long commonReadAll(@NotNull final RealBufferedSource realBufferedSource, @NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long n = 0L;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1L) {
            final long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0L) {
                n += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() > 0L) {
            n += realBufferedSource.bufferField.size();
            sink.write(realBufferedSource.bufferField, realBufferedSource.bufferField.size());
        }
        return n;
    }
    
    @NotNull
    public static final String commonReadUtf8(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }
    
    @NotNull
    public static final String commonReadUtf8(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(n);
        return realBufferedSource.bufferField.readUtf8(n);
    }
    
    @Nullable
    public static final String commonReadUtf8Line(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        final long index = realBufferedSource.indexOf((byte)10);
        return (index == -1L) ? ((realBufferedSource.bufferField.size() != 0L) ? realBufferedSource.readUtf8(realBufferedSource.bufferField.size()) : null) : DBuffer.readUtf8Line(realBufferedSource.bufferField, index);
    }
    
    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (n < 0L) {
            throw new IllegalArgumentException(("limit < 0: " + n).toString());
        }
        final long n2 = (n == Long.MAX_VALUE) ? Long.MAX_VALUE : (n + 1L);
        final long index = realBufferedSource.indexOf((byte)10, 0L, n2);
        if (index != -1L) {
            return DBuffer.readUtf8Line(realBufferedSource.bufferField, index);
        }
        if (n2 < Long.MAX_VALUE && realBufferedSource.request(n2) && realBufferedSource.bufferField.getByte(n2 - 1L) == 13 && realBufferedSource.request(n2 + 1L) && realBufferedSource.bufferField.getByte(n2) == 10) {
            return DBuffer.readUtf8Line(realBufferedSource.bufferField, n2);
        }
        final Buffer buffer = new Buffer();
        realBufferedSource.bufferField.copyTo(buffer, 0L, Math.min(32, realBufferedSource.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), n) + " content=" + buffer.readByteString().hex() + '\u2026');
    }
    
    public static final int commonReadUtf8CodePoint(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        final byte byte1 = realBufferedSource.bufferField.getByte(0L);
        if ((byte1 & 0xE0) == 0xC0) {
            realBufferedSource.require(2L);
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            realBufferedSource.require(3L);
        }
        else if ((byte1 & 0xF8) == 0xF0) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }
    
    public static final short commonReadShort(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }
    
    public static final short commonReadShortLe(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }
    
    public static final int commonReadInt(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }
    
    public static final int commonReadIntLe(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }
    
    public static final long commonReadLong(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }
    
    public static final long commonReadLongLe(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }
    
    public static final long commonReadDecimalLong(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        long n = 0L;
        while (realBufferedSource.request(n + 1L)) {
            final byte byte1 = realBufferedSource.bufferField.getByte(n);
            if ((byte1 < 48 || byte1 > 57) && (n != 0L || byte1 != 45)) {
                if (n == 0L) {
                    final StringBuilder append = new StringBuilder().append("Expected a digit or '-' but was 0x");
                    final String string = Integer.toString(byte1, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                    throw new NumberFormatException(append.append(string).toString());
                }
                break;
            }
            else {
                ++n;
            }
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }
    
    public static final long commonReadHexadecimalUnsignedLong(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        int n = 0;
        while (realBufferedSource.request(n + 1)) {
            final byte byte1 = realBufferedSource.bufferField.getByte(n);
            if ((byte1 < 48 || byte1 > 57) && (byte1 < 97 || byte1 > 102) && (byte1 < 65 || byte1 > 70)) {
                if (n == 0) {
                    final StringBuilder append = new StringBuilder().append("Expected leading [0-9a-fA-F] character but was 0x");
                    final String string = Integer.toString(byte1, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                    throw new NumberFormatException(append.append(string).toString());
                }
                break;
            }
            else {
                ++n;
            }
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }
    
    public static final void commonSkip(@NotNull final RealBufferedSource realBufferedSource, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        long a = n;
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (a > 0L) {
            if (realBufferedSource.bufferField.size() == 0L && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                throw new EOFException();
            }
            final long min = Math.min(a, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(min);
            a -= min;
        }
    }
    
    public static final long commonIndexOf(@NotNull final RealBufferedSource realBufferedSource, final byte b, final long n, final long lng) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        long max = n;
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (0L > max || max > lng) {
            throw new IllegalArgumentException(("fromIndex=" + max + " toIndex=" + lng).toString());
        }
        while (max < lng) {
            final long index = realBufferedSource.bufferField.indexOf(b, max, lng);
            if (index != -1L) {
                return index;
            }
            final long size = realBufferedSource.bufferField.size();
            if (size >= lng || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                return -1L;
            }
            max = Math.max(max, size);
        }
        return -1L;
    }
    
    public static final long commonIndexOf(@NotNull final RealBufferedSource realBufferedSource, @NotNull final ByteString byteString, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        long max = n;
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            final long index = realBufferedSource.bufferField.indexOf(byteString, max);
            if (index != -1L) {
                return index;
            }
            final long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                return -1L;
            }
            max = Math.max(max, size - byteString.size() + 1L);
        }
    }
    
    public static final long commonIndexOfElement(@NotNull final RealBufferedSource realBufferedSource, @NotNull final ByteString byteString, final long n) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long max = n;
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            final long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, max);
            if (indexOfElement != -1L) {
                return indexOfElement;
            }
            final long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                return -1L;
            }
            max = Math.max(max, size);
        }
    }
    
    public static final boolean commonRangeEquals(@NotNull final RealBufferedSource realBufferedSource, final long n, @NotNull final ByteString byteString, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (n < 0L || n2 < 0 || n3 < 0 || byteString.size() - n2 < n3) {
            return false;
        }
        for (int i = 0; i < n3; ++i) {
            final long n4 = n + i;
            if (!realBufferedSource.request(n4 + 1L)) {
                return false;
            }
            if (realBufferedSource.bufferField.getByte(n4) != byteString.getByte(n2 + i)) {
                return false;
            }
        }
        return true;
    }
    
    @NotNull
    public static final BufferedSource commonPeek(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }
    
    public static final void commonClose(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }
    
    @NotNull
    public static final Timeout commonTimeout(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }
    
    @NotNull
    public static final String commonToString(@NotNull final RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + ')';
    }
}
