/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import x.oc75d51ec7eb;

public class ocb554f4d108 {
    private static EntityPlayer \u01b5;
    private static int P;
    public static boolean \u01e3;

    private ocb554f4d108() {
    }

    public static void \u0525(EntityPlayer entityPlayer) {
        block4: {
            if (entityPlayer != Minecraft.getMinecraft().thePlayer || P++ != 0) break block4;
            \u01b5 = entityPlayer;
        }
    }

    public static void \u029b(EntityPlayer entityPlayer) {
        int n;
        block8: {
            block9: {
                block7: {
                    int n2 = oc75d51ec7eb.\u03e9;
                    if (entityPlayer != \u01b5) break block7;
                    n = P;
                    if (n2 != 0) break block8;
                    if (n > 0) break block9;
                }
                return;
            }
            n = P = P - 1;
        }
        if (n == 0) {
            \u01b5 = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean \u01fe(EntityPlayer entityPlayer, ItemStack itemStack) {
        Minecraft minecraft;
        int n;
        block17: {
            ItemStack itemStack2;
            block16: {
                EntityPlayer entityPlayer2;
                block15: {
                    n = oc75d51ec7eb.\u03e9;
                    entityPlayer2 = entityPlayer;
                    if (n != 0) break block15;
                    if (entityPlayer2 == null) return false;
                    entityPlayer2 = entityPlayer;
                }
                if (entityPlayer2 != \u01b5) return false;
                itemStack2 = itemStack;
                if (n != 0) break block16;
                if (itemStack2 == null) return false;
                itemStack2 = itemStack;
            }
            if (itemStack2.getItemUseAction() != EnumAction.BLOCK) {
                return false;
            }
            Minecraft minecraft2 = Minecraft.getMinecraft();
            minecraft = minecraft2;
            if (n != 0) break block17;
            if (minecraft.getItemRenderer() == null) return false;
            minecraft = minecraft2;
        }
        boolean bl = minecraft.getItemRenderer().isRenderItemInUse();
        if (n != 0) return bl;
        if (!bl) return false;
        return true;
    }
}

