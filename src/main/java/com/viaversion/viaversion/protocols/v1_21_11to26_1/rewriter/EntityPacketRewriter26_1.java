/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter;

import com.viaversion.viaversion.api.minecraft.Vector3d;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.Protocol1_21_11To26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.storage.PlayerSneaking;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter26_1
extends EntityRewriter<ClientboundPacket1_21_11, Protocol1_21_11To26_1> {
    public EntityPacketRewriter26_1(Protocol1_21_11To26_1 protocol1_21_11To26_1) {
        super(protocol1_21_11To26_1);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_11To26_1)this.protocol).appendClientbound(ClientboundPackets1_21_11.RESPAWN, packetWrapper -> packetWrapper.user().get(PlayerSneaking.class).setSneaking(false));
        ((Protocol1_21_11To26_1)this.protocol).registerServerbound(ServerboundPackets26_1.PLAYER_INPUT, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            boolean bl = (by & 0x20) != 0;
            packetWrapper.user().get(PlayerSneaking.class).setSneaking(bl);
        });
        ((Protocol1_21_11To26_1)this.protocol).registerServerbound(ServerboundPackets26_1.INTERACT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, 0);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            Vector3d vector3d = packetWrapper.read(Types.LOW_PRECISION_VECTOR);
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.user().get(PlayerSneaking.class).setSneaking(bl);
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_21_6.INTERACT);
            packetWrapper2.write(Types.VAR_INT, n);
            packetWrapper2.write(Types.VAR_INT, 2);
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)vector3d.x()));
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)vector3d.y()));
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)vector3d.z()));
            packetWrapper2.write(Types.VAR_INT, n2);
            packetWrapper2.write(Types.BOOLEAN, bl);
            packetWrapper2.sendToServer(Protocol1_21_11To26_1.class);
        });
        ((Protocol1_21_11To26_1)this.protocol).registerServerbound(ServerboundPackets26_1.ATTACK, ServerboundPackets1_21_6.INTERACT, this::writeInteract);
        ((Protocol1_21_11To26_1)this.protocol).registerServerbound(ServerboundPackets26_1.SPECTATE_ENTITY, ServerboundPackets1_21_6.INTERACT, this::writeInteract);
    }

    private void writeInteract(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.write(Types.VAR_INT, 1);
        packetWrapper.write(Types.BOOLEAN, packetWrapper.user().get(PlayerSneaking.class).sneaking());
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes26_1 entityDataTypes26_1 = (EntityDataTypes26_1)((Types1_20_5)((Protocol1_21_11To26_1)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().added(entityDataTypes26_1.catSoundVariant).added(entityDataTypes26_1.cowSoundVariant).added(entityDataTypes26_1.pigSoundVariant).added(entityDataTypes26_1.chickenSoundVariant).register();
        this.registerEntityDataTypeHandler(entityDataTypes26_1.itemType, entityDataTypes26_1.blockStateType, entityDataTypes26_1.optionalBlockStateType, entityDataTypes26_1.particleType, entityDataTypes26_1.particlesType, entityDataTypes26_1.componentType, entityDataTypes26_1.optionalComponentType);
        this.filter().type(EntityTypes1_21_11.VILLAGER).addIndex(19);
        this.filter().type(EntityTypes1_21_11.ZOMBIE_VILLAGER).addIndex(21);
        this.filter().type(EntityTypes1_21_11.ABSTRACT_AGEABLE).addIndex(17);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }
}

