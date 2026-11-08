/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.BlockPos;
import org.apache.commons.lang3.StringUtils;

public class C14PacketTabComplete
implements Packet<INetHandlerPlayServer> {
    private String message;
    private BlockPos targetBlock;

    public C14PacketTabComplete() {
    }

    public C14PacketTabComplete(String string) {
        this(string, null);
    }

    public C14PacketTabComplete(String string, BlockPos blockPos) {
        this.message = string;
        this.targetBlock = blockPos;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.message = packetBuffer.readStringFromBuffer(Short.MAX_VALUE);
        boolean bl = packetBuffer.readBoolean();
        if (bl) {
            this.targetBlock = packetBuffer.readBlockPos();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeString(StringUtils.substring(this.message, 0, Short.MAX_VALUE));
        boolean bl = this.targetBlock != null;
        packetBuffer.writeBoolean(bl);
        if (bl) {
            packetBuffer.writeBlockPos(this.targetBlock);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        iNetHandlerPlayServer.processTabComplete(this);
    }

    public String getMessage() {
        return this.message;
    }

    public BlockPos getTargetBlock() {
        return this.targetBlock;
    }
}

