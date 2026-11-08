/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.FullMappingsBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;

public class ParticleMappings
extends FullMappingsBase {
    private final IntList itemParticleIds = new IntArrayList(4);
    private final IntList blockParticleIds = new IntArrayList(4);

    public ParticleMappings(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        super(identifiersPair, mappings);
        this.addBlockParticle("block");
        this.addBlockParticle("falling_dust");
        this.addBlockParticle("block_marker");
        this.addBlockParticle("dust_pillar");
        this.addBlockParticle("block_crumble");
        this.addItemParticle("item");
    }

    public boolean addItemParticle(String string) {
        int n = this.id(string);
        return n != -1 && this.itemParticleIds.add(n);
    }

    public boolean addBlockParticle(String string) {
        int n = this.id(string);
        return n != -1 && this.blockParticleIds.add(n);
    }

    public boolean isBlockParticle(int n) {
        return this.blockParticleIds.contains(n);
    }

    public boolean isItemParticle(int n) {
        return this.itemParticleIds.contains(n);
    }
}

