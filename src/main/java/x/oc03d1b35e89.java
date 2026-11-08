/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.util.ResourceLocation;
import x.oc08592ac73b;
import x.oc1e2c36223e;
import x.oc3542cefbeb;
import x.oc6a43806f12;
import x.oc6af36febc3;
import x.ocb69e4fa09a;
import x.ocbd4917c4b1;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public class oc03d1b35e89
extends ocfd4ff6075d {
    private static final String \u0457 = "/assets/idle.miau/textures/gui/close.png";
    private static final float \u0496 = 4.0f;
    private static final int \u04e8 = 7;
    private static final int \u0458 = 6;
    private static final float \u01f3 = 3.0f;
    private static final float \u0243 = 0.56f;
    private static final float \u03a9 = 0.56f;
    private static final float \u00e4 = 11.0f;
    private final oc6af36febc3 \u02e2;
    private final ocb69e4fa09a \u0587 = new ocb69e4fa09a(0xBFCE0918A46764FAL ^ 0xBFCE0918A4676482L);
    private float \u01cf;
    private float \u0278;

    public oc03d1b35e89(oc6af36febc3 oc6af36febc32, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, oc6af36febc32.\u0215(), oc6af36febc32.\u0107());
        this.\u02e2 = oc6af36febc32;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(false);
        this.\u0522(oc1e2c36223e2, this.\u02e2.z$18nrktuqeiysv());
        this.\u026c(oc1e2c36223e2);
        this.\u013c(oc1e2c36223e2);
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        super.z$3dv8qdlj15ex7(n, n2);
        this.\u01cf = n;
        this.\u0278 = n2;
        this.\u0240();
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
        if (n3 == 0 && this.\u0203(n, n2, oc1e2c36223e2)) {
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
        if (n == (0xBD5C1D14 ^ 0xBD5C1D08) || n == (0xBD5C1D94 ^ 0xBD5C1D08)) {
            this.\u00e1();
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
        if (!this.\u042f(this.\u01cf, this.\u0278)) {
            return;
        }
        float f = (float)oc6a43806f12.\u04f9.\u04c1();
        float f2 = oc08592ac73b.\u02b5(n, f);
        if (f2 != 0.0f) {
            this.\u0587.\u024f(-f2);
        }
        this.\u0240();
    }

    @Override
    public void z$19sxbvum8v80h() {
        super.z$19sxbvum8v80h();
        this.\u0426().\u03f1("");
        this.\u0587.\u0234(0.0f);
    }

    @Override
    public float z$2rmsdj781vrn2() {
        int n = this.\u02e2.\u010e().size();
        float f = n == 0 ? 0.0f : 4.0f + (float)Math.min(0xAAA341E5 ^ 0xAAA341E2, n) * 12.0f;
        return 24.0f + f;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u02e2.\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return this.\u02e2.\u0377 != null ? this.\u02e2.\u0377.z$18nrktuqeiysv() : "";
    }

    public boolean \u042f(float f, float f2) {
        return this.\u02e2.\u010e().size() > (0xBE9AEFAD ^ 0xBE9AEFAA) && this.\u0244(f, f2);
    }

    @Override
    public boolean z$2v3bclguk2h6z(int n, int n2) {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        return this.\u0141(n, n2, oc1e2c36223e2) || this.\u0244(n, n2);
    }

    private void \u00e1() {
        String string = this.\u0426().Q();
        if (string == null || string.trim().isEmpty()) {
            return;
        }
        if (this.\u02e2.\u0536(string)) {
            this.\u0426().\u03f1("");
        }
        this.\u0172.\u01e3();
        this.\u0240();
    }

    private void \u013c(oc1e2c36223e oc1e2c36223e2) {
        List<String> list = this.\u02e2.\u010e();
        if (list.isEmpty()) {
            return;
        }
        float f = this.\u0167(oc1e2c36223e2);
        float f2 = this.q(list.size());
        float f3 = this.\u0172.\u02a4.\u0523() - oc1e2c36223e2.\u0124;
        ocbd4917c4b1.\u010e(oc1e2c36223e2.\u043a, f + f3, oc1e2c36223e2.\u0146 - oc1e2c36223e2.\u043a, f2);
        float f4 = this.\u0587.\u021b();
        int n = (int)(f4 / 12.0f);
        int n2 = Math.min(n + (0x4CA9C997 ^ 0x4CA9C990) + 1, list.size());
        for (int i = n; i < n2; ++i) {
            String string = list.get(i);
            float f5 = f - f4 + (float)i * 12.0f;
            int n3 = i % (0x4CA9C992 ^ 0x4CA9C990) == 0 ? 0xB3B3D3BA ^ 0x4CA9C990 : 0xB3B7D7BE ^ 0x4CA9C990;
            this.\u01be(string, oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f5, n3);
        }
        ocbd4917c4b1.\u01df();
    }

    private void \u01be(String string, float f, float f2, float f3, int n) {
        ocbd4917c4b1.\u0109(f, f3, f2, f3 + 12.0f - 1.0f, n);
        oc03d1b35e89.\u00d1(string, f + 4.0f, ocfd4ff6075d.\u039a(f3, 11.0f, 0.56f) + 0.56f, 0xF52BA728 ^ 0xAE76BE4);
        this.\u02b6(f2, f3);
    }

    private boolean \u0203(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        List<String> list = this.\u02e2.\u010e();
        float f = this.\u0587.\u021b();
        for (int i = 0; i < list.size(); ++i) {
            float f2 = this.\u0167(oc1e2c36223e2) - f + (float)i * 12.0f;
            if (!this.\u01fc(n, n2, f2, oc1e2c36223e2.\u0146)) continue;
            this.\u02e2.\u012d(list.get(i));
            this.\u0172.\u01e3();
            this.\u0240();
            return true;
        }
        return false;
    }

    private void \u0240() {
        int n = this.\u02e2.\u010e().size();
        float f = Math.max(0.0f, (float)(n - (0xAC3E458B ^ 0xAC3E458C)) * 12.0f);
        this.\u0587.\u057f(0.0f, f);
        if (this.\u0587.\u021b() > f) {
            this.\u0587.\u0234(f);
        }
    }

    private boolean \u0244(float f, float f2) {
        List<String> list = this.\u02e2.\u010e();
        if (list.isEmpty()) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        float f3 = this.\u0167(oc1e2c36223e2);
        float f4 = this.q(list.size());
        return f >= oc1e2c36223e2.\u043a && f <= oc1e2c36223e2.\u0146 && f2 >= f3 && f2 < f3 + f4;
    }

    private float \u0167(oc1e2c36223e oc1e2c36223e2) {
        return oc1e2c36223e2.N + 4.0f;
    }

    private float q(int n) {
        return (float)Math.min(0x8C0858D1 ^ 0x8C0858D6, n) * 12.0f;
    }

    private void \u02b6(float f, float f2) {
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/close.png");
        if (resourceLocation == null) {
            return;
        }
        float f3 = f - 6.0f - 3.0f;
        float f4 = f2 + 2.5f;
        int n = oc3542cefbeb.\u0189(oc3542cefbeb.\u039d[0], oc3542cefbeb.\u039d[1], 0.0);
        ocbd4917c4b1.\u00ec(resourceLocation, f3, f4, 0xCC09DB9D ^ 0xCC09DB9B, n);
    }

    private boolean \u01fc(float f, float f2, float f3, float f4) {
        float f5 = f4 - 6.0f - 3.0f;
        float f6 = f3 + 2.5f;
        return f >= f5 && f <= f5 + 6.0f && f2 >= f6 && f2 <= f6 + 6.0f;
    }

    private static void \u00d1(String string, float f, float f2, int n) {
        ocfd4ff6075d.\u018e(string, f, f2, n, 0.56f);
    }
}

