/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.Collection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.Vec4b;
import net.minecraft.world.storage.MapData;

public class S34PacketMaps
implements Packet<INetHandlerPlayClient> {
    private int mapId;
    private byte mapScale;
    private Vec4b[] mapVisiblePlayersVec4b;
    private int mapMinX;
    private int mapMinY;
    private int mapMaxX;
    private int mapMaxY;
    private byte[] mapDataBytes;

    public S34PacketMaps() {
    }

    public S34PacketMaps(int n, byte by, Collection<Vec4b> collection, byte[] byArray, int n2, int n3, int n4, int n5) {
        this.mapId = n;
        this.mapScale = by;
        this.mapVisiblePlayersVec4b = collection.toArray(new Vec4b[collection.size()]);
        this.mapMinX = n2;
        this.mapMinY = n3;
        this.mapMaxX = n4;
        this.mapMaxY = n5;
        this.mapDataBytes = new byte[n4 * n5];
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n5; ++j) {
                this.mapDataBytes[i + j * n4] = byArray[n2 + i + (n3 + j) * 128];
            }
        }
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.mapId = packetBuffer.readVarIntFromBuffer();
        this.mapScale = packetBuffer.readByte();
        this.mapVisiblePlayersVec4b = new Vec4b[packetBuffer.readVarIntFromBuffer()];
        for (int i = 0; i < this.mapVisiblePlayersVec4b.length; ++i) {
            short s = packetBuffer.readByte();
            this.mapVisiblePlayersVec4b[i] = new Vec4b((byte)(s >> 4 & 0xF), packetBuffer.readByte(), packetBuffer.readByte(), (byte)(s & 0xF));
        }
        this.mapMaxX = packetBuffer.readUnsignedByte();
        if (this.mapMaxX > 0) {
            this.mapMaxY = packetBuffer.readUnsignedByte();
            this.mapMinX = packetBuffer.readUnsignedByte();
            this.mapMinY = packetBuffer.readUnsignedByte();
            this.mapDataBytes = packetBuffer.readByteArray();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeVarIntToBuffer(this.mapId);
        packetBuffer.writeByte(this.mapScale);
        packetBuffer.writeVarIntToBuffer(this.mapVisiblePlayersVec4b.length);
        for (Vec4b vec4b : this.mapVisiblePlayersVec4b) {
            packetBuffer.writeByte((vec4b.func_176110_a() & 0xF) << 4 | vec4b.func_176111_d() & 0xF);
            packetBuffer.writeByte(vec4b.func_176112_b());
            packetBuffer.writeByte(vec4b.func_176113_c());
        }
        packetBuffer.writeByte(this.mapMaxX);
        if (this.mapMaxX > 0) {
            packetBuffer.writeByte(this.mapMaxY);
            packetBuffer.writeByte(this.mapMinX);
            packetBuffer.writeByte(this.mapMinY);
            packetBuffer.writeByteArray(this.mapDataBytes);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleMaps(this);
    }

    public int getMapId() {
        return this.mapId;
    }

    public void setMapdataTo(MapData mapData) {
        int n;
        mapData.scale = this.mapScale;
        mapData.mapDecorations.clear();
        for (n = 0; n < this.mapVisiblePlayersVec4b.length; ++n) {
            Vec4b vec4b = this.mapVisiblePlayersVec4b[n];
            mapData.mapDecorations.put("icon-" + n, vec4b);
        }
        for (n = 0; n < this.mapMaxX; ++n) {
            for (int i = 0; i < this.mapMaxY; ++i) {
                mapData.colors[this.mapMinX + n + (this.mapMinY + i) * 128] = this.mapDataBytes[n + i * this.mapMaxX];
            }
        }
    }
}

