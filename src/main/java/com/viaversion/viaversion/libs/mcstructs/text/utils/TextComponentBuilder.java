/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import java.awt.Color;

public class TextComponentBuilder {
    public static TextComponent build(Object ... objectArray) {
        StringComponent stringComponent = new StringComponent("");
        TextComponent textComponent = null;
        Style style = new Style();
        for (Object object : objectArray) {
            if (object == null) {
                TextComponentBuilder.checkAppend(stringComponent, textComponent, style);
                textComponent = null;
                style = new Style();
                continue;
            }
            if (object instanceof TextFormatting) {
                style.setFormatting((TextFormatting)object);
                continue;
            }
            if (object instanceof Color) {
                style.setFormatting(new TextFormatting(((Color)object).getRGB()));
                continue;
            }
            if (object instanceof ClickEvent) {
                style.setClickEvent((ClickEvent)object);
                continue;
            }
            if (object instanceof HoverEvent) {
                style.setHoverEvent((HoverEvent)object);
                continue;
            }
            if (object instanceof Style) {
                style = (Style)object;
                continue;
            }
            if (object instanceof TextComponent) {
                if (TextComponentBuilder.checkAppend(stringComponent, textComponent, style)) {
                    textComponent = null;
                    style = new Style();
                }
                if (textComponent == null) {
                    textComponent = (StringComponent)object;
                    continue;
                }
                textComponent.append((TextComponent)object);
                continue;
            }
            if (TextComponentBuilder.checkAppend(stringComponent, textComponent, style)) {
                textComponent = null;
                style = new Style();
            }
            if (textComponent == null) {
                textComponent = new StringComponent(object.toString());
                continue;
            }
            textComponent.append(object.toString());
        }
        if (textComponent != null) {
            if (!style.isEmpty()) {
                textComponent.setStyle(style);
            }
            stringComponent.append(textComponent);
        }
        if (stringComponent.getSiblings().size() == 1) {
            return stringComponent.getSiblings().get(0);
        }
        return stringComponent;
    }

    private static boolean checkAppend(TextComponent textComponent, TextComponent textComponent2, Style style) {
        if (textComponent2 == null) {
            return !style.isEmpty();
        }
        if (style.isEmpty()) {
            return false;
        }
        textComponent.append(textComponent2.setStyle(style));
        return true;
    }
}

