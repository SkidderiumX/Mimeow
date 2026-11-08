/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.Block;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.util.BlockPos;

public class S25
extends SPacket {
    public int entityId;
    public Block block;
    public int progress;

    public S25(S25PacketBlockBreakAnim s25PacketBlockBreakAnim) {
        super(s25PacketBlockBreakAnim);
        this.entityId = s25PacketBlockBreakAnim.getBreakerId();
        this.block = new Block(Vec3.convert(s25PacketBlockBreakAnim.getPosition()));
        this.progress = s25PacketBlockBreakAnim.getProgress();
    }

    public S25(int n, Block block, int n2) {
        super(new S25PacketBlockBreakAnim(n, new BlockPos(block.x, block.y, block.z), n2));
        this.entityId = n;
        this.block = block;
        this.progress = n2;
    }

    public S25(int n, Vec3 vec3, int n2) {
        super(new S25PacketBlockBreakAnim(n, Vec3.getBlockPos(vec3), n2));
        this.entityId = n;
        this.block = new Block(vec3);
        this.progress = n2;
    }
}

