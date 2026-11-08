/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import x.oc1378bc114d;
import x.oc34bba7044e;
import x.oc42c8f83828;
import x.oc99b8eeba10;
import x.ocbd4917c4b1;
import x.oce6044968f8;

public class GuiNewChat
extends Gui {
    private static final Logger logger = LogManager.getLogger();
    private final Minecraft mc;
    private final List<String> sentMessages = Lists.newArrayList();
    private final List<ChatLine> chatLines = Lists.newArrayList();
    private final List<ChatLine> drawnChatLines = Lists.newArrayList();
    private int scrollPos;
    private boolean isScrolled;
    private final Map<ChatLine, Long> chatLineCreationTimes = new IdentityHashMap<ChatLine, Long>();
    private float animatedScrollPos = 0.0f;
    private long lastChatDrawTime = 0L;
    private String layoutKey = "";

    public GuiNewChat(Minecraft minecraft) {
        this.mc = minecraft;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void drawChat(int n) {
        float f;
        if (this.mc.gameSettings.chatVisibility == EntityPlayer.EnumChatVisibility.HIDDEN) {
            return;
        }
        this.syncLayout();
        if (this.drawnChatLines.isEmpty()) {
            return;
        }
        boolean bl = this.getChatOpen();
        float f2 = this.getChatScale();
        if (f2 <= 0.0f) {
            return;
        }
        oc1378bc114d oc1378bc114d2 = oce6044968f8.\u024e(this.mc.fontRendererObj);
        int n2 = GuiNewChat.lineHeight(oc1378bc114d2);
        int n3 = this.getLineCount();
        long l = System.currentTimeMillis();
        float f3 = this.lastChatDrawTime == 0L ? 0.05f : Math.min(0.1f, (float)(l - this.lastChatDrawTime) / 1000.0f);
        this.lastChatDrawTime = l;
        this.animatedScrollPos = oc42c8f83828.\u049c() ? (this.animatedScrollPos += ((float)this.scrollPos - this.animatedScrollPos) * (1.0f - (float)Math.exp(-15.0f * f3))) : (float)this.scrollPos;
        if (Math.abs(this.animatedScrollPos - (float)this.scrollPos) < 0.001f) {
            this.animatedScrollPos = this.scrollPos;
        }
        int n4 = Math.max(0, (int)Math.floor(this.animatedScrollPos));
        float f4 = this.animatedScrollPos - (float)n4;
        float f5 = MathHelper.ceiling_float_int((float)this.getChatWidth() / f2);
        ArrayList<VisibleLine> arrayList = Lists.newArrayList();
        for (int i = 0; n4 + i < this.drawnChatLines.size() && i <= n3; ++i) {
            float f6;
            float f7;
            ChatLine chatLine = this.drawnChatLines.get(n4 + i);
            int n5 = n - chatLine.getUpdatedCounter();
            if (n5 >= 200 && !bl || (f7 = (f6 = bl ? 1.0f : (float)MathHelper.clamp_double((1.0 - (double)n5 / 200.0) * 10.0, 0.0, 1.0)) * f6 * (this.mc.gameSettings.chatOpacity * 0.9f + 0.1f)) <= 0.011764706f) continue;
            float f8 = 0.0f;
            Long l2 = this.chatLineCreationTimes.get(chatLine);
            if (l2 != null && oc42c8f83828.\u026d() != 0) {
                float f9 = MathHelper.clamp_float((float)(l - l2) / (float)Math.max(1L, oc42c8f83828.\u03b3()), 0.0f, 1.0f);
                f = 1.0f - (float)Math.pow(1.0f - f9, 3.0);
                if (oc42c8f83828.\u026d() == 1) {
                    f8 = -24.0f * (1.0f - f);
                } else {
                    f7 *= f;
                }
            }
            if (!(f7 > 0.011764706f)) continue;
            arrayList.add(new VisibleLine(chatLine.getChatComponent().getFormattedText(), f8, (f4 - (float)i - 1.0f) * (float)n2, f7));
        }
        GlStateManager.pushMatrix();
        try {
            GlStateManager.translate(2.0f, 20.0f, 0.0f);
            GlStateManager.scale(f2, f2, 1.0f);
            float f10 = 0.0f;
            float f11 = 0.0f;
            for (VisibleLine visibleLine : arrayList) {
                f10 = Math.min(f10, visibleLine.top);
                f11 = Math.max(f11, visibleLine.alpha);
            }
            float f12 = Math.max((float)(-n3 * n2), f10);
            float f13 = f11;
            Runnable runnable2 = () -> {
                ocbd4917c4b1.\u010e(2.0, (float)(new ScaledResolution(this.mc).getScaledHeight() - 28) - (float)(n3 * n2) * f2, (f5 + 4.0f) * f2, (float)(n3 * n2) * f2);
                try {
                    for (VisibleLine visibleLine : arrayList) {
                        int n3;
                        if (visibleLine.top + (float)n2 <= (float)(-n3 * n2) || visibleLine.top >= 0.0f || (n3 = Math.round(visibleLine.alpha / f13 * 255.0f)) == 0) continue;
                        oc1378bc114d2.z$ao2ykh4tuw6w(visibleLine.text, oce6044968f8.\u01c6() + visibleLine.slide, visibleLine.top + (float)(n2 - oc1378bc114d2.z$1tqmx4tpnr6lq()) / 2.0f, n3 << 24 | 0xFFFFFF, false);
                    }
                }
                finally {
                    ocbd4917c4b1.\u01df();
                }
            };
            if (oc42c8f83828.\u048f() == 0) {
                oce6044968f8.\u0390(new oc99b8eeba10(0.0f, f12, f5 + 4.0f, -f12, f13, runnable2, null), oc42c8f83828.\u0207());
            } else {
                ArrayList<oc99b8eeba10> arrayList2 = Lists.newArrayList();
                for (VisibleLine visibleLine : arrayList) {
                    f = Math.max((float)(-n3 * n2), visibleLine.top);
                    float f14 = Math.min(0.0f, visibleLine.top + (float)n2);
                    if (f14 <= f) continue;
                    arrayList2.add(new oc99b8eeba10(0.0f, f, f5 + 4.0f, f14 - f, visibleLine.alpha, () -> {
                        ocbd4917c4b1.\u010e(2.0, (float)(new ScaledResolution(this.mc).getScaledHeight() - 28) - (float)(n3 * n2) * f2, (f5 + 4.0f) * f2, (float)(n3 * n2) * f2);
                        try {
                            oc1378bc114d2.z$ao2ykh4tuw6w(visibleLine.text, oce6044968f8.\u01c6() + visibleLine.slide, visibleLine.top + (float)(n2 - oc1378bc114d2.z$1tqmx4tpnr6lq()) / 2.0f, -1, false);
                        }
                        finally {
                            ocbd4917c4b1.\u01df();
                        }
                    }, null));
                }
                oce6044968f8.\u0160(arrayList2, oc42c8f83828.\u0207());
            }
            if (bl && this.drawnChatLines.size() > n3) {
                float f15 = this.drawnChatLines.size() * n2;
                float f16 = n3 * n2;
                float f17 = Math.max(4.0f, f16 * f16 / f15);
                f = this.animatedScrollPos / (float)Math.max(1, this.drawnChatLines.size() - n3) * (f16 - f17);
                ocbd4917c4b1.\u0109(-2.0, -f - f17, -1.0, -f, oce6044968f8.\u022d(0.0f, 0.0f));
            }
        }
        finally {
            GlStateManager.popMatrix();
        }
    }

    private void syncLayout() {
        String string = this.mc.fontRendererObj.getUnicodeFlag() + ":" + oce6044968f8.\u01bc() + ":" + this.getChatWidth() + ":" + this.getChatScale() + ":" + oce6044968f8.\u01c6();
        if (!this.layoutKey.equals(string)) {
            this.layoutKey = string;
            int n = this.scrollPos;
            this.refreshChat();
            this.scroll(n);
            this.animatedScrollPos = this.scrollPos;
        }
    }

    private static int lineHeight(oc1378bc114d oc1378bc114d2) {
        return Math.max(1, (int)Math.ceil((float)oc1378bc114d2.z$1tqmx4tpnr6lq() + oce6044968f8.\u0161() * 2.0f));
    }

    public void clearChatMessages() {
        this.drawnChatLines.clear();
        this.chatLines.clear();
        this.sentMessages.clear();
        this.chatLineCreationTimes.clear();
    }

    public void printChatMessage(IChatComponent iChatComponent) {
        this.printChatMessageWithOptionalDeletion(iChatComponent, 0);
    }

    public void printChatMessageWithOptionalDeletion(IChatComponent iChatComponent, int n) {
        this.setChatLine(iChatComponent, n, this.mc.ingameGUI.getUpdateCounter(), false);
        logger.info("[CHAT] " + iChatComponent.getUnformattedText());
    }

    private void setChatLine(IChatComponent iChatComponent, int n, int n2, boolean bl) {
        if (n != 0) {
            this.deleteChatLine(n);
        } else if (!bl) {
            oc34bba7044e.\u0227(iChatComponent, this.chatLines, this.drawnChatLines);
        }
        int n3 = MathHelper.floor_float((float)this.getChatWidth() / this.getChatScale());
        List<IChatComponent> list = GuiUtilRenderComponents.splitText(iChatComponent, Math.max(1, n3 - Math.round(oce6044968f8.\u01c6() * 2.0f)), oce6044968f8.\u024e(this.mc.fontRendererObj), false, false);
        boolean bl2 = this.getChatOpen();
        for (IChatComponent iChatComponent2 : list) {
            if (bl2 && this.scrollPos > 0) {
                this.isScrolled = true;
                this.scroll(1);
            }
            ChatLine chatLine = new ChatLine(n2, iChatComponent2, n);
            this.drawnChatLines.add(0, chatLine);
            this.chatLineCreationTimes.put(chatLine, System.currentTimeMillis() - (bl ? oc42c8f83828.\u03b3() : 0L));
        }
        if (!bl && n == 0) {
            oc34bba7044e.\u03f8(list.size());
        }
        while (this.drawnChatLines.size() > 100) {
            this.drawnChatLines.remove(this.drawnChatLines.size() - 1);
        }
        if (!bl) {
            this.chatLines.add(0, new ChatLine(n2, iChatComponent, n));
            while (this.chatLines.size() > 100) {
                this.chatLines.remove(this.chatLines.size() - 1);
            }
        }
    }

    public void refreshChat() {
        this.drawnChatLines.clear();
        this.chatLineCreationTimes.clear();
        this.resetScroll();
        for (int i = this.chatLines.size() - 1; i >= 0; --i) {
            ChatLine chatLine = this.chatLines.get(i);
            this.setChatLine(chatLine.getChatComponent(), chatLine.getChatLineID(), chatLine.getUpdatedCounter(), true);
        }
    }

    public List<String> getSentMessages() {
        return this.sentMessages;
    }

    public void addToSentMessages(String string) {
        if (this.sentMessages.isEmpty() || !this.sentMessages.get(this.sentMessages.size() - 1).equals(string)) {
            this.sentMessages.add(string);
        }
    }

    public void resetScroll() {
        this.scrollPos = 0;
        this.animatedScrollPos = 0.0f;
        this.isScrolled = false;
    }

    public void scroll(int n) {
        this.scrollPos += n;
        int n2 = this.drawnChatLines.size();
        if (this.scrollPos > n2 - this.getLineCount()) {
            this.scrollPos = n2 - this.getLineCount();
        }
        if (this.scrollPos <= 0) {
            this.scrollPos = 0;
            this.isScrolled = false;
        }
    }

    public IChatComponent getChatComponent(int n, int n2) {
        if (!this.getChatOpen() || this.getChatScale() <= 0.0f) {
            return null;
        }
        this.syncLayout();
        oc1378bc114d oc1378bc114d2 = oce6044968f8.\u024e(this.mc.fontRendererObj);
        float f = new ScaledResolution(this.mc).getScaleFactor();
        float f2 = ((float)n / f - 2.0f) / this.getChatScale() - oce6044968f8.\u01c6() - oce6044968f8.\u045c();
        float f3 = ((float)n2 / f - 28.0f) / this.getChatScale() + oce6044968f8.\u0479();
        if (f2 < 0.0f || f2 > (float)this.getChatWidth() / this.getChatScale() || f3 < 0.0f || f3 >= (float)(this.getLineCount() * GuiNewChat.lineHeight(oc1378bc114d2))) {
            return null;
        }
        float f4 = oc42c8f83828.\u049c() ? this.animatedScrollPos : (float)this.scrollPos;
        int n3 = (int)Math.floor(f3 / (float)GuiNewChat.lineHeight(oc1378bc114d2) + f4);
        if (n3 < 0 || n3 >= this.drawnChatLines.size()) {
            return null;
        }
        int n4 = 0;
        for (IChatComponent iChatComponent : this.drawnChatLines.get(n3).getChatComponent()) {
            String string;
            if (!(iChatComponent instanceof ChatComponentText) || !((float)(n4 += oc1378bc114d2.z$toz8pt08w0nc(GuiUtilRenderComponents.func_178909_a(string = iChatComponent.getChatStyle().getFormattingCode() + iChatComponent.getUnformattedTextForChat(), false))) > f2)) continue;
            return iChatComponent;
        }
        return null;
    }

    public boolean getChatOpen() {
        return this.mc.currentScreen instanceof GuiChat;
    }

    public void deleteChatLine(int n) {
        ChatLine chatLine;
        Iterator<ChatLine> iterator2 = this.drawnChatLines.iterator();
        while (iterator2.hasNext()) {
            chatLine = iterator2.next();
            if (chatLine.getChatLineID() != n) continue;
            iterator2.remove();
        }
        iterator2 = this.chatLines.iterator();
        while (iterator2.hasNext()) {
            chatLine = iterator2.next();
            if (chatLine.getChatLineID() != n) continue;
            iterator2.remove();
            break;
        }
    }

    public int getChatWidth() {
        return GuiNewChat.calculateChatboxWidth(this.mc.gameSettings.chatWidth);
    }

    public int getChatHeight() {
        return GuiNewChat.calculateChatboxHeight(this.getChatOpen() ? this.mc.gameSettings.chatHeightFocused : this.mc.gameSettings.chatHeightUnfocused);
    }

    public float getChatScale() {
        return this.mc.gameSettings.chatScale;
    }

    public static int calculateChatboxWidth(float f) {
        int n = 320;
        int n2 = 40;
        return MathHelper.floor_float(f * (float)(n - n2) + (float)n2);
    }

    public static int calculateChatboxHeight(float f) {
        int n = 180;
        int n2 = 20;
        return MathHelper.floor_float(f * (float)(n - n2) + (float)n2);
    }

    public int getLineCount() {
        return Math.max(1, this.getChatHeight() / GuiNewChat.lineHeight(oce6044968f8.\u024e(this.mc.fontRendererObj)));
    }

    private record VisibleLine(String text, float slide, float top, float alpha) {
    }
}

