/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.BackwardsItemMappings;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.BlockStates1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.StatisticMappings1_13;
import java.util.HashMap;
import java.util.Map;

public class BackwardsMappingData1_13
extends BackwardsMappingData {
    private final Int2ObjectMap<String> statisticMappings = new Int2ObjectOpenHashMap<String>();
    private final Map<String, String> translateMappings = new HashMap<String, String>();
    private final Object2IntMap<String> pistonIds = new Object2IntOpenHashMap<String>();

    public BackwardsMappingData1_13() {
        super("1.13", "1.12", Protocol1_12_2To1_13.class);
    }

    @Override
    public void loadExtras(CompoundTag compoundTag) {
        super.loadExtras(compoundTag);
        for (Map.Entry<String, Integer> object : StatisticMappings1_13.CUSTOM_STATS.entrySet()) {
            this.statisticMappings.put((int)object.getValue(), object.getKey());
        }
        for (Map.Entry<String, Object> entry : Protocol1_12_2To1_13.MAPPINGS.getTranslateMapping().entrySet()) {
            this.translateMappings.put((String)entry.getValue(), entry.getKey());
        }
        this.pistonIds.defaultReturnValue(-1);
        Object2IntMap<String> object2IntMap = ConnectionData.getKeyToId();
        if (!object2IntMap.isEmpty()) {
            for (Object2IntMap.Entry entry : object2IntMap.object2IntEntrySet()) {
                if (!((String)entry.getKey()).contains("piston")) continue;
                this.addPistonEntries((String)entry.getKey(), entry.getIntValue());
            }
        } else {
            CompoundTag compoundTag2 = MappingDataLoader.INSTANCE.loadNBT("blockstates-1.13.nbt");
            BlockStates1_13.forEach(compoundTag2, (string, n) -> {
                if (string.contains("piston")) {
                    this.addPistonEntries((String)string, n);
                }
            });
        }
    }

    @Override
    protected void loadBackwardsItemMappings(CompoundTag compoundTag) {
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            int n = Integer.parseInt(entry.getKey());
            int n2 = ((NumberTag)entry.getValue()).asInt();
            String string = BackwardsItemMappings.identifier(n);
            String string2 = this.unmappedVersion + " " + BackwardsMappingData1_13.nameFromIdentifier(string);
            this.backwardsItemMappings.put(n, new MappedItem(this.getNewItemId(n), string, string2, n2));
        }
    }

    private void addPistonEntries(String object, int n) {
        n = this.getNewBlockStateId(n);
        this.pistonIds.put((String)object, n);
        String string = ((String)object).substring(10);
        if (!string.startsWith("piston") && !string.startsWith("sticky_piston")) {
            return;
        }
        String[] stringArray = ((String)object).substring(0, ((String)object).length() - 1).split("\\[");
        String[] stringArray2 = stringArray[1].split(",");
        object = stringArray[0] + "[" + stringArray2[1] + "," + stringArray2[0] + "]";
        this.pistonIds.put((String)object, n);
    }

    @Override
    public int getNewBlockStateId(int n) {
        if (n >= 5635 && n <= 5650) {
            int n2 = super.getNewBlockStateId(n);
            if (n2 >= 2400) {
                n2 -= 16;
            }
            return n2;
        }
        int n3 = super.getNewBlockStateId(n);
        return switch (n3) {
            case 1595, 1596, 1597 -> 1584;
            case 1611, 1612, 1613 -> 1600;
            default -> n3;
        };
    }

    @Override
    protected int checkValidity(int n, int n2, String string) {
        return n2;
    }

    public Int2ObjectMap<String> getStatisticMappings() {
        return this.statisticMappings;
    }

    public Map<String, String> getTranslateMappings() {
        return this.translateMappings;
    }

    public Object2IntMap<String> getPistonIds() {
        return this.pistonIds;
    }
}

