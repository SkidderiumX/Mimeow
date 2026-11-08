/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.viamcp.gui;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;

public class AsyncVersionSlider
extends GuiButton {
    private final List<ProtocolVersion> values = new ArrayList<ProtocolVersion>(ViaLoadingBase.PROTOCOLS);
    private float sliderValue;
    private boolean dragging;

    public AsyncVersionSlider(int n, int n2, int n3, int n4, int n5) {
        super(n, n2, n3, Math.max(n4, 110), n5, "");
        Collections.reverse(this.values);
        ProtocolVersion protocolVersion = ViaLoadingBase.getInstance().getTargetVersion();
        int n6 = Math.max(0, this.values.indexOf(protocolVersion));
        this.sliderValue = this.values.size() <= 1 ? 0.0f : (float)n6 / (float)(this.values.size() - 1);
        this.updateDisplay(n6);
        this.enabled = this.values.size() > 1;
    }

    @Override
    protected int getHoverState(boolean bl) {
        return 0;
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (!this.visible) {
            return;
        }
        if (this.dragging) {
            this.selectFromMouse(n);
        }
        minecraft.getTextureManager().bindTexture(buttonTextures);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = this.xPosition + (int)(this.sliderValue * (float)(this.width - 8));
        this.drawTexturedModalRect(n3, this.yPosition, 0, 66, 4, 20);
        this.drawTexturedModalRect(n3 + 4, this.yPosition, 196, 66, 4, 20);
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (!super.mousePressed(minecraft, n, n2)) {
            return false;
        }
        this.selectFromMouse(n);
        this.dragging = true;
        return true;
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.dragging = false;
    }

    private void selectFromMouse(int n) {
        if (this.values.isEmpty()) {
            return;
        }
        this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
        this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0f, 1.0f);
        int n2 = Math.min(this.values.size() - 1, (int)Math.ceil(this.sliderValue * (float)(this.values.size() - 1)));
        ProtocolVersion protocolVersion = this.values.get(n2);
        this.updateDisplay(n2);
        ViaLoadingBase.getInstance().reload(protocolVersion);
    }

    private void updateDisplay(int n) {
        this.displayString = this.values.isEmpty() ? "Via unavailable" : this.values.get(n).getName();
    }
}

