/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.rewriters.LegacyEnchantmentRewriter;
import com.viaversion.viarewind.api.rewriter.VRBlockItemRewriter;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.GameProfileStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.InventoryTracker;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.UUID;

public class BlockItemPacketRewriter1_8
extends VRBlockItemRewriter<ClientboundPackets1_8, ServerboundPackets1_7_2_5, Protocol1_8To1_7_6_10> {
    private LegacyEnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_8(Protocol1_8To1_7_6_10 protocol1_8To1_7_6_10) {
        super(protocol1_8To1_7_6_10, "1.8");
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.OPEN_SCREEN, packetWrapper -> {
            InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            short s2 = InventoryTracker.getInventoryType(packetWrapper.read(Types.STRING));
            inventoryTracker.getWindowTypeMap().put(s, s2);
            packetWrapper.write(Types.UNSIGNED_BYTE, s2);
            JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
            String string = ChatUtil.jsonToLegacy(jsonElement);
            string = ChatUtil.removeUnusedColor(string, '8');
            if (string.length() > 32) {
                string = string.substring(0, 32);
            }
            packetWrapper.write(Types.STRING, string);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.write(Types.BOOLEAN, true);
            if (s2 == 11) {
                packetWrapper.passthrough(Types.INT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_CLOSE, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.user().get(InventoryTracker.class).remove(s);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.user().get(InventoryTracker.class).get(packetWrapper.get(Types.BYTE, 0).byteValue());
                    short s2 = packetWrapper.get(Types.SHORT, 0);
                    if (s == 4) {
                        if (s2 == 1) {
                            packetWrapper.cancel();
                        } else if (s2 >= 2) {
                            packetWrapper.set(Types.SHORT, 0, (short)(s2 - 1));
                        }
                    }
                });
                this.map(Types.ITEM1_8, RewindTypes.COMPRESSED_NBT_ITEM);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_8.this.handleItemToClient(packetWrapper.user(), packetWrapper.get(RewindTypes.COMPRESSED_NBT_ITEM, 0)));
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by != 0) {
                        return;
                    }
                    short s = packetWrapper.get(Types.SHORT, 0);
                    if (s < 5 || s > 8) {
                        return;
                    }
                    PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
                    Item item = packetWrapper.get(RewindTypes.COMPRESSED_NBT_ITEM, 0);
                    playerSessionStorage.setPlayerEquipment(packetWrapper.user().getProtocolInfo().getUuid(), item, 8 - s);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (entityTracker1_8.isSpectator()) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_CONTENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.user().get(InventoryTracker.class).get(packetWrapper.get(Types.UNSIGNED_BYTE, 0));
                    Item[] itemArray = packetWrapper.read(Types.ITEM1_8_SHORT_ARRAY);
                    if (s == 4) {
                        Item[] itemArray2 = itemArray;
                        itemArray = new Item[itemArray2.length - 1];
                        itemArray[0] = itemArray2[0];
                        System.arraycopy(itemArray2, 2, itemArray, 1, itemArray2.length - 2);
                    }
                    for (int i = 0; i < itemArray.length; ++i) {
                        itemArray[i] = BlockItemPacketRewriter1_8.this.handleItemToClient(packetWrapper.user(), itemArray[i]);
                    }
                    packetWrapper.write(RewindTypes.COMPRESSED_NBT_ITEM_ARRAY, itemArray);
                });
                this.handler(packetWrapper -> {
                    GameProfileStorage.GameProfile gameProfile;
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (s != 0) {
                        return;
                    }
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                    Item[] itemArray = packetWrapper.get(RewindTypes.COMPRESSED_NBT_ITEM_ARRAY, 0);
                    for (int i = 5; i < 9; ++i) {
                        packetWrapper.user().get(PlayerSessionStorage.class).setPlayerEquipment(uUID, itemArray[i], 8 - i);
                        if (!entityTracker1_8.isSpectator()) continue;
                        itemArray[i] = null;
                    }
                    if (entityTracker1_8.isSpectator() && (gameProfile = packetWrapper.user().get(GameProfileStorage.class).get(uUID)) != null) {
                        itemArray[5] = gameProfile.getSkull();
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    short s2 = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    short s3 = inventoryTracker.get(s2);
                    short s4 = packetWrapper.get(Types.SHORT, 0);
                    short s5 = packetWrapper.get(Types.SHORT, 1);
                    if (s3 == 2) {
                        InventoryTracker.FurnaceData furnaceData = inventoryTracker.getFurnaceData().computeIfAbsent(s2, s -> new InventoryTracker.FurnaceData());
                        if (s4 == 0 || s4 == 1) {
                            if (s4 == 0) {
                                furnaceData.fuelLeft = s5;
                            } else {
                                furnaceData.maxFuel = s5;
                            }
                            if (furnaceData.maxFuel == 0) {
                                packetWrapper.cancel();
                                return;
                            }
                            s5 = (short)(200 * furnaceData.fuelLeft / furnaceData.maxFuel);
                            packetWrapper.set(Types.SHORT, 0, (short)1);
                            packetWrapper.set(Types.SHORT, 1, s5);
                        } else if (s4 == 2 || s4 == 3) {
                            if (s4 == 2) {
                                furnaceData.progress = s5;
                            } else {
                                furnaceData.maxProgress = s5;
                            }
                            if (furnaceData.maxProgress == 0) {
                                packetWrapper.cancel();
                                return;
                            }
                            s5 = (short)(200 * furnaceData.progress / furnaceData.maxProgress);
                            packetWrapper.set(Types.SHORT, 0, (short)0);
                            packetWrapper.set(Types.SHORT, 1, s5);
                        }
                    } else if (s3 == 4 && s4 > 2) {
                        packetWrapper.cancel();
                    } else if (s3 == 8) {
                        inventoryTracker.levelCost = s5;
                        inventoryTracker.anvilId = s2;
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.CONTAINER_CLOSE, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            packetWrapper.user().get(InventoryTracker.class).remove(by);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    short s = packetWrapper.get(Types.SHORT, 0);
                    short s2 = packetWrapper.user().get(InventoryTracker.class).get(by);
                    if (s2 == 4 && s > 0) {
                        packetWrapper.set(Types.SHORT, 0, (short)(s + 1));
                    }
                });
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(RewindTypes.COMPRESSED_NBT_ITEM, Types.ITEM1_8);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_8.this.handleItemToServer(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.SET_CREATIVE_MODE_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT);
                this.map(RewindTypes.COMPRESSED_NBT_ITEM, Types.ITEM1_8);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_8.this.handleItemToServer(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new LegacyEnchantmentRewriter(this.nbtTagName(), false);
        this.enchantmentRewriter.registerEnchantment(8, "\u00a77Depth Strider");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        super.handleItemToClient(userConnection, item);
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return item;
        }
        this.enchantmentRewriter.handleToClient(item);
        if (item.identifier() == 387) {
            ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
            if (listTag == null) {
                return item;
            }
            ListTag<StringTag> listTag2 = new ListTag<StringTag>(StringTag.class);
            compoundTag.put(this.nbtTagName() + "|pages", listTag2);
            for (StringTag stringTag : listTag) {
                String string = stringTag.getValue();
                listTag2.add(new StringTag(string));
                stringTag.setValue(ChatUtil.jsonToLegacy(string));
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
        super.handleItemToServer(userConnection, item);
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return item;
        }
        this.enchantmentRewriter.handleToServer(item);
        if (item.identifier() == 387 && (listTag = compoundTag.getListTag(this.nbtTagName() + "|pages", StringTag.class)) != null) {
            compoundTag.remove("pages");
            compoundTag.put("pages", listTag);
        }
        return item;
    }
}

