/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text;

import com.viaversion.viaversion.libs.mcstructs.core.Copyable;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.font.FontDescription;
import com.viaversion.viaversion.libs.mcstructs.text.font.ResourceFont;
import java.util.ArrayList;
import java.util.Objects;

public class Style
implements Copyable<Style> {
    private Style parent;
    private TextFormatting color;
    private Integer shadowColor;
    private Boolean obfuscated;
    private Boolean bold;
    private Boolean strikethrough;
    private Boolean underlined;
    private Boolean italic;
    private ClickEvent clickEvent;
    private HoverEvent hoverEvent;
    private String insertion;
    private FontDescription font;

    public Style() {
    }

    public Style(TextFormatting textFormatting, Boolean bl, Boolean bl2, Boolean bl3, Boolean bl4, Boolean bl5, ClickEvent clickEvent, HoverEvent hoverEvent, String string, Identifier identifier) {
        this(textFormatting, null, bl, bl2, bl3, bl4, bl5, clickEvent, hoverEvent, string, identifier);
    }

    public Style(TextFormatting textFormatting, Boolean bl, Boolean bl2, Boolean bl3, Boolean bl4, Boolean bl5, ClickEvent clickEvent, HoverEvent hoverEvent, String string, FontDescription fontDescription) {
        this(textFormatting, null, bl, bl2, bl3, bl4, bl5, clickEvent, hoverEvent, string, fontDescription);
    }

    public Style(TextFormatting textFormatting, Integer n, Boolean bl, Boolean bl2, Boolean bl3, Boolean bl4, Boolean bl5, ClickEvent clickEvent, HoverEvent hoverEvent, String string, Identifier identifier) {
        this(textFormatting, n, bl, bl2, bl3, bl4, bl5, clickEvent, hoverEvent, string, new ResourceFont(identifier));
    }

    public Style(TextFormatting textFormatting, Integer n, Boolean bl, Boolean bl2, Boolean bl3, Boolean bl4, Boolean bl5, ClickEvent clickEvent, HoverEvent hoverEvent, String string, FontDescription fontDescription) {
        if (textFormatting != null && !textFormatting.isColor()) {
            throw new IllegalArgumentException("The color must be a color");
        }
        this.color = textFormatting;
        this.shadowColor = n;
        this.obfuscated = bl;
        this.bold = bl2;
        this.strikethrough = bl3;
        this.underlined = bl4;
        this.italic = bl5;
        this.clickEvent = clickEvent;
        this.hoverEvent = hoverEvent;
        this.insertion = string;
        this.font = fontDescription;
    }

    public Style setParent(Style style) {
        this.parent = style;
        return this;
    }

    public Style getParent() {
        return this.parent;
    }

    public Style setFormatting(TextFormatting textFormatting) {
        if (textFormatting == null) {
            return this;
        }
        if (textFormatting.isColor()) {
            this.color = textFormatting;
        } else if (TextFormatting.OBFUSCATED.equals(textFormatting)) {
            this.obfuscated = true;
        } else if (TextFormatting.BOLD.equals(textFormatting)) {
            this.bold = true;
        } else if (TextFormatting.STRIKETHROUGH.equals(textFormatting)) {
            this.strikethrough = true;
        } else if (TextFormatting.UNDERLINE.equals(textFormatting)) {
            this.underlined = true;
        } else if (TextFormatting.ITALIC.equals(textFormatting)) {
            this.italic = true;
        } else if (TextFormatting.RESET.equals(textFormatting)) {
            this.color = null;
            this.obfuscated = null;
            this.bold = null;
            this.strikethrough = null;
            this.underlined = null;
            this.italic = null;
            this.clickEvent = null;
            this.hoverEvent = null;
            this.insertion = null;
            this.font = null;
        } else {
            throw new IllegalArgumentException("Invalid TextFormatting " + textFormatting);
        }
        return this;
    }

    public Style setFormatting(TextFormatting ... textFormattingArray) {
        for (TextFormatting textFormatting : textFormattingArray) {
            this.setFormatting(textFormatting);
        }
        return this;
    }

    public TextFormatting[] getFormattings() {
        return this.getFormattings(true);
    }

    public TextFormatting[] getFormattings(boolean bl) {
        ArrayList<TextFormatting> arrayList = new ArrayList<TextFormatting>();
        if (bl && this.color != null) {
            arrayList.add(this.color);
        }
        if (this.isObfuscated()) {
            arrayList.add(TextFormatting.OBFUSCATED);
        }
        if (this.isBold()) {
            arrayList.add(TextFormatting.BOLD);
        }
        if (this.isStrikethrough()) {
            arrayList.add(TextFormatting.STRIKETHROUGH);
        }
        if (this.isUnderlined()) {
            arrayList.add(TextFormatting.UNDERLINE);
        }
        if (this.isItalic()) {
            arrayList.add(TextFormatting.ITALIC);
        }
        return arrayList.toArray(new TextFormatting[0]);
    }

    public Style setColor(int n) {
        this.color = new TextFormatting(n);
        return this;
    }

    public TextFormatting getColor() {
        if (this.color == null && this.parent != null) {
            return this.parent.getColor();
        }
        return this.color;
    }

    public Style setShadowColor(Integer n) {
        this.shadowColor = n;
        return this;
    }

    public Integer getShadowColor() {
        if (this.shadowColor == null && this.parent != null) {
            return this.parent.getShadowColor();
        }
        return this.shadowColor;
    }

    public Style setBold(Boolean bl) {
        this.bold = bl;
        return this;
    }

    public Boolean getBold() {
        if (this.bold == null && this.parent != null) {
            return this.parent.getBold();
        }
        return this.bold;
    }

    public boolean isBold() {
        Boolean bl = this.getBold();
        return bl != null && bl != false;
    }

    public Style setItalic(Boolean bl) {
        this.italic = bl;
        return this;
    }

    public Boolean getItalic() {
        if (this.italic == null && this.parent != null) {
            return this.parent.getItalic();
        }
        return this.italic;
    }

    public boolean isItalic() {
        Boolean bl = this.getItalic();
        return bl != null && bl != false;
    }

    public Style setUnderlined(Boolean bl) {
        this.underlined = bl;
        return this;
    }

    public Boolean getUnderlined() {
        if (this.underlined == null && this.parent != null) {
            return this.parent.getUnderlined();
        }
        return this.underlined;
    }

    public boolean isUnderlined() {
        Boolean bl = this.getUnderlined();
        return bl != null && bl != false;
    }

    public Style setStrikethrough(Boolean bl) {
        this.strikethrough = bl;
        return this;
    }

    public Boolean getStrikethrough() {
        if (this.strikethrough == null && this.parent != null) {
            return this.parent.getStrikethrough();
        }
        return this.strikethrough;
    }

    public boolean isStrikethrough() {
        Boolean bl = this.getStrikethrough();
        return bl != null && bl != false;
    }

    public Style setObfuscated(Boolean bl) {
        this.obfuscated = bl;
        return this;
    }

    public Boolean getObfuscated() {
        if (this.obfuscated == null && this.parent != null) {
            return this.parent.getObfuscated();
        }
        return this.obfuscated;
    }

    public boolean isObfuscated() {
        Boolean bl = this.getObfuscated();
        return bl != null && bl != false;
    }

    public Style setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    public ClickEvent getClickEvent() {
        if (this.clickEvent == null && this.parent != null) {
            return this.parent.getClickEvent();
        }
        return this.clickEvent;
    }

    public Style setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    public HoverEvent getHoverEvent() {
        if (this.hoverEvent == null && this.parent != null) {
            return this.parent.getHoverEvent();
        }
        return this.hoverEvent;
    }

    public Style setInsertion(String string) {
        this.insertion = string;
        return this;
    }

    public String getInsertion() {
        if (this.insertion == null && this.parent != null) {
            return this.parent.getInsertion();
        }
        return this.insertion;
    }

    public Style setFont(Identifier identifier) {
        return this.setFont(new ResourceFont(identifier));
    }

    public Style setFont(FontDescription fontDescription) {
        this.font = fontDescription;
        return this;
    }

    public FontDescription getFont() {
        if (this.font == null && this.parent != null) {
            return this.parent.getFont();
        }
        return this.font;
    }

    public boolean isEmpty() {
        return this.getColor() == null && this.getShadowColor() == null && this.getBold() == null && this.getItalic() == null && this.getUnderlined() == null && this.getStrikethrough() == null && this.getObfuscated() == null && this.getClickEvent() == null && this.getHoverEvent() == null && this.getInsertion() == null && this.getFont() == null;
    }

    public void mergeParent() {
        this.color = this.getColor();
        this.shadowColor = this.getShadowColor();
        this.bold = this.getBold();
        this.italic = this.getItalic();
        this.underlined = this.getUnderlined();
        this.strikethrough = this.getStrikethrough();
        this.obfuscated = this.getObfuscated();
        this.clickEvent = this.getClickEvent();
        this.hoverEvent = this.getHoverEvent();
        this.insertion = this.getInsertion();
        this.font = this.getFont();
        this.parent = null;
    }

    @Override
    public Style copy() {
        Style style = new Style();
        style.parent = this.parent;
        style.color = this.color;
        style.shadowColor = this.shadowColor;
        style.bold = this.bold;
        style.italic = this.italic;
        style.underlined = this.underlined;
        style.strikethrough = this.strikethrough;
        style.obfuscated = this.obfuscated;
        style.clickEvent = this.clickEvent;
        style.hoverEvent = this.hoverEvent;
        style.insertion = this.insertion;
        style.font = this.font;
        return style;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Style style = (Style)object;
        return Objects.equals(this.parent, style.parent) && Objects.equals(this.color, style.color) && Objects.equals(this.shadowColor, style.shadowColor) && Objects.equals(this.obfuscated, style.obfuscated) && Objects.equals(this.bold, style.bold) && Objects.equals(this.strikethrough, style.strikethrough) && Objects.equals(this.underlined, style.underlined) && Objects.equals(this.italic, style.italic) && Objects.equals(this.clickEvent, style.clickEvent) && Objects.equals(this.hoverEvent, style.hoverEvent) && Objects.equals(this.insertion, style.insertion) && Objects.equals(this.font, style.font);
    }

    public int hashCode() {
        return Objects.hash(this.parent, this.color, this.shadowColor, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion, this.font);
    }

    public String toString() {
        return ToString.of(this).add("parent", this.parent, Objects::nonNull).add("shadowColor", this.shadowColor, Objects::nonNull).add("color", this.color, Objects::nonNull).add("obfuscated", this.obfuscated, Objects::nonNull).add("bold", this.bold, Objects::nonNull).add("strikethrough", this.strikethrough, Objects::nonNull).add("underlined", this.underlined, Objects::nonNull).add("italic", this.italic, Objects::nonNull).add("clickEvent", this.clickEvent, Objects::nonNull).add("hoverEvent", this.hoverEvent, Objects::nonNull).add("insertion", this.insertion, Objects::nonNull).add("font", this.font, Objects::nonNull).toString();
    }
}

