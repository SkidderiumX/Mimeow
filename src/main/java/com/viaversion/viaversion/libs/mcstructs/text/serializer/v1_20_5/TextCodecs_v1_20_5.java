/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5;

import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.impl.LazyInitCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.map.MapCodecMerger;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.JavaConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3.TextCodecs_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5.StyleCodecs_v1_20_5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Generated;

public class TextCodecs_v1_20_5 {
    public static final Codec<TextComponent> TEXT = new LazyInitCodec<TextComponent>(() -> Codec.recursive(codec -> TextCodecs_v1_20_3.createCodec((Codec)codec, StyleCodecs_v1_20_5.MAP_CODEC, (TextCodecs_v1_20_3.TextComponentType[])ComponentType.values(), ComponentType::forComponent)));
    public static final MapCodec<StringComponent> STRING_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("text").required(), StringComponent::getText, StringComponent::new);
    public static final MapCodec<TranslationComponent> TRANSLATION_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("translate").required(), TranslationComponent::getKey, Codec.STRING.mapCodec("fallback").optional().lenient().defaulted(null), TranslationComponent::getFallback, Codec.either(JavaConverter_v1_20_3.INSTANCE.toCodec().verified(object -> {
        if (object instanceof Boolean || object instanceof Number || object instanceof String) {
            return null;
        }
        return Result.error("Invalid value type: " + object.getClass().getName());
    }), TEXT).map(object -> object instanceof TextComponent ? Either.right((TextComponent)object) : Either.left(object), either -> {
        if (either.isLeft()) {
            return either.getLeft();
        }
        String string = TextCodecs_v1_20_3.tryCollapse((TextComponent)either.getRight());
        if (string != null) {
            return string;
        }
        return either.getRight();
    }).listOf().mapCodec("with").optional().defaulted(List::isEmpty, ArrayList::new), translationComponent -> Arrays.asList(translationComponent.getArgs()), (string, string2, list) -> new TranslationComponent((String)string, (List<?>)list).setFallback((String)string2));
    public static final MapCodec<KeybindComponent> KEYBIND_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("keybind").required(), KeybindComponent::getKeybind, KeybindComponent::new);
    public static final MapCodec<ScoreComponent> SCORE_COMPONENT = MapCodecMerger.codec(Codec.STRING.mapCodec("name").required(), ScoreComponent::getName, Codec.STRING.mapCodec("objective").required(), ScoreComponent::getObjective, ScoreComponent::new).mapCodec("score").required();
    public static final MapCodec<SelectorComponent> SELECTOR_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("selector").required(), SelectorComponent::getSelector, TEXT.mapCodec("separator").optional().defaulted(null), SelectorComponent::getSeparator, SelectorComponent::new);
    public static final MapCodec<NbtComponent> NBT_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("nbt").required(), NbtComponent::getComponent, Codec.BOOLEAN.mapCodec("interpret").optional().lenient().defaulted(false), NbtComponent::isResolve, TEXT.mapCodec("separator").optional().lenient().defaulted(null), NbtComponent::getSeparator, TextCodecs_v1_20_3.createLegacyComponentMatcher((NamedType[])NbtDataSourceType.values(), NbtDataSourceType::getCodec, NbtDataSourceType::forDataSource, (String)"source"), NbtComponent::getDataSource, NbtComponent::new);

    private static enum NbtDataSourceType implements NamedType
    {
        ENTITY("entity", MapCodecMerger.mapCodec(Codec.STRING.mapCodec("entity").required(), EntityNbtSource::getSelector, EntityNbtSource::new)),
        BLOCK("block", MapCodecMerger.mapCodec(Codec.STRING.mapCodec("block").required(), BlockNbtSource::getPos, BlockNbtSource::new)),
        STORAGE("storage", MapCodecMerger.mapCodec(Codec.STRING_IDENTIFIER.mapCodec("storage").required(), StorageNbtSource::getId, StorageNbtSource::new));

        private final String name;
        private final MapCodec<? extends NbtDataSource> codec;

        public static NbtDataSourceType forDataSource(NbtDataSource nbtDataSource) {
            if (nbtDataSource instanceof EntityNbtSource) {
                return ENTITY;
            }
            if (nbtDataSource instanceof BlockNbtSource) {
                return BLOCK;
            }
            if (nbtDataSource instanceof StorageNbtSource) {
                return STORAGE;
            }
            throw new IllegalArgumentException("Unknown data source type: " + nbtDataSource.getClass().getName());
        }

        @Override
        @Generated
        public String getName() {
            return this.name;
        }

        @Generated
        public MapCodec<? extends NbtDataSource> getCodec() {
            return this.codec;
        }

        @Generated
        private NbtDataSourceType(String string2, MapCodec<? extends NbtDataSource> mapCodec) {
            this.name = string2;
            this.codec = mapCodec;
        }
    }

    private static enum ComponentType implements TextCodecs_v1_20_3.TextComponentType
    {
        STRING("text", STRING_COMPONENT),
        TRANSLATION("translatable", TRANSLATION_COMPONENT),
        KEYBIND("keybind", KEYBIND_COMPONENT),
        SCORE("score", SCORE_COMPONENT),
        SELECTOR("selector", SELECTOR_COMPONENT),
        NBT("nbt", NBT_COMPONENT);

        private final String name;
        private final MapCodec<? extends TextComponent> codec;

        public static ComponentType forComponent(TextComponent textComponent) {
            if (textComponent instanceof StringComponent) {
                return STRING;
            }
            if (textComponent instanceof TranslationComponent) {
                return TRANSLATION;
            }
            if (textComponent instanceof KeybindComponent) {
                return KEYBIND;
            }
            if (textComponent instanceof ScoreComponent) {
                return SCORE;
            }
            if (textComponent instanceof SelectorComponent) {
                return SELECTOR;
            }
            if (textComponent instanceof NbtComponent) {
                return NBT;
            }
            throw new IllegalArgumentException("Unknown component type: " + textComponent.getClass().getName());
        }

        @Override
        @Generated
        public String getName() {
            return this.name;
        }

        @Override
        @Generated
        public MapCodec<? extends TextComponent> getCodec() {
            return this.codec;
        }

        @Generated
        private ComponentType(String string2, MapCodec<? extends TextComponent> mapCodec) {
            this.name = string2;
            this.codec = mapCodec;
        }
    }
}

