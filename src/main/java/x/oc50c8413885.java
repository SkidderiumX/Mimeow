/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import x.A;
import x.L;
import x.oc06b9308b3c;
import x.oc1dbdddc1e9;
import x.oc62a465bc97;
import x.oc77bf9fb04c;
import x.oc840d7c857b;
import x.ocb579fc6994;
import x.ocbc6f0988cd;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class oc50c8413885 {
    private final oc840d7c857b[] \u0290 = new oc840d7c857b[0xADDC2747 ^ 0xADDC2766];
    private int \u025d;

    public oc50c8413885(oc840d7c857b oc840d7c857b2) {
        this.\u0290[0] = Objects.requireNonNull(oc840d7c857b2).\u0208();
        this.\u025d = 1;
    }

    public oc840d7c857b \u048c() {
        return this.\u0290[this.\u025d - 1];
    }

    public int \u016e() {
        return this.\u025d;
    }

    public void \u015b() {
        if (this.\u025d <= (0x3ADAACEA ^ 0x3ADAACF5)) {
            this.\u0290[this.\u025d] = this.\u048c().\u0208();
            ++this.\u025d;
        }
    }

    public void popMark() {
        if (this.\u025d >= (0x7EA7ED54 ^ 0x7EA7ED56)) {
            --this.\u025d;
        }
    }

    public void \u0108(float f, float f2) {
        float[] fArray = this.\u048c().\u01f9;
        float f3 = fArray[0];
        float f4 = fArray[1];
        float f5 = fArray[0xC847C7C2 ^ 0xC847C7C0];
        float f6 = fArray[0xC847C7C3 ^ 0xC847C7C0];
        float f7 = fArray[0xC847C7C4 ^ 0xC847C7C0];
        float f8 = fArray[0xC847C7C5 ^ 0xC847C7C0];
        fArray[0] = f5 * 0.0f + f3;
        fArray[1] = f6 * 0.0f + f4;
        fArray[0xC847C7C2 ^ 0xC847C7C0] = 0.0f * f3 + f5;
        fArray[0xC847C7C3 ^ 0xC847C7C0] = 0.0f * f4 + f6;
        fArray[0xC847C7C4 ^ 0xC847C7C0] = f * f3 + f2 * f5 + f7;
        fArray[0xC847C7C5 ^ 0xC847C7C0] = f * f4 + f2 * f6 + f8;
    }

    public void \u04f2(float f, float f2) {
        float[] fArray = this.\u048c().\u01f9;
        float f3 = fArray[0];
        float f4 = fArray[1];
        float f5 = fArray[0xEF273D18 ^ 0xEF273D1A];
        float f6 = fArray[0xEF273D19 ^ 0xEF273D1A];
        float f7 = fArray[0xEF273D1E ^ 0xEF273D1A];
        float f8 = fArray[0xEF273D1F ^ 0xEF273D1A];
        float f9 = f5 * 0.0f;
        float f10 = f6 * 0.0f;
        fArray[0] = f9 + f * f3;
        fArray[1] = f10 + f * f4;
        fArray[0xEF273D18 ^ 0xEF273D1A] = f2 * f5 + 0.0f * f3;
        fArray[0xEF273D19 ^ 0xEF273D1A] = f2 * f6 + 0.0f * f4;
        fArray[0xEF273D1E ^ 0xEF273D1A] = f3 * 0.0f + f9 + f7;
        fArray[0xEF273D1F ^ 0xEF273D1A] = f4 * 0.0f + f10 + f8;
    }

    public void \u00f4(float f, float f2, float f3, float f4) {
        oc840d7c857b oc840d7c857b2 = this.\u048c();
        float[] fArray = oc840d7c857b2.\u01f9;
        float[] fArray2 = oc840d7c857b2.\u0150;
        float f5 = oc62a465bc97.\u057f(0.0f, f3);
        float f6 = oc62a465bc97.\u057f(0.0f, f4);
        float f7 = L.\u026d(0x1BC29122 ^ 0x1BE9C252);
        float f8 = f5 * f7 + f;
        float f9 = f6 * f7 + f2;
        fArray2[0] = fArray[0x1BE9C250 ^ 0x1BE9C252] * 0.0f + fArray[0];
        fArray2[1] = fArray[0x1BE9C251 ^ 0x1BE9C252] * 0.0f + fArray[1];
        fArray2[0x1BE9C250 ^ 0x1BE9C252] = 0.0f * fArray[0] + fArray[0x1BE9C250 ^ 0x1BE9C252];
        fArray2[0x1BE9C251 ^ 0x1BE9C252] = 0.0f * fArray[1] + fArray[0x1BE9C251 ^ 0x1BE9C252];
        fArray2[0x1BE9C256 ^ 0x1BE9C252] = f8 * fArray[0] + f9 * fArray[0x1BE9C250 ^ 0x1BE9C252] + fArray[0x1BE9C256 ^ 0x1BE9C252];
        fArray2[0x1BE9C257 ^ 0x1BE9C252] = f8 * fArray[1] + f9 * fArray[0x1BE9C251 ^ 0x1BE9C252] + fArray[0x1BE9C257 ^ 0x1BE9C252];
        oc840d7c857b2.\u029a[0] = f5 * L.\u026d(0x1BC291DA ^ 0x1BE9C252);
        oc840d7c857b2.\u029a[1] = f6 * L.\u026d(0x1BC291DE ^ 0x1BE9C252);
    }

    private static oc06b9308b3c \u00e1(float[] fArray, int n) {
        oc06b9308b3c oc06b9308b3c2 = new oc06b9308b3c();
        for (int i = 0; i < (0x3E164B1B ^ 0x3E164B1F); ++i) {
            oc06b9308b3c2.\u013f[i] = L.\u026d(n + i * (0x3E164B1B ^ 0x3E164B1F));
        }
        oc06b9308b3c2.\u04b2 = 1.0f;
        System.arraycopy(fArray, 0, oc06b9308b3c2.\u0180, 0, 0x3E164B1B ^ 0x3E164B1F);
        System.arraycopy(fArray, 0, oc06b9308b3c2.\u02af, 0, 0x3E164B1B ^ 0x3E164B1F);
        return oc06b9308b3c2;
    }

    public void \u0556(float[] fArray) {
        float[] fArray2 = (float[])fArray.clone();
        this.\u048c().\u0573 = oc50c8413885.\u00e1(fArray2, 0xD0001AB4 ^ 0xD02B4824);
    }

    public void \u02b7(float[] fArray) {
        float[] fArray2 = (float[])fArray.clone();
        this.\u048c().\u012e = oc50c8413885.\u00e1(fArray2, 0x9E01E0E0 ^ 0x9E2AB260);
    }

    public void \u01fb(oc06b9308b3c oc06b9308b3c2) {
        oc06b9308b3c oc06b9308b3c3 = oc06b9308b3c2.\u0449();
        float[] fArray = (float[])oc06b9308b3c2.\u013f.clone();
        float[] fArray2 = this.\u048c().\u01f9;
        float f = fArray[0xA08BC521 ^ 0xA08BC525] * fArray2[0] + fArray[0xA08BC520 ^ 0xA08BC525] * fArray2[0xA08BC527 ^ 0xA08BC525] + fArray2[0xA08BC521 ^ 0xA08BC525];
        float f2 = fArray[0xA08BC521 ^ 0xA08BC525] * fArray2[1] + fArray[0xA08BC520 ^ 0xA08BC525] * fArray2[0xA08BC526 ^ 0xA08BC525] + fArray2[0xA08BC520 ^ 0xA08BC525];
        oc06b9308b3c3.\u013f[0] = fArray[0] * fArray2[0] + fArray[1] * fArray2[0xA08BC527 ^ 0xA08BC525];
        oc06b9308b3c3.\u013f[1] = fArray[0] * fArray2[1] + fArray[1] * fArray2[0xA08BC526 ^ 0xA08BC525];
        oc06b9308b3c3.\u013f[0xA08BC527 ^ 0xA08BC525] = fArray[0xA08BC527 ^ 0xA08BC525] * fArray2[0] + fArray[0xA08BC526 ^ 0xA08BC525] * fArray2[0xA08BC527 ^ 0xA08BC525];
        oc06b9308b3c3.\u013f[0xA08BC526 ^ 0xA08BC525] = fArray[0xA08BC527 ^ 0xA08BC525] * fArray2[1] + fArray[0xA08BC526 ^ 0xA08BC525] * fArray2[0xA08BC526 ^ 0xA08BC525];
        oc06b9308b3c3.\u013f[0xA08BC521 ^ 0xA08BC525] = f;
        oc06b9308b3c3.\u013f[0xA08BC520 ^ 0xA08BC525] = f2;
        this.\u048c().\u0573 = oc06b9308b3c3;
    }

    public static oc06b9308b3c \u0143(float f, float f2, float f3, float f4, float f5, int n, float f6) {
        oc06b9308b3c oc06b9308b3c2 = new oc06b9308b3c();
        float f7 = oc77bf9fb04c.\u04ed(f5);
        float f8 = oc77bf9fb04c.\u0145(f5);
        oc06b9308b3c2.\u013f[0] = f7;
        oc06b9308b3c2.\u013f[1] = f8;
        oc06b9308b3c2.\u013f[0x6C9CF417 ^ 0x6C9CF415] = Float.intBitsToFloat(Float.floatToRawIntBits(f8) ^ L.\u0497(0x6CB7A745 ^ 0x6C9CF415));
        oc06b9308b3c2.\u013f[0x6C9CF416 ^ 0x6C9CF415] = f7;
        oc06b9308b3c2.\u013f[0x6C9CF411 ^ 0x6C9CF415] = f;
        oc06b9308b3c2.\u013f[0x6C9CF410 ^ 0x6C9CF415] = f2;
        oc06b9308b3c2.\u026a[0] = f3;
        oc06b9308b3c2.\u026a[1] = f4;
        oc06b9308b3c2.W = n;
        oc06b9308b3c2.\u0180[0] = oc06b9308b3c2.\u02af[0] = L.\u026d(0x6CB7A775 ^ 0x6C9CF415);
        oc06b9308b3c2.\u0180[1] = oc06b9308b3c2.\u02af[1] = L.\u026d(0x6CB7A771 ^ 0x6C9CF415);
        oc06b9308b3c2.\u02af[0x6C9CF417 ^ 0x6C9CF415] = 1.0f;
        oc06b9308b3c2.\u0180[0x6C9CF417 ^ 0x6C9CF415] = 1.0f;
        float f9 = f6;
        oc06b9308b3c2.\u02af[0x6C9CF416 ^ 0x6C9CF415] = f9;
        oc06b9308b3c2.\u0180[0x6C9CF416 ^ 0x6C9CF415] = f9;
        return oc06b9308b3c2;
    }

    public static oc06b9308b3c \u02a6(float f, float f2, float f3, float f4, float[] fArray, float[] fArray2) {
        float f5;
        oc06b9308b3c oc06b9308b3c2 = new oc06b9308b3c();
        float f6 = f3 - f;
        float f7 = f4 - f2;
        float f8 = (float)StrictMath.sqrt(f6 * f6 + f7 * f7);
        boolean bl = f8 > L.\u026d(0x619212ED ^ 0x61B9404D);
        float f9 = L.\u026d(0x619212AD ^ 0x61B9404D) * f8;
        float f10 = oc62a465bc97.\u057f(L.\u026d(0x619212A5 ^ 0x61B9404D), f8);
        float f11 = f6 / f8;
        float f12 = f7 / f8;
        if (!bl) {
            f11 = 0.0f;
            f12 = 0.0f;
        }
        float f13 = bl ? f11 : L.\u026d(0x619212FD ^ 0x61B9404D);
        oc06b9308b3c2.\u013f[0] = f5 = bl ? f12 : L.\u026d(0x619212F9 ^ 0x61B9404D);
        oc06b9308b3c2.\u013f[1] = Float.intBitsToFloat(Float.floatToRawIntBits(f11) ^ L.\u0497(0x6192128D ^ 0x61B9404D));
        oc06b9308b3c2.\u013f[0x61B9404F ^ 0x61B9404D] = f13;
        oc06b9308b3c2.\u013f[0x61B9404E ^ 0x61B9404D] = f5;
        oc06b9308b3c2.\u013f[0x61B94049 ^ 0x61B9404D] = L.\u026d(0x6192129D ^ 0x61B9404D) * f13 + f;
        oc06b9308b3c2.\u013f[0x61B94048 ^ 0x61B9404D] = L.\u026d(0x61921299 ^ 0x61B9404D) * f5 + f2;
        oc06b9308b3c2.\u026a[0] = Float.intBitsToFloat(0x267A104D ^ 0x61B9404D);
        oc06b9308b3c2.\u026a[1] = f9 + L.\u026d(0x619212A9 ^ 0x61B9404D);
        oc06b9308b3c2.\u04b2 = f10;
        System.arraycopy(fArray, 0, oc06b9308b3c2.\u0180, 0, 0x61B94049 ^ 0x61B9404D);
        System.arraycopy(fArray2, 0, oc06b9308b3c2.\u02af, 0, 0x61B94049 ^ 0x61B9404D);
        return oc06b9308b3c2;
    }

    public void \u0196(ocbc6f0988cd ocbc6f0988cd2, oc1dbdddc1e9 oc1dbdddc1e92, A a, boolean bl) {
        oc840d7c857b oc840d7c857b2 = this.\u048c();
        oc06b9308b3c oc06b9308b3c2 = oc840d7c857b2.\u0573.\u0449();
        ocbc6f0988cd2.\u01c6();
        ocbc6f0988cd2.\u0531(bl && oc840d7c857b2.\u0256 != 0 ? ocbc6f0988cd2.\u048d : 0.0f);
        oc06b9308b3c2.\u0180[0x575935AB ^ 0x575935A8] = oc06b9308b3c2.\u0180[0x575935AB ^ 0x575935A8] * oc840d7c857b2.X;
        oc06b9308b3c2.\u02af[0x575935AB ^ 0x575935A8] = oc840d7c857b2.X * oc06b9308b3c2.\u02af[0x575935AB ^ 0x575935A8];
        oc1dbdddc1e92.z$219pbvor6g5ok(oc06b9308b3c2, (int[])oc840d7c857b2.\u03f2.clone(), (float[])oc840d7c857b2.\u0150.clone(), (float[])oc840d7c857b2.\u029a.clone(), ocbc6f0988cd2.\u048d, ocbc6f0988cd2.\u0398(), (float[])ocbc6f0988cd2.\u00c7.clone());
        for (ocb579fc6994 ocb579fc69942 : ocbc6f0988cd2.\u0398()) {
            a.\u011a += ocb579fc69942.\u0389.size() + ocb579fc69942.\u0145.size() - (0x575935AC ^ 0x575935A8);
            a.\u0295 += 0x575935AA ^ 0x575935A8;
        }
    }

    public void \u0235(ocbc6f0988cd ocbc6f0988cd2, oc1dbdddc1e9 oc1dbdddc1e92, A a, boolean bl) {
        float f;
        oc840d7c857b oc840d7c857b2 = this.\u048c();
        float[] fArray = oc840d7c857b2.\u01f9;
        float f2 = (float)StrictMath.sqrt(fArray[0] * fArray[0] + fArray[0x6A8F44B4 ^ 0x6A8F44B6] * fArray[0x6A8F44B4 ^ 0x6A8F44B6]);
        float f3 = (float)StrictMath.sqrt(fArray[1] * fArray[1] + fArray[0x6A8F44B5 ^ 0x6A8F44B6] * fArray[0x6A8F44B5 ^ 0x6A8F44B6]);
        float f4 = (f3 + f2) * L.\u026d(0x6AA412B6 ^ 0x6A8F44B6) * oc840d7c857b2.\u0229;
        float f5 = oc62a465bc97.\u0517(L.\u026d(0x6AA412B2 ^ 0x6A8F44B6), f4);
        f4 = f4 < 0.0f ? 0.0f : f5;
        oc06b9308b3c oc06b9308b3c2 = oc840d7c857b2.\u012e.\u0449();
        float f6 = ocbc6f0988cd2.\u048d;
        if (f6 > f4) {
            f = f4 / f6;
            float f7 = oc62a465bc97.\u0517(L.\u026d(0x6AA412BE ^ 0x6A8F44B6), f);
            f = f < 0.0f ? 0.0f : f7;
            f *= f;
            oc06b9308b3c2.\u0180[0x6A8F44B5 ^ 0x6A8F44B6] = oc06b9308b3c2.\u0180[0x6A8F44B5 ^ 0x6A8F44B6] * f;
            oc06b9308b3c2.\u02af[0x6A8F44B5 ^ 0x6A8F44B6] = oc06b9308b3c2.\u02af[0x6A8F44B5 ^ 0x6A8F44B6] * f;
        } else {
            f6 = f4;
        }
        oc06b9308b3c2.\u0180[0x6A8F44B5 ^ 0x6A8F44B6] = oc06b9308b3c2.\u0180[0x6A8F44B5 ^ 0x6A8F44B6] * oc840d7c857b2.X;
        oc06b9308b3c2.\u02af[0x6A8F44B5 ^ 0x6A8F44B6] = oc06b9308b3c2.\u02af[0x6A8F44B5 ^ 0x6A8F44B6] * oc840d7c857b2.X;
        ocbc6f0988cd2.\u01c6();
        f = bl && oc840d7c857b2.\u0256 != 0 ? ocbc6f0988cd2.\u048d : 0.0f;
        ocbc6f0988cd2.\u0188(L.\u026d(0x6AA412B6 ^ 0x6A8F44B6) * f6, f, oc840d7c857b2.\u0403, oc840d7c857b2.\u04e1, oc840d7c857b2.\u010c);
        oc1dbdddc1e92.z$3iv8gkrmvrc59(oc06b9308b3c2, (int[])oc840d7c857b2.\u03f2.clone(), (float[])oc840d7c857b2.\u0150.clone(), (float[])oc840d7c857b2.\u029a.clone(), ocbc6f0988cd2.\u048d, f6, ocbc6f0988cd2.\u0398());
        for (ocb579fc6994 ocb579fc69942 : ocbc6f0988cd2.\u0398()) {
            a.\u038c += ocb579fc69942.\u0145.size() - (0x6A8F44B4 ^ 0x6A8F44B6);
            ++a.\u0295;
        }
    }
}

