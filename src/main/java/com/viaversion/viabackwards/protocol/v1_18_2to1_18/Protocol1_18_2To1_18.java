/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_18_2to1_18;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.protocol.v1_18_2to1_18.rewriter.CommandRewriter1_18_2;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.util.TagUtil;

public class Protocol1_18_2To1_18
extends BackwardsProtocol<ClientboundPackets1_18, ClientboundPackets1_18, ServerboundPackets1_17, ServerboundPackets1_17> {
    public Protocol1_18_2To1_18() {
        super(ClientboundPackets1_18.class, ClientboundPackets1_18.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        new CommandRewriter1_18_2(this).registerDeclareCommands(ClientboundPackets1_18.COMMANDS);
        final PacketHandler packetHandler = packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            if ((byte)n != n) {
                if (Via.getConfig().logOtherConversionWarnings()) {
                    this.getLogger().warning("Cannot send entity effect id " + n + " to old client");
                }
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.BYTE, (byte)n);
        };
        this.registerClientbound(ClientboundPackets1_18.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetHandler);
            }
        });
        this.registerClientbound(ClientboundPackets1_18.REMOVE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetHandler);
            }
        });
        this.registerClientbound(ClientboundPackets1_18.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "dimension_type");
                    for (CompoundTag compoundTag2 : listTag) {
                        Protocol1_18_2To1_18.this.removeTagPrefix(compoundTag2.getCompoundTag("element"));
                    }
                    Protocol1_18_2To1_18.this.removeTagPrefix(packetWrapper.get(Types.NAMED_COMPOUND_TAG, 1));
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_18.RESPAWN, packetWrapper -> this.removeTagPrefix(packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG)));
    }

    private void removeTagPrefix(CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("infiniburn");
        if (stringTag != null) {
            stringTag.setValue(stringTag.getValue().substring(1));
        }
    }
}

