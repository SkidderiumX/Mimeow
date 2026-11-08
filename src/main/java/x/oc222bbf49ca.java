/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc35e4c54bd4;
import x.oc42b715e79d;
import x.oc62a465bc97;
import x.oc98904eb9e7;
import x.ocd9db3ede42;

public class oc222bbf49ca {
    public boolean \u0567;
    public float \u00cf;
    public double \u0438;

    public float \u0206(oc35e4c54bd4 oc35e4c54bd42, Object object, ocd9db3ede42 ocd9db3ede422, float f, float f2, float f3, float f4, float f5, boolean bl, double d) {
        return this.\u00e2(oc35e4c54bd42, object, ocd9db3ede422, ocd9db3ede422, f, f2, f3, f4, f5, d);
    }

    public float \u00e2(oc35e4c54bd4 oc35e4c54bd42, Object object, ocd9db3ede42 ocd9db3ede422, ocd9db3ede42 ocd9db3ede423, float f, float f2, float f3, float f4, float f5, double d) {
        float f6 = oc62a465bc97.\u0496(0.0f, oc98904eb9e7.\u0132(0x6BE2C4CD ^ 0x6BF6C809), (f - f2) / (f3 - f2));
        this.\u00cf = oc98904eb9e7.\u03e9(this.\u00cf, f6, (float)((double)((float)(d - this.\u0438)) / oc98904eb9e7.\u0442(0x6BE2C4C1 ^ 0x6BF6C809)));
        this.\u0438 = d;
        return this.\u01f6(oc35e4c54bd42, object, ocd9db3ede422, ocd9db3ede423, f, f2, f3, f4, f5);
    }

    public float \u01f6(oc35e4c54bd4 oc35e4c54bd42, Object object, ocd9db3ede42 ocd9db3ede422, ocd9db3ede42 ocd9db3ede423, float f, float f2, float f3, float f4, float f5) {
        if (oc35e4c54bd42.f(ocd9db3ede423)) {
            this.\u0567 = true;
            if (oc35e4c54bd42.\u0113) {
                oc35e4c54bd42.\u00da(object, oc98904eb9e7::\u01a3);
            }
        } else if (!oc35e4c54bd42.\u01db && !oc35e4c54bd42.\u0469(object)) {
            this.\u0567 = false;
        }
        if (!this.\u0567) {
            return f;
        }
        if (oc35e4c54bd42.\u0469(object)) {
            String string = oc35e4c54bd42.\u0177();
            if (string == null) {
                return f;
            }
            f = oc98904eb9e7.\u0253(string);
            if (f5 != 0.0f) {
                f /= f5;
            }
        } else {
            f = (f3 - f2) * ((oc35e4c54bd42.\u0220 - ocd9db3ede422.\u00c8) / ocd9db3ede422.\u0423) + f2;
        }
        if (f4 != 0.0f) {
            f = oc42b715e79d.\u01f1(f / f4) * f4;
        }
        return f2 >= f ? f2 : (f >= f3 ? f3 : f);
    }
}

