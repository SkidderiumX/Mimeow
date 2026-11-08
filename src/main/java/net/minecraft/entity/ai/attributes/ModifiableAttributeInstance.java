/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

public class ModifiableAttributeInstance
implements IAttributeInstance {
    private final BaseAttributeMap attributeMap;
    private final IAttribute genericAttribute;
    private final Map<Integer, Set<AttributeModifier>> mapByOperation = Maps.newHashMap();
    private final Map<String, Set<AttributeModifier>> mapByName = Maps.newHashMap();
    private final Map<UUID, AttributeModifier> mapByUUID = Maps.newHashMap();
    private double baseValue;
    private boolean needsUpdate = true;
    private double cachedValue;

    public ModifiableAttributeInstance(BaseAttributeMap baseAttributeMap, IAttribute iAttribute) {
        this.attributeMap = baseAttributeMap;
        this.genericAttribute = iAttribute;
        this.baseValue = iAttribute.getDefaultValue();
        for (int i = 0; i < 3; ++i) {
            this.mapByOperation.put(i, Sets.newHashSet());
        }
    }

    @Override
    public IAttribute getAttribute() {
        return this.genericAttribute;
    }

    @Override
    public double getBaseValue() {
        return this.baseValue;
    }

    @Override
    public void setBaseValue(double d) {
        if (d != this.getBaseValue()) {
            this.baseValue = d;
            this.flagForUpdate();
        }
    }

    @Override
    public Collection<AttributeModifier> getModifiersByOperation(int n) {
        return this.mapByOperation.get(n);
    }

    @Override
    public Collection<AttributeModifier> func_111122_c() {
        HashSet<AttributeModifier> hashSet = Sets.newHashSet();
        for (int i = 0; i < 3; ++i) {
            hashSet.addAll(this.getModifiersByOperation(i));
        }
        return hashSet;
    }

    @Override
    public AttributeModifier getModifier(UUID uUID) {
        return this.mapByUUID.get(uUID);
    }

    @Override
    public boolean hasModifier(AttributeModifier attributeModifier) {
        return this.mapByUUID.get(attributeModifier.getID()) != null;
    }

    @Override
    public void applyModifier(AttributeModifier attributeModifier) {
        if (this.getModifier(attributeModifier.getID()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        Set<AttributeModifier> set = this.mapByName.get(attributeModifier.getName());
        if (set == null) {
            set = Sets.newHashSet();
            this.mapByName.put(attributeModifier.getName(), set);
        }
        this.mapByOperation.get(attributeModifier.getOperation()).add(attributeModifier);
        set.add(attributeModifier);
        this.mapByUUID.put(attributeModifier.getID(), attributeModifier);
        this.flagForUpdate();
    }

    protected void flagForUpdate() {
        this.needsUpdate = true;
        this.attributeMap.func_180794_a(this);
    }

    @Override
    public void removeModifier(AttributeModifier attributeModifier) {
        for (int i = 0; i < 3; ++i) {
            Set<AttributeModifier> set = this.mapByOperation.get(i);
            set.remove(attributeModifier);
        }
        Set<AttributeModifier> set = this.mapByName.get(attributeModifier.getName());
        if (set != null) {
            set.remove(attributeModifier);
            if (set.isEmpty()) {
                this.mapByName.remove(attributeModifier.getName());
            }
        }
        this.mapByUUID.remove(attributeModifier.getID());
        this.flagForUpdate();
    }

    @Override
    public void removeAllModifiers() {
        Collection<AttributeModifier> collection = this.func_111122_c();
        if (collection != null) {
            for (AttributeModifier attributeModifier : Lists.newArrayList(collection)) {
                this.removeModifier(attributeModifier);
            }
        }
    }

    @Override
    public double getAttributeValue() {
        if (this.needsUpdate) {
            this.cachedValue = this.computeValue();
            this.needsUpdate = false;
        }
        return this.cachedValue;
    }

    private double computeValue() {
        double d = this.getBaseValue();
        for (AttributeModifier attributeModifier : this.func_180375_b(0)) {
            d += attributeModifier.getAmount();
        }
        double d2 = d;
        for (AttributeModifier attributeModifier : this.func_180375_b(1)) {
            d2 += d * attributeModifier.getAmount();
        }
        for (AttributeModifier attributeModifier : this.func_180375_b(2)) {
            d2 *= 1.0 + attributeModifier.getAmount();
        }
        return this.genericAttribute.clampValue(d2);
    }

    private Collection<AttributeModifier> func_180375_b(int n) {
        HashSet<AttributeModifier> hashSet = Sets.newHashSet(this.getModifiersByOperation(n));
        for (IAttribute iAttribute = this.genericAttribute.func_180372_d(); iAttribute != null; iAttribute = iAttribute.func_180372_d()) {
            IAttributeInstance iAttributeInstance = this.attributeMap.getAttributeInstance(iAttribute);
            if (iAttributeInstance == null) continue;
            hashSet.addAll(iAttributeInstance.getModifiersByOperation(n));
        }
        return hashSet;
    }
}

