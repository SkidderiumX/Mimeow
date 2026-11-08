/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import java.util.Iterator;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import x.oc497d0cdf29;
import x.oc6111f05032;
import x.occc82079da8;
import x.ocdab58ca6e4;

public class oceb15b1dc5f {
    private static final Field \u03a0;
    private static final Field k;
    private static final Field \u01f7;
    private static final Field \u0556;
    private static final Field \u0472;
    public static int \u010b;

    private oceb15b1dc5f() {
    }

    public static Vec3 z(Entity entity) {
        return new Vec3(entity.posX, entity.posY, entity.posZ);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Vec3 \u021a(Entity entity) {
        block7: {
            Entity entity2;
            block6: {
                boolean bl = ocdab58ca6e4.\u02e3;
                entity2 = entity;
                if (bl) break block6;
                if (entity2 instanceof EntityOtherPlayerMP) break block7;
                entity2 = entity;
            }
            return oceb15b1dc5f.z(entity2);
        }
        try {
            return new Vec3(\u03a0.getDouble(entity), k.getDouble(entity), \u01f7.getDouble(entity));
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static int \u00d0(Entity entity) {
        boolean bl = ocdab58ca6e4.\u02e3;
        int n = entity instanceof EntityOtherPlayerMP;
        if (bl) return n;
        if (n == 0) {
            return 0;
        }
        try {
            n = \u0556.getInt(entity);
            return n;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static double \u0116(Entity entity) {
        block7: {
            Entity entity2;
            block6: {
                boolean bl = ocdab58ca6e4.\u02e3;
                entity2 = entity;
                if (bl) break block6;
                if (entity2 instanceof EntityOtherPlayerMP) break block7;
                entity2 = entity;
            }
            return entity2.rotationYaw;
        }
        try {
            return \u0472.getDouble(entity);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    public static boolean \u02ad(oc6111f05032 oc6111f050322) {
        Vec3 vec3 = oceb15b1dc5f.z(oc6111f050322.\u016d());
        Iterator iterator2 = oc6111f050322.X().playerEntities.iterator();
        boolean bl = ocdab58ca6e4.\u02e3;
        while (iterator2.hasNext()) {
            block9: {
                float f;
                block11: {
                    EntityPlayer entityPlayer;
                    Vec3 vec32;
                    block10: {
                        EntityPlayer entityPlayer2 = (EntityPlayer)iterator2.next();
                        if (entityPlayer2 == oc6111f050322.\u016d()) break block9;
                        vec32 = vec3;
                        entityPlayer = entityPlayer2;
                        if (bl) break block10;
                        if (oceb15b1dc5f.\u02b2(vec32, oceb15b1dc5f.z(entityPlayer)) > 36.0) break block9;
                        vec32 = vec3;
                        entityPlayer = entityPlayer2;
                    }
                    float f2 = oc497d0cdf29.\u0538(oc497d0cdf29.\u0282(vec32, oceb15b1dc5f.z(entityPlayer))[0] - oc6111f050322.\u016d().rotationYaw);
                    float f3 = oc497d0cdf29.\u0416(f2) - 90.0f;
                    f = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                    if (bl) break block11;
                    if (f > 0) break block9;
                    f = 1.0f;
                }
                return (boolean)f;
            }
            if (!bl) continue;
        }
        return false;
    }

    public static double \u02b2(Vec3 vec3, Vec3 vec32) {
        double d = vec3.xCoord - vec32.xCoord;
        double d2 = vec3.yCoord - vec32.yCoord;
        double d3 = vec3.zCoord - vec32.zCoord;
        return d3 * d3 + (d * d + d2 * d2);
    }

    static {
        String[] stringArray = new String[0x863DA5E1 ^ 0x863DA5E3];
        stringArray[0] = "otherPlayerMPX";
        stringArray[1] = "field_71185_c";
        \u03a0 = occc82079da8.\u00d0(EntityOtherPlayerMP.class, stringArray);
        String[] stringArray2 = new String[0x863DA5E1 ^ 0x863DA5E3];
        stringArray2[0] = "otherPlayerMPY";
        stringArray2[1] = "field_71182_d";
        k = occc82079da8.\u00d0(EntityOtherPlayerMP.class, stringArray2);
        String[] stringArray3 = new String[0x863DA5E1 ^ 0x863DA5E3];
        stringArray3[0] = "otherPlayerMPZ";
        stringArray3[1] = "field_71183_e";
        \u01f7 = occc82079da8.\u00d0(EntityOtherPlayerMP.class, stringArray3);
        String[] stringArray4 = new String[0x863DA5E1 ^ 0x863DA5E3];
        stringArray4[0] = "otherPlayerMPPosRotationIncrements";
        stringArray4[1] = "field_71184_b";
        \u0556 = occc82079da8.\u00d0(EntityOtherPlayerMP.class, stringArray4);
        String[] stringArray5 = new String[0x863DA5E1 ^ 0x863DA5E3];
        stringArray5[0] = "otherPlayerMPYaw";
        stringArray5[1] = "field_71180_f";
        \u0472 = occc82079da8.\u00d0(EntityOtherPlayerMP.class, stringArray5);
    }
}

