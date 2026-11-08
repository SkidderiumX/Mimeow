/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Map;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;

public class S37PacketStatistics
implements Packet<INetHandlerPlayClient> {
    private Map<StatBase, Integer> field_148976_a;

    public S37PacketStatistics() {
    }

    public S37PacketStatistics(Map<StatBase, Integer> map) {
        this.field_148976_a = map;
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleStatistics(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        int n = packetBuffer.readVarIntFromBuffer();
        this.field_148976_a = Maps.newHashMap();
        for (int i = 0; i < n; ++i) {
            StatBase statBase = StatList.getOneShotStat(packetBuffer.readStringFromBuffer(Short.MAX_VALUE));
            int n2 = packetBuffer.readVarIntFromBuffer();
            if (statBase == null) continue;
            this.field_148976_a.put(statBase, n2);
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.field_148976_a.size());
        for (Map.Entry<StatBase, Integer> entry : this.field_148976_a.entrySet()) {
            packetBuffer.writeString(entry.getKey().statId);
            packetBuffer.writeVarIntToBuffer(entry.getValue());
        }
    }

    public Map<StatBase, Integer> func_148974_c() {
        return this.field_148976_a;
    }
}

