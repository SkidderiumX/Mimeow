/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.legacy.bossbar;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.legacy.bossbar.BossBar;
import com.viaversion.viaversion.api.legacy.bossbar.BossColor;
import com.viaversion.viaversion.api.legacy.bossbar.BossFlag;
import com.viaversion.viaversion.api.legacy.bossbar.BossStyle;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

public class CommonBoss
implements BossBar {
    private final UUID uuid;
    private final Map<UUID, UserConnection> connections;
    private final Set<BossFlag> flags;
    private String title;
    private float health;
    private BossColor color;
    private BossStyle style;
    private boolean visible;

    public CommonBoss(String string, float f, BossColor bossColor, BossStyle bossStyle) {
        Preconditions.checkNotNull(string, "Title cannot be null");
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Health must be between 0 and 1. Input: " + f);
        this.uuid = UUIDUtil.randomUUID();
        this.title = string;
        this.health = f;
        this.color = bossColor == null ? BossColor.PURPLE : bossColor;
        this.style = bossStyle == null ? BossStyle.SOLID : bossStyle;
        this.connections = new MapMaker().weakValues().makeMap();
        this.flags = EnumSet.noneOf(BossFlag.class);
        this.visible = true;
    }

    @Override
    public BossBar setTitle(String string) {
        Preconditions.checkNotNull(string);
        this.title = string;
        this.sendPacket(UpdateAction.UPDATE_TITLE);
        return this;
    }

    @Override
    public BossBar setHealth(float f) {
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Health must be between 0 and 1. Input: " + f);
        this.health = f;
        this.sendPacket(UpdateAction.UPDATE_HEALTH);
        return this;
    }

    @Override
    public BossColor getColor() {
        return this.color;
    }

    @Override
    public BossBar setColor(BossColor bossColor) {
        Preconditions.checkNotNull(bossColor);
        this.color = bossColor;
        this.sendPacket(UpdateAction.UPDATE_STYLE);
        return this;
    }

    @Override
    public BossBar setStyle(BossStyle bossStyle) {
        Preconditions.checkNotNull(bossStyle);
        this.style = bossStyle;
        this.sendPacket(UpdateAction.UPDATE_STYLE);
        return this;
    }

    @Override
    public BossBar addPlayer(UUID uUID) {
        UserConnection userConnection = Via.getManager().getConnectionManager().getServerConnection(uUID);
        if (userConnection != null) {
            this.addConnection(userConnection);
        }
        return this;
    }

    @Override
    public BossBar addConnection(UserConnection userConnection) {
        if (this.connections.put(userConnection.getProtocolInfo().getUuid(), userConnection) == null && this.visible) {
            this.sendPacketConnection(userConnection, this.getPacket(UpdateAction.ADD, userConnection));
        }
        return this;
    }

    @Override
    public BossBar removePlayer(UUID uUID) {
        UserConnection userConnection = this.connections.remove(uUID);
        if (userConnection != null) {
            this.sendPacketConnection(userConnection, this.getPacket(UpdateAction.REMOVE, userConnection));
        }
        return this;
    }

    @Override
    public BossBar removeConnection(UserConnection userConnection) {
        this.removePlayer(userConnection.getProtocolInfo().getUuid());
        return this;
    }

    @Override
    public BossBar addFlag(BossFlag bossFlag) {
        Preconditions.checkNotNull(bossFlag);
        if (!this.hasFlag(bossFlag)) {
            this.flags.add(bossFlag);
        }
        this.sendPacket(UpdateAction.UPDATE_FLAGS);
        return this;
    }

    @Override
    public BossBar removeFlag(BossFlag bossFlag) {
        Preconditions.checkNotNull(bossFlag);
        if (this.hasFlag(bossFlag)) {
            this.flags.remove((Object)bossFlag);
        }
        this.sendPacket(UpdateAction.UPDATE_FLAGS);
        return this;
    }

    @Override
    public boolean hasFlag(BossFlag bossFlag) {
        Preconditions.checkNotNull(bossFlag);
        return this.flags.contains((Object)bossFlag);
    }

    @Override
    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet(this.connections.keySet());
    }

    @Override
    public Set<UserConnection> getConnections() {
        return Collections.unmodifiableSet(new HashSet<UserConnection>(this.connections.values()));
    }

    @Override
    public BossBar show() {
        this.setVisible(true);
        return this;
    }

    @Override
    public BossBar hide() {
        this.setVisible(false);
        return this;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    private void setVisible(boolean bl) {
        if (this.visible != bl) {
            this.visible = bl;
            this.sendPacket(bl ? UpdateAction.ADD : UpdateAction.REMOVE);
        }
    }

    @Override
    public UUID getId() {
        return this.uuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    @Override
    public BossStyle getStyle() {
        return this.style;
    }

    public Set<BossFlag> getFlags() {
        return this.flags;
    }

    private void sendPacket(UpdateAction updateAction) {
        for (UserConnection userConnection : new ArrayList<UserConnection>(this.connections.values())) {
            PacketWrapper packetWrapper = this.getPacket(updateAction, userConnection);
            this.sendPacketConnection(userConnection, packetWrapper);
        }
    }

    private void sendPacketConnection(UserConnection userConnection, PacketWrapper packetWrapper) {
        if (userConnection.getProtocolInfo() == null || !userConnection.getProtocolInfo().getPipeline().contains(Protocol1_8To1_9.class)) {
            this.connections.remove(userConnection.getProtocolInfo().getUuid());
            return;
        }
        try {
            packetWrapper.scheduleSend(Protocol1_8To1_9.class);
        }
        catch (Exception exception) {
            Via.getPlatform().getLogger().log(Level.WARNING, "Failed to send bossbar packet", exception);
        }
    }

    private PacketWrapper getPacket(UpdateAction updateAction, UserConnection userConnection) {
        try {
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.BOSS_EVENT, null, userConnection);
            packetWrapper.write(Types.UUID, this.uuid);
            packetWrapper.write(Types.VAR_INT, updateAction.getId());
            switch (updateAction) {
                case ADD: {
                    try {
                        packetWrapper.write(Types.COMPONENT, JsonParser.parseString(this.title));
                    }
                    catch (Exception exception) {
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.plainToJson(this.title));
                    }
                    packetWrapper.write(Types.FLOAT, Float.valueOf(this.health));
                    packetWrapper.write(Types.VAR_INT, this.color.getId());
                    packetWrapper.write(Types.VAR_INT, this.style.getId());
                    packetWrapper.write(Types.BYTE, (byte)this.flagToBytes());
                    break;
                }
                case REMOVE: {
                    break;
                }
                case UPDATE_HEALTH: {
                    packetWrapper.write(Types.FLOAT, Float.valueOf(this.health));
                    break;
                }
                case UPDATE_TITLE: {
                    try {
                        packetWrapper.write(Types.COMPONENT, JsonParser.parseString(this.title));
                    }
                    catch (Exception exception) {
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.plainToJson(this.title));
                    }
                    break;
                }
                case UPDATE_STYLE: {
                    packetWrapper.write(Types.VAR_INT, this.color.getId());
                    packetWrapper.write(Types.VAR_INT, this.style.getId());
                    break;
                }
                case UPDATE_FLAGS: {
                    packetWrapper.write(Types.BYTE, (byte)this.flagToBytes());
                }
            }
            return packetWrapper;
        }
        catch (Exception exception) {
            Via.getPlatform().getLogger().log(Level.WARNING, "Failed to create bossbar packet", exception);
            return null;
        }
    }

    private int flagToBytes() {
        int n = 0;
        for (BossFlag bossFlag : this.flags) {
            n |= bossFlag.getId();
        }
        return n;
    }

    private static enum UpdateAction {
        ADD(0),
        REMOVE(1),
        UPDATE_HEALTH(2),
        UPDATE_TITLE(3),
        UPDATE_STYLE(4),
        UPDATE_FLAGS(5);

        private final int id;

        private UpdateAction(int n2) {
            this.id = n2;
        }

        public int getId() {
            return this.id;
        }
    }
}

