/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemTagStorage
implements StorableObject {
    private Map<String, int[]> itemTags = new HashMap<String, int[]>();

    public int @Nullable [] itemTag(String string) {
        return this.itemTags.get(Key.stripMinecraftNamespace(string));
    }

    public void readItemTags(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            String string = packetWrapper.passthrough(Types.STRING);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            boolean bl = Key.stripMinecraftNamespace(string).equals("item");
            if (bl) {
                this.itemTags = new HashMap<String, int[]>(n2);
            }
            for (int j = 0; j < n2; ++j) {
                String string2 = packetWrapper.passthrough(Types.STRING);
                int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if (!bl) continue;
                this.itemTags.put(Key.stripMinecraftNamespace(string2), nArray);
            }
        }
    }
}

