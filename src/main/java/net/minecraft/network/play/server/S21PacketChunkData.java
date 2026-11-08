/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class S21PacketChunkData
implements Packet<INetHandlerPlayClient> {
    private int chunkX;
    private int chunkZ;
    private Extracted extractedData;
    private boolean field_149279_g;

    public S21PacketChunkData() {
    }

    public S21PacketChunkData(Chunk chunk, boolean bl, int n) {
        this.chunkX = chunk.xPosition;
        this.chunkZ = chunk.zPosition;
        this.field_149279_g = bl;
        this.extractedData = S21PacketChunkData.getExtractedData(chunk, bl, !chunk.getWorld().provider.getHasNoSky(), n);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.chunkX = packetBuffer.readInt();
        this.chunkZ = packetBuffer.readInt();
        this.field_149279_g = packetBuffer.readBoolean();
        this.extractedData = new Extracted();
        this.extractedData.dataSize = packetBuffer.readShort() & 0xFFFF;
        this.extractedData.data = packetBuffer.readByteArray();
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeInt(this.chunkX);
        packetBuffer.writeInt(this.chunkZ);
        packetBuffer.writeBoolean(this.field_149279_g);
        packetBuffer.writeShort((short)(this.extractedData.dataSize & 0xFFFF));
        packetBuffer.writeByteArray(this.extractedData.data);
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleChunkData(this);
    }

    public byte[] getExtractedDataBytes() {
        return this.extractedData.data;
    }

    protected static int func_180737_a(int n, boolean bl, boolean bl2) {
        int n2 = n * 2 * 16 * 16 * 16;
        int n3 = n * 16 * 16 * 16 / 2;
        int n4 = bl ? n * 16 * 16 * 16 / 2 : 0;
        int n5 = bl2 ? 256 : 0;
        return n2 + n3 + n4 + n5;
    }

    public static Extracted getExtractedData(Chunk chunk, boolean bl, boolean bl2, int n) {
        int n2;
        ExtendedBlockStorage[] extendedBlockStorageArray = chunk.getBlockStorageArray();
        Extracted extracted = new Extracted();
        ArrayList arrayList = Lists.newArrayList();
        for (n2 = 0; n2 < extendedBlockStorageArray.length; ++n2) {
            ExtendedBlockStorage extendedBlockStorage = extendedBlockStorageArray[n2];
            if (extendedBlockStorage == null || bl && extendedBlockStorage.isEmpty() || (n & 1 << n2) == 0) continue;
            extracted.dataSize |= 1 << n2;
            arrayList.add(extendedBlockStorage);
        }
        extracted.data = new byte[S21PacketChunkData.func_180737_a(Integer.bitCount(extracted.dataSize), bl2, bl)];
        n2 = 0;
        for (ExtendedBlockStorage extendedBlockStorage : arrayList) {
            char[] cArray;
            for (char c : cArray = extendedBlockStorage.getData()) {
                extracted.data[n2++] = (byte)(c & 0xFF);
                extracted.data[n2++] = (byte)(c >> 8 & 0xFF);
            }
        }
        for (ExtendedBlockStorage extendedBlockStorage : arrayList) {
            n2 = S21PacketChunkData.func_179757_a(extendedBlockStorage.getBlocklightArray().getReadOnlyData(), extracted.data, n2);
        }
        if (bl2) {
            for (ExtendedBlockStorage extendedBlockStorage : arrayList) {
                n2 = S21PacketChunkData.func_179757_a(extendedBlockStorage.getSkylightArray().getReadOnlyData(), extracted.data, n2);
            }
        }
        if (bl) {
            S21PacketChunkData.func_179757_a(chunk.getBiomeArray(), extracted.data, n2);
        }
        return extracted;
    }

    private static int func_179757_a(byte[] byArray, byte[] byArray2, int n) {
        System.arraycopy(byArray, 0, byArray2, n, byArray.length);
        return n + byArray.length;
    }

    public int getChunkX() {
        return this.chunkX;
    }

    public int getChunkZ() {
        return this.chunkZ;
    }

    public int getExtractedSize() {
        return this.extractedData.dataSize;
    }

    public boolean func_149274_i() {
        return this.field_149279_g;
    }

    public static class Extracted {
        public byte[] data;
        public int dataSize;
    }
}

