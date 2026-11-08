/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter;

import com.google.common.collect.ImmutableSet;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.data.TranslatableMappings;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viabackwards.item.DataItemWithExtras;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.Protocol1_14To1_13_2;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.ChunkLightStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Environment;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionLight;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionLightImpl;
import com.viaversion.viaversion.api.minecraft.chunks.NibbleArray;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_13;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_14;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.api.type.types.version.Types1_13_2;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;
import java.util.List;

public class BlockItemPacketRewriter1_14
extends BackwardsItemRewriter<ClientboundPackets1_14, ServerboundPackets1_13, Protocol1_14To1_13_2> {
    private EnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_14(Protocol1_14To1_13_2 protocol1_14To1_13_2) {
        super(protocol1_14To1_13_2, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_14To1_13_2)this.protocol).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
        ((Protocol1_14To1_13_2)this.protocol).replaceClientbound(ClientboundPackets1_14.OPEN_SCREEN, packetWrapper -> {
            JsonObject jsonObject;
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)n);
            int n2 = packetWrapper.read(Types.VAR_INT);
            String string = null;
            String string2 = null;
            int n3 = 0;
            if (n2 < 6) {
                if (n2 == 2) {
                    string2 = "Barrel";
                }
                string = "minecraft:container";
                n3 = (n2 + 1) * 9;
            } else {
                switch (n2) {
                    case 11: {
                        string = "minecraft:crafting_table";
                        break;
                    }
                    case 9: 
                    case 13: 
                    case 14: 
                    case 20: {
                        if (n2 == 9) {
                            string2 = "Blast Furnace";
                        } else if (n2 == 20) {
                            string2 = "Smoker";
                        } else if (n2 == 14) {
                            string2 = "Grindstone";
                        }
                        string = "minecraft:furnace";
                        n3 = 3;
                        break;
                    }
                    case 6: {
                        string = "minecraft:dropper";
                        n3 = 9;
                        break;
                    }
                    case 12: {
                        string = "minecraft:enchanting_table";
                        break;
                    }
                    case 10: {
                        string = "minecraft:brewing_stand";
                        n3 = 5;
                        break;
                    }
                    case 18: {
                        string = "minecraft:villager";
                        break;
                    }
                    case 8: {
                        string = "minecraft:beacon";
                        n3 = 1;
                        break;
                    }
                    case 7: 
                    case 21: {
                        if (n2 == 21) {
                            string2 = "Cartography Table";
                        }
                        string = "minecraft:anvil";
                        break;
                    }
                    case 15: {
                        string = "minecraft:hopper";
                        n3 = 5;
                        break;
                    }
                    case 19: {
                        string = "minecraft:shulker_box";
                        n3 = 27;
                    }
                }
            }
            if (string == null) {
                ((Protocol1_14To1_13_2)this.protocol).getLogger().warning("Can't open inventory for player! Type: " + n2);
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.STRING, string);
            JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
            if (string2 != null && jsonElement.isJsonObject() && (jsonObject = jsonElement.getAsJsonObject()).has("translate") && (n2 != 2 || jsonObject.getAsJsonPrimitive("translate").getAsString().equals("container.barrel"))) {
                jsonElement = ComponentUtil.legacyToJson(string2);
            }
            packetWrapper.write(Types.COMPONENT, jsonElement);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)n3);
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.HORSE_SCREEN_OPEN, ClientboundPackets1_13.OPEN_SCREEN, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.write(Types.STRING, "EntityHorse");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("translate", "minecraft.horse");
            packetWrapper.write(Types.COMPONENT, jsonObject);
            packetWrapper.write(Types.UNSIGNED_BYTE, packetWrapper.read(Types.VAR_INT).shortValue());
            packetWrapper.passthrough(Types.INT);
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MERCHANT_OFFERS, ClientboundPackets1_13.CUSTOM_PAYLOAD, packetWrapper -> {
            packetWrapper.write(Types.STRING, "minecraft:trader_list");
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.INT, n);
            int n2 = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
            for (int i = 0; i < n2; ++i) {
                Item item = packetWrapper.read(Types.ITEM1_13_2);
                item = this.handleItemToClient(packetWrapper.user(), item);
                packetWrapper.write(Types.ITEM1_13_2, item);
                Item item2 = packetWrapper.read(Types.ITEM1_13_2);
                item2 = this.handleItemToClient(packetWrapper.user(), item2);
                packetWrapper.write(Types.ITEM1_13_2, item2);
                boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                if (bl) {
                    Item item3 = packetWrapper.read(Types.ITEM1_13_2);
                    item3 = this.handleItemToClient(packetWrapper.user(), item3);
                    packetWrapper.write(Types.ITEM1_13_2, item3);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.read(Types.INT);
                packetWrapper.read(Types.INT);
                packetWrapper.read(Types.FLOAT);
            }
            packetWrapper.read(Types.VAR_INT);
            packetWrapper.read(Types.VAR_INT);
            packetWrapper.read(Types.BOOLEAN);
        }, true);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.OPEN_BOOK, ClientboundPackets1_13.CUSTOM_PAYLOAD, packetWrapper -> {
            packetWrapper.write(Types.STRING, "minecraft:book_open");
            packetWrapper.passthrough(Types.VAR_INT);
        });
        ((Protocol1_14To1_13_2)this.protocol).replaceClientbound(ClientboundPackets1_14.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_14.this.passthroughClientboundItem(packetWrapper));
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityType entityType = packetWrapper.user().getEntityTracker(Protocol1_14To1_13_2.class).entityType(n);
                    if (entityType == null) {
                        return;
                    }
                    if (entityType.isOrHasParent(EntityTypes1_14.ABSTRACT_HORSE)) {
                        int n2;
                        packetWrapper.setPacketType(ClientboundPackets1_13.SET_ENTITY_DATA);
                        packetWrapper.resetReader();
                        packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.read(Types.VAR_INT);
                        Item item = packetWrapper.read(Types.ITEM1_13_2);
                        int n3 = n2 = item == null || item.identifier() == 0 ? 0 : item.identifier() - 726;
                        if (n2 < 0 || n2 > 3) {
                            packetWrapper.cancel();
                            return;
                        }
                        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                        arrayList.add(new EntityData(16, Types1_13_2.ENTITY_DATA_TYPES.varIntType, n2));
                        packetWrapper.write(Types1_13.ENTITY_DATA_LIST, arrayList);
                    }
                });
            }
        });
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ImmutableSet<String> immutableSet = ImmutableSet.of("crafting_special_suspiciousstew", "blasting", "smoking", "campfire_cooking", "stonecutting");
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = packetWrapper.read(Types.STRING);
                if (immutableSet.contains(string = Key.stripMinecraftNamespace(string))) {
                    switch (string) {
                        case "blasting": 
                        case "smoking": 
                        case "campfire_cooking": {
                            packetWrapper.read(Types.STRING);
                            packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                            packetWrapper.read(Types.ITEM1_13_2);
                            packetWrapper.read(Types.FLOAT);
                            packetWrapper.read(Types.VAR_INT);
                            break;
                        }
                        case "stonecutting": {
                            packetWrapper.read(Types.STRING);
                            packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                            packetWrapper.read(Types.ITEM1_13_2);
                        }
                    }
                    ++n2;
                    continue;
                }
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.write(Types.STRING, string);
                recipeRewriter.handleRecipeType(packetWrapper, string);
            }
            packetWrapper.set(Types.VAR_INT, 0, n - n2);
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_DESTRUCTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE);
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).replaceClientbound(ClientboundPackets1_14.BLOCK_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = ((Protocol1_14To1_13_2)BlockItemPacketRewriter1_14.this.protocol).getMappingData().getNewBlockId(packetWrapper.get(Types.VAR_INT, 0));
                    if (n == -1) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.set(Types.VAR_INT, 0, n);
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).replaceClientbound(ClientboundPackets1_14.BLOCK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.set(Types.VAR_INT, 0, ((Protocol1_14To1_13_2)BlockItemPacketRewriter1_14.this.protocol).getMappingData().getNewBlockStateId(n));
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 3; ++i) {
                        float f = packetWrapper.get(Types.FLOAT, i).floatValue();
                        if (!(f < 0.0f)) continue;
                        f = (float)Math.floor(f);
                        packetWrapper.set(Types.FLOAT, i, Float.valueOf(f));
                    }
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_14To1_13_2.class);
            Chunk chunk = packetWrapper.read(ChunkType1_14.TYPE);
            packetWrapper.write(ChunkType1_13.forEnvironment(((ClientWorld)t).getEnvironment()), chunk);
            ChunkLightStorage.ChunkLight chunkLight = packetWrapper.user().get(ChunkLightStorage.class).getStoredLight(chunk.getX(), chunk.getZ());
            for (int i = 0; i < chunk.getSections().length; ++i) {
                Object object;
                Object object2;
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection == null) continue;
                ChunkSectionLight chunkSectionLight = ChunkSectionLightImpl.createWithBlockLight();
                chunkSection.setLight(chunkSectionLight);
                if (chunkLight == null) {
                    chunkSectionLight.setBlockLight(ChunkLightStorage.FULL_LIGHT);
                    if (((ClientWorld)t).getEnvironment() == Environment.NORMAL) {
                        chunkSectionLight.setSkyLight(ChunkLightStorage.FULL_LIGHT);
                    }
                } else {
                    object2 = chunkLight.blockLight()[i];
                    chunkSectionLight.setBlockLight((byte[])(object2 != null ? object2 : ChunkLightStorage.FULL_LIGHT));
                    if (((ClientWorld)t).getEnvironment() == Environment.NORMAL) {
                        object = chunkLight.skyLight()[i];
                        chunkSectionLight.setSkyLight((byte[])(object != null ? object : ChunkLightStorage.FULL_LIGHT));
                    }
                }
                object2 = chunkSection.palette(PaletteType.BLOCKS);
                if (Via.getConfig().isNonFullBlockLightFix() && chunkSection.getNonAirBlocksCount() != 0 && chunkSectionLight.hasBlockLight()) {
                    object = chunkSectionLight.getBlockLightNibbleArray();
                    object2.forEachMatchingCoordinate(n -> Protocol1_13_2To1_14.MAPPINGS.getNonFullBlocks().contains(n), arg_0 -> BlockItemPacketRewriter1_14.lambda$registerPackets$7((NibbleArray)object, arg_0));
                }
                for (int j = 0; j < object2.size(); ++j) {
                    int n2 = ((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewBlockStateId(object2.idByIndex(j));
                    object2.setIdByIndex(j, n2);
                }
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.FORGET_LEVEL_CHUNK, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            int n2 = packetWrapper.passthrough(Types.INT);
            packetWrapper.user().get(ChunkLightStorage.class).unloadChunk(n, n2);
        });
        ((Protocol1_14To1_13_2)this.protocol).replaceClientbound(ClientboundPackets1_14.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, ((Protocol1_14To1_13_2)BlockItemPacketRewriter1_14.this.protocol).getMappingData().getNewItemId(n2));
                    } else if (n == 2001) {
                        packetWrapper.set(Types.INT, 1, ((Protocol1_14To1_13_2)BlockItemPacketRewriter1_14.this.protocol).getMappingData().getNewBlockStateId(n2));
                    }
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new EnchantmentRewriter(this, false);
        this.enchantmentRewriter.registerEnchantment("minecraft:multishot", "\u00a77Multishot");
        this.enchantmentRewriter.registerEnchantment("minecraft:quick_charge", "\u00a77Quick Charge");
        this.enchantmentRewriter.registerEnchantment("minecraft:piercing", "\u00a77Piercing");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        DataItemWithExtras dataItemWithExtras;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag2 = compoundTag = (item = super.handleItemToClient(userConnection, item)).tag() != null ? item.tag().getCompoundTag("display") : null;
        if (compoundTag != null && item instanceof DataItemWithExtras && (dataItemWithExtras = (DataItemWithExtras)item).lore() != null) {
            List<JsonElement> list = dataItemWithExtras.lore();
            ListTag<StringTag> listTag = dataItemWithExtras.rawLore();
            this.saveListTag(compoundTag, listTag, "Lore");
            try {
                for (int i = 0; i < list.size(); ++i) {
                    JsonElement jsonElement = list.get(i);
                    TextComponent textComponent = SerializerVersion.V1_12.toComponent(jsonElement);
                    if (textComponent == null) {
                        list.remove(i);
                        listTag.remove(i);
                        --i;
                        continue;
                    }
                    TextUtils.setTranslator(textComponent, string -> Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().getOrDefault(string, TranslatableMappings.getTranslatableMappings("1.14").get(string)));
                    listTag.get(i).setValue(textComponent.asLegacyFormatString());
                }
            }
            catch (JsonParseException jsonParseException) {
                compoundTag.remove("Lore");
            }
        }
        if (item instanceof DataItemWithExtras) {
            item = new DataItem(item.identifier(), (byte)item.amount(), item.data(), item.tag());
        }
        this.enchantmentRewriter.handleToClient(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        ListTag<StringTag> listTag;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag2 = item.tag();
        if (compoundTag2 != null && (compoundTag = compoundTag2.getCompoundTag("display")) != null && (listTag = compoundTag.getListTag("Lore", StringTag.class)) != null && !this.hasBackupTag(compoundTag, "Lore")) {
            for (StringTag stringTag : listTag) {
                stringTag.setValue(ComponentUtil.legacyToJsonString(stringTag.getValue()));
            }
        }
        this.enchantmentRewriter.handleToServer(item);
        item = super.handleItemToServer(userConnection, item);
        return item;
    }

    private static /* synthetic */ void lambda$registerPackets$7(NibbleArray nibbleArray, int n) {
        nibbleArray.set(ChunkSection.xFromIndex(n), ChunkSection.yFromIndex(n), ChunkSection.zFromIndex(n), 0);
    }
}

