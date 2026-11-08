/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_1to1_21_11.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.Protocol26_1To1_21_11;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.storage.GameModeStorage;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.Vector3d;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;

public class EntityPacketRewriter26_1
extends EntityRewriter<ClientboundPacket26_1, Protocol26_1To1_21_11> {
    private static final int INTERACT_ACTION = 0;
    private static final int ATTACK_ACTION = 1;
    private static final int INTERACT_AT_ACTION = 2;

    public EntityPacketRewriter26_1(Protocol26_1To1_21_11 protocol26_1To1_21_11) {
        super(protocol26_1To1_21_11, ((EntityDataTypes1_21_11)VersionedTypes.V1_21_11.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_11)VersionedTypes.V1_21_11.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol26_1To1_21_11)this.protocol).appendClientbound(ClientboundPackets26_1.RESPAWN, packetWrapper -> {
            byte by = packetWrapper.get(Types.BYTE, 0);
            packetWrapper.user().get(GameModeStorage.class).setGameMode(by);
        });
        ((Protocol26_1To1_21_11)this.protocol).appendClientbound(ClientboundPackets26_1.LOGIN, packetWrapper -> {
            byte by = packetWrapper.get(Types.BYTE, 0);
            packetWrapper.user().get(GameModeStorage.class).setGameMode(by);
        });
        ((Protocol26_1To1_21_11)this.protocol).appendClientbound(ClientboundPackets26_1.GAME_EVENT, packetWrapper -> {
            packetWrapper.resetReader();
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (s == 3) {
                int n = (int)Math.floor(packetWrapper.passthrough(Types.FLOAT).floatValue() + 0.5f);
                packetWrapper.user().get(GameModeStorage.class).setGameMode(n);
            }
        });
        ((Protocol26_1To1_21_11)this.protocol).registerServerbound(ServerboundPackets1_21_6.INTERACT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            switch (n) {
                case 0: {
                    packetWrapper.cancel();
                    break;
                }
                case 1: {
                    boolean bl = packetWrapper.user().get(GameModeStorage.class).gameMode() == GameMode.SPECTATOR.id();
                    packetWrapper.setPacketType(bl ? ServerboundPackets26_1.SPECTATE_ENTITY : ServerboundPackets26_1.ATTACK);
                    packetWrapper.read(Types.BOOLEAN);
                    break;
                }
                case 2: {
                    float f = packetWrapper.read(Types.FLOAT).floatValue();
                    float f2 = packetWrapper.read(Types.FLOAT).floatValue();
                    float f3 = packetWrapper.read(Types.FLOAT).floatValue();
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.write(Types.LOW_PRECISION_VECTOR, new Vector3d(f, f2, f3));
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid interact action");
                }
            }
        });
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes26_1 entityDataTypes26_1 = (EntityDataTypes26_1)VersionedTypes.V26_1.entityDataTypes;
        EntityDataTypes1_21_11 entityDataTypes1_21_11 = (EntityDataTypes1_21_11)VersionedTypes.V1_21_11.entityDataTypes;
        this.dataTypeMapper().removed(entityDataTypes26_1.catSoundVariant).removed(entityDataTypes26_1.cowSoundVariant).removed(entityDataTypes26_1.pigSoundVariant).removed(entityDataTypes26_1.chickenSoundVariant).register();
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_11.itemType, entityDataTypes1_21_11.blockStateType, entityDataTypes1_21_11.optionalBlockStateType, entityDataTypes1_21_11.particleType, entityDataTypes1_21_11.particlesType, entityDataTypes1_21_11.componentType, entityDataTypes1_21_11.optionalComponentType);
        this.filter().type(EntityTypes1_21_11.ZOMBIE_VILLAGER).removeIndex(21);
        this.filter().type(EntityTypes1_21_11.VILLAGER).removeIndex(20);
        this.filter().type(EntityTypes1_21_11.CAT).removeIndex(24);
        this.filter().type(EntityTypes1_21_11.CHICKEN).removeIndex(19);
        this.filter().type(EntityTypes1_21_11.PIG).removeIndex(20);
        this.filter().type(EntityTypes1_21_11.COW).removeIndex(19);
        this.filter().type(EntityTypes1_21_11.TADPOLE).removeIndex(17);
        this.filter().type(EntityTypes1_21_11.ABSTRACT_AGEABLE).removeIndex(17);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }
}

