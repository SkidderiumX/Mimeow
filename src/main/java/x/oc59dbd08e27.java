/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import x.oc5e549848f3;

public class oc59dbd08e27 {
    public final Entity \u050c;
    public final boolean \u041f;
    public static boolean \u04f7;

    oc59dbd08e27(Entity entity) {
        this.\u050c = entity;
        this.\u041f = entity instanceof EntityLivingBase;
    }

    public float \u02b4() {
        float f;
        block6: {
            block5: {
                oc59dbd08e27 oc59dbd08e272;
                block4: {
                    int n = oc5e549848f3.\u0130;
                    oc59dbd08e272 = this;
                    if (n != 0) break block4;
                    if (!oc59dbd08e272.\u041f) break block5;
                    oc59dbd08e272 = this;
                }
                f = ((EntityLivingBase)oc59dbd08e272.\u050c).getMaxHealth();
                break block6;
            }
            f = 20.0f;
        }
        return f;
    }

    public float \u03ce() {
        float f;
        block6: {
            block5: {
                oc59dbd08e27 oc59dbd08e272;
                block4: {
                    int n = oc5e549848f3.\u0130;
                    oc59dbd08e272 = this;
                    if (n != 0) break block4;
                    if (!oc59dbd08e272.\u041f) break block5;
                    oc59dbd08e272 = this;
                }
                f = ((EntityLivingBase)oc59dbd08e272.\u050c).getHealth();
                break block6;
            }
            f = 20.0f;
        }
        return f;
    }

    public boolean \u0193() {
        boolean bl;
        block10: {
            block8: {
                Minecraft minecraft;
                block9: {
                    int n = oc5e549848f3.\u0130;
                    if (this.\u050c == null) break block8;
                    minecraft = Minecraft.getMinecraft();
                    if (n != 0) break block9;
                    if (minecraft.theWorld == null) break block8;
                    minecraft = Minecraft.getMinecraft();
                }
                if (minecraft.theWorld.getEntityByID(this.\u050c.getEntityId()) == null) break block8;
                bl = true;
                break block10;
            }
            bl = false;
        }
        return bl;
    }
}

