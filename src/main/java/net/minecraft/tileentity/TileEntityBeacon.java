/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;

public class TileEntityBeacon
extends TileEntityLockable
implements ITickable,
IInventory {
    public static final Potion[][] effectsList = new Potion[][]{{Potion.moveSpeed, Potion.digSpeed}, {Potion.resistance, Potion.jump}, {Potion.damageBoost}, {Potion.regeneration}};
    private final List<BeamSegment> beamSegments = Lists.newArrayList();
    private long beamRenderCounter;
    private float field_146014_j;
    private boolean isComplete;
    private int levels = -1;
    private int primaryEffect;
    private int secondaryEffect;
    private ItemStack payment;
    private String customName;

    @Override
    public void update() {
        if (this.worldObj.getTotalWorldTime() % 80L == 0L) {
            this.updateBeacon();
        }
    }

    public void updateBeacon() {
        this.updateSegmentColors();
        this.addEffectsToPlayers();
    }

    private void addEffectsToPlayers() {
        if (this.isComplete && this.levels > 0 && !this.worldObj.isRemote && this.primaryEffect > 0) {
            double d = this.levels * 10 + 10;
            int n = 0;
            if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
                n = 1;
            }
            int n2 = this.pos.getX();
            int n3 = this.pos.getY();
            int n4 = this.pos.getZ();
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(n2, n3, n4, n2 + 1, n3 + 1, n4 + 1).expand(d, d, d).addCoord(0.0, this.worldObj.getHeight(), 0.0);
            List<EntityPlayer> list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisAlignedBB);
            for (EntityPlayer entityPlayer : list) {
                entityPlayer.addPotionEffect(new PotionEffect(this.primaryEffect, 180, n, true, true));
            }
            if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect > 0) {
                for (EntityPlayer entityPlayer : list) {
                    entityPlayer.addPotionEffect(new PotionEffect(this.secondaryEffect, 180, 0, true, true));
                }
            }
        }
    }

    private void updateSegmentColors() {
        int n;
        int n2 = this.levels;
        int n3 = this.pos.getX();
        int n4 = this.pos.getY();
        int n5 = this.pos.getZ();
        this.levels = 0;
        this.beamSegments.clear();
        this.isComplete = true;
        BeamSegment beamSegment = new BeamSegment(EntitySheep.getDyeRgb(EnumDyeColor.WHITE));
        this.beamSegments.add(beamSegment);
        boolean bl = true;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (n = n4 + 1; n < 256; ++n) {
            float[] bl2;
            IBlockState object = this.worldObj.getBlockState(mutableBlockPos.set(n3, n, n5));
            if (object.getBlock() == Blocks.stained_glass) {
                bl2 = EntitySheep.getDyeRgb(object.getValue(BlockStainedGlass.COLOR));
            } else {
                if (object.getBlock() != Blocks.stained_glass_pane) {
                    if (object.getBlock().getLightOpacity() >= 15 && object.getBlock() != Blocks.bedrock) {
                        this.isComplete = false;
                        this.beamSegments.clear();
                        break;
                    }
                    beamSegment.incrementHeight();
                    continue;
                }
                bl2 = EntitySheep.getDyeRgb(object.getValue(BlockStainedGlassPane.COLOR));
            }
            if (!bl) {
                bl2 = new float[]{(beamSegment.getColors()[0] + bl2[0]) / 2.0f, (beamSegment.getColors()[1] + bl2[1]) / 2.0f, (beamSegment.getColors()[2] + bl2[2]) / 2.0f};
            }
            if (Arrays.equals(bl2, beamSegment.getColors())) {
                beamSegment.incrementHeight();
            } else {
                beamSegment = new BeamSegment(bl2);
                this.beamSegments.add(beamSegment);
            }
            bl = false;
        }
        if (this.isComplete) {
            int n6;
            n = 1;
            while (n <= 4 && (n6 = n4 - n) >= 0) {
                boolean bl2 = true;
                block2: for (int i = n3 - n; i <= n3 + n && bl2; ++i) {
                    for (int j = n5 - n; j <= n5 + n; ++j) {
                        Block block = this.worldObj.getBlockState(new BlockPos(i, n6, j)).getBlock();
                        if (block == Blocks.emerald_block || block == Blocks.gold_block || block == Blocks.diamond_block || block == Blocks.iron_block) continue;
                        bl2 = false;
                        continue block2;
                    }
                }
                if (!bl2) break;
                this.levels = n++;
            }
            if (this.levels == 0) {
                this.isComplete = false;
            }
        }
        if (!this.worldObj.isRemote && this.levels == 4 && n2 < this.levels) {
            for (EntityPlayer entityPlayer : this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(n3, n4, n5, n3, n4 - 4, n5).expand(10.0, 5.0, 10.0))) {
                entityPlayer.triggerAchievement(AchievementList.fullBeacon);
            }
        }
    }

    public List<BeamSegment> getBeamSegments() {
        return this.beamSegments;
    }

    public float shouldBeamRender() {
        if (!this.isComplete) {
            return 0.0f;
        }
        int n = (int)(this.worldObj.getTotalWorldTime() - this.beamRenderCounter);
        this.beamRenderCounter = this.worldObj.getTotalWorldTime();
        if (n > 1) {
            this.field_146014_j -= (float)n / 40.0f;
            if (this.field_146014_j < 0.0f) {
                this.field_146014_j = 0.0f;
            }
        }
        this.field_146014_j += 0.025f;
        if (this.field_146014_j > 1.0f) {
            this.field_146014_j = 1.0f;
        }
        return this.field_146014_j;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new S35PacketUpdateTileEntity(this.pos, 3, nBTTagCompound);
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }

    private int func_183001_h(int n) {
        if (n >= 0 && n < Potion.potionTypes.length && Potion.potionTypes[n] != null) {
            Potion potion = Potion.potionTypes[n];
            return potion != Potion.moveSpeed && potion != Potion.digSpeed && potion != Potion.resistance && potion != Potion.jump && potion != Potion.damageBoost && potion != Potion.regeneration ? 0 : n;
        }
        return 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this.primaryEffect = this.func_183001_h(nBTTagCompound.getInteger("Primary"));
        this.secondaryEffect = this.func_183001_h(nBTTagCompound.getInteger("Secondary"));
        this.levels = nBTTagCompound.getInteger("Levels");
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound.setInteger("Primary", this.primaryEffect);
        nBTTagCompound.setInteger("Secondary", this.secondaryEffect);
        nBTTagCompound.setInteger("Levels", this.levels);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return n == 0 ? this.payment : null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (n == 0 && this.payment != null) {
            if (n2 >= this.payment.stackSize) {
                ItemStack itemStack = this.payment;
                this.payment = null;
                return itemStack;
            }
            this.payment.stackSize -= n2;
            return new ItemStack(this.payment.getItem(), n2, this.payment.getMetadata());
        }
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int n) {
        if (n == 0 && this.payment != null) {
            ItemStack itemStack = this.payment;
            this.payment = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (n == 0) {
            this.payment = itemStack;
        }
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.beacon";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setName(String string) {
        this.customName = string;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : entityPlayer.getDistanceSq((double)this.pos.getX() + 0.5, (double)this.pos.getY() + 0.5, (double)this.pos.getZ() + 0.5) <= 64.0;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {
    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return itemStack.getItem() == Items.emerald || itemStack.getItem() == Items.diamond || itemStack.getItem() == Items.gold_ingot || itemStack.getItem() == Items.iron_ingot;
    }

    @Override
    public String getGuiID() {
        return "minecraft:beacon";
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        return new ContainerBeacon(inventoryPlayer, this);
    }

    @Override
    public int getField(int n) {
        switch (n) {
            case 0: {
                return this.levels;
            }
            case 1: {
                return this.primaryEffect;
            }
            case 2: {
                return this.secondaryEffect;
            }
        }
        return 0;
    }

    @Override
    public void setField(int n, int n2) {
        switch (n) {
            case 0: {
                this.levels = n2;
                break;
            }
            case 1: {
                this.primaryEffect = this.func_183001_h(n2);
                break;
            }
            case 2: {
                this.secondaryEffect = this.func_183001_h(n2);
            }
        }
    }

    @Override
    public int getFieldCount() {
        return 3;
    }

    @Override
    public void clear() {
        this.payment = null;
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 1) {
            this.updateBeacon();
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    public static class BeamSegment {
        private final float[] colors;
        private int height;

        public BeamSegment(float[] fArray) {
            this.colors = fArray;
            this.height = 1;
        }

        protected void incrementHeight() {
            ++this.height;
        }

        public float[] getColors() {
            return this.colors;
        }

        public int getHeight() {
            return this.height;
        }
    }
}

