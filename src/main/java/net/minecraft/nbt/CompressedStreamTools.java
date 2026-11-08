/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.util.ReportedException;

public class CompressedStreamTools {
    public static NBTTagCompound readCompressed(InputStream inputStream2) throws IOException {
        NBTTagCompound nBTTagCompound;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream2)));){
            nBTTagCompound = CompressedStreamTools.read(dataInputStream, NBTSizeTracker.INFINITE);
        }
        return nBTTagCompound;
    }

    public static void writeCompressed(NBTTagCompound nBTTagCompound, OutputStream outputStream2) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(outputStream2)));){
            CompressedStreamTools.write(nBTTagCompound, dataOutputStream);
        }
    }

    public static void safeWrite(NBTTagCompound nBTTagCompound, File file) throws IOException {
        File file2 = new File(file.getAbsolutePath() + "_tmp");
        if (file2.exists()) {
            file2.delete();
        }
        CompressedStreamTools.write(nBTTagCompound, file2);
        if (file.exists()) {
            file.delete();
        }
        if (file.exists()) {
            throw new IOException("Failed to delete " + String.valueOf(file));
        }
        file2.renameTo(file);
    }

    public static void write(NBTTagCompound nBTTagCompound, File file) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
            CompressedStreamTools.write(nBTTagCompound, dataOutputStream);
        }
    }

    public static NBTTagCompound read(File file) throws IOException {
        NBTTagCompound nBTTagCompound;
        if (!file.exists()) {
            return null;
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));){
            nBTTagCompound = CompressedStreamTools.read(dataInputStream, NBTSizeTracker.INFINITE);
        }
        return nBTTagCompound;
    }

    public static NBTTagCompound read(DataInputStream dataInputStream) throws IOException {
        return CompressedStreamTools.read(dataInputStream, NBTSizeTracker.INFINITE);
    }

    public static NBTTagCompound read(DataInput dataInput, NBTSizeTracker nBTSizeTracker) throws IOException {
        NBTBase nBTBase = CompressedStreamTools.func_152455_a(dataInput, 0, nBTSizeTracker);
        if (nBTBase instanceof NBTTagCompound) {
            return (NBTTagCompound)nBTBase;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void write(NBTTagCompound nBTTagCompound, DataOutput dataOutput) throws IOException {
        CompressedStreamTools.writeTag(nBTTagCompound, dataOutput);
    }

    private static void writeTag(NBTBase nBTBase, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(nBTBase.getId());
        if (nBTBase.getId() != 0) {
            dataOutput.writeUTF("");
            nBTBase.write(dataOutput);
        }
    }

    private static NBTBase func_152455_a(DataInput dataInput, int n, NBTSizeTracker nBTSizeTracker) throws IOException {
        byte by = dataInput.readByte();
        if (by == 0) {
            return new NBTTagEnd();
        }
        dataInput.readUTF();
        NBTBase nBTBase = NBTBase.createNewByType(by);
        try {
            nBTBase.read(dataInput, n, nBTSizeTracker);
            return nBTBase;
        }
        catch (IOException iOException) {
            CrashReport crashReport = CrashReport.makeCrashReport(iOException, "Loading NBT data");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("NBT Tag");
            crashReportCategory.addCrashSection("Tag name", "[UNNAMED TAG]");
            crashReportCategory.addCrashSection("Tag type", by);
            throw new ReportedException(crashReport);
        }
    }
}

