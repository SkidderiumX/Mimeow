/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.realms;

import java.lang.reflect.Constructor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenRealmsProxy;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsBridge
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private GuiScreen previousScreen;

    public void switchToRealms(GuiScreen guiScreen) {
        this.previousScreen = guiScreen;
        try {
            Class<?> clazz = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
            Constructor<?> constructor = clazz.getDeclaredConstructor(RealmsScreen.class);
            constructor.setAccessible(true);
            Object obj = constructor.newInstance(this);
            Minecraft.getMinecraft().displayGuiScreen(((RealmsScreen)obj).getProxy());
        }
        catch (Exception exception) {
            LOGGER.error("Realms module missing", (Throwable)exception);
        }
    }

    public GuiScreenRealmsProxy getNotificationScreen(GuiScreen guiScreen) {
        try {
            this.previousScreen = guiScreen;
            Class<?> clazz = Class.forName("com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen");
            Constructor<?> constructor = clazz.getDeclaredConstructor(RealmsScreen.class);
            constructor.setAccessible(true);
            Object obj = constructor.newInstance(this);
            return ((RealmsScreen)obj).getProxy();
        }
        catch (Exception exception) {
            LOGGER.error("Realms module missing", (Throwable)exception);
            return null;
        }
    }

    @Override
    public void init() {
        Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
    }
}

