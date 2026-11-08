/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.MappingData1_13;
import com.viaversion.viaversion.util.GsonUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class BlockIdData {
    public static final Map<String, String[]> blockIdMapping = new HashMap<String, String[]>();
    public static final Map<String, String[]> fallbackReverseMapping = new HashMap<String, String[]>();
    public static final Int2ObjectMap<String> numberIdToString = new Int2ObjectOpenHashMap<String>();

    public static void init() {
        Map<String, List> map;
        Object object;
        Closeable closeable;
        InputStream inputStream2 = MappingData1_13.class.getClassLoader().getResourceAsStream("assets/viaversion/data/blockIds1.12to1.13.json");
        try {
            closeable = new InputStreamReader(inputStream2);
            try {
                object = (Map)GsonUtil.getGson().fromJson((Reader)closeable, new TypeToken<Map<String, String[]>>(){}.getType());
                blockIdMapping.putAll((Map<String, String[]>)object);
                map = new HashMap();
                for (Map.Entry<String, String[]> entry : blockIdMapping.entrySet()) {
                    for (String string2 : entry.getValue()) {
                        map.computeIfAbsent(string2, string -> new ArrayList()).add(entry.getKey());
                    }
                }
                map.forEach((string, list) -> fallbackReverseMapping.put((String)string, list.toArray(new String[0])));
            }
            finally {
                ((InputStreamReader)closeable).close();
            }
        }
        catch (IOException iOException) {
            Protocol1_12_2To1_13.LOGGER.log(Level.SEVERE, "Failed to load block id mappings", iOException);
        }
        closeable = MappingData1_13.class.getClassLoader().getResourceAsStream("assets/viaversion/data/blockNumberToString1.12.json");
        try {
            object = new InputStreamReader((InputStream)closeable);
            try {
                map = (Map)GsonUtil.getGson().fromJson((Reader)object, new TypeToken<Map<Integer, String>>(){}.getType());
                numberIdToString.putAll(map);
            }
            finally {
                ((InputStreamReader)object).close();
            }
        }
        catch (IOException iOException) {
            Protocol1_12_2To1_13.LOGGER.log(Level.SEVERE, "Failed to load block number to string mappings", iOException);
        }
    }
}

