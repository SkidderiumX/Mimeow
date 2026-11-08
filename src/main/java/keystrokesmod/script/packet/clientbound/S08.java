/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import x.oc7ab2161b9f;

public class S08
extends SPacket {
    public Vec3 position;
    public float yaw;
    public float pitch;
    public Set<String> enumFlags;

    public S08(S08PacketPlayerPosLook s08PacketPlayerPosLook) {
        super(s08PacketPlayerPosLook);
        this.position = new Vec3(s08PacketPlayerPosLook.getX(), s08PacketPlayerPosLook.getY(), s08PacketPlayerPosLook.getZ());
        this.yaw = s08PacketPlayerPosLook.getYaw();
        this.pitch = s08PacketPlayerPosLook.getPitch();
        Set<S08PacketPlayerPosLook.EnumFlags> set = s08PacketPlayerPosLook.func_179834_f();
        HashSet<String> hashSet = new HashSet<String>(set.size());
        for (S08PacketPlayerPosLook.EnumFlags enumFlags : set) {
            hashSet.add(enumFlags.name());
        }
        this.enumFlags = hashSet;
    }

    public S08(Vec3 vec3, float f, float f2, Set<String> set) {
        super(S08.create(vec3, f, f2, set));
        this.position = vec3;
        this.yaw = f;
        this.pitch = f2;
        this.enumFlags = set;
    }

    private static S08PacketPlayerPosLook create(Vec3 vec3, float f, float f2, Set<String> set) {
        EnumSet<S08PacketPlayerPosLook.EnumFlags> enumSet = EnumSet.noneOf(S08PacketPlayerPosLook.EnumFlags.class);
        for (String string : set) {
            S08PacketPlayerPosLook.EnumFlags enumFlags = oc7ab2161b9f.\u0120(S08PacketPlayerPosLook.EnumFlags.class, string);
            if (enumFlags == null) continue;
            enumSet.add(enumFlags);
        }
        return new S08PacketPlayerPosLook(vec3.x, vec3.y, vec3.z, f, f2, enumSet);
    }
}

