/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2={"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"})
@JvmName(name="UStringsKt")
public class UStringsKt {
    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String m55bc23ea07(byte by, int n) {
        String string = Integer.toString(by & 0xFF, CharsKt.checkRadix(n));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String m83361ad528(short s, int n) {
        String string = Integer.toString(s & 0xFFFF, CharsKt.checkRadix(n));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String me54a4f1b3f(int n, int n2) {
        String string = Long.toString((long)n & 0xFFFFFFFFL, CharsKt.checkRadix(n2));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String m894e3a3955(long l, int n) {
        return UnsignedKt.ulongToString(l, CharsKt.checkRadix(n));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final byte toUByte(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UByte uByte = UStringsKt.toUByteOrNull(string);
        if (uByte == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uByte.mc2c6800511();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final byte toUByte(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UByte uByte = UStringsKt.toUByteOrNull(string, n);
        if (uByte == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uByte.mc2c6800511();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final short toUShort(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UShort uShort = UStringsKt.toUShortOrNull(string);
        if (uShort == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uShort.m0dfe878ce1();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final short toUShort(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UShort uShort = UStringsKt.toUShortOrNull(string, n);
        if (uShort == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uShort.m0dfe878ce1();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int toUInt(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UInt uInt = UStringsKt.toUIntOrNull(string);
        if (uInt == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uInt.md975fdc550();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final int toUInt(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UInt uInt = UStringsKt.toUIntOrNull(string, n);
        if (uInt == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uInt.md975fdc550();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long toULong(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        ULong uLong = UStringsKt.toULongOrNull(string);
        if (uLong == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uLong.m8c33c6a73b();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    public static final long toULong(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        ULong uLong = UStringsKt.toULongOrNull(string, n);
        if (uLong == null) {
            StringsKt.numberFormatError(string);
            throw new KotlinNothingValueException();
        }
        return uLong.m8c33c6a73b();
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UByte toUByteOrNull(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return UStringsKt.toUByteOrNull(string, 10);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UByte toUByteOrNull(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UInt uInt = UStringsKt.toUIntOrNull(string, n);
        if (uInt == null) {
            return null;
        }
        int n2 = uInt.md975fdc550();
        int n3 = -1;
        if (Integer.compareUnsigned(n2, UInt.mb680b9b7ba(n3 & 0xFF)) > 0) {
            return null;
        }
        return UByte.me30452dd28(UByte.m854efd65e6((byte)n2));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UShort toUShortOrNull(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return UStringsKt.toUShortOrNull(string, 10);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UShort toUShortOrNull(@NotNull String string, int n) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        UInt uInt = UStringsKt.toUIntOrNull(string, n);
        if (uInt == null) {
            return null;
        }
        int n2 = uInt.md975fdc550();
        int n3 = -1;
        if (Integer.compareUnsigned(n2, UInt.mb680b9b7ba(n3 & 0xFFFF)) > 0) {
            return null;
        }
        return UShort.md68ce5e29d(UShort.m96ff20ce19((short)n2));
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UInt toUIntOrNull(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return UStringsKt.toUIntOrNull(string, 10);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UInt toUIntOrNull(@NotNull String string, int n) {
        int n2;
        Intrinsics.checkNotNullParameter(string, "<this>");
        CharsKt.checkRadix(n);
        int n3 = string.length();
        if (n3 == 0) {
            return null;
        }
        int n4 = -1;
        int n5 = 0;
        char c = string.charAt(0);
        if (Intrinsics.compare(c, 48) < 0) {
            if (n3 == 1 || c != '+') {
                return null;
            }
            n5 = 1;
        } else {
            n5 = 0;
        }
        int n6 = n2 = 0x71C71C7;
        int n7 = UInt.mb680b9b7ba(n);
        int n8 = 0;
        for (int i = n5; i < n3; ++i) {
            int n9 = CharsKt.digitOf(string.charAt(i), n);
            if (n9 < 0) {
                return null;
            }
            if (Integer.compareUnsigned(n8, n6) > 0) {
                if (n6 == n2) {
                    n6 = Integer.divideUnsigned(n4, n7);
                    if (Integer.compareUnsigned(n8, n6) > 0) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            int n10 = n8 = UInt.mb680b9b7ba(n8 * n7);
            if (Integer.compareUnsigned(n8 = UInt.mb680b9b7ba(n8 + UInt.mb680b9b7ba(n9)), n10) >= 0) continue;
            return null;
        }
        return UInt.m3f97684bd0(n8);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final ULong toULongOrNull(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        return UStringsKt.toULongOrNull(string, 10);
    }

    @SinceKotlin(version="1.5")
    @WasExperimental(markerClass={ExperimentalUnsignedTypes.class})
    @Nullable
    public static final ULong toULongOrNull(@NotNull String string, int n) {
        long l;
        Intrinsics.checkNotNullParameter(string, "<this>");
        CharsKt.checkRadix(n);
        int n2 = string.length();
        if (n2 == 0) {
            return null;
        }
        long l2 = -1L;
        int n3 = 0;
        char c = string.charAt(0);
        if (Intrinsics.compare(c, 48) < 0) {
            if (n2 == 1 || c != '+') {
                return null;
            }
            n3 = 1;
        } else {
            n3 = 0;
        }
        long l3 = l = 0x71C71C71C71C71CL;
        long l4 = ULong.mc76128828a(n);
        long l5 = 0L;
        for (int i = n3; i < n2; ++i) {
            int n4 = CharsKt.digitOf(string.charAt(i), n);
            if (n4 < 0) {
                return null;
            }
            if (Long.compareUnsigned(l5, l3) > 0) {
                if (l3 == l) {
                    l3 = Long.divideUnsigned(l2, l4);
                    if (Long.compareUnsigned(l5, l3) > 0) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            long l6 = l5 = ULong.mc76128828a(l5 * l4);
            int n5 = UInt.mb680b9b7ba(n4);
            if (Long.compareUnsigned(l5 = ULong.mc76128828a(l5 + ULong.mc76128828a((long)n5 & 0xFFFFFFFFL)), l6) >= 0) continue;
            return null;
        }
        return ULong.ma7eeea8d7e(l5);
    }
}

