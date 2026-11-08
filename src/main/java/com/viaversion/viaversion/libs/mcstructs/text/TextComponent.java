/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text;

import com.viaversion.viaversion.libs.mcstructs.converter.ConsumerTracking;
import com.viaversion.viaversion.libs.mcstructs.core.Copyable;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ObjectComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.SerializerUnknownHandling;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Generated;

public abstract class TextComponent
implements Copyable<TextComponent> {
    private static final StringFormat LEGACY_FORMAT = StringFormat.vanilla('\u00a7', false);
    private List<TextComponent> siblings;
    private Style style;
    private int level = 1;
    private static final int MAX_LEN = 65535;

    private void setLevel(int n) {
        this.level = Math.max(this.level, n);
        if (this.level > 512) {
            throw new IllegalArgumentException("Too deep");
        }
    }

    public TextComponent append(String ... stringArray) {
        for (String string : stringArray) {
            this.getSiblings().add(new StringComponent(string));
        }
        return this;
    }

    public TextComponent append(TextComponent textComponent) {
        this.getSiblings().add(textComponent);
        textComponent.setLevel(this.level + 1);
        return this;
    }

    public TextComponent append(TextComponent ... textComponentArray) {
        Collections.addAll(this.getSiblings(), textComponentArray);
        for (TextComponent textComponent : textComponentArray) {
            textComponent.setLevel(this.level + 1);
        }
        return this;
    }

    public TextComponent append(Iterable<TextComponent> iterable) {
        iterable.forEach(this.getSiblings()::add);
        for (TextComponent textComponent : iterable) {
            textComponent.setLevel(this.level + 1);
        }
        return this;
    }

    public List<TextComponent> getSiblings() {
        if (this.siblings == null) {
            this.siblings = new ArrayList<TextComponent>();
        }
        return this.siblings;
    }

    public TextComponent forEach(Consumer<TextComponent> consumer) {
        consumer.accept(this);
        if (this.siblings != null) {
            for (TextComponent textComponent : this.siblings) {
                textComponent.forEach(consumer);
            }
        }
        return this;
    }

    @Nonnull
    public Style getStyle() {
        if (this.style == null) {
            this.style = new Style();
        }
        return this.style;
    }

    public TextComponent setStyle(@Nonnull Style style) {
        this.style = style;
        return this;
    }

    public TextComponent styled(Consumer<Style> consumer) {
        consumer.accept(this.getStyle());
        return this;
    }

    public TextComponent formatted(TextFormatting textFormatting) {
        this.getStyle().setFormatting(textFormatting);
        return this;
    }

    public TextComponent setParentStyle(@Nonnull Style style) {
        this.getStyle().setParent(style);
        return this;
    }

    public TextComponent setSiblingParentStyle() {
        if (this.siblings == null) {
            return this;
        }
        for (TextComponent textComponent : this.siblings) {
            textComponent.getStyle().setParent(this.getStyle());
            textComponent.setSiblingParentStyle();
        }
        return this;
    }

    public TextComponent mergeSiblingParentStyle() {
        if (this.siblings == null) {
            return this;
        }
        for (TextComponent textComponent : this.siblings) {
            textComponent.getStyle().setParent(this.getStyle());
            textComponent.getStyle().mergeParent();
            textComponent.mergeSiblingParentStyle();
        }
        return this;
    }

    public <C extends TextComponent> C copyMetaTo(C c) {
        c.setStyle(this.getStyle().copy());
        if (this.siblings != null) {
            for (TextComponent textComponent : this.siblings) {
                c.append(textComponent.copy());
            }
        }
        return c;
    }

    public String asUnformattedString() {
        return this.asUnformattedString(null);
    }

    public String asUnformattedString(ConsumerTracking consumerTracking) {
        StringBuilder stringBuilder = new StringBuilder();
        ComponentConsumer componentConsumer = string -> {
            if (string.length() + stringBuilder.length() > 65535) {
                throw new IllegalArgumentException("Too long");
            }
            stringBuilder.append((String)string);
        };
        if (consumerTracking != null && consumerTracking.currentConsumer() != null) {
            componentConsumer = ((ComponentConsumer)consumerTracking.currentConsumer()).withConsumer(componentConsumer);
            consumerTracking.setCurrentConsumer(componentConsumer);
        }
        this.visit(consumerTracking, componentConsumer);
        return stringBuilder.toString();
    }

    public void visit(ConsumerTracking consumerTracking, ComponentConsumer componentConsumer) {
        this.asSingleString(consumerTracking, componentConsumer);
        if (this.siblings != null) {
            for (TextComponent textComponent : this.siblings) {
                textComponent.visit(consumerTracking, componentConsumer);
            }
        }
    }

    public String asLegacyFormatString() {
        return LEGACY_FORMAT.toString(this, ColorHandling.RESET, SerializerUnknownHandling.IGNORE);
    }

    public abstract String asSingleString();

    public void asSingleString(ConsumerTracking consumerTracking, ComponentConsumer componentConsumer) {
        componentConsumer.accept(this.asSingleString());
    }

    @Override
    public TextComponent copy() {
        TextComponent textComponent = this.shallowCopy();
        if (this.siblings != null) {
            for (TextComponent textComponent2 : this.siblings) {
                textComponent.append(textComponent2.copy());
            }
        }
        return textComponent;
    }

    public abstract TextComponent shallowCopy();

    public abstract String toString();

    public static StringComponent empty() {
        return new StringComponent();
    }

    public static StringComponent of(String string) {
        return new StringComponent(string);
    }

    public static TextComponent of(String ... stringArray) {
        if (stringArray.length == 0) {
            return new StringComponent();
        }
        if (stringArray.length == 1) {
            return new StringComponent(stringArray[0]);
        }
        StringComponent stringComponent = new StringComponent();
        stringComponent.append(stringArray);
        return stringComponent;
    }

    public static TextComponent of(TextComponent ... textComponentArray) {
        if (textComponentArray.length == 0) {
            return new StringComponent();
        }
        if (textComponentArray.length == 1) {
            return textComponentArray[0];
        }
        StringComponent stringComponent = new StringComponent();
        stringComponent.append(textComponentArray);
        return stringComponent;
    }

    public static TextComponent of(Iterable<TextComponent> iterable) {
        StringComponent stringComponent = new StringComponent();
        iterable.forEach(stringComponent::append);
        return stringComponent;
    }

    public static TranslationComponent translation(String string, List<Object> list) {
        return new TranslationComponent(string, list);
    }

    public static TranslationComponent translation(String string, Object ... objectArray) {
        return new TranslationComponent(string, objectArray);
    }

    public static ScoreComponent score(String string, String string2) {
        return new ScoreComponent(string, string2);
    }

    public static ScoreComponent score(String string, String string2, @Nullable String string3) {
        return new ScoreComponent(string, string2, string3);
    }

    public static SelectorComponent selector(String string) {
        return new SelectorComponent(string);
    }

    public static SelectorComponent selector(String string, @Nullable TextComponent textComponent) {
        return new SelectorComponent(string, textComponent);
    }

    public static KeybindComponent keybind(String string) {
        return new KeybindComponent(string);
    }

    public static NbtComponent blockNbt(String string, boolean bl, String string2) {
        return new NbtComponent(string, bl, new BlockNbtSource(string2));
    }

    public static NbtComponent blockNbt(String string, boolean bl, @Nullable TextComponent textComponent, String string2) {
        return new NbtComponent(string, bl, textComponent, (NbtDataSource)new BlockNbtSource(string2));
    }

    public static NbtComponent entityNbt(String string, boolean bl, String string2) {
        return new NbtComponent(string, bl, new EntityNbtSource(string2));
    }

    public static NbtComponent entityNbt(String string, boolean bl, @Nullable TextComponent textComponent, String string2) {
        return new NbtComponent(string, bl, textComponent, (NbtDataSource)new EntityNbtSource(string2));
    }

    public static NbtComponent storageNbt(String string, boolean bl, Identifier identifier) {
        return new NbtComponent(string, bl, new StorageNbtSource(identifier));
    }

    public static NbtComponent storageNbt(String string, boolean bl, @Nullable TextComponent textComponent, Identifier identifier) {
        return new NbtComponent(string, bl, textComponent, (NbtDataSource)new StorageNbtSource(identifier));
    }

    public static ObjectComponent atlasSprite(Identifier identifier) {
        return new ObjectComponent(new ObjectComponent.AtlasSprite(identifier));
    }

    public static ObjectComponent atlasSprite(Identifier identifier, @Nullable TextComponent textComponent) {
        return new ObjectComponent(new ObjectComponent.AtlasSprite(identifier), textComponent);
    }

    public static ObjectComponent atlasSprite(Identifier identifier, Identifier identifier2) {
        return new ObjectComponent(new ObjectComponent.AtlasSprite(identifier, identifier2));
    }

    public static ObjectComponent atlasSprite(Identifier identifier, Identifier identifier2, @Nullable TextComponent textComponent) {
        return new ObjectComponent(new ObjectComponent.AtlasSprite(identifier, identifier2), textComponent);
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TextComponent)) {
            return false;
        }
        TextComponent textComponent = (TextComponent)object;
        if (!textComponent.canEqual(this)) {
            return false;
        }
        List<TextComponent> list = this.getSiblings();
        List<TextComponent> list2 = textComponent.getSiblings();
        if (list == null ? list2 != null : !((Object)list).equals(list2)) {
            return false;
        }
        Style style = this.getStyle();
        Style style2 = textComponent.getStyle();
        return !(style == null ? style2 != null : !((Object)style).equals(style2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof TextComponent;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        List<TextComponent> list = this.getSiblings();
        n2 = n2 * 59 + (list == null ? 43 : ((Object)list).hashCode());
        Style style = this.getStyle();
        n2 = n2 * 59 + (style == null ? 43 : ((Object)style).hashCode());
        return n2;
    }

    @FunctionalInterface
    public static interface ComponentConsumer
    extends Consumer<String> {
        default public ComponentConsumer withConsumer(ComponentConsumer componentConsumer) {
            return componentConsumer;
        }
    }
}

