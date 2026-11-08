/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc068de8cabb;
import x.oc08592ac73b;
import x.oc0c3f0511db;
import x.oc15e51da9b2;
import x.oc2930c3d5f7;
import x.oc2cf3d80e17;
import x.oc38495530cc;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc7af2e0512e;
import x.oc80438d6cc7;
import x.oc84fe78a972;
import x.oc8aaacef5d6;
import x.oc9755810e45;
import x.ocaba452434e;
import x.ocb37f88aec5;
import x.occ99cc6cd9f;
import x.ocd22c3031a1;
import x.oce4cea752dd;

public class oc1cb76bf763
extends GuiScreen {
    private final oc8aaacef5d6 \u0526 = new oc8aaacef5d6();
    private final List<oc7af2e0512e> \u047d = new ArrayList<oc7af2e0512e>();
    private final Map<oc69da1aa7f5, oc84fe78a972> \u0237 = new IdentityHashMap<oc69da1aa7f5, oc84fe78a972>();
    private final oc0c3f0511db \u03c8 = new oc0c3f0511db(this);
    private final ocb37f88aec5 \u040a = new ocb37f88aec5(this);
    private final occ99cc6cd9f \u020f = new occ99cc6cd9f(0x63329B8DD8827BDEL ^ 0x63329B8DD8827B6AL, ocaba452434e.\u04ee);
    private final occ99cc6cd9f \u0202 = new occ99cc6cd9f(0x63329B8DD8827BB6L ^ 0x63329B8DD8827B6AL, ocaba452434e.\u0144);
    private final Map<oc068de8cabb, oc15e51da9b2> \u049d = new EnumMap<oc068de8cabb, oc15e51da9b2>(oc068de8cabb.class);
    private oc068de8cabb \u02a0 = oc068de8cabb.\u0504;
    private oc4f21845252 \u0542;
    private oc84fe78a972 \u0280;
    private float \u01fa = 1.0f;
    private float \u00da;
    private boolean \u012e;
    private boolean \u045a;

    public oc1cb76bf763() {
        oc068de8cabb[] objectArray = oc068de8cabb.values();
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            oc068de8cabb oc068de8cabb2 = objectArray[i];
            this.\u049d.put(oc068de8cabb2, new oc15e51da9b2());
        }
        this.\u057b();
        String[] stringArray = new String[0x73203F1B ^ 0x73203F1D];
        stringArray[0] = "\ue9e0";
        stringArray[1] = "\ue566";
        stringArray[0x73203F1F ^ 0x73203F1D] = "\ue7fd";
        stringArray[0x73203F1E ^ 0x73203F1D] = "\ue8f4";
        stringArray[0x73203F19 ^ 0x73203F1D] = "\ue30f";
        stringArray[0x73203F18 ^ 0x73203F1D] = "\ue5d3";
        String[] stringArray2 = stringArray;
        for (n = 0; n < oc80438d6cc7.\u050a().size(); ++n) {
            this.\u047d.add(new oc7af2e0512e(this, oc80438d6cc7.\u0537(oc80438d6cc7.\u050a().get(n)), stringArray2[n], n));
        }
    }

    @Override
    public void initGui() {
        this.\u01fa = oc1cb76bf763.o(this.width, oc6a43806f12.\u021d());
        this.\u01bf();
        this.\u0280 = null;
        this.\u012e = false;
        this.\u057b();
        this.\u0517();
        this.\u047d.forEach(oc7af2e0512e2 -> {
            oc7af2e0512e2.\u0163.\u020e(0.0f);
            oc7af2e0512e2.\u0163.\u0540(1.0f);
        });
        this.\u020f.\u020e(0.0f);
        this.\u020f.\u0540(1.0f);
        this.\u0512();
        Keyboard.enableRepeatEvents(true);
    }

    public void \u040b() {
        this.\u0517();
        this.\u040a.\u01a0();
    }

    public void \u03ca() {
        this.\u0517();
        this.\u03c8.\u04d2();
    }

    private void \u0517() {
        if (oc2cf3d80e17.\u013c == null) {
            return;
        }
        ArrayList<oc69da1aa7f5> arrayList = new ArrayList<oc69da1aa7f5>(oc2cf3d80e17.\u013c.\u057f());
        if (oc2cf3d80e17.\u00c1 != null) {
            oc2cf3d80e17.\u00c1.\u01f9.forEach(oc151419fdfe2 -> arrayList.add(oc151419fdfe2.\u01da()));
        }
        this.\u0237.entrySet().removeIf(entry -> {
            if (arrayList.contains(entry.getKey())) {
                return false;
            }
            ((oc84fe78a972)entry.getValue()).q.\u02a2();
            if (this.\u0280 == entry.getValue()) {
                this.\u0280 = null;
            }
            return true;
        });
        this.\u047d.forEach(oc7af2e0512e2 -> oc7af2e0512e2.\u039b.clear());
        for (oce4cea752dd oce4cea752dd2 : oc80438d6cc7.\u050a()) {
            oc7af2e0512e oc7af2e0512e3 = this.\u047d.get(oc1cb76bf763.\u021b(oce4cea752dd2));
            for (oc69da1aa7f5 oc69da1aa7f52 : oc80438d6cc7.\u0128(oce4cea752dd2)) {
                oc7af2e0512e3.\u039b.add(this.\u0465(oc69da1aa7f52));
            }
        }
    }

    static int \u021b(oce4cea752dd oce4cea752dd2) {
        return oc80438d6cc7.\u050a().indexOf((Object)oce4cea752dd2);
    }

    static float o(int n, float f) {
        return Math.max(0.1f, Math.min(f, (float)(n - (0x8766F8BE ^ 0x8766F8AA)) / oc2930c3d5f7.\u03df));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        this.\u01fa = oc1cb76bf763.o(this.width, oc6a43806f12.\u021d());
        float f2 = (float)this.width / this.\u01fa;
        this.\u00da = (float)this.height / this.\u01fa;
        float f3 = this.\u012e ? -1.0f : (float)n / this.\u01fa;
        float f4 = this.\u012e ? -1.0f : (float)n2 / this.\u01fa;
        this.\u045a = Keyboard.isKeyDown(0x6D4C1855 ^ 0x6D4C185A);
        this.\u0526.\u0508(f2, this.\u00da);
        try {
            oc068de8cabb[] object = oc068de8cabb.values();
            n3 = object.length;
            for (int i = 0; i < n3; ++i) {
                oc068de8cabb oc068de8cabb2 = object[i];
                if (oc068de8cabb2 == this.\u02a0) continue;
                this.\u029f(oc068de8cabb2, f2, -1.0f, -1.0f);
            }
            this.\u029f(this.\u02a0, f2, f3, f4);
            this.\u0194(f2, f3, f4);
        }
        finally {
            this.\u0526.\u0509();
        }
        oc7af2e0512e oc7af2e0512e2 = this.\u047d.get(this.\u047d.size() - 1);
        int n4 = this.\u02a0 == oc068de8cabb.\u0504 ? (oc7af2e0512e2.\u0163.\u01ef() && oc7af2e0512e2.\u0163.\u047f() == 0.0f ? 1 : 0) : (n3 = this.\u020f.\u01ef() && this.\u020f.\u047f() == 0.0f ? 1 : 0);
        if (this.\u012e && n3 != 0) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
    }

    private void \u029f(oc068de8cabb oc068de8cabb2, float f, float f2, float f3) {
        oc15e51da9b2 oc15e51da9b22 = this.\u049d.get((Object)oc068de8cabb2);
        float f4 = oc15e51da9b22.\u053b.\u047f();
        if (f4 <= 0.001f) {
            return;
        }
        float f5 = oc15e51da9b22.\u02ad.\u047f();
        this.\u0526.\u04f1(f5, 0.0f, f4, () -> {
            if (oc068de8cabb2 == oc068de8cabb.\u0504) {
                float f5 = oc2930c3d5f7.\u0516(f);
                for (int i = 0; i < this.\u047d.size(); ++i) {
                    oc7af2e0512e oc7af2e0512e2 = this.\u047d.get(i);
                    oc7af2e0512e2.\u0446 = f5 + (float)i * 120.0f;
                    oc7af2e0512e2.\u021e(f2 < 0.0f ? -1.0f : f2 - f5, f3);
                }
            } else {
                this.\u0526.\u0459(this.\u020f.\u0540(this.\u012e ? 0.0f : 1.0f));
                this.\u04bc(oc068de8cabb2).H(this.\u0526, f2 < 0.0f ? -1.0f : f2 - f5, f3, f, this.\u00da);
                this.\u0526.\u0459(1.0f);
            }
        });
    }

    private void \u057b() {
        for (oc068de8cabb oc068de8cabb2 : oc068de8cabb.values()) {
            oc15e51da9b2 oc15e51da9b22 = this.\u049d.get((Object)oc068de8cabb2);
            oc15e51da9b22.\u053b.\u020e(oc068de8cabb2 == this.\u02a0 ? 1.0f : 0.0f);
            oc15e51da9b22.\u02ad.\u020e(0.0f);
        }
        this.\u0202.\u020e(this.\u02a0.ordinal());
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        Object object;
        if (this.\u012e) {
            return;
        }
        if (this.\u0280 != null) {
            this.\u0540((0x80CCE65E ^ 0x80CCE5B6) + n3);
            return;
        }
        if (this.\u0542 instanceof ocd22c3031a1) {
            this.\u0542.z$16m0yo633oydp('\u0000', (0x80CCE65E ^ 0x80CCE5B6) + n3);
            return;
        }
        this.\u01bf();
        float f = (float)n / this.\u01fa;
        float f2 = (float)n2 / this.\u01fa;
        if (n3 == 0 && (object = oc1cb76bf763.\u04c3((float)this.width / this.\u01fa, f, f2)) != null) {
            this.\u03a0((oc068de8cabb)((Object)object));
            return;
        }
        object = this.\u049d.get((Object)this.\u02a0);
        if (object.\u053b.\u047f() <= 0.1f) {
            return;
        }
        f -= object.\u02ad.\u047f();
        if (this.\u02a0 != oc068de8cabb.\u0504) {
            this.\u0535().z$10zmr5yjmvvef(f, f2, n3);
            return;
        }
        for (oc7af2e0512e oc7af2e0512e2 : this.\u047d) {
            if (!oc7af2e0512e2.\u04f0(f, f2)) continue;
            oc7af2e0512e2.\u0135(f, f2, n3);
            return;
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        if (n3 == 0) {
            this.\u0237.values().forEach(oc84fe78a9722 -> oc84fe78a9722.q.s());
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n == 0 || this.\u012e) {
            return;
        }
        if (this.\u0280 != null) {
            this.\u0540(n > 0 ? 0xE3B54E02 ^ 0xE3B54A2F : 0xE3B54E01 ^ 0xE3B54A2F);
            return;
        }
        float f = (float)oc08592ac73b.\u0546(Mouse.getEventX(), this.mc.displayWidth, this.width) / this.\u01fa;
        float f2 = (float)oc08592ac73b.\u0493(Mouse.getEventY(), this.mc.displayHeight, this.height) / this.\u01fa;
        this.\u044f(f, f2, oc08592ac73b.\u03d0(n));
    }

    void \u044f(float f, float f2, float f3) {
        oc15e51da9b2 oc15e51da9b22 = this.\u049d.get((Object)this.\u02a0);
        if (oc15e51da9b22.\u053b.\u047f() <= 0.1f) {
            return;
        }
        f -= oc15e51da9b22.\u02ad.\u047f();
        if (this.\u02a0 != oc068de8cabb.\u0504) {
            this.\u0535().z$1zwd02zrw5ico(f, f2, f3);
            return;
        }
        for (oc7af2e0512e oc7af2e0512e2 : this.\u047d) {
            if (!oc7af2e0512e2.\u04f0(f, f2)) continue;
            oc7af2e0512e2.\u0159 = Math.max(-oc7af2e0512e2.\u027c(), Math.min(0.0f, oc7af2e0512e2.\u0159 + f3 * 50.0f));
            oc7af2e0512e2.\u00c4.\u0540(oc7af2e0512e2.\u0159);
            return;
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        oc69da1aa7f5 oc69da1aa7f52;
        if (this.\u012e) {
            return;
        }
        if (this.\u0280 != null) {
            this.\u0540(n == 1 || n == (0x90793C35 ^ 0x90793CE6) ? 0 : n);
            return;
        }
        if (this.\u0542 != null && this.\u0542.z$16m0yo633oydp(c, n)) {
            return;
        }
        oc69da1aa7f5 oc69da1aa7f53 = oc69da1aa7f52 = oc2cf3d80e17.\u013c == null ? null : oc9755810e45.\u02ac(oc6a43806f12.class);
        if (n == 1 || oc69da1aa7f52 != null && n == oc69da1aa7f52.\u027d()) {
            this.\u040e();
        }
    }

    void \u040e() {
        this.\u01bf();
        this.\u012e = true;
        this.\u0237.values().forEach(oc84fe78a9722 -> oc84fe78a9722.q.\u02a2());
        this.\u047d.forEach(oc7af2e0512e2 -> oc7af2e0512e2.\u0163.\u0540(0.0f));
        this.\u020f.\u0540(0.0f);
    }

    @Override
    public void updateScreen() {
        if (this.mc.thePlayer == null || this.mc.theWorld == null || this.mc.gameSettings == null) {
            return;
        }
        boolean bl = !this.\u012e && !this.\u0402() && oc6a43806f12.\u02a5 != null && oc6a43806f12.\u02a5.\u01ed();
        for (KeyBinding keyBinding : this.\u01ec()) {
            int n = keyBinding.getKeyCode();
            boolean bl2 = bl && (n > 0 && n < (0x3A47CC5 ^ 0x3A47DC5) ? Keyboard.isKeyDown(n) : n < 0 && n + (0x3A47DA1 ^ 0x3A47DC5) >= 0 && Mouse.isButtonDown(n + (0x3A47DA1 ^ 0x3A47DC5)));
            KeyBinding.setKeyBindState(n, bl2);
        }
    }

    private KeyBinding[] \u01ec() {
        KeyBinding[] keyBindingArray = new KeyBinding[0xF1E8947 ^ 0xF1E8941];
        keyBindingArray[0] = this.mc.gameSettings.keyBindForward;
        keyBindingArray[1] = this.mc.gameSettings.keyBindBack;
        keyBindingArray[0xF1E8943 ^ 0xF1E8941] = this.mc.gameSettings.keyBindLeft;
        keyBindingArray[0xF1E8942 ^ 0xF1E8941] = this.mc.gameSettings.keyBindRight;
        keyBindingArray[0xF1E8945 ^ 0xF1E8941] = this.mc.gameSettings.keyBindJump;
        keyBindingArray[0xF1E8944 ^ 0xF1E8941] = this.mc.gameSettings.keyBindSprint;
        return keyBindingArray;
    }

    @Override
    public void onGuiClosed() {
        this.\u01bf();
        this.\u0280 = null;
        this.\u0237.values().forEach(oc84fe78a9722 -> oc84fe78a9722.q.\u02a2());
        Keyboard.enableRepeatEvents(false);
        KeyBinding.unPressAllKeys();
        this.\u03c8.z$3mqeupmq4p81d();
        this.\u040a.z$3mqeupmq4p81d();
        this.\u0526.A();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public double \u04d5() {
        return this.\u01fa;
    }

    public boolean \u0402() {
        return this.\u0542 != null || this.\u0280 != null;
    }

    public boolean \u042b() {
        return !this.\u012e && !this.\u0402() && oc6a43806f12.\u02a5 != null && oc6a43806f12.\u02a5.\u01ed();
    }

    void \u04a6(oc4f21845252 oc4f218452522) {
        this.\u01bf();
        this.\u0542 = oc4f218452522;
    }

    boolean \u04d1(oc4f21845252 oc4f218452522) {
        return this.\u0542 == oc4f218452522;
    }

    void \u04b7(oc4f21845252 oc4f218452522) {
        if (this.\u0542 == oc4f218452522) {
            this.\u0542 = null;
        }
    }

    private void \u01bf() {
        oc4f21845252 oc4f218452522 = this.\u0542;
        this.\u0542 = null;
        if (oc4f218452522 != null) {
            oc4f218452522.z$21n2hyuutt37u();
        }
    }

    private void \u0540(int n) {
        this.\u0280.\u026e.\u04dd(n);
        this.\u0280 = null;
        oc2cf3d80e17.\u04eb();
    }

    static String Q(int n) {
        if (n == 0) {
            return "None";
        }
        if (n == (0x4F12EDC1 ^ 0x4F12E9EC)) {
            return "Wheel Up";
        }
        if (n == (0x4F12EDC2 ^ 0x4F12E9EC)) {
            return "Wheel Down";
        }
        if (n >= (0x4F12EA04 ^ 0x4F12E9EC)) {
            return "Mouse " + (n - (0x4F12EA0B ^ 0x4F12E9EC));
        }
        String string = Keyboard.getKeyName(n);
        return string == null ? "None" : string;
    }

    oc84fe78a972 \u0465(oc69da1aa7f5 oc69da1aa7f53) {
        return this.\u0237.computeIfAbsent(oc69da1aa7f53, oc69da1aa7f52 -> new oc84fe78a972((oc69da1aa7f5)oc69da1aa7f52, this, this.\u0526));
    }

    void \u0464(oc84fe78a972 oc84fe78a9722) {
        this.\u01bf();
        this.\u0280 = oc84fe78a9722;
    }

    boolean \u040e(oc84fe78a972 oc84fe78a9722) {
        return this.\u0280 == oc84fe78a9722;
    }

    boolean \u04d7() {
        return this.\u045a;
    }

    oc068de8cabb \u010a() {
        return this.\u02a0;
    }

    void \u03a0(oc068de8cabb oc068de8cabb2) {
        if (oc068de8cabb2 == this.\u02a0) {
            return;
        }
        this.\u01bf();
        this.\u0280 = null;
        this.\u0237.values().forEach(oc84fe78a9722 -> oc84fe78a9722.q.\u02a2());
        this.\u03c8.z$3mqeupmq4p81d();
        this.\u040a.z$3mqeupmq4p81d();
        int n = Integer.compare(oc068de8cabb2.ordinal(), this.\u02a0.ordinal());
        for (oc068de8cabb oc068de8cabb3 : oc068de8cabb.values()) {
            oc15e51da9b2 oc15e51da9b22 = this.\u049d.get((Object)oc068de8cabb3);
            if (oc068de8cabb3 == oc068de8cabb2) {
                if (oc15e51da9b22.\u053b.\u047f() <= 0.001f) {
                    oc15e51da9b22.\u02ad.\u020e(n * (0x5534F220 ^ 0x5534F232));
                }
                oc15e51da9b22.\u053b.\u0540(1.0f);
                oc15e51da9b22.\u02ad.\u0540(0.0f);
                continue;
            }
            oc15e51da9b22.\u053b.\u0540(0.0f);
            oc15e51da9b22.\u02ad.\u0540(-n * (0x5534F220 ^ 0x5534F232));
        }
        this.\u02a0 = oc068de8cabb2;
        this.\u0202.\u0540(oc068de8cabb2.ordinal());
        this.\u0512();
    }

    private void \u0512() {
        if (this.\u02a0 == oc068de8cabb.\u0226) {
            this.\u03c8.z$ohfkdtvsjxqf();
        }
        if (this.\u02a0 == oc068de8cabb.\u0535) {
            if (oc2cf3d80e17.\u013e != null && oc2cf3d80e17.\u013e.scripts.isEmpty()) {
                oc2cf3d80e17.\u013e.loadScripts();
            }
            this.\u040a.z$ohfkdtvsjxqf();
        }
    }

    private oc38495530cc \u0535() {
        return this.\u04bc(this.\u02a0);
    }

    private oc38495530cc \u04bc(oc068de8cabb oc068de8cabb2) {
        return oc068de8cabb2 == oc068de8cabb.\u0226 ? this.\u03c8 : this.\u040a;
    }

    private void \u0194(float f, float f2, float f3) {
        float f4 = oc2930c3d5f7.\u02a0(f);
        float f5 = this.\u012e ? (this.\u02a0 == oc068de8cabb.\u0504 ? this.\u047d.get((int)0).\u0163.\u047f() : this.\u020f.\u047f()) : 1.0f;
        this.\u0526.\u0459(f5);
        this.\u0526.\u0454(f4, 8.0f, 276.0f, 24.0f, 5.0f, 5.0f);
        this.\u0526.\u027e(f4, 8.0f, 276.0f, 24.0f, 5.0f, 0xA4353C7 ^ 0xD34C5CC8);
        float f6 = f4 + this.\u0202.\u047f() * 92.0f;
        this.\u0526.\u0419(f6 + 2.0f, 10.0f, 88.0f, 20.0f, 4.0f, 4.0f, oc8aaacef5d6.\u0161(oc8aaacef5d6.\u012d(), 0.4f), oc8aaacef5d6.\u0161(oc8aaacef5d6.\u0173(), 0.4f), false);
        for (oc068de8cabb oc068de8cabb2 : oc068de8cabb.values()) {
            float f7 = f4 + (float)oc068de8cabb2.ordinal() * 92.0f;
            boolean bl = this.\u02a0 == oc068de8cabb2;
            boolean bl2 = oc4f21845252.\u0392(f2, f3, f7, 8.0f, 92.0f, 24.0f);
            if (!bl && bl2) {
                this.\u0526.\u027e(f7 + 2.0f, 10.0f, 88.0f, 20.0f, 4.0f, 0xF3B3A337 ^ 0xD34C5CC8);
            }
            String string = bl ? "productsans-bold" : "productsans-medium";
            int n = bl ? -1 : 0x2CE6F662 ^ 0xD34C5CC8;
            this.\u0526.\u0456("materialicons-outlined", oc068de8cabb2.\u04e1, f7 + 12.0f, 24.0f, 10.0f, n);
            this.\u0526.\u0456(string, oc068de8cabb2.\u0174, f7 + 28.0f, 23.0f, 9.0f, n);
        }
        this.\u0526.\u0459(1.0f);
    }

    static oc068de8cabb \u04c3(float f, float f2, float f3) {
        float f4 = oc2930c3d5f7.\u02a0(f);
        if (!oc4f21845252.\u0392(f2, f3, f4, 8.0f, 276.0f, 24.0f)) {
            return null;
        }
        return oc068de8cabb.values()[(int)((f2 - f4) / 92.0f)];
    }
}

