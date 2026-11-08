/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S3APacketTabComplete;

public class S3A
extends SPacket {
    public String[] matches;

    public S3A(S3APacketTabComplete s3APacketTabComplete, byte by) {
        super(s3APacketTabComplete);
        this.matches = s3APacketTabComplete.func_149630_c();
    }

    public S3A(String[] stringArray) {
        super(new S3APacketTabComplete(stringArray));
        this.matches = stringArray;
    }
}

