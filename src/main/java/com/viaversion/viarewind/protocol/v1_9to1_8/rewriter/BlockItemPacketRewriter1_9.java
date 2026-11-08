/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.LegacyEnchantmentRewriter;
import com.viaversion.viarewind.api.rewriter.VRBlockItemRewriter;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.data.PotionIdMappings1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.WindowTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EntityIds1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.PotionIdMappings1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.util.Key;
import java.util.HashSet;
import java.util.Set;

public class BlockItemPacketRewriter1_9
extends VRBlockItemRewriter<ClientboundPackets1_9, ServerboundPackets1_8, Protocol1_9To1_8> {
    public final Set<String> VALID_ATTRIBUTES = new HashSet<String>();
    private LegacyEnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_9(Protocol1_9To1_8 protocol1_9To1_8) {
        super(protocol1_9To1_8, "1.9");
        this.VALID_ATTRIBUTES.add("generic.maxHealth");
        this.VALID_ATTRIBUTES.add("generic.followRange");
        this.VALID_ATTRIBUTES.add("generic.knockbackResistance");
        this.VALID_ATTRIBUTES.add("generic.movementSpeed");
        this.VALID_ATTRIBUTES.add("generic.attackDamage");
        this.VALID_ATTRIBUTES.add("horse.jumpStrength");
        this.VALID_ATTRIBUTES.add("zombie.spawnReinforcements");
    }

    @Override
    protected void registerPackets() {
        this.registerBlockChange(ClientboundPackets1_9.BLOCK_UPDATE);
        this.registerMultiBlockChange(ClientboundPackets1_9.CHUNK_BLOCKS_UPDATE);
        this.registerSetCreativeModeSlot(ServerboundPackets1_8.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CONTAINER_CLOSE, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
            String string = windowTracker.get(s);
            if (string != null && string.equalsIgnoreCase("minecraft:enchanting_table")) {
                windowTracker.clearEnchantmentProperties();
            }
            windowTracker.remove(s);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.OPEN_SCREEN, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            String string = packetWrapper.passthrough(Types.STRING);
            packetWrapper.user().get(WindowTracker.class).put(s, string);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CONTAINER_SET_CONTENT, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            Item[] itemArray = packetWrapper.read(Types.ITEM1_8_SHORT_ARRAY);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClient(packetWrapper.user(), itemArray[i]);
            }
            if (s == 0 && itemArray.length == 46) {
                Item[] itemArray2 = itemArray;
                itemArray = new Item[45];
                System.arraycopy(itemArray2, 0, itemArray, 0, 45);
            } else {
                String string = packetWrapper.user().get(WindowTracker.class).get(s);
                if (string != null && string.equalsIgnoreCase("minecraft:brewing_stand")) {
                    System.arraycopy(itemArray, 0, packetWrapper.user().get(WindowTracker.class).getBrewingItems(s), 0, 4);
                    WindowTracker.updateBrewingStand(packetWrapper.user(), itemArray[4], s);
                    Item[] itemArray3 = itemArray;
                    itemArray = new Item[itemArray3.length - 1];
                    System.arraycopy(itemArray3, 0, itemArray, 0, 4);
                    System.arraycopy(itemArray3, 5, itemArray, 4, itemArray3.length - 5);
                }
            }
            packetWrapper.write(Types.ITEM1_8_SHORT_ARRAY, itemArray);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CONTAINER_SET_SLOT, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            short s = packetWrapper.passthrough(Types.SHORT);
            Item item = packetWrapper.passthrough(Types.ITEM1_8);
            this.handleItemToClient(packetWrapper.user(), item);
            if (by == 0 && s == 45) {
                packetWrapper.cancel();
                return;
            }
            WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
            String string = windowTracker.get(by);
            if (string != null && string.equalsIgnoreCase("minecraft:brewing_stand")) {
                if (s > 4) {
                    packetWrapper.set(Types.SHORT, 0, (short)(s - 1));
                } else if (s == 4) {
                    packetWrapper.cancel();
                    WindowTracker.updateBrewingStand(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0), by);
                } else {
                    windowTracker.getBrewingItems((short)((short)by))[s] = packetWrapper.get(Types.ITEM1_8, 0);
                }
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.CONTAINER_CLOSE, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            packetWrapper.user().get(WindowTracker.class).remove(by);
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE, Types.VAR_INT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_9.this.handleItemToServer(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
                this.handler(packetWrapper -> {
                    short s;
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    String string = packetWrapper.user().get(WindowTracker.class).get(by);
                    if (string != null && string.equalsIgnoreCase("minecraft:brewing_stand") && (s = packetWrapper.get(Types.SHORT, 0).shortValue()) > 3) {
                        packetWrapper.set(Types.SHORT, 0, (short)(s + 1));
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CONTAINER_SET_DATA, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            short s2 = packetWrapper.read(Types.SHORT);
            short s3 = packetWrapper.read(Types.SHORT);
            WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
            String string = windowTracker.get(s);
            if (string != null && string.equalsIgnoreCase("minecraft:enchanting_table")) {
                if (s2 >= 4 && s2 <= 6) {
                    windowTracker.putEnchantmentProperty(s2, s3);
                    packetWrapper.cancel();
                } else if (s2 >= 7 && s2 <= 9) {
                    s2 = (short)(s2 - 3);
                    short s4 = windowTracker.getEnchantmentValue(s2);
                    s3 = (short)(s4 | s3 << 8);
                }
            }
            packetWrapper.write(Types.SHORT, s2);
            packetWrapper.write(Types.SHORT, s3);
        });
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new LegacyEnchantmentRewriter(this.nbtTagName());
        this.enchantmentRewriter.registerEnchantment(9, "\u00a77Frost Walker");
        this.enchantmentRewriter.registerEnchantment(70, "\u00a77Mending");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        Object object;
        Tag tag;
        boolean bl;
        String string;
        Tag tag2;
        CompoundTag compoundTag2;
        if (item == null) {
            return null;
        }
        int n = item.identifier();
        super.handleItemToClient(userConnection, item);
        CompoundTag compoundTag3 = item.tag();
        this.enchantmentRewriter.handleToClient(item);
        CompoundTag compoundTag4 = compoundTag2 = compoundTag3 == null ? null : compoundTag3.getCompoundTag("display");
        if (item.data() != 0) {
            ByteTag byteTag;
            ByteTag byteTag2 = byteTag = compoundTag3 == null ? null : compoundTag3.getByteTag("Unbreakable");
            if (byteTag != null && byteTag.asByte() != 0) {
                compoundTag3.put(this.nbtTagName() + "|Unbreakable", new ByteTag(byteTag.asByte()));
                compoundTag3.remove("Unbreakable");
                if (compoundTag2 == null) {
                    compoundTag2 = new CompoundTag();
                    compoundTag3.put("display", compoundTag2);
                    compoundTag3.put(this.nbtTagName() + "|noDisplay", new ByteTag(true));
                }
                if ((tag2 = compoundTag2.getListTag("Lore", StringTag.class)) == null) {
                    tag2 = new ListTag<StringTag>(StringTag.class);
                    compoundTag2.put("Lore", tag2);
                }
                ((ListTag)tag2).add(new StringTag("\u00a79Unbreakable"));
            }
        }
        if (item.identifier() == 383 && item.data() == 0) {
            StringTag stringTag;
            int n2 = 0;
            Tag tag3 = tag2 = compoundTag3 == null ? null : compoundTag3.getCompoundTag("EntityTag");
            if (tag2 != null && (stringTag = ((CompoundTag)tag2).getStringTag("id")) != null) {
                string = stringTag.getValue();
                if (EntityIds1_8.ENTITY_NAME_TO_ID.containsKey(string)) {
                    n2 = EntityIds1_8.ENTITY_NAME_TO_ID.get(string);
                } else if (compoundTag2 == null) {
                    compoundTag2 = new CompoundTag();
                    compoundTag3.put("display", compoundTag2);
                    compoundTag3.put(this.nbtTagName() + "|noDisplay", new ByteTag(true));
                    compoundTag2.put("Name", new StringTag("\u00a7rSpawn " + string));
                }
            }
            item.setData((short)n2);
        }
        boolean bl2 = item.identifier() == 373;
        boolean bl3 = item.identifier() == 438;
        boolean bl4 = bl = item.identifier() == 441;
        if (bl2 || bl3 || bl) {
            int n3 = 0;
            Tag tag4 = tag = compoundTag3 == null ? null : compoundTag3.getStringTag("Potion");
            if (tag != null) {
                object = Key.stripMinecraftNamespace(((StringTag)tag).getValue());
                if (PotionIdMappings1_8.POTION_NAME_TO_ID.containsKey(object)) {
                    n3 = PotionIdMappings1_8.POTION_NAME_TO_ID.get(object);
                }
                if (bl3) {
                    object = (String)object + "_splash";
                } else if (bl) {
                    object = (String)object + "_lingering";
                }
                if ((compoundTag2 == null || !compoundTag2.contains("Name")) && PotionIdMappings1_8.POTION_NAME_INDEX.containsKey(object)) {
                    compoundTag2 = new CompoundTag();
                    compoundTag3.put("display", compoundTag2);
                    compoundTag3.put(this.nbtTagName() + "|noDisplay", new ByteTag(true));
                    compoundTag2.put("Name", new StringTag(PotionIdMappings1_8.POTION_NAME_INDEX.get(object)));
                }
            }
            if (bl3 || bl) {
                item.setIdentifier(373);
                n3 += 8192;
            }
            item.setData((short)n3);
        }
        String string2 = string = compoundTag3 == null ? null : compoundTag3.getListTag("AttributeModifiers", CompoundTag.class);
        if (string != null) {
            compoundTag3.put(this.nbtTagName() + "|AttributeModifiers", ((ListTag)((Object)string)).copy());
            ((ListTag)((Object)string)).getValue().removeIf(compoundTag -> {
                StringTag stringTag = compoundTag.getStringTag("AttributeName");
                return stringTag != null && !this.VALID_ATTRIBUTES.contains(stringTag.getValue());
            });
        }
        if (n == 443) {
            if (compoundTag3 == null) {
                compoundTag3 = new CompoundTag();
                item.setTag(compoundTag3);
            }
            if ((tag = compoundTag3.getCompoundTag("display")) == null) {
                tag = new CompoundTag();
                compoundTag3.put("display", tag);
            }
            ((CompoundTag)tag).put("color", new IntTag(0x737373));
            compoundTag3.put(this.nbtTagName() + "|noDisplay", new ByteTag(true));
        }
        if (n == 442) {
            tag = compoundTag3 == null ? null : compoundTag3.getCompoundTag("BlockEntityTag");
            Object object2 = object = tag == null ? null : ((CompoundTag)tag).getListTag("Patterns", CompoundTag.class);
            if (object == null || ((ListTag)object).isEmpty()) {
                item.setData((short)3);
                if (compoundTag3 == null) {
                    compoundTag3 = new CompoundTag();
                    item.setTag(compoundTag3);
                }
                compoundTag3.put(this.nbtTagName() + "|noData", new ByteTag(true));
            }
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        Tag tag;
        Tag tag2;
        Object object;
        if (item == null) {
            return null;
        }
        super.handleItemToServer(userConnection, item);
        CompoundTag compoundTag = item.tag();
        this.enchantmentRewriter.handleToServer(item);
        if (item.identifier() == 383 && item.data() != 0) {
            if ((compoundTag == null || !compoundTag.contains("EntityTag")) && EntityIds1_8.ENTITY_ID_TO_NAME.containsKey(item.data())) {
                if (compoundTag == null) {
                    compoundTag = new CompoundTag();
                    item.setTag(compoundTag);
                }
                object = new CompoundTag();
                ((CompoundTag)object).put("id", new StringTag(EntityIds1_8.ENTITY_ID_TO_NAME.get(item.data())));
                compoundTag.put("EntityTag", (Tag)object);
            }
            item.setData((short)0);
        }
        if (!(item.identifier() != 373 || compoundTag != null && compoundTag.contains("Potion"))) {
            if (item.data() >= 16384) {
                item.setIdentifier(438);
                item.setData((short)(item.data() - 8192));
            }
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
                object = item.data() == 8192 ? "water" : PotionIdMappings1_9.potionNameFromDamage(item.data());
                compoundTag.put("Potion", new StringTag("minecraft:" + (String)object));
            }
            item.setData((short)0);
        }
        if (compoundTag == null) {
            return item;
        }
        if (compoundTag.remove(this.nbtTagName() + "|noData") != null) {
            item.setData((short)0);
        }
        if ((object = compoundTag.remove(this.nbtTagName() + "|noDisplay")) != null) {
            compoundTag.remove("display");
            if (compoundTag.isEmpty()) {
                item.setTag(null);
            }
        }
        if ((tag2 = compoundTag.remove(this.nbtTagName() + "|Unbreakable")) != null) {
            compoundTag.put("Unbreakable", tag2);
        }
        if ((tag = compoundTag.remove(this.nbtTagName() + "|AttributeModifiers")) != null) {
            compoundTag.put("AttributeModifiers", tag);
        }
        return item;
    }
}

