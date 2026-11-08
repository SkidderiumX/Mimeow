/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;

public class TextColorUtils {
    public static TextComponent gradient(String string, TextFormatting ... textFormattingArray) {
        if (textFormattingArray.length == 0) {
            return new StringComponent(string);
        }
        if (textFormattingArray.length == 1) {
            return new StringComponent(string).setStyle(new Style().setFormatting(textFormattingArray[0]));
        }
        StringComponent stringComponent = new StringComponent("");
        float[] fArray = new float[textFormattingArray.length];
        for (int i = 0; i < textFormattingArray.length; ++i) {
            fArray[i] = (float)i / (float)(textFormattingArray.length - 1);
        }
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            float f = (float)i / (float)(cArray.length - 1);
            int n = 0;
            int n2 = 0;
            for (int j = 0; j < textFormattingArray.length - 1; ++j) {
                if (!(f >= fArray[j]) || !(f <= fArray[j + 1])) continue;
                n = j;
                n2 = j + 1;
                break;
            }
            float f2 = (f - fArray[n]) / (fArray[n2] - fArray[n]);
            int n3 = TextColorUtils.interpolate(textFormattingArray[n], textFormattingArray[n2], f2);
            stringComponent.append(new StringComponent(String.valueOf(cArray[i])).setStyle(new Style().setColor(n3)));
        }
        return stringComponent;
    }

    public static TextComponent rainbow(String string) {
        return TextColorUtils.gradient(string, new TextFormatting(0xFF0000), new TextFormatting(0xFFFF00), new TextFormatting(65280), new TextFormatting(65535), new TextFormatting(255), new TextFormatting(0xFF00FF), new TextFormatting(0xFF0000));
    }

    private static int interpolate(TextFormatting textFormatting, TextFormatting textFormatting2, float f) {
        int n = textFormatting.getRgbValue() >> 16 & 0xFF;
        int n2 = textFormatting.getRgbValue() >> 8 & 0xFF;
        int n3 = textFormatting.getRgbValue() & 0xFF;
        int n4 = textFormatting2.getRgbValue() >> 16 & 0xFF;
        int n5 = textFormatting2.getRgbValue() >> 8 & 0xFF;
        int n6 = textFormatting2.getRgbValue() & 0xFF;
        int n7 = (int)((float)n + (float)(n4 - n) * f);
        int n8 = (int)((float)n2 + (float)(n5 - n2) * f);
        int n9 = (int)((float)n3 + (float)(n6 - n3) * f);
        return n7 << 16 | n8 << 8 | n9;
    }
}

