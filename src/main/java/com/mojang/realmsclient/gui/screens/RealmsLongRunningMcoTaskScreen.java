/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.ErrorCallback;
import com.mojang.realmsclient.gui.LongRunningTask;
import com.mojang.realmsclient.gui.RealmsConstants;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class RealmsLongRunningMcoTaskScreen
extends RealmsScreen
implements ErrorCallback {
    private final int BUTTON_CANCEL_ID = 666;
    private final int BUTTON_BACK_ID = 667;
    private final RealmsScreen lastScreen;
    private final LongRunningTask taskThread;
    private volatile String title = "";
    private volatile boolean error;
    private volatile String errorMessage;
    private volatile boolean aborted;
    private int animTicks;
    private LongRunningTask task;
    private int buttonLength = 212;
    public static final String[] symbols = new String[]{"\u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583", "_ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584", "_ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585", "_ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586", "_ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587", "_ _ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588", "_ _ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587", "_ _ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586", "_ _ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585", "_ \u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584", "\u2583 \u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583", "\u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _", "\u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _", "\u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _", "\u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _", "\u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _ _", "\u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _ _", "\u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _ _", "\u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _ _", "\u2584 \u2585 \u2586 \u2587 \u2588 \u2587 \u2586 \u2585 \u2584 \u2583 _"};

    public RealmsLongRunningMcoTaskScreen(RealmsScreen realmsScreen, LongRunningTask longRunningTask) {
        this.lastScreen = realmsScreen;
        this.task = longRunningTask;
        longRunningTask.setScreen(this);
        this.taskThread = longRunningTask;
    }

    public void start() {
        new Thread((Runnable)this.taskThread, "Realms-long-running-task").start();
    }

    @Override
    public void tick() {
        super.tick();
        ++this.animTicks;
        this.task.tick();
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            this.cancelOrBackButtonClicked();
        }
    }

    @Override
    public void init() {
        this.task.init();
        this.buttonsAdd(RealmsLongRunningMcoTaskScreen.newButton(666, this.width() / 2 - this.buttonLength / 2, RealmsConstants.row(12), this.buttonLength, 20, RealmsLongRunningMcoTaskScreen.getLocalizedString("gui.cancel")));
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (realmsButton.id() == 666 || realmsButton.id() == 667) {
            this.cancelOrBackButtonClicked();
        }
        this.task.buttonClicked(realmsButton);
    }

    private void cancelOrBackButtonClicked() {
        this.aborted = true;
        this.task.abortTask();
        Realms.setScreen(this.lastScreen);
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        this.drawCenteredString(this.title, this.width() / 2, RealmsConstants.row(3), 0xFFFFFF);
        if (!this.error) {
            this.drawCenteredString(symbols[this.animTicks % symbols.length], this.width() / 2, RealmsConstants.row(8), 0x808080);
        }
        if (this.error) {
            this.drawCenteredString(this.errorMessage, this.width() / 2, RealmsConstants.row(8), 0xFF0000);
        }
        super.render(n, n2, f);
    }

    @Override
    public void error(String string) {
        this.error = true;
        this.errorMessage = string;
        this.buttonsClear();
        this.buttonsAdd(RealmsLongRunningMcoTaskScreen.newButton(667, this.width() / 2 - this.buttonLength / 2, this.height() / 4 + 120 + 12, RealmsLongRunningMcoTaskScreen.getLocalizedString("gui.back")));
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public boolean aborted() {
        return this.aborted;
    }
}

