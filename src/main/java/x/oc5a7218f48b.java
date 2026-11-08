/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import x.oc2ec6a95e5c;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc920065c394;
import x.oca4f99d2d44;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.ocfa11b18c57;

public class oc5a7218f48b
extends oc69da1aa7f5 {
    private final oc2ec6a95e5c \u02e2;
    private final occ2f8dff8d8 \u01d6;
    private final occ2f8dff8d8 \u03b8;
    private final occ2f8dff8d8 \u0224;
    private final occ2f8dff8d8 \u0370;
    private final occ2f8dff8d8 \u04c4;
    private final occ2f8dff8d8 \u03d5;
    private final List<EntityPlayer> \u0295 = new ArrayList<EntityPlayer>();
    private final List<EntityPlayer> \u0274 = new ArrayList<EntityPlayer>();
    private boolean \u02af;
    public static int \u0396;

    public oc5a7218f48b() {
        super("MurderMystery", oce4cea752dd.\u0502);
        this.\u0105("Highlights murderers, bows and more...");
        this.\u02e2 = new oc2ec6a95e5c("Murder weapons");
        this.\u028c(this.\u02e2);
        this.\u0251(Items.iron_sword);
        this.\u0251(Items.stone_sword);
        this.\u0251(Items.iron_shovel);
        this.\u0251(Items.stick);
        this.\u0251(Items.wooden_axe);
        this.\u0251(Items.wooden_sword);
        this.\u0251(Items.stone_shovel);
        this.\u0251(Items.blaze_rod);
        this.\u0251(Items.diamond_shovel);
        this.\u0251(Items.quartz);
        this.\u0251(Items.pumpkin_pie);
        this.\u0251(Items.golden_pickaxe);
        this.\u0251(Items.apple);
        this.\u0251(Items.name_tag);
        this.\u0251(Items.carrot_on_a_stick);
        this.\u0251(Items.bone);
        this.\u0251(Items.carrot);
        this.\u0251(Items.golden_carrot);
        this.\u0251(Items.cookie);
        this.\u0251(Items.diamond_axe);
        this.\u0251(Items.prismarine_shard);
        this.\u0251(Items.cooked_beef);
        this.\u0251(Items.netherbrick);
        this.\u0251(Items.cooked_chicken);
        this.\u0251(Items.golden_sword);
        this.\u0251(Items.diamond_sword);
        this.\u0251(Items.diamond_hoe);
        this.\u0251(Items.shears);
        this.\u0251(Items.fish);
        this.\u0251(Items.dye);
        this.\u0251(Items.boat);
        this.\u0251(Items.speckled_melon);
        this.\u0251(Items.book);
        this.\u0251(Item.getItemFromBlock(Blocks.double_plant));
        this.\u0251(Item.getItemFromBlock(Blocks.sponge));
        this.\u0251(Item.getItemFromBlock(Blocks.deadbush));
        this.\u01d6 = new occ2f8dff8d8("Alert murderer", true);
        this.\u028c(this.\u01d6);
        this.\u03b8 = new occ2f8dff8d8("Highlight murderer", true);
        this.\u028c(this.\u03b8);
        this.\u0224 = new occ2f8dff8d8("Highlight bow", true);
        this.\u028c(this.\u0224);
        this.\u0370 = new occ2f8dff8d8("Highlight innocent", true);
        this.\u028c(this.\u0370);
        this.\u04c4 = new occ2f8dff8d8("Highlight dead", true);
        this.\u028c(this.\u04c4);
        this.\u03d5 = new occ2f8dff8d8("Gold ESP", true);
        this.\u028c(this.\u03d5);
    }

    @Override
    public void onDisable() {
        this.\u0115();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0244(oc746a23b244 oc746a23b2442) {
        block73: {
            Object object;
            int n;
            block71: {
                block74: {
                    oc5a7218f48b oc5a7218f48b2;
                    block75: {
                        boolean bl;
                        block72: {
                            n = ocfa11b18c57.\u0117;
                            bl = oc7ab2161b9f.\u00d0();
                            if (n != 0) break block72;
                            if (!bl) break block73;
                            oc5a7218f48b2 = this;
                            if (n != 0) break block74;
                            bl = oc5a7218f48b2.\u0296();
                        }
                        if (bl) break block75;
                        this.\u0115();
                        if (n == 0) break block73;
                    }
                    oc5a7218f48b2 = this;
                }
                oc5a7218f48b2.\u02af = false;
                for (EntityPlayer entityPlayer : oc69da1aa7f5.\u0151.theWorld.playerEntities) {
                    block77: {
                        int n2;
                        block94: {
                            oc5a7218f48b oc5a7218f48b3;
                            block93: {
                                occ2f8dff8d8 occ2f8dff8d82;
                                block92: {
                                    block88: {
                                        block91: {
                                            oc5a7218f48b oc5a7218f48b4;
                                            block89: {
                                                block90: {
                                                    EntityPlayer entityPlayer2;
                                                    List<EntityPlayer> list;
                                                    block85: {
                                                        block87: {
                                                            block86: {
                                                                int n3;
                                                                block84: {
                                                                    block83: {
                                                                        oc5a7218f48b oc5a7218f48b5;
                                                                        block80: {
                                                                            block81: {
                                                                                block82: {
                                                                                    EntityPlayer entityPlayer3;
                                                                                    block79: {
                                                                                        block78: {
                                                                                            block76: {
                                                                                                if (n != 0) break block71;
                                                                                                entityPlayer3 = entityPlayer;
                                                                                                if (n != 0) break block76;
                                                                                                if (entityPlayer3 == oc69da1aa7f5.\u0151.thePlayer) break block77;
                                                                                                entityPlayer3 = entityPlayer;
                                                                                            }
                                                                                            if (n != 0) break block78;
                                                                                            if (entityPlayer3.isInvisible()) break block77;
                                                                                            entityPlayer3 = entityPlayer;
                                                                                        }
                                                                                        if (n == 0) {
                                                                                            if (oca4f99d2d44.\u039b(entityPlayer3) && !this.\u04c4.\u01ed() && n == 0) continue;
                                                                                            entityPlayer3 = entityPlayer;
                                                                                        }
                                                                                        if (n != 0) break block79;
                                                                                        if (entityPlayer3.getHeldItem() == null) break block80;
                                                                                        entityPlayer3 = entityPlayer;
                                                                                    }
                                                                                    ItemStack itemStack = entityPlayer3.getHeldItem();
                                                                                    object = itemStack.getItem();
                                                                                    n3 = this.\u02e2.b(itemStack) ? 1 : 0;
                                                                                    if (n != 0) break block81;
                                                                                    if (n3 == 0) break block82;
                                                                                    oc5a7218f48b5 = this;
                                                                                    if (n != 0) break block83;
                                                                                    if (oc5a7218f48b5.\u0295.contains(entityPlayer)) break block80;
                                                                                    this.\u0295.add(entityPlayer);
                                                                                    oc5a7218f48b5 = this;
                                                                                    if (n != 0) break block83;
                                                                                    if (!oc5a7218f48b5.\u01d6.\u01ed()) break block80;
                                                                                    oc69da1aa7f5.\u0151.thePlayer.playSound("note.pling", 1.0f, 1.0f);
                                                                                    oc7ab2161b9f.\u00fd("&eAlert: &b" + entityPlayer.getName() + " &7is the &cmurderer&7! (&d" + (int)oc69da1aa7f5.\u0151.thePlayer.getDistanceToEntity(entityPlayer) + "m&7)");
                                                                                    if (n == 0) break block80;
                                                                                }
                                                                                n3 = object instanceof ItemBow;
                                                                            }
                                                                            if (n != 0) break block84;
                                                                            if (n3 == 0) break block80;
                                                                            oc5a7218f48b5 = this;
                                                                            if (n != 0) break block83;
                                                                            if (!oc5a7218f48b5.\u0224.\u01ed()) break block80;
                                                                            oc5a7218f48b5 = this;
                                                                            if (n != 0) break block83;
                                                                            if (!oc5a7218f48b5.\u0274.contains(entityPlayer)) {
                                                                                this.\u0274.add(entityPlayer);
                                                                            }
                                                                        }
                                                                        oc5a7218f48b5 = this;
                                                                    }
                                                                    oc5a7218f48b5.\u02af = true;
                                                                    n3 = Color.green.getRGB();
                                                                }
                                                                n2 = n3;
                                                                list = this.\u0295;
                                                                entityPlayer2 = entityPlayer;
                                                                if (n != 0) break block85;
                                                                if (!list.contains(entityPlayer2)) break block86;
                                                                oc5a7218f48b4 = this;
                                                                if (n != 0) break block87;
                                                                if (!oc5a7218f48b4.\u03b8.\u01ed()) break block86;
                                                                n2 = Color.red.getRGB();
                                                                if (n == 0) break block88;
                                                            }
                                                            oc5a7218f48b4 = this;
                                                        }
                                                        if (n != 0) break block89;
                                                        list = oc5a7218f48b4.\u0274;
                                                        entityPlayer2 = entityPlayer;
                                                    }
                                                    if (!list.contains(entityPlayer2)) break block90;
                                                    occ2f8dff8d82 = this.\u0224;
                                                    if (n != 0) break block91;
                                                    if (!occ2f8dff8d82.\u01ed()) break block90;
                                                    n2 = Color.orange.getRGB();
                                                    if (n == 0) break block88;
                                                }
                                                oc5a7218f48b4 = this;
                                            }
                                            occ2f8dff8d82 = oc5a7218f48b4.\u0370;
                                        }
                                        if (n == 0) {
                                            if (!occ2f8dff8d82.\u01ed() && n == 0) continue;
                                        }
                                        break block92;
                                    }
                                    oc5a7218f48b3 = this;
                                    if (n != 0) break block93;
                                    occ2f8dff8d82 = oc5a7218f48b3.\u04c4;
                                }
                                if (occ2f8dff8d82.\u01ed()) break block94;
                                oc5a7218f48b3 = this;
                            }
                            if (oc5a7218f48b3.\u054f(entityPlayer) <= 0.009 && n == 0) continue;
                        }
                        ocbd4917c4b1.\u01a8(entityPlayer, 0x2B5A78A5 ^ 0x2B5A78A7, 0.0, 0.0, n2, false);
                    }
                    if (n == 0) continue;
                }
                if (!this.\u03d5.\u01ed()) {
                    return;
                }
            }
            float f = oc69da1aa7f5.\u0151.getTimer().renderPartialTicks;
            int n4 = 0xD4A088EE ^ 0x2B5A78A7;
            Iterator iterator2 = oc69da1aa7f5.\u0151.theWorld.loadedEntityList.iterator();
            while (iterator2.hasNext()) {
                block96: {
                    Item item;
                    EntityItem entityItem;
                    Object object2;
                    block95: {
                        object2 = object = (Entity)iterator2.next();
                        if (n != 0) break block95;
                        if (!(object2 instanceof EntityItem)) break block96;
                        object2 = object;
                    }
                    if (n == 0) {
                        if (((Entity)object2).ticksExisted < (0x2B5A78A4 ^ 0x2B5A78A7) && n == 0) continue;
                        object2 = object;
                    }
                    EntityItem entityItem2 = entityItem = (EntityItem)object2;
                    if (n == 0) {
                        if (entityItem2.getEntityItem().stackSize == 0 && n == 0) continue;
                        entityItem2 = entityItem;
                    }
                    Item item2 = item = entityItem2.getEntityItem().getItem();
                    if (n == 0) {
                        if (item2 == null) continue;
                        item2 = item;
                    }
                    if (item2 != Items.gold_ingot && n == 0) continue;
                    double d = ((Entity)object).lastTickPosX + (((Entity)object).posX - ((Entity)object).lastTickPosX) * (double)f;
                    double d2 = ((Entity)object).lastTickPosY + (((Entity)object).posY - ((Entity)object).lastTickPosY) * (double)f;
                    double d3 = ((Entity)object).lastTickPosZ + (((Entity)object).posZ - ((Entity)object).lastTickPosZ) * (double)f;
                    double d4 = oc69da1aa7f5.\u0151.thePlayer.lastTickPosX + (oc69da1aa7f5.\u0151.thePlayer.posX - oc69da1aa7f5.\u0151.thePlayer.lastTickPosX) * (double)f - d;
                    double d5 = oc69da1aa7f5.\u0151.thePlayer.lastTickPosY + (oc69da1aa7f5.\u0151.thePlayer.posY - oc69da1aa7f5.\u0151.thePlayer.lastTickPosY) * (double)f - d2;
                    double d6 = oc69da1aa7f5.\u0151.thePlayer.lastTickPosZ + (oc69da1aa7f5.\u0151.thePlayer.posZ - oc69da1aa7f5.\u0151.thePlayer.lastTickPosZ) * (double)f - d3;
                    GlStateManager.pushMatrix();
                    this.\u01a8(n4, d, d2, d3, MathHelper.sqrt_double(d4 * d4 + d5 * d5 + d6 * d6));
                    GlStateManager.popMatrix();
                }
                if (n == 0) continue;
            }
        }
    }

    public void \u01a8(int n, double d, double d2, double d3, double d4) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    d -= oc69da1aa7f5.\u0151.getRenderManager().viewerPosX;
                    d2 -= oc69da1aa7f5.\u0151.getRenderManager().viewerPosY;
                    d3 -= oc69da1aa7f5.\u0151.getRenderManager().viewerPosZ;
                    GL11.glPushMatrix();
                    GL11.glBlendFunc(0x796CEF13 ^ 0x796CEC11, 0x796CEF12 ^ 0x796CEC11);
                    GL11.glEnable(0x796CE7F3 ^ 0x796CEC11);
                    GL11.glLineWidth(2.0f);
                    GL11.glDisable(0x796CE1F0 ^ 0x796CEC11);
                    GL11.glDisable(0x796CE760 ^ 0x796CEC11);
                    GL11.glDepthMask(false);
                    int n2 = ocfa11b18c57.\u0117;
                    float f = (float)(n >> (0x796CEC01 ^ 0x796CEC11) & (0x796CECEE ^ 0x796CEC11)) / 255.0f;
                    float f2 = (float)(n >> (0x796CEC19 ^ 0x796CEC11) & (0x796CECEE ^ 0x796CEC11)) / 255.0f;
                    float f3 = (float)(n & (0x796CECEE ^ 0x796CEC11)) / 255.0f;
                    float f4 = Math.min(Math.max(0.2f, (float)((double)0.01f * d4)), 0.4f);
                    ocbd4917c4b1.\u0293(new AxisAlignedBB(d - (double)f4, d2, d3 - (double)f4, d + (double)f4, d2 + (double)(f4 * 2.0f), d3 + (double)f4), f, f2, f3, 0.35f);
                    GL11.glEnable(0x796CE1F0 ^ 0x796CEC11);
                    GL11.glEnable(0x796CE760 ^ 0x796CEC11);
                    GL11.glDepthMask(true);
                    GL11.glDisable(0x796CE7F3 ^ 0x796CEC11);
                    GL11.glPopMatrix();
                    if (n2 == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u0296() {
        boolean bl;
        int n;
        block31: {
            String string;
            block30: {
                Scoreboard scoreboard;
                block28: {
                    block29: {
                        Minecraft minecraft;
                        block27: {
                            n = ocfa11b18c57.\u0117;
                            bl = oc7ab2161b9f.\u054f();
                            if (n != 0) return bl;
                            if (!bl) return false;
                            minecraft = oc69da1aa7f5.\u0151;
                            if (n != 0) break block27;
                            if (minecraft.thePlayer.getWorldScoreboard() == null) return false;
                            minecraft = oc69da1aa7f5.\u0151;
                        }
                        scoreboard = minecraft.thePlayer.getWorldScoreboard();
                        if (n != 0) break block28;
                        if (scoreboard.getObjectiveInDisplaySlot(1) != null) break block29;
                        return false;
                    }
                    scoreboard = oc69da1aa7f5.\u0151.thePlayer.getWorldScoreboard();
                }
                String string2 = scoreboard.getObjectiveInDisplaySlot(1).getDisplayName();
                string = string2;
                if (n != 0) break block30;
                if (string.contains("MURDER")) break block31;
                string = string2;
            }
            boolean bl2 = string.contains("MYSTERY");
            if (n != 0) return bl2;
            if (bl2) break block31;
            return false;
        }
        Iterator<String> iterator2 = oc7ab2161b9f.\u00f0().iterator();
        do {
            boolean bl3;
            if (!iterator2.hasNext()) return false;
            String string = iterator2.next();
            String string3 = oc7ab2161b9f.\u045b(string);
            bl = string3.contains("Role:");
            if (n != 0) return bl;
            if (n != 0) return bl3;
            if (bl) return true;
            bl3 = string3.contains("Innocents Left:");
            if (n != 0) return bl3;
            if (!bl3) continue;
            return true;
        } while (n == 0);
        return false;
    }

    public boolean \u00ff() {
        boolean bl;
        block13: {
            block11: {
                oc5a7218f48b oc5a7218f48b2;
                int n;
                block12: {
                    List<EntityPlayer> list;
                    block10: {
                        n = ocfa11b18c57.\u0117;
                        list = this.\u0295;
                        if (n != 0) break block10;
                        if (!list.isEmpty()) break block11;
                        oc5a7218f48b2 = this;
                        if (n != 0) break block12;
                        list = oc5a7218f48b2.\u0274;
                    }
                    if (!list.isEmpty()) break block11;
                    oc5a7218f48b2 = this;
                }
                bl = oc5a7218f48b2.\u02af;
                if (n != 0) break block13;
                if (bl) break block11;
                bl = true;
                break block13;
            }
            bl = false;
        }
        return bl;
    }

    private void \u0115() {
        this.\u02af = false;
        this.\u0295.clear();
        this.\u0274.clear();
    }

    private double \u054f(Entity entity) {
        AxisAlignedBB axisAlignedBB;
        AxisAlignedBB axisAlignedBB2;
        block4: {
            block5: {
                axisAlignedBB2 = entity.getEntityBoundingBox();
                int n = ocfa11b18c57.\u0117;
                axisAlignedBB = axisAlignedBB2;
                if (n != 0) break block4;
                if (axisAlignedBB != null) break block5;
                return 0.0;
            }
            axisAlignedBB = axisAlignedBB2;
        }
        double d = axisAlignedBB.maxX - axisAlignedBB2.minX;
        double d2 = axisAlignedBB2.maxZ - axisAlignedBB2.minZ;
        double d3 = axisAlignedBB2.maxY - axisAlignedBB2.minY;
        return d * d2 * d3;
    }

    private void \u0251(Item item) {
        Item item2;
        block7: {
            block8: {
                int n = ocfa11b18c57.\u0117;
                item2 = item;
                if (n != 0) break block7;
                if (item2 != null) break block8;
                return;
            }
            item2 = item;
        }
        String string = oc920065c394.\u0185(item2);
        if (string == null) {
            return;
        }
        oc2ec6a95e5c oc2ec6a95e5c2 = this.\u02e2;
        Object object = oc920065c394.\u054b(item) ? string + ":*" : string;
        oc2ec6a95e5c2.z$1nw3rcgnkegzj((String)object);
    }
}

