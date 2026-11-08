/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.optifine.gui.GuiScreenOF;
import net.optifine.gui.TooltipProvider;

public class TooltipManager {
    private GuiScreen guiScreen;
    private TooltipProvider tooltipProvider;
    private int lastMouseX = 0;
    private int lastMouseY = 0;
    private long mouseStillTime = 0L;

    public TooltipManager(GuiScreen guiScreen, TooltipProvider tooltipProvider) {
        this.guiScreen = guiScreen;
        this.tooltipProvider = tooltipProvider;
    }

    public void drawTooltips(int n, int n2, List list) {
        if (Math.abs(n - this.lastMouseX) <= 5 && Math.abs(n2 - this.lastMouseY) <= 5) {
            GuiButton guiButton;
            int n3 = 700;
            if (System.currentTimeMillis() >= this.mouseStillTime + (long)n3 && (guiButton = GuiScreenOF.getSelectedButton(n, n2, list)) != null) {
                Rectangle rectangle = this.tooltipProvider.getTooltipBounds(this.guiScreen, n, n2);
                String[] stringArray = this.tooltipProvider.getTooltipLines(guiButton, rectangle.width);
                if (stringArray != null) {
                    int n4;
                    if (stringArray.length > 8) {
                        stringArray = Arrays.copyOf(stringArray, 8);
                        stringArray[stringArray.length - 1] = stringArray[stringArray.length - 1] + " ...";
                    }
                    if (this.tooltipProvider.isRenderBorder()) {
                        n4 = -528449408;
                        this.drawRectBorder(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height, n4);
                    }
                    Gui.drawRect(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height, -536870912);
                    for (n4 = 0; n4 < stringArray.length; ++n4) {
                        String string = stringArray[n4];
                        int n5 = 0xDDDDDD;
                        if (string.endsWith("!")) {
                            n5 = 0xFF2020;
                        }
                        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
                        fontRenderer.drawStringWithShadow(string, rectangle.x + 5, rectangle.y + 5 + n4 * 11, n5);
                    }
                }
            }
        } else {
            this.lastMouseX = n;
            this.lastMouseY = n2;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }

    private void drawRectBorder(int n, int n2, int n3, int n4, int n5) {
        Gui.drawRect(n, n2 - 1, n3, n2, n5);
        Gui.drawRect(n, n4, n3, n4 + 1, n5);
        Gui.drawRect(n - 1, n2, n, n4, n5);
        Gui.drawRect(n3, n2, n3 + 1, n4, n5);
    }
}

