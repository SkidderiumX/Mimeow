/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.network.play.server.S2EPacketCloseWindow;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.S31PacketWindowProperty;
import net.minecraft.network.play.server.S36PacketSignEditorOpen;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S42PacketCombatEvent;
import net.minecraft.network.play.server.S43PacketCamera;
import net.minecraft.network.play.server.S48PacketResourcePackSend;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.server.management.UserListOpsEntry;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.JsonSerializableSet;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityPlayerMP
extends EntityPlayer
implements ICrafting {
    private static final Logger logger = LogManager.getLogger();
    private String translator = "en_US";
    public NetHandlerPlayServer playerNetServerHandler;
    public final MinecraftServer mcServer;
    public final ItemInWorldManager theItemInWorldManager;
    public double managedPosX;
    public double managedPosZ;
    public final List<ChunkCoordIntPair> loadedChunks = Lists.newLinkedList();
    private final List<Integer> destroyedItemsNetCache = Lists.newLinkedList();
    private final StatisticsFile statsFile;
    private float combinedHealth = Float.MIN_VALUE;
    private float lastHealth = -1.0E8f;
    private int lastFoodLevel = -99999999;
    private boolean wasHungry = true;
    private int lastExperience = -99999999;
    private int respawnInvulnerabilityTicks = 60;
    private EntityPlayer.EnumChatVisibility chatVisibility;
    private boolean chatColours = true;
    private long playerLastActiveTime = System.currentTimeMillis();
    private Entity spectatingEntity = null;
    private int currentWindowId;
    public boolean isChangingQuantityOnly;
    public int ping;
    public boolean playerConqueredTheEnd;

    public EntityPlayerMP(MinecraftServer minecraftServer, WorldServer worldServer, GameProfile gameProfile, ItemInWorldManager itemInWorldManager) {
        super(worldServer, gameProfile);
        itemInWorldManager.thisPlayerMP = this;
        this.theItemInWorldManager = itemInWorldManager;
        BlockPos blockPos = worldServer.getSpawnPoint();
        if (!worldServer.provider.getHasNoSky() && worldServer.getWorldInfo().getGameType() != WorldSettings.GameType.ADVENTURE) {
            int n = Math.max(5, minecraftServer.getSpawnProtectionSize() - 6);
            int n2 = MathHelper.floor_double(worldServer.getWorldBorder().getClosestDistance(blockPos.getX(), blockPos.getZ()));
            if (n2 < n) {
                n = n2;
            }
            if (n2 <= 1) {
                n = 1;
            }
            blockPos = worldServer.getTopSolidOrLiquidBlock(blockPos.add(this.rand.nextInt(n * 2) - n, 0, this.rand.nextInt(n * 2) - n));
        }
        this.mcServer = minecraftServer;
        this.statsFile = minecraftServer.getConfigurationManager().getPlayerStatsFile(this);
        this.stepHeight = 0.0f;
        this.moveToBlockPosAndAngles(blockPos, 0.0f, 0.0f);
        while (!worldServer.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && this.posY < 255.0) {
            this.setPosition(this.posX, this.posY + 1.0, this.posZ);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound.hasKey("playerGameType", 99)) {
            if (MinecraftServer.getServer().getForceGamemode()) {
                this.theItemInWorldManager.setGameType(MinecraftServer.getServer().getGameType());
            } else {
                this.theItemInWorldManager.setGameType(WorldSettings.GameType.getByID(nBTTagCompound.getInteger("playerGameType")));
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound.setInteger("playerGameType", this.theItemInWorldManager.getGameType().getID());
    }

    @Override
    public void addExperienceLevel(int n) {
        super.addExperienceLevel(n);
        this.lastExperience = -1;
    }

    @Override
    public void removeExperienceLevel(int n) {
        super.removeExperienceLevel(n);
        this.lastExperience = -1;
    }

    public void addSelfToInternalCraftingInventory() {
        this.openContainer.onCraftGuiOpened(this);
    }

    @Override
    public void sendEnterCombat() {
        super.sendEnterCombat();
        this.playerNetServerHandler.sendPacket(new S42PacketCombatEvent(this.getCombatTracker(), S42PacketCombatEvent.Event.ENTER_COMBAT));
    }

    @Override
    public void sendEndCombat() {
        super.sendEndCombat();
        this.playerNetServerHandler.sendPacket(new S42PacketCombatEvent(this.getCombatTracker(), S42PacketCombatEvent.Event.END_COMBAT));
    }

    @Override
    public void onUpdate() {
        Entity entity;
        Object object;
        Object object2;
        this.theItemInWorldManager.updateBlockRemoving();
        --this.respawnInvulnerabilityTicks;
        if (this.hurtResistantTime > 0) {
            --this.hurtResistantTime;
        }
        this.openContainer.detectAndSendChanges();
        if (!this.worldObj.isRemote && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        while (!this.destroyedItemsNetCache.isEmpty()) {
            int n = Math.min(this.destroyedItemsNetCache.size(), Integer.MAX_VALUE);
            object2 = new int[n];
            object = this.destroyedItemsNetCache.iterator();
            int n2 = 0;
            while (object.hasNext() && n2 < n) {
                object2[n2++] = (Integer)object.next();
                object.remove();
            }
            this.playerNetServerHandler.sendPacket(new S13PacketDestroyEntities((int[])object2));
        }
        if (!this.loadedChunks.isEmpty()) {
            ArrayList<Chunk> arrayList = Lists.newArrayList();
            object2 = this.loadedChunks.iterator();
            object = Lists.newArrayList();
            while (object2.hasNext() && arrayList.size() < 10) {
                ChunkCoordIntPair chunkCoordIntPair = (ChunkCoordIntPair)object2.next();
                if (chunkCoordIntPair != null) {
                    Chunk object32;
                    if (!this.worldObj.isBlockLoaded(new BlockPos(chunkCoordIntPair.chunkXPos << 4, 0, chunkCoordIntPair.chunkZPos << 4)) || !(object32 = this.worldObj.getChunkFromChunkCoords(chunkCoordIntPair.chunkXPos, chunkCoordIntPair.chunkZPos)).isPopulated()) continue;
                    arrayList.add(object32);
                    object.addAll(((WorldServer)this.worldObj).getTileEntitiesIn(chunkCoordIntPair.chunkXPos * 16, 0, chunkCoordIntPair.chunkZPos * 16, chunkCoordIntPair.chunkXPos * 16 + 16, 256, chunkCoordIntPair.chunkZPos * 16 + 16));
                    object2.remove();
                    continue;
                }
                object2.remove();
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() == 1) {
                    this.playerNetServerHandler.sendPacket(new S21PacketChunkData((Chunk)arrayList.get(0), true, 65535));
                } else {
                    this.playerNetServerHandler.sendPacket(new S26PacketMapChunkBulk(arrayList));
                }
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    TileEntity tileEntity = (TileEntity)iterator2.next();
                    this.sendTileEntityUpdate(tileEntity);
                }
                for (Chunk chunk : arrayList) {
                    this.getServerForPlayer().getEntityTracker().func_85172_a(this, chunk);
                }
            }
        }
        if ((entity = this.getSpectatingEntity()) != this) {
            if (!entity.isEntityAlive()) {
                this.setSpectatingEntity(this);
            } else {
                this.setPositionAndRotation(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                this.mcServer.getConfigurationManager().serverUpdateMountedMovingPlayer(this);
                if (this.isSneaking()) {
                    this.setSpectatingEntity(this);
                }
            }
        }
    }

    public void onUpdateEntity() {
        try {
            super.onUpdate();
            for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
                Packet packet;
                ItemStack object = this.inventory.getStackInSlot(i);
                if (object == null || !object.getItem().isMap() || (packet = ((ItemMapBase)object.getItem()).createMapDataPacket(object, this.worldObj, this)) == null) continue;
                this.playerNetServerHandler.sendPacket(packet);
            }
            if (this.getHealth() != this.lastHealth || this.lastFoodLevel != this.foodStats.getFoodLevel() || this.foodStats.getSaturationLevel() == 0.0f != this.wasHungry) {
                this.playerNetServerHandler.sendPacket(new S06PacketUpdateHealth(this.getHealth(), this.foodStats.getFoodLevel(), this.foodStats.getSaturationLevel()));
                this.lastHealth = this.getHealth();
                this.lastFoodLevel = this.foodStats.getFoodLevel();
                boolean bl = this.wasHungry = this.foodStats.getSaturationLevel() == 0.0f;
            }
            if (this.getHealth() + this.getAbsorptionAmount() != this.combinedHealth) {
                this.combinedHealth = this.getHealth() + this.getAbsorptionAmount();
                for (ScoreObjective scoreObjective : this.getWorldScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.health)) {
                    this.getWorldScoreboard().getValueFromObjective(this.getName(), scoreObjective).func_96651_a(Arrays.asList(this));
                }
            }
            if (this.experienceTotal != this.lastExperience) {
                this.lastExperience = this.experienceTotal;
                this.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(this.experience, this.experienceTotal, this.experienceLevel));
            }
            if (this.ticksExisted % 20 * 5 == 0 && !this.getStatFile().hasAchievementUnlocked(AchievementList.exploreAllBiomes)) {
                this.updateBiomesExplored();
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking player");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Player being ticked");
            this.addEntityCrashInfo(crashReportCategory);
            throw new ReportedException(crashReport);
        }
    }

    protected void updateBiomesExplored() {
        BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(new BlockPos(MathHelper.floor_double(this.posX), 0, MathHelper.floor_double(this.posZ)));
        String string = biomeGenBase.biomeName;
        JsonSerializableSet jsonSerializableSet = (JsonSerializableSet)this.getStatFile().func_150870_b(AchievementList.exploreAllBiomes);
        if (jsonSerializableSet == null) {
            jsonSerializableSet = this.getStatFile().func_150872_a(AchievementList.exploreAllBiomes, new JsonSerializableSet());
        }
        jsonSerializableSet.add(string);
        if (this.getStatFile().canUnlockAchievement(AchievementList.exploreAllBiomes) && jsonSerializableSet.size() >= BiomeGenBase.explorationBiomesList.size()) {
            HashSet<BiomeGenBase> hashSet = Sets.newHashSet(BiomeGenBase.explorationBiomesList);
            for (String string2 : jsonSerializableSet) {
                Iterator iterator2 = hashSet.iterator();
                while (iterator2.hasNext()) {
                    BiomeGenBase biomeGenBase2 = (BiomeGenBase)iterator2.next();
                    if (!biomeGenBase2.biomeName.equals(string2)) continue;
                    iterator2.remove();
                }
                if (!hashSet.isEmpty()) continue;
                break;
            }
            if (hashSet.isEmpty()) {
                this.triggerAchievement(AchievementList.exploreAllBiomes);
            }
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        Object object;
        if (this.worldObj.getGameRules().getBoolean("showDeathMessages")) {
            object = this.getTeam();
            if (object != null && ((Team)object).getDeathMessageVisibility() != Team.EnumVisible.ALWAYS) {
                if (((Team)object).getDeathMessageVisibility() == Team.EnumVisible.HIDE_FOR_OTHER_TEAMS) {
                    this.mcServer.getConfigurationManager().sendMessageToAllTeamMembers(this, this.getCombatTracker().getDeathMessage());
                } else if (((Team)object).getDeathMessageVisibility() == Team.EnumVisible.HIDE_FOR_OWN_TEAM) {
                    this.mcServer.getConfigurationManager().sendMessageToTeamOrEvryPlayer(this, this.getCombatTracker().getDeathMessage());
                }
            } else {
                this.mcServer.getConfigurationManager().sendChatMsg(this.getCombatTracker().getDeathMessage());
            }
        }
        if (!this.worldObj.getGameRules().getBoolean("keepInventory")) {
            this.inventory.dropAllItems();
        }
        for (ScoreObjective object2 : this.worldObj.getScoreboard().getObjectivesFromCriteria(IScoreObjectiveCriteria.deathCount)) {
            Score score = this.getWorldScoreboard().getValueFromObjective(this.getName(), object2);
            score.func_96648_a();
        }
        object = this.getAttackingEntity();
        if (object != null) {
            EntityList.EntityEggInfo entityEggInfo = EntityList.entityEggs.get(EntityList.getEntityID((Entity)object));
            if (entityEggInfo != null) {
                this.triggerAchievement(entityEggInfo.field_151513_e);
            }
            ((Entity)object).addToPlayerScore(this, this.scoreValue);
        }
        this.triggerAchievement(StatList.deathsStat);
        this.func_175145_a(StatList.timeSinceDeathStat);
        this.getCombatTracker().reset();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        boolean bl;
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        }
        boolean bl2 = bl = this.mcServer.isDedicatedServer() && this.canPlayersAttack() && "fall".equals(damageSource.damageType);
        if (!bl && this.respawnInvulnerabilityTicks > 0 && damageSource != DamageSource.outOfWorld) {
            return false;
        }
        if (damageSource instanceof EntityDamageSource) {
            Entity entity = damageSource.getEntity();
            if (entity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)entity)) {
                return false;
            }
            if (entity instanceof EntityArrow) {
                EntityArrow entityArrow = (EntityArrow)entity;
                if (entityArrow.shootingEntity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)entityArrow.shootingEntity)) {
                    return false;
                }
            }
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public boolean canAttackPlayer(EntityPlayer entityPlayer) {
        return !this.canPlayersAttack() ? false : super.canAttackPlayer(entityPlayer);
    }

    private boolean canPlayersAttack() {
        return this.mcServer.isPVPEnabled();
    }

    @Override
    public void travelToDimension(int n) {
        if (this.dimension == 1 && n == 1) {
            this.triggerAchievement(AchievementList.theEnd2);
            this.worldObj.removeEntity(this);
            this.playerConqueredTheEnd = true;
            this.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(4, 0.0f));
        } else {
            if (this.dimension == 0 && n == 1) {
                this.triggerAchievement(AchievementList.theEnd);
                BlockPos blockPos = this.mcServer.worldServerForDimension(n).getSpawnCoordinate();
                if (blockPos != null) {
                    this.playerNetServerHandler.setPlayerLocation(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0f, 0.0f);
                }
                n = 1;
            } else {
                this.triggerAchievement(AchievementList.portal);
            }
            this.mcServer.getConfigurationManager().transferPlayerToDimension(this, n);
            this.lastExperience = -1;
            this.lastHealth = -1.0f;
            this.lastFoodLevel = -1;
        }
    }

    @Override
    public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
        return entityPlayerMP.isSpectator() ? this.getSpectatingEntity() == this : (this.isSpectator() ? false : super.isSpectatedByPlayer(entityPlayerMP));
    }

    private void sendTileEntityUpdate(TileEntity tileEntity) {
        Packet packet;
        if (tileEntity != null && (packet = tileEntity.getDescriptionPacket()) != null) {
            this.playerNetServerHandler.sendPacket(packet);
        }
    }

    @Override
    public void onItemPickup(Entity entity, int n) {
        super.onItemPickup(entity, n);
        this.openContainer.detectAndSendChanges();
    }

    @Override
    public EntityPlayer.EnumStatus trySleep(BlockPos blockPos) {
        EntityPlayer.EnumStatus enumStatus = super.trySleep(blockPos);
        if (enumStatus == EntityPlayer.EnumStatus.OK) {
            S0APacketUseBed s0APacketUseBed = new S0APacketUseBed(this, blockPos);
            this.getServerForPlayer().getEntityTracker().sendToAllTrackingEntity(this, s0APacketUseBed);
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.playerNetServerHandler.sendPacket(s0APacketUseBed);
        }
        return enumStatus;
    }

    @Override
    public void wakeUpPlayer(boolean bl, boolean bl2, boolean bl3) {
        if (this.isPlayerSleeping()) {
            this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(this, 2));
        }
        super.wakeUpPlayer(bl, bl2, bl3);
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }

    @Override
    public void mountEntity(Entity entity) {
        Entity entity2 = this.ridingEntity;
        super.mountEntity(entity);
        if (entity != entity2) {
            this.playerNetServerHandler.sendPacket(new S1BPacketEntityAttach(0, this, this.ridingEntity));
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }

    @Override
    protected void updateFallState(double d, boolean bl, Block block, BlockPos blockPos) {
    }

    public void handleFalling(double d, boolean bl) {
        Block block;
        int n;
        int n2;
        int n3 = MathHelper.floor_double(this.posX);
        BlockPos blockPos = new BlockPos(n3, n2 = MathHelper.floor_double(this.posY - (double)0.2f), n = MathHelper.floor_double(this.posZ));
        Block block2 = this.worldObj.getBlockState(blockPos).getBlock();
        if (block2.getMaterial() == Material.air && ((block = this.worldObj.getBlockState(blockPos.down()).getBlock()) instanceof BlockFence || block instanceof BlockWall || block instanceof BlockFenceGate)) {
            blockPos = blockPos.down();
            block2 = this.worldObj.getBlockState(blockPos).getBlock();
        }
        super.updateFallState(d, bl, block2, blockPos);
    }

    @Override
    public void openEditSign(TileEntitySign tileEntitySign) {
        tileEntitySign.setPlayer(this);
        this.playerNetServerHandler.sendPacket(new S36PacketSignEditorOpen(tileEntitySign.getPos()));
    }

    private void getNextWindowId() {
        this.currentWindowId = this.currentWindowId % 100 + 1;
    }

    @Override
    public void displayGui(IInteractionObject iInteractionObject) {
        this.getNextWindowId();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, iInteractionObject.getGuiID(), iInteractionObject.getDisplayName()));
        this.openContainer = iInteractionObject.createContainer(this.inventory, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }

    @Override
    public void displayGUIChest(IInventory iInventory) {
        ILockableContainer iLockableContainer;
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        if (iInventory instanceof ILockableContainer && (iLockableContainer = (ILockableContainer)iInventory).isLocked() && !this.canOpen(iLockableContainer.getLockCode()) && !this.isSpectator()) {
            this.playerNetServerHandler.sendPacket(new S02PacketChat(new ChatComponentTranslation("container.isLocked", iInventory.getDisplayName()), 2));
            this.playerNetServerHandler.sendPacket(new S29PacketSoundEffect("random.door_close", this.posX, this.posY, this.posZ, 1.0f, 1.0f));
            return;
        }
        this.getNextWindowId();
        if (iInventory instanceof IInteractionObject) {
            this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, ((IInteractionObject)((Object)iInventory)).getGuiID(), iInventory.getDisplayName(), iInventory.getSizeInventory()));
            this.openContainer = ((IInteractionObject)((Object)iInventory)).createContainer(this.inventory, this);
        } else {
            this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "minecraft:container", iInventory.getDisplayName(), iInventory.getSizeInventory()));
            this.openContainer = new ContainerChest(this.inventory, iInventory, this);
        }
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }

    @Override
    public void displayVillagerTradeGui(IMerchant iMerchant) {
        this.getNextWindowId();
        this.openContainer = new ContainerMerchant(this.inventory, iMerchant, this.worldObj);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
        InventoryMerchant inventoryMerchant = ((ContainerMerchant)this.openContainer).getMerchantInventory();
        IChatComponent iChatComponent = iMerchant.getDisplayName();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "minecraft:villager", iChatComponent, inventoryMerchant.getSizeInventory()));
        MerchantRecipeList merchantRecipeList = iMerchant.getRecipes(this);
        if (merchantRecipeList != null) {
            PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
            packetBuffer.writeInt(this.currentWindowId);
            merchantRecipeList.writeToBuf(packetBuffer);
            this.playerNetServerHandler.sendPacket(new S3FPacketCustomPayload("MC|TrList", packetBuffer));
        }
    }

    @Override
    public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        this.getNextWindowId();
        this.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(this.currentWindowId, "EntityHorse", iInventory.getDisplayName(), iInventory.getSizeInventory(), entityHorse.getEntityId()));
        this.openContainer = new ContainerHorseInventory(this.inventory, iInventory, entityHorse, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.onCraftGuiOpened(this);
    }

    @Override
    public void displayGUIBook(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item == Items.written_book) {
            this.playerNetServerHandler.sendPacket(new S3FPacketCustomPayload("MC|BOpen", new PacketBuffer(Unpooled.buffer())));
        }
    }

    @Override
    public void sendSlotContents(Container container, int n, ItemStack itemStack) {
        if (!(container.getSlot(n) instanceof SlotCrafting) && !this.isChangingQuantityOnly) {
            this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(container.windowId, n, itemStack));
        }
    }

    public void sendContainerToPlayer(Container container) {
        this.updateCraftingInventory(container, container.getInventory());
    }

    @Override
    public void updateCraftingInventory(Container container, List<ItemStack> list) {
        this.playerNetServerHandler.sendPacket(new S30PacketWindowItems(container.windowId, list));
        this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(-1, -1, this.inventory.getItemStack()));
    }

    @Override
    public void sendProgressBarUpdate(Container container, int n, int n2) {
        this.playerNetServerHandler.sendPacket(new S31PacketWindowProperty(container.windowId, n, n2));
    }

    @Override
    public void sendAllWindowProperties(Container container, IInventory iInventory) {
        for (int i = 0; i < iInventory.getFieldCount(); ++i) {
            this.playerNetServerHandler.sendPacket(new S31PacketWindowProperty(container.windowId, i, iInventory.getField(i)));
        }
    }

    @Override
    public void closeScreen() {
        this.playerNetServerHandler.sendPacket(new S2EPacketCloseWindow(this.openContainer.windowId));
        this.closeContainer();
    }

    public void updateHeldItem() {
        if (!this.isChangingQuantityOnly) {
            this.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(-1, -1, this.inventory.getItemStack()));
        }
    }

    public void closeContainer() {
        this.openContainer.onContainerClosed(this);
        this.openContainer = this.inventoryContainer;
    }

    public void setEntityActionState(float f, float f2, boolean bl, boolean bl2) {
        if (this.ridingEntity != null) {
            if (f >= -1.0f && f <= 1.0f) {
                this.moveStrafing = f;
            }
            if (f2 >= -1.0f && f2 <= 1.0f) {
                this.moveForward = f2;
            }
            this.isJumping = bl;
            this.setSneaking(bl2);
        }
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        if (statBase != null) {
            this.statsFile.increaseStat(this, statBase, n);
            for (ScoreObjective scoreObjective : this.getWorldScoreboard().getObjectivesFromCriteria(statBase.getCriteria())) {
                this.getWorldScoreboard().getValueFromObjective(this.getName(), scoreObjective).increseScore(n);
            }
            if (this.statsFile.func_150879_e()) {
                this.statsFile.func_150876_a(this);
            }
        }
    }

    @Override
    public void func_175145_a(StatBase statBase) {
        if (statBase != null) {
            this.statsFile.unlockAchievement(this, statBase, 0);
            for (ScoreObjective scoreObjective : this.getWorldScoreboard().getObjectivesFromCriteria(statBase.getCriteria())) {
                this.getWorldScoreboard().getValueFromObjective(this.getName(), scoreObjective).setScorePoints(0);
            }
            if (this.statsFile.func_150879_e()) {
                this.statsFile.func_150876_a(this);
            }
        }
    }

    public void mountEntityAndWakeUp() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.mountEntity(this);
        }
        if (this.sleeping) {
            this.wakeUpPlayer(true, false, false);
        }
    }

    public void setPlayerHealthUpdated() {
        this.lastHealth = -1.0E8f;
    }

    @Override
    public void addChatComponentMessage(IChatComponent iChatComponent) {
        this.playerNetServerHandler.sendPacket(new S02PacketChat(iChatComponent));
    }

    @Override
    protected void onItemUseFinish() {
        this.playerNetServerHandler.sendPacket(new S19PacketEntityStatus(this, 9));
        super.onItemUseFinish();
    }

    @Override
    public void setItemInUse(ItemStack itemStack, int n) {
        super.setItemInUse(itemStack, n);
        if (itemStack != null && itemStack.getItem() != null && itemStack.getItem().getItemUseAction(itemStack) == EnumAction.EAT) {
            this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(this, 3));
        }
    }

    @Override
    public void clonePlayer(EntityPlayer entityPlayer, boolean bl) {
        super.clonePlayer(entityPlayer, bl);
        this.lastExperience = -1;
        this.lastHealth = -1.0f;
        this.lastFoodLevel = -1;
        this.destroyedItemsNetCache.addAll(((EntityPlayerMP)entityPlayer).destroyedItemsNetCache);
    }

    @Override
    protected void onNewPotionEffect(PotionEffect potionEffect) {
        super.onNewPotionEffect(potionEffect);
        this.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.getEntityId(), potionEffect));
    }

    @Override
    protected void onChangedPotionEffect(PotionEffect potionEffect, boolean bl) {
        super.onChangedPotionEffect(potionEffect, bl);
        this.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(this.getEntityId(), potionEffect));
    }

    @Override
    protected void onFinishedPotionEffect(PotionEffect potionEffect) {
        super.onFinishedPotionEffect(potionEffect);
        this.playerNetServerHandler.sendPacket(new S1EPacketRemoveEntityEffect(this.getEntityId(), potionEffect));
    }

    @Override
    public void setPositionAndUpdate(double d, double d2, double d3) {
        this.playerNetServerHandler.setPlayerLocation(d, d2, d3, this.rotationYaw, this.rotationPitch);
    }

    @Override
    public void onCriticalHit(Entity entity) {
        this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(entity, 4));
    }

    @Override
    public void onEnchantmentCritical(Entity entity) {
        this.getServerForPlayer().getEntityTracker().func_151248_b(this, new S0BPacketAnimation(entity, 5));
    }

    @Override
    public void sendPlayerAbilities() {
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.sendPacket(new S39PacketPlayerAbilities(this.capabilities));
            this.updatePotionMetadata();
        }
    }

    public WorldServer getServerForPlayer() {
        return (WorldServer)this.worldObj;
    }

    @Override
    public void setGameType(WorldSettings.GameType gameType) {
        this.theItemInWorldManager.setGameType(gameType);
        this.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(3, gameType.getID()));
        if (gameType == WorldSettings.GameType.SPECTATOR) {
            this.mountEntity(null);
        } else {
            this.setSpectatingEntity(this);
        }
        this.sendPlayerAbilities();
        this.markPotionsDirty();
    }

    @Override
    public boolean isSpectator() {
        return this.theItemInWorldManager.getGameType() == WorldSettings.GameType.SPECTATOR;
    }

    @Override
    public void addChatMessage(IChatComponent iChatComponent) {
        this.playerNetServerHandler.sendPacket(new S02PacketChat(iChatComponent));
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        if ("seed".equals(string) && !this.mcServer.isDedicatedServer()) {
            return true;
        }
        if (!("tell".equals(string) || "help".equals(string) || "me".equals(string) || "trigger".equals(string))) {
            if (this.mcServer.getConfigurationManager().canSendCommands(this.getGameProfile())) {
                UserListOpsEntry userListOpsEntry = (UserListOpsEntry)this.mcServer.getConfigurationManager().getOppedPlayers().getEntry(this.getGameProfile());
                return userListOpsEntry != null ? userListOpsEntry.getPermissionLevel() >= n : this.mcServer.getOpPermissionLevel() >= n;
            }
            return false;
        }
        return true;
    }

    public String getPlayerIP() {
        String string = this.playerNetServerHandler.netManager.getRemoteAddress().toString();
        string = string.substring(string.indexOf("/") + 1);
        string = string.substring(0, string.indexOf(":"));
        return string;
    }

    public void handleClientSettings(C15PacketClientSettings c15PacketClientSettings) {
        this.translator = c15PacketClientSettings.getLang();
        this.chatVisibility = c15PacketClientSettings.getChatVisibility();
        this.chatColours = c15PacketClientSettings.isColorsEnabled();
        this.getDataWatcher().updateObject(10, (byte)c15PacketClientSettings.getModelPartFlags());
    }

    public EntityPlayer.EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }

    public void loadResourcePack(String string, String string2) {
        this.playerNetServerHandler.sendPacket(new S48PacketResourcePackSend(string, string2));
    }

    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }

    public void markPlayerActive() {
        this.playerLastActiveTime = MinecraftServer.getCurrentTimeMillis();
    }

    public StatisticsFile getStatFile() {
        return this.statsFile;
    }

    public void removeEntity(Entity entity) {
        if (entity instanceof EntityPlayer) {
            this.playerNetServerHandler.sendPacket(new S13PacketDestroyEntities(entity.getEntityId()));
        } else {
            this.destroyedItemsNetCache.add(entity.getEntityId());
        }
    }

    @Override
    protected void updatePotionMetadata() {
        if (this.isSpectator()) {
            this.resetPotionEffectMetadata();
            this.setInvisible(true);
        } else {
            super.updatePotionMetadata();
        }
        this.getServerForPlayer().getEntityTracker().func_180245_a(this);
    }

    public Entity getSpectatingEntity() {
        return this.spectatingEntity == null ? this : this.spectatingEntity;
    }

    public void setSpectatingEntity(Entity entity) {
        Entity entity2 = this.getSpectatingEntity();
        Entity entity3 = this.spectatingEntity = entity == null ? this : entity;
        if (entity2 != this.spectatingEntity) {
            this.playerNetServerHandler.sendPacket(new S43PacketCamera(this.spectatingEntity));
            this.setPositionAndUpdate(this.spectatingEntity.posX, this.spectatingEntity.posY, this.spectatingEntity.posZ);
        }
    }

    @Override
    public void attackTargetEntityWithCurrentItem(Entity entity) {
        if (this.theItemInWorldManager.getGameType() == WorldSettings.GameType.SPECTATOR) {
            this.setSpectatingEntity(entity);
        } else {
            super.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public long getLastActiveTime() {
        return this.playerLastActiveTime;
    }

    public IChatComponent getTabListDisplayName() {
        return null;
    }
}

