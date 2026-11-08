/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.optifine.ChunkPosComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerManager {
    private static final Logger pmLogger = LogManager.getLogger();
    private final WorldServer theWorldServer;
    private final List<EntityPlayerMP> players = Lists.newArrayList();
    private final LongHashMap<PlayerInstance> playerInstances = new LongHashMap();
    private final List<PlayerInstance> playerInstancesToUpdate = Lists.newArrayList();
    private final List<PlayerInstance> playerInstanceList = Lists.newArrayList();
    private int playerViewRadius;
    private long previousTotalWorldTime;
    private final int[][] xzDirectionsConst = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final Map<EntityPlayerMP, Set<ChunkCoordIntPair>> mapPlayerPendingEntries = new HashMap<EntityPlayerMP, Set<ChunkCoordIntPair>>();

    public PlayerManager(WorldServer worldServer) {
        this.theWorldServer = worldServer;
        this.setPlayerViewRadius(worldServer.getMinecraftServer().getConfigurationManager().getViewDistance());
    }

    public WorldServer getWorldServer() {
        return this.theWorldServer;
    }

    public void updatePlayerInstances() {
        WorldProvider worldProvider;
        Set<Map.Entry<EntityPlayerMP, Set<ChunkCoordIntPair>>> set = this.mapPlayerPendingEntries.entrySet();
        Iterator<Map.Entry<EntityPlayerMP, Set<ChunkCoordIntPair>>> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<EntityPlayerMP, Set<ChunkCoordIntPair>> entry = iterator2.next();
            Set<ChunkCoordIntPair> set2 = entry.getValue();
            if (set2.isEmpty()) continue;
            EntityPlayerMP entityPlayerMP = entry.getKey();
            if (entityPlayerMP.worldObj != this.theWorldServer) {
                iterator2.remove();
                continue;
            }
            int n = this.playerViewRadius / 3 + 1;
            if (!Config.isLazyChunkLoading()) {
                n = this.playerViewRadius * 2 + 1;
            }
            for (ChunkCoordIntPair chunkCoordIntPair : this.getNearest(set2, entityPlayerMP, n)) {
                PlayerInstance playerInstance = this.getPlayerInstance(chunkCoordIntPair.chunkXPos, chunkCoordIntPair.chunkZPos, true);
                playerInstance.addPlayer(entityPlayerMP);
                set2.remove(chunkCoordIntPair);
            }
        }
        long l = this.theWorldServer.getTotalWorldTime();
        if (l - this.previousTotalWorldTime > 8000L) {
            this.previousTotalWorldTime = l;
            for (var5_7 = 0; var5_7 < this.playerInstanceList.size(); ++var5_7) {
                PlayerInstance playerInstance = this.playerInstanceList.get(var5_7);
                playerInstance.onUpdate();
                playerInstance.processChunk();
            }
        } else {
            for (var5_7 = 0; var5_7 < this.playerInstancesToUpdate.size(); ++var5_7) {
                PlayerInstance playerInstance = this.playerInstancesToUpdate.get(var5_7);
                playerInstance.onUpdate();
            }
        }
        this.playerInstancesToUpdate.clear();
        if (this.players.isEmpty() && !(worldProvider = this.theWorldServer.provider).canRespawnHere()) {
            this.theWorldServer.theChunkProviderServer.unloadAllChunks();
        }
    }

    public boolean hasPlayerInstance(int n, int n2) {
        long l = (long)n + Integer.MAX_VALUE | (long)n2 + Integer.MAX_VALUE << 32;
        return this.playerInstances.getValueByKey(l) != null;
    }

    private PlayerInstance getPlayerInstance(int n, int n2, boolean bl) {
        long l = (long)n + Integer.MAX_VALUE | (long)n2 + Integer.MAX_VALUE << 32;
        PlayerInstance playerInstance = this.playerInstances.getValueByKey(l);
        if (playerInstance == null && bl) {
            playerInstance = new PlayerInstance(n, n2);
            this.playerInstances.add(l, playerInstance);
            this.playerInstanceList.add(playerInstance);
        }
        return playerInstance;
    }

    public void markBlockForUpdate(BlockPos blockPos) {
        int n;
        int n2 = blockPos.getX() >> 4;
        PlayerInstance playerInstance = this.getPlayerInstance(n2, n = blockPos.getZ() >> 4, false);
        if (playerInstance != null) {
            playerInstance.flagChunkForUpdate(blockPos.getX() & 0xF, blockPos.getY(), blockPos.getZ() & 0xF);
        }
    }

    public void addPlayer(EntityPlayerMP entityPlayerMP) {
        int n = (int)entityPlayerMP.posX >> 4;
        int n2 = (int)entityPlayerMP.posZ >> 4;
        entityPlayerMP.managedPosX = entityPlayerMP.posX;
        entityPlayerMP.managedPosZ = entityPlayerMP.posZ;
        int n3 = Math.min(this.playerViewRadius, 8);
        int n4 = n - n3;
        int n5 = n + n3;
        int n6 = n2 - n3;
        int n7 = n2 + n3;
        Set<ChunkCoordIntPair> set = this.getPendingEntriesSafe(entityPlayerMP);
        for (int i = n - this.playerViewRadius; i <= n + this.playerViewRadius; ++i) {
            for (int j = n2 - this.playerViewRadius; j <= n2 + this.playerViewRadius; ++j) {
                if (i >= n4 && i <= n5 && j >= n6 && j <= n7) {
                    this.getPlayerInstance(i, j, true).addPlayer(entityPlayerMP);
                    continue;
                }
                set.add(new ChunkCoordIntPair(i, j));
            }
        }
        this.players.add(entityPlayerMP);
        this.filterChunkLoadQueue(entityPlayerMP);
    }

    public void filterChunkLoadQueue(EntityPlayerMP entityPlayerMP) {
        int n;
        ArrayList<ChunkCoordIntPair> arrayList = Lists.newArrayList(entityPlayerMP.loadedChunks);
        int n2 = 0;
        int n3 = this.playerViewRadius;
        int n4 = (int)entityPlayerMP.posX >> 4;
        int n5 = (int)entityPlayerMP.posZ >> 4;
        int n6 = 0;
        int n7 = 0;
        ChunkCoordIntPair chunkCoordIntPair = this.getPlayerInstance((int)n4, (int)n5, (boolean)true).chunkCoords;
        entityPlayerMP.loadedChunks.clear();
        if (arrayList.contains(chunkCoordIntPair)) {
            entityPlayerMP.loadedChunks.add(chunkCoordIntPair);
        }
        for (n = 1; n <= n3 * 2; ++n) {
            for (int i = 0; i < 2; ++i) {
                int[] nArray = this.xzDirectionsConst[n2++ % 4];
                for (int j = 0; j < n; ++j) {
                    chunkCoordIntPair = this.getPlayerInstance((int)(n4 + (n6 += nArray[0])), (int)(n5 + (n7 += nArray[1])), (boolean)true).chunkCoords;
                    if (!arrayList.contains(chunkCoordIntPair)) continue;
                    entityPlayerMP.loadedChunks.add(chunkCoordIntPair);
                }
            }
        }
        n2 %= 4;
        for (n = 0; n < n3 * 2; ++n) {
            chunkCoordIntPair = this.getPlayerInstance((int)(n4 + (n6 += this.xzDirectionsConst[n2][0])), (int)(n5 + (n7 += this.xzDirectionsConst[n2][1])), (boolean)true).chunkCoords;
            if (!arrayList.contains(chunkCoordIntPair)) continue;
            entityPlayerMP.loadedChunks.add(chunkCoordIntPair);
        }
    }

    public void removePlayer(EntityPlayerMP entityPlayerMP) {
        this.mapPlayerPendingEntries.remove(entityPlayerMP);
        int n = (int)entityPlayerMP.managedPosX >> 4;
        int n2 = (int)entityPlayerMP.managedPosZ >> 4;
        for (int i = n - this.playerViewRadius; i <= n + this.playerViewRadius; ++i) {
            for (int j = n2 - this.playerViewRadius; j <= n2 + this.playerViewRadius; ++j) {
                PlayerInstance playerInstance = this.getPlayerInstance(i, j, false);
                if (playerInstance == null) continue;
                playerInstance.removePlayer(entityPlayerMP);
            }
        }
        this.players.remove(entityPlayerMP);
    }

    private boolean overlaps(int n, int n2, int n3, int n4, int n5) {
        int n6 = n - n3;
        int n7 = n2 - n4;
        return n6 >= -n5 && n6 <= n5 ? n7 >= -n5 && n7 <= n5 : false;
    }

    public void updateMountedMovingPlayer(EntityPlayerMP entityPlayerMP) {
        int n = (int)entityPlayerMP.posX >> 4;
        int n2 = (int)entityPlayerMP.posZ >> 4;
        double d = entityPlayerMP.managedPosX - entityPlayerMP.posX;
        double d2 = entityPlayerMP.managedPosZ - entityPlayerMP.posZ;
        double d3 = d * d + d2 * d2;
        if (d3 >= 64.0) {
            int n3 = (int)entityPlayerMP.managedPosX >> 4;
            int n4 = (int)entityPlayerMP.managedPosZ >> 4;
            int n5 = this.playerViewRadius;
            int n6 = n - n3;
            int n7 = n2 - n4;
            if (n6 != 0 || n7 != 0) {
                Set<ChunkCoordIntPair> set = this.getPendingEntriesSafe(entityPlayerMP);
                for (int i = n - n5; i <= n + n5; ++i) {
                    for (int j = n2 - n5; j <= n2 + n5; ++j) {
                        if (!this.overlaps(i, j, n3, n4, n5)) {
                            if (Config.isLazyChunkLoading()) {
                                set.add(new ChunkCoordIntPair(i, j));
                            } else {
                                this.getPlayerInstance(i, j, true).addPlayer(entityPlayerMP);
                            }
                        }
                        if (this.overlaps(i - n6, j - n7, n, n2, n5)) continue;
                        set.remove(new ChunkCoordIntPair(i - n6, j - n7));
                        PlayerInstance playerInstance = this.getPlayerInstance(i - n6, j - n7, false);
                        if (playerInstance == null) continue;
                        playerInstance.removePlayer(entityPlayerMP);
                    }
                }
                this.filterChunkLoadQueue(entityPlayerMP);
                entityPlayerMP.managedPosX = entityPlayerMP.posX;
                entityPlayerMP.managedPosZ = entityPlayerMP.posZ;
            }
        }
    }

    public boolean isPlayerWatchingChunk(EntityPlayerMP entityPlayerMP, int n, int n2) {
        PlayerInstance playerInstance = this.getPlayerInstance(n, n2, false);
        return playerInstance != null && playerInstance.playersWatchingChunk.contains(entityPlayerMP) && !entityPlayerMP.loadedChunks.contains(playerInstance.chunkCoords);
    }

    public void setPlayerViewRadius(int n) {
        if ((n = MathHelper.clamp_int(n, 3, 64)) != this.playerViewRadius) {
            int n2 = n - this.playerViewRadius;
            for (EntityPlayerMP entityPlayerMP : Lists.newArrayList(this.players)) {
                PlayerInstance playerInstance;
                int n3;
                int n4;
                int n5 = (int)entityPlayerMP.posX >> 4;
                int n6 = (int)entityPlayerMP.posZ >> 4;
                Set<ChunkCoordIntPair> set = this.getPendingEntriesSafe(entityPlayerMP);
                if (n2 > 0) {
                    for (n4 = n5 - n; n4 <= n5 + n; ++n4) {
                        for (n3 = n6 - n; n3 <= n6 + n; ++n3) {
                            if (Config.isLazyChunkLoading()) {
                                set.add(new ChunkCoordIntPair(n4, n3));
                                continue;
                            }
                            playerInstance = this.getPlayerInstance(n4, n3, true);
                            if (playerInstance.playersWatchingChunk.contains(entityPlayerMP)) continue;
                            playerInstance.addPlayer(entityPlayerMP);
                        }
                    }
                    continue;
                }
                for (n4 = n5 - this.playerViewRadius; n4 <= n5 + this.playerViewRadius; ++n4) {
                    for (n3 = n6 - this.playerViewRadius; n3 <= n6 + this.playerViewRadius; ++n3) {
                        if (this.overlaps(n4, n3, n5, n6, n)) continue;
                        set.remove(new ChunkCoordIntPair(n4, n3));
                        playerInstance = this.getPlayerInstance(n4, n3, true);
                        if (playerInstance == null) continue;
                        playerInstance.removePlayer(entityPlayerMP);
                    }
                }
            }
            this.playerViewRadius = n;
        }
    }

    public static int getFurthestViewableBlock(int n) {
        return n * 16 - 16;
    }

    private PriorityQueue<ChunkCoordIntPair> getNearest(Set<ChunkCoordIntPair> set, EntityPlayerMP entityPlayerMP, int n) {
        float f;
        for (f = entityPlayerMP.rotationYaw + 90.0f; f <= -180.0f; f += 360.0f) {
        }
        while (f > 180.0f) {
            f -= 360.0f;
        }
        double d = (double)f * (Math.PI / 180);
        double d2 = entityPlayerMP.rotationPitch;
        double d3 = d2 * (Math.PI / 180);
        ChunkPosComparator chunkPosComparator = new ChunkPosComparator(entityPlayerMP.chunkCoordX, entityPlayerMP.chunkCoordZ, d, d3);
        Comparator<ChunkCoordIntPair> comparator = Collections.reverseOrder(chunkPosComparator);
        PriorityQueue<ChunkCoordIntPair> priorityQueue = new PriorityQueue<ChunkCoordIntPair>(n, comparator);
        for (ChunkCoordIntPair chunkCoordIntPair : set) {
            if (priorityQueue.size() < n) {
                priorityQueue.add(chunkCoordIntPair);
                continue;
            }
            ChunkCoordIntPair chunkCoordIntPair2 = priorityQueue.peek();
            if (chunkPosComparator.compare(chunkCoordIntPair, chunkCoordIntPair2) >= 0) continue;
            priorityQueue.remove();
            priorityQueue.add(chunkCoordIntPair);
        }
        return priorityQueue;
    }

    private Set<ChunkCoordIntPair> getPendingEntriesSafe(EntityPlayerMP entityPlayerMP) {
        Set<ChunkCoordIntPair> set = this.mapPlayerPendingEntries.get(entityPlayerMP);
        if (set != null) {
            return set;
        }
        int n = Math.min(this.playerViewRadius, 8);
        int n2 = this.playerViewRadius * 2 + 1;
        int n3 = n * 2 + 1;
        int n4 = n2 * n2 - n3 * n3;
        n4 = Math.max(n4, 16);
        HashSet<ChunkCoordIntPair> hashSet = new HashSet<ChunkCoordIntPair>(n4);
        this.mapPlayerPendingEntries.put(entityPlayerMP, hashSet);
        return hashSet;
    }

    public class PlayerInstance {
        private final List<EntityPlayerMP> playersWatchingChunk = Lists.newArrayList();
        private final ChunkCoordIntPair chunkCoords;
        private short[] locationOfBlockChange = new short[64];
        private int numBlocksToUpdate;
        private int flagsYAreasToUpdate;
        private long previousWorldTime;

        public PlayerInstance(int n, int n2) {
            this.chunkCoords = new ChunkCoordIntPair(n, n2);
            PlayerManager.this.getWorldServer().theChunkProviderServer.loadChunk(n, n2);
        }

        public void addPlayer(EntityPlayerMP entityPlayerMP) {
            if (this.playersWatchingChunk.contains(entityPlayerMP)) {
                pmLogger.debug("Failed to add player. {} already is in chunk {}, {}", entityPlayerMP, this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos);
            } else {
                if (this.playersWatchingChunk.isEmpty()) {
                    this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
                }
                this.playersWatchingChunk.add(entityPlayerMP);
                entityPlayerMP.loadedChunks.add(this.chunkCoords);
            }
        }

        public void removePlayer(EntityPlayerMP entityPlayerMP) {
            if (this.playersWatchingChunk.contains(entityPlayerMP)) {
                Chunk chunk = PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos);
                if (chunk.isPopulated()) {
                    entityPlayerMP.playerNetServerHandler.sendPacket(new S21PacketChunkData(chunk, true, 0));
                }
                this.playersWatchingChunk.remove(entityPlayerMP);
                entityPlayerMP.loadedChunks.remove(this.chunkCoords);
                if (this.playersWatchingChunk.isEmpty()) {
                    long l = (long)this.chunkCoords.chunkXPos + Integer.MAX_VALUE | (long)this.chunkCoords.chunkZPos + Integer.MAX_VALUE << 32;
                    this.increaseInhabitedTime(chunk);
                    PlayerManager.this.playerInstances.remove(l);
                    PlayerManager.this.playerInstanceList.remove(this);
                    if (this.numBlocksToUpdate > 0) {
                        PlayerManager.this.playerInstancesToUpdate.remove(this);
                    }
                    PlayerManager.this.getWorldServer().theChunkProviderServer.dropChunk(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos);
                }
            }
        }

        public void processChunk() {
            this.increaseInhabitedTime(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos));
        }

        private void increaseInhabitedTime(Chunk chunk) {
            chunk.setInhabitedTime(chunk.getInhabitedTime() + PlayerManager.this.theWorldServer.getTotalWorldTime() - this.previousWorldTime);
            this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
        }

        public void flagChunkForUpdate(int n, int n2, int n3) {
            if (this.numBlocksToUpdate == 0) {
                PlayerManager.this.playerInstancesToUpdate.add(this);
            }
            this.flagsYAreasToUpdate |= 1 << (n2 >> 4);
            if (this.numBlocksToUpdate < 64) {
                short s = (short)(n << 12 | n3 << 8 | n2);
                for (int i = 0; i < this.numBlocksToUpdate; ++i) {
                    if (this.locationOfBlockChange[i] != s) continue;
                    return;
                }
                this.locationOfBlockChange[this.numBlocksToUpdate++] = s;
            }
        }

        public void sendToAllPlayersWatchingChunk(Packet packet) {
            for (int i = 0; i < this.playersWatchingChunk.size(); ++i) {
                EntityPlayerMP entityPlayerMP = this.playersWatchingChunk.get(i);
                if (entityPlayerMP.loadedChunks.contains(this.chunkCoords)) continue;
                entityPlayerMP.playerNetServerHandler.sendPacket(packet);
            }
        }

        public void onUpdate() {
            if (this.numBlocksToUpdate != 0) {
                if (this.numBlocksToUpdate == 1) {
                    int n = (this.locationOfBlockChange[0] >> 12 & 0xF) + this.chunkCoords.chunkXPos * 16;
                    int n2 = this.locationOfBlockChange[0] & 0xFF;
                    int n3 = (this.locationOfBlockChange[0] >> 8 & 0xF) + this.chunkCoords.chunkZPos * 16;
                    BlockPos blockPos = new BlockPos(n, n2, n3);
                    this.sendToAllPlayersWatchingChunk(new S23PacketBlockChange(PlayerManager.this.theWorldServer, blockPos));
                    if (PlayerManager.this.theWorldServer.getBlockState(blockPos).getBlock().hasTileEntity()) {
                        this.sendTileToAllPlayersWatchingChunk(PlayerManager.this.theWorldServer.getTileEntity(blockPos));
                    }
                } else if (this.numBlocksToUpdate != 64) {
                    this.sendToAllPlayersWatchingChunk(new S22PacketMultiBlockChange(this.numBlocksToUpdate, this.locationOfBlockChange, PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos)));
                    for (int i = 0; i < this.numBlocksToUpdate; ++i) {
                        int n = (this.locationOfBlockChange[i] >> 12 & 0xF) + this.chunkCoords.chunkXPos * 16;
                        int n4 = this.locationOfBlockChange[i] & 0xFF;
                        int n5 = (this.locationOfBlockChange[i] >> 8 & 0xF) + this.chunkCoords.chunkZPos * 16;
                        BlockPos blockPos = new BlockPos(n, n4, n5);
                        if (!PlayerManager.this.theWorldServer.getBlockState(blockPos).getBlock().hasTileEntity()) continue;
                        this.sendTileToAllPlayersWatchingChunk(PlayerManager.this.theWorldServer.getTileEntity(blockPos));
                    }
                } else {
                    int n = this.chunkCoords.chunkXPos * 16;
                    int n6 = this.chunkCoords.chunkZPos * 16;
                    this.sendToAllPlayersWatchingChunk(new S21PacketChunkData(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos), false, this.flagsYAreasToUpdate));
                    for (int i = 0; i < 16; ++i) {
                        if ((this.flagsYAreasToUpdate & 1 << i) == 0) continue;
                        int n7 = i << 4;
                        List<TileEntity> list = PlayerManager.this.theWorldServer.getTileEntitiesIn(n, n7, n6, n + 16, n7 + 16, n6 + 16);
                        for (int j = 0; j < list.size(); ++j) {
                            this.sendTileToAllPlayersWatchingChunk(list.get(j));
                        }
                    }
                }
                this.numBlocksToUpdate = 0;
                this.flagsYAreasToUpdate = 0;
            }
        }

        private void sendTileToAllPlayersWatchingChunk(TileEntity tileEntity) {
            Packet packet;
            if (tileEntity != null && (packet = tileEntity.getDescriptionPacket()) != null) {
                this.sendToAllPlayersWatchingChunk(packet);
            }
        }
    }
}

