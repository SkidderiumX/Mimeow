/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveFormatOld
implements ISaveFormat {
    private static final Logger logger = LogManager.getLogger();
    protected final File savesDirectory;

    public SaveFormatOld(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this.savesDirectory = file;
    }

    @Override
    public String getName() {
        return "Old Format";
    }

    @Override
    public List<SaveFormatComparator> getSaveList() throws AnvilConverterException {
        ArrayList<SaveFormatComparator> arrayList = Lists.newArrayList();
        for (int i = 0; i < 5; ++i) {
            String string = "World" + (i + 1);
            WorldInfo worldInfo = this.getWorldInfo(string);
            if (worldInfo == null) continue;
            arrayList.add(new SaveFormatComparator(string, "", worldInfo.getLastTimePlayed(), worldInfo.getSizeOnDisk(), worldInfo.getGameType(), false, worldInfo.isHardcoreModeEnabled(), worldInfo.areCommandsAllowed()));
        }
        return arrayList;
    }

    @Override
    public void flushCache() {
    }

    @Override
    public WorldInfo getWorldInfo(String string) {
        File file = new File(this.savesDirectory, string);
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                NBTTagCompound nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("Data");
                return new WorldInfo(nBTTagCompound2);
            }
            catch (Exception exception) {
                logger.error("Exception reading " + String.valueOf(file2), (Throwable)exception);
            }
        }
        if ((file2 = new File(file, "level.dat_old")).exists()) {
            try {
                NBTTagCompound nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file2));
                NBTTagCompound nBTTagCompound3 = nBTTagCompound.getCompoundTag("Data");
                return new WorldInfo(nBTTagCompound3);
            }
            catch (Exception exception) {
                logger.error("Exception reading " + String.valueOf(file2), (Throwable)exception);
            }
        }
        return null;
    }

    @Override
    public void renameWorld(String string, String string2) {
        File file;
        File file2 = new File(this.savesDirectory, string);
        if (file2.exists() && (file = new File(file2, "level.dat")).exists()) {
            try {
                NBTTagCompound nBTTagCompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound.getCompoundTag("Data");
                nBTTagCompound2.setString("LevelName", string2);
                CompressedStreamTools.writeCompressed(nBTTagCompound, new FileOutputStream(file));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public boolean isNewLevelIdAcceptable(String string) {
        File file = new File(this.savesDirectory, string);
        if (file.exists()) {
            return false;
        }
        try {
            file.mkdir();
            file.delete();
            return true;
        }
        catch (Throwable throwable) {
            logger.warn("Couldn't make new level", throwable);
            return false;
        }
    }

    @Override
    public boolean deleteWorldDirectory(String string) {
        File file = new File(this.savesDirectory, string);
        if (!file.exists()) {
            return true;
        }
        logger.info("Deleting level " + string);
        for (int i = 1; i <= 5; ++i) {
            logger.info("Attempt " + i + "...");
            if (SaveFormatOld.deleteFiles(file.listFiles())) break;
            logger.warn("Unsuccessful in deleting contents.");
            if (i >= 5) continue;
            try {
                Thread.sleep(500L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        return file.delete();
    }

    protected static boolean deleteFiles(File[] fileArray) {
        for (int i = 0; i < fileArray.length; ++i) {
            File file = fileArray[i];
            logger.debug("Deleting " + String.valueOf(file));
            if (file.isDirectory() && !SaveFormatOld.deleteFiles(file.listFiles())) {
                logger.warn("Couldn't delete directory " + String.valueOf(file));
                return false;
            }
            if (file.delete()) continue;
            logger.warn("Couldn't delete file " + String.valueOf(file));
            return false;
        }
        return true;
    }

    @Override
    public ISaveHandler getSaveLoader(String string, boolean bl) {
        return new SaveHandler(this.savesDirectory, string, bl);
    }

    @Override
    public boolean isConvertible(String string) {
        return false;
    }

    @Override
    public boolean isOldMapFormat(String string) {
        return false;
    }

    @Override
    public boolean convertMapFormat(String string, IProgressUpdate iProgressUpdate) {
        return false;
    }

    @Override
    public boolean canLoadWorld(String string) {
        File file = new File(this.savesDirectory, string);
        return file.isDirectory();
    }
}

