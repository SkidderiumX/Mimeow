/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3d8ab304f7;
import x.oc75d51ec7eb;

public class oc304b542f7a {
    private oc3d8ab304f7 \u00d4;
    private long \u0396;
    private long \u0480;
    private long \u04a8;
    private double \u0548;
    private double \u02b5;
    private double \u048f;
    private boolean \u0410;
    public static boolean \u0398;

    public oc304b542f7a(oc3d8ab304f7 oc3d8ab304f72, long l) {
        this.\u00d4 = oc3d8ab304f72;
        this.\u04a8 = System.currentTimeMillis();
        this.\u0396 = l;
    }

    public void \u010c(double d) {
        block26: {
            double d2;
            block24: {
                oc304b542f7a oc304b542f7a2;
                block25: {
                    Object object;
                    int n;
                    block23: {
                        block20: {
                            long l;
                            block21: {
                                block22: {
                                    long l2;
                                    block18: {
                                        oc304b542f7a oc304b542f7a3;
                                        block19: {
                                            n = oc75d51ec7eb.\u03e9;
                                            oc304b542f7a3 = this;
                                            l2 = System.currentTimeMillis();
                                            if (n != 0) break block18;
                                            oc304b542f7a3.\u0480 = l2;
                                            if (this.\u02b5 == d) break block19;
                                            this.\u02b5 = d;
                                            this.\u02a9();
                                            if (n == 0) break block20;
                                        }
                                        oc304b542f7a3 = this;
                                        l2 = this.\u0480 - this.\u0396;
                                    }
                                    long l3 = l2 - this.\u04a8;
                                    l = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                                    if (n != 0) break block21;
                                    if (l <= 0) break block22;
                                    l = 1;
                                    break block21;
                                }
                                l = 0;
                            }
                            oc304b542f7a3.\u0410 = l;
                            object = this;
                            if (n != 0) break block23;
                            if (!((oc304b542f7a)object).\u0410) break block20;
                            this.\u048f = d;
                            return;
                        }
                        object = this.\u00d4.\u0523().apply(this.\u0426());
                    }
                    d2 = (Double)object;
                    oc304b542f7a2 = this;
                    if (n != 0) break block24;
                    if (!(oc304b542f7a2.\u048f > d)) break block25;
                    this.\u048f = this.\u0548 - (this.\u0548 - d) * d2;
                    if (n == 0) break block26;
                }
                oc304b542f7a2 = this;
            }
            oc304b542f7a2.\u048f = this.\u0548 + (d - this.\u0548) * d2;
        }
    }

    public double \u0426() {
        return (double)(System.currentTimeMillis() - this.\u04a8) / (double)this.\u0396;
    }

    public void \u02a9() {
        this.\u04a8 = System.currentTimeMillis();
        this.\u0548 = this.\u048f;
        this.\u0410 = false;
    }

    public oc3d8ab304f7 \u0234() {
        return this.\u00d4;
    }

    public void \u03f4(oc3d8ab304f7 oc3d8ab304f72) {
        this.\u00d4 = oc3d8ab304f72;
    }

    public long \u03cf() {
        return this.\u0396;
    }

    public void \u01b6(long l) {
        this.\u0396 = l;
    }

    public long \u0397() {
        return this.\u0480;
    }

    public void \u038c(long l) {
        this.\u0480 = l;
    }

    public long \u00df() {
        return this.\u04a8;
    }

    public void \u03fe(long l) {
        this.\u04a8 = l;
    }

    public double \u01b0() {
        return this.\u0548;
    }

    public void \u0510(double d) {
        this.\u0548 = d;
    }

    public double \u04fb() {
        return this.\u02b5;
    }

    public void \u0293(double d) {
        this.\u02b5 = d;
    }

    public double \u03a9() {
        return this.\u048f;
    }

    public void \u0290(double d) {
        this.\u048f = d;
    }

    public boolean \u01c9() {
        return this.\u0410;
    }

    public void \u01ff(boolean bl) {
        this.\u0410 = bl;
    }
}

