/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import lombok.Generated;

public class StringComponent
extends TextComponent {
    private String text;

    public StringComponent() {
        this("");
    }

    public StringComponent(String string) {
        this.text = string;
    }

    public String getText() {
        return this.text;
    }

    public StringComponent setText(String string) {
        this.text = string;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.text;
    }

    @Override
    public TextComponent shallowCopy() {
        return new StringComponent(this.text).setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("text", this.text).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StringComponent)) {
            return false;
        }
        StringComponent stringComponent = (StringComponent)object;
        if (!stringComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        String string = this.getText();
        String string2 = stringComponent.getText();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof StringComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        String string = this.getText();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}

