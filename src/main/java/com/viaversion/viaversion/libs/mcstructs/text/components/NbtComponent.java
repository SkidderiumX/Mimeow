/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class NbtComponent
extends TextComponent {
    private String component;
    private boolean resolve;
    private boolean plain;
    private TextComponent separator;
    private NbtDataSource dataSource;

    public NbtComponent(String string, boolean bl, NbtDataSource nbtDataSource) {
        this(string, bl, null, nbtDataSource);
    }

    public NbtComponent(String string, boolean bl, boolean bl2, NbtDataSource nbtDataSource) {
        this(string, bl, bl2, null, nbtDataSource);
    }

    public NbtComponent(String string, boolean bl, @Nullable TextComponent textComponent, NbtDataSource nbtDataSource) {
        this(string, bl, false, textComponent, nbtDataSource);
    }

    public NbtComponent(String string, boolean bl, boolean bl2, @Nullable TextComponent textComponent, NbtDataSource nbtDataSource) {
        this.component = string;
        this.resolve = bl;
        this.plain = bl2;
        this.separator = textComponent;
        this.dataSource = nbtDataSource;
    }

    @Override
    public String asSingleString() {
        return "";
    }

    @Override
    public TextComponent shallowCopy() {
        NbtComponent nbtComponent = new NbtComponent(this.component, this.resolve, this.separator, this.dataSource);
        return nbtComponent.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("component", this.component).add("resolve", this.resolve).add("separator", this.separator, Objects::nonNull).toString();
    }

    @Generated
    public String getComponent() {
        return this.component;
    }

    @Generated
    public boolean isResolve() {
        return this.resolve;
    }

    @Generated
    public boolean isPlain() {
        return this.plain;
    }

    @Generated
    public TextComponent getSeparator() {
        return this.separator;
    }

    @Generated
    public NbtDataSource getDataSource() {
        return this.dataSource;
    }

    @Generated
    public NbtComponent setComponent(String string) {
        this.component = string;
        return this;
    }

    @Generated
    public NbtComponent setResolve(boolean bl) {
        this.resolve = bl;
        return this;
    }

    @Generated
    public NbtComponent setPlain(boolean bl) {
        this.plain = bl;
        return this;
    }

    @Generated
    public NbtComponent setSeparator(TextComponent textComponent) {
        this.separator = textComponent;
        return this;
    }

    @Generated
    public NbtComponent setDataSource(NbtDataSource nbtDataSource) {
        this.dataSource = nbtDataSource;
        return this;
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NbtComponent)) {
            return false;
        }
        NbtComponent nbtComponent = (NbtComponent)object;
        if (!nbtComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (this.isResolve() != nbtComponent.isResolve()) {
            return false;
        }
        if (this.isPlain() != nbtComponent.isPlain()) {
            return false;
        }
        String string = this.getComponent();
        String string2 = nbtComponent.getComponent();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        TextComponent textComponent = this.getSeparator();
        TextComponent textComponent2 = nbtComponent.getSeparator();
        if (textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2)) {
            return false;
        }
        NbtDataSource nbtDataSource = this.getDataSource();
        NbtDataSource nbtDataSource2 = nbtComponent.getDataSource();
        return !(nbtDataSource == null ? nbtDataSource2 != null : !nbtDataSource.equals(nbtDataSource2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof NbtComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        n2 = n2 * 59 + (this.isResolve() ? 79 : 97);
        n2 = n2 * 59 + (this.isPlain() ? 79 : 97);
        String string = this.getComponent();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        TextComponent textComponent = this.getSeparator();
        n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
        NbtDataSource nbtDataSource = this.getDataSource();
        n2 = n2 * 59 + (nbtDataSource == null ? 43 : nbtDataSource.hashCode());
        return n2;
    }
}

