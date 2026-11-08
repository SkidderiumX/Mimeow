/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class ScoreComponent
extends TextComponent {
    private String name;
    private String objective;
    @Nullable
    private String value;

    public ScoreComponent(String string, String string2) {
        this(string, string2, null);
    }

    public ScoreComponent(String string, String string2, @Nullable String string3) {
        this.name = string;
        this.objective = string2;
        this.value = string3;
    }

    public String getName() {
        return this.name;
    }

    public ScoreComponent setName(String string) {
        this.name = string;
        return this;
    }

    public String getObjective() {
        return this.objective;
    }

    public ScoreComponent setObjective(@Nullable String string) {
        this.objective = string;
        return this;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public ScoreComponent setValue(@Nullable String string) {
        this.value = string;
        return this;
    }

    @Override
    public String asSingleString() {
        return this.value;
    }

    @Override
    public TextComponent shallowCopy() {
        ScoreComponent scoreComponent = new ScoreComponent(this.name, this.objective, this.value);
        return scoreComponent.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("name", this.name).add("objective", this.objective).add("value", this.value, Objects::nonNull).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ScoreComponent)) {
            return false;
        }
        ScoreComponent scoreComponent = (ScoreComponent)object;
        if (!scoreComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        String string = this.getName();
        String string2 = scoreComponent.getName();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getObjective();
        String string4 = scoreComponent.getObjective();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        String string5 = this.getValue();
        String string6 = scoreComponent.getValue();
        return !(string5 == null ? string6 != null : !string5.equals(string6));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ScoreComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        String string = this.getName();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getObjective();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        String string3 = this.getValue();
        n2 = n2 * 59 + (string3 == null ? 43 : string3.hashCode());
        return n2;
    }
}

