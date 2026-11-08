/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import x.oc3e527bc66f;
import x.oc75d51ec7eb;

public class oc94a86ee062 {
    private final oc3e527bc66f \u0506;
    private final MovingObjectPosition \u021c;
    private final Vec3 \u0479;
    private final Vec3 \u046c;
    private final Vec3 \u00ff;
    private final int \u01b3;
    public static boolean \u037a;

    private oc94a86ee062(oc3e527bc66f oc3e527bc66f2, MovingObjectPosition movingObjectPosition, Vec3 vec3, Vec3 vec32, Vec3 vec33, int n) {
        this.\u0506 = oc3e527bc66f2;
        this.\u021c = movingObjectPosition;
        this.\u0479 = vec3;
        this.\u046c = vec32;
        this.\u00ff = vec33;
        this.\u01b3 = n;
    }

    public oc3e527bc66f \u0397() {
        return this.\u0506;
    }

    public boolean \u047f() {
        boolean bl = this.\u0506 != oc3e527bc66f.\u01e1;
        return bl;
    }

    public boolean \u0509() {
        boolean bl = this.\u0506 == oc3e527bc66f.\u04de;
        return bl;
    }

    public boolean \u0442() {
        boolean bl = this.\u0506 == oc3e527bc66f.\u0474;
        return bl;
    }

    public MovingObjectPosition \u0112() {
        return this.\u021c;
    }

    public Entity \u048f() {
        Entity entity;
        block6: {
            block5: {
                oc94a86ee062 oc94a86ee0622;
                block4: {
                    int n = oc75d51ec7eb.\u03e9;
                    oc94a86ee0622 = this;
                    if (n != 0) break block4;
                    if (oc94a86ee0622.\u021c == null) break block5;
                    oc94a86ee0622 = this;
                }
                entity = oc94a86ee0622.\u021c.entityHit;
                break block6;
            }
            entity = null;
        }
        return entity;
    }

    public Entity \u01a6() {
        return this.\u048f();
    }

    public BlockPos \u04aa() {
        BlockPos blockPos;
        block6: {
            block5: {
                oc94a86ee062 oc94a86ee0622;
                block4: {
                    int n = oc75d51ec7eb.\u03e9;
                    oc94a86ee0622 = this;
                    if (n != 0) break block4;
                    if (oc94a86ee0622.\u021c == null) break block5;
                    oc94a86ee0622 = this;
                }
                blockPos = oc94a86ee0622.\u021c.getBlockPos();
                break block6;
            }
            blockPos = null;
        }
        return blockPos;
    }

    public Vec3 \u0298() {
        return this.\u0479;
    }

    public Vec3 \u01a9() {
        return this.\u046c;
    }

    public Vec3 \u023d() {
        return this.\u00ff;
    }

    public int \u0141() {
        return this.\u01b3;
    }
}

