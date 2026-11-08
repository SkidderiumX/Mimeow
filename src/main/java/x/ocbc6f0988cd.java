/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.L;
import x.oc1b68625d17;
import x.oc3004491957;
import x.oc62a465bc97;
import x.oc77bf9fb04c;
import x.ocb579fc6994;
import x.ocba3c42d463;

public class ocbc6f0988cd {
    private final List<Float> \u01f3 = new ArrayList<Float>();
    private final List<ocb579fc6994> \u00d6 = new ArrayList<ocb579fc6994>();
    public final float[] \u00c7 = new float[0x72A07C6B ^ 0x72A07C6F];
    public final float \u04d0;
    public final float \u057c;
    public final float \u048d;

    public ocbc6f0988cd(float f, float f2, float f3) {
        this.\u04d0 = f;
        this.\u057c = f2;
        this.\u048d = f3;
    }

    private static float \u03b5(int n) {
        return L.\u026d(n);
    }

    private static float \u011a(float f) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) ^ (0x19FE20D5 ^ 0x99FE20D5));
    }

    private static float \u057a(float f) {
        float f2 = ocbc6f0988cd.\u011a(f);
        return f2 <= f ? f : f2;
    }

    public ocbc6f0988cd \u048e(float ... fArray) {
        for (float f : fArray) {
            this.\u01f3.add(Float.valueOf(f));
        }
        this.\u00d6.clear();
        return this;
    }

    public ocbc6f0988cd \u04ab(float[] fArray) {
        int n;
        for (int i = 0; i < this.\u01f3.size(); i += n) {
            int n2 = (int)this.\u01f3.get(i).floatValue();
            int n3 = n2 != 0 && n2 != 1 ? (n2 == (0x9A32FDA3 ^ 0x9A32FDA1) ? 0x9A32FDA2 ^ 0x9A32FDA1 : 0) : 1;
            for (int j = 0; j < n3; ++j) {
                int n4 = i + 1 + j * (0x9A32FDA3 ^ 0x9A32FDA1);
                float f = this.\u01f3.get(n4).floatValue();
                float f2 = this.\u01f3.get(n4 + 1).floatValue();
                this.\u01f3.set(n4, Float.valueOf(f * fArray[0] + f2 * fArray[0x9A32FDA3 ^ 0x9A32FDA1] + fArray[0x9A32FDA5 ^ 0x9A32FDA1]));
                this.\u01f3.set(n4 + 1, Float.valueOf(f * fArray[1] + f2 * fArray[0x9A32FDA2 ^ 0x9A32FDA1] + fArray[0x9A32FDA4 ^ 0x9A32FDA1]));
            }
            if (n2 != 0 && n2 != 1) {
                if (n2 == (0x9A32FDA3 ^ 0x9A32FDA1)) {
                    n = 0x9A32FDA6 ^ 0x9A32FDA1;
                    continue;
                }
                if (n2 == (0x9A32FDA5 ^ 0x9A32FDA1)) {
                    n = 0x9A32FDA3 ^ 0x9A32FDA1;
                    continue;
                }
                n = 1;
                continue;
            }
            n = 0x9A32FDA2 ^ 0x9A32FDA1;
        }
        this.\u00d6.clear();
        return this;
    }

    public ocbc6f0988cd \u0224(float f, float f2, float f3, float f4) {
        float[] fArray = new float[0xB0221B9B ^ 0xB0221B96];
        fArray[0] = 0.0f;
        fArray[1] = f;
        fArray[0xB0221B94 ^ 0xB0221B96] = f2;
        fArray[0xB0221B95 ^ 0xB0221B96] = 1.0f;
        fArray[0xB0221B92 ^ 0xB0221B96] = f;
        fArray[0xB0221B93 ^ 0xB0221B96] = f4 + f2;
        fArray[0xB0221B90 ^ 0xB0221B96] = 1.0f;
        fArray[0xB0221B91 ^ 0xB0221B96] = f3 + f;
        fArray[0xB0221B9E ^ 0xB0221B96] = f4 + f2;
        fArray[0xB0221B9F ^ 0xB0221B96] = 1.0f;
        fArray[0xB0221B9C ^ 0xB0221B96] = f3 + f;
        fArray[0xB0221B9D ^ 0xB0221B96] = f2;
        fArray[0xB0221B9A ^ 0xB0221B96] = 3.0f;
        return this.\u048e(fArray);
    }

    public ocbc6f0988cd \u0225(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ocbc6f0988cd.\u03b5(0xA87C4B4F ^ 0xA8571FAF);
        if (f9 > f5 && f9 > f6 && f9 > f7 && f9 > f8) {
            return this.\u0224(f, f2, f3, f4);
        }
        float f10 = ocbc6f0988cd.\u011a(f3);
        float f11 = ocbc6f0988cd.\u011a(f4);
        float f12 = (f3 >= f10 ? f3 : f10) * ocbc6f0988cd.\u03b5(0xA87C4AAF ^ 0xA8571FAF);
        float f13 = (f4 >= f11 ? f4 : f11) * ocbc6f0988cd.\u03b5(0xA87C4AAF ^ 0xA8571FAF);
        float f14 = ocbc6f0988cd.\u03b5(f10 <= f3 ? 0xA87C4AAB ^ 0xA8571FAF : 0xA87C4AA7 ^ 0xA8571FAF);
        float f15 = ocbc6f0988cd.\u03b5(f11 <= f4 ? 0xA87C4AAB ^ 0xA8571FAF : 0xA87C4AA7 ^ 0xA8571FAF);
        float f16 = oc62a465bc97.\u0517(f8, f12) * f14;
        float f17 = oc62a465bc97.\u0517(f8, f13) * f15;
        float f18 = oc62a465bc97.\u0517(f7, f12) * f14;
        float f19 = oc62a465bc97.\u0517(f7, f13) * f15;
        float f20 = oc62a465bc97.\u0517(f6, f12) * f14;
        float f21 = oc62a465bc97.\u0517(f6, f13) * f15;
        float f22 = oc62a465bc97.\u0517(f5, f12) * f14;
        float f23 = oc62a465bc97.\u0517(f5, f13) * f15;
        float f24 = f4 + f2;
        float f25 = f3 + f;
        float f26 = ocbc6f0988cd.\u03b5(0xA87C4A8F ^ 0xA8571FAF);
        float f27 = ocbc6f0988cd.\u03b5(0xA87C4ABF ^ 0xA8571FAF);
        float f28 = ocbc6f0988cd.\u03b5(0xA87C4ABB ^ 0xA8571FAF);
        float[] fArray = new float[0xA8571F83 ^ 0xA8571FAF];
        fArray[0] = 0.0f;
        fArray[1] = f;
        fArray[0xA8571FAD ^ 0xA8571FAF] = f2 + f23;
        fArray[0xA8571FAC ^ 0xA8571FAF] = 1.0f;
        fArray[0xA8571FAB ^ 0xA8571FAF] = f;
        fArray[0xA8571FAA ^ 0xA8571FAF] = f24 - f17;
        fArray[0xA8571FA9 ^ 0xA8571FAF] = 2.0f;
        fArray[0xA8571FA8 ^ 0xA8571FAF] = f;
        fArray[0xA8571FA7 ^ 0xA8571FAF] = ocbc6f0988cd.\u011a(f17) * f27 + f24;
        fArray[0xA8571FA6 ^ 0xA8571FAF] = f16 * f28 + f;
        fArray[0xA8571FA5 ^ 0xA8571FAF] = f24;
        fArray[0xA8571FA4 ^ 0xA8571FAF] = f16 + f;
        fArray[0xA8571FA3 ^ 0xA8571FAF] = f24;
        fArray[0xA8571FA2 ^ 0xA8571FAF] = 1.0f;
        fArray[0xA8571FA1 ^ 0xA8571FAF] = f25 - f18;
        fArray[0xA8571FA0 ^ 0xA8571FAF] = f24;
        fArray[0xA8571FBF ^ 0xA8571FAF] = 2.0f;
        fArray[0xA8571FBE ^ 0xA8571FAF] = f25 - f18 * f26;
        fArray[0xA8571FBD ^ 0xA8571FAF] = f24;
        fArray[0xA8571FBC ^ 0xA8571FAF] = f25;
        fArray[0xA8571FBB ^ 0xA8571FAF] = f24 - f19 * f26;
        fArray[0xA8571FBA ^ 0xA8571FAF] = f25;
        fArray[0xA8571FB9 ^ 0xA8571FAF] = f24 - f19;
        fArray[0xA8571FB8 ^ 0xA8571FAF] = 1.0f;
        fArray[0xA8571FB7 ^ 0xA8571FAF] = f25;
        fArray[0xA8571FB6 ^ 0xA8571FAF] = f21 + f2;
        fArray[0xA8571FB5 ^ 0xA8571FAF] = 2.0f;
        fArray[0xA8571FB4 ^ 0xA8571FAF] = f25;
        fArray[0xA8571FB3 ^ 0xA8571FAF] = f21 * f27 + f2;
        fArray[0xA8571FB2 ^ 0xA8571FAF] = ocbc6f0988cd.\u011a(f20) * f28 + f25;
        fArray[0xA8571FB1 ^ 0xA8571FAF] = f2;
        fArray[0xA8571FB0 ^ 0xA8571FAF] = f25 - f20;
        fArray[0xA8571F8F ^ 0xA8571FAF] = f2;
        fArray[0xA8571F8E ^ 0xA8571FAF] = 1.0f;
        fArray[0xA8571F8D ^ 0xA8571FAF] = f + f22;
        fArray[0xA8571F8C ^ 0xA8571FAF] = f2;
        fArray[0xA8571F8B ^ 0xA8571FAF] = 2.0f;
        fArray[0xA8571F8A ^ 0xA8571FAF] = f22 * f26 + f;
        fArray[0xA8571F89 ^ 0xA8571FAF] = f2;
        fArray[0xA8571F88 ^ 0xA8571FAF] = f;
        fArray[0xA8571F87 ^ 0xA8571FAF] = f23 * f26 + f2;
        fArray[0xA8571F86 ^ 0xA8571FAF] = f;
        fArray[0xA8571F85 ^ 0xA8571FAF] = f2 + f23;
        fArray[0xA8571F84 ^ 0xA8571FAF] = 3.0f;
        return this.\u048e(fArray);
    }

    public ocbc6f0988cd \u022b(float f, float f2, float f3, float f4) {
        float f5 = ocbc6f0988cd.\u03b5(0xA2AC6CC4 ^ 0xA2873984);
        float f6 = ocbc6f0988cd.\u03b5(0xA2AC6CC0 ^ 0xA2873984);
        float f7 = f - f3;
        float f8 = f + f3;
        float f9 = f2 + f4;
        float f10 = f2 - f4;
        float f11 = f4 * f5 + f2;
        float f12 = ocbc6f0988cd.\u011a(f3) * f6 + f;
        float f13 = ocbc6f0988cd.\u011a(f4) * f5 + f2;
        float f14 = f3 * f6 + f;
        float[] fArray = new float[0xA28739A4 ^ 0xA2873984];
        fArray[0] = 0.0f;
        fArray[1] = f7;
        fArray[0xA2873986 ^ 0xA2873984] = f2;
        fArray[0xA2873987 ^ 0xA2873984] = 2.0f;
        fArray[0xA2873980 ^ 0xA2873984] = f7;
        fArray[0xA2873981 ^ 0xA2873984] = f11;
        fArray[0xA2873982 ^ 0xA2873984] = f12;
        fArray[0xA2873983 ^ 0xA2873984] = f9;
        fArray[0xA287398C ^ 0xA2873984] = f;
        fArray[0xA287398D ^ 0xA2873984] = f9;
        fArray[0xA287398E ^ 0xA2873984] = 2.0f;
        fArray[0xA287398F ^ 0xA2873984] = f14;
        fArray[0xA2873988 ^ 0xA2873984] = f9;
        fArray[0xA2873989 ^ 0xA2873984] = f8;
        fArray[0xA287398A ^ 0xA2873984] = f11;
        fArray[0xA287398B ^ 0xA2873984] = f8;
        fArray[0xA2873994 ^ 0xA2873984] = f2;
        fArray[0xA2873995 ^ 0xA2873984] = 2.0f;
        fArray[0xA2873996 ^ 0xA2873984] = f8;
        fArray[0xA2873997 ^ 0xA2873984] = f13;
        fArray[0xA2873990 ^ 0xA2873984] = f14;
        fArray[0xA2873991 ^ 0xA2873984] = f10;
        fArray[0xA2873992 ^ 0xA2873984] = f;
        fArray[0xA2873993 ^ 0xA2873984] = f10;
        fArray[0xA287399C ^ 0xA2873984] = 2.0f;
        fArray[0xA287399D ^ 0xA2873984] = f12;
        fArray[0xA287399E ^ 0xA2873984] = f10;
        fArray[0xA287399F ^ 0xA2873984] = f7;
        fArray[0xA2873998 ^ 0xA2873984] = f13;
        fArray[0xA2873999 ^ 0xA2873984] = f7;
        fArray[0xA287399A ^ 0xA2873984] = f2;
        fArray[0xA287399B ^ 0xA2873984] = 3.0f;
        return this.\u048e(fArray);
    }

    public List<Float> \u010e() {
        return Collections.unmodifiableList(this.\u01f3);
    }

    public List<ocb579fc6994> \u0398() {
        this.\u01c6();
        return Collections.unmodifiableList(this.\u00d6);
    }

    private void \u0160(ocb579fc6994 ocb579fc69942, float f, float f2, int n) {
        if (!ocb579fc69942.\u03d4.isEmpty()) {
            oc1b68625d17 oc1b68625d172 = ocb579fc69942.\u03d4.get(ocb579fc69942.\u03d4.size() - 1);
            float f3 = f - oc1b68625d172.\u03c1;
            float f4 = f2 - oc1b68625d172.\u011b;
            if (this.\u057c * this.\u057c > f3 * f3 + f4 * f4) {
                oc1b68625d172.\u0243 |= n;
                return;
            }
        }
        ocb579fc69942.\u03d4.add(new oc1b68625d17(f, f2, n));
    }

    private void \u01ea(ocb579fc6994 ocb579fc69942, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2) {
        if (n <= (0x8F5A5892 ^ 0x8F5A5898)) {
            float f9 = f7 - f;
            float f10 = f8 - f2;
            float f11 = ocbc6f0988cd.\u057a((f3 - f7) * f10 - (f4 - f8) * f9);
            float f12 = ocbc6f0988cd.\u057a((f5 - f7) * f10 - (f6 - f8) * f9);
            float f13 = f12 + f11;
            if ((f9 * f9 + f10 * f10) * this.\u04d0 > f13 * f13) {
                this.\u0160(ocb579fc69942, f7, f8, n2);
            } else {
                float f14 = ocbc6f0988cd.\u03b5(0x8F7138F8 ^ 0x8F5A5898);
                float f15 = (f + f3) * f14;
                float f16 = (f2 + f4) * f14;
                float f17 = (f3 + f5) * f14;
                float f18 = (f4 + f6) * f14;
                float f19 = (f7 + f5) * f14;
                float f20 = (f8 + f6) * f14;
                float f21 = (f17 + f15) * f14;
                float f22 = (f18 + f16) * f14;
                float f23 = (f17 + f19) * f14;
                float f24 = (f18 + f20) * f14;
                float f25 = (f23 + f21) * f14;
                float f26 = (f24 + f22) * f14;
                this.\u01ea(ocb579fc69942, f, f2, f15, f16, f21, f22, f25, f26, n + 1, 0);
                this.\u01ea(ocb579fc69942, f25, f26, f23, f24, f19, f20, f7, f8, n + 1, n2);
            }
        }
    }

    public void \u01c6() {
        if (this.\u00d6.isEmpty()) {
            int n;
            ocb579fc6994 ocb579fc69942 = null;
            int n2 = 0;
            while (n2 < this.\u01f3.size()) {
                n = oc3004491957.\u0182(this.\u01f3.get(n2).floatValue());
                if (n == 0) {
                    ocb579fc69942 = new ocb579fc6994();
                    this.\u00d6.add(ocb579fc69942);
                }
                if (n != 0 && n != 1) {
                    if (n == (0xFCECC04D ^ 0xFCECC04F)) {
                        if (ocb579fc69942 != null && !ocb579fc69942.\u03d4.isEmpty()) {
                            oc1b68625d17 oc1b68625d172 = ocb579fc69942.\u03d4.get(ocb579fc69942.\u03d4.size() - 1);
                            this.\u01ea(ocb579fc69942, oc1b68625d172.\u03c1, oc1b68625d172.\u011b, this.\u01f3.get(n2 + 1).floatValue(), this.\u01f3.get(n2 + (0xFCECC04D ^ 0xFCECC04F)).floatValue(), this.\u01f3.get(n2 + (0xFCECC04C ^ 0xFCECC04F)).floatValue(), this.\u01f3.get(n2 + (0xFCECC04B ^ 0xFCECC04F)).floatValue(), this.\u01f3.get(n2 + (0xFCECC04A ^ 0xFCECC04F)).floatValue(), this.\u01f3.get(n2 + (0xFCECC049 ^ 0xFCECC04F)).floatValue(), 0, 1);
                        }
                        n2 += 7;
                        continue;
                    }
                    if (n == (0xFCECC04C ^ 0xFCECC04F)) {
                        if (ocb579fc69942 != null) {
                            ocb579fc69942.B = true;
                        }
                        ++n2;
                        continue;
                    }
                    if (n == (0xFCECC04B ^ 0xFCECC04F)) {
                        if (ocb579fc69942 != null) {
                            ocb579fc69942.\u0462 = oc3004491957.\u0182(this.\u01f3.get(n2 + 1).floatValue());
                        }
                        n2 += 2;
                        continue;
                    }
                    ++n2;
                    continue;
                }
                if (ocb579fc69942 != null) {
                    this.\u0160(ocb579fc69942, this.\u01f3.get(n2 + 1).floatValue(), this.\u01f3.get(n2 + (0xFCECC04D ^ 0xFCECC04F)).floatValue(), 1);
                }
                n2 += 3;
            }
            for (n = 0; n < (0xFCECC04B ^ 0xFCECC04F); ++n) {
                this.\u00c7[n] = ocbc6f0988cd.\u03b5((0xFCC795CF ^ 0xFCECC04F) + (0xFCECC04B ^ 0xFCECC04F) * n);
            }
            float f = ocbc6f0988cd.\u03b5(0xFCC795DF ^ 0xFCECC04F);
            float f2 = ocbc6f0988cd.\u03b5(0xFCC795DB ^ 0xFCECC04F);
            float f3 = ocbc6f0988cd.\u03b5(0xFCC795D7 ^ 0xFCECC04F);
            for (ocb579fc6994 ocb579fc69943 : this.\u00d6) {
                List<oc1b68625d17> list = ocb579fc69943.\u03d4;
                if (list.isEmpty()) continue;
                oc1b68625d17 oc1b68625d173 = list.get(0);
                oc1b68625d17 oc1b68625d174 = list.get(list.size() - 1);
                float f4 = oc1b68625d173.\u03c1 - oc1b68625d174.\u03c1;
                float f5 = oc1b68625d173.\u011b - oc1b68625d174.\u011b;
                if (this.\u057c * this.\u057c > f4 * f4 + f5 * f5) {
                    list.remove(list.size() - 1);
                    ocb579fc69943.B = true;
                }
                if (list.size() > (0xFCECC04D ^ 0xFCECC04F)) {
                    float f6 = 0.0f;
                    for (int i = 0xFCECC04D ^ 0xFCECC04F; i < list.size(); ++i) {
                        oc1b68625d17 oc1b68625d175 = list.get(i - 1);
                        oc1b68625d17 oc1b68625d176 = list.get(i);
                        f6 += (oc1b68625d176.\u03c1 - oc1b68625d173.\u03c1) * (oc1b68625d175.\u011b - oc1b68625d173.\u011b) - (oc1b68625d176.\u011b - oc1b68625d173.\u011b) * (oc1b68625d175.\u03c1 - oc1b68625d173.\u03c1);
                    }
                    f6 *= f;
                    if (ocb579fc69943.\u0462 == 1 && 0.0f > f6 || ocb579fc69943.\u0462 == (0xFCECC04D ^ 0xFCECC04F) && f6 > 0.0f) {
                        Collections.reverse(list);
                    }
                }
                if (list.isEmpty()) continue;
                oc1b68625d17 oc1b68625d177 = list.get(list.size() - 1);
                for (oc1b68625d17 oc1b68625d175 : list) {
                    f4 = oc1b68625d175.\u03c1 - oc1b68625d177.\u03c1;
                    f5 = oc1b68625d175.\u011b - oc1b68625d177.\u011b;
                    float f7 = (float)StrictMath.sqrt(f4 * f4 + f5 * f5);
                    if (f7 > f2) {
                        float f8 = f3 / f7;
                        f4 *= f8;
                        f5 *= f8;
                    }
                    oc1b68625d177.\u01bd = f4;
                    oc1b68625d177.\u0259 = f5;
                    oc1b68625d177.\u0376 = f7;
                    this.\u00c7[0] = oc62a465bc97.\u0517(this.\u00c7[0], oc1b68625d177.\u03c1);
                    this.\u00c7[1] = oc62a465bc97.\u0517(this.\u00c7[1], oc1b68625d177.\u011b);
                    this.\u00c7[0xFCECC04D ^ 0xFCECC04F] = oc62a465bc97.\u057f(this.\u00c7[0xFCECC04D ^ 0xFCECC04F], oc1b68625d177.\u03c1);
                    this.\u00c7[0xFCECC04C ^ 0xFCECC04F] = oc62a465bc97.\u057f(this.\u00c7[0xFCECC04C ^ 0xFCECC04F], oc1b68625d177.\u011b);
                    oc1b68625d177 = oc1b68625d175;
                }
            }
        }
    }

    public void \u014a(float f, int n, float f2) {
        this.\u01c6();
        float f3 = ocbc6f0988cd.\u03b5(0xF20FA90D ^ 0xF224C98D);
        float f4 = ocbc6f0988cd.\u03b5(0xF20FA92D ^ 0xF224C98D);
        float f5 = ocbc6f0988cd.\u03b5(0xF20FA929 ^ 0xF224C98D);
        float f6 = ocbc6f0988cd.\u03b5(0xF20FA925 ^ 0xF224C98D);
        float f7 = ocbc6f0988cd.\u03b5(0xF20FA921 ^ 0xF224C98D);
        float f8 = f > 0.0f ? f3 / f : 0.0f;
        for (ocb579fc6994 ocb579fc69942 : this.\u00d6) {
            ocb579fc69942.\u0203 = 0;
            int n2 = 0;
            if (ocb579fc69942.\u03d4.isEmpty()) continue;
            oc1b68625d17 oc1b68625d172 = ocb579fc69942.\u03d4.get(ocb579fc69942.\u03d4.size() - 1);
            for (oc1b68625d17 oc1b68625d173 : ocb579fc69942.\u03d4) {
                float f9;
                float f10;
                oc1b68625d173.\u0160 = (oc1b68625d172.\u0259 + oc1b68625d173.\u0259) * f4;
                oc1b68625d173.\u0201 = (ocbc6f0988cd.\u011a(oc1b68625d173.\u01bd) - oc1b68625d172.\u01bd) * f4;
                float f11 = oc1b68625d173.\u0160 * oc1b68625d173.\u0160 + oc1b68625d173.\u0201 * oc1b68625d173.\u0201;
                if (f11 > f5) {
                    f10 = oc62a465bc97.\u0517(f6, f3 / f11);
                    oc1b68625d173.\u0160 *= f10;
                    oc1b68625d173.\u0201 *= f10;
                }
                oc1b68625d173.\u0243 &= 1;
                f10 = oc1b68625d172.\u0259 * oc1b68625d173.\u01bd - oc1b68625d172.\u01bd * oc1b68625d173.\u0259;
                if (f10 > 0.0f) {
                    ++n2;
                    oc1b68625d173.\u0243 |= 0xF224C98F ^ 0xF224C98D;
                }
                if (f3 > f11 * (f9 = oc62a465bc97.\u057f(f7, oc62a465bc97.\u0517(oc1b68625d172.\u0376, oc1b68625d173.\u0376) * f8)) * f9) {
                    oc1b68625d173.\u0243 |= 0xF224C985 ^ 0xF224C98D;
                }
                if ((oc1b68625d173.\u0243 & 1) != 0 && ((n & (0xDDB3670 ^ 0xF224C98D)) == 1 || f3 > f11 * f2 * f2)) {
                    oc1b68625d173.\u0243 |= 0xF224C989 ^ 0xF224C98D;
                }
                if ((oc1b68625d173.\u0243 & (0xF224C981 ^ 0xF224C98D)) != 0) {
                    ++ocb579fc69942.\u0203;
                }
                oc1b68625d172 = oc1b68625d173;
            }
            ocb579fc69942.\u03ec = n2 == ocb579fc69942.\u03d4.size();
        }
    }

    private static void \u03ac(List<float[]> list, float f, float f2, float f3) {
        ocbc6f0988cd.\u023c(list, f, f2, f3, 1.0f);
    }

    private static void \u023c(List<float[]> list, float f, float f2, float f3, float f4) {
        float[] fArray = new float[0xF3DBC2B2 ^ 0xF3DBC2B6];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0xF3DBC2B4 ^ 0xF3DBC2B6] = f3;
        fArray[0xF3DBC2B5 ^ 0xF3DBC2B6] = f4;
        list.add(fArray);
    }

    private static float[][] \u03a3(boolean bl, oc1b68625d17 oc1b68625d172, oc1b68625d17 oc1b68625d173, float f) {
        float[] fArray;
        float[] fArray2;
        if (bl) {
            float[] fArray3 = new float[0x8F7327D8 ^ 0x8F7327DA];
            fArray3[0] = oc1b68625d172.\u0259 * f + oc1b68625d173.\u03c1;
            fArray2 = fArray3;
            fArray3[1] = oc1b68625d173.\u011b - oc1b68625d172.\u01bd * f;
        } else {
            float[] fArray4 = new float[0x8F7327D8 ^ 0x8F7327DA];
            fArray4[0] = oc1b68625d173.\u0160 * f + oc1b68625d173.\u03c1;
            fArray2 = fArray4;
            fArray4[1] = oc1b68625d173.\u0201 * f + oc1b68625d173.\u011b;
        }
        float[] fArray5 = fArray2;
        if (bl) {
            float[] fArray6 = new float[0x8F7327D8 ^ 0x8F7327DA];
            fArray6[0] = oc1b68625d173.\u0259 * f + oc1b68625d173.\u03c1;
            fArray = fArray6;
            fArray6[1] = oc1b68625d173.\u011b - oc1b68625d173.\u01bd * f;
        } else {
            fArray = (float[])fArray5.clone();
        }
        float[] fArray7 = fArray;
        float[][] fArrayArray = new float[0x8F7327D8 ^ 0x8F7327DA][];
        fArrayArray[0] = fArray5;
        fArrayArray[1] = fArray7;
        return fArrayArray;
    }

    public static void \u03f1(List<float[]> list, oc1b68625d17 oc1b68625d172, oc1b68625d17 oc1b68625d173, float f, float f2, float f3, float f4) {
        boolean bl = (oc1b68625d173.\u0243 & (0xCE4AF5FC ^ 0xCE4AF5FE)) != 0;
        float[][] fArray = ocbc6f0988cd.\u03a3((oc1b68625d173.\u0243 & (0xCE4AF5F6 ^ 0xCE4AF5FE)) != 0, oc1b68625d172, oc1b68625d173, bl ? f : ocbc6f0988cd.\u011a(f2));
        float f5 = bl ? ocbc6f0988cd.\u011a(f2) : f;
        float f6 = oc1b68625d172.\u0259 * f5 + oc1b68625d173.\u03c1;
        float f7 = ocbc6f0988cd.\u011a(oc1b68625d172.\u01bd) * f5 + oc1b68625d173.\u011b;
        float f8 = oc1b68625d173.\u0259 * f5 + oc1b68625d173.\u03c1;
        float f9 = ocbc6f0988cd.\u011a(oc1b68625d173.\u01bd) * f5 + oc1b68625d173.\u011b;
        float[] fArray2 = fArray[0];
        float[] fArray3 = fArray[1];
        if (bl) {
            ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f3);
            ocbc6f0988cd.\u03ac(list, f6, f7, f4);
        } else {
            ocbc6f0988cd.\u03ac(list, f6, f7, f3);
            ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f4);
        }
        if ((oc1b68625d173.\u0243 & (0xCE4AF5FA ^ 0xCE4AF5FE)) != 0) {
            if (bl) {
                ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f3);
                ocbc6f0988cd.\u03ac(list, f6, f7, f4);
                ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f3);
                ocbc6f0988cd.\u03ac(list, f8, f9, f4);
            } else {
                ocbc6f0988cd.\u03ac(list, f6, f7, f3);
                ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f4);
                ocbc6f0988cd.\u03ac(list, f8, f9, f3);
                ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f4);
            }
        } else {
            float f10 = oc1b68625d173.\u0160 * f5 + oc1b68625d173.\u03c1;
            float f11 = oc1b68625d173.\u0201 * f5 + oc1b68625d173.\u011b;
            if (bl) {
                ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
                ocbc6f0988cd.\u03ac(list, f6, f7, f4);
                ocbc6f0988cd.\u03ac(list, f10, f11, f4);
                ocbc6f0988cd.\u03ac(list, f10, f11, f4);
                ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
                ocbc6f0988cd.\u03ac(list, f8, f9, f4);
            } else {
                ocbc6f0988cd.\u03ac(list, f6, f7, f3);
                ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
                ocbc6f0988cd.\u03ac(list, f10, f11, f3);
                ocbc6f0988cd.\u03ac(list, f10, f11, f3);
                ocbc6f0988cd.\u03ac(list, f8, f9, f3);
                ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
            }
        }
        if (bl) {
            ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f3);
            ocbc6f0988cd.\u03ac(list, f8, f9, f4);
        } else {
            ocbc6f0988cd.\u03ac(list, f8, f9, f3);
            ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f4);
        }
    }

    public void \u0531(float f) {
        this.\u014a(f, 0xF74423C2 ^ 0xF74423C6, ocbc6f0988cd.\u03b5(0xF76F7676 ^ 0xF74423C6));
        boolean bl = this.\u00d6.size() == 1 && this.\u00d6.get((int)0).\u03ec;
        float f2 = this.\u048d * ocbc6f0988cd.\u03b5(0xF76F7672 ^ 0xF74423C6);
        float f3 = bl ? f2 : f + f2;
        float f4 = f - f2;
        float f5 = bl ? ocbc6f0988cd.\u03b5(0xF76F7672 ^ 0xF74423C6) : 0.0f;
        for (ocb579fc6994 ocb579fc69942 : this.\u00d6) {
            ocb579fc69942.\u0389.clear();
            ocb579fc69942.\u0145.clear();
            if (ocb579fc69942.\u03d4.isEmpty()) continue;
            oc1b68625d17 object2 = ocb579fc69942.\u03d4.get(ocb579fc69942.\u03d4.size() - 1);
            for (oc1b68625d17 oc1b68625d172 : ocb579fc69942.\u03d4) {
                if (f > 0.0f) {
                    if ((oc1b68625d172.\u0243 & (0xF74423C2 ^ 0xF74423C6)) != 0 && (oc1b68625d172.\u0243 & (0xF74423C4 ^ 0xF74423C6)) == 0) {
                        ocbc6f0988cd.\u03ac(ocb579fc69942.\u0389, object2.\u0259 * f2 + oc1b68625d172.\u03c1, ocbc6f0988cd.\u011a(object2.\u01bd) * f2 + oc1b68625d172.\u011b, 0.5f);
                        ocbc6f0988cd.\u03ac(ocb579fc69942.\u0389, oc1b68625d172.\u0259 * f2 + oc1b68625d172.\u03c1, oc1b68625d172.\u011b - oc1b68625d172.\u01bd * f2, 0.5f);
                    } else {
                        ocbc6f0988cd.\u03ac(ocb579fc69942.\u0389, oc1b68625d172.\u0160 * f2 + oc1b68625d172.\u03c1, oc1b68625d172.\u0201 * f2 + oc1b68625d172.\u011b, 0.5f);
                    }
                } else {
                    ocbc6f0988cd.\u03ac(ocb579fc69942.\u0389, oc1b68625d172.\u03c1, oc1b68625d172.\u011b, 0.5f);
                }
                object2 = oc1b68625d172;
            }
            if (!(f > 0.0f)) continue;
            object2 = ocb579fc69942.\u03d4.get(ocb579fc69942.\u03d4.size() - 1);
            for (oc1b68625d17 oc1b68625d173 : ocb579fc69942.\u03d4) {
                if ((oc1b68625d173.\u0243 & (0xF74423CA ^ 0xF74423C6)) != 0) {
                    ocbc6f0988cd.\u03f1(ocb579fc69942.\u0145, object2, oc1b68625d173, f3, f4, f5, 1.0f);
                } else {
                    ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, oc1b68625d173.\u0160 * f3 + oc1b68625d173.\u03c1, oc1b68625d173.\u0201 * f3 + oc1b68625d173.\u011b, f5);
                    ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, oc1b68625d173.\u03c1 - oc1b68625d173.\u0160 * f4, oc1b68625d173.\u011b - oc1b68625d173.\u0201 * f4, 1.0f);
                }
                object2 = oc1b68625d173;
            }
            Object object4 = ocb579fc69942.\u0145.get(0);
            float[] fArray = ocb579fc69942.\u0145.get(1);
            ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, (float)object4[0], (float)object4[1], f5);
            ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, fArray[0], fArray[1], 1.0f);
        }
    }

    private static float[] \u054a(oc1b68625d17 oc1b68625d172, oc1b68625d17 oc1b68625d173) {
        float[] fArray;
        float f = oc1b68625d173.\u03c1 - oc1b68625d172.\u03c1;
        float f2 = oc1b68625d173.\u011b - oc1b68625d172.\u011b;
        float f3 = (float)StrictMath.sqrt(f * f + f2 * f2);
        float f4 = ocbc6f0988cd.\u03b5(0xE7815DB ^ 0xE53438F) / f3;
        float f5 = f4 * f;
        float f6 = f4 * f2;
        if (f3 > ocbc6f0988cd.\u03b5(0xE7815DF ^ 0xE53438F)) {
            float[] fArray2 = new float[0xE53438D ^ 0xE53438F];
            fArray2[0] = f5;
            fArray = fArray2;
            fArray2[1] = f6;
        } else {
            float[] fArray3 = new float[0xE53438D ^ 0xE53438F];
            fArray3[0] = f;
            fArray = fArray3;
            fArray3[1] = f2;
        }
        return fArray;
    }

    private static void \u01e4(List<float[]> list, oc1b68625d17 oc1b68625d172, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl) {
        float f8 = bl ? f * f4 + oc1b68625d172.\u03c1 : oc1b68625d172.\u03c1 - f * f4;
        float f9 = bl ? f2 * f4 + oc1b68625d172.\u011b : oc1b68625d172.\u011b - f2 * f4;
        float f10 = f2 * f3 + f8;
        float f11 = ocbc6f0988cd.\u011a(f) * f3 + f9;
        float f12 = ocbc6f0988cd.\u011a(f2) * f3 + f8;
        float f13 = f * f3 + f9;
        float f14 = (bl ? f : ocbc6f0988cd.\u011a(f)) * f5;
        float f15 = (bl ? f2 : ocbc6f0988cd.\u011a(f2)) * f5;
        if (bl) {
            ocbc6f0988cd.\u03ac(list, f10, f11, f6);
            ocbc6f0988cd.\u03ac(list, f12, f13, f7);
        }
        ocbc6f0988cd.\u023c(list, f14 + f10, f15 + f11, f6, 0.0f);
        ocbc6f0988cd.\u023c(list, f14 + f12, f15 + f13, f7, 0.0f);
        if (!bl) {
            ocbc6f0988cd.\u03ac(list, f10, f11, f6);
            ocbc6f0988cd.\u03ac(list, f12, f13, f7);
        }
    }

    private static void \u023d(List<float[]> list, oc1b68625d17 oc1b68625d172, float f, float f2, float f3, int n, float f4, float f5, boolean bl) {
        if (bl) {
            ocbc6f0988cd.\u03ac(list, f2 * f3 + oc1b68625d172.\u03c1, ocbc6f0988cd.\u011a(f) * f3 + oc1b68625d172.\u011b, f4);
            ocbc6f0988cd.\u03ac(list, ocbc6f0988cd.\u011a(f2) * f3 + oc1b68625d172.\u03c1, f * f3 + oc1b68625d172.\u011b, f5);
        }
        float f6 = n - 1;
        for (int i = 0; i < n; ++i) {
            float f7 = (float)i / f6 * ocbc6f0988cd.\u03b5(0xE20DE5C3 ^ 0xE226B3E3);
            float f8 = oc77bf9fb04c.\u04ed(f7) * f3;
            float f9 = oc77bf9fb04c.\u0145(f7) * f3;
            float f10 = (bl ? f : ocbc6f0988cd.\u011a(f)) * f9 + (ocbc6f0988cd.\u011a(f2) * f8 + oc1b68625d172.\u03c1);
            float f11 = (bl ? f2 : ocbc6f0988cd.\u011a(f2)) * f9 + (f * f8 + oc1b68625d172.\u011b);
            if (bl) {
                ocbc6f0988cd.\u03ac(list, oc1b68625d172.\u03c1, oc1b68625d172.\u011b, 0.5f);
            }
            ocbc6f0988cd.\u03ac(list, f10, f11, f4);
            if (bl) continue;
            ocbc6f0988cd.\u03ac(list, oc1b68625d172.\u03c1, oc1b68625d172.\u011b, 0.5f);
        }
        if (!bl) {
            ocbc6f0988cd.\u03ac(list, f2 * f3 + oc1b68625d172.\u03c1, ocbc6f0988cd.\u011a(f) * f3 + oc1b68625d172.\u011b, f4);
            ocbc6f0988cd.\u03ac(list, ocbc6f0988cd.\u011a(f2) * f3 + oc1b68625d172.\u03c1, f * f3 + oc1b68625d172.\u011b, f5);
        }
    }

    private static void \u03b3(List<float[]> list, oc1b68625d17 oc1b68625d172, oc1b68625d17 oc1b68625d173, float f, float f2, float f3, int n) {
        boolean bl = (oc1b68625d173.\u0243 & (0x48C6F63 ^ 0x48C6F61)) != 0;
        float[][] fArray = ocbc6f0988cd.\u03a3((oc1b68625d173.\u0243 & (0x48C6F69 ^ 0x48C6F61)) != 0, oc1b68625d172, oc1b68625d173, bl ? f : ocbc6f0988cd.\u011a(f));
        float f4 = ocba3c42d463.\u038c(bl ? oc1b68625d172.\u01bd : ocbc6f0988cd.\u011a(oc1b68625d172.\u01bd), bl ? ocbc6f0988cd.\u011a(oc1b68625d172.\u0259) : oc1b68625d172.\u0259);
        float f5 = ocba3c42d463.\u038c(bl ? oc1b68625d173.\u01bd : ocbc6f0988cd.\u011a(oc1b68625d173.\u01bd), bl ? ocbc6f0988cd.\u011a(oc1b68625d173.\u0259) : oc1b68625d173.\u0259);
        if (bl ? f4 < f5 : f5 < f4) {
            f5 += ocbc6f0988cd.\u03b5(bl ? 0x4A73911 ^ 0x48C6F61 : 0x4A73915 ^ 0x48C6F61);
        }
        float f6 = bl ? ocbc6f0988cd.\u011a(f) : f;
        float f7 = oc1b68625d172.\u0259 * f6 + oc1b68625d173.\u03c1;
        float f8 = ocbc6f0988cd.\u011a(oc1b68625d172.\u01bd) * f6 + oc1b68625d173.\u011b;
        float f9 = oc1b68625d173.\u0259 * f6 + oc1b68625d173.\u03c1;
        float f10 = ocbc6f0988cd.\u011a(oc1b68625d173.\u01bd) * f6 + oc1b68625d173.\u011b;
        float[] fArray2 = fArray[0];
        float[] fArray3 = fArray[1];
        if (bl) {
            ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f2);
            ocbc6f0988cd.\u03ac(list, f7, f8, f3);
        } else {
            ocbc6f0988cd.\u03ac(list, f7, f8, f2);
            ocbc6f0988cd.\u03ac(list, fArray2[0], fArray2[1], f3);
        }
        float f11 = bl ? f4 - f5 : f5 - f4;
        int n2 = oc3004491957.\u0182(oc3004491957.\u0434(f11 / ocbc6f0988cd.\u03b5(0x4A73941 ^ 0x48C6F61) * (float)n));
        int n3 = n2 < (0x48C6F63 ^ 0x48C6F61) ? 0x48C6F63 ^ 0x48C6F61 : (n2 < n ? n2 : n);
        for (int i = 0; i < n3; ++i) {
            float f12 = (float)i / (float)(n3 - 1) * (f5 - f4) + f4;
            float f13 = oc77bf9fb04c.\u04ed(f12) * f + oc1b68625d173.\u03c1;
            float f14 = oc77bf9fb04c.\u0145(f12) * f + oc1b68625d173.\u011b;
            if (bl) {
                ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
            }
            ocbc6f0988cd.\u03ac(list, f13, f14, bl ? f3 : f2);
            if (bl) continue;
            ocbc6f0988cd.\u03ac(list, oc1b68625d173.\u03c1, oc1b68625d173.\u011b, 0.5f);
        }
        if (bl) {
            ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f2);
            ocbc6f0988cd.\u03ac(list, f9, f10, f3);
        } else {
            ocbc6f0988cd.\u03ac(list, f9, f10, f2);
            ocbc6f0988cd.\u03ac(list, fArray3[0], fArray3[1], f3);
        }
    }

    public void \u0188(float f, float f2, int n, int n2, float f3) {
        this.\u01c6();
        float f4 = ocba3c42d463.\u02ae(f / (this.\u04d0 + f));
        f4 += f4;
        int n3 = oc3004491957.\u0182(oc3004491957.\u0434(ocbc6f0988cd.\u03b5(0xB553A45 ^ 0xB7E6C65) / f4));
        int n4 = n3 >= (0xB7E6C66 ^ 0xB7E6C65) ? n3 : 0xB7E6C67 ^ 0xB7E6C65;
        f = f2 * ocbc6f0988cd.\u03b5(0xB553A41 ^ 0xB7E6C65) + f;
        float f5 = f2 == 0.0f ? ocbc6f0988cd.\u03b5(0xB553A41 ^ 0xB7E6C65) : 0.0f;
        float f6 = ocbc6f0988cd.\u03b5(f2 == 0.0f ? 0xB553A49 ^ 0xB7E6C65 : 0xB553A4D ^ 0xB7E6C65);
        float f7 = f2 * ocbc6f0988cd.\u03b5(0xB553A55 ^ 0xB7E6C65);
        float f8 = f - f2;
        this.\u014a(f, n2, f3);
        for (ocb579fc6994 ocb579fc69942 : this.\u00d6) {
            float[] fArray;
            oc1b68625d17 oc1b68625d172;
            ocb579fc69942.\u0389.clear();
            ocb579fc69942.\u0145.clear();
            int n5 = ocb579fc69942.\u03d4.size();
            if (n5 < (0xB7E6C67 ^ 0xB7E6C65)) continue;
            oc1b68625d17 oc1b68625d173 = ocb579fc69942.B ? ocb579fc69942.\u03d4.get(n5 - 1) : ocb579fc69942.\u03d4.get(0);
            oc1b68625d17 oc1b68625d174 = oc1b68625d172 = ocb579fc69942.B ? ocb579fc69942.\u03d4.get(0) : ocb579fc69942.\u03d4.get(1);
            if (!ocb579fc69942.B) {
                float[] fArray2 = ocbc6f0988cd.\u054a(oc1b68625d173, oc1b68625d172);
                if (n == 0 || n == (0xB7E6C67 ^ 0xB7E6C65)) {
                    ocbc6f0988cd.\u01e4(ocb579fc69942.\u0145, oc1b68625d173, fArray2[0], fArray2[1], f, n == 0 ? f7 : f8, f2, f5, f6, false);
                } else if (n == 1) {
                    ocbc6f0988cd.\u023d(ocb579fc69942.\u0145, oc1b68625d173, fArray2[0], fArray2[1], f, n4, f5, f6, false);
                }
            }
            int n6 = ocb579fc69942.B ? 0 : 1;
            int n7 = ocb579fc69942.B ? n5 : n5 - 1;
            for (int i = n6; i < n7; ++i) {
                oc1b68625d172 = ocb579fc69942.\u03d4.get(i);
                if ((oc1b68625d172.\u0243 & (0xB7E6C69 ^ 0xB7E6C65)) != 0) {
                    if (n2 == 1) {
                        ocbc6f0988cd.\u03b3(ocb579fc69942.\u0145, oc1b68625d173, oc1b68625d172, f, f5, f6, n4);
                    } else {
                        ocbc6f0988cd.\u03f1(ocb579fc69942.\u0145, oc1b68625d173, oc1b68625d172, f, f, f5, f6);
                    }
                } else {
                    ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, oc1b68625d172.\u0160 * f + oc1b68625d172.\u03c1, oc1b68625d172.\u0201 * f + oc1b68625d172.\u011b, f5);
                    ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, oc1b68625d172.\u03c1 - oc1b68625d172.\u0160 * f, oc1b68625d172.\u011b - oc1b68625d172.\u0201 * f, f6);
                }
                oc1b68625d173 = oc1b68625d172;
            }
            if (ocb579fc69942.B) {
                fArray = ocb579fc69942.\u0145.get(0);
                float[] fArray3 = ocb579fc69942.\u0145.get(1);
                ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, fArray[0], fArray[1], f5);
                ocbc6f0988cd.\u03ac(ocb579fc69942.\u0145, fArray3[0], fArray3[1], f6);
                continue;
            }
            oc1b68625d172 = ocb579fc69942.\u03d4.get(n5 - 1);
            fArray = ocbc6f0988cd.\u054a(oc1b68625d173, oc1b68625d172);
            if (n == 0 || n == (0xB7E6C67 ^ 0xB7E6C65)) {
                ocbc6f0988cd.\u01e4(ocb579fc69942.\u0145, oc1b68625d172, fArray[0], fArray[1], f, n == 0 ? f7 : f8, f2, f5, f6, true);
                continue;
            }
            if (n != 1) continue;
            ocbc6f0988cd.\u023d(ocb579fc69942.\u0145, oc1b68625d172, fArray[0], fArray[1], f, n4, f5, f6, true);
        }
    }
}

