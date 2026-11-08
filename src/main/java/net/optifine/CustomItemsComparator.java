/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.Comparator;
import net.minecraft.src.Config;
import net.optifine.CustomItemProperties;

public class CustomItemsComparator
implements Comparator {
    public int compare(Object object, Object object2) {
        CustomItemProperties customItemProperties = (CustomItemProperties)object;
        CustomItemProperties customItemProperties2 = (CustomItemProperties)object2;
        return customItemProperties.weight != customItemProperties2.weight ? customItemProperties2.weight - customItemProperties.weight : (!Config.equals(customItemProperties.basePath, customItemProperties2.basePath) ? customItemProperties.basePath.compareTo(customItemProperties2.basePath) : customItemProperties.name.compareTo(customItemProperties2.name));
    }
}

