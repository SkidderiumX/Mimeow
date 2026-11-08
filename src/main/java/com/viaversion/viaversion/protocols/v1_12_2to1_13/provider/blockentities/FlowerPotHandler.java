/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;

public class FlowerPotHandler
implements BlockEntityProvider.BlockEntityHandler {
    private static final int EMPTY_POT = 5265;
    private static final Map<String, Byte> STRING_TO_BYTE_ID = new HashMap<String, Byte>();
    private static final Map<IntIdPair, Integer> FLOWERS = new HashMap<IntIdPair, Integer>();

    private static void register(String string, byte by, byte by2, int n) {
        STRING_TO_BYTE_ID.put(string, by);
        FLOWERS.put(new IntIdPair(by, by2), n);
    }

    @Override
    public int transform(UserConnection userConnection, CompoundTag compoundTag) {
        Object object;
        Tag tag = compoundTag.get("Item");
        byte by = 0;
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            by = STRING_TO_BYTE_ID.getOrDefault(Key.stripMinecraftNamespace(stringTag.getValue()), (byte)0);
        } else if (tag instanceof NumberTag) {
            object = (NumberTag)tag;
            by = object.asByte();
        }
        byte by2 = 0;
        Tag tag2 = compoundTag.get("Data");
        if (tag2 instanceof NumberTag) {
            object = (NumberTag)tag2;
            by2 = object.asByte();
        }
        if ((object = FLOWERS.get(new IntIdPair(by, by2))) != null) {
            return (Integer)object;
        }
        object = FLOWERS.get(new IntIdPair(by, 0));
        if (object != null) {
            return (Integer)object;
        }
        return 5265;
    }

    static {
        FlowerPotHandler.register("air", (byte)0, (byte)0, 5265);
        FlowerPotHandler.register("sapling", (byte)6, (byte)0, 5266);
        FlowerPotHandler.register("sapling", (byte)6, (byte)1, 5267);
        FlowerPotHandler.register("sapling", (byte)6, (byte)2, 5268);
        FlowerPotHandler.register("sapling", (byte)6, (byte)3, 5269);
        FlowerPotHandler.register("sapling", (byte)6, (byte)4, 5270);
        FlowerPotHandler.register("sapling", (byte)6, (byte)5, 5271);
        FlowerPotHandler.register("tallgrass", (byte)31, (byte)2, 5272);
        FlowerPotHandler.register("yellow_flower", (byte)37, (byte)0, 5273);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)0, 5274);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)1, 5275);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)2, 5276);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)3, 5277);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)4, 5278);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)5, 5279);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)6, 5280);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)7, 5281);
        FlowerPotHandler.register("red_flower", (byte)38, (byte)8, 5282);
        FlowerPotHandler.register("red_mushroom", (byte)40, (byte)0, 5283);
        FlowerPotHandler.register("brown_mushroom", (byte)39, (byte)0, 5284);
        FlowerPotHandler.register("deadbush", (byte)32, (byte)0, 5285);
        FlowerPotHandler.register("cactus", (byte)81, (byte)0, 5286);
    }

    private record IntIdPair(int id, byte data) {
    }
}

