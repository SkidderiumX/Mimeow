/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.item;

import com.google.common.cache.CacheBuilder;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.codec.CodecRegistryContext;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.codec.hash.HashOps;
import com.viaversion.viaversion.data.item.OriginalHashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemHasherBase
implements ItemHasher {
    public static int UNKNOWN_HASH = 399825415;
    private final Map<Integer, OriginalHashedItem> hashes = CacheBuilder.newBuilder().concurrencyLevel(1).maximumSize(1024L).build().asMap();
    protected final UserConnection connection;
    private boolean processingClientboundInventoryPacket;
    private final CodecContext context;
    private final CodecContext mappedContext;

    public ItemHasherBase(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection) {
        CodecContext.RegistryAccess registryAccess = CodecContext.RegistryAccess.of(protocol, userConnection);
        this.context = new CodecRegistryContext(protocol, registryAccess, false);
        this.mappedContext = new CodecRegistryContext(protocol, registryAccess, true);
        this.connection = userConnection;
    }

    public HashedItem toHashedItem(Item item, boolean bl) {
        return ItemHasherBase.toHashedItem(new HashOps(bl ? this.mappedContext : this.context, HashFunction.crc32c()), item);
    }

    public static HashedItem toHashedItem(Hasher hasher, Item item) {
        HashedStructuredItem hashedStructuredItem = new HashedStructuredItem(item.identifier(), item.amount());
        for (StructuredData<?> structuredData : item.dataContainer().data().values()) {
            if (structuredData.isEmpty()) {
                hashedStructuredItem.removedDataIds().add(structuredData.id());
                continue;
            }
            int n = hasher.context().isSupported(structuredData.key()) ? ItemHasherBase.hash(hasher, structuredData) : UNKNOWN_HASH;
            hashedStructuredItem.dataHashesById().put(structuredData.id(), n);
        }
        return hashedStructuredItem;
    }

    public void trackOriginalHashedItem(CompoundTag compoundTag, HashedItem hashedItem, String string) {
        int n = this.hashTag(compoundTag);
        this.hashes.put(n, new OriginalHashedItem(hashedItem, string));
    }

    public @Nullable OriginalHashedItem originalHashedItem(int n, HashedItem hashedItem) {
        OriginalHashedItem originalHashedItem = this.hashes.get(n);
        if (originalHashedItem == null) {
            return null;
        }
        originalHashedItem = originalHashedItem.copy();
        for (Int2IntMap.Entry entry : originalHashedItem.dataHashesById().int2IntEntrySet()) {
            int n2 = entry.getIntKey();
            if (entry.getIntValue() != UNKNOWN_HASH || !hashedItem.dataHashesById().containsKey(n2)) continue;
            int n3 = hashedItem.dataHashesById().get(n2);
            entry.setValue(n3);
        }
        originalHashedItem.setAmount(hashedItem.amount());
        return originalHashedItem;
    }

    @Override
    public boolean isProcessingClientboundInventoryPacket() {
        return this.processingClientboundInventoryPacket;
    }

    @Override
    public void setProcessingClientboundInventoryPacket(boolean bl) {
        this.processingClientboundInventoryPacket = bl;
    }

    private static <T> int hash(Hasher hasher, StructuredData<T> structuredData) {
        hasher.reset();
        hasher.write(structuredData.key().type(), structuredData.value());
        return hasher.hash();
    }

    private int hashTag(CompoundTag compoundTag) {
        HashOps hashOps = new HashOps(this.context, HashFunction.crc32c());
        Types.TAG.write(hashOps, (Tag)compoundTag);
        return hashOps.hash();
    }
}

