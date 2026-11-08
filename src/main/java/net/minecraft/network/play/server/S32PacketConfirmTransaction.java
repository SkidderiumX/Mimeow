/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.ViaMCP;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S32PacketConfirmTransaction
implements Packet<INetHandlerPlayClient> {
    private int windowId;
    private short actionNumber;
    private boolean field_148893_c;

    public S32PacketConfirmTransaction() {
    }

    public S32PacketConfirmTransaction(int n, short s, boolean bl) {
        this.windowId = n;
        this.actionNumber = s;
        this.field_148893_c = bl;
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleConfirmTransaction(this);
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        if (ViaMCP.isTargetVersionAtLeast(ProtocolVersion.v1_17)) {
            this.windowId = packetBuffer.readInt();
        } else {
            this.windowId = packetBuffer.readUnsignedByte();
            this.actionNumber = packetBuffer.readShort();
            this.field_148893_c = packetBuffer.readBoolean();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeByte(this.windowId);
        packetBuffer.writeShort(this.actionNumber);
        packetBuffer.writeBoolean(this.field_148893_c);
    }

    public int getWindowId() {
        return this.windowId;
    }

    public short getActionNumber() {
        return this.actionNumber;
    }

    public boolean func_148888_e() {
        return this.field_148893_c;
    }
}

