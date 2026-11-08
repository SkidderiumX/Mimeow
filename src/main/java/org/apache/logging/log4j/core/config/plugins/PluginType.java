/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config.plugins;

import java.io.Serializable;

public class PluginType<T>
implements Serializable {
    private static final long serialVersionUID = 4743255148794846612L;
    private final Class<T> pluginClass;
    private final String elementName;
    private final boolean printObject;
    private final boolean deferChildren;

    public PluginType(Class<T> clazz, String string, boolean bl, boolean bl2) {
        this.pluginClass = clazz;
        this.elementName = string;
        this.printObject = bl;
        this.deferChildren = bl2;
    }

    public Class<T> getPluginClass() {
        return this.pluginClass;
    }

    public String getElementName() {
        return this.elementName;
    }

    public boolean isObjectPrintable() {
        return this.printObject;
    }

    public boolean isDeferChildren() {
        return this.deferChildren;
    }
}

