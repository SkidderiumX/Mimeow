/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import x.oc110d7f376c;
import x.oc24a0a5bddf;
import x.oc2cf3d80e17;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc9adb807c19;
import x.oca4f99d2d44;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc85c49d5af7
extends oc69da1aa7f5 {
    public occ2f8dff8d8 \u01f3;
    public oc24a0a5bddf \u040f;
    public occ2f8dff8d8 \u0215;
    public oca9cc61aada \u02aa;
    private boolean \u018e;
    private final ArrayList<Entity> e = new ArrayList();
    private int \u025b = 0;
    public static boolean \u0156;

    public oc85c49d5af7() {
        super("Tracers", oce4cea752dd.\u014e);
        this.\u01f3 = new occ2f8dff8d8("Show invis", true);
        this.\u028c(this.\u01f3);
        this.\u02aa = new oca9cc61aada("Line Width", 1.0, 1.0, 5.0, 1.0);
        this.\u028c(this.\u02aa);
        this.\u040f = new oc24a0a5bddf("Color", 0, 0x12574D4A ^ 0x12574DB5, 0);
        this.\u028c(this.\u040f);
        this.\u0215 = new occ2f8dff8d8("Rainbow", false);
        this.\u028c(this.\u0215);
    }

    @Override
    public void onEnable() {
        this.\u018e = oc69da1aa7f5.\u0151.gameSettings.viewBobbing;
        if (this.\u018e) {
            oc69da1aa7f5.\u0151.gameSettings.viewBobbing = false;
        }
    }

    @Override
    public void onDisable() {
        oc69da1aa7f5.\u0151.gameSettings.viewBobbing = this.\u018e;
        this.\u0171();
    }

    @Override
    public void z$1m9j3ewef9s() {
        block5: {
            block4: {
                boolean bl = oce6044968f8.\u0452;
                Minecraft minecraft = oc69da1aa7f5.\u0151;
                if (bl) break block4;
                if (!minecraft.gameSettings.viewBobbing) break block5;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.gameSettings.viewBobbing = false;
        }
    }

    @oc66fa4f2195
    public void \u0269(oc9adb807c19 oc9adb807c192) {
        if (oc9adb807c192.\u04b0 != oc110d7f376c.END) {
            return;
        }
        this.\u0194();
    }

    @oc66fa4f2195
    public void \u03fa(oc746a23b244 oc746a23b2442) {
        int n;
        boolean bl;
        block24: {
            oc85c49d5af7 oc85c49d5af72;
            block22: {
                block23: {
                    block21: {
                        block27: {
                            block20: {
                                int n2;
                                block19: {
                                    bl = oce6044968f8.\u0452;
                                    n2 = oc7ab2161b9f.\u00d0();
                                    if (bl) break block19;
                                    if (n2 == 0) break block20;
                                    oc85c49d5af72 = this;
                                    if (bl) break block21;
                                    n2 = oc85c49d5af72.\u025b;
                                }
                                if (n2 != 0) break block27;
                            }
                            return;
                        }
                        oc85c49d5af72 = this;
                    }
                    if (bl) break block22;
                    if (!oc85c49d5af72.\u0215.\u01ed()) break block23;
                    n = oc7ab2161b9f.\u01be(0x8E2C3022E7F480EL ^ 0x8E2C3022E7F480CL, 0L);
                    break block24;
                }
                oc85c49d5af72 = this;
            }
            n = oc85c49d5af72.\u040f.\u0373();
        }
        int n3 = n;
        for (int i = 0; i < this.\u025b; ++i) {
            Entity entity;
            block25: {
                Entity entity2;
                block26: {
                    entity2 = this.e.get(i);
                    entity = entity2;
                    if (bl) break block25;
                    if (entity != null) break block26;
                    if (!bl) continue;
                }
                entity = entity2;
            }
            ocbd4917c4b1.\u029f(entity, n3, (float)this.\u02aa.\u04c1(), oc746a23b2442.\u0401);
            if (!bl) continue;
        }
    }

    private void \u0194() {
        boolean bl;
        block36: {
            oc85c49d5af7 oc85c49d5af72;
            block34: {
                block35: {
                    bl = oce6044968f8.\u0452;
                    oc85c49d5af72 = this;
                    if (bl) break block34;
                    oc85c49d5af72.\u025b = 0;
                    if (!oc7ab2161b9f.\u00d0()) break block35;
                    if (oc69da1aa7f5.\u0151.theWorld != null) break block36;
                }
                oc85c49d5af72 = this;
            }
            oc85c49d5af72.e.clear();
            return;
        }
        if (oc2cf3d80e17.\u0125) {
            for (Entity entity : oc69da1aa7f5.\u0151.theWorld.loadedEntityList) {
                block38: {
                    Entity entity2;
                    block37: {
                        entity2 = entity;
                        if (bl) break block37;
                        if (!(entity2 instanceof EntityLivingBase)) break block38;
                        entity2 = entity;
                    }
                    if (entity2 != oc69da1aa7f5.\u0151.thePlayer) {
                        this.\u023d(entity);
                    }
                }
                if (!bl) continue;
            }
            return;
        }
        for (EntityPlayer entityPlayer : oc69da1aa7f5.\u0151.theWorld.playerEntities) {
            int n;
            block43: {
                EntityPlayer entityPlayer2;
                block45: {
                    block44: {
                        block41: {
                            block42: {
                                EntityPlayer entityPlayer3;
                                block39: {
                                    block40: {
                                        entityPlayer3 = entityPlayer;
                                        if (bl) break block39;
                                        if (entityPlayer3 != oc69da1aa7f5.\u0151.thePlayer) break block40;
                                        if (!bl) continue;
                                    }
                                    entityPlayer3 = entityPlayer;
                                }
                                n = entityPlayer3.deathTime;
                                if (bl) break block41;
                                if (n == 0) break block42;
                                if (!bl) continue;
                            }
                            n = this.\u01f3.\u01ed() ? 1 : 0;
                        }
                        if (bl) break block43;
                        if (n != 0) break block44;
                        entityPlayer2 = entityPlayer;
                        if (bl) break block45;
                        if (!entityPlayer2.isInvisible()) break block44;
                        if (!bl) continue;
                    }
                    entityPlayer2 = entityPlayer;
                }
                n = oca4f99d2d44.\u039b(entityPlayer2) ? 1 : 0;
            }
            if (n != 0 && !bl) continue;
            this.\u023d(entityPlayer);
            if (!bl) continue;
        }
    }

    private void \u0171() {
        this.\u025b = 0;
        this.e.clear();
    }

    private void \u023d(Entity entity) {
        block6: {
            Object object;
            block7: {
                boolean bl = oce6044968f8.\u0452;
                object = this;
                if (bl) break block6;
                if (((oc85c49d5af7)object).\u025b < this.e.size()) break block7;
                this.e.add(entity);
                if (!bl) break block6;
            }
            object = this.e.set(this.\u025b, entity);
        }
        ++this.\u025b;
    }
}

