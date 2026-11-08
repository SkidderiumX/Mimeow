/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.data.RewindMappingDataLoader;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.LegacyFullStringMappingsBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import java.util.logging.Logger;

public class RewindMappingData
extends BackwardsMappingData {
    public RewindMappingData(String string, String string2) {
        super(string, string2);
    }

    @Override
    protected Logger getLogger() {
        return ViaRewind.getPlatform().getLogger();
    }

    @Override
    protected CompoundTag readMappingsFile(String string) {
        return RewindMappingDataLoader.INSTANCE.loadNBTFromDir(string);
    }

    @Override
    protected FullMappings createFullMappings(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        return new LegacyFullStringMappingsBase(identifiersPair, mappings);
    }
}

