/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.io.Serializable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.status.StatusLogger;

public abstract class AbstractLayout<T extends Serializable>
implements Layout<T> {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    protected byte[] header;
    protected byte[] footer;

    @Override
    public byte[] getHeader() {
        return this.header;
    }

    public void setHeader(byte[] byArray) {
        this.header = byArray;
    }

    @Override
    public byte[] getFooter() {
        return this.footer;
    }

    public void setFooter(byte[] byArray) {
        this.footer = byArray;
    }
}

