/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers.dump;

public class Dirent {
    private final int ino;
    private final int parentIno;
    private final int type;
    private final String name;

    Dirent(int n, int n2, int n3, String string) {
        this.ino = n;
        this.parentIno = n2;
        this.type = n3;
        this.name = string;
    }

    int getIno() {
        return this.ino;
    }

    int getParentIno() {
        return this.parentIno;
    }

    int getType() {
        return this.type;
    }

    String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("[%d]: %s", this.ino, this.name);
    }
}

