/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc170ea29aae;
import x.ocd9533bdf8b;
import x.oce17e1844c5;

public class oc9dc7529f0e
implements oc1378bc114d {
    private static final int \u00d6 = 0;
    private static final int \u00f1 = 255;
    private static final int \u015b = 255;
    private static final int \u0409 = 4;
    private static final float \u022d = 2.0f;
    private static final float \u0585 = 1.0f;
    private static final String \u03ce = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String \u03d0 = "0123456789abcdefklmnor";
    private final Font \u013b;
    private final Font[] \u0453;
    private final boolean \u018d;
    private final FontRenderContext \u026e;
    private final oce17e1844c5[] \u03d1 = new oce17e1844c5[0xA4737756 ^ 0xA4737656];
    private final Map<Character, oce17e1844c5> \u00f9 = new ConcurrentHashMap<Character, oce17e1844c5>();
    private final float \u04ba;
    private final float \u047d;
    private final float \u0128;
    private final float \u01f0;
    private final float \u04f1;
    private final float \u01bd;
    private boolean \u029a;

    public oc9dc7529f0e(Font font, boolean bl) {
        this(font, bl, 2.0f);
    }

    oc9dc7529f0e(Font font, boolean bl, float f) {
        this(font, bl, f, new Font[0]);
    }

    oc9dc7529f0e(Font font2, boolean bl, float f, Font[] fontArray) {
        float f2 = oc9dc7529f0e.\u0229(f);
        this.\u04ba = 1.0f / f2;
        this.\u047d = f2;
        this.\u013b = font2.deriveFont(font2.getStyle(), Math.max(1.0f, font2.getSize2D() * f2));
        this.\u0453 = (Font[])Arrays.stream(fontArray).map(font -> font.deriveFont(this.\u013b.getSize2D())).toArray(Font[]::new);
        this.\u018d = bl;
        this.\u026e = new FontRenderContext(new AffineTransform(), bl, true);
        this.\u0128 = this.\u03ed();
        this.\u01f0 = this.\u0157();
        this.\u04f1 = Math.max(1.0f, (this.\u01f0 - this.\u0128) * this.\u04ba);
        this.\u01bd = this.\u03c1();
    }

    @Override
    public int z$ao2ykh4tuw6w(String string, float f, float f2, int n, boolean bl) {
        if (this.\u029a || string == null || string.isEmpty()) {
            return 0;
        }
        int n2 = 0;
        if (bl) {
            n2 = this.\u0574(string, f + 0.5f, f2 + 0.5f, n, true);
        }
        return Math.max(n2, this.\u0574(string, f, f2, n, false));
    }

    @Override
    public int z$22eyp2803ejhs(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2, boolean bl) {
        if (this.\u029a || string == null || string.isEmpty()) {
            return 0;
        }
        int n = 0;
        if (bl) {
            n = this.\u01b6(string, f + 0.5f, f2 + 0.5f, ocd9533bdf8b2, true);
        }
        return Math.max(n, this.\u01b6(string, f, f2, ocd9533bdf8b2, false));
    }

    @Override
    public int z$toz8pt08w0nc(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        float f = 0.0f;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (oc9dc7529f0e.\u0536(string, i)) continue;
            if (c == (0xC9A32F6F ^ 0xC9A32FC8) && i + 1 < string.length()) {
                ++i;
                continue;
            }
            if (c == (0xC9A32FC2 ^ 0xC9A32FC8)) continue;
            f += this.\u00ec((char)c).\u027c;
        }
        return Math.round(f);
    }

    @Override
    public int z$1tqmx4tpnr6lq() {
        return Math.round(this.\u04f1);
    }

    @Override
    public int z$3hte9fh87zo6x() {
        return Math.round(this.\u01bd);
    }

    @Override
    public float z$3l314uvjy8lta() {
        return this.\u01bd;
    }

    @Override
    public int z$g5bxucc1j700() {
        return 0;
    }

    @Override
    public int z$w1h9nvoglpkn() {
        return Math.round(this.\u04f1);
    }

    @Override
    public void z$2l4c667g0mutb() {
        if (this.\u029a) {
            return;
        }
        this.\u029a = true;
        oc9dc7529f0e.\u03ce(this.\u03d1);
        for (oce17e1844c5 oce17e1844c52 : this.\u00f9.values()) {
            oc9dc7529f0e.\u0251(oce17e1844c52);
        }
        this.\u00f9.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int \u0574(String string, float f, float f2, int n, boolean bl) {
        float f3;
        int n2 = n >>> (0x2E84E040 ^ 0x2E84E058) & (0x2E84E0A7 ^ 0x2E84E058);
        if (n2 == 0) {
            n2 = 0x2E84E0A7 ^ 0x2E84E058;
        }
        int n3 = bl ? oc9dc7529f0e.\u0393(n) : oc9dc7529f0e.\u00e9(n, n2);
        float f4 = f3 = f * this.\u047d;
        float f5 = f2 * this.\u047d - this.\u0128;
        GL11.glPushMatrix();
        try {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0x2E84E35A ^ 0x2E84E058, 0x2E84E35B ^ 0x2E84E058, 1, 0);
            GlStateManager.enableTexture2D();
            GL11.glTexEnvi(0x2E84C358 ^ 0x2E84E058, 0x2E84C258 ^ 0x2E84E058, 0x2E84C158 ^ 0x2E84E058);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.scale(this.\u04ba, this.\u04ba, 1.0f);
            for (int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                if (oc9dc7529f0e.\u0536(string, i)) continue;
                if (c == (0x2E84E0FF ^ 0x2E84E058) && i + 1 < string.length()) {
                    char c2;
                    int n4;
                    if ((n4 = "0123456789abcdefklmnor".indexOf(c2 = Character.toLowerCase(string.charAt(++i)))) < 0) continue;
                    if (n4 < (0x2E84E048 ^ 0x2E84E058)) {
                        n3 = oc9dc7529f0e.\u0299(n4, n2, bl);
                        continue;
                    }
                    if (c2 != (0x2E84E02A ^ 0x2E84E058)) continue;
                    n3 = bl ? oc9dc7529f0e.\u0393(n) : oc9dc7529f0e.\u00e9(n, n2);
                    continue;
                }
                if (c == (0x2E84E052 ^ 0x2E84E058)) {
                    f4 = f3;
                    f5 += this.\u01bd * this.\u047d;
                    continue;
                }
                oce17e1844c5 oce17e1844c52 = this.\u00ec(c);
                if (oce17e1844c52.\u051f != 0 && oce17e1844c52.p > 0.0f && oce17e1844c52.\u0128 > 0.0f) {
                    this.\u04ad(oce17e1844c52, f4 - 4.0f, f5, n3);
                }
                f4 += oce17e1844c52.\u0282;
            }
        }
        finally {
            GlStateManager.bindTexture(0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GlStateManager.matrixMode(0x2E84F758 ^ 0x2E84E058);
        }
        return Math.round((f4 - f3) * this.\u04ba);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int \u01b6(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2, boolean bl) {
        float f3;
        float f4 = f3 = f * this.\u047d;
        float f5 = f2 * this.\u047d - this.\u0128;
        Integer n = null;
        GL11.glPushMatrix();
        try {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0x6D070B90 ^ 0x6D070892, 0x6D070B91 ^ 0x6D070892, 1, 0);
            GlStateManager.enableTexture2D();
            GL11.glTexEnvi(0x6D072B92 ^ 0x6D070892, 0x6D072A92 ^ 0x6D070892, 0x6D072992 ^ 0x6D070892);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.scale(this.\u04ba, this.\u04ba, 1.0f);
            for (int i = 0; i < string.length(); ++i) {
                int n2;
                char c = string.charAt(i);
                if (oc9dc7529f0e.\u0536(string, i)) continue;
                if (c == (0x6D070835 ^ 0x6D070892) && i + 1 < string.length()) {
                    char c2;
                    if ((n2 = "0123456789abcdefklmnor".indexOf(c2 = Character.toLowerCase(string.charAt(++i)))) >= 0 && n2 < (0x6D070882 ^ 0x6D070892)) {
                        n = oc9dc7529f0e.\u0299(n2, 0x6D07086D ^ 0x6D070892, false);
                        continue;
                    }
                    if (c2 != (0x6D0708E0 ^ 0x6D070892)) continue;
                    n = null;
                    continue;
                }
                if (c == (0x6D070898 ^ 0x6D070892)) {
                    f4 = f3;
                    f5 += this.\u01bd * this.\u047d;
                    continue;
                }
                oce17e1844c5 oce17e1844c52 = this.\u00ec(c);
                n2 = ocd9533bdf8b2.z$151wba1mm8frh(c, (f4 - f3) * this.\u04ba, oce17e1844c52.\u027c, n);
                int n3 = n2 >>> (0x6D07088A ^ 0x6D070892) & (0x6D07086D ^ 0x6D070892);
                if (n3 == 0) {
                    f4 += oce17e1844c52.\u0282;
                    continue;
                }
                n2 = oc9dc7529f0e.\u00e9(n2, n3);
                if (bl) {
                    n2 = oc9dc7529f0e.\u0393(n2);
                }
                if (oce17e1844c52.\u051f != 0 && oce17e1844c52.p > 0.0f && oce17e1844c52.\u0128 > 0.0f) {
                    this.\u04ad(oce17e1844c52, f4 - 4.0f, f5, n2);
                }
                f4 += oce17e1844c52.\u0282;
            }
        }
        finally {
            GlStateManager.bindTexture(0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
            GlStateManager.matrixMode(0x6D071F92 ^ 0x6D070892);
        }
        return Math.round((f4 - f3) * this.\u04ba);
    }

    private void \u04ad(oce17e1844c5 oce17e1844c52, float f, float f2, int n) {
        GlStateManager.bindTexture(oce17e1844c52.\u051f);
        float f3 = (float)(n >>> (0x7E68FBDA ^ 0x7E68FBC2) & (0x7E68FB3D ^ 0x7E68FBC2)) / 255.0f;
        float f4 = (float)(n >>> (0x7E68FBD2 ^ 0x7E68FBC2) & (0x7E68FB3D ^ 0x7E68FBC2)) / 255.0f;
        float f5 = (float)(n >>> (0x7E68FBCA ^ 0x7E68FBC2) & (0x7E68FB3D ^ 0x7E68FBC2)) / 255.0f;
        float f6 = (float)(n & (0x7E68FB3D ^ 0x7E68FBC2)) / 255.0f;
        GlStateManager.color(f4, f5, f6, f3);
        GL11.glBegin(0x7E68FBC5 ^ 0x7E68FBC2);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(f, f2);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(f, f2 + oce17e1844c52.\u0128);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(f + oce17e1844c52.p, f2 + oce17e1844c52.\u0128);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(f + oce17e1844c52.p, f2);
        oc170ea29aae.\u0177();
    }

    private oce17e1844c5 \u00ec(char c) {
        if (c >= '\u0000' && c <= (0x5284E5A3 ^ 0x5284E55C)) {
            oce17e1844c5 oce17e1844c52 = this.\u03d1[c];
            if (oce17e1844c52 == null) {
                this.\u03d1[c] = oce17e1844c52 = this.p(c);
            }
            return oce17e1844c52;
        }
        return this.\u00f9.computeIfAbsent(Character.valueOf(c), this::p);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private oce17e1844c5 p(char c) {
        if (this.\u029a) {
            return new oce17e1844c5(0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0);
        }
        if (Character.isISOControl(c) && c != (0xE8C5BD7F ^ 0xE8C5BD75)) {
            return new oce17e1844c5(0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0);
        }
        Font font = this.\u013b;
        if (!font.canDisplay(c)) {
            for (Font font2 : this.\u0453) {
                if (!font2.canDisplay(c)) continue;
                font = font2;
                break;
            }
        }
        String string = String.valueOf(c);
        BufferedImage bufferedImage = new BufferedImage(1, 1, 0xE8C5BD77 ^ 0xE8C5BD75);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        try {
            graphics2D.setFont(font);
            this.\u0235(graphics2D);
            FontMetrics fontMetrics = graphics2D.getFontMetrics();
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(string, graphics2D);
            float f = Math.max(1.0f, (float)rectangle2D.getWidth());
            int n = Math.max(1, (int)Math.ceil(f) + (0xE8C5BD7D ^ 0xE8C5BD75));
            int n2 = Math.max(1, fontMetrics.getHeight());
            BufferedImage bufferedImage2 = new BufferedImage(n, n2, 0xE8C5BD77 ^ 0xE8C5BD75);
            Graphics2D graphics2D2 = bufferedImage2.createGraphics();
            try {
                graphics2D2.setFont(font);
                graphics2D2.setBackground(new Color(0xE8C5BD8A ^ 0xE8C5BD75, 0xE8C5BD8A ^ 0xE8C5BD75, 0xE8C5BD8A ^ 0xE8C5BD75, 0));
                graphics2D2.clearRect(0, 0, n, n2);
                graphics2D2.setColor(Color.WHITE);
                this.\u0235(graphics2D2);
                graphics2D2.drawString(string, 0xE8C5BD71 ^ 0xE8C5BD75, fontMetrics.getAscent());
            }
            finally {
                graphics2D2.dispose();
            }
            int n3 = this.\u03c8(bufferedImage2);
            int[] nArray = oc9dc7529f0e.\u017d(bufferedImage2);
            oce17e1844c5 oce17e1844c52 = new oce17e1844c5(n3, n, n2, f, f * this.\u04ba, nArray[0], nArray[1]);
            return oce17e1844c52;
        }
        finally {
            graphics2D.dispose();
        }
    }

    private int \u03c8(BufferedImage bufferedImage) {
        int n;
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        int[] nArray = bufferedImage.getRGB(0, 0, n2, n3, new int[n2 * n3], 0, n2);
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(n2 * n3 * (0x6C29A7B8 ^ 0x6C29A7BC));
        for (n = 0; n < n3; ++n) {
            for (int i = 0; i < n2; ++i) {
                int n4 = nArray[i + n * n2];
                byteBuffer.put((byte)(n4 >> (0x6C29A7AC ^ 0x6C29A7BC) & (0x6C29A743 ^ 0x6C29A7BC)));
                byteBuffer.put((byte)(n4 >> (0x6C29A7B4 ^ 0x6C29A7BC) & (0x6C29A743 ^ 0x6C29A7BC)));
                byteBuffer.put((byte)(n4 & (0x6C29A743 ^ 0x6C29A7BC)));
                byteBuffer.put((byte)(n4 >> (0x6C29A7A4 ^ 0x6C29A7BC) & (0x6C29A743 ^ 0x6C29A7BC)));
            }
        }
        ((Buffer)byteBuffer).flip();
        n = GL11.glGenTextures();
        GlStateManager.bindTexture(n);
        GL11.glTexParameteri(0x6C29AA5D ^ 0x6C29A7BC, 0x6C298FBD ^ 0x6C29A7BC, 0x6C2981BD ^ 0x6C29A7BC);
        GL11.glTexParameteri(0x6C29AA5D ^ 0x6C29A7BC, 0x6C298FBC ^ 0x6C29A7BC, 0x6C2981BD ^ 0x6C29A7BC);
        GL11.glTexImage2D(0x6C29AA5D ^ 0x6C29A7BC, 0, 0x6C29BEB4 ^ 0x6C29A7BC, n2, n3, 0, 0x6C29BEB4 ^ 0x6C29A7BC, 0x6C29B3BD ^ 0x6C29A7BC, byteBuffer);
        return n;
    }

    private float \u03ed() {
        float f = Float.MAX_VALUE;
        for (int i = 0; i < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length(); ++i) {
            oce17e1844c5 oce17e1844c52 = this.\u00ec("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(i));
            if (!oce17e1844c52.\u03b8()) continue;
            f = Math.min(f, (float)oce17e1844c52.\u03b0);
        }
        return f == Float.MAX_VALUE ? 0.0f : f;
    }

    private float \u0157() {
        float f = 0.0f;
        for (int i = 0; i < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length(); ++i) {
            oce17e1844c5 oce17e1844c52 = this.\u00ec("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(i));
            if (!oce17e1844c52.\u03b8()) continue;
            f = Math.max(f, (float)oce17e1844c52.\u016b);
        }
        if (f <= 0.0f) {
            return Math.max(1.0f, this.\u013b.getSize2D());
        }
        return f;
    }

    private float \u03c1() {
        return Math.max(this.\u04f1, (float)this.\u013b.getStringBounds("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", this.\u026e).getHeight() * this.\u04ba);
    }

    private static int[] \u017d(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int n3 = -1;
        int n4 = -1;
        block0: for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((bufferedImage.getRGB(j, i) >>> (0x54585383 ^ 0x5458539B) & (0x54585364 ^ 0x5458539B)) == 0) continue;
                if (n3 == -1) {
                    n3 = i;
                }
                n4 = i + 1;
                continue block0;
            }
        }
        if (n3 == -1) {
            int[] nArray = new int[0x54585399 ^ 0x5458539B];
            nArray[0] = 0;
            nArray[1] = 0;
            return nArray;
        }
        int[] nArray = new int[0x54585399 ^ 0x5458539B];
        nArray[0] = n3;
        nArray[1] = n4;
        return nArray;
    }

    private static float \u0229(float f) {
        Minecraft minecraft = Minecraft.getMinecraft();
        int n = 1;
        try {
            n = Math.max(1, new ScaledResolution(minecraft).getScaleFactor());
        }
        catch (Exception exception) {
            // empty catch block
        }
        return oc9dc7529f0e.\u04df(n, f);
    }

    static float \u04df(int n, float f) {
        float f2 = Float.isNaN(f) || Float.isInfinite(f) ? 2.0f : Math.max(2.0f, f);
        return Math.max(f2, (float)Math.max(1, n) * 1.0f);
    }

    private void \u0235(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, this.\u018d ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, this.\u018d ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    private static void \u03ce(oce17e1844c5[] oce17e1844c5Array) {
        for (int i = 0; i < oce17e1844c5Array.length; ++i) {
            oc9dc7529f0e.\u0251(oce17e1844c5Array[i]);
        }
    }

    private static void \u0251(oce17e1844c5 oce17e1844c52) {
        if (oce17e1844c52 != null && oce17e1844c52.\u051f != 0) {
            GL11.glDeleteTextures(oce17e1844c52.\u051f);
        }
    }

    private static int \u0299(int n, int n2, boolean bl) {
        int n3 = (n >> (0xD459BFDA ^ 0xD459BFD9) & 1) * (0xD459BF8C ^ 0xD459BFD9);
        int n4 = (n >> (0xD459BFDB ^ 0xD459BFD9) & 1) * (0xD459BF73 ^ 0xD459BFD9) + n3;
        int n5 = (n >> 1 & 1) * (0xD459BF73 ^ 0xD459BFD9) + n3;
        int n6 = (n & 1) * (0xD459BF73 ^ 0xD459BFD9) + n3;
        if (n == (0xD459BFDF ^ 0xD459BFD9)) {
            n4 += 85;
        }
        if (bl) {
            n4 /= 0xD459BFDD ^ 0xD459BFD9;
            n5 /= 0xD459BFDD ^ 0xD459BFD9;
            n6 /= 0xD459BFDD ^ 0xD459BFD9;
        }
        return n2 << (0xD459BFC1 ^ 0xD459BFD9) | n4 << (0xD459BFC9 ^ 0xD459BFD9) | n5 << (0xD459BFD1 ^ 0xD459BFD9) | n6;
    }

    private static int \u0393(int n) {
        int n2 = n >>> (0x44A4685 ^ 0x44A469D) & (0x44A4662 ^ 0x44A469D);
        if (n2 == 0) {
            n2 = 0x44A4662 ^ 0x44A469D;
        }
        int n3 = (n >>> (0x44A468D ^ 0x44A469D) & (0x44A4662 ^ 0x44A469D)) / (0x44A4699 ^ 0x44A469D);
        int n4 = (n >>> (0x44A4695 ^ 0x44A469D) & (0x44A4662 ^ 0x44A469D)) / (0x44A4699 ^ 0x44A469D);
        int n5 = (n & (0x44A4662 ^ 0x44A469D)) / (0x44A4699 ^ 0x44A469D);
        return n2 << (0x44A4685 ^ 0x44A469D) | n3 << (0x44A468D ^ 0x44A469D) | n4 << (0x44A4695 ^ 0x44A469D) | n5;
    }

    private static int \u00e9(int n, int n2) {
        return n2 << (0x54E1CF91 ^ 0x54E1CF89) | n & (0x541E3076 ^ 0x54E1CF89);
    }

    private static boolean \u0536(String string, int n) {
        if (!oc9dc7529f0e.\u014a(string.charAt(n))) {
            return false;
        }
        for (int i = n + 1; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == (0x85D8F985 ^ 0x85D8F922)) {
                return true;
            }
            if (oc9dc7529f0e.\u014a(c)) continue;
            return false;
        }
        return false;
    }

    private static boolean \u014a(char c) {
        return c == (0x397848D ^ 0x397844F) || c == (0x397848C ^ 0x397844F) || c == (0x39784CD ^ 0x397844F) || c == (0x397A455 ^ 0x397844F);
    }
}

