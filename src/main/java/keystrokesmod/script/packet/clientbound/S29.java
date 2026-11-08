/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S29PacketSoundEffect;

public class S29
extends SPacket {
    public String sound;
    public Vec3 position;
    public float volume;
    public float pitch;

    public S29(S29PacketSoundEffect s29PacketSoundEffect) {
        super(s29PacketSoundEffect);
        this.sound = s29PacketSoundEffect.getSoundName();
        this.position = new Vec3(s29PacketSoundEffect.getX(), s29PacketSoundEffect.getY(), s29PacketSoundEffect.getZ());
        this.volume = s29PacketSoundEffect.getVolume();
        this.pitch = s29PacketSoundEffect.getPitch();
    }

    public S29(String string, Vec3 vec3, float f, float f2) {
        super(new S29PacketSoundEffect(string, vec3.x, vec3.y, vec3.z, f, f2));
        this.sound = string;
        this.position = vec3;
        this.volume = f;
        this.pitch = f2;
    }
}

