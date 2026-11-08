/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.Protocol1_17To1_16_4;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.api.type.types.version.Types1_17;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.TagUtil;
import java.util.Iterator;

public class EntityPacketRewriter1_17
extends EntityRewriter<ClientboundPackets1_17, Protocol1_17To1_16_4> {
    private boolean warned = ViaBackwards.getConfig().bedrockAtY0() || ViaBackwards.getConfig().suppressEmulationWarnings();

    public EntityPacketRewriter1_17(Protocol1_17To1_16_4 protocol1_17To1_16_4) {
        super(protocol1_17To1_16_4);
    }

    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_17.ADD_EXPERIENCE_ORB, EntityTypes1_17.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_17.ADD_PAINTING, EntityTypes1_17.PAINTING);
        this.registerTracker(ClientboundPackets1_17.ADD_PLAYER, EntityTypes1_17.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_17.SET_ENTITY_DATA, Types1_17.ENTITY_DATA_LIST, Types1_16.ENTITY_DATA_LIST);
        ((Protocol1_17To1_16_4)this.protocol).appendClientbound(ClientboundPackets1_17.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 1);
            if (n != EntityTypes1_16_2.ITEM_FRAME.getId()) {
                return;
            }
            int n2 = packetWrapper.get(Types.INT, 0);
            float f = 0.0f;
            float f2 = 0.0f;
            switch (Math.abs(n2 % 6)) {
                case 0: {
                    f = 90.0f;
                    break;
                }
                case 1: {
                    f = -90.0f;
                    break;
                }
                case 2: {
                    f2 = 180.0f;
                    break;
                }
                case 4: {
                    f2 = 90.0f;
                    break;
                }
                case 5: {
                    f2 = 270.0f;
                }
            }
            packetWrapper.set(Types.BYTE, 0, (byte)(f * 256.0f / 360.0f));
            packetWrapper.set(Types.BYTE, 1, (byte)(f2 * 256.0f / 360.0f));
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.REMOVE_ENTITY, ClientboundPackets1_16_2.REMOVE_ENTITIES, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            this.tracker(packetWrapper.user()).removeEntity(n);
            int[] nArray = new int[]{n};
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, nArray);
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 1);
                    if (by == -1) {
                        packetWrapper.set(Types.BYTE, 1, (byte)0);
                    }
                });
                this.handler(EntityPacketRewriter1_17.this.playerTrackerHandler());
                this.handler(EntityPacketRewriter1_17.this.worldDataTrackerHandler(1));
                this.handler(packetWrapper -> {
                    Tag tag;
                    CompoundTag compoundTag;
                    CompoundTag compoundTag2 = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag2, "worldgen/biome");
                    for (CompoundTag object2 : listTag) {
                        compoundTag = object2.getCompoundTag("element");
                        tag = compoundTag.getStringTag("category");
                        if (!tag.getValue().equalsIgnoreCase("underground")) continue;
                        tag.setValue("none");
                    }
                    ListTag<CompoundTag> listTag2 = TagUtil.getRegistryEntries(compoundTag2, "dimension_type");
                    Iterator iterator2 = listTag2.iterator();
                    while (iterator2.hasNext()) {
                        compoundTag = (CompoundTag)iterator2.next();
                        tag = compoundTag.getCompoundTag("element");
                        EntityPacketRewriter1_17.this.reduceExtendedHeight((CompoundTag)tag, false);
                    }
                    EntityPacketRewriter1_17.this.reduceExtendedHeight(packetWrapper.get(Types.NAMED_COMPOUND_TAG, 1), true);
                });
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_17.this.worldDataTrackerHandler(0));
                this.handler(packetWrapper -> EntityPacketRewriter1_17.this.reduceExtendedHeight(packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0), true));
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.INT, packetWrapper.read(Types.VAR_INT)));
            }
        });
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.PLAYER_COMBAT_ENTER, ClientboundPackets1_16_2.PLAYER_COMBAT, 0);
        ((Protocol1_17To1_16_4)this.protocol).mergePacket(ClientboundPackets1_17.PLAYER_COMBAT_END, ClientboundPackets1_16_2.PLAYER_COMBAT, 1);
        ((Protocol1_17To1_16_4)this.protocol).registerClientbound(ClientboundPackets1_17.PLAYER_COMBAT_KILL, ClientboundPackets1_16_2.PLAYER_COMBAT, packetWrapper -> {
            packetWrapper.write(Types.VAR_INT, 2);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.INT);
            ((ComponentRewriterBase)((Protocol1_17To1_16_4)this.protocol).getComponentRewriter()).processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            entityData.setDataType(Types1_16.ENTITY_DATA_TYPES.byId(entityData.dataType().typeId()));
            EntityDataType entityDataType = entityData.dataType();
            if (entityDataType == Types1_16.ENTITY_DATA_TYPES.particleType) {
                Particle particle = (Particle)entityData.getValue();
                if (particle.id() == 16) {
                    particle.getArguments().subList(4, 7).clear();
                } else if (particle.id() == 37) {
                    particle.setId(0);
                    particle.getArguments().clear();
                    return;
                }
                ((ParticleRewriter)((Protocol1_17To1_16_4)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), particle);
            } else if (entityDataType == Types1_16.ENTITY_DATA_TYPES.poseType) {
                int n = (Integer)entityData.value();
                if (n == 6) {
                    entityData.setValue(1);
                } else if (n > 6) {
                    entityData.setValue(n - 1);
                }
            }
        });
        this.registerEntityDataTypeHandler(Types1_16.ENTITY_DATA_TYPES.itemType, null, Types1_16.ENTITY_DATA_TYPES.optionalBlockStateType, null, Types1_16.ENTITY_DATA_TYPES.componentType, Types1_16.ENTITY_DATA_TYPES.optionalComponentType);
        this.filter().type(EntityTypes1_17.AXOLOTL).cancel(17);
        this.filter().type(EntityTypes1_17.AXOLOTL).cancel(18);
        this.filter().type(EntityTypes1_17.AXOLOTL).cancel(19);
        this.filter().type(EntityTypes1_17.GLOW_SQUID).cancel(16);
        this.filter().type(EntityTypes1_17.GOAT).cancel(17);
        this.filter().type(EntityTypes1_17.SHULKER).addIndex(17);
        this.registerBlockStateHandler(EntityTypes1_17.ABSTRACT_MINECART, 11);
        this.filter().removeIndex(7);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_17.AXOLOTL, EntityTypes1_17.TROPICAL_FISH).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_17.GOAT, EntityTypes1_17.SHEEP).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_17.GLOW_SQUID, EntityTypes1_17.SQUID).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_17.GLOW_ITEM_FRAME, EntityTypes1_17.ITEM_FRAME);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_17.getTypeFromId(n);
    }

    private void reduceExtendedHeight(CompoundTag compoundTag, boolean bl) {
        NumberTag numberTag = compoundTag.getNumberTag("min_y");
        NumberTag numberTag2 = compoundTag.getNumberTag("height");
        NumberTag numberTag3 = compoundTag.getNumberTag("logical_height");
        if (numberTag.asInt() != 0 || numberTag2.asInt() > 256 || numberTag3.asInt() > 256) {
            if (bl && !this.warned) {
                ((Protocol1_17To1_16_4)this.protocol).getLogger().warning("Increased world height is NOT SUPPORTED for 1.16 players and below. They will see a void below y 0 and above 256. You can enable the `bedrock-at-y-0` config option to replace the air with a bedrock layer.");
                this.warned = true;
            }
            compoundTag.putInt("height", Math.min(256, numberTag2.asInt()));
            compoundTag.putInt("logical_height", Math.min(256, numberTag3.asInt()));
        }
    }
}

