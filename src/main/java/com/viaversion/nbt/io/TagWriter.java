/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.io;

import com.viaversion.nbt.io.NBTIO;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.fastutil.io.FastBufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.zip.GZIPOutputStream;

public class TagWriter {
    private boolean named;

    public TagWriter named() {
        this.named = true;
        return this;
    }

    public void write(DataOutput dataOutput, Tag tag) throws IOException {
        NBTIO.writeTag(dataOutput, tag, this.named);
    }

    public void write(OutputStream outputStream2, Tag tag) throws IOException {
        NBTIO.writeTag(new DataOutputStream(outputStream2), tag, this.named);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(Path path, Tag tag, boolean bl) throws IOException {
        if (!Files.exists(path, new LinkOption[0])) {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent(), new FileAttribute[0]);
            }
            Files.createFile(path, new FileAttribute[0]);
        }
        try (OutputStream outputStream2 = new FastBufferedOutputStream(Files.newOutputStream(path, new OpenOption[0]));){
            if (bl) {
                outputStream2 = new GZIPOutputStream(outputStream2);
            }
            this.write(outputStream2, tag);
        }
    }
}

