/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistrySimple;

public class IMetadataSerializer {
    private final IRegistry<String, Registration<? extends IMetadataSection>> metadataSectionSerializerRegistry = new RegistrySimple<String, Registration<? extends IMetadataSection>>();
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson;

    public IMetadataSerializer() {
        this.gsonBuilder.registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer());
        this.gsonBuilder.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
        this.gsonBuilder.registerTypeAdapterFactory(new EnumTypeAdapterFactory());
    }

    public <T extends IMetadataSection> void registerMetadataSectionType(IMetadataSectionSerializer<T> iMetadataSectionSerializer, Class<T> clazz) {
        this.metadataSectionSerializerRegistry.putObject(iMetadataSectionSerializer.getSectionName(), new Registration<T>(iMetadataSectionSerializer, clazz));
        this.gsonBuilder.registerTypeAdapter(clazz, iMetadataSectionSerializer);
        this.gson = null;
    }

    public <T extends IMetadataSection> T parseMetadataSection(String string, JsonObject jsonObject) {
        if (string == null) {
            throw new IllegalArgumentException("Metadata section name cannot be null");
        }
        if (!jsonObject.has(string)) {
            return (T)((IMetadataSection)null);
        }
        if (!jsonObject.get(string).isJsonObject()) {
            throw new IllegalArgumentException("Invalid metadata for '" + string + "' - expected object, found " + String.valueOf(jsonObject.get(string)));
        }
        Registration<? extends IMetadataSection> registration = this.metadataSectionSerializerRegistry.getObject(string);
        if (registration == null) {
            throw new IllegalArgumentException("Don't know how to handle metadata section '" + string + "'");
        }
        return (T)((IMetadataSection)this.getGson().fromJson((JsonElement)jsonObject.getAsJsonObject(string), registration.clazz));
    }

    private Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonBuilder.create();
        }
        return this.gson;
    }

    public class Registration<T extends IMetadataSection> {
        final IMetadataSectionSerializer<T> section;
        final Class<T> clazz;

        private Registration(IMetadataSectionSerializer<T> iMetadataSectionSerializer, Class<T> clazz) {
            this.section = iMetadataSectionSerializer;
            this.clazz = clazz;
        }
    }
}

