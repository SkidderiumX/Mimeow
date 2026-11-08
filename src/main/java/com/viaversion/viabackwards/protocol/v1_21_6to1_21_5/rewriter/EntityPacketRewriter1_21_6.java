/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.viabackwards.api.entities.EntityScaleHelper;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;

public class EntityPacketRewriter1_21_6
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_6To1_21_5> {
    public EntityPacketRewriter1_21_6(Protocol1_21_6To1_21_5 protocol1_21_6To1_21_5) {
        super(protocol1_21_6To1_21_5, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_6To1_21_5)this.protocol).replaceClientbound(ClientboundPackets1_21_6.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            short s = packetWrapper.passthrough(Types.SHORT);
            short s2 = packetWrapper.passthrough(Types.SHORT);
            short s3 = packetWrapper.passthrough(Types.SHORT);
            this.trackSpawnWithData1_19(packetWrapper, n3);
            if (!(s == 0 && s2 == 0 && s3 == 0 || this.typeFromId(n2).isOrHasParent(EntityTypes1_21_6.LIVING_ENTITY))) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_5.SET_ENTITY_MOTION);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(Types.SHORT, s);
                packetWrapper2.write(Types.SHORT, s2);
                packetWrapper2.write(Types.SHORT, s3);
                packetWrapper.send(Protocol1_21_6To1_21_5.class);
                packetWrapper2.send(Protocol1_21_6To1_21_5.class);
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_6To1_21_5)this.protocol).registerServerbound(ServerboundPackets1_21_5.PLAYER_COMMAND, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            if (n < 2) {
                packetWrapper.cancel();
            }
            packetWrapper.write(Types.VAR_INT, n - 2);
        });
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes;
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_5.itemType, entityDataTypes1_21_5.blockStateType, entityDataTypes1_21_5.optionalBlockStateType, entityDataTypes1_21_5.particleType, entityDataTypes1_21_5.particlesType, entityDataTypes1_21_5.componentType, entityDataTypes1_21_5.optionalComponentType);
        this.filter().type(EntityTypes1_21_6.HANGING_ENTITY).removeIndex(8);
        this.filter().type(EntityTypes1_21_6.HAPPY_GHAST).cancel(17);
        this.filter().type(EntityTypes1_21_6.HAPPY_GHAST).cancel(18);
        EntityScaleHelper entityScaleHelper = new EntityScaleHelper(this, ClientboundPackets1_21_5.UPDATE_ATTRIBUTES);
        entityScaleHelper.addBabyScale(EntityTypes1_21_6.HAPPY_GHAST, 0.2375f, 16);
        this.filter().type(EntityTypes1_21_6.HAPPY_GHAST).cancel(16);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_21_6.HAPPY_GHAST, EntityTypes1_21_6.GHAST).tagName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_6.getTypeFromId(n);
    }
}

