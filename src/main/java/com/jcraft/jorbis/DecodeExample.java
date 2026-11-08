/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Packet;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Info;
import java.io.FileInputStream;
import java.io.InputStream;

public class DecodeExample {
    static int convsize = 8192;
    static byte[] convbuffer = new byte[convsize];

    DecodeExample() {
    }

    public static void main(String[] stringArray) {
        InputStream inputStream2 = System.in;
        if (stringArray.length > 0) {
            try {
                inputStream2 = new FileInputStream(stringArray[0]);
            }
            catch (Exception exception) {
                System.err.println(exception);
            }
        }
        SyncState syncState = new SyncState();
        StreamState streamState = new StreamState();
        Page page = new Page();
        Packet packet = new Packet();
        Info info = new Info();
        Comment comment = new Comment();
        DspState dspState = new DspState();
        Block block = new Block(dspState);
        int n = 0;
        syncState.init();
        while (true) {
            boolean bl = false;
            int n2 = syncState.buffer(4096);
            byte[] byArray = syncState.data;
            try {
                n = inputStream2.read(byArray, n2, 4096);
            }
            catch (Exception exception) {
                System.err.println(exception);
                System.exit(-1);
            }
            syncState.wrote(n);
            if (syncState.pageout(page) != 1) {
                if (n < 4096) break;
                System.err.println("Input does not appear to be an Ogg bitstream.");
                System.exit(1);
            }
            streamState.init(page.serialno());
            info.init();
            comment.init();
            if (streamState.pagein(page) < 0) {
                System.err.println("Error reading first page of Ogg bitstream data.");
                System.exit(1);
            }
            if (streamState.packetout(packet) != 1) {
                System.err.println("Error reading initial header packet.");
                System.exit(1);
            }
            if (info.synthesis_headerin(comment, packet) < 0) {
                System.err.println("This Ogg bitstream does not contain Vorbis audio data.");
                System.exit(1);
            }
            int n3 = 0;
            while (n3 < 2) {
                int n4;
                while (n3 < 2 && (n4 = syncState.pageout(page)) != 0) {
                    if (n4 != 1) continue;
                    streamState.pagein(page);
                    while (n3 < 2 && (n4 = streamState.packetout(packet)) != 0) {
                        if (n4 == -1) {
                            System.err.println("Corrupt secondary header.  Exiting.");
                            System.exit(1);
                        }
                        info.synthesis_headerin(comment, packet);
                        ++n3;
                    }
                }
                n2 = syncState.buffer(4096);
                byArray = syncState.data;
                try {
                    n = inputStream2.read(byArray, n2, 4096);
                }
                catch (Exception exception) {
                    System.err.println(exception);
                    System.exit(1);
                }
                if (n == 0 && n3 < 2) {
                    System.err.println("End of file before finding all Vorbis headers!");
                    System.exit(1);
                }
                syncState.wrote(n);
            }
            Object object = comment.user_comments;
            for (int i = 0; i < ((byte[][])object).length && object[i] != null; ++i) {
                System.err.println(new String(object[i], 0, object[i].length - 1));
            }
            System.err.println("\nBitstream is " + info.channels + " channel, " + info.rate + "Hz");
            System.err.println("Encoded by: " + new String(comment.vendor, 0, comment.vendor.length - 1) + "\n");
            convsize = 4096 / info.channels;
            dspState.synthesis_init(info);
            block.init(dspState);
            object = new float[1][][];
            int[] nArray = new int[info.channels];
            while (!bl) {
                int n5;
                while (!bl && (n5 = syncState.pageout(page)) != 0) {
                    if (n5 == -1) {
                        System.err.println("Corrupt or missing data in bitstream; continuing...");
                        continue;
                    }
                    streamState.pagein(page);
                    while ((n5 = streamState.packetout(packet)) != 0) {
                        int n6;
                        if (n5 == -1) continue;
                        if (block.synthesis(packet) == 0) {
                            dspState.synthesis_blockin(block);
                        }
                        while ((n6 = dspState.synthesis_pcmout((float[][][])object, nArray)) > 0) {
                            byte[] byArray2 = object[0];
                            int n7 = n6 < convsize ? n6 : convsize;
                            for (n3 = 0; n3 < info.channels; ++n3) {
                                int n8 = n3 * 2;
                                int n9 = nArray[n3];
                                for (int i = 0; i < n7; ++i) {
                                    int n10 = (int)((double)byArray2[n3][n9 + i] * 32767.0);
                                    if (n10 > Short.MAX_VALUE) {
                                        n10 = Short.MAX_VALUE;
                                    }
                                    if (n10 < Short.MIN_VALUE) {
                                        n10 = Short.MIN_VALUE;
                                    }
                                    if (n10 < 0) {
                                        n10 |= 0x8000;
                                    }
                                    DecodeExample.convbuffer[n8] = (byte)n10;
                                    DecodeExample.convbuffer[n8 + 1] = (byte)(n10 >>> 8);
                                    n8 += 2 * info.channels;
                                }
                            }
                            System.out.write(convbuffer, 0, 2 * info.channels * n7);
                            dspState.synthesis_read(n7);
                        }
                    }
                    if (page.eos() == 0) continue;
                    bl = true;
                }
                if (bl) continue;
                n2 = syncState.buffer(4096);
                byArray = syncState.data;
                try {
                    n = inputStream2.read(byArray, n2, 4096);
                }
                catch (Exception exception) {
                    System.err.println(exception);
                    System.exit(1);
                }
                syncState.wrote(n);
                if (n != 0) continue;
                bl = true;
            }
            streamState.clear();
            block.clear();
            dspState.clear();
            info.clear();
        }
        syncState.clear();
        System.err.println("Done.");
    }
}

