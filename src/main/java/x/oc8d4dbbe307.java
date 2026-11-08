/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import org.lwjgl.opengl.GL11;
import x.oc05d664c647;
import x.oc110d7f376c;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc9adb807c19;
import x.oca9cc61aada;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc8d4dbbe307
extends oc69da1aa7f5 {
    private static final int \u00e0 = 28;
    private static final float \u0563 = 52.0f;
    private static final float \u0196 = 80.0f;
    private final oca9cc61aada \u04f7;
    private final DecimalFormat \u01b8 = new DecimalFormat("0.0");
    private final ArrayList<EntityTNTPrimed> \u01ff = new ArrayList();
    private int \u0238 = 0;
    private boolean d = false;
    public static int \u03b0;

    public oc8d4dbbe307() {
        super("TNTTimer", oce4cea752dd.\u014e, 0);
        this.\u0105("Shows the time remaining before primed TNT explodes.");
        this.\u04f7 = new oca9cc61aada("Scale", 1.0, 0.5, 3.0, 0.01);
        this.\u028c(this.\u04f7);
    }

    @oc66fa4f2195
    public void \u0539(oc9adb807c19 oc9adb807c192) {
        if (oc9adb807c192.\u04b0 != oc110d7f376c.END) {
            return;
        }
        this.D();
    }

    @oc66fa4f2195
    public void \u01d4(oc746a23b244 oc746a23b2442) {
        boolean bl;
        block28: {
            block20: {
                int n;
                block19: {
                    bl = oce6044968f8.\u0452;
                    n = oc7ab2161b9f.\u00d0();
                    if (bl) break block19;
                    if (n == 0) break block20;
                    n = this.\u0238;
                }
                if (n != 0) break block28;
            }
            return;
        }
        RenderManager renderManager = oc69da1aa7f5.\u0151.getRenderManager();
        FontRenderer fontRenderer = oc69da1aa7f5.\u0151.fontRendererObj;
        float f = oc746a23b2442.\u0401;
        boolean bl2 = this.d;
        int n = 0;
        while (n < this.\u0238) {
            block21: {
                block22: {
                    int n2;
                    EntityTNTPrimed entityTNTPrimed;
                    block27: {
                        int n3;
                        block25: {
                            block26: {
                                block23: {
                                    block24: {
                                        entityTNTPrimed = this.\u01ff.get(n);
                                        if (bl) break block21;
                                        if (entityTNTPrimed == null) break block22;
                                        n3 = entityTNTPrimed.isDead;
                                        if (bl) break block23;
                                        if (n3 == 0) break block24;
                                        break block22;
                                    }
                                    n3 = bl2;
                                }
                                if (bl) break block25;
                                if (n3 == 0) break block26;
                                n3 = entityTNTPrimed.fuse - (0x7EE52CDF ^ 0x7EE52CC3);
                                break block25;
                            }
                            n3 = entityTNTPrimed.fuse;
                        }
                        n2 = n3;
                        if (n2 >= 1) break block27;
                        break block22;
                    }
                    double d = entityTNTPrimed.lastTickPosX + (entityTNTPrimed.posX - entityTNTPrimed.lastTickPosX) * (double)f - renderManager.viewerPosX;
                    double d2 = entityTNTPrimed.lastTickPosY + (entityTNTPrimed.posY - entityTNTPrimed.lastTickPosY) * (double)f - renderManager.viewerPosY;
                    double d3 = entityTNTPrimed.lastTickPosZ + (entityTNTPrimed.posZ - entityTNTPrimed.lastTickPosZ) * (double)f - renderManager.viewerPosZ;
                    this.\u01b0(fontRenderer, renderManager, entityTNTPrimed, d, d2, d3, n2, f, bl2);
                }
                ++n;
            }
            if (!bl) continue;
        }
    }

    private void D() {
        Minecraft minecraft;
        boolean bl;
        block31: {
            block32: {
                block30: {
                    this.\u0238 = 0;
                    this.d = false;
                    bl = oce6044968f8.\u0452;
                    if (!oc7ab2161b9f.\u00d0()) break block30;
                    minecraft = oc69da1aa7f5.\u0151;
                    if (bl) break block31;
                    if (minecraft.theWorld != null) break block32;
                }
                return;
            }
            this.d = this.\u04bc();
            minecraft = oc69da1aa7f5.\u0151;
        }
        for (Entity entity : minecraft.theWorld.loadedEntityList) {
            block40: {
                Object object;
                EntityTNTPrimed entityTNTPrimed;
                block41: {
                    int n;
                    block39: {
                        block37: {
                            int n2;
                            block35: {
                                block36: {
                                    Entity entity2;
                                    block33: {
                                        entity2 = entity;
                                        if (bl) break block33;
                                        if (!(entity2 instanceof EntityTNTPrimed)) {
                                            continue;
                                        }
                                        entity2 = entity;
                                    }
                                    entityTNTPrimed = (EntityTNTPrimed)entity2;
                                    n2 = this.d;
                                    if (bl) break block35;
                                    if (n2 == 0) break block36;
                                    n2 = entityTNTPrimed.fuse - (0xB2C2DD86 ^ 0xB2C2DD9A);
                                    break block35;
                                }
                                n2 = entityTNTPrimed.fuse;
                            }
                            int n3 = n2;
                            n = n3;
                            if (bl) break block37;
                            if (n < 1) {
                                continue;
                            }
                            double d = entityTNTPrimed.getDistanceSqToEntity(oc69da1aa7f5.\u0151.thePlayer) - 4096.0;
                            n = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                        }
                        if (bl) break block39;
                        if (n > 0) {
                            continue;
                        }
                        object = this;
                        if (bl) break block40;
                        n = ((oc8d4dbbe307)object).\u0238;
                    }
                    if (n < this.\u01ff.size()) break block41;
                    this.\u01ff.add(entityTNTPrimed);
                    if (!bl) break block40;
                }
                object = this.\u01ff.set(this.\u0238, entityTNTPrimed);
            }
            ++this.\u0238;
            if (!bl) continue;
        }
    }

    private void \u01b0(FontRenderer fontRenderer, RenderManager renderManager, EntityTNTPrimed entityTNTPrimed, double d, double d2, double d3, int n, float f, boolean bl) {
        int n2;
        float f2;
        float f3;
        Color color;
        String string;
        block6: {
            block7: {
                string = this.\u01b8.format(((float)n - f) / 20.0f);
                boolean bl2 = oce6044968f8.\u0452;
                float f4 = bl ? 52.0f : 80.0f;
                float f5 = f4;
                float f6 = Math.min((float)n / f5, 1.0f);
                color = new Color(1.0f - f6, f6, 0.0f);
                f3 = 0.02666667f * oc05d664c647.\u04e8(this.\u04f7.\u04c1());
                GL11.glPushMatrix();
                GlStateManager.translate((float)d, (float)d2 + entityTNTPrimed.height + 0.5f, (float)d3);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(-renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                f2 = renderManager.playerViewX;
                n2 = oc69da1aa7f5.\u0151.gameSettings.thirdPersonView;
                if (bl2) break block6;
                if (n2 != (0x13654751 ^ 0x13654753)) break block7;
                n2 = -1;
                break block6;
            }
            n2 = 1;
        }
        GlStateManager.rotate(f2 * (float)n2, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-f3, -f3, f3);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(0x13654451 ^ 0x13654753, 0x13654450 ^ 0x13654753, 1, 0);
        int n3 = fontRenderer.getStringWidth(string) >> 1;
        GlStateManager.enableDepth();
        GlStateManager.depthMask(true);
        GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(0x13654754 ^ 0x13654753, DefaultVertexFormats.POSITION_COLOR);
        worldRenderer.pos(-n3 - 1, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        worldRenderer.pos(-n3 - 1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        worldRenderer.pos(n3 + 1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        worldRenderer.pos(n3 + 1, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        fontRenderer.drawString(string, -n3, 0, color.getRGB());
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    private boolean \u04bc() {
        boolean bl;
        block18: {
            block17: {
                ScoreObjective scoreObjective;
                boolean bl2;
                block16: {
                    Scoreboard scoreboard;
                    block14: {
                        Scoreboard scoreboard2;
                        block15: {
                            Minecraft minecraft;
                            block12: {
                                block13: {
                                    bl2 = oce6044968f8.\u0452;
                                    minecraft = oc69da1aa7f5.\u0151;
                                    if (bl2) break block12;
                                    if (minecraft.theWorld != null) break block13;
                                    return false;
                                }
                                minecraft = oc69da1aa7f5.\u0151;
                            }
                            scoreboard2 = minecraft.theWorld.getScoreboard();
                            scoreboard = scoreboard2;
                            if (bl2) break block14;
                            if (scoreboard != null) break block15;
                            return false;
                        }
                        scoreboard = scoreboard2;
                    }
                    ScoreObjective scoreObjective2 = scoreboard.getObjectiveInDisplaySlot(1);
                    scoreObjective = scoreObjective2;
                    if (bl2) break block16;
                    if (scoreObjective == null) break block17;
                    scoreObjective = scoreObjective2;
                }
                bl = oc7ab2161b9f.\u0211(scoreObjective.getDisplayName()).contains("BED WARS");
                if (bl2) break block18;
                if (!bl) break block17;
                bl = true;
                break block18;
            }
            bl = false;
        }
        return bl;
    }
}

