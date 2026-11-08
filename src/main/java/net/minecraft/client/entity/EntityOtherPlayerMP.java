/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityOtherPlayerMP
extends AbstractClientPlayer {
    private boolean isItemInUse;
    private int otherPlayerMPPosRotationIncrements;
    private double otherPlayerMPX;
    private double otherPlayerMPY;
    private double otherPlayerMPZ;
    private double otherPlayerMPYaw;
    private double otherPlayerMPPitch;

    public EntityOtherPlayerMP(World world2, GameProfile gameProfile) {
        super(world2, gameProfile);
        this.stepHeight = 0.0f;
        this.noClip = true;
        this.renderOffsetY = 0.25f;
        this.renderDistanceWeight = 10.0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return true;
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n, boolean bl) {
        this.otherPlayerMPX = d;
        this.otherPlayerMPY = d2;
        this.otherPlayerMPZ = d3;
        this.otherPlayerMPYaw = f;
        this.otherPlayerMPPitch = f2;
        this.otherPlayerMPPosRotationIncrements = n;
    }

    public void snapToServerPosition() {
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            this.setPositionAndRotation(this.otherPlayerMPX, this.otherPlayerMPY, this.otherPlayerMPZ, (float)this.otherPlayerMPYaw, (float)this.otherPlayerMPPitch);
            this.otherPlayerMPPosRotationIncrements = 0;
        }
    }

    public double getOtherPlayerMPYaw() {
        return this.otherPlayerMPYaw;
    }

    @Override
    public void onUpdate() {
        this.renderOffsetY = 0.0f;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f = MathHelper.sqrt_double(d * d + d2 * d2) * 4.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.limbSwingAmount += (f - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
        if (!this.isItemInUse && this.isEating() && this.inventory.mainInventory[this.inventory.currentItem] != null) {
            ItemStack itemStack = this.inventory.mainInventory[this.inventory.currentItem];
            this.setItemInUse(this.inventory.mainInventory[this.inventory.currentItem], itemStack.getItem().getMaxItemUseDuration(itemStack));
            this.isItemInUse = true;
        } else if (this.isItemInUse && !this.isEating()) {
            this.clearItemInUse();
            this.isItemInUse = false;
        }
    }

    @Override
    public void onLivingUpdate() {
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            double d;
            double d2 = this.posX + (this.otherPlayerMPX - this.posX) / (double)this.otherPlayerMPPosRotationIncrements;
            double d3 = this.posY + (this.otherPlayerMPY - this.posY) / (double)this.otherPlayerMPPosRotationIncrements;
            double d4 = this.posZ + (this.otherPlayerMPZ - this.posZ) / (double)this.otherPlayerMPPosRotationIncrements;
            for (d = this.otherPlayerMPYaw - (double)this.rotationYaw; d < -180.0; d += 360.0) {
            }
            while (d >= 180.0) {
                d -= 360.0;
            }
            this.rotationYaw = (float)((double)this.rotationYaw + d / (double)this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.otherPlayerMPPitch - (double)this.rotationPitch) / (double)this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(d2, d3, d4);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f2 = (float)Math.atan(-this.motionY * (double)0.2f) * 15.0f;
        if (f > 0.1f) {
            f = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            f = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            f2 = 0.0f;
        }
        this.cameraYaw += (f - this.cameraYaw) * 0.4f;
        this.cameraPitch += (f2 - this.cameraPitch) * 0.8f;
    }

    @Override
    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
        if (n == 0) {
            this.inventory.mainInventory[this.inventory.currentItem] = itemStack;
        } else {
            this.inventory.armorInventory[n - 1] = itemStack;
        }
    }

    @Override
    public void addChatMessage(IChatComponent iChatComponent) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(iChatComponent);
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return false;
    }

    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
}

