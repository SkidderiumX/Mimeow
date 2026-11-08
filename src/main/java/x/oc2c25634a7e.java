/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import x.W;
import x.oc08592ac73b;
import x.oc192c7e4083;
import x.oc1b46ea259e;
import x.oc1cb76bf763;
import x.oc29eefd1b1c;
import x.oc2cf3d80e17;
import x.oc5f2027353d;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc7ab2161b9f;
import x.oc80438d6cc7;
import x.oc8f0e20dbc2;
import x.oc9953295ed5;
import x.oce4cea752dd;
import x.ocea775c9d5c;
import x.ocebe35f25d6;
import x.ocfbfc7a6736;

public class oc2c25634a7e
extends GuiScreen {
    private ScheduledFuture \u04f2;
    private oc5f2027353d \u0534;
    private oc5f2027353d \u0156;
    private oc5f2027353d \u049f;
    private oc5f2027353d \u045b;
    private oc5f2027353d \u00c6;
    private ScaledResolution \u0142;
    public static ArrayList<oc192c7e4083> \u02b4;
    private int \u024c;
    private int \u0499;
    private double \u01b8;
    private static boolean \u04be;
    private boolean \u01a9;
    private boolean \u0444 = true;

    public oc2c25634a7e() {
        \u02b4 = new ArrayList();
        int n = 0xBE716073 ^ 0xBE716076;
        for (oce4cea752dd oce4cea752dd2 : oc80438d6cc7.\u0287()) {
            oc192c7e4083 oc192c7e40832 = new oc192c7e4083(oce4cea752dd2);
            oc192c7e40832.\u0238(n, false);
            \u02b4.add(oc192c7e40832);
            n += 20;
        }
    }

    private void \u01b4() {
        ArrayList<oc192c7e4083> arrayList = new ArrayList<oc192c7e4083>(\u02b4);
        arrayList.sort(Comparator.comparingDouble(oc192c7e4083::\u0406));
        for (int i = 0; i < arrayList.size(); ++i) {
            oc192c7e4083 oc192c7e40832 = (oc192c7e4083)arrayList.get(i);
            for (int j = 0; j < i; ++j) {
                oc192c7e4083 oc192c7e40833 = (oc192c7e4083)arrayList.get(j);
                float f = Math.min(oc192c7e40833.\u01a9() + oc192c7e40833.\u0232(), oc192c7e40832.\u01a9() + oc192c7e40832.\u0232()) - Math.max(oc192c7e40833.\u01a9(), oc192c7e40832.\u01a9());
                if (f < Math.min(oc192c7e40833.\u0232(), oc192c7e40832.\u0232()) * 0.5f) continue;
                float f2 = oc192c7e40833.\u0406() + oc192c7e40833.\u022c();
                if (oc192c7e40832.\u0406() >= f2) continue;
                oc192c7e40832.\u0238(f2, true);
            }
        }
    }

    public void V() {
        this.\u00c6 = this.\u045b = new oc5f2027353d(500.0f);
        this.\u049f = this.\u045b;
        this.\u0534 = this.\u045b;
        this.\u045b.\u039e();
        this.\u04f2 = oc2cf3d80e17.\u02af().schedule(() -> this.mc.addScheduledTask(() -> {
            if (this.mc.currentScreen == this) {
                this.\u0156 = new oc5f2027353d(650.0f);
                this.\u0156.\u039e();
            }
        }), 0xCC6CDD11E2DBE954L ^ 0xCC6CDD11E2DBEBDEL, TimeUnit.MILLISECONDS);
    }

    @Override
    public void initGui() {
        super.initGui();
        double d = this.\u0392();
        if (!\u04be) {
            \u04be = true;
            this.\u01b8 = d;
        }
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            oc192c7e40832.\u04df(this.width, this.height);
        }
        this.\u01b4();
        if (Double.compare(this.\u01b8, d) != 0) {
            for (oc192c7e4083 oc192c7e40832 : \u02b4) {
                oc192c7e40832.\u019d();
            }
        }
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            if (oc192c7e40832.\u0229 == oce4cea752dd.\u051d) {
                oc192c7e40832.\u00ca(true);
                continue;
            }
            if (oc192c7e40832.\u0229 == oce4cea752dd.\u00aa) {
                oc192c7e40832.\u0193();
                continue;
            }
            oc192c7e40832.\u0101();
        }
        this.\u01b8 = d;
    }

    private List<oc192c7e4083> \u0165() {
        ArrayList<oc192c7e4083> arrayList = new ArrayList<oc192c7e4083>(\u02b4);
        arrayList.sort(Comparator.comparingLong(oc192c7e40832 -> oc192c7e40832.\u04aa));
        return arrayList;
    }

    private oc192c7e4083 \u03a0(List<oc192c7e4083> list, int n, int n2) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (!list.get(i).\u01a1(n, n2)) continue;
            return list.get(i);
        }
        return null;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3 = this.\u0500(n);
        int n4 = this.\u0500(n2);
        if (oc6a43806f12.\u056b.\u04c1() != 0.0 && this.\u0444) {
            try {
                if (oc1b46ea259e.\u049d()) {
                    W.\u0213(0.0f, 0.0f, this.\u024c, this.\u0499, 0.0f, true, Color.black);
                    float f2 = (float)(3.0 * ((oc6a43806f12.\u056b.\u04c1() + 35.0) / 100.0));
                    this.\u0444 = oc1b46ea259e.\u038f(0x45BD3670 ^ 0x45BD3672, this.\u00c6.\u01df(0.0f, f2, 1));
                    if (!this.\u0444) {
                        this.mc.getFramebuffer().bindFramebuffer(true);
                    }
                } else {
                    this.\u0444 = false;
                }
            }
            catch (LinkageError | RuntimeException throwable) {
                this.\u0444 = false;
                oc7ab2161b9f.\u00f4.warn("ClickGUI blur was disabled", throwable);
                this.mc.getFramebuffer().bindFramebuffer(true);
            }
        }
        if (oc6a43806f12.\u0276.\u01ed()) {
            Gui.drawRect(0, 0, this.\u024c, this.\u0499, (int)(this.\u045b.\u01df(0.0f, 0.7f, 0x45BD3670 ^ 0x45BD3672) * 255.0f) << (0x45BD366A ^ 0x45BD3672));
        }
        GlStateManager.pushMatrix();
        GlStateManager.scale(this.\u0490(), this.\u0490(), 1.0);
        if (!oc6a43806f12.\u03cf.\u01ed()) {
            int n5 = this.height / (0x45BD3676 ^ 0x45BD3672);
            int n6 = this.width / (0x45BD3670 ^ 0x45BD3672);
            int n7 = (0x45BD366C ^ 0x45BD3672) - this.\u0534.\u04de(0, 0x45BD366C ^ 0x45BD3672, 0x45BD3671 ^ 0x45BD3672);
            this.drawCenteredString(this.fontRendererObj, "m", n6 + 1 - n7, n5 - (0x45BD367D ^ 0x45BD3672), oc7ab2161b9f.\u01be(0x4FED6C6717A1C7FEL ^ 0x4FED6C6717A1C7FCL, 0x4FED6C6717A1C220L ^ 0x4FED6C6717A1C7FCL));
            this.drawCenteredString(this.fontRendererObj, "i", n6 - n7, n5 - (0x45BD3677 ^ 0x45BD3672), oc7ab2161b9f.\u01be(0x4FED6C6717A1C7FEL ^ 0x4FED6C6717A1C7FCL, 0x4FED6C6717A1C414L ^ 0x4FED6C6717A1C7FCL));
            this.drawCenteredString(this.fontRendererObj, "a", n6 - n7, n5 + (0x45BD3677 ^ 0x45BD3672), oc7ab2161b9f.\u01be(0x4FED6C6717A1C7FEL ^ 0x4FED6C6717A1C7FCL, 0x4FED6C6717A1C608L ^ 0x4FED6C6717A1C7FCL));
            this.drawCenteredString(this.fontRendererObj, "u", n6 + 1 + n7, n5 + (0x45BD3666 ^ 0x45BD3672), oc7ab2161b9f.\u01be(0x4FED6C6717A1C7FEL ^ 0x4FED6C6717A1C7FCL, 0L));
            this.drawVerticalLine(n6 - (0x45BD3678 ^ 0x45BD3672) - n7, n5 - (0x45BD366C ^ 0x45BD3672), n5 + (0x45BD3659 ^ 0x45BD3672), Color.white.getRGB());
            this.drawVerticalLine(n6 + (0x45BD3678 ^ 0x45BD3672) + n7, n5 - (0x45BD366C ^ 0x45BD3672), n5 + (0x45BD3659 ^ 0x45BD3672), Color.white.getRGB());
            if (this.\u0156 != null) {
                int n8 = this.\u0156.\u04de(0, 0x45BD3666 ^ 0x45BD3672, 0x45BD3670 ^ 0x45BD3672);
                this.drawHorizontalLine(n6 - (0x45BD3678 ^ 0x45BD3672), n6 - (0x45BD3678 ^ 0x45BD3672) + n8, n5 - (0x45BD366F ^ 0x45BD3672), -1);
                this.drawHorizontalLine(n6 + (0x45BD3678 ^ 0x45BD3672), n6 + (0x45BD3678 ^ 0x45BD3672) - n8, n5 + (0x45BD3658 ^ 0x45BD3672), -1);
            }
        }
        List<oc192c7e4083> list = this.\u0165();
        oc192c7e4083 oc192c7e40832 = this.\u03a0(list, n3, n4);
        for (oc192c7e4083 oc192c7e40833 : list) {
            oc192c7e40833.\u0566(this.fontRendererObj);
            oc192c7e40833.X(n3, n4, oc192c7e40833 == oc192c7e40832);
            for (oc6c12eede72 oc6c12eede722 : oc192c7e40833.\u01d0()) {
                oc6c12eede722.z$3dv8qdlj15ex7(n3, n4);
            }
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        if (!oc6a43806f12.\u01c6.\u01ed()) {
            GlStateManager.pushMatrix();
            GlStateManager.disableBlend();
            GuiInventory.drawEntityOnScreen(this.width + (0x45BD367D ^ 0x45BD3672) - this.\u049f.\u04de(0, 0x45BD365A ^ 0x45BD3672, 0x45BD3670 ^ 0x45BD3672), this.height - (0x45BD3678 ^ 0x45BD3672), 0x45BD365A ^ 0x45BD3672, this.width - (0x45BD366B ^ 0x45BD3672) - n3, this.height - (0x45BD3640 ^ 0x45BD3672) - n4, this.mc.thePlayer);
            GlStateManager.enableBlend();
            GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) throws IOException {
        ArrayList<oc192c7e4083> arrayList = new ArrayList<oc192c7e4083>(\u02b4);
        arrayList.sort((oc192c7e40832, oc192c7e40833) -> Long.compare(oc192c7e40833.\u04aa, oc192c7e40832.\u04aa));
        oc192c7e4083 oc192c7e40834 = null;
        for (oc192c7e4083 object : arrayList) {
            if (!object.\u01a1(n, n2)) continue;
            oc192c7e40834 = object;
            break;
        }
        if (oc192c7e40834 != null) {
            oc192c7e40834.\u021a();
        }
        if (n3 == 0) {
            for (oc192c7e4083 oc192c7e40835 : \u02b4) {
                oc192c7e40835.\u0282(false);
            }
            if (oc192c7e40834 != null && oc192c7e40834.\u049c(n, n2)) {
                oc192c7e40834.\u0282(true);
                oc192c7e40834.\u0569 = (float)n - oc192c7e40834.\u01a9();
                oc192c7e40834.Y = (float)n2 - oc192c7e40834.\u0406();
                oc192c7e40834.\u0172 = true;
            }
        }
        if (n3 == 1 && oc192c7e40834 != null && oc192c7e40834.\u027a(n, n2)) {
            oc192c7e40834.\u0432(!oc192c7e40834.\u0194());
            oc2cf3d80e17.\u04eb();
        }
        if (oc192c7e40834 != null && oc192c7e40834.\u0194() && !oc192c7e40834.\u01d0().isEmpty() && !oc192c7e40834.\u027a(n, n2)) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40834.\u01d0()) {
                if (ocebe35f25d62.z$1qf5sz783tgla(n, n2, n3)) break;
            }
        }
        if (n3 == 0 || n3 == 1) {
            Iterator<ocebe35f25d6> iterator2 = this.\u0522(n, n2);
            this.\u046c((oc8f0e20dbc2)((Object)iterator2));
        }
    }

    @Override
    public void mouseReleased(int n, int n2, int n3) {
        boolean bl = false;
        if (n3 == 0) {
            for (oc192c7e4083 oc192c7e40832 : \u02b4) {
                bl |= oc192c7e40832.\u0172;
                oc192c7e40832.\u0282(false);
                if (!oc192c7e40832.\u0194() || oc192c7e40832.\u01d0().isEmpty()) continue;
                for (oc6c12eede72 oc6c12eede722 : oc192c7e40832.\u01d0()) {
                    oc6c12eede722.z$1n0m425nu1zvd(n, n2, n3);
                }
            }
        }
        if (bl) {
            oc2cf3d80e17.\u04eb();
        }
        if (this.\u01a9) {
            this.\u01a9 = false;
            this.\u01a1();
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = oc08592ac73b.\u0546(Mouse.getEventX(), this.mc.displayWidth, this.width);
            int n3 = oc08592ac73b.\u0493(Mouse.getEventY(), this.mc.displayHeight, this.height);
            oc192c7e4083 oc192c7e40832 = this.\u03a0(this.\u0165(), n2, n3);
            if (oc192c7e40832 != null) {
                oc192c7e40832.Y(n, n2, n3);
            }
        }
    }

    public void \u040a() {
        if (this.mc == null) {
            this.mc = Minecraft.getMinecraft();
        }
        this.\u01a1();
    }

    @Override
    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        this.mc = minecraft;
        this.itemRender = minecraft.getRenderItem();
        this.fontRendererObj = minecraft.fontRendererObj;
        this.\u0394();
        if (!ocea775c9d5c.\u0173.post(new oc29eefd1b1c(this, this.buttonList))) {
            this.buttonList.clear();
            this.initGui();
        }
        ocea775c9d5c.\u0173.post(new ocfbfc7a6736(this, this.buttonList));
    }

    @Override
    public void keyTyped(char c, int n) {
        oc8f0e20dbc2 oc8f0e20dbc22 = this.\u0272();
        if (n == 1) {
            if (oc8f0e20dbc22 != null) {
                oc8f0e20dbc22.z$qv3ekpvnclzq();
                return;
            }
            if (!this.\u04ce()) {
                this.mc.displayGuiScreen(null);
                return;
            }
        }
        if (oc8f0e20dbc22 != null) {
            for (oc192c7e4083 oc192c7e40832 : \u02b4) {
                if (!oc192c7e40832.\u0194() || oc192c7e40832.\u01d0().isEmpty()) continue;
                for (oc6c12eede72 oc6c12eede722 : oc192c7e40832.\u01d0()) {
                    oc6c12eede722.z$zr5dl604ndgu(c, n);
                }
            }
            return;
        }
        for (oc192c7e4083 oc192c7e40833 : \u02b4) {
            if (!oc192c7e40833.\u0194() || oc192c7e40833.\u01d0().isEmpty()) continue;
            for (oc6c12eede72 oc6c12eede723 : oc192c7e40833.\u01d0()) {
                oc6c12eede723.z$zr5dl604ndgu(c, n);
            }
        }
    }

    @Override
    public void onGuiClosed() {
        this.\u0156 = null;
        if (this.\u04f2 != null) {
            this.\u04f2.cancel(true);
            this.\u04f2 = null;
        }
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            oc192c7e40832.\u0172 = false;
            oc192c7e40832.\u04e1();
            for (oc6c12eede72 oc6c12eede722 : oc192c7e40832.\u01d0()) {
                oc6c12eede722.z$19sxbvum8v80h();
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private boolean \u04ce() {
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u01d0()) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    if (oc6c12eede722 instanceof oc9953295ed5 && ((oc9953295ed5)oc6c12eede722).\u04d3) {
                        return true;
                    }
                    if (!(oc6c12eede722 instanceof oc8f0e20dbc2) || !((oc8f0e20dbc2)((Object)oc6c12eede722)).z$z2u2v5j2dveu()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean \u04d0() {
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u01d0()) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    oc8f0e20dbc2 oc8f0e20dbc22;
                    if (!(oc6c12eede722 instanceof oc8f0e20dbc2) || !(oc8f0e20dbc22 = (oc8f0e20dbc2)((Object)oc6c12eede722)).z$z2u2v5j2dveu()) continue;
                    oc8f0e20dbc22.z$qv3ekpvnclzq();
                    return true;
                }
            }
        }
        return false;
    }

    private oc8f0e20dbc2 \u0272() {
        oc8f0e20dbc2 oc8f0e20dbc22 = null;
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u01d0()) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    oc8f0e20dbc2 oc8f0e20dbc23;
                    if (!(oc6c12eede722 instanceof oc8f0e20dbc2) || !(oc8f0e20dbc23 = (oc8f0e20dbc2)((Object)oc6c12eede722)).z$z2u2v5j2dveu()) continue;
                    if (oc8f0e20dbc22 == null) {
                        oc8f0e20dbc22 = oc8f0e20dbc23;
                        continue;
                    }
                    oc8f0e20dbc23.z$qv3ekpvnclzq();
                }
            }
        }
        return oc8f0e20dbc22;
    }

    private oc8f0e20dbc2 \u0522(int n, int n2) {
        ArrayList<oc192c7e4083> arrayList = new ArrayList<oc192c7e4083>(\u02b4);
        arrayList.sort((oc192c7e40832, oc192c7e40833) -> Long.compare(oc192c7e40833.\u04aa, oc192c7e40832.\u04aa));
        for (oc192c7e4083 oc192c7e40834 : arrayList) {
            if (!oc192c7e40834.\u0194() || !oc192c7e40834.\u01a1(n, n2)) continue;
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40834.\u01d0()) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    oc8f0e20dbc2 oc8f0e20dbc22;
                    if (!(oc6c12eede722 instanceof oc8f0e20dbc2) || !(oc8f0e20dbc22 = (oc8f0e20dbc2)((Object)oc6c12eede722)).z$z2u2v5j2dveu() || !oc8f0e20dbc22.z$2v3bclguk2h6z(n, n2)) continue;
                    return oc8f0e20dbc22;
                }
            }
        }
        return null;
    }

    private void \u046c(oc8f0e20dbc2 oc8f0e20dbc22) {
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u01d0()) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    oc8f0e20dbc2 oc8f0e20dbc23;
                    if (!(oc6c12eede722 instanceof oc8f0e20dbc2) || (oc8f0e20dbc23 = (oc8f0e20dbc2)((Object)oc6c12eede722)) == oc8f0e20dbc22 || !oc8f0e20dbc23.z$z2u2v5j2dveu()) continue;
                    oc8f0e20dbc23.z$qv3ekpvnclzq();
                }
            }
        }
    }

    public void \u015c() {
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u01d0()) {
                ocebe35f25d62.\u00d0();
            }
        }
    }

    public void c() {
        this.\u01a9 = true;
    }

    private void \u01a1() {
        this.\u0394();
        for (oc192c7e4083 oc192c7e40832 : \u02b4) {
            oc192c7e40832.\u04df(this.width, this.height);
            oc192c7e40832.\u019d();
        }
        this.buttonList.clear();
        this.initGui();
    }

    private void \u0394() {
        this.\u0142 = new ScaledResolution(this.mc);
        this.\u024c = this.\u0142.getScaledWidth();
        this.\u0499 = this.\u0142.getScaledHeight();
        double d = this.\u0244();
        this.width = Math.max(1, MathHelper.ceiling_double_int((double)this.mc.displayWidth / d));
        this.height = Math.max(1, MathHelper.ceiling_double_int((double)this.mc.displayHeight / d));
    }

    private int \u0190() {
        int n = 1;
        while (this.mc.displayWidth / (n + 1) >= (0xD6CC96B3 ^ 0xD6CC97F3) && this.mc.displayHeight / (n + 1) >= (0xD6CC9703 ^ 0xD6CC97F3)) {
            ++n;
        }
        if (this.mc.isUnicode() && n % (0xD6CC97F1 ^ 0xD6CC97F3) != 0 && n != 1) {
            --n;
        }
        return n;
    }

    private double \u0244() {
        return Math.max(1.0, Math.min((double)this.\u0190(), this.\u0392() * 2.0));
    }

    private int \u0500(int n) {
        return (int)Math.floor((double)n / this.\u0490());
    }

    private double \u0490() {
        return this.\u024c <= 0 || this.width <= 0 ? 1.0 : (double)this.\u024c / (double)this.width;
    }

    public static double \u0196() {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft == null) {
            return 1.0;
        }
        if (minecraft.currentScreen instanceof oc2c25634a7e) {
            return ((oc2c25634a7e)minecraft.currentScreen).\u0490();
        }
        GuiScreen guiScreen = minecraft.currentScreen;
        if (guiScreen instanceof oc1cb76bf763) {
            oc1cb76bf763 oc1cb76bf7632 = (oc1cb76bf763)guiScreen;
            return oc1cb76bf7632.\u04d5();
        }
        return 1.0;
    }

    private double \u0392() {
        return oc6a43806f12.\u021d();
    }
}

