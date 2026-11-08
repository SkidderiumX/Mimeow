/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viabackwards.api.data.MappedLegacyBlockItem;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriterBase;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.data.BlockColors1_11_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.IdAndData;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class LegacyBlockItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends BackwardsItemRewriterBase<C, S, T> {
    protected final Int2ObjectMap<MappedLegacyBlockItem> itemReplacements = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);
    protected final Int2ObjectMap<MappedLegacyBlockItem> blockReplacements = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);

    protected LegacyBlockItemRewriter(T t, String string, Type<Item> type, Type<Item[]> type2, Type<Item> type3, Type<Item[]> type4) {
        super(t, type, type2, type3, type4, false);
        Int2ObjectOpenHashMap<MappedLegacyBlockItem> int2ObjectOpenHashMap = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);
        JsonObject jsonObject = this.readMappingsFile("item-mappings-" + string + ".json");
        this.addMappings(MappedLegacyBlockItem.Type.ITEM, jsonObject, this.itemReplacements);
        this.addMappings(MappedLegacyBlockItem.Type.BLOCK_ITEM, jsonObject, int2ObjectOpenHashMap);
        this.addMappings(MappedLegacyBlockItem.Type.BLOCK, jsonObject, this.blockReplacements);
        this.blockReplacements.putAll(int2ObjectOpenHashMap);
        this.itemReplacements.putAll(int2ObjectOpenHashMap);
    }

    protected LegacyBlockItemRewriter(T t, String string, Type<Item> type, Type<Item[]> type2) {
        this(t, string, type, type2, type, type2);
    }

    protected LegacyBlockItemRewriter(T t, String string) {
        this(t, string, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    private void addMappings(MappedLegacyBlockItem.Type type, JsonObject jsonObject, Int2ObjectMap<MappedLegacyBlockItem> int2ObjectMap) {
        if (jsonObject.has(type.getName())) {
            JsonObject jsonObject2 = jsonObject.getAsJsonObject(type.getName());
            for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
                this.addMapping(entry.getKey(), entry.getValue().getAsJsonObject(), type, int2ObjectMap);
            }
        }
    }

    private void addMapping(String string, JsonObject jsonObject, MappedLegacyBlockItem.Type type, Int2ObjectMap<MappedLegacyBlockItem> int2ObjectMap) {
        String string2;
        int n = jsonObject.getAsJsonPrimitive("id").getAsInt();
        JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive("data");
        short s = jsonPrimitive != null ? jsonPrimitive.getAsShort() : (short)0;
        String string3 = string2 = type != MappedLegacyBlockItem.Type.BLOCK ? jsonObject.getAsJsonPrimitive("name").getAsString() : null;
        if (string.indexOf(45) == -1) {
            int n2;
            int n3 = string.indexOf(58);
            if (n3 != -1) {
                short s2 = Short.parseShort(string.substring(n3 + 1));
                n2 = Integer.parseInt(string.substring(0, n3));
                n2 = this.compress(n2, s2);
            } else {
                n2 = this.compress(Integer.parseInt(string), -1);
            }
            int2ObjectMap.put(n2, new MappedLegacyBlockItem(n, s, string2, type));
            return;
        }
        String[] stringArray = string.split("-", 2);
        int n4 = Integer.parseInt(stringArray[0]);
        int n5 = Integer.parseInt(stringArray[1]);
        if (string2 != null && string2.contains("%color%")) {
            for (int i = n4; i <= n5; ++i) {
                int2ObjectMap.put(this.compress(i, -1), new MappedLegacyBlockItem(n, s, string2.replace("%color%", BlockColors1_11_1.get(i - n4)), type));
            }
        } else {
            MappedLegacyBlockItem mappedLegacyBlockItem = new MappedLegacyBlockItem(n, s, string2, type);
            for (int i = n4; i <= n5; ++i) {
                int2ObjectMap.put(this.compress(i, -1), mappedLegacyBlockItem);
            }
        }
    }

    public void registerBlockChange(C c) {
        ((BackwardsProtocol)this.protocol).registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.set(Types.VAR_INT, 0, LegacyBlockItemRewriter.this.handleBlockId(n));
                });
            }
        });
    }

    public void registerMultiBlockChange(C c) {
        ((BackwardsProtocol)this.protocol).registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BLOCK_CHANGE_ARRAY);
                this.handler(packetWrapper -> {
                    for (BlockChangeRecord blockChangeRecord : packetWrapper.get(Types.BLOCK_CHANGE_ARRAY, 0)) {
                        blockChangeRecord.setBlockId(LegacyBlockItemRewriter.this.handleBlockId(blockChangeRecord.getBlockId()));
                    }
                });
            }
        });
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        MappedLegacyBlockItem mappedLegacyBlockItem = this.getMappedItem(item.identifier(), item.data());
        if (mappedLegacyBlockItem == null) {
            return super.handleItemToClient(userConnection, item);
        }
        if (item.tag() == null) {
            item.setTag(new CompoundTag());
        }
        short s = item.data();
        item.tag().putInt(this.nbtTagName("id"), item.identifier());
        item.setIdentifier(mappedLegacyBlockItem.getId());
        if (mappedLegacyBlockItem.getData() != -1) {
            item.setData(mappedLegacyBlockItem.getData());
            item.tag().putShort(this.nbtTagName("data"), s);
        }
        if (mappedLegacyBlockItem.getName() != null) {
            String string;
            StringTag stringTag;
            CompoundTag compoundTag = item.tag().getCompoundTag("display");
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.tag().put("display", compoundTag);
            }
            if ((stringTag = compoundTag.getStringTag("Name")) == null) {
                stringTag = new StringTag(mappedLegacyBlockItem.getName());
                compoundTag.put("Name", stringTag);
                compoundTag.put(this.nbtTagName("customName"), new ByteTag(false));
            }
            if ((string = stringTag.getValue()).contains("%vb_color%")) {
                compoundTag.putString("Name", string.replace("%vb_color%", BlockColors1_11_1.get(s)));
            }
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if ((item = super.handleItemToServer(userConnection, item)).tag() != null) {
            Tag tag;
            Tag tag2 = item.tag().remove(this.nbtTagName("id"));
            if (tag2 instanceof IntTag) {
                item.setIdentifier(((NumberTag)tag2).asInt());
            }
            if ((tag = item.tag().remove(this.nbtTagName("data"))) instanceof ShortTag) {
                item.setData(((NumberTag)tag).asShort());
            }
        }
        return item;
    }

    public PacketHandler getFallingBlockHandler() {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.INT, 0);
            EntityTypes1_12.ObjectType objectType = EntityTypes1_12.ObjectType.findById(packetWrapper.get(Types.BYTE, 0).byteValue(), n);
            if (objectType == EntityTypes1_12.ObjectType.FALLING_BLOCK) {
                IdAndData idAndData = this.handleBlock(n & 0xFFF, n >> 12 & 0xF);
                if (idAndData == null) {
                    return;
                }
                packetWrapper.set(Types.INT, 0, idAndData.getId() | idAndData.getData() << 12);
            }
        };
    }

    public @Nullable IdAndData handleBlock(int n, int n2) {
        MappedLegacyBlockItem mappedLegacyBlockItem = this.getMappedBlock(n, n2);
        if (mappedLegacyBlockItem == null) {
            return null;
        }
        IdAndData idAndData = mappedLegacyBlockItem.getBlock();
        if (idAndData.getData() == -1) {
            return idAndData.withData(n2);
        }
        return idAndData;
    }

    public int handleBlockId(int n) {
        int n2;
        int n3 = IdAndData.getId(n);
        IdAndData idAndData = this.handleBlock(n3, n2 = IdAndData.getData(n));
        if (idAndData == null) {
            return n;
        }
        return IdAndData.toRawData(idAndData.getId(), idAndData.getData());
    }

    public void handleChunk(Chunk chunk) {
        int n;
        Object object;
        Object object2;
        HashMap<Pos, CompoundTag> hashMap = new HashMap<Pos, CompoundTag>();
        for (CompoundTag object3 : chunk.getBlockEntities()) {
            ChunkSection k;
            NumberTag numberTag;
            NumberTag numberTag2 = object3.getNumberTag("x");
            if (numberTag2 == null || (object2 = object3.getNumberTag("y")) == null || (numberTag = object3.getNumberTag("z")) == null) continue;
            Pos j = new Pos(numberTag2.asInt() & 0xF, object2.asInt(), numberTag.asInt() & 0xF);
            hashMap.put(j, object3);
            if (j.y() < 0 || j.y() > 255 || (k = chunk.getSections()[j.y() >> 4]) == null || (object = this.getMappedBlock(n = k.palette(PaletteType.BLOCKS).idAt(j.x(), j.y() & 0xF, j.z()))) == null || !((MappedLegacyBlockItem)object).hasBlockEntityHandler()) continue;
            ((MappedLegacyBlockItem)object).getBlockEntityHandler().handleCompoundTag(n, object3);
        }
        for (int i = 0; i < chunk.getSections().length; ++i) {
            Object object3;
            int n2;
            ChunkSection chunkSection = chunk.getSections()[i];
            if (chunkSection == null) continue;
            boolean bl = false;
            object2 = chunkSection.palette(PaletteType.BLOCKS);
            for (n2 = 0; n2 < object2.size(); ++n2) {
                int n3 = object2.idByIndex(n2);
                int n4 = n3 >> 4;
                object = this.handleBlock(n4, n = n3 & 0xF);
                if (object != null) {
                    object2.setIdByIndex(n2, IdAndData.toRawData(((IdAndData)object).getId(), ((IdAndData)object).getData()));
                }
                if (bl || (object3 = this.getMappedBlock(n3)) == null || !((MappedLegacyBlockItem)object3).hasBlockEntityHandler()) continue;
                bl = true;
            }
            if (!bl) continue;
            for (n2 = 0; n2 < 16; ++n2) {
                for (int j = 0; j < 16; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        n = object2.idAt(n2, j, k);
                        object = this.getMappedBlock(n);
                        if (object == null || !((MappedLegacyBlockItem)object).hasBlockEntityHandler() || hashMap.containsKey(object3 = new Pos(n2, j + (i << 4), k))) continue;
                        CompoundTag compoundTag = new CompoundTag();
                        compoundTag.putInt("x", n2 + (chunk.getX() << 4));
                        compoundTag.putInt("y", j + (i << 4));
                        compoundTag.putInt("z", k + (chunk.getZ() << 4));
                        ((MappedLegacyBlockItem)object).getBlockEntityHandler().handleCompoundTag(n, compoundTag);
                        chunk.getBlockEntities().add(compoundTag);
                    }
                }
            }
        }
    }

    protected CompoundTag getNamedTag(String object) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag.put("display", compoundTag2);
        object = "\u00a7r" + (String)object;
        compoundTag2.putString("Name", (String)(this.jsonNameFormat ? ComponentUtil.legacyToJsonString((String)object) : object));
        return compoundTag;
    }

    private @Nullable MappedLegacyBlockItem getMappedBlock(int n, int n2) {
        MappedLegacyBlockItem mappedLegacyBlockItem = (MappedLegacyBlockItem)this.blockReplacements.get(this.compress(n, n2));
        return mappedLegacyBlockItem != null ? mappedLegacyBlockItem : (MappedLegacyBlockItem)this.blockReplacements.get(this.compress(n, -1));
    }

    private @Nullable MappedLegacyBlockItem getMappedItem(int n, int n2) {
        MappedLegacyBlockItem mappedLegacyBlockItem = (MappedLegacyBlockItem)this.itemReplacements.get(this.compress(n, n2));
        return mappedLegacyBlockItem != null ? mappedLegacyBlockItem : (MappedLegacyBlockItem)this.itemReplacements.get(this.compress(n, -1));
    }

    private @Nullable MappedLegacyBlockItem getMappedBlock(int n) {
        int n2 = IdAndData.getId(n);
        int n3 = IdAndData.getData(n);
        return this.getMappedBlock(n2, n3);
    }

    protected JsonObject readMappingsFile(String string) {
        return BackwardsMappingDataLoader.INSTANCE.loadFromDataDir(string);
    }

    protected int compress(int n, int n2) {
        return n << 16 | n2 & 0xFFFF;
    }

    private record Pos(int x, short y, int z) {
        public Pos(int n, int n2, int n3) {
            this(n, (short)n2, n3);
        }
    }
}

