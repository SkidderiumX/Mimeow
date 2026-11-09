/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import keystrokesmod.script.ScriptDefaults;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import x.oc3fe2a46456;

public class Image {
    private static HashMap<String, BufferedImage> imageCache = new HashMap();
    public String url;
    public BufferedImage bufferedImage;
    public int height;
    public int width;
    public int textureId = -1;
    public boolean cached;

    public Image(String string, boolean bl) {
        BufferedImage bufferedImage;
        this.url = string;
        this.cached = bl;
        BufferedImage bufferedImage2 = bufferedImage = bl ? imageCache.get(string) : null;
        if (bufferedImage == null) {
            ScriptDefaults.client.async(() -> {
                BufferedImage bufferedImage_r = oc3fe2a46456.\u0501(string);
                if (bufferedImage_r != null) {
                    this.bufferedImage = bufferedImage_r;
                    this.height = bufferedImage_r.getHeight();
                    this.width = bufferedImage_r.getWidth();
                    if (bl) {
                        imageCache.put(string, bufferedImage_r);
                    }
                }
            });
        } else {
            this.bufferedImage = bufferedImage;
            this.height = bufferedImage.getHeight();
            this.width = bufferedImage.getWidth();
        }
    }

    public float[] getDimensions() {
        int n = new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor();
        float[] fArray = new float[0x2BD473B5 ^ 0x2BD473B7];
        fArray[0] = this.width / n;
        fArray[1] = this.height / n;
        return fArray;
    }

    public boolean isLoaded() {
        return this.bufferedImage != null;
    }

    public static void clearCache() {
        imageCache.clear();
    }

    public String toString() {
        String string = this.url;
        int n = this.width;
        int n2 = this.height;
        return "Image(" + n2 + "," + n + "," + string + ")";
    }
}

