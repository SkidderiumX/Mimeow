/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;

public class RealmsEditBox {
    private final GuiTextField editBox;

    public RealmsEditBox(int n, int n2, int n3, int n4, int n5) {
        this.editBox = new GuiTextField(n, Minecraft.getMinecraft().fontRendererObj, n2, n3, n4, n5);
    }

    public String getValue() {
        return this.editBox.getText();
    }

    public void tick() {
        this.editBox.updateCursorCounter();
    }

    public void setFocus(boolean bl) {
        this.editBox.setFocused(bl);
    }

    public void setValue(String string) {
        this.editBox.setText(string);
    }

    public void keyPressed(char c, int n) {
        this.editBox.textboxKeyTyped(c, n);
    }

    public boolean isFocused() {
        return this.editBox.isFocused();
    }

    public void mouseClicked(int n, int n2, int n3) {
        this.editBox.mouseClicked(n, n2, n3);
    }

    public void render() {
        this.editBox.drawTextBox();
    }

    public void setMaxLength(int n) {
        this.editBox.setMaxStringLength(n);
    }

    public void setIsEditable(boolean bl) {
        this.editBox.setEnabled(bl);
    }
}

