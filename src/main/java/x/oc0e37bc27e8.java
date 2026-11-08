/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc08592ac73b;
import x.oc11bafa49c6;
import x.oc1e2c36223e;
import x.oc1e36b6c903;
import x.oc3542cefbeb;
import x.oc6a43806f12;
import x.ocb69e4fa09a;
import x.ocbd4917c4b1;
import x.oce1bd2fa256;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public class oc0e37bc27e8
extends ocfd4ff6075d {
    private static final String \u021f = "/assets/idle.miau/textures/gui/close.png";
    private static final float \u03f2 = 4.0f;
    private static final int J = 7;
    private static final int \u0401 = 6;
    private static final float \u022c = 3.0f;
    private static final float \u03d2 = 8.0f;
    private static final float \u017c = 0.56f;
    private static final float \u01d8 = 0.56f;
    private static final float \u04be = 11.0f;
    private final oce1bd2fa256 \u016b;
    private final ocb69e4fa09a \u03d8 = new ocb69e4fa09a(0xC230C29713A3C308L ^ 0xC230C29713A3C370L);
    private float \u048d;
    private float \u0291;

    public oc0e37bc27e8(oce1bd2fa256 oce1bd2fa2562, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, oce1bd2fa2562.\u01fa(), oce1bd2fa2562.\u028d());
        this.\u016b = oce1bd2fa2562;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(false);
        this.\u0522(oc1e2c36223e2, this.\u016b.z$18nrktuqeiysv());
        this.\u026c(oc1e2c36223e2);
        this.\u0261(oc1e2c36223e2);
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        super.z$3dv8qdlj15ex7(n, n2);
        this.\u048d = n;
        this.\u0291 = n2;
        this.\u0539();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this)) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        if (n3 == 0 && this.\u0141(n, n2, oc1e2c36223e2)) {
            this.\u039a(true);
            return true;
        }
        if (n3 == 0 && this.\u00d2(n, n2, oc1e2c36223e2)) {
            return true;
        }
        if (this.\u0503()) {
            this.\u0426().\u03f1("");
            this.\u039a(false);
        }
        return false;
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        if (!this.\u0172.\u0224 || !this.\u0503()) {
            return;
        }
        if (n == 1) {
            this.\u0426().\u03f1("");
            this.\u039a(false);
            return;
        }
        if (n == (0x34A3A4E2 ^ 0x34A3A4FE) || n == (0x34A3A462 ^ 0x34A3A4FE)) {
            this.\u02ac();
            this.\u039a(false);
            return;
        }
        this.\u0426().\u04e7(c, n);
    }

    @Override
    public void z$vm4dmbdypoel(int n) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this)) {
            return;
        }
        if (!this.\u0508(this.\u048d, this.\u0291)) {
            return;
        }
        float f = (float)oc6a43806f12.\u04f9.\u04c1();
        float f2 = oc08592ac73b.\u02b5(n, f);
        if (f2 != 0.0f) {
            this.\u03d8.\u024f(-f2);
        }
        this.\u0539();
    }

    @Override
    public void z$19sxbvum8v80h() {
        super.z$19sxbvum8v80h();
        this.\u0426().\u03f1("");
        this.\u03d8.\u0234(0.0f);
    }

    @Override
    public float z$2rmsdj781vrn2() {
        int n = this.\u016b.\u01b8().size();
        float f = n == 0 ? 0.0f : 4.0f + (float)Math.min(0x21D73DEE ^ 0x21D73DE9, n) * 12.0f;
        return 24.0f + f;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u016b.\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return this.\u016b.\u01f3 != null ? this.\u016b.\u01f3.z$18nrktuqeiysv() : "";
    }

    public boolean \u0508(float f, float f2) {
        return this.\u016b.\u01b8().size() > (0xABF7A9B1 ^ 0xABF7A9B6) && this.\u0432(f, f2);
    }

    @Override
    public boolean z$2v3bclguk2h6z(int n, int n2) {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        return this.\u0141(n, n2, oc1e2c36223e2) || this.\u0432(n, n2);
    }

    public void \u0388() {
        this.\u0539();
    }

    private void \u02ac() {
        String string = this.\u0426().Q();
        if (string == null || string.trim().isEmpty()) {
            return;
        }
        if (this.\u016b.\u044c(string)) {
            this.\u0426().\u03f1("");
        }
        this.\u0172.\u01e3();
        this.\u0539();
    }

    private void \u0261(oc1e2c36223e oc1e2c36223e2) {
        List<oc1e36b6c903> list = this.\u016b.\u01b8();
        if (list.isEmpty()) {
            return;
        }
        float f = this.\u045e(oc1e2c36223e2);
        float f2 = this.\u0225(list.size());
        float f3 = this.\u0172.\u02a4.\u0523() - oc1e2c36223e2.\u0124;
        ocbd4917c4b1.\u010e(oc1e2c36223e2.\u043a, f + f3, oc1e2c36223e2.\u0146 - oc1e2c36223e2.\u043a, f2);
        float f4 = this.\u03d8.\u021b();
        int n = (int)(f4 / 12.0f);
        int n2 = Math.min(n + (0xE25BDD58 ^ 0xE25BDD5F) + 1, list.size());
        Map<String, NetworkPlayerInfo> map = this.\u0451();
        for (int i = n; i < n2; ++i) {
            oc1e36b6c903 oc1e36b6c9032 = list.get(i);
            float f5 = f - f4 + (float)i * 12.0f;
            int n3 = i % (0xE25BDD5D ^ 0xE25BDD5F) == 0 ? 0x1D41C775 ^ 0xE25BDD5F : 0x1D45C371 ^ 0xE25BDD5F;
            this.\u022c(oc1e36b6c9032, map.get(oc1e36b6c9032.\u0479()), oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f5, n3);
        }
        ocbd4917c4b1.\u01df();
    }

    private void \u022c(oc1e36b6c903 oc1e36b6c9032, NetworkPlayerInfo networkPlayerInfo, float f, float f2, float f3, int n) {
        ocbd4917c4b1.\u0109(f, f3, f2, f3 + 12.0f - 1.0f, n);
        this.\u0406(oc1e36b6c9032, networkPlayerInfo, f + 2.0f, f3 + 1.5f);
        oc0e37bc27e8.\u04fd(oc1e36b6c9032.\u0273(), f + 13.0f, ocfd4ff6075d.\u039a(f3, 11.0f, 0.56f) + 0.56f, 0x5192FCF0 ^ 0xAE5E303C);
        this.\u0203(f2, f3);
    }

    private boolean \u00d2(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        List<oc1e36b6c903> list = this.\u016b.\u01b8();
        float f = this.\u03d8.\u021b();
        for (int i = 0; i < list.size(); ++i) {
            float f2 = this.\u045e(oc1e2c36223e2) - f + (float)i * 12.0f;
            if (!this.\u0176(n, n2, f2, oc1e2c36223e2.\u0146)) continue;
            this.\u016b.\u056c(list.get(i).\u0479());
            this.\u0172.\u01e3();
            this.\u0539();
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void \u0406(oc1e36b6c903 oc1e36b6c9032, NetworkPlayerInfo networkPlayerInfo, float f, float f2) {
        ResourceLocation resourceLocation = this.\u0562(oc1e36b6c9032, networkPlayerInfo);
        if (resourceLocation == null) {
            return;
        }
        boolean bl = GL11.glIsEnabled(0x118F3EB1 ^ 0x118F35C0);
        boolean bl2 = GL11.glIsEnabled(0x118F3E22 ^ 0x118F35C0);
        boolean bl3 = GL11.glGetBoolean(0x118F3EB2 ^ 0x118F35C0);
        try {
            ocbd4917c4b1.\u0510();
            Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Gui.drawScaledCustomSizeModalRect((int)f, (int)f2, 8.0f, 8.0f, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 64.0f, 64.0f);
            Gui.drawScaledCustomSizeModalRect((int)f, (int)f2, 40.0f, 8.0f, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 0x118F35C8 ^ 0x118F35C0, 64.0f, 64.0f);
        }
        finally {
            ocbd4917c4b1.\u04fe(bl, bl2, bl3);
        }
    }

    private ResourceLocation \u0562(oc1e36b6c903 oc1e36b6c9032, NetworkPlayerInfo networkPlayerInfo) {
        return oc11bafa49c6.\u0553(oc1e36b6c9032.\u0273(), networkPlayerInfo);
    }

    private Map<String, NetworkPlayerInfo> \u0451() {
        HashMap<String, NetworkPlayerInfo> hashMap = new HashMap<String, NetworkPlayerInfo>();
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.getNetHandler() == null) {
            return hashMap;
        }
        for (NetworkPlayerInfo networkPlayerInfo : minecraft.getNetHandler().getPlayerInfoMap()) {
            GameProfile gameProfile;
            if (networkPlayerInfo == null || (gameProfile = networkPlayerInfo.getGameProfile()) == null || gameProfile.getName() == null) continue;
            hashMap.put(gameProfile.getName().toLowerCase(), networkPlayerInfo);
        }
        return hashMap;
    }

    private void \u0539() {
        int n = this.\u016b.\u01b8().size();
        float f = Math.max(0.0f, (float)(n - (0x8151E0F7 ^ 0x8151E0F0)) * 12.0f);
        this.\u03d8.\u057f(0.0f, f);
        if (this.\u03d8.\u021b() > f) {
            this.\u03d8.\u0234(f);
        }
    }

    private boolean \u0432(float f, float f2) {
        List<oc1e36b6c903> list = this.\u016b.\u01b8();
        if (list.isEmpty()) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        float f3 = this.\u045e(oc1e2c36223e2);
        float f4 = this.\u0225(list.size());
        return f >= oc1e2c36223e2.\u043a && f <= oc1e2c36223e2.\u0146 && f2 >= f3 && f2 < f3 + f4;
    }

    private float \u045e(oc1e2c36223e oc1e2c36223e2) {
        return oc1e2c36223e2.N + 4.0f;
    }

    private float \u0225(int n) {
        return (float)Math.min(0xD145E27 ^ 0xD145E20, n) * 12.0f;
    }

    private void \u0203(float f, float f2) {
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/close.png");
        if (resourceLocation == null) {
            return;
        }
        float f3 = f - 6.0f - 3.0f;
        float f4 = f2 + 2.5f;
        int n = oc3542cefbeb.\u0189(oc3542cefbeb.\u039d[0], oc3542cefbeb.\u039d[1], 0.0);
        ocbd4917c4b1.\u00ec(resourceLocation, f3, f4, 0x6674F636 ^ 0x6674F630, n);
    }

    private boolean \u0176(float f, float f2, float f3, float f4) {
        float f5 = f4 - 6.0f - 3.0f;
        float f6 = f3 + 2.5f;
        return f >= f5 && f <= f5 + 6.0f && f2 >= f6 && f2 <= f6 + 6.0f;
    }

    private static void \u04fd(String string, float f, float f2, int n) {
        ocfd4ff6075d.\u018e(string, f, f2, n, 0.56f);
    }
}

