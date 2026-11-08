/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.CachedVertex;
import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.GLUtessellatorImpl;

public class Render {
    private static final boolean USE_OPTIMIZED_CODE_PATH = false;
    private static final RenderFan renderFan = new RenderFan();
    private static final RenderStrip renderStrip = new RenderStrip();
    private static final RenderTriangle renderTriangle = new RenderTriangle();
    private static final int SIGN_INCONSISTENT = 2;

    private Render() {
    }

    public static void __gl_renderMesh(GLUtessellatorImpl gLUtessellatorImpl, GLUmesh gLUmesh) {
        gLUtessellatorImpl.lonelyTriList = null;
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            gLUface.marked = false;
            gLUface = gLUface.next;
        }
        gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            if (gLUface.inside && !gLUface.marked) {
                Render.RenderMaximumFaceGroup(gLUtessellatorImpl, gLUface);
                assert (gLUface.marked);
            }
            gLUface = gLUface.next;
        }
        if (gLUtessellatorImpl.lonelyTriList != null) {
            Render.RenderLonelyTriangles(gLUtessellatorImpl, gLUtessellatorImpl.lonelyTriList);
            gLUtessellatorImpl.lonelyTriList = null;
        }
    }

    static void RenderMaximumFaceGroup(GLUtessellatorImpl gLUtessellatorImpl, GLUface gLUface) {
        GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
        FaceCount faceCount = new FaceCount();
        faceCount.size = 1L;
        faceCount.eStart = gLUhalfEdge;
        faceCount.render = renderTriangle;
        if (!gLUtessellatorImpl.flagBoundary) {
            FaceCount faceCount2 = Render.MaximumFan(gLUhalfEdge);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
            faceCount2 = Render.MaximumFan(gLUhalfEdge.Lnext);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
            faceCount2 = Render.MaximumFan(gLUhalfEdge.Onext.Sym);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
            faceCount2 = Render.MaximumStrip(gLUhalfEdge);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
            faceCount2 = Render.MaximumStrip(gLUhalfEdge.Lnext);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
            faceCount2 = Render.MaximumStrip(gLUhalfEdge.Onext.Sym);
            if (faceCount2.size > faceCount.size) {
                faceCount = faceCount2;
            }
        }
        faceCount.render.render(gLUtessellatorImpl, faceCount.eStart, faceCount.size);
    }

    private static boolean Marked(GLUface gLUface) {
        return !gLUface.inside || gLUface.marked;
    }

    private static GLUface AddToTrail(GLUface gLUface, GLUface gLUface2) {
        gLUface.trail = gLUface2;
        gLUface.marked = true;
        return gLUface;
    }

    private static void FreeTrail(GLUface gLUface) {
        while (gLUface != null) {
            gLUface.marked = false;
            gLUface = gLUface.trail;
        }
    }

    static FaceCount MaximumFan(GLUhalfEdge gLUhalfEdge) {
        FaceCount faceCount = new FaceCount(0L, null, renderFan);
        GLUface gLUface = null;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        while (!Render.Marked(gLUhalfEdge2.Lface)) {
            gLUface = Render.AddToTrail(gLUhalfEdge2.Lface, gLUface);
            ++faceCount.size;
            gLUhalfEdge2 = gLUhalfEdge2.Onext;
        }
        gLUhalfEdge2 = gLUhalfEdge;
        while (!Render.Marked(gLUhalfEdge2.Sym.Lface)) {
            gLUface = Render.AddToTrail(gLUhalfEdge2.Sym.Lface, gLUface);
            ++faceCount.size;
            gLUhalfEdge2 = gLUhalfEdge2.Sym.Lnext;
        }
        faceCount.eStart = gLUhalfEdge2;
        Render.FreeTrail(gLUface);
        return faceCount;
    }

    private static boolean IsEven(long l) {
        return (l & 1L) == 0L;
    }

    static FaceCount MaximumStrip(GLUhalfEdge gLUhalfEdge) {
        FaceCount faceCount = new FaceCount(0L, null, renderStrip);
        long l = 0L;
        long l2 = 0L;
        GLUface gLUface = null;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge;
        while (!Render.Marked(gLUhalfEdge2.Lface)) {
            gLUface = Render.AddToTrail(gLUhalfEdge2.Lface, gLUface);
            ++l2;
            gLUhalfEdge2 = gLUhalfEdge2.Lnext.Sym;
            if (Render.Marked(gLUhalfEdge2.Lface)) break;
            gLUface = Render.AddToTrail(gLUhalfEdge2.Lface, gLUface);
            ++l2;
            gLUhalfEdge2 = gLUhalfEdge2.Onext;
        }
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2;
        gLUhalfEdge2 = gLUhalfEdge;
        while (!Render.Marked(gLUhalfEdge2.Sym.Lface)) {
            gLUface = Render.AddToTrail(gLUhalfEdge2.Sym.Lface, gLUface);
            ++l;
            gLUhalfEdge2 = gLUhalfEdge2.Sym.Lnext;
            if (Render.Marked(gLUhalfEdge2.Sym.Lface)) break;
            gLUface = Render.AddToTrail(gLUhalfEdge2.Sym.Lface, gLUface);
            ++l;
            gLUhalfEdge2 = gLUhalfEdge2.Sym.Onext.Sym;
        }
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2;
        faceCount.size = l2 + l;
        if (Render.IsEven(l2)) {
            faceCount.eStart = gLUhalfEdge3.Sym;
        } else if (Render.IsEven(l)) {
            faceCount.eStart = gLUhalfEdge4;
        } else {
            --faceCount.size;
            faceCount.eStart = gLUhalfEdge4.Onext;
        }
        Render.FreeTrail(gLUface);
        return faceCount;
    }

    static void RenderLonelyTriangles(GLUtessellatorImpl gLUtessellatorImpl, GLUface gLUface) {
        int n = -1;
        gLUtessellatorImpl.callBeginOrBeginData(4);
        while (gLUface != null) {
            GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
            do {
                if (gLUtessellatorImpl.flagBoundary) {
                    int n2;
                    int n3 = n2 = !gLUhalfEdge.Sym.Lface.inside ? 1 : 0;
                    if (n != n2) {
                        n = n2;
                        gLUtessellatorImpl.callEdgeFlagOrEdgeFlagData(n != 0);
                    }
                }
                gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Org.data);
            } while ((gLUhalfEdge = gLUhalfEdge.Lnext) != gLUface.anEdge);
            gLUface = gLUface.trail;
        }
        gLUtessellatorImpl.callEndOrEndData();
    }

    public static void __gl_renderBoundary(GLUtessellatorImpl gLUtessellatorImpl, GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            if (gLUface.inside) {
                gLUtessellatorImpl.callBeginOrBeginData(2);
                GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
                do {
                    gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Org.data);
                } while ((gLUhalfEdge = gLUhalfEdge.Lnext) != gLUface.anEdge);
                gLUtessellatorImpl.callEndOrEndData();
            }
            gLUface = gLUface.next;
        }
    }

    static int ComputeNormal(GLUtessellatorImpl gLUtessellatorImpl, double[] dArray, boolean bl) {
        CachedVertex[] cachedVertexArray = gLUtessellatorImpl.cache;
        int n = gLUtessellatorImpl.cacheCount;
        double[] dArray2 = new double[3];
        int n2 = 0;
        if (!bl) {
            dArray[2] = 0.0;
            dArray[1] = 0.0;
            dArray[0] = 0.0;
        }
        int n3 = 1;
        double d = cachedVertexArray[n3].coords[0] - cachedVertexArray[0].coords[0];
        double d2 = cachedVertexArray[n3].coords[1] - cachedVertexArray[0].coords[1];
        double d3 = cachedVertexArray[n3].coords[2] - cachedVertexArray[0].coords[2];
        while (++n3 < n) {
            double d4 = d;
            double d5 = d2;
            double d6 = d3;
            d = cachedVertexArray[n3].coords[0] - cachedVertexArray[0].coords[0];
            d2 = cachedVertexArray[n3].coords[1] - cachedVertexArray[0].coords[1];
            d3 = cachedVertexArray[n3].coords[2] - cachedVertexArray[0].coords[2];
            dArray2[0] = d5 * d3 - d6 * d2;
            dArray2[1] = d6 * d - d4 * d3;
            dArray2[2] = d4 * d2 - d5 * d;
            double d7 = dArray2[0] * dArray[0] + dArray2[1] * dArray[1] + dArray2[2] * dArray[2];
            if (!bl) {
                if (d7 >= 0.0) {
                    dArray[0] = dArray[0] + dArray2[0];
                    dArray[1] = dArray[1] + dArray2[1];
                    dArray[2] = dArray[2] + dArray2[2];
                    continue;
                }
                dArray[0] = dArray[0] - dArray2[0];
                dArray[1] = dArray[1] - dArray2[1];
                dArray[2] = dArray[2] - dArray2[2];
                continue;
            }
            if (d7 == 0.0) continue;
            if (d7 > 0.0) {
                if (n2 < 0) {
                    return 2;
                }
                n2 = 1;
                continue;
            }
            if (n2 > 0) {
                return 2;
            }
            n2 = -1;
        }
        return n2;
    }

    public static boolean __gl_renderCache(GLUtessellatorImpl gLUtessellatorImpl) {
        int n;
        CachedVertex[] cachedVertexArray = gLUtessellatorImpl.cache;
        int n2 = gLUtessellatorImpl.cacheCount;
        double[] dArray = new double[3];
        if (gLUtessellatorImpl.cacheCount < 3) {
            return true;
        }
        dArray[0] = gLUtessellatorImpl.normal[0];
        dArray[1] = gLUtessellatorImpl.normal[1];
        dArray[2] = gLUtessellatorImpl.normal[2];
        if (dArray[0] == 0.0 && dArray[1] == 0.0 && dArray[2] == 0.0) {
            Render.ComputeNormal(gLUtessellatorImpl, dArray, false);
        }
        if ((n = Render.ComputeNormal(gLUtessellatorImpl, dArray, true)) == 2) {
            return false;
        }
        return n == 0;
    }

    private static class FaceCount {
        long size;
        GLUhalfEdge eStart;
        renderCallBack render;

        private FaceCount() {
        }

        private FaceCount(long l, GLUhalfEdge gLUhalfEdge, renderCallBack renderCallBack2) {
            this.size = l;
            this.eStart = gLUhalfEdge;
            this.render = renderCallBack2;
        }
    }

    private static class RenderTriangle
    implements renderCallBack {
        private RenderTriangle() {
        }

        @Override
        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long l) {
            assert (l == 1L);
            gLUtessellatorImpl.lonelyTriList = Render.AddToTrail(gLUhalfEdge.Lface, gLUtessellatorImpl.lonelyTriList);
        }
    }

    private static interface renderCallBack {
        public void render(GLUtessellatorImpl var1, GLUhalfEdge var2, long var3);
    }

    private static class RenderFan
    implements renderCallBack {
        private RenderFan() {
        }

        @Override
        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long l) {
            gLUtessellatorImpl.callBeginOrBeginData(6);
            gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Org.data);
            gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Sym.Org.data);
            while (!Render.Marked(gLUhalfEdge.Lface)) {
                gLUhalfEdge.Lface.marked = true;
                --l;
                gLUhalfEdge = gLUhalfEdge.Onext;
                gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Sym.Org.data);
            }
            assert (l == 0L);
            gLUtessellatorImpl.callEndOrEndData();
        }
    }

    private static class RenderStrip
    implements renderCallBack {
        private RenderStrip() {
        }

        @Override
        public void render(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, long l) {
            gLUtessellatorImpl.callBeginOrBeginData(5);
            gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Org.data);
            gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Sym.Org.data);
            while (!Render.Marked(gLUhalfEdge.Lface)) {
                gLUhalfEdge.Lface.marked = true;
                --l;
                gLUhalfEdge = gLUhalfEdge.Lnext.Sym;
                gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Org.data);
                if (Render.Marked(gLUhalfEdge.Lface)) break;
                gLUhalfEdge.Lface.marked = true;
                --l;
                gLUhalfEdge = gLUhalfEdge.Onext;
                gLUtessellatorImpl.callVertexOrVertexData(gLUhalfEdge.Sym.Org.data);
            }
            assert (l == 0L);
            gLUtessellatorImpl.callEndOrEndData();
        }
    }
}

