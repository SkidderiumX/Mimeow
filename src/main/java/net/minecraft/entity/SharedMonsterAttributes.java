/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.Collection;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SharedMonsterAttributes {
    private static final Logger logger = LogManager.getLogger();
    public static final IAttribute maxHealth = new RangedAttribute(null, "generic.maxHealth", 20.0, 0.0, 1024.0).setDescription("Max Health").setShouldWatch(true);
    public static final IAttribute followRange = new RangedAttribute(null, "generic.followRange", 32.0, 0.0, 2048.0).setDescription("Follow Range");
    public static final IAttribute knockbackResistance = new RangedAttribute(null, "generic.knockbackResistance", 0.0, 0.0, 1.0).setDescription("Knockback Resistance");
    public static final IAttribute movementSpeed = new RangedAttribute(null, "generic.movementSpeed", 0.7f, 0.0, 1024.0).setDescription("Movement Speed").setShouldWatch(true);
    public static final IAttribute attackDamage = new RangedAttribute(null, "generic.attackDamage", 2.0, 0.0, 2048.0);

    public static NBTTagList writeBaseAttributeMapToNBT(BaseAttributeMap baseAttributeMap) {
        NBTTagList nBTTagList = new NBTTagList();
        for (IAttributeInstance iAttributeInstance : baseAttributeMap.getAllAttributes()) {
            nBTTagList.appendTag(SharedMonsterAttributes.writeAttributeInstanceToNBT(iAttributeInstance));
        }
        return nBTTagList;
    }

    private static NBTTagCompound writeAttributeInstanceToNBT(IAttributeInstance iAttributeInstance) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        IAttribute iAttribute = iAttributeInstance.getAttribute();
        nBTTagCompound.setString("Name", iAttribute.getAttributeUnlocalizedName());
        nBTTagCompound.setDouble("Base", iAttributeInstance.getBaseValue());
        Collection<AttributeModifier> collection = iAttributeInstance.func_111122_c();
        if (collection != null && !collection.isEmpty()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (AttributeModifier attributeModifier : collection) {
                if (!attributeModifier.isSaved()) continue;
                nBTTagList.appendTag(SharedMonsterAttributes.writeAttributeModifierToNBT(attributeModifier));
            }
            nBTTagCompound.setTag("Modifiers", nBTTagList);
        }
        return nBTTagCompound;
    }

    private static NBTTagCompound writeAttributeModifierToNBT(AttributeModifier attributeModifier) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound.setString("Name", attributeModifier.getName());
        nBTTagCompound.setDouble("Amount", attributeModifier.getAmount());
        nBTTagCompound.setInteger("Operation", attributeModifier.getOperation());
        nBTTagCompound.setLong("UUIDMost", attributeModifier.getID().getMostSignificantBits());
        nBTTagCompound.setLong("UUIDLeast", attributeModifier.getID().getLeastSignificantBits());
        return nBTTagCompound;
    }

    public static void setAttributeModifiers(BaseAttributeMap baseAttributeMap, NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            IAttributeInstance iAttributeInstance = baseAttributeMap.getAttributeInstanceByName(nBTTagCompound.getString("Name"));
            if (iAttributeInstance != null) {
                SharedMonsterAttributes.applyModifiersToAttributeInstance(iAttributeInstance, nBTTagCompound);
                continue;
            }
            logger.warn("Ignoring unknown attribute '" + nBTTagCompound.getString("Name") + "'");
        }
    }

    private static void applyModifiersToAttributeInstance(IAttributeInstance iAttributeInstance, NBTTagCompound nBTTagCompound) {
        iAttributeInstance.setBaseValue(nBTTagCompound.getDouble("Base"));
        if (nBTTagCompound.hasKey("Modifiers", 9)) {
            NBTTagList nBTTagList = nBTTagCompound.getTagList("Modifiers", 10);
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                AttributeModifier attributeModifier = SharedMonsterAttributes.readAttributeModifierFromNBT(nBTTagList.getCompoundTagAt(i));
                if (attributeModifier == null) continue;
                AttributeModifier attributeModifier2 = iAttributeInstance.getModifier(attributeModifier.getID());
                if (attributeModifier2 != null) {
                    iAttributeInstance.removeModifier(attributeModifier2);
                }
                iAttributeInstance.applyModifier(attributeModifier);
            }
        }
    }

    public static AttributeModifier readAttributeModifierFromNBT(NBTTagCompound nBTTagCompound) {
        UUID uUID = new UUID(nBTTagCompound.getLong("UUIDMost"), nBTTagCompound.getLong("UUIDLeast"));
        try {
            return new AttributeModifier(uUID, nBTTagCompound.getString("Name"), nBTTagCompound.getDouble("Amount"), nBTTagCompound.getInteger("Operation"));
        }
        catch (Exception exception) {
            logger.warn("Unable to create attribute: " + exception.getMessage());
            return null;
        }
    }
}

