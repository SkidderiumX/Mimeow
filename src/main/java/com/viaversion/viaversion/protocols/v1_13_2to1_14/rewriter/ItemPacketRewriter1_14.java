/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.google.common.collect.Sets;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.storage.EntityTracker1_14;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ItemPacketRewriter1_14
extends ItemRewriter<ClientboundPackets1_13, ServerboundPackets1_14, Protocol1_13_2To1_14> {
    private static final Set<String> REMOVED_RECIPE_TYPES = Sets.newHashSet("crafting_special_banneraddpattern", "crafting_special_repairitem");
    private static final JsonNBTComponentRewriter<ClientboundPackets1_13> COMPONENT_REWRITER = new JsonNBTComponentRewriter<ClientboundPackets1_13>(null, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject jsonObject, String string) {
            super.handleTranslate(jsonObject, string);
            if (string.startsWith("block.") && string.endsWith(".name")) {
                jsonObject.addProperty("translate", string.substring(0, string.length() - 5));
            }
        }
    };

    public ItemPacketRewriter1_14(Protocol1_13_2To1_14 protocol1_13_2To1_14) {
        super(protocol1_13_2To1_14, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.OPEN_SCREEN, null, packetWrapper -> {
            Short s = packetWrapper.read(Types.UNSIGNED_BYTE);
            String string = packetWrapper.read(Types.STRING);
            JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
            COMPONENT_REWRITER.processText(packetWrapper.user(), jsonElement);
            Short s2 = packetWrapper.read(Types.UNSIGNED_BYTE);
            if (string.equals("EntityHorse")) {
                packetWrapper.setPacketType(ClientboundPackets1_14.HORSE_SCREEN_OPEN);
                int n = packetWrapper.read(Types.INT);
                packetWrapper.write(Types.UNSIGNED_BYTE, s);
                packetWrapper.write(Types.VAR_INT, s2.intValue());
                packetWrapper.write(Types.INT, n);
            } else {
                packetWrapper.setPacketType(ClientboundPackets1_14.OPEN_SCREEN);
                packetWrapper.write(Types.VAR_INT, s.intValue());
                int n = -1;
                switch (string) {
                    case "minecraft:crafting_table": {
                        n = 11;
                        break;
                    }
                    case "minecraft:furnace": {
                        n = 13;
                        break;
                    }
                    case "minecraft:dropper": 
                    case "minecraft:dispenser": {
                        n = 6;
                        break;
                    }
                    case "minecraft:enchanting_table": {
                        n = 12;
                        break;
                    }
                    case "minecraft:brewing_stand": {
                        n = 10;
                        break;
                    }
                    case "minecraft:villager": {
                        n = 18;
                        break;
                    }
                    case "minecraft:beacon": {
                        n = 8;
                        break;
                    }
                    case "minecraft:anvil": {
                        n = 7;
                        break;
                    }
                    case "minecraft:hopper": {
                        n = 15;
                        break;
                    }
                    case "minecraft:shulker_box": {
                        n = 19;
                        break;
                    }
                    default: {
                        if (s2 <= 0 || s2 > 54) break;
                        n = s2 / 9 - 1;
                    }
                }
                if (n == -1) {
                    ((Protocol1_13_2To1_14)this.protocol).getLogger().warning("Can't open inventory for player! Type: " + string + " Size: " + s2);
                }
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.COMPONENT, jsonElement);
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = Key.namespaced(packetWrapper.get(Types.STRING, 0));
                    if (string.equals("minecraft:trader_list")) {
                        packetWrapper.setPacketType(ClientboundPackets1_14.MERCHANT_OFFERS);
                        packetWrapper.resetReader();
                        packetWrapper.read(Types.STRING);
                        int n = packetWrapper.read(Types.INT);
                        EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
                        entityTracker1_14.setLatestTradeWindowId(n);
                        packetWrapper.write(Types.VAR_INT, n);
                        int n2 = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                        for (int i = 0; i < n2; ++i) {
                            ItemPacketRewriter1_14.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                            ItemPacketRewriter1_14.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                            if (bl) {
                                ItemPacketRewriter1_14.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                            }
                            packetWrapper.passthrough(Types.BOOLEAN);
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.write(Types.INT, 0);
                            packetWrapper.write(Types.INT, 0);
                            packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
                        }
                        packetWrapper.write(Types.VAR_INT, 0);
                        packetWrapper.write(Types.VAR_INT, 0);
                        packetWrapper.write(Types.BOOLEAN, false);
                        packetWrapper.clearInputBuffer();
                    } else if (string.equals("minecraft:book_open")) {
                        int n = packetWrapper.read(Types.VAR_INT);
                        packetWrapper.clearPacket();
                        packetWrapper.setPacketType(ClientboundPackets1_14.OPEN_BOOK);
                        packetWrapper.write(Types.VAR_INT, n);
                    }
                });
            }
        });
        RecipeRewriter recipeRewriter = new RecipeRewriter(this.protocol);
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = packetWrapper.read(Types.STRING);
                if (REMOVED_RECIPE_TYPES.contains(string2)) {
                    ++n2;
                    continue;
                }
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.write(Types.STRING, string);
                recipeRewriter.handleRecipeType(packetWrapper, string2);
            }
            packetWrapper.set(Types.VAR_INT, 0, n - n2);
        });
        ((Protocol1_13_2To1_14)this.protocol).registerServerbound(ServerboundPackets1_14.SELECT_TRADE, packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_13.CONTAINER_CLICK);
            EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
            packetWrapper2.write(Types.BYTE, (byte)entityTracker1_14.getLatestTradeWindowId());
            packetWrapper2.write(Types.SHORT, (short)-999);
            packetWrapper2.write(Types.BYTE, (byte)2);
            packetWrapper2.write(Types.SHORT, (short)ThreadLocalRandom.current().nextInt());
            packetWrapper2.write(Types.VAR_INT, 5);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("force_resync", new DoubleTag(Double.NaN));
            packetWrapper2.write(Types.ITEM1_13_2, new DataItem(1, 1, compoundTag));
            packetWrapper2.scheduleSendToServer(Protocol1_13_2To1_14.class);
        });
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        ListTag<StringTag> listTag;
        if (item == null) {
            return null;
        }
        item.setIdentifier(Protocol1_13_2To1_14.MAPPINGS.getNewItemId(item.identifier()));
        if (item.tag() == null) {
            return item;
        }
        CompoundTag compoundTag = item.tag().getCompoundTag("display");
        if (compoundTag != null && (listTag = compoundTag.getListTag("Lore", StringTag.class)) != null) {
            compoundTag.put(this.nbtTagName("Lore"), listTag.copy());
            for (StringTag stringTag : listTag) {
                String string = ComponentUtil.legacyToJsonString(stringTag.getValue(), true);
                stringTag.setValue(string);
            }
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        ListTag<StringTag> listTag;
        if (item == null) {
            return null;
        }
        item.setIdentifier(Protocol1_13_2To1_14.MAPPINGS.getOldItemId(item.identifier()));
        if (item.tag() == null) {
            return item;
        }
        CompoundTag compoundTag = item.tag().getCompoundTag("display");
        if (compoundTag != null && (listTag = compoundTag.getListTag("Lore", StringTag.class)) != null) {
            Tag tag = compoundTag.remove(this.nbtTagName("Lore"));
            if (tag instanceof ListTag) {
                compoundTag.put("Lore", tag.copy());
            } else {
                for (StringTag stringTag : listTag) {
                    stringTag.setValue(ComponentUtil.jsonToLegacy(stringTag.getValue()));
                }
            }
        }
        return item;
    }
}

