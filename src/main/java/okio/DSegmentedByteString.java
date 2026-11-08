/*
 * Decompiled with CFR 0.152.
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio.internal.DByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0015H\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0015*\u00020\u0015H\u0000\u001a\f\u0010\"\u001a\u00020#*\u00020#H\u0000\u001a\u0015\u0010$\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010&\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\f\u0010'\u001a\u00020(*\u00020\u001bH\u0000\u001a\f\u0010'\u001a\u00020(*\u00020\u0001H\u0000\u001a\f\u0010'\u001a\u00020(*\u00020\u0015H\u0000\u001a\u0015\u0010)\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0080\f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006*"}, d2={"DEFAULT__ByteString_size", "", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "arrayRangeEquals", "", "a", "", "aOffset", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "resolveDefaultParameter", "unsafeCursor", "and", "", "other", "leftRotate", "bitCount", "sizeParam", "Lokio/ByteString;", "position", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"})
@JvmName(name="DSegmentedByteString")
@SourceDebugExtension(value={"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,187:1\n68#1:188\n74#1:189\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokio/DSegmentedByteString\n*L\n106#1:188\n107#1:189\n*E\n"})
public class DSegmentedByteString {
    @NotNull
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final void checkOffsetAndCount(long l, long l2, long l3) {
        if ((l2 | l3) < 0L || l2 > l || l - l2 < l3) {
            throw new ArrayIndexOutOfBoundsException("size=" + l + " offset=" + l2 + " byteCount=" + l3);
        }
    }

    public static final short reverseBytes(short s) {
        int n = s & 0xFFFF;
        int n2 = (n & 0xFF00) >>> 8 | (n & 0xFF) << 8;
        return (short)n2;
    }

    public static final int reverseBytes(int n) {
        return (n & 0xFF000000) >>> 24 | (n & 0xFF0000) >>> 8 | (n & 0xFF00) << 8 | (n & 0xFF) << 24;
    }

    public static final long reverseBytes(long l) {
        return (l & 0xFF00000000000000L) >>> 56 | (l & 0xFF000000000000L) >>> 40 | (l & 0xFF0000000000L) >>> 24 | (l & 0xFF00000000L) >>> 8 | (l & 0xFF000000L) << 8 | (l & 0xFF0000L) << 24 | (l & 0xFF00L) << 40 | (l & 0xFFL) << 56;
    }

    public static final int leftRotate(int n, int n2) {
        boolean bl = false;
        return n << n2 | n >>> 32 - n2;
    }

    public static final long rightRotate(long l, int n) {
        boolean bl = false;
        return l >>> n | l << 64 - n;
    }

    public static final int shr(byte by, int n) {
        boolean bl = false;
        return by >> n;
    }

    public static final int shl(byte by, int n) {
        boolean bl = false;
        return by << n;
    }

    public static final int and(byte by, int n) {
        boolean bl = false;
        return by & n;
    }

    public static final long and(byte by, long l) {
        boolean bl = false;
        return (long)by & l;
    }

    public static final byte xor(byte by, byte by2) {
        boolean bl = false;
        return (byte)(by ^ by2);
    }

    public static final long and(int n, long l) {
        boolean bl = false;
        return (long)n & l;
    }

    public static final long minOf(long l, int n) {
        boolean bl = false;
        return Math.min(l, (long)n);
    }

    public static final long minOf(int n, long l) {
        boolean bl = false;
        return Math.min((long)n, l);
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] byArray, int n, @NotNull byte[] byArray2, int n2, int n3) {
        Intrinsics.checkNotNullParameter(byArray, "a");
        Intrinsics.checkNotNullParameter(byArray2, "b");
        for (int i = 0; i < n3; ++i) {
            if (byArray[i + n] == byArray2[i + n2]) continue;
            return false;
        }
        return true;
    }

    @NotNull
    public static final String toHexString(byte by) {
        char[] cArray = new char[2];
        byte by2 = by;
        int n = 4;
        boolean bl = false;
        cArray[0] = DByteString.getHEX_DIGIT_CHARS()[by2 >> n & 0xF];
        by2 = by;
        n = 15;
        bl = false;
        cArray[1] = DByteString.getHEX_DIGIT_CHARS()[by2 & n];
        return StringsKt.concatToString(cArray);
    }

    @NotNull
    public static final String toHexString(int n) {
        int n2;
        if (n == 0) {
            return "0";
        }
        char[] cArray = new char[]{DByteString.getHEX_DIGIT_CHARS()[n >> 28 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 24 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 20 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 16 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 12 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 8 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n >> 4 & 0xF], DByteString.getHEX_DIGIT_CHARS()[n & 0xF]};
        for (n2 = 0; n2 < cArray.length && cArray[n2] == '0'; ++n2) {
        }
        return StringsKt.concatToString(cArray, n2, cArray.length);
    }

    @NotNull
    public static final String toHexString(long l) {
        int n;
        if (l == 0L) {
            return "0";
        }
        char[] cArray = new char[]{DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 60 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 56 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 52 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 48 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 44 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 40 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 36 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 32 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 28 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 24 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 20 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 16 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 12 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 8 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l >> 4 & 0xFL)], DByteString.getHEX_DIGIT_CHARS()[(int)(l & 0xFL)]};
        for (n = 0; n < cArray.length && cArray[n] == '0'; ++n) {
        }
        return StringsKt.concatToString(cArray, n, cArray.length);
    }

    @NotNull
    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    @NotNull
    public static final Buffer.UnsafeCursor resolveDefaultParameter(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor == DEFAULT__new_UnsafeCursor) {
            return new Buffer.UnsafeCursor();
        }
        return unsafeCursor;
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final int resolveDefaultParameter(@NotNull ByteString byteString, int n) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (n == DEFAULT__ByteString_size) {
            return byteString.size();
        }
        return n;
    }

    public static final int resolveDefaultParameter(@NotNull byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter(byArray, "<this>");
        if (n == DEFAULT__ByteString_size) {
            return byArray.length;
        }
        return n;
    }
}

