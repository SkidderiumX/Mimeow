/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1.storage;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.Protocol1_12To1_11_1;
import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import java.util.Locale;

public class ShoulderTracker
extends StoredObject {
    private int entityId;
    private String leftShoulder;
    private String rightShoulder;

    public ShoulderTracker(UserConnection userConnection) {
        super(userConnection);
    }

    public void update() {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_12.CHAT, this.getUser());
        try {
            packetWrapper.write(Types.COMPONENT, ComponentUtil.plainToJson(this.generateString()));
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        packetWrapper.write(Types.BYTE, (byte)2);
        try {
            packetWrapper.scheduleSend(Protocol1_12To1_11_1.class);
        }
        catch (Exception exception) {
            ViaBackwards.getPlatform().getLogger().severe("Failed to send the shoulder indication");
            exception.printStackTrace();
        }
    }

    private String generateString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ");
        if (this.leftShoulder == null) {
            stringBuilder.append("\u00a74\u00a7lNothing");
        } else {
            stringBuilder.append("\u00a72\u00a7l").append(this.getName(this.leftShoulder));
        }
        stringBuilder.append("\u00a78\u00a7l <- \u00a77\u00a7lShoulders\u00a78\u00a7l -> ");
        if (this.rightShoulder == null) {
            stringBuilder.append("\u00a74\u00a7lNothing");
        } else {
            stringBuilder.append("\u00a72\u00a7l").append(this.getName(this.rightShoulder));
        }
        return stringBuilder.toString();
    }

    private String getName(String string) {
        string = Key.stripMinecraftNamespace(string);
        String[] stringArray = string.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray) {
            stringBuilder.append(string2.substring(0, 1).toUpperCase(Locale.ROOT)).append(string2.substring(1)).append(" ");
        }
        return stringBuilder.toString();
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int n) {
        this.entityId = n;
    }

    public String getLeftShoulder() {
        return this.leftShoulder;
    }

    public void setLeftShoulder(String string) {
        this.leftShoulder = string;
    }

    public String getRightShoulder() {
        return this.rightShoulder;
    }

    public void setRightShoulder(String string) {
        this.rightShoulder = string;
    }

    public String toString() {
        return "ShoulderTracker{entityId=" + this.entityId + ", leftShoulder='" + this.leftShoulder + "', rightShoulder='" + this.rightShoulder + "'}";
    }
}

