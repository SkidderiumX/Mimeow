/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Rewritable {
    public Object rewrite(UserConnection var1, Protocol<?, ?, ?, ?> var2, boolean var3);

    public static int rewriteDataComponentType(Protocol<?, ?, ?, ?> protocol, boolean bl, int n) {
        FullMappings fullMappings = protocol.getMappingData().getDataComponentSerializerMappings();
        return fullMappings == null ? n : (bl ? fullMappings.getNewId(n) : fullMappings.inverse().getNewId(n));
    }

    public static int rewriteSound(Protocol<?, ?, ?, ?> protocol, boolean bl, int n) {
        return protocol.getMappingData().getSoundMappings() == null ? n : (bl ? protocol.getMappingData().getNewSoundId(n) : protocol.getMappingData().getOldSoundId(n));
    }

    public static int rewriteItem(Protocol<?, ?, ?, ?> protocol, boolean bl, int n) {
        return protocol.getMappingData().getItemMappings() == null ? n : (bl ? protocol.getMappingData().getNewItemId(n) : protocol.getMappingData().getOldItemId(n));
    }

    public static String rewriteItem(Protocol<?, ?, ?, ?> protocol, boolean bl, String string) {
        FullMappings fullMappings = protocol.getMappingData().getFullItemMappings();
        return fullMappings == null ? string : (bl ? Rewritable.mappedIdentifier(fullMappings, string) : Rewritable.unmappedIdentifier(fullMappings, string));
    }

    public static Int2IntFunction itemRewriteFunction(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return protocol.getMappingData().getItemMappings() == null ? Int2IntFunction.identity() : (bl ? protocol.getMappingData()::getNewItemId : protocol.getMappingData()::getOldItemId);
    }

    public static Int2IntFunction blockRewriteFunction(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return protocol.getMappingData().getBlockMappings() == null ? Int2IntFunction.identity() : (bl ? protocol.getMappingData()::getNewBlockId : protocol.getMappingData()::getOldBlockId);
    }

    public static Int2IntFunction soundRewriteFunction(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return protocol.getMappingData().getSoundMappings() == null ? Int2IntFunction.identity() : (bl ? protocol.getMappingData().getSoundMappings()::getNewId : protocol.getMappingData()::getOldSoundId);
    }

    public static Int2IntFunction entityRewriteFunction(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return protocol.getMappingData().getEntityMappings() == null ? Int2IntFunction.identity() : (bl ? protocol.getMappingData().getEntityMappings()::getNewId : protocol.getMappingData().getEntityMappings().inverse()::getNewId);
    }

    public static @Nullable String mappedIdentifier(FullMappings fullMappings, String string) {
        if (fullMappings.id(string) == -1) {
            return string;
        }
        return fullMappings.mappedIdentifier(string);
    }

    public static @Nullable String unmappedIdentifier(FullMappings fullMappings, String string) {
        if (fullMappings.mappedId(string) == -1) {
            return string;
        }
        return fullMappings.identifier(string);
    }
}

