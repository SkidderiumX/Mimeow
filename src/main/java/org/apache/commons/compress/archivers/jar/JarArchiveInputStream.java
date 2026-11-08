/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers.jar;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

public class JarArchiveInputStream
extends ZipArchiveInputStream {
    public JarArchiveInputStream(InputStream inputStream2) {
        super(inputStream2);
    }

    public JarArchiveEntry getNextJarEntry() throws IOException {
        ZipArchiveEntry zipArchiveEntry = this.getNextZipEntry();
        return zipArchiveEntry == null ? null : new JarArchiveEntry(zipArchiveEntry);
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return this.getNextJarEntry();
    }

    public static boolean matches(byte[] byArray, int n) {
        return ZipArchiveInputStream.matches(byArray, n);
    }
}

