/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

import com.viaversion.viaversion.libs.mcstructs.core.Copyable;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.ResolvedFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.DeserializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.SerializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.AdventureRgbStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.AnsiStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.BungeeRgbStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.PrioritizingStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.VanillaStringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher.VoidVanillaStringFormat;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class StringFormat {
    protected final char colorChar;
    private static final IllegalArgumentException EX = new IllegalArgumentException("Too long");

    public static StringFormat vanilla() {
        return StringFormat.vanilla('\u00a7', false);
    }

    public static StringFormat vanilla(char c) {
        return StringFormat.vanilla(c, false);
    }

    public static StringFormat vanilla(boolean bl) {
        return StringFormat.vanilla('\u00a7', bl);
    }

    public static StringFormat vanilla(char c, boolean bl) {
        return new PrioritizingStringFormat(new VanillaStringFormat(c, bl), new VoidVanillaStringFormat(c));
    }

    public static StringFormat bungee() {
        return StringFormat.bungee('&');
    }

    public static StringFormat bungee(char c) {
        return new PrioritizingStringFormat(new BungeeRgbStringFormat(c), new VanillaStringFormat(c, false), new VoidVanillaStringFormat(c));
    }

    public static StringFormat adventure() {
        return StringFormat.adventure('&');
    }

    public static StringFormat adventure(char c) {
        return new PrioritizingStringFormat(new AdventureRgbStringFormat(c), new VanillaStringFormat(c, false), new VoidVanillaStringFormat(c));
    }

    public static StringFormat ansi() {
        return StringFormat.ansi(true);
    }

    public static StringFormat ansi(boolean bl) {
        return new AnsiStringFormat(bl);
    }

    public StringFormat(char c) {
        this.colorChar = c;
    }

    public TextComponent fromString(String string, ColorHandling colorHandling, DeserializerUnknownHandling deserializerUnknownHandling) {
        return this.fromString(string, colorHandling, deserializerUnknownHandling, true);
    }

    public TextComponent fromString(String string, ColorHandling colorHandling, DeserializerUnknownHandling deserializerUnknownHandling, boolean bl) {
        TextStringReader textStringReader = new TextStringReader(string);
        Style style = new Style();
        ArrayList<TextComponent> arrayList = new ArrayList<TextComponent>();
        StringBuilder stringBuilder = new StringBuilder();
        while (textStringReader.canRead()) {
            ResolvedFormatting resolvedFormatting = this.resolve(textStringReader);
            if (resolvedFormatting == null) {
                stringBuilder.append(textStringReader.read());
                continue;
            }
            TextFormatting textFormatting = resolvedFormatting.get();
            if (textFormatting == null && (textFormatting = deserializerUnknownHandling.handle(resolvedFormatting, stringBuilder)) == null) continue;
            if (stringBuilder.length() > 0 || !bl) {
                arrayList.add(TextComponent.of(stringBuilder.toString()).setStyle(style.copy()));
                stringBuilder.setLength(0);
            }
            if (textFormatting.equals(TextFormatting.RESET) || colorHandling.equals((Object)ColorHandling.RESET) && textFormatting.isColor()) {
                style = new Style();
            }
            style.setFormatting(textFormatting);
        }
        if (stringBuilder.length() > 0 || !bl) {
            arrayList.add(TextComponent.of(stringBuilder.toString()).setStyle(style));
        }
        if (arrayList.size() == 1) {
            return (TextComponent)arrayList.get(0);
        }
        return TextComponent.of(arrayList);
    }

    public String toString(TextComponent textComponent, ColorHandling colorHandling, SerializerUnknownHandling serializerUnknownHandling) {
        return this.toString(textComponent, colorHandling, serializerUnknownHandling, true);
    }

    public String toString(TextComponent textComponent, ColorHandling colorHandling, SerializerUnknownHandling serializerUnknownHandling, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        Copyable<Style> copyable = null;
        ArrayList<TextComponent> arrayList = new ArrayList<TextComponent>();
        arrayList.add(textComponent.copy().mergeSiblingParentStyle());
        int n = 1;
        while (!arrayList.isEmpty()) {
            Copyable<TextComponent> copyable2;
            Object object;
            TextComponent textComponent2 = (TextComponent)arrayList.remove(0);
            if (textComponent2 instanceof TranslationComponent) {
                object = (TranslationComponent)textComponent2;
                copyable2 = ((TranslationComponent)object).resolveIntoComponents();
                if ((n += ((TextComponent)copyable2).getSiblings().size()) > 32) {
                    throw EX;
                }
                arrayList.add(0, ((TextComponent)copyable2).mergeSiblingParentStyle());
                for (int i = 0; i < ((TextComponent)object).getSiblings().size(); ++i) {
                    arrayList.add(i + 1, ((TextComponent)object).getSiblings().get(i));
                }
                continue;
            }
            object = textComponent2.asSingleString();
            if (!((String)object).isEmpty() || !bl) {
                copyable2 = textComponent2.getStyle();
                if (!((Style)copyable2).equals(copyable)) {
                    TextFormatting[] textFormattingArray = ((Style)copyable2).getFormattings();
                    if (!(copyable == null || copyable.isEmpty() || !colorHandling.equals((Object)ColorHandling.FORMATTING) && textFormattingArray.length > 0 && textFormattingArray[0].isColor())) {
                        this.write(stringBuilder, TextFormatting.RESET);
                    }
                    for (TextFormatting textFormatting : textFormattingArray) {
                        if (this.canWrite(textFormatting)) {
                            this.write(stringBuilder, textFormatting);
                            continue;
                        }
                        TextFormatting textFormatting2 = serializerUnknownHandling.handle(textFormatting, stringBuilder);
                        if (textFormatting2 == null || !this.canWrite(textFormatting2)) continue;
                        this.write(stringBuilder, textFormatting2);
                    }
                    copyable = copyable2;
                }
                stringBuilder.append(textComponent2.asSingleString());
            }
            for (int i = 0; i < textComponent2.getSiblings().size(); ++i) {
                arrayList.add(i, textComponent2.getSiblings().get(i));
            }
        }
        if (copyable != null && !copyable.isEmpty() && this.shouldResetAtEnd()) {
            this.write(stringBuilder, TextFormatting.RESET);
        }
        return stringBuilder.toString();
    }

    public Style styleAt(String string, int n, ColorHandling colorHandling, DeserializerUnknownHandling deserializerUnknownHandling) {
        TextStringReader textStringReader = new TextStringReader(string);
        Style style = new Style();
        while (textStringReader.canRead() && textStringReader.getIndex() < n) {
            ResolvedFormatting resolvedFormatting = this.resolve(textStringReader);
            if (resolvedFormatting == null) {
                textStringReader.read();
                continue;
            }
            TextFormatting textFormatting = resolvedFormatting.get();
            if (textFormatting == null && (textFormatting = deserializerUnknownHandling.handle(resolvedFormatting, new StringBuilder())) == null) continue;
            if (textFormatting.equals(TextFormatting.RESET) || colorHandling.equals((Object)ColorHandling.RESET) && textFormatting.isColor()) {
                style = new Style();
            }
            style.setFormatting(textFormatting);
        }
        return style;
    }

    public String convertTo(String string, StringFormat stringFormat) {
        TextStringReader textStringReader = new TextStringReader(string);
        StringBuilder stringBuilder = new StringBuilder();
        TextFormatting textFormatting = null;
        while (textStringReader.canRead()) {
            ResolvedFormatting resolvedFormatting = this.resolve(textStringReader);
            if (resolvedFormatting == null) {
                stringBuilder.append(textStringReader.read());
                continue;
            }
            textFormatting = resolvedFormatting.get();
            stringFormat.write(stringBuilder, textFormatting);
        }
        if (stringFormat.shouldResetAtEnd() && !TextFormatting.RESET.equals(textFormatting)) {
            stringFormat.write(stringBuilder, TextFormatting.RESET);
        }
        return stringBuilder.toString();
    }

    public String prependStyle(String string, Style style, SerializerUnknownHandling serializerUnknownHandling) {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextFormatting textFormatting : style.getFormattings()) {
            if (this.canWrite(textFormatting)) {
                this.write(stringBuilder, textFormatting);
                continue;
            }
            TextFormatting textFormatting2 = serializerUnknownHandling.handle(textFormatting, stringBuilder);
            if (textFormatting2 == null || !this.canWrite(textFormatting2)) continue;
            this.write(stringBuilder, textFormatting2);
        }
        return stringBuilder.append(string).toString();
    }

    public String[] split(String string, String string2, ColorHandling colorHandling, SerializerUnknownHandling serializerUnknownHandling, DeserializerUnknownHandling deserializerUnknownHandling) {
        String[] stringArray = string.split(Pattern.quote(string2));
        for (int i = 1; i < stringArray.length; ++i) {
            String string3 = stringArray[i - 1];
            Style style = this.styleAt(string3, string3.length(), colorHandling, deserializerUnknownHandling);
            stringArray[i] = this.prependStyle(stringArray[i], style, serializerUnknownHandling);
        }
        return stringArray;
    }

    @Nullable
    public ResolvedFormatting resolve(TextStringReader textStringReader) {
        if (!this.canRead(textStringReader)) {
            return null;
        }
        textStringReader.mark();
        if (!this.matches(textStringReader)) {
            textStringReader.reset();
            return null;
        }
        textStringReader.reset();
        TextFormatting textFormatting = this.read(textStringReader);
        String string = textStringReader.getMark();
        return new ResolvedFormatting(string, textFormatting);
    }

    public boolean canRead(TextStringReader textStringReader) {
        return textStringReader.canRead() && textStringReader.peek() == this.colorChar;
    }

    public abstract boolean matches(TextStringReader var1);

    @Nullable
    public abstract TextFormatting read(TextStringReader var1);

    public abstract boolean canWrite(TextFormatting var1);

    public abstract void write(StringBuilder var1, TextFormatting var2);

    public boolean shouldResetAtEnd() {
        return false;
    }

    protected static <T> T init(T t, Consumer<T> consumer) {
        consumer.accept(t);
        return t;
    }
}

