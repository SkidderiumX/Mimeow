/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;

public class GuiConfirmOpenLink
extends GuiYesNo {
    private final String openLinkWarning;
    private final String copyLinkButtonText;
    private final String linkText;
    private boolean showSecurityWarning = true;

    public GuiConfirmOpenLink(GuiYesNoCallback guiYesNoCallback, String string, int n, boolean bl) {
        super(guiYesNoCallback, I18n.format(bl ? "chat.link.confirmTrusted" : "chat.link.confirm", new Object[0]), string, n);
        this.confirmButtonText = I18n.format(bl ? "chat.link.open" : "gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format(bl ? "gui.cancel" : "gui.no", new Object[0]);
        this.copyLinkButtonText = I18n.format("chat.copy", new Object[0]);
        this.openLinkWarning = I18n.format("chat.link.warning", new Object[0]);
        this.linkText = string;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 105, this.height / 6 + 96, 100, 20, this.confirmButtonText));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, this.height / 6 + 96, 100, 20, this.copyLinkButtonText));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50 + 105, this.height / 6 + 96, 100, 20, this.cancelButtonText));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 2) {
            this.copyLinkToClipboard();
        }
        this.parentScreen.confirmClicked(guiButton.id == 0, this.parentButtonClickedId);
    }

    public void copyLinkToClipboard() {
        GuiConfirmOpenLink.setClipboardString(this.linkText);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        if (this.showSecurityWarning) {
            this.drawCenteredString(this.fontRendererObj, this.openLinkWarning, this.width / 2, 110, 0xFFCCCC);
        }
    }

    public void disableSecurityWarning() {
        this.showSecurityWarning = false;
    }
}

