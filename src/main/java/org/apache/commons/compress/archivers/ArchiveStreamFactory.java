package org.apache.commons.compress.archivers;

import org.apache.commons.compress.archivers.arj.*;
import org.apache.commons.compress.archivers.dump.*;
import org.apache.commons.compress.archivers.ar.*;
import org.apache.commons.compress.archivers.zip.*;
import org.apache.commons.compress.archivers.tar.*;
import org.apache.commons.compress.archivers.jar.*;
import org.apache.commons.compress.archivers.cpio.*;
import org.apache.commons.compress.utils.*;
import org.apache.commons.compress.archivers.sevenz.*;
import java.io.*;

public class ArchiveStreamFactory
{
    public static final String AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final String DUMP = "dump";
    public static final String JAR = "jar";
    public static final String TAR = "tar";
    public static final String ZIP = "zip";
    public static final String SEVEN_Z = "7z";
    private String entryEncoding;
    
    public ArchiveStreamFactory() {
        this.entryEncoding = null;
    }
    
    public String getEntryEncoding() {
        return this.entryEncoding;
    }
    
    public void setEntryEncoding(final String entryEncoding) {
        this.entryEncoding = entryEncoding;
    }
    
    public ArchiveInputStream createArchiveInputStream(final String str, final InputStream inputStream) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if ("ar".equalsIgnoreCase(str)) {
            return new ArArchiveInputStream(inputStream);
        }
        if ("arj".equalsIgnoreCase(str)) {
            if (this.entryEncoding != null) {
                return new ArjArchiveInputStream(inputStream, this.entryEncoding);
            }
            return new ArjArchiveInputStream(inputStream);
        }
        else if ("zip".equalsIgnoreCase(str)) {
            if (this.entryEncoding != null) {
                return new ZipArchiveInputStream(inputStream, this.entryEncoding);
            }
            return new ZipArchiveInputStream(inputStream);
        }
        else if ("tar".equalsIgnoreCase(str)) {
            if (this.entryEncoding != null) {
                return new TarArchiveInputStream(inputStream, this.entryEncoding);
            }
            return new TarArchiveInputStream(inputStream);
        }
        else {
            if ("jar".equalsIgnoreCase(str)) {
                return new JarArchiveInputStream(inputStream);
            }
            if ("cpio".equalsIgnoreCase(str)) {
                if (this.entryEncoding != null) {
                    return new CpioArchiveInputStream(inputStream, this.entryEncoding);
                }
                return new CpioArchiveInputStream(inputStream);
            }
            else if ("dump".equalsIgnoreCase(str)) {
                if (this.entryEncoding != null) {
                    return new DumpArchiveInputStream(inputStream, this.entryEncoding);
                }
                return new DumpArchiveInputStream(inputStream);
            }
            else {
                if ("7z".equalsIgnoreCase(str)) {
                    throw new StreamingNotSupportedException("7z");
                }
                throw new ArchiveException("Archiver: " + str + " not found.");
            }
        }
    }
    
    public ArchiveOutputStream createArchiveOutputStream(final String str, final OutputStream outputStream) throws ArchiveException {
        if (str == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        }
        if ("ar".equalsIgnoreCase(str)) {
            return new ArArchiveOutputStream(outputStream);
        }
        if ("zip".equalsIgnoreCase(str)) {
            final ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputStream);
            if (this.entryEncoding != null) {
                zipArchiveOutputStream.setEncoding(this.entryEncoding);
            }
            return zipArchiveOutputStream;
        }
        if ("tar".equalsIgnoreCase(str)) {
            if (this.entryEncoding != null) {
                return new TarArchiveOutputStream(outputStream, this.entryEncoding);
            }
            return new TarArchiveOutputStream(outputStream);
        }
        else {
            if ("jar".equalsIgnoreCase(str)) {
                return new JarArchiveOutputStream(outputStream);
            }
            if ("cpio".equalsIgnoreCase(str)) {
                if (this.entryEncoding != null) {
                    return new CpioArchiveOutputStream(outputStream, this.entryEncoding);
                }
                return new CpioArchiveOutputStream(outputStream);
            }
            else {
                if ("7z".equalsIgnoreCase(str)) {
                    throw new StreamingNotSupportedException("7z");
                }
                throw new ArchiveException("Archiver: " + str + " not found.");
            }
        }
    }
    
    public ArchiveInputStream createArchiveInputStream(final InputStream inputStream) throws ArchiveException {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        final byte[] array = new byte[12];
        inputStream.mark(array.length);
        try {
            final int fully = IOUtils.readFully(inputStream, array);
            inputStream.reset();
            if (ZipArchiveInputStream.matches(array, fully)) {
                if (this.entryEncoding != null) {
                    return new ZipArchiveInputStream(inputStream, this.entryEncoding);
                }
                return new ZipArchiveInputStream(inputStream);
            }
            else {
                if (JarArchiveInputStream.matches(array, fully)) {
                    return new JarArchiveInputStream(inputStream);
                }
                if (ArArchiveInputStream.matches(array, fully)) {
                    return new ArArchiveInputStream(inputStream);
                }
                if (CpioArchiveInputStream.matches(array, fully)) {
                    return new CpioArchiveInputStream(inputStream);
                }
                if (ArjArchiveInputStream.matches(array, fully)) {
                    return new ArjArchiveInputStream(inputStream);
                }
                if (SevenZFile.matches(array, fully)) {
                    throw new StreamingNotSupportedException("7z");
                }
                final byte[] array2 = new byte[32];
                inputStream.mark(array2.length);
                final int fully2 = IOUtils.readFully(inputStream, array2);
                inputStream.reset();
                if (DumpArchiveInputStream.matches(array2, fully2)) {
                    return new DumpArchiveInputStream(inputStream);
                }
                final byte[] buf = new byte[512];
                inputStream.mark(buf.length);
                final int fully3 = IOUtils.readFully(inputStream, buf);
                inputStream.reset();
                if (TarArchiveInputStream.matches(buf, fully3)) {
                    if (this.entryEncoding != null) {
                        return new TarArchiveInputStream(inputStream, this.entryEncoding);
                    }
                    return new TarArchiveInputStream(inputStream);
                }
                else if (fully3 >= 512) {
                    TarArchiveInputStream tarArchiveInputStream = null;
                    try {
                        tarArchiveInputStream = new TarArchiveInputStream(new ByteArrayInputStream(buf));
                        if (tarArchiveInputStream.getNextTarEntry().isCheckSumOK()) {
                            return new TarArchiveInputStream(inputStream);
                        }
                    }
                    catch (final Exception ex) {}
                    finally {
                        IOUtils.closeQuietly(tarArchiveInputStream);
                    }
                }
            }
        }
        catch (final IOException ex2) {
            throw new ArchiveException("Could not use reset and mark operations.", ex2);
        }
        throw new ArchiveException("No Archiver found for the stream signature");
    }
}
