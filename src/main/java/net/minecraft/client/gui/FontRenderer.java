/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import x.oc040fe9e89e;
import x.oc170ea29aae;
import x.oc9755810e45;
import x.oce92bff16e0;
import x.oced29a282d7;

public class FontRenderer
implements IResourceManagerReloadListener {
    private static final ResourceLocation[] unicodePageLocations = new ResourceLocation[256];
    private int[] charWidth = new int[256];
    public int FONT_HEIGHT = 9;
    public Random fontRandom = new Random();
    private byte[] glyphWidth = new byte[65536];
    private int[] colorCode = new int[32];
    private final ResourceLocation locationFontTexture;
    private final TextureManager renderEngine;
    private float posX;
    private float posY;
    private boolean unicodeFlag;
    private boolean bidiFlag;
    private float red;
    private float blue;
    private float green;
    private float alpha;
    private int textColor;
    private boolean randomStyle;
    private boolean boldStyle;
    private boolean italicStyle;
    private boolean underlineStyle;
    private boolean strikethroughStyle;
    private Map<Integer, int[]> smoothFontTextures;

    public FontRenderer(GameSettings gameSettings, ResourceLocation resourceLocation, TextureManager textureManager, boolean bl) {
        this.locationFontTexture = resourceLocation;
        this.renderEngine = textureManager;
        this.unicodeFlag = bl;
        textureManager.bindTexture(this.locationFontTexture);
        for (int i = 0; i < 32; ++i) {
            int n = (i >> 3 & 1) * 85;
            int n2 = (i >> 2 & 1) * 170 + n;
            int n3 = (i >> 1 & 1) * 170 + n;
            int n4 = (i >> 0 & 1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (gameSettings.anaglyph) {
                int n5 = (n2 * 30 + n3 * 59 + n4 * 11) / 100;
                int n6 = (n2 * 30 + n3 * 70) / 100;
                int n7 = (n2 * 30 + n4 * 70) / 100;
                n2 = n5;
                n3 = n6;
                n4 = n7;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this.colorCode[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
        }
        this.readGlyphSizes();
    }

    @Override
    public void onResourceManagerReload(IResourceManager iResourceManager) {
        this.readFontTexture();
    }

    private void readFontTexture() {
        BufferedImage bufferedImage;
        try {
            bufferedImage = TextureUtil.readBufferedImage(Minecraft.getMinecraft().getResourceManager().getResource(this.locationFontTexture).getInputStream());
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        int n3 = n2 / 16;
        int n4 = n / 16;
        int n5 = 1;
        float f = 8.0f / (float)n4;
        for (int i = 0; i < 256; ++i) {
            int n6;
            int n7 = i % 16;
            int n8 = i / 16;
            if (i == 32) {
                this.charWidth[i] = 3 + n5;
            }
            for (n6 = n4 - 1; n6 >= 0; --n6) {
                int n9 = n7 * n4 + n6;
                boolean bl = true;
                for (int j = 0; j < n3 && bl; ++j) {
                    int n10 = (n8 * n4 + j) * n;
                    if ((nArray[n9 + n10] >> 24 & 0xFF) == 0) continue;
                    bl = false;
                }
                if (!bl) break;
            }
            this.charWidth[i] = (int)(0.5 + (double)((float)(++n6) * f)) + n5;
        }
    }

    private void readGlyphSizes() {
        InputStream inputStream2 = null;
        try {
            inputStream2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("font/glyph_sizes.bin")).getInputStream();
            inputStream2.read(this.glyphWidth);
        }
        catch (IOException iOException) {
            try {
                throw new RuntimeException(iOException);
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(inputStream2);
                throw throwable;
            }
        }
        IOUtils.closeQuietly(inputStream2);
    }

    private float renderChar(char c, boolean bl) {
        if (c == ' ') {
            return 4.0f;
        }
        int n = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c);
        return n != -1 && !this.unicodeFlag ? this.renderDefaultChar(n, bl) : this.renderUnicodeChar(c, bl);
    }

    private float renderDefaultChar(int n, boolean bl) {
        int n2 = n % 16 * 8;
        int n3 = n / 16 * 8;
        boolean bl2 = bl;
        this.bindFontTexture(this.locationFontTexture);
        int n4 = this.charWidth[n];
        float f = (float)n4 - 0.01f;
        GL11.glBegin(5);
        GL11.glTexCoord2f((float)n2 / 128.0f, (float)n3 / 128.0f);
        GL11.glVertex3f(this.posX + (float)bl2, this.posY, 0.0f);
        GL11.glTexCoord2f((float)n2 / 128.0f, ((float)n3 + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX - (float)bl2, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f(((float)n2 + f - 1.0f) / 128.0f, (float)n3 / 128.0f);
        GL11.glVertex3f(this.posX + f - 1.0f + (float)bl2, this.posY, 0.0f);
        GL11.glTexCoord2f(((float)n2 + f - 1.0f) / 128.0f, ((float)n3 + 7.99f) / 128.0f);
        GL11.glVertex3f(this.posX + f - 1.0f - (float)bl2, this.posY + 7.99f, 0.0f);
        oc170ea29aae.\u0177();
        return n4;
    }

    private ResourceLocation getUnicodePageLocation(int n) {
        if (unicodePageLocations[n] == null) {
            FontRenderer.unicodePageLocations[n] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", n));
        }
        return unicodePageLocations[n];
    }

    private void loadGlyphTexture(int n) {
        this.bindFontTexture(this.getUnicodePageLocation(n));
    }

    private void bindFontTexture(ResourceLocation resourceLocation) {
        this.renderEngine.bindTexture(resourceLocation);
        if (this.smoothFontTextures == null) {
            return;
        }
        int n = GlStateManager.getBoundTexture();
        if (!this.smoothFontTextures.containsKey(n)) {
            this.smoothFontTextures.put(n, new int[]{GL11.glGetTexParameteri(3553, 10241), GL11.glGetTexParameteri(3553, 10240)});
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int withSmoothFont(IntSupplier intSupplier) {
        if (this.smoothFontTextures != null) {
            return intSupplier.getAsInt();
        }
        GlAlphaState glAlphaState = new GlAlphaState();
        GlBlendState glBlendState = new GlBlendState();
        GlStateManager.getAlphaState(glAlphaState);
        GlStateManager.getBlendState(glBlendState);
        this.smoothFontTextures = new LinkedHashMap<Integer, int[]>();
        try {
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 771);
            int n = intSupplier.getAsInt();
            return n;
        }
        finally {
            int n = GlStateManager.getBoundTexture();
            for (Map.Entry<Integer, int[]> entry : this.smoothFontTextures.entrySet()) {
                GlStateManager.bindTexture(entry.getKey());
                GL11.glTexParameteri(3553, 10241, entry.getValue()[0]);
                GL11.glTexParameteri(3553, 10240, entry.getValue()[1]);
            }
            GlStateManager.bindTexture(n);
            this.smoothFontTextures = null;
            GlStateManager.setAlphaState(glAlphaState);
            GlStateManager.setBlendState(glBlendState);
        }
    }

    private float renderUnicodeChar(char c, boolean bl) {
        if (this.glyphWidth[c] == 0) {
            return 0.0f;
        }
        int n = c / 256;
        this.loadGlyphTexture(n);
        int n2 = this.glyphWidth[c] >>> 4;
        int n3 = this.glyphWidth[c] & 0xF;
        float f = n2;
        float f2 = n3 + 1;
        float f3 = (float)(c % 16 * 16) + f;
        float f4 = (c & 0xFF) / 16 * 16;
        float f5 = f2 - f - 0.02f;
        float f6 = bl ? 1.0f : 0.0f;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f3 / 256.0f, f4 / 256.0f);
        GL11.glVertex3f(this.posX + f6, this.posY, 0.0f);
        GL11.glTexCoord2f(f3 / 256.0f, (f4 + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX - f6, this.posY + 7.99f, 0.0f);
        GL11.glTexCoord2f((f3 + f5) / 256.0f, f4 / 256.0f);
        GL11.glVertex3f(this.posX + f5 / 2.0f + f6, this.posY, 0.0f);
        GL11.glTexCoord2f((f3 + f5) / 256.0f, (f4 + 15.98f) / 256.0f);
        GL11.glVertex3f(this.posX + f5 / 2.0f - f6, this.posY + 7.99f, 0.0f);
        oc170ea29aae.\u0177();
        return (f2 - f) / 2.0f + 1.0f;
    }

    public int drawStringWithShadow(String string, float f, float f2, int n) {
        return this.drawString(string, f, f2, n, true);
    }

    public int drawString(String string, int n, int n2, int n3) {
        return this.drawString(string, n, n2, n3, false);
    }

    public int drawString(String string, float f, float f2, int n, boolean bl) {
        int n2;
        GlStateManager.enableAlpha();
        this.resetStyles();
        if (bl) {
            n2 = this.renderString(string, f + 1.0f, f2 + 1.0f, n, true);
            n2 = Math.max(n2, this.renderString(string, f, f2, n, false));
        } else {
            n2 = this.renderString(string, f, f2, n, false);
        }
        return n2;
    }

    private String bidiReorder(String string) {
        try {
            Bidi bidi = new Bidi(new ArabicShaping(8).shape(string), 127);
            bidi.setReorderingMode(0);
            return bidi.writeReordered(2);
        }
        catch (ArabicShapingException arabicShapingException) {
            return string;
        }
    }

    private void resetStyles() {
        this.randomStyle = false;
        this.boldStyle = false;
        this.italicStyle = false;
        this.underlineStyle = false;
        this.strikethroughStyle = false;
    }

    private void renderStringAtPos(String string, boolean bl) {
        for (int i = 0; i < string.length(); ++i) {
            WorldRenderer worldRenderer;
            Tessellator tessellator;
            char c;
            int n;
            int n2;
            char c2 = string.charAt(i);
            if (c2 == '\u00a7' && i + 1 < string.length()) {
                n2 = "0123456789abcdefklmnor".indexOf(Character.toLowerCase(string.charAt(i + 1)));
                if (n2 < 16) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    if (n2 < 0 || n2 > 15) {
                        n2 = 15;
                    }
                    if (bl) {
                        n2 += 16;
                    }
                    this.textColor = n = this.colorCode[n2];
                    GlStateManager.color((float)(n >> 16) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, this.alpha);
                } else if (n2 == 16) {
                    this.randomStyle = true;
                } else if (n2 == 17) {
                    this.boldStyle = true;
                } else if (n2 == 18) {
                    this.strikethroughStyle = true;
                } else if (n2 == 19) {
                    this.underlineStyle = true;
                } else if (n2 == 20) {
                    this.italicStyle = true;
                } else if (n2 == 21) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    GlStateManager.color(this.red, this.blue, this.green, this.alpha);
                }
                ++i;
                continue;
            }
            n2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c2);
            if (this.randomStyle && n2 != -1) {
                n = this.getCharWidth(c2);
                while (n != this.getCharWidth(c = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".charAt(n2 = this.fontRandom.nextInt("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".length())))) {
                }
                c2 = c;
            }
            float f = this.unicodeFlag ? 0.5f : 1.0f;
            char c3 = c = (c2 == '\u0000' || n2 == -1 || this.unicodeFlag) && bl ? (char)'\u0001' : '\u0000';
            if (c != '\u0000') {
                this.posX -= f;
                this.posY -= f;
            }
            float f2 = this.renderChar(c2, this.italicStyle);
            if (c != '\u0000') {
                this.posX += f;
                this.posY += f;
            }
            if (this.boldStyle) {
                this.posX += f;
                if (c != '\u0000') {
                    this.posX -= f;
                    this.posY -= f;
                }
                this.renderChar(c2, this.italicStyle);
                this.posX -= f;
                if (c != '\u0000') {
                    this.posX += f;
                    this.posY += f;
                }
                f2 += 1.0f;
            }
            if (this.strikethroughStyle) {
                tessellator = Tessellator.getInstance();
                worldRenderer = tessellator.getWorldRenderer();
                GlStateManager.disableTexture2D();
                worldRenderer.begin(7, DefaultVertexFormats.POSITION);
                worldRenderer.pos(this.posX, this.posY + (float)(this.FONT_HEIGHT / 2), 0.0).endVertex();
                worldRenderer.pos(this.posX + f2, this.posY + (float)(this.FONT_HEIGHT / 2), 0.0).endVertex();
                worldRenderer.pos(this.posX + f2, this.posY + (float)(this.FONT_HEIGHT / 2) - 1.0f, 0.0).endVertex();
                worldRenderer.pos(this.posX, this.posY + (float)(this.FONT_HEIGHT / 2) - 1.0f, 0.0).endVertex();
                tessellator.draw();
                GlStateManager.enableTexture2D();
            }
            if (this.underlineStyle) {
                tessellator = Tessellator.getInstance();
                worldRenderer = tessellator.getWorldRenderer();
                GlStateManager.disableTexture2D();
                worldRenderer.begin(7, DefaultVertexFormats.POSITION);
                int n3 = this.underlineStyle ? -1 : 0;
                worldRenderer.pos(this.posX + (float)n3, this.posY + (float)this.FONT_HEIGHT, 0.0).endVertex();
                worldRenderer.pos(this.posX + f2, this.posY + (float)this.FONT_HEIGHT, 0.0).endVertex();
                worldRenderer.pos(this.posX + f2, this.posY + (float)this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
                worldRenderer.pos(this.posX + (float)n3, this.posY + (float)this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
                tessellator.draw();
                GlStateManager.enableTexture2D();
            }
            this.posX += (float)((int)f2);
        }
    }

    private int renderStringAligned(String string, int n, int n2, int n3, int n4, boolean bl) {
        if (this.bidiFlag) {
            int n5 = this.getStringWidth(this.bidiReorder(string));
            n = n + n3 - n5;
        }
        return this.renderString(string, n, n2, n4, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int renderString(String string, float f, float f2, int n, boolean bl) {
        if ((string = this.mimeow$modify$renderString(string)) == null) {
            return 0;
        }
        if (this.bidiFlag) {
            string = this.bidiReorder(string);
        }
        if ((n & 0xFC000000) == 0) {
            n |= 0xFF000000;
        }
        if (bl) {
            n = (n & 0xFCFCFC) >> 2 | n & 0xFF000000;
        }
        this.red = (float)(n >> 16 & 0xFF) / 255.0f;
        this.blue = (float)(n >> 8 & 0xFF) / 255.0f;
        this.green = (float)(n & 0xFF) / 255.0f;
        this.alpha = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.color(this.red, this.blue, this.green, this.alpha);
        this.posX = f;
        this.posY = f2;
        oc040fe9e89e oc040fe9e89e2 = oc170ea29aae.\u03c7(oc040fe9e89e.\u0291);
        try {
            this.renderStringAtPos(string, bl);
        }
        finally {
            oc170ea29aae.\u03c9(oc040fe9e89e2);
        }
        return (int)this.posX;
    }

    public int getStringWidth(String string) {
        if ((string = this.mimeow$modify$getStringWidth(string)) == null) {
            return 0;
        }
        int n = 0;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            int n2 = this.getCharWidth(c);
            if (n2 < 0 && i < string.length() - 1) {
                if ((c = string.charAt(++i)) != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl = false;
                    }
                } else {
                    bl = true;
                }
                n2 = 0;
            }
            n += n2;
            if (!bl || n2 <= 0) continue;
            ++n;
        }
        return n;
    }

    public int getCharWidth(char c) {
        if (c == '\u00a7') {
            return -1;
        }
        if (c == ' ') {
            return 4;
        }
        int n = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c);
        if (c > '\u0000' && n != -1 && !this.unicodeFlag) {
            return this.charWidth[n];
        }
        if (this.glyphWidth[c] != 0) {
            int n2 = this.glyphWidth[c] >>> 4;
            int n3 = this.glyphWidth[c] & 0xF;
            if (n3 > 7) {
                n3 = 15;
                n2 = 0;
            }
            return (++n3 - n2) / 2 + 1;
        }
        return 0;
    }

    public String trimStringToWidth(String string, int n) {
        return this.trimStringToWidth(string, n, false);
    }

    public String trimStringToWidth(String string, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = bl ? string.length() - 1 : 0;
        int n4 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n3; i >= 0 && i < string.length() && n2 < n; i += n4) {
            char c = string.charAt(i);
            int n5 = this.getCharWidth(c);
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (n5 < 0) {
                bl2 = true;
            } else {
                n2 += n5;
                if (bl3) {
                    ++n2;
                }
            }
            if (n2 > n) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private String trimStringNewline(String string) {
        while (string != null && string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public void drawSplitString(String string, int n, int n2, int n3, int n4) {
        this.resetStyles();
        this.textColor = n4;
        string = this.trimStringNewline(string);
        this.renderSplitString(string, n, n2, n3, false);
    }

    private void renderSplitString(String string, int n, int n2, int n3, boolean bl) {
        for (String string2 : this.listFormattedStringToWidth(string, n3)) {
            this.renderStringAligned(string2, n, n2, n3, this.textColor, bl);
            n2 += this.FONT_HEIGHT;
        }
    }

    public int splitStringWidth(String string, int n) {
        return this.FONT_HEIGHT * this.listFormattedStringToWidth(string, n).size();
    }

    public void setUnicodeFlag(boolean bl) {
        this.unicodeFlag = bl;
    }

    public boolean getUnicodeFlag() {
        return this.unicodeFlag;
    }

    public void setBidiFlag(boolean bl) {
        this.bidiFlag = bl;
    }

    public List<String> listFormattedStringToWidth(String string, int n) {
        return Arrays.asList(this.wrapFormattedStringToWidth(string, n).split("\n"));
    }

    String wrapFormattedStringToWidth(String string, int n) {
        int n2 = this.sizeStringToWidth(string, n);
        if (string.length() <= n2) {
            return string;
        }
        String string2 = string.substring(0, n2);
        char c = string.charAt(n2);
        boolean bl = c == ' ' || c == '\n';
        String string3 = FontRenderer.getFormatFromString(string2) + string.substring(n2 + (bl ? 1 : 0));
        return string2 + "\n" + this.wrapFormattedStringToWidth(string3, n);
    }

    private int sizeStringToWidth(String string, int n) {
        int n2;
        int n3 = string.length();
        int n4 = 0;
        int n5 = -1;
        boolean bl = false;
        for (n2 = 0; n2 < n3; ++n2) {
            char c = string.charAt(n2);
            switch (c) {
                case '\n': {
                    --n2;
                    break;
                }
                case ' ': {
                    n5 = n2;
                }
                default: {
                    n4 += this.getCharWidth(c);
                    if (!bl) break;
                    ++n4;
                    break;
                }
                case '\u00a7': {
                    char c2;
                    if (n2 >= n3 - 1) break;
                    if ((c2 = string.charAt(++n2)) != 'l' && c2 != 'L') {
                        if (c2 != 'r' && c2 != 'R' && !FontRenderer.isFormatColor(c2)) break;
                        bl = false;
                        break;
                    }
                    bl = true;
                }
            }
            if (c == '\n') {
                n5 = ++n2;
                break;
            }
            if (n4 > n) break;
        }
        return n2 != n3 && n5 != -1 && n5 < n2 ? n5 : n2;
    }

    private static boolean isFormatColor(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    private static boolean isFormatSpecial(char c) {
        return c >= 'k' && c <= 'o' || c >= 'K' && c <= 'O' || c == 'r' || c == 'R';
    }

    public static String getFormatFromString(String string) {
        Object object = "";
        int n = -1;
        int n2 = string.length();
        while ((n = string.indexOf(167, n + 1)) != -1) {
            if (n >= n2 - 1) continue;
            char c = string.charAt(n + 1);
            if (FontRenderer.isFormatColor(c)) {
                object = "\u00a7" + c;
                continue;
            }
            if (!FontRenderer.isFormatSpecial(c)) continue;
            object = (String)object + "\u00a7" + c;
        }
        return object;
    }

    public boolean getBidiFlag() {
        return this.bidiFlag;
    }

    public int getColorCode(char c) {
        return this.colorCode["0123456789abcdef".indexOf(c)];
    }

    private String mimeow$modify$renderString(String string) {
        if (string == null) {
            return null;
        }
        if (oc9755810e45.\u03c8 != null && oc9755810e45.\u03c8.z$3rzb3dil7uydr()) {
            string = oced29a282d7.\u0377(string);
        }
        if (oc9755810e45.\u04f2 != null && oc9755810e45.\u04f2.z$3rzb3dil7uydr()) {
            string = oce92bff16e0.\u045e(string);
        }
        return string;
    }

    private String mimeow$modify$getStringWidth(String string) {
        if (string == null) {
            return null;
        }
        if (oc9755810e45.\u03c8 != null && oc9755810e45.\u03c8.z$3rzb3dil7uydr()) {
            string = oced29a282d7.\u0377(string);
        }
        if (oc9755810e45.\u04f2 != null && oc9755810e45.\u04f2.z$3rzb3dil7uydr()) {
            string = oce92bff16e0.\u045e(string);
        }
        return string;
    }
}

