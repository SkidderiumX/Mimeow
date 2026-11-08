/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallback;
import org.lwjgl.util.glu.GLUtessellatorCallbackAdapter;
import org.lwjgl.util.glu.tessellation.CachedVertex;
import org.lwjgl.util.glu.tessellation.Dict;
import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.GLUvertex;
import org.lwjgl.util.glu.tessellation.Mesh;
import org.lwjgl.util.glu.tessellation.Normal;
import org.lwjgl.util.glu.tessellation.PriorityQ;
import org.lwjgl.util.glu.tessellation.Render;
import org.lwjgl.util.glu.tessellation.Sweep;
import org.lwjgl.util.glu.tessellation.TessMono;

public class GLUtessellatorImpl
implements GLUtessellator {
    public static final int TESS_MAX_CACHE = 100;
    private int state = 0;
    private GLUhalfEdge lastEdge;
    GLUmesh mesh;
    double[] normal = new double[3];
    double[] sUnit = new double[3];
    double[] tUnit = new double[3];
    private double relTolerance;
    int windingRule;
    boolean fatalError;
    Dict dict;
    PriorityQ pq;
    GLUvertex event;
    boolean flagBoundary;
    boolean boundaryOnly;
    GLUface lonelyTriList;
    private boolean flushCacheOnNextVertex;
    int cacheCount;
    CachedVertex[] cache = new CachedVertex[100];
    private Object polygonData;
    private GLUtessellatorCallback callBegin;
    private GLUtessellatorCallback callEdgeFlag;
    private GLUtessellatorCallback callVertex;
    private GLUtessellatorCallback callEnd;
    private GLUtessellatorCallback callError;
    private GLUtessellatorCallback callCombine;
    private GLUtessellatorCallback callBeginData;
    private GLUtessellatorCallback callEdgeFlagData;
    private GLUtessellatorCallback callVertexData;
    private GLUtessellatorCallback callEndData;
    private GLUtessellatorCallback callErrorData;
    private GLUtessellatorCallback callCombineData;
    private static final double GLU_TESS_DEFAULT_TOLERANCE = 0.0;
    private static GLUtessellatorCallback NULL_CB = new GLUtessellatorCallbackAdapter();

    public GLUtessellatorImpl() {
        this.normal[0] = 0.0;
        this.normal[1] = 0.0;
        this.normal[2] = 0.0;
        this.relTolerance = 0.0;
        this.windingRule = 100130;
        this.flagBoundary = false;
        this.boundaryOnly = false;
        this.callBegin = NULL_CB;
        this.callEdgeFlag = NULL_CB;
        this.callVertex = NULL_CB;
        this.callEnd = NULL_CB;
        this.callError = NULL_CB;
        this.callCombine = NULL_CB;
        this.callBeginData = NULL_CB;
        this.callEdgeFlagData = NULL_CB;
        this.callVertexData = NULL_CB;
        this.callEndData = NULL_CB;
        this.callErrorData = NULL_CB;
        this.callCombineData = NULL_CB;
        this.polygonData = null;
        for (int i = 0; i < this.cache.length; ++i) {
            this.cache[i] = new CachedVertex();
        }
    }

    public static GLUtessellator gluNewTess() {
        return new GLUtessellatorImpl();
    }

    private void makeDormant() {
        if (this.mesh != null) {
            Mesh.__gl_meshDeleteMesh(this.mesh);
        }
        this.state = 0;
        this.lastEdge = null;
        this.mesh = null;
    }

    private void requireState(int n) {
        if (this.state != n) {
            this.gotoState(n);
        }
    }

    private void gotoState(int n) {
        while (this.state != n) {
            if (this.state < n) {
                if (this.state == 0) {
                    this.callErrorOrErrorData(100151);
                    this.gluTessBeginPolygon(null);
                    continue;
                }
                if (this.state != 1) continue;
                this.callErrorOrErrorData(100152);
                this.gluTessBeginContour();
                continue;
            }
            if (this.state == 2) {
                this.callErrorOrErrorData(100154);
                this.gluTessEndContour();
                continue;
            }
            if (this.state != 1) continue;
            this.callErrorOrErrorData(100153);
            this.makeDormant();
        }
    }

    @Override
    public void gluDeleteTess() {
        this.requireState(0);
    }

    @Override
    public void gluTessProperty(int n, double d) {
        switch (n) {
            case 100142: {
                if (d < 0.0 || d > 1.0) break;
                this.relTolerance = d;
                return;
            }
            case 100140: {
                int n2 = (int)d;
                if ((double)n2 != d) break;
                switch (n2) {
                    case 100130: 
                    case 100131: 
                    case 100132: 
                    case 100133: 
                    case 100134: {
                        this.windingRule = n2;
                        return;
                    }
                }
            }
            case 100141: {
                this.boundaryOnly = d != 0.0;
                return;
            }
            default: {
                this.callErrorOrErrorData(100900);
                return;
            }
        }
        this.callErrorOrErrorData(100901);
    }

    @Override
    public void gluGetTessProperty(int n, double[] dArray, int n2) {
        switch (n) {
            case 100142: {
                assert (0.0 <= this.relTolerance && this.relTolerance <= 1.0);
                dArray[n2] = this.relTolerance;
                break;
            }
            case 100140: {
                assert (this.windingRule == 100130 || this.windingRule == 100131 || this.windingRule == 100132 || this.windingRule == 100133 || this.windingRule == 100134);
                dArray[n2] = this.windingRule;
                break;
            }
            case 100141: {
                assert (this.boundaryOnly || !this.boundaryOnly);
                dArray[n2] = this.boundaryOnly ? 1.0 : 0.0;
                break;
            }
            default: {
                dArray[n2] = 0.0;
                this.callErrorOrErrorData(100900);
            }
        }
    }

    @Override
    public void gluTessNormal(double d, double d2, double d3) {
        this.normal[0] = d;
        this.normal[1] = d2;
        this.normal[2] = d3;
    }

    @Override
    public void gluTessCallback(int n, GLUtessellatorCallback gLUtessellatorCallback) {
        switch (n) {
            case 100100: {
                this.callBegin = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100106: {
                this.callBeginData = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100104: {
                this.callEdgeFlag = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                this.flagBoundary = gLUtessellatorCallback != null;
                return;
            }
            case 100110: {
                this.callBegin = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                this.callEdgeFlagData = this.callBegin;
                this.flagBoundary = gLUtessellatorCallback != null;
                return;
            }
            case 100101: {
                this.callVertex = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100107: {
                this.callVertexData = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100102: {
                this.callEnd = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100108: {
                this.callEndData = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100103: {
                this.callError = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100109: {
                this.callErrorData = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100105: {
                this.callCombine = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
            case 100111: {
                this.callCombineData = gLUtessellatorCallback == null ? NULL_CB : gLUtessellatorCallback;
                return;
            }
        }
        this.callErrorOrErrorData(100900);
    }

    private boolean addVertex(double[] dArray, Object object) {
        GLUhalfEdge gLUhalfEdge = this.lastEdge;
        if (gLUhalfEdge == null) {
            gLUhalfEdge = Mesh.__gl_meshMakeEdge(this.mesh);
            if (gLUhalfEdge == null) {
                return false;
            }
            if (!Mesh.__gl_meshSplice(gLUhalfEdge, gLUhalfEdge.Sym)) {
                return false;
            }
        } else {
            if (Mesh.__gl_meshSplitEdge(gLUhalfEdge) == null) {
                return false;
            }
            gLUhalfEdge = gLUhalfEdge.Lnext;
        }
        gLUhalfEdge.Org.data = object;
        gLUhalfEdge.Org.coords[0] = dArray[0];
        gLUhalfEdge.Org.coords[1] = dArray[1];
        gLUhalfEdge.Org.coords[2] = dArray[2];
        gLUhalfEdge.winding = 1;
        gLUhalfEdge.Sym.winding = -1;
        this.lastEdge = gLUhalfEdge;
        return true;
    }

    private void cacheVertex(double[] dArray, Object object) {
        if (this.cache[this.cacheCount] == null) {
            this.cache[this.cacheCount] = new CachedVertex();
        }
        CachedVertex cachedVertex = this.cache[this.cacheCount];
        cachedVertex.data = object;
        cachedVertex.coords[0] = dArray[0];
        cachedVertex.coords[1] = dArray[1];
        cachedVertex.coords[2] = dArray[2];
        ++this.cacheCount;
    }

    private boolean flushCache() {
        CachedVertex[] cachedVertexArray = this.cache;
        this.mesh = Mesh.__gl_meshNewMesh();
        if (this.mesh == null) {
            return false;
        }
        for (int i = 0; i < this.cacheCount; ++i) {
            CachedVertex cachedVertex = cachedVertexArray[i];
            if (this.addVertex(cachedVertex.coords, cachedVertex.data)) continue;
            return false;
        }
        this.cacheCount = 0;
        this.flushCacheOnNextVertex = false;
        return true;
    }

    @Override
    public void gluTessVertex(double[] dArray, int n, Object object) {
        boolean bl = false;
        double[] dArray2 = new double[3];
        this.requireState(2);
        if (this.flushCacheOnNextVertex) {
            if (!this.flushCache()) {
                this.callErrorOrErrorData(100902);
                return;
            }
            this.lastEdge = null;
        }
        for (int i = 0; i < 3; ++i) {
            double d = dArray[i + n];
            if (d < -1.0E150) {
                d = -1.0E150;
                bl = true;
            }
            if (d > 1.0E150) {
                d = 1.0E150;
                bl = true;
            }
            dArray2[i] = d;
        }
        if (bl) {
            this.callErrorOrErrorData(100155);
        }
        if (this.mesh == null) {
            if (this.cacheCount < 100) {
                this.cacheVertex(dArray2, object);
                return;
            }
            if (!this.flushCache()) {
                this.callErrorOrErrorData(100902);
                return;
            }
        }
        if (!this.addVertex(dArray2, object)) {
            this.callErrorOrErrorData(100902);
        }
    }

    @Override
    public void gluTessBeginPolygon(Object object) {
        this.requireState(0);
        this.state = 1;
        this.cacheCount = 0;
        this.flushCacheOnNextVertex = false;
        this.mesh = null;
        this.polygonData = object;
    }

    @Override
    public void gluTessBeginContour() {
        this.requireState(1);
        this.state = 2;
        this.lastEdge = null;
        if (this.cacheCount > 0) {
            this.flushCacheOnNextVertex = true;
        }
    }

    @Override
    public void gluTessEndContour() {
        this.requireState(2);
        this.state = 1;
    }

    @Override
    public void gluTessEndPolygon() {
        try {
            this.requireState(1);
            this.state = 0;
            if (this.mesh == null) {
                if (!this.flagBoundary && Render.__gl_renderCache(this)) {
                    this.polygonData = null;
                    return;
                }
                if (!this.flushCache()) {
                    throw new RuntimeException();
                }
            }
            Normal.__gl_projectPolygon(this);
            if (!Sweep.__gl_computeInterior(this)) {
                throw new RuntimeException();
            }
            GLUmesh gLUmesh = this.mesh;
            if (!this.fatalError) {
                boolean bl = true;
                bl = this.boundaryOnly ? TessMono.__gl_meshSetWindingNumber(gLUmesh, 1, true) : TessMono.__gl_meshTessellateInterior(gLUmesh);
                if (!bl) {
                    throw new RuntimeException();
                }
                Mesh.__gl_meshCheckMesh(gLUmesh);
                if (this.callBegin != NULL_CB || this.callEnd != NULL_CB || this.callVertex != NULL_CB || this.callEdgeFlag != NULL_CB || this.callBeginData != NULL_CB || this.callEndData != NULL_CB || this.callVertexData != NULL_CB || this.callEdgeFlagData != NULL_CB) {
                    if (this.boundaryOnly) {
                        Render.__gl_renderBoundary(this, gLUmesh);
                    } else {
                        Render.__gl_renderMesh(this, gLUmesh);
                    }
                }
            }
            Mesh.__gl_meshDeleteMesh(gLUmesh);
            this.polygonData = null;
            gLUmesh = null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.callErrorOrErrorData(100902);
        }
    }

    @Override
    public void gluBeginPolygon() {
        this.gluTessBeginPolygon(null);
        this.gluTessBeginContour();
    }

    @Override
    public void gluNextContour(int n) {
        this.gluTessEndContour();
        this.gluTessBeginContour();
    }

    @Override
    public void gluEndPolygon() {
        this.gluTessEndContour();
        this.gluTessEndPolygon();
    }

    void callBeginOrBeginData(int n) {
        if (this.callBeginData != NULL_CB) {
            this.callBeginData.beginData(n, this.polygonData);
        } else {
            this.callBegin.begin(n);
        }
    }

    void callVertexOrVertexData(Object object) {
        if (this.callVertexData != NULL_CB) {
            this.callVertexData.vertexData(object, this.polygonData);
        } else {
            this.callVertex.vertex(object);
        }
    }

    void callEdgeFlagOrEdgeFlagData(boolean bl) {
        if (this.callEdgeFlagData != NULL_CB) {
            this.callEdgeFlagData.edgeFlagData(bl, this.polygonData);
        } else {
            this.callEdgeFlag.edgeFlag(bl);
        }
    }

    void callEndOrEndData() {
        if (this.callEndData != NULL_CB) {
            this.callEndData.endData(this.polygonData);
        } else {
            this.callEnd.end();
        }
    }

    void callCombineOrCombineData(double[] dArray, Object[] objectArray, float[] fArray, Object[] objectArray2) {
        if (this.callCombineData != NULL_CB) {
            this.callCombineData.combineData(dArray, objectArray, fArray, objectArray2, this.polygonData);
        } else {
            this.callCombine.combine(dArray, objectArray, fArray, objectArray2);
        }
    }

    void callErrorOrErrorData(int n) {
        if (this.callErrorData != NULL_CB) {
            this.callErrorData.errorData(n, this.polygonData);
        } else {
            this.callError.error(n);
        }
    }
}

