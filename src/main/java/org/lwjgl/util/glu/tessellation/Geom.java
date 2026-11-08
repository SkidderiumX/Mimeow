/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUvertex;

public class Geom {
    private Geom() {
    }

    static double EdgeEval(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        assert (Geom.VertLeq(gLUvertex, gLUvertex2) && Geom.VertLeq(gLUvertex2, gLUvertex3));
        double d = gLUvertex2.s - gLUvertex.s;
        double d2 = gLUvertex3.s - gLUvertex2.s;
        if (d + d2 > 0.0) {
            if (d < d2) {
                return gLUvertex2.t - gLUvertex.t + (gLUvertex.t - gLUvertex3.t) * (d / (d + d2));
            }
            return gLUvertex2.t - gLUvertex3.t + (gLUvertex3.t - gLUvertex.t) * (d2 / (d + d2));
        }
        return 0.0;
    }

    static double EdgeSign(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        assert (Geom.VertLeq(gLUvertex, gLUvertex2) && Geom.VertLeq(gLUvertex2, gLUvertex3));
        double d = gLUvertex2.s - gLUvertex.s;
        double d2 = gLUvertex3.s - gLUvertex2.s;
        if (d + d2 > 0.0) {
            return (gLUvertex2.t - gLUvertex3.t) * d + (gLUvertex2.t - gLUvertex.t) * d2;
        }
        return 0.0;
    }

    static double TransEval(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        assert (Geom.TransLeq(gLUvertex, gLUvertex2) && Geom.TransLeq(gLUvertex2, gLUvertex3));
        double d = gLUvertex2.t - gLUvertex.t;
        double d2 = gLUvertex3.t - gLUvertex2.t;
        if (d + d2 > 0.0) {
            if (d < d2) {
                return gLUvertex2.s - gLUvertex.s + (gLUvertex.s - gLUvertex3.s) * (d / (d + d2));
            }
            return gLUvertex2.s - gLUvertex3.s + (gLUvertex3.s - gLUvertex.s) * (d2 / (d + d2));
        }
        return 0.0;
    }

    static double TransSign(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        assert (Geom.TransLeq(gLUvertex, gLUvertex2) && Geom.TransLeq(gLUvertex2, gLUvertex3));
        double d = gLUvertex2.t - gLUvertex.t;
        double d2 = gLUvertex3.t - gLUvertex2.t;
        if (d + d2 > 0.0) {
            return (gLUvertex2.s - gLUvertex3.s) * d + (gLUvertex2.s - gLUvertex.s) * d2;
        }
        return 0.0;
    }

    static boolean VertCCW(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3) {
        return gLUvertex.s * (gLUvertex2.t - gLUvertex3.t) + gLUvertex2.s * (gLUvertex3.t - gLUvertex.t) + gLUvertex3.s * (gLUvertex.t - gLUvertex2.t) >= 0.0;
    }

    static double Interpolate(double d, double d2, double d3, double d4) {
        d = d < 0.0 ? 0.0 : d;
        double d5 = d3 = d3 < 0.0 ? 0.0 : d3;
        if (d <= d3) {
            if (d3 == 0.0) {
                return (d2 + d4) / 2.0;
            }
            return d2 + (d4 - d2) * (d / (d + d3));
        }
        return d4 + (d2 - d4) * (d3 / (d + d3));
    }

    static void EdgeIntersect(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, GLUvertex gLUvertex4, GLUvertex gLUvertex5) {
        double d;
        double d2;
        GLUvertex gLUvertex6;
        if (!Geom.VertLeq(gLUvertex, gLUvertex2)) {
            gLUvertex6 = gLUvertex;
            gLUvertex = gLUvertex2;
            gLUvertex2 = gLUvertex6;
        }
        if (!Geom.VertLeq(gLUvertex3, gLUvertex4)) {
            gLUvertex6 = gLUvertex3;
            gLUvertex3 = gLUvertex4;
            gLUvertex4 = gLUvertex6;
        }
        if (!Geom.VertLeq(gLUvertex, gLUvertex3)) {
            gLUvertex6 = gLUvertex;
            gLUvertex = gLUvertex3;
            gLUvertex3 = gLUvertex6;
            gLUvertex6 = gLUvertex2;
            gLUvertex2 = gLUvertex4;
            gLUvertex4 = gLUvertex6;
        }
        if (!Geom.VertLeq(gLUvertex3, gLUvertex2)) {
            gLUvertex5.s = (gLUvertex3.s + gLUvertex2.s) / 2.0;
        } else if (Geom.VertLeq(gLUvertex2, gLUvertex4)) {
            d2 = Geom.EdgeEval(gLUvertex, gLUvertex3, gLUvertex2);
            if (d2 + (d = Geom.EdgeEval(gLUvertex3, gLUvertex2, gLUvertex4)) < 0.0) {
                d2 = -d2;
                d = -d;
            }
            gLUvertex5.s = Geom.Interpolate(d2, gLUvertex3.s, d, gLUvertex2.s);
        } else {
            d2 = Geom.EdgeSign(gLUvertex, gLUvertex3, gLUvertex2);
            if (d2 + (d = -Geom.EdgeSign(gLUvertex, gLUvertex4, gLUvertex2)) < 0.0) {
                d2 = -d2;
                d = -d;
            }
            gLUvertex5.s = Geom.Interpolate(d2, gLUvertex3.s, d, gLUvertex4.s);
        }
        if (!Geom.TransLeq(gLUvertex, gLUvertex2)) {
            gLUvertex6 = gLUvertex;
            gLUvertex = gLUvertex2;
            gLUvertex2 = gLUvertex6;
        }
        if (!Geom.TransLeq(gLUvertex3, gLUvertex4)) {
            gLUvertex6 = gLUvertex3;
            gLUvertex3 = gLUvertex4;
            gLUvertex4 = gLUvertex6;
        }
        if (!Geom.TransLeq(gLUvertex, gLUvertex3)) {
            gLUvertex6 = gLUvertex3;
            gLUvertex3 = gLUvertex;
            gLUvertex = gLUvertex6;
            gLUvertex6 = gLUvertex4;
            gLUvertex4 = gLUvertex2;
            gLUvertex2 = gLUvertex6;
        }
        if (!Geom.TransLeq(gLUvertex3, gLUvertex2)) {
            gLUvertex5.t = (gLUvertex3.t + gLUvertex2.t) / 2.0;
        } else if (Geom.TransLeq(gLUvertex2, gLUvertex4)) {
            d2 = Geom.TransEval(gLUvertex, gLUvertex3, gLUvertex2);
            if (d2 + (d = Geom.TransEval(gLUvertex3, gLUvertex2, gLUvertex4)) < 0.0) {
                d2 = -d2;
                d = -d;
            }
            gLUvertex5.t = Geom.Interpolate(d2, gLUvertex3.t, d, gLUvertex2.t);
        } else {
            d2 = Geom.TransSign(gLUvertex, gLUvertex3, gLUvertex2);
            if (d2 + (d = -Geom.TransSign(gLUvertex, gLUvertex4, gLUvertex2)) < 0.0) {
                d2 = -d2;
                d = -d;
            }
            gLUvertex5.t = Geom.Interpolate(d2, gLUvertex3.t, d, gLUvertex4.t);
        }
    }

    static boolean VertEq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        return gLUvertex.s == gLUvertex2.s && gLUvertex.t == gLUvertex2.t;
    }

    static boolean VertLeq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        return gLUvertex.s < gLUvertex2.s || gLUvertex.s == gLUvertex2.s && gLUvertex.t <= gLUvertex2.t;
    }

    static boolean TransLeq(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        return gLUvertex.t < gLUvertex2.t || gLUvertex.t == gLUvertex2.t && gLUvertex.s <= gLUvertex2.s;
    }

    static boolean EdgeGoesLeft(GLUhalfEdge gLUhalfEdge) {
        return Geom.VertLeq(gLUhalfEdge.Sym.Org, gLUhalfEdge.Org);
    }

    static boolean EdgeGoesRight(GLUhalfEdge gLUhalfEdge) {
        return Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge.Sym.Org);
    }

    static double VertL1dist(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        return Math.abs(gLUvertex.s - gLUvertex2.s) + Math.abs(gLUvertex.t - gLUvertex2.t);
    }
}

