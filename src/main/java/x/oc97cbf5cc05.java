/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import x.oc07d263d49a;
import x.oc08592ac73b;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc2cf3d80e17;
import x.oc35ec3fe254;
import x.oc670dbafdea;
import x.oc6a43806f12;
import x.oc984b264623;
import x.ocbd4917c4b1;
import x.oce2a4f2842f;
import x.oce4cea752dd;

public class oc97cbf5cc05
extends GuiScreen {
    private static final int \u0134 = 118;
    private static final int \u04aa = 34;
    private static final int \u0233 = 155;
    private static final int \u04e4 = 6;
    private static final float \u019a = 5.0f;
    private static final int \u04d0 = 5;
    private static final int \u01a9 = 20;
    private static final int \u018a = 9;
    private static final int \u03e6 = 9;
    private static final int \u011e = 4;
    private static final oce4cea752dd[] E;
    private final List<oc670dbafdea> \u02aa = new ArrayList<oc670dbafdea>();
    private final oce2a4f2842f \u0125 = new oce2a4f2842f();
    private final oc984b264623 \u0551 = new oc984b264623();
    private oc35ec3fe254 x = oc35ec3fe254.\u0546;
    private long \u0199;
    private boolean \u051e;

    public oc97cbf5cc05() {
        for (oce4cea752dd oce4cea752dd2 : E) {
            this.\u02aa.add(new oc670dbafdea(oce4cea752dd2, 0xAA161670 ^ 0xAA161606));
        }
    }

    @Override
    public void initGui() {
        int n = this.T();
        int n2 = this.\u0242();
        if (!this.\u051e) {
            this.\u0251(n, n2);
            this.\u051e = true;
        } else {
            this.\u03cd(n, n2);
        }
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            oc670dbafdea2.\u0282();
            oc670dbafdea2.\u01ce();
        }
        if (this.x == oc35ec3fe254.\u046c) {
            this.\u0125.\u00e8(n, n2);
        } else if (this.x == oc35ec3fe254.\u021b) {
            this.\u0111(n, n2);
        }
        this.\u0199 = System.currentTimeMillis();
        super.initGui();
    }

    public void \u04cb() {
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            if (oc670dbafdea2.\u0238() != oce4cea752dd.\u057c) continue;
            oc670dbafdea2.\u0282();
        }
        if (this.\u0551 != null) {
            this.\u0551.\u029f();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void drawScreen(int n, int n2, float f) {
        float f2 = this.\u01b1();
        int n3 = oc97cbf5cc05.\u0574(n, f2);
        int n4 = oc97cbf5cc05.\u0574(n2, f2);
        int n5 = oc97cbf5cc05.\u054f(this.width, f2);
        int n6 = oc97cbf5cc05.\u054f(this.height, f2);
        float f3 = Math.min(1.0f, (float)(System.currentTimeMillis() - this.\u0199) / 125.0f);
        float f4 = 1.0f - (float)Math.pow(1.0f - f3, 3.0);
        GlStateManager.pushMatrix();
        GlStateManager.scale(f2, f2, 1.0f);
        try {
            if (this.x == oc35ec3fe254.\u0546) {
                this.\u03cd(n5, n6);
                for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
                    oc670dbafdea2.\u02a7(n3, n4, n6);
                }
                this.\u012e();
                for (oc670dbafdea oc670dbafdea2 : this.\u03eb()) {
                    oc670dbafdea2.\u02aa(n3, n4, f4);
                }
            } else if (this.x == oc35ec3fe254.\u046c) {
                this.\u0125.\u0145(n3, n4, n5, n6);
            } else {
                this.\u0551.\u01e5(n3, n4, n5, n6);
            }
            super.drawScreen(n3, n4, f);
            this.\u01b9(n3, n4, n5);
        }
        finally {
            GlStateManager.popMatrix();
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        Object object;
        float f = this.\u01b1();
        n = oc97cbf5cc05.\u0574(n, f);
        n2 = oc97cbf5cc05.\u0574(n2, f);
        if (n3 == 0 && (object = this.\u0452(n, n2, oc97cbf5cc05.\u054f(this.width, f))) != null) {
            boolean bl = object == this.x;
            this.\u01d8((oc35ec3fe254)((Object)object));
            if (object == oc35ec3fe254.\u021b && bl) {
                this.\u0111(oc97cbf5cc05.\u054f(this.width, f), oc97cbf5cc05.\u054f(this.height, f));
            }
            return;
        }
        if (this.x == oc35ec3fe254.\u0546) {
            object = this.\u03eb();
            Collections.reverse(object);
            Iterator<Object> iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                oc670dbafdea oc670dbafdea2 = (oc670dbafdea)iterator2.next();
                if (!oc670dbafdea2.\u0297(n, n2, n3)) continue;
                oc670dbafdea2.\u0404();
                return;
            }
            for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
                oc670dbafdea2.\u03ab();
            }
        } else if (this.x == oc35ec3fe254.\u046c ? this.\u0125.\u0127(n, n2, n3) : this.\u0551.\u017a(n, n2, n3)) {
            return;
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        float f = this.\u01b1();
        n = oc97cbf5cc05.\u0574(n, f);
        n2 = oc97cbf5cc05.\u0574(n2, f);
        boolean bl = false;
        if (this.x == oc35ec3fe254.\u0546) {
            for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
                bl |= oc670dbafdea2.\u0186(n, n2, n3);
            }
        }
        if (bl) {
            oc2cf3d80e17.\u04eb();
        }
        if (this.x == oc35ec3fe254.\u021b) {
            this.\u0551.\u03cb(n, n2, n3);
        }
        super.mouseReleased(n, n2, n3);
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (this.x == oc35ec3fe254.\u0546) {
            for (oc670dbafdea oc670dbafdea2 : this.\u01af()) {
                if (!oc670dbafdea2.\u0435(c, n)) continue;
                return;
            }
        } else if (this.x == oc35ec3fe254.\u021b && this.\u0551.\u028e(c, n)) {
            return;
        }
        super.keyTyped(c, n);
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n == 0) {
            return;
        }
        int n2 = oc08592ac73b.\u0546(Mouse.getEventX(), this.mc.displayWidth, this.width);
        int n3 = oc08592ac73b.\u0493(Mouse.getEventY(), this.mc.displayHeight, this.height);
        float f = this.\u01b1();
        n2 = oc97cbf5cc05.\u0574(n2, f);
        n3 = oc97cbf5cc05.\u0574(n3, f);
        if (this.x == oc35ec3fe254.\u046c) {
            this.\u0125.\u03e7(n2, n3, n);
            return;
        }
        if (this.x == oc35ec3fe254.\u021b) {
            this.\u0551.\u0295(n2, n3, n);
            return;
        }
        for (oc670dbafdea oc670dbafdea2 : this.\u01af()) {
            if (!oc670dbafdea2.\u01a6(n2, n3, n)) continue;
            return;
        }
    }

    @Override
    public void onGuiClosed() {
        this.\u0125.\u01b7();
        this.\u0551.\u019e();
        this.\u0551.\u04e2();
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            oc670dbafdea2.\u0109();
        }
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public List<oc670dbafdea> \u017f() {
        return Collections.unmodifiableList(this.\u02aa);
    }

    public boolean \u0136() {
        return this.\u051e;
    }

    public void \u02b7(oce4cea752dd oce4cea752dd2, int n, int n2, boolean bl) {
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            if (oc670dbafdea2.\u0238() != oce4cea752dd2) continue;
            oc670dbafdea2.\u0254(n, n2, bl);
            this.\u051e = true;
            return;
        }
    }

    private void \u0251(int n, int n2) {
        int n3 = 0x84F7E86E ^ 0x84F7EBB4;
        if (n >= n3 + (0x84F7EBA0 ^ 0x84F7EBB4)) {
            int n4 = Math.max(0x84F7EBBE ^ 0x84F7EBB4, (n - n3) / (0x84F7EBB6 ^ 0x84F7EBB4));
            for (int i = 0; i < this.\u02aa.size(); ++i) {
                oc670dbafdea oc670dbafdea2 = this.\u02aa.get(i);
                oc670dbafdea2.\u0509(n4 + i * (0x84F7EBC8 ^ 0x84F7EBB4), 0x84F7EB96 ^ 0x84F7EBB4);
                oc670dbafdea2.\u04a6(n, n2);
            }
            return;
        }
        int n5 = n >= (0x84F7EA4E ^ 0x84F7EBB4) ? 0x84F7EBB0 ^ 0x84F7EBB4 : 0x84F7EBB6 ^ 0x84F7EBB4;
        int n6 = n5 * (0x84F7EBC2 ^ 0x84F7EBB4) + (n5 - 1) * (0x84F7EBB2 ^ 0x84F7EBB4);
        int n7 = Math.max(0x84F7EBBC ^ 0x84F7EBB4, (n - n6) / (0x84F7EBB6 ^ 0x84F7EBB4));
        for (int i = 0; i < this.\u02aa.size(); ++i) {
            int n8 = i % n5;
            int n9 = i / n5;
            int n10 = n7 + n8 * (0x84F7EBC8 ^ 0x84F7EBB4);
            int n11 = (0x84F7EB96 ^ 0x84F7EBB4) + n9 * (0x84F7EB2F ^ 0x84F7EBB4);
            oc670dbafdea oc670dbafdea3 = this.\u02aa.get(i);
            oc670dbafdea3.\u0509(n10, n11);
            oc670dbafdea3.\u04a6(n, n2);
        }
    }

    static int \u0155(oce4cea752dd oce4cea752dd2) {
        int n = oc97cbf5cc05.\u014d(oce4cea752dd2);
        int n2 = n % (0xAA851419 ^ 0xAA85141D);
        return (0xAA85140D ^ 0xAA85141D) + n2 * (0xAA851461 ^ 0xAA85141D);
    }

    static int \u0516(oce4cea752dd oce4cea752dd2) {
        int n = oc97cbf5cc05.\u014d(oce4cea752dd2);
        int n2 = n / (0x1998BD00 ^ 0x1998BD04);
        return (0x1998BD26 ^ 0x1998BD04) + n2 * (0x1998BD9F ^ 0x1998BD04);
    }

    private static int \u014d(oce4cea752dd oce4cea752dd2) {
        for (int i = 0; i < E.length; ++i) {
            if (E[i] != oce4cea752dd2) continue;
            return i;
        }
        return 0;
    }

    private void \u012e() {
        int n = this.\u02aa.size();
        float[] fArray = new float[n];
        float[] fArray2 = new float[n];
        float[] fArray3 = new float[n];
        float[] fArray4 = new float[n];
        boolean[] blArray = new boolean[n];
        for (int i = 0; i < n; ++i) {
            oc670dbafdea oc670dbafdea2 = this.\u02aa.get(i);
            fArray[i] = oc670dbafdea2.\u01e3();
            fArray2[i] = oc670dbafdea2.\u039e();
            fArray3[i] = oc670dbafdea2.\u01bf();
            fArray4[i] = oc670dbafdea2.\u0262();
            blArray[i] = oc670dbafdea2.\u0444();
        }
        float[] fArray5 = oc07d263d49a.\u0442(fArray, fArray2, fArray3, fArray4, blArray, 5.0f);
        for (int i = 0; i < n; ++i) {
            this.\u02aa.get(i).\u0177(fArray5[i] - fArray2[i]);
        }
    }

    private void \u03cd(int n, int n2) {
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            oc670dbafdea2.\u04a6(n, n2);
        }
    }

    private void \u01b9(int n, int n2, int n3) {
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.B();
        int n4 = this.\u0261(oc1378bc114d2);
        int n5 = (n3 - n4 - (0x1354ADC1 ^ 0x1354ADC5)) / (0x1354ADC7 ^ 0x1354ADC5);
        int n6 = n5 + (0x1354ADC7 ^ 0x1354ADC5);
        ocbd4917c4b1.\u04da(n5, 5.0f, n5 + n4 + (0x1354ADC1 ^ 0x1354ADC5), 25.0f, 5.0f, oc255ab955c3.\u0515(0xEC4DB4DC ^ 0x1354ADC5, 0x1354AD2E ^ 0x1354ADC5));
        for (oc35ec3fe254 oc35ec3fe2542 : oc35ec3fe254.values()) {
            int n7;
            int n8 = this.\u0518(oc35ec3fe2542, oc1378bc114d2);
            boolean bl = oc255ab955c3.\u050e(n6, 7.0f, n8, 16.0f, n, n2);
            if (oc35ec3fe2542 == this.x) {
                n7 = oc255ab955c3.\u0515(oc255ab955c3.\u01ea((double)n6 + (double)n8 * 0.5, 15.0), 0x1354AD24 ^ 0x1354ADC5);
                ocbd4917c4b1.\u04da(n6, 7.0f, n6 + n8, 23.0f, 4.0f, n7);
            } else if (bl) {
                ocbd4917c4b1.\u04da(n6, 7.0f, n6 + n8, 23.0f, 4.0f, 0x854DB4DC ^ 0x1354ADC5);
            }
            n7 = oc35ec3fe2542 == this.x ? -1 : 0xECCA335B ^ 0x1354ADC5;
            int n9 = n6 + (0x1354ADCC ^ 0x1354ADC5);
            int n10 = 0x1354ADCF ^ 0x1354ADC5;
            if (!oc255ab955c3.\u01ca(oc35ec3fe2542.\u01e1, n9, n10, 0x1354ADCC ^ 0x1354ADC5, 0x1354ADCC ^ 0x1354ADC5, n7)) {
                Gui.drawRect(n9, n10, n9 + (0x1354ADCC ^ 0x1354ADC5), n10 + (0x1354ADCC ^ 0x1354ADC5), n7);
            }
            int n11 = n9 + (0x1354ADCC ^ 0x1354ADC5) + (0x1354ADC1 ^ 0x1354ADC5);
            int n12 = oc255ab955c3.\u0544(0x1354ADC0 ^ 0x1354ADC5, 0x1354ADD1 ^ 0x1354ADC5, oc1378bc114d2);
            oc1378bc114d2.z$ao2ykh4tuw6w(oc35ec3fe2542.\u019a, n11, n12, n7, true);
            n6 += n8;
        }
    }

    private oc35ec3fe254 \u0452(int n, int n2, int n3) {
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.B();
        int n4 = (n3 - this.\u0261(oc1378bc114d2) - (0xD2132C47 ^ 0xD2132C43)) / (0xD2132C41 ^ 0xD2132C43) + (0xD2132C41 ^ 0xD2132C43);
        for (oc35ec3fe254 oc35ec3fe2542 : oc35ec3fe254.values()) {
            int n5 = this.\u0518(oc35ec3fe2542, oc1378bc114d2);
            if (oc255ab955c3.\u050e(n4, 7.0f, n5, 16.0f, n, n2)) {
                return oc35ec3fe2542;
            }
            n4 += n5;
        }
        return null;
    }

    private int \u0261(oc1378bc114d oc1378bc114d2) {
        int n = 0;
        for (oc35ec3fe254 oc35ec3fe2542 : oc35ec3fe254.values()) {
            n += this.\u0518(oc35ec3fe2542, oc1378bc114d2);
        }
        return n;
    }

    private int \u0518(oc35ec3fe254 oc35ec3fe2542, oc1378bc114d oc1378bc114d2) {
        return (0x8D15C62D ^ 0x8D15C632) + oc1378bc114d2.z$toz8pt08w0nc(oc35ec3fe2542.\u019a);
    }

    private void \u01d8(oc35ec3fe254 oc35ec3fe2542) {
        if (oc35ec3fe2542 == this.x) {
            return;
        }
        if (this.x == oc35ec3fe254.\u021b) {
            this.\u0551.\u04bb();
        }
        for (oc670dbafdea oc670dbafdea2 : this.\u02aa) {
            oc670dbafdea2.\u03ab();
            oc670dbafdea2.\u01ce();
        }
        this.x = oc35ec3fe2542;
        if (this.x == oc35ec3fe254.\u046c) {
            this.\u0125.\u00e8(this.T(), this.\u0242());
        } else if (this.x == oc35ec3fe254.\u021b) {
            this.\u0111(this.T(), this.\u0242());
        }
    }

    private void \u0111(int n, int n2) {
        if (oc2cf3d80e17.\u013e != null && oc2cf3d80e17.\u013e.scripts.isEmpty()) {
            oc2cf3d80e17.\u013e.loadScripts();
        }
        this.\u0551.\u0295(n, n2);
    }

    static int \u0574(int n, float f) {
        return (int)Math.floor((float)n / oc97cbf5cc05.\u0282(f));
    }

    static int \u054f(int n, float f) {
        return (int)Math.ceil((float)n / oc97cbf5cc05.\u0282(f));
    }

    private int T() {
        return oc97cbf5cc05.\u054f(this.width, this.\u01b1());
    }

    private int \u0242() {
        return oc97cbf5cc05.\u054f(this.height, this.\u01b1());
    }

    public float \u01b1() {
        return oc97cbf5cc05.\u0282(oc6a43806f12.\u021d());
    }

    private static float \u0282(float f) {
        return Float.isFinite(f) && f > 0.0f ? f : 1.0f;
    }

    private List<oc670dbafdea> \u03eb() {
        ArrayList<oc670dbafdea> arrayList = new ArrayList<oc670dbafdea>(this.\u02aa);
        arrayList.sort(Comparator.comparingLong(oc670dbafdea::\u03cb));
        return arrayList;
    }

    private List<oc670dbafdea> \u01af() {
        List<oc670dbafdea> list = this.\u03eb();
        Collections.reverse(list);
        return list;
    }

    static {
        oce4cea752dd[] oce4cea752ddArray = new oce4cea752dd[0xB98FA7C1 ^ 0xB98FA7C9];
        oce4cea752ddArray[0] = oce4cea752dd.\u0201;
        oce4cea752ddArray[1] = oce4cea752dd.\u0495;
        oce4cea752ddArray[0xB98FA7CB ^ 0xB98FA7C9] = oce4cea752dd.\u0437;
        oce4cea752ddArray[0xB98FA7CA ^ 0xB98FA7C9] = oce4cea752dd.\u014e;
        oce4cea752ddArray[0xB98FA7CD ^ 0xB98FA7C9] = oce4cea752dd.\u04b6;
        oce4cea752ddArray[0xB98FA7CC ^ 0xB98FA7C9] = oce4cea752dd.\u0502;
        oce4cea752ddArray[0xB98FA7CF ^ 0xB98FA7C9] = oce4cea752dd.\u04a9;
        oce4cea752ddArray[0xB98FA7CE ^ 0xB98FA7C9] = oce4cea752dd.\u04a6;
        E = oce4cea752ddArray;
    }
}

