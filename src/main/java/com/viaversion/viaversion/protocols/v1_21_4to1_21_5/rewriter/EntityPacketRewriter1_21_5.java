/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage.MessageIndexStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.concurrent.ThreadLocalRandom;

public class EntityPacketRewriter1_21_5
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_4To1_21_5> {
    private static final int ATTACK_BLOCKED_ENTITY_EVENT = 29;
    private static final int SHIELD_DISABLED_ENTITY_EVENT = 30;
    private static final int SADDLE_ITEM_ID = 800;
    private static final byte SADDLE_EQUIPMENT_SLOT = 7;

    public EntityPacketRewriter1_21_5(Protocol1_21_4To1_21_5 protocol1_21_4To1_21_5) {
        super(protocol1_21_4To1_21_5);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.ADD_EXPERIENCE_ORB, ClientboundPackets1_21_5.ADD_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.UUID, UUIDUtil.randomUUID());
            packetWrapper.write(Types.VAR_INT, EntityTypes1_21_5.EXPERIENCE_ORB.getId());
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.passthroughAndMap(Types.SHORT, Types.VAR_INT);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).appendClientbound(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, packetWrapper -> {
            this.sendEntityVariants(packetWrapper.user(), "minecraft:frog_variant", "frog", true, "temperate", "warm", "cold");
            this.sendEntityVariants(packetWrapper.user(), "minecraft:cat_variant", "cat", false, "tabby", "black", "red", "siamese", "british_shorthair", "calico", "persian", "ragdoll", "white", "jellie", "all_black");
            this.sendEntityVariants(packetWrapper.user(), "minecraft:pig_variant", "pig", true, "temperate");
            this.sendEntityVariants(packetWrapper.user(), "minecraft:cow_variant", "cow", true, "temperate");
            this.sendEntityVariants(packetWrapper.user(), "minecraft:chicken_variant", "chicken", true, "temperate");
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, packetWrapper.user());
            packetWrapper2.write(Types.STRING, "minecraft:wolf_sound_variant");
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{this.wolfSoundVariant()});
            packetWrapper2.send(Protocol1_21_4To1_21_5.class);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).appendClientbound(ClientboundPackets1_21_2.LOGIN, packetWrapper -> packetWrapper.user().get(MessageIndexStorage.class).setIndex(0));
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.read(Types.BYTE);
            if (n == 8) {
                by = (byte)(by | 8);
            }
            packetWrapper.write(Types.BYTE, by);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).replaceClientbound(ClientboundPackets1_21_2.SET_PLAYER_TEAM, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                String string = packetWrapper.read(Types.STRING);
                String string2 = packetWrapper.read(Types.STRING);
                packetWrapper.write(Types.VAR_INT, this.visibilityId(string));
                packetWrapper.write(Types.VAR_INT, this.collisionId(string2));
                packetWrapper.passthrough(Types.VAR_INT);
                ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
                ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
            }
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.ENTITY_EVENT, packetWrapper -> {
            int n = packetWrapper.read(Types.INT);
            byte by = packetWrapper.read(Types.BYTE);
            if (by == 29) {
                this.playShieldSound(packetWrapper, n, 1273, 1.0f);
                return;
            }
            if (by == 30) {
                this.playShieldSound(packetWrapper, n, 1274, 0.8f);
                return;
            }
            packetWrapper.write(Types.INT, n);
            packetWrapper.write(Types.BYTE, by);
        });
    }

    private void playShieldSound(PacketWrapper packetWrapper, int n, int n2, float f) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        packetWrapper.setPacketType(ClientboundPackets1_21_5.SOUND_ENTITY);
        packetWrapper.write(Types.SOUND_EVENT, Holder.of(n2));
        packetWrapper.write(Types.VAR_INT, 7);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.FLOAT, Float.valueOf(f));
        packetWrapper.write(Types.FLOAT, Float.valueOf(0.8f + threadLocalRandom.nextFloat() * 0.4f));
        packetWrapper.write(Types.LONG, threadLocalRandom.nextLong());
    }

    private RegistryEntry wolfSoundVariant() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("ambient_sound", "entity.wolf.ambient");
        compoundTag.putString("death_sound", "entity.wolf.death");
        compoundTag.putString("growl_sound", "entity.wolf.growl");
        compoundTag.putString("hurt_sound", "entity.wolf.hurt");
        compoundTag.putString("pant_sound", "entity.wolf.pant");
        compoundTag.putString("whine_sound", "entity.wolf.whine");
        return new RegistryEntry("classic", compoundTag);
    }

    private int collisionId(String string) {
        return switch (string) {
            case "always" -> 0;
            case "never" -> 1;
            case "pushOtherTeams" -> 2;
            case "pushOwnTeam" -> 3;
            default -> 0;
        };
    }

    private int visibilityId(String string) {
        return switch (string) {
            case "always" -> 0;
            case "never" -> 1;
            case "hideForOtherTeams" -> 2;
            case "hideForOwnTeam" -> 3;
            default -> 0;
        };
    }

    private void sendEntityVariants(UserConnection userConnection, String string, String string2, boolean bl, String ... stringArray) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, userConnection);
        packetWrapper.write(Types.STRING, string);
        RegistryEntry[] registryEntryArray = new RegistryEntry[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            CompoundTag compoundTag = new CompoundTag();
            String string3 = "entity/" + string2 + "/" + stringArray[i];
            if (bl) {
                string3 = string3 + "_" + string2;
            }
            compoundTag.putString("asset_id", string3);
            registryEntryArray[i] = new RegistryEntry(stringArray[i], compoundTag);
        }
        packetWrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
        packetWrapper.send(Protocol1_21_4To1_21_5.class);
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().added(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).cowVariantType).added(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).wolfSoundVariantType).added(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).pigVariantType).added(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).chickenVariantType).skip(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).wolfVariantType).register();
        this.filter().dataType(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).wolfVariantType).handler((entityDataHandlerEvent, entityData) -> {
            Holder holder = (Holder)entityData.value();
            entityData.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).wolfVariantType, holder.hasId() ? holder.id() : 0);
        });
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).itemType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).blockStateType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).particleType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).particlesType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).componentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalComponentType);
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).index(11).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.getValue();
            int n2 = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData().getNewBlockStateId(n);
            if (n2 == 0) {
                entityDataHandlerEvent.cancel();
                return;
            }
            entityData.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).optionalBlockStateType, n2);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).removeIndex(13);
        this.filter().type(EntityTypes1_21_5.MOOSHROOM).index(17).handler((entityDataHandlerEvent, entityData) -> {
            String string = (String)entityData.value();
            int n = string.equals("red") ? 0 : 1;
            entityData.setTypeAndValue(((EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes).varIntType, n);
        });
        this.filter().type(EntityTypes1_21_5.PIG).index(17).handler((entityDataHandlerEvent, entityData) -> {
            boolean bl = (Boolean)entityData.value();
            this.sendSaddleEquipment(entityDataHandlerEvent, bl);
        });
        this.filter().type(EntityTypes1_21_5.PIG).removeIndex(17);
        this.filter().type(EntityTypes1_21_5.STRIDER).index(19).handler((entityDataHandlerEvent, entityData) -> {
            entityDataHandlerEvent.cancel();
            boolean bl = (Boolean)entityData.value();
            this.sendSaddleEquipment(entityDataHandlerEvent, bl);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_HORSE).index(17).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.value();
            this.sendSaddleEquipment(entityDataHandlerEvent, (by & 4) != 0);
        });
        this.filter().type(EntityTypes1_21_5.DOLPHIN).removeIndex(17);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(22);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(21);
        this.filter().type(EntityTypes1_21_5.TURTLE).cancel(20);
        this.filter().type(EntityTypes1_21_5.TURTLE).removeIndex(17);
    }

    private void sendSaddleEquipment(EntityDataHandlerEvent entityDataHandlerEvent, boolean bl) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_5.SET_EQUIPMENT, entityDataHandlerEvent.user());
        packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
        packetWrapper.write(Types.BYTE, (byte)7);
        packetWrapper.write(VersionedTypes.V1_21_5.item, bl ? new StructuredItem(800, 1) : StructuredItem.empty());
        packetWrapper.send(Protocol1_21_4To1_21_5.class);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_5.getTypeFromId(n);
    }
}

