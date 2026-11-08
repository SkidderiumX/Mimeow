/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.Block;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;

public class S23
extends SPacket {
    public Vec3 position;
    public Block block;

    public S23(S23PacketBlockChange s23PacketBlockChange, byte by) {
        super(s23PacketBlockChange);
        this.position = Vec3.convert(s23PacketBlockChange.getBlockPosition());
        this.block = new Block(s23PacketBlockChange.getBlockState(), new BlockPos(this.position.x, this.position.y, this.position.z));
    }

    public S23(Vec3 vec3) {
        super(new S23PacketBlockChange(Minecraft.getMinecraft().theWorld, Vec3.getBlockPos(vec3)));
        this.position = vec3;
        this.block = new Block(vec3);
    }
}

