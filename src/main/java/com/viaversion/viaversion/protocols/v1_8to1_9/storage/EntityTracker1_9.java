/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.storage;

import com.google.common.cache.CacheBuilder;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.legacy.bossbar.BossBar;
import com.viaversion.viaversion.api.legacy.bossbar.BossColor;
import com.viaversion.viaversion.api.legacy.bossbar.BossStyle;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.BossBarProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.provider.EntityIdProvider;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.InventoryTracker;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_9
extends EntityTrackerBase {
    public static final String WITHER_TRANSLATABLE = "{\"translate\":\"entity.WitherBoss.name\"}";
    public static final String DRAGON_TRANSLATABLE = "{\"translate\":\"entity.EnderDragon.name\"}";
    private final Int2ObjectMap<UUID> uuidMap = new Int2ObjectOpenHashMap<UUID>();
    private final Int2IntMap vehicleMap = new Int2IntOpenHashMap();
    private final Int2ObjectMap<BossBar> bossBarMap = new Int2ObjectOpenHashMap<BossBar>();
    private final IntSet validBlocking = new IntOpenHashSet();
    private final IntSet knownHolograms = new IntOpenHashSet();
    private final Set<BlockPosition> blockInteractions = Collections.newSetFromMap(CacheBuilder.newBuilder().maximumSize(1000L).expireAfterAccess(250L, TimeUnit.MILLISECONDS).build().asMap());
    private boolean blocking;
    private boolean autoTeam;
    private BlockPosition currentlyDigging;
    private boolean teamExists;
    private GameMode gameMode;
    private String currentTeam;
    private int heldItemSlot;
    private Item itemInSecondHand;

    public EntityTracker1_9(UserConnection userConnection) {
        super(userConnection, EntityTypes1_9.EntityType.PLAYER);
    }

    public UUID getEntityUUID(int n2) {
        return this.uuidMap.computeIfAbsent(n2, n -> UUIDUtil.randomUUID());
    }

    public void setSecondHand(Item item) {
        this.setSecondHand(this.clientEntityId(), item);
    }

    public void setSecondHand(int n, Item item) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.SET_EQUIPPED_ITEM, null, this.user());
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.VAR_INT, 1);
        this.itemInSecondHand = item;
        packetWrapper.write(Types.ITEM1_8, this.itemInSecondHand);
        packetWrapper.scheduleSend(Protocol1_8To1_9.class);
    }

    public Item getItemInSecondHand() {
        return this.itemInSecondHand;
    }

    public void syncShieldWithSword() {
        if (this.user().getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_4)) {
            return;
        }
        boolean bl = this.hasSwordInHand();
        if (!bl || this.itemInSecondHand == null) {
            this.setSecondHand(bl ? new DataItem(442, 1, 0, null) : null);
        }
    }

    public boolean hasSwordInHand() {
        InventoryTracker inventoryTracker = this.user().get(InventoryTracker.class);
        int n = this.heldItemSlot + 36;
        int n2 = inventoryTracker.getItemId(0, (short)n);
        return Protocol1_8To1_9.isSword(n2);
    }

    @Override
    public @Nullable TrackedEntity removeEntity(int n) {
        this.vehicleMap.remove(n);
        this.uuidMap.remove(n);
        this.validBlocking.remove(n);
        this.knownHolograms.remove(n);
        BossBar bossBar = (BossBar)this.bossBarMap.remove(n);
        if (bossBar != null) {
            bossBar.hide();
            Via.getManager().getProviders().get(BossBarProvider.class).handleRemove(this.user(), bossBar.getId());
        }
        return super.removeEntity(n);
    }

    public boolean interactedBlockRecently(int n, int n2, int n3) {
        for (BlockPosition blockPosition : this.blockInteractions) {
            if (Math.abs(blockPosition.x() - n) > 1 || Math.abs(blockPosition.y() - n2) > 1 || Math.abs(blockPosition.z() - n3) > 1) continue;
            return true;
        }
        return false;
    }

    public void addBlockInteraction(BlockPosition blockPosition) {
        this.blockInteractions.add(blockPosition);
    }

    public void handleEntityData(int n, List<EntityData> list) {
        EntityType entityType = this.entityType(n);
        if (entityType == null) {
            return;
        }
        for (EntityData entityData : new ArrayList<EntityData>(list)) {
            Object object;
            Object object2;
            int n2;
            if (entityType == EntityTypes1_9.EntityType.SKELETON && this.getDataByIndex(list, 12) == null) {
                list.add(new EntityData(12, EntityDataTypes1_9.BOOLEAN, true));
            }
            if (entityType == EntityTypes1_9.EntityType.HORSE && entityData.id() == 16 && ((n2 = ((Integer)entityData.value()).intValue()) < 0 || n2 > 3)) {
                entityData.setValue(0);
            }
            if (entityType == EntityTypes1_9.EntityType.PLAYER) {
                if (entityData.id() == 0) {
                    n2 = ((Byte)entityData.getValue()).byteValue();
                    if (n != this.getProvidedEntityId() && Via.getConfig().isShieldBlocking() && this.user().getProtocolInfo().protocolVersion().olderThan(ProtocolVersion.v1_21_4)) {
                        if ((n2 & 0x10) == 16) {
                            if (this.validBlocking.contains(n)) {
                                object2 = new DataItem(442, 1, 0, null);
                                this.setSecondHand(n, (Item)object2);
                            } else {
                                this.setSecondHand(n, null);
                            }
                        } else {
                            this.setSecondHand(n, null);
                        }
                    }
                }
                if (entityData.id() == 12 && Via.getConfig().isLeftHandedHandling()) {
                    list.add(new EntityData(13, EntityDataTypes1_9.BYTE, (byte)(((Byte)entityData.getValue() & 0x80) == 0 ? 1 : 0)));
                }
            }
            if (entityType == EntityTypes1_9.EntityType.ARMOR_STAND && Via.getConfig().isHologramPatch() && entityData.id() == 0 && this.getDataByIndex(list, 10) != null) {
                EntityData entityData2;
                EntityData entityData3 = this.getDataByIndex(list, 10);
                byte by = (Byte)entityData.getValue();
                if ((by & 0x20) == 32 && ((Byte)entityData3.getValue() & 1) == 1 && (entityData2 = this.getDataByIndex(list, 2)) != null && !((String)entityData2.getValue()).isEmpty() && (object = this.getDataByIndex(list, 3)) != null && ((Boolean)((EntityData)object).getValue()).booleanValue() && !this.knownHolograms.contains(n)) {
                    this.knownHolograms.add(n);
                    PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.MOVE_ENTITY_POS, null, this.user());
                    packetWrapper.write(Types.VAR_INT, n);
                    packetWrapper.write(Types.SHORT, (short)0);
                    packetWrapper.write(Types.SHORT, (short)(128.0 * (Via.getConfig().getHologramYOffset() * 32.0)));
                    packetWrapper.write(Types.SHORT, (short)0);
                    packetWrapper.write(Types.BOOLEAN, true);
                    packetWrapper.scheduleSend(Protocol1_8To1_9.class);
                }
            }
            if (!Via.getConfig().isBossbarPatch() || entityType != EntityTypes1_9.EntityType.ENDER_DRAGON && entityType != EntityTypes1_9.EntityType.WITHER) continue;
            if (entityData.id() == 2) {
                BossBar bossBar = (BossBar)this.bossBarMap.get(n);
                object2 = (String)entityData.getValue();
                object2 = ((String)object2).isEmpty() ? (entityType == EntityTypes1_9.EntityType.ENDER_DRAGON ? DRAGON_TRANSLATABLE : WITHER_TRANSLATABLE) : ComponentUtil.plainToJson((String)object2).toString();
                if (bossBar == null) {
                    bossBar = Via.getAPI().legacyAPI().createLegacyBossBar((String)object2, BossColor.PINK, BossStyle.SOLID);
                    this.bossBarMap.put(n, bossBar);
                    bossBar.addConnection(this.user());
                    bossBar.show();
                    Via.getManager().getProviders().get(BossBarProvider.class).handleAdd(this.user(), bossBar.getId());
                    continue;
                }
                bossBar.setTitle((String)object2);
                continue;
            }
            if (entityData.id() != 6 || Via.getConfig().isBossbarAntiflicker()) continue;
            BossBar bossBar = (BossBar)this.bossBarMap.get(n);
            float f = entityType == EntityTypes1_9.EntityType.ENDER_DRAGON ? 200.0f : 300.0f;
            float f2 = Math.max(0.0f, Math.min(((Float)entityData.getValue()).floatValue() / f, 1.0f));
            if (bossBar == null) {
                object = entityType == EntityTypes1_9.EntityType.ENDER_DRAGON ? DRAGON_TRANSLATABLE : WITHER_TRANSLATABLE;
                bossBar = Via.getAPI().legacyAPI().createLegacyBossBar((String)object, f2, BossColor.PINK, BossStyle.SOLID);
                this.bossBarMap.put(n, bossBar);
                bossBar.addConnection(this.user());
                bossBar.show();
                Via.getManager().getProviders().get(BossBarProvider.class).handleAdd(this.user(), bossBar.getId());
                continue;
            }
            bossBar.setHealth(f2);
        }
    }

    public EntityData getDataByIndex(List<EntityData> list, int n) {
        for (EntityData entityData : list) {
            if (n != entityData.id()) continue;
            return entityData;
        }
        return null;
    }

    public void sendTeamPacket(boolean bl, boolean bl2) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.SET_PLAYER_TEAM, null, this.user());
        packetWrapper.write(Types.STRING, "viaversion");
        if (bl) {
            if (!this.teamExists) {
                packetWrapper.write(Types.BYTE, (byte)0);
                packetWrapper.write(Types.STRING, "viaversion");
                packetWrapper.write(Types.STRING, "\u00a7f");
                packetWrapper.write(Types.STRING, "");
                packetWrapper.write(Types.BYTE, (byte)0);
                packetWrapper.write(Types.STRING, "");
                packetWrapper.write(Types.STRING, "never");
                packetWrapper.write(Types.BYTE, (byte)15);
            } else {
                packetWrapper.write(Types.BYTE, (byte)3);
            }
            packetWrapper.write(Types.STRING_ARRAY, new String[]{this.user().getProtocolInfo().getUsername()});
        } else {
            packetWrapper.write(Types.BYTE, (byte)1);
        }
        this.teamExists = bl;
        if (bl2) {
            packetWrapper.send(Protocol1_8To1_9.class);
        } else {
            packetWrapper.scheduleSend(Protocol1_8To1_9.class);
        }
    }

    public int getProvidedEntityId() {
        try {
            return Via.getManager().getProviders().get(EntityIdProvider.class).getEntityId(this.user());
        }
        catch (Exception exception) {
            return this.clientEntityId();
        }
    }

    public Int2ObjectMap<UUID> getUuidMap() {
        return this.uuidMap;
    }

    public Int2IntMap getVehicleMap() {
        return this.vehicleMap;
    }

    public Int2ObjectMap<BossBar> getBossBarMap() {
        return this.bossBarMap;
    }

    public IntSet getValidBlocking() {
        return this.validBlocking;
    }

    public IntSet getKnownHolograms() {
        return this.knownHolograms;
    }

    public Set<BlockPosition> getBlockInteractions() {
        return this.blockInteractions;
    }

    public boolean isBlocking() {
        return this.blocking;
    }

    public void setBlocking(boolean bl) {
        this.blocking = bl;
    }

    public boolean isAutoTeam() {
        return this.autoTeam;
    }

    public void setAutoTeam(boolean bl) {
        this.autoTeam = bl;
    }

    public BlockPosition getCurrentlyDigging() {
        return this.currentlyDigging;
    }

    public void setCurrentlyDigging(BlockPosition blockPosition) {
        this.currentlyDigging = blockPosition;
    }

    public boolean isTeamExists() {
        return this.teamExists;
    }

    public GameMode getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public String getCurrentTeam() {
        return this.currentTeam;
    }

    public void setCurrentTeam(String string) {
        this.currentTeam = string;
    }

    public void setHeldItemSlot(int n) {
        this.heldItemSlot = n;
    }
}

