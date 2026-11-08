/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Generated;

public class KeybindComponent
extends TextComponent {
    private String keybind;
    private Translator translator;

    public KeybindComponent(String string) {
        this(string, Translator.GLOBAL);
    }

    public KeybindComponent(String string, @Nonnull Translator translator) {
        this.keybind = string;
        this.translator = translator;
    }

    public String getKeybind() {
        return this.keybind;
    }

    public KeybindComponent setKeybind(String string) {
        this.keybind = string;
        return this;
    }

    public KeybindComponent setTranslator(@Nullable Translator translator) {
        this.translator = translator == null ? Translator.GLOBAL : translator;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.translator.translateOrKey(this.keybind);
    }

    @Override
    public TextComponent shallowCopy() {
        KeybindComponent keybindComponent = new KeybindComponent(this.keybind);
        keybindComponent.translator = this.translator;
        return keybindComponent.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("keybind", this.keybind).add("translator", this.translator, translator -> translator != Translator.GLOBAL).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeybindComponent)) {
            return false;
        }
        KeybindComponent keybindComponent = (KeybindComponent)object;
        if (!keybindComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        String string = this.getKeybind();
        String string2 = keybindComponent.getKeybind();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        Translator translator = this.translator;
        Translator translator2 = keybindComponent.translator;
        return !(translator == null ? translator2 != null : !translator.equals(translator2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof KeybindComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        String string = this.getKeybind();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        Translator translator = this.translator;
        n2 = n2 * 59 + (translator == null ? 43 : translator.hashCode());
        return n2;
    }
}

