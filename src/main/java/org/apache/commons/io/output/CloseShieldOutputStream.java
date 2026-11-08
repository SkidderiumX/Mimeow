/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.OutputStream;
import org.apache.commons.io.output.ClosedOutputStream;
import org.apache.commons.io.output.ProxyOutputStream;

public class CloseShieldOutputStream
extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream2) {
        super(outputStream2);
    }

    @Override
    public void close() {
        this.out = new ClosedOutputStream();
    }
}

