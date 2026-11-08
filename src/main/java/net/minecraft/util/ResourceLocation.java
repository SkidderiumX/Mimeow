/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import x.oc6d684442a4;

public class ResourceLocation {
    protected final String resourceDomain;
    protected final String resourcePath;

    protected ResourceLocation(int n, String ... stringArray) {
        String string = StringUtils.isEmpty(stringArray[0]) ? "minecraft" : stringArray[0].toLowerCase();
        this.resourceDomain = oc6d684442a4.\u0522(string);
        this.resourcePath = oc6d684442a4.\u04b8(stringArray[1]);
        Validate.notNull(this.resourcePath);
    }

    public ResourceLocation(String string) {
        this(0, ResourceLocation.splitObjectName(string));
    }

    public ResourceLocation(String string, String string2) {
        this(0, string, string2);
    }

    protected static String[] splitObjectName(String string) {
        String[] stringArray = new String[]{null, string};
        int n = string.indexOf(58);
        if (n >= 0) {
            stringArray[1] = string.substring(n + 1, string.length());
            if (n > 1) {
                stringArray[0] = string.substring(0, n);
            }
        }
        return stringArray;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getResourceDomain() {
        return this.resourceDomain;
    }

    public String toString() {
        return this.resourceDomain + ":" + this.resourcePath;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ResourceLocation)) {
            return false;
        }
        ResourceLocation resourceLocation = (ResourceLocation)object;
        return this.resourceDomain.equals(resourceLocation.resourceDomain) && this.resourcePath.equals(resourceLocation.resourcePath);
    }

    public int hashCode() {
        return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
    }
}

