/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;

public class SoundRewriter<C extends ClientboundPacketType> {
    protected final Protocol<C, ?, ?, ?> protocol;

    public SoundRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    public void registerSound(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isIntIdIdentity(this.protocol.getMappingData().getSoundMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.getSoundHandler().handle(packetWrapper);
        });
    }

    public void registerSound1_19_3(C c) {
        if (this.protocol.getMappingData() != null && !Mappings.isFullIdentity(this.protocol.getMappingData().getFullSoundMappings())) {
            this.protocol.registerClientbound(c, this.soundHolderHandler());
        }
    }

    public PacketHandler soundHolderHandler() {
        return packetWrapper -> {
            Holder<int> holder = (Holder<int>)((Object)packetWrapper.read(Types.SOUND_EVENT));
            if (holder.isDirect()) {
                packetWrapper.write(Types.SOUND_EVENT, this.rewriteSoundEvent(packetWrapper, (Holder<SoundEvent>)holder));
                return;
            }
            int n = this.protocol.getMappingData().getSoundMappings().getNewId(holder.id());
            if (n == -1) {
                packetWrapper.cancel();
                return;
            }
            if (n != holder.id()) {
                holder = Holder.of(n);
            }
            packetWrapper.write(Types.SOUND_EVENT, holder);
        };
    }

    public Holder<SoundEvent> rewriteSoundEvent(PacketWrapper packetWrapper, Holder<SoundEvent> holder) {
        SoundEvent soundEvent = holder.value();
        String string = this.protocol.getMappingData().getFullSoundMappings().mappedIdentifier(soundEvent.identifier());
        if (string != null) {
            if (!string.isEmpty()) {
                return Holder.of(soundEvent.withIdentifier(string));
            }
            packetWrapper.cancel();
        }
        return holder;
    }

    public PacketHandler getSoundHandler() {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 0);
            int n2 = this.protocol.getMappingData().getSoundMappings().getNewId(n);
            if (n2 == -1) {
                packetWrapper.cancel();
            } else if (n != n2) {
                packetWrapper.set(Types.VAR_INT, 0, n2);
            }
        };
    }
}

