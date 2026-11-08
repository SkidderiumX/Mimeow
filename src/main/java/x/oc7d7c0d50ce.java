/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import x.oc32fdd3a6bd;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc71f0695a70;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oca26bed83cb;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc7d7c0d50ce
extends oc69da1aa7f5 {
    private final oca9cc61aada n;
    private final occ2f8dff8d8 \u040c;
    private final occ2f8dff8d8 \u019f;
    private final occ2f8dff8d8 \u046c;
    private final occ2f8dff8d8 \u03e7;
    private final occ2f8dff8d8 \u018c;
    private final occ2f8dff8d8 \u0492;
    private final occ2f8dff8d8 \u048a;
    public static boolean \u0115;

    public oc7d7c0d50ce() {
        super("ItemESP", oce4cea752dd.\u014e);
        this.\u0105("Highlights dropped items.");
        this.n = new oca9cc61aada("opacity", "%", 25.0, 0.0, 100.0, 1.0);
        this.\u028c(this.n);
        this.\u040c = new occ2f8dff8d8("outline", false);
        this.\u028c(this.\u040c);
        this.\u019f = new occ2f8dff8d8("item-count", true);
        this.\u028c(this.\u019f);
        this.\u046c = new occ2f8dff8d8("auto-scale", true);
        this.\u028c(this.\u046c);
        this.\u03e7 = new occ2f8dff8d8("emeralds", true);
        this.\u028c(this.\u03e7);
        this.\u018c = new occ2f8dff8d8("diamonds", true);
        this.\u028c(this.\u018c);
        this.\u0492 = new occ2f8dff8d8("gold", true, "Render gold");
        this.\u028c(this.\u0492);
        this.\u048a = new occ2f8dff8d8("iron", true, "Render iron");
        this.\u028c(this.\u048a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u026b(oc746a23b244 oc746a23b2442) {
        Minecraft minecraft;
        boolean bl;
        block10: {
            bl = oce6044968f8.\u0452;
            if (!oc7ab2161b9f.\u00d0()) return;
            minecraft = oc69da1aa7f5.\u0151;
            if (bl) break block10;
            if (minecraft.theWorld == null) return;
            minecraft = oc69da1aa7f5.\u0151;
        }
        if (minecraft.getRenderViewEntity() == null) {
            return;
        }
        Map<oca26bed83cb, Integer> map = this.\u03a0(oc746a23b2442.\u0401);
        ArrayList<Map.Entry<oca26bed83cb, Integer>> arrayList = new ArrayList<Map.Entry<oca26bed83cb, Integer>>(map.entrySet());
        arrayList.sort(Comparator.comparingInt(entry -> oc7d7c0d50ce.\u00fe(((oca26bed83cb)entry.getKey()).V)));
        for (Map.Entry entry2 : arrayList) {
            this.\u0210((oca26bed83cb)entry2.getKey(), (Integer)entry2.getValue());
            if (!bl) continue;
        }
    }

    private Map<oca26bed83cb, Integer> \u03a0(float f) {
        LinkedHashMap<oca26bed83cb, Integer> linkedHashMap = new LinkedHashMap<oca26bed83cb, Integer>();
        Iterator<Entity> iterator2 = this.\u018e().iterator();
        boolean bl = oce6044968f8.\u0452;
        while (iterator2.hasNext()) {
            int n;
            ItemStack itemStack;
            EntityItem entityItem;
            block24: {
                ItemStack itemStack2;
                block23: {
                    Entity entity;
                    block21: {
                        Entity entity2;
                        block22: {
                            block20: {
                                block19: {
                                    entity2 = iterator2.next();
                                    entity = entity2;
                                    if (bl) break block19;
                                    if (!(entity instanceof EntityItem)) continue;
                                    entity = entity2;
                                }
                                if (bl) break block20;
                                if (entity.ticksExisted < (0x4D5B58B3 ^ 0x4D5B58B0)) continue;
                                entity = entity2;
                            }
                            if (bl) break block21;
                            if (entity.ignoreFrustumCheck) break block22;
                            entity = entity2;
                            if (bl) break block21;
                            if (ocbd4917c4b1.\u04e5(entity.getEntityBoundingBox().expand(0.125, 0.125, 0.125))) break block22;
                            if (!bl) continue;
                        }
                        entity = entity2;
                    }
                    entityItem = (EntityItem)entity;
                    itemStack = entityItem.getEntityItem();
                    itemStack2 = itemStack;
                    if (bl) break block23;
                    if (itemStack2 == null) continue;
                    itemStack2 = itemStack;
                }
                n = itemStack2.stackSize;
                if (bl) break block24;
                if (n <= 0) continue;
                n = this.\u0407(itemStack.getItem()) ? 1 : 0;
            }
            if (n == 0 && !bl) continue;
            double d = ocbd4917c4b1.\u0137(entityItem.posX, entityItem.lastTickPosX, f);
            double d2 = ocbd4917c4b1.\u0137(entityItem.posY, entityItem.lastTickPosY, f);
            double d3 = ocbd4917c4b1.\u0137(entityItem.posZ, entityItem.lastTickPosZ, f);
            oca26bed83cb oca26bed83cb2 = new oca26bed83cb(Item.getIdFromItem(itemStack.getItem()), d, d2, d3);
            linkedHashMap.merge(oca26bed83cb2, itemStack.stackSize, Integer::sum);
            if (!bl) continue;
        }
        return linkedHashMap;
    }

    private List<Entity> \u018e() {
        ArrayList<Entity> arrayList = new ArrayList<Entity>(oc69da1aa7f5.\u0151.theWorld.loadedEntityList);
        arrayList.sort((entity, entity2) -> {
            int n;
            block2: {
                block3: {
                    double d = oc69da1aa7f5.\u0151.getRenderManager().getDistanceToCamera(entity.posX, entity.posY, entity.posZ);
                    boolean bl = oce6044968f8.\u0452;
                    double d2 = oc69da1aa7f5.\u0151.getRenderManager().getDistanceToCamera(entity2.posX, entity2.posY, entity2.posZ);
                    int n2 = Double.compare(d2, d);
                    n = n2;
                    if (bl) break block2;
                    if (n == 0) break block3;
                    n = n2;
                    break block2;
                }
                n = entity.getUniqueID().toString().compareTo(entity2.getUniqueID().toString());
            }
            return n;
        });
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean \u0407(Item item) {
        oc32fdd3a6bd oc32fdd3a6bd2 = oc7d7c0d50ce.\u03b7(item);
        boolean bl = oce6044968f8.\u0452;
        if (oc32fdd3a6bd2 == null) {
            return false;
        }
        boolean bl2 = oc71f0695a70.\u0197[oc32fdd3a6bd2.ordinal()];
        if (bl) return bl2;
        switch (bl2) {
            case 1: {
                return this.\u03e7.\u01ed();
            }
            case 2: {
                return this.\u018c.\u01ed();
            }
            case 3: {
                return this.\u0492.\u01ed();
            }
            case 4: {
                return this.\u048a.\u01ed();
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0210(oca26bed83cb oca26bed83cb2, int n) {
        block18: {
            oc7d7c0d50ce oc7d7c0d50ce2;
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            block17: {
                boolean bl;
                block14: {
                    int n2 = oc7d7c0d50ce.\u0541(oca26bed83cb2.V);
                    int n3 = n2 >> (0xB9A00F2E ^ 0xB9A00F3E) & (0xB9A00FC1 ^ 0xB9A00F3E);
                    int n4 = n2 >> (0xB9A00F36 ^ 0xB9A00F3E) & (0xB9A00FC1 ^ 0xB9A00F3E);
                    bl = oce6044968f8.\u0452;
                    int n5 = n2 & (0xB9A00FC1 ^ 0xB9A00F3E);
                    d5 = oca26bed83cb2.\u0454 - oc69da1aa7f5.\u0151.getRenderManager().viewerPosX;
                    d4 = oca26bed83cb2.\u0402 - oc69da1aa7f5.\u0151.getRenderManager().viewerPosY;
                    d3 = oca26bed83cb2.\u03b0 - oc69da1aa7f5.\u0151.getRenderManager().viewerPosZ;
                    d2 = oc69da1aa7f5.\u0151.getRenderViewEntity().getDistance(oca26bed83cb2.\u0454, oca26bed83cb2.\u0402, oca26bed83cb2.\u03b0);
                    d = oc7d7c0d50ce.\u04f4(d2, this.\u046c.\u01ed());
                    AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d5 - d * 0.5, d4, d3 - d * 0.5, d5 + d * 0.5, d4 + d, d3 + d * 0.5);
                    ocbd4917c4b1.\u0404();
                    try {
                        oc7d7c0d50ce oc7d7c0d50ce3;
                        block16: {
                            int n6;
                            block15: {
                                int n7;
                                n6 = n7 = (int)(this.n.\u04c1() * 255.0 / 100.0);
                                if (bl) break block15;
                                if (n6 > 0) {
                                    ocbd4917c4b1.\u03f4(axisAlignedBB, n3, n4, n5, n7);
                                }
                                oc7d7c0d50ce3 = this;
                                if (bl) break block16;
                                n6 = oc7d7c0d50ce3.\u040c.\u01ed() ? 1 : 0;
                            }
                            if (n6 == 0) break block14;
                            oc7d7c0d50ce3 = this;
                        }
                        oc7d7c0d50ce3.\u0520(axisAlignedBB, n3, n4, n5);
                    }
                    finally {
                        GlStateManager.resetColor();
                        ocbd4917c4b1.\u04cb();
                    }
                }
                oc7d7c0d50ce2 = this;
                if (bl) break block17;
                if (!oc7d7c0d50ce2.\u019f.\u01ed()) break block18;
                oc7d7c0d50ce2 = this;
            }
            oc7d7c0d50ce2.\u00e6(n, d5, d4, d3, d2, d);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void \u0520(AxisAlignedBB axisAlignedBB, int n, int n2, int n3) {
        GL11.glLineWidth(1.5f);
        GL11.glEnable(0x68099293 ^ 0x680999B3);
        GL11.glHint(0x680995E1 ^ 0x680999B3, 0x680988B1 ^ 0x680999B3);
        try {
            RenderGlobal.drawOutlinedBoundingBox(axisAlignedBB, n, n2, n3, 0x6809994C ^ 0x680999B3);
        }
        finally {
            GL11.glDisable(0x68099293 ^ 0x680999B3);
            GL11.glLineWidth(1.0f);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u00e6(int n, double d, double d2, double d3, double d4, double d5) {
        GlStateManager.pushMatrix();
        boolean bl = oce6044968f8.\u0452;
        try {
            GlStateManager.translate(d, d2 + d5 * 0.5, d3);
            float f = oc69da1aa7f5.\u0151.getRenderManager().playerViewY;
            if (!bl) {
                GlStateManager.rotate(-f, 0.0f, 1.0f, 0.0f);
                f = oc69da1aa7f5.\u0151.gameSettings.thirdPersonView == (0x6C76BD8C ^ 0x6C76BD8E) ? -1.0f : 1.0f;
            }
            float f2 = f;
            GlStateManager.rotate(oc69da1aa7f5.\u0151.getRenderManager().playerViewX, f2, 0.0f, 0.0f);
            double d6 = oc7d7c0d50ce.\u0249(d4, this.\u046c.\u01ed());
            GlStateManager.scale(d6, d6, 1.0);
            GlStateManager.disableDepth();
            String string = Integer.toString(n);
            float f3 = (float)(-oc69da1aa7f5.\u0151.fontRendererObj.getStringWidth(string)) * 0.5f + 0.5f;
            float f4 = (float)(-oc69da1aa7f5.\u0151.fontRendererObj.FONT_HEIGHT) * 0.5f + 0.5f;
            this.\u01db(string, f3, f4);
            return;
        }
        finally {
            GlStateManager.enableDepth();
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
    }

    private void \u01db(String string, float f, float f2) {
        oc69da1aa7f5.\u0151.fontRendererObj.drawString(string, f + 1.0f, f2, 0, false);
        oc69da1aa7f5.\u0151.fontRendererObj.drawString(string, f - 1.0f, f2, 0, false);
        oc69da1aa7f5.\u0151.fontRendererObj.drawString(string, f, f2 + 1.0f, 0, false);
        oc69da1aa7f5.\u0151.fontRendererObj.drawString(string, f, f2 - 1.0f, 0, false);
        oc69da1aa7f5.\u0151.fontRendererObj.drawString(string, f, f2, -1, false);
    }

    static double \u04f4(double d, boolean bl) {
        double d2 = 6.0;
        double d3 = bl ? d : 6.0;
        double d4 = Math.max(d2, d3);
        return 0.5 + 0.375 * ((d4 - 6.0) / 28.0);
    }

    static double \u0249(double d, boolean bl) {
        double d2 = 6.0;
        double d3 = bl ? d : 6.0;
        double d4 = Math.max(d2, d3);
        return -0.04375 - 0.0328125 * ((d4 - 6.0) / 28.0);
    }

    static int \u00fe(int n) {
        int n2;
        block6: {
            oc32fdd3a6bd oc32fdd3a6bd2;
            block4: {
                oc32fdd3a6bd oc32fdd3a6bd3;
                block5: {
                    oc32fdd3a6bd3 = oc7d7c0d50ce.\u03b7(Item.getItemById(n));
                    boolean bl = oce6044968f8.\u0452;
                    oc32fdd3a6bd2 = oc32fdd3a6bd3;
                    if (bl) break block4;
                    if (oc32fdd3a6bd2 != null) break block5;
                    n2 = 0;
                    break block6;
                }
                oc32fdd3a6bd2 = oc32fdd3a6bd3;
            }
            n2 = oc32fdd3a6bd2.\u023c;
        }
        return n2;
    }

    static int \u0541(int n) {
        int n2;
        block6: {
            oc32fdd3a6bd oc32fdd3a6bd2;
            block4: {
                oc32fdd3a6bd oc32fdd3a6bd3;
                block5: {
                    oc32fdd3a6bd3 = oc7d7c0d50ce.\u03b7(Item.getItemById(n));
                    boolean bl = oce6044968f8.\u0452;
                    oc32fdd3a6bd2 = oc32fdd3a6bd3;
                    if (bl) break block4;
                    if (oc32fdd3a6bd2 != null) break block5;
                    n2 = 0xF1401831 ^ 0xEEAB29B;
                    break block6;
                }
                oc32fdd3a6bd2 = oc32fdd3a6bd3;
            }
            n2 = oc32fdd3a6bd2.\u04d8;
        }
        return n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static oc32fdd3a6bd \u03b7(Item item) {
        Block block;
        block99: {
            Block block2;
            Block block3;
            boolean bl;
            block98: {
                Item item2;
                block97: {
                    block96: {
                        Block block4;
                        block95: {
                            Item item3;
                            block94: {
                                block93: {
                                    block92: {
                                        block91: {
                                            block90: {
                                                block89: {
                                                    block88: {
                                                        block87: {
                                                            block86: {
                                                                Block block5;
                                                                block85: {
                                                                    Item item4;
                                                                    block83: {
                                                                        block84: {
                                                                            bl = oce6044968f8.\u0452;
                                                                            item4 = item;
                                                                            if (bl) break block83;
                                                                            if (item4 != null) break block84;
                                                                            return null;
                                                                        }
                                                                        item4 = item;
                                                                    }
                                                                    block3 = Block.getBlockFromItem(item4);
                                                                    if (item == Items.emerald) return oc32fdd3a6bd.\u01be;
                                                                    block5 = block3;
                                                                    if (bl) break block85;
                                                                    if (block5 == Blocks.emerald_block) return oc32fdd3a6bd.\u01be;
                                                                    block5 = block3;
                                                                }
                                                                if (block5 == Blocks.emerald_ore) {
                                                                    return oc32fdd3a6bd.\u01be;
                                                                }
                                                                item3 = item;
                                                                if (bl) break block86;
                                                                if (item3 == Items.diamond) return oc32fdd3a6bd.\u054c;
                                                                item3 = item;
                                                            }
                                                            if (bl) break block87;
                                                            if (item3 == Items.diamond_sword) return oc32fdd3a6bd.\u054c;
                                                            item3 = item;
                                                        }
                                                        if (bl) break block88;
                                                        if (item3 == Items.diamond_pickaxe) return oc32fdd3a6bd.\u054c;
                                                        item3 = item;
                                                    }
                                                    if (bl) break block89;
                                                    if (item3 == Items.diamond_shovel) return oc32fdd3a6bd.\u054c;
                                                    item3 = item;
                                                }
                                                if (bl) break block90;
                                                if (item3 == Items.diamond_axe) return oc32fdd3a6bd.\u054c;
                                                item3 = item;
                                            }
                                            if (bl) break block91;
                                            if (item3 == Items.diamond_hoe) return oc32fdd3a6bd.\u054c;
                                            item3 = item;
                                        }
                                        if (bl) break block92;
                                        if (item3 == Items.diamond_helmet) return oc32fdd3a6bd.\u054c;
                                        item3 = item;
                                    }
                                    if (bl) break block93;
                                    if (item3 == Items.diamond_chestplate) return oc32fdd3a6bd.\u054c;
                                    item3 = item;
                                }
                                if (bl) break block94;
                                if (item3 == Items.diamond_leggings) return oc32fdd3a6bd.\u054c;
                                item3 = item;
                            }
                            if (item3 == Items.diamond_boots) return oc32fdd3a6bd.\u054c;
                            block4 = block3;
                            if (bl) break block95;
                            if (block4 == Blocks.diamond_block) return oc32fdd3a6bd.\u054c;
                            block4 = block3;
                        }
                        if (block4 == Blocks.diamond_ore) {
                            return oc32fdd3a6bd.\u054c;
                        }
                        item2 = item;
                        if (bl) break block96;
                        if (item2 == Items.gold_ingot) return oc32fdd3a6bd.\u03a9;
                        item2 = item;
                    }
                    if (bl) break block97;
                    if (item2 == Items.gold_nugget) return oc32fdd3a6bd.\u03a9;
                    item2 = item;
                }
                if (item2 == Items.golden_apple) return oc32fdd3a6bd.\u03a9;
                block2 = block3;
                if (bl) break block98;
                if (block2 == Blocks.gold_block) return oc32fdd3a6bd.\u03a9;
                block2 = block3;
            }
            if (block2 == Blocks.gold_ore) {
                return oc32fdd3a6bd.\u03a9;
            }
            if (item == Items.iron_ingot) return oc32fdd3a6bd.\u01dd;
            block = block3;
            if (bl) break block99;
            if (block == Blocks.iron_block) return oc32fdd3a6bd.\u01dd;
            block = block3;
        }
        if (block != Blocks.iron_ore) return null;
        return oc32fdd3a6bd.\u01dd;
    }
}

