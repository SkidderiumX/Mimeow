/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3;

import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.impl.LazyInitCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.map.MapCodecMerger;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.JavaConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FuzzyMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.StrictSelectorMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
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
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3.StyleCodecs_v1_20_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.Generated;

public class TextCodecs_v1_20_3 {
    public static final Codec<TextComponent> TEXT = new LazyInitCodec<TextComponent>(() -> Codec.recursive(codec -> TextCodecs_v1_20_3.createCodec((Codec)codec, StyleCodecs_v1_20_3.MAP_CODEC, (TextComponentType[])ComponentType.values(), ComponentType::forComponent)));
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

    public static <T extends TextComponentType> Codec<TextComponent> createCodec(Codec<TextComponent> codec, MapCodec<Style> mapCodec, T[] TArray, Function<TextComponent, T> function) {
        MapCodec mapCodec2 = TextCodecs_v1_20_3.createLegacyComponentMatcher(TArray, TextComponentType::getCodec, function, (String)"type");
        Codec<TextComponent> codec2 = MapCodecMerger.codec(mapCodec2, Function.identity(), codec.nonEmptyList().mapCodec("extra").optional().defaulted(List::isEmpty, ArrayList::new), TextComponent::getSiblings, mapCodec, TextComponent::getStyle, (textComponent, list, style) -> textComponent.append((Iterable<TextComponent>)list).setStyle((Style)style));
        return Codec.either(Codec.either(Codec.STRING, codec.nonEmptyList()), codec2).map(textComponent -> {
            String string = TextCodecs_v1_20_3.tryCollapse(textComponent);
            if (string != null) {
                return Either.left(Either.left(string));
            }
            return Either.right(textComponent);
        }, either2 -> either2.xmap(either -> either.xmap(StringComponent::new, TextCodecs_v1_20_3::mergeComponents), textComponent -> textComponent));
    }

    public static <T extends NamedType, E> MapCodec<E> createLegacyComponentMatcher(T[] TArray, Function<T, MapCodec<? extends E>> function, Function<E, T> function2, String string) {
        ArrayList arrayList = new ArrayList();
        for (T t : TArray) {
            arrayList.add(function.apply(t));
        }
        FuzzyMapCodec<Object> fuzzyMapCodec = new FuzzyMapCodec<Object>(arrayList, object -> (MapCodec)function.apply(function2.apply(object)));
        Codec codec = Codec.named(TArray);
        MapCodec<E> mapCodec = codec.typedMap(string, function2, function);
        return new StrictSelectorMapCodec<Object>(string, mapCodec, fuzzyMapCodec);
    }

    @Nullable
    public static String tryCollapse(TextComponent textComponent) {
        if (textComponent instanceof StringComponent && textComponent.getSiblings().isEmpty() && textComponent.getStyle().isEmpty()) {
            return ((StringComponent)textComponent).getText();
        }
        return null;
    }

    private static TextComponent mergeComponents(List<TextComponent> list) {
        TextComponent textComponent = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            textComponent = textComponent.append(list.get(i));
        }
        return textComponent;
    }

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

    private static enum ComponentType implements TextComponentType
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

    public static interface TextComponentType
    extends NamedType {
        public MapCodec<? extends TextComponent> getCodec();
    }
}

