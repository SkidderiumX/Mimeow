/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import org.lwjgl.opengl.GL11;
import x.oc110d7f376c;
import x.oc1378bc114d;
import x.oc24a0a5bddf;
import x.oc45aa3f2e74;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc8ce2882092;
import x.oc9581f92f7d;
import x.oc9adb807c19;
import x.oc9e2e8d26de;
import x.oca305a6dc47;
import x.oca4f99d2d44;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocd2958dac48;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc2629a64205
extends oc69da1aa7f5 {
    private static final float \u0287 = 5.0f;
    private static final Comparator<oc9581f92f7d> \u043b = (oc9581f92f7d2, oc9581f92f7d3) -> Double.compare(oc9581f92f7d3.\u00f9, oc9581f92f7d2.\u00f9);
    private static final String[] \u04c9;
    private static final int \u01a1 = 14;
    private static final int \u0110 = 8;
    private static final int \u04df = 24;
    private static final int \u00cd = 9;
    private occ2f8dff8d8 \u028b;
    private occ2f8dff8d8 \u03ae;
    private occ2f8dff8d8 \u01a6;
    private oca9cc61aada \u0159;
    private occ2f8dff8d8 \u0534;
    private occ2f8dff8d8 \u04e3;
    private oca9cc61aada a;
    private occ2f8dff8d8 \u022f;
    private occ2f8dff8d8 \u04d7;
    private occ2f8dff8d8 \u0492;
    private occc831eff22 D;
    private occ2f8dff8d8 \u0141;
    private occ2f8dff8d8 \u04c8;
    private occ2f8dff8d8 \u0397;
    private occ2f8dff8d8 f;
    private occ2f8dff8d8 \u01cf;
    private occ2f8dff8d8 \u00de;
    private occ2f8dff8d8 \u0578;
    private oc24a0a5bddf \u0225;
    private oc24a0a5bddf \u044f;
    private final List<oc9581f92f7d> \u01a9 = new ArrayList<oc9581f92f7d>();
    private int \u0395 = 0;
    private static final int[] \u0153;
    private static final String[] \u051d;
    private static final int[] \u00e7;
    private static final String[] \u01fe;
    private static final int[] \u04e4;
    private static final String[] \u044a;
    private static final int[] \u0445;
    private static final String[] \u04d3;
    private static final int[] \u01c6;
    private static final String[] \u00c0;
    public static int \u0208;

    public oc2629a64205() {
        super("Nametags", oce4cea752dd.\u014e, 0);
        this.\u028b = new occ2f8dff8d8("Auto Scale", false);
        this.\u028c(this.\u028b);
        this.\u03ae = new occ2f8dff8d8("Background", true);
        this.\u028c(this.\u03ae);
        this.\u01a6 = new occ2f8dff8d8("Only render name", false);
        this.\u028c(this.\u01a6);
        this.\u0159 = new oca9cc61aada("Background Opacity", 0.5, 0.0, 1.0, 0.05);
        this.\u028c(this.\u0159);
        this.\u0534 = new occ2f8dff8d8("Background Border", false);
        this.\u028c(this.\u0534);
        this.\u04e3 = new occ2f8dff8d8("Show Health", false);
        this.\u028c(this.\u04e3);
        this.a = new oca9cc61aada("Health display", 0, \u04c9);
        this.\u028c(this.a);
        this.\u022f = new occ2f8dff8d8("Show Heart Symbol", true);
        this.\u028c(this.\u022f);
        this.\u04d7 = new occ2f8dff8d8("Text Shadow", false);
        this.\u028c(this.\u04d7);
        this.\u0492 = new occ2f8dff8d8("Show Distance", false);
        this.\u028c(this.\u0492);
        this.\u0397 = new occ2f8dff8d8("Show Armor", false);
        this.\u028c(this.\u0397);
        this.f = new occ2f8dff8d8("Show Enchantments", false);
        this.\u028c(this.f);
        this.\u01cf = new occ2f8dff8d8("Show Durability", false);
        this.\u028c(this.\u01cf);
        this.D = new occc831eff22("Targets");
        this.\u028c(this.D);
        this.\u0141 = new occ2f8dff8d8(this.D, "Show Invis", true);
        this.\u028c(this.\u0141);
        this.\u04c8 = new occ2f8dff8d8(this.D, "Show Teammate", true);
        this.\u028c(this.\u04c8);
        this.\u00de = new occ2f8dff8d8(this.D, "Show Yourself", false);
        this.\u028c(this.\u00de);
        this.\u0578 = new occ2f8dff8d8("Hide Vanilla", true);
        this.\u028c(this.\u0578);
        this.\u0225 = new oc24a0a5bddf("Friend color", 0xF81E6F7 ^ 0xF81E6A2, 0xF81E65D ^ 0xF81E6A2, 0xF81E65D ^ 0xF81E6A2);
        this.\u028c(this.\u0225);
        this.\u044f = new oc24a0a5bddf("Enemy color", 0xF81E65D ^ 0xF81E6A2, 0xF81E6F7 ^ 0xF81E6A2, 0xF81E6F7 ^ 0xF81E6A2);
        this.\u028c(this.\u044f);
    }

    @Override
    public void z$2u87utkr1isxg() {
        int n;
        occ2f8dff8d8 occ2f8dff8d82;
        block8: {
            block7: {
                boolean bl;
                block6: {
                    this.D.\u0209(true, this);
                    boolean bl2 = this.\u04e3.\u01ed();
                    bl = oce6044968f8.\u0452;
                    this.a.\u0209(bl2, this);
                    occ2f8dff8d82 = this.\u022f;
                    n = bl2;
                    if (bl) break block6;
                    if (n == false) break block7;
                    n = (int)this.a.\u04c1();
                }
                if (bl) break block8;
                if (n != false) break block7;
                n = 1;
                break block8;
            }
            n = false;
        }
        occ2f8dff8d82.\u0209(n != 0, this);
    }

    @oc66fa4f2195
    public void \u057e(oc9adb807c19 oc9adb807c192) {
        block7: {
            if (oc9adb807c192.\u04b0 != oc110d7f376c.END) {
                return;
            }
            if (oc7ab2161b9f.\u00d0() && oc69da1aa7f5.\u0151.theWorld != null) break block7;
            this.\u0395 = 0;
            return;
        }
        this.\u044a();
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u0473(oc746a23b244 oc746a23b2442) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        this.\u0164(oc746a23b2442.\u0401);
    }

    @oc66fa4f2195
    public void \u04c7(oca305a6dc47 oca305a6dc472) {
        block13: {
            oca305a6dc47 oca305a6dc473;
            block12: {
                boolean bl;
                block10: {
                    boolean bl2;
                    block11: {
                        bl2 = oce6044968f8.\u0452;
                        bl = this.\u0578.\u01ed();
                        if (bl2) break block10;
                        if (bl) break block11;
                        return;
                    }
                    oca305a6dc473 = oca305a6dc472;
                    if (bl2) break block12;
                    bl = oca305a6dc473.\u04bd instanceof EntityPlayer;
                }
                if (!bl) break block13;
                oca305a6dc473 = oca305a6dc472;
            }
            EntityPlayer entityPlayer = (EntityPlayer)oca305a6dc473.\u04bd;
            if (this.\u047f(entityPlayer)) {
                oca305a6dc472.setCanceled(true);
            }
        }
    }

    private void \u044a() {
        block39: {
            oc2629a64205 oc2629a642052;
            block56: {
                Entity entity;
                boolean bl;
                oc1378bc114d oc1378bc114d2;
                block38: {
                    block37: {
                        oc1378bc114d2 = this.\u0193();
                        bl = oce6044968f8.\u0452;
                        entity = oc69da1aa7f5.\u0151.getRenderViewEntity();
                        if (bl) break block37;
                        if (entity != null) break block38;
                        this.\u0395 = 0;
                    }
                    return;
                }
                boolean bl2 = this.\u0492.\u01ed();
                boolean bl3 = this.\u0397.\u01ed();
                float f = this.\u0541();
                this.\u0395 = 0;
                for (EntityPlayer entityPlayer : oc69da1aa7f5.\u0151.theWorld.playerEntities) {
                    float f2;
                    float f3;
                    double d;
                    int n;
                    int n2;
                    int n3;
                    int n4;
                    int n5;
                    String string;
                    EntityPlayer entityPlayer2;
                    oc9581f92f7d oc9581f92f7d2;
                    int n6;
                    ItemStack itemStack;
                    ItemStack itemStack2;
                    ItemStack itemStack3;
                    ItemStack itemStack4;
                    ItemStack itemStack5;
                    int n7;
                    block55: {
                        EntityPlayer entityPlayer3;
                        block53: {
                            block54: {
                                Object object;
                                int[] nArray;
                                int n8;
                                int n9;
                                String string2;
                                double d2;
                                block51: {
                                    block52: {
                                        int n10;
                                        block41: {
                                            block42: {
                                                block40: {
                                                    if (bl) break block39;
                                                    if (this.\u047f(entityPlayer)) break block40;
                                                    if (!bl) continue;
                                                }
                                                double d3 = entityPlayer.posX - entity.posX;
                                                double d4 = entityPlayer.posY - entity.posY;
                                                double d5 = entityPlayer.posZ - entity.posZ;
                                                d2 = d3 * d3 + d4 * d4 + d5 * d5;
                                                float f4 = (float)Math.sqrt(d2);
                                                string2 = this.\u01bd(entityPlayer, bl2, f4);
                                                n7 = oc9e2e8d26de.\u04b0(entityPlayer.getUniqueID(), entityPlayer.getName());
                                                n10 = n7;
                                                if (bl) break block41;
                                                if (n10 == 0) break block42;
                                                n10 = oc45aa3f2e74.\u041e(0x644D4A5E ^ 0x644D4A57);
                                                break block41;
                                            }
                                            n10 = 0;
                                        }
                                        int n11 = n10;
                                        n9 = (oc1378bc114d2.z$toz8pt08w0nc(string2) + n11) / (0x644D4A55 ^ 0x644D4A57);
                                        n8 = this.\u0122(entityPlayer);
                                        nArray = this.\u0223(string2, entityPlayer.getName());
                                        itemStack5 = null;
                                        itemStack4 = null;
                                        itemStack3 = null;
                                        itemStack2 = null;
                                        itemStack = null;
                                        n6 = 0;
                                        if (bl3) {
                                            ItemStack itemStack6;
                                            block49: {
                                                block50: {
                                                    ItemStack itemStack7;
                                                    block47: {
                                                        block48: {
                                                            ItemStack itemStack8;
                                                            block45: {
                                                                block46: {
                                                                    ItemStack itemStack9;
                                                                    block43: {
                                                                        block44: {
                                                                            itemStack5 = entityPlayer.getEquipmentInSlot(0);
                                                                            itemStack9 = itemStack5;
                                                                            if (bl) break block43;
                                                                            if (itemStack9 == null) break block44;
                                                                            ++n6;
                                                                        }
                                                                        itemStack9 = entityPlayer.getEquipmentInSlot(1);
                                                                    }
                                                                    itemStack4 = itemStack9;
                                                                    itemStack8 = itemStack4;
                                                                    if (bl) break block45;
                                                                    if (itemStack8 == null) break block46;
                                                                    ++n6;
                                                                }
                                                                itemStack8 = entityPlayer.getEquipmentInSlot(0x644D4A55 ^ 0x644D4A57);
                                                            }
                                                            itemStack3 = itemStack8;
                                                            itemStack7 = itemStack3;
                                                            if (bl) break block47;
                                                            if (itemStack7 == null) break block48;
                                                            ++n6;
                                                        }
                                                        itemStack7 = entityPlayer.getEquipmentInSlot(0x644D4A54 ^ 0x644D4A57);
                                                    }
                                                    itemStack2 = itemStack7;
                                                    itemStack6 = itemStack2;
                                                    if (bl) break block49;
                                                    if (itemStack6 == null) break block50;
                                                    ++n6;
                                                }
                                                itemStack6 = entityPlayer.getEquipmentInSlot(0x644D4A53 ^ 0x644D4A57);
                                            }
                                            itemStack = itemStack6;
                                            if (itemStack != null) {
                                                ++n6;
                                            }
                                        }
                                        object = this;
                                        if (bl) break block51;
                                        if (((oc2629a64205)object).\u0395 < this.\u01a9.size()) break block52;
                                        this.\u01a9.add(new oc9581f92f7d());
                                    }
                                    object = this.\u01a9.get(this.\u0395++);
                                }
                                oc9581f92f7d2 = (oc9581f92f7d)object;
                                entityPlayer2 = entityPlayer;
                                string = string2;
                                n5 = n9;
                                n4 = oc7ab2161b9f.\u01f3(entityPlayer);
                                n3 = n8;
                                n2 = nArray[0];
                                n = nArray[1];
                                d = d2;
                                f3 = f;
                                entityPlayer3 = entityPlayer;
                                if (bl) break block53;
                                if (!entityPlayer3.isSneaking()) break block54;
                                f2 = entityPlayer.height - 0.3f;
                                break block55;
                            }
                            entityPlayer3 = entityPlayer;
                        }
                        f2 = entityPlayer3.height;
                    }
                    oc9581f92f7d2.\u0407(entityPlayer2, string, n5, n4, n3, n2, n, d, f3, f2 + 0.3f, itemStack5, itemStack4, itemStack3, itemStack2, itemStack, n6, n7 != 0);
                    if (!bl) continue;
                }
                oc2629a642052 = this;
                if (bl) break block56;
                if (oc2629a642052.\u0395 <= 1) break block39;
                oc2629a642052 = this;
            }
            oc2629a642052.\u01a9.subList(0, this.\u0395).sort(\u043b);
        }
    }

    private void \u0164(float f) {
        block20: {
            int n;
            boolean bl;
            oc1378bc114d oc1378bc114d2;
            FontRenderer fontRenderer;
            RenderManager renderManager;
            block18: {
                int n2;
                block19: {
                    block17: {
                        renderManager = oc69da1aa7f5.\u0151.getRenderManager();
                        fontRenderer = oc69da1aa7f5.\u0151.fontRendererObj;
                        oc1378bc114d2 = this.\u0193();
                        bl = oce6044968f8.\u0452;
                        if (renderManager == null || fontRenderer == null) break block17;
                        n2 = this.\u0395;
                        if (bl) break block18;
                        if (n2 != 0) break block19;
                    }
                    return;
                }
                oc69da1aa7f5.\u0151.entityRenderer.callSetupCameraTransform(f, 0);
                n2 = n = 0;
            }
            while (n < this.\u0395) {
                block21: {
                    block22: {
                        oc9581f92f7d oc9581f92f7d2;
                        block23: {
                            oc9581f92f7d2 = this.\u01a9.get(n);
                            if (bl) break block20;
                            if (bl) break block21;
                            if (oc9581f92f7d2.\u03e8 == null) break block22;
                            if (ocbd4917c4b1.\u017e(oc9581f92f7d2.\u03e8)) break block23;
                            if (!bl) break block22;
                        }
                        this.\u013a(oc9581f92f7d2, f, renderManager, oc1378bc114d2, fontRenderer);
                    }
                    ++n;
                }
                if (!bl) continue;
            }
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.disableLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.tryBlendFuncSeparate(0x75B963CD ^ 0x75B960CF, 0x75B963CC ^ 0x75B960CF, 1, 0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    private boolean \u047f(EntityPlayer entityPlayer) {
        boolean bl;
        block55: {
            block56: {
                boolean bl2;
                block52: {
                    EntityPlayer entityPlayer2;
                    block54: {
                        block53: {
                            block51: {
                                oc2629a64205 oc2629a642052;
                                block49: {
                                    block50: {
                                        int n;
                                        block47: {
                                            block48: {
                                                boolean bl3;
                                                block45: {
                                                    block46: {
                                                        EntityPlayer entityPlayer3;
                                                        block40: {
                                                            block41: {
                                                                int n2;
                                                                block44: {
                                                                    block43: {
                                                                        block42: {
                                                                            block38: {
                                                                                block39: {
                                                                                    bl2 = oce6044968f8.\u0452;
                                                                                    entityPlayer3 = entityPlayer;
                                                                                    if (bl2) break block38;
                                                                                    if (entityPlayer3 != null) break block39;
                                                                                    return false;
                                                                                }
                                                                                entityPlayer3 = entityPlayer;
                                                                            }
                                                                            if (bl2) break block40;
                                                                            if (entityPlayer3 != oc69da1aa7f5.\u0151.thePlayer) break block41;
                                                                            n2 = this.\u00de.\u01ed();
                                                                            if (bl2) break block42;
                                                                            if (n2 == 0) break block43;
                                                                            n2 = oc69da1aa7f5.\u0151.gameSettings.thirdPersonView;
                                                                        }
                                                                        if (bl2) break block44;
                                                                        if (n2 == 0) break block43;
                                                                        n2 = 1;
                                                                        break block44;
                                                                    }
                                                                    n2 = 0;
                                                                }
                                                                return n2 != 0;
                                                            }
                                                            entityPlayer3 = entityPlayer;
                                                        }
                                                        bl3 = entityPlayer3.isDead;
                                                        if (bl2) break block45;
                                                        if (bl3) break block46;
                                                        n = entityPlayer.deathTime;
                                                        if (bl2) break block47;
                                                        if (n <= 0) break block48;
                                                    }
                                                    bl3 = false;
                                                }
                                                return bl3;
                                            }
                                            oc2629a642052 = this;
                                            if (bl2) break block49;
                                            n = oc2629a642052.\u0141.\u01ed() ? 1 : 0;
                                        }
                                        if (n != 0) break block50;
                                        bl = entityPlayer.isInvisible();
                                        if (bl2) break block51;
                                        if (!bl) break block50;
                                        return false;
                                    }
                                    oc2629a642052 = this;
                                }
                                bl = oc2629a642052.\u04c8.\u01ed();
                            }
                            if (bl2) break block52;
                            if (bl) break block53;
                            entityPlayer2 = entityPlayer;
                            if (bl2) break block54;
                            if (!oc7ab2161b9f.\u04e5(entityPlayer2)) break block53;
                            return false;
                        }
                        entityPlayer2 = entityPlayer;
                    }
                    bl = oca4f99d2d44.\u039b(entityPlayer2);
                }
                if (bl2) break block55;
                if (bl) break block56;
                bl = true;
                break block55;
            }
            bl = false;
        }
        return bl;
    }

    private String \u01bd(EntityPlayer entityPlayer, boolean bl, float f) {
        Object object;
        block32: {
            String string;
            int n;
            String string2;
            block35: {
                int n2;
                block36: {
                    block37: {
                        boolean bl2;
                        block33: {
                            block34: {
                                int n3;
                                block31: {
                                    block29: {
                                        block30: {
                                            block39: {
                                                block38: {
                                                    String string3;
                                                    block28: {
                                                        block27: {
                                                            int n4;
                                                            String string4;
                                                            block26: {
                                                                bl2 = oce6044968f8.\u0452;
                                                                if (!this.\u01a6.\u01ed()) break block38;
                                                                string4 = oc7ab2161b9f.\u00f3(entityPlayer.getDisplayName().getFormattedText());
                                                                n4 = string4.length();
                                                                if (bl2) break block26;
                                                                if (n4 < (0x61993E1 ^ 0x61993E3)) break block27;
                                                                string3 = string4;
                                                                if (bl2) break block28;
                                                                n4 = string3.charAt(0);
                                                            }
                                                            if (n4 != (0x6199344 ^ 0x61993E3)) break block27;
                                                            string3 = string4;
                                                            break block28;
                                                        }
                                                        string3 = "";
                                                    }
                                                    string2 = string3;
                                                    object = string2 + entityPlayer.getName();
                                                    if (!bl2) break block39;
                                                }
                                                object = entityPlayer.getDisplayName().getFormattedText();
                                            }
                                            n3 = this.\u04e3.\u01ed();
                                            if (bl2) break block29;
                                            if (n3 == 0) break block30;
                                            object = this.\u050a((String)object, entityPlayer);
                                        }
                                        n3 = bl;
                                    }
                                    if (bl2) break block31;
                                    if (n3 == 0) break block32;
                                    n3 = (int)f;
                                }
                                n = n3;
                                n2 = n;
                                if (bl2) break block33;
                                if (n2 > (0x61993EB ^ 0x61993E3)) break block34;
                                string = "\u00a7c";
                                break block35;
                            }
                            n2 = n;
                        }
                        if (bl2) break block36;
                        if (n2 > (0x61993EC ^ 0x61993E3)) break block37;
                        string = "\u00a76";
                        break block35;
                    }
                    n2 = n;
                }
                string = n2 <= (0x61993FA ^ 0x61993E3) ? "\u00a7e" : "\u00a77";
            }
            string2 = string;
            object = string2 + n + "m\u00a7r " + (String)object;
        }
        return object;
    }

    private int \u0122(EntityPlayer entityPlayer) {
        int n;
        block10: {
            block11: {
                EntityPlayer entityPlayer2;
                boolean bl;
                block8: {
                    block9: {
                        bl = oce6044968f8.\u0452;
                        entityPlayer2 = entityPlayer;
                        if (bl) break block8;
                        if (!oc7ab2161b9f.\u04ec(entityPlayer2)) break block9;
                        return this.\u0225.\u0373();
                    }
                    entityPlayer2 = entityPlayer;
                }
                n = oc7ab2161b9f.\u0160(entityPlayer2);
                if (bl) break block10;
                if (n == 0) break block11;
                return this.\u044f.\u0373();
            }
            n = -1;
        }
        return n;
    }

    private float \u0541() {
        return ocd2958dac48.\u0478() * 0.02f;
    }

    private float \u053b(float f, float f2) {
        float f3 = Math.max(1.0f, f2);
        return f * (f3 / 5.0f);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u013a(oc9581f92f7d oc9581f92f7d2, float f, RenderManager renderManager, oc1378bc114d oc1378bc114d2, FontRenderer fontRenderer) {
        block56: {
            oc9581f92f7d oc9581f92f7d3;
            boolean bl;
            block54: {
                block55: {
                    oc2629a64205 oc2629a642052;
                    block52: {
                        block53: {
                            int n;
                            block50: {
                                block51: {
                                    block49: {
                                        EntityPlayer entityPlayer;
                                        EntityPlayer entityPlayer2;
                                        block47: {
                                            block48: {
                                                block45: {
                                                    block46: {
                                                        block44: {
                                                            entityPlayer2 = oc9581f92f7d2.\u03e8;
                                                            bl = oce6044968f8.\u0452;
                                                            entityPlayer = entityPlayer2;
                                                            if (bl) break block44;
                                                            if (entityPlayer == null) break block45;
                                                            entityPlayer = entityPlayer2;
                                                        }
                                                        if (bl) break block46;
                                                        if (entityPlayer.isDead) break block45;
                                                        entityPlayer = entityPlayer2;
                                                    }
                                                    if (bl) break block47;
                                                    if (entityPlayer.deathTime <= 0) break block48;
                                                }
                                                return;
                                            }
                                            entityPlayer = entityPlayer2;
                                        }
                                        double d = entityPlayer.lastTickPosX + (entityPlayer2.posX - entityPlayer2.lastTickPosX) * (double)f - renderManager.viewerPosX;
                                        double d2 = entityPlayer2.lastTickPosY + (entityPlayer2.posY - entityPlayer2.lastTickPosY) * (double)f - renderManager.viewerPosY;
                                        double d3 = entityPlayer2.lastTickPosZ + (entityPlayer2.posZ - entityPlayer2.lastTickPosZ) * (double)f - renderManager.viewerPosZ;
                                        float f2 = oc9581f92f7d2.\u0394;
                                        if (bl) break block49;
                                        if (this.\u028b.\u01ed()) {
                                            f2 = this.\u053b(oc9581f92f7d2.\u0394, (float)Math.sqrt(d * d + d2 * d2 + d3 * d3));
                                        }
                                        GlStateManager.pushMatrix();
                                        GlStateManager.translate((float)d, (float)d2 + oc9581f92f7d2.\u043f, (float)d3);
                                        GlStateManager.rotate(-renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                                        GlStateManager.rotate(renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
                                        GlStateManager.scale(-f2, -f2, f2);
                                        GlStateManager.disableLighting();
                                        GlStateManager.depthMask(false);
                                        GlStateManager.disableDepth();
                                        GlStateManager.enableBlend();
                                        n = 0x989B7C23 ^ 0x989B7F21;
                                        if (bl) break block50;
                                        GlStateManager.tryBlendFuncSeparate(n, 0x989B7C22 ^ 0x989B7F21, 1, 0);
                                        GlStateManager.translate(0.0f, -10.0f, 0.0f);
                                    }
                                    if (!this.\u03ae.\u01ed()) break block51;
                                    oc2629a642052 = this;
                                    if (bl) break block52;
                                    if (oc2629a642052.\u0159.\u04c1() > 0.01) break block53;
                                }
                                oc2629a642052 = this;
                                if (bl) break block52;
                                n = oc2629a642052.\u0534.\u01ed();
                            }
                            if (n != 0) break block53;
                            oc9581f92f7d3 = oc9581f92f7d2;
                            if (bl) break block54;
                            if (oc9581f92f7d3.\u03b6 == -1) break block55;
                        }
                        this.\u048e(oc9581f92f7d2.\u0401, 0.0f, oc9581f92f7d2.\u049f, oc9581f92f7d2.\u03b6, oc1378bc114d2);
                        oc2629a642052 = this;
                    }
                    oc2629a642052.\u0139();
                }
                this.\u02aa(oc9581f92f7d2, oc1378bc114d2);
                this.\u0139();
                if (bl) break block56;
                oc9581f92f7d3 = oc9581f92f7d2;
            }
            if (oc9581f92f7d3.\u0408 > 0) {
                int n = -(oc9581f92f7d2.\u0408 * (0x989B7F2F ^ 0x989B7F21)) / (0x989B7F23 ^ 0x989B7F21);
                int n2 = 0x676480CD ^ 0x989B7F21;
                oc9581f92f7d oc9581f92f7d4 = oc9581f92f7d2;
                if (!bl) {
                    if (oc9581f92f7d4.\u0430 != null) {
                        this.\u04e7(oc9581f92f7d2.\u0430, n, n2, fontRenderer);
                        n += 14;
                    }
                    oc9581f92f7d4 = oc9581f92f7d2;
                }
                if (!bl) {
                    if (oc9581f92f7d4.\u0179 != null) {
                        this.\u04e7(oc9581f92f7d2.\u0179, n, n2, fontRenderer);
                        n += 14;
                    }
                    oc9581f92f7d4 = oc9581f92f7d2;
                }
                if (!bl) {
                    if (oc9581f92f7d4.\u012b != null) {
                        this.\u04e7(oc9581f92f7d2.\u012b, n, n2, fontRenderer);
                        n += 14;
                    }
                    oc9581f92f7d4 = oc9581f92f7d2;
                }
                if (!bl) {
                    if (oc9581f92f7d4.\u044d != null) {
                        this.\u04e7(oc9581f92f7d2.\u044d, n, n2, fontRenderer);
                        n += 14;
                    }
                    oc9581f92f7d4 = oc9581f92f7d2;
                }
                if (oc9581f92f7d4.\u04ca != null) {
                    this.\u04e7(oc9581f92f7d2.\u04ca, n, n2, fontRenderer);
                }
            }
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.tryBlendFuncSeparate(0x989B7C23 ^ 0x989B7F21, 0x989B7C22 ^ 0x989B7F21, 1, 0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }

    private void \u0139() {
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(0x9337586 ^ 0x9337782, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(0x9337480 ^ 0x9337782, 0x9337481 ^ 0x9337782, 1, 0);
        GL11.glTexEnvi(0x9335482 ^ 0x9337782, 0x9335582 ^ 0x9337782, 0x9335682 ^ 0x9337782);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void \u02aa(oc9581f92f7d oc9581f92f7d2, oc1378bc114d oc1378bc114d2) {
        int n2;
        float f3;
        block18: {
            block19: {
                block16: {
                    int n3;
                    block17: {
                        oc9581f92f7d oc9581f92f7d3;
                        boolean bl;
                        block14: {
                            block15: {
                                f3 = -oc9581f92f7d2.\u0401;
                                bl = oce6044968f8.\u0452;
                                oc9581f92f7d3 = oc9581f92f7d2;
                                if (bl) break block14;
                                if (!oc9581f92f7d3.\u00d5) break block15;
                                int n4 = Math.round((float)(oc1378bc114d2.z$1tqmx4tpnr6lq() - (0xDFF3BE47 ^ 0xDFF3BE4E)) / 2.0f);
                                oc45aa3f2e74.\u03f8(f3, n4, 0xDFF3BE47 ^ 0xDFF3BE4E, -1);
                                f3 += (float)oc45aa3f2e74.\u041e(0xDFF3BE47 ^ 0xDFF3BE4E);
                            }
                            oc9581f92f7d3 = oc9581f92f7d2;
                        }
                        n3 = oc9581f92f7d3.\u03b6;
                        if (bl) break block16;
                        if (n3 == -1) break block17;
                        n3 = oc9581f92f7d2.\u0207;
                        if (bl) break block16;
                        if (n3 < 0) break block17;
                        n2 = oc9581f92f7d2.\u0399;
                        if (bl) break block18;
                        if (n2 > oc9581f92f7d2.\u0207) break block19;
                    }
                    n3 = oc1378bc114d2.z$ao2ykh4tuw6w(oc9581f92f7d2.\u0574, f3, 0.0f, -1, this.\u04d7.\u01ed());
                }
                return;
            }
            n2 = 1;
        }
        int[] nArray = new int[n2];
        nArray[0] = 0;
        int[] nArray2 = nArray;
        oc1378bc114d2.z$22eyp2803ejhs(oc9581f92f7d2.\u0574, f3, 0.0f, (c, f, f2, n) -> {
            int n2;
            block15: {
                block14: {
                    Integer n3;
                    block13: {
                        boolean bl;
                        block11: {
                            int n4;
                            block12: {
                                block10: {
                                    int n5 = nArray2[0];
                                    nArray[0] = n5 + 1;
                                    int n6 = n5;
                                    bl = oce6044968f8.\u0452;
                                    n4 = n6;
                                    if (bl) break block10;
                                    if (n4 < oc9581f92f7d2.\u0207) break block11;
                                    n4 = n6;
                                }
                                if (bl) break block12;
                                if (n4 >= oc9581f92f7d2.\u0399) break block11;
                                n4 = oc9581f92f7d2.\u03b6;
                            }
                            return n4;
                        }
                        n3 = n;
                        if (bl) break block13;
                        if (n3 == null) break block14;
                        n3 = n;
                    }
                    n2 = n3;
                    break block15;
                }
                n2 = -1;
            }
            return n2;
        }, this.\u04d7.\u01ed());
    }

    private void \u048e(int n, float f, int n2, int n3, oc1378bc114d oc1378bc114d2) {
        block39: {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            WorldRenderer worldRenderer;
            Tessellator tessellator;
            block42: {
                block41: {
                    int n4;
                    int n5;
                    boolean bl;
                    block40: {
                        block37: {
                            block38: {
                                int n6;
                                block35: {
                                    block36: {
                                        block33: {
                                            block34: {
                                                int n7;
                                                block32: {
                                                    block31: {
                                                        block30: {
                                                            GlStateManager.disableTexture2D();
                                                            tessellator = Tessellator.getInstance();
                                                            worldRenderer = tessellator.getWorldRenderer();
                                                            f9 = (float)this.\u0159.\u04c1();
                                                            f8 = (float)(-n) - 3.0f;
                                                            f7 = (float)n + 3.0f;
                                                            f6 = f + (float)oc1378bc114d2.z$g5bxucc1j700() - 3.0f;
                                                            bl = oce6044968f8.\u0452;
                                                            f5 = f + (float)oc1378bc114d2.z$w1h9nvoglpkn() + 2.0f;
                                                            n7 = this.\u03ae.\u01ed();
                                                            if (bl) break block30;
                                                            if (n7 == 0) break block31;
                                                            float f10 = f9 - 0.01f;
                                                            n7 = f10 == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1);
                                                        }
                                                        if (bl) break block32;
                                                        if (n7 <= 0) break block31;
                                                        n7 = 1;
                                                        break block32;
                                                    }
                                                    n7 = 0;
                                                }
                                                int n8 = n7;
                                                n6 = n8;
                                                if (bl) break block33;
                                                if (n6 == 0) break block34;
                                                worldRenderer.begin(0x305D2E6D ^ 0x305D2E6A, DefaultVertexFormats.POSITION_COLOR);
                                                worldRenderer.pos(f8, f6, 0.0).color(0.0f, 0.0f, 0.0f, f9).endVertex();
                                                worldRenderer.pos(f8, f5, 0.0).color(0.0f, 0.0f, 0.0f, f9).endVertex();
                                                worldRenderer.pos(f7, f5, 0.0).color(0.0f, 0.0f, 0.0f, f9).endVertex();
                                                worldRenderer.pos(f7, f6, 0.0).color(0.0f, 0.0f, 0.0f, f9).endVertex();
                                                tessellator.draw();
                                            }
                                            n6 = n3;
                                        }
                                        if (bl) break block35;
                                        if (n6 == -1) break block36;
                                        n6 = n3;
                                        break block35;
                                    }
                                    n6 = n2;
                                }
                                n5 = n6;
                                n4 = this.\u0534.\u01ed();
                                if (bl) break block37;
                                if (n4 != 0) break block38;
                                n4 = n3;
                                if (bl) break block37;
                                if (n4 == -1) break block39;
                            }
                            n4 = n5;
                        }
                        if (bl) break block40;
                        if (n4 == -1) break block41;
                        n4 = n5 >> (0x305D2E7A ^ 0x305D2E6A) & (0x305D2E95 ^ 0x305D2E6A);
                    }
                    f4 = (float)n4 / 255.0f;
                    f3 = (float)(n5 >> (0x305D2E62 ^ 0x305D2E6A) & (0x305D2E95 ^ 0x305D2E6A)) / 255.0f;
                    f2 = (float)(n5 & (0x305D2E95 ^ 0x305D2E6A)) / 255.0f;
                    if (!bl) break block42;
                }
                f4 = 0.6f;
                f3 = 0.6f;
                f2 = 0.6f;
            }
            float f11 = 1.0f;
            float f12 = n3 != -1 ? f9 : 1.0f;
            float f13 = f12;
            float f14 = f8 - f11;
            float f15 = f7 + f11;
            float f16 = f6 - f11;
            float f17 = f5 + f11;
            float f18 = -0.001f;
            worldRenderer.begin(0x305D2E6D ^ 0x305D2E6A, DefaultVertexFormats.POSITION_COLOR);
            worldRenderer.pos(f14, f16, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f14, f6, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f6, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f16, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f14, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f14, f17, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f17, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f14, f6, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f14, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f8, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f8, f6, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f7, f6, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f7, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f5, f18).color(f4, f3, f2, f13).endVertex();
            worldRenderer.pos(f15, f6, f18).color(f4, f3, f2, f13).endVertex();
            tessellator.draw();
        }
        GlStateManager.enableTexture2D();
    }

    private int[] \u0223(String string, String string2) {
        int n;
        int n2;
        block4: {
            block5: {
                String string3 = this.\u0403(string);
                n2 = string3.indexOf(string2);
                boolean bl = oce6044968f8.\u0452;
                n = n2;
                if (bl) break block4;
                if (n >= 0) break block5;
                int[] nArray = new int[0x11BADEBB ^ 0x11BADEB9];
                nArray[0] = -1;
                nArray[1] = -1;
                return nArray;
            }
            n = 0x11BADEBB ^ 0x11BADEB9;
        }
        int[] nArray = new int[n];
        nArray[0] = n2;
        nArray[1] = n2 + string2.length();
        return nArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String \u0403(String string) {
        String string2;
        block9: {
            StringBuilder stringBuilder = new StringBuilder(string.length());
            boolean bl = oce6044968f8.\u0452;
            for (int i = 0; i < string.length(); ++i) {
                int n;
                block11: {
                    int n2;
                    block10: {
                        string2 = string;
                        if (bl) break block9;
                        n2 = n = string2.charAt(i);
                        if (bl) break block10;
                        if (n2 != (0x90B76122 ^ 0x90B76185)) break block11;
                        n2 = i + 1;
                    }
                    if (n2 < string.length()) {
                        ++i;
                        if (!bl) continue;
                    }
                }
                stringBuilder.append((char)n);
                if (!bl) continue;
            }
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    private oc1378bc114d \u0193() {
        return ocd2958dac48.\u01e7();
    }

    private String \u050a(String object, EntityPlayer entityPlayer) {
        block46: {
            block47: {
                String string;
                String string2;
                String string3;
                block52: {
                    block51: {
                        int n;
                        block50: {
                            float f;
                            int n2;
                            boolean bl;
                            block49: {
                                float f2;
                                block48: {
                                    String string4;
                                    String string5;
                                    String string6;
                                    block45: {
                                        block44: {
                                            int n3;
                                            block43: {
                                                String string7;
                                                float f3;
                                                block40: {
                                                    double d;
                                                    block41: {
                                                        double d2;
                                                        block42: {
                                                            double d3;
                                                            block38: {
                                                                block39: {
                                                                    int n4;
                                                                    float f4;
                                                                    block36: {
                                                                        block37: {
                                                                            block34: {
                                                                                block35: {
                                                                                    f3 = Math.max(0.0f, entityPlayer.getHealth());
                                                                                    f4 = entityPlayer.getMaxHealth();
                                                                                    bl = oce6044968f8.\u0452;
                                                                                    float f5 = f4 - 0.0f;
                                                                                    n4 = f5 == 0.0f ? 0 : (f5 < 0.0f ? -1 : 1);
                                                                                    if (bl) break block34;
                                                                                    if (n4 > 0) break block35;
                                                                                    f4 = 20.0f;
                                                                                }
                                                                                n4 = (int)this.a.\u04c1();
                                                                            }
                                                                            if (bl) break block36;
                                                                            if (n4 != false) break block37;
                                                                            n4 = 1;
                                                                            break block36;
                                                                        }
                                                                        n4 = 0;
                                                                    }
                                                                    n2 = n4;
                                                                    d2 = f3 / f4;
                                                                    d = d2;
                                                                    d3 = 0.3;
                                                                    if (bl) break block38;
                                                                    if (!(d < d3)) break block39;
                                                                    string7 = "\u00a7c";
                                                                    break block40;
                                                                }
                                                                d = d2;
                                                                if (bl) break block41;
                                                                d3 = 0.5;
                                                            }
                                                            if (!(d < d3)) break block42;
                                                            string7 = "\u00a76";
                                                            break block40;
                                                        }
                                                        d = d2;
                                                    }
                                                    string7 = d < 0.7 ? "\u00a7e" : "\u00a7a";
                                                }
                                                string6 = string7;
                                                float f6 = n2 != 0 ? f3 / 2.0f : f3;
                                                float f7 = f6;
                                                string5 = this.\u0579(f7);
                                                n3 = n2;
                                                if (bl) break block43;
                                                if (n3 == 0) break block44;
                                                n3 = this.\u022f.\u01ed() ? 1 : 0;
                                            }
                                            if (n3 == 0) break block44;
                                            string4 = " \u2764";
                                            break block45;
                                        }
                                        string4 = "";
                                    }
                                    String string8 = string4;
                                    object = (String)object + " " + string6 + string5 + string8;
                                    f2 = entityPlayer.getAbsorptionAmount();
                                    if (bl) break block46;
                                    if (!(f2 > 0.0f)) break block47;
                                    if (n2 == 0) break block48;
                                    f = f2 / 2.0f;
                                    break block49;
                                }
                                f = f2;
                            }
                            float f8 = f;
                            string3 = this.\u0579(f8);
                            n = n2;
                            if (bl) break block50;
                            if (n == 0) break block51;
                            n = this.\u022f.\u01ed() ? 1 : 0;
                        }
                        if (n == 0) break block51;
                        string2 = " \u2764";
                        break block52;
                    }
                    string2 = "";
                }
                String string9 = string = string2;
                String string10 = string3;
                object = (String)object + " \u00a76+" + string10 + string9;
            }
            object = (String)object + "\u00a7r";
        }
        return object;
    }

    private String \u0579(float f) {
        float f2;
        float f3;
        block4: {
            block5: {
                int n = (int)f;
                boolean bl = oce6044968f8.\u0452;
                f3 = f;
                f2 = n;
                if (bl) break block4;
                if (f3 != f2) break block5;
                return String.valueOf(n);
            }
            f3 = f;
            f2 = 10.0f;
        }
        int n = Math.round(f3 * f2);
        int n2 = n / (0x67AF63BE ^ 0x67AF63B4);
        int n3 = Math.abs(n % (0x67AF63BE ^ 0x67AF63B4));
        return n2 + "." + n3;
    }

    private void \u04e7(ItemStack itemStack, int n, int n2, FontRenderer fontRenderer) {
        block26: {
            ItemStack itemStack2;
            block28: {
                boolean bl;
                block27: {
                    int n3;
                    block25: {
                        block23: {
                            block24: {
                                block21: {
                                    block22: {
                                        ItemStack itemStack3;
                                        block19: {
                                            block20: {
                                                bl = oce6044968f8.\u0452;
                                                itemStack3 = itemStack;
                                                if (bl) break block19;
                                                if (itemStack3 != null) break block20;
                                                return;
                                            }
                                            itemStack3 = itemStack;
                                        }
                                        ocbd4917c4b1.\u04f0(itemStack3, n, n2);
                                        if (bl) break block21;
                                        if (!this.f.\u01ed()) break block22;
                                        GlStateManager.pushMatrix();
                                        GlStateManager.scale(0.5, 0.5, 0.5);
                                        GlStateManager.translate(0.0f, -10.0f, 0.0f);
                                        this.\u04a7(itemStack, n, n2, fontRenderer);
                                        GlStateManager.popMatrix();
                                    }
                                    GlStateManager.disableDepth();
                                }
                                n3 = itemStack.stackSize;
                                if (bl) break block23;
                                if (n3 <= 1) break block24;
                                String string = String.valueOf(itemStack.stackSize);
                                fontRenderer.drawStringWithShadow(string, n + (0xC9C0A0E5 ^ 0xC9C0A0F4) - fontRenderer.getStringWidth(string), n2 + (0xC9C0A0FD ^ 0xC9C0A0F4), 0xC93F5F0B ^ 0xC9C0A0F4);
                            }
                            n3 = this.\u01cf.\u01ed() ? 1 : 0;
                        }
                        if (bl) break block25;
                        if (n3 == 0) break block26;
                        itemStack2 = itemStack;
                        if (bl) break block27;
                        n3 = itemStack2.isItemStackDamageable() ? 1 : 0;
                    }
                    if (n3 == 0) break block26;
                    itemStack2 = itemStack;
                }
                if (bl) break block28;
                if (itemStack2.getItemDamage() <= 0) break block26;
                itemStack2 = itemStack;
            }
            int n4 = itemStack2.getMaxDamage();
            int n5 = itemStack.getItemDamage();
            float f = 1.0f - (float)n5 / (float)n4;
            ocbd4917c4b1.\u01dd(n, n2, f);
        }
        GlStateManager.enableDepth();
    }

    private void \u04a7(ItemStack itemStack, int n, int n2, FontRenderer fontRenderer) {
        String[] stringArray;
        int[] nArray;
        boolean bl;
        block23: {
            block24: {
                Item item;
                block19: {
                    Item item2;
                    block20: {
                        block17: {
                            block18: {
                                block15: {
                                    block16: {
                                        item2 = itemStack.getItem();
                                        bl = oce6044968f8.\u0452;
                                        item = item2;
                                        if (bl) break block15;
                                        if (!(item instanceof ItemArmor)) break block16;
                                        nArray = \u0153;
                                        stringArray = \u051d;
                                        if (!bl) break block23;
                                    }
                                    item = item2;
                                }
                                if (bl) break block17;
                                if (!(item instanceof ItemSword)) break block18;
                                nArray = \u00e7;
                                stringArray = \u01fe;
                                if (!bl) break block23;
                            }
                            item = item2;
                        }
                        if (bl) break block19;
                        if (!(item instanceof ItemBow)) break block20;
                        nArray = \u04e4;
                        stringArray = \u044a;
                        if (!bl) break block23;
                    }
                    item = item2;
                }
                if (!(item instanceof ItemTool)) break block24;
                nArray = \u0445;
                stringArray = \u04d3;
                if (!bl) break block23;
            }
            nArray = \u01c6;
            stringArray = \u00c0;
        }
        int n3 = n * (0x8D8F84B4 ^ 0x8D8F84B6);
        int n4 = n2 - (0x8D8F84AE ^ 0x8D8F84B6);
        for (int i = 0; i < nArray.length; ++i) {
            block21: {
                int n5;
                block22: {
                    n5 = EnchantmentHelper.getEnchantmentLevel(nArray[i], itemStack);
                    if (bl) break block21;
                    if (n5 > 0) break block22;
                    if (!bl) continue;
                }
                this.\u00cf(fontRenderer, stringArray[i], n5, n3, n4);
            }
            n4 += 8;
            if (!bl) continue;
        }
    }

    private void \u00cf(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.drawStringWithShadow(string, n2, n3, 0xED436B38 ^ 0xEDBC94C7);
        int n4 = fontRenderer.getStringWidth(string);
        fontRenderer.drawStringWithShadow(String.valueOf(n), n2 + n4, n3, this.\u0535(n));
    }

    private int \u0535(int n) {
        int n2;
        block24: {
            block25: {
                boolean bl;
                block32: {
                    block33: {
                        block30: {
                            block31: {
                                block28: {
                                    block29: {
                                        block26: {
                                            block27: {
                                                bl = oce6044968f8.\u0452;
                                                n2 = n;
                                                if (bl) break block24;
                                                if (n2 > (0x485F1F95 ^ 0x485F1F90)) break block25;
                                                n2 = n;
                                                if (bl) break block26;
                                                if (n2 != 1) break block27;
                                                return 0x48A0E06F ^ 0x485F1F90;
                                            }
                                            n2 = n;
                                        }
                                        if (bl) break block28;
                                        if (n2 != (0x485F1F92 ^ 0x485F1F90)) break block29;
                                        return 0x480AE06F ^ 0x485F1F90;
                                    }
                                    n2 = n;
                                }
                                if (bl) break block30;
                                if (n2 != (0x485F1F93 ^ 0x485F1F90)) break block31;
                                return 0x485FB53A ^ 0x485F1F90;
                            }
                            n2 = n;
                        }
                        if (bl) break block32;
                        if (n2 != (0x485F1F94 ^ 0x485F1F90)) break block33;
                        return 0x48F51F3A ^ 0x485F1F90;
                    }
                    n2 = n;
                }
                if (bl) break block24;
                if (n2 != (0x485F1F95 ^ 0x485F1F90)) break block25;
                return 0x48A0B590 ^ 0x485F1F90;
            }
            n2 = 0x48A04A6F ^ 0x485F1F90;
        }
        return n2;
    }

    static {
        String[] stringArray = new String[0xB251C9E1 ^ 0xB251C9E3];
        stringArray[0] = "Hearts";
        stringArray[1] = "Health";
        \u04c9 = stringArray;
        int[] nArray = new int[0xB251C9E0 ^ 0xB251C9E3];
        nArray[0] = 0;
        nArray[1] = 0xB251C9E4 ^ 0xB251C9E3;
        nArray[0xB251C9E1 ^ 0xB251C9E3] = 0xB251C9C1 ^ 0xB251C9E3;
        \u0153 = nArray;
        String[] stringArray2 = new String[0xB251C9E0 ^ 0xB251C9E3];
        stringArray2[0] = "P";
        stringArray2[1] = "T";
        stringArray2[0xB251C9E1 ^ 0xB251C9E3] = "U";
        \u051d = stringArray2;
        int[] nArray2 = new int[0xB251C9E0 ^ 0xB251C9E3];
        nArray2[0] = 0xB251C9F3 ^ 0xB251C9E3;
        nArray2[1] = 0xB251C9F7 ^ 0xB251C9E3;
        nArray2[0xB251C9E1 ^ 0xB251C9E3] = 0xB251C9F0 ^ 0xB251C9E3;
        \u00e7 = nArray2;
        String[] stringArray3 = new String[0xB251C9E0 ^ 0xB251C9E3];
        stringArray3[0] = "S";
        stringArray3[1] = "F";
        stringArray3[0xB251C9E1 ^ 0xB251C9E3] = "K";
        \u01fe = stringArray3;
        int[] nArray3 = new int[0xB251C9E0 ^ 0xB251C9E3];
        nArray3[0] = 0xB251C9D3 ^ 0xB251C9E3;
        nArray3[1] = 0xB251C9D2 ^ 0xB251C9E3;
        nArray3[0xB251C9E1 ^ 0xB251C9E3] = 0xB251C9D1 ^ 0xB251C9E3;
        \u04e4 = nArray3;
        String[] stringArray4 = new String[0xB251C9E0 ^ 0xB251C9E3];
        stringArray4[0] = "Pw";
        stringArray4[1] = "Pu";
        stringArray4[0xB251C9E1 ^ 0xB251C9E3] = "Fl";
        \u044a = stringArray4;
        int[] nArray4 = new int[0xB251C9E0 ^ 0xB251C9E3];
        nArray4[0] = 0xB251C9C3 ^ 0xB251C9E3;
        nArray4[1] = 0xB251C9C0 ^ 0xB251C9E3;
        nArray4[0xB251C9E1 ^ 0xB251C9E3] = 0xB251C9C1 ^ 0xB251C9E3;
        \u0445 = nArray4;
        String[] stringArray5 = new String[0xB251C9E0 ^ 0xB251C9E3];
        stringArray5[0] = "E";
        stringArray5[1] = "Fo";
        stringArray5[0xB251C9E1 ^ 0xB251C9E3] = "U";
        \u04d3 = stringArray5;
        \u01c6 = new int[]{0xB251C9F0 ^ 0xB251C9E3};
        \u00c0 = new String[]{"K"};
    }
}

