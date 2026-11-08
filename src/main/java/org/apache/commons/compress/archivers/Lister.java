/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

public class Lister {
    private static final ArchiveStreamFactory factory = new ArchiveStreamFactory();

    public static void main(String[] stringArray) throws Exception {
        ArchiveEntry archiveEntry;
        if (stringArray.length == 0) {
            Lister.usage();
            return;
        }
        System.out.println("Analysing " + stringArray[0]);
        File file = new File(stringArray[0]);
        if (!file.isFile()) {
            System.err.println(file + " doesn't exist or is a directory");
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        ArchiveInputStream archiveInputStream = stringArray.length > 1 ? factory.createArchiveInputStream(stringArray[1], bufferedInputStream) : factory.createArchiveInputStream(bufferedInputStream);
        System.out.println("Created " + archiveInputStream.toString());
        while ((archiveEntry = archiveInputStream.getNextEntry()) != null) {
            System.out.println(archiveEntry.getName());
        }
        archiveInputStream.close();
        ((InputStream)bufferedInputStream).close();
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]");
    }
}

