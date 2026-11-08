/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import x.oc08592ac73b;
import x.oc1e2c36223e;
import x.oc2cf3d80e17;
import x.oc3542cefbeb;
import x.oc5f2027353d;
import x.oc6a43806f12;
import x.ocb69e4fa09a;
import x.ocbd4917c4b1;
import x.ocdd11f3c425;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public abstract class oc81019d75fb
extends ocfd4ff6075d {
    private static final String \u04f7 = "/assets/idle.miau/textures/gui/close.png";
    private static final String \u0469 = "/assets/idle.miau/textures/gui/arrow_left.png";
    protected static final float \u01f4 = 250.0f;
    protected static final int \u0104 = 7;
    protected static final int U = 7;
    protected static final int \u01bf = 6;
    protected static final float \u0427 = 3.0f;
    protected static final float \u0480 = 4.0f;
    protected static final float \u0443 = 0.56f;
    protected static final float \u0194 = 0.56f;
    protected static final float \u011b = 11.0f;
    protected final ocb69e4fa09a \u04c8 = new ocb69e4fa09a(0xEE334FF2BED780DFL ^ 0xEE334FF2BED780A7L);
    protected final ocb69e4fa09a \u017c = new ocb69e4fa09a(0xEE334FF2BED780DFL ^ 0xEE334FF2BED780A7L);
    protected float \u0435;
    protected float \u04f2;
    private oc5f2027353d j;
    private float \u01f0;
    private float \u04f8;
    private float \u04cb;

    protected oc81019d75fb(ocebe35f25d6 ocebe35f25d62, float f, String string) {
        super(ocebe35f25d62, f, string, 0xC1C4A699 ^ 0xC1C4A619);
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(false);
        this.\u0522(oc1e2c36223e2, this.z$37vljf1p4xmma());
        this.\u026c(oc1e2c36223e2);
        this.\u0586(oc1e2c36223e2);
        this.\u0104(oc1e2c36223e2);
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        super.z$3dv8qdlj15ex7(n, n2);
        this.\u0435 = n;
        this.\u04f2 = n2;
        this.\u00ca();
        this.\u0161();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this)) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        if (n3 == 0 && this.z$1ypnztpggng98(n, n2, oc1e2c36223e2)) {
            this.z$3nc6oxfxxw2c(n, n2);
            return true;
        }
        if (n3 == 0 && this.z$2ry952kdqqsva(n, n2, oc1e2c36223e2)) {
            this.\u01da(n, n2);
            return true;
        }
        if (this.\u00ce(n, n2, oc1e2c36223e2)) {
            this.z$3vjd5f9fpehnr(n, n2);
            return true;
        }
        if (this.\u045e()) {
            this.\u0196();
        }
        this.z$y2i4ps06rcix(n, n2, n3);
        return false;
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        if (!this.\u0172.\u0224) {
            return;
        }
        if (n == 1 && this.\u045e()) {
            if (!this.z$2tyl9wl3yz5qt()) {
                this.\u0196();
            }
            return;
        }
        if ((n == (0x819FB56D ^ 0x819FB571) || n == (0x819FB5ED ^ 0x819FB571)) && this.\u045e()) {
            this.\u0196();
            return;
        }
        if (this.\u0426().\u04e7(c, n)) {
            this.z$6z92wsjyn19b(this.\u0426().Q());
            this.\u04c8.\u0234(0.0f);
            this.\u00ca();
            this.\u0172.\u01e3();
        }
    }

    @Override
    public void z$vm4dmbdypoel(int n) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this)) {
            return;
        }
        float f = (float)oc6a43806f12.\u04f9.\u04c1();
        float f2 = oc08592ac73b.\u02b5(n, f);
        if (this.\u011b()) {
            if (f2 != 0.0f) {
                this.\u04c8.\u024f(-f2);
            }
            this.\u016d();
            return;
        }
        if (this.\u01af() && this.z$1sz52c3oju7wv() > (0xEE3165E6 ^ 0xEE3165E1)) {
            if (f2 != 0.0f) {
                this.\u017c.\u024f(-f2);
            }
            this.\u0101();
        }
    }

    @Override
    public void z$19sxbvum8v80h() {
        super.z$19sxbvum8v80h();
        this.\u0426().\u03f1("");
        this.z$3jmhyccrxm495();
        this.\u04c8.\u0234(0.0f);
        this.\u017c.\u0234(0.0f);
        this.j = null;
        this.\u04cb = 0.0f;
        this.\u01f0 = 0.0f;
        this.\u04f8 = 0.0f;
    }

    @Override
    public float z$2rmsdj781vrn2() {
        return this.\u046d();
    }

    public boolean \u045e() {
        return this.\u0503();
    }

    public void \u0196() {
        this.\u039a(false);
        this.\u00ca();
    }

    @Override
    public boolean z$z2u2v5j2dveu() {
        return this.\u045e() || this.z$1qy37w0ke846i();
    }

    @Override
    public void z$qv3ekpvnclzq() {
        this.z$1l3emcmy91hvz();
        this.\u0196();
    }

    @Override
    public boolean z$2v3bclguk2h6z(int n, int n2) {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        return this.\u0141(n, n2, oc1e2c36223e2) || this.\u01e4(n, n2) || this.\u04d0(n, n2);
    }

    public boolean \u0471(float f, float f2) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this)) {
            return false;
        }
        if (this.\u01e4(f, f2) && this.z$3e4g54z35cw92() > (0x5F9CD550 ^ 0x5F9CD557)) {
            return true;
        }
        return this.\u04d0(f, f2) && this.z$1sz52c3oju7wv() > (0x5F9CD550 ^ 0x5F9CD557);
    }

    public float \u046d() {
        int n = this.z$1sz52c3oju7wv();
        float f = n == 0 ? 0.0f : 4.0f + (float)Math.min(0xBF0B0B2F ^ 0xBF0B0B28, n) * 12.0f;
        return 24.0f + this.\u01e1() + f;
    }

    protected final float \u01e1() {
        if (this.j != null) {
            if ((float)(System.currentTimeMillis() - this.j.\u0445) >= 280.0f) {
                this.j = null;
                this.\u04cb = this.\u04f8;
                this.\u01f0 = this.\u04f8;
            } else {
                this.\u04cb = this.j.\u01df(this.\u01f0, this.\u04f8, 1);
                if (this.\u04cb == this.\u04f8) {
                    this.j = null;
                    this.\u01f0 = this.\u04f8;
                }
            }
        }
        return this.\u04cb;
    }

    protected final float \u0432(oc1e2c36223e oc1e2c36223e2) {
        return oc1e2c36223e2.N + this.\u01e1() + 4.0f;
    }

    protected final float \u0469() {
        return (float)Math.min(0xC9630A34 ^ 0xC9630A33, this.z$1sz52c3oju7wv()) * 12.0f;
    }

    protected final void \u016d() {
        float f = Math.max(0.0f, (float)(this.z$3e4g54z35cw92() - (0x3DDBF1C0 ^ 0x3DDBF1C7)) * 12.0f);
        this.\u04c8.\u057f(0.0f, f);
    }

    protected final void \u0101() {
        float f = Math.max(0.0f, (float)(this.z$1sz52c3oju7wv() - (0xD3AB1212 ^ 0xD3AB1215)) * 12.0f);
        this.\u017c.\u057f(0.0f, f);
    }

    protected final void \u00ca() {
        float f = this.\u04d9();
        if (f != this.\u04f8) {
            this.\u01f0 = this.\u04cb;
            this.\u04f8 = f;
            this.j = new oc5f2027353d(250.0f);
            this.j.\u039e();
        }
    }

    protected final void \u0278() {
        this.\u04dc();
        this.\u00ca();
        this.\u0172.\u01e3();
    }

    protected final void \u04dc() {
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }

    protected final ItemStack \u01d8(ocdd11f3c425 ocdd11f3c4252) {
        if (ocdd11f3c4252 == null) {
            return null;
        }
        if (ocdd11f3c4252.\u01a1 != null && !ocdd11f3c4252.\u01a1.isEmpty()) {
            int n = (int)(System.currentTimeMillis() / (0x93CD3C41EDB5382BL ^ 0x93CD3C41EDB53BC3L) % (long)ocdd11f3c4252.\u01a1.size());
            return ocdd11f3c4252.\u01a1.get(n);
        }
        return ocdd11f3c4252.\u021d;
    }

    protected final void \u0437(float f, float f2, float f3, int n, String string) {
        ocbd4917c4b1.\u0109(f, f3, f2, f3 + 12.0f - 1.0f, n);
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/arrow_left.png");
        if (resourceLocation != null) {
            float f4 = f + 2.0f;
            float f5 = f3 + 2.5f;
            ocbd4917c4b1.\u00ec(resourceLocation, f4, f5, 0xEE659CA3 ^ 0xEE659CA5, -1);
        }
        this.\u04a1(string != null ? string : "Back", f + 13.0f, f3, 0x11A95069 ^ 0xEE659CA5);
    }

    protected final void \u03e4(String string, ItemStack itemStack, float f, float f2, float f3, int n, boolean bl) {
        ocbd4917c4b1.\u0109(f, f3, f2, f3 + 12.0f - 1.0f, n);
        this.\u0240(itemStack, f + 2.0f, f3);
        this.\u04a1(string != null ? string : "", f + 13.0f, f3, 0x3DF65DE5 ^ 0xC23A9129);
        if (bl) {
            this.\u0295(f2, f3);
        }
    }

    protected final void \u04a1(String string, float f, float f2, int n) {
        ocfd4ff6075d.\u018e(string, f, ocfd4ff6075d.\u039a(f2, 11.0f, 0.56f) + 0.56f, n, 0.56f);
    }

    protected final void \u0295(float f, float f2) {
        ResourceLocation resourceLocation = ocbd4917c4b1.\u02b8("/assets/idle.miau/textures/gui/close.png");
        if (resourceLocation == null) {
            return;
        }
        float f3 = f - 6.0f - 3.0f;
        float f4 = f2 + 2.5f;
        int n = oc3542cefbeb.\u0189(oc3542cefbeb.\u039d[0], oc3542cefbeb.\u039d[1], 0.0);
        ocbd4917c4b1.\u00ec(resourceLocation, f3, f4, 0x73E637B5 ^ 0x73E637B3, n);
    }

    protected final boolean \u0227(float f, float f2, float f3, float f4) {
        float f5 = f4 - 6.0f - 3.0f;
        float f6 = f3 + 3.0f;
        return f >= f5 && f <= f5 + 6.0f && f2 >= f6 && f2 <= f6 + 6.0f;
    }

    protected final void \u0240(ItemStack itemStack, float f, float f2) {
        if (itemStack == null) {
            return;
        }
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        double d = 0.55;
        float f3 = (float)(16.0 * d);
        float f4 = (11.0f - f3) / 2.0f;
        float f5 = f2 + f4;
        float f6 = (float)((double)f / d);
        float f7 = (float)((double)f5 / d);
        GlStateManager.pushMatrix();
        GlStateManager.scale(d, d, d);
        GlStateManager.translate(f6, f7, 0.0f);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableBlend();
        renderItem.renderItemAndEffectIntoGUI(itemStack, 0, 0);
        GlStateManager.enableBlend();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    protected final boolean \u01e4(float f, float f2) {
        if (this.z$3e4g54z35cw92() == 0) {
            return false;
        }
        float f3 = this.\u01e1();
        if (f3 <= 0.0f) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        return f >= oc1e2c36223e2.\u043a && f <= oc1e2c36223e2.\u0146 && f2 >= oc1e2c36223e2.N && f2 < oc1e2c36223e2.N + f3;
    }

    protected final boolean \u04d0(float f, float f2) {
        if (this.z$1sz52c3oju7wv() == 0) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        float f3 = this.\u0432(oc1e2c36223e2);
        float f4 = this.\u0469();
        return f >= oc1e2c36223e2.\u043a && f <= oc1e2c36223e2.\u0146 && f2 >= f3 && f2 < f3 + f4;
    }

    protected final boolean \u011b() {
        return this.\u01e4(this.\u0435, this.\u04f2);
    }

    protected final boolean \u01af() {
        return this.\u04d0(this.\u0435, this.\u04f2);
    }

    private float \u04d9() {
        int n = this.z$3e4g54z35cw92();
        if (this.\u045e() && n > 0) {
            return (float)Math.min(0x611178F0 ^ 0x611178F7, n) * 12.0f;
        }
        return 0.0f;
    }

    private void \u0586(oc1e2c36223e oc1e2c36223e2) {
        float f;
        int n = this.z$3e4g54z35cw92();
        float f2 = this.\u01e1();
        float f3 = this.\u0172.\u02a4.\u0248 - oc1e2c36223e2.\u0124;
        if (f2 <= 0.0f || n == 0) {
            return;
        }
        float f4 = oc1e2c36223e2.N + f3;
        ocbd4917c4b1.\u010e(oc1e2c36223e2.\u043a, f4, oc1e2c36223e2.\u0146 - oc1e2c36223e2.\u043a, f2);
        float f5 = this.\u04c8.\u021b();
        int n2 = (int)(f5 / 12.0f);
        int n3 = Math.min(n2 + (0x5BB07206 ^ 0x5BB07201) + 1, n);
        int n4 = -1;
        if (this.\u0435 >= oc1e2c36223e2.\u043a && this.\u0435 <= oc1e2c36223e2.\u0146 && this.\u04f2 >= f4 && this.\u04f2 < f4 + f2 && ((n4 = (int)(((f = this.\u04f2 - f4) + f5) / 12.0f)) < 0 || n4 >= n)) {
            n4 = -1;
        }
        this.z$2ys9gltfj0lh(oc1e2c36223e2, f5, n2, n3, n4);
        ocbd4917c4b1.\u01df();
    }

    private void \u0104(oc1e2c36223e oc1e2c36223e2) {
        int n = this.z$1sz52c3oju7wv();
        if (n == 0) {
            return;
        }
        float f = this.\u0432(oc1e2c36223e2);
        float f2 = this.\u0469();
        float f3 = this.\u0172.\u02a4.\u0248 - oc1e2c36223e2.\u0124;
        ocbd4917c4b1.\u010e(oc1e2c36223e2.\u043a, f + f3, oc1e2c36223e2.\u0146 - oc1e2c36223e2.\u043a, f2);
        float f4 = this.\u017c.\u021b();
        int n2 = (int)(f4 / 12.0f);
        int n3 = Math.min(n2 + (0x1E11F817 ^ 0x1E11F810) + 1, n);
        this.z$14avr6kdt7khn(oc1e2c36223e2, f4, n2, n3);
        ocbd4917c4b1.\u01df();
    }

    private boolean \u00ce(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        if (this.\u0141(n, n2, oc1e2c36223e2)) {
            this.\u039a(true);
            this.z$vrc7cco7wwqp();
            this.\u00ca();
            return true;
        }
        return false;
    }

    protected boolean z$1qy37w0ke846i() {
        return false;
    }

    protected void z$1l3emcmy91hvz() {
    }

    protected void \u0161() {
    }

    protected void z$3nc6oxfxxw2c(int n, int n2) {
    }

    protected void \u01da(int n, int n2) {
    }

    protected void z$3vjd5f9fpehnr(int n, int n2) {
    }

    protected void z$y2i4ps06rcix(int n, int n2, int n3) {
    }

    protected abstract String z$37vljf1p4xmma();

    protected abstract int z$1sz52c3oju7wv();

    protected abstract int z$3e4g54z35cw92();

    protected abstract void z$2ys9gltfj0lh(oc1e2c36223e var1, float var2, int var3, int var4, int var5);

    protected abstract void z$14avr6kdt7khn(oc1e2c36223e var1, float var2, int var3, int var4);

    protected abstract boolean z$1ypnztpggng98(int var1, int var2, oc1e2c36223e var3);

    protected abstract boolean z$2ry952kdqqsva(int var1, int var2, oc1e2c36223e var3);

    protected abstract void z$6z92wsjyn19b(String var1);

    protected abstract boolean z$2tyl9wl3yz5qt();

    protected abstract void z$vrc7cco7wwqp();

    protected abstract void z$3jmhyccrxm495();
}

