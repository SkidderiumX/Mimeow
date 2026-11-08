/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import x.oc1378bc114d;
import x.ocd9533bdf8b;

public class oca077e2210f
implements oc1378bc114d {
    private static final String \u042b = "0123456789abcdef";
    private static final char \u0427 = '\u00a7';
    private final FontRenderer \u02c1;
    private final float \u03e2;
    private final boolean \u04ea;

    public oca077e2210f(FontRenderer fontRenderer) {
        this(fontRenderer, 1.0f);
    }

    public oca077e2210f(FontRenderer fontRenderer, float f) {
        this(fontRenderer, f, true);
    }

    public oca077e2210f(FontRenderer fontRenderer, float f, boolean bl) {
        this.\u02c1 = fontRenderer;
        this.\u03e2 = Math.max(0.5f, Math.min(2.0f, f));
        this.\u04ea = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int z$ao2ykh4tuw6w(String string, float f, float f2, int n, boolean bl) {
        boolean bl2 = this.\u0117();
        try {
            int n2;
            if (this.\u03e2 == 1.0f) {
                int n3 = this.\u02c1.drawString(string, f, f2, n, bl);
                return n3;
            }
            GlStateManager.pushMatrix();
            try {
                GlStateManager.translate(f, f2, 0.0f);
                GlStateManager.scale(this.\u03e2, this.\u03e2, 1.0f);
                int n4 = this.\u02c1.drawString(string, 0.0f, 0.0f, n, bl);
                n2 = Math.round((float)n4 * this.\u03e2);
            }
            catch (Throwable throwable) {
                GlStateManager.popMatrix();
                throw throwable;
            }
            GlStateManager.popMatrix();
            return n2;
        }
        finally {
            this.\u0452(bl2);
        }
    }

    @Override
    public int z$22eyp2803ejhs(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2, boolean bl) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        return this.\u04d1(string, f, f2, ocd9533bdf8b2, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int \u04d1(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2, boolean bl) {
        boolean bl2 = this.\u0117();
        try {
            int n;
            int n2 = 0;
            Integer n3 = null;
            StringBuilder stringBuilder = new StringBuilder();
            for (n = 0; n < string.length(); ++n) {
                float f3;
                float f4;
                int n4;
                char c;
                char c2 = string.charAt(n);
                if (c2 == (0xC86655EE ^ 0xC8665549) && n + 1 < string.length()) {
                    int n5;
                    if ((n5 = "0123456789abcdef".indexOf(c = (char)Character.toLowerCase(string.charAt(++n)))) >= 0) {
                        n3 = 0x37665549 ^ 0xC8665549 | this.\u02c1.getColorCode(c);
                        stringBuilder.setLength(0);
                        continue;
                    }
                    if (c == (0xC866553B ^ 0xC8665549)) {
                        n3 = null;
                        stringBuilder.setLength(0);
                        continue;
                    }
                    if (!oca077e2210f.\u04c8(c)) continue;
                    oca077e2210f.\u0458(stringBuilder, c);
                    continue;
                }
                if (c2 == (0xC8665543 ^ 0xC8665549) || (c = this.\u02c1.getCharWidth(c2)) < '\u0000') continue;
                if (oca077e2210f.\u019f(stringBuilder, (char)(0xC8665525 ^ 0xC8665549)) && c > '\u0000') {
                    ++c;
                }
                if ((n4 = ocd9533bdf8b2.z$151wba1mm8frh(c2, f4 = (float)n2 * this.\u03e2, f3 = (float)c * this.\u03e2, n3)) >>> (0xC8665551 ^ 0xC8665549) > 0) {
                    this.\u0554(c2, stringBuilder, f + f4, f2, n4, bl);
                }
                n2 += c;
            }
            n = Math.round((float)n2 * this.\u03e2);
            return n;
        }
        finally {
            this.\u0452(bl2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int z$toz8pt08w0nc(String string) {
        boolean bl = this.\u0117();
        try {
            int n = Math.round((float)this.\u02c1.getStringWidth(string) * this.\u03e2);
            return n;
        }
        finally {
            this.\u0452(bl);
        }
    }

    @Override
    public int z$1tqmx4tpnr6lq() {
        return Math.round((float)this.\u02c1.FONT_HEIGHT * this.\u03e2);
    }

    @Override
    public int z$3hte9fh87zo6x() {
        return Math.round((float)this.\u02c1.FONT_HEIGHT * this.\u03e2);
    }

    @Override
    public float z$3l314uvjy8lta() {
        return (float)this.\u02c1.FONT_HEIGHT * this.\u03e2;
    }

    @Override
    public int z$g5bxucc1j700() {
        return 0;
    }

    @Override
    public int z$w1h9nvoglpkn() {
        return Math.max(1, Math.round(((float)this.\u02c1.FONT_HEIGHT - 1.0f) * this.\u03e2));
    }

    public float \u0519() {
        return this.\u03e2;
    }

    private boolean \u0117() {
        if (!this.\u04ea) {
            return false;
        }
        boolean bl = this.\u02c1.getUnicodeFlag();
        if (bl) {
            this.\u02c1.setUnicodeFlag(false);
        }
        return bl;
    }

    private void \u0452(boolean bl) {
        if (bl) {
            this.\u02c1.setUnicodeFlag(true);
        }
    }

    private void \u0554(char c, StringBuilder stringBuilder, float f, float f2, int n, boolean bl) {
        if (stringBuilder.length() == 0) {
            this.z$ao2ykh4tuw6w(String.valueOf(c), f, f2, n, bl);
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.length() + 1);
        stringBuilder2.append((CharSequence)stringBuilder).append(c);
        this.z$ao2ykh4tuw6w(stringBuilder2.toString(), f, f2, n, bl);
    }

    private static boolean \u04c8(char c) {
        return c >= (0x17C70BA3 ^ 0x17C70BC8) && c <= (0x17C70BA7 ^ 0x17C70BC8);
    }

    private static boolean \u019f(StringBuilder stringBuilder, char c) {
        for (int i = 1; i < stringBuilder.length(); i += 2) {
            if (stringBuilder.charAt(i) != c) continue;
            return true;
        }
        return false;
    }

    private static void \u0458(StringBuilder stringBuilder, char c) {
        if (oca077e2210f.\u019f(stringBuilder, c)) {
            return;
        }
        stringBuilder.append((char)(0x6A8CE191 ^ 0x6A8CE136)).append(c);
    }
}

