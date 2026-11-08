/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio._JvmPlatformKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\r"}, d2={"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"})
@JvmName(name="DBase64")
public class DBase64 {
    @NotNull
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    @NotNull
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String string) {
        int n;
        char c;
        int n2;
        Intrinsics.checkNotNullParameter(string, "<this>");
        for (n2 = string.length(); n2 > 0 && ((c = string.charAt(n2 - 1)) == '=' || c == '\n' || c == '\r' || c == ' ' || c == '\t'); --n2) {
        }
        byte[] byArray = new byte[(int)((long)n2 * 6L / 8L)];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = n2;
        for (n = 0; n < n6; ++n) {
            char c2 = string.charAt(n);
            int n7 = 0;
            boolean bl = 'A' <= c2 ? c2 < '[' : false;
            if (bl) {
                n7 = c2 - 65;
            } else {
                boolean bl2 = 'a' <= c2 ? c2 < '{' : false;
                if (bl2) {
                    n7 = c2 - 71;
                } else {
                    boolean bl3 = '0' <= c2 ? c2 < ':' : false;
                    if (bl3) {
                        n7 = c2 + 4;
                    } else if (c2 == '+' || c2 == '-') {
                        n7 = 62;
                    } else if (c2 == '/' || c2 == '_') {
                        n7 = 63;
                    } else {
                        if (c2 == '\n' || c2 == '\r' || c2 == ' ' || c2 == '\t') continue;
                        return null;
                    }
                }
            }
            n5 = n5 << 6 | n7;
            if (++n4 % 4 != 0) continue;
            byArray[n3++] = (byte)(n5 >> 16);
            byArray[n3++] = (byte)(n5 >> 8);
            byArray[n3++] = (byte)n5;
        }
        n = n4 % 4;
        switch (n) {
            case 1: {
                return null;
            }
            case 2: {
                byArray[n3++] = (byte)((n5 <<= 12) >> 16);
                break;
            }
            case 3: {
                byArray[n3++] = (byte)((n5 <<= 6) >> 16);
                byArray[n3++] = (byte)(n5 >> 8);
            }
        }
        if (n3 == byArray.length) {
            return byArray;
        }
        byte[] byArray2 = Arrays.copyOf(byArray, n3);
        Intrinsics.checkNotNullExpressionValue(byArray2, "copyOf(this, newSize)");
        return byArray2;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] byArray, @NotNull byte[] byArray2) {
        byte by;
        byte by2;
        Intrinsics.checkNotNullParameter(byArray, "<this>");
        Intrinsics.checkNotNullParameter(byArray2, "map");
        int n = (byArray.length + 2) / 3 * 4;
        byte[] byArray3 = new byte[n];
        int n2 = 0;
        int n3 = byArray.length - byArray.length % 3;
        int n4 = 0;
        while (n4 < n3) {
            byte by3 = byArray[n4++];
            by2 = byArray[n4++];
            by = byArray[n4++];
            byArray3[n2++] = byArray2[(by3 & 0xFF) >> 2];
            byArray3[n2++] = byArray2[(by3 & 3) << 4 | (by2 & 0xFF) >> 4];
            byArray3[n2++] = byArray2[(by2 & 0xF) << 2 | (by & 0xFF) >> 6];
            byArray3[n2++] = byArray2[by & 0x3F];
        }
        switch (byArray.length - n3) {
            case 1: {
                by2 = byArray[n4];
                byArray3[n2++] = byArray2[(by2 & 0xFF) >> 2];
                byArray3[n2++] = byArray2[(by2 & 3) << 4];
                byArray3[n2++] = 61;
                byArray3[n2] = 61;
                break;
            }
            case 2: {
                by2 = byArray[n4++];
                by = byArray[n4];
                byArray3[n2++] = byArray2[(by2 & 0xFF) >> 2];
                byArray3[n2++] = byArray2[(by2 & 3) << 4 | (by & 0xFF) >> 4];
                byArray3[n2++] = byArray2[(by & 0xF) << 2];
                byArray3[n2] = 61;
            }
        }
        return _JvmPlatformKt.toUtf8String(byArray3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] byArray, byte[] byArray2, int n, Object object) {
        if ((n & 1) != 0) {
            byArray2 = BASE64;
        }
        return DBase64.encodeBase64(byArray, byArray2);
    }
}

