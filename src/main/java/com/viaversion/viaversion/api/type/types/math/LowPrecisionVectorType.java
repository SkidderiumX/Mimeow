/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.Vector3d;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.MathUtil;
import io.netty.buffer.ByteBuf;

public class LowPrecisionVectorType
extends Type<Vector3d> {
    private static final double MAX_QUANTIZED_VALUE = 32766.0;
    private static final int SCALE_BITS = 2;
    private static final int SCALE_BITS_MASK = 3;
    private static final int CONTINUATION_FLAG = 4;
    private static final double ABS_MAX_VALUE = 1.7179869183E10;
    private static final double ABS_MIN_VALUE = 3.051944088384301E-5;

    public LowPrecisionVectorType() {
        super(Vector3d.class);
    }

    @Override
    public Vector3d read(ByteBuf byteBuf) {
        short s = Types.UNSIGNED_BYTE.read(byteBuf);
        if (s == 0) {
            return Vector3d.ZERO;
        }
        short s2 = Types.UNSIGNED_BYTE.read(byteBuf);
        long l = Types.UNSIGNED_INT.read(byteBuf);
        long l2 = l << 16 | (long)(s2 << 8) | (long)s;
        long l3 = s & 3;
        if ((s & 4) != 0) {
            l3 |= ((long)Types.VAR_INT.readPrimitive(byteBuf) & 0xFFFFFFFFL) << 2;
        }
        return new Vector3d(this.unpack(l2 >> 3) * (double)l3, this.unpack(l2 >> 18) * (double)l3, this.unpack(l2 >> 33) * (double)l3);
    }

    @Override
    public void write(ByteBuf byteBuf, Vector3d vector3d) {
        double d = this.sanitize(vector3d.x());
        double d2 = this.sanitize(vector3d.y());
        double d3 = this.sanitize(vector3d.z());
        double d4 = Math.max(Math.abs(d), Math.max(Math.abs(d2), Math.abs(d3)));
        if (d4 < 3.051944088384301E-5) {
            byteBuf.writeByte(0);
            return;
        }
        long l = MathUtil.ceilLong(d4);
        boolean bl = (l & 3L) != l;
        long l2 = bl ? l & 3L | 4L : l;
        long l3 = l2 | this.pack(d / (double)l) << 3 | this.pack(d2 / (double)l) << 18 | this.pack(d3 / (double)l) << 33;
        byteBuf.writeByte((byte)l3);
        byteBuf.writeByte((byte)(l3 >> 8));
        byteBuf.writeInt((int)(l3 >> 16));
        if (bl) {
            Types.VAR_INT.writePrimitive(byteBuf, (int)(l >> 2));
        }
    }

    private double sanitize(double d) {
        return Double.isNaN(d) ? 0.0 : MathUtil.clamp(d, -1.7179869183E10, 1.7179869183E10);
    }

    private long pack(double d) {
        double d2 = d * 0.5 + 0.5;
        return Math.round(d2 * 32766.0);
    }

    private double unpack(long l) {
        double d = Math.min((double)(l & 0x7FFFL), 32766.0);
        return d * 2.0 / 32766.0 - 1.0;
    }
}

