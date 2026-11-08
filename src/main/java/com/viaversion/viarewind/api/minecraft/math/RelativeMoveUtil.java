/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.minecraft.math;

import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.EntityTracker1_9;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Vector;

@Deprecated
public class RelativeMoveUtil {
    public static Vector[] calculateRelativeMoves(UserConnection userConnection, int n, int n2, int n3, int n4) {
        Vector[] vectorArray;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)userConnection.getEntityTracker(Protocol1_9To1_8.class);
        Vector vector = entityTracker1_9.getEntityOffset(n);
        if (vector != null) {
            n2 += vector.blockX();
            n3 += vector.blockY();
            n4 += vector.blockZ();
        }
        if (n2 > Short.MAX_VALUE) {
            n10 = n2 - Short.MAX_VALUE;
            n2 = Short.MAX_VALUE;
        } else if (n2 < Short.MIN_VALUE) {
            n10 = n2 - Short.MIN_VALUE;
            n2 = Short.MIN_VALUE;
        } else {
            n10 = 0;
        }
        if (n3 > Short.MAX_VALUE) {
            n9 = n3 - Short.MAX_VALUE;
            n3 = Short.MAX_VALUE;
        } else if (n3 < Short.MIN_VALUE) {
            n9 = n3 - Short.MIN_VALUE;
            n3 = Short.MIN_VALUE;
        } else {
            n9 = 0;
        }
        if (n4 > Short.MAX_VALUE) {
            n8 = n4 - Short.MAX_VALUE;
            n4 = Short.MAX_VALUE;
        } else if (n4 < Short.MIN_VALUE) {
            n8 = n4 - Short.MIN_VALUE;
            n4 = Short.MIN_VALUE;
        } else {
            n8 = 0;
        }
        if (n2 > 16256 || n2 < -16384 || n3 > 16256 || n3 < -16384 || n4 > 16256 || n4 < -16384) {
            byte by = (byte)(n2 / 256);
            byte by2 = (byte)Math.round((float)(n2 - by * 128) / 128.0f);
            byte by3 = (byte)(n3 / 256);
            byte by4 = (byte)Math.round((float)(n3 - by3 * 128) / 128.0f);
            byte by5 = (byte)(n4 / 256);
            byte by6 = (byte)Math.round((float)(n4 - by5 * 128) / 128.0f);
            n7 = by + by2;
            n6 = by3 + by4;
            n5 = by5 + by6;
            vectorArray = new Vector[]{new Vector(by, by3, by5), new Vector(by2, by4, by6)};
        } else {
            n7 = Math.round((float)n2 / 128.0f);
            n6 = Math.round((float)n3 / 128.0f);
            n5 = Math.round((float)n4 / 128.0f);
            vectorArray = new Vector[]{new Vector(n7, n6, n5)};
        }
        n10 = n10 + n2 - n7 * 128;
        n9 = n9 + n3 - n6 * 128;
        n8 = n8 + n4 - n5 * 128;
        entityTracker1_9.setEntityOffset(n, new Vector(n10, n9, n8));
        return vectorArray;
    }
}

