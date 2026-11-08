/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveHandler
implements ISaveHandler,
IPlayerFileData {
    private static final Logger logger = LogManager.getLogger();
    private final File worldDirectory;
    private final File playersDirectory;
    private final File mapDataDir;
    private final long initializationTime = MinecraftServer.getCurrentTimeMillis();
    private final String saveDirectoryName;

    public SaveHandler(File file, String string, boolean bl) {
        this.worldDirectory = new File(file, string);
        this.worldDirectory.mkdirs();
        this.playersDirectory = new File(this.worldDirectory, "playerdata");
        this.mapDataDir = new File(this.worldDirectory, "data");
        this.mapDataDir.mkdirs();
        this.saveDirectoryName = string;
        if (bl) {
            this.playersDirectory.mkdirs();
        }
        this.setSessionLock();
    }

    private void setSessionLock() {
        try {
            File file = new File(this.worldDirectory, "session.lock");
            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
                dataOutputStream.writeLong(this.initializationTime);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    @Override
    public File getWorldDirectory() {
        return this.worldDirectory;
    }

    @Override
    public void checkSessionLock() throws MinecraftException {
        try {
            File file = new File(this.worldDirectory, "session.lock");
            try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));){
                if (dataInputStream.readLong() != this.initializationTime) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
        }
        catch (IOException iOException) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    @Override
    public IChunkLoader getChunkLoader(WorldProvider worldProvider) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    @Override
    public WorldInfo loadWorldInfo() {
        File file = new File(this.worldDirectory, "level.dat");
        if (file.exists()) {
            try {
                NBTTagCompound nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("Data");
                return new WorldInfo(nBTTagCompound2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if ((file = new File(this.worldDirectory, "level.dat_old")).exists()) {
            try {
                NBTTagCompound nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
                NBTTagCompound nBTTagCompound3 = nBTTagCompound.getCompoundTag("Data");
                return new WorldInfo(nBTTagCompound3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void saveWorldInfoWithPlayer(WorldInfo worldInfo, NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = worldInfo.cloneNBTCompound(nBTTagCompound);
        NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
        nBTTagCompound3.setTag("Data", nBTTagCompound2);
        try {
            File file = new File(this.worldDirectory, "level.dat_new");
            File file2 = new File(this.worldDirectory, "level.dat_old");
            File file3 = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(nBTTagCompound3, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void saveWorldInfo(WorldInfo worldInfo) {
        NBTTagCompound nBTTagCompound = worldInfo.getNBTTagCompound();
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2.setTag("Data", nBTTagCompound);
        try {
            File file = new File(this.worldDirectory, "level.dat_new");
            File file2 = new File(this.worldDirectory, "level.dat_old");
            File file3 = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(nBTTagCompound2, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void writePlayerData(EntityPlayer entityPlayer) {
        try {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            entityPlayer.writeToNBT(nBTTagCompound);
            File file = new File(this.playersDirectory, entityPlayer.getUniqueID().toString() + ".dat.tmp");
            File file2 = new File(this.playersDirectory, entityPlayer.getUniqueID().toString() + ".dat");
            CompressedStreamTools.writeCompressed(nBTTagCompound, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        }
        catch (Exception exception) {
            logger.warn("Failed to save player data for " + entityPlayer.getName());
        }
    }

    @Override
    public NBTTagCompound readPlayerData(EntityPlayer entityPlayer) {
        NBTTagCompound nBTTagCompound = null;
        try {
            File file = new File(this.playersDirectory, entityPlayer.getUniqueID().toString() + ".dat");
            if (file.exists() && file.isFile()) {
                nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
            }
        }
        catch (Exception exception) {
            logger.warn("Failed to load player data for " + entityPlayer.getName());
        }
        if (nBTTagCompound != null) {
            entityPlayer.readFromNBT(nBTTagCompound);
        }
        return nBTTagCompound;
    }

    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return this;
    }

    @Override
    public String[] getAvailablePlayerDat() {
        String[] stringArray = this.playersDirectory.list();
        if (stringArray == null) {
            stringArray = new String[]{};
        }
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].endsWith(".dat")) continue;
            stringArray[i] = stringArray[i].substring(0, stringArray[i].length() - 4);
        }
        return stringArray;
    }

    @Override
    public void flush() {
    }

    @Override
    public File getMapFileFromName(String string) {
        return new File(this.mapDataDir, string + ".dat");
    }

    @Override
    public String getWorldDirectoryName() {
        return this.saveDirectoryName;
    }
}

