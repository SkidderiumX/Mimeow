/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_21_4
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_2To1_21_4> {
    public EntityPacketRewriter1_21_4(Protocol1_21_2To1_21_4 protocol1_21_2To1_21_4) {
        super(protocol1_21_2To1_21_4);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_2To1_21_4)this.protocol).getRegistryDataRewriter().addHandler("worldgen/biome", (string, compoundTag) -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("effects");
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("music");
            if (compoundTag3 == null) {
                return;
            }
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            CompoundTag compoundTag4 = new CompoundTag();
            compoundTag4.put("data", compoundTag3);
            compoundTag4.putInt("weight", 1);
            listTag.add(compoundTag4);
            compoundTag2.put("music", listTag);
        });
        ((Protocol1_21_2To1_21_4)this.protocol).registerServerbound(ServerboundPackets1_21_4.MOVE_VEHICLE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.read(Types.BOOLEAN);
        });
        ((Protocol1_21_2To1_21_4)this.protocol).cancelServerbound(ServerboundPackets1_21_4.PLAYER_LOADED);
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_4.CREAKING).addIndex(18);
        this.filter().type(EntityTypes1_21_4.SALMON).index(17).handler((entityDataHandlerEvent, entityData) -> {
            String string;
            int n = switch (string = (String)entityData.value()) {
                case "small" -> 0;
                case "large" -> 2;
                default -> 1;
            };
            entityData.setTypeAndValue(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).varIntType, n);
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_4.getTypeFromId(n);
    }
}

