/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.tileentity;

import java.util.Calendar;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import x.occb14fa9996;
import x.ocee33618a8d;

public class TileEntityChestRenderer
extends TileEntitySpecialRenderer<TileEntityChest> {
    private static final ResourceLocation textureTrappedDouble = new ResourceLocation("textures/entity/chest/trapped_double.png");
    private static final ResourceLocation textureChristmasDouble = new ResourceLocation("textures/entity/chest/christmas_double.png");
    private static final ResourceLocation textureNormalDouble = new ResourceLocation("textures/entity/chest/normal_double.png");
    private static final ResourceLocation textureTrapped = new ResourceLocation("textures/entity/chest/trapped.png");
    private static final ResourceLocation textureChristmas = new ResourceLocation("textures/entity/chest/christmas.png");
    private static final ResourceLocation textureNormal = new ResourceLocation("textures/entity/chest/normal.png");
    private ModelChest simpleChest = new ModelChest();
    private ModelChest largeChest = new ModelLargeChest();
    private boolean isChristmas;

    public TileEntityChestRenderer() {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this.isChristmas = true;
        }
    }

    @Override
    public void renderTileEntityAt(TileEntityChest tileEntityChest, double d, double d2, double d3, float f, int n) {
        Object object;
        int n2;
        this.mimeow$chestChamsPre(tileEntityChest, d, d2, d3, f, n, new ocee33618a8d("renderTileEntityAt", false));
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        if (!tileEntityChest.hasWorldObj()) {
            n2 = 0;
        } else {
            object = tileEntityChest.getBlockType();
            n2 = tileEntityChest.getBlockMetadata();
            if (object instanceof BlockChest && n2 == 0) {
                ((BlockChest)object).checkForSurroundingChests(tileEntityChest.getWorld(), tileEntityChest.getPos(), tileEntityChest.getWorld().getBlockState(tileEntityChest.getPos()));
                n2 = tileEntityChest.getBlockMetadata();
            }
            tileEntityChest.checkForAdjacentChests();
        }
        if (tileEntityChest.adjacentChestZNeg == null && tileEntityChest.adjacentChestXNeg == null) {
            float f2;
            if (tileEntityChest.adjacentChestXPos == null && tileEntityChest.adjacentChestZPos == null) {
                object = this.simpleChest;
                if (n >= 0) {
                    this.bindTexture(DESTROY_STAGES[n]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(4.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                } else if (this.isChristmas) {
                    this.bindTexture(textureChristmas);
                } else if (tileEntityChest.getChestType() == 1) {
                    this.bindTexture(textureTrapped);
                } else {
                    this.bindTexture(textureNormal);
                }
            } else {
                object = this.largeChest;
                if (n >= 0) {
                    this.bindTexture(DESTROY_STAGES[n]);
                    GlStateManager.matrixMode(5890);
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(8.0f, 4.0f, 1.0f);
                    GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
                    GlStateManager.matrixMode(5888);
                } else if (this.isChristmas) {
                    this.bindTexture(textureChristmasDouble);
                } else if (tileEntityChest.getChestType() == 1) {
                    this.bindTexture(textureTrappedDouble);
                } else {
                    this.bindTexture(textureNormalDouble);
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            if (n < 0) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            }
            GlStateManager.translate((float)d, (float)d2 + 1.0f, (float)d3 + 1.0f);
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            GlStateManager.translate(0.5f, 0.5f, 0.5f);
            int n3 = 0;
            if (n2 == 2) {
                n3 = 180;
            }
            if (n2 == 3) {
                n3 = 0;
            }
            if (n2 == 4) {
                n3 = 90;
            }
            if (n2 == 5) {
                n3 = -90;
            }
            if (n2 == 2 && tileEntityChest.adjacentChestXPos != null) {
                GlStateManager.translate(1.0f, 0.0f, 0.0f);
            }
            if (n2 == 5 && tileEntityChest.adjacentChestZPos != null) {
                GlStateManager.translate(0.0f, 0.0f, -1.0f);
            }
            GlStateManager.rotate(n3, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, -0.5f);
            float f3 = tileEntityChest.prevLidAngle + (tileEntityChest.lidAngle - tileEntityChest.prevLidAngle) * f;
            if (tileEntityChest.adjacentChestZNeg != null && (f2 = tileEntityChest.adjacentChestZNeg.prevLidAngle + (tileEntityChest.adjacentChestZNeg.lidAngle - tileEntityChest.adjacentChestZNeg.prevLidAngle) * f) > f3) {
                f3 = f2;
            }
            if (tileEntityChest.adjacentChestXNeg != null && (f2 = tileEntityChest.adjacentChestXNeg.prevLidAngle + (tileEntityChest.adjacentChestXNeg.lidAngle - tileEntityChest.adjacentChestXNeg.prevLidAngle) * f) > f3) {
                f3 = f2;
            }
            f3 = 1.0f - f3;
            f3 = 1.0f - f3 * f3 * f3;
            ((ModelChest)object).chestLid.rotateAngleX = -(f3 * (float)Math.PI / 2.0f);
            ((ModelChest)object).renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (n >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }
        }
        this.mimeow$chestChamsPost(tileEntityChest, d, d2, d3, f, n, new ocee33618a8d("renderTileEntityAt", false));
    }

    private void mimeow$chestChamsPre(TileEntityChest tileEntityChest, double d, double d2, double d3, float f, int n, ocee33618a8d ocee33618a8d2) {
        occb14fa9996.\u0208(tileEntityChest);
    }

    private void mimeow$chestChamsPost(TileEntityChest tileEntityChest, double d, double d2, double d3, float f, int n, ocee33618a8d ocee33618a8d2) {
        occb14fa9996.\u03f5();
    }
}

