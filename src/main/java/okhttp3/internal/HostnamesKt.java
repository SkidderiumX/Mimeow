/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003\u00a8\u0006\u000f"}, d2={"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"})
public class HostnamesKt {
    @Nullable
    public static final String toCanonicalHost(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        String string2 = string;
        if (StringsKt.contains$default((CharSequence)string2, ":", false, 2, null)) {
            InetAddress inetAddress = StringsKt.startsWith$default(string2, "[", false, 2, null) && StringsKt.endsWith$default(string2, "]", false, 2, null) ? HostnamesKt.decodeIpv6(string2, 1, string2.length() - 1) : HostnamesKt.decodeIpv6(string2, 0, string2.length());
            if (inetAddress == null) {
                return null;
            }
            InetAddress inetAddress2 = inetAddress;
            byte[] byArray = inetAddress2.getAddress();
            if (byArray.length == 16) {
                Intrinsics.checkNotNullExpressionValue(byArray, "address");
                return HostnamesKt.inet6AddressToAscii(byArray);
            }
            if (byArray.length == 4) {
                return inetAddress2.getHostAddress();
            }
            throw new AssertionError((Object)("Invalid IPv6 address: '" + string2 + '\''));
        }
        try {
            String string3 = IDN.toASCII(string2);
            Intrinsics.checkNotNullExpressionValue(string3, "toASCII(host)");
            String string4 = string3;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String string5 = string4.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(string5, "this as java.lang.String).toLowerCase(locale)");
            String string6 = string5;
            if (((CharSequence)string6).length() == 0) {
                return null;
            }
            return HostnamesKt.containsInvalidHostnameAsciiCodes(string6) ? null : string6;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    private static final boolean containsInvalidHostnameAsciiCodes(String string) {
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (Intrinsics.compare(c, 31) <= 0 || Intrinsics.compare(c, 127) >= 0) {
                return true;
            }
            if (StringsKt.indexOf$default((CharSequence)" #%/:?@[\\]", c, 0, false, 6, null) == -1) continue;
            return true;
        }
        return false;
    }

    private static final InetAddress decodeIpv6(String string, int n, int n2) {
        byte[] byArray = new byte[16];
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        int n6 = n;
        while (n6 < n2) {
            int n7;
            if (n3 == byArray.length) {
                return null;
            }
            if (n6 + 2 <= n2 && StringsKt.startsWith$default(string, "::", n6, false, 4, null)) {
                if (n4 != -1) {
                    return null;
                }
                n4 = n3 += 2;
                if ((n6 += 2) == n2) {
                    break;
                }
            } else if (n3 != 0 && !StringsKt.startsWith$default(string, ":", n6, false, 4, null)) {
                if (StringsKt.startsWith$default(string, ".", n6, false, 4, null)) {
                    if (!HostnamesKt.decodeIpv4Suffix(string, n5, n2, byArray, n3 - 2)) {
                        return null;
                    }
                    n3 += 2;
                    break;
                }
                return null;
            }
            int n8 = 0;
            n5 = ++n6;
            while (n6 < n2 && (n7 = Util.parseHexDigit(string.charAt(n6))) != -1) {
                n8 = (n8 << 4) + n7;
                ++n6;
            }
            n7 = n6 - n5;
            if (n7 == 0 || n7 > 4) {
                return null;
            }
            byArray[n3++] = (byte)(n8 >>> 8 & 0xFF);
            byArray[n3++] = (byte)(n8 & 0xFF);
        }
        if (n3 != byArray.length) {
            if (n4 == -1) {
                return null;
            }
            System.arraycopy(byArray, n4, byArray, byArray.length - (n3 - n4), n3 - n4);
            Arrays.fill(byArray, n4, n4 + (byArray.length - n3), (byte)0);
        }
        return InetAddress.getByAddress(byArray);
    }

    private static final boolean decodeIpv4Suffix(String string, int n, int n2, byte[] byArray, int n3) {
        int n4 = n3;
        int n5 = n;
        while (n5 < n2) {
            int n6;
            if (n4 == byArray.length) {
                return false;
            }
            if (n4 != n3 && string.charAt(n5) != '.') {
                return false;
            }
            int n7 = 0;
            int n8 = ++n5;
            while (n5 < n2 && Intrinsics.compare(n6 = string.charAt(n5), 48) >= 0 && Intrinsics.compare(n6, 57) <= 0) {
                if (n7 == 0 && n8 != n5) {
                    return false;
                }
                if ((n7 = n7 * 10 + n6 - 48) > 255) {
                    return false;
                }
                ++n5;
            }
            n6 = n5 - n8;
            if (n6 == 0) {
                return false;
            }
            byArray[n4++] = (byte)n7;
        }
        return n4 == n3 + 4;
    }

    private static final String inet6AddressToAscii(byte[] byArray) {
        int n;
        int n2;
        int n3 = 0;
        n3 = -1;
        int n4 = 0;
        boolean bl = false;
        for (n2 = 0; n2 < byArray.length; n2 += 2) {
            n = n2;
            while (n2 < 16 && byArray[n2] == 0 && byArray[n2 + 1] == 0) {
                n2 += 2;
            }
            int n5 = n2 - n;
            if (n5 <= n4 || n5 < 4) continue;
            n3 = n;
            n4 = n5;
        }
        Buffer buffer = new Buffer();
        n2 = 0;
        while (n2 < byArray.length) {
            if (n2 == n3) {
                buffer.writeByte(58);
                if ((n2 += n4) != 16) continue;
                buffer.writeByte(58);
                continue;
            }
            if (n2 > 0) {
                buffer.writeByte(58);
            }
            n = Util.and(byArray[n2], 255) << 8 | Util.and(byArray[n2 + 1], 255);
            buffer.writeHexadecimalUnsignedLong(n);
            n2 += 2;
        }
        return buffer.readUtf8();
    }
}

