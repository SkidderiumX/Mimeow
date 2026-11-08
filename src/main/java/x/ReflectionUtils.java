/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import org.lwjgl.input.Mouse;
import x.MouseEvent;
import x.oc8e5a0b9bfa;
import x.ocea775c9d5c;

public class ReflectionUtils {
    public static Field button;
    public static Field buttonstate;
    public static Field buttons;
    public static HashMap<Class, Field> containerInventoryPlayer;
    private static List<Class> containerClasses;
    public static boolean ERROR;
    public static Map<String, KeyBinding> keybinds;

    public static void setupFields() {
        try {
            button = MouseEvent.class.getDeclaredField("button");
            buttonstate = MouseEvent.class.getDeclaredField("buttonstate");
            buttons = Mouse.class.getDeclaredField("buttons");
            for (Class clazz : containerClasses) {
                for (Field field : clazz.getDeclaredFields()) {
                    ReflectionUtils.addToMap(clazz, field);
                }
            }
        }
        catch (Exception exception) {
            System.out.println("There was an error, relaunch the game.");
            exception.printStackTrace();
            ERROR = true;
        }
    }

    public static void setKeyBindings() {
        for (KeyBinding keyBinding : Minecraft.getMinecraft().gameSettings.keyBindings) {
            String string = keyBinding.getKeyDescription().replaceFirst("key\\.", "");
            keybinds.put(string, keyBinding);
        }
    }

    public static void setButton(int n, boolean bl) {
        if (button != null && buttonstate != null && buttons != null) {
            MouseEvent mouseEvent = new MouseEvent();
            try {
                button.setAccessible(true);
                button.set(mouseEvent, n);
                buttonstate.setAccessible(true);
                buttonstate.set(mouseEvent, bl);
                ocea775c9d5c.\u0173.post(mouseEvent);
                buttons.setAccessible(true);
                ByteBuffer byteBuffer = (ByteBuffer)buttons.get(null);
                buttons.setAccessible(false);
                byteBuffer.put(n, (byte)(bl ? 1 : 0));
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    private static void addToMap(Class clazz, Field field) {
        if (field == null || field.getType() != IInventory.class) {
            return;
        }
        if ((field = oc8e5a0b9bfa.\u020a(clazz, field.getName())) == null) {
            return;
        }
        field.setAccessible(true);
        containerInventoryPlayer.put(clazz, field);
    }

    public static boolean setItemInUse(boolean bl) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.getItemRenderer() != null) {
            minecraft.getItemRenderer().setRenderItemInUse(bl);
        }
        return bl;
    }

    static {
        containerInventoryPlayer = new HashMap();
        Class[] classArray = new Class[0x52668054 ^ 0x5266805C];
        classArray[0] = GuiFurnace.class;
        classArray[1] = GuiBrewingStand.class;
        classArray[0x5266805E ^ 0x5266805C] = GuiEnchantment.class;
        classArray[0x5266805F ^ 0x5266805C] = ContainerHopper.class;
        classArray[0x52668058 ^ 0x5266805C] = GuiDispenser.class;
        classArray[0x52668059 ^ 0x5266805C] = ContainerWorkbench.class;
        classArray[0x5266805A ^ 0x5266805C] = ContainerMerchant.class;
        classArray[0x5266805B ^ 0x5266805C] = ContainerHorseInventory.class;
        containerClasses = Arrays.asList(classArray);
        ERROR = false;
        keybinds = new HashMap<String, KeyBinding>();
    }
}

