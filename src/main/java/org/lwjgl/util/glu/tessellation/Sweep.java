/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.ActiveRegion;
import org.lwjgl.util.glu.tessellation.Dict;
import org.lwjgl.util.glu.tessellation.DictNode;
import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.GLUtessellatorImpl;
import org.lwjgl.util.glu.tessellation.GLUvertex;
import org.lwjgl.util.glu.tessellation.Geom;
import org.lwjgl.util.glu.tessellation.Mesh;
import org.lwjgl.util.glu.tessellation.PriorityQ;

public class Sweep {
    private static final boolean TOLERANCE_NONZERO = false;
    private static final double SENTINEL_COORD = 4.0E150;

    private Sweep() {
    }

    private static void DebugEvent(GLUtessellatorImpl gLUtessellatorImpl) {
    }

    private static void AddWinding(GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        gLUhalfEdge.winding += gLUhalfEdge2.winding;
        gLUhalfEdge.Sym.winding += gLUhalfEdge2.Sym.winding;
    }

    private static ActiveRegion RegionBelow(ActiveRegion activeRegion) {
        return (ActiveRegion)Dict.dictKey(Dict.dictPred(activeRegion.nodeUp));
    }

    private static ActiveRegion RegionAbove(ActiveRegion activeRegion) {
        return (ActiveRegion)Dict.dictKey(Dict.dictSucc(activeRegion.nodeUp));
    }

    static boolean EdgeLeq(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, ActiveRegion activeRegion2) {
        double d;
        GLUvertex gLUvertex = gLUtessellatorImpl.event;
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
        if (gLUhalfEdge.Sym.Org == gLUvertex) {
            if (gLUhalfEdge2.Sym.Org == gLUvertex) {
                if (Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge2.Org)) {
                    return Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org, gLUhalfEdge2.Org) <= 0.0;
                }
                return Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org, gLUhalfEdge.Org) >= 0.0;
            }
            return Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUvertex, gLUhalfEdge2.Org) <= 0.0;
        }
        if (gLUhalfEdge2.Sym.Org == gLUvertex) {
            return Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUvertex, gLUhalfEdge.Org) >= 0.0;
        }
        double d2 = Geom.EdgeEval(gLUhalfEdge.Sym.Org, gLUvertex, gLUhalfEdge.Org);
        return d2 >= (d = Geom.EdgeEval(gLUhalfEdge2.Sym.Org, gLUvertex, gLUhalfEdge2.Org));
    }

    static void DeleteRegion(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        if (activeRegion.fixUpperEdge) assert (activeRegion.eUp.winding == 0);
        activeRegion.eUp.activeRegion = null;
        Dict.dictDelete(gLUtessellatorImpl.dict, activeRegion.nodeUp);
    }

    static boolean FixUpperEdge(ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        assert (activeRegion.fixUpperEdge);
        if (!Mesh.__gl_meshDelete(activeRegion.eUp)) {
            return false;
        }
        activeRegion.fixUpperEdge = false;
        activeRegion.eUp = gLUhalfEdge;
        gLUhalfEdge.activeRegion = activeRegion;
        return true;
    }

    static ActiveRegion TopLeftRegion(ActiveRegion activeRegion) {
        GLUvertex gLUvertex = activeRegion.eUp.Org;
        do {
            activeRegion = Sweep.RegionAbove(activeRegion);
        } while (activeRegion.eUp.Org == gLUvertex);
        if (activeRegion.fixUpperEdge) {
            GLUhalfEdge gLUhalfEdge = Mesh.__gl_meshConnect(Sweep.RegionBelow((ActiveRegion)activeRegion).eUp.Sym, activeRegion.eUp.Lnext);
            if (gLUhalfEdge == null) {
                return null;
            }
            if (!Sweep.FixUpperEdge(activeRegion, gLUhalfEdge)) {
                return null;
            }
            activeRegion = Sweep.RegionAbove(activeRegion);
        }
        return activeRegion;
    }

    static ActiveRegion TopRightRegion(ActiveRegion activeRegion) {
        GLUvertex gLUvertex = activeRegion.eUp.Sym.Org;
        do {
            activeRegion = Sweep.RegionAbove(activeRegion);
        } while (activeRegion.eUp.Sym.Org == gLUvertex);
        return activeRegion;
    }

    static ActiveRegion AddRegionBelow(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        ActiveRegion activeRegion2 = new ActiveRegion();
        if (activeRegion2 == null) {
            throw new RuntimeException();
        }
        activeRegion2.eUp = gLUhalfEdge;
        activeRegion2.nodeUp = Dict.dictInsertBefore(gLUtessellatorImpl.dict, activeRegion.nodeUp, activeRegion2);
        if (activeRegion2.nodeUp == null) {
            throw new RuntimeException();
        }
        activeRegion2.fixUpperEdge = false;
        activeRegion2.sentinel = false;
        activeRegion2.dirty = false;
        gLUhalfEdge.activeRegion = activeRegion2;
        return activeRegion2;
    }

    static boolean IsWindingInside(GLUtessellatorImpl gLUtessellatorImpl, int n) {
        switch (gLUtessellatorImpl.windingRule) {
            case 100130: {
                return (n & 1) != 0;
            }
            case 100131: {
                return n != 0;
            }
            case 100132: {
                return n > 0;
            }
            case 100133: {
                return n < 0;
            }
            case 100134: {
                return n >= 2 || n <= -2;
            }
        }
        throw new InternalError();
    }

    static void ComputeWinding(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        activeRegion.windingNumber = Sweep.RegionAbove((ActiveRegion)activeRegion).windingNumber + activeRegion.eUp.winding;
        activeRegion.inside = Sweep.IsWindingInside(gLUtessellatorImpl, activeRegion.windingNumber);
    }

    static void FinishRegion(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        GLUface gLUface = gLUhalfEdge.Lface;
        gLUface.inside = activeRegion.inside;
        gLUface.anEdge = gLUhalfEdge;
        Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion);
    }

    static GLUhalfEdge FinishLeftRegions(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, ActiveRegion activeRegion2) {
        ActiveRegion activeRegion3 = activeRegion;
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        while (activeRegion3 != activeRegion2) {
            activeRegion3.fixUpperEdge = false;
            ActiveRegion activeRegion4 = Sweep.RegionBelow(activeRegion3);
            GLUhalfEdge gLUhalfEdge2 = activeRegion4.eUp;
            if (gLUhalfEdge2.Org != gLUhalfEdge.Org) {
                if (!activeRegion4.fixUpperEdge) {
                    Sweep.FinishRegion(gLUtessellatorImpl, activeRegion3);
                    break;
                }
                gLUhalfEdge2 = Mesh.__gl_meshConnect(gLUhalfEdge.Onext.Sym, gLUhalfEdge2.Sym);
                if (gLUhalfEdge2 == null) {
                    throw new RuntimeException();
                }
                if (!Sweep.FixUpperEdge(activeRegion4, gLUhalfEdge2)) {
                    throw new RuntimeException();
                }
            }
            if (gLUhalfEdge.Onext != gLUhalfEdge2) {
                if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge2)) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge2)) {
                    throw new RuntimeException();
                }
            }
            Sweep.FinishRegion(gLUtessellatorImpl, activeRegion3);
            gLUhalfEdge = activeRegion4.eUp;
            activeRegion3 = activeRegion4;
        }
        return gLUhalfEdge;
    }

    static void AddRightEdges(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2, GLUhalfEdge gLUhalfEdge3, boolean bl) {
        ActiveRegion activeRegion2;
        boolean bl2 = true;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge;
        do {
            assert (Geom.VertLeq(gLUhalfEdge4.Org, gLUhalfEdge4.Sym.Org));
            Sweep.AddRegionBelow(gLUtessellatorImpl, activeRegion, gLUhalfEdge4.Sym);
        } while ((gLUhalfEdge4 = gLUhalfEdge4.Onext) != gLUhalfEdge2);
        if (gLUhalfEdge3 == null) {
            gLUhalfEdge3 = Sweep.RegionBelow((ActiveRegion)activeRegion).eUp.Sym.Onext;
        }
        ActiveRegion activeRegion3 = activeRegion;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge3;
        while (true) {
            activeRegion2 = Sweep.RegionBelow(activeRegion3);
            gLUhalfEdge4 = activeRegion2.eUp.Sym;
            if (gLUhalfEdge4.Org != gLUhalfEdge5.Org) break;
            if (gLUhalfEdge4.Onext != gLUhalfEdge5) {
                if (!Mesh.__gl_meshSplice(gLUhalfEdge4.Sym.Lnext, gLUhalfEdge4)) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(gLUhalfEdge5.Sym.Lnext, gLUhalfEdge4)) {
                    throw new RuntimeException();
                }
            }
            activeRegion2.windingNumber = activeRegion3.windingNumber - gLUhalfEdge4.winding;
            activeRegion2.inside = Sweep.IsWindingInside(gLUtessellatorImpl, activeRegion2.windingNumber);
            activeRegion3.dirty = true;
            if (!bl2 && Sweep.CheckForRightSplice(gLUtessellatorImpl, activeRegion3)) {
                Sweep.AddWinding(gLUhalfEdge4, gLUhalfEdge5);
                Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion3);
                if (!Mesh.__gl_meshDelete(gLUhalfEdge5)) {
                    throw new RuntimeException();
                }
            }
            bl2 = false;
            activeRegion3 = activeRegion2;
            gLUhalfEdge5 = gLUhalfEdge4;
        }
        activeRegion3.dirty = true;
        assert (activeRegion3.windingNumber - gLUhalfEdge4.winding == activeRegion2.windingNumber);
        if (bl) {
            Sweep.WalkDirtyRegions(gLUtessellatorImpl, activeRegion3);
        }
    }

    static void CallCombine(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex, Object[] objectArray, float[] fArray, boolean bl) {
        double[] dArray = new double[]{gLUvertex.coords[0], gLUvertex.coords[1], gLUvertex.coords[2]};
        Object[] objectArray2 = new Object[1];
        gLUtessellatorImpl.callCombineOrCombineData(dArray, objectArray, fArray, objectArray2);
        gLUvertex.data = objectArray2[0];
        if (gLUvertex.data == null) {
            if (!bl) {
                gLUvertex.data = objectArray[0];
            } else if (!gLUtessellatorImpl.fatalError) {
                gLUtessellatorImpl.callErrorOrErrorData(100156);
                gLUtessellatorImpl.fatalError = true;
            }
        }
    }

    static void SpliceMergeVertices(GLUtessellatorImpl gLUtessellatorImpl, GLUhalfEdge gLUhalfEdge, GLUhalfEdge gLUhalfEdge2) {
        Object[] objectArray = new Object[4];
        float[] fArray = new float[]{0.5f, 0.5f, 0.0f, 0.0f};
        objectArray[0] = gLUhalfEdge.Org.data;
        objectArray[1] = gLUhalfEdge2.Org.data;
        Sweep.CallCombine(gLUtessellatorImpl, gLUhalfEdge.Org, objectArray, fArray, false);
        if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge2)) {
            throw new RuntimeException();
        }
    }

    static void VertexWeights(GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, float[] fArray) {
        double d = Geom.VertL1dist(gLUvertex2, gLUvertex);
        double d2 = Geom.VertL1dist(gLUvertex3, gLUvertex);
        fArray[0] = (float)(0.5 * d2 / (d + d2));
        fArray[1] = (float)(0.5 * d / (d + d2));
        gLUvertex.coords[0] = gLUvertex.coords[0] + ((double)fArray[0] * gLUvertex2.coords[0] + (double)fArray[1] * gLUvertex3.coords[0]);
        gLUvertex.coords[1] = gLUvertex.coords[1] + ((double)fArray[0] * gLUvertex2.coords[1] + (double)fArray[1] * gLUvertex3.coords[1]);
        gLUvertex.coords[2] = gLUvertex.coords[2] + ((double)fArray[0] * gLUvertex2.coords[2] + (double)fArray[1] * gLUvertex3.coords[2]);
    }

    static void GetIntersectData(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex, GLUvertex gLUvertex2, GLUvertex gLUvertex3, GLUvertex gLUvertex4, GLUvertex gLUvertex5) {
        Object[] objectArray = new Object[4];
        float[] fArray = new float[4];
        float[] fArray2 = new float[2];
        float[] fArray3 = new float[2];
        objectArray[0] = gLUvertex2.data;
        objectArray[1] = gLUvertex3.data;
        objectArray[2] = gLUvertex4.data;
        objectArray[3] = gLUvertex5.data;
        gLUvertex.coords[2] = 0.0;
        gLUvertex.coords[1] = 0.0;
        gLUvertex.coords[0] = 0.0;
        Sweep.VertexWeights(gLUvertex, gLUvertex2, gLUvertex3, fArray2);
        Sweep.VertexWeights(gLUvertex, gLUvertex4, gLUvertex5, fArray3);
        System.arraycopy(fArray2, 0, fArray, 0, 2);
        System.arraycopy(fArray3, 0, fArray, 2, 2);
        Sweep.CallCombine(gLUtessellatorImpl, gLUvertex, objectArray, fArray, true);
    }

    static boolean CheckForRightSplice(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
        if (Geom.VertLeq(gLUhalfEdge.Org, gLUhalfEdge2.Org)) {
            if (Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org, gLUhalfEdge2.Org) > 0.0) {
                return false;
            }
            if (!Geom.VertEq(gLUhalfEdge.Org, gLUhalfEdge2.Org)) {
                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge2.Sym.Lnext)) {
                    throw new RuntimeException();
                }
                activeRegion2.dirty = true;
                activeRegion.dirty = true;
            } else if (gLUhalfEdge.Org != gLUhalfEdge2.Org) {
                gLUtessellatorImpl.pq.pqDelete(gLUhalfEdge.Org.pqHandle);
                Sweep.SpliceMergeVertices(gLUtessellatorImpl, gLUhalfEdge2.Sym.Lnext, gLUhalfEdge);
            }
        } else {
            if (Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org, gLUhalfEdge.Org) < 0.0) {
                return false;
            }
            activeRegion.dirty = true;
            Sweep.RegionAbove((ActiveRegion)activeRegion).dirty = true;
            if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                throw new RuntimeException();
            }
            if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge)) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    static boolean CheckForLeftSplice(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
        assert (!Geom.VertEq(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org));
        if (Geom.VertLeq(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org)) {
            if (Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUhalfEdge2.Sym.Org, gLUhalfEdge.Org) < 0.0) {
                return false;
            }
            activeRegion.dirty = true;
            Sweep.RegionAbove((ActiveRegion)activeRegion).dirty = true;
            GLUhalfEdge gLUhalfEdge3 = Mesh.__gl_meshSplitEdge(gLUhalfEdge);
            if (gLUhalfEdge3 == null) {
                throw new RuntimeException();
            }
            if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym, gLUhalfEdge3)) {
                throw new RuntimeException();
            }
            gLUhalfEdge3.Lface.inside = activeRegion.inside;
        } else {
            if (Geom.EdgeSign(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Sym.Org, gLUhalfEdge2.Org) > 0.0) {
                return false;
            }
            activeRegion2.dirty = true;
            activeRegion.dirty = true;
            GLUhalfEdge gLUhalfEdge4 = Mesh.__gl_meshSplitEdge(gLUhalfEdge2);
            if (gLUhalfEdge4 == null) {
                throw new RuntimeException();
            }
            if (!Mesh.__gl_meshSplice(gLUhalfEdge.Lnext, gLUhalfEdge2.Sym)) {
                throw new RuntimeException();
            }
            gLUhalfEdge4.Sym.Lface.inside = activeRegion.inside;
        }
        return true;
    }

    static boolean CheckForIntersect(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        GLUvertex gLUvertex;
        double d;
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
        GLUvertex gLUvertex2 = gLUhalfEdge.Org;
        GLUvertex gLUvertex3 = gLUhalfEdge2.Org;
        GLUvertex gLUvertex4 = gLUhalfEdge.Sym.Org;
        GLUvertex gLUvertex5 = gLUhalfEdge2.Sym.Org;
        GLUvertex gLUvertex6 = new GLUvertex();
        assert (!Geom.VertEq(gLUvertex5, gLUvertex4));
        assert (Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl.event, gLUvertex2) <= 0.0);
        assert (Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl.event, gLUvertex3) >= 0.0);
        assert (gLUvertex2 != gLUtessellatorImpl.event && gLUvertex3 != gLUtessellatorImpl.event);
        assert (!activeRegion.fixUpperEdge && !activeRegion2.fixUpperEdge);
        if (gLUvertex2 == gLUvertex3) {
            return false;
        }
        double d2 = Math.min(gLUvertex2.t, gLUvertex4.t);
        if (d2 > (d = Math.max(gLUvertex3.t, gLUvertex5.t))) {
            return false;
        }
        if (Geom.VertLeq(gLUvertex2, gLUvertex3) ? Geom.EdgeSign(gLUvertex5, gLUvertex2, gLUvertex3) > 0.0 : Geom.EdgeSign(gLUvertex4, gLUvertex3, gLUvertex2) < 0.0) {
            return false;
        }
        Sweep.DebugEvent(gLUtessellatorImpl);
        Geom.EdgeIntersect(gLUvertex4, gLUvertex2, gLUvertex5, gLUvertex3, gLUvertex6);
        assert (Math.min(gLUvertex2.t, gLUvertex4.t) <= gLUvertex6.t);
        assert (gLUvertex6.t <= Math.max(gLUvertex3.t, gLUvertex5.t));
        assert (Math.min(gLUvertex5.s, gLUvertex4.s) <= gLUvertex6.s);
        assert (gLUvertex6.s <= Math.max(gLUvertex3.s, gLUvertex2.s));
        if (Geom.VertLeq(gLUvertex6, gLUtessellatorImpl.event)) {
            gLUvertex6.s = gLUtessellatorImpl.event.s;
            gLUvertex6.t = gLUtessellatorImpl.event.t;
        }
        GLUvertex gLUvertex7 = gLUvertex = Geom.VertLeq(gLUvertex2, gLUvertex3) ? gLUvertex2 : gLUvertex3;
        if (Geom.VertLeq(gLUvertex, gLUvertex6)) {
            gLUvertex6.s = gLUvertex.s;
            gLUvertex6.t = gLUvertex.t;
        }
        if (Geom.VertEq(gLUvertex6, gLUvertex2) || Geom.VertEq(gLUvertex6, gLUvertex3)) {
            Sweep.CheckForRightSplice(gLUtessellatorImpl, activeRegion);
            return false;
        }
        if (!Geom.VertEq(gLUvertex4, gLUtessellatorImpl.event) && Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl.event, gLUvertex6) >= 0.0 || !Geom.VertEq(gLUvertex5, gLUtessellatorImpl.event) && Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl.event, gLUvertex6) <= 0.0) {
            if (gLUvertex5 == gLUtessellatorImpl.event) {
                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym, gLUhalfEdge)) {
                    throw new RuntimeException();
                }
                if ((activeRegion = Sweep.TopLeftRegion(activeRegion)) == null) {
                    throw new RuntimeException();
                }
                gLUhalfEdge = Sweep.RegionBelow((ActiveRegion)activeRegion).eUp;
                Sweep.FinishLeftRegions(gLUtessellatorImpl, Sweep.RegionBelow(activeRegion), activeRegion2);
                Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge.Sym.Lnext, gLUhalfEdge, gLUhalfEdge, true);
                return true;
            }
            if (gLUvertex4 == gLUtessellatorImpl.event) {
                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                    throw new RuntimeException();
                }
                if (!Mesh.__gl_meshSplice(gLUhalfEdge.Lnext, gLUhalfEdge2.Sym.Lnext)) {
                    throw new RuntimeException();
                }
                activeRegion2 = activeRegion;
                activeRegion = Sweep.TopRightRegion(activeRegion);
                GLUhalfEdge gLUhalfEdge3 = Sweep.RegionBelow((ActiveRegion)activeRegion).eUp.Sym.Onext;
                activeRegion2.eUp = gLUhalfEdge2.Sym.Lnext;
                gLUhalfEdge2 = Sweep.FinishLeftRegions(gLUtessellatorImpl, activeRegion2, null);
                Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge2.Onext, gLUhalfEdge.Sym.Onext, gLUhalfEdge3, true);
                return true;
            }
            if (Geom.EdgeSign(gLUvertex4, gLUtessellatorImpl.event, gLUvertex6) >= 0.0) {
                activeRegion.dirty = true;
                Sweep.RegionAbove((ActiveRegion)activeRegion).dirty = true;
                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
                    throw new RuntimeException();
                }
                gLUhalfEdge.Org.s = gLUtessellatorImpl.event.s;
                gLUhalfEdge.Org.t = gLUtessellatorImpl.event.t;
            }
            if (Geom.EdgeSign(gLUvertex5, gLUtessellatorImpl.event, gLUvertex6) <= 0.0) {
                activeRegion2.dirty = true;
                activeRegion.dirty = true;
                if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                    throw new RuntimeException();
                }
                gLUhalfEdge2.Org.s = gLUtessellatorImpl.event.s;
                gLUhalfEdge2.Org.t = gLUtessellatorImpl.event.t;
            }
            return false;
        }
        if (Mesh.__gl_meshSplitEdge(gLUhalfEdge.Sym) == null) {
            throw new RuntimeException();
        }
        if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
            throw new RuntimeException();
        }
        if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge)) {
            throw new RuntimeException();
        }
        gLUhalfEdge.Org.s = gLUvertex6.s;
        gLUhalfEdge.Org.t = gLUvertex6.t;
        gLUhalfEdge.Org.pqHandle = gLUtessellatorImpl.pq.pqInsert(gLUhalfEdge.Org);
        if ((long)gLUhalfEdge.Org.pqHandle == Long.MAX_VALUE) {
            gLUtessellatorImpl.pq.pqDeletePriorityQ();
            gLUtessellatorImpl.pq = null;
            throw new RuntimeException();
        }
        Sweep.GetIntersectData(gLUtessellatorImpl, gLUhalfEdge.Org, gLUvertex2, gLUvertex4, gLUvertex3, gLUvertex5);
        activeRegion2.dirty = true;
        activeRegion.dirty = true;
        Sweep.RegionAbove((ActiveRegion)activeRegion).dirty = true;
        return false;
    }

    static void WalkDirtyRegions(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion) {
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        while (true) {
            if (activeRegion2.dirty) {
                activeRegion = activeRegion2;
                activeRegion2 = Sweep.RegionBelow(activeRegion2);
                continue;
            }
            if (!activeRegion.dirty) {
                activeRegion2 = activeRegion;
                if ((activeRegion = Sweep.RegionAbove(activeRegion)) == null || !activeRegion.dirty) {
                    return;
                }
            }
            activeRegion.dirty = false;
            GLUhalfEdge gLUhalfEdge = activeRegion.eUp;
            GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
            if (gLUhalfEdge.Sym.Org != gLUhalfEdge2.Sym.Org && Sweep.CheckForLeftSplice(gLUtessellatorImpl, activeRegion)) {
                if (activeRegion2.fixUpperEdge) {
                    Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion2);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                        throw new RuntimeException();
                    }
                    activeRegion2 = Sweep.RegionBelow(activeRegion);
                    gLUhalfEdge2 = activeRegion2.eUp;
                } else if (activeRegion.fixUpperEdge) {
                    Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion);
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                        throw new RuntimeException();
                    }
                    activeRegion = Sweep.RegionAbove(activeRegion2);
                    gLUhalfEdge = activeRegion.eUp;
                }
            }
            if (gLUhalfEdge.Org != gLUhalfEdge2.Org) {
                if (!(gLUhalfEdge.Sym.Org == gLUhalfEdge2.Sym.Org || activeRegion.fixUpperEdge || activeRegion2.fixUpperEdge || gLUhalfEdge.Sym.Org != gLUtessellatorImpl.event && gLUhalfEdge2.Sym.Org != gLUtessellatorImpl.event)) {
                    if (Sweep.CheckForIntersect(gLUtessellatorImpl, activeRegion)) {
                        return;
                    }
                } else {
                    Sweep.CheckForRightSplice(gLUtessellatorImpl, activeRegion);
                }
            }
            if (gLUhalfEdge.Org != gLUhalfEdge2.Org || gLUhalfEdge.Sym.Org != gLUhalfEdge2.Sym.Org) continue;
            Sweep.AddWinding(gLUhalfEdge2, gLUhalfEdge);
            Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion);
            if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                throw new RuntimeException();
            }
            activeRegion = Sweep.RegionAbove(activeRegion2);
        }
    }

    static void ConnectRightVertex(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUhalfEdge gLUhalfEdge) {
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.Onext;
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge3 = activeRegion.eUp;
        GLUhalfEdge gLUhalfEdge4 = activeRegion2.eUp;
        boolean bl = false;
        if (gLUhalfEdge3.Sym.Org != gLUhalfEdge4.Sym.Org) {
            Sweep.CheckForIntersect(gLUtessellatorImpl, activeRegion);
        }
        if (Geom.VertEq(gLUhalfEdge3.Org, gLUtessellatorImpl.event)) {
            if (!Mesh.__gl_meshSplice(gLUhalfEdge2.Sym.Lnext, gLUhalfEdge3)) {
                throw new RuntimeException();
            }
            if ((activeRegion = Sweep.TopLeftRegion(activeRegion)) == null) {
                throw new RuntimeException();
            }
            gLUhalfEdge2 = Sweep.RegionBelow((ActiveRegion)activeRegion).eUp;
            Sweep.FinishLeftRegions(gLUtessellatorImpl, Sweep.RegionBelow(activeRegion), activeRegion2);
            bl = true;
        }
        if (Geom.VertEq(gLUhalfEdge4.Org, gLUtessellatorImpl.event)) {
            if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge4.Sym.Lnext)) {
                throw new RuntimeException();
            }
            gLUhalfEdge = Sweep.FinishLeftRegions(gLUtessellatorImpl, activeRegion2, null);
            bl = true;
        }
        if (bl) {
            Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge.Onext, gLUhalfEdge2, gLUhalfEdge2, true);
            return;
        }
        GLUhalfEdge gLUhalfEdge5 = Geom.VertLeq(gLUhalfEdge4.Org, gLUhalfEdge3.Org) ? gLUhalfEdge4.Sym.Lnext : gLUhalfEdge3;
        if ((gLUhalfEdge5 = Mesh.__gl_meshConnect(gLUhalfEdge.Onext.Sym, gLUhalfEdge5)) == null) {
            throw new RuntimeException();
        }
        Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge5, gLUhalfEdge5.Onext, gLUhalfEdge5.Onext, false);
        gLUhalfEdge5.Sym.activeRegion.fixUpperEdge = true;
        Sweep.WalkDirtyRegions(gLUtessellatorImpl, activeRegion);
    }

    static void ConnectLeftDegenerate(GLUtessellatorImpl gLUtessellatorImpl, ActiveRegion activeRegion, GLUvertex gLUvertex) {
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2 = activeRegion.eUp;
        if (Geom.VertEq(gLUhalfEdge2.Org, gLUvertex)) {
            assert (false);
            Sweep.SpliceMergeVertices(gLUtessellatorImpl, gLUhalfEdge2, gLUvertex.anEdge);
            return;
        }
        if (!Geom.VertEq(gLUhalfEdge2.Sym.Org, gLUvertex)) {
            if (Mesh.__gl_meshSplitEdge(gLUhalfEdge2.Sym) == null) {
                throw new RuntimeException();
            }
            if (activeRegion.fixUpperEdge) {
                if (!Mesh.__gl_meshDelete(gLUhalfEdge2.Onext)) {
                    throw new RuntimeException();
                }
                activeRegion.fixUpperEdge = false;
            }
            if (!Mesh.__gl_meshSplice(gLUvertex.anEdge, gLUhalfEdge2)) {
                throw new RuntimeException();
            }
            Sweep.SweepEvent(gLUtessellatorImpl, gLUvertex);
            return;
        }
        assert (false);
        activeRegion = Sweep.TopRightRegion(activeRegion);
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge3 = activeRegion2.eUp.Sym;
        GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge = gLUhalfEdge3.Onext;
        if (activeRegion2.fixUpperEdge) {
            assert (gLUhalfEdge4 != gLUhalfEdge3);
            Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion2);
            if (!Mesh.__gl_meshDelete(gLUhalfEdge3)) {
                throw new RuntimeException();
            }
            gLUhalfEdge3 = gLUhalfEdge4.Sym.Lnext;
        }
        if (!Mesh.__gl_meshSplice(gLUvertex.anEdge, gLUhalfEdge3)) {
            throw new RuntimeException();
        }
        if (!Geom.EdgeGoesLeft(gLUhalfEdge4)) {
            gLUhalfEdge4 = null;
        }
        Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge3.Onext, gLUhalfEdge, gLUhalfEdge4, true);
    }

    static void ConnectLeftVertex(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex) {
        ActiveRegion activeRegion;
        ActiveRegion activeRegion2 = new ActiveRegion();
        activeRegion2.eUp = gLUvertex.anEdge.Sym;
        ActiveRegion activeRegion3 = (ActiveRegion)Dict.dictKey(Dict.dictSearch(gLUtessellatorImpl.dict, activeRegion2));
        ActiveRegion activeRegion4 = Sweep.RegionBelow(activeRegion3);
        GLUhalfEdge gLUhalfEdge = activeRegion3.eUp;
        GLUhalfEdge gLUhalfEdge2 = activeRegion4.eUp;
        if (Geom.EdgeSign(gLUhalfEdge.Sym.Org, gLUvertex, gLUhalfEdge.Org) == 0.0) {
            Sweep.ConnectLeftDegenerate(gLUtessellatorImpl, activeRegion3, gLUvertex);
            return;
        }
        ActiveRegion activeRegion5 = activeRegion = Geom.VertLeq(gLUhalfEdge2.Sym.Org, gLUhalfEdge.Sym.Org) ? activeRegion3 : activeRegion4;
        if (activeRegion3.inside || activeRegion.fixUpperEdge) {
            GLUhalfEdge gLUhalfEdge3;
            if (activeRegion == activeRegion3) {
                gLUhalfEdge3 = Mesh.__gl_meshConnect(gLUvertex.anEdge.Sym, gLUhalfEdge.Lnext);
                if (gLUhalfEdge3 == null) {
                    throw new RuntimeException();
                }
            } else {
                GLUhalfEdge gLUhalfEdge4 = Mesh.__gl_meshConnect(gLUhalfEdge2.Sym.Onext.Sym, gLUvertex.anEdge);
                if (gLUhalfEdge4 == null) {
                    throw new RuntimeException();
                }
                gLUhalfEdge3 = gLUhalfEdge4.Sym;
            }
            if (activeRegion.fixUpperEdge) {
                if (!Sweep.FixUpperEdge(activeRegion, gLUhalfEdge3)) {
                    throw new RuntimeException();
                }
            } else {
                Sweep.ComputeWinding(gLUtessellatorImpl, Sweep.AddRegionBelow(gLUtessellatorImpl, activeRegion3, gLUhalfEdge3));
            }
            Sweep.SweepEvent(gLUtessellatorImpl, gLUvertex);
        } else {
            Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion3, gLUvertex.anEdge, gLUvertex.anEdge, null, true);
        }
    }

    static void SweepEvent(GLUtessellatorImpl gLUtessellatorImpl, GLUvertex gLUvertex) {
        gLUtessellatorImpl.event = gLUvertex;
        Sweep.DebugEvent(gLUtessellatorImpl);
        GLUhalfEdge gLUhalfEdge = gLUvertex.anEdge;
        while (gLUhalfEdge.activeRegion == null) {
            gLUhalfEdge = gLUhalfEdge.Onext;
            if (gLUhalfEdge != gLUvertex.anEdge) continue;
            Sweep.ConnectLeftVertex(gLUtessellatorImpl, gLUvertex);
            return;
        }
        ActiveRegion activeRegion = Sweep.TopLeftRegion(gLUhalfEdge.activeRegion);
        if (activeRegion == null) {
            throw new RuntimeException();
        }
        ActiveRegion activeRegion2 = Sweep.RegionBelow(activeRegion);
        GLUhalfEdge gLUhalfEdge2 = activeRegion2.eUp;
        GLUhalfEdge gLUhalfEdge3 = Sweep.FinishLeftRegions(gLUtessellatorImpl, activeRegion2, null);
        if (gLUhalfEdge3.Onext == gLUhalfEdge2) {
            Sweep.ConnectRightVertex(gLUtessellatorImpl, activeRegion, gLUhalfEdge3);
        } else {
            Sweep.AddRightEdges(gLUtessellatorImpl, activeRegion, gLUhalfEdge3.Onext, gLUhalfEdge2, gLUhalfEdge2, true);
        }
    }

    static void AddSentinel(GLUtessellatorImpl gLUtessellatorImpl, double d) {
        ActiveRegion activeRegion = new ActiveRegion();
        if (activeRegion == null) {
            throw new RuntimeException();
        }
        GLUhalfEdge gLUhalfEdge = Mesh.__gl_meshMakeEdge(gLUtessellatorImpl.mesh);
        if (gLUhalfEdge == null) {
            throw new RuntimeException();
        }
        gLUhalfEdge.Org.s = 4.0E150;
        gLUhalfEdge.Org.t = d;
        gLUhalfEdge.Sym.Org.s = -4.0E150;
        gLUhalfEdge.Sym.Org.t = d;
        gLUtessellatorImpl.event = gLUhalfEdge.Sym.Org;
        activeRegion.eUp = gLUhalfEdge;
        activeRegion.windingNumber = 0;
        activeRegion.inside = false;
        activeRegion.fixUpperEdge = false;
        activeRegion.sentinel = true;
        activeRegion.dirty = false;
        activeRegion.nodeUp = Dict.dictInsert(gLUtessellatorImpl.dict, activeRegion);
        if (activeRegion.nodeUp == null) {
            throw new RuntimeException();
        }
    }

    static void InitEdgeDict(final GLUtessellatorImpl gLUtessellatorImpl) {
        gLUtessellatorImpl.dict = Dict.dictNewDict(gLUtessellatorImpl, new Dict.DictLeq(){

            @Override
            public boolean leq(Object object, Object object2, Object object3) {
                return Sweep.EdgeLeq(gLUtessellatorImpl, (ActiveRegion)object2, (ActiveRegion)object3);
            }
        });
        if (gLUtessellatorImpl.dict == null) {
            throw new RuntimeException();
        }
        Sweep.AddSentinel(gLUtessellatorImpl, -4.0E150);
        Sweep.AddSentinel(gLUtessellatorImpl, 4.0E150);
    }

    static void DoneEdgeDict(GLUtessellatorImpl gLUtessellatorImpl) {
        ActiveRegion activeRegion;
        int n = 0;
        while ((activeRegion = (ActiveRegion)Dict.dictKey(Dict.dictMin(gLUtessellatorImpl.dict))) != null) {
            if (!activeRegion.sentinel) {
                assert (activeRegion.fixUpperEdge);
                assert (++n == 1);
            }
            assert (activeRegion.windingNumber == 0);
            Sweep.DeleteRegion(gLUtessellatorImpl, activeRegion);
        }
        Dict.dictDeleteDict(gLUtessellatorImpl.dict);
    }

    static void RemoveDegenerateEdges(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUhalfEdge gLUhalfEdge = gLUtessellatorImpl.mesh.eHead;
        GLUhalfEdge gLUhalfEdge2 = gLUhalfEdge.next;
        while (gLUhalfEdge2 != gLUhalfEdge) {
            GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge2.next;
            GLUhalfEdge gLUhalfEdge4 = gLUhalfEdge2.Lnext;
            if (Geom.VertEq(gLUhalfEdge2.Org, gLUhalfEdge2.Sym.Org) && gLUhalfEdge2.Lnext.Lnext != gLUhalfEdge2) {
                Sweep.SpliceMergeVertices(gLUtessellatorImpl, gLUhalfEdge4, gLUhalfEdge2);
                if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                    throw new RuntimeException();
                }
                gLUhalfEdge2 = gLUhalfEdge4;
                gLUhalfEdge4 = gLUhalfEdge2.Lnext;
            }
            if (gLUhalfEdge4.Lnext == gLUhalfEdge2) {
                if (gLUhalfEdge4 != gLUhalfEdge2) {
                    if (gLUhalfEdge4 == gLUhalfEdge3 || gLUhalfEdge4 == gLUhalfEdge3.Sym) {
                        gLUhalfEdge3 = gLUhalfEdge3.next;
                    }
                    if (!Mesh.__gl_meshDelete(gLUhalfEdge4)) {
                        throw new RuntimeException();
                    }
                }
                if (gLUhalfEdge2 == gLUhalfEdge3 || gLUhalfEdge2 == gLUhalfEdge3.Sym) {
                    gLUhalfEdge3 = gLUhalfEdge3.next;
                }
                if (!Mesh.__gl_meshDelete(gLUhalfEdge2)) {
                    throw new RuntimeException();
                }
            }
            gLUhalfEdge2 = gLUhalfEdge3;
        }
    }

    static boolean InitPriorityQ(GLUtessellatorImpl gLUtessellatorImpl) {
        gLUtessellatorImpl.pq = PriorityQ.pqNewPriorityQ(new PriorityQ.Leq(){

            @Override
            public boolean leq(Object object, Object object2) {
                return Geom.VertLeq((GLUvertex)object, (GLUvertex)object2);
            }
        });
        PriorityQ priorityQ = gLUtessellatorImpl.pq;
        if (priorityQ == null) {
            return false;
        }
        GLUvertex gLUvertex = gLUtessellatorImpl.mesh.vHead;
        GLUvertex gLUvertex2 = gLUvertex.next;
        while (gLUvertex2 != gLUvertex) {
            gLUvertex2.pqHandle = priorityQ.pqInsert(gLUvertex2);
            if ((long)gLUvertex2.pqHandle == Long.MAX_VALUE) break;
            gLUvertex2 = gLUvertex2.next;
        }
        if (gLUvertex2 != gLUvertex || !priorityQ.pqInit()) {
            gLUtessellatorImpl.pq.pqDeletePriorityQ();
            gLUtessellatorImpl.pq = null;
            return false;
        }
        return true;
    }

    static void DonePriorityQ(GLUtessellatorImpl gLUtessellatorImpl) {
        gLUtessellatorImpl.pq.pqDeletePriorityQ();
    }

    static boolean RemoveDegenerateFaces(GLUmesh gLUmesh) {
        GLUface gLUface = gLUmesh.fHead.next;
        while (gLUface != gLUmesh.fHead) {
            GLUface gLUface2 = gLUface.next;
            GLUhalfEdge gLUhalfEdge = gLUface.anEdge;
            assert (gLUhalfEdge.Lnext != gLUhalfEdge);
            if (gLUhalfEdge.Lnext.Lnext == gLUhalfEdge) {
                Sweep.AddWinding(gLUhalfEdge.Onext, gLUhalfEdge);
                if (!Mesh.__gl_meshDelete(gLUhalfEdge)) {
                    return false;
                }
            }
            gLUface = gLUface2;
        }
        return true;
    }

    public static boolean __gl_computeInterior(GLUtessellatorImpl gLUtessellatorImpl) {
        GLUvertex gLUvertex;
        gLUtessellatorImpl.fatalError = false;
        Sweep.RemoveDegenerateEdges(gLUtessellatorImpl);
        if (!Sweep.InitPriorityQ(gLUtessellatorImpl)) {
            return false;
        }
        Sweep.InitEdgeDict(gLUtessellatorImpl);
        while ((gLUvertex = (GLUvertex)gLUtessellatorImpl.pq.pqExtractMin()) != null) {
            GLUvertex gLUvertex2;
            while ((gLUvertex2 = (GLUvertex)gLUtessellatorImpl.pq.pqMinimum()) != null && Geom.VertEq(gLUvertex2, gLUvertex)) {
                gLUvertex2 = (GLUvertex)gLUtessellatorImpl.pq.pqExtractMin();
                Sweep.SpliceMergeVertices(gLUtessellatorImpl, gLUvertex.anEdge, gLUvertex2.anEdge);
            }
            Sweep.SweepEvent(gLUtessellatorImpl, gLUvertex);
        }
        gLUtessellatorImpl.event = ((ActiveRegion)Dict.dictKey((DictNode)Dict.dictMin((Dict)gLUtessellatorImpl.dict))).eUp.Org;
        Sweep.DebugEvent(gLUtessellatorImpl);
        Sweep.DoneEdgeDict(gLUtessellatorImpl);
        Sweep.DonePriorityQ(gLUtessellatorImpl);
        if (!Sweep.RemoveDegenerateFaces(gLUtessellatorImpl.mesh)) {
            return false;
        }
        Mesh.__gl_meshCheckMesh(gLUtessellatorImpl.mesh);
        return true;
    }
}

