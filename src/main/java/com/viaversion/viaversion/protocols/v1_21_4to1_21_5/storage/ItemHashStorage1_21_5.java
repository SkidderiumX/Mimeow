/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.codec.CodecRegistryContext;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.codec.hash.HashOps;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import java.util.concurrent.ExecutionException;

public class ItemHashStorage1_21_5
implements ItemHasher {
    private final Cache<Long, StructuredData<?>> hashToStructuredData = CacheBuilder.newBuilder().concurrencyLevel(1).maximumSize(512L).build();
    private boolean processingClientboundInventoryPacket;
    private final CodecContext context;

    public ItemHashStorage1_21_5(Protocol1_21_4To1_21_5 protocol1_21_4To1_21_5, UserConnection userConnection) {
        CodecContext.RegistryAccess registryAccess = CodecContext.RegistryAccess.of(protocol1_21_4To1_21_5, userConnection);
        this.context = new CodecRegistryContext(protocol1_21_4To1_21_5, registryAccess, true);
    }

    public void trackStructuredData(StructuredData<?> structuredData) {
        int n;
        if (structuredData.isEmpty()) {
            return;
        }
        HashOps hashOps = new HashOps(this.context, HashFunction.crc32c());
        int n2 = n = hashOps.context().isSupported(structuredData.key()) ? ItemHashStorage1_21_5.hash(hashOps, structuredData) : ItemHasherBase.UNKNOWN_HASH;
        if (n == ItemHasherBase.UNKNOWN_HASH) {
            return;
        }
        long l = (long)structuredData.id() << 32 | (long)n;
        try {
            this.hashToStructuredData.get(l, structuredData::copy);
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
    }

    public StructuredData<?> dataFromHash(int n, int n2) {
        long l = (long)n << 32 | (long)n2;
        StructuredData<?> structuredData = this.hashToStructuredData.getIfPresent(l);
        return structuredData != null ? structuredData.copy() : null;
    }

    private static <T> int hash(Hasher hasher, StructuredData<T> structuredData) {
        hasher.write(structuredData.key().type(), structuredData.value());
        return hasher.hash();
    }

    @Override
    public boolean isProcessingClientboundInventoryPacket() {
        return this.processingClientboundInventoryPacket;
    }

    @Override
    public void setProcessingClientboundInventoryPacket(boolean bl) {
        this.processingClientboundInventoryPacket = bl;
    }
}

