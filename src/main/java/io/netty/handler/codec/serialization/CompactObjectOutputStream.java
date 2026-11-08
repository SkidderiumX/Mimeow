/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

public class CompactObjectOutputStream
extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    CompactObjectOutputStream(OutputStream outputStream2) throws IOException {
        super(outputStream2);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        this.writeByte(5);
    }

    @Override
    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> clazz = objectStreamClass.forClass();
        if (clazz.isPrimitive() || clazz.isArray() || clazz.isInterface() || objectStreamClass.getSerialVersionUID() == 0L) {
            this.write(0);
            super.writeClassDescriptor(objectStreamClass);
        } else {
            this.write(1);
            this.writeUTF(objectStreamClass.getName());
        }
    }
}

