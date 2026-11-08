/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class FlatLayerInfo {
    private final int field_175902_a;
    private IBlockState layerMaterial;
    private int layerCount = 1;
    private int layerMinimumY;

    public FlatLayerInfo(int n, Block block) {
        this(3, n, block);
    }

    public FlatLayerInfo(int n, int n2, Block block) {
        this.field_175902_a = n;
        this.layerCount = n2;
        this.layerMaterial = block.getDefaultState();
    }

    public FlatLayerInfo(int n, int n2, Block block, int n3) {
        this(n, n2, block);
        this.layerMaterial = block.getStateFromMeta(n3);
    }

    public int getLayerCount() {
        return this.layerCount;
    }

    public IBlockState getLayerMaterial() {
        return this.layerMaterial;
    }

    private Block getLayerMaterialBlock() {
        return this.layerMaterial.getBlock();
    }

    private int getFillBlockMeta() {
        return this.layerMaterial.getBlock().getMetaFromState(this.layerMaterial);
    }

    public int getMinY() {
        return this.layerMinimumY;
    }

    public void setMinY(int n) {
        this.layerMinimumY = n;
    }

    public String toString() {
        Object object;
        if (this.field_175902_a >= 3) {
            ResourceLocation resourceLocation = (ResourceLocation)Block.blockRegistry.getNameForObject(this.getLayerMaterialBlock());
            Object object2 = object = resourceLocation == null ? "null" : resourceLocation.toString();
            if (this.layerCount > 1) {
                object = this.layerCount + "*" + (String)object;
            }
        } else {
            object = Integer.toString(Block.getIdFromBlock(this.getLayerMaterialBlock()));
            if (this.layerCount > 1) {
                object = this.layerCount + "x" + (String)object;
            }
        }
        int n = this.getFillBlockMeta();
        if (n > 0) {
            object = (String)object + ":" + n;
        }
        return object;
    }
}

