/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.AbstractFileComparator;
import org.apache.commons.io.comparator.ReverseComparator;

public class SizeFileComparator
extends AbstractFileComparator
implements Serializable {
    public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
    public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
    public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
    private final boolean sumDirectoryContents;

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    public SizeFileComparator(boolean bl) {
        this.sumDirectoryContents = bl;
    }

    @Override
    public int compare(File file, File file2) {
        long l = 0L;
        l = file.isDirectory() ? (this.sumDirectoryContents && file.exists() ? FileUtils.sizeOfDirectory(file) : 0L) : file.length();
        long l2 = 0L;
        l2 = file2.isDirectory() ? (this.sumDirectoryContents && file2.exists() ? FileUtils.sizeOfDirectory(file2) : 0L) : file2.length();
        long l3 = l - l2;
        if (l3 < 0L) {
            return -1;
        }
        if (l3 > 0L) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + this.sumDirectoryContents + "]";
    }
}

