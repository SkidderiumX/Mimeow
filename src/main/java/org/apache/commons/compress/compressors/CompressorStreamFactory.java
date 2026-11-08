/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.compressors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.compress.compressors.xz.XZUtils;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class CompressorStreamFactory {
    public static final String BZIP2 = "bzip2";
    public static final String GZIP = "gz";
    public static final String PACK200 = "pack200";
    public static final String XZ = "xz";
    public static final String LZMA = "lzma";
    public static final String SNAPPY_FRAMED = "snappy-framed";
    public static final String SNAPPY_RAW = "snappy-raw";
    public static final String Z = "z";
    private boolean decompressConcatenated = false;

    public void setDecompressConcatenated(boolean bl) {
        this.decompressConcatenated = bl;
    }

    public CompressorInputStream createCompressorInputStream(InputStream inputStream2) throws CompressorException {
        if (inputStream2 == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!inputStream2.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] byArray = new byte[12];
        inputStream2.mark(byArray.length);
        try {
            int n = IOUtils.readFully(inputStream2, byArray);
            inputStream2.reset();
            if (BZip2CompressorInputStream.matches(byArray, n)) {
                return new BZip2CompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (GzipCompressorInputStream.matches(byArray, n)) {
                return new GzipCompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (XZUtils.isXZCompressionAvailable() && XZCompressorInputStream.matches(byArray, n)) {
                return new XZCompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (Pack200CompressorInputStream.matches(byArray, n)) {
                return new Pack200CompressorInputStream(inputStream2);
            }
            if (FramedSnappyCompressorInputStream.matches(byArray, n)) {
                return new FramedSnappyCompressorInputStream(inputStream2);
            }
            if (ZCompressorInputStream.matches(byArray, n)) {
                return new ZCompressorInputStream(inputStream2);
            }
        }
        catch (IOException iOException) {
            throw new CompressorException("Failed to detect Compressor from InputStream.", iOException);
        }
        throw new CompressorException("No Compressor found for the stream signature.");
    }

    public CompressorInputStream createCompressorInputStream(String string, InputStream inputStream2) throws CompressorException {
        if (string == null || inputStream2 == null) {
            throw new IllegalArgumentException("Compressor name and stream must not be null.");
        }
        try {
            if (GZIP.equalsIgnoreCase(string)) {
                return new GzipCompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (BZIP2.equalsIgnoreCase(string)) {
                return new BZip2CompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (XZ.equalsIgnoreCase(string)) {
                return new XZCompressorInputStream(inputStream2, this.decompressConcatenated);
            }
            if (LZMA.equalsIgnoreCase(string)) {
                return new LZMACompressorInputStream(inputStream2);
            }
            if (PACK200.equalsIgnoreCase(string)) {
                return new Pack200CompressorInputStream(inputStream2);
            }
            if (SNAPPY_RAW.equalsIgnoreCase(string)) {
                return new SnappyCompressorInputStream(inputStream2);
            }
            if (SNAPPY_FRAMED.equalsIgnoreCase(string)) {
                return new FramedSnappyCompressorInputStream(inputStream2);
            }
            if (Z.equalsIgnoreCase(string)) {
                return new ZCompressorInputStream(inputStream2);
            }
        }
        catch (IOException iOException) {
            throw new CompressorException("Could not create CompressorInputStream.", iOException);
        }
        throw new CompressorException("Compressor: " + string + " not found.");
    }

    public CompressorOutputStream createCompressorOutputStream(String string, OutputStream outputStream2) throws CompressorException {
        if (string == null || outputStream2 == null) {
            throw new IllegalArgumentException("Compressor name and stream must not be null.");
        }
        try {
            if (GZIP.equalsIgnoreCase(string)) {
                return new GzipCompressorOutputStream(outputStream2);
            }
            if (BZIP2.equalsIgnoreCase(string)) {
                return new BZip2CompressorOutputStream(outputStream2);
            }
            if (XZ.equalsIgnoreCase(string)) {
                return new XZCompressorOutputStream(outputStream2);
            }
            if (PACK200.equalsIgnoreCase(string)) {
                return new Pack200CompressorOutputStream(outputStream2);
            }
        }
        catch (IOException iOException) {
            throw new CompressorException("Could not create CompressorOutputStream", iOException);
        }
        throw new CompressorException("Compressor: " + string + " not found.");
    }
}

