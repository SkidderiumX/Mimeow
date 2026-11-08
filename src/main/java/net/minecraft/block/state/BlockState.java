/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.state;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Cartesian;
import net.minecraft.util.MapPopulator;

public class BlockState {
    private static final Joiner COMMA_JOINER = Joiner.on(", ");
    private static final Function<IProperty, String> GET_NAME_FUNC = new Function<IProperty, String>(){

        @Override
        public String apply(IProperty iProperty) {
            return iProperty == null ? "<NULL>" : iProperty.getName();
        }
    };
    private final Block block;
    private final ImmutableList<IProperty> properties;
    private final ImmutableList<IBlockState> validStates;

    public BlockState(Block block, IProperty ... iPropertyArray) {
        this.block = block;
        Arrays.sort(iPropertyArray, new Comparator<IProperty>(){

            @Override
            public int compare(IProperty iProperty, IProperty iProperty2) {
                return iProperty.getName().compareTo(iProperty2.getName());
            }
        });
        this.properties = ImmutableList.copyOf(iPropertyArray);
        LinkedHashMap<Map<IProperty, Comparable>, StateImplementation> linkedHashMap = Maps.newLinkedHashMap();
        ArrayList<StateImplementation> arrayList = Lists.newArrayList();
        for (List<Comparable> object : Cartesian.cartesianProduct(this.getAllowedValues())) {
            Map<IProperty, Comparable> map = MapPopulator.createMap(this.properties, object);
            StateImplementation stateImplementation = new StateImplementation(block, ImmutableMap.copyOf(map));
            linkedHashMap.put(map, stateImplementation);
            arrayList.add(stateImplementation);
        }
        for (StateImplementation stateImplementation : arrayList) {
            stateImplementation.buildPropertyValueTable(linkedHashMap);
        }
        this.validStates = ImmutableList.copyOf(arrayList);
    }

    public ImmutableList<IBlockState> getValidStates() {
        return this.validStates;
    }

    private List<Iterable<Comparable>> getAllowedValues() {
        ArrayList<Iterable<Comparable>> arrayList = Lists.newArrayList();
        for (int i = 0; i < this.properties.size(); ++i) {
            arrayList.add(((IProperty)this.properties.get(i)).getAllowedValues());
        }
        return arrayList;
    }

    public IBlockState getBaseState() {
        return (IBlockState)this.validStates.get(0);
    }

    public Block getBlock() {
        return this.block;
    }

    public Collection<IProperty> getProperties() {
        return this.properties;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("block", Block.blockRegistry.getNameForObject(this.block)).add("properties", Iterables.transform(this.properties, GET_NAME_FUNC)).toString();
    }

    public static class StateImplementation
    extends BlockStateBase {
        private final Block block;
        private final ImmutableMap<IProperty, Comparable> properties;
        private ImmutableTable<IProperty, Comparable, IBlockState> propertyValueTable;

        private StateImplementation(Block block, ImmutableMap<IProperty, Comparable> immutableMap) {
            this.block = block;
            this.properties = immutableMap;
        }

        @Override
        public Collection<IProperty> getPropertyNames() {
            return Collections.unmodifiableCollection(this.properties.keySet());
        }

        @Override
        public <T extends Comparable<T>> T getValue(IProperty<T> iProperty) {
            if (!this.properties.containsKey(iProperty)) {
                throw new IllegalArgumentException("Cannot get property " + String.valueOf(iProperty) + " as it does not exist in " + String.valueOf(this.block.getBlockState()));
            }
            return (T)((Comparable)iProperty.getValueClass().cast(this.properties.get(iProperty)));
        }

        @Override
        public <T extends Comparable<T>, V extends T> IBlockState withProperty(IProperty<T> iProperty, V v) {
            if (!this.properties.containsKey(iProperty)) {
                throw new IllegalArgumentException("Cannot set property " + String.valueOf(iProperty) + " as it does not exist in " + String.valueOf(this.block.getBlockState()));
            }
            if (!iProperty.getAllowedValues().contains(v)) {
                throw new IllegalArgumentException("Cannot set property " + String.valueOf(iProperty) + " to " + String.valueOf(v) + " on block " + String.valueOf(Block.blockRegistry.getNameForObject(this.block)) + ", it is not an allowed value");
            }
            return this.properties.get(iProperty) == v ? this : (IBlockState)this.propertyValueTable.get(iProperty, v);
        }

        @Override
        public ImmutableMap<IProperty, Comparable> getProperties() {
            return this.properties;
        }

        @Override
        public Block getBlock() {
            return this.block;
        }

        public boolean equals(Object object) {
            return this == object;
        }

        public int hashCode() {
            return this.properties.hashCode();
        }

        public void buildPropertyValueTable(Map<Map<IProperty, Comparable>, StateImplementation> map) {
            if (this.propertyValueTable != null) {
                throw new IllegalStateException();
            }
            HashBasedTable<IProperty, Comparable, IBlockState> hashBasedTable = HashBasedTable.create();
            for (IProperty iProperty : this.properties.keySet()) {
                for (Comparable comparable : iProperty.getAllowedValues()) {
                    if (comparable == this.properties.get(iProperty)) continue;
                    hashBasedTable.put(iProperty, comparable, map.get(this.getPropertiesWithValue(iProperty, comparable)));
                }
            }
            this.propertyValueTable = ImmutableTable.copyOf(hashBasedTable);
        }

        private Map<IProperty, Comparable> getPropertiesWithValue(IProperty iProperty, Comparable comparable) {
            HashMap<IProperty, Comparable> hashMap = Maps.newHashMap(this.properties);
            hashMap.put(iProperty, comparable);
            return hashMap;
        }
    }
}

