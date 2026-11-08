/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.Protocol1_20_2To1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.RecipeRewriter1_20_2;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20_3
extends ItemRewriter<ClientboundPacket1_20_2, ServerboundPacket1_20_3, Protocol1_20_2To1_20_3> {
    public BlockItemPacketRewriter1_20_3(Protocol1_20_2To1_20_3 protocol1_20_2To1_20_3) {
        super(protocol1_20_2To1_20_3, Types.ITEM1_20_2, Types.ITEM1_20_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_2To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_2.LEVEL_PARTICLES, new PacketHandlers(){

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
                this.handler(packetWrapper -> {
                    ParticleMappings particleMappings;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == (particleMappings = ((Protocol1_20_2To1_20_3)BlockItemPacketRewriter1_20_3.this.protocol).getMappingData().getParticleMappings()).id("vibration")) {
                        String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
                        packetWrapper.write(Types.VAR_INT, string.equals("block") ? 0 : 1);
                    }
                });
                this.handler(((ParticleRewriter)((Protocol1_20_2To1_20_3)BlockItemPacketRewriter1_20_3.this.protocol).getParticleRewriter()).levelParticlesHandler1_13(Types.VAR_INT));
            }
        });
        new RecipeRewriter1_20_2<ClientboundPacket1_20_2>(this.protocol){

            @Override
            public void handleCraftingShaped(PacketWrapper packetWrapper) {
                int n = packetWrapper.read(Types.VAR_INT);
                int n2 = packetWrapper.read(Types.VAR_INT);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.VAR_INT, n2);
                int n3 = n2 * n;
                for (int i = 0; i < n3; ++i) {
                    this.handleIngredient(packetWrapper);
                }
                this.rewrite(packetWrapper.user(), packetWrapper.passthrough(this.itemType()));
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        }.register(ClientboundPackets1_20_2.UPDATE_RECIPES);
        ((Protocol1_20_2To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_2.EXPLODE, packetWrapper -> {
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
            packetWrapper.write(Types.VAR_INT, 1);
            packetWrapper.write(Types1_20_3.PARTICLE, new Particle(((Protocol1_20_2To1_20_3)this.protocol).getMappingData().getParticleMappings().mappedId("explosion")));
            packetWrapper.write(Types1_20_3.PARTICLE, new Particle(((Protocol1_20_2To1_20_3)this.protocol).getMappingData().getParticleMappings().mappedId("explosion_emitter")));
            packetWrapper.write(Types.STRING, "minecraft:entity.generic.explode");
            packetWrapper.write(Types.OPTIONAL_FLOAT, null);
        });
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (compoundTag != null && item.identifier() == 1047) {
            Object object;
            ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
            if (listTag != null) {
                object = listTag.iterator();
                while (object.hasNext()) {
                    StringTag stringTag = (StringTag)object.next();
                    this.updatePageTag(stringTag);
                }
            }
            if ((object = compoundTag.getCompoundTag("filtered_pages")) != null) {
                for (String string : ((CompoundTag)object).keySet()) {
                    this.updatePageTag(((CompoundTag)object).getStringTag(string));
                }
            }
        }
        return super.handleItemToClient(userConnection, item);
    }

    private void updatePageTag(StringTag stringTag) {
        block2: {
            try {
                JsonElement jsonElement = ComponentUtil.convertJson(stringTag.getValue(), SerializerVersion.V1_19_4, SerializerVersion.V1_20_3);
                stringTag.setValue(jsonElement.toString());
            }
            catch (Exception exception) {
                if (!Via.getConfig().logTextComponentConversionErrors()) break block2;
                ((Protocol1_20_2To1_20_3)this.protocol).getLogger().log(Level.SEVERE, "Error during book conversion: " + StringUtil.forLogging(stringTag.getValue()), exception);
            }
        }
    }
}

