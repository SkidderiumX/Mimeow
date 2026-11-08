package okio.internal;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.*;
import kotlin.text.*;
import java.util.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007" }, d2 = { "commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio" })
@SourceDebugExtension({ "SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n68#3:77\n74#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n" })
public class _Utf8Kt
{
    @NotNull
    public static final String commonToUtf8String(@NotNull final byte[] array, final int i, final int j) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        if (i < 0 || j > array.length || i > j) {
            throw new ArrayIndexOutOfBoundsException("size=" + array.length + " beginIndex=" + i + " endIndex=" + j);
        }
        final char[] array2 = new char[j - i];
        int n = 0;
        int k = i;
        while (k < j) {
            final byte b = array[k];
            if (b >= 0) {
                final char c = (char)b;
                final char[] array3 = array2;
                final int n2 = n;
                n = n2 + 1;
                array3[n2] = c;
                ++k;
                while (k < j && array[k] >= 0) {
                    final char c2 = (char)array[k++];
                    final char[] array4 = array2;
                    final int n3 = n;
                    n = n3 + 1;
                    array4[n3] = c2;
                }
            }
            else if (b >> 5 == -2) {
                final int n4 = k;
                int n8;
                int n9;
                if (j <= k + 1) {
                    final int n5 = 65533;
                    final int n6 = n4;
                    final char c3 = (char)n5;
                    final char[] array5 = array2;
                    final int n7 = n;
                    n = n7 + 1;
                    array5[n7] = c3;
                    final Unit instance = Unit.INSTANCE;
                    n8 = n6;
                    n9 = 1;
                }
                else {
                    final byte b2 = array[k];
                    final byte b3 = array[k + 1];
                    if ((b3 & 0xC0) != 0x80) {
                        final int n10 = 65533;
                        final int n11 = n4;
                        final char c4 = (char)n10;
                        final char[] array6 = array2;
                        final int n12 = n;
                        n = n12 + 1;
                        array6[n12] = c4;
                        final Unit instance2 = Unit.INSTANCE;
                        n8 = n11;
                        n9 = 1;
                    }
                    else {
                        final int n13 = 0xF80 ^ b3 ^ b2 << 6;
                        if (n13 < 128) {
                            final int n14 = 65533;
                            final int n15 = n4;
                            final char c5 = (char)n14;
                            final char[] array7 = array2;
                            final int n16 = n;
                            n = n16 + 1;
                            array7[n16] = c5;
                            final Unit instance3 = Unit.INSTANCE;
                            n8 = n15;
                        }
                        else {
                            final int n17 = n13;
                            final int n18 = n4;
                            final char c6 = (char)n17;
                            final char[] array8 = array2;
                            final int n19 = n;
                            n = n19 + 1;
                            array8[n19] = c6;
                            final Unit instance4 = Unit.INSTANCE;
                            n8 = n18;
                        }
                        n9 = 2;
                    }
                }
                k = n8 + n9;
            }
            else if (b >> 4 == -2) {
                final int n20 = k;
                int n24;
                int n25;
                if (j <= k + 2) {
                    final int n21 = 65533;
                    final int n22 = n20;
                    final char c7 = (char)n21;
                    final char[] array9 = array2;
                    final int n23 = n;
                    n = n23 + 1;
                    array9[n23] = c7;
                    final Unit instance5 = Unit.INSTANCE;
                    n24 = n22;
                    n25 = ((j <= k + 1 || (array[k + 1] & 0xC0) != 0x80) ? 1 : 2);
                }
                else {
                    final byte b4 = array[k];
                    final byte b5 = array[k + 1];
                    if ((b5 & 0xC0) != 0x80) {
                        final int n26 = 65533;
                        final int n27 = n20;
                        final char c8 = (char)n26;
                        final char[] array10 = array2;
                        final int n28 = n;
                        n = n28 + 1;
                        array10[n28] = c8;
                        final Unit instance6 = Unit.INSTANCE;
                        n24 = n27;
                        n25 = 1;
                    }
                    else {
                        final byte b6 = array[k + 2];
                        if ((b6 & 0xC0) != 0x80) {
                            final int n29 = 65533;
                            final int n30 = n20;
                            final char c9 = (char)n29;
                            final char[] array11 = array2;
                            final int n31 = n;
                            n = n31 + 1;
                            array11[n31] = c9;
                            final Unit instance7 = Unit.INSTANCE;
                            n24 = n30;
                            n25 = 2;
                        }
                        else {
                            final int n32 = 0xFFFE1F80 ^ b6 ^ b5 << 6 ^ b4 << 12;
                            if (n32 < 2048) {
                                final int n33 = 65533;
                                final int n34 = n20;
                                final char c10 = (char)n33;
                                final char[] array12 = array2;
                                final int n35 = n;
                                n = n35 + 1;
                                array12[n35] = c10;
                                final Unit instance8 = Unit.INSTANCE;
                                n24 = n34;
                            }
                            else if (55296 <= n32 && n32 < 57344) {
                                final int n36 = 65533;
                                final int n37 = n20;
                                final char c11 = (char)n36;
                                final char[] array13 = array2;
                                final int n38 = n;
                                n = n38 + 1;
                                array13[n38] = c11;
                                final Unit instance9 = Unit.INSTANCE;
                                n24 = n37;
                            }
                            else {
                                final int n39 = n32;
                                final int n40 = n20;
                                final char c12 = (char)n39;
                                final char[] array14 = array2;
                                final int n41 = n;
                                n = n41 + 1;
                                array14[n41] = c12;
                                final Unit instance10 = Unit.INSTANCE;
                                n24 = n40;
                            }
                            n25 = 3;
                        }
                    }
                }
                k = n24 + n25;
            }
            else if (b >> 3 == -2) {
                final int n42 = k;
                int n50;
                int n51;
                if (j <= k + 3) {
                    final int n43 = 65533;
                    final int n44 = n42;
                    if (n43 != 65533) {
                        final char c13 = (char)((n43 >>> 10) + 55232);
                        final char[] array15 = array2;
                        final int n45 = n;
                        final int n46 = n45 + 1;
                        array15[n45] = c13;
                        final char c14 = (char)((n43 & 0x3FF) + 56320);
                        final char[] array16 = array2;
                        final int n47 = n46;
                        n = n47 + 1;
                        array16[n47] = c14;
                    }
                    else {
                        final int n48 = '\ufffd';
                        final char[] array17 = array2;
                        final int n49 = n;
                        n = n49 + 1;
                        array17[n49] = (char)n48;
                    }
                    final Unit instance11 = Unit.INSTANCE;
                    n50 = n44;
                    n51 = ((j <= k + 1 || (array[k + 1] & 0xC0) != 0x80) ? 1 : ((j <= k + 2 || (array[k + 2] & 0xC0) != 0x80) ? 2 : 3));
                }
                else {
                    final byte b7 = array[k];
                    final byte b8 = array[k + 1];
                    if ((b8 & 0xC0) != 0x80) {
                        final int n52 = 65533;
                        final int n53 = n42;
                        if (n52 != 65533) {
                            final char c15 = (char)((n52 >>> 10) + 55232);
                            final char[] array18 = array2;
                            final int n54 = n;
                            final int n55 = n54 + 1;
                            array18[n54] = c15;
                            final char c16 = (char)((n52 & 0x3FF) + 56320);
                            final char[] array19 = array2;
                            final int n56 = n55;
                            n = n56 + 1;
                            array19[n56] = c16;
                        }
                        else {
                            final int n57 = '\ufffd';
                            final char[] array20 = array2;
                            final int n58 = n;
                            n = n58 + 1;
                            array20[n58] = (char)n57;
                        }
                        final Unit instance12 = Unit.INSTANCE;
                        n50 = n53;
                        n51 = 1;
                    }
                    else {
                        final byte b9 = array[k + 2];
                        if ((b9 & 0xC0) != 0x80) {
                            final int n59 = 65533;
                            final int n60 = n42;
                            if (n59 != 65533) {
                                final char c17 = (char)((n59 >>> 10) + 55232);
                                final char[] array21 = array2;
                                final int n61 = n;
                                final int n62 = n61 + 1;
                                array21[n61] = c17;
                                final char c18 = (char)((n59 & 0x3FF) + 56320);
                                final char[] array22 = array2;
                                final int n63 = n62;
                                n = n63 + 1;
                                array22[n63] = c18;
                            }
                            else {
                                final int n64 = '\ufffd';
                                final char[] array23 = array2;
                                final int n65 = n;
                                n = n65 + 1;
                                array23[n65] = (char)n64;
                            }
                            final Unit instance13 = Unit.INSTANCE;
                            n50 = n60;
                            n51 = 2;
                        }
                        else {
                            final byte b10 = array[k + 3];
                            if ((b10 & 0xC0) != 0x80) {
                                final int n66 = 65533;
                                final int n67 = n42;
                                if (n66 != 65533) {
                                    final char c19 = (char)((n66 >>> 10) + 55232);
                                    final char[] array24 = array2;
                                    final int n68 = n;
                                    final int n69 = n68 + 1;
                                    array24[n68] = c19;
                                    final char c20 = (char)((n66 & 0x3FF) + 56320);
                                    final char[] array25 = array2;
                                    final int n70 = n69;
                                    n = n70 + 1;
                                    array25[n70] = c20;
                                }
                                else {
                                    final int n71 = '\ufffd';
                                    final char[] array26 = array2;
                                    final int n72 = n;
                                    n = n72 + 1;
                                    array26[n72] = (char)n71;
                                }
                                final Unit instance14 = Unit.INSTANCE;
                                n50 = n67;
                                n51 = 3;
                            }
                            else {
                                final int n73 = 0x381F80 ^ b10 ^ b9 << 6 ^ b8 << 12 ^ b7 << 18;
                                if (n73 > 1114111) {
                                    final int n74 = 65533;
                                    final int n75 = n42;
                                    if (n74 != 65533) {
                                        final char c21 = (char)((n74 >>> 10) + 55232);
                                        final char[] array27 = array2;
                                        final int n76 = n;
                                        final int n77 = n76 + 1;
                                        array27[n76] = c21;
                                        final char c22 = (char)((n74 & 0x3FF) + 56320);
                                        final char[] array28 = array2;
                                        final int n78 = n77;
                                        n = n78 + 1;
                                        array28[n78] = c22;
                                    }
                                    else {
                                        final int n79 = '\ufffd';
                                        final char[] array29 = array2;
                                        final int n80 = n;
                                        n = n80 + 1;
                                        array29[n80] = (char)n79;
                                    }
                                    final Unit instance15 = Unit.INSTANCE;
                                    n50 = n75;
                                }
                                else if (55296 <= n73 && n73 < 57344) {
                                    final int n81 = 65533;
                                    final int n82 = n42;
                                    if (n81 != 65533) {
                                        final char c23 = (char)((n81 >>> 10) + 55232);
                                        final char[] array30 = array2;
                                        final int n83 = n;
                                        final int n84 = n83 + 1;
                                        array30[n83] = c23;
                                        final char c24 = (char)((n81 & 0x3FF) + 56320);
                                        final char[] array31 = array2;
                                        final int n85 = n84;
                                        n = n85 + 1;
                                        array31[n85] = c24;
                                    }
                                    else {
                                        final int n86 = '\ufffd';
                                        final char[] array32 = array2;
                                        final int n87 = n;
                                        n = n87 + 1;
                                        array32[n87] = (char)n86;
                                    }
                                    final Unit instance16 = Unit.INSTANCE;
                                    n50 = n82;
                                }
                                else if (n73 < 65536) {
                                    final int n88 = 65533;
                                    final int n89 = n42;
                                    if (n88 != 65533) {
                                        final char c25 = (char)((n88 >>> 10) + 55232);
                                        final char[] array33 = array2;
                                        final int n90 = n;
                                        final int n91 = n90 + 1;
                                        array33[n90] = c25;
                                        final char c26 = (char)((n88 & 0x3FF) + 56320);
                                        final char[] array34 = array2;
                                        final int n92 = n91;
                                        n = n92 + 1;
                                        array34[n92] = c26;
                                    }
                                    else {
                                        final int n93 = '\ufffd';
                                        final char[] array35 = array2;
                                        final int n94 = n;
                                        n = n94 + 1;
                                        array35[n94] = (char)n93;
                                    }
                                    final Unit instance17 = Unit.INSTANCE;
                                    n50 = n89;
                                }
                                else {
                                    final int n95 = n73;
                                    final int n96 = n42;
                                    if (n95 != 65533) {
                                        final char c27 = (char)((n95 >>> 10) + 55232);
                                        final char[] array36 = array2;
                                        final int n97 = n;
                                        final int n98 = n97 + 1;
                                        array36[n97] = c27;
                                        final char c28 = (char)((n95 & 0x3FF) + 56320);
                                        final char[] array37 = array2;
                                        final int n99 = n98;
                                        n = n99 + 1;
                                        array37[n99] = c28;
                                    }
                                    else {
                                        final int n100 = '\ufffd';
                                        final char[] array38 = array2;
                                        final int n101 = n;
                                        n = n101 + 1;
                                        array38[n101] = (char)n100;
                                    }
                                    final Unit instance18 = Unit.INSTANCE;
                                    n50 = n96;
                                }
                                n51 = 4;
                            }
                        }
                    }
                }
                k = n50 + n51;
            }
            else {
                final int n102 = '\ufffd';
                final char[] array39 = array2;
                final int n103 = n;
                n = n103 + 1;
                array39[n103] = (char)n102;
                ++k;
            }
        }
        return StringsKt__StringsJVMKt.concatToString(array2, 0, n);
    }
    
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        final byte[] array = new byte[4 * s.length()];
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (Intrinsics.compare(char1, 128) >= 0) {
                int newLength = i;
                final int length = s.length();
                int j = i;
                while (j < length) {
                    final char char2 = s.charAt(j);
                    if (Intrinsics.compare(char2, 128) < 0) {
                        final byte b = (byte)char2;
                        final byte[] array2 = array;
                        final int n = newLength;
                        newLength = n + 1;
                        array2[n] = b;
                        ++j;
                        while (j < length && Intrinsics.compare(s.charAt(j), 128) < 0) {
                            final byte b2 = (byte)s.charAt(j++);
                            final byte[] array3 = array;
                            final int n2 = newLength;
                            newLength = n2 + 1;
                            array3[n2] = b2;
                        }
                    }
                    else if (Intrinsics.compare(char2, 2048) < 0) {
                        final byte b3 = (byte)(char2 >> 6 | 0xC0);
                        final byte[] array4 = array;
                        final int n3 = newLength;
                        final int n4 = n3 + 1;
                        array4[n3] = b3;
                        final byte b4 = (byte)((char2 & '?') | 0x80);
                        final byte[] array5 = array;
                        final int n5 = n4;
                        newLength = n5 + 1;
                        array5[n5] = b4;
                        ++j;
                    }
                    else if ('\ud800' > char2 || char2 >= '\ue000') {
                        final byte b5 = (byte)(char2 >> 12 | 0xE0);
                        final byte[] array6 = array;
                        final int n6 = newLength;
                        final int n7 = n6 + 1;
                        array6[n6] = b5;
                        final byte b6 = (byte)((char2 >> 6 & 0x3F) | 0x80);
                        final byte[] array7 = array;
                        final int n8 = n7;
                        final int n9 = n8 + 1;
                        array7[n8] = b6;
                        final byte b7 = (byte)((char2 & '?') | 0x80);
                        final byte[] array8 = array;
                        final int n10 = n9;
                        newLength = n10 + 1;
                        array8[n10] = b7;
                        ++j;
                    }
                    else {
                        if (Intrinsics.compare(char2, 56319) <= 0 && length > j + 1) {
                            final char char3 = s.charAt(j + 1);
                            if ('\udc00' <= char3 && char3 < '\ue000') {
                                final int n11 = (char2 << 10) + s.charAt(j + 1) - 56613888;
                                final byte b8 = (byte)(n11 >> 18 | 0xF0);
                                final byte[] array9 = array;
                                final int n12 = newLength;
                                final int n13 = n12 + 1;
                                array9[n12] = b8;
                                final byte b9 = (byte)((n11 >> 12 & 0x3F) | 0x80);
                                final byte[] array10 = array;
                                final int n14 = n13;
                                final int n15 = n14 + 1;
                                array10[n14] = b9;
                                final byte b10 = (byte)((n11 >> 6 & 0x3F) | 0x80);
                                final byte[] array11 = array;
                                final int n16 = n15;
                                final int n17 = n16 + 1;
                                array11[n16] = b10;
                                final byte b11 = (byte)((n11 & 0x3F) | 0x80);
                                final byte[] array12 = array;
                                final int n18 = n17;
                                newLength = n18 + 1;
                                array12[n18] = b11;
                                j += 2;
                                continue;
                            }
                        }
                        final int n19 = 63;
                        final byte[] array13 = array;
                        final int n20 = newLength;
                        newLength = n20 + 1;
                        array13[n20] = (byte)n19;
                        ++j;
                    }
                }
                final byte[] copy = Arrays.copyOf(array, newLength);
                Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, newSize)");
                return copy;
            }
            array[i] = (byte)char1;
        }
        final byte[] copy2 = Arrays.copyOf(array, s.length());
        Intrinsics.checkNotNullExpressionValue(copy2, "copyOf(this, newSize)");
        return copy2;
    }
}
