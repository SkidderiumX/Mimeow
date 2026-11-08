/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.F;
import x.N;
import x.oc0af730cc9f;
import x.oc10354c7bb8;
import x.oc1cb76bf763;
import x.oc2ec6a95e5c;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc7cb8a77087;
import x.oc8aaacef5d6;
import x.oc920065c394;
import x.oc9be9d1e2c8;
import x.ocb072b0dd6a;
import x.ocbc9c7a1e51;
import x.oce1bd2fa256;

public class oc28d879035d
extends ocb072b0dd6a {
    private boolean \u0277;
    private final List<oc7cb8a77087> \u0515;
    private final List<oc7cb8a77087> \u029f;

    oc28d879035d(N n, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        int n2;
        if (n instanceof oc6af36febc3) {
            oc6af36febc3 oc6af36febc32 = (oc6af36febc3)n;
            n2 = oc6af36febc32.\u0107();
        } else if (n instanceof oce1bd2fa256) {
            oce1bd2fa256 oce1bd2fa2562 = (oce1bd2fa256)n;
            n2 = oce1bd2fa2562.\u028d();
        } else {
            n2 = 0x1259B851 ^ 0x1259B831;
        }
        super(n, oc69da1aa7f52, oc1cb76bf7632, n2);
        this.\u0515 = new ArrayList<oc7cb8a77087>();
        this.\u029f = new ArrayList<oc7cb8a77087>();
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        this.\u04ef();
        return this.\u0277 ? (float)((0x883BC774 ^ 0x883BC754) + (this.\u029f.size() + this.\u0515.size()) * (0x883BC759 ^ 0x883BC754)) : 17.0f;
    }

    private void \u04ef() {
        oc10354c7bb8 oc10354c7bb82;
        N n;
        Object object2;
        this.\u029f.clear();
        this.\u0515.clear();
        Object object3 = this.\u04b3;
        if (object3 instanceof oc6af36febc3) {
            object2 = (oc6af36febc3)object3;
            ((oc6af36febc3)object2).\u010e().forEach(string -> this.\u029f.add(new oc7cb8a77087((String)string, (String)string)));
        } else {
            object3 = this.\u04b3;
            if (object3 instanceof oce1bd2fa256) {
                n = (oce1bd2fa256)object3;
                n.\u01b8().forEach(oc1e36b6c9032 -> this.\u029f.add(new oc7cb8a77087(oc1e36b6c9032.\u0479(), oc1e36b6c9032.\u0273())));
            } else {
                object3 = this.\u04b3;
                if (object3 instanceof oc10354c7bb8) {
                    oc10354c7bb82 = (oc10354c7bb8)object3;
                    for (String object4 : oc10354c7bb82.\u0478()) {
                        ocbc9c7a1e51 ocbc9c7a1e512;
                        Object object = this.\u04b3 instanceof oc0af730cc9f ? oc9be9d1e2c8.\u047f(object4) : (this.\u04b3 instanceof oc2ec6a95e5c ? oc920065c394.\u049f(object4) : F.\u0370(object4));
                        N n2 = this.\u04b3;
                        if (n2 instanceof ocbc9c7a1e51 && (ocbc9c7a1e512 = (ocbc9c7a1e51)n2).\u03a6(object4) != null) {
                            object = (String)object + " [" + ocbc9c7a1e512.\u03a6(object4) + "]";
                        }
                        this.\u029f.add(new oc7cb8a77087(object4, (String)object));
                    }
                }
            }
        }
        object2 = this.\u0180.getText().trim();
        if (!this.\u0277 || ((String)object2).isEmpty()) {
            return;
        }
        N n3 = this.\u04b3;
        if (n3 instanceof oc0af730cc9f) {
            n = (oc0af730cc9f)n3;
            oc9be9d1e2c8.\u01d2((String)object2, (oc0af730cc9f)n).stream().limit(0x9B9E48D790F1F68AL ^ 0x9B9E48D790F1F68EL).forEach(occ36fe312d92 -> this.\u0515.add(new oc7cb8a77087(occ36fe312d92.\u03e2, occ36fe312d92.\u01b6)));
        } else {
            N n4 = this.\u04b3;
            if (n4 instanceof oc2ec6a95e5c) {
                oc10354c7bb82 = (oc2ec6a95e5c)n4;
                oc920065c394.\u022e((String)object2, (oc2ec6a95e5c)oc10354c7bb82).stream().limit(0x9B9E48D790F1F68AL ^ 0x9B9E48D790F1F68EL).forEach(oc019314a9ca2 -> this.\u0515.add(new oc7cb8a77087(oc019314a9ca2.\u04cf() ? oc019314a9ca2.\u0465.get((int)0).\u0468 : oc019314a9ca2.\u0417(), oc019314a9ca2.\u0493())));
            } else {
                N n5 = this.\u04b3;
                if (n5 instanceof oc10354c7bb8) {
                    object3 = (oc10354c7bb8)n5;
                    F.\u04af((String)object2, (oc10354c7bb8)object3).stream().limit(0x9B9E48D790F1F68AL ^ 0x9B9E48D790F1F68EL).forEach(oc3af4427d652 -> this.\u0515.add(new oc7cb8a77087((String)(oc3af4427d652.\u04ae() ? oc3af4427d652.\u049e.get((int)0).\u020e : oc3af4427d652.\u01a7 + ":*"), oc3af4427d652.\u0520())));
                }
            }
        }
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        String string = this.\u04b3.z$18nrktuqeiysv() + " (" + this.\u029f.size() + ")";
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", string, 7.0f, this.\u03c8 - 23.0f), this.\u01e7 + 5.0f, this.\u0575 + 10.5f, 7.0f, -1);
        oc8aaacef5d62.\u025e(this.\u01e7 + this.\u03c8 - 12.0f, this.\u0575 + 8.5f, 10.0f, this.\u0277 ? 1.0f : 0.0f, -1);
        if (!this.\u0277) {
            return;
        }
        this.o(oc8aaacef5d62, this.\u0575 + 18.0f);
        float f3 = this.\u0575 + 32.0f;
        for (oc7cb8a77087 oc7cb8a770872 : this.\u0515) {
            oc8aaacef5d62.\u027e(this.\u01e7 + 5.0f, f3, this.\u03c8 - 10.0f, 12.0f, 2.0f, oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), 0.25f));
            oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", oc7cb8a770872.\u01c9, 7.0f, this.\u03c8 - 16.0f), this.\u01e7 + 7.0f, f3 + 9.0f, 7.0f, -1);
            f3 += 13.0f;
        }
        for (oc7cb8a77087 oc7cb8a770872 : this.\u029f) {
            oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", oc7cb8a770872.\u01c9, 7.0f, this.\u03c8 - 23.0f), this.\u01e7 + 7.0f, f3 + 9.0f, 7.0f, 0x2A85B8B7 ^ 0xD5053837);
            oc8aaacef5d62.\u0456("productsans-medium", "\u00d7", this.\u01e7 + this.\u03c8 - 12.0f, f3 + 9.0f, 7.0f, -1);
            f3 += 13.0f;
        }
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (f2 < this.\u0575 + 17.0f) {
            if (n != 1 && n != 0) {
                return false;
            }
            boolean bl = this.\u0277 = !this.\u0277;
            if (!this.\u0277) {
                this.z$21n2hyuutt37u();
            }
            return true;
        }
        if (!this.\u0277) {
            return false;
        }
        if (f2 < this.\u0575 + 32.0f) {
            if (n != 0) {
                return false;
            }
            this.\u013d(f);
            return true;
        }
        int n2 = (int)((f2 - this.\u0575 - 32.0f) / 13.0f);
        if (n2 < this.\u0515.size()) {
            if (n != 0) {
                return false;
            }
            this.\u02b6(this.\u0515.get((int)n2).\u013e);
            this.\u0180.setText("");
        } else {
            Object object;
            if ((n2 -= this.\u0515.size()) >= this.\u029f.size()) {
                return false;
            }
            String string = this.\u029f.get((int)n2).\u013e;
            if (n == 1 && (object = this.\u04b3) instanceof ocbc9c7a1e51) {
                ocbc9c7a1e51 ocbc9c7a1e512;
                ocbc9c7a1e512.\u01ce(string, (object = (ocbc9c7a1e512 = (ocbc9c7a1e51)object).\u03a6(string)) == null || (Integer)object == (0xB211D460 ^ 0xB211D469) ? 1 : (Integer)object + 1);
            } else if (n == 0) {
                this.\u01a6(string);
            } else {
                return false;
            }
        }
        this.z$3e974bso21r1k();
        return true;
    }

    @Override
    boolean z$16m0yo633oydp(char c, int n) {
        if (n == (0x1DBCDB46 ^ 0x1DBCDB5A) || n == (0x1DBCDBC6 ^ 0x1DBCDB5A)) {
            String string;
            String string2 = string = this.\u0515.isEmpty() ? this.\u0180.getText().trim() : this.\u0515.get((int)0).\u013e;
            if (!string.isEmpty()) {
                this.\u02b6(string);
                this.\u0180.setText("");
                this.z$3e974bso21r1k();
            }
            return true;
        }
        return super.z$16m0yo633oydp(c, n);
    }

    private void \u02b6(String string) {
        N n = this.\u04b3;
        if (n instanceof oc6af36febc3) {
            oc6af36febc3 oc6af36febc32 = (oc6af36febc3)n;
            oc6af36febc32.\u0536(string);
        } else {
            n = this.\u04b3;
            if (n instanceof oce1bd2fa256) {
                oce1bd2fa256 oce1bd2fa2562 = (oce1bd2fa256)n;
                oce1bd2fa2562.\u044c(string);
            } else {
                n = this.\u04b3;
                if (n instanceof oc2ec6a95e5c) {
                    oc2ec6a95e5c oc2ec6a95e5c2 = (oc2ec6a95e5c)n;
                    oc2ec6a95e5c2.z$1nw3rcgnkegzj(string);
                } else {
                    n = this.\u04b3;
                    if (n instanceof oc0af730cc9f) {
                        oc0af730cc9f oc0af730cc9f2 = (oc0af730cc9f)n;
                        oc0af730cc9f2.x(string);
                    } else {
                        n = this.\u04b3;
                        if (n instanceof oc10354c7bb8) {
                            oc10354c7bb8 oc10354c7bb82 = (oc10354c7bb8)n;
                            oc10354c7bb82.\u051f(string);
                        }
                    }
                }
            }
        }
    }

    private void \u01a6(String string) {
        N n = this.\u04b3;
        if (n instanceof oc6af36febc3) {
            oc6af36febc3 oc6af36febc32 = (oc6af36febc3)n;
            oc6af36febc32.\u012d(string);
        } else {
            n = this.\u04b3;
            if (n instanceof oce1bd2fa256) {
                oce1bd2fa256 oce1bd2fa2562 = (oce1bd2fa256)n;
                oce1bd2fa2562.\u056c(string);
            } else {
                n = this.\u04b3;
                if (n instanceof oc2ec6a95e5c) {
                    oc2ec6a95e5c oc2ec6a95e5c2 = (oc2ec6a95e5c)n;
                    oc2ec6a95e5c2.z$2pk8fzn7jisvx(string);
                } else {
                    n = this.\u04b3;
                    if (n instanceof oc0af730cc9f) {
                        oc0af730cc9f oc0af730cc9f2 = (oc0af730cc9f)n;
                        oc0af730cc9f2.\u0116(string);
                    } else {
                        n = this.\u04b3;
                        if (n instanceof oc10354c7bb8) {
                            oc10354c7bb8 oc10354c7bb82 = (oc10354c7bb8)n;
                            oc10354c7bb82.\u0535(string);
                        }
                    }
                }
            }
        }
    }
}

