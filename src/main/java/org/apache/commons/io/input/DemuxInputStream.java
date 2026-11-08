/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class DemuxInputStream
extends InputStream {
    private final InheritableThreadLocal<InputStream> m_streams = new InheritableThreadLocal();

    public InputStream bindStream(InputStream inputStream2) {
        InputStream inputStream3 = (InputStream)this.m_streams.get();
        this.m_streams.set(inputStream2);
        return inputStream3;
    }

    @Override
    public void close() throws IOException {
        InputStream inputStream2 = (InputStream)this.m_streams.get();
        if (null != inputStream2) {
            inputStream2.close();
        }
    }

    @Override
    public int read() throws IOException {
        InputStream inputStream2 = (InputStream)this.m_streams.get();
        if (null != inputStream2) {
            return inputStream2.read();
        }
        return -1;
    }
}

