/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.IChatComponent;

public class S45PacketTitle
implements Packet<INetHandlerPlayClient> {
    private Type type;
    private IChatComponent message;
    private int fadeInTime;
    private int displayTime;
    private int fadeOutTime;

    public S45PacketTitle() {
    }

    public S45PacketTitle(Type type, IChatComponent iChatComponent) {
        this(type, iChatComponent, -1, -1, -1);
    }

    public S45PacketTitle(int n, int n2, int n3) {
        this(Type.TIMES, null, n, n2, n3);
    }

    public S45PacketTitle(Type type, IChatComponent iChatComponent, int n, int n2, int n3) {
        this.type = type;
        this.message = iChatComponent;
        this.fadeInTime = n;
        this.displayTime = n2;
        this.fadeOutTime = n3;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.type = packetBuffer.readEnumValue(Type.class);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE) {
            this.message = packetBuffer.readChatComponent();
        }
        if (this.type == Type.TIMES) {
            this.fadeInTime = packetBuffer.readInt();
            this.displayTime = packetBuffer.readInt();
            this.fadeOutTime = packetBuffer.readInt();
        }
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeEnumValue(this.type);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE) {
            packetBuffer.writeChatComponent(this.message);
        }
        if (this.type == Type.TIMES) {
            packetBuffer.writeInt(this.fadeInTime);
            packetBuffer.writeInt(this.displayTime);
            packetBuffer.writeInt(this.fadeOutTime);
        }
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handleTitle(this);
    }

    public Type getType() {
        return this.type;
    }

    public IChatComponent getMessage() {
        return this.message;
    }

    public int getFadeInTime() {
        return this.fadeInTime;
    }

    public int getDisplayTime() {
        return this.displayTime;
    }

    public int getFadeOutTime() {
        return this.fadeOutTime;
    }

    public static enum Type {
        TITLE,
        SUBTITLE,
        TIMES,
        CLEAR,
        RESET;


        public static Type byName(String string) {
            for (Type type : Type.values()) {
                if (!type.name().equalsIgnoreCase(string)) continue;
                return type;
            }
            return TITLE;
        }

        public static String[] getNames() {
            String[] stringArray = new String[Type.values().length];
            int n = 0;
            for (Type type : Type.values()) {
                stringArray[n++] = type.name().toLowerCase();
            }
            return stringArray;
        }
    }
}

