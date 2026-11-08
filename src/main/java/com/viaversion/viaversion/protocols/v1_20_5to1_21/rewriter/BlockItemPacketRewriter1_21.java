/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.AttributeModifierMappings1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.PlayerPositionStorage;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import java.util.Arrays;
import java.util.List;

public class BlockItemPacketRewriter1_21
extends StructuredItemRewriter<ClientboundPacket1_20_5, ServerboundPacket1_20_5, Protocol1_20_5To1_21> {
    private static final List<String> DISCS = List.of("11", "13", "5", "blocks", "cat", "chirp", "far", "mall", "mellohi", "otherside", "pigstep", "relic", "stal", "strad", "wait", "ward");
    private static final int HELMET_SLOT = 5;
    private static final int CHESTPLATE_SLOT = 6;
    private static final int LEGGINGS_SLOT = 7;
    private static final int BOOTS_SLOT = 8;
    private static final int AQUA_AFFINITY_ID = 6;
    private static final int DEPTH_STRIDER_ID = 8;
    private static final int SWIFT_SNEAK_ID = 12;

    public BlockItemPacketRewriter1_21(Protocol1_20_5To1_21 protocol1_20_5To1_21) {
        super(protocol1_20_5To1_21);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_5To1_21)this.protocol).replaceClientbound(ClientboundPackets1_20_5.CONTAINER_SET_SLOT, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            short s = packetWrapper.passthrough(Types.SHORT);
            Item item = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(this.itemType()));
            packetWrapper.write(this.mappedItemType(), item);
            if (by != 0 || s > 8 || s < 5 || s == 6) {
                return;
            }
            EfficiencyAttributeStorage efficiencyAttributeStorage = packetWrapper.user().get(EfficiencyAttributeStorage.class);
            Enchantments enchantments = item.dataContainer().get(StructuredDataKey.ENCHANTMENTS1_20_5);
            EfficiencyAttributeStorage.ActiveEnchants activeEnchants = efficiencyAttributeStorage.activeEnchants();
            activeEnchants = switch (s) {
                case 5 -> activeEnchants.aquaAffinity(enchantments == null ? 0 : enchantments.getLevel(6));
                case 7 -> activeEnchants.swiftSneak(enchantments == null ? 0 : enchantments.getLevel(12));
                case 8 -> activeEnchants.depthStrider(enchantments == null ? 0 : enchantments.getLevel(8));
                default -> activeEnchants;
            };
            efficiencyAttributeStorage.setEnchants(-1, packetWrapper.user(), activeEnchants);
        });
        ((Protocol1_20_5To1_21)this.protocol).registerClientbound(ClientboundPackets1_20_5.HORSE_SCREEN_OPEN, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, Math.max(0, (n - 1) / 3));
        });
        ((Protocol1_20_5To1_21)this.protocol).replaceClientbound(ClientboundPackets1_20_5.LEVEL_EVENT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n2 = packetWrapper.read(Types.INT);
            if (n == 1010) {
                int n3 = this.itemToJubeboxSong(n2);
                if (n3 == -1) {
                    packetWrapper.cancel();
                    return;
                }
                packetWrapper.write(Types.INT, n3);
            } else if (n == 2001) {
                packetWrapper.write(Types.INT, ((Protocol1_20_5To1_21)this.protocol).getMappingData().getNewBlockStateId(n2));
            } else {
                packetWrapper.write(Types.INT, n2);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.USE_ITEM, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            if (!Via.getConfig().fix1_21PlacementRotation()) {
                return;
            }
            PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT);
            packetWrapper2.write(Types.DOUBLE, playerPositionStorage.x());
            packetWrapper2.write(Types.DOUBLE, playerPositionStorage.y());
            packetWrapper2.write(Types.DOUBLE, playerPositionStorage.z());
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f2));
            packetWrapper2.write(Types.BOOLEAN, playerPositionStorage.onGround());
            packetWrapper2.sendToServer(Protocol1_20_5To1_21.class);
            packetWrapper.sendToServer(Protocol1_20_5To1_21.class);
            packetWrapper.cancel();
        });
        new RecipeRewriter1_20_3<ClientboundPackets1_20_5>(this.protocol).register1_20_5(ClientboundPackets1_20_5.UPDATE_RECIPES);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        super.handleItemToClient(userConnection, item);
        BlockItemPacketRewriter1_21.updateItemData(item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        if (structuredDataContainer.has(StructuredDataKey.RARITY)) {
            return item;
        }
        if (item.identifier() == 1188 || item.identifier() == 1200) {
            structuredDataContainer.set(StructuredDataKey.RARITY, 0);
            this.saveTag(this.createCustomTag(item), new ByteTag(true), "rarity");
        }
        return item;
    }

    public static void updateItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.FOOD1_20_5, StructuredDataKey.FOOD1_21);
        structuredDataContainer.replace(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, attributeModifiers1_20_5 -> {
            AttributeModifiers1_21.AttributeModifier[] attributeModifierArray = (AttributeModifiers1_21.AttributeModifier[])Arrays.stream(attributeModifiers1_20_5.modifiers()).map(attributeModifier -> {
                AttributeModifiers1_20_5.ModifierData modifierData = attributeModifier.modifier();
                AttributeModifiers1_21.ModifierData modifierData2 = new AttributeModifiers1_21.ModifierData(Protocol1_20_5To1_21.mapAttributeUUID(modifierData.uuid(), modifierData.name()), modifierData.amount(), modifierData.operation());
                return new AttributeModifiers1_21.AttributeModifier(attributeModifier.attribute(), modifierData2, attributeModifier.slotType());
            }).toArray(AttributeModifiers1_21.AttributeModifier[]::new);
            return new AttributeModifiers1_21(attributeModifierArray, attributeModifiers1_20_5.showInTooltip());
        });
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        super.handleItemToServer(userConnection, item);
        BlockItemPacketRewriter1_21.downgradeItemData(item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null) {
            return item;
        }
        if (compoundTag.remove(this.nbtTagName("rarity")) != null) {
            structuredDataContainer.remove(StructuredDataKey.RARITY);
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        return item;
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.FOOD1_21, StructuredDataKey.FOOD1_20_5);
        structuredDataContainer.remove(StructuredDataKey.JUKEBOX_PLAYABLE1_21);
        structuredDataContainer.replace(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, attributeModifiers1_21 -> {
            AttributeModifiers1_20_5.AttributeModifier[] attributeModifierArray = (AttributeModifiers1_20_5.AttributeModifier[])Arrays.stream(attributeModifiers1_21.modifiers()).map(attributeModifier -> {
                AttributeModifiers1_21.ModifierData modifierData = attributeModifier.modifier();
                String string = AttributeModifierMappings1_21.idToName(modifierData.id());
                AttributeModifiers1_20_5.ModifierData modifierData2 = new AttributeModifiers1_20_5.ModifierData(Protocol1_20_5To1_21.mapAttributeId(modifierData.id()), string != null ? string : modifierData.id(), modifierData.amount(), modifierData.operation());
                return new AttributeModifiers1_20_5.AttributeModifier(attributeModifier.attribute(), modifierData2, attributeModifier.slotType());
            }).toArray(AttributeModifiers1_20_5.AttributeModifier[]::new);
            return new AttributeModifiers1_20_5(attributeModifierArray, attributeModifiers1_21.showInTooltip());
        });
    }

    private int itemToJubeboxSong(int n) {
        String string = Protocol1_20_5To1_21.MAPPINGS.getFullItemMappings().identifier(n);
        if (!string.contains("music_disc_")) {
            return -1;
        }
        string = string.substring("minecraft:music_disc_".length());
        return DISCS.indexOf(string);
    }
}

