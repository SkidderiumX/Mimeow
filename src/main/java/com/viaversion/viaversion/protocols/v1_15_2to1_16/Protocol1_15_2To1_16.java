/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_15_2to1_16;

import com.google.common.base.Joiner;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ClientboundStatusPackets;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.provider.PlayerAbilitiesProvider;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.ComponentRewriter1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.EntityPacketRewriter1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.ItemPacketRewriter1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter.WorldPacketRewriter1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.storage.InventoryTracker1_16;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.GsonUtil;
import com.viaversion.viaversion.util.Key;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.UUID;

public class Protocol1_15_2To1_16
extends AbstractProtocol<ClientboundPackets1_15, ClientboundPackets1_16, ServerboundPackets1_14, ServerboundPackets1_16> {
    private static final UUID ZERO_UUID = new UUID(0L, 0L);
    public static final MappingData MAPPINGS = new MappingDataBase("1.15", "1.16");
    private final EntityPacketRewriter1_16 entityRewriter = new EntityPacketRewriter1_16(this);
    private final ItemPacketRewriter1_16 itemRewriter = new ItemPacketRewriter1_16(this);
    private final ParticleRewriter<ClientboundPackets1_15> particleRewriter = new ParticleRewriter<ClientboundPackets1_15>(this);
    private final ComponentRewriter1_16 componentRewriter = new ComponentRewriter1_16(this);
    private final TagRewriter<ClientboundPackets1_15> tagRewriter = new TagRewriter<ClientboundPackets1_15>(this);
    private final BlockRewriter<ClientboundPackets1_15> blockRewriter = BlockRewriter.for1_14(this);

    public Protocol1_15_2To1_16() {
        super(ClientboundPackets1_15.class, ClientboundPackets1_16.class, ServerboundPackets1_14.class, ServerboundPackets1_16.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_16.register(this);
        this.tagRewriter.register(ClientboundPackets1_15.UPDATE_TAGS, RegistryType.ENTITY);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            UUID uUID = UUID.fromString(packetWrapper.read(Types.STRING));
            packetWrapper.write(Types.UUID, uUID);
        });
        this.registerClientbound(State.STATUS, ClientboundStatusPackets.STATUS_RESPONSE, (PacketWrapper packetWrapper) -> {
            String string = packetWrapper.passthrough(Types.STRING);
            JsonObject jsonObject = GsonUtil.getGson().fromJson(string, JsonObject.class);
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("players");
            if (jsonObject2 == null) {
                return;
            }
            JsonArray jsonArray = jsonObject2.getAsJsonArray("sample");
            if (jsonArray == null) {
                return;
            }
            JsonArray jsonArray2 = new JsonArray();
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject3 = jsonElement.getAsJsonObject();
                String string2 = jsonObject3.getAsJsonPrimitive("name").getAsString();
                if (string2.indexOf(10) == -1) {
                    jsonArray2.add(jsonObject3);
                    continue;
                }
                String string3 = jsonObject3.getAsJsonPrimitive("id").getAsString();
                for (String string4 : string2.split("\n")) {
                    JsonObject jsonObject4 = new JsonObject();
                    jsonObject4.addProperty("name", string4);
                    jsonObject4.addProperty("id", string3);
                    jsonArray2.add(jsonObject4);
                }
            }
            if (jsonArray2.size() != jsonArray.size()) {
                jsonObject2.add("sample", jsonArray2);
                packetWrapper.set(Types.STRING, 0, jsonObject.toString());
            }
        });
        this.replaceClientbound(ClientboundPackets1_15.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.COMPONENT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    Protocol1_15_2To1_16.this.componentRewriter.processText(packetWrapper.user(), packetWrapper.get(Types.COMPONENT, 0));
                    packetWrapper.write(Types.UUID, ZERO_UUID);
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_16.INTERACT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0 || n == 2) {
                if (n == 2) {
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.VAR_INT);
            }
            packetWrapper.read(Types.BOOLEAN);
        });
        if (Via.getConfig().isIgnoreLong1_16ChannelNames()) {
            this.registerServerbound(ServerboundPackets1_16.CUSTOM_PAYLOAD, new PacketHandlers(){

                @Override
                public void register() {
                    this.map(Types.STRING);
                    this.handler(packetWrapper -> {
                        String string = packetWrapper.get(Types.STRING, 0);
                        String string2 = Key.namespaced(string);
                        if (string.length() > 32) {
                            if (Via.getManager().isDebug()) {
                                Protocol1_15_2To1_16.this.getLogger().warning("Ignoring serverbound plugin channel, as it is longer than 32 characters: " + string);
                            }
                            packetWrapper.cancel();
                        } else if (string2.equals("minecraft:register") || string2.equals("minecraft:unregister")) {
                            String[] stringArray = new String(packetWrapper.read(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA), StandardCharsets.UTF_8).split("\u0000");
                            ArrayList<String> arrayList = new ArrayList<String>(stringArray.length);
                            for (String string3 : stringArray) {
                                if (string3.length() > 32) {
                                    if (!Via.getManager().isDebug()) continue;
                                    Protocol1_15_2To1_16.this.getLogger().warning("Ignoring serverbound plugin channel register of '" + string3 + "', as it is longer than 32 characters");
                                    continue;
                                }
                                arrayList.add(string3);
                            }
                            if (arrayList.isEmpty()) {
                                packetWrapper.cancel();
                                return;
                            }
                            packetWrapper.write(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA, Joiner.on('\u0000').join(arrayList).getBytes(StandardCharsets.UTF_8));
                        }
                    });
                }
            });
        }
        this.registerServerbound(ServerboundPackets1_16.PLAYER_ABILITIES, packetWrapper -> {
            packetWrapper.passthrough(Types.BYTE);
            PlayerAbilitiesProvider playerAbilitiesProvider = Via.getManager().getProviders().get(PlayerAbilitiesProvider.class);
            packetWrapper.write(Types.FLOAT, Float.valueOf(playerAbilitiesProvider.getFlyingSpeed(packetWrapper.user())));
            packetWrapper.write(Types.FLOAT, Float.valueOf(playerAbilitiesProvider.getWalkingSpeed(packetWrapper.user())));
        });
        this.cancelServerbound(ServerboundPackets1_16.JIGSAW_GENERATE);
        this.cancelServerbound(ServerboundPackets1_16.SET_JIGSAW_BLOCK);
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_16.initialize(this);
        ParticleType.Fillers.fill1_13_2(this, Types1_16.PARTICLE, true);
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:crimson_stems", "minecraft:non_flammable_wood", "minecraft:piglin_loved", "minecraft:piglin_repellents", "minecraft:soul_fire_base_blocks", "minecraft:warped_stems");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:crimson_stems", "minecraft:guarded_by_piglins", "minecraft:hoglin_repellents", "minecraft:non_flammable_wood", "minecraft:nylium", "minecraft:piglin_repellents", "minecraft:soul_fire_base_blocks", "minecraft:soul_speed_blocks", "minecraft:strider_warm_blocks", "minecraft:warped_stems");
        super.onMappingDataLoaded();
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(PlayerAbilitiesProvider.class, new PlayerAbilitiesProvider());
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_16.PLAYER));
        userConnection.put(new InventoryTracker1_16());
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_16 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_16 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_15> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_15> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_16 getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_15> getTagRewriter() {
        return this.tagRewriter;
    }
}

