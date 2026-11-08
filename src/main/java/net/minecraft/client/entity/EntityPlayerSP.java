/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovementInput;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import x.T;
import x.oc057a60a0eb;
import x.oc0e4b758d9a;
import x.oc1059074ce8;
import x.oc205fefdaba;
import x.oc25aa89b91f;
import x.oc2f61de30bc;
import x.oc4557683e94;
import x.oc51fb428ba0;
import x.oc56ed92c768;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.ocabfbeb7421;
import x.occ0e417c6e5;
import x.ocd2c4efd8d9;
import x.oce3cc81daa8;
import x.ocea775c9d5c;
import x.ocebec3dfd67;
import x.ocee33618a8d;

public class EntityPlayerSP
extends AbstractClientPlayer
implements occ0e417c6e5 {
    public final NetHandlerPlayClient sendQueue;
    private final StatFileWriter statWriter;
    private double lastReportedPosX;
    private double lastReportedPosY;
    private double lastReportedPosZ;
    private float lastReportedYaw;
    private float lastReportedPitch;
    private boolean serverSneakState;
    private boolean serverSprintState;
    private int positionUpdateTicks;
    private boolean hasValidHealth;
    private String clientBrand;
    public MovementInput movementInput;
    protected Minecraft mc;
    protected int sprintToggleTimer;
    public int sprintingTicksLeft;
    public float renderArmYaw;
    public float renderArmPitch;
    public float prevRenderArmYaw;
    public float prevRenderArmPitch;
    private int horseJumpPowerCounter;
    private float horseJumpPower;
    public float timeInPortal;
    public float prevTimeInPortal;

    public EntityPlayerSP(Minecraft minecraft, World world2, NetHandlerPlayClient netHandlerPlayClient, StatFileWriter statFileWriter) {
        super(world2, netHandlerPlayClient.getGameProfile());
        this.sendQueue = netHandlerPlayClient;
        this.statWriter = statFileWriter;
        this.mc = minecraft;
        this.dimension = 0;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return false;
    }

    @Override
    public void heal(float f) {
    }

    @Override
    public void mountEntity(Entity entity) {
        super.mountEntity(entity);
        if (entity instanceof EntityMinecart) {
            this.mc.getSoundHandler().playSound(new MovingSoundMinecartRiding(this, (EntityMinecart)entity));
        }
    }

    @Override
    public void onUpdate() {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("onUpdate", true);
        this.mimeow$onUpdatePre(ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
                super.onUpdate();
                if (this.isRiding()) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
                    this.sendQueue.addToSendQueue(new C0CPacketInput(this.moveStrafing, this.moveForward, this.movementInput.jump, this.movementInput.sneak));
                } else {
                    this.onUpdateWalkingPlayer();
                }
            }
            this.mimeow$onUpdatePost(new ocee33618a8d("onUpdate", false));
        }
    }

    @Override
    public EntityItem dropOneItem(boolean bl) {
        C07PacketPlayerDigging.Action action = bl ? C07PacketPlayerDigging.Action.DROP_ALL_ITEMS : C07PacketPlayerDigging.Action.DROP_ITEM;
        this.sendQueue.addToSendQueue(new C07PacketPlayerDigging(action, BlockPos.ORIGIN, EnumFacing.DOWN));
        return null;
    }

    @Override
    protected void joinEntityItemWithWorld(EntityItem entityItem) {
    }

    public void sendChatMessage(String string) {
        this.sendQueue.addToSendQueue(new C01PacketChatMessage(string));
    }

    @Override
    public void swingItem() {
        if (oc51fb428ba0.\u0241()) {
            return;
        }
        super.swingItem();
        this.sendQueue.addToSendQueue(new C0APacketAnimation());
    }

    @Override
    public void respawnPlayer() {
        this.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
    }

    @Override
    protected void damageEntity(DamageSource damageSource, float f) {
        if (!this.isEntityInvulnerable(damageSource)) {
            this.setHealth(this.getHealth() - f);
        }
    }

    @Override
    public void closeScreen() {
        this.sendQueue.addToSendQueue(new C0DPacketCloseWindow(this.openContainer.windowId));
        this.closeScreenAndDropStack();
    }

    public void closeScreenAndDropStack() {
        this.inventory.setItemStack(null);
        super.closeScreen();
        this.mc.displayGuiScreen(null);
    }

    public void setPlayerSPHealth(float f) {
        if (this.hasValidHealth) {
            float f2 = this.getHealth() - f;
            if (f2 <= 0.0f) {
                this.setHealth(f);
                if (f2 < 0.0f) {
                    this.hurtResistantTime = this.maxHurtResistantTime / 2;
                }
            } else {
                this.lastDamage = f2;
                this.setHealth(this.getHealth());
                this.hurtResistantTime = this.maxHurtResistantTime;
                this.damageEntity(DamageSource.generic, f2);
                this.maxHurtTime = 10;
                this.hurtTime = 10;
            }
        } else {
            this.setHealth(f);
            this.hasValidHealth = true;
        }
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        if (statBase != null && statBase.isIndependent) {
            super.addStat(statBase, n);
        }
    }

    @Override
    public void sendPlayerAbilities() {
        this.sendQueue.addToSendQueue(new C13PacketPlayerAbilities(this.capabilities));
    }

    @Override
    public boolean isUser() {
        return true;
    }

    protected void sendHorseJump() {
        this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.RIDING_JUMP, (int)(this.getHorseJumpPower() * 100.0f)));
    }

    public void sendHorseInventory() {
        this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.OPEN_INVENTORY));
    }

    public void setClientBrand(String string) {
        this.clientBrand = string;
    }

    public String getClientBrand() {
        return this.clientBrand;
    }

    public StatFileWriter getStatFileWriter() {
        return this.statWriter;
    }

    @Override
    public void addChatComponentMessage(IChatComponent iChatComponent) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(iChatComponent);
    }

    @Override
    protected boolean pushOutOfBlocks(double d, double d2, double d3) {
        oc205fefdaba oc205fefdaba2 = new oc205fefdaba();
        ocea775c9d5c.\u0173.post(oc205fefdaba2);
        if (oc205fefdaba2.isCanceled()) {
            return false;
        }
        if (this.noClip) {
            return false;
        }
        BlockPos blockPos = new BlockPos(d, d2, d3);
        double d4 = d - (double)blockPos.getX();
        double d5 = d3 - (double)blockPos.getZ();
        if (!this.isOpenBlockSpace(blockPos)) {
            int n = -1;
            double d6 = 9999.0;
            if (this.isOpenBlockSpace(blockPos.west()) && d4 < d6) {
                d6 = d4;
                n = 0;
            }
            if (this.isOpenBlockSpace(blockPos.east()) && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                n = 1;
            }
            if (this.isOpenBlockSpace(blockPos.north()) && d5 < d6) {
                d6 = d5;
                n = 4;
            }
            if (this.isOpenBlockSpace(blockPos.south()) && 1.0 - d5 < d6) {
                d6 = 1.0 - d5;
                n = 5;
            }
            float f = 0.1f;
            if (n == 0) {
                this.motionX = -f;
            }
            if (n == 1) {
                this.motionX = f;
            }
            if (n == 4) {
                this.motionZ = -f;
            }
            if (n == 5) {
                this.motionZ = f;
            }
        }
        return false;
    }

    private boolean isOpenBlockSpace(BlockPos blockPos) {
        return !this.worldObj.getBlockState(blockPos).getBlock().isNormalCube() && !this.worldObj.getBlockState(blockPos.up()).getBlock().isNormalCube();
    }

    @Override
    public void setSprinting(boolean bl) {
        super.setSprinting(bl);
        this.sprintingTicksLeft = bl ? 600 : 0;
    }

    public void setXPStats(float f, int n, int n2) {
        this.experience = f;
        this.experienceTotal = n;
        this.experienceLevel = n2;
    }

    @Override
    public void addChatMessage(IChatComponent iChatComponent) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(iChatComponent);
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return n <= 0;
    }

    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }

    @Override
    public void playSound(String string, float f, float f2) {
        this.worldObj.playSound(this.posX, this.posY, this.posZ, string, f, f2, false);
    }

    @Override
    public boolean isServerWorld() {
        return true;
    }

    public boolean isRidingHorse() {
        return this.ridingEntity != null && this.ridingEntity instanceof EntityHorse && ((EntityHorse)this.ridingEntity).isHorseSaddled();
    }

    public float getHorseJumpPower() {
        return this.horseJumpPower;
    }

    @Override
    public void openEditSign(TileEntitySign tileEntitySign) {
        this.mc.displayGuiScreen(new GuiEditSign(tileEntitySign));
    }

    @Override
    public void openEditCommandBlock(CommandBlockLogic commandBlockLogic) {
        this.mc.displayGuiScreen(new GuiCommandBlock(commandBlockLogic));
    }

    @Override
    public void displayGUIBook(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item == Items.writable_book) {
            this.mc.displayGuiScreen(new GuiScreenBook(this, itemStack, true));
        }
    }

    @Override
    public void displayGUIChest(IInventory iInventory) {
        String string;
        String string2 = string = iInventory instanceof IInteractionObject ? ((IInteractionObject)((Object)iInventory)).getGuiID() : "minecraft:container";
        if ("minecraft:chest".equals(string)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, iInventory));
        } else if ("minecraft:hopper".equals(string)) {
            this.mc.displayGuiScreen(new GuiHopper(this.inventory, iInventory));
        } else if ("minecraft:furnace".equals(string)) {
            this.mc.displayGuiScreen(new GuiFurnace(this.inventory, iInventory));
        } else if ("minecraft:brewing_stand".equals(string)) {
            this.mc.displayGuiScreen(new GuiBrewingStand(this.inventory, iInventory));
        } else if ("minecraft:beacon".equals(string)) {
            this.mc.displayGuiScreen(new GuiBeacon(this.inventory, iInventory));
        } else if (!"minecraft:dispenser".equals(string) && !"minecraft:dropper".equals(string)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, iInventory));
        } else {
            this.mc.displayGuiScreen(new GuiDispenser(this.inventory, iInventory));
        }
    }

    @Override
    public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
        this.mc.displayGuiScreen(new GuiScreenHorseInventory(this.inventory, iInventory, entityHorse));
    }

    @Override
    public void displayGui(IInteractionObject iInteractionObject) {
        String string = iInteractionObject.getGuiID();
        if ("minecraft:crafting_table".equals(string)) {
            this.mc.displayGuiScreen(new GuiCrafting(this.inventory, this.worldObj));
        } else if ("minecraft:enchanting_table".equals(string)) {
            this.mc.displayGuiScreen(new GuiEnchantment(this.inventory, this.worldObj, iInteractionObject));
        } else if ("minecraft:anvil".equals(string)) {
            this.mc.displayGuiScreen(new GuiRepair(this.inventory, this.worldObj));
        }
    }

    @Override
    public void displayVillagerTradeGui(IMerchant iMerchant) {
        this.mc.displayGuiScreen(new GuiMerchant(this.inventory, iMerchant, this.worldObj));
    }

    @Override
    public void onCriticalHit(Entity entity) {
        this.mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT);
    }

    @Override
    public void onEnchantmentCritical(Entity entity) {
        this.mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT_MAGIC);
    }

    @Override
    public boolean isSneaking() {
        boolean bl = this.movementInput != null ? this.movementInput.sneak : false;
        return bl && !this.sleeping;
    }

    @Override
    public void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.isCurrentViewEntity()) {
            this.moveStrafing = this.movementInput.moveStrafe;
            this.moveForward = this.movementInput.moveForward;
            this.isJumping = this.movementInput.jump;
            this.prevRenderArmYaw = this.renderArmYaw;
            this.prevRenderArmPitch = this.renderArmPitch;
            this.renderArmPitch = (float)((double)this.renderArmPitch + (double)(this.rotationPitch - this.renderArmPitch) * 0.5);
            this.renderArmYaw = (float)((double)this.renderArmYaw + (double)(this.rotationYaw - this.renderArmYaw) * 0.5);
        }
    }

    protected boolean isCurrentViewEntity() {
        return this.mc.getRenderViewEntity() == this;
    }

    private void mimeow$onUpdatePre(ocee33618a8d ocee33618a8d2) {
        if (!oc7ab2161b9f.\u0123() && ocabfbeb7421.\u02b0()) {
            this.syncPrevRenderStateToCurrent();
            ocee33618a8d2.z$2vp8d6bhwkrey();
        } else if (!oc7ab2161b9f.\u0123() && this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
            oc75d51ec7eb.\u0173 = oc75d51ec7eb.\u021b;
            oc75d51ec7eb.\u043a = oc75d51ec7eb.\u014f;
            ocea775c9d5c.\u0173.post(new oc2f61de30bc());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void mimeow$onUpdatePost(ocee33618a8d ocee33618a8d2) {
        if (!oc7ab2161b9f.\u0123()) {
            int n;
            if (this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
                ocea775c9d5c.\u0173.post(new ocebec3dfd67());
            }
            if ((n = ocabfbeb7421.\u0259()) > 0) {
                InterpolationState interpolationState = this.captureInterpolationState();
                for (int i = 0; i < n; ++i) {
                    oc7ab2161b9f.\u03f9();
                    try {
                        this.onUpdate();
                        continue;
                    }
                    finally {
                        oc7ab2161b9f.\u00ba();
                    }
                }
                this.restoreInterpolationState(interpolationState);
            }
        }
    }

    public void onUpdateWalkingPlayer() {
        boolean bl;
        oc25aa89b91f.\u02ac = false;
        oc25aa89b91f.c(false);
        oc75d51ec7eb.\u0127 = false;
        oc25aa89b91f oc25aa89b91f2 = new oc25aa89b91f(this.posX, this.getEntityBoundingBox().minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround, this.isSprinting(), this.isSneaking());
        ocea775c9d5c.\u0173.post(oc25aa89b91f2);
        oc75d51ec7eb.d = new float[]{oc25aa89b91f2.\u0541(), oc25aa89b91f2.\u01bd()};
        boolean bl2 = oc25aa89b91f2.\u0531();
        if (bl2 != this.serverSprintState && !oc7ab2161b9f.\u0123()) {
            if (bl2) {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SPRINTING));
            } else {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SPRINTING));
            }
            this.serverSprintState = bl2;
        }
        if ((bl = oc25aa89b91f2.\u0274()) != this.serverSneakState && !oc7ab2161b9f.\u0123()) {
            if (bl) {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SNEAKING));
            } else {
                this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SNEAKING));
            }
            this.serverSneakState = bl;
        }
        if (this.isCurrentViewEntity()) {
            boolean bl3;
            if (oc25aa89b91f.\u0171()) {
                oc75d51ec7eb.\u0585(oc25aa89b91f2.\u0541());
            }
            oc75d51ec7eb.\u021b = oc25aa89b91f2.\u01bd();
            oc75d51ec7eb.\u014f = oc25aa89b91f2.\u0541();
            if (oc75d51ec7eb.\u0127) {
                oc75d51ec7eb.\u021b = oc75d51ec7eb.\u04de[1].floatValue();
                oc75d51ec7eb.\u014f = oc75d51ec7eb.\u04de[0].floatValue();
                oc75d51ec7eb.\u0585(oc75d51ec7eb.\u014f);
            }
            oc75d51ec7eb.\u0127 = false;
            double d = oc25aa89b91f2.\u010a() - this.lastReportedPosX;
            double d2 = oc25aa89b91f2.\u01f8() - this.lastReportedPosY;
            double d3 = oc25aa89b91f2.\u0465() - this.lastReportedPosZ;
            double d4 = oc25aa89b91f2.\u0541() - this.lastReportedYaw;
            double d5 = oc25aa89b91f2.\u01bd() - this.lastReportedPitch;
            boolean bl4 = d * d + d2 * d2 + d3 * d3 > 9.0E-4 || this.positionUpdateTicks >= 20;
            boolean bl5 = bl3 = d4 != 0.0 || d5 != 0.0;
            if (this.ridingEntity == null) {
                if (bl4 && bl3) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(oc25aa89b91f2.\u010a(), oc25aa89b91f2.\u01f8(), oc25aa89b91f2.\u0465(), oc25aa89b91f2.\u0541(), oc25aa89b91f2.\u01bd(), oc25aa89b91f2.z()));
                } else if (bl4) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(oc25aa89b91f2.\u010a(), oc25aa89b91f2.\u01f8(), oc25aa89b91f2.\u0465(), oc25aa89b91f2.z()));
                } else if (bl3) {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(oc25aa89b91f2.\u0541(), oc25aa89b91f2.\u01bd(), oc25aa89b91f2.z()));
                } else {
                    this.sendQueue.addToSendQueue(new C03PacketPlayer(oc25aa89b91f2.z()));
                }
            } else {
                this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.motionX, -999.0, this.motionZ, oc25aa89b91f2.\u0541(), oc25aa89b91f2.\u01bd(), oc25aa89b91f2.z()));
                bl4 = false;
            }
            ++this.positionUpdateTicks;
            if (bl4) {
                this.lastReportedPosX = oc25aa89b91f2.\u010a();
                this.lastReportedPosY = oc25aa89b91f2.\u01f8();
                this.lastReportedPosZ = oc25aa89b91f2.\u0465();
                this.positionUpdateTicks = 0;
            }
            if (bl3) {
                this.lastReportedYaw = oc25aa89b91f2.\u0541();
                this.lastReportedPitch = oc25aa89b91f2.\u01bd();
            }
        }
        ocea775c9d5c.\u0173.post(new oc0e4b758d9a());
    }

    @Override
    public void onLivingUpdate() {
        boolean bl;
        if (this.sprintingTicksLeft > 0) {
            --this.sprintingTicksLeft;
            if (this.sprintingTicksLeft == 0) {
                this.setSprinting(false);
            }
        }
        if (this.sprintToggleTimer > 0) {
            --this.sprintToggleTimer;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.inPortal) {
            if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
                this.mc.displayGuiScreen(null);
            }
            if (this.timeInPortal == 0.0f) {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("portal.trigger"), this.rand.nextFloat() * 0.4f + 0.8f));
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
            }
            this.inPortal = false;
        } else if (this.isPotionActive(Potion.confusion) && this.getActivePotionEffect(Potion.confusion).getDuration() > 60 && (oc9755810e45.\u0205 == null || !oc9755810e45.\u0205.\u03b4(Potion.confusion))) {
            this.timeInPortal += 0.006666667f;
            if (this.timeInPortal > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        } else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
        boolean bl2 = this.movementInput.jump;
        boolean bl3 = this.movementInput.sneak;
        float f = 0.8f;
        boolean bl4 = this.movementInput.moveForward >= f;
        this.movementInput.updatePlayerMoveState();
        boolean bl5 = oc9755810e45.\u04a9 == null || !oc9755810e45.\u04a9.z$3rzb3dil7uydr() || !oc4557683e94.\u01fa();
        oce3cc81daa8 oce3cc81daa82 = oc9755810e45.\u050e;
        boolean bl6 = bl = oce3cc81daa82 != null && oce3cc81daa82.\u0222(this);
        if (this.isUsingItem() && !this.isRiding() && !bl) {
            MovementInput movementInput = this.movementInput;
            float f2 = oc4557683e94.\u04b2();
            movementInput.moveStrafe *= f2;
            movementInput = this.movementInput;
            movementInput.moveForward *= f2;
            if (bl5) {
                this.sprintToggleTimer = 0;
            }
        }
        this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + (double)this.width * 0.35);
        boolean bl7 = (float)this.getFoodStats().getFoodLevel() > 6.0f || this.capabilities.allowFlying;
        boolean bl8 = this.mc.gameSettings.keyBindSprint.isKeyDown();
        if (!(!this.onGround || bl3 || bl4 || !(this.movementInput.moveForward >= f) || this.isSprinting() || !bl7 || this.isUsingItem() && bl5 || this.isPotionActive(Potion.blindness))) {
            if (this.sprintToggleTimer <= 0 && !bl8) {
                this.sprintToggleTimer = 7;
            } else {
                this.setSprinting(true);
            }
        }
        if (!(this.isSprinting() || !bl8 || this.movementInput.moveForward == 0.0f && this.movementInput.moveStrafe == 0.0f || !(this.movementInput.moveForward >= f) || !bl7 || (this.isUsingItem() || this.mc.thePlayer.isBlocking()) && bl5 || this.isPotionActive(Potion.blindness))) {
            this.setSprinting(true);
        }
        if (this.isSprinting() && (this.movementInput.moveForward < f || !bl7 || this.isCollidedHorizontally || oc56ed92c768.\u0245 || this.movementInput.moveForward == 0.0f && this.movementInput.moveStrafe == 0.0f || this.mc.gameSettings.keyBindSneak.isKeyDown() || T.\u0533())) {
            this.setSprinting(false);
        }
        ocea775c9d5c.\u0173.post(new oc1059074ce8());
        if (T.\u0260()) {
            this.setSprinting(true);
        }
        ocd2c4efd8d9 ocd2c4efd8d92 = oc9755810e45.\u00e0;
        if (!(this.isSprinting() || T.\u0533() || ocd2c4efd8d92 == null || !ocd2c4efd8d92.z$3rzb3dil7uydr() || this.movementInput.moveForward == 0.0f && this.movementInput.moveStrafe == 0.0f || this.mc.gameSettings.keyBindSneak.isKeyDown() || this.isPotionActive(Potion.blindness))) {
            boolean bl9 = false;
            if (ocd2c4efd8d92.\u011d() && this.movementInput.moveForward < 0.0f) {
                bl9 = true;
            }
            if (ocd2c4efd8d92.\u0295() && this.movementInput.moveForward == 0.0f && this.movementInput.moveStrafe != 0.0f) {
                bl9 = true;
            }
            if (ocd2c4efd8d92.\u010c() && this.isUsingItem()) {
                bl9 = true;
            }
            if (bl9) {
                this.setSprinting(true);
            }
        }
        if (this.capabilities.allowFlying) {
            if (this.mc.playerController.isSpectatorMode()) {
                if (!this.capabilities.isFlying) {
                    this.capabilities.isFlying = true;
                    this.sendPlayerAbilities();
                }
            } else if (!bl2 && this.movementInput.jump) {
                if (this.flyToggleTimer == 0) {
                    this.flyToggleTimer = 7;
                } else {
                    this.capabilities.isFlying = !this.capabilities.isFlying;
                    this.sendPlayerAbilities();
                    this.flyToggleTimer = 0;
                }
            }
        }
        if (this.capabilities.isFlying && this.isCurrentViewEntity()) {
            if (this.movementInput.sneak) {
                this.motionY -= (double)(this.capabilities.getFlySpeed() * 3.0f);
            }
            if (this.movementInput.jump) {
                this.motionY += (double)(this.capabilities.getFlySpeed() * 3.0f);
            }
        }
        if (this.isRidingHorse()) {
            if (this.horseJumpPowerCounter < 0) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter == 0) {
                    this.horseJumpPower = 0.0f;
                }
            }
            if (bl2 && !this.movementInput.jump) {
                this.horseJumpPowerCounter = -10;
                this.sendHorseJump();
            } else if (!bl2 && this.movementInput.jump) {
                this.horseJumpPowerCounter = 0;
                this.horseJumpPower = 0.0f;
            } else if (bl2) {
                ++this.horseJumpPowerCounter;
                this.horseJumpPower = this.horseJumpPowerCounter < 10 ? (float)this.horseJumpPowerCounter * 0.1f : 0.8f + 2.0f / (float)(this.horseJumpPowerCounter - 9) * 0.1f;
            }
        } else {
            this.horseJumpPower = 0.0f;
        }
        ocea775c9d5c.\u0173.post(new oc057a60a0eb());
        super.onLivingUpdate();
        if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
            this.capabilities.isFlying = false;
            this.sendPlayerAbilities();
        }
    }

    public boolean isServerSprinting() {
        return this.serverSprintState;
    }

    @Override
    public boolean getServerSprintState() {
        return this.serverSprintState;
    }

    @Override
    public void setServerSprintState(boolean bl) {
        this.serverSprintState = bl;
    }

    @Override
    public boolean getServerSneakState() {
        return this.serverSneakState;
    }

    @Override
    public void setServerSneakState(boolean bl) {
        this.serverSneakState = bl;
    }

    private InterpolationState captureInterpolationState() {
        return new InterpolationState(this.prevPosX, this.prevPosY, this.prevPosZ, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, this.prevRotationYaw, this.prevRotationPitch, this.prevRotationYawHead, this.prevRenderYawOffset, this.prevCameraYaw, this.prevCameraPitch, this.prevDistanceWalkedModified, this.prevLimbSwingAmount, this.prevSwingProgress, this.prevChasingPosX, this.prevChasingPosY, this.prevChasingPosZ);
    }

    private void restoreInterpolationState(InterpolationState interpolationState) {
        if (interpolationState != null) {
            this.prevPosX = interpolationState.prevPosX;
            this.prevPosY = interpolationState.prevPosY;
            this.prevPosZ = interpolationState.prevPosZ;
            this.lastTickPosX = interpolationState.lastTickPosX;
            this.lastTickPosY = interpolationState.lastTickPosY;
            this.lastTickPosZ = interpolationState.lastTickPosZ;
            this.prevRotationYaw = interpolationState.prevRotationYaw;
            this.prevRotationPitch = interpolationState.prevRotationPitch;
            this.prevRotationYawHead = interpolationState.prevRotationYawHead;
            this.prevRenderYawOffset = interpolationState.prevRenderYawOffset;
            this.prevCameraYaw = interpolationState.prevCameraYaw;
            this.prevCameraPitch = interpolationState.prevCameraPitch;
            this.prevDistanceWalkedModified = interpolationState.prevDistanceWalkedModified;
            this.prevLimbSwingAmount = interpolationState.prevLimbSwingAmount;
            this.prevSwingProgress = interpolationState.prevSwingProgress;
            this.prevChasingPosX = interpolationState.prevChasingPosX;
            this.prevChasingPosY = interpolationState.prevChasingPosY;
            this.prevChasingPosZ = interpolationState.prevChasingPosZ;
        }
    }

    private void syncPrevRenderStateToCurrent() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYawHead = this.rotationYawHead;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevCameraYaw = this.cameraYaw;
        this.prevCameraPitch = this.cameraPitch;
        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevLimbSwingAmount = this.limbSwingAmount;
        this.prevSwingProgress = this.swingProgress;
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        this.prevTimeInPortal = this.timeInPortal;
    }

    public int getPositionUpdateTicks() {
        return this.positionUpdateTicks;
    }

    public void resetSprintToggleTimer() {
        this.sprintToggleTimer = 0;
    }

    @Override
    public double getLastReportedPosX() {
        return this.lastReportedPosX;
    }

    @Override
    public double getLastReportedPosY() {
        return this.lastReportedPosY;
    }

    @Override
    public double getLastReportedPosZ() {
        return this.lastReportedPosZ;
    }

    @Override
    public float getLastReportedYaw() {
        return this.lastReportedYaw;
    }

    private static final class InterpolationState {
        private final double prevPosX;
        private final double prevPosY;
        private final double prevPosZ;
        private final double lastTickPosX;
        private final double lastTickPosY;
        private final double lastTickPosZ;
        private final float prevRotationYaw;
        private final float prevRotationPitch;
        private final float prevRotationYawHead;
        private final float prevRenderYawOffset;
        private final float prevCameraYaw;
        private final float prevCameraPitch;
        private final float prevDistanceWalkedModified;
        private final float prevLimbSwingAmount;
        private final float prevSwingProgress;
        private final double prevChasingPosX;
        private final double prevChasingPosY;
        private final double prevChasingPosZ;

        private InterpolationState(double d, double d2, double d3, double d4, double d5, double d6, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, double d7, double d8, double d9) {
            this.prevPosX = d;
            this.prevPosY = d2;
            this.prevPosZ = d3;
            this.lastTickPosX = d4;
            this.lastTickPosY = d5;
            this.lastTickPosZ = d6;
            this.prevRotationYaw = f;
            this.prevRotationPitch = f2;
            this.prevRotationYawHead = f3;
            this.prevRenderYawOffset = f4;
            this.prevCameraYaw = f5;
            this.prevCameraPitch = f6;
            this.prevDistanceWalkedModified = f7;
            this.prevLimbSwingAmount = f8;
            this.prevSwingProgress = f9;
            this.prevChasingPosX = d7;
            this.prevChasingPosY = d8;
            this.prevChasingPosZ = d9;
        }
    }
}

