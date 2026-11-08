/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.PlayerAttributesStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.WolfDataMaskStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.WorldNameTracker;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.util.Key;
import java.util.UUID;

public class EntityPacketRewriter1_16
extends EntityRewriter<ClientboundPackets1_16, Protocol1_16To1_15_2> {
    private final ValueTransformer<String, Integer> dimensionTransformer = new ValueTransformer<String, Integer>(Types.STRING, (Type)Types.INT){

        @Override
        public Integer transform(PacketWrapper packetWrapper, String string) {
            return switch (string = Key.namespaced(string)) {
                case "minecraft:the_nether" -> -1;
                case "minecraft:the_end" -> 1;
                default -> 0;
            };
        }
    };

    public EntityPacketRewriter1_16(Protocol1_16To1_15_2 protocol1_16To1_15_2) {
        super(protocol1_16To1_15_2);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_16To1_15_2)this.protocol).replaceClientbound(ClientboundPackets1_16.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    EntityType entityType = EntityPacketRewriter1_16.this.typeFromId(packetWrapper.get(Types.VAR_INT, 1));
                    if (entityType == EntityTypes1_16.LIGHTNING_BOLT) {
                        packetWrapper.cancel();
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_15.ADD_GLOBAL_ENTITY);
                        packetWrapper2.write(Types.VAR_INT, packetWrapper.get(Types.VAR_INT, 0));
                        packetWrapper2.write(Types.BYTE, (byte)1);
                        packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 0));
                        packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 1));
                        packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 2));
                        packetWrapper2.send(Protocol1_16To1_15_2.class);
                    }
                });
                this.handler(EntityPacketRewriter1_16.this.getSpawnTrackerWithDataHandler());
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(EntityPacketRewriter1_16.this.dimensionTransformer);
                this.handler(packetWrapper -> {
                    Object object;
                    WorldNameTracker worldNameTracker = packetWrapper.user().get(WorldNameTracker.class);
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.passthrough(Types.LONG);
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    packetWrapper.read(Types.BYTE);
                    Object t = packetWrapper.user().getClientWorld(Protocol1_16To1_15_2.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    if (((ClientWorld)t).getEnvironment() != null && n == ((ClientWorld)t).getEnvironment().id() && (packetWrapper.user().isClientSide() || Via.getPlatform().isProxy() || packetWrapper.user().getProtocolInfo().protocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_12_2) || !string.equals(worldNameTracker.getWorldName()))) {
                        object = packetWrapper.create(ClientboundPackets1_15.RESPAWN);
                        object.write(Types.INT, n == 0 ? -1 : 0);
                        object.write(Types.LONG, 0L);
                        object.write(Types.UNSIGNED_BYTE, (short)0);
                        object.write(Types.STRING, "default");
                        object.send(Protocol1_16To1_15_2.class);
                    }
                    if (((ClientWorld)t).setEnvironment(n)) {
                        EntityPacketRewriter1_16.this.tracker(packetWrapper.user()).clearEntities();
                    }
                    packetWrapper.write(Types.STRING, "default");
                    packetWrapper.read(Types.BOOLEAN);
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        packetWrapper.set(Types.STRING, 0, "flat");
                    }
                    object = packetWrapper.user().get(PlayerAttributesStorage.class);
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    if (bl) {
                        packetWrapper.send(Protocol1_16To1_15_2.class);
                        packetWrapper.cancel();
                        ((PlayerAttributesStorage)object).sendAttributes(packetWrapper.user(), EntityPacketRewriter1_16.this.tracker(packetWrapper.user()).clientEntityId());
                    } else {
                        ((PlayerAttributesStorage)object).clearAttributes();
                    }
                    worldNameTracker.setWorldName(string);
                });
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.read(Types.BYTE);
                this.read(Types.STRING_ARRAY);
                this.read(Types.NAMED_COMPOUND_TAG);
                this.map(EntityPacketRewriter1_16.this.dimensionTransformer);
                this.handler(packetWrapper -> {
                    WorldNameTracker worldNameTracker = packetWrapper.user().get(WorldNameTracker.class);
                    worldNameTracker.setWorldName(packetWrapper.read(Types.STRING));
                });
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_16To1_15_2.class);
                    ((ClientWorld)t).setEnvironment(packetWrapper.get(Types.INT, 1));
                    packetWrapper.write(Types.STRING, "default");
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.read(Types.BOOLEAN);
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        packetWrapper.set(Types.STRING, 0, "flat");
                    }
                });
                this.handler(EntityPacketRewriter1_16.this.playerTrackerHandler());
            }
        });
        this.registerTracker(ClientboundPackets1_16.ADD_EXPERIENCE_ORB, EntityTypes1_16.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_16.ADD_PAINTING, EntityTypes1_16.PAINTING);
        this.registerTracker(ClientboundPackets1_16.ADD_PLAYER, EntityTypes1_16.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_16.SET_ENTITY_DATA, Types1_16.ENTITY_DATA_LIST, Types1_14.ENTITY_DATA_LIST);
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.UPDATE_ATTRIBUTES, packetWrapper -> {
            PlayerAttributesStorage playerAttributesStorage = packetWrapper.user().get(PlayerAttributesStorage.class);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.INT);
            for (int i = 0; i < n2; ++i) {
                String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
                String string2 = ((Protocol1_16To1_15_2)this.protocol).getMappingData().mappedAttributeIdentifier(string);
                packetWrapper.write(Types.STRING, string2);
                double d = packetWrapper.passthrough(Types.DOUBLE);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                PlayerAttributesStorage.AttributeModifier[] attributeModifierArray = new PlayerAttributesStorage.AttributeModifier[n3];
                for (int j = 0; j < n3; ++j) {
                    UUID uUID = packetWrapper.passthrough(Types.UUID);
                    double d2 = packetWrapper.passthrough(Types.DOUBLE);
                    byte by = packetWrapper.passthrough(Types.BYTE);
                    attributeModifierArray[j] = new PlayerAttributesStorage.AttributeModifier(uUID, d2, by);
                }
                if (n != this.tracker(packetWrapper.user()).clientEntityId()) continue;
                playerAttributesStorage.addAttribute(string2, new PlayerAttributesStorage.Attribute(d, attributeModifierArray));
            }
        });
        ((Protocol1_16To1_15_2)this.protocol).registerClientbound(ClientboundPackets1_16.PLAYER_INFO, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (n == 0) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    ((Protocol1_16To1_15_2)this.protocol).getComponentRewriter().processText(packetWrapper.user(), packetWrapper.passthrough(Types.OPTIONAL_COMPONENT));
                    continue;
                }
                if (n == 1) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n == 2) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n != 3) continue;
                ((Protocol1_16To1_15_2)this.protocol).getComponentRewriter().processText(packetWrapper.user(), packetWrapper.passthrough(Types.OPTIONAL_COMPONENT));
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            JsonElement jsonElement;
            entityData.setDataType(Types1_14.ENTITY_DATA_TYPES.byId(entityData.dataType().typeId()));
            EntityDataType entityDataType = entityData.dataType();
            if (entityDataType == Types1_14.ENTITY_DATA_TYPES.itemType) {
                entityData.setValue(((Protocol1_16To1_15_2)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.getValue()));
            } else if (entityDataType == Types1_14.ENTITY_DATA_TYPES.optionalBlockStateType) {
                entityData.setValue(((Protocol1_16To1_15_2)this.protocol).getMappingData().getNewBlockStateId((Integer)entityData.getValue()));
            } else if (entityDataType == Types1_14.ENTITY_DATA_TYPES.particleType) {
                ((ParticleRewriter)((Protocol1_16To1_15_2)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.getValue());
            } else if (entityDataType == Types1_14.ENTITY_DATA_TYPES.optionalComponentType && (jsonElement = (JsonElement)entityData.value()) != null) {
                ((Protocol1_16To1_15_2)this.protocol).getComponentRewriter().processText(entityDataHandlerEvent.user(), jsonElement);
            }
        });
        this.filter().type(EntityTypes1_16.ZOGLIN).cancel(16);
        this.filter().type(EntityTypes1_16.HOGLIN).cancel(15);
        this.filter().type(EntityTypes1_16.PIGLIN).cancel(16);
        this.filter().type(EntityTypes1_16.PIGLIN).cancel(17);
        this.filter().type(EntityTypes1_16.PIGLIN).cancel(18);
        this.filter().type(EntityTypes1_16.STRIDER).index(15).handler((entityDataHandlerEvent, entityData) -> {
            boolean bl = (Boolean)entityData.value();
            entityData.setTypeAndValue(Types1_14.ENTITY_DATA_TYPES.varIntType, bl ? 1 : 3);
        });
        this.filter().type(EntityTypes1_16.STRIDER).cancel(16);
        this.filter().type(EntityTypes1_16.STRIDER).cancel(17);
        this.filter().type(EntityTypes1_16.STRIDER).cancel(18);
        this.filter().type(EntityTypes1_16.FISHING_BOBBER).cancel(8);
        this.filter().type(EntityTypes1_16.ABSTRACT_ARROW).cancel(8);
        this.filter().type(EntityTypes1_16.ABSTRACT_ARROW).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() >= 8) {
                entityDataHandlerEvent.setIndex(entityDataHandlerEvent.index() + 1);
            }
        });
        this.filter().type(EntityTypes1_16.WOLF).index(16).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.value();
            entityDataHandlerEvent.trackedEntity().put(new WolfDataMaskStorage(by));
        });
        this.filter().type(EntityTypes1_16.WOLF).index(20).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            byte by = 0;
            WolfDataMaskStorage wolfDataMaskStorage = entityDataHandlerEvent.trackedEntity().get(WolfDataMaskStorage.class);
            if (wolfDataMaskStorage != null) {
                by = wolfDataMaskStorage.tameableMask();
            }
            byte by2 = (byte)((n = ((Integer)entityData.value()).intValue()) > 0 ? by | 2 : by & 0xFFFFFFFD);
            entityDataHandlerEvent.createExtraData(new EntityData(16, Types1_14.ENTITY_DATA_TYPES.byteType, by2));
            entityDataHandlerEvent.cancel();
        });
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_16.HOGLIN, EntityTypes1_16.COW).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_16.ZOGLIN, EntityTypes1_16.COW).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_16.PIGLIN, EntityTypes1_16.ZOMBIFIED_PIGLIN).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_16.STRIDER, EntityTypes1_16.MAGMA_CUBE).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_16.getTypeFromId(n);
    }
}

