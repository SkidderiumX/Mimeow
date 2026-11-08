/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.Geom;
import org.lwjgl.util.glu.tessellation.Mesh;

public class TessMono {
    TessMono() {
    }

    static boolean __gl_meshTessellateMonoRegion(GLUface gLUface) {
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUface.anEdge;
        assert (gLUhalfEdge2.Lnext != gLUhalfEdge2 && gLUhalfEdge2.Lnext.Lnext != gLUhalfEdge2);
        while (Geom.VertLeq(gLUhalfEdge2.Sym.Org, gLUhalfEdge2.Org)) {
            gLUhalfEdge2 = gLUhalfEdge2.Onext.Sym;
        }
        while (Geom.VertLeq(gLUhalfEdge2.Org, gLUhalfEdge2.Sym.Org)) {
            gLUhalfEdge2 = gLUhalfEdge2.Lnext;
        }
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Onext.Sym;
        while (gLUhalfEdge2.Lnext != gLUhalfEdge3) {
            if (Geom.VertLeq(gLUhalfEdge2.Sym.Org, gLUhalfEdge3.Org)) {
                while (gLUhalfEdge3.Lnext != gLUhalfEdge2 && (Geom.EdgeGoesLeft(gLUhalfEdge3.Lnext) || Geom.EdgeSign(gLUhalfEdge3.Org, gLUhalfEdge3.Sym.Org, gLUhalfEdge3.Lnext.Sym.Org) <= 0.0)) {
                    gLUhalfEdge = Mesh.__gl_meshConnect(gLUhalfEdge3.Lnext, gLUhalfEdge3);
                    if (gLUhalfEdge == null) {
                        return false;
                    }
                    gLUhalfEdge3 = gLUhalfEdge.Sym;
                }
                gLUhalfEdge3 = gLUhalfEdge3.Onext.Sym;
                continue;
            }
            while (gLUhalfEdge3.Lnext != gLUhalfEdge2 && (Geom.EdgeGoesRight(gLUhalfEdge2.Onext.Sym) || Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge2.Org, gLUhalfEdge2.Onext.Sym.Org) >= 0.0)) {
                gLUhalfEdge = Mesh.__gl_meshConnect(gLUhalfEdge2, gLUhalfEdge2.Onext.Sym);
                if (gLUhalfEdge == null) {
                    return false;
                }
                gLUhalfEdge2 = gLUhalfEdge.Sym;
            }
            gLUhalfEdge2 = gLUhalfEdge2.Lnext;
        }
        assert (gLUhalfEdge3.Lnext != gLUhalfEdge2);
        while (gLUhalfEdge3.Lnext.Lnext != gLUhalfEdge2) {
            gLUhalfEdge = Mesh.__gl_meshConnect(gLUhalfEdge3.Lnext, gLUhalfEdge3);
            if (gLUhalfEdge == null) {
                return false;
            }
            gLUhalfEdge3 = gLUhalfEdge.Sym;
        }
        return true;
    }

    public static boolean __gl_meshTessellateInterior(GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            GLUface gLUface2 = gLUface.next;
            if (gLUface.inside && !TessMono.__gl_meshTessellateMonoRegion(gLUface)) {
                return false;
            }
            gLUface = gLUface2;
        }
        return true;
    }

    public static void __gl_meshDiscardExterior(GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            GLUface gLUface2 = gLUface.next;
            if (!gLUface.inside) {
                Mesh.__gl_meshZapFace(gLUface);
            }
            gLUface = gLUface2;
        }
    }

    public static boolean __gl_meshSetWindingNumber(GLUmesh gLUmesh, int n, boolean bl) {
        GLUhalfEdge gLUhalfEdge = gLUmesh.eHead.next;
        while (gLUhalfEdge != gLUmesh.eHead) {
            GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.next;
            if (gLUhalfEdge.Sym.Lface.inside != gLUhalfEdge.Lface.inside) {
                gLUhalfEdge.winding = gLUhalfEdge.Lface.inside ? n : -n;
            } else if (!bl) {
                gLUhalfEdge.winding = 0;
            } else if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                return false;
            }
            gLUhalfEdge = gLUhalfEdge2;
        }
        return true;
    }
}

