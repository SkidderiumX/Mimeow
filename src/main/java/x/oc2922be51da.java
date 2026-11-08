/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc7ab2161b9f;
import x.oc8eb3e96b6e;
import x.oc9755810e45;
import x.ocdd342096f8;

public class oc2922be51da {
    public static int \u0431;

    private oc2922be51da() {
    }

    public static boolean \u047c() {
        boolean bl;
        block8: {
            block7: {
                int n;
                block6: {
                    n = \u0431;
                    bl = oc7ab2161b9f.\u00d0();
                    if (n != 0) break block6;
                    if (!bl) break block7;
                    bl = Minecraft.getMinecraft().inGameHasFocus;
                }
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u016a(int n) {
        boolean bl;
        block24: {
            int n2;
            block22: {
                block23: {
                    int n3;
                    block20: {
                        block21: {
                            int n4;
                            block18: {
                                block19: {
                                    block16: {
                                        block17: {
                                            n3 = \u0431;
                                            n4 = n;
                                            if (n3 != 0) break block16;
                                            if (n4 != 0) break block17;
                                            return false;
                                        }
                                        n4 = n;
                                    }
                                    if (n3 != 0) break block18;
                                    if (n4 == (0x15FC186E ^ 0x15FC1C43)) break block19;
                                    n2 = n;
                                    if (n3 != 0) break block20;
                                    if (n2 != (0x15FC186D ^ 0x15FC1C43)) break block21;
                                }
                                n4 = oc8eb3e96b6e.\u0533(n) ? 1 : 0;
                            }
                            return n4 != 0;
                        }
                        n2 = n;
                    }
                    if (n3 != 0) break block22;
                    if (n2 < (0x15FC1FAB ^ 0x15FC1C43)) break block23;
                    bl = Mouse.isButtonDown(n - (0x15FC1FAB ^ 0x15FC1C43));
                    break block24;
                }
                n2 = n;
            }
            bl = Keyboard.isKeyDown(n2);
        }
        return bl;
    }

    public static int \u0446(ItemStack itemStack) {
        int n;
        block9: {
            block7: {
                ItemStack itemStack2;
                block8: {
                    int n2;
                    block6: {
                        n2 = \u0431;
                        itemStack2 = itemStack;
                        if (n2 != 0) break block6;
                        if (itemStack2 == null) break block7;
                        itemStack2 = itemStack;
                    }
                    if (n2 != 0) break block8;
                    if (itemStack2.getItem() == null) break block7;
                    itemStack2 = itemStack;
                }
                n = Item.getIdFromItem(itemStack2.getItem());
                break block9;
            }
            n = 0;
        }
        return n;
    }

    public static void \u01df() {
        block14: {
            Minecraft minecraft;
            Minecraft minecraft2;
            block13: {
                boolean bl;
                block12: {
                    int n;
                    block11: {
                        ocdd342096f8 ocdd342096f82;
                        block10: {
                            minecraft2 = Minecraft.getMinecraft();
                            n = \u0431;
                            ocdd342096f82 = oc9755810e45.\u00ff;
                            if (n != 0) break block10;
                            if (ocdd342096f82 == null) break block11;
                            ocdd342096f82 = oc9755810e45.\u00ff;
                        }
                        bl = ocdd342096f82.z$3rzb3dil7uydr();
                        if (n != 0) break block12;
                        if (!bl) break block11;
                        oc9755810e45.\u00ff.\u03d2();
                    }
                    minecraft = minecraft2;
                    if (n != 0) break block13;
                    bl = minecraft.thePlayer.isUsingItem();
                }
                if (!bl) break block14;
                minecraft = minecraft2;
            }
            minecraft.playerController.onStoppedUsingItem(minecraft2.thePlayer);
        }
    }

    public static void \u00e8(KeyBinding keyBinding) {
        keyBinding.incrementPressTime();
    }

    public static void \u023d(KeyBinding keyBinding, int n) {
        keyBinding.setPressTime(n);
    }

    public static void \u0515(GuiContainer guiContainer, int n, int n2, int n3) {
        guiContainer.clickSlot(n, n2, n3);
    }

    public static void \u0446(GuiScreen guiScreen) {
        try {
            guiScreen.pressKey('\u0000', 1);
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Cannot close inventory", iOException);
        }
    }

    public static void \u04bb() {
        while (Mouse.next()) {
        }
        while (Keyboard.next()) {
        }
    }
}

