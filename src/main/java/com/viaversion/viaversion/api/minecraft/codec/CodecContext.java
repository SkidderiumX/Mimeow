/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.codec.RegistryAccessImpl;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.util.Key;

public interface CodecContext {
    public RegistryAccess registryAccess();

    public boolean mapped();

    public boolean isSupported(StructuredDataKey<?> var1);

    public UserConnection connection();

    public static interface RegistryAccess {
        public UserConnection connection();

        public Key item(int var1);

        public Key attributeModifier(int var1);

        public Key dataComponentType(int var1);

        public Key entity(int var1);

        public Key blockEntity(int var1);

        public Key sound(int var1);

        public Key key(MappingData.MappingType var1, int var2);

        public int id(MappingData.MappingType var1, String var2);

        public static RegistryAccess of(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection) {
            return new RegistryAccessImpl(protocol, userConnection);
        }

        public Key registryKey(String var1, int var2);

        public RegistryAccess withMapped(boolean var1);
    }
}

