/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui;

import com.mojang.realmsclient.gui.ErrorCallback;
import com.mojang.realmsclient.gui.GuiCallback;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import net.minecraft.realms.RealmsButton;

public abstract class LongRunningTask
implements Runnable,
ErrorCallback,
GuiCallback {
    protected RealmsLongRunningMcoTaskScreen longRunningMcoTaskScreen;

    public void setScreen(RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen) {
        this.longRunningMcoTaskScreen = realmsLongRunningMcoTaskScreen;
    }

    @Override
    public void error(String string) {
        this.longRunningMcoTaskScreen.error(string);
    }

    public void setTitle(String string) {
        this.longRunningMcoTaskScreen.setTitle(string);
    }

    public boolean aborted() {
        return this.longRunningMcoTaskScreen.aborted();
    }

    @Override
    public void tick() {
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
    }

    public void init() {
    }

    public void abortTask() {
    }
}

