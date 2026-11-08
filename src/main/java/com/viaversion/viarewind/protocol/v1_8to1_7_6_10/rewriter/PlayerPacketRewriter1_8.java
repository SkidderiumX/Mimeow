/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.minecraft.math.AABB;
import com.viaversion.viarewind.api.minecraft.math.Ray3d;
import com.viaversion.viarewind.api.minecraft.math.RayTracing;
import com.viaversion.viarewind.api.minecraft.math.Vector3d;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.ChatItemRewriter;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.ChatNewlineRewriter;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.VirtualHologramEntity;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.TitleRenderProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.GameProfileStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.InventoryTracker;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.utils.ChatUtil;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.util.ComponentUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PlayerPacketRewriter1_8
extends RewriterBase<Protocol1_8To1_7_6_10> {
    public PlayerPacketRewriter1_8(Protocol1_8To1_7_6_10 protocol1_8To1_7_6_10) {
        super(protocol1_8To1_7_6_10);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.COMPONENT);
                this.handler(packetWrapper -> {
                    JsonElement jsonElement = packetWrapper.get(Types.COMPONENT, 0);
                    byte by = packetWrapper.read(Types.BYTE);
                    if (by == 2) {
                        packetWrapper.cancel();
                        return;
                    }
                    ChatItemRewriter.toClient((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol, packetWrapper.user(), jsonElement);
                    List<JsonObject> list = ChatNewlineRewriter.splitChatComponentByNewline(jsonElement);
                    if (list.size() > 1) {
                        packetWrapper.cancel();
                        for (JsonObject jsonObject : list) {
                            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_7_2_5.CHAT);
                            packetWrapper2.write(Types.COMPONENT, jsonObject);
                            packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                        }
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.INT_POSITION);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_HEALTH, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.VAR_INT, Types.SHORT);
                this.map(Types.FLOAT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    if (ViaRewind.getConfig().isReplaceAdventureMode() && packetWrapper.get(Types.UNSIGNED_BYTE, 1) == 2) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 1, (short)0);
                    }
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    entityTracker1_8.setClientEntityGameMode(packetWrapper.get(Types.UNSIGNED_BYTE, 1).shortValue());
                    int n = packetWrapper.get(Types.INT, 0);
                    Object t = packetWrapper.user().getClientWorld(Protocol1_8To1_7_6_10.class);
                    if (((ClientWorld)t).setEnvironment(n)) {
                        entityTracker1_8.clearEntities();
                        entityTracker1_8.addPlayer(entityTracker1_8.clientEntityId(), packetWrapper.user().getProtocolInfo().getUuid());
                    }
                    packetWrapper.send(Protocol1_8To1_7_6_10.class);
                    packetWrapper.cancel();
                    if (entityTracker1_8.getEntityData().isEmpty()) {
                        return;
                    }
                    ArrayList<EntityData> arrayList = new ArrayList<EntityData>(entityTracker1_8.getEntityData());
                    arrayList.removeIf(entityData -> entityData.id() == 6);
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_DATA, packetWrapper.user());
                    packetWrapper2.write(Types.INT, entityTracker1_8.clientEntityId());
                    packetWrapper2.write(RewindTypes.ENTITY_DATA_LIST1_7, arrayList);
                    packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    double d = packetWrapper.get(Types.DOUBLE, 0);
                    double d2 = packetWrapper.get(Types.DOUBLE, 1);
                    double d3 = packetWrapper.get(Types.DOUBLE, 2);
                    float f = packetWrapper.get(Types.FLOAT, 0).floatValue();
                    float f2 = packetWrapper.get(Types.FLOAT, 1).floatValue();
                    PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
                    byte by = packetWrapper.read(Types.BYTE);
                    if ((by & 1) == 1) {
                        packetWrapper.set(Types.DOUBLE, 0, d + playerSessionStorage.getPosX());
                    }
                    if ((by & 2) == 2) {
                        d2 += playerSessionStorage.getPosY();
                    }
                    playerSessionStorage.receivedPosY = d2;
                    packetWrapper.set(Types.DOUBLE, 1, d2 + (double)1.62f);
                    if ((by & 4) == 4) {
                        packetWrapper.set(Types.DOUBLE, 2, d3 + playerSessionStorage.getPosZ());
                    }
                    if ((by & 8) == 8) {
                        packetWrapper.set(Types.FLOAT, 0, Float.valueOf(f + playerSessionStorage.yaw));
                    }
                    if ((by & 0x10) == 16) {
                        packetWrapper.set(Types.FLOAT, 1, Float.valueOf(f2 + playerSessionStorage.pitch));
                    }
                    packetWrapper.write(Types.BOOLEAN, playerSessionStorage.onGround);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (!Objects.equals(entityTracker1_8.spectatingClientEntityId, entityTracker1_8.clientEntityIdOrNull())) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_EXPERIENCE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.VAR_INT, Types.SHORT);
                this.map(Types.VAR_INT, Types.SHORT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.GAME_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) != 3) {
                        return;
                    }
                    int n = packetWrapper.get(Types.FLOAT, 0).intValue();
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (n == 3 || entityTracker1_8.isSpectator()) {
                        UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                        Item[] itemArray = new Item[4];
                        if (n == 3) {
                            GameProfileStorage.GameProfile gameProfile = packetWrapper.user().get(GameProfileStorage.class).get(uUID);
                            itemArray[3] = gameProfile == null ? null : gameProfile.getSkull();
                        } else {
                            for (int i = 0; i < itemArray.length; ++i) {
                                itemArray[i] = packetWrapper.user().get(PlayerSessionStorage.class).getPlayerEquipment(uUID, i);
                            }
                        }
                        for (int i = 0; i < itemArray.length; ++i) {
                            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.CONTAINER_SET_SLOT, packetWrapper.user());
                            packetWrapper2.write(Types.BYTE, (byte)0);
                            packetWrapper2.write(Types.SHORT, (short)(8 - i));
                            packetWrapper2.write(RewindTypes.COMPRESSED_NBT_ITEM, itemArray[i]);
                            packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                        }
                    }
                    if (n == 2 && ViaRewind.getConfig().isReplaceAdventureMode()) {
                        n = 0;
                        packetWrapper.set(Types.FLOAT, 0, Float.valueOf(0.0f));
                    }
                    entityTracker1_8.setClientEntityGameMode(n);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.OPEN_SIGN_EDITOR, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.INT_POSITION);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.PLAYER_INFO, packetWrapper -> {
            packetWrapper.cancel();
            GameProfileStorage gameProfileStorage = packetWrapper.user().get(GameProfileStorage.class);
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                Object object;
                Item[] itemArray;
                Object object2;
                Object object3;
                UUID uUID = packetWrapper.read(Types.UUID);
                if (n == 0) {
                    object3 = packetWrapper.read(Types.STRING);
                    object2 = packetWrapper.read(Types.PROFILE_PROPERTY_ARRAY);
                    int n3 = packetWrapper.read(Types.VAR_INT);
                    int n4 = packetWrapper.read(Types.VAR_INT);
                    JsonElement jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    itemArray = jsonElement != null ? ChatUtil.jsonToLegacy(jsonElement) : null;
                    GameProfileStorage.GameProfile gameProfile = gameProfileStorage.put(uUID, (String)object3, (String)itemArray, n4, n3);
                    for (Object object4 : object2) {
                        gameProfile.properties.add(new GameProfileStorage.Property(((GameProfile.Property)object4).name(), ((GameProfile.Property)object4).value(), ((GameProfile.Property)object4).signature()));
                    }
                    object = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_INFO, packetWrapper.user());
                    object.write(Types.STRING, gameProfile.getLegacyDisplayName());
                    object.write(Types.BOOLEAN, true);
                    object.write(Types.SHORT, (short)n4);
                    object.scheduleSend(Protocol1_8To1_7_6_10.class);
                    continue;
                }
                if (n == 1) {
                    int n5 = packetWrapper.read(Types.VAR_INT);
                    object2 = gameProfileStorage.get(uUID);
                    if (object2 == null || ((GameProfileStorage.GameProfile)object2).gamemode == n5) continue;
                    if (n5 == 3 || ((GameProfileStorage.GameProfile)object2).gamemode == 3) {
                        boolean bl;
                        EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                        int n6 = entityTracker1_8.getPlayerEntityId(uUID);
                        boolean bl2 = bl = n6 == entityTracker1_8.clientEntityId();
                        if (n6 != -1) {
                            itemArray = new Item[bl ? 4 : 5];
                            if (n5 == 3) {
                                itemArray[bl ? 3 : 4] = ((GameProfileStorage.GameProfile)object2).getSkull();
                            } else {
                                for (int j = 0; j < itemArray.length; ++j) {
                                    itemArray[j] = packetWrapper.user().get(PlayerSessionStorage.class).getPlayerEquipment(uUID, j);
                                }
                            }
                            for (short s = 0; s < itemArray.length; s = (short)(s + 1)) {
                                object = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_EQUIPPED_ITEM, packetWrapper.user());
                                object.write(Types.INT, n6);
                                object.write(Types.SHORT, s);
                                object.write(RewindTypes.COMPRESSED_NBT_ITEM, itemArray[s]);
                                object.scheduleSend(Protocol1_8To1_7_6_10.class);
                            }
                        }
                    }
                    ((GameProfileStorage.GameProfile)object2).gamemode = n5;
                    continue;
                }
                if (n == 2) {
                    int n7 = packetWrapper.read(Types.VAR_INT);
                    object2 = gameProfileStorage.get(uUID);
                    if (object2 == null || ((GameProfileStorage.GameProfile)object2).ping == n7) continue;
                    ((GameProfileStorage.GameProfile)object2).ping = n7;
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_INFO, packetWrapper.user());
                    packetWrapper2.write(Types.STRING, ((GameProfileStorage.GameProfile)object2).getLegacyDisplayName());
                    packetWrapper2.write(Types.BOOLEAN, true);
                    packetWrapper2.write(Types.SHORT, (short)n7);
                    packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                    continue;
                }
                if (n == 3) {
                    String string;
                    object3 = gameProfileStorage.get(uUID);
                    if (object3 == null) continue;
                    object2 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    String string2 = string = object2 != null ? ChatUtil.jsonToLegacy((JsonElement)object2) : null;
                    if (Objects.equals(((GameProfileStorage.GameProfile)object3).displayName, string)) continue;
                    PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_INFO, packetWrapper.user());
                    packetWrapper3.write(Types.STRING, ((GameProfileStorage.GameProfile)object3).getLegacyDisplayName());
                    packetWrapper3.write(Types.BOOLEAN, false);
                    packetWrapper3.write(Types.SHORT, (short)0);
                    packetWrapper3.scheduleSend(Protocol1_8To1_7_6_10.class);
                    ((GameProfileStorage.GameProfile)object3).setDisplayName(string);
                    packetWrapper3 = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_INFO, packetWrapper.user());
                    packetWrapper3.write(Types.STRING, ((GameProfileStorage.GameProfile)object3).getLegacyDisplayName());
                    packetWrapper3.write(Types.BOOLEAN, true);
                    packetWrapper3.write(Types.SHORT, (short)((GameProfileStorage.GameProfile)object3).ping);
                    packetWrapper3.scheduleSend(Protocol1_8To1_7_6_10.class);
                    continue;
                }
                if (n != 4 || (object3 = gameProfileStorage.remove(uUID)) == null) continue;
                object2 = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_INFO, packetWrapper.user());
                object2.write(Types.STRING, ((GameProfileStorage.GameProfile)object3).getLegacyDisplayName());
                object2.write(Types.BOOLEAN, false);
                object2.write(Types.SHORT, (short)0);
                object2.scheduleSend(Protocol1_8To1_7_6_10.class);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.PLAYER_ABILITIES, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
            playerSessionStorage.invincible = (by & 8) == 8;
            playerSessionStorage.allowFly = (by & 4) == 4;
            playerSessionStorage.flying = (by & 2) == 2;
            playerSessionStorage.creative = (by & 1) == 1;
            playerSessionStorage.flySpeed = f;
            playerSessionStorage.walkSpeed = f2;
            if (playerSessionStorage.sprinting && playerSessionStorage.flying) {
                packetWrapper.set(Types.FLOAT, 0, Float.valueOf(playerSessionStorage.flySpeed * 2.0f));
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    packetWrapper.cancel();
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|TrList")) {
                        packetWrapper.passthrough(Types.INT);
                        int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                        for (int i = 0; i < n; ++i) {
                            Item item = ((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_8));
                            packetWrapper.write(RewindTypes.COMPRESSED_NBT_ITEM, item);
                            item = ((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_8));
                            packetWrapper.write(RewindTypes.COMPRESSED_NBT_ITEM, item);
                            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
                            if (bl) {
                                item = ((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_8));
                                packetWrapper.write(RewindTypes.COMPRESSED_NBT_ITEM, item);
                            }
                            packetWrapper.passthrough(Types.BOOLEAN);
                            packetWrapper.read(Types.INT);
                            packetWrapper.read(Types.INT);
                        }
                    } else if (string.equals("MC|Brand")) {
                        packetWrapper.write(Types.REMAINING_BYTES, packetWrapper.read(Types.STRING).getBytes(StandardCharsets.UTF_8));
                    }
                    packetWrapper.setPacketType(null);
                    ByteBuf byteBuf = Unpooled.buffer();
                    packetWrapper.writeToBuffer(byteBuf);
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.CUSTOM_PAYLOAD, byteBuf, packetWrapper.user());
                    packetWrapper2.passthrough(Types.STRING);
                    if (byteBuf.readableBytes() <= Short.MAX_VALUE) {
                        packetWrapper2.write(Types.SHORT, (short)byteBuf.readableBytes());
                        packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_CAMERA, null, packetWrapper -> {
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.VAR_INT);
            EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
            if (entityTracker1_8.spectatingClientEntityId != n) {
                entityTracker1_8.setSpectating(n);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_TITLES, null, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.cancel();
                    int n = packetWrapper.read(Types.VAR_INT);
                    TitleRenderProvider titleRenderProvider = Via.getManager().getProviders().get(TitleRenderProvider.class);
                    if (titleRenderProvider == null) {
                        return;
                    }
                    UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                    switch (n) {
                        case 0: {
                            titleRenderProvider.setTitle(uUID, packetWrapper.read(Types.STRING));
                            break;
                        }
                        case 1: {
                            titleRenderProvider.setSubTitle(uUID, packetWrapper.read(Types.STRING));
                            break;
                        }
                        case 2: {
                            titleRenderProvider.setTimings(uUID, packetWrapper.read(Types.INT), packetWrapper.read(Types.INT), packetWrapper.read(Types.INT));
                            break;
                        }
                        case 3: {
                            titleRenderProvider.clear(uUID);
                            break;
                        }
                        case 4: {
                            titleRenderProvider.reset(uUID);
                        }
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).cancelClientbound(ClientboundPackets1_8.TAB_LIST);
        ((Protocol1_8To1_7_6_10)this.protocol).cancelClientbound(ClientboundPackets1_8.PLAYER_COMBAT);
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.RESOURCE_PACK, ClientboundPackets1_7_2_5.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.create(Types.STRING, "MC|RPack");
                this.handler(packetWrapper -> {
                    ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
                    try {
                        Types.STRING.write(byteBuf, packetWrapper.read(Types.STRING));
                        packetWrapper.write(Types.SHORT_BYTE_ARRAY, (byte[])Types.REMAINING_BYTES.read(byteBuf));
                    }
                    finally {
                        byteBuf.release();
                    }
                });
                this.read(Types.STRING);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.CHAT, packetWrapper -> {
            String string = packetWrapper.passthrough(Types.STRING);
            EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
            if (entityTracker1_8.isSpectator() && string.toLowerCase().startsWith("/stp ")) {
                String string2 = string.split(" ")[1];
                GameProfileStorage gameProfileStorage = packetWrapper.user().get(GameProfileStorage.class);
                List<GameProfileStorage.GameProfile> list = gameProfileStorage.get(string2, true);
                if (list.isEmpty()) {
                    return;
                }
                GameProfileStorage.GameProfile gameProfile = list.get(0);
                if (gameProfile != null && gameProfile.uuid != null) {
                    packetWrapper.cancel();
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.TELEPORT_ENTITY, packetWrapper.user());
                    packetWrapper2.write(Types.UUID, gameProfile.uuid);
                    packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                }
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.INTERACT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT, Types.VAR_INT);
                this.map(Types.BYTE, Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    int n2 = entityTracker1_8.getHologramIdWithExtra(packetWrapper.get(Types.VAR_INT, 0));
                    PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
                    if (n2 == -1) {
                        return;
                    }
                    packetWrapper.set(Types.VAR_INT, 0, n2);
                    if (n != 0) {
                        return;
                    }
                    AABB aABB = ((VirtualHologramEntity)entityTracker1_8.getHolograms().get(n2)).getBoundingBox();
                    Vector3d vector3d = new Vector3d(playerSessionStorage.getPosX(), playerSessionStorage.getPosY() + 1.8, playerSessionStorage.getPosZ());
                    double d = Math.toRadians(playerSessionStorage.yaw);
                    double d2 = Math.toRadians(playerSessionStorage.pitch);
                    Vector3d vector3d2 = new Vector3d(-Math.cos(d2) * Math.sin(d), -Math.sin(d2), Math.cos(d2) * Math.cos(d));
                    Ray3d ray3d = new Ray3d(vector3d, vector3d2);
                    Vector3d vector3d3 = RayTracing.trace(ray3d, aABB, 5.0);
                    if (vector3d3 == null) {
                        return;
                    }
                    vector3d3.substract(aABB.getMin());
                    packetWrapper.set(Types.VAR_INT, 1, 2);
                    packetWrapper.write(Types.FLOAT, Float.valueOf((float)vector3d3.getX()));
                    packetWrapper.write(Types.FLOAT, Float.valueOf((float)vector3d3.getY()));
                    packetWrapper.write(Types.FLOAT, Float.valueOf((float)vector3d3.getZ()));
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.MOVE_PLAYER_STATUS_ONLY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    packetWrapper.user().get(PlayerSessionStorage.class).onGround = packetWrapper.get(Types.BOOLEAN, 0);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.MOVE_PLAYER_POS, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.read(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
            playerSessionStorage.onGround = packetWrapper.passthrough(Types.BOOLEAN);
            playerSessionStorage.setPos(d, d2, d3);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.MOVE_PLAYER_ROT, packetWrapper -> {
            PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
            playerSessionStorage.yaw = packetWrapper.passthrough(Types.FLOAT).floatValue();
            playerSessionStorage.pitch = packetWrapper.passthrough(Types.FLOAT).floatValue();
            playerSessionStorage.onGround = packetWrapper.passthrough(Types.BOOLEAN);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.read(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
            playerSessionStorage.setPos(d, d2, d3);
            playerSessionStorage.yaw = packetWrapper.passthrough(Types.FLOAT).floatValue();
            playerSessionStorage.pitch = packetWrapper.passthrough(Types.FLOAT).floatValue();
            playerSessionStorage.onGround = packetWrapper.passthrough(Types.BOOLEAN);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.PLAYER_ACTION, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.VAR_INT);
                this.map(RewindTypes.U_BYTE_POSITION, Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    if (s > 5) {
                        s = 0;
                    }
                    packetWrapper.write(Types.UNSIGNED_BYTE, s);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.USE_ITEM_ON, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(RewindTypes.U_BYTE_POSITION, Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE);
                this.map(RewindTypes.COMPRESSED_NBT_ITEM, Types.ITEM1_8);
                this.handler(packetWrapper -> ((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToServer(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.SWING, packetWrapper -> {
            int n = packetWrapper.read(Types.INT);
            int n2 = packetWrapper.read(Types.BYTE).byteValue();
            if (n2 == 1) {
                return;
            }
            packetWrapper.cancel();
            switch (n2) {
                case 104: {
                    n2 = 0;
                    break;
                }
                case 105: {
                    n2 = 1;
                    break;
                }
                case 3: {
                    n2 = 2;
                    break;
                }
                default: {
                    return;
                }
            }
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.ANIMATE, packetWrapper.user());
            packetWrapper2.write(Types.VAR_INT, n);
            packetWrapper2.write(Types.VAR_INT, n2);
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.send(Protocol1_8To1_7_6_10.class);
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.PLAYER_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT, Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.BYTE) - 1));
                this.map(Types.INT, Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 3 || n == 4) {
                        PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
                        playerSessionStorage.sprinting = n == 3;
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.PLAYER_ABILITIES, packetWrapper.user());
                        packetWrapper2.write(Types.BYTE, playerSessionStorage.combineAbilities());
                        packetWrapper2.write(Types.FLOAT, Float.valueOf(playerSessionStorage.sprinting ? playerSessionStorage.flySpeed * 2.0f : playerSessionStorage.flySpeed));
                        packetWrapper2.write(Types.FLOAT, Float.valueOf(playerSessionStorage.walkSpeed));
                        packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.PLAYER_INPUT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    boolean bl2 = packetWrapper.read(Types.BOOLEAN);
                    byte by = 0;
                    if (bl) {
                        by = (byte)(by + 1);
                    }
                    if (bl2) {
                        by = (byte)(by + 2);
                    }
                    packetWrapper.write(Types.BYTE, by);
                    if (!bl2) {
                        return;
                    }
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (entityTracker1_8.spectatingClientEntityId.intValue() != entityTracker1_8.clientEntityId()) {
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_8.PLAYER_COMMAND, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, entityTracker1_8.clientEntityId());
                        packetWrapper2.write(Types.VAR_INT, 0);
                        packetWrapper2.write(Types.VAR_INT, 0);
                        packetWrapper2.scheduleSendToServer(Protocol1_8To1_7_6_10.class);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.SIGN_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(RewindTypes.SHORT_POSITION, Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 4; ++i) {
                        String string = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.legacyToJson(string));
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.PLAYER_ABILITIES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    PlayerSessionStorage playerSessionStorage = packetWrapper.user().get(PlayerSessionStorage.class);
                    if (playerSessionStorage.allowFly) {
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        playerSessionStorage.flying = (by & 2) == 2;
                    }
                    packetWrapper.set(Types.FLOAT, 0, Float.valueOf(playerSessionStorage.flySpeed));
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.COMMAND_SUGGESTION, packetWrapper -> {
            String string = packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.OPTIONAL_POSITION1_8, null);
            if (string.toLowerCase().startsWith("/stp ")) {
                packetWrapper.cancel();
                String[] stringArray = string.split(" ");
                if (stringArray.length <= 2) {
                    String string2 = stringArray.length == 1 ? "" : stringArray[1];
                    GameProfileStorage gameProfileStorage = packetWrapper.user().get(GameProfileStorage.class);
                    List<GameProfileStorage.GameProfile> list = gameProfileStorage.getAllWithPrefix(string2, true);
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.COMMAND_SUGGESTIONS, packetWrapper.user());
                    packetWrapper2.write(Types.VAR_INT, list.size());
                    for (GameProfileStorage.GameProfile gameProfile : list) {
                        packetWrapper2.write(Types.STRING, gameProfile.name);
                    }
                    packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                }
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.read(Types.BYTE);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.write(Types.UNSIGNED_BYTE, (short)(bl ? 127 : 126));
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerServerbound(ServerboundPackets1_7_2_5.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.read(Types.SHORT);
                this.handler(packetWrapper -> {
                    String string;
                    switch (string = packetWrapper.get(Types.STRING, 0)) {
                        case "MC|TrSel": {
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.read(Types.REMAINING_BYTES);
                            break;
                        }
                        case "MC|AdvCdm": {
                            byte by = packetWrapper.passthrough(Types.BYTE);
                            if (by == 0) {
                                packetWrapper.passthrough(Types.INT);
                                packetWrapper.passthrough(Types.INT);
                                packetWrapper.passthrough(Types.INT);
                            } else if (by == 1) {
                                packetWrapper.passthrough(Types.INT);
                            }
                            packetWrapper.passthrough(Types.STRING);
                            packetWrapper.write(Types.BOOLEAN, true);
                            packetWrapper.read(Types.REMAINING_BYTES);
                            break;
                        }
                        case "MC|Beacon": {
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.passthrough(Types.INT);
                            packetWrapper.read(Types.REMAINING_BYTES);
                            break;
                        }
                        case "MC|ItemName": {
                            byte[] byArray = packetWrapper.read(Types.REMAINING_BYTES);
                            packetWrapper.write(Types.STRING, new String(byArray, StandardCharsets.UTF_8));
                            InventoryTracker inventoryTracker = packetWrapper.user().get(InventoryTracker.class);
                            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.CONTAINER_SET_DATA, packetWrapper.user());
                            packetWrapper2.write(Types.UNSIGNED_BYTE, inventoryTracker.anvilId);
                            packetWrapper2.write(Types.SHORT, (short)0);
                            packetWrapper2.write(Types.SHORT, inventoryTracker.levelCost);
                            packetWrapper2.send(Protocol1_8To1_7_6_10.class);
                            break;
                        }
                        case "MC|BEdit": 
                        case "MC|BSign": {
                            ListTag<StringTag> listTag;
                            boolean bl = string.equals("MC|BSign");
                            Item item = packetWrapper.read(RewindTypes.COMPRESSED_NBT_ITEM);
                            packetWrapper.read(Types.REMAINING_BYTES);
                            if (item == null) {
                                packetWrapper.write(Types.ITEM1_8, null);
                                break;
                            }
                            CompoundTag compoundTag = item.tag();
                            if (bl && compoundTag != null && compoundTag.contains("pages") && (listTag = compoundTag.getListTag("pages", StringTag.class)) != null) {
                                for (int i = 0; i < listTag.size(); ++i) {
                                    StringTag stringTag = listTag.get(i);
                                    String string2 = stringTag.getValue();
                                    string2 = new JsonPrimitive(string2).toString();
                                    stringTag.setValue(string2);
                                }
                            }
                            ((Protocol1_8To1_7_6_10)PlayerPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToServer(packetWrapper.user(), item);
                            packetWrapper.write(Types.ITEM1_8, item);
                            break;
                        }
                        case "MC|Brand": {
                            packetWrapper.write(Types.STRING, new String(packetWrapper.read(Types.REMAINING_BYTES), StandardCharsets.UTF_8));
                        }
                    }
                });
            }
        });
    }
}

