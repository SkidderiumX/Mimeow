/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EntitySilverfish
extends EntityMob {
    private AISummonSilverfish summonSilverfish;

    public EntitySilverfish(World world2) {
        super(world2);
        this.setSize(0.4f, 0.3f);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.summonSilverfish = new AISummonSilverfish(this);
        this.tasks.addTask(3, this.summonSilverfish);
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(5, new AIHideInStone(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>((EntityCreature)this, EntityPlayer.class, true));
    }

    @Override
    public double getYOffset() {
        return 0.2;
    }

    @Override
    public float getEyeHeight() {
        return 0.1f;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected String getLivingSound() {
        return "mob.silverfish.say";
    }

    @Override
    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }

    @Override
    protected String getDeathSound() {
        return "mob.silverfish.kill";
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        }
        if (damageSource instanceof EntityDamageSource || damageSource == DamageSource.magic) {
            this.summonSilverfish.func_179462_f();
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    protected void playStepSound(BlockPos blockPos, Block block) {
        this.playSound("mob.silverfish.step", 0.15f, 1.0f);
    }

    @Override
    protected Item getDropItem() {
        return null;
    }

    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }

    @Override
    public float getBlockPathWeight(BlockPos blockPos) {
        return this.worldObj.getBlockState(blockPos.down()).getBlock() == Blocks.stone ? 10.0f : super.getBlockPathWeight(blockPos);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            EntityPlayer entityPlayer = this.worldObj.getClosestPlayerToEntity(this, 5.0);
            return entityPlayer == null;
        }
        return false;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public static class AISummonSilverfish
    extends EntityAIBase {
        private EntitySilverfish silverfish;
        private int field_179463_b;

        public AISummonSilverfish(EntitySilverfish entitySilverfish) {
            this.silverfish = entitySilverfish;
        }

        public void func_179462_f() {
            if (this.field_179463_b == 0) {
                this.field_179463_b = 20;
            }
        }

        @Override
        public boolean shouldExecute() {
            return this.field_179463_b > 0;
        }

        @Override
        public void updateTask() {
            --this.field_179463_b;
            if (this.field_179463_b <= 0) {
                World world2 = this.silverfish.worldObj;
                Random random = this.silverfish.getRNG();
                BlockPos blockPos = new BlockPos(this.silverfish);
                int n = 0;
                while (n <= 5 && n >= -5) {
                    int n2 = 0;
                    while (n2 <= 10 && n2 >= -10) {
                        int n3 = 0;
                        while (n3 <= 10 && n3 >= -10) {
                            BlockPos blockPos2 = blockPos.add(n2, n, n3);
                            IBlockState iBlockState = world2.getBlockState(blockPos2);
                            if (iBlockState.getBlock() == Blocks.monster_egg) {
                                if (world2.getGameRules().getBoolean("mobGriefing")) {
                                    world2.destroyBlock(blockPos2, true);
                                } else {
                                    world2.setBlockState(blockPos2, iBlockState.getValue(BlockSilverfish.VARIANT).getModelBlock(), 3);
                                }
                                if (random.nextBoolean()) {
                                    return;
                                }
                            }
                            n3 = n3 <= 0 ? 1 - n3 : 0 - n3;
                        }
                        n2 = n2 <= 0 ? 1 - n2 : 0 - n2;
                    }
                    n = n <= 0 ? 1 - n : 0 - n;
                }
            }
        }
    }

    public static class AIHideInStone
    extends EntityAIWander {
        private final EntitySilverfish silverfish;
        private EnumFacing facing;
        private boolean field_179484_c;

        public AIHideInStone(EntitySilverfish entitySilverfish) {
            super(entitySilverfish, 1.0, 10);
            this.silverfish = entitySilverfish;
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            if (this.silverfish.getAttackTarget() != null) {
                return false;
            }
            if (!this.silverfish.getNavigator().noPath()) {
                return false;
            }
            Random random = this.silverfish.getRNG();
            if (random.nextInt(10) == 0) {
                this.facing = EnumFacing.random(random);
                BlockPos blockPos = new BlockPos(this.silverfish.posX, this.silverfish.posY + 0.5, this.silverfish.posZ).offset(this.facing);
                IBlockState iBlockState = this.silverfish.worldObj.getBlockState(blockPos);
                if (BlockSilverfish.canContainSilverfish(iBlockState)) {
                    this.field_179484_c = true;
                    return true;
                }
            }
            this.field_179484_c = false;
            return super.shouldExecute();
        }

        @Override
        public boolean continueExecuting() {
            return this.field_179484_c ? false : super.continueExecuting();
        }

        @Override
        public void startExecuting() {
            if (!this.field_179484_c) {
                super.startExecuting();
            } else {
                World world2 = this.silverfish.worldObj;
                BlockPos blockPos = new BlockPos(this.silverfish.posX, this.silverfish.posY + 0.5, this.silverfish.posZ).offset(this.facing);
                IBlockState iBlockState = world2.getBlockState(blockPos);
                if (BlockSilverfish.canContainSilverfish(iBlockState)) {
                    world2.setBlockState(blockPos, Blocks.monster_egg.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.forModelBlock(iBlockState)), 3);
                    this.silverfish.spawnExplosionParticle();
                    this.silverfish.setDead();
                }
            }
        }
    }
}

