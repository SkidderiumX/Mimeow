/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.world.chunk.Chunk;

public class S26PacketMapChunkBulk
implements Packet<INetHandlerPlayClient> {
    private int[] xPositions;
    private int[] zPositions;
    private S21PacketChunkData.Extracted[] chunksData;
    private boolean isOverworld;

    public S26PacketMapChunkBulk() {
    }

    public S26PacketMapChunkBulk(List<Chunk> list) {
        int n = list.size();
        this.xPositions = new int[n];
        this.zPositions = new int[n];
        this.chunksData = new S21PacketChunkData.Extracted[n];
        this.isOverworld = !list.get((int)0).getWorld().provider.getHasNoSky();
        for (int i = 0; i < n; ++i) {
            Chunk chunk = list.get(i);
            S21PacketChunkData.Extracted extracted = S21PacketChunkData.getExtractedData(chunk, true, this.isOverworld, 65535);
            this.xPositions[i] = chunk.xPosition;
            this.zPositions[i] = chunk.zPosition;
            this.chunksData[i] = extracted;
        }
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        int n;
        this.isOverworld = packetBuffer.readBoolean();
        int n2 = packetBuffer.readVarIntFromBuffer();
        this.xPositions = new int[n2];
        this.zPositions = new int[n2];
        this.chunksData = new S21PacketChunkData.Extracted[n2];
        for (n = 0; n < n2; ++n) {
            this.xPositions[n] = packetBuffer.readInt();
            this.zPositions[n] = packetBuffer.readInt();
            this.chunksData[n] = new S21PacketChunkData.Extracted();
            this.chunksData[n].dataSize = packetBuffer.readShort() & 0xFFFF;
            this.chunksData[n].data = new byte[S21PacketChunkData.func_180737_a(Integer.bitCount(this.chunksData[n].dataSize), this.isOverworld, true)];
        }
        for (n = 0; n < n2; ++n) {
            packetBuffer.readBytes(this.chunksData[n].data);
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        int n;
        packetBuffer.writeBoolean(this.isOverworld);
        packetBuffer.writeVarIntToBuffer(this.chunksData.length);
        for (n = 0; n < this.xPositions.length; ++n) {
            packetBuffer.writeInt(this.xPositions[n]);
            packetBuffer.writeInt(this.zPositions[n]);
            packetBuffer.writeShort((short)(this.chunksData[n].dataSize & 0xFFFF));
        }
        for (n = 0; n < this.xPositions.length; ++n) {
            packetBuffer.writeBytes(this.chunksData[n].data);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleMapChunkBulk(this);
    }

    public int getChunkX(int n) {
        return this.xPositions[n];
    }

    public int getChunkZ(int n) {
        return this.zPositions[n];
    }

    public int getChunkCount() {
        return this.xPositions.length;
    }

    public byte[] getChunkBytes(int n) {
        return this.chunksData[n].data;
    }

    public int getChunkSize(int n) {
        return this.chunksData[n].dataSize;
    }
}

