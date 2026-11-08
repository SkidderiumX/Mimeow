package okio;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.*;
import kotlin.jvm.functions.*;
import kotlin.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 " }, d2 = { "HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio" })
@JvmName(name = "Utf8")
@SourceDebugExtension({ "SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n74#3:561\n68#3:562\n74#3:573\n68#3:594\n74#3:600\n68#3:642\n74#3:648\n68#3:703\n74#3:714\n68#3:735\n74#3:741\n68#3:783\n74#3:789\n74#3:845\n74#3:847\n74#3:849\n74#3:851\n74#3:853\n74#3:855\n74#3:857\n74#3:859\n74#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n" })
public class Utf8
{
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '\ufffd';
    public static final int REPLACEMENT_CODE_POINT = 65533;
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    
    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull final String s, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        if (n < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + n).toString());
        }
        if (n2 < n) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + n2 + " < " + n).toString());
        }
        if (n2 > s.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + n2 + " > " + s.length()).toString());
        }
        long n3 = 0L;
        int i = n;
        while (i < n2) {
            final char char1 = s.charAt(i);
            if (char1 < '\u0080') {
                ++n3;
                ++i;
            }
            else if (char1 < '\u0800') {
                n3 += 2;
                ++i;
            }
            else if (char1 < '\ud800' || char1 > '\udfff') {
                n3 += 3;
                ++i;
            }
            else {
                final char c = (i + 1 < n2) ? s.charAt(i + 1) : '\0';
                if (char1 > '\udbff' || c < '\udc00' || c > '\udfff') {
                    ++n3;
                    ++i;
                }
                else {
                    n3 += 4;
                    i += 2;
                }
            }
        }
        return n3;
    }
    
    public static /* synthetic */ long size$default(final String s, int n, int length, final int n2, final Object o) {
        if ((n2 & 0x1) != 0x0) {
            n = 0;
        }
        if ((n2 & 0x2) != 0x0) {
            length = s.length();
        }
        return size(s, n, length);
    }
    
    public static final boolean isIsoControl(final int n) {
        return (0 <= n && n < 32) || (127 <= n && n < 160);
    }
    
    public static final boolean isUtf8Continuation(final byte b) {
        return (b & 0xC0) == 0x80;
    }
    
    public static final void processUtf8Bytes(@NotNull final String s, final int n, final int n2, @NotNull final Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = n;
        while (i < n2) {
            final char char1 = s.charAt(i);
            if (Intrinsics.compare(char1, 128) < 0) {
                function1.invoke((byte)char1);
                ++i;
                while (i < n2 && Intrinsics.compare(s.charAt(i), 128) < 0) {
                    function1.invoke((byte)s.charAt(i++));
                }
            }
            else if (Intrinsics.compare(char1, 2048) < 0) {
                function1.invoke((byte)(char1 >> 6 | 0xC0));
                function1.invoke((byte)((char1 & '?') | 0x80));
                ++i;
            }
            else if ('\ud800' > char1 || char1 >= '\ue000') {
                function1.invoke((byte)(char1 >> 12 | 0xE0));
                function1.invoke((byte)((char1 >> 6 & 0x3F) | 0x80));
                function1.invoke((byte)((char1 & '?') | 0x80));
                ++i;
            }
            else {
                if (Intrinsics.compare(char1, 56319) <= 0 && n2 > i + 1) {
                    final char char2 = s.charAt(i + 1);
                    if ('\udc00' <= char2 && char2 < '\ue000') {
                        final int n3 = (char1 << 10) + s.charAt(i + 1) - 56613888;
                        function1.invoke((byte)(n3 >> 18 | 0xF0));
                        function1.invoke((byte)((n3 >> 12 & 0x3F) | 0x80));
                        function1.invoke((byte)((n3 >> 6 & 0x3F) | 0x80));
                        function1.invoke((byte)((n3 & 0x3F) | 0x80));
                        i += 2;
                        continue;
                    }
                }
                function1.invoke((Byte)63);
                ++i;
            }
        }
    }
    
    public static final void processUtf8CodePoints(@NotNull final byte[] array, final int n, final int n2, @NotNull final Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = n;
        while (i < n2) {
            final byte j = array[i];
            if (j >= 0) {
                function1.invoke((int)j);
                ++i;
                while (i < n2 && array[i] >= 0) {
                    function1.invoke((int)array[i++]);
                }
            }
            else if (j >> 5 == -2) {
                final int n3 = i;
                int n5;
                int n6;
                if (n2 <= i + 1) {
                    final int k = 65533;
                    final int n4 = n3;
                    function1.invoke(k);
                    final Unit instance = Unit.INSTANCE;
                    n5 = n4;
                    n6 = 1;
                }
                else {
                    final byte b = array[i];
                    final byte b2 = array[i + 1];
                    if ((b2 & 0xC0) != 0x80) {
                        final int l = 65533;
                        final int n7 = n3;
                        function1.invoke(l);
                        final Unit instance2 = Unit.INSTANCE;
                        n5 = n7;
                        n6 = 1;
                    }
                    else {
                        final int n8 = 0xF80 ^ b2 ^ b << 6;
                        if (n8 < 128) {
                            final int m = 65533;
                            final int n9 = n3;
                            function1.invoke(m);
                            final Unit instance3 = Unit.INSTANCE;
                            n5 = n9;
                        }
                        else {
                            final int i2 = n8;
                            final int n10 = n3;
                            function1.invoke(i2);
                            final Unit instance4 = Unit.INSTANCE;
                            n5 = n10;
                        }
                        n6 = 2;
                    }
                }
                i = n5 + n6;
            }
            else if (j >> 4 == -2) {
                final int n11 = i;
                int n13;
                int n14;
                if (n2 <= i + 2) {
                    final int i3 = 65533;
                    final int n12 = n11;
                    function1.invoke(i3);
                    final Unit instance5 = Unit.INSTANCE;
                    n13 = n12;
                    n14 = ((n2 <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : 2);
                }
                else {
                    final byte b3 = array[i];
                    final byte b4 = array[i + 1];
                    if ((b4 & 0xC0) != 0x80) {
                        final int i4 = 65533;
                        final int n15 = n11;
                        function1.invoke(i4);
                        final Unit instance6 = Unit.INSTANCE;
                        n13 = n15;
                        n14 = 1;
                    }
                    else {
                        final byte b5 = array[i + 2];
                        if ((b5 & 0xC0) != 0x80) {
                            final int i5 = 65533;
                            final int n16 = n11;
                            function1.invoke(i5);
                            final Unit instance7 = Unit.INSTANCE;
                            n13 = n16;
                            n14 = 2;
                        }
                        else {
                            final int n17 = 0xFFFE1F80 ^ b5 ^ b4 << 6 ^ b3 << 12;
                            if (n17 < 2048) {
                                final int i6 = 65533;
                                final int n18 = n11;
                                function1.invoke(i6);
                                final Unit instance8 = Unit.INSTANCE;
                                n13 = n18;
                            }
                            else if (55296 <= n17 && n17 < 57344) {
                                final int i7 = 65533;
                                final int n19 = n11;
                                function1.invoke(i7);
                                final Unit instance9 = Unit.INSTANCE;
                                n13 = n19;
                            }
                            else {
                                final int i8 = n17;
                                final int n20 = n11;
                                function1.invoke(i8);
                                final Unit instance10 = Unit.INSTANCE;
                                n13 = n20;
                            }
                            n14 = 3;
                        }
                    }
                }
                i = n13 + n14;
            }
            else if (j >> 3 == -2) {
                final int n21 = i;
                int n23;
                int n24;
                if (n2 <= i + 3) {
                    final int i9 = 65533;
                    final int n22 = n21;
                    function1.invoke(i9);
                    final Unit instance11 = Unit.INSTANCE;
                    n23 = n22;
                    n24 = ((n2 <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : ((n2 <= i + 2 || (array[i + 2] & 0xC0) != 0x80) ? 2 : 3));
                }
                else {
                    final byte b6 = array[i];
                    final byte b7 = array[i + 1];
                    if ((b7 & 0xC0) != 0x80) {
                        final int i10 = 65533;
                        final int n25 = n21;
                        function1.invoke(i10);
                        final Unit instance12 = Unit.INSTANCE;
                        n23 = n25;
                        n24 = 1;
                    }
                    else {
                        final byte b8 = array[i + 2];
                        if ((b8 & 0xC0) != 0x80) {
                            final int i11 = 65533;
                            final int n26 = n21;
                            function1.invoke(i11);
                            final Unit instance13 = Unit.INSTANCE;
                            n23 = n26;
                            n24 = 2;
                        }
                        else {
                            final byte b9 = array[i + 3];
                            if ((b9 & 0xC0) != 0x80) {
                                final int i12 = 65533;
                                final int n27 = n21;
                                function1.invoke(i12);
                                final Unit instance14 = Unit.INSTANCE;
                                n23 = n27;
                                n24 = 3;
                            }
                            else {
                                final int n28 = 0x381F80 ^ b9 ^ b8 << 6 ^ b7 << 12 ^ b6 << 18;
                                if (n28 > 1114111) {
                                    final int i13 = 65533;
                                    final int n29 = n21;
                                    function1.invoke(i13);
                                    final Unit instance15 = Unit.INSTANCE;
                                    n23 = n29;
                                }
                                else if (55296 <= n28 && n28 < 57344) {
                                    final int i14 = 65533;
                                    final int n30 = n21;
                                    function1.invoke(i14);
                                    final Unit instance16 = Unit.INSTANCE;
                                    n23 = n30;
                                }
                                else if (n28 < 65536) {
                                    final int i15 = 65533;
                                    final int n31 = n21;
                                    function1.invoke(i15);
                                    final Unit instance17 = Unit.INSTANCE;
                                    n23 = n31;
                                }
                                else {
                                    final int i16 = n28;
                                    final int n32 = n21;
                                    function1.invoke(i16);
                                    final Unit instance18 = Unit.INSTANCE;
                                    n23 = n32;
                                }
                                n24 = 4;
                            }
                        }
                    }
                }
                i = n23 + n24;
            }
            else {
                function1.invoke(65533);
                ++i;
            }
        }
    }
    
    public static final void processUtf16Chars(@NotNull final byte[] array, final int n, final int n2, @NotNull final Function1<? super Character, Unit> function1) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i = n;
        while (i < n2) {
            final byte b = array[i];
            if (b >= 0) {
                function1.invoke((char)b);
                ++i;
                while (i < n2 && array[i] >= 0) {
                    function1.invoke((char)array[i++]);
                }
            }
            else if (b >> 5 == -2) {
                final int n3 = i;
                int n6;
                int n7;
                if (n2 <= i + 1) {
                    final int n4 = 65533;
                    final int n5 = n3;
                    function1.invoke((char)n4);
                    final Unit instance = Unit.INSTANCE;
                    n6 = n5;
                    n7 = 1;
                }
                else {
                    final byte b2 = array[i];
                    final byte b3 = array[i + 1];
                    if ((b3 & 0xC0) != 0x80) {
                        final int n8 = 65533;
                        final int n9 = n3;
                        function1.invoke((char)n8);
                        final Unit instance2 = Unit.INSTANCE;
                        n6 = n9;
                        n7 = 1;
                    }
                    else {
                        final int n10 = 0xF80 ^ b3 ^ b2 << 6;
                        if (n10 < 128) {
                            final int n11 = 65533;
                            final int n12 = n3;
                            function1.invoke((char)n11);
                            final Unit instance3 = Unit.INSTANCE;
                            n6 = n12;
                        }
                        else {
                            final int n13 = n10;
                            final int n14 = n3;
                            function1.invoke((char)n13);
                            final Unit instance4 = Unit.INSTANCE;
                            n6 = n14;
                        }
                        n7 = 2;
                    }
                }
                i = n6 + n7;
            }
            else if (b >> 4 == -2) {
                final int n15 = i;
                int n18;
                int n19;
                if (n2 <= i + 2) {
                    final int n16 = 65533;
                    final int n17 = n15;
                    function1.invoke((char)n16);
                    final Unit instance5 = Unit.INSTANCE;
                    n18 = n17;
                    n19 = ((n2 <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : 2);
                }
                else {
                    final byte b4 = array[i];
                    final byte b5 = array[i + 1];
                    if ((b5 & 0xC0) != 0x80) {
                        final int n20 = 65533;
                        final int n21 = n15;
                        function1.invoke((char)n20);
                        final Unit instance6 = Unit.INSTANCE;
                        n18 = n21;
                        n19 = 1;
                    }
                    else {
                        final byte b6 = array[i + 2];
                        if ((b6 & 0xC0) != 0x80) {
                            final int n22 = 65533;
                            final int n23 = n15;
                            function1.invoke((char)n22);
                            final Unit instance7 = Unit.INSTANCE;
                            n18 = n23;
                            n19 = 2;
                        }
                        else {
                            final int n24 = 0xFFFE1F80 ^ b6 ^ b5 << 6 ^ b4 << 12;
                            if (n24 < 2048) {
                                final int n25 = 65533;
                                final int n26 = n15;
                                function1.invoke((char)n25);
                                final Unit instance8 = Unit.INSTANCE;
                                n18 = n26;
                            }
                            else if (55296 <= n24 && n24 < 57344) {
                                final int n27 = 65533;
                                final int n28 = n15;
                                function1.invoke((char)n27);
                                final Unit instance9 = Unit.INSTANCE;
                                n18 = n28;
                            }
                            else {
                                final int n29 = n24;
                                final int n30 = n15;
                                function1.invoke((char)n29);
                                final Unit instance10 = Unit.INSTANCE;
                                n18 = n30;
                            }
                            n19 = 3;
                        }
                    }
                }
                i = n18 + n19;
            }
            else if (b >> 3 == -2) {
                final int n31 = i;
                int n34;
                int n35;
                if (n2 <= i + 3) {
                    final int n32 = 65533;
                    final int n33 = n31;
                    if (n32 != 65533) {
                        function1.invoke((char)((n32 >>> 10) + 55232));
                        function1.invoke((char)((n32 & 0x3FF) + 56320));
                    }
                    else {
                        function1.invoke('\ufffd');
                    }
                    final Unit instance11 = Unit.INSTANCE;
                    n34 = n33;
                    n35 = ((n2 <= i + 1 || (array[i + 1] & 0xC0) != 0x80) ? 1 : ((n2 <= i + 2 || (array[i + 2] & 0xC0) != 0x80) ? 2 : 3));
                }
                else {
                    final byte b7 = array[i];
                    final byte b8 = array[i + 1];
                    if ((b8 & 0xC0) != 0x80) {
                        final int n36 = 65533;
                        final int n37 = n31;
                        if (n36 != 65533) {
                            function1.invoke((char)((n36 >>> 10) + 55232));
                            function1.invoke((char)((n36 & 0x3FF) + 56320));
                        }
                        else {
                            function1.invoke('\ufffd');
                        }
                        final Unit instance12 = Unit.INSTANCE;
                        n34 = n37;
                        n35 = 1;
                    }
                    else {
                        final byte b9 = array[i + 2];
                        if ((b9 & 0xC0) != 0x80) {
                            final int n38 = 65533;
                            final int n39 = n31;
                            if (n38 != 65533) {
                                function1.invoke((char)((n38 >>> 10) + 55232));
                                function1.invoke((char)((n38 & 0x3FF) + 56320));
                            }
                            else {
                                function1.invoke('\ufffd');
                            }
                            final Unit instance13 = Unit.INSTANCE;
                            n34 = n39;
                            n35 = 2;
                        }
                        else {
                            final byte b10 = array[i + 3];
                            if ((b10 & 0xC0) != 0x80) {
                                final int n40 = 65533;
                                final int n41 = n31;
                                if (n40 != 65533) {
                                    function1.invoke((char)((n40 >>> 10) + 55232));
                                    function1.invoke((char)((n40 & 0x3FF) + 56320));
                                }
                                else {
                                    function1.invoke('\ufffd');
                                }
                                final Unit instance14 = Unit.INSTANCE;
                                n34 = n41;
                                n35 = 3;
                            }
                            else {
                                final int n42 = 0x381F80 ^ b10 ^ b9 << 6 ^ b8 << 12 ^ b7 << 18;
                                if (n42 > 1114111) {
                                    final int n43 = 65533;
                                    final int n44 = n31;
                                    if (n43 != 65533) {
                                        function1.invoke((char)((n43 >>> 10) + 55232));
                                        function1.invoke((char)((n43 & 0x3FF) + 56320));
                                    }
                                    else {
                                        function1.invoke('\ufffd');
                                    }
                                    final Unit instance15 = Unit.INSTANCE;
                                    n34 = n44;
                                }
                                else if (55296 <= n42 && n42 < 57344) {
                                    final int n45 = 65533;
                                    final int n46 = n31;
                                    if (n45 != 65533) {
                                        function1.invoke((char)((n45 >>> 10) + 55232));
                                        function1.invoke((char)((n45 & 0x3FF) + 56320));
                                    }
                                    else {
                                        function1.invoke('\ufffd');
                                    }
                                    final Unit instance16 = Unit.INSTANCE;
                                    n34 = n46;
                                }
                                else if (n42 < 65536) {
                                    final int n47 = 65533;
                                    final int n48 = n31;
                                    if (n47 != 65533) {
                                        function1.invoke((char)((n47 >>> 10) + 55232));
                                        function1.invoke((char)((n47 & 0x3FF) + 56320));
                                    }
                                    else {
                                        function1.invoke('\ufffd');
                                    }
                                    final Unit instance17 = Unit.INSTANCE;
                                    n34 = n48;
                                }
                                else {
                                    final int n49 = n42;
                                    final int n50 = n31;
                                    if (n49 != 65533) {
                                        function1.invoke((char)((n49 >>> 10) + 55232));
                                        function1.invoke((char)((n49 & 0x3FF) + 56320));
                                    }
                                    else {
                                        function1.invoke('\ufffd');
                                    }
                                    final Unit instance18 = Unit.INSTANCE;
                                    n34 = n50;
                                }
                                n35 = 4;
                            }
                        }
                    }
                }
                i = n34 + n35;
            }
            else {
                function1.invoke('\ufffd');
                ++i;
            }
        }
    }
    
    public static final int process2Utf8Bytes(@NotNull final byte[] array, final int n, final int n2, @NotNull final Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (n2 <= n + 1) {
            function1.invoke(65533);
            return 1;
        }
        final byte b = array[n];
        final byte b2 = array[n + 1];
        if ((b2 & 0xC0) != 0x80) {
            function1.invoke(65533);
            return 1;
        }
        final int i = 0xF80 ^ b2 ^ b << 6;
        if (i < 128) {
            function1.invoke(65533);
        }
        else {
            function1.invoke(i);
        }
        return 2;
    }
    
    public static final int process3Utf8Bytes(@NotNull final byte[] array, final int n, final int n2, @NotNull final Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (n2 <= n + 2) {
            function1.invoke(65533);
            if (n2 <= n + 1 || (array[n + 1] & 0xC0) != 0x80) {
                return 1;
            }
            return 2;
        }
        else {
            final byte b = array[n];
            final byte b2 = array[n + 1];
            if ((b2 & 0xC0) != 0x80) {
                function1.invoke(65533);
                return 1;
            }
            final byte b3 = array[n + 2];
            if ((b3 & 0xC0) != 0x80) {
                function1.invoke(65533);
                return 2;
            }
            final int i = 0xFFFE1F80 ^ b3 ^ b2 << 6 ^ b << 12;
            if (i < 2048) {
                function1.invoke(65533);
            }
            else if (55296 <= i && i < 57344) {
                function1.invoke(65533);
            }
            else {
                function1.invoke(i);
            }
            return 3;
        }
    }
    
    public static final int process4Utf8Bytes(@NotNull final byte[] array, final int n, final int n2, @NotNull final Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (n2 <= n + 3) {
            function1.invoke(65533);
            if (n2 <= n + 1 || (array[n + 1] & 0xC0) != 0x80) {
                return 1;
            }
            if (n2 <= n + 2 || (array[n + 2] & 0xC0) != 0x80) {
                return 2;
            }
            return 3;
        }
        else {
            final byte b = array[n];
            final byte b2 = array[n + 1];
            if ((b2 & 0xC0) != 0x80) {
                function1.invoke(65533);
                return 1;
            }
            final byte b3 = array[n + 2];
            if ((b3 & 0xC0) != 0x80) {
                function1.invoke(65533);
                return 2;
            }
            final byte b4 = array[n + 3];
            if ((b4 & 0xC0) != 0x80) {
                function1.invoke(65533);
                return 3;
            }
            final int i = 0x381F80 ^ b4 ^ b3 << 6 ^ b2 << 12 ^ b << 18;
            if (i > 1114111) {
                function1.invoke(65533);
            }
            else if (55296 <= i && i < 57344) {
                function1.invoke(65533);
            }
            else if (i < 65536) {
                function1.invoke(65533);
            }
            else {
                function1.invoke(i);
            }
            return 4;
        }
    }
    
    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull final String s, final int n) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        return size$default(s, n, 0, 2, null);
    }
    
    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "<this>");
        return size$default(s, 0, 0, 3, null);
    }
}
