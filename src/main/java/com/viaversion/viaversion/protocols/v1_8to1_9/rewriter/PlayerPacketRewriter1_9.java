/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CommandBlockProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.CompressionProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.MainHandProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.ClientWorld1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.MovementTracker;
import com.viaversion.viaversion.util.ComponentUtil;

public class PlayerPacketRewriter1_9 {
    public static void register(final Protocol1_8To1_9 protocol1_8To1_9) {
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING, Protocol1_8To1_9.STRING_TO_JSON);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    JsonObject jsonObject = (JsonObject)packetWrapper.get(Types.COMPONENT, 0);
                    if (jsonObject.get("translate") != null && jsonObject.get("translate").getAsString().equals("gameMode.changed")) {
                        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        String string = entityTracker1_9.getGameMode().text();
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("text", string);
                        jsonObject2.addProperty("color", "gray");
                        jsonObject2.addProperty("italic", true);
                        JsonArray jsonArray = new JsonArray();
                        jsonArray.add(jsonObject2);
                        jsonObject.add("with", jsonArray);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.TAB_LIST, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING, Protocol1_8To1_9.STRING_TO_JSON);
                this.map(Types.STRING, Protocol1_8To1_9.STRING_TO_JSON);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.DISCONNECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING, Protocol1_8To1_9.STRING_TO_JSON);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.SET_TITLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 0 || n == 1) {
                        Protocol1_8To1_9.STRING_TO_JSON.write(packetWrapper, packetWrapper.read(Types.STRING));
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.create(Types.VAR_INT, 0);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.SET_PLAYER_TEAM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    Object object;
                    Object object2;
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.BYTE);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.write(Types.STRING, Via.getConfig().isPreventCollision() ? "never" : "");
                        packetWrapper.passthrough(Types.BYTE);
                    }
                    if (by == 0 || by == 3 || by == 4) {
                        object2 = packetWrapper.passthrough(Types.STRING_ARRAY);
                        object = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        String string = packetWrapper.user().getProtocolInfo().getUsername();
                        String string2 = packetWrapper.get(Types.STRING, 0);
                        for (Object object3 : object2) {
                            if (!((EntityTracker1_9)object).isAutoTeam() || !((String)object3).equalsIgnoreCase(string)) continue;
                            if (by == 4) {
                                packetWrapper.send(Protocol1_8To1_9.class);
                                packetWrapper.cancel();
                                ((EntityTracker1_9)object).sendTeamPacket(true, true);
                                ((EntityTracker1_9)object).setCurrentTeam("viaversion");
                                continue;
                            }
                            ((EntityTracker1_9)object).sendTeamPacket(false, true);
                            ((EntityTracker1_9)object).setCurrentTeam(string2);
                        }
                    }
                    if (by == 1) {
                        object2 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        object = packetWrapper.get(Types.STRING, 0);
                        if (((EntityTracker1_9)object2).isAutoTeam() && ((String)object).equals(((EntityTracker1_9)object2).getCurrentTeam())) {
                            packetWrapper.send(Protocol1_8To1_9.class);
                            packetWrapper.cancel();
                            ((EntityTracker1_9)object2).sendTeamPacket(true, true);
                            ((EntityTracker1_9)object2).setCurrentTeam("viaversion");
                        }
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addEntity(n, EntityTypes1_9.EntityType.PLAYER);
                    entityTracker1_9.setClientEntityId(n);
                });
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    s = (short)(s & 0xFFFFFFF7);
                    entityTracker1_9.setGameMode(GameMode.getById(s));
                });
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_8To1_9.class);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    ((ClientWorld)t).setEnvironment(by);
                });
                this.handler(packetWrapper -> {
                    CommandBlockProvider commandBlockProvider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    commandBlockProvider.sendPermission(packetWrapper.user());
                });
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (Via.getConfig().isAutoTeam()) {
                        entityTracker1_9.setAutoTeam(true);
                        packetWrapper.send(Protocol1_8To1_9.class);
                        packetWrapper.cancel();
                        entityTracker1_9.sendTeamPacket(true, true);
                        entityTracker1_9.setCurrentTeam("viaversion");
                    } else {
                        entityTracker1_9.setAutoTeam(false);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.PLAYER_INFO, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    for (int i = 0; i < n2; ++i) {
                        String string;
                        packetWrapper.passthrough(Types.UUID);
                        if (n == 0) {
                            packetWrapper.passthrough(Types.STRING);
                            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                            packetWrapper.passthrough(Types.VAR_INT);
                            packetWrapper.passthrough(Types.VAR_INT);
                            string = packetWrapper.read(Types.OPTIONAL_STRING);
                            packetWrapper.write(Types.OPTIONAL_COMPONENT, string != null ? Protocol1_8To1_9.STRING_TO_JSON.transform(packetWrapper, string) : null);
                            continue;
                        }
                        if (n == 1 || n == 2) {
                            packetWrapper.passthrough(Types.VAR_INT);
                            continue;
                        }
                        if (n != 3) continue;
                        string = packetWrapper.read(Types.OPTIONAL_STRING);
                        packetWrapper.write(Types.OPTIONAL_COMPONENT, string != null ? Protocol1_8To1_9.STRING_TO_JSON.transform(packetWrapper, string) : null);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|BOpen")) {
                        packetWrapper.write(Types.VAR_INT, 0);
                    } else if (string.equals("MC|TrList")) {
                        protocol1_8To1_9.getItemRewriter().handleTradeList(packetWrapper);
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    CommandBlockProvider commandBlockProvider = Via.getManager().getProviders().get(CommandBlockProvider.class);
                    commandBlockProvider.sendPermission(packetWrapper.user());
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    entityTracker1_9.setGameMode(GameMode.getById(s));
                    ClientWorld1_9 clientWorld1_9 = (ClientWorld1_9)packetWrapper.user().getClientWorld(Protocol1_8To1_9.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    if (clientWorld1_9.setEnvironment(n)) {
                        entityTracker1_9.clearEntities();
                        clientWorld1_9.getLoadedChunks().clear();
                        commandBlockProvider.unloadChunks(packetWrapper.user());
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.GAME_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (s == 3) {
                        int n = packetWrapper.get(Types.FLOAT, 0).intValue();
                        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                        entityTracker1_9.setGameMode(GameMode.getById(n));
                    } else if (s == 4) {
                        packetWrapper.set(Types.FLOAT, 0, Float.valueOf(1.0f));
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.SET_COMPRESSION, null, packetWrapper -> {
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.user().getProtocolInfo().setCompressionEnabled(n >= 0);
            CompressionProvider compressionProvider = Via.getManager().getProviders().get(CompressionProvider.class);
            compressionProvider.handlePlayCompression(packetWrapper.user(), n);
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.COMMAND_SUGGESTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.read(Types.BOOLEAN);
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT, Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    if (Via.getConfig().isLeftHandedHandling() && n == 0) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 0, (short)(packetWrapper.get(Types.UNSIGNED_BYTE, 0).intValue() | 0x80));
                    }
                    packetWrapper.sendToServer(Protocol1_8To1_9.class);
                    packetWrapper.cancel();
                    Via.getManager().getProviders().get(MainHandProvider.class).setMainHand(packetWrapper.user(), n);
                });
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.SWING, new PacketHandlers(){

            @Override
            public void register() {
                this.read(Types.VAR_INT);
            }
        });
        protocol1_8To1_9.cancelServerbound(ServerboundPackets1_9.ACCEPT_TELEPORTATION);
        protocol1_8To1_9.cancelServerbound(ServerboundPackets1_9.MOVE_VEHICLE);
        protocol1_8To1_9.cancelServerbound(ServerboundPackets1_9.PADDLE_BOAT);
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    Item item;
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|BSign") && (item = packetWrapper.passthrough(Types.ITEM1_8)) != null) {
                        item.setIdentifier(387);
                        CompoundTag compoundTag = item.tag();
                        ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
                        if (listTag == null) {
                            return;
                        }
                        for (int i = 0; i < listTag.size(); ++i) {
                            StringTag stringTag = listTag.get(i);
                            String string2 = stringTag.getValue();
                            stringTag.setValue(ComponentUtil.plainToJson(string2).toString());
                        }
                    }
                    if (string.equals("MC|AutoCmd")) {
                        packetWrapper.set(Types.STRING, 0, "MC|AdvCdm");
                        packetWrapper.write(Types.BYTE, (byte)0);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.clearInputBuffer();
                    }
                    if (string.equals("MC|AdvCmd")) {
                        packetWrapper.set(Types.STRING, 0, "MC|AdvCdm");
                    }
                });
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.CLIENT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 2 && (entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class)).isBlocking()) {
                        if (!Via.getConfig().isShowShieldWhenSwordInHand()) {
                            entityTracker1_9.setSecondHand(null);
                        }
                        entityTracker1_9.setBlocking(false);
                    }
                });
            }
        });
        final PacketHandler packetHandler = packetWrapper -> {
            MovementTracker movementTracker = packetWrapper.user().get(MovementTracker.class);
            movementTracker.incrementIdlePacket();
            movementTracker.setGround(packetWrapper.get(Types.BOOLEAN, 0));
        };
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.MOVE_PLAYER_POS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BOOLEAN);
                this.handler(packetHandler);
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.MOVE_PLAYER_POS_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BOOLEAN);
                this.handler(packetHandler);
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.MOVE_PLAYER_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BOOLEAN);
                this.handler(packetHandler);
            }
        });
        protocol1_8To1_9.registerServerbound(ServerboundPackets1_9.MOVE_PLAYER_STATUS_ONLY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BOOLEAN);
                this.handler(packetHandler);
            }
        });
    }
}

