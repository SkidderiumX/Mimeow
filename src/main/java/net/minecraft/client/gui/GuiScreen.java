/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityList;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc0bfbf9cc9a;
import x.oc1e3977fb7b;
import x.oc2cf3d80e17;
import x.oc36adbc80c5;
import x.oc4e1b577a95;
import x.oc51b6bb9827;
import x.oc6ce415157c;
import x.oc95a52a4046;
import x.oc9755810e45;
import x.oc9b5c00ac67;
import x.occb187f10ff;
import x.ocdf3e495c45;
import x.ocea775c9d5c;
import x.ocee33618a8d;
import x.ocfbfc7a6736;

public abstract class GuiScreen
extends Gui
implements GuiYesNoCallback,
oc51b6bb9827 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Set<String> PROTOCOLS = Sets.newHashSet("http", "https");
    private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n');
    protected Minecraft mc;
    protected RenderItem itemRender;
    public int width;
    public int height;
    protected List<GuiButton> buttonList = Lists.newArrayList();
    protected List<GuiLabel> labelList = Lists.newArrayList();
    public boolean allowUserInput;
    protected FontRenderer fontRendererObj;
    private GuiButton selectedButton;
    private int eventButton;
    private long lastMouseEvent;
    private int touchValue;
    private URI clickedLinkURI;

    public void drawScreen(int n, int n2, float f) {
        int n3;
        if (ocea775c9d5c.\u0173.post(new oc6ce415157c(this, n, n2, f))) {
            return;
        }
        for (n3 = 0; n3 < this.buttonList.size(); ++n3) {
            this.buttonList.get(n3).drawButton(this.mc, n, n2);
        }
        for (n3 = 0; n3 < this.labelList.size(); ++n3) {
            this.labelList.get(n3).drawLabel(this.mc, n, n2);
        }
        ocea775c9d5c.\u0173.post(new oc36adbc80c5(this, n, n2, f));
    }

    public final void pressKey(char c, int n) throws IOException {
        this.keyTyped(c, n);
    }

    protected void keyTyped(char c, int n) throws IOException {
        if (n == 1) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null) {
                this.mc.setIngameFocus();
            }
        }
    }

    public static String getClipboardString() {
        return oc95a52a4046.\u0217();
    }

    public static void setClipboardString(String string) {
        if (string != null && !string.isEmpty()) {
            oc95a52a4046.\u016e(string);
        }
    }

    protected void renderToolTip(ItemStack itemStack, int n, int n2) {
        List<String> list = itemStack.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
        for (int i = 0; i < list.size(); ++i) {
            if (i == 0) {
                list.set(i, String.valueOf((Object)itemStack.getRarity().rarityColor) + list.get(i));
                continue;
            }
            list.set(i, String.valueOf((Object)EnumChatFormatting.GRAY) + list.get(i));
        }
        this.drawHoveringText(list, n, n2);
    }

    protected void drawCreativeTabHoveringText(String string, int n, int n2) {
        this.drawHoveringText(Arrays.asList(string), n, n2);
    }

    protected void drawHoveringText(List<String> list, int n, int n2) {
        if (!list.isEmpty()) {
            int n3;
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int n4 = 0;
            for (String string : list) {
                n3 = this.fontRendererObj.getStringWidth(string);
                if (n3 <= n4) continue;
                n4 = n3;
            }
            int n5 = n + 12;
            int n6 = n2 - 12;
            n3 = 8;
            if (list.size() > 1) {
                n3 += 2 + (list.size() - 1) * 10;
            }
            if (n5 + n4 > this.width) {
                n5 -= 28 + n4;
            }
            if (n6 + n3 + 6 > this.height) {
                n6 = this.height - n3 - 6;
            }
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            int n7 = -267386864;
            this.drawGradientRect(n5 - 3, n6 - 4, n5 + n4 + 3, n6 - 3, n7, n7);
            this.drawGradientRect(n5 - 3, n6 + n3 + 3, n5 + n4 + 3, n6 + n3 + 4, n7, n7);
            this.drawGradientRect(n5 - 3, n6 - 3, n5 + n4 + 3, n6 + n3 + 3, n7, n7);
            this.drawGradientRect(n5 - 4, n6 - 3, n5 - 3, n6 + n3 + 3, n7, n7);
            this.drawGradientRect(n5 + n4 + 3, n6 - 3, n5 + n4 + 4, n6 + n3 + 3, n7, n7);
            int n8 = 0x505000FF;
            int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
            this.drawGradientRect(n5 - 3, n6 - 3 + 1, n5 - 3 + 1, n6 + n3 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 + n4 + 2, n6 - 3 + 1, n5 + n4 + 3, n6 + n3 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 - 3, n6 - 3, n5 + n4 + 3, n6 - 3 + 1, n8, n8);
            this.drawGradientRect(n5 - 3, n6 + n3 + 2, n5 + n4 + 3, n6 + n3 + 3, n9, n9);
            for (int i = 0; i < list.size(); ++i) {
                String string = list.get(i);
                this.fontRendererObj.drawStringWithShadow(string, n5, n6, -1);
                if (i == 0) {
                    n6 += 2;
                }
                n6 += 10;
            }
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
        }
    }

    protected void handleComponentHover(IChatComponent iChatComponent, int n, int n2) {
        if (iChatComponent != null && iChatComponent.getChatStyle().getChatHoverEvent() != null) {
            block21: {
                HoverEvent hoverEvent = iChatComponent.getChatStyle().getChatHoverEvent();
                if (hoverEvent.getAction() == HoverEvent.Action.SHOW_ITEM) {
                    ItemStack itemStack = null;
                    try {
                        NBTTagCompound nBTTagCompound = JsonToNBT.getTagFromJson(hoverEvent.getValue().getUnformattedText());
                        if (nBTTagCompound instanceof NBTTagCompound) {
                            itemStack = ItemStack.loadItemStackFromNBT(nBTTagCompound);
                        }
                    }
                    catch (NBTException nBTException) {
                        // empty catch block
                    }
                    if (itemStack != null) {
                        this.renderToolTip(itemStack, n, n2);
                    } else {
                        this.drawCreativeTabHoveringText(String.valueOf((Object)EnumChatFormatting.RED) + "Invalid Item!", n, n2);
                    }
                } else if (hoverEvent.getAction() == HoverEvent.Action.SHOW_ENTITY) {
                    if (this.mc.gameSettings.advancedItemTooltips) {
                        try {
                            NBTTagCompound nBTTagCompound = JsonToNBT.getTagFromJson(hoverEvent.getValue().getUnformattedText());
                            if (nBTTagCompound instanceof NBTTagCompound) {
                                ArrayList<String> arrayList = Lists.newArrayList();
                                NBTTagCompound nBTTagCompound2 = nBTTagCompound;
                                arrayList.add(nBTTagCompound2.getString("name"));
                                if (nBTTagCompound2.hasKey("type", 8)) {
                                    String string = nBTTagCompound2.getString("type");
                                    arrayList.add("Type: " + string + " (" + EntityList.getIDFromString(string) + ")");
                                }
                                arrayList.add(nBTTagCompound2.getString("id"));
                                this.drawHoveringText(arrayList, n, n2);
                                break block21;
                            }
                            this.drawCreativeTabHoveringText(String.valueOf((Object)EnumChatFormatting.RED) + "Invalid Entity!", n, n2);
                        }
                        catch (NBTException nBTException) {
                            this.drawCreativeTabHoveringText(String.valueOf((Object)EnumChatFormatting.RED) + "Invalid Entity!", n, n2);
                        }
                    }
                } else if (hoverEvent.getAction() == HoverEvent.Action.SHOW_TEXT) {
                    this.drawHoveringText(NEWLINE_SPLITTER.splitToList(hoverEvent.getValue().getFormattedText()), n, n2);
                } else if (hoverEvent.getAction() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
                    StatBase statBase = StatList.getOneShotStat(hoverEvent.getValue().getUnformattedText());
                    if (statBase != null) {
                        IChatComponent iChatComponent2 = statBase.getStatName();
                        ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("stats.tooltip.type." + (statBase.isAchievement() ? "achievement" : "statistic"), new Object[0]);
                        chatComponentTranslation.getChatStyle().setItalic(true);
                        String string = statBase instanceof Achievement ? ((Achievement)statBase).getDescription() : null;
                        ArrayList<String> arrayList = Lists.newArrayList(iChatComponent2.getFormattedText(), chatComponentTranslation.getFormattedText());
                        if (string != null) {
                            arrayList.addAll(this.fontRendererObj.listFormattedStringToWidth(string, 150));
                        }
                        this.drawHoveringText(arrayList, n, n2);
                    } else {
                        this.drawCreativeTabHoveringText(String.valueOf((Object)EnumChatFormatting.RED) + "Invalid statistic/achievement!", n, n2);
                    }
                }
            }
            GlStateManager.disableLighting();
        }
    }

    protected void setText(String string, boolean bl) {
    }

    protected boolean handleComponentClick(IChatComponent iChatComponent) {
        if (iChatComponent == null) {
            return false;
        }
        ClickEvent clickEvent = iChatComponent.getChatStyle().getChatClickEvent();
        if (GuiScreen.isShiftKeyDown()) {
            if (iChatComponent.getChatStyle().getInsertion() != null) {
                this.setText(iChatComponent.getChatStyle().getInsertion(), false);
            }
        } else if (clickEvent != null) {
            block19: {
                if (clickEvent.getAction() == ClickEvent.Action.OPEN_URL) {
                    if (!this.mc.gameSettings.chatLinks) {
                        return false;
                    }
                    try {
                        URI uRI = new URI(clickEvent.getValue());
                        String string = uRI.getScheme();
                        if (string == null) {
                            throw new URISyntaxException(clickEvent.getValue(), "Missing protocol");
                        }
                        if (!PROTOCOLS.contains(string.toLowerCase())) {
                            throw new URISyntaxException(clickEvent.getValue(), "Unsupported protocol: " + string.toLowerCase());
                        }
                        if (this.mc.gameSettings.chatLinksPrompt) {
                            this.clickedLinkURI = uRI;
                            this.mc.displayGuiScreen(new GuiConfirmOpenLink((GuiYesNoCallback)this, clickEvent.getValue(), 31102009, false));
                            break block19;
                        }
                        this.openWebLink(uRI);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        LOGGER.error("Can't open url for " + String.valueOf(clickEvent), (Throwable)uRISyntaxException);
                    }
                } else if (clickEvent.getAction() == ClickEvent.Action.OPEN_FILE) {
                    URI uRI = new File(clickEvent.getValue()).toURI();
                    this.openWebLink(uRI);
                } else if (clickEvent.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
                    this.setText(clickEvent.getValue(), true);
                } else if (clickEvent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                    this.sendChatMessage(clickEvent.getValue(), false);
                } else {
                    LOGGER.error("Don't know how to handle " + String.valueOf(clickEvent));
                }
            }
            return true;
        }
        return false;
    }

    public void sendChatMessage(String string) {
        this.sendChatMessage(string, true);
    }

    public void sendChatMessage(String string, boolean bl) {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("sendChatMessage", true);
        this.mimeow$messageSend(string, bl, ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (bl) {
                this.mc.ingameGUI.getChatGUI().addToSentMessages(string);
            }
            this.mc.thePlayer.sendChatMessage(string);
        }
    }

    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        if (n3 == 0) {
            for (int i = 0; i < this.buttonList.size(); ++i) {
                GuiButton guiButton = this.buttonList.get(i);
                if (!guiButton.mousePressed(this.mc, n, n2)) continue;
                this.selectedButton = guiButton;
                guiButton.playPressSound(this.mc.getSoundHandler());
                this.mimeow$redirect$actionPerformed(this, guiButton);
            }
        }
    }

    protected void mouseReleased(int n, int n2, int n3) {
        if (this.selectedButton != null && n3 == 0) {
            this.selectedButton.mouseReleased(n, n2);
            this.selectedButton = null;
        }
    }

    protected void mouseClickMove(int n, int n2, int n3, long l) {
    }

    protected void actionPerformed(GuiButton guiButton) throws IOException {
    }

    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        this.mc = minecraft;
        this.itemRender = minecraft.getRenderItem();
        this.fontRendererObj = minecraft.fontRendererObj;
        this.width = n;
        this.height = n2;
        this.buttonList.clear();
        this.initGui();
        this.mimeow$initGuiPost(minecraft, n, n2, new ocee33618a8d("setWorldAndResolution", false));
    }

    public void setGuiSize(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public void initGui() {
    }

    public void handleInput() throws IOException {
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                this.handleMouseInput();
            }
        }
        if (Keyboard.isCreated()) {
            while (Keyboard.next()) {
                ocea775c9d5c.\u0173.post(new occb187f10ff(Keyboard.getKeyName(Keyboard.getEventKey()), Keyboard.getEventKey(), Keyboard.getEventKeyState(), true));
                this.handleKeyboardInput();
            }
        }
    }

    public void handleMouseInput() throws IOException {
        int n = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int n2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
        int n3 = Mouse.getEventButton();
        if (Mouse.getEventButtonState()) {
            if (this.mc.gameSettings.touchscreen && this.touchValue++ > 0) {
                return;
            }
            this.eventButton = n3;
            this.lastMouseEvent = Minecraft.getSystemTime();
            this.mouseClicked(n, n2, this.eventButton);
        } else if (n3 != -1) {
            if (this.mc.gameSettings.touchscreen && --this.touchValue > 0) {
                return;
            }
            this.eventButton = -1;
            this.mouseReleased(n, n2, n3);
        } else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
            long l = Minecraft.getSystemTime() - this.lastMouseEvent;
            this.mouseClickMove(n, n2, this.eventButton, l);
        }
    }

    public void handleKeyboardInput() throws IOException {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("handleKeyboardInput", true);
        this.mimeow$injectHandleKeyboardInput(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (Keyboard.getEventKeyState()) {
                this.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
            }
            this.mc.dispatchKeypresses();
        }
    }

    public void updateScreen() {
    }

    public void onGuiClosed() {
    }

    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }

    public void drawWorldBackground(int n) {
        if (this.mc.theWorld != null) {
            if (oc9755810e45.\u0376 != null && oc9755810e45.\u0376.z$3rzb3dil7uydr()) {
                float f = oc4e1b577a95.H();
                if (f <= 0.001f) {
                    GlStateManager.colorMask(false, false, false, false);
                    GuiScreen.drawRect(0, 0, this.width, this.height, -1);
                    GlStateManager.colorMask(true, true, true, true);
                    return;
                }
                int n2 = Math.max(0, (int)((f - 0.0627451f) * 255.0f));
                int n3 = Math.max(0, (int)(f * 255.0f));
                int n4 = n2 << 24 | 0x101010;
                int n5 = n3 << 24 | 0x101010;
                this.drawGradientRect(0, 0, this.width, this.height, n4, n5);
                return;
            }
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            this.drawBackground(n);
        }
    }

    public void drawBackground(int n) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(optionsBackground);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldRenderer.pos(0.0, this.height, 0.0).tex(0.0, (float)this.height / 32.0f + (float)n).color(64, 64, 64, 255).endVertex();
        worldRenderer.pos(this.width, this.height, 0.0).tex((float)this.width / 32.0f, (float)this.height / 32.0f + (float)n).color(64, 64, 64, 255).endVertex();
        worldRenderer.pos(this.width, 0.0, 0.0).tex((float)this.width / 32.0f, n).color(64, 64, 64, 255).endVertex();
        worldRenderer.pos(0.0, 0.0, 0.0).tex(0.0, n).color(64, 64, 64, 255).endVertex();
        tessellator.draw();
    }

    public boolean doesGuiPauseGame() {
        return true;
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == 31102009) {
            if (bl) {
                this.openWebLink(this.clickedLinkURI);
            }
            this.clickedLinkURI = null;
            this.mc.displayGuiScreen(this);
        }
    }

    private void openWebLink(URI uRI) {
        try {
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, uRI);
        }
        catch (Throwable throwable) {
            LOGGER.error("Couldn't open link", throwable);
        }
    }

    public static boolean isCtrlKeyDown() {
        return Minecraft.isRunningOnMac ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static boolean isAltKeyDown() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }

    public static boolean isKeyComboCtrlX(int n) {
        return n == 45 && GuiScreen.isCtrlKeyDown() && !GuiScreen.isShiftKeyDown() && !GuiScreen.isAltKeyDown();
    }

    public static boolean isKeyComboCtrlV(int n) {
        return n == 47 && GuiScreen.isCtrlKeyDown() && !GuiScreen.isShiftKeyDown() && !GuiScreen.isAltKeyDown();
    }

    public static boolean isKeyComboCtrlC(int n) {
        return n == 46 && GuiScreen.isCtrlKeyDown() && !GuiScreen.isShiftKeyDown() && !GuiScreen.isAltKeyDown();
    }

    public static boolean isKeyComboCtrlA(int n) {
        return n == 30 && GuiScreen.isCtrlKeyDown() && !GuiScreen.isShiftKeyDown() && !GuiScreen.isAltKeyDown();
    }

    public void onResize(Minecraft minecraft, int n, int n2) {
        this.setWorldAndResolution(minecraft, n, n2);
    }

    private void mimeow$messageSend(String string, boolean bl, ocee33618a8d ocee33618a8d2) {
        if (bl && ocdf3e495c45.\u03dd().\u027d(string)) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(string);
            ocee33618a8d2.z$2vp8d6bhwkrey();
            return;
        }
        if (bl && oc2cf3d80e17.\u0449 != null && oc2cf3d80e17.\u0449.\u014a(string)) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(oc2cf3d80e17.\u0449.\u043b(string));
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    private void mimeow$injectHandleKeyboardInput(ocee33618a8d ocee33618a8d2) {
        oc1e3977fb7b oc1e3977fb7b2 = new oc1e3977fb7b(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        ocea775c9d5c.\u0173.post(oc1e3977fb7b2);
        if (oc1e3977fb7b2.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    private void mimeow$initGuiPost(Minecraft minecraft, int n, int n2, ocee33618a8d ocee33618a8d2) {
        ocea775c9d5c.\u0173.post(new ocfbfc7a6736(this, this.buttonList));
    }

    private void mimeow$redirect$actionPerformed(GuiScreen guiScreen, GuiButton guiButton) throws IOException {
        oc9b5c00ac67 oc9b5c00ac672 = new oc9b5c00ac67(guiScreen, guiButton, this.buttonList);
        if (!ocea775c9d5c.\u0173.post(oc9b5c00ac672)) {
            this.actionPerformed(guiButton);
            ocea775c9d5c.\u0173.post(new oc0bfbf9cc9a(guiScreen, guiButton, this.buttonList));
        }
    }

    @Override
    public void callMouseClicked(int n, int n2, int n3) {
        try {
            this.mouseClicked(n, n2, n3);
        }
        catch (IOException iOException) {
            throw new IllegalStateException(iOException);
        }
    }
}

