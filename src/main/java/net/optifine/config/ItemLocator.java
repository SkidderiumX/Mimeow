/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.IObjectLocator;

public class ItemLocator
implements IObjectLocator {
    @Override
    public Object getObject(ResourceLocation resourceLocation) {
        Item item = Item.getByNameOrId(resourceLocation.toString());
        return item;
    }
}

