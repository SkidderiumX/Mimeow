/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import x.oc117ab26e54;
import x.oc1378bc114d;
import x.oc1e2c36223e;
import x.oc2ef79a3df1;
import x.oc6a43806f12;
import x.oc8355eae8ed;
import x.oc920065c394;
import x.ocbc9c7a1e51;
import x.ocbd4917c4b1;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public class oc6c40e19ed3
extends oc117ab26e54<ocbc9c7a1e51> {
    private static final float \u03c1 = 9.0f;
    private static final float \u024f = 3.0f;
    private static final float \u00ee = 0.5f;
    private static final float \u0209 = 3.0f;
    private static final float \u038e = 10.0f;
    private static final float \u0478 = 3.0f;
    private List<oc8355eae8ed> \u0229;
    private String \u0395;
    private String \u015f;
    private float \u0566;

    public oc6c40e19ed3(ocbc9c7a1e51 ocbc9c7a1e512, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocbc9c7a1e512, ocebe35f25d62, f);
    }

    @Override
    protected int z$1sz52c3oju7wv() {
        return ((ocbc9c7a1e51)this.\u00b5).\u01df().size();
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        super.z$3dv8qdlj15ex7(n, n2);
        this.\u0238();
    }

    @Override
    public void z$1n0m425nu1zvd(int n, int n2, int n3) {
        if (n3 == 0) {
            this.\u015f = null;
        }
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        if (!this.\u0172.\u0224) {
            return;
        }
        if (this.\u0395 != null) {
            if (n == 1) {
                this.\u0395 = null;
                return;
            }
            int n2 = this.\u0121(n);
            if (n2 != -1) {
                ((ocbc9c7a1e51)this.\u00b5).\u01ce(this.\u0395, n2);
                this.\u0395 = null;
                this.z$1zejnqfgzojx7();
                this.\u04dc();
            }
            return;
        }
        super.z$zr5dl604ndgu(c, n);
    }

    @Override
    protected boolean z$1qy37w0ke846i() {
        return this.\u0395 != null;
    }

    @Override
    protected void z$1l3emcmy91hvz() {
        this.\u0395 = null;
    }

    @Override
    protected void z$3nc6oxfxxw2c(int n, int n2) {
        this.\u0395 = null;
    }

    @Override
    protected void z$3vjd5f9fpehnr(int n, int n2) {
        this.\u0395 = null;
    }

    @Override
    protected void z$y2i4ps06rcix(int n, int n2, int n3) {
        this.\u0395 = null;
    }

    @Override
    protected void z$14avr6kdt7khn(oc1e2c36223e oc1e2c36223e2, float f, int n, int n2) {
        List<String> list = ((ocbc9c7a1e51)this.\u00b5).\u01df();
        if (this.\u0229 == null || this.\u0229.size() != list.size()) {
            this.\u0229 = new ArrayList<oc8355eae8ed>();
            for (String object : list) {
                List<oc2ef79a3df1> list2 = oc920065c394.\u04f6(object) ? oc920065c394.\u046b(object) : null;
                ArrayList<ItemStack> n3 = null;
                if (list2 != null && !list2.isEmpty()) {
                    n3 = new ArrayList<ItemStack>();
                    for (oc2ef79a3df1 oc2ef79a3df12 : list2) {
                        n3.add(oc2ef79a3df12.\u020b());
                    }
                }
                this.\u0229.add(new oc8355eae8ed(object, oc920065c394.\u049f(object), oc920065c394.t(object), n3, ((ocbc9c7a1e51)this.\u00b5).\u03a6(object)));
            }
        }
        for (int i = n; i < n2; ++i) {
            oc8355eae8ed oc8355eae8ed2 = this.\u0229.get(i);
            float f2 = this.\u0432(oc1e2c36223e2) - f + (float)i * 12.0f;
            int n3 = oc8355eae8ed2.\u029c.equals(this.\u015f) ? 0x223A44F1 ^ 0xDD106ECD : (i % (0xDD106ECF ^ 0xDD106ECD) == 0 ? 0x220A74E7 ^ 0xDD106ECD : 0x220E70E3 ^ 0xDD106ECD);
            this.\u024a(oc8355eae8ed2, oc1e2c36223e2.\u043a, oc1e2c36223e2.\u0146, f2, n3);
        }
    }

    @Override
    protected boolean z$2ry952kdqqsva(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        int n3 = this.\u03bf(n, n2, oc1e2c36223e2);
        if (n3 < 0) {
            this.\u015f = null;
            return false;
        }
        String string = ((ocbc9c7a1e51)this.\u00b5).\u01df().get(n3);
        float f = this.\u0432(oc1e2c36223e2) - this.\u017c.\u021b() + (float)n3 * 12.0f;
        if (this.\u0227(n, n2, f, oc1e2c36223e2.\u0146)) {
            ((ocbc9c7a1e51)this.\u00b5).z$2pk8fzn7jisvx(string);
            this.z$1zejnqfgzojx7();
            this.\u0395 = null;
            this.\u015f = null;
            this.\u04dc();
            this.\u0101();
            this.\u00ca();
            this.\u0172.\u01e3();
            return true;
        }
        if (this.\u0376(n, n2, f, oc1e2c36223e2.\u0146, string)) {
            this.\u0395 = string;
            this.\u015f = null;
            return true;
        }
        this.\u015f = string;
        this.\u0566 = (float)n2 - f;
        if (!this.\u00cb(n, n2, oc1e2c36223e2)) {
            this.\u0395 = null;
        }
        return true;
    }

    @Override
    protected void z$1zejnqfgzojx7() {
        this.\u0229 = null;
    }

    @Override
    protected void z$24873xrdw6tbn() {
        this.\u0395 = null;
        this.\u015f = null;
    }

    private void \u024a(oc8355eae8ed oc8355eae8ed2, float f, float f2, float f3, int n) {
        ocbd4917c4b1.\u0109(f, f3, f2, f3 + 12.0f - 1.0f, n);
        this.\u0240(this.\u01d8(oc8355eae8ed2), f + 2.0f, f3);
        this.\u04a1(oc8355eae8ed2.\u057c != null ? oc8355eae8ed2.\u057c : "", f + 13.0f, f3, 0xF2D31258 ^ 0xD1FDE94);
        float f4 = f2 - 6.0f - 3.0f;
        float f5 = f4 - 3.0f;
        float f6 = f5 - this.\u01a5(oc8355eae8ed2.\u029c);
        this.\u04ea(oc8355eae8ed2, f6, f5, f3);
        this.\u0295(f2, f3);
    }

    private void \u04ea(oc8355eae8ed oc8355eae8ed2, float f, float f2, float f3) {
        boolean bl = oc8355eae8ed2.\u029c.equals(this.\u0395);
        int n = bl ? 0xB3BF02AC ^ 0x4C8A57D6 : 0xB3AE1EB0 ^ 0x4C8A57D6;
        float f4 = f3 + 2.0f;
        float f5 = f3 + 12.0f - 3.0f;
        ocbd4917c4b1.\u0109(f, f4, f2, f5, 0xB39B43CA ^ 0x4C8A57D6);
        ocbd4917c4b1.\u0109(f + 1.0f, f4 + 1.0f, f2 - 1.0f, f5 - 1.0f, n);
        String string = this.\u0185(oc8355eae8ed2.\u029c);
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        float f6 = (float)oc1378bc114d2.z$toz8pt08w0nc(string) * 0.5f;
        float f7 = f + (f2 - f - f6) / 2.0f;
        float f8 = ocfd4ff6075d.\u0400(f4, f5 - f4) + 0.5f;
        ocfd4ff6075d.\u0408(string, f7, f8, 0xB362B923 ^ 0x4C8A57D6);
    }

    private void \u0238() {
        List<String> list;
        int n;
        if (this.\u015f == null || ((ocbc9c7a1e51)this.\u00b5).\u01df().isEmpty()) {
            return;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        float f = this.\u0432(oc1e2c36223e2);
        float f2 = this.\u0469();
        if (f2 <= 0.0f) {
            this.\u015f = null;
            return;
        }
        if (((ocbc9c7a1e51)this.\u00b5).\u01df().size() > (0xCEFE3513 ^ 0xCEFE3514) && this.\u0435 >= oc1e2c36223e2.\u043a && this.\u0435 <= oc1e2c36223e2.\u0146) {
            if (this.\u04f2 < f + 10.0f) {
                this.\u017c.\u024f(3.0f);
                this.\u0101();
            } else if (this.\u04f2 > f + f2 - 10.0f) {
                this.\u017c.\u024f(-3.0f);
                this.\u0101();
            }
        }
        if ((n = (list = ((ocbc9c7a1e51)this.\u00b5).\u01df()).indexOf(this.\u015f)) < 0) {
            this.\u015f = null;
            return;
        }
        float f3 = this.\u04f2 - this.\u0566;
        float f4 = f3 + 6.0f;
        int n2 = (int)Math.floor((f4 - f + this.\u017c.\u021b()) / 12.0f);
        if ((n2 = Math.max(0, Math.min(n2, list.size() - 1))) != n) {
            ((ocbc9c7a1e51)this.\u00b5).\u01fd(this.\u015f, n2);
            this.z$1zejnqfgzojx7();
            this.\u04dc();
        }
    }

    private int \u03bf(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        float f;
        if (!this.\u04d0(n, n2)) {
            return -1;
        }
        float f2 = this.\u0432(oc1e2c36223e2);
        int n3 = (int)(((float)n2 - f2 + (f = this.\u017c.\u021b())) / 12.0f);
        if (n3 < 0 || n3 >= ((ocbc9c7a1e51)this.\u00b5).\u01df().size()) {
            return -1;
        }
        float f3 = f2 - f + (float)n3 * 12.0f;
        return (float)n2 >= f3 && (float)n2 < f3 + 12.0f ? n3 : -1;
    }

    private boolean \u00cb(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        int n3 = this.\u03bf(n, n2, oc1e2c36223e2);
        if (n3 < 0) {
            return false;
        }
        String string = ((ocbc9c7a1e51)this.\u00b5).\u01df().get(n3);
        float f = this.\u0432(oc1e2c36223e2) - this.\u017c.\u021b() + (float)n3 * 12.0f;
        return this.\u0376(n, n2, f, oc1e2c36223e2.\u0146, string);
    }

    private boolean \u0376(int n, int n2, float f, float f2, String string) {
        float f3 = f2 - 6.0f - 3.0f - 3.0f;
        float f4 = f3 - this.\u01a5(string);
        return (float)n >= f4 && (float)n <= f3 && (float)n2 >= f + 1.0f && (float)n2 <= f + 12.0f - 1.0f;
    }

    private float \u01a5(String string) {
        String string2 = this.\u0185(string);
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        float f = (float)oc1378bc114d2.z$toz8pt08w0nc(string2) * 0.5f;
        return Math.max(9.0f, f + 6.0f);
    }

    private String \u0185(String string) {
        if (string != null && string.equals(this.\u0395)) {
            return "...";
        }
        Integer n = ((ocbc9c7a1e51)this.\u00b5).\u03a6(string);
        return Integer.toString(n != null ? n : 1);
    }

    private int \u0121(int n) {
        Minecraft minecraft = Minecraft.getMinecraft();
        for (int i = 0; i < minecraft.gameSettings.keyBindsHotbar.length; ++i) {
            if (n != minecraft.gameSettings.keyBindsHotbar[i].getKeyCode()) continue;
            return i + 1;
        }
        return -1;
    }
}

