/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_17to1_16_4;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter.BlockItemPacketRewriter1_17;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.rewriter.EntityPacketRewriter1_17;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.storage.PlayerLastCursorItem;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Protocol1_17To1_16_4
extends BackwardsProtocol<ClientboundPackets1_17, ClientboundPackets1_16_2, ServerboundPackets1_17, ServerboundPackets1_16_2> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.17", "1.16.2", Protocol1_16_4To1_17.class);
    private static final RegistryType[] TAG_REGISTRY_TYPES = new RegistryType[]{RegistryType.BLOCK, RegistryType.ITEM, RegistryType.FLUID, RegistryType.ENTITY};
    private static final int[] EMPTY_ARRAY = new int[0];
    private final EntityPacketRewriter1_17 entityRewriter = new EntityPacketRewriter1_17(this);
    private final BlockItemPacketRewriter1_17 blockItemPackets = new BlockItemPacketRewriter1_17(this);
    private final ParticleRewriter<ClientboundPackets1_17> particleRewriter = new ParticleRewriter<ClientboundPackets1_17>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_17> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_17>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_17> tagRewriter = new TagRewriter<ClientboundPackets1_17>(this);
    private final BlockRewriter<ClientboundPackets1_17> blockRewriter = BlockRewriter.for1_14(this);

    public Protocol1_17To1_16_4() {
        super(ClientboundPackets1_17.class, ClientboundPackets1_16_2.class, ServerboundPackets1_17.class, ServerboundPackets1_16_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_17.UPDATE_TAGS, packetWrapper -> {
            Object object;
            Object object2;
            HashMap hashMap = new HashMap();
            int n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
                ArrayList<TagData> arrayList = new ArrayList<TagData>();
                hashMap.put(string, arrayList);
                int n2 = packetWrapper.read(Types.VAR_INT);
                for (int j = 0; j < n2; ++j) {
                    object2 = packetWrapper.read(Types.STRING);
                    object = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                    arrayList.add(new TagData((String)object2, (int[])object));
                }
            }
            for (RegistryType registryType : TAG_REGISTRY_TYPES) {
                List list = (List)hashMap.get(registryType.identifier());
                if (list == null) {
                    packetWrapper.write(Types.VAR_INT, 0);
                    continue;
                }
                object2 = this.tagRewriter.getRewriter(registryType);
                packetWrapper.write(Types.VAR_INT, list.size());
                object = list.iterator();
                while (object.hasNext()) {
                    TagData tagData = (TagData)object.next();
                    int[] nArray = tagData.entries();
                    if (object2 != null) {
                        IntArrayList intArrayList = new IntArrayList(nArray.length);
                        for (int n3 : nArray) {
                            int n4 = object2.rewrite(n3);
                            if (n4 == -1) continue;
                            intArrayList.add(n4);
                        }
                        nArray = intArrayList.toArray(EMPTY_ARRAY);
                    }
                    packetWrapper.write(Types.STRING, tagData.identifier());
                    packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, nArray);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_17.RESOURCE_PACK, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.read(Types.OPTIONAL_COMPONENT);
        });
        this.registerClientbound(ClientboundPackets1_17.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> packetWrapper.write(Types.INT, packetWrapper.read(Types.VAR_INT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_17.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.handler(packetWrapper -> packetWrapper.read(Types.FLOAT));
            }
        });
        this.registerClientbound(ClientboundPackets1_17.PING, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.INT);
            short s = (short)n;
            if (n == s && ViaBackwards.getConfig().handlePingsAsInvAcknowledgements()) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_16_2.CONTAINER_ACK);
                packetWrapper2.write(Types.UNSIGNED_BYTE, (short)0);
                packetWrapper2.write(Types.SHORT, s);
                packetWrapper2.write(Types.BOOLEAN, false);
                packetWrapper2.send(Protocol1_17To1_16_4.class);
                return;
            }
            PacketWrapper packetWrapper3 = packetWrapper.create(ServerboundPackets1_17.PONG);
            packetWrapper3.write(Types.INT, n);
            packetWrapper3.sendToServer(Protocol1_17To1_16_4.class);
        });
        this.registerServerbound(ServerboundPackets1_16_2.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, false));
            }
        });
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_TITLE_TEXT, 0);
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_SUBTITLE_TEXT, 1);
        this.rewriteTitlePacket(ClientboundPackets1_17.SET_ACTION_BAR_TEXT, 2);
        this.mergePacket(ClientboundPackets1_17.SET_TITLES_ANIMATION, ClientboundPackets1_16_2.SET_TITLES, 3);
        this.registerClientbound(ClientboundPackets1_17.CLEAR_TITLES, ClientboundPackets1_16_2.SET_TITLES, (PacketWrapper packetWrapper) -> {
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                packetWrapper.write(Types.VAR_INT, 5);
            } else {
                packetWrapper.write(Types.VAR_INT, 4);
            }
        });
        this.cancelClientbound(ClientboundPackets1_17.ADD_VIBRATION_SIGNAL);
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_17.PLAYER));
        userConnection.put(new PlayerLastCursorItem());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_17> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public void mergePacket(ClientboundPackets1_17 clientboundPackets1_17, ClientboundPackets1_16_2 clientboundPackets1_16_2, int n) {
        this.registerClientbound(clientboundPackets1_17, clientboundPackets1_16_2, (PacketWrapper packetWrapper) -> packetWrapper.write(Types.VAR_INT, n));
    }

    private void rewriteTitlePacket(ClientboundPackets1_17 clientboundPackets1_17, int n) {
        this.registerClientbound(clientboundPackets1_17, ClientboundPackets1_16_2.SET_TITLES, (PacketWrapper packetWrapper) -> {
            packetWrapper.write(Types.VAR_INT, n);
            this.translatableRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
        });
    }

    public EntityPacketRewriter1_17 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_17 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_17> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_17> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_17> getTagRewriter() {
        return this.tagRewriter;
    }
}

