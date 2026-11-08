/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.SoundRewriter;

public class ParticleRewriter<C extends ClientboundPacketType>
implements com.viaversion.viaversion.api.rewriter.ParticleRewriter {
    protected final Protocol<C, ?, ?, ?> protocol;
    private final Type<Particle> particleType;
    private final Type<Particle> mappedParticleType;

    public ParticleRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
        this.particleType = protocol.types() != null ? protocol.types().particle() : null;
        this.mappedParticleType = protocol.mappedTypes() != null ? protocol.mappedTypes().particle() : null;
    }

    public void registerLevelParticles1_13(C c, final Type<?> type) {
        this.protocol.registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(type);
                this.map(type);
                this.map(type);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(ParticleRewriter.this.levelParticlesHandler1_13(Types.INT));
            }
        });
    }

    public void registerLevelParticles1_19(C c) {
        this.protocol.registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(ParticleRewriter.this.levelParticlesHandler1_13(Types.VAR_INT));
            }
        });
    }

    public PacketHandler levelParticlesHandler1_13(Type<Integer> type) {
        return packetWrapper -> {
            int n;
            int n2 = (Integer)packetWrapper.get(type, 0);
            if (n2 == -1) {
                return;
            }
            ParticleMappings particleMappings = this.protocol.getMappingData().getParticleMappings();
            if (particleMappings.isBlockParticle(n2)) {
                n = packetWrapper.read(Types.VAR_INT);
                packetWrapper.write(Types.VAR_INT, this.protocol.getMappingData().getNewBlockStateId(n));
            } else if (particleMappings.isItemParticle(n2)) {
                ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
                Item item = packetWrapper.read(itemRewriter.itemType());
                packetWrapper.write(itemRewriter.mappedItemType(), itemRewriter.handleItemToClient(packetWrapper.user(), item));
            }
            n = this.protocol.getMappingData().getNewParticleId(n2);
            if (n != n2) {
                packetWrapper.set(type, 0, n);
            }
        };
    }

    public void registerLevelParticles1_20_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.INT);
            Particle particle = packetWrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(packetWrapper.user(), particle);
        });
    }

    public void registerLevelParticles1_21_4(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.INT);
            Particle particle = packetWrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(packetWrapper.user(), particle);
        });
    }

    public void registerExplode1_20_5(C c) {
        SoundRewriter<C> soundRewriter = new SoundRewriter<C>(this.protocol);
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
            }
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.VAR_INT);
            Particle particle = packetWrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            Particle particle2 = packetWrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(packetWrapper.user(), particle);
            this.rewriteParticle(packetWrapper.user(), particle2);
            soundRewriter.soundHolderHandler().handle(packetWrapper);
        });
    }

    public void registerExplode1_21_2(C c) {
        SoundRewriter<C> soundRewriter = new SoundRewriter<C>(this.protocol);
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
            }
            this.passthroughParticle(packetWrapper);
            soundRewriter.soundHolderHandler().handle(packetWrapper);
        });
    }

    public void registerExplode1_21_9(C c) {
        SoundRewriter<C> soundRewriter = new SoundRewriter<C>(this.protocol);
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.INT);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
            }
            this.passthroughParticle(packetWrapper);
            soundRewriter.soundHolderHandler().handle(packetWrapper);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                this.passthroughParticle(packetWrapper);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.VAR_INT);
            }
        });
    }

    public Particle passthroughParticle(PacketWrapper packetWrapper) {
        Particle particle = packetWrapper.read(this.particleType);
        packetWrapper.write(this.mappedParticleType, particle);
        this.rewriteParticle(packetWrapper.user(), particle);
        return particle;
    }

    @Override
    public void rewriteParticle(UserConnection userConnection, Particle particle) {
        ParticleMappings particleMappings = this.protocol.getMappingData().getParticleMappings();
        ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
        int n = particle.id();
        if (particleMappings.isBlockParticle(n)) {
            Particle.ParticleData<Integer> particleData = particle.getArgument(0);
            particleData.setValue(this.protocol.getMappingData().getNewBlockStateId((Integer)particleData.getValue()));
        } else if (particleMappings.isItemParticle(n) && itemRewriter != null) {
            Particle.ParticleData<Item> particleData = particle.getArgument(0);
            Item item = itemRewriter.handleItemToClient(userConnection, (Item)particleData.getValue());
            if (itemRewriter.mappedItemTemplateType() != null && itemRewriter.itemTemplateType() != itemRewriter.mappedItemTemplateType()) {
                particle.set(0, itemRewriter.mappedItemTemplateType(), item);
            } else {
                particleData.setValue(item);
            }
        }
        particle.setId(this.protocol.getMappingData().getNewParticleId(n));
    }

    public Type<Particle> particleType() {
        return this.particleType;
    }

    public Type<Particle> mappedParticleType() {
        return this.mappedParticleType;
    }
}

