/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc2922be51da;
import x.oc507025139f;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc6abd5869f3;
import x.oc84f20a0bc5;
import x.oca9cc61aada;
import x.ocb8b190c865;
import x.ocbab3c9954b;
import x.ocbb5aeb6bd8;
import x.occ2f8dff8d8;
import x.occb36f998dc;
import x.ocd299de7725;
import x.oce4cea752dd;
import x.oce67b724dc6;
import x.ocf5b7e839f8;

public class ocb58b5235c7
extends oc69da1aa7f5 {
    private final oca9cc61aada \u0541;
    private final oca9cc61aada \u02a8;
    private final oca9cc61aada \u029a;
    private final oca9cc61aada \u0103;
    private final oca9cc61aada \u045c;
    private final occ2f8dff8d8 \u01fa;
    private final ocbb5aeb6bd8 \u013e = new ocbb5aeb6bd8();
    private final oc6abd5869f3 \u04cd = new oc6abd5869f3(this);
    private final ocb8b190c865 \u0243 = new ocb8b190c865();
    private final ocd299de7725 \u01d5 = new ocd299de7725();
    public static boolean \u017d;

    public ocb58b5235c7() {
        super("AutoSoup", oce4cea752dd.\u0437);
        this.\u0105("Uses soup at Min Health and heals toward Max Health.");
        this.\u0541 = new oca9cc61aada("Min Health", 13.0, 0.0, 20.0, 0.1);
        this.\u028c(this.\u0541);
        this.\u02a8 = new oca9cc61aada("Max Health", 20.0, 0.0, 20.0, 0.1);
        this.\u028c(this.\u02a8);
        this.\u029a = new oca9cc61aada("Randomization", 0.5, 0.0, 1.0, 0.01);
        this.\u028c(this.\u029a);
        this.\u0103 = new oca9cc61aada("Switch Delay", 2.0, 0.0, 10.0, 0.1);
        this.\u028c(this.\u0103);
        this.\u045c = new oca9cc61aada("Use Delay", 0.5, 0.0, 2.0, 0.01);
        this.\u028c(this.\u045c);
        this.\u01fa = new occ2f8dff8d8("Drop bowls", true);
        this.\u028c(this.\u01fa);
    }

    @Override
    public void z$2zw1jy3uhp6iv() {
        block18: {
            ocb58b5235c7 ocb58b5235c72;
            block21: {
                int n;
                block19: {
                    block20: {
                        block16: {
                            block17: {
                                n = oc84f20a0bc5.\u0117;
                                ocb58b5235c72 = this;
                                if (n != 0) break block16;
                                if (ocb58b5235c72.\u0177()) break block17;
                                super.z$2zw1jy3uhp6iv();
                                if (n == 0) break block18;
                            }
                            ocb58b5235c72 = this;
                        }
                        if (n != 0) break block19;
                        if (!oc2922be51da.\u016a(ocb58b5235c72.\u027d())) break block20;
                        this.\u0425();
                        if (n == 0) break block18;
                    }
                    ocb58b5235c72 = this;
                }
                if (n != 0) break block21;
                if (!ocb58b5235c72.z$3rzb3dil7uydr()) break block18;
                ocb58b5235c72 = this;
            }
            ocb58b5235c72.z$1ca1cmv0s357();
        }
    }

    @Override
    public void onEnable() {
        this.\u013e.\u0543();
    }

    @Override
    public void z$1ca1cmv0s357() {
        block10: {
            ocb58b5235c7 ocb58b5235c72;
            block8: {
                block9: {
                    int n = oc84f20a0bc5.\u0117;
                    ocb58b5235c72 = this;
                    if (n != 0) break block8;
                    if (!ocb58b5235c72.z$3rzb3dil7uydr()) break block9;
                    ocb58b5235c72 = this;
                    if (n != 0) break block8;
                    if (ocb58b5235c72.\u013e.\u0428()) break block10;
                }
                ocb58b5235c72 = this;
            }
            super.z$1ca1cmv0s357();
        }
    }

    @oc66fa4f2195
    public void \u02a1(occb36f998dc occb36f998dc2) {
        block4: {
            if (oc2922be51da.\u047c() && oc69da1aa7f5.\u0151.currentScreen == null) break block4;
            this.\u04cd.\u0244();
            this.\u013e.\u0273(this.\u04cd);
            return;
        }
        this.\u013e.\u0280(this.\u04cd, new oce67b724dc6(this), (float)this.\u0541.\u04c1(), (float)this.\u02a8.\u04c1(), (float)this.\u0103.\u04c1(), (float)this.\u045c.\u04c1(), this.\u01fa.\u01ed());
    }

    @oc66fa4f2195
    public void \u04c7(oc507025139f oc507025139f2) {
        if (ocf5b7e839f8.\u0231() == this) {
            oc507025139f2.setCanceled(true);
        }
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        block20: {
            ocb58b5235c7 ocb58b5235c72;
            block22: {
                oca9cc61aada oca9cc61aada3;
                block21: {
                    int n;
                    block18: {
                        block19: {
                            n = oc84f20a0bc5.\u0117;
                            oca9cc61aada3 = oca9cc61aada2;
                            if (n != 0) break block18;
                            if (oca9cc61aada3 != this.\u0541) break block19;
                            oca9cc61aada3 = this.\u0541;
                            if (n != 0) break block18;
                            if (!(oca9cc61aada3.\u04c1() > this.\u02a8.\u04c1())) break block19;
                            this.\u02a8.\u021e(this.\u0541.\u04c1());
                            if (n == 0) break block20;
                        }
                        oca9cc61aada3 = oca9cc61aada2;
                    }
                    if (n != 0) break block21;
                    if (oca9cc61aada3 != this.\u02a8) break block20;
                    ocb58b5235c72 = this;
                    if (n != 0) break block22;
                    oca9cc61aada3 = ocb58b5235c72.\u02a8;
                }
                if (!(oca9cc61aada3.\u04c1() < this.\u0541.\u04c1())) break block20;
                ocb58b5235c72 = this;
            }
            ocb58b5235c72.\u0541.\u021e(this.\u02a8.\u04c1());
        }
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        if (n instanceof oca9cc61aada) {
            this.z$1sehylui0i4ix((oca9cc61aada)n);
        }
    }

    @Override
    public void onDisable() {
        this.\u04cd.\u0244();
    }

    @oc66fa4f2195
    public void \u0470(ocbab3c9954b ocbab3c9954b2) {
        this.\u04cd.\u0244();
        this.\u013e.\u0273(this.\u04cd);
    }
}

