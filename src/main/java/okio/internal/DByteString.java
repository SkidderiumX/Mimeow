package okio.internal;

import kotlin.jvm.*;
import kotlin.jvm.internal.*;
import kotlin.text.*;
import java.util.*;
import kotlin.collections.*;
import org.jetbrains.annotations.*;
import okio.*;
import kotlin.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>" }, d2 = { "HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio" })
@JvmName(name = "DByteString")
@SourceDebugExtension({ "SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/DByteString\n+ 2 Util.kt\nokio/DSegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,363:1\n131#1,2:369\n133#1,9:372\n68#2:364\n74#2:365\n74#2:367\n74#2:368\n68#2:396\n74#2:408\n1#3:366\n1#3:371\n212#4,7:381\n122#4:388\n219#4,5:389\n122#4:394\n226#4:395\n228#4:397\n397#4,2:398\n122#4:400\n400#4,6:401\n127#4:407\n406#4:409\n122#4:410\n407#4,13:411\n122#4:424\n422#4:425\n122#4:426\n425#4:427\n230#4,3:428\n440#4,3:431\n122#4:434\n443#4:435\n127#4:436\n446#4,10:437\n127#4:447\n456#4:448\n122#4:449\n457#4,4:450\n127#4:454\n461#4:455\n122#4:456\n462#4,14:457\n122#4:471\n477#4,2:472\n122#4:474\n481#4:475\n122#4:476\n484#4:477\n234#4,3:478\n500#4,3:481\n122#4:484\n503#4:485\n127#4:486\n506#4,2:487\n127#4:489\n510#4,10:490\n127#4:500\n520#4:501\n122#4:502\n521#4,4:503\n127#4:507\n525#4:508\n122#4:509\n526#4,4:510\n127#4:514\n530#4:515\n122#4:516\n531#4,15:517\n122#4:532\n547#4,2:533\n122#4:535\n550#4,2:536\n122#4:538\n554#4:539\n122#4:540\n557#4:541\n241#4:542\n122#4:543\n242#4,5:544\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/DByteString\n*L\n329#1:369,2\n329#1:372,9\n67#1:364\n68#1:365\n258#1:367\n259#1:368\n348#1:396\n348#1:408\n329#1:371\n348#1:381,7\n353#1:388\n348#1:389,5\n353#1:394\n348#1:395\n348#1:397\n348#1:398,2\n353#1:400\n348#1:401,6\n348#1:407\n348#1:409\n353#1:410\n348#1:411,13\n353#1:424\n348#1:425\n353#1:426\n348#1:427\n348#1:428,3\n348#1:431,3\n353#1:434\n348#1:435\n348#1:436\n348#1:437,10\n348#1:447\n348#1:448\n353#1:449\n348#1:450,4\n348#1:454\n348#1:455\n353#1:456\n348#1:457,14\n353#1:471\n348#1:472,2\n353#1:474\n348#1:475\n353#1:476\n348#1:477\n348#1:478,3\n348#1:481,3\n353#1:484\n348#1:485\n348#1:486\n348#1:487,2\n348#1:489\n348#1:490,10\n348#1:500\n348#1:501\n353#1:502\n348#1:503,4\n348#1:507\n348#1:508\n353#1:509\n348#1:510,4\n348#1:514\n348#1:515\n353#1:516\n348#1:517,15\n353#1:532\n348#1:533,2\n353#1:535\n348#1:536,2\n353#1:538\n348#1:539\n353#1:540\n348#1:541\n348#1:542\n353#1:543\n348#1:544,5\n*E\n" })
public class DByteString
{
    @NotNull
    private static final char[] HEX_DIGIT_CHARS;
    
    @NotNull
    public static final String commonUtf8(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio == null) {
            utf8$okio = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(utf8$okio);
        }
        return utf8$okio;
    }
    
    @NotNull
    public static final String commonBase64(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return DBase64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }
    
    @NotNull
    public static final String commonBase64Url(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return DBase64.encodeBase64(byteString.getData$okio(), DBase64.getBASE64_URL_SAFE());
    }
    
    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return DByteString.HEX_DIGIT_CHARS;
    }
    
    @NotNull
    public static final String commonHex(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        final char[] array = new char[byteString.getData$okio().length * 2];
        int n = 0;
        final byte[] data$okio = byteString.getData$okio();
        for (int i = 0; i < data$okio.length; ++i) {
            final byte b = data$okio[i];
            array[n++] = getHEX_DIGIT_CHARS()[b >> 4 & 0xF];
            array[n++] = getHEX_DIGIT_CHARS()[b & 0xF];
        }
        return StringsKt__StringsJVMKt.concatToString(array);
    }
    
    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getData$okio().length; ++i) {
            final byte b = byteString.getData$okio()[i];
            if (b >= 65 && b <= 90) {
                final byte[] data$okio = byteString.getData$okio();
                final byte[] copy = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, size)");
                final byte[] array = copy;
                array[i++] = (byte)(b + 32);
                while (i < array.length) {
                    final byte b2 = array[i];
                    if (b2 < 65 || b2 > 90) {
                        ++i;
                    }
                    else {
                        array[i] = (byte)(b2 + 32);
                        ++i;
                    }
                }
                return new ByteString(array);
            }
        }
        return byteString;
    }
    
    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getData$okio().length; ++i) {
            final byte b = byteString.getData$okio()[i];
            if (b >= 97 && b <= 122) {
                final byte[] data$okio = byteString.getData$okio();
                final byte[] copy = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, size)");
                final byte[] array = copy;
                array[i++] = (byte)(b - 32);
                while (i < array.length) {
                    final byte b2 = array[i];
                    if (b2 < 97 || b2 > 122) {
                        ++i;
                    }
                    else {
                        array[i] = (byte)(b2 - 32);
                        ++i;
                    }
                }
                return new ByteString(array);
            }
        }
        return byteString;
    }
    
    @NotNull
    public static final ByteString commonSubstring(@NotNull final ByteString byteString, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        final int resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(byteString, n2);
        if (n < 0) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (resolveDefaultParameter > byteString.getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        if (resolveDefaultParameter - n < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (n == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
            return byteString;
        }
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), n, resolveDefaultParameter));
    }
    
    public static final byte commonGetByte(@NotNull final ByteString byteString, final int n) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio()[n];
    }
    
    public static final int commonGetSize(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio().length;
    }
    
    @NotNull
    public static final byte[] commonToByteArray(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        final byte[] data$okio = byteString.getData$okio();
        final byte[] copy = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, size)");
        return copy;
    }
    
    @NotNull
    public static final byte[] commonInternalArray(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio();
    }
    
    public static final boolean commonRangeEquals(@NotNull final ByteString byteString, final int n, @NotNull final ByteString byteString2, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(n2, byteString.getData$okio(), n, n3);
    }
    
    public static final boolean commonRangeEquals(@NotNull final ByteString byteString, final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "other");
        return n >= 0 && n <= byteString.getData$okio().length - n3 && n2 >= 0 && n2 <= array.length - n3 && DSegmentedByteString.arrayRangeEquals(byteString.getData$okio(), n, array, n2, n3);
    }
    
    public static final void commonCopyInto(@NotNull final ByteString byteString, final int n, @NotNull final byte[] array, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "target");
        ArraysKt___ArraysJvmKt.copyInto(byteString.getData$okio(), array, n2, n, n + n3);
    }
    
    public static final boolean commonStartsWith(@NotNull final ByteString byteString, @NotNull final ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }
    
    public static final boolean commonStartsWith(@NotNull final ByteString byteString, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "prefix");
        return byteString.rangeEquals(0, array, 0, array.length);
    }
    
    public static final boolean commonEndsWith(@NotNull final ByteString byteString, @NotNull final ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }
    
    public static final boolean commonEndsWith(@NotNull final ByteString byteString, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "suffix");
        return byteString.rangeEquals(byteString.size() - array.length, array, 0, array.length);
    }
    
    public static final int commonIndexOf(@NotNull final ByteString byteString, @NotNull final byte[] array, final int a) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "other");
        final int n = byteString.getData$okio().length - array.length;
        int max = Math.max(a, 0);
        if (max <= n) {
            while (!DSegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, array, 0, array.length)) {
                if (max == n) {
                    return -1;
                }
                ++max;
            }
            return max;
        }
        return -1;
    }
    
    public static final int commonLastIndexOf(@NotNull final ByteString byteString, @NotNull final ByteString byteString2, final int n) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), n);
    }
    
    public static final int commonLastIndexOf(@NotNull final ByteString byteString, @NotNull final byte[] array, final int n) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(array, "other");
        for (int min = Math.min(DSegmentedByteString.resolveDefaultParameter(byteString, n), byteString.getData$okio().length - array.length); -1 < min; --min) {
            if (DSegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, array, 0, array.length)) {
                return min;
            }
        }
        return -1;
    }
    
    public static final boolean commonEquals(@NotNull final ByteString byteString, @Nullable final Object o) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return o == byteString || (o instanceof ByteString && (((ByteString)o).size() == byteString.getData$okio().length && ((ByteString)o).rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)));
    }
    
    public static final int commonHashCode(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        final int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        final int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }
    
    public static final int commonCompareTo(@NotNull final ByteString byteString, @NotNull final ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        final int size = byteString.size();
        final int size2 = byteString2.size();
        for (int i = 0; i < Math.min(size, size2); ++i) {
            final int n = byteString.getByte(i) & 0xFF;
            final int n2 = byteString2.getByte(i) & 0xFF;
            if (n != n2) {
                return (n < n2) ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return (size < size2) ? -1 : 1;
    }
    
    @NotNull
    public static final ByteString commonOf(@NotNull final byte[] original) {
        Intrinsics.checkNotNullParameter(original, "data");
        final byte[] copy = Arrays.copyOf(original, original.length);
        Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, size)");
        return new ByteString(copy);
    }
    
    @NotNull
    public static final ByteString commonToByteString(@NotNull final byte[] array, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        final int resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(array, n2);
        DSegmentedByteString.checkOffsetAndCount(array.length, n, resolveDefaultParameter);
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(array, n, n + resolveDefaultParameter));
    }
    
    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull final String utf8$okio) {
        Intrinsics.checkNotNullParameter(utf8$okio, "<this>");
        final ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(utf8$okio));
        byteString.setUtf8$okio(utf8$okio);
        return byteString;
    }
    
    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        final byte[] decodeBase64ToArray = DBase64.decodeBase64ToArray(s);
        return (decodeBase64ToArray != null) ? new ByteString(decodeBase64ToArray) : null;
    }
    
    @NotNull
    public static final ByteString commonDecodeHex(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        final byte[] array = new byte[str.length() / 2];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (byte)((decodeHexDigit(str.charAt(i * 2)) << 4) + decodeHexDigit(str.charAt(i * 2 + 1)));
        }
        return new ByteString(array);
    }
    
    public static final void commonWrite(@NotNull final ByteString byteString, @NotNull final Buffer buffer, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), n, n2);
    }
    
    private static final int decodeHexDigit(final char c) {
        int n;
        if ('0' <= c && c < ':') {
            n = c - '0';
        }
        else if ('a' <= c && c < 'g') {
            n = c - 'a' + 10;
        }
        else {
            if ('A' > c || c >= 'G') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
            n = c - 'A' + 10;
        }
        return n;
    }
    
    @NotNull
    public static final String commonToString(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        final int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex == -1) {
            String s;
            if (byteString.getData$okio().length <= 64) {
                s = "[hex=" + byteString.hex() + ']';
            }
            else {
                final StringBuilder append = new StringBuilder().append("[size=").append(byteString.getData$okio().length).append(" hex=");
                final int n = 0;
                final int resolveDefaultParameter = DSegmentedByteString.resolveDefaultParameter(byteString, 64);
                if (resolveDefaultParameter > byteString.getData$okio().length) {
                    throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
                }
                if (resolveDefaultParameter - n < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                s = append.append(((resolveDefaultParameter == byteString.getData$okio().length) ? byteString : new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), n, resolveDefaultParameter))).hex()).append("\u2026]").toString();
            }
            return s;
        }
        final String utf8 = byteString.utf8();
        final String substring = utf8.substring(0, access$codePointIndexToCharIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        final String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        return (access$codePointIndexToCharIndex < utf8.length()) ? ("[size=" + byteString.getData$okio().length + " text=" + replace$default + "\u2026]") : ("[text=" + replace$default + ']');
    }
    
    private static final int codePointIndexToCharIndex(final byte[] array, final int n) {
        int n2 = 0;
        int n3 = 0;
        final int n4 = 0;
        final int length = array.length;
        int i = n4;
        while (i < length) {
            final byte b = array[i];
            if (b >= 0) {
                final byte b2 = b;
                final int n5 = n3;
                n3 = n5 + 1;
                if (n5 == n) {
                    return n2;
                }
                if ((b2 != 10 && b2 != 13 && ((0 <= b2 && b2 < 32) || (127 <= b2 && b2 < 160))) || b2 == 65533) {
                    return -1;
                }
                n2 += ((b2 < 65536) ? 1 : 2);
                ++i;
                while (i < length && array[i] >= 0) {
                    final byte b3 = array[i++];
                    final int n6 = n3;
                    n3 = n6 + 1;
                    if (n6 == n) {
                        return n2;
                    }
                    if ((b3 != 10 && b3 != 13 && ((0 <= b3 && b3 < 32) || (127 <= b3 && b3 < 160))) || b3 == 65533) {
                        return -1;
                    }
                    n2 += ((b3 < 65536) ? 1 : 2);
                }
            }
            else if (b >> 5 == -2) {
                final int n7 = i;
                int n12;
                int n13;
                if (length <= i + 1) {
                    final int n8 = 65533;
                    final int n9 = n7;
                    final int n10 = n8;
                    final int n11 = n3;
                    n3 = n11 + 1;
                    if (n11 == n) {
                        return n2;
                    }
                    if ((n10 != 10 && n10 != 13 && ((0 <= n10 && n10 < 32) || (127 <= n10 && n10 < 160))) || n10 == 65533) {
                        return -1;
                    }
                    n2 += ((n10 < 65536) ? 1 : 2);
                    final Unit instance = Unit.INSTANCE;
                    n12 = n9;
                    n13 = 1;
                }
                else {
                    final byte b4 = array[i];
                    final byte b5 = array[i + 1];
                    if ((b5 & 0xC0) != 0x80) {
                        final int n14 = 65533;
                        final int n15 = n7;
                        final int n16 = n14;
                        final int n17 = n3;
                        n3 = n17 + 1;
                        if (n17 == n) {
                            return n2;
                        }
                        if ((n16 != 10 && n16 != 13 && ((0 <= n16 && n16 < 32) || (127 <= n16 && n16 < 160))) || n16 == 65533) {
                            return -1;
                        }
                        n2 += ((n16 < 65536) ? 1 : 2);
                        final Unit instance2 = Unit.INSTANCE;
                        n12 = n15;
                        n13 = 1;
                    }
                    else {
                        final int n18 = 0xF80 ^ b5 ^ b4 << 6;
                        if (n18 < 128) {
                            final int n19 = 65533;
                            final int n20 = n7;
                            final int n21 = n19;
                            final int n22 = n3;
                            n3 = n22 + 1;
                            if (n22 == n) {
                                return n2;
                            }
                            if ((n21 != 10 && n21 != 13 && ((0 <= n21 && n21 < 32) || (127 <= n21 && n21 < 160))) || n21 == 65533) {
                                return -1;
                            }
                            n2 += ((n21 < 65536) ? 1 : 2);
                            final Unit instance3 = Unit.INSTANCE;
                            n12 = n20;
                        }
                        else {
                            final int n23 = n18;
                            final int n24 = n7;
                            final int n25 = n23;
                            final int n26 = n3;
                            n3 = n26 + 1;
                            if (n26 == n) {
                                return n2;
                            }
                            if ((n25 != 10 && n25 != 13 && ((0 <= n25 && n25 < 32) || (127 <= n25 && n25 < 160))) || n25 == 65533) {
                                return -1;
                            }
                            n2 += ((n25 < 65536) ? 1 : 2);
                            final Unit instance4 = Unit.INSTANCE;
                            n12 = n24;
                        }
                        n13 = 2;
                    }
                }
                i = n12 + n13;
            }
            else if (b >> 4 == -2) {
                final int n27 = i;
                int n32;
                int n33;
                if (length <= i + 2) {
                    final int n28 = 65533;
                    final int n29 = n27;
                    final int n30 = n28;
                    final int n31 = n3;
                    n3 = n31 + 1;
                    if (n31 == n) {
                        return n2;
                    }
                    if ((n30 != 10 && n30 != 13 && ((0 <= n30 && n30 < 32) || (127 <= n30 && n30 < 160))) || n30 == 65533) {
                        return -1;
                    }
                    n2 += ((n30 < 65536) ? 1 : 2);
                    final Unit instance5 = Unit.INSTANCE;
                    n32 = n29;
                    n33 = ((length <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : 2);
                }
                else {
                    final byte b6 = array[i];
                    final byte b7 = array[i + 1];
                    if ((b7 & 0xC0) != 0x80) {
                        final int n34 = 65533;
                        final int n35 = n27;
                        final int n36 = n34;
                        final int n37 = n3;
                        n3 = n37 + 1;
                        if (n37 == n) {
                            return n2;
                        }
                        if ((n36 != 10 && n36 != 13 && ((0 <= n36 && n36 < 32) || (127 <= n36 && n36 < 160))) || n36 == 65533) {
                            return -1;
                        }
                        n2 += ((n36 < 65536) ? 1 : 2);
                        final Unit instance6 = Unit.INSTANCE;
                        n32 = n35;
                        n33 = 1;
                    }
                    else {
                        final byte b8 = array[i + 2];
                        if ((b8 & 0xC0) != 0x80) {
                            final int n38 = 65533;
                            final int n39 = n27;
                            final int n40 = n38;
                            final int n41 = n3;
                            n3 = n41 + 1;
                            if (n41 == n) {
                                return n2;
                            }
                            if ((n40 != 10 && n40 != 13 && ((0 <= n40 && n40 < 32) || (127 <= n40 && n40 < 160))) || n40 == 65533) {
                                return -1;
                            }
                            n2 += ((n40 < 65536) ? 1 : 2);
                            final Unit instance7 = Unit.INSTANCE;
                            n32 = n39;
                            n33 = 2;
                        }
                        else {
                            final int n42 = 0xFFFE1F80 ^ b8 ^ b7 << 6 ^ b6 << 12;
                            if (n42 < 2048) {
                                final int n43 = 65533;
                                final int n44 = n27;
                                final int n45 = n43;
                                final int n46 = n3;
                                n3 = n46 + 1;
                                if (n46 == n) {
                                    return n2;
                                }
                                if ((n45 != 10 && n45 != 13 && ((0 <= n45 && n45 < 32) || (127 <= n45 && n45 < 160))) || n45 == 65533) {
                                    return -1;
                                }
                                n2 += ((n45 < 65536) ? 1 : 2);
                                final Unit instance8 = Unit.INSTANCE;
                                n32 = n44;
                            }
                            else if (55296 <= n42 && n42 < 57344) {
                                final int n47 = 65533;
                                final int n48 = n27;
                                final int n49 = n47;
                                final int n50 = n3;
                                n3 = n50 + 1;
                                if (n50 == n) {
                                    return n2;
                                }
                                if ((n49 != 10 && n49 != 13 && ((0 <= n49 && n49 < 32) || (127 <= n49 && n49 < 160))) || n49 == 65533) {
                                    return -1;
                                }
                                n2 += ((n49 < 65536) ? 1 : 2);
                                final Unit instance9 = Unit.INSTANCE;
                                n32 = n48;
                            }
                            else {
                                final int n51 = n42;
                                final int n52 = n27;
                                final int n53 = n51;
                                final int n54 = n3;
                                n3 = n54 + 1;
                                if (n54 == n) {
                                    return n2;
                                }
                                if ((n53 != 10 && n53 != 13 && ((0 <= n53 && n53 < 32) || (127 <= n53 && n53 < 160))) || n53 == 65533) {
                                    return -1;
                                }
                                n2 += ((n53 < 65536) ? 1 : 2);
                                final Unit instance10 = Unit.INSTANCE;
                                n32 = n52;
                            }
                            n33 = 3;
                        }
                    }
                }
                i = n32 + n33;
            }
            else if (b >> 3 == -2) {
                final int n55 = i;
                int n60;
                int n61;
                if (length <= i + 3) {
                    final int n56 = 65533;
                    final int n57 = n55;
                    final int n58 = n56;
                    final int n59 = n3;
                    n3 = n59 + 1;
                    if (n59 == n) {
                        return n2;
                    }
                    if ((n58 != 10 && n58 != 13 && ((0 <= n58 && n58 < 32) || (127 <= n58 && n58 < 160))) || n58 == 65533) {
                        return -1;
                    }
                    n2 += ((n58 < 65536) ? 1 : 2);
                    final Unit instance11 = Unit.INSTANCE;
                    n60 = n57;
                    n61 = ((length <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : ((length <= i + 2 || (array[i + 2] & 0xC0) != 0x80) ? 2 : 3));
                }
                else {
                    final byte b9 = array[i];
                    final byte b10 = array[i + 1];
                    if ((b10 & 0xC0) != 0x80) {
                        final int n62 = 65533;
                        final int n63 = n55;
                        final int n64 = n62;
                        final int n65 = n3;
                        n3 = n65 + 1;
                        if (n65 == n) {
                            return n2;
                        }
                        if ((n64 != 10 && n64 != 13 && ((0 <= n64 && n64 < 32) || (127 <= n64 && n64 < 160))) || n64 == 65533) {
                            return -1;
                        }
                        n2 += ((n64 < 65536) ? 1 : 2);
                        final Unit instance12 = Unit.INSTANCE;
                        n60 = n63;
                        n61 = 1;
                    }
                    else {
                        final byte b11 = array[i + 2];
                        if ((b11 & 0xC0) != 0x80) {
                            final int n66 = 65533;
                            final int n67 = n55;
                            final int n68 = n66;
                            final int n69 = n3;
                            n3 = n69 + 1;
                            if (n69 == n) {
                                return n2;
                            }
                            if ((n68 != 10 && n68 != 13 && ((0 <= n68 && n68 < 32) || (127 <= n68 && n68 < 160))) || n68 == 65533) {
                                return -1;
                            }
                            n2 += ((n68 < 65536) ? 1 : 2);
                            final Unit instance13 = Unit.INSTANCE;
                            n60 = n67;
                            n61 = 2;
                        }
                        else {
                            final byte b12 = array[i + 3];
                            if ((b12 & 0xC0) != 0x80) {
                                final int n70 = 65533;
                                final int n71 = n55;
                                final int n72 = n70;
                                final int n73 = n3;
                                n3 = n73 + 1;
                                if (n73 == n) {
                                    return n2;
                                }
                                if ((n72 != 10 && n72 != 13 && ((0 <= n72 && n72 < 32) || (127 <= n72 && n72 < 160))) || n72 == 65533) {
                                    return -1;
                                }
                                n2 += ((n72 < 65536) ? 1 : 2);
                                final Unit instance14 = Unit.INSTANCE;
                                n60 = n71;
                                n61 = 3;
                            }
                            else {
                                final int n74 = 0x381F80 ^ b12 ^ b11 << 6 ^ b10 << 12 ^ b9 << 18;
                                if (n74 > 1114111) {
                                    final int n75 = 65533;
                                    final int n76 = n55;
                                    final int n77 = n75;
                                    final int n78 = n3;
                                    n3 = n78 + 1;
                                    if (n78 == n) {
                                        return n2;
                                    }
                                    if ((n77 != 10 && n77 != 13 && ((0 <= n77 && n77 < 32) || (127 <= n77 && n77 < 160))) || n77 == 65533) {
                                        return -1;
                                    }
                                    n2 += ((n77 < 65536) ? 1 : 2);
                                    final Unit instance15 = Unit.INSTANCE;
                                    n60 = n76;
                                }
                                else if (55296 <= n74 && n74 < 57344) {
                                    final int n79 = 65533;
                                    final int n80 = n55;
                                    final int n81 = n79;
                                    final int n82 = n3;
                                    n3 = n82 + 1;
                                    if (n82 == n) {
                                        return n2;
                                    }
                                    if ((n81 != 10 && n81 != 13 && ((0 <= n81 && n81 < 32) || (127 <= n81 && n81 < 160))) || n81 == 65533) {
                                        return -1;
                                    }
                                    n2 += ((n81 < 65536) ? 1 : 2);
                                    final Unit instance16 = Unit.INSTANCE;
                                    n60 = n80;
                                }
                                else if (n74 < 65536) {
                                    final int n83 = 65533;
                                    final int n84 = n55;
                                    final int n85 = n83;
                                    final int n86 = n3;
                                    n3 = n86 + 1;
                                    if (n86 == n) {
                                        return n2;
                                    }
                                    if ((n85 != 10 && n85 != 13 && ((0 <= n85 && n85 < 32) || (127 <= n85 && n85 < 160))) || n85 == 65533) {
                                        return -1;
                                    }
                                    n2 += ((n85 < 65536) ? 1 : 2);
                                    final Unit instance17 = Unit.INSTANCE;
                                    n60 = n84;
                                }
                                else {
                                    final int n87 = n74;
                                    final int n88 = n55;
                                    final int n89 = n87;
                                    final int n90 = n3;
                                    n3 = n90 + 1;
                                    if (n90 == n) {
                                        return n2;
                                    }
                                    if ((n89 != 10 && n89 != 13 && ((0 <= n89 && n89 < 32) || (127 <= n89 && n89 < 160))) || n89 == 65533) {
                                        return -1;
                                    }
                                    n2 += ((n89 < 65536) ? 1 : 2);
                                    final Unit instance18 = Unit.INSTANCE;
                                    n60 = n88;
                                }
                                n61 = 4;
                            }
                        }
                    }
                }
                i = n60 + n61;
            }
            else {
                final int n91 = 65533;
                final int n92 = n3;
                n3 = n92 + 1;
                if (n92 == n) {
                    return n2;
                }
                if ((n91 != 10 && n91 != 13 && ((0 <= n91 && n91 < 32) || (127 <= n91 && n91 < 160))) || n91 == 65533) {
                    return -1;
                }
                n2 += ((n91 < 65536) ? 1 : 2);
                ++i;
            }
        }
        return n2;
    }
    
    static {
        HEX_DIGIT_CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
}
