/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import x.oc2f7ef6a217;
import x.oc51cbcffcfe;
import x.oc718fd4d503;
import x.oc8edd24b1ed;
import x.oc9755810e45;
import x.oca6aec23846;
import x.ocb754f4cbfb;
import x.occ48acb5d22;
import x.occ52191e479;
import x.oce21f48fe00;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public class PlayerControllerMP
implements oc51cbcffcfe {
    private final Minecraft mc;
    private final NetHandlerPlayClient netClientHandler;
    private BlockPos currentBlock = new BlockPos(-1, -1, -1);
    private ItemStack currentItemHittingBlock;
    private float curBlockDamageMP;
    private float stepSoundTickCounter;
    private int blockHitDelay;
    private boolean isHittingBlock;
    private WorldSettings.GameType currentGameType = WorldSettings.GameType.SURVIVAL;
    private int currentPlayerItem;

    public PlayerControllerMP(Minecraft minecraft, NetHandlerPlayClient netHandlerPlayClient) {
        this.mc = minecraft;
        this.netClientHandler = netHandlerPlayClient;
    }

    public static void clickBlockCreative(Minecraft minecraft, PlayerControllerMP playerControllerMP, BlockPos blockPos, EnumFacing enumFacing) {
        if (!minecraft.theWorld.extinguishFire(minecraft.thePlayer, blockPos, enumFacing)) {
            playerControllerMP.onPlayerDestroyBlock(blockPos, enumFacing);
        }
    }

    public void setPlayerCapabilities(EntityPlayer entityPlayer) {
        this.currentGameType.configurePlayerCapabilities(entityPlayer.capabilities);
    }

    public boolean isSpectator() {
        return this.currentGameType == WorldSettings.GameType.SPECTATOR;
    }

    public void setGameType(WorldSettings.GameType gameType) {
        this.currentGameType = gameType;
        this.currentGameType.configurePlayerCapabilities(this.mc.thePlayer.capabilities);
    }

    public void flipPlayer(EntityPlayer entityPlayer) {
        entityPlayer.rotationYaw = -180.0f;
    }

    public boolean shouldDrawHUD() {
        return this.currentGameType.isSurvivalOrAdventure();
    }

    public boolean onPlayerDestroyBlock(BlockPos blockPos, EnumFacing enumFacing) {
        ItemStack itemStack;
        Object object;
        Object object2;
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.thePlayer.isAllowEdit()) {
                object2 = this.mc.theWorld.getBlockState(blockPos).getBlock();
                object = this.mc.thePlayer.getCurrentEquippedItem();
                if (object == null) {
                    return false;
                }
                if (!((ItemStack)object).canDestroy((Block)object2)) {
                    return false;
                }
            }
        }
        if (this.currentGameType.isCreative() && this.mc.thePlayer.getHeldItem() != null && this.mc.thePlayer.getHeldItem().getItem() instanceof ItemSword) {
            return false;
        }
        object2 = this.mc.theWorld;
        object = ((World)object2).getBlockState(blockPos);
        Block block = object.getBlock();
        if (block.getMaterial() == Material.air) {
            return false;
        }
        ((World)object2).playAuxSFX(2001, blockPos, Block.getStateId((IBlockState)object));
        boolean bl = ((World)object2).setBlockToAir(blockPos);
        if (bl) {
            block.onBlockDestroyedByPlayer((World)object2, blockPos, (IBlockState)object);
        }
        this.currentBlock = new BlockPos(this.currentBlock.getX(), -1, this.currentBlock.getZ());
        if (!this.currentGameType.isCreative() && (itemStack = this.mc.thePlayer.getCurrentEquippedItem()) != null) {
            itemStack.onBlockDestroyed((World)object2, block, blockPos, this.mc.thePlayer);
            if (itemStack.stackSize == 0) {
                this.mc.thePlayer.destroyCurrentEquippedItem();
            }
        }
        return bl;
    }

    public boolean clickBlock(BlockPos blockPos, EnumFacing enumFacing) {
        Block block;
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.thePlayer.isAllowEdit()) {
                block = this.mc.theWorld.getBlockState(blockPos).getBlock();
                ItemStack itemStack = this.mc.thePlayer.getCurrentEquippedItem();
                if (itemStack == null) {
                    return false;
                }
                if (!itemStack.canDestroy(block)) {
                    return false;
                }
            }
        }
        if (!this.mc.theWorld.getWorldBorder().contains(blockPos)) {
            return false;
        }
        if (this.currentGameType.isCreative()) {
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
            PlayerControllerMP.clickBlockCreative(this.mc, this, blockPos, enumFacing);
            this.blockHitDelay = 5;
            this.mimeow$fastMineAfterClickBlockSetDelay(blockPos, enumFacing, new occ52191e479("clickBlock", false));
        } else if (!this.isHittingBlock || !this.isHittingPosition(blockPos)) {
            boolean bl;
            if (this.isHittingBlock) {
                this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, enumFacing));
            }
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
            block = this.mc.theWorld.getBlockState(blockPos).getBlock();
            boolean bl2 = bl = block.getMaterial() != Material.air;
            if (bl && this.curBlockDamageMP == 0.0f) {
                block.onBlockClicked(this.mc.theWorld, blockPos, this.mc.thePlayer);
            }
            if (bl && block.getPlayerRelativeBlockHardness(this.mc.thePlayer, this.mc.thePlayer.worldObj, blockPos) >= 1.0f) {
                this.onPlayerDestroyBlock(blockPos, enumFacing);
            } else {
                this.isHittingBlock = true;
                this.currentBlock = blockPos;
                this.currentItemHittingBlock = this.mc.thePlayer.getHeldItem();
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
            }
        }
        return true;
    }

    public void resetBlockRemoving() {
        if (this.isHittingBlock) {
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, EnumFacing.DOWN));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.currentBlock, -1);
        }
    }

    public boolean onPlayerDamageBlock(BlockPos blockPos, EnumFacing enumFacing) {
        this.syncCurrentPlayItem();
        if (this.blockHitDelay > 0) {
            --this.blockHitDelay;
            return true;
        }
        if (this.currentGameType.isCreative() && this.mc.theWorld.getWorldBorder().contains(blockPos)) {
            this.blockHitDelay = 5;
            this.mimeow$fastMineAfterCreativeMiningSetDelay(blockPos, enumFacing, new occ52191e479("onPlayerDamageBlock", false));
            this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
            PlayerControllerMP.clickBlockCreative(this.mc, this, blockPos, enumFacing);
            return true;
        }
        if (this.isHittingPosition(blockPos)) {
            Block block = this.mc.theWorld.getBlockState(blockPos).getBlock();
            if (block.getMaterial() == Material.air) {
                this.isHittingBlock = false;
                return false;
            }
            World world2 = this.mc.thePlayer.worldObj;
            EntityPlayerSP entityPlayerSP = this.mc.thePlayer;
            this.curBlockDamageMP += this.mimeow$redirect$fastMineScaleHardness(block, entityPlayerSP, world2, blockPos);
            if (this.stepSoundTickCounter % 4.0f == 0.0f) {
                this.mc.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(block.stepSound.getStepSound()), (block.stepSound.getVolume() + 1.0f) / 8.0f, block.stepSound.getFrequency() * 0.5f, (float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f));
            }
            this.stepSoundTickCounter += 1.0f;
            if (this.curBlockDamageMP >= 1.0f) {
                this.isHittingBlock = false;
                this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, enumFacing));
                this.onPlayerDestroyBlock(blockPos, enumFacing);
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.blockHitDelay = 5;
                this.mimeow$fastMineAfterBreakBlockSetDelay(blockPos, enumFacing, new occ52191e479("onPlayerDamageBlock", false));
            }
            this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
            return true;
        }
        return this.clickBlock(blockPos, enumFacing);
    }

    public float getBlockReachDistance() {
        return this.currentGameType.isCreative() ? 5.0f : 4.5f;
    }

    public void updateController() {
        ocea775c9d5c.\u0173.post(new oca6aec23846());
        this.syncCurrentPlayItem();
        if (this.netClientHandler.getNetworkManager().isChannelOpen()) {
            this.netClientHandler.getNetworkManager().processReceivedPackets();
        } else {
            this.netClientHandler.getNetworkManager().checkDisconnected();
        }
    }

    private boolean isHittingPosition(BlockPos blockPos) {
        boolean bl;
        ItemStack itemStack = this.mc.thePlayer.getHeldItem();
        boolean bl2 = bl = this.currentItemHittingBlock == null && itemStack == null;
        if (this.currentItemHittingBlock != null && itemStack != null) {
            bl = itemStack.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(itemStack, this.currentItemHittingBlock) && (itemStack.isItemStackDamageable() || itemStack.getMetadata() == this.currentItemHittingBlock.getMetadata());
        }
        return blockPos.equals(this.currentBlock) && bl;
    }

    private void syncCurrentPlayItem() {
        int n = oc718fd4d503.\u014c.\u0532();
        if (n != this.currentPlayerItem) {
            this.currentPlayerItem = n;
            this.netClientHandler.addToSendQueue(new C09PacketHeldItemChange(this.currentPlayerItem));
        }
    }

    public boolean onPlayerRightClick(EntityPlayerSP entityPlayerSP, WorldClient worldClient, ItemStack itemStack, BlockPos blockPos, EnumFacing enumFacing, Vec3 vec3) {
        this.syncCurrentPlayItem();
        float f = (float)(vec3.xCoord - (double)blockPos.getX());
        float f2 = (float)(vec3.yCoord - (double)blockPos.getY());
        float f3 = (float)(vec3.zCoord - (double)blockPos.getZ());
        boolean bl = false;
        if (!this.mc.theWorld.getWorldBorder().contains(blockPos)) {
            return false;
        }
        if (this.currentGameType != WorldSettings.GameType.SPECTATOR) {
            ItemBlock itemBlock;
            IBlockState iBlockState = worldClient.getBlockState(blockPos);
            if ((!entityPlayerSP.isSneaking() || entityPlayerSP.getHeldItem() == null) && iBlockState.getBlock().onBlockActivated(worldClient, blockPos, iBlockState, entityPlayerSP, enumFacing, f, f2, f3)) {
                bl = true;
            }
            if (!bl && itemStack != null && itemStack.getItem() instanceof ItemBlock && !(itemBlock = (ItemBlock)itemStack.getItem()).canPlaceBlockOnSide(worldClient, blockPos, enumFacing, entityPlayerSP, itemStack)) {
                return false;
            }
        }
        this.netClientHandler.addToSendQueue(new C08PacketPlayerBlockPlacement(blockPos, enumFacing.getIndex(), entityPlayerSP.inventory.getCurrentItem(), f, f2, f3));
        if (!bl && this.currentGameType != WorldSettings.GameType.SPECTATOR) {
            if (itemStack == null) {
                return false;
            }
            if (this.currentGameType.isCreative()) {
                int n = itemStack.getMetadata();
                int n2 = itemStack.stackSize;
                boolean bl2 = itemStack.onItemUse(entityPlayerSP, worldClient, blockPos, enumFacing, f, f2, f3);
                itemStack.setItemDamage(n);
                itemStack.stackSize = n2;
                return bl2;
            }
            return itemStack.onItemUse(entityPlayerSP, worldClient, blockPos, enumFacing, f, f2, f3);
        }
        return true;
    }

    public boolean sendUseItem(EntityPlayer entityPlayer, World world2, ItemStack itemStack) {
        occ52191e479<Boolean> occ52191e4792 = PlayerControllerMP.createUseItemCallback();
        this.mimeow$injectUseItemEvent(entityPlayer, world2, itemStack, occ52191e4792);
        if (occ52191e4792.z$24lpjeeur71n9()) {
            return occ52191e4792.\u016f();
        }
        if (this.currentGameType == WorldSettings.GameType.SPECTATOR) {
            return false;
        }
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C08PacketPlayerBlockPlacement(entityPlayer.inventory.getCurrentItem()));
        int n = itemStack.stackSize;
        ItemStack itemStack2 = itemStack.useItemRightClick(world2, entityPlayer);
        if (itemStack2 != itemStack || itemStack2 != null && itemStack2.stackSize != n) {
            int n2 = oc718fd4d503.\u014c.\u0548(entityPlayer.inventory);
            entityPlayer.inventory.mainInventory[n2] = itemStack2;
            if (itemStack2.stackSize == 0) {
                entityPlayer.inventory.mainInventory[n2] = null;
            }
            return true;
        }
        return false;
    }

    static occ52191e479<Boolean> createUseItemCallback() {
        return new occ52191e479<Boolean>("sendUseItem", true);
    }

    public EntityPlayerSP func_178892_a(World world2, StatFileWriter statFileWriter) {
        return new EntityPlayerSP(this.mc, world2, this.netClientHandler, statFileWriter);
    }

    public void attackEntity(EntityPlayer entityPlayer, Entity entity) {
        this.attackEntityWithResult(entityPlayer, entity);
    }

    public boolean attackEntityWithResult(EntityPlayer entityPlayer, Entity entity) {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("attackEntity", true);
        this.mimeow$injectAttackEntity(entityPlayer, entity, ocee33618a8d2);
        if (ocee33618a8d2.z$24lpjeeur71n9()) {
            return false;
        }
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
        if (this.currentGameType != WorldSettings.GameType.SPECTATOR) {
            entityPlayer.attackTargetEntityWithCurrentItem(entity);
        }
        return true;
    }

    public boolean interactWithEntitySendPacket(EntityPlayer entityPlayer, Entity entity) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.INTERACT));
        return this.currentGameType != WorldSettings.GameType.SPECTATOR && entityPlayer.interactWith(entity);
    }

    public boolean isPlayerRightClickingOnEntity(EntityPlayer entityPlayer, Entity entity, MovingObjectPosition movingObjectPosition) {
        this.syncCurrentPlayItem();
        Vec3 vec3 = new Vec3(movingObjectPosition.hitVec.xCoord - entity.posX, movingObjectPosition.hitVec.yCoord - entity.posY, movingObjectPosition.hitVec.zCoord - entity.posZ);
        this.netClientHandler.addToSendQueue(new C02PacketUseEntity(entity, vec3));
        return this.currentGameType != WorldSettings.GameType.SPECTATOR && entity.interactAt(entityPlayer, vec3);
    }

    public ItemStack windowClick(int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        short s = entityPlayer.openContainer.getNextTransactionID(entityPlayer.inventory);
        ItemStack itemStack = entityPlayer.openContainer.slotClick(n2, n3, n4, entityPlayer);
        this.netClientHandler.addToSendQueue(new C0EPacketClickWindow(n, n2, n3, n4, itemStack, s));
        ocea775c9d5c.\u0173.post(new oc2f7ef6a217(n, n2, n3, n4));
        return itemStack;
    }

    public void sendEnchantPacket(int n, int n2) {
        this.netClientHandler.addToSendQueue(new C11PacketEnchantItem(n, n2));
    }

    public void sendSlotPacket(ItemStack itemStack, int n) {
        if (this.currentGameType.isCreative()) {
            this.netClientHandler.addToSendQueue(new C10PacketCreativeInventoryAction(n, itemStack));
        }
    }

    public void sendPacketDropItem(ItemStack itemStack) {
        if (this.currentGameType.isCreative() && itemStack != null) {
            this.netClientHandler.addToSendQueue(new C10PacketCreativeInventoryAction(-1, itemStack));
        }
    }

    public void onStoppedUsingItem(EntityPlayer entityPlayer) {
        this.syncCurrentPlayItem();
        this.netClientHandler.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        entityPlayer.stopUsingItem();
    }

    public boolean gameIsSurvivalOrAdventure() {
        return this.currentGameType.isSurvivalOrAdventure();
    }

    public boolean isNotCreative() {
        return !this.currentGameType.isCreative();
    }

    public boolean isInCreativeMode() {
        return this.currentGameType.isCreative();
    }

    public boolean extendedReach() {
        return this.currentGameType.isCreative();
    }

    public boolean isRidingHorse() {
        return this.mc.thePlayer.isRiding() && this.mc.thePlayer.ridingEntity instanceof EntityHorse;
    }

    public boolean isSpectatorMode() {
        return this.currentGameType == WorldSettings.GameType.SPECTATOR;
    }

    public WorldSettings.GameType getCurrentGameType() {
        return this.currentGameType;
    }

    public boolean getIsHittingBlock() {
        return this.isHittingBlock;
    }

    public void mimeow$injectUseItemEvent(EntityPlayer entityPlayer, World world2, ItemStack itemStack, occ52191e479<Boolean> occ52191e4792) {
        oce21f48fe00 oce21f48fe002 = new oce21f48fe00(itemStack);
        ocea775c9d5c.\u0173.post(oce21f48fe002);
        if (oce21f48fe002.isCanceled()) {
            occ52191e4792.\u04ea(false);
        }
    }

    private void mimeow$injectAttackEntity(EntityPlayer entityPlayer, Entity entity, ocee33618a8d ocee33618a8d2) {
        occ48acb5d22 occ48acb5d222 = new occ48acb5d22(entity, entityPlayer, true);
        ocea775c9d5c.\u0173.post(occ48acb5d222);
        if (occ48acb5d222.isCanceled()) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    private float mimeow$redirect$fastMineScaleHardness(Block block, EntityPlayer entityPlayer, World world2, BlockPos blockPos) {
        float f = block.getPlayerRelativeBlockHardness(entityPlayer, world2, blockPos);
        oc8edd24b1ed oc8edd24b1ed2 = oc9755810e45.\u03d4;
        if (oc8edd24b1ed2 != null && oc8edd24b1ed2.\u0554()) {
            return f * oc8edd24b1ed2.\u04c6();
        }
        ocb754f4cbfb ocb754f4cbfb2 = oc9755810e45.\u015b;
        return ocb754f4cbfb2 == null ? f : f * ocb754f4cbfb2.\u0579();
    }

    private void Roven$fastMineApplyBreakDelaySlider() {
        oc8edd24b1ed oc8edd24b1ed2 = oc9755810e45.\u03d4;
        if (oc8edd24b1ed2 != null && oc8edd24b1ed2.\u0554()) {
            int n = oc8edd24b1ed2.\u0289();
            if (n < 5) {
                this.blockHitDelay = n;
            }
        } else {
            int n;
            ocb754f4cbfb ocb754f4cbfb2 = oc9755810e45.\u015b;
            if (ocb754f4cbfb2 != null && (n = ocb754f4cbfb2.\u0129()) >= 0) {
                this.blockHitDelay = n;
            }
        }
    }

    private void mimeow$fastMineAfterClickBlockSetDelay(BlockPos blockPos, EnumFacing enumFacing, occ52191e479 occ52191e4792) {
        this.Roven$fastMineApplyBreakDelaySlider();
    }

    private void mimeow$fastMineAfterCreativeMiningSetDelay(BlockPos blockPos, EnumFacing enumFacing, occ52191e479 occ52191e4792) {
        this.Roven$fastMineApplyBreakDelaySlider();
    }

    private void mimeow$fastMineAfterBreakBlockSetDelay(BlockPos blockPos, EnumFacing enumFacing, occ52191e479 occ52191e4792) {
        this.Roven$fastMineApplyBreakDelaySlider();
    }

    @Override
    public float getCurBlockDamageMP() {
        return this.curBlockDamageMP;
    }

    @Override
    public BlockPos getCurrentBlock() {
        return this.currentBlock;
    }

    @Override
    public void setCurBlockDamageMP(float f) {
        this.curBlockDamageMP = f;
    }

    @Override
    public int getBlockHitDelay() {
        return this.blockHitDelay;
    }

    @Override
    public void setBlockHitDelay(int n) {
        this.blockHitDelay = n;
    }

    @Override
    public boolean isHittingBlock() {
        return this.isHittingBlock;
    }

    @Override
    public int getCurrentPlayerItem() {
        return this.currentPlayerItem;
    }

    @Override
    public void setCurrentPlayerItem(int n) {
        this.currentPlayerItem = n;
    }

    @Override
    public void callSyncCurrentPlayItem() {
        this.syncCurrentPlayItem();
    }
}

