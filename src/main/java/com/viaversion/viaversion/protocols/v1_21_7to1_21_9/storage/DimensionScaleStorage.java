/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.HashMap;
import java.util.Map;

public class DimensionScaleStorage
implements StorableObject {
    private final Map<Integer, Double> dimensionScales = new HashMap<Integer, Double>(4);

    public double getScale(int n) {
        return this.dimensionScales.getOrDefault(n, 1.0);
    }

    public void setScale(int n, double d) {
        this.dimensionScales.put(n, d);
    }
}

