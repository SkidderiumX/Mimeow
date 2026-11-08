/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class DemuxOutputStream
extends OutputStream {
    private final InheritableThreadLocal<OutputStream> m_streams = new InheritableThreadLocal();

    public OutputStream bindStream(OutputStream outputStream2) {
        OutputStream outputStream3 = (OutputStream)this.m_streams.get();
        this.m_streams.set(outputStream2);
        return outputStream3;
    }

    @Override
    public void close() throws IOException {
        OutputStream outputStream2 = (OutputStream)this.m_streams.get();
        if (null != outputStream2) {
            outputStream2.close();
        }
    }

    @Override
    public void flush() throws IOException {
        OutputStream outputStream2 = (OutputStream)this.m_streams.get();
        if (null != outputStream2) {
            outputStream2.flush();
        }
    }

    @Override
    public void write(int n) throws IOException {
        OutputStream outputStream2 = (OutputStream)this.m_streams.get();
        if (null != outputStream2) {
            outputStream2.write(n);
        }
    }
}

