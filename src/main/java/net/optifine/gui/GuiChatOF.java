/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.src.Config;
import net.optifine.shaders.Shaders;

public class GuiChatOF
extends GuiChat {
    private static final String CMD_RELOAD_SHADERS = "/reloadShaders";
    private static final String CMD_RELOAD_CHUNKS = "/reloadChunks";

    public GuiChatOF(GuiChat guiChat) {
        super(GuiVideoSettings.getGuiChatText(guiChat));
    }

    @Override
    public void sendChatMessage(String string) {
        if (this.checkCustomCommand(string)) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(string);
        } else {
            super.sendChatMessage(string);
        }
    }

    private boolean checkCustomCommand(String string) {
        if (string == null) {
            return false;
        }
        if ((string = string.trim()).equals(CMD_RELOAD_SHADERS)) {
            if (Config.isShaders()) {
                Shaders.uninit();
                Shaders.loadShaderPack();
            }
            return true;
        }
        if (string.equals(CMD_RELOAD_CHUNKS)) {
            this.mc.renderGlobal.loadRenderers();
            return true;
        }
        return false;
    }
}

