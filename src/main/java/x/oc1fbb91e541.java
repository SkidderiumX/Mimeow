/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.Session;
import org.lwjgl.input.Keyboard;
import x.oc54714bd439;
import x.oc804fdd8d75;
import x.ocb8a733cf81;
import x.occ791aa07d0;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class oc1fbb91e541
extends GuiScreen {
    private final GuiScreen \u00aa;
    private String \u00da = "&fEnter a username to add a cracked account.&r";
    private GuiTextField \u0129;
    public static int \u039c;

    public oc1fbb91e541(GuiScreen guiScreen) {
        this.\u00aa = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        this.\u0129 = new GuiTextField(1, this.mc.fontRendererObj, scaledResolution.getScaledWidth() / (0x24DBCC2B ^ 0x24DBCC29) - (0x24DBCC4D ^ 0x24DBCC29), scaledResolution.getScaledHeight() / (0x24DBCC2B ^ 0x24DBCC29), 0x24DBCCE1 ^ 0x24DBCC29, 0x24DBCC3D ^ 0x24DBCC29);
        this.\u0129.setMaxStringLength(0x24DBCC39 ^ 0x24DBCC29);
        this.\u0129.setFocused(true);
        this.buttonList.add(new GuiButton(0x24DBCFCF ^ 0x24DBCC29, scaledResolution.getScaledWidth() / (0x24DBCC2B ^ 0x24DBCC29) - (0x24DBCC4D ^ 0x24DBCC29), scaledResolution.getScaledHeight() / (0x24DBCC2B ^ 0x24DBCC29) + (0x24DBCC37 ^ 0x24DBCC29), 0x24DBCCE1 ^ 0x24DBCC29, 0x24DBCC3D ^ 0x24DBCC29, "Add Cracked"));
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Cracked Account", this.width / (0xE42846CB ^ 0xE42846C9), this.height / (0xE42846CB ^ 0xE42846C9) - this.fontRendererObj.FONT_HEIGHT / (0xE42846CB ^ 0xE42846C9) - this.fontRendererObj.FONT_HEIGHT * (0xE42846CB ^ 0xE42846C9) - (0xE42846C7 ^ 0xE42846C9), 0xE482EC63 ^ 0xE42846C9);
        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4(this.\u00da), this.width / (0xE42846CB ^ 0xE42846C9), this.height / (0xE42846CB ^ 0xE42846C9) - this.fontRendererObj.FONT_HEIGHT / (0xE42846CB ^ 0xE42846C9) - (0xE42846C7 ^ 0xE42846C9), -1);
        this.\u0129.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void actionPerformed(GuiButton guiButton) {
        boolean bl;
        String string;
        block22: {
            boolean bl2;
            block25: {
                block24: {
                    GuiButton guiButton2;
                    block23: {
                        bl2 = ocf130f74f2a.\u02a1;
                        guiButton2 = guiButton;
                        if (bl2) break block23;
                        if (guiButton2 == null) break block24;
                        guiButton2 = guiButton;
                    }
                    if (guiButton2.id == (0x9F6F0D5C ^ 0x9F6F0EBA)) break block25;
                }
                return;
            }
            string = this.\u0129.getText().trim();
            boolean bl3 = string.matches("^\\w{3,16}$");
            if (!bl2) {
                if (!bl3) {
                    this.\u00da = "&cInvalid username (3-16 letters, digits or _).&r";
                    return;
                }
                bl3 = false;
            }
            bl = bl3;
            for (oc804fdd8d75 oc804fdd8d752 : ocd6bc26d10b.\u0293) {
                block27: {
                    oc804fdd8d75 oc804fdd8d753;
                    block28: {
                        block26: {
                            if (bl2) break block22;
                            oc804fdd8d753 = oc804fdd8d752;
                            if (bl2) break block26;
                            if (!oc804fdd8d753.\u049e()) break block27;
                            oc804fdd8d753 = oc804fdd8d752;
                        }
                        if (bl2) break block28;
                        if (!oc804fdd8d753.\u014c().equalsIgnoreCase(string)) break block27;
                        oc804fdd8d753 = oc804fdd8d752;
                    }
                    string = oc804fdd8d753.\u014c();
                    bl = true;
                    if (!bl2) break;
                }
                if (!bl2) continue;
            }
            if (!bl) {
                ocd6bc26d10b.\u01fa(oc804fdd8d75.\u04de(string));
            }
        }
        Session session = occ791aa07d0.\u00fb(string);
        occ791aa07d0.\u0431(session);
        this.mc.displayGuiScreen(new ocfc2b827e17(this.\u00aa, new ocb8a733cf81(oc54714bd439.\u01e4(String.format(bl ? "&eCracked account already exists! Logged in as %s&r" : "&aAdded cracked account! (%s)&r", session.getUsername())), 0xB327773B51AF7E83L ^ 0xB327773B51AF6D0BL)));
    }

    @Override
    protected void keyTyped(char c, int n) {
        block11: {
            int n2;
            block9: {
                block10: {
                    this.\u0129.textboxKeyTyped(c, n);
                    boolean bl = ocf130f74f2a.\u02a1;
                    n2 = n;
                    if (bl) break block9;
                    if (n2 != (0x1831B6E ^ 0x1831B72)) break block10;
                    this.actionPerformed(this.buttonList.get(0));
                    if (!bl) break block11;
                }
                n2 = n;
            }
            if (n2 == 1) {
                this.mc.displayGuiScreen(this.\u00aa);
            }
        }
    }
}

