/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import x.oc2f61de30bc;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.occ48acb5d22;
import x.oce4cea752dd;
import x.oce6044968f8;

public class ocfba7478f0e
extends oc69da1aa7f5 {
    private final occ2f8dff8d8 \u01e3 = new occ2f8dff8d8("Lightning", true);
    private final occ2f8dff8d8 \u0389;
    private final occ2f8dff8d8 \u0470;
    private EntityLivingBase \u0452;
    private World \u0132;
    public static boolean \u00c8;

    public ocfba7478f0e() {
        super("KillEffect", oce4cea752dd.\u014e);
        this.\u028c(this.\u01e3);
        this.\u0389 = new occ2f8dff8d8("Blood Explosion", true);
        this.\u028c(this.\u0389);
        this.\u0470 = new occ2f8dff8d8("Explosion", true);
        this.\u028c(this.\u0470);
    }

    @Override
    public void onDisable() {
        this.\u0112();
    }

    @oc66fa4f2195
    public void \u0578(occ48acb5d22 occ48acb5d222) {
        occ48acb5d22 occ48acb5d223;
        block10: {
            block11: {
                block9: {
                    boolean bl = oce6044968f8.\u0452;
                    if (!oc7ab2161b9f.\u00d0()) break block9;
                    occ48acb5d223 = occ48acb5d222;
                    if (bl) break block10;
                    if (occ48acb5d223.\u01d5 == oc69da1aa7f5.\u0151.thePlayer) break block11;
                }
                return;
            }
            occ48acb5d223 = occ48acb5d222;
        }
        if (occ48acb5d223.\u01fa instanceof EntityLivingBase) {
            this.\u0452 = (EntityLivingBase)occ48acb5d222.\u01fa;
            this.\u0132 = oc69da1aa7f5.\u0151.theWorld;
        }
    }

    @oc66fa4f2195
    public void \u0491(oc2f61de30bc oc2f61de30bc2) {
        block14: {
            ocfba7478f0e ocfba7478f0e2;
            block13: {
                block12: {
                    boolean bl = oce6044968f8.\u0452;
                    if (this.\u0452 == null) {
                        return;
                    }
                    if (!oc7ab2161b9f.\u00d0()) break block12;
                    ocfba7478f0e2 = this;
                    if (bl) break block13;
                    if (ocfba7478f0e2.\u0132 == oc69da1aa7f5.\u0151.theWorld) break block14;
                }
                ocfba7478f0e2 = this;
            }
            ocfba7478f0e2.\u0112();
            return;
        }
        if (oc69da1aa7f5.\u0151.theWorld.loadedEntityList.contains(this.\u0452)) {
            return;
        }
        this.\u0190(this.\u0452);
        this.\u0112();
    }

    @oc66fa4f2195
    public void \u0273(ocbab3c9954b ocbab3c9954b2) {
        this.\u0112();
    }

    private void \u0190(EntityLivingBase entityLivingBase) {
        block18: {
            ocfba7478f0e ocfba7478f0e2;
            boolean bl;
            block16: {
                occ2f8dff8d8 occ2f8dff8d82;
                block14: {
                    block15: {
                        bl = oce6044968f8.\u0452;
                        occ2f8dff8d82 = this.\u01e3;
                        if (bl) break block14;
                        if (!occ2f8dff8d82.\u01ed()) break block15;
                        EntityLightningBolt entityLightningBolt = new EntityLightningBolt(oc69da1aa7f5.\u0151.theWorld, entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
                        oc69da1aa7f5.\u0151.theWorld.addEntityToWorld((int)(-Math.random() * 100000.0), entityLightningBolt);
                        oc69da1aa7f5.\u0151.thePlayer.playSound("ambient.weather.thunder", 1.0f, 1.0f);
                    }
                    ocfba7478f0e2 = this;
                    if (bl) break block16;
                    occ2f8dff8d82 = ocfba7478f0e2.\u0470;
                }
                if (occ2f8dff8d82.\u01ed()) {
                    Minecraft minecraft;
                    block17: {
                        for (int i = 0; i <= (0xD022ABF6 ^ 0xD022ABFE); ++i) {
                            minecraft = oc69da1aa7f5.\u0151;
                            if (!bl) {
                                minecraft.effectRenderer.emitParticleAtEntity(entityLivingBase, EnumParticleTypes.FLAME);
                                if (!bl) continue;
                                break;
                            }
                            break block17;
                        }
                        minecraft = oc69da1aa7f5.\u0151;
                    }
                    minecraft.thePlayer.playSound("item.fireCharge.use", 1.0f, 1.0f);
                }
                ocfba7478f0e2 = this;
            }
            if (ocfba7478f0e2.\u0389.\u01ed()) {
                double d = entityLivingBase.posY;
                double d2 = entityLivingBase.posY + (double)entityLivingBase.height + 0.4;
                double d3 = 0.4;
                int n = Block.getStateId(Blocks.redstone_block.getDefaultState());
                int n2 = 0;
                while (n2 < (0xD022AB9A ^ 0xD022ABFE)) {
                    block19: {
                        if (bl) break block18;
                        for (double d4 = d; d4 <= d2; d4 += d3) {
                            oc69da1aa7f5.\u0151.theWorld.spawnParticle(EnumParticleTypes.BLOCK_CRACK, entityLivingBase.posX, d4, entityLivingBase.posZ, 0.0, 0.0, 0.0, n);
                            if (!bl) {
                                if (!bl) continue;
                            }
                            break block19;
                        }
                        ++n2;
                    }
                    if (!bl) continue;
                }
                for (double d5 = d; d5 <= d2; d5 += d3) {
                    oc69da1aa7f5.\u0151.thePlayer.playSound("dig.stone", 1.0f, 1.0f);
                    if (!bl) continue;
                }
            }
        }
    }

    private void \u0112() {
        this.\u0452 = null;
        this.\u0132 = null;
    }
}

