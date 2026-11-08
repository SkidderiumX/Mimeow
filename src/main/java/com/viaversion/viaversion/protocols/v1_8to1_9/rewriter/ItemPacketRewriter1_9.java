/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EntityIds1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.PotionIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.InventoryTracker;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemPacketRewriter1_9
extends ItemRewriter<ClientboundPackets1_8, ServerboundPackets1_9, Protocol1_8To1_9> {
    public ItemPacketRewriter1_9(Protocol1_8To1_9 protocol1_8To1_9) {
        super(protocol1_8To1_9, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper2 -> {
                    short s = packetWrapper2.get(Types.UNSIGNED_BYTE, 0);
                    short s2 = packetWrapper2.get(Types.SHORT, 0);
                    short s3 = packetWrapper2.get(Types.SHORT, 1);
                    InventoryTracker inventoryTracker = packetWrapper2.user().get(InventoryTracker.class);
                    if (inventoryTracker.getInventory() != null && inventoryTracker.getInventory().equalsIgnoreCase("minecraft:enchanting_table") && s2 > 3 && s2 < 7) {
                        short s4 = (short)(s3 >> 8);
                        short s5 = (short)(s3 & 0xFF);
                        packetWrapper2.create(packetWrapper2.getId(), packetWrapper -> {
                            packetWrapper.write(Types.UNSIGNED_BYTE, s);
                            packetWrapper.write(Types.SHORT, s2);
                            packetWrapper.write(Types.SHORT, s5);
                        }).scheduleSend(Protocol1_8To1_9.class);
                        packetWrapper2.set(Types.SHORT, 0, (short)(s2 + 3));
                        packetWrapper2.set(Types.SHORT, 1, s4);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.map(Types.STRING, Protocol1_8To1_9.STRING_TO_JSON);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    inventoryTracker.setInventory(string);
                });
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("minecraft:brewing_stand")) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 1, (short)(packetWrapper.get(Types.UNSIGNED_BYTE, 1) + 1));
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    boolean bl;
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    boolean bl2 = bl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                    if (bl) {
                        InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        short s = packetWrapper.get(Types.SHORT, 0);
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        inventoryTracker.setItemId(by, s, item == null ? 0 : item.identifier());
                        entityTracker1_9.syncShieldWithSword();
                    }
                    ItemPacketRewriter1_9.this.handleItemToClient(packetWrapper.user(), item);
                });
                this.handler(packetWrapper -> {
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    short s = packetWrapper.get(Types.SHORT, 0);
                    if (inventoryTracker.getInventory() != null && inventoryTracker.getInventory().equals("minecraft:brewing_stand") && s >= 4) {
                        packetWrapper.set(Types.SHORT, 0, (short)(s + 1));
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_SET_CONTENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.ITEM1_8_SHORT_ARRAY);
                this.handler(packetWrapper -> {
                    Item[] itemArray = packetWrapper.get(Types.ITEM1_8_SHORT_ARRAY, 0);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    boolean bl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                    for (short s2 = 0; s2 < itemArray.length; s2 = (short)(s2 + 1)) {
                        Item item = itemArray[s2];
                        if (bl) {
                            inventoryTracker.setItemId(s, s2, item == null ? 0 : item.identifier());
                        }
                        ItemPacketRewriter1_9.this.handleItemToClient(packetWrapper.user(), item);
                    }
                    if (bl) {
                        entityTracker1_9.syncShieldWithSword();
                    }
                });
                this.handler(packetWrapper -> {
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    if (inventoryTracker.getInventory() != null && inventoryTracker.getInventory().equals("minecraft:brewing_stand")) {
                        Item[] itemArray = packetWrapper.get(Types.ITEM1_8_SHORT_ARRAY, 0);
                        Item[] itemArray2 = new Item[itemArray.length + 1];
                        for (int i = 0; i < itemArray2.length; ++i) {
                            if (i > 4) {
                                itemArray2[i] = itemArray[i - 1];
                                continue;
                            }
                            if (i == 4) continue;
                            itemArray2[i] = itemArray[i];
                        }
                        packetWrapper.set(Types.ITEM1_8_SHORT_ARRAY, 0, itemArray2);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.CONTAINER_CLOSE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    inventoryTracker.setInventory(null);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    inventoryTracker.resetInventory(s);
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, true));
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.SET_CREATIVE_MODE_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    boolean bl;
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    boolean bl2 = bl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                    if (bl) {
                        InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        short s = packetWrapper.get(Types.SHORT, 0);
                        inventoryTracker.setItemId(0, s, item == null ? 0 : item.identifier());
                        entityTracker1_9.syncShieldWithSword();
                    }
                    ItemPacketRewriter1_9.this.handleItemToServer(packetWrapper.user(), item);
                });
                this.handler(packetWrapper2 -> {
                    boolean bl;
                    short s = packetWrapper2.get(Types.SHORT, 0);
                    boolean bl2 = bl = s == 45;
                    if (bl) {
                        packetWrapper2.create(ClientboundPackets1_9.CONTAINER_SET_SLOT, packetWrapper -> {
                            packetWrapper.write(Types.BYTE, (byte)0);
                            packetWrapper.write(Types.SHORT, s);
                            packetWrapper.write(Types.ITEM1_8, null);
                        }).send(Protocol1_8To1_9.class);
                        packetWrapper2.set(Types.SHORT, 0, (short)-999);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT, Types.BYTE);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    if (Via.getConfig().isShowShieldWhenSwordInHand()) {
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        byte by2 = packetWrapper.get(Types.BYTE, 2);
                        short s = packetWrapper.get(Types.SHORT, 0);
                        byte by3 = packetWrapper.get(Types.BYTE, 1);
                        InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                        inventoryTracker.handleWindowClick(packetWrapper.user(), by, by2, s, by3);
                    }
                    ItemPacketRewriter1_9.this.handleItemToServer(packetWrapper.user(), item);
                });
                this.handler(packetWrapper2 -> {
                    byte by = packetWrapper2.get(Types.BYTE, 0);
                    short s = packetWrapper2.get(Types.SHORT, 0);
                    boolean bl = s == 45 && by == 0;
                    InventoryTracker inventoryTracker = packetWrapper2.user().get(InventoryTracker.class);
                    if (inventoryTracker.getInventory() != null && inventoryTracker.getInventory().equals("minecraft:brewing_stand")) {
                        if (s == 4) {
                            bl = true;
                        }
                        if (s > 4) {
                            packetWrapper2.set(Types.SHORT, 0, (short)(s - 1));
                        }
                    }
                    if (bl) {
                        packetWrapper2.create(ClientboundPackets1_9.CONTAINER_SET_SLOT, packetWrapper -> {
                            packetWrapper.write(Types.BYTE, by);
                            packetWrapper.write(Types.SHORT, s);
                            packetWrapper.write(Types.ITEM1_8, null);
                        }).scheduleSend(Protocol1_8To1_9.class);
                        packetWrapper2.set(Types.BYTE, 1, (byte)0);
                        packetWrapper2.set(Types.BYTE, 2, (byte)0);
                        packetWrapper2.set(Types.SHORT, 0, (short)-999);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.CONTAINER_CLOSE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                    inventoryTracker.setInventory(null);
                    inventoryTracker.resetInventory(packetWrapper.get(Types.BYTE, 0).byteValue());
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.SET_CARRIED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    boolean bl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (entityTracker1_9.isBlocking()) {
                        entityTracker1_9.setBlocking(false);
                        if (!bl) {
                            entityTracker1_9.setSecondHand(null);
                        }
                    }
                    if (bl) {
                        entityTracker1_9.setHeldItemSlot(packetWrapper.get(Types.SHORT, 0).shortValue());
                        entityTracker1_9.syncShieldWithSword();
                    }
                });
            }
        });
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        StringTag stringTag;
        Object object;
        Tag tag;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        if (item.identifier() == 62) {
            item.setIdentifier(61);
            compoundTag = item.tag();
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
            }
            compoundTag.putBoolean(this.nbtTagName("lit_furnace"), true);
            tag = compoundTag.getCompoundTag("display");
            if (tag == null) {
                tag = new CompoundTag();
                compoundTag.put("display", tag);
                ((CompoundTag)tag).putBoolean(this.nbtTagName(), true);
            }
            if ((object = ((CompoundTag)tag).getStringTag("Name")) == null) {
                object = new StringTag("1.8 Lit Furnace");
                ((CompoundTag)tag).put("Name", (Tag)object);
                ((CompoundTag)tag).putBoolean(this.nbtTagName("custom_name"), true);
            }
            item.setTag(compoundTag);
        }
        if (item.identifier() == 383 && item.data() != 0) {
            compoundTag = item.tag();
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
            }
            tag = new CompoundTag();
            object = EntityIds1_8.ENTITY_ID_TO_NAME.get(item.data());
            if (object != null) {
                stringTag = new StringTag((String)object);
                ((CompoundTag)tag).put("id", stringTag);
                compoundTag.put("EntityTag", tag);
            }
            item.setTag(compoundTag);
            item.setData((short)0);
        }
        if (item.identifier() == 373) {
            compoundTag = item.tag();
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
            }
            if (item.data() >= 16384) {
                item.setIdentifier(438);
                item.setData((short)(item.data() - 8192));
            }
            tag = PotionIdMappings1_9.potionNameFromDamage(item.data());
            object = new StringTag(Key.namespaced(tag));
            compoundTag.put("Potion", (Tag)object);
            item.setTag(compoundTag);
            item.setData((short)0);
        }
        if (item.identifier() == 387) {
            compoundTag = item.tag();
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
            }
            tag = compoundTag.getListTag("pages", StringTag.class);
            compoundTag.put(this.nbtTagName("pages"), tag == null ? new ListTag<StringTag>(StringTag.class) : ((ListTag)tag).copy());
            if (tag == null) {
                tag = new ListTag<StringTag>(Collections.singletonList(new StringTag(ComponentUtil.emptyJsonComponent().toString())));
                compoundTag.put("pages", tag);
            } else {
                for (int i = 0; i < ((ListTag)tag).size(); ++i) {
                    stringTag = (StringTag)((ListTag)tag).get(i);
                    try {
                        stringTag.setValue(ComponentUtil.convertJsonOrEmpty(stringTag.getValue(), SerializerVersion.V1_8, SerializerVersion.V1_9).toString());
                        continue;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
            item.setTag(compoundTag);
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        block18: {
            Tag tag;
            CompoundTag compoundTag;
            block19: {
                block20: {
                    Object object;
                    Tag tag2;
                    if (item == null) {
                        return null;
                    }
                    if (item.identifier() == 61 && (compoundTag = item.tag()) != null && compoundTag.remove(this.nbtTagName("lit_furnace")) != null) {
                        item.setIdentifier(62);
                        tag2 = compoundTag.getCompoundTag("display");
                        if (tag2 != null) {
                            if (((CompoundTag)tag2).remove(this.nbtTagName("custom_name")) != null) {
                                ((CompoundTag)tag2).remove("Name");
                            }
                            if (((CompoundTag)tag2).remove(this.nbtTagName()) != null) {
                                compoundTag.remove("display");
                                if (compoundTag.isEmpty()) {
                                    item.setTag(null);
                                }
                            }
                        }
                    }
                    if (item.identifier() == 383 && item.data() == 0) {
                        compoundTag = item.tag();
                        int n = 0;
                        if (compoundTag != null && compoundTag.getCompoundTag("EntityTag") != null) {
                            tag = compoundTag.getCompoundTag("EntityTag");
                            object = ((CompoundTag)tag).getStringTag("id");
                            if (object != null && EntityIds1_8.ENTITY_NAME_TO_ID.containsKey(((StringTag)object).getValue())) {
                                n = EntityIds1_8.ENTITY_NAME_TO_ID.get(((StringTag)object).getValue());
                            }
                            compoundTag.remove("EntityTag");
                        }
                        item.setTag(compoundTag);
                        item.setData((short)n);
                    }
                    if (item.identifier() == 373) {
                        compoundTag = item.tag();
                        int n = 0;
                        if (compoundTag != null && compoundTag.getStringTag("Potion") != null) {
                            tag = compoundTag.getStringTag("Potion");
                            object = Key.stripMinecraftNamespace(((StringTag)tag).getValue());
                            if (PotionIdMappings1_9.POTION_NAME_TO_ID.containsKey(object)) {
                                n = PotionIdMappings1_9.POTION_NAME_TO_ID.get(object);
                            }
                            compoundTag.remove("Potion");
                        }
                        item.setTag(compoundTag);
                        item.setData((short)n);
                    }
                    if (item.identifier() == 438) {
                        compoundTag = item.tag();
                        int n = 0;
                        item.setIdentifier(373);
                        if (compoundTag != null && compoundTag.getStringTag("Potion") != null) {
                            tag = compoundTag.getStringTag("Potion");
                            object = Key.stripMinecraftNamespace(((StringTag)tag).getValue());
                            if (PotionIdMappings1_9.POTION_NAME_TO_ID.containsKey(object)) {
                                n = PotionIdMappings1_9.POTION_NAME_TO_ID.get(object) + 8192;
                            }
                            compoundTag.remove("Potion");
                        }
                        item.setTag(compoundTag);
                        item.setData((short)n);
                    }
                    if (item.identifier() != 387 || (compoundTag = item.tag()) == null) break block18;
                    tag2 = (ListTag)compoundTag.removeUnchecked(this.nbtTagName("pages"));
                    if (tag2 == null) break block19;
                    if (((ListTag)tag2).isEmpty()) break block20;
                    compoundTag.put("pages", tag2);
                    break block18;
                }
                compoundTag.remove("pages");
                if (!compoundTag.isEmpty()) break block18;
                item.setTag(null);
                break block18;
            }
            tag = compoundTag.getListTag("pages", StringTag.class);
            if (tag != null) {
                for (int i = 0; i < ((ListTag)tag).size(); ++i) {
                    StringTag stringTag = (StringTag)((ListTag)tag).get(i);
                    stringTag.setValue(ComponentUtil.convertJsonOrEmpty(stringTag.getValue(), SerializerVersion.V1_9, SerializerVersion.V1_8).toString());
                }
            }
        }
        boolean bl = item.identifier() >= 198 && item.identifier() <= 212;
        bl |= item.identifier() == 397 && item.data() == 5;
        if (bl |= item.identifier() >= 432 && item.identifier() <= 448) {
            item.setIdentifier(1);
            item.setData((short)0);
        }
        return item;
    }
}

