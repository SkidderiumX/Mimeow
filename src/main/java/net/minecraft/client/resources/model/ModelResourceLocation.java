/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.model;

import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

public class ModelResourceLocation
extends ResourceLocation {
    private final String variant;

    protected ModelResourceLocation(int n, String ... stringArray) {
        super(0, stringArray[0], stringArray[1]);
        this.variant = StringUtils.isEmpty(stringArray[2]) ? "normal" : stringArray[2].toLowerCase();
    }

    public ModelResourceLocation(String string) {
        this(0, ModelResourceLocation.parsePathString(string));
    }

    public ModelResourceLocation(ResourceLocation resourceLocation, String string) {
        this(resourceLocation.toString(), string);
    }

    public ModelResourceLocation(String string, String string2) {
        this(0, ModelResourceLocation.parsePathString(string + "#" + (string2 == null ? "normal" : string2)));
    }

    protected static String[] parsePathString(String string) {
        String[] stringArray = new String[]{null, string, null};
        int n = string.indexOf(35);
        String string2 = string;
        if (n >= 0) {
            stringArray[2] = string.substring(n + 1, string.length());
            if (n > 1) {
                string2 = string.substring(0, n);
            }
        }
        System.arraycopy(ResourceLocation.splitObjectName(string2), 0, stringArray, 0, 2);
        return stringArray;
    }

    public String getVariant() {
        return this.variant;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ModelResourceLocation && super.equals(object)) {
            ModelResourceLocation modelResourceLocation = (ModelResourceLocation)object;
            return this.variant.equals(modelResourceLocation.variant);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.variant.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "#" + this.variant;
    }
}

