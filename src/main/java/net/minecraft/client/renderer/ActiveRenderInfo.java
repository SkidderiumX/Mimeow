/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.util.glu.GLU;
import x.oc02a3730b27;
import x.oc30aea91d28;
import x.oc9755810e45;

public class ActiveRenderInfo {
    private static final IntBuffer VIEWPORT = GLAllocation.createDirectIntBuffer(16);
    private static final FloatBuffer MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
    private static final FloatBuffer PROJECTION = GLAllocation.createDirectFloatBuffer(16);
    private static final FloatBuffer OBJECTCOORDS = GLAllocation.createDirectFloatBuffer(3);
    private static Vec3 position = new Vec3(0.0, 0.0, 0.0);
    private static float rotationX;
    private static float rotationXZ;
    private static float rotationZ;
    private static float rotationYZ;
    private static float rotationXY;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void updateRenderInfo(EntityPlayer entityPlayer, boolean bl) {
        oc02a3730b27.\u0575();
        try {
            GlStateManager.getFloat(2982, MODELVIEW);
            GlStateManager.getFloat(2983, PROJECTION);
            oc30aea91d28.\u0539(2978, VIEWPORT);
            float f = (VIEWPORT.get(0) + VIEWPORT.get(2)) / 2;
            float f2 = (VIEWPORT.get(1) + VIEWPORT.get(3)) / 2;
            GLU.gluUnProject(f, f2, 0.0f, MODELVIEW, PROJECTION, VIEWPORT, OBJECTCOORDS);
            position = new Vec3(OBJECTCOORDS.get(0), OBJECTCOORDS.get(1), OBJECTCOORDS.get(2));
            int n = bl ? 1 : 0;
            float f3 = ActiveRenderInfo.mimeow$redirectRotationPitch(entityPlayer);
            float f4 = ActiveRenderInfo.mimeow$redirectRotationYaw(entityPlayer);
            rotationX = MathHelper.cos(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
            rotationZ = MathHelper.sin(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
            rotationYZ = -rotationZ * MathHelper.sin(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
            rotationXY = rotationX * MathHelper.sin(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
            rotationXZ = MathHelper.cos(f3 * (float)Math.PI / 180.0f);
        }
        finally {
            oc02a3730b27.\u014e();
        }
    }

    public static Vec3 projectViewFromEntity(Entity entity, double d) {
        double d2 = entity.prevPosX + (entity.posX - entity.prevPosX) * d;
        double d3 = entity.prevPosY + (entity.posY - entity.prevPosY) * d;
        double d4 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * d;
        double d5 = d2 + ActiveRenderInfo.position.xCoord;
        double d6 = d3 + ActiveRenderInfo.position.yCoord;
        double d7 = d4 + ActiveRenderInfo.position.zCoord;
        return new Vec3(d5, d6, d7);
    }

    public static Block getBlockAtEntityViewpoint(World world2, Entity entity, float f) {
        Vec3 vec3 = ActiveRenderInfo.projectViewFromEntity(entity, f);
        BlockPos blockPos = new BlockPos(vec3);
        IBlockState iBlockState = world2.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        if (block.getMaterial().isLiquid()) {
            float f2;
            float f3 = 0.0f;
            if (iBlockState.getBlock() instanceof BlockLiquid) {
                f3 = BlockLiquid.getLiquidHeightPercent(iBlockState.getValue(BlockLiquid.LEVEL)) - 0.11111111f;
            }
            if (vec3.yCoord >= (double)(f2 = (float)(blockPos.getY() + 1) - f3)) {
                block = world2.getBlockState(blockPos.up()).getBlock();
            }
        }
        return block;
    }

    public static Vec3 getPosition() {
        return position;
    }

    public static float getRotationX() {
        return rotationX;
    }

    public static float getRotationXZ() {
        return rotationXZ;
    }

    public static float getRotationZ() {
        return rotationZ;
    }

    public static float getRotationYZ() {
        return rotationYZ;
    }

    public static float getRotationXY() {
        return rotationXY;
    }

    private static float mimeow$redirectRotationYaw(EntityPlayer entityPlayer) {
        return ActiveRenderInfo.isFreelookActive(entityPlayer) ? oc9755810e45.\u0411.\u0219() : entityPlayer.rotationYaw;
    }

    private static float mimeow$redirectRotationPitch(EntityPlayer entityPlayer) {
        return ActiveRenderInfo.isFreelookActive(entityPlayer) ? oc9755810e45.\u0411.\u03b7() : entityPlayer.rotationPitch;
    }

    private static boolean isFreelookActive(Entity entity) {
        return entity == Minecraft.getMinecraft().thePlayer && oc9755810e45.\u0411 != null && oc9755810e45.\u0411.\u00d6();
    }
}

