/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public class TextUtils {
    private static final String URL_PATTERN = "(?:https?://)?[\\w._-]+\\.\\w{2,}(?:/\\S*)?";

    public static TextComponent makeURLsClickable(TextComponent textComponent) {
        return TextUtils.makeURLsClickable(textComponent, true);
    }

    public static TextComponent makeURLsClickable(TextComponent textComponent2, boolean bl) {
        return TextUtils.replace(textComponent2, URL_PATTERN, textComponent -> {
            if (bl) {
                textComponent.getStyle().setClickEvent(ClickEvent.openUrl(textComponent.asSingleString()));
            } else {
                try {
                    textComponent.getStyle().setClickEvent(ClickEvent.openUrl(new URI(textComponent.asSingleString())));
                }
                catch (URISyntaxException uRISyntaxException) {
                    // empty catch block
                }
            }
            return textComponent;
        });
    }

    public static TextComponent replace(TextComponent textComponent, Function<TextComponent, TextComponent> function) {
        TextComponent textComponent2 = textComponent.shallowCopy();
        if ((textComponent2 = function.apply(textComponent2)) instanceof TranslationComponent) {
            Object[] objectArray = ((TranslationComponent)textComponent2).getArgs();
            for (int i = 0; i < objectArray.length; ++i) {
                if (!(objectArray[i] instanceof TextComponent)) continue;
                objectArray[i] = TextUtils.replace((TextComponent)objectArray[i], function);
            }
        }
        for (TextComponent textComponent3 : textComponent.getSiblings()) {
            textComponent2.append(TextUtils.replace(textComponent3, function));
        }
        return textComponent2;
    }

    public static TextComponent replace(TextComponent textComponent, String string, Function<TextComponent, TextComponent> function) {
        TextComponent textComponent2;
        Object object;
        Pattern pattern = Pattern.compile(string);
        if (textComponent instanceof StringComponent) {
            Object object2;
            String string2 = textComponent.asSingleString();
            Matcher object3 = pattern.matcher(string2);
            object = new ArrayList();
            int n = 0;
            while (object3.find()) {
                TextComponent textComponent3;
                int n2 = object3.start();
                object2 = object3.group();
                if (n2 > n) {
                    object.add(new StringComponent(string2.substring(n, n2)).setStyle(textComponent.getStyle().copy()));
                }
                if ((textComponent3 = function.apply(new StringComponent((String)object2).setStyle(textComponent.getStyle().copy()))) != null) {
                    object.add(textComponent3);
                }
                n = object3.end();
            }
            if (n < string2.length()) {
                object.add(new StringComponent(string2.substring(n)).setStyle(textComponent.getStyle().copy()));
            }
            if (object.size() > 1) {
                textComponent2 = new StringComponent("");
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    object2 = (TextComponent)iterator2.next();
                    textComponent2.append((TextComponent)object2);
                }
            } else {
                textComponent2 = object.size() == 1 ? ((TextComponent)object.get(0)).shallowCopy() : textComponent.shallowCopy();
            }
        } else {
            textComponent2 = textComponent.shallowCopy();
        }
        for (TextComponent textComponent4 : textComponent.getSiblings()) {
            object = TextUtils.replace(textComponent4, string, function);
            textComponent2.append((TextComponent)object);
        }
        return textComponent2;
    }

    public static TextComponent replaceRGBColors(TextComponent textComponent2) {
        TextComponent textComponent3 = textComponent2.copy();
        textComponent3.forEach(textComponent -> {
            if (textComponent.getStyle().getColor() != null && textComponent.getStyle().getColor().isRGBColor()) {
                textComponent.getStyle().setFormatting(TextFormatting.getClosestFormattingColor(textComponent.getStyle().getColor().getRgbValue()));
            }
        });
        return textComponent3;
    }

    public static TextComponent join(TextComponent textComponent, TextComponent ... textComponentArray) {
        if (textComponentArray.length == 0) {
            return new StringComponent("");
        }
        if (textComponentArray.length == 1) {
            return textComponentArray[0].copy();
        }
        TextComponent textComponent2 = null;
        for (TextComponent textComponent3 : textComponentArray) {
            if (textComponent2 == null) {
                textComponent2 = new StringComponent("").append(textComponent3.copy());
                continue;
            }
            textComponent2.append(textComponent.copy()).append(textComponent3.copy());
        }
        return textComponent2;
    }

    public static void iterateAll(TextComponent textComponent, Consumer<TextComponent> consumer) {
        Object object2;
        consumer.accept(textComponent);
        if (textComponent instanceof TranslationComponent) {
            object2 = (TranslationComponent)textComponent;
            for (Object object : ((TranslationComponent)object2).getArgs()) {
                if (!(object instanceof TextComponent)) continue;
                TextUtils.iterateAll((TextComponent)object, consumer);
            }
        }
        if (textComponent.getStyle().getHoverEvent() != null) {
            TextComponent textComponent2;
            EntityHoverEvent entityHoverEvent;
            object2 = textComponent.getStyle().getHoverEvent();
            if (object2 instanceof TextHoverEvent) {
                TextUtils.iterateAll(((TextHoverEvent)object2).getText(), consumer);
            } else if (object2 instanceof EntityHoverEvent && (entityHoverEvent = (EntityHoverEvent)object2).isModern() && (textComponent2 = entityHoverEvent.asModern().getName()) != null) {
                TextUtils.iterateAll(textComponent2, consumer);
            }
        }
        for (TextComponent textComponent3 : textComponent.getSiblings()) {
            TextUtils.iterateAll(textComponent3, consumer);
        }
    }

    public static void setTranslator(TextComponent textComponent, @Nullable Translator translator) {
        TextUtils.setTranslator(textComponent, translator, translator);
    }

    public static void setTranslator(TextComponent textComponent2, @Nullable Translator translator, @Nullable Translator translator2) {
        TextUtils.iterateAll(textComponent2, textComponent -> {
            if (textComponent instanceof TranslationComponent) {
                TranslationComponent translationComponent = (TranslationComponent)textComponent;
                translationComponent.setTranslator(translator);
            } else if (textComponent instanceof KeybindComponent) {
                KeybindComponent keybindComponent = (KeybindComponent)textComponent;
                keybindComponent.setTranslator(translator2);
            }
        });
    }

    public static TextComponent[] split(TextComponent textComponent2, String string, boolean bl) {
        TextComponent textComponent3 = textComponent2.copy();
        textComponent3.mergeSiblingParentStyle();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Runnable runnable2 = () -> {
            boolean bl_r = arrayList2.isEmpty();
            arrayList2.removeIf(textComponent -> textComponent instanceof StringComponent && textComponent.asSingleString().isEmpty());
            if (arrayList2.size() == 1) {
                arrayList.add(arrayList2.get(0));
            } else if (!bl_r) {
                StringComponent stringComponent = new StringComponent("");
                for (TextComponent textComponent2_r2 : arrayList2) {
                    stringComponent.append(textComponent2_r2);
                }
                arrayList.add(stringComponent);
            }
            arrayList2.clear();
        };
        textComponent3.forEach(textComponent -> {
            if (textComponent instanceof StringComponent || textComponent instanceof TranslationComponent && bl) {
                String string2 = textComponent.asSingleString();
                if (string2.contains(string)) {
                    String[] stringArray = string2.split(string, -1);
                    for (int i = 0; i < stringArray.length; ++i) {
                        String string3 = stringArray[i];
                        TextComponent textComponent2_r = new StringComponent(string3).setStyle(textComponent.getStyle().copy());
                        arrayList2.add(textComponent2_r);
                        if (i == stringArray.length - 1) continue;
                        runnable2.run();
                    }
                } else {
                    arrayList2.add(textComponent.shallowCopy());
                }
            } else {
                arrayList2.add(textComponent.shallowCopy());
            }
        });
        runnable2.run();
        return arrayList.toArray(new TextComponent[0]);
    }
}

