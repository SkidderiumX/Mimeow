/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x.F;
import x.N;
import x.W;
import x.oc019314a9ca;
import x.oc08592ac73b;
import x.oc0af730cc9f;
import x.oc10354c7bb8;
import x.oc1e36b6c903;
import x.oc255ab955c3;
import x.oc2ec6a95e5c;
import x.oc345277813d;
import x.oc3af4427d65;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oc6af36febc3;
import x.oc920065c394;
import x.oc9be9d1e2c8;
import x.oca98caeda20;
import x.ocbc9c7a1e51;
import x.occ36fe312d9;
import x.occ81c66c6bb;
import x.oce1bd2fa256;

public class oc2ada83901b
extends oc5e2e2031b5 {
    private static final int \u056f = 4;
    private static final int \u01f3 = 5;
    private final oca98caeda20 \u01aa;
    private boolean \u0248;
    private int \u017c;

    oc2ada83901b(N n, oc69da1aa7f5 oc69da1aa7f52) {
        super(n, oc69da1aa7f52);
        this.\u01aa = new oca98caeda20(oc2ada83901b.\u021f(n), oc2ada83901b.\u022c(n));
    }

    @Override
    int z$ag4eb8ubl7je() {
        if (!this.\u0248) {
            return 0xBD221659 ^ 0xBD221656;
        }
        int n = this.\u023c().size();
        int n2 = Math.min(0xBD221653 ^ 0xBD221656, Math.max(0, this.\u0468() - this.\u017c));
        return (0xBD221659 ^ 0xBD221656) * ((0xBD221654 ^ 0xBD221656) + n + n2 + (this.\u0468() > 0 ? 1 : 0));
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        int n3;
        oc255ab955c3.\u04df(this.\u0152 - 3.0f, this.\u0417, this.\u016d, n, n2);
        String string = " (" + this.\u0468() + ")";
        String string2 = oc255ab955c3.\u0516(this.\u047b.z$18nrktuqeiysv() + string, oc255ab955c3.\u0117(), (int)this.\u016d - (0x6A7868A8 ^ 0x6A7868BC));
        oc255ab955c3.\u0117().z$ao2ykh4tuw6w(string2, this.\u0152 + 2.0f, this.\u0417 + 3.0f, -1, false);
        oc255ab955c3.\u0117().z$ao2ykh4tuw6w(this.\u0248 ? "-" : "+", this.\u0152 + this.\u016d - 10.0f, this.\u0417 + 3.0f, oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5), false);
        if (!this.\u0248) {
            return;
        }
        float f = this.\u0417 + 15.0f;
        this.\u01aa.\u01da(this.\u0152, f + 1.0f, this.\u016d - 6.0f);
        f += 15.0f;
        for (oc345277813d oc345277813d2 : this.\u023c()) {
            n3 = oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2);
            W.\u02e0(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, 2.0f, n3 != 0 ? 0xD86171A5 ^ 0x6A7868BC : 0xFC6171A5 ^ 0x6A7868BC);
            oc255ab955c3.\u0117().z$ao2ykh4tuw6w(oc255ab955c3.\u0516(oc345277813d2.\u050d, oc255ab955c3.\u0117(), (int)this.\u016d - (0x6A7868B4 ^ 0x6A7868BC)), this.\u0152 + 2.0f, f + 3.0f, oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)f + 7.5), false);
            f += 15.0f;
        }
        List<occ81c66c6bb> list = this.\u0455();
        this.\u02c0(list.size());
        int n4 = Math.min(list.size(), this.\u017c + (0x6A7868B9 ^ 0x6A7868BC));
        for (n3 = this.\u017c; n3 < n4; ++n3) {
            occ81c66c6bb occ81c66c6bb2 = (occ81c66c6bb)list.get(n3);
            boolean bl = oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2);
            if (bl) {
                W.\u02e0(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, 2.0f, 0xFC6171A5 ^ 0x6A7868BC);
            }
            String string3 = occ81c66c6bb2.\u0211 == null ? "" : " [" + occ81c66c6bb2.\u0211 + "]";
            String string4 = oc255ab955c3.\u0516(occ81c66c6bb2.\u00e8 + string3, oc255ab955c3.\u0117(), (int)this.\u016d - (0x6A7868AE ^ 0x6A7868BC));
            oc255ab955c3.\u0117().z$ao2ykh4tuw6w(string4, this.\u0152 + 2.0f, f + 3.0f, 0x95E6F622 ^ 0x6A7868BC, false);
            oc255ab955c3.\u0117().z$ao2ykh4tuw6w("x", this.\u0152 + this.\u016d - 11.0f, f + 3.0f, -1, false);
            f += 15.0f;
        }
        if (!list.isEmpty()) {
            n3 = oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2) ? 1 : 0;
            W.\u02e0(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, 2.0f, n3 != 0 ? 0xD86171A5 ^ 0x6A7868BC : 0xFC6171A5 ^ 0x6A7868BC);
            oc255ab955c3.\u0117().z$ao2ykh4tuw6w("Clear", this.\u0152 + 2.0f, f + 3.0f, -1, false);
        }
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, this.\u0417, this.\u016d, 15.0f, n, n2) && (n3 == 0 || n3 == 1)) {
            boolean bl = this.\u0248 = !this.\u0248;
            if (!this.\u0248) {
                this.\u01aa.\u02e1();
            }
            return true;
        }
        if (!this.\u0248) {
            return false;
        }
        float f = this.\u0417 + 15.0f;
        if (oc255ab955c3.\u050e(this.\u0152, f, this.\u016d - 6.0f, 14.0f, n, n2) && n3 == 0) {
            this.\u01aa.\u04cc();
            return true;
        }
        f += 15.0f;
        for (oc345277813d oc345277813d2 : this.\u023c()) {
            if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2) && n3 == 0) {
                this.\u0247(oc345277813d2.\u050c);
                this.\u01aa.\u039d("");
                this.\u0416();
                return true;
            }
            f += 15.0f;
        }
        List<occ81c66c6bb> list = this.\u0455();
        this.\u02c0(list.size());
        int n4 = Math.min(list.size(), this.\u017c + (0xA4906DB3 ^ 0xA4906DB6));
        for (int i = this.\u017c; i < n4; ++i) {
            occ81c66c6bb occ81c66c6bb2 = (occ81c66c6bb)list.get(i);
            if (oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2)) {
                if (n3 == 1 && this.\u047b instanceof ocbc9c7a1e51) {
                    ocbc9c7a1e51 ocbc9c7a1e512 = (ocbc9c7a1e51)this.\u047b;
                    int n5 = ocbc9c7a1e512.\u03a6(occ81c66c6bb2.\u0490);
                    ocbc9c7a1e512.\u01ce(occ81c66c6bb2.\u0490, n5 % (0xA4906DBF ^ 0xA4906DB6) + 1);
                } else if (n3 == 0) {
                    this.\u0498(occ81c66c6bb2.\u0490);
                }
                this.\u0416();
                return true;
            }
            f += 15.0f;
        }
        if (!list.isEmpty() && oc255ab955c3.\u050e(this.\u0152 - 3.0f, f, this.\u016d, 15.0f, n, n2) && n3 == 0) {
            this.\u051f();
            this.\u017c = 0;
            this.\u0416();
            return true;
        }
        this.\u01aa.\u02e1();
        return false;
    }

    @Override
    boolean z$3twgyf5k61sst(char c, int n) {
        if (!this.\u01aa.\u0175()) {
            return false;
        }
        if (n == (0x70722C ^ 0x707230) || n == (0x7072AC ^ 0x707230)) {
            String string;
            List<oc345277813d> list = this.\u023c();
            String string2 = string = list.isEmpty() ? this.\u01aa.\u01af().trim() : list.get((int)0).\u050c;
            if (!string.isEmpty()) {
                this.\u0247(string);
                this.\u01aa.\u039d("");
                this.\u0416();
            }
            return true;
        }
        this.\u01aa.\u01dd(c, n);
        return true;
    }

    @Override
    boolean z$3kj7psbv4c9hb(int n, int n2, int n3) {
        if (!this.\u0248 || !this.\u01f7(n, n2) || this.\u0468() <= (0x3344C472 ^ 0x3344C477)) {
            return false;
        }
        int n4 = Math.max(1, Math.round(Math.abs(oc08592ac73b.\u03d0(n3))));
        this.\u017c += n3 > 0 ? -n4 : n4;
        this.\u02c0(this.\u0468());
        return true;
    }

    @Override
    void z$1l3ht5d17kefg() {
        this.\u01aa.\u02e1();
    }

    private List<oc345277813d> \u023c() {
        if (!this.\u0248 || !this.\u01aa.\u0175() || this.\u01aa.\u01af().trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<oc345277813d> list = this.\u04fa(this.\u01aa.\u01af());
        if (list.size() > (0xBB28A0FF ^ 0xBB28A0FB)) {
            return list.subList(0, 0xBB28A0FF ^ 0xBB28A0FB);
        }
        return list;
    }

    private List<oc345277813d> \u04fa(String string) {
        ArrayList<oc345277813d> arrayList;
        block4: {
            block5: {
                block3: {
                    arrayList = new ArrayList<oc345277813d>();
                    if (!(this.\u047b instanceof oc0af730cc9f)) break block3;
                    for (occ36fe312d9 occ36fe312d92 : oc9be9d1e2c8.\u01d2(string, (oc0af730cc9f)this.\u047b)) {
                        arrayList.add(new oc345277813d(occ36fe312d92.\u03e2, occ36fe312d92.\u01b6));
                    }
                    break block4;
                }
                if (!(this.\u047b instanceof oc2ec6a95e5c)) break block5;
                for (oc019314a9ca oc019314a9ca2 : oc920065c394.\u022e(string, (oc2ec6a95e5c)this.\u047b)) {
                    String string2 = oc019314a9ca2.\u04cf() ? oc019314a9ca2.\u0465.get((int)0).\u0468 : oc019314a9ca2.\u0417();
                    arrayList.add(new oc345277813d(string2, oc019314a9ca2.\u0493()));
                }
                break block4;
            }
            if (!(this.\u047b instanceof oc10354c7bb8)) break block4;
            for (oc3af4427d65 oc3af4427d652 : F.\u04af(string, (oc10354c7bb8)this.\u047b)) {
                String string3 = oc3af4427d652.\u04ae() ? oc3af4427d652.\u049e.get((int)0).\u020e : oc3af4427d652.\u01a7 + ":*";
                arrayList.add(new oc345277813d(string3, oc3af4427d652.\u0520()));
            }
        }
        return arrayList;
    }

    private List<occ81c66c6bb> \u0455() {
        ArrayList<occ81c66c6bb> arrayList;
        block6: {
            block9: {
                block8: {
                    block7: {
                        block5: {
                            arrayList = new ArrayList<occ81c66c6bb>();
                            if (!(this.\u047b instanceof oce1bd2fa256)) break block5;
                            for (oc1e36b6c903 oc1e36b6c9032 : ((oce1bd2fa256)this.\u047b).\u01b8()) {
                                arrayList.add(new occ81c66c6bb(oc1e36b6c9032.\u0479(), oc1e36b6c9032.\u0273(), null));
                            }
                            break block6;
                        }
                        if (!(this.\u047b instanceof oc6af36febc3)) break block7;
                        for (String string : ((oc6af36febc3)this.\u047b).\u010e()) {
                            arrayList.add(new occ81c66c6bb(string, string, null));
                        }
                        break block6;
                    }
                    if (!(this.\u047b instanceof oc0af730cc9f)) break block8;
                    for (String string : ((oc0af730cc9f)this.\u047b).\u0271()) {
                        arrayList.add(new occ81c66c6bb(string, oc9be9d1e2c8.\u047f(string), null));
                    }
                    break block6;
                }
                if (!(this.\u047b instanceof oc2ec6a95e5c)) break block9;
                for (String string : ((oc2ec6a95e5c)this.\u047b).\u01df()) {
                    Integer n = this.\u047b instanceof ocbc9c7a1e51 ? ((ocbc9c7a1e51)this.\u047b).\u03a6(string) : null;
                    arrayList.add(new occ81c66c6bb(string, oc920065c394.\u049f(string), n));
                }
                break block6;
            }
            if (!(this.\u047b instanceof oc10354c7bb8)) break block6;
            for (String string : ((oc10354c7bb8)this.\u047b).\u0478()) {
                arrayList.add(new occ81c66c6bb(string, F.\u0370(string), null));
            }
        }
        return arrayList;
    }

    private int \u0468() {
        if (this.\u047b instanceof oce1bd2fa256) {
            return ((oce1bd2fa256)this.\u047b).\u01b8().size();
        }
        if (this.\u047b instanceof oc6af36febc3) {
            return ((oc6af36febc3)this.\u047b).\u010e().size();
        }
        if (this.\u047b instanceof oc10354c7bb8) {
            return ((oc10354c7bb8)this.\u047b).\u0478().size();
        }
        return 0;
    }

    private void \u0247(String string) {
        if (this.\u047b instanceof oce1bd2fa256) {
            ((oce1bd2fa256)this.\u047b).\u044c(string);
        } else if (this.\u047b instanceof oc6af36febc3) {
            ((oc6af36febc3)this.\u047b).\u0536(string);
        } else if (this.\u047b instanceof oc0af730cc9f) {
            ((oc0af730cc9f)this.\u047b).x(string);
        } else if (this.\u047b instanceof oc2ec6a95e5c) {
            ((oc2ec6a95e5c)this.\u047b).z$1nw3rcgnkegzj(string);
        } else if (this.\u047b instanceof oc10354c7bb8) {
            ((oc10354c7bb8)this.\u047b).\u051f(string);
        }
    }

    private void \u0498(String string) {
        if (this.\u047b instanceof oce1bd2fa256) {
            ((oce1bd2fa256)this.\u047b).\u056c(string);
        } else if (this.\u047b instanceof oc6af36febc3) {
            ((oc6af36febc3)this.\u047b).\u012d(string);
        } else if (this.\u047b instanceof oc0af730cc9f) {
            ((oc0af730cc9f)this.\u047b).\u0116(string);
        } else if (this.\u047b instanceof oc2ec6a95e5c) {
            ((oc2ec6a95e5c)this.\u047b).z$2pk8fzn7jisvx(string);
        } else if (this.\u047b instanceof oc10354c7bb8) {
            ((oc10354c7bb8)this.\u047b).\u0535(string);
        }
    }

    private void \u051f() {
        if (this.\u047b instanceof oce1bd2fa256) {
            ((oce1bd2fa256)this.\u047b).\u039c();
        } else if (this.\u047b instanceof oc6af36febc3) {
            ((oc6af36febc3)this.\u047b).\u016f();
        } else if (this.\u047b instanceof oc10354c7bb8) {
            ((oc10354c7bb8)this.\u047b).\u0478().clear();
        }
    }

    private void \u02c0(int n) {
        this.\u017c = Math.max(0, Math.min(this.\u017c, Math.max(0, n - (0x5ED431FD ^ 0x5ED431F8))));
    }

    private static String \u021f(N n) {
        if (n instanceof oce1bd2fa256) {
            return ((oce1bd2fa256)n).\u01fa();
        }
        if (n instanceof oc6af36febc3) {
            return ((oc6af36febc3)n).\u0215();
        }
        if (n instanceof oc0af730cc9f) {
            return "Search potion effects...";
        }
        if (n instanceof oc2ec6a95e5c) {
            return "Search items...";
        }
        return "Search blocks...";
    }

    private static int \u022c(N n) {
        if (n instanceof oce1bd2fa256) {
            return ((oce1bd2fa256)n).\u028d();
        }
        if (n instanceof oc6af36febc3) {
            return ((oc6af36febc3)n).\u0107();
        }
        return 0x72407EC6 ^ 0x72407EA6;
    }
}

