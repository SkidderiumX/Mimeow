/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import x.oc268d5d38dd;
import x.oc2cf3d80e17;
import x.oc371b4f94cb;
import x.oc3c183b786c;
import x.oc4cd250c7b8;
import x.oc54714bd439;
import x.oc5ea809bee2;
import x.oc6d9efd226f;
import x.ocab1e1d632b;
import x.occ995d8031c;
import x.ocd7b0575e93;
import x.ocd938c50489;

public class oc19a6b77031
extends GuiScreen {
    private static final int \u0100 = 0;
    private static final int \u01d3 = 1;
    private static final int S = 2;
    private static final int \u01ab = 3;
    private static final int \u03ba = 4;
    private static final int \u01ca = 4;
    private static final int \u01a0 = -5592406;
    private static final int \u02b0 = -1;
    private static final int \u0518 = -43691;
    private static final String \u04b7 = "https://getmiau.today/changelogs/client";
    private static final DateTimeFormatter \u0133 = DateTimeFormatter.ofPattern("dd.MM.yyyy").withZone(ZoneId.systemDefault());
    private static final Comparator<oc6d9efd226f> \u037d = new ocd938c50489();
    private final GuiScreen \u04cb;
    private final oc268d5d38dd \u0255;
    private final List<oc6d9efd226f> \u00f5 = new ArrayList<oc6d9efd226f>();
    private List<oc371b4f94cb> \u0224 = Collections.emptyList();
    private GuiButton \u0563;
    private GuiButton \u0390;
    private String \u0155;
    private String \u0185;
    private int \u0268;
    private int \u010b = -1;
    private int \u014e;
    private int \u0263;
    private int \u057c;
    private int \u019e;
    private int \u03cc;
    private int \u0527;
    private int \u0466;
    private int \u0490;
    private int \u0537;
    private int \u040b;
    private boolean \u0187;
    private boolean \u0227;
    private boolean \u00dd;
    private boolean \u03ed;
    private boolean \u027b;

    public oc19a6b77031(GuiScreen guiScreen) {
        this(guiScreen, new oc268d5d38dd());
    }

    oc19a6b77031(GuiScreen guiScreen, oc268d5d38dd oc268d5d38dd2) {
        this.\u04cb = guiScreen;
        this.\u0255 = oc268d5d38dd2;
    }

    @Override
    public void initGui() {
        this.\u03ed = false;
        int n = 0xFAEB39BE ^ 0xFAEB39B6;
        int n2 = 0xFAEB39BE ^ 0xFAEB39B6;
        this.\u0527 = Math.max(0xFAEB39EC ^ 0xFAEB39B6, Math.min(0xFAEB3920 ^ 0xFAEB39B6, this.width / (0xFAEB39B3 ^ 0xFAEB39B6)));
        this.\u03cc = n;
        this.\u0466 = this.\u03cc + this.\u0527 + n2;
        this.\u0490 = this.width - n;
        this.\u0537 = 0xFAEB399B ^ 0xFAEB39B6;
        this.\u040b = this.height - n;
        int n3 = this.\u03cc + (0xFAEB39B2 ^ 0xFAEB39B6);
        int n4 = this.\u0527 - (0xFAEB39BE ^ 0xFAEB39B6);
        int n5 = this.\u0537 + (0xFAEB39BE ^ 0xFAEB39B6);
        int n6 = 0xFAEB39A0 ^ 0xFAEB39B6;
        this.\u0563 = new GuiButton(1, n3, n5, n4, 0xFAEB39A2 ^ 0xFAEB39B6, "Refresh");
        this.buttonList.add(this.\u0563);
        this.buttonList.add(new GuiButton(0xFAEB39B4 ^ 0xFAEB39B6, n3, n5 += n6, n4, 0xFAEB39A2 ^ 0xFAEB39B6, "Website"));
        this.\u0390 = new GuiButton(0xFAEB39B5 ^ 0xFAEB39B6, n3, n5 += n6, n4, 0xFAEB39A2 ^ 0xFAEB39B6, "Older");
        this.buttonList.add(this.\u0390);
        this.buttonList.add(new GuiButton(0, n3, n5 + n6, n4, 0xFAEB39A2 ^ 0xFAEB39B6, "Back"));
        this.\u04eb();
        if (!this.\u00dd && !this.\u0187) {
            this.\u0447(false);
        }
    }

    @Override
    public void onGuiClosed() {
        this.\u03ed = true;
        this.\u027b = false;
        this.\u0187 = false;
        this.\u0227 = false;
        ++this.\u0268;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 0) {
            this.mc.displayGuiScreen(this.\u04cb);
        } else if (guiButton.id == 1) {
            this.\u0447(false);
        } else if (guiButton.id == (0xDA2CCDAE ^ 0xDA2CCDAC)) {
            GuiConfirmOpenLink guiConfirmOpenLink = new GuiConfirmOpenLink((GuiYesNoCallback)this, "https://getmiau.today/changelogs/client", 0xDA2CCDA8 ^ 0xDA2CCDAC, true);
            guiConfirmOpenLink.disableSecurityWarning();
            this.mc.displayGuiScreen(guiConfirmOpenLink);
        } else if (guiButton.id == (0xDA2CCDAF ^ 0xDA2CCDAC)) {
            this.\u0447(true);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == (0x1A8CC823 ^ 0x1A8CC827) && bl) {
            this.\u00eb();
        }
        this.mc.displayGuiScreen(this);
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n == 1) {
            this.mc.displayGuiScreen(this.\u04cb);
            return;
        }
        if (n == (0x7E49C77C ^ 0x7E49C7B4)) {
            this.\u0221(0x81B63858 ^ 0x7E49C7B4);
            return;
        }
        if (n == (0x7E49C764 ^ 0x7E49C7B4)) {
            this.\u0221(0x7E49C7A0 ^ 0x7E49C7B4);
            return;
        }
        if (n == (0x7E49C77D ^ 0x7E49C7B4)) {
            this.\u0221(-this.\u0495());
            return;
        }
        if (n == (0x7E49C765 ^ 0x7E49C7B4)) {
            this.\u0221(this.\u0495());
            return;
        }
        if (n == (0x7E49C773 ^ 0x7E49C7B4)) {
            this.\u0263 = 0;
            return;
        }
        if (n == (0x7E49C77B ^ 0x7E49C7B4)) {
            this.\u0263 = this.\u057c;
            return;
        }
        if (n == (0x7E49C78B ^ 0x7E49C7B4)) {
            this.\u0447(false);
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            this.\u0221(n > 0 ? 0xA0B12CE2 ^ 0x5F4ED33E : 0x5F4ED31A ^ 0x5F4ED33E);
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        if (n3 == 0 && this.\u057c > 0 && n >= this.\u0159() - (0xC97D9EB6 ^ 0xC97D9EB4) && n <= this.\u0159() + (0xC97D9EBC ^ 0xC97D9EB4) && n2 >= this.U() && n2 <= this.\u04d5()) {
            int n4 = this.\u03ae();
            int n5 = this.\u01f5();
            if (n2 >= n4 && n2 <= n4 + n5) {
                this.\u027b = true;
                this.\u019e = n2 - n4;
            } else {
                this.s(n2 - n5 / (0xC97D9EB6 ^ 0xC97D9EB4));
            }
            return;
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        if (this.\u027b && n3 == 0) {
            this.s(n2 - this.\u019e);
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        this.\u027b = false;
        super.mouseReleased(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        Gui.drawRect(this.\u03cc, this.\u0537, this.\u03cc + this.\u0527, this.\u040b, 0xF4C0A618 ^ 0x82C0A618);
        Gui.drawRect(this.\u0466, this.\u0537, this.\u0490, this.\u040b, 0xD0C0A618 ^ 0x82C0A618);
        this.drawCenteredString(this.fontRendererObj, oc54714bd439.\u01e4("&cMiau Changelogs"), this.width / (0x82C0A61A ^ 0x82C0A618), 0x82C0A616 ^ 0x82C0A618, -1);
        this.drawCenteredString(this.fontRendererObj, this.\u0242(), this.width / (0x82C0A61A ^ 0x82C0A618), 0x82C0A604 ^ 0x82C0A618, this.\u023d());
        int n3 = this.\u0466 + (0x82C0A61E ^ 0x82C0A618);
        int n4 = Math.max(0x82C0A630 ^ 0x82C0A618, this.\u0490 - n3 - (0x82C0A616 ^ 0x82C0A618));
        this.\u0545(n4);
        this.\u0431();
        this.\u028c(this.\u0466, this.U(), Math.max(1, this.\u0490 - this.\u0466), this.\u0495());
        if (this.\u00f5.isEmpty()) {
            this.\u00d5();
        } else {
            int n5 = this.U() - this.\u0263;
            for (oc371b4f94cb oc371b4f94cb2 : this.\u0224) {
                if (n5 + oc371b4f94cb2.\u00c6 >= this.U() && n5 <= this.\u04d5()) {
                    this.\u00eb(n3, n5, n4, oc371b4f94cb2);
                }
                n5 += oc371b4f94cb2.\u00c6 + (0x82C0A61C ^ 0x82C0A618);
            }
        }
        this.\u0177();
        this.\u0567();
        super.drawScreen(n, n2, f);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void \u0447(boolean bl) {
        if (this.\u0187 || this.\u0227 || bl && this.\u0155 == null) {
            return;
        }
        int n = ++this.\u0268;
        String string = bl ? this.\u0155 : null;
        this.\u0185 = null;
        if (bl) {
            this.\u0227 = true;
        } else {
            this.\u0187 = true;
            this.\u0263 = 0;
        }
        this.\u04eb();
        try {
            oc2cf3d80e17.P().execute(new oc5ea809bee2(this, string, n, bl));
        }
        catch (RuntimeException runtimeException) {
            this.\u0561(n, bl, runtimeException);
        }
    }

    private void \u017f(Runnable runnable2) {
        Minecraft minecraft = this.mc;
        if (minecraft != null) {
            minecraft.addScheduledTask(runnable2);
        }
    }

    private void \u03cc(int n, boolean bl, ocab1e1d632b ocab1e1d632b2) {
        if (this.\u03ed || n != this.\u0268) {
            return;
        }
        if (bl) {
            LinkedHashMap<String, oc6d9efd226f> linkedHashMap = new LinkedHashMap<String, oc6d9efd226f>();
            for (oc6d9efd226f oc6d9efd226f2 : this.\u00f5) {
                linkedHashMap.put(oc6d9efd226f2.\u03b1(), oc6d9efd226f2);
            }
            for (oc6d9efd226f oc6d9efd226f2 : ocab1e1d632b2.r()) {
                linkedHashMap.put(oc6d9efd226f2.\u03b1(), oc6d9efd226f2);
            }
            this.\u00f5.clear();
            this.\u00f5.addAll(linkedHashMap.values());
        } else {
            this.\u00f5.clear();
            this.\u00f5.addAll(ocab1e1d632b2.r());
            this.\u00dd = true;
        }
        Collections.sort(this.\u00f5, \u037d);
        this.\u0155 = ocab1e1d632b2.\u03af();
        this.\u0187 = false;
        this.\u0227 = false;
        this.\u0185 = null;
        this.\u0415();
        this.\u04eb();
    }

    private void \u0561(int n, boolean bl, Exception exception) {
        if (this.\u03ed || n != this.\u0268) {
            return;
        }
        this.\u0187 = false;
        this.\u0227 = false;
        if (!bl && this.\u00f5.isEmpty()) {
            this.\u00dd = false;
            this.\u0155 = null;
        }
        this.\u0185 = this.\u0269(exception);
        this.\u04eb();
    }

    private void \u04eb() {
        boolean bl;
        boolean bl2 = bl = this.\u0187 || this.\u0227;
        if (this.\u0563 != null) {
            this.\u0563.enabled = !bl;
            String string = this.\u0563.displayString = this.\u0187 ? "Loading..." : "Refresh";
        }
        if (this.\u0390 != null) {
            this.\u0390.enabled = !bl && this.\u0155 != null;
            this.\u0390.displayString = this.\u0227 ? "Loading..." : "Older";
        }
    }

    private void \u0415() {
        this.\u010b = -1;
        this.\u0224 = Collections.emptyList();
    }

    private void \u0545(int n) {
        int n2 = Math.max(0xF58595C9 ^ 0xF58595DD, n - (0xF58595CF ^ 0xF58595DD));
        if (this.\u010b == n2) {
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = 0;
        for (oc6d9efd226f oc6d9efd226f2 : this.\u00f5) {
            ArrayList<oc3c183b786c> arrayList2 = new ArrayList<oc3c183b786c>();
            List<occ995d8031c> list = oc4cd250c7b8.\u050b(oc6d9efd226f2.\u01b3());
            if (list.isEmpty()) {
                for (String string : this.fontRendererObj.listFormattedStringToWidth("- No changelog details were provided.", n2)) {
                    arrayList2.add(new oc3c183b786c(string, ocd7b0575e93.\u019f.\u0510()));
                }
            }
            for (occ995d8031c occ995d8031c2 : list) {
                List<String> list2 = this.fontRendererObj.listFormattedStringToWidth("- " + occ995d8031c2.\u0181(), n2);
                for (String string : list2) {
                    arrayList2.add(new oc3c183b786c(string, occ995d8031c2.\u021b().\u0510()));
                }
            }
            oc371b4f94cb oc371b4f94cb2 = new oc371b4f94cb(oc6d9efd226f2, arrayList2, Math.max(0xF58595F1 ^ 0xF58595DD, (0xF58595C2 ^ 0xF58595DD) + arrayList2.size() * (0xF58595D6 ^ 0xF58595DD)));
            arrayList.add(oc371b4f94cb2);
            n3 += oc371b4f94cb2.\u00c6 + (0xF58595D9 ^ 0xF58595DD);
        }
        this.\u0224 = Collections.unmodifiableList(arrayList);
        this.\u014e = Math.max(0, n3 - (0xF58595D9 ^ 0xF58595DD));
        this.\u010b = n2;
    }

    private void \u00eb(int n, int n2, int n3, oc371b4f94cb oc371b4f94cb2) {
        Gui.drawRect(n, n2, n + n3, n2 + oc371b4f94cb2.\u00c6, oc371b4f94cb2.\u0407.\u0259() ? 0x7D8334FA ^ 0xF79570A0 : 0x859570A0 ^ 0xF79570A0);
        String string = this.\u0457(oc371b4f94cb2.\u0407);
        int n4 = this.fontRendererObj.getStringWidth(string);
        String string2 = oc371b4f94cb2.\u0407.\u0259() ? "Current" : "";
        int n5 = string2.isEmpty() ? 0 : this.fontRendererObj.getStringWidth(string2) + (0xF79570A7 ^ 0xF79570A0);
        int n6 = this.fontRendererObj.getStringWidth("Version: ");
        int n7 = Math.max(0xF79570B4 ^ 0xF79570A0, n3 - n4 - n5 - n6 - (0xF79570BC ^ 0xF79570A0));
        String string3 = this.fontRendererObj.trimStringToWidth(oc371b4f94cb2.\u0407.\u0154(), n7);
        this.drawString(this.fontRendererObj, "Version: ", n + (0xF79570A8 ^ 0xF79570A0), n2 + (0xF79570A7 ^ 0xF79570A0), 0x83FDA0A ^ 0xF79570A0);
        this.drawString(this.fontRendererObj, string3, n + (0xF79570A8 ^ 0xF79570A0) + n6, n2 + (0xF79570A7 ^ 0xF79570A0), -1);
        if (!string2.isEmpty()) {
            this.drawString(this.fontRendererObj, string2, n + (0xF79570AC ^ 0xF79570A0) + n6 + this.fontRendererObj.getStringWidth(string3), n2 + (0xF79570A7 ^ 0xF79570A0), 0x8C08FF5 ^ 0xF79570A0);
        }
        this.drawString(this.fontRendererObj, string, n + n3 - n4 - (0xF79570A8 ^ 0xF79570A0), n2 + (0xF79570A7 ^ 0xF79570A0), 0x83FDA0A ^ 0xF79570A0);
        Gui.drawRect(n + (0xF79570A7 ^ 0xF79570A0), n2 + (0xF79570B4 ^ 0xF79570A0), n + n3 - (0xF79570A7 ^ 0xF79570A0), n2 + (0xF79570B5 ^ 0xF79570A0), 0x919570A0 ^ 0xF79570A0);
        int n8 = n2 + (0xF79570B9 ^ 0xF79570A0);
        for (oc3c183b786c oc3c183b786c2 : oc371b4f94cb2.\u0412) {
            this.drawString(this.fontRendererObj, oc3c183b786c2.\u028e, n + (0xF79570A9 ^ 0xF79570A0), n8, oc3c183b786c2.\u050b);
            n8 += 11;
        }
    }

    private void \u00d5() {
        int n;
        String string;
        if (this.\u0187) {
            string = "Loading changelogs...";
            n = 0xE71E31CC ^ 0x18B49B66;
        } else if (this.\u0185 != null) {
            string = this.\u0185;
            n = 0xE74BCE33 ^ 0x18B49B66;
        } else {
            string = "No changelogs are available yet.";
            n = 0xE71E31CC ^ 0x18B49B66;
        }
        List<String> list = this.fontRendererObj.listFormattedStringToWidth(string, Math.max(0x18B49B4E ^ 0x18B49B66, this.\u0490 - this.\u0466 - (0x18B49B7E ^ 0x18B49B66)));
        int n2 = this.U() + Math.max(0x18B49B6A ^ 0x18B49B66, (this.\u0495() - list.size() * (0x18B49B6D ^ 0x18B49B66)) / (0x18B49B64 ^ 0x18B49B66));
        int n3 = this.\u0466 + (this.\u0490 - this.\u0466) / (0x18B49B64 ^ 0x18B49B66);
        for (String string2 : list) {
            this.drawCenteredString(this.fontRendererObj, string2, n3, n2, n);
            n2 += 11;
        }
    }

    private void \u0567() {
        if (this.\u057c <= 0) {
            return;
        }
        int n = this.\u0159();
        Gui.drawRect(n, this.U(), n + (0x3B14FC70 ^ 0x3B14FC76), this.\u04d5(), 0xC414FC76 ^ 0x3B14FC76);
        int n2 = this.\u03ae();
        Gui.drawRect(n, n2, n + (0x3B14FC70 ^ 0x3B14FC76), n2 + this.\u01f5(), this.\u027b ? 0xC4D43CB6 ^ 0x3B14FC76 : 0xC4947CF6 ^ 0x3B14FC76);
        Gui.drawRect(n, n2, n + (0x3B14FC73 ^ 0x3B14FC76), n2 + this.\u01f5() - 1, this.\u027b ? -1 : 0xC4D43CB6 ^ 0x3B14FC76);
    }

    private void \u028c(int n, int n2, int n3, int n4) {
        int n5 = new ScaledResolution(this.mc).getScaleFactor();
        GL11.glEnable(0x7D67B3F4 ^ 0x7D67BFE5);
        GL11.glScissor(n * n5, (this.height - n2 - n4) * n5, n3 * n5, n4 * n5);
    }

    private void \u0177() {
        GL11.glDisable(0x10484514 ^ 0x10484905);
    }

    private void \u0431() {
        this.\u057c = Math.max(0, this.\u014e - this.\u0495());
        this.\u0263 = Math.max(0, Math.min(this.\u0263, this.\u057c));
    }

    private void \u0221(int n) {
        this.\u0263 = Math.max(0, Math.min(this.\u057c, this.\u0263 + n));
    }

    private void s(int n) {
        int n2 = this.\u0495() - this.\u01f5();
        if (n2 <= 0) {
            this.\u0263 = 0;
            return;
        }
        int n3 = Math.max(0, Math.min(n2, n - this.U()));
        this.\u0263 = Math.round((float)n3 / (float)n2 * (float)this.\u057c);
    }

    private int \u03ae() {
        int n = this.\u0495() - this.\u01f5();
        return this.U() + (this.\u057c == 0 ? 0 : Math.round((float)this.\u0263 / (float)this.\u057c * (float)n));
    }

    private int \u01f5() {
        if (this.\u014e <= 0) {
            return this.\u0495();
        }
        int n = Math.max(1, this.\u0495() - (0x60F6E6B8 ^ 0x60F6E6B0));
        int n2 = Math.min(0x60F6E690 ^ 0x60F6E6B0, n);
        return Math.max(n2, Math.min(n, this.\u0495() * this.\u0495() / this.\u014e));
    }

    private int \u0495() {
        return Math.max(1, this.\u04d5() - this.U());
    }

    private int U() {
        return this.\u0537 + (0xA80A8835 ^ 0xA80A8833);
    }

    private int \u04d5() {
        return Math.max(this.U() + 1, this.\u040b - (0x64033D3B ^ 0x64033D3D));
    }

    private int \u0159() {
        return this.\u0490 - (0x99C88AE ^ 0x99C88A6);
    }

    private String \u0242() {
        if (this.\u0227) {
            return "Loading older releases...";
        }
        if (this.\u0187) {
            return this.\u00f5.isEmpty() ? "Fetching release history" : "Refreshing release history";
        }
        if (this.\u0185 != null && !this.\u00f5.isEmpty()) {
            return this.\u0185;
        }
        if (!this.\u00f5.isEmpty()) {
            return this.\u00f5.size() + (this.\u00f5.size() == 1 ? " release" : " releases");
        }
        return "Release history from api.getmiau.today";
    }

    private int \u023d() {
        return this.\u0185 != null ? 0x4690BF42 ^ 0xB96FEA17 : 0x46C540BD ^ 0xB96FEA17;
    }

    private String \u0457(oc6d9efd226f oc6d9efd226f2) {
        try {
            return \u0133.format(Instant.ofEpochMilli(oc6d9efd226f2.j()));
        }
        catch (Exception exception) {
            return oc6d9efd226f2.\u03ef();
        }
    }

    private String \u0269(Exception exception) {
        String string = exception.getMessage();
        if (string == null || string.trim().isEmpty()) {
            return "Unable to load changelogs";
        }
        String string2 = string.replace((char)(0x3703DCE2 ^ 0x3703DCEF), (char)(0x3703DCCF ^ 0x3703DCEF)).replace((char)(0x3703DCE5 ^ 0x3703DCEF), (char)(0x3703DCCF ^ 0x3703DCEF)).trim();
        return string2.length() > (0x3703DC4F ^ 0x3703DCEF) ? string2.substring(0, 0x3703DC72 ^ 0x3703DCEF) + "..." : string2;
    }

    private void \u00eb() {
        try {
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, new URI("https://getmiau.today/changelogs/client"));
        }
        catch (Exception exception) {
            this.\u0185 = "Unable to open the changelog website";
        }
    }
}

