/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.provider.InventoryProvider;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.BlockPlaceDestroyTracker;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.BossBarStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.CooldownStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.EntityTracker1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.PlayerPositionTracker;
import com.viaversion.viarewind.utils.ChatUtil;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.util.StringUtil;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerPacketRewriter1_9
extends RewriterBase<Protocol1_9To1_8> {
    public PlayerPacketRewriter1_9(Protocol1_9To1_8 protocol1_9To1_8) {
        super(protocol1_9To1_8);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.BOSS_EVENT, null, packetWrapper -> {
            packetWrapper.cancel();
            BossBarStorage bossBarStorage = packetWrapper.user().get(BossBarStorage.class);
            UUID uUID = packetWrapper.read(Types.UUID);
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 0) {
                JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                float f = packetWrapper.read(Types.FLOAT).floatValue();
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.read(Types.UNSIGNED_BYTE);
                bossBarStorage.add(uUID, ChatUtil.jsonToLegacy(jsonElement), f);
            } else if (n == 1) {
                bossBarStorage.remove(uUID);
            } else if (n == 2) {
                float f = packetWrapper.read(Types.FLOAT).floatValue();
                bossBarStorage.updateHealth(uUID, f);
            } else if (n == 3) {
                JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                bossBarStorage.updateTitle(uUID, ChatUtil.jsonToLegacy(jsonElement));
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SET_PLAYER_TEAM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.BYTE);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.read(Types.STRING);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).cancelClientbound(ClientboundPackets1_9.COOLDOWN);
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|BOpen")) {
                        packetWrapper.read(Types.VAR_INT);
                    } else if (string.equals("MC|TrList")) {
                        ((Protocol1_9To1_8)PlayerPacketRewriter1_9.this.protocol).getItemRewriter().handleTradeList(packetWrapper);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
                    playerPositionTracker.setConfirmId(packetWrapper.read(Types.VAR_INT));
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    double d = packetWrapper.get(Types.DOUBLE, 0);
                    double d2 = packetWrapper.get(Types.DOUBLE, 1);
                    double d3 = packetWrapper.get(Types.DOUBLE, 2);
                    float f = packetWrapper.get(Types.FLOAT, 0).floatValue();
                    float f2 = packetWrapper.get(Types.FLOAT, 1).floatValue();
                    packetWrapper.set(Types.BYTE, 0, (byte)0);
                    if (by != 0) {
                        if ((by & 1) != 0) {
                            packetWrapper.set(Types.DOUBLE, 0, d += playerPositionTracker.getPosX());
                        }
                        if ((by & 2) != 0) {
                            packetWrapper.set(Types.DOUBLE, 1, d2 += playerPositionTracker.getPosY());
                        }
                        if ((by & 4) != 0) {
                            packetWrapper.set(Types.DOUBLE, 2, d3 += playerPositionTracker.getPosZ());
                        }
                        if ((by & 8) != 0) {
                            packetWrapper.set(Types.FLOAT, 0, Float.valueOf(f += playerPositionTracker.getYaw()));
                        }
                        if ((by & 0x10) != 0) {
                            packetWrapper.set(Types.FLOAT, 1, Float.valueOf(f2 += playerPositionTracker.getPitch()));
                        }
                    }
                    playerPositionTracker.setPos(d, d2, d3);
                    playerPositionTracker.setYaw(f);
                    playerPositionTracker.setPitch(f2);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_9To1_8.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        Object t2 = packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
                        t2.clearEntities();
                        packetWrapper.user().get(BossBarStorage.class).reset();
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.PLAYER_COMBAT, packetWrapper -> {
            if (!ViaRewind.getConfig().handlePlayerCombatPacket()) {
                return;
            }
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n != 2) {
                return;
            }
            EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.INT);
            if (n2 != entityTracker1_9.clientEntityId()) {
                return;
            }
            JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_8.SET_HEALTH);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
            packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_8.CHAT);
            packetWrapper3.write(Types.COMPONENT, jsonElement);
            packetWrapper3.write(Types.BYTE, (byte)2);
            packetWrapper3.scheduleSend(Protocol1_9To1_8.class);
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    if (!ViaRewind.getConfig().isEnableOffhand()) {
                        return;
                    }
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.toLowerCase().trim().startsWith(ViaRewind.getConfig().getOffhandCommand())) {
                        packetWrapper.cancel();
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.PLAYER_ACTION, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, 6);
                        packetWrapper2.write(Types.BLOCK_POSITION1_8, new BlockPosition(0, 0, 0));
                        packetWrapper2.write(Types.UNSIGNED_BYTE, (short)255);
                        packetWrapper2.sendToServer(Protocol1_9To1_8.class);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.INTERACT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 2) {
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                    }
                    if (n == 2 || n == 0) {
                        packetWrapper.write(Types.VAR_INT, 0);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.MOVE_PLAYER_STATUS_ONLY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    packetWrapper.user().get(PlayerPositionTracker.class).sendAnimations();
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
                    if (entityTracker1_9.isInsideVehicle(entityTracker1_9.clientEntityId())) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.MOVE_PLAYER_POS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
                    playerPositionTracker.sendAnimations();
                    if (playerPositionTracker.getConfirmId() != -1) {
                        return;
                    }
                    playerPositionTracker.setPos(packetWrapper.get(Types.DOUBLE, 0), packetWrapper.get(Types.DOUBLE, 1), packetWrapper.get(Types.DOUBLE, 2));
                    playerPositionTracker.setOnGround(packetWrapper.get(Types.BOOLEAN, 0));
                });
                this.handler(packetWrapper -> packetWrapper.user().get(BossBarStorage.class).updateLocation());
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.MOVE_PLAYER_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
                    playerPositionTracker.sendAnimations();
                    if (playerPositionTracker.getConfirmId() != -1) {
                        return;
                    }
                    playerPositionTracker.setYaw(packetWrapper.get(Types.FLOAT, 0).floatValue());
                    playerPositionTracker.setPitch(packetWrapper.get(Types.FLOAT, 1).floatValue());
                    playerPositionTracker.setOnGround(packetWrapper.get(Types.BOOLEAN, 0));
                });
                this.handler(packetWrapper -> packetWrapper.user().get(BossBarStorage.class).updateLocation());
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
            playerPositionTracker.sendAnimations();
            if (playerPositionTracker.getConfirmId() != -1) {
                boolean bl2;
                boolean bl3 = bl2 = Math.abs(playerPositionTracker.getPosY() - d2) <= 1.0E-7;
                if (playerPositionTracker.getPosX() == d && bl2 && playerPositionTracker.getPosZ() == d3 && playerPositionTracker.getYaw() == f && playerPositionTracker.getPitch() == f2) {
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.ACCEPT_TELEPORTATION, packetWrapper.user());
                    packetWrapper2.write(Types.VAR_INT, playerPositionTracker.getConfirmId());
                    packetWrapper2.sendToServer(Protocol1_9To1_8.class);
                    playerPositionTracker.setConfirmId(-1);
                }
            } else {
                playerPositionTracker.setPos(d, d2, d3);
                playerPositionTracker.setYaw(f);
                playerPositionTracker.setPitch(f2);
                playerPositionTracker.setOnGround(bl);
                packetWrapper.user().get(BossBarStorage.class).updateLocation();
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.PLAYER_ACTION, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            BlockPlaceDestroyTracker blockPlaceDestroyTracker = packetWrapper.user().get(BlockPlaceDestroyTracker.class);
            if (n == 0 || n == 1 || n == 2) {
                blockPlaceDestroyTracker.setMining();
            }
            CooldownStorage cooldownStorage = packetWrapper.user().get(CooldownStorage.class);
            if (n == 1) {
                blockPlaceDestroyTracker.setLastMining(0L);
                cooldownStorage.hit();
            } else if (n == 2) {
                blockPlaceDestroyTracker.setLastMining(System.currentTimeMillis() + 100L);
                cooldownStorage.setLastHit(0L);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE, Types.VAR_INT);
                this.read(Types.ITEM1_8);
                this.create(Types.VAR_INT, 0);
                this.map(Types.BYTE, Types.UNSIGNED_BYTE);
                this.map(Types.BYTE, Types.UNSIGNED_BYTE);
                this.map(Types.BYTE, Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.VAR_INT, 0) == -1) {
                        packetWrapper.cancel();
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.USE_ITEM, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, 0);
                        packetWrapper2.sendToServer(Protocol1_9To1_8.class);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.SET_CARRIED_ITEM, packetWrapper -> packetWrapper.user().get(CooldownStorage.class).hit());
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.SWING, packetWrapper -> {
            packetWrapper.cancel();
            PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.SWING, packetWrapper.user());
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper.user().get(PlayerPositionTracker.class).queueAnimation(packetWrapper2);
            packetWrapper.user().get(BlockPlaceDestroyTracker.class).updateMining();
            packetWrapper.user().get(CooldownStorage.class).hit();
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.PLAYER_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
                    InventoryProvider inventoryProvider = Via.getManager().getProviders().get(InventoryProvider.class);
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 6) {
                        packetWrapper.set(Types.VAR_INT, 1, 7);
                    } else if (n == 0 && inventoryProvider.hasElytra(packetWrapper.user()) && !playerPositionTracker.isOnGround()) {
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.PLAYER_COMMAND, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, packetWrapper.get(Types.VAR_INT, 0));
                        packetWrapper2.write(Types.VAR_INT, 8);
                        packetWrapper2.write(Types.VAR_INT, 0);
                        packetWrapper2.scheduleSendToServer(Protocol1_9To1_8.class);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.PLAYER_INPUT, packetWrapper -> {
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
            Integer n = entityTracker1_9.getVehicle(entityTracker1_9.clientEntityId());
            if (n != null && entityTracker1_9.entityType(n) == EntityTypes1_9.EntityType.BOAT) {
                PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_9.PADDLE_BOAT, packetWrapper.user());
                packetWrapper2.write(Types.BOOLEAN, f2 != 0.0f || f < 0.0f);
                packetWrapper2.write(Types.BOOLEAN, f2 != 0.0f || f > 0.0f);
                packetWrapper2.scheduleSendToServer(Protocol1_9To1_8.class);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.SIGN_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.handler(packetWrapper -> {
                    for (int i = 0; i < 4; ++i) {
                        JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                        if (!jsonElement.isJsonPrimitive()) {
                            throw new IllegalStateException("Invalid sign text: " + StringUtil.forLogging(jsonElement));
                        }
                        packetWrapper.write(Types.STRING, ChatUtil.jsonToLegacy(jsonElement));
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.COMMAND_SUGGESTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.create(Types.BOOLEAN, false);
                this.map(Types.OPTIONAL_POSITION1_8);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.BYTE, Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.create(Types.VAR_INT, 1);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_DATA, packetWrapper.user());
                    packetWrapper2.write(Types.VAR_INT, packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).clientEntityId());
                    ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                    arrayList.add(new EntityData(10, EntityDataTypes1_8.BYTE, (byte)s));
                    packetWrapper2.write(Types.ENTITY_DATA_LIST1_8, arrayList);
                    packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerServerbound(ServerboundPackets1_8.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|BEdit") || string.equals("MC|BSign")) {
                        Item item = packetWrapper.passthrough(Types.ITEM1_8);
                        item.setIdentifier(386);
                        CompoundTag compoundTag = item.tag();
                        if (compoundTag == null) {
                            return;
                        }
                        ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
                        if (listTag == null) {
                            return;
                        }
                        if (listTag.size() > ViaRewind.getConfig().getMaxBookPages()) {
                            packetWrapper.user().disconnect("Too many book pages");
                            return;
                        }
                        for (int i = 0; i < listTag.size(); ++i) {
                            StringTag stringTag = listTag.get(i);
                            String string2 = stringTag.getValue();
                            if (string2.length() > ViaRewind.getConfig().getMaxBookPageSize()) {
                                packetWrapper.user().disconnect("Book page too large");
                                return;
                            }
                            stringTag.setValue(ChatUtil.jsonToLegacy(string2));
                        }
                    } else if (string.equals("MC|AdvCdm")) {
                        packetWrapper.set(Types.STRING, 0, "MC|AdvCmd");
                    }
                });
            }
        });
    }
}

