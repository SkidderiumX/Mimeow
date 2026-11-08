/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Map;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.server.management.LowerStringMap;

public abstract class BaseAttributeMap {
    protected final Map<IAttribute, IAttributeInstance> attributes = Maps.newHashMap();
    protected final Map<String, IAttributeInstance> attributesByName = new LowerStringMap<IAttributeInstance>();
    protected final Multimap<IAttribute, IAttribute> field_180377_c = HashMultimap.create();

    public IAttributeInstance getAttributeInstance(IAttribute iAttribute) {
        return this.attributes.get(iAttribute);
    }

    public IAttributeInstance getAttributeInstanceByName(String string) {
        return this.attributesByName.get(string);
    }

    public IAttributeInstance registerAttribute(IAttribute iAttribute) {
        if (this.attributesByName.containsKey(iAttribute.getAttributeUnlocalizedName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        IAttributeInstance iAttributeInstance = this.func_180376_c(iAttribute);
        this.attributesByName.put(iAttribute.getAttributeUnlocalizedName(), iAttributeInstance);
        this.attributes.put(iAttribute, iAttributeInstance);
        for (IAttribute iAttribute2 = iAttribute.func_180372_d(); iAttribute2 != null; iAttribute2 = iAttribute2.func_180372_d()) {
            this.field_180377_c.put(iAttribute2, iAttribute);
        }
        return iAttributeInstance;
    }

    protected abstract IAttributeInstance func_180376_c(IAttribute var1);

    public Collection<IAttributeInstance> getAllAttributes() {
        return this.attributesByName.values();
    }

    public void func_180794_a(IAttributeInstance iAttributeInstance) {
    }

    public void removeAttributeModifiers(Multimap<String, AttributeModifier> multimap) {
        for (Map.Entry<String, AttributeModifier> entry : multimap.entries()) {
            IAttributeInstance iAttributeInstance = this.getAttributeInstanceByName(entry.getKey());
            if (iAttributeInstance == null) continue;
            iAttributeInstance.removeModifier(entry.getValue());
        }
    }

    public void applyAttributeModifiers(Multimap<String, AttributeModifier> multimap) {
        for (Map.Entry<String, AttributeModifier> entry : multimap.entries()) {
            IAttributeInstance iAttributeInstance = this.getAttributeInstanceByName(entry.getKey());
            if (iAttributeInstance == null) continue;
            iAttributeInstance.removeModifier(entry.getValue());
            iAttributeInstance.applyModifier(entry.getValue());
        }
    }
}

