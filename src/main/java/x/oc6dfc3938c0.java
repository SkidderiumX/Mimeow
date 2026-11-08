/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import x.N;
import x.oc0dddd2db0b;
import x.oc10354c7bb8;
import x.oc24a0a5bddf;
import x.oc2cf3d80e17;
import x.oc321b4679dd;
import x.oc35e4c54bd4;
import x.oc449e61fefc;
import x.oc4d46a99983;
import x.oc5ef5aeeaf9;
import x.oc63848f8f74;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc6f44315029;
import x.oc98904eb9e7;
import x.oc9c5bf76ff7;
import x.oca3e979d682;
import x.oca481da7ec8;
import x.oca9cc61aada;
import x.ocac488f5520;
import x.ocada7dda290;
import x.occ2f8dff8d8;
import x.occ4cfb65507;
import x.occc831eff22;
import x.oce4a4c32971;
import x.ocf1568fef75;
import x.ocf9f6726f63;

public class oc6dfc3938c0 {
    private final oc449e61fefc \u023c;
    private final Map<N, oca3e979d682> \u03c9 = new IdentityHashMap<N, oca3e979d682>();

    public oc6dfc3938c0(ocf9f6726f63 ocf9f6726f632, oc6f44315029 oc6f443150292) {
        this.\u023c = new oc449e61fefc(ocf9f6726f632, oc6f443150292, (string, dArray) -> {
            Object[] objectArray = new Object[dArray.length];
            for (int i = 0; i < dArray.length; ++i) {
                objectArray[i] = dArray[i];
            }
            try {
                return String.format(Locale.ROOT, string.replace("%0.", "%."), objectArray);
            }
            catch (Exception exception) {
                if (dArray.length == 1) {
                    return String.format(Locale.ROOT, "%.2f", dArray[0]);
                }
                if (dArray.length >= (0xEB306592 ^ 0xEB306590)) {
                    Object[] objectArray2 = new Object[0xEB306592 ^ 0xEB306590];
                    objectArray2[0] = dArray[0];
                    objectArray2[1] = dArray[1];
                    return String.format(Locale.ROOT, "%.2f - %.2f", objectArray2);
                }
                return string;
            }
        });
    }

    private static String \u03e0(String string) {
        if (string == null || string.trim().isEmpty()) {
            return "";
        }
        return " " + string.trim().replace("%", "%%");
    }

    public void \u012d(oc69da1aa7f5 oc69da1aa7f52, oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, float[] fArray, double d) {
        if (oc69da1aa7f52 == null || oc69da1aa7f52.\u0260() == null) {
            return;
        }
        this.\u02e4(oc69da1aa7f52, null, oc35e4c54bd42, ocac488f55202, oce4a4c329712, fArray, d, Collections.newSetFromMap(new IdentityHashMap()));
    }

    private void \u02e4(oc69da1aa7f5 oc69da1aa7f52, occc831eff22 occc831eff222, oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, float[] fArray, double d, Set<N> set) {
        for (N n : oc69da1aa7f52.\u0260()) {
            if (n == null || !n.\u04c0 || oc0dddd2db0b.\u04f4(n, oc69da1aa7f52.\u0260()) != occc831eff222 || !set.add(n)) continue;
            this.\u03b6(oc69da1aa7f52, n, oc35e4c54bd42, ocac488f55202, oce4a4c329712, fArray, d, set);
        }
    }

    private oca3e979d682 \u027d(N n) {
        oca3e979d682 oca3e979d6822 = this.\u03c9.get(n);
        if (oca3e979d6822 == null) {
            oca3e979d6822 = new oca3e979d682();
            this.\u03c9.put(n, oca3e979d6822);
        }
        return oca3e979d6822;
    }

    private void \u03b6(oc69da1aa7f5 oc69da1aa7f52, N n2, oc35e4c54bd4 oc35e4c54bd42, ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, float[] fArray2, double d, Set<N> set) {
        oca3e979d682 oca3e979d6822 = this.\u027d(n2);
        if (n2 instanceof occ2f8dff8d8) {
            occ2f8dff8d8 occ2f8dff8d82 = (occ2f8dff8d8)n2;
            if (occ2f8dff8d82.\u04fd) {
                boolean bl = this.\u023c.\u03f0(oc35e4c54bd42, ocac488f55202, oce4a4c329712, occ2f8dff8d82.z$18nrktuqeiysv(), oca3e979d6822.\u0100, false, fArray2, d);
                if (bl) {
                    occ2f8dff8d82.\u0568();
                }
            } else {
                boolean bl = occ2f8dff8d82.\u01ed();
                boolean bl2 = this.\u023c.\u03f0(oc35e4c54bd42, ocac488f55202, oce4a4c329712, occ2f8dff8d82.z$18nrktuqeiysv(), oca3e979d6822.\u0100, bl, fArray2, d);
                if (bl2 != bl) {
                    occ2f8dff8d82.\u03d1(bl2);
                    oc69da1aa7f52.guiButtonToggled(occ2f8dff8d82);
                    oc69da1aa7f52.z$2u87utkr1isxg();
                    oc2cf3d80e17.\u04eb();
                }
            }
        } else if (n2 instanceof oca9cc61aada) {
            occ4cfb65507 occ4cfb655072;
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)n2;
            if (oca9cc61aada2 instanceof occ4cfb65507 && (occ4cfb655072 = (occ4cfb65507)oca9cc61aada2).\u04ed().size() >= (0xAD07C2D ^ 0xAD07C2B)) {
                List<String> list = occ4cfb655072.\u04ed();
                int n3 = Math.max(0, Math.min(list.size() - 1, (int)oca9cc61aada2.\u04c1()));
                this.\u023c.\u047b(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oca9cc61aada2.z$18nrktuqeiysv(), list.get(n3), list, n -> {
                    if (n == null) {
                        return;
                    }
                    oca9cc61aada2.\u021e(n.intValue());
                    oc69da1aa7f52.z$1sehylui0i4ix(oca9cc61aada2);
                    oc69da1aa7f52.z$2u87utkr1isxg();
                    oc2cf3d80e17.\u04eb();
                }, d);
            } else if (oca9cc61aada2.\u00c6 && oca9cc61aada2.\u04be() != null && oca9cc61aada2.\u04be().length > 0) {
                int n4;
                String[] stringArray = oca9cc61aada2.\u04be();
                oca3e979d6822.\u02b3[0] = n4 = Math.max(0, Math.min(stringArray.length - 1, (int)Math.round(oca9cc61aada2.\u04c1())));
                this.\u023c.\u012a(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oca9cc61aada2.z$18nrktuqeiysv(), oca3e979d6822.\u03fb, Arrays.asList(stringArray), oca3e979d6822.\u02b3, 0, fArray2, d);
                if (oca3e979d6822.\u02b3[0] != n4) {
                    oca9cc61aada2.\u021e(oca3e979d6822.\u02b3[0]);
                    oc69da1aa7f52.z$1sehylui0i4ix(oca9cc61aada2);
                    oc69da1aa7f52.z$2u87utkr1isxg();
                    oc2cf3d80e17.\u04eb();
                }
            } else {
                String string2 = oca9cc61aada2.\u011c();
                String string3 = oca9cc61aada2.\u03d3() >= 1.0 && oca9cc61aada2.\u03d3() == Math.floor(oca9cc61aada2.\u03d3()) ? "%.0f" + oc6dfc3938c0.\u03e0(string2) : "%.2f" + oc6dfc3938c0.\u03e0(string2);
                float f = (float)oca9cc61aada2.\u04c1();
                float f2 = this.\u023c.\u04c7(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oca9cc61aada2.z$18nrktuqeiysv(), string3, oca3e979d6822.\u028a, oca3e979d6822.\u0420, (float)oca9cc61aada2.\u0515(), (float)oca9cc61aada2.\u0236(), (float)oca9cc61aada2.\u03d3(), 0.0f, f, fArray2, d);
                if (Float.floatToRawIntBits(f2) != Float.floatToRawIntBits(f)) {
                    oca9cc61aada2.\u021e(f2);
                    oc69da1aa7f52.z$1sehylui0i4ix(oca9cc61aada2);
                    oc69da1aa7f52.z$2u87utkr1isxg();
                    oc2cf3d80e17.\u04eb();
                }
            }
        } else if (n2 instanceof ocf1568fef75) {
            ocf1568fef75 ocf1568fef752 = (ocf1568fef75)n2;
            String string4 = ocf1568fef752.\u041c();
            String string5 = "%.2f" + oc6dfc3938c0.\u03e0(string4);
            String string6 = "%.2f - %.2f" + oc6dfc3938c0.\u03e0(string4);
            float f = (float)ocf1568fef752.\u00f6();
            float f3 = (float)ocf1568fef752.\u0456();
            float[] fArray3 = this.\u023c.\u054d(oc35e4c54bd42, ocac488f55202, oce4a4c329712, ocf1568fef752.z$18nrktuqeiysv(), string5, string6, oca3e979d6822.\u028a, oca3e979d6822.\u0255, oca3e979d6822.\u00e0, (float)ocf1568fef752.\u03b8(), (float)ocf1568fef752.\u0276(), (float)ocf1568fef752.\u0525(), 0.0f, f, f3, fArray2, d);
            if (fArray3[0] != f || fArray3[1] != f3) {
                ocf1568fef752.\u046c(fArray3[0], fArray3[1]);
                oc2cf3d80e17.\u04eb();
            }
        } else if (n2 instanceof oc24a0a5bddf) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)n2;
            float[] fArray4 = new float[0xAD07C28 ^ 0xAD07C2B];
            fArray4[0] = (float)oc24a0a5bddf2.\u02c0() / 255.0f;
            fArray4[1] = (float)oc24a0a5bddf2.z() / 255.0f;
            fArray4[0xAD07C29 ^ 0xAD07C2B] = (float)oc24a0a5bddf2.\u0446() / 255.0f;
            float[] fArray5 = fArray4;
            this.\u023c.\u03c5(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oc24a0a5bddf2.z$18nrktuqeiysv(), fArray5, fArray -> {
                oc24a0a5bddf2.\u04c2((int)(fArray[0] * 255.0f), (int)(fArray[1] * 255.0f), (int)(fArray[0x7067098B ^ 0x70670989] * 255.0f));
                oc2cf3d80e17.\u04eb();
            }, d);
        } else if (n2 instanceof ocada7dda290) {
            ocada7dda290 ocada7dda2902 = (ocada7dda290)n2;
            if (this.\u023c.\u0517(oc35e4c54bd42, ocac488f55202, oce4a4c329712, ocada7dda2902.z$18nrktuqeiysv(), oca3e979d6822.\u03fb, Arrays.asList(ocada7dda2902.\u01e5()), ocada7dda2902::\u01e9, ocada7dda2902::\u0465, fArray2, d)) {
                oc69da1aa7f52.z$3tl278wzjcayb(ocada7dda2902);
                oc69da1aa7f52.z$2u87utkr1isxg();
                oc2cf3d80e17.\u04eb();
            }
        } else if (n2 instanceof occc831eff22) {
            occc831eff22 occc831eff222 = (occc831eff22)n2;
            boolean bl = this.\u023c.\u00e8(oc35e4c54bd42, ocac488f55202, oce4a4c329712, occc831eff222.z$18nrktuqeiysv(), occc831eff222.\u01ab());
            if (bl != occc831eff222.\u01ab()) {
                occc831eff222.\u04f6(bl);
                oc69da1aa7f52.z$2u87utkr1isxg();
            }
            if (bl) {
                this.\u02e4(oc69da1aa7f52, occc831eff222, oc35e4c54bd42, ocac488f55202, oce4a4c329712, fArray2, d, set);
            }
        } else if (n2 instanceof oc4d46a99983) {
            oc4d46a99983 oc4d46a999832 = (oc4d46a99983)n2;
            this.\u023c.\u02ac(ocac488f55202, oce4a4c329712, oc4d46a999832.\u03f5());
        } else if (n2 instanceof oc6af36febc3) {
            oc6af36febc3 oc6af36febc32 = (oc6af36febc3)n2;
            this.\u023c.\u02b0(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oc6af36febc32.z$18nrktuqeiysv(), oc6af36febc32.z$18nrktuqeiysv(), oc98904eb9e7::\u01d3, 0, new oca481da7ec8(this, oc6af36febc32), null, d);
        } else if (n2 instanceof oc10354c7bb8) {
            oc10354c7bb8 oc10354c7bb82 = (oc10354c7bb8)n2;
            if (oca3e979d6822.\u053c == null) {
                oca3e979d6822.\u053c = oc9c5bf76ff7.\u03b1(oc10354c7bb82);
                oca3e979d6822.g = oca3e979d6822.\u053c.stream().map(oc63848f8f74::\u046a).toList();
            }
            List<oc63848f8f74> list = oca3e979d6822.\u053c;
            this.\u023c.\u02b0(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oc10354c7bb82.z$18nrktuqeiysv(), oc10354c7bb82.z$18nrktuqeiysv(), oc98904eb9e7::\u01d3, 0, new oc5ef5aeeaf9(this, oc10354c7bb82, list), oca3e979d6822.g, d);
        } else if (n2 instanceof oc321b4679dd) {
            String string7;
            oc321b4679dd oc321b4679dd2 = (oc321b4679dd)n2;
            String string8 = string7 = oc321b4679dd2.\u00ca().isEmpty() ? oc321b4679dd2.\u0574() : oc321b4679dd2.\u00ca();
            if (oc321b4679dd2.\u01fc() && oc321b4679dd2.\u00eb()) {
                string7 = "*".repeat(oc321b4679dd2.\u00ca().length());
            }
            this.\u023c.\u0479(oc35e4c54bd42, ocac488f55202, oce4a4c329712, oc321b4679dd2.z$18nrktuqeiysv(), string7, oc321b4679dd2.\u00ca(), oca3e979d6822.\u028a, oc321b4679dd2.x(), string -> {
                if (string != null) {
                    oc321b4679dd2.z$1bnplyl2p7uqx((String)string);
                    oc321b4679dd2.\u01ba();
                    oc69da1aa7f52.z$3tl278wzjcayb(oc321b4679dd2);
                    oc69da1aa7f52.z$2u87utkr1isxg();
                    oc2cf3d80e17.\u04eb();
                }
            }, d);
        }
    }
}

