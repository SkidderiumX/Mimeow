/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.storage.SneakStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_21_6
extends EntityRewriter<ClientboundPacket1_21_5, Protocol1_21_5To1_21_6> {
    public EntityPacketRewriter1_21_6(Protocol1_21_5To1_21_6 protocol1_21_5To1_21_6) {
        super(protocol1_21_5To1_21_6);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_5To1_21_6)this.protocol).appendClientbound(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, packetWrapper -> {
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA, packetWrapper.user());
            packetWrapper2.write(Types.STRING, "minecraft:dialog");
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{this.serverLinksDialog()});
            packetWrapper2.send(Protocol1_21_5To1_21_6.class);
        });
        ((Protocol1_21_5To1_21_6)this.protocol).appendClientbound(ClientboundPackets1_21_5.RESPAWN, packetWrapper -> packetWrapper.user().get(SneakStorage.class).setSneaking(false));
        ((Protocol1_21_5To1_21_6)this.protocol).registerServerbound(ServerboundPackets1_21_6.PLAYER_COMMAND, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, n + 2);
        });
        ((Protocol1_21_5To1_21_6)this.protocol).registerServerbound(ServerboundPackets1_21_6.PLAYER_INPUT, packetWrapper -> {
            boolean bl;
            byte by = packetWrapper.passthrough(Types.BYTE);
            boolean bl2 = bl = (by & 0x20) != 0;
            if (packetWrapper.user().get(SneakStorage.class).setSneaking(bl)) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_21_5.PLAYER_COMMAND);
                packetWrapper2.write(Types.VAR_INT, this.tracker(packetWrapper.user()).clientEntityId());
                packetWrapper2.write(Types.VAR_INT, bl ? 0 : 1);
                packetWrapper2.write(Types.VAR_INT, 0);
                packetWrapper2.sendToServer(Protocol1_21_5To1_21_6.class);
            }
        });
    }

    private RegistryEntry serverLinksDialog() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("type", "minecraft:server_links");
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putString("translate", "menu.server_links.title");
        compoundTag.put("title", compoundTag2);
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag3.putString("translate", "menu.server_links");
        compoundTag.put("external_title", compoundTag3);
        CompoundTag compoundTag4 = new CompoundTag();
        compoundTag4.putInt("width", 200);
        CompoundTag compoundTag5 = new CompoundTag();
        compoundTag5.putString("translate", "gui.back");
        compoundTag4.put("label", compoundTag5);
        compoundTag.put("exit_action", compoundTag4);
        compoundTag.putInt("columns", 1);
        compoundTag.putInt("button_width", 310);
        return new RegistryEntry("server_links", compoundTag);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes;
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler(entityDataTypes1_21_5.itemType, entityDataTypes1_21_5.blockStateType, entityDataTypes1_21_5.optionalBlockStateType, entityDataTypes1_21_5.particleType, entityDataTypes1_21_5.particlesType, entityDataTypes1_21_5.componentType, entityDataTypes1_21_5.optionalComponentType);
        this.filter().type(EntityTypes1_21_6.HANGING_ENTITY).addIndex(8);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_6.getTypeFromId(n);
    }
}

