/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v26_1to26_2.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes26_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v26_1to26_2.Protocol26_1To26_2;
import com.viaversion.viaversion.protocols.v26_1to26_2.storage.Encrypted;
import com.viaversion.viaversion.protocols.v26_1to26_2.storage.FakeEntityId;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import java.util.concurrent.ThreadLocalRandom;

public class EntityPacketRewriter26_2
extends EntityRewriter<ClientboundPacket26_1, Protocol26_1To26_2> {
    public EntityPacketRewriter26_2(Protocol26_1To26_2 protocol26_1To26_2) {
        super(protocol26_1To26_2);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.SPECTATE_ENTITY, packetWrapper -> {
            Integer n = packetWrapper.read(Types.OPTIONAL_VAR_INT);
            if (n != null) {
                packetWrapper.write(Types.VAR_INT, this.toOriginalEntityId(packetWrapper, n));
            } else {
                packetWrapper.setPacketType(ServerboundPackets26_1.SWING);
                packetWrapper.write(Types.VAR_INT, 0);
            }
        });
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.LOGIN, packetWrapper -> {
            packetWrapper.user().put(new FakeEntityId(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, -1)));
            int n = packetWrapper.get(Types.INT, 0);
            packetWrapper.set(Types.INT, 0, this.toFakeEntityId(packetWrapper, n));
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            boolean bl = packetWrapper.user().has(Encrypted.class);
            packetWrapper.write(Types.BOOLEAN, bl);
        });
        PacketHandler packetHandler = packetWrapper -> packetWrapper.set(Types.VAR_INT, 0, this.toFakeEntityId(packetWrapper, packetWrapper.get(Types.VAR_INT, 0)));
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.ADD_ENTITY, packetWrapper -> {
            packetHandler.handle(packetWrapper);
            EntityType entityType = this.typeFromId(packetWrapper.get(Types.VAR_INT, 1));
            if (entityType != null && entityType.isOrHasParent(EntityTypes26_2.PROJECTILE)) {
                packetWrapper.set(Types.VAR_INT, 2, this.toFakeEntityId(packetWrapper, packetWrapper.get(Types.VAR_INT, 2)));
            }
        });
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.SET_ENTITY_DATA, packetHandler);
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.SET_EQUIPMENT, packetHandler);
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.PLAYER_COMBAT_KILL, packetHandler);
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.UPDATE_ATTRIBUTES, packetHandler);
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.REMOVE_ENTITIES, packetWrapper -> {
            int[] nArray = packetWrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0);
            for (int i = 0; i < nArray.length; ++i) {
                nArray[i] = this.toFakeEntityId(packetWrapper, nArray[i]);
            }
        });
        PacketHandler packetHandler2 = packetWrapper -> packetWrapper.write(Types.VAR_INT, this.toFakeEntityId(packetWrapper, packetWrapper.read(Types.VAR_INT)));
        PacketHandler packetHandler3 = packetWrapper -> packetWrapper.write(Types.VAR_INT, this.toOriginalEntityId(packetWrapper, packetWrapper.read(Types.VAR_INT)));
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.ANIMATE, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.DEBUG_ENTITY_VALUE, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.ENTITY_POSITION_SYNC, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.HURT_ANIMATION, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.MOVE_ENTITY_POS, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.MOVE_ENTITY_ROT, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.MOVE_ENTITY_POS_ROT, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.MOVE_MINECART_ALONG_TRACK, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.REMOVE_MOB_EFFECT, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.ROTATE_HEAD, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.SET_CAMERA, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.SET_ENTITY_MOTION, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.UPDATE_MOB_EFFECT, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.TELEPORT_ENTITY, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.PROJECTILE_POWER, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.BLOCK_DESTRUCTION, packetHandler2);
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.ENTITY_EVENT, packetWrapper -> packetWrapper.write(Types.INT, this.toFakeEntityId(packetWrapper, packetWrapper.read(Types.INT))));
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.DAMAGE_EVENT, packetWrapper -> {
            Integer n;
            packetHandler2.handle(packetWrapper);
            packetWrapper.passthrough(Types.VAR_INT);
            Integer n2 = packetWrapper.passthrough(Types.OPTIONAL_VAR_INT);
            if (n2 != null) {
                packetWrapper.set(Types.OPTIONAL_VAR_INT, 0, this.toFakeEntityId(packetWrapper, n2));
            }
            if ((n = packetWrapper.passthrough(Types.OPTIONAL_VAR_INT)) != null) {
                packetWrapper.set(Types.OPTIONAL_VAR_INT, 1, this.toFakeEntityId(packetWrapper, n));
            }
        });
        ((Protocol26_1To26_2)this.protocol).appendClientbound(ClientboundPackets26_1.SOUND_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetHandler2.handle(packetWrapper);
        });
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.PLAYER_LOOK_AT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            if (bl) {
                packetHandler2.handle(packetWrapper);
            }
        });
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.SET_PASSENGERS, packetWrapper -> {
            packetHandler2.handle(packetWrapper);
            int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            for (int i = 0; i < nArray.length; ++i) {
                nArray[i] = this.toFakeEntityId(packetWrapper, nArray[i]);
            }
        });
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.MOUNT_SCREEN_OPEN, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.INT, this.toFakeEntityId(packetWrapper, packetWrapper.read(Types.INT)));
        });
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.SET_ENTITY_LINK, packetWrapper -> packetWrapper.write(Types.INT, this.toFakeEntityId(packetWrapper, packetWrapper.read(Types.INT))));
        ((Protocol26_1To26_2)this.protocol).registerClientbound(ClientboundPackets26_1.TAKE_ITEM_ENTITY, packetWrapper -> {
            packetHandler2.handle(packetWrapper);
            packetHandler2.handle(packetWrapper);
        });
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.ATTACK, packetHandler3);
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.INTERACT, packetHandler3);
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.PICK_ITEM_FROM_ENTITY, packetHandler3);
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.PLAYER_COMMAND, packetHandler3);
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.SET_COMMAND_MINECART, packetHandler3);
        ((Protocol26_1To26_2)this.protocol).registerServerbound(ServerboundPackets26_1.ENTITY_TAG_QUERY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetHandler3.handle(packetWrapper);
        });
    }

    private int toFakeEntityId(PacketWrapper packetWrapper, int n) {
        return n == 0 ? packetWrapper.user().get(FakeEntityId.class).id() : n;
    }

    private int toOriginalEntityId(PacketWrapper packetWrapper, int n) {
        return n < -1 && n == packetWrapper.user().get(FakeEntityId.class).id() ? 0 : n;
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes26_1 entityDataTypes26_1 = (EntityDataTypes26_1)((Types1_20_5)((Protocol26_1To26_2)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler(entityDataTypes26_1.itemType, entityDataTypes26_1.blockStateType, entityDataTypes26_1.optionalBlockStateType, entityDataTypes26_1.particleType, entityDataTypes26_1.particlesType, entityDataTypes26_1.componentType, entityDataTypes26_1.optionalComponentType);
        this.filter().type(EntityTypes26_2.ABSTRACT_CUBE_MOB).addIndex(16);
        this.filter().type(EntityTypes26_2.ABSTRACT_CUBE_MOB).addIndex(17);
        EntityDataHandler entityDataHandler = (entityDataHandlerEvent, entityData) -> {
            Integer n = (Integer)entityData.value();
            if (n != null) {
                entityData.setValue(n == 0 ? entityDataHandlerEvent.user().get(FakeEntityId.class).id() : n.intValue());
            }
        };
        this.filter().type(EntityTypes26_2.FROG).index(19).handler(entityDataHandler);
        this.filter().type(EntityTypes26_2.FIREWORK_ROCKET).index(9).handler(entityDataHandler);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes26_2.getTypeFromId(n);
    }
}

