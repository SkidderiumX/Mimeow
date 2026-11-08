/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import com.google.common.collect.Lists;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import net.minecraft.server.MinecraftServer;

public class RegionFile {
    private static final byte[] emptySector = new byte[4096];
    private final File fileName;
    private RandomAccessFile dataFile;
    private final int[] offsets = new int[1024];
    private final int[] chunkTimestamps = new int[1024];
    private List<Boolean> sectorFree;
    private int sizeDelta;
    private long lastModified;

    public RegionFile(File file) {
        this.fileName = file;
        this.sizeDelta = 0;
        try {
            int n;
            int n2;
            int n3;
            if (file.exists()) {
                this.lastModified = file.lastModified();
            }
            this.dataFile = new RandomAccessFile(file, "rw");
            if (this.dataFile.length() < 4096L) {
                for (n3 = 0; n3 < 1024; ++n3) {
                    this.dataFile.writeInt(0);
                }
                for (n3 = 0; n3 < 1024; ++n3) {
                    this.dataFile.writeInt(0);
                }
                this.sizeDelta += 8192;
            }
            if ((this.dataFile.length() & 0xFFFL) != 0L) {
                n3 = 0;
                while ((long)n3 < (this.dataFile.length() & 0xFFFL)) {
                    this.dataFile.write(0);
                    ++n3;
                }
            }
            n3 = (int)this.dataFile.length() / 4096;
            this.sectorFree = Lists.newArrayListWithCapacity(n3);
            for (n2 = 0; n2 < n3; ++n2) {
                this.sectorFree.add(true);
            }
            this.sectorFree.set(0, false);
            this.sectorFree.set(1, false);
            this.dataFile.seek(0L);
            for (n2 = 0; n2 < 1024; ++n2) {
                this.offsets[n2] = n = this.dataFile.readInt();
                if (n == 0 || (n >> 8) + (n & 0xFF) > this.sectorFree.size()) continue;
                for (int i = 0; i < (n & 0xFF); ++i) {
                    this.sectorFree.set((n >> 8) + i, false);
                }
            }
            for (n2 = 0; n2 < 1024; ++n2) {
                this.chunkTimestamps[n2] = n = this.dataFile.readInt();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public synchronized DataInputStream getChunkDataInputStream(int n, int n2) {
        if (this.outOfBounds(n, n2)) {
            return null;
        }
        try {
            int n3 = this.getOffset(n, n2);
            if (n3 == 0) {
                return null;
            }
            int n4 = n3 >> 8;
            int n5 = n3 & 0xFF;
            if (n4 + n5 > this.sectorFree.size()) {
                return null;
            }
            this.dataFile.seek(n4 * 4096);
            int n6 = this.dataFile.readInt();
            if (n6 > 4096 * n5) {
                return null;
            }
            if (n6 <= 0) {
                return null;
            }
            byte by = this.dataFile.readByte();
            if (by == 1) {
                byte[] byArray = new byte[n6 - 1];
                this.dataFile.read(byArray);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(byArray))));
            }
            if (by == 2) {
                byte[] byArray = new byte[n6 - 1];
                this.dataFile.read(byArray);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(byArray))));
            }
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public DataOutputStream getChunkDataOutputStream(int n, int n2) {
        return this.outOfBounds(n, n2) ? null : new DataOutputStream(new DeflaterOutputStream(new ChunkBuffer(n, n2)));
    }

    protected synchronized void write(int n, int n2, byte[] byArray, int n3) {
        try {
            int n4 = this.getOffset(n, n2);
            int n5 = n4 >> 8;
            int n6 = n4 & 0xFF;
            int n7 = (n3 + 5) / 4096 + 1;
            if (n7 >= 256) {
                return;
            }
            if (n5 != 0 && n6 == n7) {
                this.write(n5, byArray, n3);
            } else {
                int n8;
                int n9;
                for (n9 = 0; n9 < n6; ++n9) {
                    this.sectorFree.set(n5 + n9, true);
                }
                n9 = this.sectorFree.indexOf(true);
                int n10 = 0;
                if (n9 != -1) {
                    for (n8 = n9; n8 < this.sectorFree.size(); ++n8) {
                        if (n10 != 0) {
                            n10 = this.sectorFree.get(n8).booleanValue() ? ++n10 : 0;
                        } else if (this.sectorFree.get(n8).booleanValue()) {
                            n9 = n8;
                            n10 = 1;
                        }
                        if (n10 >= n7) break;
                    }
                }
                if (n10 >= n7) {
                    n5 = n9;
                    this.setOffset(n, n2, n9 << 8 | n7);
                    for (n8 = 0; n8 < n7; ++n8) {
                        this.sectorFree.set(n5 + n8, false);
                    }
                    this.write(n5, byArray, n3);
                } else {
                    this.dataFile.seek(this.dataFile.length());
                    n5 = this.sectorFree.size();
                    for (n8 = 0; n8 < n7; ++n8) {
                        this.dataFile.write(emptySector);
                        this.sectorFree.add(false);
                    }
                    this.sizeDelta += 4096 * n7;
                    this.write(n5, byArray, n3);
                    this.setOffset(n, n2, n5 << 8 | n7);
                }
            }
            this.setChunkTimestamp(n, n2, (int)(MinecraftServer.getCurrentTimeMillis() / 1000L));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void write(int n, byte[] byArray, int n2) throws IOException {
        this.dataFile.seek(n * 4096);
        this.dataFile.writeInt(n2 + 1);
        this.dataFile.writeByte(2);
        this.dataFile.write(byArray, 0, n2);
    }

    private boolean outOfBounds(int n, int n2) {
        return n < 0 || n >= 32 || n2 < 0 || n2 >= 32;
    }

    private int getOffset(int n, int n2) {
        return this.offsets[n + n2 * 32];
    }

    public boolean isChunkSaved(int n, int n2) {
        return this.getOffset(n, n2) != 0;
    }

    private void setOffset(int n, int n2, int n3) throws IOException {
        this.offsets[n + n2 * 32] = n3;
        this.dataFile.seek((n + n2 * 32) * 4);
        this.dataFile.writeInt(n3);
    }

    private void setChunkTimestamp(int n, int n2, int n3) throws IOException {
        this.chunkTimestamps[n + n2 * 32] = n3;
        this.dataFile.seek(4096 + (n + n2 * 32) * 4);
        this.dataFile.writeInt(n3);
    }

    public void close() throws IOException {
        if (this.dataFile != null) {
            this.dataFile.close();
        }
    }

    public class ChunkBuffer
    extends ByteArrayOutputStream {
        private int chunkX;
        private int chunkZ;

        public ChunkBuffer(int n, int n2) {
            super(8096);
            this.chunkX = n;
            this.chunkZ = n2;
        }

        @Override
        public void close() throws IOException {
            RegionFile.this.write(this.chunkX, this.chunkZ, this.buf, this.count);
        }
    }
}

