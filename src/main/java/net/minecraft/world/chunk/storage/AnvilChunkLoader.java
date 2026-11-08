/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.storage.RegionFileCache;
import net.minecraft.world.storage.IThreadedFileIO;
import net.minecraft.world.storage.ThreadedFileIOBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnvilChunkLoader
implements IChunkLoader,
IThreadedFileIO {
    private static final Logger logger = LogManager.getLogger();
    private Map<ChunkCoordIntPair, NBTTagCompound> chunksToRemove = new ConcurrentHashMap<ChunkCoordIntPair, NBTTagCompound>();
    private Set<ChunkCoordIntPair> pendingAnvilChunksCoordinates = Collections.newSetFromMap(new ConcurrentHashMap());
    private final File chunkSaveLocation;
    private boolean field_183014_e = false;

    public AnvilChunkLoader(File file) {
        this.chunkSaveLocation = file;
    }

    @Override
    public Chunk loadChunk(World world2, int n, int n2) throws IOException {
        ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(n, n2);
        NBTTagCompound nBTTagCompound = this.chunksToRemove.get(chunkCoordIntPair);
        if (nBTTagCompound == null) {
            try (DataInputStream dataInputStream = RegionFileCache.getChunkInputStream(this.chunkSaveLocation, n, n2);){
                if (dataInputStream == null) {
                    Chunk chunk = null;
                    return chunk;
                }
                nBTTagCompound = CompressedStreamTools.read(dataInputStream);
            }
        }
        return this.checkedReadChunkFromNBT(world2, n, n2, nBTTagCompound);
    }

    protected Chunk checkedReadChunkFromNBT(World world2, int n, int n2, NBTTagCompound nBTTagCompound) {
        if (!nBTTagCompound.hasKey("Level", 10)) {
            logger.error("Chunk file at " + n + "," + n2 + " is missing level data, skipping");
            return null;
        }
        NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("Level");
        if (!nBTTagCompound2.hasKey("Sections", 9)) {
            logger.error("Chunk file at " + n + "," + n2 + " is missing block data, skipping");
            return null;
        }
        Chunk chunk = this.readChunkFromNBT(world2, nBTTagCompound2);
        if (!chunk.isAtLocation(n, n2)) {
            logger.error("Chunk file at " + n + "," + n2 + " is in the wrong location; relocating. (Expected " + n + ", " + n2 + ", got " + chunk.xPosition + ", " + chunk.zPosition + ")");
            nBTTagCompound2.setInteger("xPos", n);
            nBTTagCompound2.setInteger("zPos", n2);
            chunk = this.readChunkFromNBT(world2, nBTTagCompound2);
        }
        return chunk;
    }

    @Override
    public void saveChunk(World world2, Chunk chunk) throws MinecraftException, IOException {
        world2.checkSessionLock();
        try {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound.setTag("Level", nBTTagCompound2);
            this.writeChunkToNBT(chunk, world2, nBTTagCompound2);
            this.addChunkToPending(chunk.getChunkCoordIntPair(), nBTTagCompound);
        }
        catch (Exception exception) {
            logger.error("Failed to save chunk", (Throwable)exception);
        }
    }

    protected void addChunkToPending(ChunkCoordIntPair chunkCoordIntPair, NBTTagCompound nBTTagCompound) {
        if (!this.pendingAnvilChunksCoordinates.contains(chunkCoordIntPair)) {
            this.chunksToRemove.put(chunkCoordIntPair, nBTTagCompound);
        }
        ThreadedFileIOBase.getThreadedIOInstance().queueIO(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean writeNextIO() {
        boolean bl;
        if (this.chunksToRemove.isEmpty()) {
            if (this.field_183014_e) {
                logger.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", this.chunkSaveLocation.getName());
            }
            return false;
        }
        ChunkCoordIntPair chunkCoordIntPair = this.chunksToRemove.keySet().iterator().next();
        try {
            this.pendingAnvilChunksCoordinates.add(chunkCoordIntPair);
            NBTTagCompound nBTTagCompound = this.chunksToRemove.remove(chunkCoordIntPair);
            if (nBTTagCompound != null) {
                try {
                    this.func_183013_b(chunkCoordIntPair, nBTTagCompound);
                }
                catch (Exception exception) {
                    logger.error("Failed to save chunk", (Throwable)exception);
                }
            }
            bl = true;
        }
        finally {
            this.pendingAnvilChunksCoordinates.remove(chunkCoordIntPair);
        }
        return bl;
    }

    private void func_183013_b(ChunkCoordIntPair chunkCoordIntPair, NBTTagCompound nBTTagCompound) throws IOException {
        DataOutputStream dataOutputStream = RegionFileCache.getChunkOutputStream(this.chunkSaveLocation, chunkCoordIntPair.chunkXPos, chunkCoordIntPair.chunkZPos);
        CompressedStreamTools.write(nBTTagCompound, dataOutputStream);
        dataOutputStream.close();
    }

    @Override
    public void saveExtraChunkData(World world2, Chunk chunk) throws IOException {
    }

    @Override
    public void chunkTick() {
    }

    @Override
    public void saveExtraData() {
        try {
            this.field_183014_e = true;
            while (true) {
                if (this.writeNextIO()) continue;
            }
        }
        catch (Throwable throwable) {
            this.field_183014_e = false;
            throw throwable;
        }
    }

    private void writeChunkToNBT(Chunk chunk, World world2, NBTTagCompound nBTTagCompound) {
        Object object;
        Object object2;
        Object object3;
        NBTTagCompound nBTTagCompound2;
        nBTTagCompound.setByte("V", (byte)1);
        nBTTagCompound.setInteger("xPos", chunk.xPosition);
        nBTTagCompound.setInteger("zPos", chunk.zPosition);
        nBTTagCompound.setLong("LastUpdate", world2.getTotalWorldTime());
        nBTTagCompound.setIntArray("HeightMap", chunk.getHeightMap());
        nBTTagCompound.setBoolean("TerrainPopulated", chunk.isTerrainPopulated());
        nBTTagCompound.setBoolean("LightPopulated", chunk.isLightPopulated());
        nBTTagCompound.setLong("InhabitedTime", chunk.getInhabitedTime());
        ExtendedBlockStorage[] extendedBlockStorageArray = chunk.getBlockStorageArray();
        NBTTagList nBTTagList = new NBTTagList();
        boolean bl = !world2.provider.getHasNoSky();
        for (ExtendedBlockStorage object4 : extendedBlockStorageArray) {
            if (object4 == null) continue;
            nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.setByte("Y", (byte)(object4.getYLocation() >> 4 & 0xFF));
            object3 = new byte[object4.getData().length];
            object2 = new NibbleArray();
            object = null;
            for (int i = 0; i < object4.getData().length; ++i) {
                char c = object4.getData()[i];
                int n = i & 0xF;
                int n2 = i >> 8 & 0xF;
                int n3 = i >> 4 & 0xF;
                if (c >> 12 != 0) {
                    if (object == null) {
                        object = new NibbleArray();
                    }
                    ((NibbleArray)object).set(n, n2, n3, c >> 12);
                }
                object3[i] = (byte)(c >> 4 & 0xFF);
                ((NibbleArray)object2).set(n, n2, n3, c & 0xF);
            }
            nBTTagCompound2.setByteArray("Blocks", (byte[])object3);
            nBTTagCompound2.setByteArray("Data", (byte[])((NibbleArray)object2).getReadOnlyData().clone());
            if (object != null) {
                nBTTagCompound2.setByteArray("Add", (byte[])((NibbleArray)object).getReadOnlyData().clone());
            }
            nBTTagCompound2.setByteArray("BlockLight", (byte[])object4.getBlocklightArray().getReadOnlyData().clone());
            if (bl) {
                nBTTagCompound2.setByteArray("SkyLight", (byte[])object4.getSkylightArray().getReadOnlyData().clone());
            } else {
                nBTTagCompound2.setByteArray("SkyLight", new byte[object4.getBlocklightArray().getReadOnlyData().length]);
            }
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("Sections", nBTTagList);
        nBTTagCompound.setByteArray("Biomes", chunk.getBiomeArray());
        chunk.setHasEntities(false);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (int i = 0; i < chunk.getEntityLists().length; ++i) {
            for (Entity entity : chunk.getEntityLists()[i]) {
                if (!entity.writeToNBTOptional(nBTTagCompound2 = new NBTTagCompound())) continue;
                chunk.setHasEntities(true);
                nBTTagList2.appendTag(nBTTagCompound2);
            }
        }
        nBTTagCompound.setTag("Entities", nBTTagList2);
        NBTTagList nBTTagList3 = new NBTTagList();
        for (TileEntity tileEntity : chunk.getTileEntityMap().values()) {
            nBTTagCompound2 = new NBTTagCompound();
            tileEntity.writeToNBT(nBTTagCompound2);
            nBTTagList3.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("TileEntities", nBTTagList3);
        List<NextTickListEntry> list = world2.getPendingBlockUpdates(chunk, false);
        if (list != null) {
            long l = world2.getTotalWorldTime();
            object3 = new NBTTagList();
            object2 = list.iterator();
            while (object2.hasNext()) {
                object = (NextTickListEntry)object2.next();
                NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
                ResourceLocation resourceLocation = (ResourceLocation)Block.blockRegistry.getNameForObject(((NextTickListEntry)object).getBlock());
                nBTTagCompound3.setString("i", resourceLocation == null ? "" : resourceLocation.toString());
                nBTTagCompound3.setInteger("x", ((NextTickListEntry)object).position.getX());
                nBTTagCompound3.setInteger("y", ((NextTickListEntry)object).position.getY());
                nBTTagCompound3.setInteger("z", ((NextTickListEntry)object).position.getZ());
                nBTTagCompound3.setInteger("t", (int)(((NextTickListEntry)object).scheduledTime - l));
                nBTTagCompound3.setInteger("p", ((NextTickListEntry)object).priority);
                ((NBTTagList)object3).appendTag(nBTTagCompound3);
            }
            nBTTagCompound.setTag("TileTicks", (NBTBase)object3);
        }
    }

    private Chunk readChunkFromNBT(World world2, NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList;
        NBTTagList nBTTagList2;
        NBTTagList nBTTagList3;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n = nBTTagCompound.getInteger("xPos");
        int n2 = nBTTagCompound.getInteger("zPos");
        Chunk chunk = new Chunk(world2, n, n2);
        chunk.setHeightMap(nBTTagCompound.getIntArray("HeightMap"));
        chunk.setTerrainPopulated(nBTTagCompound.getBoolean("TerrainPopulated"));
        chunk.setLightPopulated(nBTTagCompound.getBoolean("LightPopulated"));
        chunk.setInhabitedTime(nBTTagCompound.getLong("InhabitedTime"));
        NBTTagList nBTTagList4 = nBTTagCompound.getTagList("Sections", 10);
        int n3 = 16;
        ExtendedBlockStorage[] extendedBlockStorageArray = new ExtendedBlockStorage[n3];
        boolean bl = !world2.provider.getHasNoSky();
        for (int i = 0; i < nBTTagList4.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagList4.getCompoundTagAt(i);
            byte by = nBTTagCompound2.getByte("Y");
            object4 = new ExtendedBlockStorage(by << 4, bl);
            object3 = nBTTagCompound2.getByteArray("Blocks");
            object2 = new NibbleArray(nBTTagCompound2.getByteArray("Data"));
            object = nBTTagCompound2.hasKey("Add", 7) ? new NibbleArray(nBTTagCompound2.getByteArray("Add")) : null;
            char[] cArray = new char[((byte[])object3).length];
            for (int j = 0; j < cArray.length; ++j) {
                int n4 = j & 0xF;
                int n5 = j >> 8 & 0xF;
                int n6 = j >> 4 & 0xF;
                int n7 = object != null ? ((NibbleArray)object).get(n4, n5, n6) : 0;
                cArray[j] = (char)(n7 << 12 | (object3[j] & 0xFF) << 4 | ((NibbleArray)object2).get(n4, n5, n6));
            }
            ((ExtendedBlockStorage)object4).setData(cArray);
            ((ExtendedBlockStorage)object4).setBlocklightArray(new NibbleArray(nBTTagCompound2.getByteArray("BlockLight")));
            if (bl) {
                ((ExtendedBlockStorage)object4).setSkylightArray(new NibbleArray(nBTTagCompound2.getByteArray("SkyLight")));
            }
            ((ExtendedBlockStorage)object4).removeInvalidBlocks();
            extendedBlockStorageArray[by] = object4;
        }
        chunk.setStorageArrays(extendedBlockStorageArray);
        if (nBTTagCompound.hasKey("Biomes", 7)) {
            chunk.setBiomeArray(nBTTagCompound.getByteArray("Biomes"));
        }
        if ((nBTTagList3 = nBTTagCompound.getTagList("Entities", 10)) != null) {
            for (int i = 0; i < nBTTagList3.tagCount(); ++i) {
                NBTTagCompound nBTTagCompound3 = nBTTagList3.getCompoundTagAt(i);
                object4 = EntityList.createEntityFromNBT(nBTTagCompound3, world2);
                chunk.setHasEntities(true);
                if (object4 == null) continue;
                chunk.addEntity((Entity)object4);
                object3 = object4;
                object2 = nBTTagCompound3;
                while (((NBTTagCompound)object2).hasKey("Riding", 10)) {
                    object = EntityList.createEntityFromNBT(((NBTTagCompound)object2).getCompoundTag("Riding"), world2);
                    if (object != null) {
                        chunk.addEntity((Entity)object);
                        ((Entity)object3).mountEntity((Entity)object);
                    }
                    object3 = object;
                    object2 = ((NBTTagCompound)object2).getCompoundTag("Riding");
                }
            }
        }
        if ((nBTTagList2 = nBTTagCompound.getTagList("TileEntities", 10)) != null) {
            for (int i = 0; i < nBTTagList2.tagCount(); ++i) {
                object4 = nBTTagList2.getCompoundTagAt(i);
                object3 = TileEntity.createAndLoadEntity((NBTTagCompound)object4);
                if (object3 == null) continue;
                chunk.addTileEntity((TileEntity)object3);
            }
        }
        if (nBTTagCompound.hasKey("TileTicks", 9) && (nBTTagList = nBTTagCompound.getTagList("TileTicks", 10)) != null) {
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                object3 = nBTTagList.getCompoundTagAt(i);
                object2 = ((NBTTagCompound)object3).hasKey("i", 8) ? Block.getBlockFromName(((NBTTagCompound)object3).getString("i")) : Block.getBlockById(((NBTTagCompound)object3).getInteger("i"));
                world2.scheduleBlockUpdate(new BlockPos(((NBTTagCompound)object3).getInteger("x"), ((NBTTagCompound)object3).getInteger("y"), ((NBTTagCompound)object3).getInteger("z")), (Block)object2, ((NBTTagCompound)object3).getInteger("t"), ((NBTTagCompound)object3).getInteger("p"));
            }
        }
        return chunk;
    }
}

