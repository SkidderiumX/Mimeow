/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.ActiveRegion;
import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUvertex;

public class GLUhalfEdge {
    public GLUhalfEdge next;
    public GLUhalfEdge Sym;
    public GLUhalfEdge Onext;
    public GLUhalfEdge Lnext;
    public GLUvertex Org;
    public GLUface Lface;
    public ActiveRegion activeRegion;
    public int winding;
    public boolean first;

    GLUhalfEdge(boolean bl) {
        this.first = bl;
    }
}

