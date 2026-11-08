/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viabackwards.api.rewriters.MapColorRewriter;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.storage.BiomeStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.data.MapColorMappings1_15_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_15;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_16;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.ItemPacketRewriter1_16;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.CompactArrayUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class BlockItemPacketRewriter1_16
extends BackwardsItemRewriter<ClientboundPackets1_16, ServerboundPackets1_14, Protocol1_16To1_15_2> {
    private EnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_16(Protocol1_16To1_15_2 protocol1_16To1_15_2) {
        super(protocol1_16To1_15_2, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.UPDATE_RECIPES, packetWrapper -> {
            int n;
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = Key.stripMinecraftNamespace(string);
                if (string2.equals("smithing")) {
                    --n2;
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2);
                    continue;
                }
                packetWrapper.write(Types.STRING, string);
                packetWrapper.passthrough(Types.STRING);
                recipeRewriter.handleRecipeType(packetWrapper, string2);
            }
            packetWrapper.set(Types.VAR_INT, 0, n2);
        });
        ((Protocol1_16To1_15_2)this.protocol).getBlockRewriter().registerLevelChunk(ClientboundPackets1_16.LEVEL_CHUNK, ChunkType1_16.TYPE, ChunkType1_15.TYPE, (userConnection, chunk) -> {
            CompoundTag compoundTag = chunk.getHeightMap();
            for (Tag tag : compoundTag.values()) {
                if (!(tag instanceof LongArrayTag)) continue;
                LongArrayTag longArrayTag = (LongArrayTag)tag;
                int[] nArray = new int[256];
                CompactArrayUtil.iterateCompactArrayWithPadding(9, nArray.length, longArrayTag.getValue(), (n, n2) -> {
                    nArray[n] = n2;
                });
                longArrayTag.setValue(CompactArrayUtil.createCompactArray(9, nArray.length, n -> nArray[n]));
            }
            if (chunk.isBiomeData()) {
                if (userConnection.getProtocolInfo().serverProtocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_16_2)) {
                    BiomeStorage biomeStorage = userConnection.get(BiomeStorage.class);
                    for (int i = 0; i < 1024; ++i) {
                        int n3 = chunk.getBiomeData()[i];
                        int n4 = biomeStorage.legacyBiome(n3);
                        if (n4 == -1) {
                            ((Protocol1_16To1_15_2)this.protocol).getLogger().warning("Biome sent that does not exist in the biome registry: " + n3);
                            n4 = 1;
                        }
                        chunk.getBiomeData()[i] = n4;
                    }
                } else {
                    for (int i = 0; i < 1024; ++i) {
                        int n5 = chunk.getBiomeData()[i];
                        switch (n5) {
                            case 170: 
                            case 171: 
                            case 172: 
                            case 173: {
                                chunk.getBiomeData()[i] = 8;
                            }
                        }
                    }
                }
            }
            if (chunk.getBlockEntities() == null) {
                return;
            }
            for (CompoundTag compoundTag2 : chunk.getBlockEntities()) {
                this.handleBlockEntity(compoundTag2);
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.SET_EQUIPMENT, ClientboundPackets1_15.SET_EQUIPPED_ITEM, packetWrapper -> {
            int n;
            Object object;
            byte by;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            ArrayList<EquipmentData> arrayList = new ArrayList<EquipmentData>();
            do {
                by = packetWrapper.read(Types.BYTE);
                object = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2));
                n = by & 0x7F;
                arrayList.add(new EquipmentData(n, (Item)object));
            } while ((by & 0xFFFFFF80) != 0);
            object = (EquipmentData)arrayList.get(0);
            packetWrapper.write(Types.VAR_INT, ((EquipmentData)object).slot);
            packetWrapper.write(Types.ITEM1_13_2, ((EquipmentData)object).item);
            for (n = 1; n < arrayList.size(); ++n) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_15.SET_EQUIPPED_ITEM);
                EquipmentData equipmentData = (EquipmentData)arrayList.get(n);
                packetWrapper2.write(Types.VAR_INT, n2);
                packetWrapper2.write(Types.VAR_INT, equipmentData.slot);
                packetWrapper2.write(Types.ITEM1_13_2, equipmentData.item);
                packetWrapper2.send(Protocol1_16To1_15_2.class);
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.LIGHT_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.CONTAINER_SET_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.SHORT, 0);
                    if (s >= 4 && s <= 6) {
                        short s2 = packetWrapper.get(Types.SHORT, 1);
                        if (s2 > 11) {
                            s2 = (short)(s2 - 1);
                            packetWrapper.set(Types.SHORT, 1, s2);
                        } else if (s2 == 11) {
                            packetWrapper.set(Types.SHORT, 1, (short)9);
                        }
                    }
                });
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(MapColorRewriter.getRewriteHandler(MapColorMappings1_15_2::getMappedColor));
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.BLOCK_ENTITY_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            CompoundTag compoundTag = packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG);
            this.handleBlockEntity(compoundTag);
        });
        ((Protocol1_16To1_15_2)this.protocol).registerServerbound(ServerboundPackets1_14.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
    }

    private void handleBlockEntity(CompoundTag compoundTag) {
        String string = compoundTag.getString("id");
        if (string == null) {
            return;
        }
        if ((string = Key.namespaced(string)).equals("minecraft:conduit")) {
            Tag tag = compoundTag.remove("Target");
            if (!(tag instanceof IntArrayTag)) {
                return;
            }
            UUID uUID = UUIDUtil.fromIntArray((int[])tag.getValue());
            compoundTag.putString("target_uuid", uUID.toString());
        } else if (string.equals("minecraft:skull")) {
            Tag tag = compoundTag.remove("SkullOwner");
            if (!(tag instanceof CompoundTag)) {
                return;
            }
            CompoundTag compoundTag2 = (CompoundTag)tag;
            Iterator<Map.Entry<String, Tag>> iterator2 = compoundTag2.remove("Id");
            if (iterator2 instanceof IntArrayTag) {
                tag = (IntArrayTag)((Object)iterator2);
                iterator2 = UUIDUtil.fromIntArray(((IntArrayTag)tag).getValue());
                compoundTag2.putString("Id", ((UUID)((Object)iterator2)).toString());
            }
            tag = new CompoundTag();
            for (Map.Entry<String, Tag> entry : compoundTag2) {
                ((CompoundTag)tag).put(entry.getKey(), entry.getValue());
            }
            compoundTag.put("Owner", tag);
        }
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new EnchantmentRewriter(this);
        this.enchantmentRewriter.registerEnchantment("minecraft:soul_speed", "\u00a77Soul Speed");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        Object object;
        Object object2;
        Tag tag;
        if (item == null) {
            return null;
        }
        item = super.handleItemToClient(userConnection, item);
        CompoundTag compoundTag = item.tag();
        if (item.identifier() == 771 && compoundTag != null && (tag = compoundTag.getCompoundTag("SkullOwner")) != null && (object2 = ((CompoundTag)tag).getIntArrayTag("Id")) != null) {
            object = UUIDUtil.fromIntArray(((IntArrayTag)object2).getValue());
            ((CompoundTag)tag).putString("Id", ((UUID)object).toString());
        }
        if (item.identifier() == 759 && compoundTag != null && (tag = compoundTag.getListTag("pages", StringTag.class)) != null) {
            object2 = ((ListTag)tag).iterator();
            while (object2.hasNext()) {
                object = (StringTag)object2.next();
                JsonElement jsonElement = ((Protocol1_16To1_15_2)this.protocol).getComponentRewriter().processText(userConnection, ((StringTag)object).getValue());
                ((StringTag)object).setValue(jsonElement.toString());
            }
        }
        ItemPacketRewriter1_16.newToOldAttributes(item);
        this.enchantmentRewriter.handleToClient(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        StringTag stringTag;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        int n = item.identifier();
        item = super.handleItemToServer(userConnection, item);
        CompoundTag compoundTag2 = item.tag();
        if (n == 771 && compoundTag2 != null && (compoundTag = compoundTag2.getCompoundTag("SkullOwner")) != null && (stringTag = compoundTag.getStringTag("Id")) != null) {
            UUID uUID = UUID.fromString(stringTag.getValue());
            compoundTag.put("Id", new IntArrayTag(UUIDUtil.toIntArray(uUID)));
        }
        ItemPacketRewriter1_16.oldToNewAttributes(item);
        this.enchantmentRewriter.handleToServer(item);
        return item;
    }

    private record EquipmentData(int slot, Item item) {
    }
}

