/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.Protocol1_21_4To1_21_2;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;

public class EntityPacketRewriter1_21_4
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_4To1_21_2> {
    public EntityPacketRewriter1_21_4(Protocol1_21_4To1_21_2 protocol1_21_4To1_21_2) {
        super(protocol1_21_4To1_21_2, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_4To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21_2.LOGIN, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.STRING_ARRAY);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n2, string);
            this.trackPlayer(packetWrapper.user(), n);
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_21_4.PLAYER_LOADED);
            packetWrapper2.scheduleSendToServer(Protocol1_21_4To1_21_2.class);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21_2.RESPAWN, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n, string);
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_21_4.PLAYER_LOADED);
            packetWrapper2.scheduleSendToServer(Protocol1_21_4To1_21_2.class);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_VEHICLE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.write(Types.BOOLEAN, true);
        });
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler1_20_3(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_4.CREAKING).removeIndex(19);
        this.filter().type(EntityTypes1_21_4.CREAKING).removeIndex(18);
        this.filter().type(EntityTypes1_21_4.SALMON).index(17).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            String string = switch (n) {
                case 0 -> "small";
                case 2 -> "large";
                default -> "medium";
            };
            entityData.setTypeAndValue(((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).stringType, string);
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_4.getTypeFromId(n);
    }
}

