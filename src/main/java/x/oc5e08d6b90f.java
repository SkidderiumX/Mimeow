/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import x.oc04db39b778;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oca4f99d2d44;
import x.ocda171fe5d8;

public class oc5e08d6b90f
implements ocda171fe5d8 {
    public static int \u0152;

    private oc5e08d6b90f() {
    }

    public static EntityPlayer \u04e5(double d) {
        return oc5e08d6b90f.\u00df(d, true);
    }

    public static EntityPlayer \u00df(double d, boolean bl) {
        EntityPlayer entityPlayer;
        block4: {
            block5: {
                EntityPlayer entityPlayer2 = oc5e08d6b90f.\u0568(d, bl);
                int n = oc75d51ec7eb.\u03e9;
                entityPlayer = entityPlayer2;
                if (n != 0) break block4;
                if (entityPlayer == null) break block5;
                return entityPlayer2;
            }
            entityPlayer = oc5e08d6b90f.\u0506(d, bl);
        }
        return entityPlayer;
    }

    public static EntityPlayer \u0233(double d) {
        return oc5e08d6b90f.\u0506(d, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static EntityPlayer \u0506(double d, boolean bl) {
        EntityPlayer entityPlayer3;
        Minecraft minecraft;
        int n;
        block12: {
            n = oc75d51ec7eb.\u03e9;
            minecraft = ocda171fe5d8.\u01d4;
            if (n != 0) break block12;
            if (minecraft == null) return null;
            minecraft = ocda171fe5d8.\u01d4;
        }
        if (minecraft.theWorld == null) {
            return null;
        }
        EntityPlayer entityPlayer2 = null;
        double d2 = Double.MAX_VALUE;
        for (EntityPlayer entityPlayer3 : ocda171fe5d8.\u01d4.theWorld.playerEntities) {
            block16: {
                EntityPlayer entityPlayer4;
                block15: {
                    EntityPlayer entityPlayer5;
                    block13: {
                        block14: {
                            if (n != 0) return entityPlayer3;
                            entityPlayer4 = entityPlayer3;
                            entityPlayer5 = entityPlayer4;
                            if (n != 0) break block13;
                            if (oc5e08d6b90f.\u03c4(entityPlayer5, d, bl)) break block14;
                            if (n == 0) continue;
                        }
                        entityPlayer5 = entityPlayer4;
                    }
                    double d3 = oc75d51ec7eb.\u038f(entityPlayer5);
                    if (n != 0) break block15;
                    if (!(d3 < d2)) break block16;
                    d2 = d3;
                }
                entityPlayer2 = entityPlayer4;
            }
            if (n == 0) continue;
        }
        entityPlayer3 = entityPlayer2;
        return entityPlayer3;
    }

    public static EntityPlayer \u0495(double d) {
        return oc5e08d6b90f.\u0568(d, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static EntityPlayer \u0568(double d, boolean bl) {
        Minecraft minecraft;
        block7: {
            block8: {
                int n;
                block6: {
                    n = oc75d51ec7eb.\u03e9;
                    minecraft = ocda171fe5d8.\u01d4;
                    if (n != 0) break block6;
                    if (minecraft == null) return null;
                    minecraft = ocda171fe5d8.\u01d4;
                }
                if (n != 0) break block7;
                if (minecraft.objectMouseOver != null) break block8;
                return null;
            }
            minecraft = ocda171fe5d8.\u01d4;
        }
        MovingObjectPosition movingObjectPosition = minecraft.objectMouseOver;
        return oc5e08d6b90f.\u0137(movingObjectPosition.entityHit, d, bl);
    }

    public static EntityPlayer \u03f0(Entity entity, double d) {
        return oc5e08d6b90f.\u0137(entity, d, true);
    }

    public static EntityPlayer \u0137(Entity entity, double d, boolean bl) {
        EntityPlayer entityPlayer;
        block10: {
            block11: {
                Entity entity2;
                int n;
                block8: {
                    block9: {
                        n = oc75d51ec7eb.\u03e9;
                        entity2 = entity;
                        if (n != 0) break block8;
                        if (entity2 instanceof EntityPlayer) break block9;
                        return null;
                    }
                    entity2 = entity;
                }
                EntityPlayer entityPlayer2 = (EntityPlayer)entity2;
                entityPlayer = entityPlayer2;
                if (n != 0) break block10;
                if (!oc5e08d6b90f.\u03c4(entityPlayer, d, bl)) break block11;
                entityPlayer = entityPlayer2;
                break block10;
            }
            entityPlayer = null;
        }
        return entityPlayer;
    }

    public static boolean \u01df(EntityPlayer entityPlayer, double d) {
        return oc5e08d6b90f.\u03c4(entityPlayer, d, true);
    }

    public static boolean \u03c4(EntityPlayer entityPlayer, double d, boolean bl) {
        boolean bl2;
        block8: {
            block7: {
                EntityPlayer entityPlayer2;
                int n;
                block6: {
                    n = oc75d51ec7eb.\u03e9;
                    entityPlayer2 = entityPlayer;
                    if (n != 0) break block6;
                    if (!oc5e08d6b90f.\u018e(entityPlayer2, bl)) break block7;
                    entityPlayer2 = entityPlayer;
                }
                bl2 = oc5e08d6b90f.\u01e7(entityPlayer2, d);
                if (n != 0) break block8;
                if (!bl2) break block7;
                bl2 = true;
                break block8;
            }
            bl2 = false;
        }
        return bl2;
    }

    public static boolean \u01a2(EntityPlayer entityPlayer) {
        return oc5e08d6b90f.\u018e(entityPlayer, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u018e(EntityPlayer entityPlayer, boolean bl) {
        boolean bl2;
        int n;
        block36: {
            block37: {
                EntityPlayer entityPlayer2;
                block34: {
                    block35: {
                        EntityPlayer entityPlayer3;
                        boolean bl3;
                        block33: {
                            block32: {
                                n = oc75d51ec7eb.\u03e9;
                                bl3 = oc7ab2161b9f.\u00d0();
                                if (n != 0) return bl3;
                                if (!bl3) return false;
                                entityPlayer3 = entityPlayer;
                                if (n != 0) break block32;
                                if (entityPlayer3 == null) return false;
                                entityPlayer3 = entityPlayer;
                            }
                            if (n != 0) break block33;
                            if (entityPlayer3 == ocda171fe5d8.\u01d4.thePlayer) return false;
                            entityPlayer3 = entityPlayer;
                        }
                        bl3 = entityPlayer3.isDead;
                        if (n != 0) return bl3;
                        if (bl3) return false;
                        entityPlayer2 = entityPlayer;
                        if (n != 0) break block34;
                        if (entityPlayer2.deathTime == 0) break block35;
                        return false;
                    }
                    entityPlayer2 = entityPlayer;
                }
                boolean bl4 = oc7ab2161b9f.\u04ec(entityPlayer2);
                if (n != 0) return bl4;
                if (bl4) return false;
                bl2 = oca4f99d2d44.\u039b(entityPlayer);
                if (n != 0) break block36;
                if (!bl2) break block37;
                return false;
            }
            bl2 = bl;
        }
        if (n != 0) return bl2;
        if (!bl2) return true;
        bl2 = oc7ab2161b9f.\u04e5(entityPlayer);
        if (n != 0) return bl2;
        if (!bl2) return true;
        return false;
    }

    public static boolean \u03fd(Entity entity) {
        int n;
        block16: {
            block15: {
                int n2;
                block14: {
                    Entity entity2;
                    int n3;
                    block12: {
                        block13: {
                            n3 = oc75d51ec7eb.\u03e9;
                            entity2 = entity;
                            if (n3 != 0) break block12;
                            if (entity2 instanceof EntityPlayer) break block13;
                            return false;
                        }
                        entity2 = entity;
                    }
                    int n4 = Float.floatToRawIntBits(((oc04db39b778)((Object)entity2)).getSpeedOnGround());
                    n = n4;
                    n2 = 0xBDEB3307 ^ 0x42143307;
                    if (n3 != 0) break block14;
                    if ((n & n2) != (0xF1013307 ^ 0x42143307)) break block15;
                    n = n4;
                    if (n3 != 0) break block16;
                    n2 = 0x42143300 ^ 0x42143307;
                }
                if ((n & n2) == 0) break block15;
                n = 1;
                break block16;
            }
            n = 0;
        }
        return n != 0;
    }

    public static boolean \u01e7(EntityPlayer entityPlayer, double d) {
        double d2;
        block8: {
            block9: {
                EntityPlayer entityPlayer2;
                int n;
                block6: {
                    block7: {
                        n = oc75d51ec7eb.\u03e9;
                        entityPlayer2 = entityPlayer;
                        if (n != 0) break block6;
                        if (entityPlayer2 != null) break block7;
                        return false;
                    }
                    entityPlayer2 = entityPlayer;
                }
                double d3 = oc75d51ec7eb.\u038f(entityPlayer2) - d;
                d2 = d3 == 0.0 ? 0 : (d3 < 0.0 ? -1 : 1);
                if (n != 0) break block8;
                if (d2 > 0) break block9;
                d2 = 1.0;
                break block8;
            }
            d2 = 0.0;
        }
        return (boolean)d2;
    }
}

