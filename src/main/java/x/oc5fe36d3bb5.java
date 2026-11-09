/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import x.oc7ab2161b9f;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.occ2ace216f9;
import x.ocd3fd3d417e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class oc5fe36d3bb5 {
    public Entity \u057f;
    public String Q;
    public int \u02b6;
    public boolean \u053d;
    public boolean \u03d2;
    public boolean \u00e6;
    public static int \u0454;

    public oc5fe36d3bb5(Entity entity) {
        this.\u057f = entity;
        this.Q = entity == null ? "" : entity.getClass().getSimpleName();
        this.\u02b6 = entity == null ? 0 : entity.getEntityId();
        this.\u053d = entity instanceof EntityLivingBase;
        this.\u03d2 = entity instanceof EntityPlayer;
        this.\u00e6 = entity != null && entity == Minecraft.getMinecraft().thePlayer;
    }

    public static oc5fe36d3bb5 \u0277(Entity entity) {
        oc5fe36d3bb5 oc5fe36d3bb52 = entity == null ? null : new oc5fe36d3bb5(entity);
        return oc5fe36d3bb52;
    }

    public static void \u03de() {
    }

    public boolean \u051b() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u0180();
                if (n != 0) break block8;
                if (bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public int \u0439() {
        return this.\u02b6;
    }

    public String \u04dd() {
        return this.Q;
    }

    public boolean \u013c() {
        return this.\u03d2;
    }

    public boolean \u0162() {
        return this.\u053d;
    }

    public double J() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.posX;
        }
        return d;
    }

    public double \u0573() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.posY;
        }
        return d;
    }

    public double \u028c() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.posZ;
        }
        return d;
    }

    public double \u01b2() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.prevPosX;
        }
        return d;
    }

    public double \u0582() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.prevPosY;
        }
        return d;
    }

    public double \u0104() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.prevPosZ;
        }
        return d;
    }

    public double \u00da() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.motionX;
        }
        return d;
    }

    public double o() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.motionY;
        }
        return d;
    }

    public double \u0209() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = 0.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc5fe36d3bb52.\u057f.motionZ;
        }
        return d;
    }

    public ocbf5a535fb8 \u017d() {
        ocbf5a535fb8 ocbf5a535fb82 = this.\u057f == null ? null : new ocbf5a535fb8(this.\u057f.posX, this.\u057f.posY, this.\u057f.posZ);
        return ocbf5a535fb82;
    }

    public ocbf5a535fb8 \u03c3() {
        ocbf5a535fb8 ocbf5a535fb82 = this.\u057f == null ? null : new ocbf5a535fb8(this.\u057f.prevPosX, this.\u057f.prevPosY, this.\u057f.prevPosZ);
        return ocbf5a535fb82;
    }

    public ocbf5a535fb8 \u0208() {
        ocbf5a535fb8 ocbf5a535fb82;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    ocbf5a535fb82 = null;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            ocbf5a535fb82 = ocbf5a535fb8.\u03e1(oc5fe36d3bb52.\u057f.getPosition());
        }
        return ocbf5a535fb82;
    }

    public float \u00d2() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.rotationYaw;
        }
        return f;
    }

    public float \u025c() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.rotationPitch;
        }
        return f;
    }

    public void \u0399(float f) {
        block5: {
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb5 oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.rotationYaw = f;
        }
    }

    public void \u01eb(float f) {
        block5: {
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb5 oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.rotationPitch = f;
        }
    }

    public float \u0184() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.getEyeHeight();
        }
        return f;
    }

    public float \u01f8() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.height;
        }
        return f;
    }

    public float \u0553() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.width;
        }
        return f;
    }

    public int \u0472() {
        int n;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    n = 0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            n = oc5fe36d3bb52.\u057f.ticksExisted;
        }
        return n;
    }

    public boolean \u0180() {
        int n;
        block16: {
            block18: {
                block15: {
                    oc5fe36d3bb5 oc5fe36d3bb52;
                    int n2;
                    block17: {
                        oc5fe36d3bb5 oc5fe36d3bb53;
                        block14: {
                            n2 = occ0b63c0426.\u039f;
                            oc5fe36d3bb53 = this;
                            if (n2 != 0) break block14;
                            if (oc5fe36d3bb53.\u057f == null) break block15;
                            oc5fe36d3bb53 = this;
                        }
                        n = oc5fe36d3bb53.\u057f.isDead;
                        if (n2 != 0) break block16;
                        if (n != 0) break block15;
                        oc5fe36d3bb52 = this;
                        if (n2 != 0) break block17;
                        if (!oc5fe36d3bb52.\u053d) break block18;
                        oc5fe36d3bb52 = this;
                    }
                    n = ((EntityLivingBase)oc5fe36d3bb52.\u057f).deathTime;
                    if (n2 != 0) break block16;
                    if (n <= 0) break block18;
                }
                n = 1;
                break block16;
            }
            n = 0;
        }
        return n != 0;
    }

    public boolean \u04c2() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.onGround;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03cf() {
        return this.\u04c2();
    }

    public boolean \u04d4() {
        boolean bl;
        block18: {
            block17: {
                block19: {
                    EntityPlayerSP entityPlayerSP;
                    EntityPlayerSP entityPlayerSP2;
                    int n;
                    block16: {
                        oc5fe36d3bb5 oc5fe36d3bb52;
                        block14: {
                            block15: {
                                n = occ0b63c0426.\u039f;
                                oc5fe36d3bb52 = this;
                                if (n != 0) break block14;
                                if (oc5fe36d3bb52.\u057f instanceof EntityPlayerSP) break block15;
                                return false;
                            }
                            oc5fe36d3bb52 = this;
                        }
                        entityPlayerSP2 = (EntityPlayerSP)oc5fe36d3bb52.\u057f;
                        entityPlayerSP = entityPlayerSP2;
                        if (n != 0) break block16;
                        if (entityPlayerSP.movementInput == null) break block17;
                        entityPlayerSP = entityPlayerSP2;
                    }
                    float f = entityPlayerSP.movementInput.moveForward - 0.0f;
                    bl = f == 0.0f ? 0 : (f > 0.0f ? 1 : -1);
                    if (n != 0) break block18;
                    if (bl) break block19;
                    float f2 = entityPlayerSP2.movementInput.moveStrafe - 0.0f;
                    bl = f2 == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                    if (n != 0) break block18;
                    if (!bl) break block17;
                }
                bl = true;
                break block18;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u021d() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isSneaking();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u056c() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isSprinting();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03e9() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isInvisible();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03e0() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isRiding();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0508() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isInWater();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03a6() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isInLava();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0576() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isCollided;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u04d8() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isCollidedHorizontally;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u015e() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isCollidedVertically;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public float \u0128() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.fallDistance;
        }
        return f;
    }

    public occ2ace216f9 \u03f7() {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block4: {
            block5: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f instanceof EntityLivingBase) break block5;
                return null;
            }
            oc5fe36d3bb52 = this;
        }
        return occ2ace216f9.\u0256(((EntityLivingBase)oc5fe36d3bb52.\u057f).getHeldItem());
    }

    public boolean \u02a3() {
        int n;
        block11: {
            block9: {
                occ2ace216f9 occ2ace216f92;
                int n2;
                block10: {
                    occ2ace216f9 occ2ace216f93;
                    block8: {
                        occ2ace216f93 = this.\u03f7();
                        n2 = occ0b63c0426.\u039f;
                        occ2ace216f92 = occ2ace216f93;
                        if (n2 != 0) break block8;
                        if (occ2ace216f92 == null) break block9;
                        occ2ace216f92 = occ2ace216f93;
                    }
                    if (n2 != 0) break block10;
                    if (!occ2ace216f92.\u0268) break block9;
                    occ2ace216f92 = occ2ace216f93;
                }
                n = occ2ace216f92.\u0261;
                if (n2 != 0) break block11;
                if (n <= 0) break block9;
                n = 1;
                break block11;
            }
            n = 0;
        }
        return n != 0;
    }

    public boolean \u056b() {
        boolean bl;
        block8: {
            block7: {
                Entity entity;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n != 0) break block6;
                    if (!(entity instanceof EntityPlayer)) break block7;
                    entity = this.\u057f;
                }
                bl = ((EntityPlayer)entity).capabilities.allowEdit;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0403() {
        boolean bl;
        block8: {
            block7: {
                Entity entity;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n != 0) break block6;
                    if (!(entity instanceof EntityLivingBase)) break block7;
                    entity = this.\u057f;
                }
                bl = oc7ab2161b9f.\u016d((EntityLivingBase)entity);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public float oFloat() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityLivingBase)) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityLivingBase)oc5fe36d3bb52.\u057f).getAbsorptionAmount();
                break block6;
            }
            f = -1.0f;
        }
        return f;
    }

    public double \u0548() {
        double d;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    d = -1.0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            d = oc7ab2161b9f.\u041f(oc5fe36d3bb52.\u057f);
        }
        return d;
    }

    public oc5fe36d3bb5 \u0123() {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb53;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb53 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb53.\u057f != null) break block5;
                    oc5fe36d3bb52 = null;
                    break block6;
                }
                oc5fe36d3bb53 = this;
            }
            oc5fe36d3bb52 = oc5fe36d3bb5.\u0277(oc5fe36d3bb53.\u057f.ridingEntity);
        }
        return oc5fe36d3bb52;
    }

    public oc5fe36d3bb5 P() {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb53;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb53 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb53.\u057f != null) break block5;
                    oc5fe36d3bb52 = null;
                    break block6;
                }
                oc5fe36d3bb53 = this;
            }
            oc5fe36d3bb52 = oc5fe36d3bb5.\u0277(oc5fe36d3bb53.\u057f.riddenByEntity);
        }
        return oc5fe36d3bb52;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ocd3fd3d417e \u0431() {
        Minecraft minecraft;
        Minecraft minecraft2;
        block10: {
            int n;
            block9: {
                n = occ0b63c0426.\u039f;
                if (!(this.\u057f instanceof EntityPlayer)) {
                    return null;
                }
                minecraft2 = Minecraft.getMinecraft();
                minecraft = minecraft2;
                if (n != 0) break block9;
                if (minecraft == null) return null;
                minecraft = minecraft2;
            }
            if (n != 0) return ocd3fd3d417e.\u056d(minecraft.getNetHandler().getPlayerInfo(this.\u057f.getUniqueID()));
            if (minecraft.getNetHandler() != null) break block10;
            return null;
        }
        minecraft = minecraft2;
        return ocd3fd3d417e.\u056d(minecraft.getNetHandler().getPlayerInfo(this.\u057f.getUniqueID()));
    }

    public int \u03e6() {
        int n;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityPlayer)) break block5;
                    oc5fe36d3bb52 = this;
                }
                n = ((EntityPlayer)oc5fe36d3bb52.\u057f).experienceLevel;
                break block6;
            }
            n = 0;
        }
        return n;
    }

    public float e() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityPlayer)) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityPlayer)oc5fe36d3bb52.\u057f).experience;
                break block6;
            }
            f = 0.0f;
        }
        return f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u03fc() {
        Entity entity;
        block9: {
            block10: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block8;
                    if (oc5fe36d3bb52.\u057f == null) return "";
                    oc5fe36d3bb52 = this;
                }
                entity = oc5fe36d3bb52.\u057f;
                if (n != 0) break block9;
                if (entity.getUniqueID() != null) break block10;
                return "";
            }
            entity = this.\u057f;
        }
        String string = entity.getUniqueID().toString();
        return string;
    }

    public String m() {
        String string;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    string = "";
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            string = oc5fe36d3bb52.\u057f.getCustomNameTag();
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public double \u0269() {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block9: {
            block10: {
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block8;
                    if (!oc5fe36d3bb52.\u053d) return 0.0;
                    oc5fe36d3bb52 = this;
                }
                if (n != 0) break block9;
                if (oc5fe36d3bb52.\u057f != null) break block10;
                return 0.0;
            }
            oc5fe36d3bb52 = this;
        }
        double d = oc5fe36d3bb52.\u057f.posX - this.\u057f.prevPosX;
        double d2 = this.\u057f.posZ - this.\u057f.prevPosZ;
        return Math.sqrt(d * d + d2 * d2) * 20.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u03ff() {
        Entity entity;
        block9: {
            block10: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block8;
                    if (oc5fe36d3bb52.\u057f == null) return "";
                    oc5fe36d3bb52 = this;
                }
                entity = oc5fe36d3bb52.\u057f;
                if (n != 0) break block9;
                if (entity.getHorizontalFacing() != null) break block10;
                return "";
            }
            entity = this.\u057f;
        }
        String string = entity.getHorizontalFacing().name();
        return string;
    }

    public boolean \u015d() {
        boolean bl;
        block8: {
            block7: {
                Entity entity;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n != 0) break block6;
                    if (!(entity instanceof EntityPlayer)) break block7;
                    entity = this.\u057f;
                }
                bl = ((EntityPlayer)entity).isPlayerSleeping();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u04b3() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isBurning();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public int \u0506() {
        int n;
        block17: {
            occ2ace216f9 occ2ace216f92;
            block15: {
                occ2ace216f9 occ2ace216f93;
                block16: {
                    oc5fe36d3bb5 oc5fe36d3bb52;
                    int n2;
                    block10: {
                        block11: {
                            int n3;
                            block14: {
                                ItemStack itemStack;
                                block12: {
                                    ItemStack itemStack2;
                                    block13: {
                                        n2 = occ0b63c0426.\u039f;
                                        oc5fe36d3bb52 = this;
                                        if (n2 != 0) break block10;
                                        if (!(oc5fe36d3bb52.\u057f instanceof EntityItem)) break block11;
                                        itemStack2 = ((EntityItem)this.\u057f).getEntityItem();
                                        itemStack = itemStack2;
                                        if (n2 != 0) break block12;
                                        if (itemStack != null) break block13;
                                        n3 = -1;
                                        break block14;
                                    }
                                    itemStack = itemStack2;
                                }
                                n3 = itemStack.stackSize;
                            }
                            return n3;
                        }
                        oc5fe36d3bb52 = this;
                    }
                    occ2ace216f93 = oc5fe36d3bb52.\u03f7();
                    occ2ace216f92 = occ2ace216f93;
                    if (n2 != 0) break block15;
                    if (occ2ace216f92 != null) break block16;
                    n = -1;
                    break block17;
                }
                occ2ace216f92 = occ2ace216f93;
            }
            n = occ2ace216f92.\u0261;
        }
        return n;
    }

    public boolean \u010c() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc7ab2161b9f.\u0180(oc5fe36d3bb52.\u057f);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public int \u043a() {
        int n;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                n = ((EntityLivingBase)oc5fe36d3bb52.\u057f).maxHurtTime;
                break block6;
            }
            n = -1;
        }
        return n;
    }

    public String \u0257() {
        String string;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    string = "";
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            string = oc5fe36d3bb52.\u057f.getName();
        }
        return string;
    }

    public String \u00e9() {
        String string;
        block12: {
            Entity entity;
            block10: {
                block11: {
                    oc5fe36d3bb5 oc5fe36d3bb52;
                    block8: {
                        block9: {
                            int n = occ0b63c0426.\u039f;
                            oc5fe36d3bb52 = this;
                            if (n != 0) break block8;
                            if (oc5fe36d3bb52.\u057f == null) break block9;
                            entity = this.\u057f;
                            if (n != 0) break block10;
                            if (entity.getDisplayName() != null) break block11;
                        }
                        oc5fe36d3bb52 = this;
                    }
                    string = oc5fe36d3bb52.\u0257();
                    break block12;
                }
                entity = this.\u057f;
            }
            string = entity.getDisplayName().getUnformattedText();
        }
        return string;
    }

    public int \u017e() {
        int n;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                n = ((EntityLivingBase)oc5fe36d3bb52.\u057f).hurtTime;
                break block6;
            }
            n = -1;
        }
        return n;
    }

    public float \u00c1() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityLivingBase)oc5fe36d3bb52.\u057f).getHealth();
                break block6;
            }
            f = -1.0f;
        }
        return f;
    }

    public float \u022d() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityLivingBase)oc5fe36d3bb52.\u057f).getMaxHealth();
                break block6;
            }
            f = -1.0f;
        }
        return f;
    }

    public double \u010d(ocbf5a535fb8 ocbf5a535fb82) {
        double d;
        block5: {
            block4: {
                if (this.\u057f != null && ocbf5a535fb82 != null) break block4;
                d = Double.MAX_VALUE;
                break block5;
            }
            d = this.\u057f.getDistance(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        }
        return d;
    }

    public double \u03ff(ocbf5a535fb8 ocbf5a535fb82) {
        double d;
        block5: {
            block4: {
                if (this.\u057f != null && ocbf5a535fb82 != null) break block4;
                d = Double.MAX_VALUE;
                break block5;
            }
            d = this.\u057f.getDistanceSq(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        }
        return d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public double \u04e9(oc5fe36d3bb5 oc5fe36d3bb52) {
        oc5fe36d3bb5 oc5fe36d3bb53;
        block12: {
            block13: {
                int n;
                block11: {
                    block10: {
                        n = occ0b63c0426.\u039f;
                        oc5fe36d3bb53 = this;
                        if (n != 0) break block10;
                        if (oc5fe36d3bb53.\u057f == null) return Double.POSITIVE_INFINITY;
                        oc5fe36d3bb53 = oc5fe36d3bb52;
                    }
                    if (n != 0) break block11;
                    if (oc5fe36d3bb53 == null) return Double.POSITIVE_INFINITY;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                }
                if (n != 0) break block12;
                if (oc5fe36d3bb53.\u057f != null) break block13;
                return Double.POSITIVE_INFINITY;
            }
            oc5fe36d3bb53 = this;
        }
        double d = oc5fe36d3bb53.\u057f.getDistanceToEntity(oc5fe36d3bb52.\u057f);
        return d;
    }

    public boolean \u022dBool() {
        boolean bl;
        block8: {
            block7: {
                Entity entity;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n != 0) break block6;
                    if (!(entity instanceof EntityPlayer)) break block7;
                    entity = this.\u057f;
                }
                bl = ((EntityPlayer)entity).isUsingItem();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean G() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityPlayer)) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = ((EntityPlayer)oc5fe36d3bb52.\u057f).isBlocking();
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public double \u019e() {
        double d = this.\u00da();
        double d2 = this.\u0209();
        return Math.sqrt(d * d + d2 * d2);
    }

    public int \u0207() {
        int n;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                n = ((EntityLivingBase)oc5fe36d3bb52.\u057f).swingProgressInt;
                break block6;
            }
            n = -1;
        }
        return n;
    }

    public float \u04b0() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityLivingBase)oc5fe36d3bb52.\u057f).swingProgress;
                break block6;
            }
            f = 0.0f;
        }
        return f;
    }

    public float \u0447() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!oc5fe36d3bb52.\u053d) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityLivingBase)oc5fe36d3bb52.\u057f).prevSwingProgress;
                break block6;
            }
            f = 0.0f;
        }
        return f;
    }

    public int \u03d2() {
        int n;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n2 != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    n = 0;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            n = oc5fe36d3bb52.\u057f.fireResistance;
        }
        return n;
    }

    public float \u0470() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.prevRotationYaw;
        }
        return f;
    }

    public float \u051f() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.prevRotationPitch;
        }
        return f;
    }

    public void \u03c1(float f) {
        block5: {
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb5 oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.prevRotationYaw = f;
        }
    }

    public void \u04d0(float f) {
        block5: {
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb5 oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.prevRotationPitch = f;
        }
    }

    public boolean \u00cc() {
        boolean bl;
        block8: {
            block7: {
                Entity entity;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n != 0) break block6;
                    if (!(entity instanceof EntityPlayer)) break block7;
                    entity = this.\u057f;
                }
                bl = ((EntityPlayer)entity).capabilities.isCreativeMode;
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public int \u046b() {
        int n;
        block6: {
            block5: {
                Entity entity;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    entity = this.\u057f;
                    if (n2 != 0) break block4;
                    if (!(entity instanceof EntityPlayer)) break block5;
                    entity = this.\u057f;
                }
                n = ((EntityPlayer)entity).getFoodStats().getFoodLevel();
                break block6;
            }
            n = 0;
        }
        return n;
    }

    public float \u023e() {
        float f;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityPlayer)) break block5;
                    oc5fe36d3bb52 = this;
                }
                f = ((EntityPlayer)oc5fe36d3bb52.\u057f).getFoodStats().getSaturationLevel();
                break block6;
            }
            f = 0.0f;
        }
        return f;
    }

    public float \u043d() {
        float f;
        block6: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb52.\u057f != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc5fe36d3bb52 = this;
            }
            f = oc5fe36d3bb52.\u057f.getAir();
        }
        return f;
    }

    public boolean \u00e9Bool() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc5fe36d3bb52.\u057f.isOffsetPositionInLiquid(0.0, 0.0, 0.0);
                if (n != 0) break block8;
                if (bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u04ca() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc7ab2161b9f.\u04a2(oc5fe36d3bb52.\u057f);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u0214() {
        boolean bl;
        block8: {
            block7: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block6;
                    if (oc5fe36d3bb52.\u057f == null) break block7;
                    oc5fe36d3bb52 = this;
                }
                bl = oc7ab2161b9f.\u04c2(oc5fe36d3bb52.\u057f);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public oc5fe36d3bb5 \u04db() {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (!(oc5fe36d3bb52.\u057f instanceof EntityFishHook)) break block5;
                oc5fe36d3bb52 = oc5fe36d3bb5.\u0277(((EntityFishHook)this.\u057f).angler);
            }
            return oc5fe36d3bb52;
        }
        return null;
    }

    public List<Object[]> \u0525() {
        ArrayList<Object[]> arrayList;
        block10: {
            ArrayList<Object[]> arrayList2;
            block9: {
                oc5fe36d3bb5 oc5fe36d3bb52;
                int n;
                block8: {
                    arrayList2 = new ArrayList<Object[]>();
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb52 = this;
                    if (n != 0) break block8;
                    if (!(oc5fe36d3bb52.\u057f instanceof EntityLivingBase)) break block9;
                    oc5fe36d3bb52 = this;
                }
                for (PotionEffect potionEffect : ((EntityLivingBase)oc5fe36d3bb52.\u057f).getActivePotionEffects()) {
                    arrayList = arrayList2;
                    if (n == 0) {
                        Object[] objectArray = new Object[0x5F8A6F1A ^ 0x5F8A6F1E];
                        objectArray[0] = potionEffect.getPotionID();
                        objectArray[1] = potionEffect.getEffectName();
                        objectArray[0x5F8A6F1C ^ 0x5F8A6F1E] = potionEffect.getAmplifier();
                        objectArray[0x5F8A6F1D ^ 0x5F8A6F1E] = potionEffect.getDuration();
                        arrayList.add(objectArray);
                        if (n == 0) continue;
                        break;
                    }
                    break block10;
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public occ2ace216f9 \u0218(int n) {
        occ2ace216f9 occ2ace216f92;
        block9: {
            block7: {
                int n2;
                block8: {
                    int n3;
                    block6: {
                        n3 = occ0b63c0426.\u039f;
                        n2 = this.\u057f instanceof EntityPlayer;
                        if (n3 != 0) break block6;
                        if (n2 == 0) break block7;
                        n2 = n;
                    }
                    if (n3 != 0) break block8;
                    if (n2 < 0) break block7;
                    n2 = n;
                }
                if (n2 >= (0xE240CC89 ^ 0xE240CC8D)) break block7;
                occ2ace216f92 = occ2ace216f9.\u0256(((EntityPlayer)this.\u057f).inventory.armorInventory[n]);
                break block9;
            }
            occ2ace216f92 = null;
        }
        return occ2ace216f92;
    }

    public ocbf5a535fb8 \u0216() {
        ocbf5a535fb8 ocbf5a535fb82 = this.\u057f == null ? null : new ocbf5a535fb8(this.\u057f.motionX, this.\u057f.motionY, this.\u057f.motionZ);
        return ocbf5a535fb82;
    }

    public void \u0162(double d, double d2, double d3) {
        block5: {
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb5 oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                this.\u057f.motionX = d;
                this.\u057f.motionY = d2;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.motionZ = d3;
        }
    }

    public ocbf5a535fb8 \u02ae() {
        ocbf5a535fb8 ocbf5a535fb82 = this.\u057f == null ? null : new ocbf5a535fb8((double)this.\u057f.serverPosX / 32.0, (double)this.\u057f.serverPosY / 32.0, (double)this.\u057f.serverPosZ / 32.0);
        return ocbf5a535fb82;
    }

    public void \u024c(ocbf5a535fb8 ocbf5a535fb82) {
        block4: {
            if (this.\u057f == null || ocbf5a535fb82 == null) break block4;
            this.\u057f.setPosition(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        }
    }

    public void \u023f(ocbf5a535fb8 ocbf5a535fb82) {
        if (ocbf5a535fb82 != null) {
            this.\u027f(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        }
    }

    public void \u027f(double d, double d2, double d3) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setPosition(d, d2, d3);
        }
    }

    public void \u00c3(ocbf5a535fb8 ocbf5a535fb82, float f, float f2) {
        if (ocbf5a535fb82 != null) {
            this.\u045d(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0, f, f2);
        }
    }

    public void \u045d(double d, double d2, double d3, float f, float f2) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setPositionAndRotation(d, d2, d3, f, f2);
        }
    }

    public void \u01ed(ocbf5a535fb8 ocbf5a535fb82, float f, float f2, int n) {
        if (ocbf5a535fb82 != null) {
            this.\u03f7(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0, f, f2, n);
        }
    }

    public void \u03f7(double d, double d2, double d3, float f, float f2, int n) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n2 = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n2 != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setPositionAndRotation2(d, d2, d3, f, f2, n, false);
        }
    }

    public void \u0372(double d, double d2, double d3) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setPosition(d, d2, d3);
        }
    }

    public void \u049d(boolean bl) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setSprinting(bl);
        }
    }

    public void y(boolean bl) {
        block5: {
            oc5fe36d3bb5 oc5fe36d3bb52;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc5fe36d3bb52 = this;
                if (n != 0) break block4;
                if (oc5fe36d3bb52.\u057f == null) break block5;
                oc5fe36d3bb52 = this;
            }
            oc5fe36d3bb52.\u057f.setSneaking(bl);
        }
    }
}

