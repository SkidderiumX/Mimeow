/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;

public class CommandRewriter<C extends ClientboundPacketType> {
    private static final Set<String> REGISTRY_ARGUMENT_TYPES = Set.of("resource", "resource_key", "resource_or_tag", "resource_or_tag_key", "resource_selector");
    protected final Protocol<C, ?, ?, ?> protocol;
    protected final Map<String, CommandArgumentConsumer> parserHandlers = new HashMap<String, CommandArgumentConsumer>();

    public CommandRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
        this.parserHandlers.put("brigadier:double", packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if ((by & 1) != 0) {
                packetWrapper.passthrough(Types.DOUBLE);
            }
            if ((by & 2) != 0) {
                packetWrapper.passthrough(Types.DOUBLE);
            }
        });
        this.parserHandlers.put("brigadier:float", packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if ((by & 1) != 0) {
                packetWrapper.passthrough(Types.FLOAT);
            }
            if ((by & 2) != 0) {
                packetWrapper.passthrough(Types.FLOAT);
            }
        });
        this.parserHandlers.put("brigadier:integer", packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if ((by & 1) != 0) {
                packetWrapper.passthrough(Types.INT);
            }
            if ((by & 2) != 0) {
                packetWrapper.passthrough(Types.INT);
            }
        });
        this.parserHandlers.put("brigadier:long", packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if ((by & 1) != 0) {
                packetWrapper.passthrough(Types.LONG);
            }
            if ((by & 2) != 0) {
                packetWrapper.passthrough(Types.LONG);
            }
        });
        this.parserHandlers.put("brigadier:string", packetWrapper -> packetWrapper.passthrough(Types.VAR_INT));
        this.parserHandlers.put("minecraft:entity", packetWrapper -> packetWrapper.passthrough(Types.BYTE));
        this.parserHandlers.put("minecraft:score_holder", packetWrapper -> packetWrapper.passthrough(Types.BYTE));
        this.parserHandlers.put("minecraft:resource", packetWrapper -> packetWrapper.passthrough(Types.STRING));
        this.parserHandlers.put("minecraft:resource_or_tag", packetWrapper -> packetWrapper.passthrough(Types.STRING));
        this.parserHandlers.put("minecraft:resource_or_tag_key", packetWrapper -> packetWrapper.passthrough(Types.STRING));
        this.parserHandlers.put("minecraft:resource_key", packetWrapper -> packetWrapper.passthrough(Types.STRING));
        this.parserHandlers.put("minecraft:resource_selector", packetWrapper -> packetWrapper.passthrough(Types.STRING));
    }

    public void registerDeclareCommands(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                byte by;
                byte by2 = packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if ((by2 & 8) != 0) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if ((by = (byte)(by2 & 3)) == 1 || by == 2) {
                    packetWrapper.passthrough(Types.STRING);
                }
                if (by == 2) {
                    String string = packetWrapper.read(Types.STRING);
                    String string2 = this.handleArgumentType(string);
                    if (string2 != null) {
                        packetWrapper.write(Types.STRING, string2);
                    }
                    this.handleArgument(packetWrapper, string);
                }
                if ((by2 & 0x10) == 0) continue;
                packetWrapper.passthrough(Types.STRING);
            }
            packetWrapper.passthrough(Types.VAR_INT);
        });
    }

    public void registerDeclareCommands1_19(C c) {
        this.protocol.registerClientbound(c, this::handle1_19);
    }

    public void handle1_19(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            byte by;
            byte by2 = packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            if ((by2 & 8) != 0) {
                packetWrapper.passthrough(Types.VAR_INT);
            }
            if ((by = (byte)(by2 & 3)) == 1 || by == 2) {
                packetWrapper.passthrough(Types.STRING);
            }
            if (by != 2) continue;
            int n2 = packetWrapper.read(Types.VAR_INT);
            String string = this.argumentType(n2);
            if (string == null) {
                packetWrapper.write(Types.VAR_INT, this.mapInvalidArgumentType(n2));
                continue;
            }
            String string2 = this.handleArgumentType(string);
            Preconditions.checkNotNull(string2, "No mapping for argument type %s", string);
            boolean bl = false;
            RegistryDataRewriter registryDataRewriter = this.protocol.getRegistryDataRewriter();
            if (registryDataRewriter != null && registryDataRewriter.hasRegistriesToRemove() && REGISTRY_ARGUMENT_TYPES.contains(Key.stripMinecraftNamespace(string))) {
                String string3 = packetWrapper.read(Types.STRING);
                if (registryDataRewriter.shouldRemoveRegistry(string3)) {
                    bl = true;
                    packetWrapper.write(Types.VAR_INT, this.mappedArgumentTypeId("brigadier:string"));
                    packetWrapper.write(Types.VAR_INT, 1);
                } else {
                    packetWrapper.write(Types.STRING, string3);
                    packetWrapper.rewindReader(1);
                }
            }
            if (!bl) {
                packetWrapper.write(Types.VAR_INT, this.mappedArgumentTypeId(string2));
                this.handleArgument(packetWrapper, string);
            }
            if ((by2 & 0x10) == 0) continue;
            packetWrapper.passthrough(Types.STRING);
        }
        packetWrapper.passthrough(Types.VAR_INT);
    }

    public void handleArgument(PacketWrapper packetWrapper, String string) {
        CommandArgumentConsumer commandArgumentConsumer = this.parserHandlers.get(string);
        if (commandArgumentConsumer != null) {
            commandArgumentConsumer.accept(packetWrapper);
        }
    }

    public String handleArgumentType(String string) {
        if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getArgumentTypeMappings() != null) {
            return this.protocol.getMappingData().getArgumentTypeMappings().mappedIdentifier(string);
        }
        return string;
    }

    protected @Nullable String argumentType(int n) {
        FullMappings fullMappings = this.protocol.getMappingData().getArgumentTypeMappings();
        String string = fullMappings.identifier(n);
        Preconditions.checkArgument(string != null || n >= fullMappings.size(), "Unknown argument type id %s", n);
        return string;
    }

    protected int mappedArgumentTypeId(String string) {
        return this.protocol.getMappingData().getArgumentTypeMappings().mappedId(string);
    }

    private int mapInvalidArgumentType(int n) {
        if (n < 0) {
            return n;
        }
        FullMappings fullMappings = this.protocol.getMappingData().getArgumentTypeMappings();
        int n2 = n - fullMappings.size();
        return fullMappings.mappedSize() + n2;
    }

    @FunctionalInterface
    public static interface CommandArgumentConsumer {
        public void accept(PacketWrapper var1);
    }
}

