/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;

public class BlockItemPacketRewriter1_21_6
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_6, ServerboundPacket1_21_5, Protocol1_21_6To1_21_5> {
    public BlockItemPacketRewriter1_21_6(Protocol1_21_6To1_21_5 protocol1_21_6To1_21_5) {
        super(protocol1_21_6To1_21_5);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter.BlockItemPacketRewriter1_21_6.downgradeItemData(item);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter.BlockItemPacketRewriter1_21_6.upgradeItemData(item);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Object object;
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
        AttributeModifiers1_21 attributeModifiers1_21 = structuredDataContainer.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6);
        if (attributeModifiers1_21 != null) {
            object = new ListTag<CompoundTag>(CompoundTag.class);
            boolean bl = false;
            for (AttributeModifiers1_21.AttributeModifier attributeModifier : attributeModifiers1_21.modifiers()) {
                if (attributeModifier.display().id() != 0) {
                    bl = true;
                }
                CompoundTag compoundTag2 = new CompoundTag();
                ((ListTag)object).add(compoundTag2);
                compoundTag2.putInt("id", attributeModifier.display().id());
                AttributeModifiers1_21.Display display = attributeModifier.display();
                if (!(display instanceof AttributeModifiers1_21.OverrideText)) continue;
                AttributeModifiers1_21.OverrideText overrideText = (AttributeModifiers1_21.OverrideText)display;
                compoundTag2.put("text", overrideText.component());
            }
            if (bl) {
                compoundTag.put("attribute_modifiers_displays", (Tag)object);
            }
        }
        if ((object = structuredDataContainer.get(StructuredDataKey.EQUIPPABLE1_21_6)) != null && ((Equippable)object).canBeSheared()) {
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.putBoolean("can_be_sheared", true);
            this.saveSoundEventHolder(compoundTag3, ((Equippable)object).shearingSound());
            compoundTag.put("equippable", compoundTag3);
        }
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        ListTag<CompoundTag> listTag = compoundTag.remove(this.nbtTagName("backup"));
        if (!(listTag instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag3 = (CompoundTag)((Object)listTag);
        listTag = compoundTag3.getListTag("attribute_modifiers_displays", CompoundTag.class);
        if (listTag != null) {
            structuredDataContainer.replace(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, attributeModifiers1_21 -> {
                AttributeModifiers1_21.AttributeModifier[] attributeModifierArray = new AttributeModifiers1_21.AttributeModifier[attributeModifiers1_21.modifiers().length];
                for (int i = 0; i < attributeModifiers1_21.modifiers().length; ++i) {
                    CompoundTag compoundTag = (CompoundTag)listTag.get(i);
                    int n = compoundTag.getInt("id");
                    AttributeModifiers1_21.Display display = n == 2 ? new AttributeModifiers1_21.OverrideText(compoundTag.get("text")) : new AttributeModifiers1_21.Display(n);
                    AttributeModifiers1_21.AttributeModifier attributeModifier = attributeModifiers1_21.modifiers()[i];
                    attributeModifierArray[i] = new AttributeModifiers1_21.AttributeModifier(attributeModifier.attribute(), attributeModifier.modifier(), attributeModifier.slotType(), display);
                }
                return new AttributeModifiers1_21(attributeModifierArray);
            });
        }
        if ((compoundTag2 = compoundTag3.getCompoundTag("equippable")) != null) {
            structuredDataContainer.replace(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_6, equippable -> new Equippable(equippable.equipmentSlot(), equippable.soundEvent(), equippable.model(), equippable.cameraOverlay(), equippable.allowedEntities(), equippable.dispensable(), equippable.swappable(), equippable.damageOnHurt(), equippable.equipOnInteract(), compoundTag2.getBoolean("can_be_sheared"), this.restoreSoundEventHolder(compoundTag2)));
        }
    }
}

