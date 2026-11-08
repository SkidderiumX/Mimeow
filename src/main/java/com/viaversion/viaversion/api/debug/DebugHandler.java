/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.debug;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import java.util.logging.Level;

public interface DebugHandler {
    public boolean enabled();

    public void setEnabled(boolean var1);

    public void addPacketTypeNameToLog(String var1);

    public void addPacketTypeToLog(PacketType var1);

    public boolean removePacketTypeNameToLog(String var1);

    public boolean removePacketTypeToLog(PacketType var1);

    public void clearPacketTypesToLog();

    default public void setLogPacketTransform(boolean bl) {
        this.setLogPrePacketTransform(bl);
        this.setLogPostPacketTransform(bl);
    }

    public boolean logPrePacketTransform();

    public void setLogPrePacketTransform(boolean var1);

    public boolean logPostPacketTransform();

    public void setLogPostPacketTransform(boolean var1);

    public boolean shouldLog(PacketWrapper var1, Direction var2);

    default public void enableAndLogTypes(PacketType ... packetTypeArray) {
        this.setEnabled(true);
        for (PacketType packetType : packetTypeArray) {
            this.addPacketTypeToLog(packetType);
        }
    }

    default public void error(String string, Throwable throwable) {
        if (Via.getConfig().logOtherConversionWarnings() || this.enabled()) {
            Via.getPlatform().getLogger().log(Level.SEVERE, string, throwable);
        }
    }
}

