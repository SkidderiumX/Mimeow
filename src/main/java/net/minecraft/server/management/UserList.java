/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.server.management.UserListEntry;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserList<K, V extends UserListEntry<K>> {
    protected static final Logger logger = LogManager.getLogger();
    protected final Gson gson;
    private final File saveFile;
    private final Map<String, V> values = Maps.newHashMap();
    private boolean lanServer = true;
    private static final ParameterizedType saveFileFormat = new ParameterizedType(){

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{UserListEntry.class};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    };

    public UserList(File file) {
        this.saveFile = file;
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeHierarchyAdapter(UserListEntry.class, new Serializer());
        this.gson = gsonBuilder.create();
    }

    public boolean isLanServer() {
        return this.lanServer;
    }

    public void setLanServer(boolean bl) {
        this.lanServer = bl;
    }

    public void addEntry(V v) {
        this.values.put(this.getObjectKey(((UserListEntry)v).getValue()), v);
        try {
            this.writeChanges();
        }
        catch (IOException iOException) {
            logger.warn("Could not save the list after adding a user.", (Throwable)iOException);
        }
    }

    public V getEntry(K k) {
        this.removeExpired();
        return (V)((UserListEntry)this.values.get(this.getObjectKey(k)));
    }

    public void removeEntry(K k) {
        this.values.remove(this.getObjectKey(k));
        try {
            this.writeChanges();
        }
        catch (IOException iOException) {
            logger.warn("Could not save the list after removing a user.", (Throwable)iOException);
        }
    }

    public String[] getKeys() {
        return this.values.keySet().toArray(new String[this.values.size()]);
    }

    protected String getObjectKey(K k) {
        return k.toString();
    }

    protected boolean hasEntry(K k) {
        return this.values.containsKey(this.getObjectKey(k));
    }

    private void removeExpired() {
        ArrayList<Object> arrayList = Lists.newArrayList();
        for (Object object : this.values.values()) {
            if (!((UserListEntry)object).hasBanExpired()) continue;
            arrayList.add(((UserListEntry)object).getValue());
        }
        for (Object object : arrayList) {
            this.values.remove(object);
        }
    }

    protected UserListEntry<K> createEntry(JsonObject jsonObject) {
        return new UserListEntry<Object>(null, jsonObject);
    }

    protected Map<String, V> getValues() {
        return this.values;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeChanges() throws IOException {
        Collection<V> collection = this.values.values();
        String string = this.gson.toJson(collection);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newWriter(this.saveFile, Charsets.UTF_8);
            bufferedWriter.write(string);
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedWriter);
            throw throwable;
        }
        IOUtils.closeQuietly(bufferedWriter);
    }

    public class Serializer
    implements JsonDeserializer<UserListEntry<K>>,
    JsonSerializer<UserListEntry<K>> {
        private Serializer() {
        }

        @Override
        public JsonElement serialize(UserListEntry<K> userListEntry, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            userListEntry.onSerialization(jsonObject);
            return jsonObject;
        }

        @Override
        public UserListEntry<K> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                UserListEntry userListEntry = UserList.this.createEntry(jsonObject);
                return userListEntry;
            }
            return null;
        }
    }
}

