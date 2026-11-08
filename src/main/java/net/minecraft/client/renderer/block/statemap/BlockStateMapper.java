/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.block.statemap;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.resources.model.ModelResourceLocation;

public class BlockStateMapper {
    private Map<Block, IStateMapper> blockStateMap = Maps.newIdentityHashMap();
    private Set<Block> setBuiltInBlocks = Sets.newIdentityHashSet();

    public void registerBlockStateMapper(Block block, IStateMapper iStateMapper) {
        this.blockStateMap.put(block, iStateMapper);
    }

    public void registerBuiltInBlocks(Block ... blockArray) {
        Collections.addAll(this.setBuiltInBlocks, blockArray);
    }

    public Map<IBlockState, ModelResourceLocation> putAllStateModelLocations() {
        IdentityHashMap<IBlockState, ModelResourceLocation> identityHashMap = Maps.newIdentityHashMap();
        for (Block block : Block.blockRegistry) {
            if (this.setBuiltInBlocks.contains(block)) continue;
            identityHashMap.putAll(((IStateMapper)Objects.firstNonNull(this.blockStateMap.get(block), new DefaultStateMapper())).putStateModelLocations(block));
        }
        return identityHashMap;
    }
}

