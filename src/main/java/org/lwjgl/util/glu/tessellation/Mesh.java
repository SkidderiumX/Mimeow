/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.GLUvertex;

public class Mesh {
    private Mesh() {
    }

    static GLUhalfEdge MakeEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge3 = new GLUhalfEdge(true);
        GLUhalfEdge gLUhalfEdge4 = new GLUhalfEdge(false);
        if (!gLUhalfEdge.first) {
            gLUhalfEdge = gLUhalfEdge.Sym;
        }
        gLUhalfEdge4.next = gLUhalfEdge2 = gLUhalfEdge.Sym.next;
        gLUhalfEdge2.Sym.next = gLUhalfEdge3;
        gLUhalfEdge3.next = gLUhalfEdge;
        gLUhalfEdge.Sym.next = gLUhalfEdge4;
        gLUhalfEdge3.Sym = gLUhalfEdge4;
        gLUhalfEdge3.Onext = gLUhalfEdge3;
        gLUhalfEdge3.Lnext = gLUhalfEdge4;
        gLUhalfEdge3.Org = null;
        gLUhalfEdge3.Lface = null;
        gLUhalfEdge3.winding = 0;
        gLUhalfEdge3.activeRegion = null;
        gLUhalfEdge4.Sym = gLUhalfEdge3;
        gLUhalfEdge4.Onext = gLUhalfEdge4;
        gLUhalfEdge4.Lnext = gLUhalfEdge3;
        gLUhalfEdge4.Org = null;
        gLUhalfEdge4.Lface = null;
        gLUhalfEdge4.winding = 0;
        gLUhalfEdge4.activeRegion = null;
        return gLUhalfEdge3;
    }

    static void Splice(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge.Onext;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2.Onext;
        gLUhalfEdge3.Sym.Lnext = gLUhalfEdge2;
        gLUhalfEdge4.Sym.Lnext = gLUhalfEdge;
        gLUhalfEdge.Onext = gLUhalfEdge4;
        gLUhalfEdge2.Onext = gLUhalfEdge3;
    }

    static void MakeVertex(GLUvertex gLUvertex, GLUhalfEdge gLUhalfEdge, GLUvertex gLUvertex2) {
        GLUvertex gLUvertex3;
        GLUvertex gLUvertex4 = gLUvertex;
        assert (gLUvertex4 != null);
        gLUvertex4.prev = gLUvertex3 = gLUvertex2.prev;
        gLUvertex3.next = gLUvertex4;
        gLUvertex4.next = gLUvertex2;
        gLUvertex2.prev = gLUvertex4;
        gLUvertex4.anEdge = gLUhalfEdge;
        gLUvertex4.data = null;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        do {
            gLUhalfEdge2.Org = gLUvertex4;
        } while ((gLUhalfEdge2 = gLUhalfEdge2.Onext) != gLUhalfEdge);
    }

    static void MakeFace(GLUface gLUface, GLUhalfEdge gLUhalfEdge, GLUface gLUface2) {
        GLUface gLUface3;
        GLUface gLUface4 = gLUface;
        assert (gLUface4 != null);
        gLUface4.prev = gLUface3 = gLUface2.prev;
        gLUface3.next = gLUface4;
        gLUface4.next = gLUface2;
        gLUface2.prev = gLUface4;
        gLUface4.anEdge = gLUhalfEdge;
        gLUface4.data = null;
        gLUface4.trail = null;
        gLUface4.marked = false;
        gLUface4.inside = gLUface2.inside;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        do {
            gLUhalfEdge2.Lface = gLUface4;
        } while ((gLUhalfEdge2 = gLUhalfEdge2.Lnext) != gLUhalfEdge);
    }

    static void KillEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2;
        if (!gLUhalfEdge.first) {
            gLUhalfEdge = gLUhalfEdge.Sym;
        }
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge.next;
        gLUhalfEdge3.Sym.next = gLUhalfEdge2 = gLUhalfEdge.Sym.next;
        gLUhalfEdge2.Sym.next = gLUhalfEdge3;
    }

    static void KillVertex(GLUvertex gLUvertex, GLUvertex gLUvertex2) {
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge = gLUvertex.anEdge;
        do {
            gLUhalfEdge2.Org = gLUvertex2;
        } while ((gLUhalfEdge2 = gLUhalfEdge2.Onext) != gLUhalfEdge);
        GLUvertex gLUvertex3 = gLUvertex.prev;
        GLUvertex gLUvertex4 = gLUvertex.next;
        gLUvertex4.prev = gLUvertex3;
        gLUvertex3.next = gLUvertex4;
    }

    static void KillFace(GLUface gLUface, GLUface gLUface2) {
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge = gLUface.anEdge;
        do {
            gLUhalfEdge2.Lface = gLUface2;
        } while ((gLUhalfEdge2 = gLUhalfEdge2.Lnext) != gLUhalfEdge);
        GLUface gLUface3 = gLUface.prev;
        GLUface gLUface4 = gLUface.next;
        gLUface4.prev = gLUface3;
        gLUface3.next = gLUface4;
    }

    public static GLUhalfEdge __gl_meshMakeEdge(GLUmesh gLUmesh) {
        GLUvertex gLUvertex = new GLUvertex();
        GLUvertex gLUvertex2 = new GLUvertex();
        GLUface gLUface = new GLUface();
        GLUhalfEdge gLUhalfEdge = Mesh.MakeEdge(gLUmesh.eHead);
        if (gLUhalfEdge == null) {
            return null;
        }
        Mesh.MakeVertex(gLUvertex, gLUhalfEdge, gLUmesh.vHead);
        Mesh.MakeVertex(gLUvertex2, gLUhalfEdge.Sym, gLUmesh.vHead);
        Mesh.MakeFace(gLUface, gLUhalfEdge, gLUmesh.fHead);
        return gLUhalfEdge;
    }

    public static boolean __gl_meshSplice(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        Object object;
        boolean bl = false;
        boolean bl2 = false;
        if (gLUhalfEdge == gLUhalfEdge2) {
            return true;
        }
        if (gLUhalfEdge2.Org != gLUhalfEdge.Org) {
            bl2 = true;
            Mesh.KillVertex(gLUhalfEdge2.Org, gLUhalfEdge.Org);
        }
        if (gLUhalfEdge2.Lface != gLUhalfEdge.Lface) {
            bl = true;
            Mesh.KillFace(gLUhalfEdge2.Lface, gLUhalfEdge.Lface);
        }
        Mesh.Splice(gLUhalfEdge2, gLUhalfEdge);
        if (!bl2) {
            object = new GLUvertex();
            Mesh.MakeVertex((GLUvertex)object, gLUhalfEdge2, gLUhalfEdge.Org);
            gLUhalfEdge.Org.anEdge = gLUhalfEdge;
        }
        if (!bl) {
            object = new GLUface();
            Mesh.MakeFace((GLUface)object, gLUhalfEdge2, gLUhalfEdge.Lface);
            gLUhalfEdge.Lface.anEdge = gLUhalfEdge;
        }
        return true;
    }

    static boolean __gl_meshDelete(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.Sym;
        boolean bl = false;
        if (gLUhalfEdge.Lface != gLUhalfEdge.Sym.Lface) {
            bl = true;
            Mesh.KillFace(gLUhalfEdge.Lface, gLUhalfEdge.Sym.Lface);
        }
        if (gLUhalfEdge.Onext == gLUhalfEdge) {
            Mesh.KillVertex(gLUhalfEdge.Org, null);
        } else {
            gLUhalfEdge.Sym.Lface.anEdge = gLUhalfEdge.Sym.Lnext;
            gLUhalfEdge.Org.anEdge = gLUhalfEdge.Onext;
            Mesh.Splice(gLUhalfEdge, gLUhalfEdge.Sym.Lnext);
            if (!bl) {
                GLUface gLUface = new GLUface();
                Mesh.MakeFace(gLUface, gLUhalfEdge, gLUhalfEdge.Lface);
            }
        }
        if (gLUhalfEdge2.Onext == gLUhalfEdge2) {
            Mesh.KillVertex(gLUhalfEdge2.Org, null);
            Mesh.KillFace(gLUhalfEdge2.Lface, null);
        } else {
            gLUhalfEdge.Lface.anEdge = gLUhalfEdge2.Sym.Lnext;
            gLUhalfEdge2.Org.anEdge = gLUhalfEdge2.Onext;
            Mesh.Splice(gLUhalfEdge2, gLUhalfEdge2.Sym.Lnext);
        }
        Mesh.KillEdge(gLUhalfEdge);
        return true;
    }

    static GLUhalfEdge __gl_meshAddEdgeVertex(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = Mesh.MakeEdge(gLUhalfEdge);
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Sym;
        Mesh.Splice(gLUhalfEdge2, gLUhalfEdge.Lnext);
        gLUhalfEdge2.Org = gLUhalfEdge.Sym.Org;
        GLUvertex gLUvertex = new GLUvertex();
        Mesh.MakeVertex(gLUvertex, gLUhalfEdge3, gLUhalfEdge2.Org);
        gLUhalfEdge2.Lface = gLUhalfEdge3.Lface = gLUhalfEdge.Lface;
        return gLUhalfEdge2;
    }

    public static GLUhalfEdge __gl_meshSplitEdge(GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = Mesh.__gl_meshAddEdgeVertex(gLUhalfEdge);
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Sym;
        Mesh.Splice(gLUhalfEdge.Sym, gLUhalfEdge.Sym.Sym.Lnext);
        Mesh.Splice(gLUhalfEdge.Sym, gLUhalfEdge3);
        gLUhalfEdge.Sym.Org = gLUhalfEdge3.Org;
        gLUhalfEdge3.Sym.Org.anEdge = gLUhalfEdge3.Sym;
        gLUhalfEdge3.Sym.Lface = gLUhalfEdge.Sym.Lface;
        gLUhalfEdge3.winding = gLUhalfEdge.winding;
        gLUhalfEdge3.Sym.winding = gLUhalfEdge.Sym.winding;
        return gLUhalfEdge3;
    }

    static GLUhalfEdge __gl_meshConnect(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        boolean bl = false;
        GLUhalfEdge gLUhalfEdge3 = Mesh.MakeEdge(gLUhalfEdge);
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge3.Sym;
        if (gLUhalfEdge2.Lface != gLUhalfEdge.Lface) {
            bl = true;
            Mesh.KillFace(gLUhalfEdge2.Lface, gLUhalfEdge.Lface);
        }
        Mesh.Splice(gLUhalfEdge3, gLUhalfEdge.Lnext);
        Mesh.Splice(gLUhalfEdge4, gLUhalfEdge2);
        gLUhalfEdge3.Org = gLUhalfEdge.Sym.Org;
        gLUhalfEdge4.Org = gLUhalfEdge2.Org;
        gLUhalfEdge3.Lface = gLUhalfEdge4.Lface = gLUhalfEdge.Lface;
        gLUhalfEdge.Lface.anEdge = gLUhalfEdge4;
        if (!bl) {
            GLUface gLUface = new GLUface();
            Mesh.MakeFace(gLUface, gLUhalfEdge3, gLUhalfEdge.Lface);
        }
        return gLUhalfEdge3;
    }

    static void __gl_meshZapFace(GLUface gLUface) {
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2 = gLUface.anEdge;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.Lnext;
        do {
            gLUhalfEdge = gLUhalfEdge3;
            gLUhalfEdge3 = gLUhalfEdge.Lnext;
            gLUhalfEdge.Lface = null;
            if (gLUhalfEdge.Sym.Lface != null) continue;
            if (gLUhalfEdge.Onext == gLUhalfEdge) {
                Mesh.KillVertex(gLUhalfEdge.Org, null);
            } else {
                gLUhalfEdge.Org.anEdge = gLUhalfEdge.Onext;
                Mesh.Splice(gLUhalfEdge, gLUhalfEdge.Sym.Lnext);
            }
            GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge.Sym;
            if (gLUhalfEdge4.Onext == gLUhalfEdge4) {
                Mesh.KillVertex(gLUhalfEdge4.Org, null);
            } else {
                gLUhalfEdge4.Org.anEdge = gLUhalfEdge4.Onext;
                Mesh.Splice(gLUhalfEdge4, gLUhalfEdge4.Sym.Lnext);
            }
            Mesh.KillEdge(gLUhalfEdge);
        } while (gLUhalfEdge != gLUhalfEdge2);
        GLUface gLUface2 = gLUface.prev;
        GLUface gLUface3 = gLUface.next;
        gLUface3.prev = gLUface2;
        gLUface2.next = gLUface3;
    }

    public static GLUmesh __gl_meshNewMesh() {
        GLUmesh gLUmesh = new GLUmesh();
        GLUvertex gLUvertex = gLUmesh.vHead;
        GLUface gLUface = gLUmesh.fHead;
        GLUhalfEdge gLUhalfEdge = gLUmesh.eHead;
        GLUhalfEdge gLUhalfEdge2 = gLUmesh.eHeadSym;
        gLUvertex.next = gLUvertex.prev = gLUvertex;
        gLUvertex.anEdge = null;
        gLUvertex.data = null;
        gLUface.next = gLUface.prev = gLUface;
        gLUface.anEdge = null;
        gLUface.data = null;
        gLUface.trail = null;
        gLUface.marked = false;
        gLUface.inside = false;
        gLUhalfEdge.next = gLUhalfEdge;
        gLUhalfEdge.Sym = gLUhalfEdge2;
        gLUhalfEdge.Onext = null;
        gLUhalfEdge.Lnext = null;
        gLUhalfEdge.Org = null;
        gLUhalfEdge.Lface = null;
        gLUhalfEdge.winding = 0;
        gLUhalfEdge.activeRegion = null;
        gLUhalfEdge2.next = gLUhalfEdge2;
        gLUhalfEdge2.Sym = gLUhalfEdge;
        gLUhalfEdge2.Onext = null;
        gLUhalfEdge2.Lnext = null;
        gLUhalfEdge2.Org = null;
        gLUhalfEdge2.Lface = null;
        gLUhalfEdge2.winding = 0;
        gLUhalfEdge2.activeRegion = null;
        return gLUmesh;
    }

    static GLUmesh __gl_meshUnion(GLUmesh gLUmesh, GLUmesh gLUmesh2) {
        GLUface gLUface = gLUmesh.fHead;
        GLUvertex gLUvertex = gLUmesh.vHead;
        GLUhalfEdge gLUhalfEdge = gLUmesh.eHead;
        GLUface gLUface2 = gLUmesh2.fHead;
        GLUvertex gLUvertex2 = gLUmesh2.vHead;
        GLUhalfEdge gLUhalfEdge2 = gLUmesh2.eHead;
        if (gLUface2.next != gLUface2) {
            gLUface.prev.next = gLUface2.next;
            gLUface2.next.prev = gLUface.prev;
            gLUface2.prev.next = gLUface;
            gLUface.prev = gLUface2.prev;
        }
        if (gLUvertex2.next != gLUvertex2) {
            gLUvertex.prev.next = gLUvertex2.next;
            gLUvertex2.next.prev = gLUvertex.prev;
            gLUvertex2.prev.next = gLUvertex;
            gLUvertex.prev = gLUvertex2.prev;
        }
        if (gLUhalfEdge2.next != gLUhalfEdge2) {
            gLUhalfEdge.Sym.next.Sym.next = gLUhalfEdge2.next;
            gLUhalfEdge2.next.Sym.next = gLUhalfEdge.Sym.next;
            gLUhalfEdge2.Sym.next.Sym.next = gLUhalfEdge;
            gLUhalfEdge.Sym.next = gLUhalfEdge2.Sym.next;
        }
        return gLUmesh;
    }

    static void __gl_meshDeleteMeshZap(GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead;
        while (gLUface.next != gLUface) {
            Mesh.__gl_meshZapFace(gLUface.next);
        }
        assert (gLUmesh.vHead.next == gLUmesh.vHead);
    }

    public static void __gl_meshDeleteMesh(GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            GLUface gLUface2;
            gLUface = gLUface2 = gLUface.next;
        }
        GLUvertex gLUvertex = gLUmesh.vHead.next;
        while (gLUvertex != gLUmesh.vHead) {
            GLUvertex gLUvertex2;
            gLUvertex = gLUvertex2 = gLUvertex.next;
        }
        GLUhalfEdge gLUhalfEdge = gLUmesh.eHead.next;
        while (gLUhalfEdge != gLUmesh.eHead) {
            GLUhalfEdge gLUhalfEdge2;
            gLUhalfEdge = gLUhalfEdge2 = gLUhalfEdge.next;
        }
    }

    public static void __gl_meshCheckMesh(GLUmesh gLUmesh) {
        GLUvertex gLUvertex;
        GLUhalfEdge gLUhalfEdge;
        GLUface gLUface;
        GLUface gLUface2 = gLUmesh.fHead;
        GLUvertex gLUvertex2 = gLUmesh.vHead;
        GLUhalfEdge gLUhalfEdge2 = gLUmesh.eHead;
        GLUface gLUface3 = gLUface2;
        gLUface3 = gLUface2;
        while ((gLUface = gLUface3.next) != gLUface2) {
            assert (gLUface.prev == gLUface3);
            gLUhalfEdge = gLUface.anEdge;
            do {
                assert (gLUhalfEdge.Sym != gLUhalfEdge);
                assert (gLUhalfEdge.Sym.Sym == gLUhalfEdge);
                assert (gLUhalfEdge.Lnext.Onext.Sym == gLUhalfEdge);
                assert (gLUhalfEdge.Onext.Sym.Lnext == gLUhalfEdge);
                assert (gLUhalfEdge.Lface == gLUface);
            } while ((gLUhalfEdge = gLUhalfEdge.Lnext) != gLUface.anEdge);
            gLUface3 = gLUface;
        }
        assert (gLUface.prev == gLUface3 && gLUface.anEdge == null && gLUface.data == null);
        GLUvertex gLUvertex3 = gLUvertex2;
        gLUvertex3 = gLUvertex2;
        while ((gLUvertex = gLUvertex3.next) != gLUvertex2) {
            assert (gLUvertex.prev == gLUvertex3);
            gLUhalfEdge = gLUvertex.anEdge;
            do {
                assert (gLUhalfEdge.Sym != gLUhalfEdge);
                assert (gLUhalfEdge.Sym.Sym == gLUhalfEdge);
                assert (gLUhalfEdge.Lnext.Onext.Sym == gLUhalfEdge);
                assert (gLUhalfEdge.Onext.Sym.Lnext == gLUhalfEdge);
                assert (gLUhalfEdge.Org == gLUvertex);
            } while ((gLUhalfEdge = gLUhalfEdge.Onext) != gLUvertex.anEdge);
            gLUvertex3 = gLUvertex;
        }
        assert (gLUvertex.prev == gLUvertex3 && gLUvertex.anEdge == null && gLUvertex.data == null);
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
        gLUhalfEdge3 = gLUhalfEdge2;
        while ((gLUhalfEdge = gLUhalfEdge3.next) != gLUhalfEdge2) {
            assert (gLUhalfEdge.Sym.next == gLUhalfEdge3.Sym);
            assert (gLUhalfEdge.Sym != gLUhalfEdge);
            assert (gLUhalfEdge.Sym.Sym == gLUhalfEdge);
            assert (gLUhalfEdge.Org != null);
            assert (gLUhalfEdge.Sym.Org != null);
            assert (gLUhalfEdge.Lnext.Onext.Sym == gLUhalfEdge);
            assert (gLUhalfEdge.Onext.Sym.Lnext == gLUhalfEdge);
            gLUhalfEdge3 = gLUhalfEdge;
        }
        assert (gLUhalfEdge.Sym.next == gLUhalfEdge3.Sym && gLUhalfEdge.Sym == gLUmesh.eHeadSym && gLUhalfEdge.Sym.Sym == gLUhalfEdge && gLUhalfEdge.Org == null && gLUhalfEdge.Sym.Org == null && gLUhalfEdge.Lface == null && gLUhalfEdge.Sym.Lface == null);
    }
}

