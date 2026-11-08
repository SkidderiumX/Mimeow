/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import x.oc68aa547e4e;
import x.oceb7ed9a2d8;

public class ocae3bb6ecc0 {
    public final oceb7ed9a2d8 \u0214;
    public final int[] \u0463;
    public final List<oc68aa547e4e> \u0143 = new ArrayList<oc68aa547e4e>();
    public final List<ocae3bb6ecc0> \u039d = new ArrayList<ocae3bb6ecc0>();
    public final float \u03f0;
    public final float \u0521;
    public final float \u01be;

    public ocae3bb6ecc0(oceb7ed9a2d8 oceb7ed9a2d82, int[] nArray, float f, float f2, float f3) {
        if (nArray.length != (0x5F163A5E ^ 0x5F163B5E)) {
            throw new IllegalArgumentException("Font hash table must contain 256 supplied entries");
        }
        this.\u0214 = oceb7ed9a2d82;
        this.\u0463 = nArray;
        this.\u03f0 = f;
        this.\u0521 = f2;
        this.\u01be = f3;
    }
}

