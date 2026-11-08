/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityHorse
extends EntityAnimal
implements IInvBasic {
    private static final Predicate<Entity> horseBreedingSelector = new Predicate<Entity>(){

        @Override
        public boolean apply(Entity entity) {
            return entity instanceof EntityHorse && ((EntityHorse)entity).isBreeding();
        }
    };
    private static final IAttribute horseJumpStrength = new RangedAttribute(null, "horse.jumpStrength", 0.7, 0.0, 2.0).setDescription("Jump Strength").setShouldWatch(true);
    private static final String[] horseArmorTextures = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    private static final String[] HORSE_ARMOR_TEXTURES_ABBR = new String[]{"", "meo", "goo", "dio"};
    private static final int[] armorValues = new int[]{0, 5, 7, 11};
    private static final String[] horseTextures = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    private static final String[] HORSE_TEXTURES_ABBR = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    private static final String[] horseMarkingTextures = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
    private static final String[] HORSE_MARKING_TEXTURES_ABBR = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
    private int eatingHaystackCounter;
    private int openMouthCounter;
    private int jumpRearingCounter;
    public int field_110278_bp;
    public int field_110279_bq;
    protected boolean horseJumping;
    private AnimalChest horseChest;
    private boolean hasReproduced;
    protected int temper;
    protected float jumpPower;
    private boolean field_110294_bI;
    private float headLean;
    private float prevHeadLean;
    private float rearingAmount;
    private float prevRearingAmount;
    private float mouthOpenness;
    private float prevMouthOpenness;
    private int gallopTime;
    private String texturePrefix;
    private String[] horseTexturesArray = new String[3];
    private boolean field_175508_bO = false;

    public EntityHorse(World world2) {
        super(world2);
        this.setSize(1.4f, 1.6f);
        this.isImmuneToFire = false;
        this.setChested(false);
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2));
        this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0));
        this.tasks.addTask(6, new EntityAIWander(this, 0.7));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.initHorseChest();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(19, (byte)0);
        this.dataWatcher.addObject(20, 0);
        this.dataWatcher.addObject(21, String.valueOf(""));
        this.dataWatcher.addObject(22, 0);
    }

    public void setHorseType(int n) {
        this.dataWatcher.updateObject(19, (byte)n);
        this.resetTexturePrefix();
    }

    public int getHorseType() {
        return this.dataWatcher.getWatchableObjectByte(19);
    }

    public void setHorseVariant(int n) {
        this.dataWatcher.updateObject(20, n);
        this.resetTexturePrefix();
    }

    public int getHorseVariant() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        int n = this.getHorseType();
        switch (n) {
            default: {
                return StatCollector.translateToLocal("entity.horse.name");
            }
            case 1: {
                return StatCollector.translateToLocal("entity.donkey.name");
            }
            case 2: {
                return StatCollector.translateToLocal("entity.mule.name");
            }
            case 3: {
                return StatCollector.translateToLocal("entity.zombiehorse.name");
            }
            case 4: 
        }
        return StatCollector.translateToLocal("entity.skeletonhorse.name");
    }

    private boolean getHorseWatchableBoolean(int n) {
        return (this.dataWatcher.getWatchableObjectInt(16) & n) != 0;
    }

    private void setHorseWatchableBoolean(int n, boolean bl) {
        int n2 = this.dataWatcher.getWatchableObjectInt(16);
        if (bl) {
            this.dataWatcher.updateObject(16, n2 | n);
        } else {
            this.dataWatcher.updateObject(16, n2 & ~n);
        }
    }

    public boolean isAdultHorse() {
        return !this.isChild();
    }

    public boolean isTame() {
        return this.getHorseWatchableBoolean(2);
    }

    public boolean func_110253_bW() {
        return this.isAdultHorse();
    }

    public String getOwnerId() {
        return this.dataWatcher.getWatchableObjectString(21);
    }

    public void setOwnerId(String string) {
        this.dataWatcher.updateObject(21, string);
    }

    public float getHorseSize() {
        return 0.5f;
    }

    @Override
    public void setScaleForAge(boolean bl) {
        if (bl) {
            this.setScale(this.getHorseSize());
        } else {
            this.setScale(1.0f);
        }
    }

    public boolean isHorseJumping() {
        return this.horseJumping;
    }

    public void setHorseTamed(boolean bl) {
        this.setHorseWatchableBoolean(2, bl);
    }

    public void setHorseJumping(boolean bl) {
        this.horseJumping = bl;
    }

    @Override
    public boolean allowLeashing() {
        return !this.isUndead() && super.allowLeashing();
    }

    @Override
    protected void func_142017_o(float f) {
        if (f > 6.0f && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }

    public boolean isChested() {
        return this.getHorseWatchableBoolean(8);
    }

    public int getHorseArmorIndexSynced() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    private int getHorseArmorIndex(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        Item item = itemStack.getItem();
        return item == Items.iron_horse_armor ? 1 : (item == Items.golden_horse_armor ? 2 : (item == Items.diamond_horse_armor ? 3 : 0));
    }

    public boolean isEatingHaystack() {
        return this.getHorseWatchableBoolean(32);
    }

    public boolean isRearing() {
        return this.getHorseWatchableBoolean(64);
    }

    public boolean isBreeding() {
        return this.getHorseWatchableBoolean(16);
    }

    public boolean getHasReproduced() {
        return this.hasReproduced;
    }

    public void setHorseArmorStack(ItemStack itemStack) {
        this.dataWatcher.updateObject(22, this.getHorseArmorIndex(itemStack));
        this.resetTexturePrefix();
    }

    public void setBreeding(boolean bl) {
        this.setHorseWatchableBoolean(16, bl);
    }

    public void setChested(boolean bl) {
        this.setHorseWatchableBoolean(8, bl);
    }

    public void setHasReproduced(boolean bl) {
        this.hasReproduced = bl;
    }

    public void setHorseSaddled(boolean bl) {
        this.setHorseWatchableBoolean(4, bl);
    }

    public int getTemper() {
        return this.temper;
    }

    public void setTemper(int n) {
        this.temper = n;
    }

    public int increaseTemper(int n) {
        int n2 = MathHelper.clamp_int(this.getTemper() + n, 0, this.getMaxTemper());
        this.setTemper(n2);
        return n2;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        Entity entity = damageSource.getEntity();
        return this.riddenByEntity != null && this.riddenByEntity.equals(entity) ? false : super.attackEntityFrom(damageSource, f);
    }

    @Override
    public int getTotalArmorValue() {
        return armorValues[this.getHorseArmorIndexSynced()];
    }

    @Override
    public boolean canBePushed() {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn() {
        int n = MathHelper.floor_double(this.posX);
        int n2 = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(new BlockPos(n, 0, n2));
        return true;
    }

    public void dropChests() {
        if (!this.worldObj.isRemote && this.isChested()) {
            this.dropItem(Item.getItemFromBlock(Blocks.chest), 1);
            this.setChested(false);
        }
    }

    private void func_110266_cB() {
        this.openHorseMouth();
        if (!this.isSilent()) {
            this.worldObj.playSoundAtEntity(this, "eating", 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
        }
    }

    @Override
    public void fall(float f, float f2) {
        int n;
        if (f > 1.0f) {
            this.playSound("mob.horse.land", 0.4f, 1.0f);
        }
        if ((n = MathHelper.ceiling_float_int((f * 0.5f - 3.0f) * f2)) > 0) {
            Block block;
            this.attackEntityFrom(DamageSource.fall, n);
            if (this.riddenByEntity != null) {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, n);
            }
            if ((block = this.worldObj.getBlockState(new BlockPos(this.posX, this.posY - 0.2 - (double)this.prevRotationYaw, this.posZ)).getBlock()).getMaterial() != Material.air && !this.isSilent()) {
                Block.SoundType soundType = block.stepSound;
                this.worldObj.playSoundAtEntity(this, soundType.getStepSound(), soundType.getVolume() * 0.5f, soundType.getFrequency() * 0.75f);
            }
        }
    }

    private int getChestSize() {
        int n = this.getHorseType();
        return !this.isChested() || n != 1 && n != 2 ? 2 : 17;
    }

    private void initHorseChest() {
        AnimalChest animalChest = this.horseChest;
        this.horseChest = new AnimalChest("HorseChest", this.getChestSize());
        this.horseChest.setCustomName(this.getName());
        if (animalChest != null) {
            animalChest.removeInventoryChangeListener(this);
            int n = Math.min(animalChest.getSizeInventory(), this.horseChest.getSizeInventory());
            for (int i = 0; i < n; ++i) {
                ItemStack itemStack = animalChest.getStackInSlot(i);
                if (itemStack == null) continue;
                this.horseChest.setInventorySlotContents(i, itemStack.copy());
            }
        }
        this.horseChest.addInventoryChangeListener(this);
        this.updateHorseSlots();
    }

    private void updateHorseSlots() {
        if (!this.worldObj.isRemote) {
            this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);
            if (this.canWearArmor()) {
                this.setHorseArmorStack(this.horseChest.getStackInSlot(1));
            }
        }
    }

    @Override
    public void onInventoryChanged(InventoryBasic inventoryBasic) {
        int n = this.getHorseArmorIndexSynced();
        boolean bl = this.isHorseSaddled();
        this.updateHorseSlots();
        if (this.ticksExisted > 20) {
            if (n == 0 && n != this.getHorseArmorIndexSynced()) {
                this.playSound("mob.horse.armor", 0.5f, 1.0f);
            } else if (n != this.getHorseArmorIndexSynced()) {
                this.playSound("mob.horse.armor", 0.5f, 1.0f);
            }
            if (!bl && this.isHorseSaddled()) {
                this.playSound("mob.horse.leather", 0.5f, 1.0f);
            }
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    protected EntityHorse getClosestHorse(Entity entity, double d) {
        double d2 = Double.MAX_VALUE;
        Entity entity2 = null;
        for (Entity entity3 : this.worldObj.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().addCoord(d, d, d), horseBreedingSelector)) {
            double d3 = entity3.getDistanceSq(entity.posX, entity.posY, entity.posZ);
            if (!(d3 < d2)) continue;
            entity2 = entity3;
            d2 = d3;
        }
        return (EntityHorse)entity2;
    }

    public double getHorseJumpStrength() {
        return this.getEntityAttribute(horseJumpStrength).getAttributeValue();
    }

    @Override
    protected String getDeathSound() {
        this.openHorseMouth();
        int n = this.getHorseType();
        return n == 3 ? "mob.horse.zombie.death" : (n == 4 ? "mob.horse.skeleton.death" : (n != 1 && n != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
    }

    @Override
    protected Item getDropItem() {
        boolean bl = this.rand.nextInt(4) == 0;
        int n = this.getHorseType();
        return n == 4 ? Items.bone : (n == 3 ? (bl ? null : Items.rotten_flesh) : Items.leather);
    }

    @Override
    protected String getHurtSound() {
        int n;
        this.openHorseMouth();
        if (this.rand.nextInt(3) == 0) {
            this.makeHorseRear();
        }
        return (n = this.getHorseType()) == 3 ? "mob.horse.zombie.hit" : (n == 4 ? "mob.horse.skeleton.hit" : (n != 1 && n != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }

    public boolean isHorseSaddled() {
        return this.getHorseWatchableBoolean(4);
    }

    @Override
    protected String getLivingSound() {
        int n;
        this.openHorseMouth();
        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeHorseRear();
        }
        return (n = this.getHorseType()) == 3 ? "mob.horse.zombie.idle" : (n == 4 ? "mob.horse.skeleton.idle" : (n != 1 && n != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }

    protected String getAngrySoundName() {
        this.openHorseMouth();
        this.makeHorseRear();
        int n = this.getHorseType();
        return n != 3 && n != 4 ? (n != 1 && n != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }

    @Override
    protected void playStepSound(BlockPos blockPos, Block block) {
        Block.SoundType soundType = block.stepSound;
        if (this.worldObj.getBlockState(blockPos.up()).getBlock() == Blocks.snow_layer) {
            soundType = Blocks.snow_layer.stepSound;
        }
        if (!block.getMaterial().isLiquid()) {
            int n = this.getHorseType();
            if (this.riddenByEntity != null && n != 1 && n != 2) {
                ++this.gallopTime;
                if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
                    this.playSound("mob.horse.gallop", soundType.getVolume() * 0.15f, soundType.getFrequency());
                    if (n == 0 && this.rand.nextInt(10) == 0) {
                        this.playSound("mob.horse.breathe", soundType.getVolume() * 0.6f, soundType.getFrequency());
                    }
                } else if (this.gallopTime <= 5) {
                    this.playSound("mob.horse.wood", soundType.getVolume() * 0.15f, soundType.getFrequency());
                }
            } else if (soundType == Block.soundTypeWood) {
                this.playSound("mob.horse.wood", soundType.getVolume() * 0.15f, soundType.getFrequency());
            } else {
                this.playSound("mob.horse.soft", soundType.getVolume() * 0.15f, soundType.getFrequency());
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(horseJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.225f);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }

    public int getMaxTemper() {
        return 100;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8f;
    }

    @Override
    public int getTalkInterval() {
        return 400;
    }

    public boolean func_110239_cn() {
        return this.getHorseType() == 0 || this.getHorseArmorIndexSynced() > 0;
    }

    private void resetTexturePrefix() {
        this.texturePrefix = null;
    }

    public boolean func_175507_cI() {
        return this.field_175508_bO;
    }

    private void setHorseTexturePaths() {
        int n;
        this.texturePrefix = "horse/";
        this.horseTexturesArray[0] = null;
        this.horseTexturesArray[1] = null;
        this.horseTexturesArray[2] = null;
        int n2 = this.getHorseType();
        int n3 = this.getHorseVariant();
        if (n2 == 0) {
            n = n3 & 0xFF;
            int n4 = (n3 & 0xFF00) >> 8;
            if (n >= horseTextures.length) {
                this.field_175508_bO = false;
                return;
            }
            this.horseTexturesArray[0] = horseTextures[n];
            this.texturePrefix = this.texturePrefix + HORSE_TEXTURES_ABBR[n];
            if (n4 >= horseMarkingTextures.length) {
                this.field_175508_bO = false;
                return;
            }
            this.horseTexturesArray[1] = horseMarkingTextures[n4];
            this.texturePrefix = this.texturePrefix + HORSE_MARKING_TEXTURES_ABBR[n4];
        } else {
            this.horseTexturesArray[0] = "";
            this.texturePrefix = this.texturePrefix + "_" + n2 + "_";
        }
        n = this.getHorseArmorIndexSynced();
        if (n >= horseArmorTextures.length) {
            this.field_175508_bO = false;
        } else {
            this.horseTexturesArray[2] = horseArmorTextures[n];
            this.texturePrefix = this.texturePrefix + HORSE_ARMOR_TEXTURES_ABBR[n];
            this.field_175508_bO = true;
        }
    }

    public String getHorseTexture() {
        if (this.texturePrefix == null) {
            this.setHorseTexturePaths();
        }
        return this.texturePrefix;
    }

    public String[] getVariantTexturePaths() {
        if (this.texturePrefix == null) {
            this.setHorseTexturePaths();
        }
        return this.horseTexturesArray;
    }

    public void openGUI(EntityPlayer entityPlayer) {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == entityPlayer) && this.isTame()) {
            this.horseChest.setCustomName(this.getName());
            entityPlayer.displayGUIHorse(this, this.horseChest);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory.getCurrentItem();
        if (itemStack != null && itemStack.getItem() == Items.spawn_egg) {
            return super.interact(entityPlayer);
        }
        if (!this.isTame() && this.isUndead()) {
            return false;
        }
        if (this.isTame() && this.isAdultHorse() && entityPlayer.isSneaking()) {
            this.openGUI(entityPlayer);
            return true;
        }
        if (this.func_110253_bW() && this.riddenByEntity != null) {
            return super.interact(entityPlayer);
        }
        if (itemStack != null) {
            boolean bl = false;
            if (this.canWearArmor()) {
                int n = -1;
                if (itemStack.getItem() == Items.iron_horse_armor) {
                    n = 1;
                } else if (itemStack.getItem() == Items.golden_horse_armor) {
                    n = 2;
                } else if (itemStack.getItem() == Items.diamond_horse_armor) {
                    n = 3;
                }
                if (n >= 0) {
                    if (!this.isTame()) {
                        this.makeHorseRearWithSound();
                        return true;
                    }
                    this.openGUI(entityPlayer);
                    return true;
                }
            }
            if (!bl && !this.isUndead()) {
                float f = 0.0f;
                int n = 0;
                int n2 = 0;
                if (itemStack.getItem() == Items.wheat) {
                    f = 2.0f;
                    n = 20;
                    n2 = 3;
                } else if (itemStack.getItem() == Items.sugar) {
                    f = 1.0f;
                    n = 30;
                    n2 = 3;
                } else if (Block.getBlockFromItem(itemStack.getItem()) == Blocks.hay_block) {
                    f = 20.0f;
                    n = 180;
                } else if (itemStack.getItem() == Items.apple) {
                    f = 3.0f;
                    n = 60;
                    n2 = 3;
                } else if (itemStack.getItem() == Items.golden_carrot) {
                    f = 4.0f;
                    n = 60;
                    n2 = 5;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        bl = true;
                        this.setInLove(entityPlayer);
                    }
                } else if (itemStack.getItem() == Items.golden_apple) {
                    f = 10.0f;
                    n = 240;
                    n2 = 10;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        bl = true;
                        this.setInLove(entityPlayer);
                    }
                }
                if (this.getHealth() < this.getMaxHealth() && f > 0.0f) {
                    this.heal(f);
                    bl = true;
                }
                if (!this.isAdultHorse() && n > 0) {
                    this.addGrowth(n);
                    bl = true;
                }
                if (n2 > 0 && (bl || !this.isTame()) && n2 < this.getMaxTemper()) {
                    bl = true;
                    this.increaseTemper(n2);
                }
                if (bl) {
                    this.func_110266_cB();
                }
            }
            if (!this.isTame() && !bl) {
                if (itemStack != null && itemStack.interactWithEntity(entityPlayer, this)) {
                    return true;
                }
                this.makeHorseRearWithSound();
                return true;
            }
            if (!bl && this.canCarryChest() && !this.isChested() && itemStack.getItem() == Item.getItemFromBlock(Blocks.chest)) {
                this.setChested(true);
                this.playSound("mob.chickenplop", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                bl = true;
                this.initHorseChest();
            }
            if (!bl && this.func_110253_bW() && !this.isHorseSaddled() && itemStack.getItem() == Items.saddle) {
                this.openGUI(entityPlayer);
                return true;
            }
            if (bl) {
                if (!entityPlayer.capabilities.isCreativeMode && --itemStack.stackSize == 0) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, null);
                }
                return true;
            }
        }
        if (this.func_110253_bW() && this.riddenByEntity == null) {
            if (itemStack != null && itemStack.interactWithEntity(entityPlayer, this)) {
                return true;
            }
            this.mountTo(entityPlayer);
            return true;
        }
        return super.interact(entityPlayer);
    }

    private void mountTo(EntityPlayer entityPlayer) {
        entityPlayer.rotationYaw = this.rotationYaw;
        entityPlayer.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
    }

    public boolean canWearArmor() {
        return this.getHorseType() == 0;
    }

    public boolean canCarryChest() {
        int n = this.getHorseType();
        return n == 2 || n == 1;
    }

    @Override
    protected boolean isMovementBlocked() {
        return this.riddenByEntity != null && this.isHorseSaddled() ? true : this.isEatingHaystack() || this.isRearing();
    }

    public boolean isUndead() {
        int n = this.getHorseType();
        return n == 3 || n == 4;
    }

    public boolean isSterile() {
        return this.isUndead() || this.getHorseType() == 2;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return false;
    }

    private void func_110210_cH() {
        this.field_110278_bp = 1;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (!this.worldObj.isRemote) {
            this.dropChestItems();
        }
    }

    @Override
    public void onLivingUpdate() {
        if (this.rand.nextInt(200) == 0) {
            this.func_110210_cH();
        }
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            EntityHorse entityHorse;
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0f);
            }
            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ))).getBlock() == Blocks.grass) {
                this.setEatingHaystack(true);
            }
            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50) {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }
            if (this.isBreeding() && !this.isAdultHorse() && !this.isEatingHaystack() && (entityHorse = this.getClosestHorse(this, 16.0)) != null && this.getDistanceSqToEntity(entityHorse) > 4.0) {
                this.navigator.getPathToEntityLiving(entityHorse);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote && this.dataWatcher.hasObjectChanged()) {
            this.dataWatcher.func_111144_e();
            this.resetTexturePrefix();
        }
        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(128, false);
        }
        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }
        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
            this.field_110278_bp = 0;
        }
        if (this.field_110279_bq > 0) {
            ++this.field_110279_bq;
            if (this.field_110279_bq > 300) {
                this.field_110279_bq = 0;
            }
        }
        this.prevHeadLean = this.headLean;
        if (this.isEatingHaystack()) {
            this.headLean += (1.0f - this.headLean) * 0.4f + 0.05f;
            if (this.headLean > 1.0f) {
                this.headLean = 1.0f;
            }
        } else {
            this.headLean += (0.0f - this.headLean) * 0.4f - 0.05f;
            if (this.headLean < 0.0f) {
                this.headLean = 0.0f;
            }
        }
        this.prevRearingAmount = this.rearingAmount;
        if (this.isRearing()) {
            this.headLean = 0.0f;
            this.prevHeadLean = 0.0f;
            this.rearingAmount += (1.0f - this.rearingAmount) * 0.4f + 0.05f;
            if (this.rearingAmount > 1.0f) {
                this.rearingAmount = 1.0f;
            }
        } else {
            this.field_110294_bI = false;
            this.rearingAmount += (0.8f * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6f - 0.05f;
            if (this.rearingAmount < 0.0f) {
                this.rearingAmount = 0.0f;
            }
        }
        this.prevMouthOpenness = this.mouthOpenness;
        if (this.getHorseWatchableBoolean(128)) {
            this.mouthOpenness += (1.0f - this.mouthOpenness) * 0.7f + 0.05f;
            if (this.mouthOpenness > 1.0f) {
                this.mouthOpenness = 1.0f;
            }
        } else {
            this.mouthOpenness += (0.0f - this.mouthOpenness) * 0.7f - 0.05f;
            if (this.mouthOpenness < 0.0f) {
                this.mouthOpenness = 0.0f;
            }
        }
    }

    private void openHorseMouth() {
        if (!this.worldObj.isRemote) {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(128, true);
        }
    }

    private boolean canMate() {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.isAdultHorse() && !this.isSterile() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public void setEating(boolean bl) {
        this.setHorseWatchableBoolean(32, bl);
    }

    public void setEatingHaystack(boolean bl) {
        this.setEating(bl);
    }

    public void setRearing(boolean bl) {
        if (bl) {
            this.setEatingHaystack(false);
        }
        this.setHorseWatchableBoolean(64, bl);
    }

    private void makeHorseRear() {
        if (!this.worldObj.isRemote) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    public void makeHorseRearWithSound() {
        this.makeHorseRear();
        String string = this.getAngrySoundName();
        if (string != null) {
            this.playSound(string, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    public void dropChestItems() {
        this.dropItemsInChest(this, this.horseChest);
        this.dropChests();
    }

    private void dropItemsInChest(Entity entity, AnimalChest animalChest) {
        if (animalChest != null && !this.worldObj.isRemote) {
            for (int i = 0; i < animalChest.getSizeInventory(); ++i) {
                ItemStack itemStack = animalChest.getStackInSlot(i);
                if (itemStack == null) continue;
                this.entityDropItem(itemStack, 0.0f);
            }
        }
    }

    public boolean setTamedBy(EntityPlayer entityPlayer) {
        this.setOwnerId(entityPlayer.getUniqueID().toString());
        this.setHorseTamed(true);
        return true;
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isHorseSaddled()) {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            f = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5f;
            f2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
            if (f2 <= 0.0f) {
                f2 *= 0.25f;
                this.gallopTime = 0;
            }
            if (this.onGround && this.jumpPower == 0.0f && this.isRearing() && !this.field_110294_bI) {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (this.jumpPower > 0.0f && !this.isHorseJumping() && this.onGround) {
                this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;
                if (this.isPotionActive(Potion.jump)) {
                    this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f);
                }
                this.setHorseJumping(true);
                this.isAirBorne = true;
                if (f2 > 0.0f) {
                    float f3 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0f);
                    float f4 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0f);
                    this.motionX += (double)(-0.4f * f3 * this.jumpPower);
                    this.motionZ += (double)(0.4f * f4 * this.jumpPower);
                    this.playSound("mob.horse.jump", 0.4f, 1.0f);
                }
                this.jumpPower = 0.0f;
            }
            this.stepHeight = 1.0f;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
            if (!this.worldObj.isRemote) {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(f, f2);
            }
            if (this.onGround) {
                this.jumpPower = 0.0f;
                this.setHorseJumping(false);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d = this.posX - this.prevPosX;
            double d2 = this.posZ - this.prevPosZ;
            float f5 = MathHelper.sqrt_double(d * d + d2 * d2) * 4.0f;
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
            this.limbSwingAmount += (f5 - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        } else {
            this.stepHeight = 0.5f;
            this.jumpMovementFactor = 0.02f;
            super.moveEntityWithHeading(f, f2);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound.setBoolean("EatingHaystack", this.isEatingHaystack());
        nBTTagCompound.setBoolean("ChestedHorse", this.isChested());
        nBTTagCompound.setBoolean("HasReproduced", this.getHasReproduced());
        nBTTagCompound.setBoolean("Bred", this.isBreeding());
        nBTTagCompound.setInteger("Type", this.getHorseType());
        nBTTagCompound.setInteger("Variant", this.getHorseVariant());
        nBTTagCompound.setInteger("Temper", this.getTemper());
        nBTTagCompound.setBoolean("Tame", this.isTame());
        nBTTagCompound.setString("OwnerUUID", this.getOwnerId());
        if (this.isChested()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (int i = 2; i < this.horseChest.getSizeInventory(); ++i) {
                ItemStack itemStack = this.horseChest.getStackInSlot(i);
                if (itemStack == null) continue;
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2.setByte("Slot", (byte)i);
                itemStack.writeToNBT(nBTTagCompound2);
                nBTTagList.appendTag(nBTTagCompound2);
            }
            nBTTagCompound.setTag("Items", nBTTagList);
        }
        if (this.horseChest.getStackInSlot(1) != null) {
            nBTTagCompound.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }
        if (this.horseChest.getStackInSlot(0) != null) {
            nBTTagCompound.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        Object object;
        Object object2;
        super.readEntityFromNBT(nBTTagCompound);
        this.setEatingHaystack(nBTTagCompound.getBoolean("EatingHaystack"));
        this.setBreeding(nBTTagCompound.getBoolean("Bred"));
        this.setChested(nBTTagCompound.getBoolean("ChestedHorse"));
        this.setHasReproduced(nBTTagCompound.getBoolean("HasReproduced"));
        this.setHorseType(nBTTagCompound.getInteger("Type"));
        this.setHorseVariant(nBTTagCompound.getInteger("Variant"));
        this.setTemper(nBTTagCompound.getInteger("Temper"));
        this.setHorseTamed(nBTTagCompound.getBoolean("Tame"));
        String string = "";
        if (nBTTagCompound.hasKey("OwnerUUID", 8)) {
            string = nBTTagCompound.getString("OwnerUUID");
        } else {
            object2 = nBTTagCompound.getString("Owner");
            string = PreYggdrasilConverter.getStringUUIDFromName((String)object2);
        }
        if (string.length() > 0) {
            this.setOwnerId(string);
        }
        if ((object2 = this.getAttributeMap().getAttributeInstanceByName("Speed")) != null) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(object2.getBaseValue() * 0.25);
        }
        if (this.isChested()) {
            object = nBTTagCompound.getTagList("Items", 10);
            this.initHorseChest();
            for (int i = 0; i < ((NBTTagList)object).tagCount(); ++i) {
                NBTTagCompound nBTTagCompound2 = ((NBTTagList)object).getCompoundTagAt(i);
                int n = nBTTagCompound2.getByte("Slot") & 0xFF;
                if (n < 2 || n >= this.horseChest.getSizeInventory()) continue;
                this.horseChest.setInventorySlotContents(n, ItemStack.loadItemStackFromNBT(nBTTagCompound2));
            }
        }
        if (nBTTagCompound.hasKey("ArmorItem", 10) && (object = ItemStack.loadItemStackFromNBT(nBTTagCompound.getCompoundTag("ArmorItem"))) != null && EntityHorse.isArmorItem(((ItemStack)object).getItem())) {
            this.horseChest.setInventorySlotContents(1, (ItemStack)object);
        }
        if (nBTTagCompound.hasKey("SaddleItem", 10)) {
            object = ItemStack.loadItemStackFromNBT(nBTTagCompound.getCompoundTag("SaddleItem"));
            if (object != null && ((ItemStack)object).getItem() == Items.saddle) {
                this.horseChest.setInventorySlotContents(0, (ItemStack)object);
            }
        } else if (nBTTagCompound.getBoolean("Saddle")) {
            this.horseChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
        }
        this.updateHorseSlots();
    }

    @Override
    public boolean canMateWith(EntityAnimal entityAnimal) {
        if (entityAnimal == this) {
            return false;
        }
        if (entityAnimal.getClass() != this.getClass()) {
            return false;
        }
        EntityHorse entityHorse = (EntityHorse)entityAnimal;
        if (this.canMate() && entityHorse.canMate()) {
            int n;
            int n2 = this.getHorseType();
            return n2 == (n = entityHorse.getHorseType()) || n2 == 0 && n == 1 || n2 == 1 && n == 0;
        }
        return false;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        EntityHorse entityHorse = (EntityHorse)entityAgeable;
        EntityHorse entityHorse2 = new EntityHorse(this.worldObj);
        int n = this.getHorseType();
        int n2 = entityHorse.getHorseType();
        int n3 = 0;
        if (n == n2) {
            n3 = n;
        } else if (n == 0 && n2 == 1 || n == 1 && n2 == 0) {
            n3 = 2;
        }
        if (n3 == 0) {
            int n4 = this.rand.nextInt(9);
            int n5 = n4 < 4 ? this.getHorseVariant() & 0xFF : (n4 < 8 ? entityHorse.getHorseVariant() & 0xFF : this.rand.nextInt(7));
            int n6 = this.rand.nextInt(5);
            n5 = n6 < 2 ? (n5 |= this.getHorseVariant() & 0xFF00) : (n6 < 4 ? (n5 |= entityHorse.getHorseVariant() & 0xFF00) : (n5 |= this.rand.nextInt(5) << 8 & 0xFF00));
            entityHorse2.setHorseVariant(n5);
        }
        entityHorse2.setHorseType(n3);
        double d = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + entityAgeable.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double)this.getModifiedMaxHealth();
        entityHorse2.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d / 3.0);
        double d2 = this.getEntityAttribute(horseJumpStrength).getBaseValue() + entityAgeable.getEntityAttribute(horseJumpStrength).getBaseValue() + this.getModifiedJumpStrength();
        entityHorse2.getEntityAttribute(horseJumpStrength).setBaseValue(d2 / 3.0);
        double d3 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + entityAgeable.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.getModifiedMovementSpeed();
        entityHorse2.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d3 / 3.0);
        return entityHorse2;
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficultyInstance, IEntityLivingData iEntityLivingData) {
        iEntityLivingData = super.onInitialSpawn(difficultyInstance, iEntityLivingData);
        int n = 0;
        int n2 = 0;
        if (iEntityLivingData instanceof GroupData) {
            n = ((GroupData)iEntityLivingData).horseType;
            n2 = ((GroupData)iEntityLivingData).horseVariant & 0xFF | this.rand.nextInt(5) << 8;
        } else {
            if (this.rand.nextInt(10) == 0) {
                n = 1;
            } else {
                int n3 = this.rand.nextInt(7);
                int n4 = this.rand.nextInt(5);
                n = 0;
                n2 = n3 | n4 << 8;
            }
            iEntityLivingData = new GroupData(n, n2);
        }
        this.setHorseType(n);
        this.setHorseVariant(n2);
        if (this.rand.nextInt(5) == 0) {
            this.setGrowingAge(-24000);
        }
        if (n != 4 && n != 3) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getModifiedMaxHealth());
            if (n == 0) {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.getModifiedMovementSpeed());
            } else {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.175f);
            }
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2f);
        }
        if (n != 2 && n != 1) {
            this.getEntityAttribute(horseJumpStrength).setBaseValue(this.getModifiedJumpStrength());
        } else {
            this.getEntityAttribute(horseJumpStrength).setBaseValue(0.5);
        }
        this.setHealth(this.getMaxHealth());
        return iEntityLivingData;
    }

    public float getGrassEatingAmount(float f) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * f;
    }

    public float getRearingAmount(float f) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * f;
    }

    public float getMouthOpennessAngle(float f) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * f;
    }

    public void setJumpPower(int n) {
        if (this.isHorseSaddled()) {
            if (n < 0) {
                n = 0;
            } else {
                this.field_110294_bI = true;
                this.makeHorseRear();
            }
            this.jumpPower = n >= 90 ? 1.0f : 0.4f + 0.4f * (float)n / 90.0f;
        }
    }

    protected void spawnHorseParticles(boolean bl) {
        EnumParticleTypes enumParticleTypes = bl ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;
        for (int i = 0; i < 7; ++i) {
            double d = this.rand.nextGaussian() * 0.02;
            double d2 = this.rand.nextGaussian() * 0.02;
            double d3 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(enumParticleTypes, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3, new int[0]);
        }
    }

    @Override
    public void handleStatusUpdate(byte by) {
        if (by == 7) {
            this.spawnHorseParticles(true);
        } else if (by == 6) {
            this.spawnHorseParticles(false);
        } else {
            super.handleStatusUpdate(by);
        }
    }

    @Override
    public void updateRiderPosition() {
        super.updateRiderPosition();
        if (this.prevRearingAmount > 0.0f) {
            float f = MathHelper.sin(this.renderYawOffset * (float)Math.PI / 180.0f);
            float f2 = MathHelper.cos(this.renderYawOffset * (float)Math.PI / 180.0f);
            float f3 = 0.7f * this.prevRearingAmount;
            float f4 = 0.15f * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + (double)(f3 * f), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double)f4, this.posZ - (double)(f3 * f2));
            if (this.riddenByEntity instanceof EntityLivingBase) {
                ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    private float getModifiedMaxHealth() {
        return 15.0f + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    private double getModifiedJumpStrength() {
        return (double)0.4f + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2;
    }

    private double getModifiedMovementSpeed() {
        return ((double)0.45f + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3) * 0.25;
    }

    public static boolean isArmorItem(Item item) {
        return item == Items.iron_horse_armor || item == Items.golden_horse_armor || item == Items.diamond_horse_armor;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }

    @Override
    public float getEyeHeight() {
        return this.height;
    }

    @Override
    public boolean replaceItemInInventory(int n, ItemStack itemStack) {
        int n2;
        if (n == 499 && this.canCarryChest()) {
            if (itemStack == null && this.isChested()) {
                this.setChested(false);
                this.initHorseChest();
                return true;
            }
            if (itemStack != null && itemStack.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.isChested()) {
                this.setChested(true);
                this.initHorseChest();
                return true;
            }
        }
        if ((n2 = n - 400) >= 0 && n2 < 2 && n2 < this.horseChest.getSizeInventory()) {
            if (n2 == 0 && itemStack != null && itemStack.getItem() != Items.saddle) {
                return false;
            }
            if (n2 != 1 || (itemStack == null || EntityHorse.isArmorItem(itemStack.getItem())) && this.canWearArmor()) {
                this.horseChest.setInventorySlotContents(n2, itemStack);
                this.updateHorseSlots();
                return true;
            }
            return false;
        }
        int n3 = n - 500 + 2;
        if (n3 >= 2 && n3 < this.horseChest.getSizeInventory()) {
            this.horseChest.setInventorySlotContents(n3, itemStack);
            return true;
        }
        return false;
    }

    public static class GroupData
    implements IEntityLivingData {
        public int horseType;
        public int horseVariant;

        public GroupData(int n, int n2) {
            this.horseType = n;
            this.horseVariant = n2;
        }
    }
}

