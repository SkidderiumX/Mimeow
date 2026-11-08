/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.Protocol1_19To1_18_2;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.LastDeathPosition;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;

public class BlockItemPacketRewriter1_19
extends BackwardsItemRewriter<ClientboundPackets1_19, ServerboundPackets1_17, Protocol1_19To1_18_2> {
    private final EnchantmentRewriter enchantmentRewriter = new EnchantmentRewriter(this);

    public BlockItemPacketRewriter1_19(Protocol1_19To1_18_2 protocol1_19To1_18_2) {
        super(protocol1_19To1_18_2, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    protected void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_19>(this.protocol).register(ClientboundPackets1_19.UPDATE_RECIPES);
        ((Protocol1_19To1_18_2)this.protocol).replaceClientbound(ClientboundPackets1_19.MERCHANT_OFFERS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.UNSIGNED_BYTE, (short)n);
                    for (int i = 0; i < n; ++i) {
                        BlockItemPacketRewriter1_19.this.passthroughClientboundItem(packetWrapper);
                        BlockItemPacketRewriter1_19.this.passthroughClientboundItem(packetWrapper);
                        Item item = packetWrapper.read(Types.ITEM1_13_2);
                        if (item != null) {
                            item = BlockItemPacketRewriter1_19.this.handleItemToClient(packetWrapper.user(), item);
                            packetWrapper.write(Types.BOOLEAN, true);
                            packetWrapper.write(Types.ITEM1_13_2, item);
                        } else {
                            packetWrapper.write(Types.BOOLEAN, false);
                        }
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.INT);
                    }
                });
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.BLOCK_CHANGED_ACK, null, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.read(Types.VAR_INT);
                this.handler(PacketWrapper::cancel);
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).replaceClientbound(ClientboundPackets1_19.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    ParticleMappings particleMappings;
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == (particleMappings = ((Protocol1_19To1_18_2)BlockItemPacketRewriter1_19.this.protocol).getMappingData().getParticleMappings()).id("sculk_charge")) {
                        packetWrapper.set(Types.INT, 0, -1);
                        packetWrapper.cancel();
                    } else if (n == particleMappings.id("shriek")) {
                        packetWrapper.set(Types.INT, 0, -1);
                        packetWrapper.cancel();
                    } else if (n == particleMappings.id("vibration")) {
                        packetWrapper.set(Types.INT, 0, -1);
                        packetWrapper.cancel();
                    }
                });
                this.handler(((ParticleRewriter)((Protocol1_19To1_18_2)BlockItemPacketRewriter1_19.this.protocol).getParticleRewriter()).levelParticlesHandler1_13(Types.INT));
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerServerbound(ServerboundPackets1_17.PLAYER_ACTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.UNSIGNED_BYTE);
                this.create(Types.VAR_INT, 0);
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerServerbound(ServerboundPackets1_17.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.VAR_INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BOOLEAN);
                this.create(Types.VAR_INT, 0);
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerServerbound(ServerboundPackets1_17.USE_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.create(Types.VAR_INT, 0);
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerServerbound(ServerboundPackets1_17.SET_BEACON, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            if (n > 0) {
                packetWrapper.write(Types.BOOLEAN, true);
                packetWrapper.write(Types.VAR_INT, n);
            } else {
                packetWrapper.write(Types.BOOLEAN, false);
            }
            int n2 = packetWrapper.read(Types.VAR_INT);
            if (n2 > 0) {
                packetWrapper.write(Types.BOOLEAN, true);
                packetWrapper.write(Types.VAR_INT, n2);
            } else {
                packetWrapper.write(Types.BOOLEAN, false);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter.registerEnchantment("minecraft:swift_sneak", "\u00a77Swift Sneak");
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        int n = item.identifier();
        item = super.handleItemToClient(userConnection, item);
        if (n != 834) {
            return item;
        }
        LastDeathPosition lastDeathPosition = userConnection.get(LastDeathPosition.class);
        if (lastDeathPosition == null) {
            return item;
        }
        GlobalBlockPosition globalBlockPosition = lastDeathPosition.position();
        CompoundTag compoundTag = new CompoundTag();
        item.tag().putBoolean(this.nbtTagName(), true);
        item.tag().put("LodestonePos", compoundTag);
        item.tag().putString("LodestoneDimension", globalBlockPosition.dimension());
        compoundTag.putInt("X", globalBlockPosition.x());
        compoundTag.putInt("Y", globalBlockPosition.y());
        compoundTag.putInt("Z", globalBlockPosition.z());
        this.enchantmentRewriter.handleToClient(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        item = super.handleItemToServer(userConnection, item);
        CompoundTag compoundTag = item.tag();
        if (item.identifier() == 834 && compoundTag != null) {
            if (compoundTag.contains(this.nbtTagName())) {
                compoundTag.remove(this.nbtTagName());
                compoundTag.remove("LodestonePos");
                compoundTag.remove("LodestoneDimension");
            }
            if (compoundTag.isEmpty()) {
                item.setTag(null);
            }
        }
        this.enchantmentRewriter.handleToServer(item);
        return item;
    }
}

