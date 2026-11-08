/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class GuiShareToLan
extends GuiScreen {
    private final GuiScreen field_146598_a;
    private GuiButton field_146596_f;
    private GuiButton field_146597_g;
    private String field_146599_h = "survival";
    private boolean field_146600_i;

    public GuiShareToLan(GuiScreen guiScreen) {
        this.field_146598_a = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("lanServer.start", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.field_146597_g = new GuiButton(104, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.gameMode", new Object[0]));
        this.buttonList.add(this.field_146597_g);
        this.field_146596_f = new GuiButton(103, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0]));
        this.buttonList.add(this.field_146596_f);
        this.func_146595_g();
    }

    private void func_146595_g() {
        this.field_146597_g.displayString = I18n.format("selectWorld.gameMode", new Object[0]) + " " + I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
        this.field_146596_f.displayString = I18n.format("selectWorld.allowCommands", new Object[0]) + " ";
        this.field_146596_f.displayString = this.field_146600_i ? this.field_146596_f.displayString + I18n.format("options.on", new Object[0]) : this.field_146596_f.displayString + I18n.format("options.off", new Object[0]);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 102) {
            this.mc.displayGuiScreen(this.field_146598_a);
        } else if (guiButton.id == 104) {
            this.field_146599_h = this.field_146599_h.equals("spectator") ? "creative" : (this.field_146599_h.equals("creative") ? "adventure" : (this.field_146599_h.equals("adventure") ? "survival" : "spectator"));
            this.func_146595_g();
        } else if (guiButton.id == 103) {
            this.field_146600_i = !this.field_146600_i;
            this.func_146595_g();
        } else if (guiButton.id == 101) {
            this.mc.displayGuiScreen(null);
            String string = this.mc.getIntegratedServer().shareToLAN(WorldSettings.GameType.getByName(this.field_146599_h), this.field_146600_i);
            ChatComponentStyle chatComponentStyle = string != null ? new ChatComponentTranslation("commands.publish.started", string) : new ChatComponentText("commands.publish.failed");
            this.mc.ingameGUI.getChatGUI().printChatMessage(chatComponentStyle);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.title", new Object[0]), this.width / 2, 50, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.otherPlayers", new Object[0]), this.width / 2, 82, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

