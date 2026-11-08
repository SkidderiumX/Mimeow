/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.WorldIdentifiers;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.Protocol1_15_2To1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.data.AttributeMappings1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.data.DimensionRegistries1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.storage.InventoryTracker1_16;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.UUIDUtil;

public class EntityPacketRewriter1_16
extends EntityRewriter<ClientboundPackets1_15, Protocol1_15_2To1_16> {
    private final PacketHandler DIMENSION_HANDLER = packetWrapper -> {
        String string;
        WorldIdentifiers worldIdentifiers = Via.getConfig().get1_16WorldNamesMap();
        WorldIdentifiers worldIdentifiers2 = packetWrapper.user().get(WorldIdentifiers.class);
        if (worldIdentifiers2 != null) {
            worldIdentifiers = worldIdentifiers2;
        }
        int n = packetWrapper.read(Types.INT);
        String string2 = switch (n) {
            case -1 -> {
                string = "minecraft:the_nether";
                yield worldIdentifiers.nether();
            }
            case 0 -> {
                string = "minecraft:overworld";
                yield worldIdentifiers.overworld();
            }
            case 1 -> {
                string = "minecraft:the_end";
                yield worldIdentifiers.end();
            }
            default -> {
                ((Protocol1_15_2To1_16)this.protocol).getLogger().warning("Invalid dimension id: " + n);
                string = "minecraft:overworld";
                yield worldIdentifiers.overworld();
            }
        };
        packetWrapper.write(Types.STRING, string);
        packetWrapper.write(Types.STRING, string2);
        this.trackWorld(packetWrapper.user(), string2);
    };

    public EntityPacketRewriter1_16(Protocol1_15_2To1_16 protocol1_15_2To1_16) {
        super(protocol1_15_2To1_16);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.ADD_GLOBAL_ENTITY, ClientboundPackets1_16.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.read(Types.BYTE);
            if (by != 1) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.user().getEntityTracker(Protocol1_15_2To1_16.class).addEntity(n, EntityTypes1_16.LIGHTNING_BOLT);
            packetWrapper.write(Types.UUID, UUIDUtil.randomUUID());
            packetWrapper.write(Types.VAR_INT, EntityTypes1_16.LIGHTNING_BOLT.getId());
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.write(Types.INT, 0);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
        });
        this.registerTracker(ClientboundPackets1_15.ADD_PLAYER, EntityTypes1_16.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_15.SET_ENTITY_DATA, Types1_14.ENTITY_DATA_LIST, Types1_16.ENTITY_DATA_LIST);
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(EntityPacketRewriter1_16.this.DIMENSION_HANDLER);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.BYTE, (byte)-1);
                    boolean bl = packetWrapper.user().getProtocolInfo().serverProtocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_15);
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.write(Types.BOOLEAN, false);
                    packetWrapper.write(Types.BOOLEAN, string.equals("flat"));
                    packetWrapper.write(Types.BOOLEAN, bl);
                });
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.BYTE, (byte)-1);
                    packetWrapper.write(Types.STRING_ARRAY, DimensionRegistries1_16.getWorldNames());
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, DimensionRegistries1_16.getDimensionsTag());
                });
                this.handler(EntityPacketRewriter1_16.this.DIMENSION_HANDLER);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(EntityPacketRewriter1_16.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.write(Types.BOOLEAN, false);
                    packetWrapper.write(Types.BOOLEAN, string.equals("flat"));
                });
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.UPDATE_ATTRIBUTES, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.VAR_INT);
            int n2 = n = packetWrapper.passthrough(Types.INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n3;
                int n4;
                String string = packetWrapper.read(Types.STRING);
                String string2 = (String)AttributeMappings1_16.attributeIdentifierMappings().get(string);
                if (string2 == null && !Key.isValid(string2 = Key.namespaced(string))) {
                    if (Via.getConfig().logOtherConversionWarnings()) {
                        ((Protocol1_15_2To1_16)this.protocol).getLogger().warning("Invalid attribute: " + string);
                    }
                    --n2;
                    packetWrapper.read(Types.DOUBLE);
                    n4 = packetWrapper.read(Types.VAR_INT);
                    for (n3 = 0; n3 < n4; ++n3) {
                        packetWrapper.read(Types.UUID);
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.BYTE);
                    }
                    continue;
                }
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.passthrough(Types.DOUBLE);
                n4 = packetWrapper.passthrough(Types.VAR_INT);
                for (n3 = 0; n3 < n4; ++n3) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
            if (n != n2) {
                packetWrapper.set(Types.INT, 0, n2);
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerServerbound(ServerboundPackets1_16.SWING, packetWrapper -> {
            if (!Via.getConfig().cancelSwingInInventory()) {
                return;
            }
            InventoryTracker1_16 inventoryTracker1_16 = packetWrapper.user().get(InventoryTracker1_16.class);
            if (inventoryTracker1_16.isInventoryOpen()) {
                packetWrapper.cancel();
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_16.ENTITY_DATA_TYPES::byId);
        this.registerEntityDataTypeHandler(Types1_16.ENTITY_DATA_TYPES.itemType, Types1_16.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_16.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_16.ABSTRACT_MINECART, 10);
        this.filter().type(EntityTypes1_16.ABSTRACT_ARROW).removeIndex(8);
        this.filter().type(EntityTypes1_16.WOLF).index(16).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.value();
            int n = (by & 2) != 0 ? Integer.MAX_VALUE : 0;
            entityDataHandlerEvent.createExtraData(new EntityData(20, Types1_16.ENTITY_DATA_TYPES.varIntType, n));
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_16.getTypeFromId(n);
    }
}

