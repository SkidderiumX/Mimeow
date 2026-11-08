/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.Protocol1_19_3To1_19_1;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.storage.ChatTypeStorage1_19_3;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_3;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.util.TagUtil;
import java.util.BitSet;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityPacketRewriter1_19_3
extends EntityRewriter<ClientboundPackets1_19_3, Protocol1_19_3To1_19_1> {
    private static final int[] PROFILE_ACTIONS = new int[]{2, 3, 4, 5};
    private static final int ADD_PLAYER = 0;
    private static final int INITIALIZE_CHAT = 1;
    private static final int UPDATE_GAMEMODE = 2;
    private static final int UPDATE_LISTED = 3;
    private static final int UPDATE_LATENCY = 4;
    private static final int UPDATE_DISPLAYNAME = 5;

    public EntityPacketRewriter1_19_3(Protocol1_19_3To1_19_1 protocol1_19_3To1_19_1) {
        super(protocol1_19_3To1_19_1, Types1_19.ENTITY_DATA_TYPES.optionalComponentType, Types1_19.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    protected void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_19_3.SET_ENTITY_DATA, Types1_19_3.ENTITY_DATA_LIST, Types1_19.ENTITY_DATA_LIST);
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_3.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_19_3.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> {
                    ChatTypeStorage1_19_3 chatTypeStorage1_19_3 = packetWrapper.user().get(ChatTypeStorage1_19_3.class);
                    chatTypeStorage1_19_3.clear();
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "chat_type", new ListTag<CompoundTag>(CompoundTag.class));
                    for (CompoundTag compoundTag2 : listTag) {
                        NumberTag numberTag = compoundTag2.getNumberTag("id");
                        chatTypeStorage1_19_3.addChatType(numberTag.asInt(), compoundTag2);
                    }
                });
                this.handler(packetWrapper -> {
                    ChatSession1_19_3 chatSession1_19_3 = packetWrapper.user().get(ChatSession1_19_3.class);
                    if (chatSession1_19_3 != null) {
                        PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_19_3.CHAT_SESSION_UPDATE);
                        packetWrapper2.write(Types.UUID, chatSession1_19_3.getSessionId());
                        packetWrapper2.write(Types.PROFILE_KEY, chatSession1_19_3.getProfileKey());
                        packetWrapper2.sendToServer(Protocol1_19_3To1_19_1.class);
                    }
                });
            }
        });
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.write(Types.BOOLEAN, (by & 1) != 0);
                });
            }
        });
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.PLAYER_INFO_UPDATE, ClientboundPackets1_19_1.PLAYER_INFO, packetWrapper -> {
            packetWrapper.cancel();
            BitSet bitSet = packetWrapper.read(Types.PROFILE_ACTIONS_ENUM1_19_3);
            int n = packetWrapper.read(Types.VAR_INT);
            if (bitSet.get(0)) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19_1.PLAYER_INFO);
                packetWrapper2.write(Types.VAR_INT, 0);
                packetWrapper2.write(Types.VAR_INT, n);
                for (int i = 0; i < n; ++i) {
                    int n2;
                    ProfileKey profileKey;
                    packetWrapper2.write(Types.UUID, packetWrapper.read(Types.UUID));
                    packetWrapper2.write(Types.STRING, packetWrapper.read(Types.STRING));
                    packetWrapper2.write(Types.PROFILE_PROPERTY_ARRAY, packetWrapper.read(Types.PROFILE_PROPERTY_ARRAY));
                    if (bitSet.get(1) && packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        packetWrapper.read(Types.UUID);
                        profileKey = packetWrapper.read(Types.PROFILE_KEY);
                    } else {
                        profileKey = null;
                    }
                    int n3 = n2 = bitSet.get(2) ? packetWrapper.read(Types.VAR_INT) : 0;
                    if (bitSet.get(3)) {
                        packetWrapper.read(Types.BOOLEAN);
                    }
                    int n4 = bitSet.get(4) ? packetWrapper.read(Types.VAR_INT) : 0;
                    JsonElement jsonElement = bitSet.get(5) ? packetWrapper.read(Types.OPTIONAL_COMPONENT) : null;
                    packetWrapper2.write(Types.VAR_INT, n2);
                    packetWrapper2.write(Types.VAR_INT, n4);
                    packetWrapper2.write(Types.OPTIONAL_COMPONENT, jsonElement);
                    packetWrapper2.write(Types.OPTIONAL_PROFILE_KEY, profileKey);
                }
                packetWrapper2.send(Protocol1_19_3To1_19_1.class);
                return;
            }
            PlayerProfileUpdate[] playerProfileUpdateArray = new PlayerProfileUpdate[n];
            for (int i = 0; i < n; ++i) {
                UUID uUID = packetWrapper.read(Types.UUID);
                int n5 = 0;
                int n6 = 0;
                JsonElement jsonElement = null;
                block8: for (int n7 : PROFILE_ACTIONS) {
                    if (!bitSet.get(n7)) continue;
                    switch (n7) {
                        case 2: {
                            n5 = packetWrapper.read(Types.VAR_INT);
                            continue block8;
                        }
                        case 3: {
                            packetWrapper.read(Types.BOOLEAN);
                            continue block8;
                        }
                        case 4: {
                            n6 = packetWrapper.read(Types.VAR_INT);
                            continue block8;
                        }
                        case 5: {
                            jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                        }
                    }
                }
                playerProfileUpdateArray[i] = new PlayerProfileUpdate(uUID, n5, n6, jsonElement);
            }
            if (bitSet.get(2)) {
                this.sendPlayerProfileUpdate(packetWrapper.user(), 1, playerProfileUpdateArray);
            } else if (bitSet.get(4)) {
                this.sendPlayerProfileUpdate(packetWrapper.user(), 2, playerProfileUpdateArray);
            } else if (bitSet.get(5)) {
                this.sendPlayerProfileUpdate(packetWrapper.user(), 3, playerProfileUpdateArray);
            }
        });
        ((Protocol1_19_3To1_19_1)this.protocol).registerClientbound(ClientboundPackets1_19_3.PLAYER_INFO_REMOVE, ClientboundPackets1_19_1.PLAYER_INFO, packetWrapper -> {
            UUID[] uUIDArray = packetWrapper.read(Types.UUID_ARRAY);
            packetWrapper.write(Types.VAR_INT, 4);
            packetWrapper.write(Types.VAR_INT, uUIDArray.length);
            for (UUID uUID : uUIDArray) {
                packetWrapper.write(Types.UUID, uUID);
            }
        });
    }

    private void sendPlayerProfileUpdate(UserConnection userConnection, int n, PlayerProfileUpdate[] playerProfileUpdateArray) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_1.PLAYER_INFO, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.VAR_INT, playerProfileUpdateArray.length);
        for (PlayerProfileUpdate playerProfileUpdate : playerProfileUpdateArray) {
            packetWrapper.write(Types.UUID, playerProfileUpdate.uuid());
            if (n == 1) {
                packetWrapper.write(Types.VAR_INT, playerProfileUpdate.gamemode());
                continue;
            }
            if (n == 2) {
                packetWrapper.write(Types.VAR_INT, playerProfileUpdate.latency());
                continue;
            }
            if (n == 3) {
                packetWrapper.write(Types.OPTIONAL_COMPONENT, playerProfileUpdate.displayName());
                continue;
            }
            throw new IllegalArgumentException("Invalid action: " + n);
        }
        packetWrapper.send(Protocol1_19_3To1_19_1.class);
    }

    @Override
    public void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n = entityData.dataType().typeId();
            if (n > 2) {
                entityData.setDataType(Types1_19.ENTITY_DATA_TYPES.byId(n - 1));
            } else if (n != 2) {
                entityData.setDataType(Types1_19.ENTITY_DATA_TYPES.byId(n));
            }
        });
        this.registerEntityDataTypeHandler(Types1_19.ENTITY_DATA_TYPES.itemType, null, Types1_19.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_19.ENTITY_DATA_TYPES.particleType, Types1_19.ENTITY_DATA_TYPES.componentType, Types1_19.ENTITY_DATA_TYPES.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_19_3.ABSTRACT_MINECART, 11);
        this.filter().dataType(Types1_19.ENTITY_DATA_TYPES.poseType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n == 10) {
                entityData.setValue(0);
            } else if (n > 10) {
                entityData.setValue(n - 1);
            }
        });
        this.filter().type(EntityTypes1_19_3.CAMEL).cancel(19);
        this.filter().type(EntityTypes1_19_3.CAMEL).cancel(20);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_19_3.CAMEL, EntityTypes1_19_3.DONKEY).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_3.getTypeFromId(n);
    }

    private record PlayerProfileUpdate(UUID uuid, int gamemode, int latency, @Nullable JsonElement displayName) {
    }
}

