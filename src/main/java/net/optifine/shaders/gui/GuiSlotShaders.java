/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.gui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.gui.GuiShaders;
import net.optifine.util.ResUtils;

public class GuiSlotShaders
extends GuiSlot {
    private ArrayList shaderslist;
    private int selectedIndex;
    private long lastClickedCached = 0L;
    final GuiShaders shadersGui;

    public GuiSlotShaders(GuiShaders guiShaders, int n, int n2, int n3, int n4, int n5) {
        super(guiShaders.getMc(), n, n2, n3, n4, n5);
        this.shadersGui = guiShaders;
        this.updateList();
        this.amountScrolled = 0.0f;
        int n6 = this.selectedIndex * n5;
        int n7 = (n4 - n3) / 2;
        if (n6 > n7) {
            this.scrollBy(n6 - n7);
        }
    }

    @Override
    public int getListWidth() {
        return this.width - 20;
    }

    public void updateList() {
        this.shaderslist = Shaders.listOfShaders();
        this.selectedIndex = 0;
        int n = this.shaderslist.size();
        for (int i = 0; i < n; ++i) {
            if (!((String)this.shaderslist.get(i)).equals(Shaders.currentShaderName)) continue;
            this.selectedIndex = i;
            break;
        }
    }

    @Override
    protected int getSize() {
        return this.shaderslist.size();
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
        String string;
        IShaderPack iShaderPack;
        if ((n != this.selectedIndex || this.lastClicked != this.lastClickedCached) && this.checkCompatible(iShaderPack = Shaders.getShaderPack(string = (String)this.shaderslist.get(n)), n)) {
            this.selectIndex(n);
        }
    }

    private void selectIndex(int n) {
        this.selectedIndex = n;
        this.lastClickedCached = this.lastClicked;
        Shaders.setShaderPack((String)this.shaderslist.get(n));
        Shaders.uninit();
        this.shadersGui.updateButtons();
    }

    private boolean checkCompatible(IShaderPack iShaderPack, final int n) {
        if (iShaderPack == null) {
            return true;
        }
        InputStream inputStream2 = iShaderPack.getResourceAsStream("/shaders/shaders.properties");
        Properties properties = ResUtils.readProperties(inputStream2, "Shaders");
        if (properties == null) {
            return true;
        }
        String string = "version.1.8.9";
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            return true;
        }
        String string3 = "M6_pre2";
        int n2 = Config.compareRelease(string3, string2 = string2.trim());
        if (n2 >= 0) {
            return true;
        }
        String string4 = ("HD_U_" + string2).replace('_', ' ');
        String string5 = I18n.format("of.message.shaders.nv1", string4);
        String string6 = I18n.format("of.message.shaders.nv2", new Object[0]);
        GuiYesNoCallback guiYesNoCallback = new GuiYesNoCallback(){

            @Override
            public void confirmClicked(boolean bl, int n2) {
                if (bl) {
                    GuiSlotShaders.this.selectIndex(n);
                }
                GuiSlotShaders.this.mc.displayGuiScreen(GuiSlotShaders.this.shadersGui);
            }
        };
        GuiYesNo guiYesNo = new GuiYesNo(guiYesNoCallback, string5, string6, 0);
        this.mc.displayGuiScreen(guiYesNo);
        return false;
    }

    @Override
    protected boolean isSelected(int n) {
        return n == this.selectedIndex;
    }

    @Override
    protected int getScrollBarX() {
        return this.width - 6;
    }

    @Override
    protected int getContentHeight() {
        return this.getSize() * 18;
    }

    @Override
    protected void drawBackground() {
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        String string = (String)this.shaderslist.get(n);
        if (string.equals("OFF")) {
            string = Lang.get("of.options.shaders.packNone");
        } else if (string.equals("(internal)")) {
            string = Lang.get("of.options.shaders.packDefault");
        }
        this.shadersGui.drawCenteredString(string, this.width / 2, n3 + 1, 0xE0E0E0);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }
}

