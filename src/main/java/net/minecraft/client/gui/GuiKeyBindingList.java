/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.ArrayUtils;

public class GuiKeyBindingList
extends GuiListExtended {
    private final GuiControls field_148191_k;
    private final Minecraft mc;
    private final GuiListExtended.IGuiListEntry[] listEntries;
    private int maxListLabelWidth = 0;

    public GuiKeyBindingList(GuiControls guiControls, Minecraft minecraft) {
        super(minecraft, guiControls.width, guiControls.height, 63, guiControls.height - 32, 20);
        this.field_148191_k = guiControls;
        this.mc = minecraft;
        KeyBinding[] keyBindingArray = ArrayUtils.clone(minecraft.gameSettings.keyBindings);
        this.listEntries = new GuiListExtended.IGuiListEntry[keyBindingArray.length + KeyBinding.getKeybinds().size()];
        Arrays.sort(keyBindingArray);
        int n = 0;
        String string = null;
        for (KeyBinding keyBinding : keyBindingArray) {
            int n2;
            String string2 = keyBinding.getKeyCategory();
            if (!string2.equals(string)) {
                string = string2;
                this.listEntries[n++] = new CategoryEntry(string2);
            }
            if ((n2 = minecraft.fontRendererObj.getStringWidth(I18n.format(keyBinding.getKeyDescription(), new Object[0]))) > this.maxListLabelWidth) {
                this.maxListLabelWidth = n2;
            }
            this.listEntries[n++] = new KeyEntry(keyBinding);
        }
    }

    @Override
    protected int getSize() {
        return this.listEntries.length;
    }

    @Override
    public GuiListExtended.IGuiListEntry getListEntry(int n) {
        return this.listEntries[n];
    }

    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 15;
    }

    @Override
    public int getListWidth() {
        return super.getListWidth() + 32;
    }

    public class CategoryEntry
    implements GuiListExtended.IGuiListEntry {
        private final String labelText;
        private final int labelWidth;

        public CategoryEntry(String string) {
            this.labelText = I18n.format(string, new Object[0]);
            this.labelWidth = GuiKeyBindingList.this.mc.fontRendererObj.getStringWidth(this.labelText);
        }

        @Override
        public void drawEntry(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.labelText, GuiKeyBindingList.this.mc.currentScreen.width / 2 - this.labelWidth / 2, n3 + n5 - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT - 1, 0xFFFFFF);
        }

        @Override
        public boolean mousePressed(int n, int n2, int n3, int n4, int n5, int n6) {
            return false;
        }

        @Override
        public void mouseReleased(int n, int n2, int n3, int n4, int n5, int n6) {
        }

        @Override
        public void setSelected(int n, int n2, int n3) {
        }
    }

    public class KeyEntry
    implements GuiListExtended.IGuiListEntry {
        private final KeyBinding keybinding;
        private final String keyDesc;
        private final GuiButton btnChangeKeyBinding;
        private final GuiButton btnReset;

        private KeyEntry(KeyBinding keyBinding) {
            this.keybinding = keyBinding;
            this.keyDesc = I18n.format(keyBinding.getKeyDescription(), new Object[0]);
            this.btnChangeKeyBinding = new GuiButton(0, 0, 0, 75, 20, I18n.format(keyBinding.getKeyDescription(), new Object[0]));
            this.btnReset = new GuiButton(0, 0, 0, 50, 20, I18n.format("controls.reset", new Object[0]));
        }

        @Override
        public void drawEntry(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
            boolean bl2 = GuiKeyBindingList.this.field_148191_k.buttonId == this.keybinding;
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.keyDesc, n2 + 90 - GuiKeyBindingList.this.maxListLabelWidth, n3 + n5 / 2 - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT / 2, 0xFFFFFF);
            this.btnReset.xPosition = n2 + 190;
            this.btnReset.yPosition = n3;
            this.btnReset.enabled = this.keybinding.getKeyCode() != this.keybinding.getKeyCodeDefault();
            this.btnReset.drawButton(GuiKeyBindingList.this.mc, n6, n7);
            this.btnChangeKeyBinding.xPosition = n2 + 105;
            this.btnChangeKeyBinding.yPosition = n3;
            this.btnChangeKeyBinding.displayString = GameSettings.getKeyDisplayString(this.keybinding.getKeyCode());
            boolean bl3 = false;
            if (this.keybinding.getKeyCode() != 0) {
                for (KeyBinding keyBinding : GuiKeyBindingList.this.mc.gameSettings.keyBindings) {
                    if (keyBinding == this.keybinding || keyBinding.getKeyCode() != this.keybinding.getKeyCode()) continue;
                    bl3 = true;
                    break;
                }
            }
            if (bl2) {
                this.btnChangeKeyBinding.displayString = String.valueOf((Object)EnumChatFormatting.WHITE) + "> " + String.valueOf((Object)EnumChatFormatting.YELLOW) + this.btnChangeKeyBinding.displayString + String.valueOf((Object)EnumChatFormatting.WHITE) + " <";
            } else if (bl3) {
                this.btnChangeKeyBinding.displayString = String.valueOf((Object)EnumChatFormatting.RED) + this.btnChangeKeyBinding.displayString;
            }
            this.btnChangeKeyBinding.drawButton(GuiKeyBindingList.this.mc, n6, n7);
        }

        @Override
        public boolean mousePressed(int n, int n2, int n3, int n4, int n5, int n6) {
            if (this.btnChangeKeyBinding.mousePressed(GuiKeyBindingList.this.mc, n2, n3)) {
                GuiKeyBindingList.this.field_148191_k.buttonId = this.keybinding;
                return true;
            }
            if (this.btnReset.mousePressed(GuiKeyBindingList.this.mc, n2, n3)) {
                GuiKeyBindingList.this.mc.gameSettings.setOptionKeyBinding(this.keybinding, this.keybinding.getKeyCodeDefault());
                KeyBinding.resetKeyBindingArrayAndHash();
                return true;
            }
            return false;
        }

        @Override
        public void mouseReleased(int n, int n2, int n3, int n4, int n5, int n6) {
            this.btnChangeKeyBinding.mouseReleased(n2, n3);
            this.btnReset.mouseReleased(n2, n3);
        }

        @Override
        public void setSelected(int n, int n2, int n3) {
        }
    }
}

