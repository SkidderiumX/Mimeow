/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import java.util.ArrayList;
import java.util.List;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.BlockPos;

public class S27
extends SPacket {
    public float strength;
    public Vec3 position;
    public Vec3 motion;
    public List<Vec3> affectedBlockPositions;

    public S27(S27PacketExplosion s27PacketExplosion) {
        super(s27PacketExplosion);
        this.strength = s27PacketExplosion.getStrength();
        this.position = new Vec3(s27PacketExplosion.getX(), s27PacketExplosion.getY(), s27PacketExplosion.getZ());
        this.motion = new Vec3(s27PacketExplosion.func_149149_c(), s27PacketExplosion.func_149144_d(), s27PacketExplosion.func_149147_e());
        ArrayList<Vec3> arrayList = new ArrayList<Vec3>();
        for (BlockPos blockPos : s27PacketExplosion.getAffectedBlockPositions()) {
            arrayList.add(Vec3.convert(blockPos));
        }
        this.affectedBlockPositions = arrayList;
    }

    public S27(float f, Vec3 vec3, Vec3 vec32, List<Vec3> list) {
        super(S27.create(f, vec3, vec32, list));
        this.strength = f;
        this.position = vec3;
        this.motion = vec32;
        this.affectedBlockPositions = list;
    }

    private static S27PacketExplosion create(float f, Vec3 vec3, Vec3 vec32, List<Vec3> list) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        for (Vec3 vec33 : list) {
            arrayList.add(Vec3.getBlockPos(vec33));
        }
        return new S27PacketExplosion(vec3.x, vec3.y, vec3.z, f, arrayList, Vec3.getVec3(vec32));
    }
}

