/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.BooleanSupplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import x.oc75d51ec7eb;

public class oc6111f05032 {
    private final Minecraft \u01ce;
    private BooleanSupplier \u01d8 = () -> false;
    public static boolean \u027e;

    public oc6111f05032(Minecraft minecraft) {
        this.\u01ce = minecraft;
    }

    public Minecraft \u0128() {
        return this.\u01ce;
    }

    public EntityPlayerSP \u016d() {
        return this.\u01ce.thePlayer;
    }

    public WorldClient X() {
        return this.\u01ce.theWorld;
    }

    public boolean \u0544() {
        boolean bl;
        block8: {
            block7: {
                oc6111f05032 oc6111f050322;
                block6: {
                    int n = oc75d51ec7eb.\u03e9;
                    oc6111f050322 = this;
                    if (n != 0) break block6;
                    if (oc6111f050322.\u016d() == null) break block7;
                    oc6111f050322 = this;
                }
                if (oc6111f050322.X() == null) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public void \u043f(BooleanSupplier booleanSupplier) {
        this.\u01d8 = booleanSupplier;
    }

    public boolean \u044f() {
        boolean bl;
        block13: {
            block11: {
                oc6111f05032 oc6111f050322;
                int n;
                block12: {
                    block10: {
                        n = oc75d51ec7eb.\u03e9;
                        oc6111f050322 = this;
                        if (n != 0) break block10;
                        if (!oc6111f050322.\u0544()) break block11;
                        oc6111f050322 = this;
                    }
                    if (n != 0) break block12;
                    if (!oc6111f050322.\u01ce.inGameHasFocus) break block11;
                    oc6111f050322 = this;
                }
                bl = oc6111f050322.\u01d8.getAsBoolean();
                if (n != 0) break block13;
                if (bl) break block11;
                bl = true;
                break block13;
            }
            bl = false;
        }
        return bl;
    }
}

