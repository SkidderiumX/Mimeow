/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtSerializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtSerializer;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.SNbtDeserializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.SNbtSerializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_13.SNbtDeserializer_v1_13;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_14.SNbtDeserializer_v1_14;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_14.SNbtSerializer_v1_14;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_21_5.SNbtDeserializer_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_7.SNbtDeserializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_7.SNbtSerializer_v1_7;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_8.SNbtDeserializer_v1_8;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_8.SNbtSerializer_v1_8;
import java.util.function.Supplier;
import javax.annotation.Nullable;

public class SNbt<T extends Tag> {
    public static final SNbt<Tag> V1_7 = new SNbt(SNbtSerializer_v1_7::new, SNbtDeserializer_v1_7::new);
    public static final SNbt<CompoundTag> V1_8 = new SNbt(SNbtSerializer_v1_8::new, SNbtDeserializer_v1_8::new);
    public static final SNbt<CompoundTag> V1_12 = new SNbt(SNbtSerializer_v1_12::new, SNbtDeserializer_v1_12::new);
    public static final SNbt<CompoundTag> V1_13 = new SNbt(SNbtSerializer_v1_12::new, SNbtDeserializer_v1_13::new);
    public static final SNbt<CompoundTag> V1_14 = new SNbt(SNbtSerializer_v1_14::new, SNbtDeserializer_v1_14::new);
    public static final SNbt<CompoundTag> V1_21_5 = new SNbt(SNbtSerializer_v1_14::new, SNbtDeserializer_v1_21_5::new);
    public static final SNbt<CompoundTag> LATEST = V1_21_5;
    private final Supplier<SNbtSerializer> serializerSupplier;
    private final Supplier<SNbtDeserializer<T>> deserializerSupplier;
    private SNbtSerializer serializer;
    private SNbtDeserializer<T> deserializer;

    public SNbt(Supplier<SNbtSerializer> supplier, Supplier<SNbtDeserializer<T>> supplier2) {
        this.serializerSupplier = supplier;
        this.deserializerSupplier = supplier2;
    }

    public SNbtSerializer getSerializer() {
        if (this.serializer == null) {
            this.serializer = this.serializerSupplier.get();
        }
        return this.serializer;
    }

    public SNbtDeserializer<T> getDeserializer() {
        if (this.deserializer == null) {
            this.deserializer = this.deserializerSupplier.get();
        }
        return this.deserializer;
    }

    public String serialize(Tag tag) throws SNbtSerializeException {
        return this.getSerializer().serialize(tag);
    }

    @Nullable
    public String trySerialize(Tag tag) {
        try {
            return this.serialize(tag);
        }
        catch (SNbtSerializeException sNbtSerializeException) {
            return null;
        }
    }

    public T deserialize(String string) throws SNbtDeserializeException {
        return this.getDeserializer().deserialize(string);
    }

    @Nullable
    public T tryDeserialize(String string) {
        try {
            return this.deserialize(string);
        }
        catch (SNbtDeserializeException sNbtDeserializeException) {
            return null;
        }
    }
}

