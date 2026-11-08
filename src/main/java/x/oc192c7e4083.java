/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import x.oc03d1b35e89;
import x.oc08592ac73b;
import x.oc0e37bc27e8;
import x.oc1378bc114d;
import x.oc151419fdfe;
import x.oc26930a666f;
import x.oc2cf3d80e17;
import x.oc41720aed4a;
import x.oc5f2027353d;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc7ab2161b9f;
import x.oc7b35709bf1;
import x.oc81019d75fb;
import x.oc8d36772412;
import x.oc9e5a7eeec6;
import x.oca4a10e5e70;
import x.oca6255529df;
import x.ocb69e4fa09a;
import x.ocbd4917c4b1;
import x.oce4cea752dd;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public class oc192c7e4083 {
    private static long \u01cc;
    private static final Map<oce4cea752dd, oc7b35709bf1> \u00f0;
    private static final oc26930a666f \u04e0;
    public List<ocebe35f25d6> \u015d = new CopyOnWriteArrayList<ocebe35f25d6>();
    public oce4cea752dd \u0229;
    public boolean \u00de;
    public float \u01b9;
    public float \u0501;
    public float \u04d9;
    public float \u053f;
    public boolean \u0172;
    public float \u0569;
    public float Y;
    public boolean \u019d = false;
    public boolean \u0181 = false;
    public oc5f2027353d \u03b6;
    private oc5f2027353d \u01f3;
    public float \u0244;
    private static final int \u0136;
    private static final int \u0480;
    private static final int \u01ee;
    private static final int \u0253;
    private float \u0453;
    private float \u01b3;
    private float \u03ff;
    public float \u0248;
    private float \u04b4;
    private float q;
    private float \u0469;
    private int \u042b;
    private final ocb69e4fa09a \u0288 = new ocb69e4fa09a(0x9D067390697BD3AAL ^ 0x9D067390697BD3D2L);
    public long \u04aa = 0L;

    public oc192c7e4083(oce4cea752dd oce4cea752dd2) {
        this.\u0229 = oce4cea752dd2;
        this.\u01b9 = oce4cea752dd2 == oce4cea752dd.\u00aa ? 108.0f : 92.0f;
        this.\u04d9 = 5.0f;
        this.\u0501 = 5.0f;
        this.\u0248 = 5.0f;
        this.\u053f = 13.0f;
        float f = this.\u053f + 3.0f;
        this.\u0288.\u0234(this.\u0248);
        this.\u0469 = this.\u0453 = this.\u0501 + this.\u053f + 4.0f;
        for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u00f3().\u0249(this.\u0229)) {
            ocebe35f25d6 ocebe35f25d62 = new ocebe35f25d6(oc69da1aa7f52, this, f);
            this.\u015d.add(ocebe35f25d62);
            f += 16.0f;
        }
    }

    public List<ocebe35f25d6> \u01d0() {
        return this.\u015d;
    }

    public void \u0101() {
        Map<String, Boolean> map = this.\u015b();
        this.\u015d.clear();
        this.\u053f = 13.0f;
        float f = this.\u053f + 3.0f;
        for (oc69da1aa7f5 oc69da1aa7f52 : oc2cf3d80e17.\u00f3().\u0249(this.\u0229)) {
            ocebe35f25d6 ocebe35f25d62 = new ocebe35f25d6(oc69da1aa7f52, this, f);
            ocebe35f25d62.\u0567(Boolean.TRUE.equals(map.get(oc69da1aa7f52.z$3i8m9vxwuvqj0())));
            this.\u015d.add(ocebe35f25d62);
            f += 16.0f;
        }
        this.\u04e2();
    }

    public void \u00ca(boolean bl) {
        Map<String, Boolean> map = this.\u015b();
        this.\u015d.clear();
        this.\u053f = 13.0f;
        float f = this.\u053f + 3.0f;
        if (this.\u0229 == oce4cea752dd.\u051d && bl) {
            if (oc2cf3d80e17.\u00c1 == null) {
                return;
            }
            for (oc151419fdfe oc151419fdfe2 : oc2cf3d80e17.\u00c1.\u01f9) {
                ocebe35f25d6 ocebe35f25d62 = new ocebe35f25d6(oc151419fdfe2.\u01da(), this, f);
                ocebe35f25d62.\u0567(Boolean.TRUE.equals(map.get(oc151419fdfe2.\u01da().z$3i8m9vxwuvqj0())));
                this.\u015d.add(ocebe35f25d62);
                f += 16.0f;
            }
        }
        this.\u04e2();
    }

    public void \u0193() {
        int n = ++this.\u042b;
        Map<String, Boolean> map = this.\u015b();
        this.\u03fe(Collections.singletonList(oc8d36772412.\u0182("Loading...")), map);
        \u04e0.\u04e6(oc9e5a7eeec6.\u044d, list -> {
            if (n != this.\u042b) {
                return;
            }
            ArrayList<oc41720aed4a> arrayList = new ArrayList<oc41720aed4a>((Collection<oc41720aed4a>)list);
            arrayList.sort(Comparator.comparing(oc41720aed4a::\u00d6, String.CASE_INSENSITIVE_ORDER));
            ArrayList<oc8d36772412> arrayList2 = new ArrayList<oc8d36772412>();
            for (oc41720aed4a oc41720aed4a2 : arrayList) {
                arrayList2.add(new oc8d36772412(oc41720aed4a2));
            }
            if (arrayList2.isEmpty()) {
                arrayList2.add(oc8d36772412.\u0182("No configs found"));
            }
            this.\u03fe(arrayList2, map);
        }, string -> {
            if (n == this.\u042b) {
                this.\u03fe(Collections.singletonList(oc8d36772412.\u0182("Failed: " + string)), map);
            }
        });
    }

    private void \u03fe(List<oc8d36772412> list, Map<String, Boolean> map) {
        this.\u015d.clear();
        this.\u053f = 13.0f;
        float f = this.\u053f + 3.0f;
        for (oc8d36772412 oc8d367724122 : list) {
            ocebe35f25d6 ocebe35f25d62 = new ocebe35f25d6(oc8d367724122, this, f);
            ocebe35f25d62.\u0567(Boolean.TRUE.equals(map.get(oc8d367724122.z$3i8m9vxwuvqj0())));
            this.\u015d.add(ocebe35f25d62);
            f += 16.0f;
        }
        this.\u04e2();
    }

    private Map<String, Boolean> \u015b() {
        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
            if (ocebe35f25d62.\u0523 == null) continue;
            hashMap.put(ocebe35f25d62.\u0523.z$3i8m9vxwuvqj0(), ocebe35f25d62.\u0224);
        }
        return hashMap;
    }

    private void \u04e2() {
        float f;
        oca4a10e5e70 oca4a10e5e702 = this.\u00c5(this.\u00de || this.\u03b6 != null);
        float f2 = oca4a10e5e702.\u0501;
        float f3 = this.\u0501;
        this.\u0248 = f = Math.max(f2, Math.min(f3, this.\u0288.\u0230()));
        this.\u0288.\u0234(f);
        if (this.\u00de && !this.\u015d.isEmpty()) {
            this.\u0244 = oca4a10e5e702.\u0247;
            this.\u0453 = oca4a10e5e702.\u018f;
            return;
        }
        if (!this.\u00de && this.\u03b6 == null) {
            this.\u0244 = 0.0f;
        }
        this.\u0453 = this.\u0501 + this.\u053f + 4.0f;
    }

    public void \u037c(float f, boolean bl) {
        if (bl) {
            f = Math.max(f, 2.0f);
            f = Math.min(f, this.q - this.\u01b9 - 4.0f);
        }
        this.\u04d9 = f;
    }

    public void \u0238(float f, boolean bl) {
        float f2;
        float f3;
        if (bl) {
            f = Math.max(f, 1.0f);
            f3 = this.\u04b4 - this.\u053f - 5.0f;
            f = Math.min(f, f3);
        }
        f3 = this.\u0288.\u0230() - this.\u0501;
        this.\u0501 = f;
        this.\u0248 = f2 = f + f3;
        this.\u0288.\u0234(f2);
    }

    public void \u0282(boolean bl) {
        this.\u0172 = bl;
    }

    public boolean \u0194() {
        return this.\u00de;
    }

    public void \u021a() {
        this.\u04aa = ++\u01cc;
    }

    public void \u0432(boolean bl) {
        this.\u0469 = this.\u051f();
        this.\u03ff = this.\u053f();
        float f = 250.0f;
        this.\u00de = bl;
        this.\u03b6 = new oc5f2027353d(f);
        this.\u03b6.\u039e();
        this.\u01f3 = new oc5f2027353d(f);
        this.\u01f3.\u039e();
    }

    public void \u0226(int n) {
        this.Y(n, Float.NaN, Float.NaN);
    }

    public void Y(int n, float f, float f2) {
        boolean bl;
        boolean bl2 = bl = !Float.isNaN(f) && !Float.isNaN(f2);
        if (!this.\u00de || bl && !this.\u0112((int)f, (int)f2) || !bl && !this.\u0181) {
            return;
        }
        for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
            ocebe35f25d62.z$vm4dmbdypoel(n);
        }
        if (bl) {
            for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
                for (oc6c12eede72 oc6c12eede722 : ocebe35f25d62.\u0376) {
                    ocfd4ff6075d ocfd4ff6075d2;
                    if (!ocebe35f25d62.\u0224 || !ocebe35f25d62.\u047c(oc6c12eede722) || !(oc6c12eede722 instanceof oc81019d75fb ? ((oc81019d75fb)(ocfd4ff6075d2 = (oc81019d75fb)oc6c12eede722)).\u0471(f, f2) : (oc6c12eede722 instanceof oc0e37bc27e8 ? ((oc0e37bc27e8)(ocfd4ff6075d2 = (oc0e37bc27e8)oc6c12eede722)).\u0508(f, f2) : oc6c12eede722 instanceof oc03d1b35e89 && ((oc03d1b35e89)(ocfd4ff6075d2 = (oc03d1b35e89)oc6c12eede722)).\u042f(f, f2)))) continue;
                    return;
                }
            }
        }
        this.\u021a();
        float f3 = (float)oc6a43806f12.\u04f9.\u04c1();
        float f4 = this.\u04ae();
        float f5 = this.\u0501;
        float f6 = oc08592ac73b.\u02b5(n, f3);
        if (f6 != 0.0f) {
            this.\u0288.\u024f(f6);
        }
        this.\u0288.\u057f(f4, f5);
    }

    private float \u0416() {
        float f = 0.0f;
        for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
            f += ocebe35f25d62.\u0454();
        }
        return f;
    }

    private float \u04ae() {
        return this.\u00c5((boolean)false).\u0501;
    }

    public void \u0566(FontRenderer fontRenderer) {
        float f;
        float f2;
        this.\u01b9 = this.\u0229 == oce4cea752dd.\u00aa ? 108.0f : 92.0f;
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u0109();
        if (this.\u03b6 != null && System.currentTimeMillis() - this.\u03b6.\u0445 >= (0xDDD9B407A071CAEAL ^ 0xDDD9B407A071CBF2L)) {
            this.\u03b6 = null;
        }
        if (this.\u01f3 != null && System.currentTimeMillis() - this.\u01f3.\u0445 >= (0xDDD9B407A071CAEAL ^ 0xDDD9B407A071CBF2L)) {
            this.\u01f3 = null;
        }
        for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
            ocebe35f25d62.\u056d();
        }
        oca4a10e5e70 oca4a10e5e702 = this.\u00c5(this.\u00de || this.\u03b6 != null);
        this.\u0244 = !this.\u00de && this.\u03b6 == null ? 0.0f : oca4a10e5e702.\u0247;
        float f3 = this.\u0501;
        float f4 = oca4a10e5e702.\u0501;
        this.\u0288.\u057f(f4, f3);
        this.\u0248 = this.\u0288.\u021b();
        this.\u0248 = Math.max(f4, Math.min(f3, this.\u0248));
        String string = this.\u0458();
        float f5 = this.\u04d9 + this.\u01b9 / 2.0f - (float)oc1378bc114d2.z$toz8pt08w0nc(string) / 2.0f;
        float f6 = oca4a10e5e702.\u018f;
        if (this.\u03b6 != null) {
            f2 = this.\u00de ? f6 : this.\u0501 + this.\u053f + 4.0f;
            f = this.\u03b6.\u01df(this.\u0469, f2, 1);
            if (this.\u00de && f > f2 || !this.\u00de && f < f2) {
                f = f2;
            }
        } else {
            f = f6;
        }
        f2 = this.\u00de ? f5 : this.\u04d9 + 12.0f;
        float f7 = this.\u01f3 == null ? f2 : this.\u01f3.\u01df(this.\u03ff, f2, 1);
        this.\u01b3 = f7;
        this.\u0453 = f;
        GL11.glPushMatrix();
        ocbd4917c4b1.\u0422(this.\u04d9 - 2.0f, this.\u0501, this.\u04d9 + this.\u01b9 + 2.0f, f, 10.0f, \u0136, (this.\u00de || this.\u019d) && oc6a43806f12.\u0131.\u01ed() ? ocbd4917c4b1.\u03a5(oc7ab2161b9f.\u01be(0xDDD9B407A071CBF0L ^ 0xDDD9B407A071CBF2L, 0L), 0.5) : \u0480, (this.\u00de || this.\u019d) && oc6a43806f12.\u0131.\u01ed() ? ocbd4917c4b1.\u03a5(oc7ab2161b9f.\u01be(0xDDD9B407A071CBF0L ^ 0xDDD9B407A071CBF2L, 0xDDD9B407A071C94EL ^ 0xDDD9B407A071CBF2L), 0.5) : \u01ee);
        this.\u03fc(this.\u0229, (int)(this.\u04d9 + 1.0f), (int)(this.\u0501 + 4.0f), this.\u00de || this.\u019d);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, f7, this.\u0501 + 4.0f, \u0253, false);
        float f8 = this.\u0501 + this.\u053f + 3.0f;
        float f9 = f - 2.0f;
        float f10 = Math.max(0.0f, f9 - f8);
        if (this.\u00de || this.\u03b6 != null) {
            GL11.glEnable(0xC17D5995 ^ 0xC17D5584);
            ocbd4917c4b1.\u0522(0.0, f8, this.\u04d9 + this.\u01b9 + 4.0f, f10);
            float f11 = this.\u0248 - this.\u0501;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, f11, 0.0f);
            for (oc6c12eede72 oc6c12eede722 : this.\u015d) {
                oc6c12eede722.z$1wkvejfd36e8w();
            }
            GL11.glPopMatrix();
            GL11.glDisable(0xC17D5995 ^ 0xC17D5584);
        }
        GL11.glPopMatrix();
    }

    public void \u0415() {
        float f = this.\u053f + 3.0f;
        for (oc6c12eede72 oc6c12eede722 : this.\u015d) {
            oc6c12eede722.z$18gzyyc94suow(f);
            f += oc6c12eede722.z$2rmsdj781vrn2();
        }
    }

    public float \u01a9() {
        return this.\u04d9;
    }

    public float \u0406() {
        return this.\u0501;
    }

    public float \u0523() {
        return this.\u0248;
    }

    public float \u0232() {
        return this.\u01b9;
    }

    public float \u022c() {
        if (!this.\u0194()) {
            return this.\u053f + 2.0f;
        }
        float f = Math.max(this.\u0453, this.\u0501 + this.\u053f + 2.0f);
        return Math.max(this.\u053f + 2.0f, f - this.\u0501);
    }

    public void X(int n, int n2, boolean bl) {
        if (this.\u0172) {
            float f = (float)n - this.\u0569;
            float f2 = (float)n2 - this.Y;
            f = Math.max(f, 2.0f);
            f = Math.min(f, this.q - this.\u01b9 - 4.0f);
            f2 = Math.max(f2, 1.0f);
            int n3 = (int)(this.\u04b4 - this.\u053f - 5.0f);
            f2 = Math.min(f2, (float)n3);
            this.\u037c(f, false);
            this.\u0238(f2, false);
        }
        this.\u0181 = bl && this.\u0112(n, n2);
        this.\u019d = bl && this.\u027a(n, n2);
    }

    public boolean \u027a(int n, int n2) {
        return (float)n >= this.\u04d9 && (float)n <= this.\u04d9 + this.\u01b9 && (float)n2 >= this.\u0501 + 2.0f && (float)n2 <= this.\u0501 + this.\u053f + 1.0f;
    }

    public boolean \u0112(int n, int n2) {
        return (float)n >= this.\u04d9 - 2.0f && (float)n <= this.\u04d9 + this.\u01b9 + 2.0f && (float)n2 >= this.\u0501 + 2.0f && (float)n2 <= this.\u0501 + this.\u053f + this.\u0244 + 1.0f;
    }

    public boolean \u049c(int n, int n2) {
        return (float)n >= this.\u04d9 && (float)n <= this.\u04d9 + this.\u01b9 && (float)n2 >= this.\u0501 && (float)n2 <= this.\u0501 + this.\u053f;
    }

    public boolean \u01a1(int n, int n2) {
        return (float)n >= this.\u04d9 - 2.0f && (float)n <= this.\u04d9 + this.\u01b9 + 2.0f && (float)n2 >= this.\u0501 && (float)n2 <= this.\u0453;
    }

    private void \u03fc(oce4cea752dd oce4cea752dd2, int n, int n2, boolean bl) {
        ItemStack itemStack;
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        double d = 0.55;
        GlStateManager.pushMatrix();
        GlStateManager.scale(d, d, d);
        oc7b35709bf1 oc7b35709bf12 = \u00f0.get((Object)oce4cea752dd2);
        ItemStack itemStack2 = oc7b35709bf12 == null ? null : (itemStack = bl ? oc7b35709bf12.\u0410 : oc7b35709bf12.\u03c0);
        if (itemStack != null) {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableBlend();
            GlStateManager.translate((float)((double)n / d), (float)((double)n2 / d), 0.0f);
            renderItem.renderItemAndEffectIntoGUI(itemStack, 0, 0);
            GlStateManager.enableBlend();
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }

    private float \u03a7() {
        if (!this.\u015d.isEmpty() && (this.\u00de || this.\u03b6 != null)) {
            float f = this.\u0501 + this.\u04b4 * 0.9f;
            return Math.min(this.\u0501 + this.\u053f + this.\u0244 + 4.0f, f);
        }
        return this.\u0501 + this.\u053f + 4.0f;
    }

    private float \u053f() {
        if (this.\u01f3 != null) {
            return this.\u01b3;
        }
        float f = this.\u04d9 + this.\u01b9 / 2.0f - (float)oc6a43806f12.\u0109().z$toz8pt08w0nc(this.\u0458()) / 2.0f;
        return this.\u00de ? f : this.\u04d9 + 12.0f;
    }

    private String \u0458() {
        return this.\u0229 == oce4cea752dd.\u00aa ? "official config" : this.\u0229.name();
    }

    private float \u051f() {
        if (this.\u0453 > 0.0f) {
            return this.\u0453;
        }
        if (!this.\u015d.isEmpty() && (this.\u00de || this.\u03b6 != null)) {
            float f = 0.0f;
            for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
                f += ocebe35f25d62.z$2rmsdj781vrn2();
            }
            return this.\u0501 + this.\u053f + f + 4.0f;
        }
        return this.\u0501 + this.\u053f + 4.0f;
    }

    public void \u04df(float f, float f2) {
        this.q = f;
        this.\u04b4 = f2;
    }

    public void \u019d() {
        this.\u037c(this.\u04d9, true);
        this.\u0238(this.\u0501, true);
    }

    public void \u02e1(float f, float f2, boolean bl, boolean bl2) {
        if (bl2) {
            this.\u037c(f, true);
            this.\u0238(f2, true);
        } else {
            float f3;
            float f4 = this.\u0288.\u0230() - this.\u0501;
            this.\u04d9 = f;
            this.\u0501 = f2;
            this.\u0248 = f3 = f2 + f4;
            this.\u0288.\u0234(f3);
        }
        this.\u00de = bl;
        this.\u03b6 = null;
        this.\u01f3 = null;
        if (bl && !this.\u015d.isEmpty()) {
            oca4a10e5e70 oca4a10e5e702 = this.\u00c5(true);
            this.\u0244 = oca4a10e5e702.\u0247;
            this.\u0453 = oca4a10e5e702.\u018f;
        } else {
            this.\u0244 = 0.0f;
            this.\u0453 = this.\u0501 + this.\u053f + 4.0f;
        }
        this.\u0248 = this.\u0501;
        this.\u0288.\u0234(this.\u0501);
    }

    public void \u04e1() {
        if (this.\u03b6 != null || this.\u01f3 != null) {
            float f = this.\u0501 + this.\u053f;
            if (this.\u00de && !this.\u015d.isEmpty()) {
                float f2 = 0.0f;
                for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
                    f2 += ocebe35f25d62.z$2rmsdj781vrn2();
                }
                f += f2 + 4.0f;
            } else {
                f += 4.0f;
            }
            this.\u0453 = f;
        }
        this.\u03b6 = null;
        this.\u01f3 = null;
        this.\u0248 = this.\u0288.\u0230();
        this.\u0288.\u0234(this.\u0248);
    }

    private oca4a10e5e70 \u00c5(boolean bl) {
        float f;
        if (this.\u015d.isEmpty() || !this.\u00de && this.\u03b6 == null) {
            return new oca4a10e5e70(0.0f, this.\u0501, this.\u0501 + this.\u053f + 4.0f);
        }
        float f2 = this.\u04b4 * 0.9f - this.\u053f - 4.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = this.\u053f + 3.0f;
        for (ocebe35f25d6 ocebe35f25d62 : this.\u015d) {
            if (bl) {
                ocebe35f25d62.z$18gzyyc94suow(f5);
            }
            f = ocebe35f25d62.z$2rmsdj781vrn2();
            f5 += f;
            f4 += ocebe35f25d62.\u0454();
            if (!(f3 < f2)) continue;
            f3 += Math.min(f, f2 - f3);
        }
        float f6 = Math.min(f2, f4);
        float f7 = Math.max(0.0f, f4 - f6);
        f = f7 > 0.0f ? this.\u0501 - f7 : this.\u0501;
        float f8 = this.\u0501 + this.\u04b4 * 0.9f;
        float f9 = Math.min(this.\u0501 + this.\u053f + f3 + 4.0f, f8);
        return new oca4a10e5e70(Math.max(0.0f, f3), f, f9);
    }

    private static Map<oce4cea752dd, oc7b35709bf1> \u0469() {
        EnumMap<oce4cea752dd, oc7b35709bf1> enumMap = new EnumMap<oce4cea752dd, oc7b35709bf1>(oce4cea752dd.class);
        for (oce4cea752dd oce4cea752dd2 : oce4cea752dd.values()) {
            ItemStack itemStack = oc192c7e4083.\u0402(oce4cea752dd2, false);
            ItemStack itemStack2 = oc192c7e4083.\u0402(oce4cea752dd2, true);
            if (itemStack == null || itemStack2 == null) continue;
            enumMap.put(oce4cea752dd2, new oc7b35709bf1(itemStack, itemStack2));
        }
        return enumMap;
    }

    private static ItemStack \u0402(oce4cea752dd oce4cea752dd2, boolean bl) {
        ItemStack itemStack;
        switch (oca6255529df.\u03b9[oce4cea752dd2.ordinal()]) {
            case 1: {
                itemStack = new ItemStack(Items.diamond_sword);
                break;
            }
            case 2: {
                itemStack = new ItemStack(Items.diamond_boots);
                break;
            }
            case 3: {
                itemStack = new ItemStack(Items.golden_apple);
                break;
            }
            case 4: {
                itemStack = new ItemStack(Items.filled_map);
                break;
            }
            case 5: {
                itemStack = new ItemStack(Items.ender_eye);
                break;
            }
            case 6: {
                itemStack = new ItemStack(Items.gold_ingot);
                break;
            }
            case 7: {
                itemStack = new ItemStack(Items.bed);
                break;
            }
            case 8: {
                itemStack = new ItemStack(Items.slime_ball);
                break;
            }
            case 9: {
                itemStack = new ItemStack(Items.clock);
                break;
            }
            case 10: {
                itemStack = new ItemStack(Items.book);
                break;
            }
            case 11: {
                itemStack = new ItemStack(Items.enchanted_book);
                break;
            }
            case 12: {
                itemStack = new ItemStack(Items.redstone);
                break;
            }
            default: {
                return null;
            }
        }
        if (!bl) {
            return itemStack;
        }
        if (oce4cea752dd2 != oce4cea752dd.\u0437) {
            itemStack.addEnchantment(Enchantment.unbreaking, 0x10E6EEE1 ^ 0x10E6EEE3);
        } else {
            itemStack.setItemDamage(1);
        }
        return itemStack;
    }

    static {
        \u00f0 = oc192c7e4083.\u0469();
        \u04e0 = new oc26930a666f();
        \u0136 = new Color(0, 0, 0, 0x5302E9F5 ^ 0x5302E99B).getRGB();
        \u0480 = new Color(0x5302E9CA ^ 0x5302E99B, 0x5302E9F8 ^ 0x5302E99B, 0x5302E90E ^ 0x5302E99B).getRGB();
        \u01ee = new Color(0x5302E9FA ^ 0x5302E99B, 0x5302E9D8 ^ 0x5302E99B, 0x5302E91E ^ 0x5302E99B).getRGB();
        \u0253 = new Color(0x5302E947 ^ 0x5302E99B, 0x5302E947 ^ 0x5302E99B, 0x5302E947 ^ 0x5302E99B).getRGB();
    }
}

