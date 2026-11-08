/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MathHelper;
import x.oc69da1aa7f5;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc9ee35e7bd8
extends oc69da1aa7f5 {
    private float H;
    private float \u0267;
    private boolean \u0407;
    public static int \u0129;

    public oc9ee35e7bd8() {
        super("FreeLook", oce4cea752dd.\u014e);
        this.\u0105("Lets you look around without changing player rotation.");
    }

    @Override
    public void onEnable() {
        block9: {
            block10: {
                boolean bl;
                block8: {
                    bl = oce6044968f8.\u0452;
                    EntityPlayerSP entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                    if (bl) break block8;
                    if (entityPlayerSP == null) break block9;
                    this.H = entityPlayerSP.rotationYaw;
                    this.\u0267 = entityPlayerSP.rotationPitch;
                    this.\u0407 = true;
                }
                Minecraft minecraft = oc69da1aa7f5.\u0151;
                if (bl) break block10;
                if (minecraft.gameSettings.thirdPersonView != 0) break block9;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.gameSettings.thirdPersonView = 1;
        }
    }

    @Override
    public void onDisable() {
        block5: {
            block4: {
                this.\u0407 = false;
                boolean bl = oce6044968f8.\u0452;
                Minecraft minecraft = oc69da1aa7f5.\u0151;
                if (bl) break block4;
                if (minecraft.gameSettings.thirdPersonView == 0) break block5;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.gameSettings.thirdPersonView = 0;
        }
    }

    public boolean \u00d6() {
        boolean bl;
        block10: {
            block9: {
                oc9ee35e7bd8 oc9ee35e7bd82;
                block8: {
                    boolean bl2 = oce6044968f8.\u0452;
                    oc9ee35e7bd82 = this;
                    if (bl2) break block8;
                    if (!oc9ee35e7bd82.z$3rzb3dil7uydr()) break block9;
                    oc9ee35e7bd82 = this;
                }
                if (!oc9ee35e7bd82.\u0407 || oc69da1aa7f5.\u0151.thePlayer == null) break block9;
                bl = true;
                break block10;
            }
            bl = false;
        }
        return bl;
    }

    public void \u02af(float f, float f2) {
        this.H += f * 0.15f;
        this.\u0267 = MathHelper.clamp_float(this.\u0267 - f2 * 0.15f, -90.0f, 90.0f);
    }

    public float \u0219() {
        return this.H;
    }

    public float \u03b7() {
        return this.\u0267;
    }
}

