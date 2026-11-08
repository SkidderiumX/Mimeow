/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter;

import com.google.common.primitives.Ints;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.FlowerPotHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.BackwardsBlockStorage;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.NoteBlockStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.BlockIdData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.SpawnEggMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.IdAndData;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class BlockItemPacketRewriter1_13
extends BackwardsItemRewriter<ClientboundPackets1_13, ServerboundPackets1_12_1, Protocol1_13To1_12_2> {
    private final Map<String, String> enchantmentMappings = new HashMap<String, String>();
    private final String extraNbtTag = this.nbtTagName("2");

    public BlockItemPacketRewriter1_13(Protocol1_13To1_12_2 protocol1_13To1_12_2) {
        super(protocol1_13To1_12_2, Types.ITEM1_13, Types.ITEM1_13_SHORT_ARRAY, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    public static boolean isDamageable(int n) {
        return n >= 256 && n <= 259 || n == 261 || n >= 267 && n <= 279 || n >= 283 && n <= 286 || n >= 290 && n <= 294 || n >= 298 && n <= 317 || n == 346 || n == 359 || n == 398 || n == 442 || n == 443;
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13To1_12_2)this.protocol).replaceClientbound(ClientboundPackets1_13.COOLDOWN, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = ((Protocol1_13To1_12_2)this.protocol).getMappingData().getItemMappings().getNewId(n);
            if (n2 == -1) {
                packetWrapper.cancel();
                return;
            }
            if (SpawnEggMappings1_13.getEntityId(n2).isPresent()) {
                packetWrapper.write(Types.VAR_INT, IdAndData.toRawData(383));
                return;
            }
            packetWrapper.write(Types.VAR_INT, IdAndData.getId(n2));
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    BlockPosition blockPosition;
                    NoteBlockStorage noteBlockStorage;
                    Pair<Integer, Integer> pair;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 73) {
                        n = 25;
                    } else if (n == 99) {
                        n = 33;
                    } else if (n == 92) {
                        n = 29;
                    } else if (n == 142) {
                        n = 54;
                    } else if (n == 305) {
                        n = 146;
                    } else if (n == 249) {
                        n = 130;
                    } else if (n == 257) {
                        n = 138;
                    } else if (n == 140) {
                        n = 52;
                    } else if (n == 472) {
                        n = 209;
                    } else if (n >= 483 && n <= 498) {
                        n = n - 483 + 219;
                    }
                    if (n == 25 && (pair = (noteBlockStorage = packetWrapper.user().get(NoteBlockStorage.class)).getNoteBlockUpdate(blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0))) != null) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 0, pair.key().shortValue());
                        packetWrapper.set(Types.UNSIGNED_BYTE, 1, pair.value().shortValue());
                    }
                    packetWrapper.set(Types.VAR_INT, 0, n);
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    BackwardsBlockEntityProvider backwardsBlockEntityProvider = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 5) {
                        packetWrapper.cancel();
                    }
                    packetWrapper.set(Types.NAMED_COMPOUND_TAG, 0, backwardsBlockEntityProvider.transform(packetWrapper.user(), packetWrapper.get(Types.BLOCK_POSITION1_8, 0), packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0)));
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.FORGET_LEVEL_CHUNK, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT) << 4;
            int n2 = packetWrapper.passthrough(Types.INT) << 4;
            int n3 = n + 15;
            int n4 = n2 + 15;
            BackwardsBlockStorage backwardsBlockStorage = packetWrapper.user().get(BackwardsBlockStorage.class);
            backwardsBlockStorage.getBlocks().entrySet().removeIf(entry -> {
                BlockPosition blockPosition = (BlockPosition)entry.getKey();
                return blockPosition.x() >= n && blockPosition.z() >= n2 && blockPosition.x() <= n3 && blockPosition.z() <= n4;
            });
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
                    if (n >= 249 && n <= 748) {
                        packetWrapper.user().get(NoteBlockStorage.class).storeNoteBlockUpdate(blockPosition, n);
                    }
                    BackwardsBlockStorage backwardsBlockStorage = packetWrapper.user().get(BackwardsBlockStorage.class);
                    backwardsBlockStorage.checkAndStore(blockPosition, n);
                    packetWrapper.write(Types.VAR_INT, ((Protocol1_13To1_12_2)BlockItemPacketRewriter1_13.this.protocol).getMappingData().getNewBlockStateId(n));
                    BlockItemPacketRewriter1_13.flowerPotSpecialTreatment(packetWrapper.user(), n, blockPosition);
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.CHUNK_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BLOCK_CHANGE_ARRAY);
                this.handler(packetWrapper -> {
                    BackwardsBlockStorage backwardsBlockStorage = packetWrapper.user().get(BackwardsBlockStorage.class);
                    for (BlockChangeRecord blockChangeRecord : packetWrapper.get(Types.BLOCK_CHANGE_ARRAY, 0)) {
                        int n = packetWrapper.get(Types.INT, 0);
                        int n2 = packetWrapper.get(Types.INT, 1);
                        int n3 = blockChangeRecord.getBlockId();
                        BlockPosition blockPosition = new BlockPosition(blockChangeRecord.getSectionX() + n * 16, blockChangeRecord.getY(), blockChangeRecord.getSectionZ() + n2 * 16);
                        backwardsBlockStorage.checkAndStore(blockPosition, n3);
                        BlockItemPacketRewriter1_13.flowerPotSpecialTreatment(packetWrapper.user(), n3, blockPosition);
                        blockChangeRecord.setBlockId(((Protocol1_13To1_12_2)BlockItemPacketRewriter1_13.this.protocol).getMappingData().getNewBlockStateId(n3));
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.LEVEL_CHUNK, packetWrapper -> {
            int n;
            int n2;
            int n3;
            Object object;
            Object t = packetWrapper.user().getClientWorld(Protocol1_13To1_12_2.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            ChunkType1_13 chunkType1_13 = ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.read(chunkType1_13);
            BackwardsBlockEntityProvider backwardsBlockEntityProvider = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
            BackwardsBlockStorage backwardsBlockStorage = packetWrapper.user().get(BackwardsBlockStorage.class);
            for (CompoundTag compoundTag : chunk.getBlockEntities()) {
                int n5;
                StringTag stringTag = compoundTag.getStringTag("id");
                if (stringTag == null || !backwardsBlockEntityProvider.isHandled((String)(object = stringTag.getValue())) || (n5 = compoundTag.getNumberTag("y").asInt() >> 4) < 0 || n5 > 15) continue;
                ChunkSection chunkSection = chunk.getSections()[n5];
                n3 = compoundTag.getNumberTag("x").asInt();
                n2 = compoundTag.getNumberTag("y").asShort();
                int n6 = compoundTag.getNumberTag("z").asInt();
                BlockPosition blockPosition = new BlockPosition(n3, n2, n6);
                int n7 = chunkSection.palette(PaletteType.BLOCKS).idAt(n3 & 0xF, n2 & 0xF, n6 & 0xF);
                backwardsBlockStorage.checkAndStore(blockPosition, n7);
                backwardsBlockEntityProvider.transform(packetWrapper.user(), blockPosition, compoundTag);
            }
            int n8 = chunk.getX() << 4;
            int n9 = chunk.getZ() << 4;
            for (n = 0; n < chunk.getSections().length; ++n) {
                object = chunk.getSections()[n];
                if (object == null) continue;
                DataPalette dataPalette = object.palette(PaletteType.BLOCKS);
                int n10 = n << 4;
                dataPalette.forEachMatchingCoordinate(FlowerPotHandler::isFlowah, n4 -> {
                    int n5 = dataPalette.idAt(n4);
                    BlockPosition blockPosition = new BlockPosition(ChunkSection.xFromIndex(n4) + n8, (short)(ChunkSection.yFromIndex(n4) + n10), ChunkSection.zFromIndex(n4) + n9);
                    backwardsBlockStorage.checkAndStore(blockPosition, n5);
                    CompoundTag compoundTag = backwardsBlockEntityProvider.transform(packetWrapper.user(), blockPosition, "minecraft:flower_pot");
                    chunk.getBlockEntities().add(compoundTag);
                });
                for (n3 = 0; n3 < dataPalette.size(); ++n3) {
                    n2 = ((Protocol1_13To1_12_2)this.protocol).getMappingData().getNewBlockStateId(dataPalette.idByIndex(n3));
                    dataPalette.setIdByIndex(n3, n2);
                }
            }
            if (chunk.isBiomeData()) {
                for (n = 0; n < 256; ++n) {
                    int n11;
                    int n12 = chunk.getBiomeData()[n];
                    switch (n12) {
                        case 40: 
                        case 41: 
                        case 42: 
                        case 43: {
                            int n13 = 9;
                            break;
                        }
                        case 47: 
                        case 48: 
                        case 49: {
                            int n13 = 24;
                            break;
                        }
                        case 50: {
                            int n13 = 10;
                            break;
                        }
                        case 44: 
                        case 45: 
                        case 46: {
                            int n13 = 0;
                            break;
                        }
                        default: {
                            int n13 = n11 = -1;
                        }
                    }
                    if (n11 == -1) continue;
                    chunk.getBiomeData()[n] = n11;
                }
            }
            packetWrapper.write(chunkType1_9_3, chunk);
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, ((Protocol1_13To1_12_2)BlockItemPacketRewriter1_13.this.protocol).getMappingData().getItemMappings().getNewId(n2) >> 4);
                    } else if (n == 2001) {
                        n2 = ((Protocol1_13To1_12_2)BlockItemPacketRewriter1_13.this.protocol).getMappingData().getNewBlockStateId(n2);
                        int n3 = n2 >> 4;
                        int n4 = n2 & 0xF;
                        packetWrapper.set(Types.INT, 1, n3 & 0xFFF | n4 << 12);
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        byte by = packetWrapper.read(Types.BYTE);
                        byte by2 = packetWrapper.read(Types.BYTE);
                        byte by3 = packetWrapper.read(Types.BYTE);
                        packetWrapper.read(Types.OPTIONAL_COMPONENT);
                        if (n2 > 9) {
                            packetWrapper.set(Types.VAR_INT, 1, packetWrapper.get(Types.VAR_INT, 1) - 1);
                            continue;
                        }
                        packetWrapper.write(Types.BYTE, (byte)(n2 << 4 | by3 & 0xF));
                        packetWrapper.write(Types.BYTE, by);
                        packetWrapper.write(Types.BYTE, by2);
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentMappings.put("minecraft:loyalty", "\u00a77Loyalty");
        this.enchantmentMappings.put("minecraft:impaling", "\u00a77Impaling");
        this.enchantmentMappings.put("minecraft:riptide", "\u00a77Riptide");
        this.enchantmentMappings.put("minecraft:channeling", "\u00a77Channeling");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        Tag tag;
        if (item == null) {
            return null;
        }
        int n = item.identifier();
        Integer n2 = null;
        boolean bl = false;
        CompoundTag compoundTag = item.tag();
        if (compoundTag != null && (tag = compoundTag.remove(this.extraNbtTag)) instanceof NumberTag) {
            n2 = ((NumberTag)tag).asInt();
            bl = true;
        }
        if (n2 == null) {
            if ((item = super.handleItemToClient(userConnection, item)).identifier() == -1) {
                if (n == 362) {
                    n2 = 0xE50000;
                } else {
                    if (Via.getConfig().logOtherConversionWarnings()) {
                        ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Failed to get new item for " + n);
                    }
                    n2 = 65536;
                }
            } else {
                if (compoundTag == null) {
                    compoundTag = item.tag();
                }
                n2 = this.itemIdToRaw(item.identifier(), item, compoundTag);
            }
        }
        item.setIdentifier(n2 >> 16);
        item.setData((short)(n2 & 0xFFFF));
        if (compoundTag != null) {
            StringTag stringTag;
            Tag tag2;
            if (BlockItemPacketRewriter1_13.isDamageable(item.identifier())) {
                tag2 = compoundTag.remove("Damage");
                if (!bl && tag2 instanceof NumberTag) {
                    item.setData(((NumberTag)tag2).asShort());
                }
            }
            if (item.identifier() == 358) {
                tag2 = compoundTag.remove("map");
                if (!bl && tag2 instanceof NumberTag) {
                    item.setData(((NumberTag)tag2).asShort());
                }
            }
            this.invertShieldAndBannerId(item, compoundTag);
            tag2 = compoundTag.getCompoundTag("display");
            if (tag2 != null && (stringTag = ((CompoundTag)tag2).getStringTag("Name")) != null) {
                ((CompoundTag)tag2).putString(this.extraNbtTag + "|Name", stringTag.getValue());
                stringTag.setValue(((Protocol1_13To1_12_2)this.protocol).jsonToLegacy(userConnection, stringTag.getValue()));
            }
            this.rewriteEnchantmentsToClient(compoundTag, false);
            this.rewriteEnchantmentsToClient(compoundTag, true);
            this.rewriteCanPlaceToClient(compoundTag, "CanPlaceOn");
            this.rewriteCanPlaceToClient(compoundTag, "CanDestroy");
        }
        return item;
    }

    private int itemIdToRaw(int n, Item item, CompoundTag compoundTag) {
        Optional<String> optional = SpawnEggMappings1_13.getEntityId(n);
        if (optional.isPresent()) {
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
            }
            if (!compoundTag.contains("EntityTag")) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putString("id", optional.get());
                compoundTag.put("EntityTag", compoundTag2);
            }
            return 25100288;
        }
        return n >> 4 << 16 | n & 0xF;
    }

    private void rewriteCanPlaceToClient(CompoundTag compoundTag, String string) {
        ListTag<?> listTag = compoundTag.getListTag(string);
        if (listTag == null) {
            return;
        }
        ListTag<StringTag> listTag2 = new ListTag<StringTag>(StringTag.class);
        compoundTag.put(this.extraNbtTag + "|" + string, listTag.copy());
        for (Tag tag : listTag) {
            String[] stringArray;
            Object object = tag.getValue();
            String[] stringArray2 = stringArray = object instanceof String ? BlockIdData.fallbackReverseMapping.get(Key.stripMinecraftNamespace((String)object)) : null;
            if (stringArray != null) {
                for (String string2 : stringArray) {
                    listTag2.add(new StringTag(string2));
                }
                continue;
            }
            listTag2.add(new StringTag(tag.getValue().toString()));
        }
        compoundTag.put(string, listTag2);
    }

    private void rewriteEnchantmentsToClient(CompoundTag compoundTag, boolean bl) {
        Tag tag;
        CompoundTag compoundTag2;
        String string = bl ? "StoredEnchantments" : "Enchantments";
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        if (listTag == null) {
            return;
        }
        ListTag<CompoundTag> listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
        ListTag<CompoundTag> listTag3 = new ListTag<CompoundTag>(CompoundTag.class);
        ArrayList<StringTag> arrayList = new ArrayList<StringTag>();
        boolean bl2 = false;
        Object object = ((ListTag)listTag.copy()).iterator();
        while (object.hasNext()) {
            Object object2;
            compoundTag2 = (CompoundTag)object.next();
            tag = compoundTag2.getStringTag("id");
            if (tag == null) continue;
            String string2 = ((StringTag)tag).getValue();
            NumberTag tag2 = compoundTag2.getNumberTag("lvl");
            if (tag2 == null) continue;
            int n = tag2.asInt();
            int n2 = n < Short.MAX_VALUE ? (int)n : Short.MAX_VALUE;
            String string3 = this.enchantmentMappings.get(string2);
            if (string3 != null) {
                arrayList.add(new StringTag(string3 + " " + EnchantmentRewriter.getRomanNumber(n2)));
                listTag2.add(compoundTag2);
                continue;
            }
            if (string2.isEmpty()) continue;
            Short s = (Short)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().inverse().get(Key.stripMinecraftNamespace(string2));
            if (s == null) {
                if (!string2.startsWith("viaversion:legacy/")) {
                    listTag2.add(compoundTag2);
                    if (ViaBackwards.getConfig().addCustomEnchantsToLore()) {
                        object2 = string2;
                        int n3 = ((String)object2).indexOf(58) + 1;
                        if (n3 != 0 && n3 != ((String)object2).length()) {
                            object2 = ((String)object2).substring(n3);
                        }
                        object2 = "\u00a77" + Character.toUpperCase(((String)object2).charAt(0)) + ((String)object2).substring(1).toLowerCase(Locale.ENGLISH);
                        arrayList.add(new StringTag((String)object2 + " " + EnchantmentRewriter.getRomanNumber(n2)));
                    }
                    if (!Via.getManager().isDebug()) continue;
                    ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Found unknown enchant: " + (String)string2);
                    continue;
                }
                s = Short.valueOf(string2.substring(18));
            }
            if (n2 != 0) {
                bl2 = true;
            }
            object2 = new CompoundTag();
            ((CompoundTag)object2).putShort("id", s);
            ((CompoundTag)object2).putShort("lvl", (short)n2);
            listTag3.add((CompoundTag)object2);
        }
        if (!bl && !bl2) {
            object = compoundTag.getNumberTag("HideFlags");
            if (object == null) {
                object = new IntTag();
                compoundTag.put(this.extraNbtTag + "|DummyEnchant", new ByteTag(false));
            } else {
                compoundTag.putInt(this.extraNbtTag + "|OldHideFlags", object.asByte());
            }
            if (listTag3.isEmpty()) {
                compoundTag2 = new CompoundTag();
                compoundTag2.putShort("id", (short)0);
                compoundTag2.putShort("lvl", (short)0);
                listTag3.add(compoundTag2);
            }
            int n = object.asByte() | 1;
            compoundTag.putInt("HideFlags", n);
        }
        if (!listTag2.isEmpty()) {
            compoundTag.put(this.extraNbtTag + "|" + string, listTag2);
            if (!arrayList.isEmpty()) {
                ListTag<StringTag> listTag4;
                object = compoundTag.getCompoundTag("display");
                if (object == null) {
                    object = new CompoundTag();
                    compoundTag.put("display", (Tag)object);
                }
                if ((listTag4 = ((CompoundTag)object).getListTag("Lore", StringTag.class)) == null) {
                    listTag4 = new ListTag<StringTag>(StringTag.class);
                    ((CompoundTag)object).put("Lore", listTag4);
                    compoundTag.put(this.extraNbtTag + "|DummyLore", new ByteTag(false));
                } else if (!listTag4.isEmpty()) {
                    tag = new ListTag<StringTag>(StringTag.class);
                    for (StringTag stringTag : listTag4) {
                        ((ListTag)tag).add(stringTag.copy());
                    }
                    compoundTag.put(this.extraNbtTag + "|OldLore", tag);
                    arrayList.addAll((Collection<StringTag>)listTag4.getValue());
                }
                listTag4.setValue(arrayList);
            }
        }
        compoundTag.remove("Enchantments");
        compoundTag.put(bl ? string : "ench", listTag3);
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        int n = item.identifier() << 16 | item.data() & 0xFFFF;
        int n2 = IdAndData.toRawData(item.identifier(), item.data());
        if (BlockItemPacketRewriter1_13.isDamageable(item.identifier())) {
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
            }
            compoundTag.putInt("Damage", item.data());
        }
        if (item.identifier() == 358) {
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
            }
            compoundTag.putInt("map", item.data());
        }
        if (compoundTag != null) {
            Tag tag;
            Tag tag2;
            this.invertShieldAndBannerId(item, compoundTag);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("display");
            if (compoundTag2 != null && (tag2 = compoundTag2.getStringTag("Name")) != null) {
                tag = compoundTag2.remove(this.extraNbtTag + "|Name");
                ((StringTag)tag2).setValue(tag instanceof StringTag ? ((StringTag)tag).getValue() : ComponentUtil.legacyToJsonString(((StringTag)tag2).getValue()));
            }
            this.rewriteEnchantmentsToServer(compoundTag, false);
            this.rewriteEnchantmentsToServer(compoundTag, true);
            this.rewriteCanPlaceToServer(compoundTag, "CanPlaceOn");
            this.rewriteCanPlaceToServer(compoundTag, "CanDestroy");
            if (item.identifier() == 383) {
                tag2 = compoundTag.getCompoundTag("EntityTag");
                if (tag2 != null && (tag = ((CompoundTag)tag2).getStringTag("id")) != null) {
                    n2 = SpawnEggMappings1_13.getSpawnEggId(((StringTag)tag).getValue());
                    if (n2 == -1) {
                        n2 = 25100288;
                    } else {
                        ((CompoundTag)tag2).remove("id");
                        if (((CompoundTag)tag2).isEmpty()) {
                            compoundTag.remove("EntityTag");
                        }
                    }
                } else {
                    n2 = 25100288;
                }
            }
            if (compoundTag.isEmpty()) {
                compoundTag = null;
                item.setTag(null);
            }
        }
        int n3 = item.identifier();
        item.setIdentifier(n2);
        item = super.handleItemToServer(userConnection, item);
        if (item.identifier() != n2 && item.identifier() != -1) {
            return item;
        }
        item.setIdentifier(n3);
        int n4 = -1;
        if (((Protocol1_13To1_12_2)this.protocol).getMappingData().getItemMappings().inverse().getNewId(n2) == -1) {
            if (!BlockItemPacketRewriter1_13.isDamageable(item.identifier()) && item.identifier() != 358) {
                if (compoundTag == null) {
                    compoundTag = new CompoundTag();
                    item.setTag(compoundTag);
                }
                compoundTag.putInt(this.extraNbtTag, n);
            }
            if (item.identifier() == 229) {
                n4 = 362;
            } else if (item.identifier() == 31 && item.data() == 0) {
                n2 = IdAndData.toRawData(32);
            } else if (((Protocol1_13To1_12_2)this.protocol).getMappingData().getItemMappings().inverse().getNewId(n2 & 0xFFFFFFF0) != -1) {
                n2 &= 0xFFFFFFF0;
            } else {
                if (Via.getConfig().logOtherConversionWarnings()) {
                    ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Failed to get old item for " + item.identifier());
                }
                n2 = 16;
            }
        }
        if (n4 == -1) {
            n4 = ((Protocol1_13To1_12_2)this.protocol).getMappingData().getItemMappings().inverse().getNewId(n2);
        }
        item.setIdentifier(n4);
        item.setData((short)0);
        return item;
    }

    private void rewriteCanPlaceToServer(CompoundTag compoundTag, String string) {
        if (compoundTag.getListTag(string) == null) {
            return;
        }
        ListTag<?> listTag = compoundTag.getListTag(this.extraNbtTag + "|" + string);
        if (listTag != null) {
            compoundTag.remove(this.extraNbtTag + "|" + string);
            compoundTag.put(string, listTag.copy());
        } else {
            listTag = compoundTag.getListTag(string);
            if (listTag != null) {
                ListTag<StringTag> listTag2 = new ListTag<StringTag>(StringTag.class);
                for (Tag tag : listTag) {
                    String string2;
                    String[] stringArray;
                    Object object = tag.getValue();
                    String string3 = Key.stripMinecraftNamespace(object.toString());
                    int n = Ints.tryParse(string3);
                    String string4 = (String)BlockIdData.numberIdToString.get(n);
                    if (string4 != null) {
                        string3 = string4;
                    }
                    if ((stringArray = BlockIdData.blockIdMapping.get(string2 = string3.toLowerCase(Locale.ROOT))) != null) {
                        for (String string5 : stringArray) {
                            listTag2.add(new StringTag(string5));
                        }
                        continue;
                    }
                    listTag2.add(new StringTag(string2));
                }
                compoundTag.put(string, listTag2);
            }
        }
    }

    private void rewriteEnchantmentsToServer(CompoundTag compoundTag, boolean bl) {
        CompoundTag compoundTag2;
        Tag tag;
        Tag tag22;
        Tag tag3;
        String string = bl ? "StoredEnchantments" : "Enchantments";
        ListTag<CompoundTag> listTag = compoundTag.getListTag(bl ? string : "ench", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        ListTag<CompoundTag> listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
        boolean bl2 = false;
        if (!bl) {
            tag3 = compoundTag.remove(this.extraNbtTag + "|OldHideFlags");
            if (tag3 instanceof IntTag) {
                compoundTag.putInt("HideFlags", ((NumberTag)tag3).asByte());
                bl2 = true;
            } else if (compoundTag.remove(this.extraNbtTag + "|DummyEnchant") != null) {
                compoundTag.remove("HideFlags");
                bl2 = true;
            }
        }
        for (CompoundTag object2 : listTag) {
            short s;
            tag22 = object2.getNumberTag("id");
            tag = object2.getNumberTag("lvl");
            CompoundTag compoundTag3 = new CompoundTag();
            short s2 = tag22 != null ? tag22.asShort() : (short)0;
            short s3 = s = tag != null ? tag.asShort() : (short)0;
            if (bl2 && s2 == 0 && s == 0) continue;
            Object object = (String)Protocol1_12_2To1_13.MAPPINGS.getOldEnchantmentsIds().get(s2);
            if (object == null) {
                object = "viaversion:legacy/" + s2;
            }
            compoundTag3.putString("id", (String)object);
            compoundTag3.putShort("lvl", s);
            listTag2.add(compoundTag3);
        }
        tag3 = compoundTag.getListTag(this.extraNbtTag + "|Enchantments", CompoundTag.class);
        if (tag3 != null) {
            for (Tag tag22 : tag3) {
                listTag2.add((CompoundTag)tag22);
            }
            compoundTag.remove(this.extraNbtTag + "|Enchantments");
        }
        if ((compoundTag2 = compoundTag.getCompoundTag("display")) == null) {
            CompoundTag compoundTag4 = new CompoundTag();
            compoundTag.put("display", compoundTag4);
        }
        if ((tag22 = compoundTag.getListTag(this.extraNbtTag + "|OldLore", StringTag.class)) != null) {
            tag = var8_13.getListTag("Lore", StringTag.class);
            if (tag == null) {
                tag = new ListTag<StringTag>(StringTag.class);
                compoundTag.put("Lore", tag);
            }
            ((ListTag)tag).setValue(((ListTag)tag22).getValue());
            compoundTag.remove(this.extraNbtTag + "|OldLore");
        } else if (compoundTag.remove(this.extraNbtTag + "|DummyLore") != null) {
            var8_13.remove("Lore");
            if (var8_13.isEmpty()) {
                compoundTag.remove("display");
            }
        }
        if (!bl) {
            compoundTag.remove("ench");
        }
        compoundTag.put(string, listTag2);
    }

    private void invertShieldAndBannerId(Item item, CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag;
        if (item.identifier() != 442 && item.identifier() != 425) {
            return;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("BlockEntityTag");
        if (compoundTag2 == null) {
            return;
        }
        NumberTag numberTag = compoundTag2.getNumberTag("Base");
        if (numberTag != null) {
            compoundTag2.putInt("Base", 15 - numberTag.asInt());
        }
        if ((listTag = compoundTag2.getListTag("Patterns", CompoundTag.class)) != null) {
            for (CompoundTag compoundTag3 : listTag) {
                NumberTag numberTag2 = compoundTag3.getNumberTag("Color");
                compoundTag3.putInt("Color", 15 - numberTag2.asInt());
            }
        }
    }

    private static void flowerPotSpecialTreatment(UserConnection userConnection, int n, BlockPosition blockPosition) {
        if (FlowerPotHandler.isFlowah(n)) {
            BackwardsBlockEntityProvider backwardsBlockEntityProvider = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
            CompoundTag compoundTag = backwardsBlockEntityProvider.transform(userConnection, blockPosition, "minecraft:flower_pot");
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_12_1.BLOCK_UPDATE, userConnection);
            packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.scheduleSend(Protocol1_13To1_12_2.class);
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_12_1.BLOCK_UPDATE, userConnection);
            packetWrapper2.write(Types.BLOCK_POSITION1_8, blockPosition);
            packetWrapper2.write(Types.VAR_INT, Protocol1_13To1_12_2.MAPPINGS.getNewBlockStateId(n));
            packetWrapper2.scheduleSend(Protocol1_13To1_12_2.class);
            PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_12_1.BLOCK_ENTITY_DATA, userConnection);
            packetWrapper3.write(Types.BLOCK_POSITION1_8, blockPosition);
            packetWrapper3.write(Types.UNSIGNED_BYTE, (short)5);
            packetWrapper3.write(Types.NAMED_COMPOUND_TAG, compoundTag);
            packetWrapper3.scheduleSend(Protocol1_13To1_12_2.class);
        }
    }
}

