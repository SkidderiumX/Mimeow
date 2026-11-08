/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.google.common.annotations.Beta;
import com.viaversion.nbt.io.NBTIO;
import com.viaversion.nbt.io.TagReader;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.IdentityMappings;
import com.viaversion.viaversion.api.data.IntArrayMappings;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.util.GsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingDataLoader {
    public static final MappingDataLoader INSTANCE = new MappingDataLoader(MappingDataLoader.class, "assets/viaversion/data/");
    public static final TagReader<CompoundTag> MAPPINGS_READER = NBTIO.reader(CompoundTag.class).named();
    private static final Map<String, String[]> GLOBAL_IDENTIFIER_INDEXES = new HashMap<String, String[]>();
    private static final int VERSION = 2;
    private static final byte DIRECT_ID = 0;
    private static final byte SHIFTS_ID = 1;
    private static final byte CHANGES_ID = 2;
    private static final byte IDENTITY_ID = 3;
    private final Map<String, CompoundTag> mappingsCache = new ConcurrentHashMap<String, CompoundTag>();
    private final Class<?> dataLoaderClass;
    private final String dataPath;
    private volatile boolean cacheValid = true;

    public MappingDataLoader(Class<?> clazz, String string) {
        this.dataLoaderClass = clazz;
        this.dataPath = string;
    }

    public static void loadGlobalIdentifiers() {
        CompoundTag compoundTag = INSTANCE.loadNBT("identifier-table.nbt");
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            ListTag listTag = (ListTag)entry.getValue();
            int n = listTag.size();
            String[] stringArray = new String[n];
            for (int i = 0; i < n; ++i) {
                stringArray[i] = ((StringTag)listTag.get(i)).getValue();
            }
            GLOBAL_IDENTIFIER_INDEXES.put(entry.getKey(), stringArray);
        }
    }

    public @Nullable String identifierFromGlobalId(String string, int n) {
        String[] stringArray = GLOBAL_IDENTIFIER_INDEXES.get(string);
        if (stringArray == null) {
            throw new IllegalArgumentException("Unknown global identifier key: " + string);
        }
        if (n < 0 || n >= stringArray.length) {
            throw new IllegalArgumentException("Unknown global identifier index: " + string + "/" + n);
        }
        return stringArray[n];
    }

    public void clearCache() {
        this.cacheValid = false;
        this.mappingsCache.clear();
    }

    public @Nullable JsonObject loadFromDataDir(String string) {
        JsonObject jsonObject;
        File file = new File(this.getDataFolder(), string);
        if (!file.exists()) {
            return this.loadData(string);
        }
        FileReader fileReader = new FileReader(file);
        try {
            jsonObject = GsonUtil.getGson().fromJson((Reader)fileReader, JsonObject.class);
        }
        catch (Throwable throwable) {
            try {
                try {
                    fileReader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (JsonSyntaxException jsonSyntaxException) {
                this.getLogger().warning(string + " is badly formatted!");
                throw new RuntimeException(jsonSyntaxException);
            }
            catch (JsonIOException | IOException exception) {
                throw new RuntimeException(exception);
            }
        }
        fileReader.close();
        return jsonObject;
    }

    public @Nullable JsonObject loadData(String string) {
        JsonObject jsonObject;
        InputStream inputStream2 = this.getResource(string);
        if (inputStream2 == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2);
        try {
            jsonObject = GsonUtil.getGson().fromJson((Reader)inputStreamReader, JsonObject.class);
        }
        catch (Throwable throwable) {
            try {
                try {
                    inputStreamReader.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        inputStreamReader.close();
        return jsonObject;
    }

    public @Nullable CompoundTag loadNBT(String string, boolean bl) {
        if (!this.cacheValid) {
            return this.loadNBTFromFile(string);
        }
        if (bl) {
            return this.mappingsCache.computeIfAbsent(string, this::loadNBTFromFile);
        }
        CompoundTag compoundTag = this.mappingsCache.get(string);
        return compoundTag != null ? compoundTag : this.loadNBTFromFile(string);
    }

    public @Nullable CompoundTag loadNBT(String string) {
        return this.loadNBT(string, false);
    }

    public @Nullable CompoundTag loadNBTFromFile(String string) {
        CompoundTag compoundTag;
        InputStream inputStream2 = this.getResource(string);
        if (inputStream2 == null) {
            return null;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
        try {
            compoundTag = MAPPINGS_READER.read(bufferedInputStream);
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((InputStream)bufferedInputStream).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        ((InputStream)bufferedInputStream).close();
        return compoundTag;
    }

    public @Nullable Mappings loadMappings(CompoundTag compoundTag, String string) {
        return this.loadMappings(compoundTag, string, n -> {
            int[] nArray = new int[n];
            Arrays.fill(nArray, -1);
            return nArray;
        }, (nArray, n, n2) -> {
            nArray[n] = n2;
        }, IntArrayMappings::of);
    }

    @Beta
    public <M extends Mappings, V> @Nullable Mappings loadMappings(CompoundTag compoundTag, String string, MappingHolderSupplier<V> mappingHolderSupplier, AddConsumer<V> addConsumer, MappingsSupplier<M, V> mappingsSupplier) {
        V v;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 == null) {
            return null;
        }
        int n = compoundTag.getInt("version", -1);
        if (n != 2) {
            throw new IllegalArgumentException("Invalid version: " + n);
        }
        int n2 = compoundTag2.getInt("mappedSize", -1);
        byte by = compoundTag2.getByteTag("id").asByte();
        if (by == 0) {
            int n3 = compoundTag2.getIntTag("size").asInt();
            ByteBuf byteBuf = Unpooled.wrappedBuffer(compoundTag2.getByteArrayTag("val").getValue());
            int[] nArray = new int[n3];
            int n4 = 0;
            for (int i = 0; i < n3; ++i) {
                nArray[i] = n4 += MappingDataLoader.readZigZagVarInt(byteBuf);
            }
            return IntArrayMappings.of(nArray, n2);
        }
        if (by == 1) {
            int n5;
            int n6;
            ValuePairs valuePairs = MappingDataLoader.readAtValuePairs(compoundTag2);
            int[] nArray = valuePairs.first;
            int[] nArray2 = valuePairs.second;
            int n7 = compoundTag2.getIntTag("size").asInt();
            v = mappingHolderSupplier.get(n7);
            if (nArray[0] != 0) {
                n6 = nArray[0];
                for (n5 = 0; n5 < n6; ++n5) {
                    addConsumer.addTo(v, n5, n5);
                }
            }
            for (n6 = 0; n6 < nArray.length; ++n6) {
                n5 = n6 == nArray.length - 1 ? 1 : 0;
                int n8 = nArray[n6];
                int n9 = n5 != 0 ? n7 : nArray[n6 + 1];
                int n10 = nArray2[n6];
                for (int i = n8; i < n9; ++i) {
                    addConsumer.addTo(v, i, n10++);
                }
            }
        } else if (by == 2) {
            int n11;
            ValuePairs valuePairs = MappingDataLoader.readAtValuePairs(compoundTag2);
            int[] nArray = valuePairs.first;
            int[] nArray3 = valuePairs.second;
            int n12 = compoundTag2.getIntTag("size").asInt();
            boolean bl = compoundTag2.get("nofill") == null;
            v = mappingHolderSupplier.get(n12);
            int n13 = 0;
            for (n11 = 0; n11 < nArray.length; ++n11) {
                int n14 = nArray[n11];
                if (bl) {
                    for (int i = n13; i < n14; ++i) {
                        addConsumer.addTo(v, i, i);
                    }
                    n13 = n14 + 1;
                }
                addConsumer.addTo(v, n14, nArray3[n11]);
            }
            if (bl && n13 != n12) {
                for (n11 = n13; n11 < n12; ++n11) {
                    addConsumer.addTo(v, n11, n11);
                }
            }
        } else {
            if (by == 3) {
                IntTag intTag = compoundTag2.getIntTag("size");
                return new IdentityMappings(intTag.asInt(), n2);
            }
            throw new IllegalArgumentException("Unknown serialization strategy: " + by);
        }
        return mappingsSupplier.create(v, n2);
    }

    private static ValuePairs readAtValuePairs(CompoundTag compoundTag) {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(compoundTag.getByteArrayTag("val").getValue());
        IntArrayList intArrayList = new IntArrayList();
        IntArrayList intArrayList2 = new IntArrayList();
        int n = -1;
        int n2 = 0;
        while (byteBuf.isReadable()) {
            n = n + 1 + Types.VAR_INT.readPrimitive(byteBuf);
            intArrayList.add(n);
            intArrayList2.add(n2 += MappingDataLoader.readZigZagVarInt(byteBuf));
        }
        return new ValuePairs(intArrayList.toIntArray(), intArrayList2.toIntArray());
    }

    private static int readZigZagVarInt(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        return n >>> 1 ^ -(n & 1);
    }

    public @Nullable List<String> identifiersFromGlobalIds(CompoundTag compoundTag, String string) {
        Mappings mappings = this.loadMappings(compoundTag, string);
        return mappings != null ? this.identifiers(mappings, string) : null;
    }

    public @Nullable IdentifiersPair identifiersFromGlobalIds(CompoundTag compoundTag, CompoundTag compoundTag2, String string) {
        Mappings mappings = this.loadMappings(compoundTag, string);
        if (mappings == null) {
            return null;
        }
        Mappings mappings2 = this.loadMappings(compoundTag2, string);
        if (mappings2 == null) {
            return null;
        }
        int n = mappings.size();
        if (n != mappings2.size()) {
            return new IdentifiersPair(this.identifiers(mappings, string), this.identifiers(mappings2, string), false);
        }
        ArrayList<String> arrayList = new ArrayList<String>(n);
        ArrayList<String> arrayList2 = new ArrayList<String>(n);
        boolean bl = true;
        for (int i = 0; i < n; ++i) {
            int n2 = mappings.getNewId(i);
            int n3 = mappings2.getNewId(i);
            String string2 = this.identifierFromGlobalId(string, n2);
            if (n2 == n3) {
                arrayList.add(string2);
                arrayList2.add(string2);
                continue;
            }
            if (n3 == -1) {
                throw new IllegalArgumentException("Mapped global id -1 for unmapped global id: " + string + "/" + string2 + " (" + n2 + ")");
            }
            bl = false;
            arrayList.add(string2);
            arrayList2.add(this.identifierFromGlobalId(string, n3));
        }
        return bl ? new IdentifiersPair(arrayList) : new IdentifiersPair(arrayList, arrayList2);
    }

    private List<String> identifiers(Mappings mappings, String string) {
        int n = mappings.size();
        ArrayList<String> arrayList = new ArrayList<String>(n);
        for (int i = 0; i < n; ++i) {
            int n2 = mappings.getNewId(i);
            arrayList.add(this.identifierFromGlobalId(string, n2));
        }
        return arrayList;
    }

    public Object2IntMap<String> indexedObjectToMap(JsonObject jsonObject) {
        Object2IntOpenHashMap<String> object2IntOpenHashMap = new Object2IntOpenHashMap<String>(jsonObject.size());
        object2IntOpenHashMap.defaultReturnValue(-1);
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            object2IntOpenHashMap.put(entry.getValue().getAsString(), Integer.parseInt(entry.getKey()));
        }
        return object2IntOpenHashMap;
    }

    public Object2IntMap<String> arrayToMap(JsonArray jsonArray) {
        Object2IntOpenHashMap<String> object2IntOpenHashMap = new Object2IntOpenHashMap<String>(jsonArray.size());
        object2IntOpenHashMap.defaultReturnValue(-1);
        for (int i = 0; i < jsonArray.size(); ++i) {
            object2IntOpenHashMap.put(jsonArray.get(i).getAsString(), i);
        }
        return object2IntOpenHashMap;
    }

    public Logger getLogger() {
        return Via.getPlatform().getLogger();
    }

    public File getDataFolder() {
        return Via.getPlatform().getDataFolder();
    }

    public @Nullable InputStream getResource(String string) {
        return this.dataLoaderClass.getClassLoader().getResourceAsStream(this.dataPath + string);
    }

    @FunctionalInterface
    public static interface MappingHolderSupplier<T> {
        public T get(int var1);
    }

    @FunctionalInterface
    public static interface AddConsumer<T> {
        public void addTo(T var1, int var2, int var3);
    }

    @FunctionalInterface
    public static interface MappingsSupplier<T extends Mappings, V> {
        public T create(V var1, int var2);
    }

    private record ValuePairs(int[] first, int[] second) {
    }

    public record IdentifiersPair(List<String> unmapped, List<String> mapped, boolean identity) {
        public IdentifiersPair(List<String> list, List<String> list2) {
            this(list, list2, false);
        }

        public IdentifiersPair(List<String> list) {
            this(list, list, true);
        }
    }
}

