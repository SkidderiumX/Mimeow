/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter;

import com.viaversion.viabackwards.protocol.v1_14to1_13_2.Protocol1_14To1_13_2;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class CommandRewriter1_14
extends CommandRewriter<ClientboundPackets1_14> {
    public CommandRewriter1_14(Protocol1_14To1_13_2 protocol1_14To1_13_2) {
        super(protocol1_14To1_13_2);
        this.parserHandlers.put("minecraft:nbt_tag", packetWrapper -> packetWrapper.write(Types.VAR_INT, 2));
        this.parserHandlers.put("minecraft:time", packetWrapper -> {
            packetWrapper.write(Types.BYTE, (byte)1);
            packetWrapper.write(Types.INT, 0);
        });
    }

    @Override
    public @Nullable String handleArgumentType(String string) {
        return switch (string) {
            case "minecraft:nbt_compound_tag" -> "minecraft:nbt";
            case "minecraft:nbt_tag" -> "brigadier:string";
            case "minecraft:time" -> "brigadier:integer";
            default -> super.handleArgumentType(string);
        };
    }
}

