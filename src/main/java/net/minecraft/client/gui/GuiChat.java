/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc1378bc114d;
import x.oc2cf3d80e17;
import x.oc304b542f7a;
import x.oc3d8ab304f7;
import x.oc42c8f83828;
import x.oc4e1b577a95;
import x.oc99b8eeba10;
import x.ocb69e4fa09a;
import x.ocbd4917c4b1;
import x.oce6044968f8;

public class GuiChat
extends GuiScreen {
    private static final Logger logger = LogManager.getLogger();
    private String historyBuffer = "";
    private int sentHistoryCursor = -1;
    private boolean playerNamesFound;
    private boolean waitingOnAutocomplete;
    private int autocompleteIndex;
    private List<String> foundPlayerNames = Lists.newArrayList();
    protected GuiTextField inputField;
    private String defaultInputFieldText = "";
    private static final int MAX_PREVIEW_ROWS = 6;
    private static final float PREVIEW_SCROLL_SPEED = 20.0f;
    private String[] commandCompletions = new String[0];
    private int commandCompletionIndex = -1;
    private final ocb69e4fa09a previewScrollAnimation = new ocb69e4fa09a(200L);
    private final oc304b542f7a openAnimation = new oc304b542f7a(oc3d8ab304f7.\u0436, 250L);
    private String previewScrollInput = "";

    public GuiChat() {
    }

    public GuiChat(String string) {
        this.defaultInputFieldText = string;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        this.inputField = new GuiTextField(0, this.fontRendererObj, 4, this.height - 12, this.width - 4, 12);
        this.inputField.setMaxStringLength(oc4e1b577a95.\u041a() ? 256 : 100);
        this.inputField.setFontSupplier(() -> oce6044968f8.\u024e(this.fontRendererObj));
        this.inputField.setEnableBackgroundDrawing(false);
        this.inputField.setFocused(true);
        this.inputField.setText(this.defaultInputFieldText);
        this.inputField.setCanLoseFocus(false);
        this.openAnimation.\u02a9();
        this.openAnimation.\u0290(0.0);
        this.updateInputLength();
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.ingameGUI.getChatGUI().resetScroll();
        this.resetCommandCompletions();
        this.resetPreviewScroll();
    }

    @Override
    public void updateScreen() {
        this.inputField.updateCursorCounter();
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n != 15) {
            this.resetCommandCompletions();
        }
        this.waitingOnAutocomplete = false;
        if (n == 15) {
            this.autocompletePlayerNames();
        } else {
            this.playerNamesFound = false;
        }
        if (n == 1) {
            this.mc.displayGuiScreen(null);
        } else if (n != 28 && n != 156) {
            if (n == 200) {
                this.getSentHistory(-1);
            } else if (n == 208) {
                this.getSentHistory(1);
            } else if (n == 201) {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            } else if (n == 209) {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            } else {
                this.inputField.textboxKeyTyped(c, n);
            }
        } else {
            String string = this.inputField.getText().trim();
            if (string.length() > 0) {
                this.sendChatMessage(string);
            }
            if (this.mc.currentScreen == this) {
                this.mc.displayGuiScreen(null);
            }
        }
        this.updateInputLength();
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            if (this.handleSuggestionScroll(n)) {
                return;
            }
            if (n > 1) {
                n = 1;
            }
            if (n < -1) {
                n = -1;
            }
            if (!GuiChat.isShiftKeyDown()) {
                n *= 7;
            }
            this.mc.ingameGUI.getChatGUI().scroll(n);
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        IChatComponent iChatComponent;
        if (n3 == 0 && this.handleComponentClick(iChatComponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY()))) {
            return;
        }
        this.inputField.mouseClicked(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void setText(String string, boolean bl) {
        if (bl) {
            this.inputField.setText(string);
        } else {
            this.inputField.writeText(string);
        }
        this.resetCommandCompletions();
        this.updateInputLength();
    }

    public void autocompletePlayerNames() {
        if (this.handleCommandAutocomplete()) {
            return;
        }
        if (this.playerNamesFound) {
            this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
            if (this.autocompleteIndex >= this.foundPlayerNames.size()) {
                this.autocompleteIndex = 0;
            }
        } else {
            int n = this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false);
            this.foundPlayerNames.clear();
            this.autocompleteIndex = 0;
            String string = this.inputField.getText().substring(n).toLowerCase();
            String string2 = this.inputField.getText().substring(0, this.inputField.getCursorPosition());
            this.sendAutocompleteRequest(string2, string);
            if (this.foundPlayerNames.isEmpty()) {
                return;
            }
            this.playerNamesFound = true;
            this.inputField.deleteFromCursor(n - this.inputField.getCursorPosition());
        }
        if (this.foundPlayerNames.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string2 : this.foundPlayerNames) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(string2);
            }
            this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new ChatComponentText(stringBuilder.toString()), 1);
        }
        this.inputField.writeText(this.foundPlayerNames.get(this.autocompleteIndex++));
    }

    private void sendAutocompleteRequest(String string, String string2) {
        if (oc2cf3d80e17.\u0449 != null && oc2cf3d80e17.\u0449.\u01a4(string)) {
            return;
        }
        if (string.length() >= 1) {
            BlockPos blockPos = null;
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                blockPos = this.mc.objectMouseOver.getBlockPos();
            }
            this.mc.thePlayer.sendQueue.addToSendQueue(new C14PacketTabComplete(string, blockPos));
            this.waitingOnAutocomplete = true;
        }
    }

    public void getSentHistory(int n) {
        int n2 = this.sentHistoryCursor + n;
        int n3 = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        if ((n2 = MathHelper.clamp_int(n2, 0, n3)) != this.sentHistoryCursor) {
            if (n2 == n3) {
                this.sentHistoryCursor = n3;
                this.inputField.setText(this.historyBuffer);
            } else {
                if (this.sentHistoryCursor == n3) {
                    this.historyBuffer = this.inputField.getText();
                }
                this.inputField.setText(this.mc.ingameGUI.getChatGUI().getSentMessages().get(n2));
                this.sentHistoryCursor = n2;
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        IChatComponent iChatComponent;
        boolean bl = oc42c8f83828.\u03a5();
        boolean bl2 = bl && oc42c8f83828.\u01dc();
        float f2 = 1.0f;
        if (bl2) {
            this.openAnimation.\u010c(1.0);
            f2 = (float)this.openAnimation.\u03a9();
            f2 = MathHelper.clamp_float(f2, 0.0f, 1.0f);
        }
        float f3 = 2.0f;
        oc1378bc114d oc1378bc114d2 = oce6044968f8.\u024e(this.fontRendererObj);
        float f4 = Math.max(2.0f, oce6044968f8.\u0161());
        float f5 = this.inputPanelTop();
        this.inputField.xPosition = 4 + Math.round(oce6044968f8.\u01c6());
        this.inputField.yPosition = Math.round(f5 + f4);
        this.inputField.setSize(this.width - this.inputField.xPosition - 4, Math.round((float)(this.height - 2) - f5));
        float f6 = this.width - 2;
        float f7 = this.height - 2;
        if (bl2 && f2 < 1.0f) {
            GlStateManager.pushMatrix();
            float f8 = (f3 + f6) / 2.0f;
            float f9 = (f5 + f7) / 2.0f;
            GlStateManager.translate(f8 * (1.0f - f2), f9 * (1.0f - f2), 0.0f);
            GlStateManager.scale(f2, f2, 1.0f);
        }
        oce6044968f8.\u0390(new oc99b8eeba10(f3, f5, f6 - f3, f7 - f5, () -> {
            if (this.inputField.getText().isEmpty()) {
                oc1378bc114d2.z$ao2ykh4tuw6w("# + Message to chat IRC", this.inputField.xPosition, this.inputField.yPosition, 0x50D0D0D0, false);
            }
            this.inputField.drawTextBox();
        }), oc42c8f83828.G());
        if (bl2 && f2 < 1.0f) {
            GlStateManager.popMatrix();
        }
        if ((iChatComponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY())) != null && iChatComponent.getChatStyle().getChatHoverEvent() != null) {
            this.handleComponentHover(iChatComponent, n, n2);
        }
        super.drawScreen(n, n2, f);
        this.drawCommandSuggestions();
    }

    public void onAutocompleteResponse(String[] stringArray) {
        if (this.waitingOnAutocomplete) {
            this.playerNamesFound = false;
            this.foundPlayerNames.clear();
            for (String string : stringArray) {
                if (string.length() <= 0) continue;
                this.foundPlayerNames.add(string);
            }
            String string = this.inputField.getText().substring(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false));
            String string2 = StringUtils.getCommonPrefix(stringArray);
            if (string2.length() > 0 && !string.equalsIgnoreCase(string2)) {
                this.inputField.deleteFromCursor(this.inputField.func_146197_a(-1, this.inputField.getCursorPosition(), false) - this.inputField.getCursorPosition());
                this.inputField.writeText(string2);
            } else if (this.foundPlayerNames.size() > 0) {
                this.playerNamesFound = true;
                this.autocompletePlayerNames();
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void updateInputLength() {
        int n = oc2cf3d80e17.\u0449 != null && oc2cf3d80e17.\u0449.\u01a4(this.inputField.getText()) ? 256 : 100;
        this.inputField.setMaxStringLength(n);
    }

    private boolean handleCommandAutocomplete() {
        String[] stringArray;
        if (oc2cf3d80e17.\u0449 == null) {
            return false;
        }
        String string = this.inputField.getText();
        if (!oc2cf3d80e17.\u0449.\u01a4(string)) {
            this.resetCommandCompletions();
            return false;
        }
        if (this.canCycleCurrentCompletion(string)) {
            stringArray = this.commandCompletions;
            this.commandCompletionIndex = (this.commandCompletionIndex + 1) % stringArray.length;
        } else {
            stringArray = oc2cf3d80e17.\u0449.\u012b(string);
            if (stringArray.length == 0) {
                this.resetCommandCompletions();
                return true;
            }
            this.commandCompletions = stringArray;
            this.commandCompletionIndex = 0;
        }
        this.inputField.setText(stringArray[this.commandCompletionIndex]);
        this.inputField.setCursorPositionEnd();
        this.updateInputLength();
        return true;
    }

    private boolean canCycleCurrentCompletion(String string) {
        if (this.commandCompletions.length == 0 || this.commandCompletionIndex < 0) {
            return false;
        }
        for (String string2 : this.commandCompletions) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    private void resetCommandCompletions() {
        this.commandCompletions = new String[0];
        this.commandCompletionIndex = -1;
    }

    private boolean handleSuggestionScroll(int n) {
        int n2;
        if (oc2cf3d80e17.\u0449 == null) {
            return false;
        }
        String string = this.inputField.getText();
        if (!oc2cf3d80e17.\u0449.\u01a4(string)) {
            this.resetPreviewScroll();
            return false;
        }
        String[] stringArray = oc2cf3d80e17.\u0449.\u0580(string);
        int n3 = Math.min(6, stringArray.length);
        this.syncPreviewScrollState(string, stringArray.length, n3);
        if (n3 == 0 || stringArray.length <= n3) {
            return false;
        }
        int n4 = Mouse.getEventX() * this.width / this.mc.displayWidth;
        if (!this.isMouseOverPreviewPanel(n4, n2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1, stringArray, n3)) {
            return false;
        }
        float f = 20.0f * ((float)n / 120.0f);
        if (f != 0.0f) {
            this.previewScrollAnimation.\u024f(-f);
            this.clampPreviewScroll(stringArray.length, n3);
        }
        return true;
    }

    private void drawCommandSuggestions() {
        if (oc2cf3d80e17.\u0449 == null) {
            this.resetPreviewScroll();
            return;
        }
        String string = this.inputField.getText();
        if (!oc2cf3d80e17.\u0449.\u01a4(string)) {
            this.resetPreviewScroll();
            return;
        }
        String[] stringArray = oc2cf3d80e17.\u0449.\u0580(string);
        if (stringArray.length == 0) {
            this.resetPreviewScroll();
            return;
        }
        int n = Math.min(6, stringArray.length);
        this.syncPreviewScrollState(string, stringArray.length, n);
        oc1378bc114d oc1378bc114d2 = oce6044968f8.\u024e(this.fontRendererObj);
        int n2 = oc1378bc114d2.z$1tqmx4tpnr6lq();
        int n3 = this.previewRowHeight();
        int n4 = 0;
        for (String string2 : stringArray) {
            if (string2 == null) continue;
            n4 = Math.max(n4, oc1378bc114d2.z$toz8pt08w0nc(string2));
        }
        int n5 = 4;
        int n6 = Math.min(this.width - 4, n5 + n4 + 8);
        int n7 = Math.round(this.inputPanelTop()) - 2;
        int n8 = n7 - n * n3 - 2;
        int n9 = n8 + 1;
        int n10 = n * n3;
        float f = this.previewScrollAnimation.\u021b();
        float f2 = this.mc.gameSettings.chatOpacity * 0.9f + 0.1f;
        oce6044968f8.\u0390(new oc99b8eeba10(n5, n8, n6 - n5, n7 - n8, f2, () -> {
            ocbd4917c4b1.\u010e(n5, n9, n6 - n5, n10);
            try {
                for (int i = 0; i < stringArray.length; ++i) {
                    String string = stringArray[i];
                    int n7 = Math.round((float)n9 - f + (float)(i * n3));
                    if (string == null || n7 + n2 < n9 || n7 > n9 + n10) continue;
                    oc1378bc114d2.z$ao2ykh4tuw6w(string, n5 + 4, n7, -1, false);
                }
            }
            finally {
                ocbd4917c4b1.\u01df();
            }
        }, null), oc42c8f83828.\u0207());
    }

    private float inputPanelTop() {
        return (float)(this.height - 2) - Math.max(12.0f, (float)oce6044968f8.\u024e(this.fontRendererObj).z$1tqmx4tpnr6lq() + Math.max(2.0f, oce6044968f8.\u0161()) * 2.0f);
    }

    private int previewRowHeight() {
        return oce6044968f8.\u024e(this.fontRendererObj).z$1tqmx4tpnr6lq() + Math.max(2, Math.round(oce6044968f8.\u0161() * 2.0f));
    }

    private void syncPreviewScrollState(String string, int n, int n2) {
        if (!string.equals(this.previewScrollInput)) {
            this.previewScrollInput = string;
            this.previewScrollAnimation.\u0234(0.0f);
        }
        this.clampPreviewScroll(n, n2);
    }

    private void clampPreviewScroll(int n, int n2) {
        int n3 = this.previewRowHeight();
        float f = Math.max(0.0f, (float)((n - n2) * n3));
        this.previewScrollAnimation.\u057f(0.0f, f);
    }

    private boolean isMouseOverPreviewPanel(int n, int n2, String[] stringArray, int n3) {
        int n4 = 0;
        for (String string : stringArray) {
            if (string == null) continue;
            n4 = Math.max(n4, oce6044968f8.\u024e(this.fontRendererObj).z$toz8pt08w0nc(string));
        }
        int n5 = 4;
        int n6 = Math.min(this.width - 4, n5 + n4 + 8);
        int n7 = Math.round(this.inputPanelTop()) - 2;
        int n8 = n7 - n3 * this.previewRowHeight() - 2;
        return n >= n5 && n <= n6 && n2 >= n8 && n2 <= n7;
    }

    private void resetPreviewScroll() {
        this.previewScrollInput = "";
        this.previewScrollAnimation.\u0234(0.0f);
    }
}

