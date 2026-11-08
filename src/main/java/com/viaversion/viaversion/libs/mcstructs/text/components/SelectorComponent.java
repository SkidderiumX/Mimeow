/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class SelectorComponent
extends TextComponent {
    private String selector;
    @Nullable
    private TextComponent separator;

    public SelectorComponent(String string) {
        this(string, null);
    }

    public SelectorComponent(String string, @Nullable TextComponent textComponent) {
        this.selector = string;
        this.separator = textComponent;
    }

    public String getSelector() {
        return this.selector;
    }

    public SelectorComponent setSelector(String string) {
        this.selector = string;
        return this;
    }

    @Nullable
    public TextComponent getSeparator() {
        return this.separator;
    }

    public SelectorComponent setSeparator(@Nullable TextComponent textComponent) {
        this.separator = textComponent;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.selector;
    }

    @Override
    public TextComponent shallowCopy() {
        if (this.separator == null) {
            return new SelectorComponent(this.selector, null).setStyle(this.getStyle().copy());
        }
        return new SelectorComponent(this.selector, this.separator.copy()).setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("selector", this.selector).add("separator", this.separator, Objects::nonNull).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SelectorComponent)) {
            return false;
        }
        SelectorComponent selectorComponent = (SelectorComponent)object;
        if (!selectorComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        String string = this.getSelector();
        String string2 = selectorComponent.getSelector();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        TextComponent textComponent = this.getSeparator();
        TextComponent textComponent2 = selectorComponent.getSeparator();
        return !(textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof SelectorComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        String string = this.getSelector();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        TextComponent textComponent = this.getSeparator();
        n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
        return n2;
    }
}

