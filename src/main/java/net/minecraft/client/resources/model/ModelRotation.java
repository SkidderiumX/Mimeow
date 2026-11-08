/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.model;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.vecmath.Matrix4f;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.optifine.compat.model.IModelPart;
import net.optifine.compat.model.IModelState;
import net.optifine.compat.model.ITransformation;
import net.optifine.compat.model.TRSRTransformation;
import org.lwjgl.util.vector.Vector3f;

public enum ModelRotation implements IModelState,
ITransformation
{
    X0_Y0(0, 0),
    X0_Y90(0, 90),
    X0_Y180(0, 180),
    X0_Y270(0, 270),
    X90_Y0(90, 0),
    X90_Y90(90, 90),
    X90_Y180(90, 180),
    X90_Y270(90, 270),
    X180_Y0(180, 0),
    X180_Y90(180, 90),
    X180_Y180(180, 180),
    X180_Y270(180, 270),
    X270_Y0(270, 0),
    X270_Y90(270, 90),
    X270_Y180(270, 180),
    X270_Y270(270, 270);

    private static final Map<Integer, ModelRotation> mapRotations;
    private final int combinedXY;
    private final org.lwjgl.util.vector.Matrix4f matrix4d;
    private final int quartersX;
    private final int quartersY;

    private static int combineXY(int n, int n2) {
        return n * 360 + n2;
    }

    private ModelRotation(int n2, int n3) {
        this.combinedXY = ModelRotation.combineXY(n2, n3);
        this.matrix4d = new org.lwjgl.util.vector.Matrix4f();
        org.lwjgl.util.vector.Matrix4f matrix4f = new org.lwjgl.util.vector.Matrix4f();
        matrix4f.setIdentity();
        org.lwjgl.util.vector.Matrix4f.rotate((float)(-n2) * ((float)Math.PI / 180), new Vector3f(1.0f, 0.0f, 0.0f), matrix4f, matrix4f);
        this.quartersX = MathHelper.abs_int(n2 / 90);
        org.lwjgl.util.vector.Matrix4f matrix4f2 = new org.lwjgl.util.vector.Matrix4f();
        matrix4f2.setIdentity();
        org.lwjgl.util.vector.Matrix4f.rotate((float)(-n3) * ((float)Math.PI / 180), new Vector3f(0.0f, 1.0f, 0.0f), matrix4f2, matrix4f2);
        this.quartersY = MathHelper.abs_int(n3 / 90);
        org.lwjgl.util.vector.Matrix4f.mul(matrix4f2, matrix4f, this.matrix4d);
    }

    public org.lwjgl.util.vector.Matrix4f getMatrix4d() {
        return this.matrix4d;
    }

    public EnumFacing rotateFace(EnumFacing enumFacing) {
        int n;
        EnumFacing enumFacing2 = enumFacing;
        for (n = 0; n < this.quartersX; ++n) {
            enumFacing2 = enumFacing2.rotateAround(EnumFacing.Axis.X);
        }
        if (enumFacing2.getAxis() != EnumFacing.Axis.Y) {
            for (n = 0; n < this.quartersY; ++n) {
                enumFacing2 = enumFacing2.rotateAround(EnumFacing.Axis.Y);
            }
        }
        return enumFacing2;
    }

    public int rotateVertex(EnumFacing enumFacing, int n) {
        int n2 = n;
        if (enumFacing.getAxis() == EnumFacing.Axis.X) {
            n2 = (n + this.quartersX) % 4;
        }
        EnumFacing enumFacing2 = enumFacing;
        for (int i = 0; i < this.quartersX; ++i) {
            enumFacing2 = enumFacing2.rotateAround(EnumFacing.Axis.X);
        }
        if (enumFacing2.getAxis() == EnumFacing.Axis.Y) {
            n2 = (n2 + this.quartersY) % 4;
        }
        return n2;
    }

    public static ModelRotation getModelRotation(int n, int n2) {
        return mapRotations.get(ModelRotation.combineXY(MathHelper.normalizeAngle(n, 360), MathHelper.normalizeAngle(n2, 360)));
    }

    @Override
    public Optional<TRSRTransformation> apply(Optional<? extends IModelPart> optional) {
        return Optional.of(new TRSRTransformation(this.getMatrix()));
    }

    @Override
    public Matrix4f getMatrix() {
        org.lwjgl.util.vector.Matrix4f matrix4f = this.getMatrix4d();
        return new Matrix4f(new float[]{matrix4f.m00, matrix4f.m01, matrix4f.m02, matrix4f.m03, matrix4f.m10, matrix4f.m11, matrix4f.m12, matrix4f.m13, matrix4f.m20, matrix4f.m21, matrix4f.m22, matrix4f.m23, matrix4f.m30, matrix4f.m31, matrix4f.m32, matrix4f.m33});
    }

    @Override
    public EnumFacing rotate(EnumFacing enumFacing) {
        return this.rotateFace(enumFacing);
    }

    @Override
    public int rotate(EnumFacing enumFacing, int n) {
        return this.rotateVertex(enumFacing, n);
    }

    static {
        mapRotations = Maps.newHashMap();
        for (ModelRotation modelRotation : ModelRotation.values()) {
            mapRotations.put(modelRotation.combinedXY, modelRotation);
        }
    }
}

