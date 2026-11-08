/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import x.L;
import x.oc057476a9f5;
import x.oc08592ac73b;
import x.oc094a54ecb8;
import x.oc11d1e4dfb9;
import x.oc1e7298eef6;
import x.oc2cf3d80e17;
import x.oc3004491957;
import x.oc33beffb935;
import x.oc35e4c54bd4;
import x.oc449e61fefc;
import x.oc62a465bc97;
import x.oc64a59b1eaa;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc6b92d7f083;
import x.oc6dfc3938c0;
import x.oc6f44315029;
import x.oc7a3173be3e;
import x.oc7d882df7eb;
import x.oc9311f94f2e;
import x.oc98904eb9e7;
import x.ocac488f5520;
import x.ocba3c42d463;
import x.occ22af137a2;
import x.occ573e1fe6c;
import x.occ93a9667d6;
import x.ocd94f97a9f3;
import x.ocd9db3ede42;
import x.oce4a4c32971;
import x.ocefb3475d27;
import x.ocf2c1cef686;
import x.ocf9f6726f63;

public class oc6a954e7c9f
extends GuiScreen {
    private final oc35e4c54bd4 \u03af = new oc35e4c54bd4();
    private final occ93a9667d6 \u04dc = new oc7a3173be3e();
    private List<oc094a54ecb8> \u00d9 = Collections.emptyList();
    private float \u02e1;
    private final Object G = new Object();
    private final Object V = new Object();
    private final Map<oc69da1aa7f5, Float> \u0400 = new IdentityHashMap<oc69da1aa7f5, Float>();
    private final Map<oc69da1aa7f5, oc64a59b1eaa> \u0433 = new IdentityHashMap<oc69da1aa7f5, oc64a59b1eaa>();
    private final Map<oc69da1aa7f5, oc11d1e4dfb9> \u02ad = new IdentityHashMap<oc69da1aa7f5, oc11d1e4dfb9>();
    private final Map<oc69da1aa7f5, oc33beffb935> \u01d7 = new IdentityHashMap<oc69da1aa7f5, oc33beffb935>();
    private final ocf9f6726f63 \u0110 = new ocf9f6726f63(oc1e7298eef6::\u0240, true);
    private final oc6dfc3938c0 \u03a9;
    private int \u0537;
    private int \u00b5;
    private float \u0493;
    private final oc6f44315029 \u03ca = new oc6f44315029();
    private float \u04df;
    private float \u00ce;
    private float \u02ac;
    private final ocf2c1cef686 \u0137 = new ocf2c1cef686();
    private final Object \u0180 = new Object();

    public oc6a954e7c9f() {
        this.\u03a9 = new oc6dfc3938c0(this.\u0110, this.\u03ca);
    }

    private static float \u03f0(int n) {
        return L.\u026d(n);
    }

    private static double \u039c(int n) {
        return L.\u0239(n);
    }

    public oc057476a9f5 \u0155() {
        if (oc6a43806f12.\u0172 != null) {
            return new oc057476a9f5((float)oc6a43806f12.\u0172.\u02c0() / 255.0f, (float)oc6a43806f12.\u0172.z() / 255.0f, (float)oc6a43806f12.\u0172.\u0446() / 255.0f);
        }
        return new oc057476a9f5(1.0f, 0.35f, 0.0f);
    }

    public boolean \u0160() {
        return oc6a43806f12.\u020d != null && oc6a43806f12.\u020d.\u01ed();
    }

    public boolean \u018c() {
        return oc6a43806f12.\u04a0 != null && oc6a43806f12.\u04a0.\u01ed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {
        this.\u03af.\u0278(ocd94f97a9f3.\u0128());
        if (Mouse.isGrabbed()) {
            Mouse.setCursorPosition(this.mc.displayWidth / (0x8AE22E4F ^ 0x8AE22E4D), this.mc.displayHeight / (0x8AE22E4F ^ 0x8AE22E4D));
            Mouse.setGrabbed(false);
        }
    }

    @Override
    public void onGuiClosed() {
        this.\u0137.\u04c2();
        this.\u03af.\u04b7(true);
        this.\u03af.\u03fc();
        ocd94f97a9f3.\u01e3();
        if (oc2cf3d80e17.\u00c1 != null && oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u00c1.\u03e6(oc2cf3d80e17.\u0115);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void drawScreen(int n, int n2, float f) {
        this.\u0537 = n;
        this.\u00b5 = n2;
        this.\u0493 = f;
        int n3 = GL11.glGetInteger(0xA78AB502 ^ 0xA78ABEA2);
        try (occ22af137a2 occ22af137a22 = occ22af137a2.\u0158();){
            GL11.glMatrixMode(0xA78AA9A3 ^ 0xA78ABEA2);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, this.mc.displayWidth, this.mc.displayHeight, 0.0, -3000.0, 3000.0);
            GL11.glMatrixMode(0xA78AA9A2 ^ 0xA78ABEA2);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GlStateManager.disableDepth();
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0xA78ABDA0 ^ 0xA78ABEA2, 0xA78ABDA1 ^ 0xA78ABEA2, 1, 0xA78ABDA1 ^ 0xA78ABEA2);
            float f2 = oc6a43806f12.\u021d();
            float f3 = Mouse.getX();
            float f4 = this.mc.displayHeight - Mouse.getY() - 1;
            ocac488f5520 ocac488f55202 = this.I(this.mc.displayWidth, this.mc.displayHeight, f2, f3, f4, ocd94f97a9f3.\u0128());
            ocd94f97a9f3.\u03cb(ocac488f55202);
        }
        finally {
            GL11.glMatrixMode(0xA78AA9A2 ^ 0xA78ABEA2);
            GL11.glPopMatrix();
            GL11.glMatrixMode(0xA78AA9A3 ^ 0xA78ABEA2);
            GL11.glPopMatrix();
            GL11.glMatrixMode(n3);
        }
    }

    public ocac488f5520 I(int n, int n2, float f, float f2, float f3, double d) {
        ocac488f5520 ocac488f55202;
        try (oc6b92d7f083 oc6b92d7f0832 = oc1e7298eef6.\u04a9();){
            ocac488f55202 = this.\u043b(n, n2, f, f2, f3, d);
        }
        return ocac488f55202;
    }

    private ocac488f5520 \u043b(int n, int n2, float f, float f2, float f3, double d) {
        int n3 = oc9311f94f2e.\u03bc(oc9311f94f2e.\u0419(this.\u03af.\u04c5));
        if (this.\u03af.\u04c5 != n3) {
            this.\u03af.\u04c5 = n3;
            this.\u03af.\u0464 = oc9311f94f2e.\u0419(n3);
            this.\u03af.\u03fc();
        }
        float f4 = this.\u03af.\u046c(d);
        float f5 = this.\u03af.\u01f6;
        this.\u0137.\u053c();
        this.\u03af.\u024e = f2;
        this.\u03af.\u04b8 = f3;
        float f6 = (float)n / f;
        float f7 = (float)n2 / f;
        ocd9db3ede42 ocd9db3ede422 = this.\u03af.\u01f6(f6, f7, f, this.\u018c(), d);
        float f8 = oc6a954e7c9f.\u045d(f5);
        this.\u04df = f;
        this.\u00ce = 0.0f;
        this.\u02ac = oc6a954e7c9f.\u03f0(0xCA4B5FF8 ^ 0xCA5F562C) + f8 * oc6a954e7c9f.\u03f0(0xCA4B5FF4 ^ 0xCA5F562C) - this.\u03af.\u0102;
        ocac488f5520 ocac488f55202 = new ocac488f5520().\u019a().\u0566().\u042e(f, f, 1.0f).\u0176(f8).\u0104(oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FFC ^ 0xCA5F562C)).\u0217(0.0f, 0.0f, f6, f7, 0.0f).\u03e8(0.0f, this.\u02ac, 0.0f);
        oce4a4c32971 oce4a4c329712 = this.\u03af.\u0500.peek();
        ocd9db3ede42 ocd9db3ede423 = oce4a4c329712.\u027d(oc6a954e7c9f.\u03f0(0xCA4B5EAC ^ 0xCA5F562C) * (float)oc9311f94f2e.\u00ba(oce4a4c329712.\u04e0.\u0423));
        ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0xCA4B5EA8 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5EA8 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5EA8 ^ 0xCA5F562C), 1.0f).\u0217(ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0423, ocd9db3ede423.\u0462, oc6a954e7c9f.\u03f0(0xCA4B5EA4 ^ 0xCA5F562C));
        this.\u03af.\u0464 = oc98904eb9e7.\u03e9(this.\u03af.\u0464, oc9311f94f2e.\u0419(this.\u03af.\u04c5), (float)((double)f4 / oc6a954e7c9f.\u039c(0xCA4B5EBC ^ 0xCA5F562C)));
        int n4 = (int)this.\u03af.\u0464;
        ocd9db3ede42 ocd9db3ede424 = oc9311f94f2e.\u0244(ocd9db3ede423, n4);
        ocd9db3ede42 ocd9db3ede425 = oc9311f94f2e.\u0244(ocd9db3ede423, Math.min(n4 + 1, oc9311f94f2e.\u049d.length - 1));
        float f9 = this.\u03af.\u0464 - (float)n4;
        ocd9db3ede42 ocd9db3ede426 = new ocd9db3ede42(ocd9db3ede424.\u00c8 + (ocd9db3ede425.\u00c8 - ocd9db3ede424.\u00c8) * f9, ocd9db3ede424.\u0151 + (ocd9db3ede425.\u0151 - ocd9db3ede424.\u0151) * f9, ocd9db3ede424.\u0423, ocd9db3ede424.\u0462).\u0427(oc6a954e7c9f.\u03f0(0xCA4B5EB4 ^ 0xCA5F562C));
        ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0xCA4B5EB0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5EB0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5EB0 ^ 0xCA5F562C), 1.0f).\u0217(ocd9db3ede426.\u00c8, ocd9db3ede426.\u0151, ocd9db3ede426.\u0423, ocd9db3ede426.\u0462, oc6a954e7c9f.\u03f0(0xCA4B5E8C ^ 0xCA5F562C));
        String[] stringArray = oc9311f94f2e.\u049d;
        for (int i = 0; i < stringArray.length; ++i) {
            ocd9db3ede42 ocd9db3ede427 = oc9311f94f2e.\u0244(ocd9db3ede423, i);
            if (i == stringArray.length - 1) {
                float f10;
                if (this.\u0137.\u0439(this.\u0180, this.\u03af.\u0518(ocd9db3ede427), this.\u03af.\u01db, this.\u03af.\u0107 == 0, !this.\u03af.\u00c7, d)) {
                    this.\u03af.\u03ef = true;
                    this.mc.displayGuiScreen(null);
                }
                if ((f10 = this.\u0137.\u019b(this.\u0180)) > 0.0f) {
                    ocac488f55202.\u0104(0.8f, 0.25f, 0.27f, 0.25f).\u0217(ocd9db3ede427.\u00c8 + 6.0f, ocd9db3ede427.\u0151 + 6.0f, (ocd9db3ede427.\u0423 - 12.0f) * f10, ocd9db3ede427.\u0462 - 12.0f, 14.0f);
                }
            } else if (this.\u03af.f(ocd9db3ede427)) {
                this.\u03af.\u04c5 = oc9311f94f2e.\u03bc(i);
                this.\u03af.\u00fa = 0;
            }
            ocd9db3ede42 ocd9db3ede428 = ocd9db3ede427.\u0427(oc6a954e7c9f.\u03f0(0xCA4B5EB4 ^ 0xCA5F562C));
            boolean bl = this.\u03af.\u0518(ocd9db3ede428);
            int n5 = i == stringArray.length - 1 ? oc6a954e7c9f.\u010b(oc6a954e7c9f.\u03f0(bl ? 0xCA4B5E98 ^ 0xCA5F562C : 0xCA4B5E84 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(bl ? 0xCA4B5E94 ^ 0xCA5F562C : 0xCA4B5E9C ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(bl ? 0xCA4B5E94 ^ 0xCA5F562C : 0xCA4B5E9C ^ 0xCA5F562C)) : this.\u00cf(bl ? 0xCA4B5E80 ^ 0xCA5F562C : 0xCA4B5E84 ^ 0xCA5F562C);
            this.\u0110.\u0397(ocac488f55202, stringArray[i], ocd9db3ede428, 1, 0, oc6a954e7c9f.\u03f0(0xCA4B5E88 ^ 0xCA5F562C), n5);
        }
        float f11 = (float)oc9311f94f2e.\u0419(this.\u03af.\u04c5) - this.\u03af.\u0464;
        ocac488f55202.\u0566();
        if (f11 != 0.0f) {
            float f12 = Float.intBitsToFloat(Float.floatToRawIntBits(f11) & L.\u0497(0xCA4B5F2C ^ 0xCA5F562C));
            float f13 = oc6a954e7c9f.\u03f0(0xCA4B5EFC ^ 0xCA5F562C) - (f12 + f12);
            if (f12 > oc6a954e7c9f.\u03f0(0xCA4B5EE0 ^ 0xCA5F562C)) {
                f13 = 0.0f;
            }
            this.\u00ce = (float)((double)f11 * ((double)f6 * oc6a954e7c9f.\u039c(0xCA4B5F3C ^ 0xCA5F562C)));
            ocac488f55202.\u0176(f13).\u03e8(this.\u00ce, 0.0f, 0.0f);
        }
        if (this.\u03af.\u04c5 != oc9311f94f2e.\u0258) {
            this.\u0221(ocac488f55202, oce4a4c329712, d, f4, f6, f7);
        } else {
            this.\u01d9(ocac488f55202, oce4a4c329712, d, f6, f7);
        }
        ocac488f55202.\u021a().\u0408();
        this.\u03af.\u0217();
        int n6 = this.\u03af.\u01d3;
        this.\u00ce = 0.0f;
        this.\u0110.\u018c(ocac488f55202, this.\u03ca, f4);
        ocac488f55202.\u021a().\u0408();
        if (this.\u03af.\u0107 != 0) {
            float f14 = oc6a954e7c9f.\u045d(this.\u03af.\u0544);
            ocac488f55202.\u0566().\u042e(f, f, 1.0f).\u0176(f14).\u0104(oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FE0 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5FFC ^ 0xCA5F562C)).\u0217(0.0f, 0.0f, f6, f7, 0.0f);
            this.\u02ac = oc6a954e7c9f.\u03f0(0xCA4B5FF8 ^ 0xCA5F562C) + f14 * oc6a954e7c9f.\u03f0(0xCA4B5FF4 ^ 0xCA5F562C);
            ocac488f55202.\u03e8(0.0f, this.\u02ac, 0.0f);
            this.\u03af.\u0226 -= this.\u03af.\u0102;
            this.\u03af.\u0212();
            ocd9db3ede42 ocd9db3ede429 = ocd9db3ede422;
            if (ocd9db3ede422.\u0423 > oc6a954e7c9f.\u03f0(0xCA4B5FB8 ^ 0xCA5F562C)) {
                ocd9db3ede429 = new ocd9db3ede42((float)((double)ocd9db3ede422.\u00c8 + (double)(ocd9db3ede422.\u0423 + oc6a954e7c9f.\u03f0(0xCA4B5FB4 ^ 0xCA5F562C)) * oc6a954e7c9f.\u039c(0xCA4B5F14 ^ 0xCA5F562C)), ocd9db3ede422.\u0151, oc6a954e7c9f.\u03f0(0xCA4B5FB8 ^ 0xCA5F562C), ocd9db3ede422.\u0462);
            }
            oce4a4c32971 oce4a4c329713 = this.\u03af.\u0164(ocd9db3ede429, oc6a954e7c9f.\u03f0(0xCA4B5ED4 ^ 0xCA5F562C), oc6a954e7c9f.\u03f0(0xCA4B5ED0 ^ 0xCA5F562C), false);
            this.\u014f(ocac488f55202, oce4a4c329713, d);
            this.\u03af.\u0217();
            ocac488f55202.\u021a().\u0408();
        }
        this.\u03af.\u01d3 = n6;
        this.\u03af.\u0573(f7, d);
        this.\u0137.\u0490();
        return ocac488f55202;
    }

    public void \u0275(oc69da1aa7f5 oc69da1aa7f52, boolean bl) {
        oc11d1e4dfb9 oc11d1e4dfb92 = new oc11d1e4dfb9();
        oc11d1e4dfb92.\u0545 = bl;
        this.\u02ad.put(oc69da1aa7f52, oc11d1e4dfb92);
    }

    private static float \u045d(float f) {
        return oc6a954e7c9f.\u03f0(0xD8501E1B ^ 0xD84417DF) - ocba3c42d463.\u00f1(oc6a954e7c9f.\u03f0(0xD8501E1B ^ 0xD84417DF) - f, oc6a954e7c9f.\u03f0(0xD8501E17 ^ 0xD84417DF));
    }

    private static int \u010b(float f, float f2, float f3) {
        return 0x8908FD2C ^ 0x7608FD2C | ((int)(f * 255.0f) & (0x7608FDD3 ^ 0x7608FD2C)) << (0x7608FD3C ^ 0x7608FD2C) | ((int)(f2 * 255.0f) & (0x7608FDD3 ^ 0x7608FD2C)) << (0x7608FD24 ^ 0x7608FD2C) | (int)(f3 * 255.0f) & (0x7608FDD3 ^ 0x7608FD2C);
    }

    private void \u03a1(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712) {
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u040e;
        ocac488f55202.\u04d2((ocd9db3ede422.\u00c8 + this.\u00ce) * this.\u04df, (ocd9db3ede422.\u0151 + this.\u02ac) * this.\u04df, ocd9db3ede422.\u0423 * this.\u04df, ocd9db3ede422.\u0462 * this.\u04df);
    }

    private void \u0221(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, double d, float f, float f2, float f3) {
        oc057476a9f5 oc057476a9f52 = this.\u0155();
        float[] fArray = new float[0xD95C21F7 ^ 0xD95C21F3];
        fArray[0] = oc057476a9f52.\u0130;
        fArray[1] = oc057476a9f52.\u0562;
        fArray[0xD95C21F1 ^ 0xD95C21F3] = oc057476a9f52.\u01b8;
        fArray[0xD95C21F0 ^ 0xD95C21F3] = 1.0f;
        float[] fArray2 = fArray;
        oce4a4c329712.\u00ee(oc6a954e7c9f.\u03f0(0xD9482813 ^ 0xD95C21F3));
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9311f94f2e.\u00c0(this.\u03af.\u04c5)) {
            boolean bl;
            float f4 = this.\u0400.containsKey(oc69da1aa7f52) ? this.\u0400.get(oc69da1aa7f52).floatValue() : 0.0f;
            ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(f4);
            if (!oc98904eb9e7.\u0203(new ocd9db3ede42(0.0f, this.\u03af.\u0102, f2, f3), ocd9db3ede422)) continue;
            ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0xD9482803 ^ 0xD95C21F3), oc6a954e7c9f.\u03f0(0xD9482803 ^ 0xD95C21F3), oc6a954e7c9f.\u03f0(0xD9482803 ^ 0xD95C21F3), 1.0f).\u0217(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462, oc6a954e7c9f.\u03f0(0xD9482807 ^ 0xD95C21F3));
            oce4a4c32971 oce4a4c329713 = this.\u03af.\u0164(ocd9db3ede422, oc6a954e7c9f.\u03f0(0xD948280B ^ 0xD95C21F3), 12.0f, true);
            this.\u03a1(ocac488f55202, oce4a4c329713);
            oce4a4c329713.\u03b1(1);
            ocd9db3ede42 ocd9db3ede423 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0xD9482807 ^ 0xD95C21F3));
            oc11d1e4dfb9 oc11d1e4dfb92 = this.\u02ad.get(oc69da1aa7f52);
            if (oc11d1e4dfb92 == null) {
                oc11d1e4dfb92 = new oc11d1e4dfb9();
                this.\u02ad.put(oc69da1aa7f52, oc11d1e4dfb92);
            }
            boolean bl2 = oc69da1aa7f52.\u0260() != null && !oc69da1aa7f52.\u0260().isEmpty();
            float f5 = this.\u0160() ? this.\u0110.\u0552(this.\u03af, ocac488f55202, oc11d1e4dfb92, bl2, oc69da1aa7f52.getDisplayName(), ocd9db3ede423, 16.0f, this.\u00cf(0xD9482BF3 ^ 0xD95C21F3), this.\u00cf(0xD9482BF7 ^ 0xD95C21F3)) : this.\u0110.\u0397(ocac488f55202, oc69da1aa7f52.getDisplayName(), ocd9db3ede423, 0, 0, oc6a954e7c9f.\u03f0(0xD948280F ^ 0xD95C21F3), this.\u00cf(0xD9482BF3 ^ 0xD95C21F3));
            oc33beffb935 oc33beffb9352 = this.\u01d7.get(oc69da1aa7f52);
            if (oc33beffb9352 == null) {
                int n2 = occ573e1fe6c.\u0548(oc69da1aa7f52.\u027d());
                oc33beffb9352 = new oc33beffb935(n2, oc69da1aa7f52.\u0177(), oc69da1aa7f52, n -> {
                    oc69da1aa7f52.\u04dd(occ573e1fe6c.\u025b(n));
                    oc2cf3d80e17.\u04eb();
                });
                this.\u01d7.put(oc69da1aa7f52, oc33beffb9352);
            }
            if (this.\u03af.\u00fa != 1 || this.\u03af.\u0580 != oc69da1aa7f52) {
                oc33beffb9352.\u03e1 = occ573e1fe6c.\u0548(oc69da1aa7f52.\u027d());
                oc33beffb9352.\u0442 = oc69da1aa7f52.\u0177();
            }
            this.\u0110.\u029e(this.\u03af, ocac488f55202, oc33beffb9352, new ocd9db3ede42(f5 + oc6a954e7c9f.\u03f0(0xD9482BFB ^ 0xD95C21F3), ocd9db3ede423.\u0151, ocd9db3ede423.\u0423 - f5 + ocd9db3ede423.\u00c8, ocd9db3ede423.\u0462), fArray2, true);
            if (oc69da1aa7f52.\u0177() != oc33beffb9352.\u0442) {
                oc69da1aa7f52.\u04c1(oc33beffb9352.\u0442);
                oc2cf3d80e17.\u04eb();
            }
            ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede423.\u00c8 + ocd9db3ede423.\u0423 + oc6a954e7c9f.\u03f0(0xD9482BFF ^ 0xD95C21F3), ocd9db3ede423.\u0151, oc6a954e7c9f.\u03f0(0xD9482BE3 ^ 0xD95C21F3), ocd9db3ede423.\u0462);
            oc64a59b1eaa oc64a59b1eaa2 = this.\u0433.get(oc69da1aa7f52);
            if (oc64a59b1eaa2 == null) {
                oc64a59b1eaa2 = new oc64a59b1eaa();
                this.\u0433.put(oc69da1aa7f52, oc64a59b1eaa2);
            }
            if ((bl = oc449e61fefc.\u01fd(this.\u03af, ocac488f55202, oc64a59b1eaa2, ocd9db3ede424, oc69da1aa7f52.z$3rzb3dil7uydr(), fArray2, d)) != oc69da1aa7f52.z$3rzb3dil7uydr()) {
                oc69da1aa7f52.z$11p1yfisf2riw();
                oc2cf3d80e17.\u04eb();
            }
            if (!this.\u0160()) {
                ocd9db3ede42 ocd9db3ede425 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0xD9482807 ^ 0xD95C21F3));
                this.\u0110.\u0552(this.\u03af, ocac488f55202, oc11d1e4dfb92, bl2, oc9311f94f2e.\u0264(oc69da1aa7f52), ocd9db3ede425, 14.0f, this.\u00cf(0xD9482BE7 ^ 0xD95C21F3), this.\u00cf(0xD9482BEB ^ 0xD95C21F3));
            }
            if (oc11d1e4dfb92.\u0545) {
                this.\u03a9.\u012d(oc69da1aa7f52, this.\u03af, ocac488f55202, oce4a4c329713, fArray2, d);
            }
            float f6 = ocf9f6726f63.\u0102(this.\u03af.\u0217());
            this.\u0400.put(oc69da1aa7f52, Float.valueOf(f4 == 0.0f ? f6 : oc98904eb9e7.\u03e9(f4, f6, (float)((double)f / oc6a954e7c9f.\u039c(0xD948281B ^ 0xD95C21F3)))));
            ocac488f55202.\u021a();
        }
    }

    private void \u045b(ocac488f5520 ocac488f55202, String string, ocd9db3ede42 ocd9db3ede422, float f, int n) {
        float f2 = oc1e7298eef6.\u0240(string, 0, f);
        float f3 = (float)((double)ocd9db3ede422.\u0423 * oc6a954e7c9f.\u039c(0x68BCA669 ^ 0x68A8AE51) + (double)ocd9db3ede422.\u00c8) - f2 * 0.5f;
        float f4 = (float)((double)ocd9db3ede422.\u0462 * oc6a954e7c9f.\u039c(0x68BCA669 ^ 0x68A8AE51) + (double)(ocd9db3ede422.\u0151 + oc6a954e7c9f.\u03f0(0x68BCA611 ^ 0x68A8AE51)));
        ocac488f55202.\u00ff(string, f3, f4, n, f, 0x68A8AE40 ^ 0x68A8AE51);
    }

    private int \u00cf(int n) {
        int n2 = (int)(oc6a954e7c9f.\u03f0(n) * 255.0f);
        return 0x2D06FBCF ^ 0xD206FBCF | n2 << (0xD206FBDF ^ 0xD206FBCF) | n2 << (0xD206FBC7 ^ 0xD206FBCF) | n2;
    }

    private void \u0431(Throwable throwable) {
        this.\u03af.\u04c4(throwable.getMessage() == null ? throwable.toString() : throwable.getMessage(), () -> {}, ocd94f97a9f3.\u0128());
    }

    private void \u01e2(int n, String string, boolean bl) {
        try {
            if (n == 0) {
                this.\u04dc.z$290lade6yz6q7(string);
            } else if (n == 1) {
                this.\u04dc.z$8vfnfg7a8xhb(string, bl);
            } else if (n == (0x667DD593 ^ 0x667DD591)) {
                this.\u04dc.z$1detxdtpegs8e();
            } else if (n == (0x667DD592 ^ 0x667DD591)) {
                this.\u04dc.z$3og0ar4vwp2z4(string);
            }
        }
        catch (IOException iOException) {
            this.\u0431(iOException);
        }
    }

    private void j(int n, String string, double d) {
        if (n == 1 && string == null) {
            this.\u0431(new oc7d882df7eb(0xD8BEF5D1 ^ 0xD8BEE2A2, L.\u00f2(0xD8AAE925 ^ 0xD8BEE2A2)));
        } else if (n == (0xD8BEE2A1 ^ 0xD8BEE2A2) && string == null) {
            this.\u0431(new oc7d882df7eb(0xD8BEF5D6 ^ 0xD8BEE2A2, L.\u00f2(0xD8AAE9C7 ^ 0xD8BEE2A2)));
        } else if (this.\u03af.R) {
            this.\u01e2(n, string, true);
        } else {
            int n2 = (0xD8AAEE92 ^ 0xD8BEE2A2) + L.\u0497((0xD8AAEE92 ^ 0xD8BEE2A2) + n * (0xD8BEE2A6 ^ 0xD8BEE2A2));
            this.\u03af.\u04c4(L.\u00f2(n2).replace("%s", string == null ? L.\u00f2(0xD8AAE868 ^ 0xD8BEE2A2) : string), () -> {
                this.\u03af.R = true;
                this.\u01e2(n, string, true);
            }, d);
        }
    }

    private void \u011d(oc094a54ecb8 oc094a54ecb82, double d) {
        this.\u03af.\u0183("Rename profile", oc094a54ecb82, oc98904eb9e7::\u045d, string -> {
            if (string == null) {
                return;
            }
            try {
                this.\u04dc.z$1y8rno1hz6kp0(oc094a54ecb82.\u049c, (String)string);
                this.\u00d9 = this.\u04dc.z$1cf840poz11vw();
                this.\u03af.\u057a = d;
            }
            catch (IOException iOException) {
                this.\u0431(iOException);
            }
        }, d);
        this.\u03af.\u02c0.append(oc094a54ecb82.\u049c);
    }

    private void \u01d9(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, double d, float f, float f2) {
        Object object;
        Object object2;
        if (this.\u03af.\u00fa == 0 && d > this.\u03af.\u057a + oc6a954e7c9f.\u039c(0x677A6410 ^ 0x676E6D08)) {
            try {
                this.\u00d9 = this.\u04dc.z$1cf840poz11vw();
            }
            catch (IOException iOException) {
                this.\u00d9 = this.\u04dc.z$ezjgq66s9xkf();
                this.\u0431(iOException);
            }
            this.\u03af.\u057a = d;
        }
        oce4a4c329712.\u00ee(oc6a954e7c9f.\u03f0(0x677A6428 ^ 0x676E6D08));
        float f3 = oc6a954e7c9f.\u03f0(0x677A6420 ^ 0x676E6D08);
        float f4 = oc6a954e7c9f.\u03f0(0x677A6424 ^ 0x676E6D08);
        for (int i = 0; i <= this.\u00d9.size(); ++i) {
            object2 = i == 0 ? null : this.\u00d9.get(i - 1);
            object = oce4a4c329712.\u027d(this.\u02e1);
            if (!oc98904eb9e7.\u0203(new ocd9db3ede42(0.0f, this.\u03af.\u0102, f, f2), (ocd9db3ede42)object)) continue;
            ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), 1.0f).\u0217(((ocd9db3ede42)object).\u00c8, ((ocd9db3ede42)object).\u0151, ((ocd9db3ede42)object).\u0423, ((ocd9db3ede42)object).\u0462, f3);
            oce4a4c32971 oce4a4c329713 = this.\u03af.\u0164((ocd9db3ede42)object, oc6a954e7c9f.\u03f0(0x677A65F0 ^ 0x676E6D08), 12.0f, true);
            this.\u03a1(ocac488f55202, oce4a4c329713);
            oce4a4c329713.\u03b1(1);
            ocd9db3ede42 ocd9db3ede422 = oce4a4c329713.\u027d(f3);
            ocd9db3ede42 ocd9db3ede423 = new ocd9db3ede42(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, Math.max(0.0f, ocd9db3ede422.\u0423 - 124.0f), ocd9db3ede422.\u0462);
            boolean bl = object2 != null && this.\u03af.\u0518(ocd9db3ede423);
            this.\u0110.\u0397(ocac488f55202, object2 == null ? L.\u00f2(0x677A67C2 ^ 0x676E6D08) : ((oc094a54ecb8)object2).\u049c, ocd9db3ede423, 0, 0, f4, this.\u00cf(bl ? 0x677A65D8 ^ 0x676E6D08 : 0x677A6438 ^ 0x676E6D08));
            if (object2 != null) {
                if (bl) {
                    this.\u03ca.\u0537("Rename profile", oc3004491957.\u0182(ocd9db3ede423.\u00c8), oc3004491957.\u0182(ocd9db3ede423.\u0151));
                }
                if (this.\u03af.f(ocd9db3ede423)) {
                    this.\u011d((oc094a54ecb8)object2, d);
                }
            }
            for (int j = 0; j < (0x676E6D0C ^ 0x676E6D08); ++j) {
                ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0423 - (float)((0x676E6D58 ^ 0x676E6D08) - (0x676E6D1C ^ 0x676E6D08) * j) - (float)((0x676E6D2C ^ 0x676E6D08) - (0x676E6D04 ^ 0x676E6D08) * j), ocd9db3ede422.\u0151, f3, 20.0f);
                boolean bl2 = (j & (object2 == null ? 1 : 0)) == 0;
                int n = (0x677A67DC ^ 0x676E6D08) + L.\u0497((0x677A67DC ^ 0x676E6D08) + j * (0x676E6D0C ^ 0x676E6D08));
                String string = L.\u00f2(n);
                ocefb3475d27.\u023f(ocac488f55202, ocd9db3ede424, j, bl2, bl2 && this.\u03af.\u0518(ocd9db3ede424));
                if (bl2 && this.\u03af.\u0518(ocd9db3ede424)) {
                    this.\u03ca.\u0537(string, oc3004491957.\u043e((double)ocd9db3ede424.\u00c8 + (double)ocd9db3ede424.\u0423 * oc6a954e7c9f.\u039c(0x677A6430 ^ 0x676E6D08)), oc3004491957.\u0182(ocd9db3ede424.\u0151));
                }
                if (!bl2 || !this.\u03af.f(ocd9db3ede424)) continue;
                this.j(j, object2 == null ? null : ((oc094a54ecb8)object2).\u049c, d);
            }
            if (!this.\u0160()) {
                ocd9db3ede42 ocd9db3ede425 = oce4a4c329713.\u027d(f3);
                this.\u0110.\u0397(ocac488f55202, object2 == null ? L.\u00f2(0x677A6608 ^ 0x676E6D08) : ((oc094a54ecb8)object2).\u027f, ocd9db3ede425, 0, 0, oc6a954e7c9f.\u03f0(0x677A6448 ^ 0x676E6D08), this.\u00cf(0x677A644C ^ 0x676E6D08));
            }
            this.\u02e1 = this.\u03af.\u0217();
            ocac488f55202.\u021a();
        }
        ocd9db3ede42 ocd9db3ede426 = oce4a4c329712.\u027d(this.\u02e1);
        ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), oc6a954e7c9f.\u03f0(0x677A642C ^ 0x676E6D08), oc6a954e7c9f.\u03f0(0x677A65C4 ^ 0x676E6D08)).\u0217(ocd9db3ede426.\u00c8, ocd9db3ede426.\u0151, ocd9db3ede426.\u0423, ocd9db3ede426.\u0462, f3);
        if (this.\u03af.f(ocd9db3ede426)) {
            this.\u03af.\u00da(this.G, oc98904eb9e7::\u045d);
        }
        if (this.\u03af.\u0469(this.G)) {
            object2 = new ocd9db3ede42(ocd9db3ede426.\u00c8, (float)((double)ocd9db3ede426.\u0151 + (double)ocd9db3ede426.\u0462 * oc6a954e7c9f.\u039c(0x677A6430 ^ 0x676E6D08) + oc6a954e7c9f.\u039c(0x677A6458 ^ 0x676E6D08)), ocd9db3ede426.\u0423, oc6a954e7c9f.\u03f0(0x677A646C ^ 0x676E6D08));
            this.\u0110.\u024f(this.\u03af, ocac488f55202, (ocd9db3ede42)object2, 1, f4, d);
            object = this.\u03af.\u0177();
            if (object != null) {
                this.\u01e2(1, (String)object, false);
            }
        } else {
            this.\u045b(ocac488f55202, L.\u00f2(0x677A6115 ^ 0x676E6D08), ocd9db3ede426, oc6a954e7c9f.\u03f0(0x677A6440 ^ 0x676E6D08), this.\u00cf(this.\u03af.\u0518(ocd9db3ede426) ? 0x677A65D8 ^ 0x676E6D08 : 0x677A6438 ^ 0x676E6D08));
        }
    }

    private void \u014f(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712, double d) {
        this.\u03af.\u043c = true;
        this.\u03af.\u0544 = oc62a465bc97.\u0517(oc6a954e7c9f.\u03f0(0x2A9EADAC ^ 0x2A8AA33C), (float)((double)this.\u03af.\u0544 + (d - this.\u03af.\u00c9) / oc6a954e7c9f.\u039c(0x2A9EADB4 ^ 0x2A8AA33C)));
        oce4a4c329712.\u03b1(1);
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(this.\u03af.\u041f);
        ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0x2A9EADA8 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(0x2A9EADA8 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(0x2A9EADA8 ^ 0x2A8AA33C), 1.0f).\u0217(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0423, ocd9db3ede422.\u0462, oc6a954e7c9f.\u03f0(0x2A9EADA4 ^ 0x2A8AA33C));
        oce4a4c32971 oce4a4c329713 = this.\u03af.\u0164(ocd9db3ede422, oc6a954e7c9f.\u03f0(0x2A9EADA0 ^ 0x2A8AA33C), 12.0f, true);
        this.\u03a1(ocac488f55202, oce4a4c329713);
        oce4a4c329713.\u03b1(1);
        ocd9db3ede42 ocd9db3ede423 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADA4 ^ 0x2A8AA33C));
        this.\u0110.\u0397(ocac488f55202, this.\u03af.\u0127, ocd9db3ede423, 0, 0, oc6a954e7c9f.\u03f0(0x2A9EAD9C ^ 0x2A8AA33C), this.\u00cf(0x2A9EAD98 ^ 0x2A8AA33C));
        ocd9db3ede42 ocd9db3ede424 = new ocd9db3ede42(ocd9db3ede423.\u0423 - ocd9db3ede423.\u0462 + ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151, ocd9db3ede423.\u0462, ocd9db3ede423.\u0462);
        float f = (float)((double)ocd9db3ede424.\u0423 * oc6a954e7c9f.\u039c(0x2A9EAD84 ^ 0x2A8AA33C));
        boolean bl = this.\u03af.\u0518(ocd9db3ede424);
        ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(bl ? 0x2A9EAD90 ^ 0x2A8AA33C : 0x2A9EAD94 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(bl ? 0x2A9EAD8C ^ 0x2A8AA33C : 0x2A9EAD94 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(bl ? 0x2A9EAD8C ^ 0x2A8AA33C : 0x2A9EAD94 ^ 0x2A8AA33C), 1.0f).\u0297(oc6a954e7c9f.\u03f0(0x2A9EAD88 ^ 0x2A8AA33C)).\u0138(ocd9db3ede424.\u00c8 + f, ocd9db3ede424.\u0151 + f, ocd9db3ede424.\u00c8 + ocd9db3ede424.\u0423 - f, ocd9db3ede424.\u0151 + ocd9db3ede424.\u0462 - f).\u0138(ocd9db3ede424.\u00c8 + ocd9db3ede424.\u0423 - f, ocd9db3ede424.\u0151 + f, ocd9db3ede424.\u00c8 + f, ocd9db3ede424.\u0151 + ocd9db3ede424.\u0462 - f);
        boolean bl2 = this.\u03af.f(ocd9db3ede424);
        int n = this.\u03af.\u0107;
        if (n == 1 || n == (0x2A8AA338 ^ 0x2A8AA33C)) {
            ocd9db3ede42 ocd9db3ede425 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADFC ^ 0x2A8AA33C));
            ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(0x2A9EADF4 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(0x2A9EADF4 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(0x2A9EADF4 ^ 0x2A8AA33C), 1.0f).\u0297(oc6a954e7c9f.\u03f0(0x2A9EAD88 ^ 0x2A8AA33C)).\u048f(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u0423, ocd9db3ede425.\u0462, oc6a954e7c9f.\u03f0(0x2A9EADA0 ^ 0x2A8AA33C));
            if (!this.\u03af.\u0469(this.\u03af.\u0580)) {
                this.\u03af.\u04b7(true);
            } else {
                this.\u0110.\u024f(this.\u03af, ocac488f55202, ocd9db3ede425.\u0427(oc6a954e7c9f.\u03f0(0x2A9EADF0 ^ 0x2A8AA33C)), 1, oc6a954e7c9f.\u03f0(0x2A9EADF8 ^ 0x2A8AA33C), d);
                if (n == 1) {
                    this.\u03af.\u049b();
                } else {
                    this.\u03af.\u0279(d);
                    ocd9db3ede42 ocd9db3ede426 = null;
                    Integer n2 = null;
                    for (int i = 0; i < this.\u03af.\u054e.size(); ++i) {
                        if ((i & 1) == 0) {
                            ocd9db3ede426 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADE4 ^ 0x2A8AA33C));
                        }
                        ocd9db3ede42 ocd9db3ede427 = new ocd9db3ede42(ocd9db3ede426.\u00c8 + (float)(i & 1) * ocd9db3ede426.\u0423 * oc6a954e7c9f.\u03f0(0x2A9EADE0 ^ 0x2A8AA33C), ocd9db3ede426.\u0151, ocd9db3ede426.\u0423 * oc6a954e7c9f.\u03f0(0x2A9EADE0 ^ 0x2A8AA33C), ocd9db3ede426.\u0462);
                        int n3 = this.\u03af.\u054e.get(i);
                        this.\u0110.\u0397(ocac488f55202, this.\u03af.\u00f3.get(n3), ocd9db3ede427, 0, 0, oc6a954e7c9f.\u03f0(0x2A9EAD9C ^ 0x2A8AA33C), this.\u00cf(this.\u03af.\u0518(ocd9db3ede427) ? 0x2A9EADAC ^ 0x2A8AA33C : 0x2A9EAD98 ^ 0x2A8AA33C));
                        if (!this.\u03af.f(ocd9db3ede427)) continue;
                        n2 = n3;
                    }
                    if (this.\u03af.\u00ec != 0) {
                        ocd9db3ede42 ocd9db3ede428 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADE4 ^ 0x2A8AA33C));
                        this.\u0110.\u0397(ocac488f55202, L.\u00f2(0x2A9EACAD ^ 0x2A8AA33C).replace("%u", Integer.toString(Math.min(this.\u03af.\u00ec, 0x2A8A8433 ^ 0x2A8AA33C))), ocd9db3ede428, 0, 0, oc6a954e7c9f.\u03f0(0x2A9EADF8 ^ 0x2A8AA33C), this.\u00cf(0x2A9EAD94 ^ 0x2A8AA33C));
                    }
                    if (n2 != null) {
                        this.\u03af.J(n2);
                    }
                }
            }
        } else if (n == (0x2A8AA33F ^ 0x2A8AA33C)) {
            ocd9db3ede42 ocd9db3ede429 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADFC ^ 0x2A8AA33C));
            this.\u0110.\u0397(ocac488f55202, this.\u03af.\u00ca, ocd9db3ede429, 0, 0, oc6a954e7c9f.\u03f0(0x2A9EADF8 ^ 0x2A8AA33C), this.\u00cf(0x2A9EAD98 ^ 0x2A8AA33C));
            ocd9db3ede42 ocd9db3ede4210 = oce4a4c329713.\u027d(oc6a954e7c9f.\u03f0(0x2A9EADFC ^ 0x2A8AA33C));
            boolean bl3 = this.\u03af.\u0518(ocd9db3ede4210);
            ocac488f55202.\u0104(oc6a954e7c9f.\u03f0(bl3 ? 0x2A9EAD90 ^ 0x2A8AA33C : 0x2A9EAD98 ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(bl3 ? 0x2A9EAD8C ^ 0x2A8AA33C : 0x2A9EADDC ^ 0x2A8AA33C), oc6a954e7c9f.\u03f0(bl3 ? 0x2A9EAD8C ^ 0x2A8AA33C : 0x2A9EADDC ^ 0x2A8AA33C), 1.0f).\u0217(ocd9db3ede4210.\u00c8, ocd9db3ede4210.\u0151, ocd9db3ede4210.\u0423, ocd9db3ede4210.\u0462, oc6a954e7c9f.\u03f0(0x2A9EADD8 ^ 0x2A8AA33C));
            this.\u045b(ocac488f55202, L.\u00f2(0x2A9EACB4 ^ 0x2A8AA33C), ocd9db3ede4210, oc6a954e7c9f.\u03f0(0x2A9EADF8 ^ 0x2A8AA33C), this.\u00cf(0x2A9EADAC ^ 0x2A8AA33C));
            if (this.\u03af.f(ocd9db3ede4210)) {
                this.\u03af.\u03fa();
            }
        } else if (n == (0x2A8AA33E ^ 0x2A8AA33C)) {
            this.\u018c(ocac488f55202, oce4a4c329713);
        }
        this.\u03af.\u041f = this.\u03af.\u0217();
        ocac488f55202.\u021a();
        this.\u03af.\u043c = false;
        this.\u03af.\u00c9 = d;
        if (bl2 && this.\u03af.\u0107 != 0) {
            this.\u03af.\u04b7(true);
        }
    }

    private static float[] M(float[][] fArray, float f) {
        if (fArray.length == 1) {
            return fArray[0];
        }
        float f2 = oc62a465bc97.\u0496(0.0f, 1.0f, f) * (float)(fArray.length - 1);
        int n = Math.min(fArray.length - (0x76281C9F ^ 0x76281C9D), (int)f2);
        float f3 = f2 - (float)n;
        float[] fArray2 = new float[0x76281C99 ^ 0x76281C9D];
        for (int i = 0; i < (0x76281C99 ^ 0x76281C9D); ++i) {
            fArray2[i] = fArray[n][i] + (fArray[n + 1][i] - fArray[n][i]) * f3;
        }
        return fArray2;
    }

    private void \u018c(ocac488f5520 ocac488f55202, oce4a4c32971 oce4a4c329712) {
        float f;
        String string;
        ocd9db3ede42 ocd9db3ede422 = oce4a4c329712.\u027d(oc6a954e7c9f.\u03f0(0x46C6353E ^ 0x46D23BD6));
        ocac488f55202.\u0104(this.\u03af.\u0373[0], this.\u03af.\u0373[1], this.\u03af.\u0373[0x46D23BD4 ^ 0x46D23BD6], 1.0f).\u0217(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0462, ocd9db3ede422.\u0462, oc6a954e7c9f.\u03f0(0x46C63532 ^ 0x46D23BD6));
        ocac488f55202.\u0104(0.33f, 0.33f, 0.33f, 1.0f).\u0297(1.0f).\u048f(ocd9db3ede422.\u00c8, ocd9db3ede422.\u0151, ocd9db3ede422.\u0462, ocd9db3ede422.\u0462, oc6a954e7c9f.\u03f0(0x46C63532 ^ 0x46D23BD6));
        Object[] objectArray = new Object[0x46D23BD5 ^ 0x46D23BD6];
        objectArray[0] = (int)(oc3004491957.\u0462(this.\u03af.\u0373[0] * oc6a954e7c9f.\u03f0(0x46C6353A ^ 0x46D23BD6)) & (0x414547B81870948CL ^ 0x414547B818709473L));
        objectArray[1] = (int)(oc3004491957.\u0462(this.\u03af.\u0373[1] * oc6a954e7c9f.\u03f0(0x46C6353A ^ 0x46D23BD6)) & (0x414547B81870948CL ^ 0x414547B818709473L));
        objectArray[0x46D23BD4 ^ 0x46D23BD6] = (int)(oc3004491957.\u0462(this.\u03af.\u0373[0x46D23BD4 ^ 0x46D23BD6] * oc6a954e7c9f.\u03f0(0x46C6353A ^ 0x46D23BD6)) & (0x414547B81870948CL ^ 0x414547B818709473L));
        String string2 = String.format(Locale.ROOT, "%02x%02x%02x", objectArray);
        ocac488f55202.\u00ff(L.\u00f2(0x46C634AF ^ 0x46D23BD6) + (this.\u03af.\u0469(this.V) ? this.\u03af.\u02c0.toString() : string2), ocd9db3ede422.\u00c8 + ocd9db3ede422.\u0462 + oc6a954e7c9f.\u03f0(0x46C6354A ^ 0x46D23BD6), ocd9db3ede422.\u0151, this.\u00cf(0x46C6357E ^ 0x46D23BD6), oc6a954e7c9f.\u03f0(0x46C6354E ^ 0x46D23BD6), 0x46D23BDF ^ 0x46D23BD6);
        if (this.\u03af.f(ocd9db3ede422)) {
            this.\u03af.\u00da(this.V, oc98904eb9e7::\u014d);
        }
        if (this.\u03af.\u0469(this.V) && (string = this.\u03af.\u0177()) != null) {
            this.\u03af.\u047c(string);
        }
        for (int i = 0; i < (0x46D23BD5 ^ 0x46D23BD6); ++i) {
            float[][] fArrayArray;
            ocd9db3ede42 ocd9db3ede423 = oce4a4c329712.\u027d(19.0f);
            ocac488f55202.\u00ff(L.\u00f2(i == 0 ? 0x46C63484 ^ 0x46D23BD6 : (i == 1 ? 0x46C63480 ^ 0x46D23BD6 : 0x46C634B7 ^ 0x46D23BD6)), ocd9db3ede423.\u00c8, ocd9db3ede423.\u0151 + 9.0f, this.\u00cf(0x46C63572 ^ 0x46D23BD6), oc6a954e7c9f.\u03f0(0x46C63512 ^ 0x46D23BD6), 0x46D23BDF ^ 0x46D23BD6);
            ocd9db3ede42 ocd9db3ede424 = oce4a4c329712.\u027d(oc6a954e7c9f.\u03f0(0x46C63512 ^ 0x46D23BD6));
            f = 1.0f;
            ocd9db3ede42 ocd9db3ede425 = new ocd9db3ede42(ocd9db3ede424.\u00c8 + f, ocd9db3ede424.\u0151, ocd9db3ede424.\u0423 - 2.0f, ocd9db3ede424.\u0462);
            if (i == 0) {
                int n = (int)oc6a954e7c9f.\u03f0(0x46C634D6 ^ 0x46D23BD6);
                fArrayArray = new float[n + 1][];
                for (int j = 0; j <= n; ++j) {
                    fArrayArray[j] = oc98904eb9e7.\u04c3((float)j / (float)n, this.\u03af.\u015d[1], this.\u03af.\u015d[0x46D23BD4 ^ 0x46D23BD6], 0x46D23B29 ^ 0x46D23BD6);
                }
            } else {
                float[][] fArrayArray2 = new float[0x46D23BD4 ^ 0x46D23BD6][];
                fArrayArray2[0] = oc98904eb9e7.\u04c3(this.\u03af.\u015d[0], i == 1 ? 0.0f : this.\u03af.\u015d[1], i == (0x46D23BD4 ^ 0x46D23BD6) ? 0.0f : this.\u03af.\u015d[0x46D23BD4 ^ 0x46D23BD6], 0x46D23B29 ^ 0x46D23BD6);
                fArrayArray2[1] = oc98904eb9e7.\u04c3(this.\u03af.\u015d[0], i == 1 ? oc6a954e7c9f.\u03f0(0x46C63546 ^ 0x46D23BD6) : this.\u03af.\u015d[1], i == (0x46D23BD4 ^ 0x46D23BD6) ? oc6a954e7c9f.\u03f0(0x46C63546 ^ 0x46D23BD6) : this.\u03af.\u015d[0x46D23BD4 ^ 0x46D23BD6], 0x46D23B29 ^ 0x46D23BD6);
                fArrayArray = fArrayArray2;
            }
            ocac488f55202.\u014e(ocd9db3ede425, 5.0f, fArrayArray);
            ocac488f55202.\u0104(0.2509804f, 0.2509804f, 0.2509804f, 1.0f).\u0297(2.0f).\u048f(ocd9db3ede425.\u00c8, ocd9db3ede425.\u0151, ocd9db3ede425.\u0423, ocd9db3ede425.\u0462, 5.0f);
            float f2 = 10.0f + f;
            float f3 = (ocd9db3ede424.\u0423 - 2.0f * f2) * this.\u03af.\u015d[i] + ocd9db3ede424.\u00c8 + f2;
            float f4 = (float)((double)ocd9db3ede424.\u0462 * oc6a954e7c9f.\u039c(0x46C634EE ^ 0x46D23BD6) + (double)ocd9db3ede424.\u0151);
            float[] fArray = oc6a954e7c9f.M(fArrayArray, this.\u03af.\u015d[i]);
            float[] fArray2 = new float[0x46D23BD5 ^ 0x46D23BD6];
            fArray2[0] = f3;
            fArray2[1] = f4;
            fArray2[0x46D23BD4 ^ 0x46D23BD6] = 10.0f;
            ocac488f55202.\u0104(fArray[0], fArray[1], fArray[0x46D23BD4 ^ 0x46D23BD6], 1.0f).B("circle", fArray2);
            ocac488f55202.\u0104(0.2509804f, 0.2509804f, 0.2509804f, 1.0f).\u0297(2.0f).\u056c(f3, f4, 10.0f);
            this.\u03af.\u03df(ocd9db3ede424, i, f2);
        }
        ocd9db3ede42 ocd9db3ede426 = oce4a4c329712.\u027d(19.0f);
        ocac488f55202.\u00ff(L.\u00f2(0x46C634BD ^ 0x46D23BD6), ocd9db3ede426.\u00c8, ocd9db3ede426.\u0151 + 9.0f, this.\u00cf(0x46C63572 ^ 0x46D23BD6), oc6a954e7c9f.\u03f0(0x46C63512 ^ 0x46D23BD6), 0x46D23BDF ^ 0x46D23BD6);
        ocd9db3ede422 = oce4a4c329712.\u027d(oc6a954e7c9f.\u03f0(0x46C6350E ^ 0x46D23BD6));
        float f5 = ocd9db3ede422.\u00c8;
        float f6 = (ocd9db3ede422.\u0423 + oc6a954e7c9f.\u03f0(0x46C634D2 ^ 0x46D23BD6)) * oc6a954e7c9f.\u03f0(0x46C634DE ^ 0x46D23BD6);
        f = oc6a954e7c9f.\u03f0(0x46C6354A ^ 0x46D23BD6) + f6;
        for (int i = 0x46D23BDE ^ 0x46D23BD6; i > 0; --i) {
            int n = this.\u03af.\u0262 >= i ? this.\u03af.\u0262 - i : this.\u03af.\u0262 + (0x46D23BDE ^ 0x46D23BD6) - i;
            float[] fArray = this.\u03af.G[n];
            ocd9db3ede42 ocd9db3ede427 = new ocd9db3ede42(f5, ocd9db3ede422.\u0151, f6, ocd9db3ede422.\u0462);
            ocac488f55202.\u0104(fArray[0], fArray[1], fArray[0x46D23BD4 ^ 0x46D23BD6], 1.0f).\u0217(ocd9db3ede427.\u00c8, ocd9db3ede427.\u0151, ocd9db3ede427.\u0423, ocd9db3ede427.\u0462, 5.0f);
            boolean bl = this.\u03af.\u0518(ocd9db3ede427);
            float f7 = bl ? 0.55f : 0.33f;
            ocac488f55202.\u0104(f7, f7, f7, 1.0f).\u0297(1.0f).\u048f(ocd9db3ede427.\u00c8, ocd9db3ede427.\u0151, ocd9db3ede427.\u0423, ocd9db3ede427.\u0462, 5.0f);
            if (this.\u03af.f(ocd9db3ede427)) {
                this.\u03af.\u04bd(n);
            }
            f5 += f;
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        int n = Mouse.getEventX();
        int n2 = this.mc.displayHeight - Mouse.getEventY() - 1;
        this.\u03af.\u024e = n;
        this.\u03af.\u04b8 = n2;
        int n3 = Mouse.getEventButton();
        if (n3 >= 0) {
            boolean bl = Mouse.getEventButtonState();
            int n4 = occ573e1fe6c.\u01a1(n3);
            this.\u03af.\u024e(0xC0561961 ^ 0xC0561963, n4, n, n2, 0.0f, bl, new byte[0]);
        } else if (Mouse.getEventDWheel() != 0) {
            this.\u0452(Mouse.getEventDWheel());
        } else {
            this.\u03af.\u024e(1, 0, n, n2, 0.0f, false, new byte[0]);
        }
        super.handleMouseInput();
    }

    void \u0452(int n) {
        this.\u03af.\u024e(0xFF868729 ^ 0xFF86872A, 0, 0, 0, oc08592ac73b.\u03d0(n), false, new byte[0]);
    }

    @Override
    public void handleKeyboardInput() throws IOException {
        int n = Keyboard.getEventKey();
        char c = Keyboard.getEventCharacter();
        boolean bl = Keyboard.getEventKeyState();
        int n2 = occ573e1fe6c.\u0548(n);
        byte[] byArray = Character.toString(c).getBytes(StandardCharsets.UTF_8);
        if (bl) {
            if (!this.\u03af.\u024e(0x828ACF7E ^ 0x828ACF7C, n2, 0, 0, 0.0f, true, byArray) && n == 1) {
                if (this.\u03af.\u0107 != 0) {
                    this.\u03af.\u04b7(true);
                } else {
                    this.mc.displayGuiScreen(null);
                }
            }
        } else {
            this.\u03af.\u024e(0x828ACF7E ^ 0x828ACF7C, n2, 0, 0, 0.0f, false, new byte[0]);
        }
        super.handleKeyboardInput();
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n == 1) {
            if (this.\u03af.\u0107 != 0) {
                this.\u03af.\u04b7(true);
            } else {
                this.mc.displayGuiScreen(null);
            }
        } else {
            super.keyTyped(c, n);
        }
    }
}

