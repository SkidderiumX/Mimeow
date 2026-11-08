/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import x.oc3e2faaf2d2;
import x.oc54714bd439;
import x.ocf130f74f2a;

public class oc4882bbe420
extends GuiScreen {
    private final GuiScreen \u0576;
    private final List<String> \u04b0;
    private final int \u03db;
    private oc3e2faaf2d2 \u0274;
    public static int \u043f;

    public oc4882bbe420(GuiScreen guiScreen, List<String> list, int n) {
        this.\u0576 = guiScreen;
        this.\u04b0 = list;
        this.\u03db = n;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.\u0274 = new oc3e2faaf2d2(this, this.mc);
        this.\u0274.registerScrollButtons(0x2E36315E ^ 0x2E363155, 0x2E363159 ^ 0x2E363155);
        this.buttonList.add(new GuiButton(0, this.width / (0x2E363157 ^ 0x2E363155) - (0x2E363131 ^ 0x2E363155), this.height - (0x2E36314B ^ 0x2E363155), 0x2E36319D ^ 0x2E363155, 0x2E363141 ^ 0x2E363155, "Back"));
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void handleMouseInput() throws IOException {
        oc4882bbe420 oc4882bbe4202;
        block4: {
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                oc4882bbe4202 = this;
                if (bl) break block4;
                if (oc4882bbe4202.\u0274 == null) break block5;
                this.\u0274.handleMouseInput();
            }
            oc4882bbe4202 = this;
        }
        super.handleMouseInput();
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        block8: {
            GuiButton guiButton2;
            block7: {
                boolean bl = ocf130f74f2a.\u02a1;
                guiButton2 = guiButton;
                if (bl) break block7;
                if (!guiButton2.enabled) break block8;
                guiButton2 = guiButton;
            }
            if (guiButton2.id == 0) {
                this.mc.displayGuiScreen(this.\u0576);
            }
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.mc.displayGuiScreen(this.\u0576);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.\u0274.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4("&a&lImport Completed&r"), this.width / (0x817EA835 ^ 0x817EA837), 0x817EA83D ^ 0x817EA837, -1);
        Object[] objectArray = new Object[0x817EA835 ^ 0x817EA837];
        objectArray[0] = this.\u04b0.size();
        objectArray[1] = this.\u03db;
        String string = String.format("&7Successfully imported: &a%d&r &8| &7Failed: &c%d&r", objectArray);
        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(string), this.width / (0x817EA835 ^ 0x817EA837), 0x817EA82E ^ 0x817EA837, -1);
        super.drawScreen(n, n2, f);
    }

    static /* synthetic */ FontRenderer \u017d(oc4882bbe420 oc4882bbe4202) {
        return oc4882bbe4202.fontRendererObj;
    }
}

