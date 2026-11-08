/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.RecipeRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.data.PotionEffects1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20_2
extends ItemRewriter<ClientboundPackets1_19_4, ServerboundPackets1_20_2, Protocol1_20To1_20_2> {
    public BlockItemPacketRewriter1_20_2(Protocol1_20To1_20_2 protocol1_20To1_20_2) {
        super(protocol1_20To1_20_2, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY, Types.ITEM1_20_2, Types.ITEM1_20_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20To1_20_2)this.protocol).registerServerbound(ServerboundPackets1_20_2.SET_BEACON, packetWrapper -> {
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) + 1);
            }
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) + 1);
            }
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.FORGET_LEVEL_CHUNK, packetWrapper -> {
            int n = packetWrapper.read(Types.INT);
            int n2 = packetWrapper.read(Types.INT);
            packetWrapper.write(Types.CHUNK_POSITION, new ChunkPosition(n, n2));
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.TAG_QUERY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.COMPOUND_TAG, packetWrapper.read(Types.NAMED_COMPOUND_TAG));
        });
        ((Protocol1_20To1_20_2)this.protocol).replaceClientbound(ClientboundPackets1_19_4.BLOCK_ENTITY_DATA, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
            BlockEntityImpl blockEntityImpl = new BlockEntityImpl(BlockEntity.pack(blockPosition.x(), blockPosition.z()), (short)blockPosition.y(), n, compoundTag);
            ((Protocol1_20To1_20_2)this.protocol).getBlockRewriter().handleBlockEntity(packetWrapper.user(), blockEntityImpl);
            packetWrapper.write(Types.TRUSTED_COMPOUND_TAG, blockEntityImpl.tag());
        });
        ((Protocol1_20To1_20_2)this.protocol).replaceClientbound(ClientboundPackets1_19_4.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.write(Types.ITEM1_20_2, this.handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2)));
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.read(Types.STRING_ARRAY);
                n2 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n2; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
        new RecipeRewriter1_19_4<ClientboundPackets1_19_4>(this.protocol){

            @Override
            protected Type<Item> mappedItemType() {
                return BlockItemPacketRewriter1_20_2.this.mappedItemType();
            }

            @Override
            protected Type<Item[]> mappedItemArrayType() {
                return BlockItemPacketRewriter1_20_2.this.mappedItemArrayType();
            }
        }.register(ClientboundPackets1_19_4.UPDATE_RECIPES);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (item.tag() != null) {
            BlockItemPacketRewriter1_20_2.to1_20_2Effects(item);
        }
        return super.handleItemToClient(userConnection, item);
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (item.tag() != null) {
            BlockItemPacketRewriter1_20_2.to1_20_1Effects(item);
        }
        return super.handleItemToServer(userConnection, item);
    }

    public static void to1_20_2Effects(Item item) {
        Tag tag = item.tag().remove("CustomPotionEffects");
        if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            item.tag().put("custom_potion_effects", tag);
            for (Tag tag2 : listTag) {
                String string;
                if (!(tag2 instanceof CompoundTag)) continue;
                CompoundTag compoundTag = (CompoundTag)tag2;
                Tag tag3 = compoundTag.remove("Id");
                if (tag3 instanceof NumberTag && (string = PotionEffects1_20_2.idToKey(((NumberTag)tag3).asInt() - 1)) != null) {
                    compoundTag.put("id", new StringTag(string));
                }
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "Amplifier", "amplifier");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "Duration", "duration");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "Ambient", "ambient");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "ShowParticles", "show_particles");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "ShowIcon", "show_icon");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "HiddenEffect", "hidden_effect");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "FactorCalculationData", "factor_calculation_data");
            }
        }
    }

    public static void to1_20_1Effects(Item item) {
        Tag tag = item.tag().remove("custom_potion_effects");
        if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            item.tag().put("CustomPotionEffects", listTag);
            for (Tag tag2 : listTag) {
                if (!(tag2 instanceof CompoundTag)) continue;
                CompoundTag compoundTag = (CompoundTag)tag2;
                Tag tag3 = compoundTag.remove("id");
                if (tag3 instanceof StringTag) {
                    StringTag stringTag = (StringTag)tag3;
                    int n = PotionEffects1_20_2.keyToId(stringTag.getValue());
                    compoundTag.putInt("Id", n + 1);
                }
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "amplifier", "Amplifier");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "duration", "Duration");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "ambient", "Ambient");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "show_particles", "ShowParticles");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "show_icon", "ShowIcon");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "hidden_effect", "HiddenEffect");
                BlockItemPacketRewriter1_20_2.renameTag(compoundTag, "factor_calculation_data", "FactorCalculationData");
            }
        }
    }

    private static void renameTag(CompoundTag compoundTag, String string, String string2) {
        Tag tag = compoundTag.remove(string);
        if (tag != null) {
            compoundTag.put(string2, tag);
        }
    }
}

