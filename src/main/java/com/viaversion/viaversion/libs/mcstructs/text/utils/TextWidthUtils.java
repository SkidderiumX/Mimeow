/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class TextWidthUtils {
    private static float[] charWidths = null;

    private static void loadCharWidths() {
        if (charWidths == null) {
            InputStream inputStream2 = TextUtils.class.getResourceAsStream("/mcstructs/text/charwidths.bin");
            if (inputStream2 == null) {
                throw new IllegalStateException("Could not find charwidths.bin");
            }
            try (GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream2);){
                charWidths = new float[gZIPInputStream.read() << 24 | gZIPInputStream.read() << 16 | gZIPInputStream.read() << 8 | gZIPInputStream.read()];
                for (int i = 0; i < charWidths.length; ++i) {
                    TextWidthUtils.charWidths[i] = gZIPInputStream.read();
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("Failed to read char widths", iOException);
            }
        }
    }

    public static float[] getCharWidths() {
        TextWidthUtils.loadCharWidths();
        return charWidths;
    }

    public static float getCharWidth(char c, float f, boolean bl) {
        TextWidthUtils.loadCharWidths();
        if (c > charWidths.length) {
            return 0.0f;
        }
        return charWidths[c] + (bl ? f : 0.0f);
    }

    public static float getComponentWidth(TextComponent textComponent) {
        TextWidthUtils.loadCharWidths();
        return TextWidthUtils.getComponentWidth(textComponent, charWidths, 1.0f);
    }

    public static float getComponentWidth(TextComponent textComponent, float[] fArray) {
        return TextWidthUtils.getComponentWidth(textComponent, fArray, 1.0f);
    }

    public static float getComponentWidth(TextComponent textComponent2, float[] fArray, float f) {
        float[] fArray2 = new float[]{0.0f};
        textComponent2.forEach(textComponent -> {
            char[] cArray;
            for (char c : cArray = textComponent.asSingleString().toCharArray()) {
                fArray[0] = fArray2[0] + (c >= fArray.length ? 0.0f : fArray[c]);
            }
            if (textComponent.getStyle().isBold()) {
                fArray[0] = fArray2[0] + f * (float)cArray.length;
            }
        });
        return fArray2[0];
    }
}

