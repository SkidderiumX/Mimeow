/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.IProgressUpdate;
import net.optifine.CustomLoadingScreen;
import net.optifine.CustomLoadingScreens;

public class GuiScreenWorking
extends GuiScreen
implements IProgressUpdate {
    private String field_146591_a = "";
    private String field_146589_f = "";
    private int progress;
    private boolean doneWorking;
    private CustomLoadingScreen customLoadingScreen = CustomLoadingScreens.getCustomLoadingScreen();

    @Override
    public void displaySavingString(String string) {
        this.resetProgressAndMessage(string);
    }

    @Override
    public void resetProgressAndMessage(String string) {
        this.field_146591_a = string;
        this.displayLoadingString("Working...");
    }

    @Override
    public void displayLoadingString(String string) {
        this.field_146589_f = string;
        this.setLoadingProgress(0);
    }

    @Override
    public void setLoadingProgress(int n) {
        this.progress = n;
    }

    @Override
    public void setDoneWorking() {
        this.doneWorking = true;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.doneWorking) {
            if (!this.mc.isConnectedToRealms()) {
                this.mc.displayGuiScreen(null);
            }
        } else {
            if (this.customLoadingScreen != null && this.mc.theWorld == null) {
                this.customLoadingScreen.drawBackground(this.width, this.height);
            } else {
                this.drawDefaultBackground();
            }
            if (this.progress > 0) {
                this.drawCenteredString(this.fontRendererObj, this.field_146591_a, this.width / 2, 70, 0xFFFFFF);
                this.drawCenteredString(this.fontRendererObj, this.field_146589_f + " " + this.progress + "%", this.width / 2, 90, 0xFFFFFF);
            }
            super.drawScreen(n, n2, f);
        }
    }
}

