/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import keystrokesmod.script.model.SimulatedPlayer;
import keystrokesmod.script.model.Vec3;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;

public class Simulation {
    private final SimulatedPlayer raw;

    private Simulation(SimulatedPlayer simulatedPlayer) {
        this.raw = simulatedPlayer;
    }

    public static Simulation create() {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft == null || minecraft.thePlayer == null || minecraft.thePlayer.movementInput == null) {
            throw new IllegalStateException("Simulation requires an initialized client player");
        }
        MovementInput movementInput = minecraft.thePlayer.movementInput;
        SimulatedPlayer simulatedPlayer = SimulatedPlayer.fromClientPlayer(movementInput);
        return new Simulation(simulatedPlayer);
    }

    public void setForward(float f) {
        this.raw.movementInput.moveForward = f;
    }

    public void setStrafe(float f) {
        this.raw.movementInput.moveStrafe = f;
    }

    public void setJump(boolean bl) {
        this.raw.movementInput.jump = bl;
    }

    public void setSneak(boolean bl) {
        this.raw.movementInput.sneak = bl;
    }

    public void setYaw(float f) {
        this.raw.rotationYaw = f;
    }

    public void setPitch(float f) {
        this.raw.rotationPitch = f;
    }

    public void setSprinting(boolean bl) {
        this.raw.setSprintRequested(bl);
    }

    public void resetState(double d, double d2, double d3, boolean bl) {
        this.raw.resetSimulationState(d, d2, d3, bl);
    }

    public void tick() {
        this.raw.tick();
    }

    public Vec3 getPosition() {
        return this.raw.getPos();
    }

    public Vec3 getMotion() {
        return new Vec3(this.raw.motionX, this.raw.motionY, this.raw.motionZ);
    }

    public boolean onGround() {
        return this.raw.onGround;
    }
}

