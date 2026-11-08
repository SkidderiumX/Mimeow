/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUtessellatorImpl;
import org.lwjgl.util.glu.tessellation.GLUvertex;

public class Normal {
    static boolean SLANTED_SWEEP;
    static double S_UNIT_X;
    static double S_UNIT_Y;
    private static final boolean TRUE_PROJECT = false;
    static final /* synthetic */ boolean $assertionsDisabled;

    private Normal() {
    }

    private static double Dot(double[] dArray, double[] dArray2) {
        return dArray[0] * dArray2[0] + dArray[1] * dArray2[1] + dArray[2] * dArray2[2];
    }

    static void Normalize(double[] dArray) {
        double d = dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2];
        if (!$assertionsDisabled && !(d > 0.0)) {
            throw new AssertionError();
        }
        d = Math.sqrt(d);
        dArray[0] = dArray[0] / d;
        dArray[1] = dArray[1] / d;
        dArray[2] = dArray[2] / d;
    }

    static int LongAxis(double[] dArray) {
        int n = 0;
        if (Math.abs(dArray[1]) > Math.abs(dArray[0])) {
            n = 1;
        }
        if (Math.abs(dArray[2]) > Math.abs(dArray[n])) {
            n = 2;
        }
        return n;
    }

    static void ComputeNormal(GLUtessellatorImpl gLUtessellatorImpl, double[] dArray) {
        int n;
        GLUvertex gLUvertex = gLUtessellatorImpl.mesh.vHead;
        double[] dArray2 = new double[3];
        double[] dArray3 = new double[3];
        GLUvertex[] gLUvertexArray = new GLUvertex[3];
        GLUvertex[] gLUvertexArray2 = new GLUvertex[3];
        double[] dArray4 = new double[3];
        double[] dArray5 = new double[3];
        double[] dArray6 = new double[3];
        dArray2[2] = -2.0E150;
        dArray2[1] = -2.0E150;
        dArray2[0] = -2.0E150;
        dArray3[2] = 2.0E150;
        dArray3[1] = 2.0E150;
        dArray3[0] = 2.0E150;
        GLUvertex gLUvertex2 = gLUvertex.next;
        while (gLUvertex2 != gLUvertex) {
            for (n = 0; n < 3; ++n) {
                double d = gLUvertex2.coords[n];
                if (d < dArray3[n]) {
                    dArray3[n] = d;
                    gLUvertexArray[n] = gLUvertex2;
                }
                if (!(d > dArray2[n])) continue;
                dArray2[n] = d;
                gLUvertexArray2[n] = gLUvertex2;
            }
            gLUvertex2 = gLUvertex2.next;
        }
        n = 0;
        if (dArray2[1] - dArray3[1] > dArray2[0] - dArray3[0]) {
            n = 1;
        }
        if (dArray2[2] - dArray3[2] > dArray2[n] - dArray3[n]) {
            n = 2;
        }
        if (dArray3[n] >= dArray2[n]) {
            dArray[0] = 0.0;
            dArray[1] = 0.0;
            dArray[2] = 1.0;
            return;
        }
        double d = 0.0;
        GLUvertex gLUvertex3 = gLUvertexArray[n];
        GLUvertex gLUvertex4 = gLUvertexArray2[n];
        dArray4[0] = gLUvertex3.coords[0] - gLUvertex4.coords[0];
        dArray4[1] = gLUvertex3.coords[1] - gLUvertex4.coords[1];
        dArray4[2] = gLUvertex3.coords[2] - gLUvertex4.coords[2];
        gLUvertex2 = gLUvertex.next;
        while (gLUvertex2 != gLUvertex) {
            dArray5[0] = gLUvertex2.coords[0] - gLUvertex4.coords[0];
            dArray5[1] = gLUvertex2.coords[1] - gLUvertex4.coords[1];
            dArray5[2] = gLUvertex2.coords[2] - gLUvertex4.coords[2];
            dArray6[0] = dArray4[1] * dArray5[2] - dArray4[2] * dArray5[1];
            dArray6[1] = dArray4[2] * dArray5[0] - dArray4[0] * dArray5[2];
            dArray6[2] = dArray4[0] * dArray5[1] - dArray4[1] * dArray5[0];
            double d2 = dArray6[0] * dArray6[0] + dArray6[1] * dArray6[1] + dArray6[2] * dArray6[2];
            if (d2 > d) {
                d = d2;
                dArray[0] = dArray6[0];
                dArray[1] = dArray6[1];
                dArray[2] = dArray6[2];
            }
            gLUvertex2 = gLUvertex2.next;
        }
        if (d <= 0.0) {
            dArray[2] = 0.0;
            dArray[1] = 0.0;
            dArray[0] = 0.0;
            dArray[Normal.LongAxis((double[])dArray4)] = 1.0;
        }
    }

    static void CheckOrientation(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUface gLUface = gLUtessellatorImpl.mesh.fHead;
        GLUvertex gLUvertex = gLUtessellatorImpl.mesh.vHead;
        double d = 0.0;
        GLUface gLUface2 = gLUface.next;
        while (gLUface2 != gLUface) {
            GLUhalfEdge gLUhalfEdge = gLUface2.anEdge;
            if (gLUhalfEdge.winding > 0) {
                do {
                    d += (gLUhalfEdge.Org.s - gLUhalfEdge.Sym.Org.s) * (gLUhalfEdge.Org.t + gLUhalfEdge.Sym.Org.t);
                } while ((gLUhalfEdge = gLUhalfEdge.Lnext) != gLUface2.anEdge);
            }
            gLUface2 = gLUface2.next;
        }
        if (d < 0.0) {
            GLUvertex gLUvertex2 = gLUvertex.next;
            while (gLUvertex2 != gLUvertex) {
                gLUvertex2.t = -gLUvertex2.t;
                gLUvertex2 = gLUvertex2.next;
            }
            gLUtessellatorImpl.tUnit[0] = -gLUtessellatorImpl.tUnit[0];
            gLUtessellatorImpl.tUnit[1] = -gLUtessellatorImpl.tUnit[1];
            gLUtessellatorImpl.tUnit[2] = -gLUtessellatorImpl.tUnit[2];
        }
    }

    public static void __gl_projectPolygon(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUvertex gLUvertex = gLUtessellatorImpl.mesh.vHead;
        double[] dArray = new double[3];
        boolean bl = false;
        dArray[0] = gLUtessellatorImpl.normal[0];
        dArray[1] = gLUtessellatorImpl.normal[1];
        dArray[2] = gLUtessellatorImpl.normal[2];
        if (dArray[0] == 0.0 && dArray[1] == 0.0 && dArray[2] == 0.0) {
            Normal.ComputeNormal(gLUtessellatorImpl, dArray);
            bl = true;
        }
        double[] dArray2 = gLUtessellatorImpl.sUnit;
        double[] dArray3 = gLUtessellatorImpl.tUnit;
        int n = Normal.LongAxis(dArray);
        dArray2[n] = 0.0;
        dArray2[(n + 1) % 3] = S_UNIT_X;
        dArray2[(n + 2) % 3] = S_UNIT_Y;
        dArray3[n] = 0.0;
        dArray3[(n + 1) % 3] = dArray[n] > 0.0 ? -S_UNIT_Y : S_UNIT_Y;
        dArray3[(n + 2) % 3] = dArray[n] > 0.0 ? S_UNIT_X : -S_UNIT_X;
        GLUvertex gLUvertex2 = gLUvertex.next;
        while (gLUvertex2 != gLUvertex) {
            gLUvertex2.s = Normal.Dot(gLUvertex2.coords, dArray2);
            gLUvertex2.t = Normal.Dot(gLUvertex2.coords, dArray3);
            gLUvertex2 = gLUvertex2.next;
        }
        if (bl) {
            Normal.CheckOrientation(gLUtessellatorImpl);
        }
    }

    static {
        boolean bl = $assertionsDisabled = !Normal.class.desiredAssertionStatus();
        if (false) {
            S_UNIT_X = 0.5094153956495538;
            S_UNIT_Y = 0.8605207462201063;
        } else {
            S_UNIT_X = 1.0;
            S_UNIT_Y = 0.0;
        }
    }
}

