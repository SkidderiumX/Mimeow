/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S08PacketPlayerPosLook
implements Packet<INetHandlerPlayClient> {
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private Set<EnumFlags> field_179835_f;

    public S08PacketPlayerPosLook() {
    }

    public S08PacketPlayerPosLook(double d, double d2, double d3, float f, float f2, Set<EnumFlags> set) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.yaw = f;
        this.pitch = f2;
        this.field_179835_f = set;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) throws IOException {
        this.x = packetBuffer.readDouble();
        this.y = packetBuffer.readDouble();
        this.z = packetBuffer.readDouble();
        this.yaw = packetBuffer.readFloat();
        this.pitch = packetBuffer.readFloat();
        this.field_179835_f = EnumFlags.func_180053_a(packetBuffer.readUnsignedByte());
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) throws IOException {
        packetBuffer.writeDouble(this.x);
        packetBuffer.writeDouble(this.y);
        packetBuffer.writeDouble(this.z);
        packetBuffer.writeFloat(this.yaw);
        packetBuffer.writeFloat(this.pitch);
        packetBuffer.writeByte(EnumFlags.func_180056_a(this.field_179835_f));
    }

    @Override
    public void processPacket(INetHandlerPlayClient iNetHandlerPlayClient) {
        iNetHandlerPlayClient.handlePlayerPosLook(this);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public Set<EnumFlags> func_179834_f() {
        return this.field_179835_f;
    }

    public static enum EnumFlags {
        X(0),
        Y(1),
        Z(2),
        Y_ROT(3),
        X_ROT(4);

        private int field_180058_f;

        private EnumFlags(int n2) {
            this.field_180058_f = n2;
        }

        private int func_180055_a() {
            return 1 << this.field_180058_f;
        }

        private boolean func_180054_b(int n) {
            return (n & this.func_180055_a()) == this.func_180055_a();
        }

        public static Set<EnumFlags> func_180053_a(int n) {
            EnumSet<EnumFlags> enumSet = EnumSet.noneOf(EnumFlags.class);
            for (EnumFlags enumFlags : EnumFlags.values()) {
                if (!enumFlags.func_180054_b(n)) continue;
                enumSet.add(enumFlags);
            }
            return enumSet;
        }

        public static int func_180056_a(Set<EnumFlags> set) {
            int n = 0;
            for (EnumFlags enumFlags : set) {
                n |= enumFlags.func_180055_a();
            }
            return n;
        }
    }
}

