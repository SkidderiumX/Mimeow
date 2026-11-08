/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.override;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PlayerControllerOF
extends PlayerControllerMP {
    private boolean acting = false;
    private BlockPos lastClickBlockPos = null;
    private Entity lastClickEntity = null;

    public PlayerControllerOF(Minecraft minecraft, NetHandlerPlayClient netHandlerPlayClient) {
        super(minecraft, netHandlerPlayClient);
    }

    @Override
    public boolean clickBlock(BlockPos blockPos, EnumFacing enumFacing) {
        this.acting = true;
        this.lastClickBlockPos = blockPos;
        boolean bl = super.clickBlock(blockPos, enumFacing);
        this.acting = false;
        return bl;
    }

    @Override
    public boolean onPlayerDamageBlock(BlockPos blockPos, EnumFacing enumFacing) {
        this.acting = true;
        this.lastClickBlockPos = blockPos;
        boolean bl = super.onPlayerDamageBlock(blockPos, enumFacing);
        this.acting = false;
        return bl;
    }

    @Override
    public boolean sendUseItem(EntityPlayer entityPlayer, World world2, ItemStack itemStack) {
        this.acting = true;
        boolean bl = super.sendUseItem(entityPlayer, world2, itemStack);
        this.acting = false;
        return bl;
    }

    @Override
    public boolean onPlayerRightClick(EntityPlayerSP entityPlayerSP, WorldClient worldClient, ItemStack itemStack, BlockPos blockPos, EnumFacing enumFacing, Vec3 vec3) {
        this.acting = true;
        this.lastClickBlockPos = blockPos;
        boolean bl = super.onPlayerRightClick(entityPlayerSP, worldClient, itemStack, blockPos, enumFacing, vec3);
        this.acting = false;
        return bl;
    }

    @Override
    public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {
        this.lastClickEntity = entity;
        return super.interactWithEntitySendPacket(entityPlayer, entity);
    }

    @Override
    public boolean isPlayerRightClickingOnEntity(EntityPlayer entityPlayer, Entity entity, MovingObjectPosition movingObjectPosition) {
        this.lastClickEntity = entity;
        return super.isPlayerRightClickingOnEntity(entityPlayer, entity, movingObjectPosition);
    }

    public boolean isActing() {
        return this.acting;
    }

    public BlockPos getLastClickBlockPos() {
        return this.lastClickBlockPos;
    }

    public Entity getLastClickEntity() {
        return this.lastClickEntity;
    }
}

