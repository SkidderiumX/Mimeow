/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.data.BackwardsMappingData1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter.BlockItemPacketRewriter1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter.CommandRewriter1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter.EntityPacketRewriter1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter.PlayerPacketRewriter1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter.SoundPacketRewriter1_14;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.ChunkLightStorage;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.DifficultyStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class Protocol1_14To1_13_2
extends BackwardsProtocol<ClientboundPackets1_14, ClientboundPackets1_13, ServerboundPackets1_14, ServerboundPackets1_13> {
    public static final BackwardsMappingData1_14 MAPPINGS = new BackwardsMappingData1_14();
    private final EntityPacketRewriter1_14 entityRewriter = new EntityPacketRewriter1_14(this);
    private final BlockItemPacketRewriter1_14 itemRewriter = new BlockItemPacketRewriter1_14(this);
    private final BlockRewriter<ClientboundPackets1_14> blockRewriter = BlockRewriter.legacy(this);
    private final ParticleRewriter<ClientboundPackets1_14> particleRewriter = new ParticleRewriter<ClientboundPackets1_14>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_14> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_14>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_14> tagRewriter = new TagRewriter<ClientboundPackets1_14>(this);

    public Protocol1_14To1_13_2() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_13.class, ServerboundPackets1_14.class, ServerboundPackets1_13.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        new CommandRewriter1_14(this).registerDeclareCommands(ClientboundPackets1_14.COMMANDS);
        new PlayerPacketRewriter1_14(this).register();
        new SoundPacketRewriter1_14(this).register();
        this.cancelClientbound(ClientboundPackets1_14.SET_CHUNK_CACHE_CENTER);
        this.cancelClientbound(ClientboundPackets1_14.SET_CHUNK_CACHE_RADIUS);
        this.registerClientbound(ClientboundPackets1_14.UPDATE_TAGS, packetWrapper -> {
            this.tagRewriter.handle(packetWrapper, RegistryType.BLOCK);
            this.tagRewriter.handle(packetWrapper, RegistryType.ITEM);
            this.tagRewriter.handle(packetWrapper, RegistryType.FLUID);
            int n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.read(Types.STRING);
                packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            }
        });
        this.registerClientbound(ClientboundPackets1_14.LIGHT_UPDATE, null, (PacketWrapper packetWrapper) -> {
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            int n3 = packetWrapper.read(Types.VAR_INT);
            int n4 = packetWrapper.read(Types.VAR_INT);
            int n5 = packetWrapper.read(Types.VAR_INT);
            int n6 = packetWrapper.read(Types.VAR_INT);
            byte[][] byArrayArray = new byte[16][];
            if (Protocol1_14To1_13_2.isSet(n3, 0)) {
                packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
            for (int i = 0; i < 16; ++i) {
                if (Protocol1_14To1_13_2.isSet(n3, i + 1)) {
                    byArrayArray[i] = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    continue;
                }
                if (!Protocol1_14To1_13_2.isSet(n5, i + 1)) continue;
                byArrayArray[i] = ChunkLightStorage.EMPTY_LIGHT;
            }
            if (Protocol1_14To1_13_2.isSet(n3, 17)) {
                packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
            byte[][] byArrayArray2 = new byte[16][];
            if (Protocol1_14To1_13_2.isSet(n4, 0)) {
                packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
            for (int i = 0; i < 16; ++i) {
                if (Protocol1_14To1_13_2.isSet(n4, i + 1)) {
                    byArrayArray2[i] = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    continue;
                }
                if (!Protocol1_14To1_13_2.isSet(n6, i + 1)) continue;
                byArrayArray2[i] = ChunkLightStorage.EMPTY_LIGHT;
            }
            if (Protocol1_14To1_13_2.isSet(n4, 17)) {
                packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
            packetWrapper.user().get(ChunkLightStorage.class).setStoredLight(byArrayArray, byArrayArray2, n, n2);
            packetWrapper.cancel();
        });
    }

    private static boolean isSet(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_14.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        if (!userConnection.has(ChunkLightStorage.class)) {
            userConnection.put(new ChunkLightStorage());
        }
        userConnection.put(new DifficultyStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_14 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_14 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_14> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_14> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_14> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_14> getTagRewriter() {
        return this.tagRewriter;
    }
}

