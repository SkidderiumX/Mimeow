/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StatisticsRewriter<C extends ClientboundPacketType> {
    private static final int CUSTOM_STATS_CATEGORY = 8;
    private final Protocol<C, ?, ?, ?> protocol;

    public StatisticsRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    public void register(C c) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null || Mappings.isIntIdIdentity(mappingData.getBlockMappings()) && Mappings.isIntIdIdentity(mappingData.getItemMappings()) && Mappings.isIntIdIdentity(mappingData.getEntityMappings()) && Mappings.isIntIdIdentity(mappingData.getStatisticsMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n3 = packetWrapper.read(Types.VAR_INT);
                int n4 = packetWrapper.read(Types.VAR_INT);
                int n5 = packetWrapper.read(Types.VAR_INT);
                if (n3 == 8 && mappingData.getStatisticsMappings() != null) {
                    n4 = mappingData.getStatisticsMappings().getNewId(n4);
                    if (n4 == -1) {
                        --n2;
                        continue;
                    }
                } else {
                    IdRewriteFunction idRewriteFunction;
                    RegistryType registryType = this.getRegistryTypeForStatistic(n3);
                    if (registryType != null && (idRewriteFunction = this.getRewriter(registryType)) != null) {
                        n4 = idRewriteFunction.rewrite(n4);
                    }
                }
                packetWrapper.write(Types.VAR_INT, n3);
                packetWrapper.write(Types.VAR_INT, n4);
                packetWrapper.write(Types.VAR_INT, n5);
            }
            if (n2 != n) {
                packetWrapper.set(Types.VAR_INT, 0, n2);
            }
        });
    }

    protected @Nullable IdRewriteFunction getRewriter(RegistryType registryType) {
        return switch (registryType) {
            case RegistryType.BLOCK -> {
                if (this.protocol.getMappingData().getBlockMappings() != null) {
                    yield n -> this.protocol.getMappingData().getNewBlockId(n);
                }
                yield null;
            }
            case RegistryType.ITEM -> {
                if (this.protocol.getMappingData().getItemMappings() != null) {
                    yield n -> this.protocol.getMappingData().getNewItemId(n);
                }
                yield null;
            }
            case RegistryType.ENTITY -> {
                if (this.protocol.getEntityRewriter() != null) {
                    yield n -> this.protocol.getEntityRewriter().newEntityId(n);
                }
                yield null;
            }
            default -> throw new IllegalArgumentException("Unknown registry type in statistics packet: " + String.valueOf(registryType));
        };
    }

    public @Nullable RegistryType getRegistryTypeForStatistic(int n) {
        return switch (n) {
            case 0 -> RegistryType.BLOCK;
            case 1, 2, 3, 4, 5 -> RegistryType.ITEM;
            case 6, 7 -> RegistryType.ENTITY;
            default -> null;
        };
    }
}

