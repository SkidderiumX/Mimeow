/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.Paintings1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.PlayerPositionStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.WolfVariantRegistryMarker;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;

public class EntityPacketRewriter1_21
extends EntityRewriter<ClientboundPacket1_20_5, Protocol1_20_5To1_21> {
    public EntityPacketRewriter1_21(Protocol1_20_5To1_21 protocol1_20_5To1_21) {
        super(protocol1_20_5To1_21);
    }

    @Override
    public void registerPackets() {
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this.protocol);
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("scaling", "when_caused_by_living_non_player");
        compoundTag.putString("message_id", "inFire");
        compoundTag.putFloat("exhaustion", 0.1f);
        registryDataRewriter.addEntries("damage_type", new RegistryEntry("minecraft:campfire", compoundTag));
        ((Protocol1_20_5To1_21)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA, packetWrapper -> {
            String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
            RegistryEntry[] registryEntryArray = packetWrapper.read(Types.REGISTRY_ENTRY_ARRAY);
            registryEntryArray = registryDataRewriter.handle(packetWrapper.user(), string, registryEntryArray);
            packetWrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
            if (string.equals("wolf_variant")) {
                packetWrapper.user().put(new WolfVariantRegistryMarker());
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).appendClientbound(ClientboundConfigurationPackets1_20_5.FINISH_CONFIGURATION, packetWrapper -> {
            RegistryEntry[] registryEntryArray;
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            packetWrapper2.write(Types.STRING, "minecraft:painting_variant");
            RegistryEntry[] registryEntryArray2 = new RegistryEntry[Paintings1_20_5.PAINTINGS.length];
            for (int i = 0; i < Paintings1_20_5.PAINTINGS.length; ++i) {
                registryEntryArray = Paintings1_20_5.PAINTINGS[i];
                CompoundTag compoundTag_r2 = new CompoundTag();
                compoundTag_r2.putInt("width", registryEntryArray.width());
                compoundTag_r2.putInt("height", registryEntryArray.height());
                compoundTag_r2.putString("asset_id", registryEntryArray.assetId());
                registryEntryArray2[i] = new RegistryEntry(registryEntryArray.assetId(), compoundTag_r2);
            }
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray2);
            packetWrapper2.send(Protocol1_20_5To1_21.class);
            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            packetWrapper3.write(Types.STRING, "minecraft:enchantment");
            registryEntryArray = new RegistryEntry[Enchantments1_20_5.ENCHANTMENTS.size()];
            for (int i = 0; i < Enchantments1_20_5.ENCHANTMENTS.size(); ++i) {
                String string = Enchantments1_20_5.idToKey(i);
                CompoundTag compoundTag_r = ((Protocol1_20_5To1_21)this.protocol).getMappingData().enchantment(i);
                registryEntryArray[i] = new RegistryEntry(string, compoundTag_r);
            }
            packetWrapper3.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
            packetWrapper3.send(Protocol1_20_5To1_21.class);
            PacketWrapper packetWrapper4 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            packetWrapper4.write(Types.STRING, "minecraft:jukebox_song");
            packetWrapper4.write(Types.REGISTRY_ENTRY_ARRAY, ((Protocol1_20_5To1_21)this.protocol).getMappingData().jukeboxSongs());
            packetWrapper4.send(Protocol1_20_5To1_21.class);
            if (!packetWrapper.user().has(WolfVariantRegistryMarker.class)) {
                EntityPacketRewriter1_21.createDefaultWolfVariantRegistryDataPacket(packetWrapper).send(Protocol1_20_5To1_21.class);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).appendClientbound(ClientboundPackets1_20_5.LOGIN, packetWrapper -> packetWrapper.user().get(EfficiencyAttributeStorage.class).onLoginSent(packetWrapper.get(Types.INT, 0), packetWrapper.user()));
        ((Protocol1_20_5To1_21)this.protocol).appendClientbound(ClientboundPackets1_20_5.RESPAWN, packetWrapper -> {
            packetWrapper.user().get(EfficiencyAttributeStorage.class).onRespawn(packetWrapper.user());
            packetWrapper.user().put(new PlayerPositionStorage());
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS, packetWrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storePosition(packetWrapper);
                this.storeOnGround(packetWrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, packetWrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.FLOAT);
                this.storeOnGround(packetWrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storePosition(packetWrapper);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.FLOAT);
                this.storeOnGround(packetWrapper);
            }
        });
        ((Protocol1_20_5To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_STATUS_ONLY, packetWrapper -> {
            if (Via.getConfig().fix1_21PlacementRotation()) {
                this.storeOnGround(packetWrapper);
            }
        });
    }

    private static PacketWrapper createDefaultWolfVariantRegistryDataPacket(PacketWrapper packetWrapper) {
        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
        packetWrapper2.write(Types.STRING, "minecraft:wolf_variant");
        packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, EntityPacketRewriter1_21.getDefaultWolfVariantRegistryEntries());
        return packetWrapper2;
    }

    private static RegistryEntry[] getDefaultWolfVariantRegistryEntries() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("wild_texture", "minecraft:entity/wolf/wolf");
        compoundTag.putString("angry_texture", "minecraft:entity/wolf/wolf_angry");
        compoundTag.put("biomes", new ListTag<StringTag>(StringTag.class));
        compoundTag.putString("tame_texture", "minecraft:entity/wolf/wolf_tame");
        return new RegistryEntry[]{new RegistryEntry("minecraft:pale", compoundTag)};
    }

    private void storePosition(PacketWrapper packetWrapper) {
        double d = packetWrapper.passthrough(Types.DOUBLE);
        double d2 = packetWrapper.passthrough(Types.DOUBLE);
        double d3 = packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.user().get(PlayerPositionStorage.class).setPosition(d, d2, d3);
    }

    private void storeOnGround(PacketWrapper packetWrapper) {
        boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
        packetWrapper.user().get(PlayerPositionStorage.class).setOnGround(bl);
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().skip(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType).skip(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).paintingVariantType).register();
        this.filter().dataType(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).paintingVariantType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            entityData.setTypeAndValue(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).paintingVariantType, Holder.of(n));
        });
        this.filter().dataType(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            entityData.setTypeAndValue(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).wolfVariantType, Holder.of(n));
        });
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).itemType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).blockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particleType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particlesType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).componentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_5.getTypeFromId(n);
    }
}

