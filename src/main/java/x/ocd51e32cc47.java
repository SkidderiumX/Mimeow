/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import x.oc69da1aa7f5;
import x.oce4cea752dd;
import x.oce6044968f8;

public class ocd51e32cc47
extends oc69da1aa7f5 {
    private float \u0424;
    public static int \u04ca;

    public ocd51e32cc47() {
        super("Fullbright", oce4cea752dd.\u014e);
    }

    @Override
    public void onEnable() {
        block5: {
            block4: {
                boolean bl = oce6044968f8.\u0452;
                Minecraft minecraft = oc69da1aa7f5.\u0151;
                if (bl) break block4;
                if (minecraft.gameSettings == null) break block5;
                this.\u0424 = oc69da1aa7f5.\u0151.gameSettings.gammaSetting;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.gameSettings.gammaSetting = 1000.0f;
        }
    }

    @Override
    public void onDisable() {
        block5: {
            block4: {
                boolean bl = oce6044968f8.\u0452;
                Minecraft minecraft = oc69da1aa7f5.\u0151;
                if (bl) break block4;
                if (minecraft.gameSettings == null) break block5;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.gameSettings.gammaSetting = this.\u0424;
        }
    }
}

