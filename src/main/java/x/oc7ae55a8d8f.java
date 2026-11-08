/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import x.oc110d7f376c;
import x.oc4d46a99983;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc9adb807c19;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.ocd47efa9be3;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc7ae55a8d8f
extends oc69da1aa7f5 {
    private static final int \u01bc = 4;
    private static final int \u00f4 = 13;
    private static final double \u029d = 96.0;
    private static final int[] \u028e = new int[0];
    private static final Random \u046b = new Random();
    private final occ2f8dff8d8 \u011e;
    private final occ2f8dff8d8 \u020d;
    private final oca9cc61aada \u01a1;
    private final oca9cc61aada \u0415;
    private final oca9cc61aada \u0181;
    private final oca9cc61aada \u04b1;
    private final Map<Integer, Integer> \u024a = new HashMap<Integer, Integer>();
    private static final String[] \u023d;
    private static final int[] \u0547;
    private static final int[] \u0445;
    private static final float[] \u0578;
    private static final boolean[] \u01f0;
    private static final int[][] d;
    public static int \u00dc;

    public oc7ae55a8d8f() {
        super("HitParticles", oce4cea752dd.\u014e);
        this.\u028c(new oc4d46a99983("Melee"));
        this.\u011e = new occ2f8dff8d8("Melee hits", true);
        this.\u028c(this.\u011e);
        this.\u01a1 = new oca9cc61aada("Melee particle", 0x8DF56A7 ^ 0x8DF56A3, \u023d);
        this.\u028c(this.\u01a1);
        this.\u0181 = new oca9cc61aada("Melee multiplier", 1.0, 1.0, 8.0, 1.0);
        this.\u028c(this.\u0181);
        this.\u028c(new oc4d46a99983("Ranged"));
        this.\u020d = new occ2f8dff8d8("Arrow hits", true);
        this.\u028c(this.\u020d);
        this.\u0415 = new oca9cc61aada("Ranged particle", 0x8DF56A7 ^ 0x8DF56A3, \u023d);
        this.\u028c(this.\u0415);
        this.\u04b1 = new oca9cc61aada("Ranged multiplier", 1.0, 1.0, 8.0, 1.0);
        this.\u028c(this.\u04b1);
    }

    @Override
    public void onDisable() {
        this.\u024a.clear();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u0257(ocd47efa9be3 ocd47efa9be32) {
        int n;
        EntityLivingBase entityLivingBase;
        block27: {
            block28: {
                EntityLivingBase entityLivingBase2;
                boolean bl;
                block26: {
                    ocd47efa9be3 ocd47efa9be33;
                    block24: {
                        block25: {
                            block23: {
                                boolean bl2;
                                block22: {
                                    oc7ae55a8d8f oc7ae55a8d8f2;
                                    block21: {
                                        bl = oce6044968f8.\u0452;
                                        oc7ae55a8d8f2 = this;
                                        if (bl) break block21;
                                        if (!oc7ae55a8d8f2.z$3rzb3dil7uydr()) return;
                                        oc7ae55a8d8f2 = this;
                                    }
                                    bl2 = oc7ae55a8d8f2.\u011e.\u01ed();
                                    if (bl) break block22;
                                    if (!bl2) return;
                                    bl2 = oc7ab2161b9f.\u00d0();
                                }
                                if (!bl2) {
                                    return;
                                }
                                ocd47efa9be33 = ocd47efa9be32;
                                if (bl) break block23;
                                if (ocd47efa9be33.\u03b2 != oc69da1aa7f5.\u0151.thePlayer) return;
                                ocd47efa9be33 = ocd47efa9be32;
                            }
                            if (bl) break block24;
                            if (ocd47efa9be33.\u03ca instanceof EntityLivingBase) break block25;
                            return;
                        }
                        ocd47efa9be33 = ocd47efa9be32;
                    }
                    entityLivingBase = (EntityLivingBase)ocd47efa9be33.\u03ca;
                    entityLivingBase2 = entityLivingBase;
                    if (bl) break block26;
                    if (entityLivingBase2.hurtTime > (0xB6A596A4 ^ 0xB6A596A1)) return;
                    entityLivingBase2 = entityLivingBase;
                }
                n = entityLivingBase2.hurtResistantTime;
                if (bl) break block27;
                if (n <= 0) break block28;
                return;
            }
            n = (int)this.\u01a1.\u04c1();
        }
        int n2 = n;
        this.\u022d(n2, entityLivingBase, (int)this.\u0181.\u04c1());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void J(oc9adb807c19 oc9adb807c192) {
        boolean bl;
        block38: {
            oc7ae55a8d8f oc7ae55a8d8f2;
            block37: {
                bl = oce6044968f8.\u0452;
                oc7ae55a8d8f2 = this;
                if (bl) break block37;
                if (!oc7ae55a8d8f2.z$3rzb3dil7uydr()) return;
                oc7ae55a8d8f2 = this;
            }
            if (!oc7ae55a8d8f2.\u020d.\u01ed() || oc9adb807c192.\u04b0 != oc110d7f376c.END) return;
            if (oc7ab2161b9f.\u00d0()) break block38;
            return;
        }
        this.\u024d();
        AxisAlignedBB axisAlignedBB = oc69da1aa7f5.\u0151.thePlayer.getEntityBoundingBox().expand(96.0, 96.0, 96.0);
        List<EntityArrow> list = oc69da1aa7f5.\u0151.theWorld.getEntitiesWithinAABB(EntityArrow.class, axisAlignedBB);
        int n = 0;
        int n2 = list.size();
        while (n < n2) {
            block42: {
                block41: {
                    EntityLivingBase entityLivingBase;
                    block45: {
                        Integer n3;
                        int n4;
                        int n5;
                        block46: {
                            int n6;
                            block43: {
                                EntityArrow entityArrow;
                                block44: {
                                    EntityArrow entityArrow2;
                                    block39: {
                                        block40: {
                                            entityArrow = list.get(n);
                                            entityArrow2 = entityArrow;
                                            if (bl) break block39;
                                            if (entityArrow2.shootingEntity == oc69da1aa7f5.\u0151.thePlayer) break block40;
                                            if (!bl) break block41;
                                        }
                                        entityArrow2 = entityArrow;
                                    }
                                    entityLivingBase = oc7ae55a8d8f.\u0439(entityArrow2);
                                    if (bl) break block42;
                                    if (entityLivingBase == null) break block41;
                                    n6 = entityLivingBase.hurtTime;
                                    if (bl) break block43;
                                    if (n6 <= 0) break block44;
                                    if (!bl) break block41;
                                }
                                n6 = entityArrow.getEntityId();
                            }
                            n5 = n6;
                            n4 = entityLivingBase.getEntityId();
                            Integer n7 = this.\u024a.get(n5);
                            if (bl) break block45;
                            if (n7 == null) break block46;
                            n3 = n7;
                            if (bl) break block45;
                            if (n3 != n4) break block46;
                            if (!bl) break block41;
                        }
                        n3 = this.\u024a.put(n5, n4);
                    }
                    int n8 = (int)this.\u0415.\u04c1();
                    this.\u022d(n8, entityLivingBase, (int)this.\u04b1.\u04c1());
                }
                ++n;
            }
            if (!bl) continue;
        }
    }

    private void \u024d() {
        Iterator<Map.Entry<Integer, Integer>> iterator2 = this.\u024a.entrySet().iterator();
        boolean bl = oce6044968f8.\u0452;
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator2.next();
            if (oc69da1aa7f5.\u0151.theWorld.getEntityByID(entry.getKey()) == null) {
                iterator2.remove();
            }
            if (!bl) continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u022d(int n, Entity entity, int n2) {
        int n3;
        block15: {
            int n4;
            block16: {
                int n5;
                boolean bl;
                block13: {
                    block14: {
                        block12: {
                            bl = oce6044968f8.\u0452;
                            n5 = n;
                            if (bl) break block12;
                            if (n5 < 0) return;
                            n5 = n;
                        }
                        if (bl) break block13;
                        if (n5 < \u0547.length) break block14;
                        return;
                    }
                    n5 = \u0547[n];
                }
                n4 = n5;
                n3 = n4;
                if (bl) break block15;
                if (n3 != -1) break block16;
                oc7ae55a8d8f.\u0377(0xC5642038 ^ 0xC5642031, entity, n2, \u0445[0xC5642035 ^ 0xC5642031], \u0578[0xC5642035 ^ 0xC5642031], \u01f0[0xC5642035 ^ 0xC5642031], d[0xC5642035 ^ 0xC5642031]);
                oc7ae55a8d8f.\u0377(0xC564203B ^ 0xC5642031, entity, n2, \u0445[0xC564203C ^ 0xC5642031], \u0578[0xC564203C ^ 0xC5642031], \u01f0[0xC564203C ^ 0xC5642031], d[0xC564203C ^ 0xC5642031]);
                if (!bl) return;
            }
            n3 = n4;
        }
        oc7ae55a8d8f.\u0377(n3, entity, n2, \u0445[n], \u0578[n], \u01f0[n], d[n]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void \u0377(int n, Entity entity, int n2, int n3, float f, boolean n4, int[] nArray) {
        boolean bl = oce6044968f8.\u0452;
        for (int i = 0; i < n3 * n2; ++i) {
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            block9: {
                block8: {
                    int n5;
                    block7: {
                        d5 = \u046b.nextFloat() * (f * 2.0f) - f;
                        d4 = \u046b.nextFloat() * (f * 2.0f) - f;
                        d3 = \u046b.nextFloat() * (f * 2.0f) - f;
                        n5 = n4;
                        if (bl) break block7;
                        if (n5 != 0) break block8;
                        d2 = d5;
                        d = d5;
                        if (bl) break block9;
                        double d6 = d2 * d + d4 * d4 + d3 * d3 - 1.0;
                        n5 = d6 == 0.0 ? 0 : (d6 < 0.0 ? -1 : 1);
                    }
                    if (n5 > 0) continue;
                }
                d2 = entity.posX;
                d = d5 * (double)entity.width / 4.0;
            }
            double d7 = d2 + d;
            double d8 = entity.getEntityBoundingBox().minY + (double)(entity.height / 2.0f) + d4 * (double)entity.height / 4.0;
            double d9 = entity.posZ + d3 * (double)entity.width / 4.0;
            oc69da1aa7f5.\u0151.effectRenderer.spawnEffectParticle(n, d7, d8, d9, d5, d4, d3, nArray);
            if (!bl) continue;
        }
    }

    private static EntityLivingBase \u0439(EntityArrow entityArrow) {
        boolean bl;
        Vec3 vec3;
        Vec3 vec32;
        World world2;
        block26: {
            MovingObjectPosition movingObjectPosition;
            block25: {
                world2 = entityArrow.worldObj;
                vec32 = new Vec3(entityArrow.posX, entityArrow.posY, entityArrow.posZ);
                Vec3 vec33 = new Vec3(entityArrow.posX + entityArrow.motionX, entityArrow.posY + entityArrow.motionY, entityArrow.posZ + entityArrow.motionZ);
                MovingObjectPosition movingObjectPosition2 = world2.rayTraceBlocks(vec32, vec33, false, true, false);
                vec3 = vec33;
                bl = oce6044968f8.\u0452;
                movingObjectPosition = movingObjectPosition2;
                if (bl) break block25;
                if (movingObjectPosition == null) break block26;
                movingObjectPosition = movingObjectPosition2;
            }
            vec3 = movingObjectPosition.hitVec;
        }
        EntityLivingBase entityLivingBase = null;
        double d = 0.0;
        AxisAlignedBB axisAlignedBB = entityArrow.getEntityBoundingBox().addCoord(entityArrow.motionX, entityArrow.motionY, entityArrow.motionZ).expand(1.0, 1.0, 1.0);
        List<Entity> list = world2.getEntitiesWithinAABBExcludingEntity(entityArrow, axisAlignedBB);
        for (Entity entity : list) {
            block33: {
                double d2;
                double d3;
                EntityLivingBase entityLivingBase2;
                block34: {
                    Entity entity2;
                    block31: {
                        block32: {
                            block29: {
                                block30: {
                                    Entity entity3;
                                    block27: {
                                        block28: {
                                            entity3 = entity;
                                            if (bl) break block27;
                                            if (entity3 instanceof EntityLivingBase) break block28;
                                            if (!bl) continue;
                                        }
                                        entity3 = entity;
                                    }
                                    entityLivingBase2 = (EntityLivingBase)entity3;
                                    entity2 = entityLivingBase2;
                                    if (bl) break block29;
                                    if (entity2.canBeCollidedWith()) break block30;
                                    if (!bl) continue;
                                }
                                entity2 = entityLivingBase2;
                            }
                            if (bl) break block31;
                            if (entity2 != entityArrow.shootingEntity) break block32;
                            if (!bl) continue;
                        }
                        entity2 = entity;
                    }
                    AxisAlignedBB axisAlignedBB2 = entity2.getEntityBoundingBox().expand(0.3, 0.3, 0.3);
                    MovingObjectPosition movingObjectPosition = axisAlignedBB2.calculateIntercept(vec32, vec3);
                    if (movingObjectPosition == null && !bl) continue;
                    d3 = vec32.squareDistanceTo(movingObjectPosition.hitVec);
                    if (bl) break block33;
                    if (!(d3 >= d)) break block34;
                    d2 = d;
                    if (bl) break block33;
                    if (d2 == 0.0) break block34;
                    if (!bl) continue;
                }
                entityLivingBase = entityLivingBase2;
                d2 = d = d3;
            }
            if (!bl) continue;
        }
        return entityLivingBase;
    }

    static {
        String[] stringArray = new String[0xBD2D09CE ^ 0xBD2D09D6];
        stringArray[0] = "Angry Villager";
        stringArray[1] = "Blood";
        stringArray[0xBD2D09D4 ^ 0xBD2D09D6] = "Cloud";
        stringArray[0xBD2D09D5 ^ 0xBD2D09D6] = "Confetti";
        stringArray[0xBD2D09D2 ^ 0xBD2D09D6] = "Critical";
        stringArray[0xBD2D09D3 ^ 0xBD2D09D6] = "Crit/Magic Crit";
        stringArray[0xBD2D09D0 ^ 0xBD2D09D6] = "Enchantment";
        stringArray[0xBD2D09D1 ^ 0xBD2D09D6] = "Explosion";
        stringArray[0xBD2D09DE ^ 0xBD2D09D6] = "Flame";
        stringArray[0xBD2D09DF ^ 0xBD2D09D6] = "Happy Villager";
        stringArray[0xBD2D09DC ^ 0xBD2D09D6] = "Heart";
        stringArray[0xBD2D09DD ^ 0xBD2D09D6] = "Instant Spell";
        stringArray[0xBD2D09DA ^ 0xBD2D09D6] = "Lava";
        stringArray[0xBD2D09DB ^ 0xBD2D09D6] = "Magic Critical";
        stringArray[0xBD2D09D8 ^ 0xBD2D09D6] = "Mob Spell";
        stringArray[0xBD2D09D9 ^ 0xBD2D09D6] = "Music Note";
        stringArray[0xBD2D09C6 ^ 0xBD2D09D6] = "Portal";
        stringArray[0xBD2D09C7 ^ 0xBD2D09D6] = "Slime";
        stringArray[0xBD2D09C4 ^ 0xBD2D09D6] = "Smoke";
        stringArray[0xBD2D09C5 ^ 0xBD2D09D6] = "Snow";
        stringArray[0xBD2D09C2 ^ 0xBD2D09D6] = "Spark";
        stringArray[0xBD2D09C3 ^ 0xBD2D09D6] = "Spell";
        stringArray[0xBD2D09C0 ^ 0xBD2D09D6] = "Splash";
        stringArray[0xBD2D09C1 ^ 0xBD2D09D6] = "Witch";
        \u023d = stringArray;
        int[] nArray = new int[0xBD2D09CE ^ 0xBD2D09D6];
        nArray[0] = 0xBD2D09C2 ^ 0xBD2D09D6;
        nArray[1] = 0xBD2D09F3 ^ 0xBD2D09D6;
        nArray[0xBD2D09D4 ^ 0xBD2D09D6] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray[0xBD2D09D5 ^ 0xBD2D09D6] = 0xBD2D09C8 ^ 0xBD2D09D6;
        nArray[0xBD2D09D2 ^ 0xBD2D09D6] = 0xBD2D09DF ^ 0xBD2D09D6;
        nArray[0xBD2D09D3 ^ 0xBD2D09D6] = -1;
        nArray[0xBD2D09D0 ^ 0xBD2D09D6] = 0xBD2D09CF ^ 0xBD2D09D6;
        nArray[0xBD2D09D1 ^ 0xBD2D09D6] = 1;
        nArray[0xBD2D09DE ^ 0xBD2D09D6] = 0xBD2D09CC ^ 0xBD2D09D6;
        nArray[0xBD2D09DF ^ 0xBD2D09D6] = 0xBD2D09C3 ^ 0xBD2D09D6;
        nArray[0xBD2D09DC ^ 0xBD2D09D6] = 0xBD2D09F4 ^ 0xBD2D09D6;
        nArray[0xBD2D09DD ^ 0xBD2D09D6] = 0xBD2D09D8 ^ 0xBD2D09D6;
        nArray[0xBD2D09DA ^ 0xBD2D09D6] = 0xBD2D09CD ^ 0xBD2D09D6;
        nArray[0xBD2D09DB ^ 0xBD2D09D6] = 0xBD2D09DC ^ 0xBD2D09D6;
        nArray[0xBD2D09D8 ^ 0xBD2D09D6] = 0xBD2D09D9 ^ 0xBD2D09D6;
        nArray[0xBD2D09D9 ^ 0xBD2D09D6] = 0xBD2D09C1 ^ 0xBD2D09D6;
        nArray[0xBD2D09C6 ^ 0xBD2D09D6] = 0xBD2D09CE ^ 0xBD2D09D6;
        nArray[0xBD2D09C7 ^ 0xBD2D09D6] = 0xBD2D09F7 ^ 0xBD2D09D6;
        nArray[0xBD2D09C4 ^ 0xBD2D09D6] = 0xBD2D09DD ^ 0xBD2D09D6;
        nArray[0xBD2D09C5 ^ 0xBD2D09D6] = 0xBD2D09C9 ^ 0xBD2D09D6;
        nArray[0xBD2D09C2 ^ 0xBD2D09D6] = 0xBD2D09D5 ^ 0xBD2D09D6;
        nArray[0xBD2D09C3 ^ 0xBD2D09D6] = 0xBD2D09DB ^ 0xBD2D09D6;
        nArray[0xBD2D09C0 ^ 0xBD2D09D6] = 0xBD2D09D3 ^ 0xBD2D09D6;
        nArray[0xBD2D09C1 ^ 0xBD2D09D6] = 0xBD2D09C7 ^ 0xBD2D09D6;
        \u0547 = nArray;
        int[] nArray2 = new int[0xBD2D09CE ^ 0xBD2D09D6];
        nArray2[0] = 0xBD2D09DE ^ 0xBD2D09D6;
        nArray2[1] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D4 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D5 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D2 ^ 0xBD2D09D6] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D3 ^ 0xBD2D09D6] = -1;
        nArray2[0xBD2D09D0 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D1 ^ 0xBD2D09D6] = 1;
        nArray2[0xBD2D09DE ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09DF ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09DC ^ 0xBD2D09D6] = 0xBD2D09DE ^ 0xBD2D09D6;
        nArray2[0xBD2D09DD ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09DA ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09DB ^ 0xBD2D09D6] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D8 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09D9 ^ 0xBD2D09D6] = 0xBD2D09DE ^ 0xBD2D09D6;
        nArray2[0xBD2D09C6 ^ 0xBD2D09D6] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C7 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C4 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C5 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C2 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C3 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C0 ^ 0xBD2D09D6] = 0xBD2D09F6 ^ 0xBD2D09D6;
        nArray2[0xBD2D09C1 ^ 0xBD2D09D6] = 0xBD2D09C6 ^ 0xBD2D09D6;
        \u0445 = nArray2;
        float[] fArray = new float[0xBD2D09CE ^ 0xBD2D09D6];
        fArray[0] = 2.5f;
        fArray[1] = 1.2f;
        fArray[0xBD2D09D4 ^ 0xBD2D09D6] = 0.2f;
        fArray[0xBD2D09D5 ^ 0xBD2D09D6] = 3.0f;
        fArray[0xBD2D09D2 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09D3 ^ 0xBD2D09D6] = -1.0f;
        fArray[0xBD2D09D0 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09D1 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09DE ^ 0xBD2D09D6] = 0.05f;
        fArray[0xBD2D09DF ^ 0xBD2D09D6] = 2.5f;
        fArray[0xBD2D09DC ^ 0xBD2D09D6] = 2.0f;
        fArray[0xBD2D09DD ^ 0xBD2D09D6] = 0.7f;
        fArray[0xBD2D09DA ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09DB ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09D8 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09D9 ^ 0xBD2D09D6] = 3.0f;
        fArray[0xBD2D09C6 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09C7 ^ 0xBD2D09D6] = 0.5f;
        fArray[0xBD2D09C4 ^ 0xBD2D09D6] = 0.08f;
        fArray[0xBD2D09C5 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09C2 ^ 0xBD2D09D6] = 0.1f;
        fArray[0xBD2D09C3 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09C0 ^ 0xBD2D09D6] = 1.0f;
        fArray[0xBD2D09C1 ^ 0xBD2D09D6] = 0.5f;
        \u0578 = fArray;
        boolean[] blArray = new boolean[0xBD2D09CE ^ 0xBD2D09D6];
        blArray[0] = true;
        blArray[1] = true;
        blArray[0xBD2D09D4 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09D5 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09D2 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09D3 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09D0 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09D1 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09DE ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09DF ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09DC ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09DD ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09DA ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09DB ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09D8 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09D9 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09C6 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09C7 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09C4 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09C5 ^ 0xBD2D09D6] = true;
        blArray[0xBD2D09C2 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09C3 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09C0 ^ 0xBD2D09D6] = false;
        blArray[0xBD2D09C1 ^ 0xBD2D09D6] = false;
        \u01f0 = blArray;
        int[][] nArrayArray = new int[0xBD2D09CE ^ 0xBD2D09D6][];
        nArrayArray[0] = \u028e;
        nArrayArray[1] = new int[]{Block.getIdFromBlock(Blocks.netherrack)};
        nArrayArray[0xBD2D09D4 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D5 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D2 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D3 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D0 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D1 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DE ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DF ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DC ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DD ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DA ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09DB ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D8 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09D9 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C6 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C7 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C4 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C5 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C2 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C3 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C0 ^ 0xBD2D09D6] = \u028e;
        nArrayArray[0xBD2D09C1 ^ 0xBD2D09D6] = \u028e;
        d = nArrayArray;
    }
}

