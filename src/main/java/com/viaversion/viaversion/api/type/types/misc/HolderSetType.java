/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.RegistryKey;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntArrayType;
import com.viaversion.viaversion.api.type.types.misc.RegistryValueType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class HolderSetType
extends Type<HolderSet> {
    private final RegistryKey registryKey;

    public HolderSetType() {
        this((RegistryKey)null);
    }

    public HolderSetType(RegistryKey registryKey) {
        super(HolderSet.class);
        this.registryKey = registryKey;
    }

    @Override
    public HolderSet read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf) - 1;
        if (n == -1) {
            String string = (String)Types.STRING.read(byteBuf);
            return HolderSet.of(string);
        }
        return HolderSet.of(new VarIntArrayType(n).read(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, HolderSet holderSet) {
        if (holderSet.hasTagKey()) {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
            Types.STRING.write(byteBuf, holderSet.tagKey());
        } else {
            int[] nArray = holderSet.ids();
            Types.VAR_INT.writePrimitive(byteBuf, nArray.length + 1);
            for (int n : nArray) {
                Types.VAR_INT.writePrimitive(byteBuf, n);
            }
        }
    }

    @Override
    public void write(Ops ops, HolderSet holderSet) {
        if (holderSet.hasTagKey()) {
            ops.write(Types.TAG_KEY, Key.of(holderSet.tagKey()));
        } else {
            Preconditions.checkArgument(this.registryKey != null, "Cannot write HolderSet with direct ids without a mapping type");
            if (holderSet.ids().length == 1) {
                ops.write(Types.IDENTIFIER, this.key(ops, holderSet.ids()[0]));
                return;
            }
            ops.writeList(listSerializer -> {
                for (int n : holderSet.ids()) {
                    listSerializer.write(Types.IDENTIFIER, this.key(ops, n));
                }
            });
        }
    }

    private Key key(Ops ops, int n) {
        RegistryKey registryKey = this.registryKey;
        if (registryKey instanceof MappingData.MappingType) {
            MappingData.MappingType mappingType = (MappingData.MappingType)registryKey;
            return ops.context().registryAccess().key(mappingType, n);
        }
        registryKey = this.registryKey;
        if (registryKey instanceof RegistryValueType) {
            RegistryValueType registryValueType = (RegistryValueType)registryKey;
            return registryValueType.byId(n);
        }
        return ops.context().registryAccess().registryKey(this.registryKey.registry().toString(), n);
    }

    public static final class OptionalHolderSetType
    extends OptionalType<HolderSet> {
        public OptionalHolderSetType() {
            super(Types.HOLDER_SET);
        }
    }
}

