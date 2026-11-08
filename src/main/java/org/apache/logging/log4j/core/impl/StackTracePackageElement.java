/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.io.Serializable;

public class StackTracePackageElement
implements Serializable {
    private static final long serialVersionUID = -2171069569241280505L;
    private final String location;
    private final String version;
    private final boolean isExact;

    public StackTracePackageElement(String string, String string2, boolean bl) {
        this.location = string;
        this.version = string2;
        this.isExact = bl;
    }

    public String getLocation() {
        return this.location;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isExact() {
        return this.isExact;
    }

    public String toString() {
        String string = this.isExact ? "" : "~";
        return string + "[" + this.location + ":" + this.version + "]";
    }
}

