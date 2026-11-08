/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

@NotThreadSafe
public class FileEntity
extends AbstractHttpEntity
implements Cloneable {
    protected final File file;

    @Deprecated
    public FileEntity(File file, String string) {
        this.file = Args.notNull(file, "File");
        this.setContentType(string);
    }

    public FileEntity(File file, ContentType contentType) {
        this.file = Args.notNull(file, "File");
        if (contentType != null) {
            this.setContentType(contentType.toString());
        }
    }

    public FileEntity(File file) {
        this.file = Args.notNull(file, "File");
    }

    public boolean isRepeatable() {
        return true;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream2) throws IOException {
        Args.notNull(outputStream2, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            int n;
            byte[] byArray = new byte[4096];
            while ((n = ((InputStream)fileInputStream).read(byArray)) != -1) {
                outputStream2.write(byArray, 0, n);
            }
            outputStream2.flush();
        }
        finally {
            ((InputStream)fileInputStream).close();
        }
    }

    public boolean isStreaming() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

