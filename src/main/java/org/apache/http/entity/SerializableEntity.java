/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.util.Args;

@NotThreadSafe
public class SerializableEntity
extends AbstractHttpEntity {
    private byte[] objSer;
    private Serializable objRef;

    public SerializableEntity(Serializable serializable, boolean bl) throws IOException {
        Args.notNull(serializable, "Source object");
        if (bl) {
            this.createBytes(serializable);
        } else {
            this.objRef = serializable;
        }
    }

    public SerializableEntity(Serializable serializable) {
        Args.notNull(serializable, "Source object");
        this.objRef = serializable;
    }

    private void createBytes(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        this.objSer = byteArrayOutputStream.toByteArray();
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        if (this.objSer == null) {
            this.createBytes(this.objRef);
        }
        return new ByteArrayInputStream(this.objSer);
    }

    public long getContentLength() {
        if (this.objSer == null) {
            return -1L;
        }
        return this.objSer.length;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return this.objSer == null;
    }

    public void writeTo(OutputStream outputStream2) throws IOException {
        Args.notNull(outputStream2, "Output stream");
        if (this.objSer == null) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream2);
            objectOutputStream.writeObject(this.objRef);
            objectOutputStream.flush();
        } else {
            outputStream2.write(this.objSer);
            outputStream2.flush();
        }
    }
}

