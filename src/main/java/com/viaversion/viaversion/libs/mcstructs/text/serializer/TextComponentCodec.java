/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.internal.Streams;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.JsonConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_5.JsonConverter_v1_20_5;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_21_5.NbtConverter_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtSerializeException;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3.StyleCodecs_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3.TextCodecs_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5.StyleCodecs_v1_20_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5.TextCodecs_v1_20_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_2.StyleCodecs_v1_21_2;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_2.TextCodecs_v1_21_2;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_4.StyleCodecs_v1_21_4;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_4.TextCodecs_v1_21_4;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5.StyleCodecs_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5.TextCodecs_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_6.StyleCodecs_v1_21_6;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_6.TextCodecs_v1_21_6;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_9.StyleCodecs_v1_21_9;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_9.TextCodecs_v1_21_9;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v26_1.StyleCodecs_v26_1;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v26_1.TextCodecs_v26_1;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.TextVerifier;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.VerifyingConverter;
import java.io.StringReader;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class TextComponentCodec {
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();
    public static final TextComponentCodec V1_20_3 = new TextComponentCodec(() -> SNbt.V1_14, () -> TextCodecs_v1_20_3.TEXT, () -> StyleCodecs_v1_20_3.CODEC, JsonConverter_v1_20_3.INSTANCE, NbtConverter_v1_20_3.INSTANCE);
    public static final TextComponentCodec V1_20_5 = new TextComponentCodec(() -> SNbt.V1_14, () -> TextCodecs_v1_20_5.TEXT, () -> StyleCodecs_v1_20_5.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_20_3.INSTANCE);
    public static final TextComponentCodec V1_21_2 = new TextComponentCodec(() -> SNbt.V1_14, () -> TextCodecs_v1_21_2.TEXT, () -> StyleCodecs_v1_21_2.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_20_3.INSTANCE);
    public static final TextComponentCodec V1_21_4 = new TextComponentCodec(() -> SNbt.V1_14, () -> TextCodecs_v1_21_4.TEXT, () -> StyleCodecs_v1_21_4.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_20_3.INSTANCE);
    public static final TextComponentCodec V1_21_5 = new TextComponentCodec(() -> SNbt.V1_21_5, () -> TextCodecs_v1_21_5.TEXT, () -> StyleCodecs_v1_21_5.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_21_5.INSTANCE);
    public static final TextComponentCodec V1_21_6 = new TextComponentCodec(() -> SNbt.V1_21_5, () -> TextCodecs_v1_21_6.TEXT, () -> StyleCodecs_v1_21_6.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_21_5.INSTANCE);
    public static final TextComponentCodec V1_21_9 = new TextComponentCodec(() -> SNbt.V1_21_5, () -> TextCodecs_v1_21_9.TEXT, () -> StyleCodecs_v1_21_9.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_21_5.INSTANCE);
    public static final TextComponentCodec V26_1;
    public static final TextComponentCodec LATEST;
    private final Supplier<SNbt<CompoundTag>> sNbtSupplier;
    private final Supplier<Codec<TextComponent>> textCodecSupplier;
    private final Supplier<Codec<Style>> styleCodecSupplier;
    private final DataConverter<JsonElement> jsonConverter;
    private final DataConverter<Tag> nbtConverter;
    private SNbt<CompoundTag> sNbt;
    private Codec<TextComponent> textCodec;
    private Codec<Style> styleCodec;

    public TextComponentCodec(Supplier<SNbt<CompoundTag>> supplier, Supplier<Codec<TextComponent>> supplier2, Supplier<Codec<Style>> supplier3, DataConverter<JsonElement> dataConverter, DataConverter<Tag> dataConverter2) {
        this.sNbtSupplier = supplier;
        this.textCodecSupplier = supplier2;
        this.styleCodecSupplier = supplier3;
        this.jsonConverter = dataConverter;
        this.nbtConverter = dataConverter2;
    }

    private SNbt<CompoundTag> getSNbtSerializer() {
        if (this.sNbt == null) {
            this.sNbt = this.sNbtSupplier.get();
        }
        return this.sNbtSupplier.get();
    }

    public Codec<TextComponent> getTextCodec() {
        if (this.textCodec == null) {
            this.textCodec = this.textCodecSupplier.get();
        }
        return this.textCodec;
    }

    public Codec<Style> getStyleCodec() {
        if (this.styleCodec == null) {
            this.styleCodec = this.styleCodecSupplier.get();
        }
        return this.styleCodec;
    }

    public DataConverter<JsonElement> getJsonConverter() {
        return this.jsonConverter;
    }

    public DataConverter<Tag> getNbtConverter() {
        return this.nbtConverter;
    }

    public TextComponentCodec withVerifier(TextVerifier textVerifier) {
        return new TextComponentCodec(this.sNbtSupplier, this.textCodecSupplier, this.styleCodecSupplier, new VerifyingConverter<JsonElement>(this.jsonConverter, textVerifier), new VerifyingConverter<Tag>(this.nbtConverter, textVerifier));
    }

    public TextComponent deserializeJson(String string) {
        return this.deserializeJsonTree(JsonParser.parseString(string));
    }

    public TextComponent deserializeJsonReader(String string) {
        JsonReader jsonReader = new JsonReader(new StringReader(string));
        jsonReader.setLenient(false);
        try {
            return this.deserialize(Streams.parse(jsonReader));
        }
        catch (StackOverflowError stackOverflowError) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", stackOverflowError);
        }
    }

    public TextComponent deserializeLenientJson(String string) {
        JsonReader jsonReader = new JsonReader(new StringReader(string));
        jsonReader.setLenient(true);
        return this.deserializeJsonTree(JsonParser.parseReader(jsonReader));
    }

    public TextComponent deserializeNbt(String string) {
        try {
            return this.deserialize(this.getSNbtSerializer().getDeserializer().deserializeValue(string));
        }
        catch (SNbtDeserializeException sNbtDeserializeException) {
            throw new RuntimeException("Failed to deserialize SNbt", sNbtDeserializeException);
        }
    }

    public TextComponent deserializeJsonTree(@Nullable JsonElement jsonElement) {
        if (jsonElement == null) {
            return null;
        }
        return this.deserialize(jsonElement);
    }

    public TextComponent deserializeNbtTree(@Nullable Tag tag) {
        if (tag == null) {
            return null;
        }
        return this.deserialize(tag);
    }

    public TextComponent deserialize(JsonElement jsonElement) {
        return (TextComponent)this.getTextCodec().deserialize(this.jsonConverter, jsonElement).getOrThrow(JsonParseException::new);
    }

    public TextComponent deserialize(Tag tag) {
        return (TextComponent)this.getTextCodec().deserialize(this.nbtConverter, tag).get();
    }

    public JsonElement serializeJsonTree(TextComponent textComponent) {
        return this.getTextCodec().serialize(this.jsonConverter, textComponent).getOrThrow(JsonParseException::new);
    }

    public Tag serializeNbtTree(TextComponent textComponent) {
        return this.getTextCodec().serialize(this.nbtConverter, textComponent).get();
    }

    public String serializeJsonString(TextComponent textComponent) {
        return GSON.toJson(this.serializeJsonTree(textComponent));
    }

    public String serializeNbtString(TextComponent textComponent) {
        try {
            return this.getSNbtSerializer().serialize(this.serializeNbtTree(textComponent));
        }
        catch (SNbtSerializeException sNbtSerializeException) {
            throw new RuntimeException("Failed to serialize SNbt", sNbtSerializeException);
        }
    }

    public TextComponentSerializer asSerializer() {
        return new TextComponentSerializer(this, () -> new GsonBuilder().registerTypeHierarchyAdapter(TextComponent.class, (textComponent, type, jsonSerializationContext) -> this.serializeJsonTree((TextComponent)textComponent)).registerTypeHierarchyAdapter(TextComponent.class, (jsonElement, type, jsonDeserializationContext) -> this.deserializeJsonTree(jsonElement)).disableHtmlEscaping().create());
    }

    static {
        LATEST = V26_1 = new TextComponentCodec(() -> SNbt.V1_21_5, () -> TextCodecs_v26_1.TEXT, () -> StyleCodecs_v26_1.CODEC, JsonConverter_v1_20_5.INSTANCE, NbtConverter_v1_21_5.INSTANCE);
    }
}

