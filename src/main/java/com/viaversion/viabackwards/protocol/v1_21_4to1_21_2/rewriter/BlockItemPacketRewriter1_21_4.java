/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.BackwardsFullStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.Protocol1_21_4To1_21_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;

public class BlockItemPacketRewriter1_21_4
extends BackwardsFullStructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_2, Protocol1_21_4To1_21_2> {
    public BlockItemPacketRewriter1_21_4(Protocol1_21_4To1_21_2 protocol1_21_4To1_21_2) {
        super(protocol1_21_4To1_21_2);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_4To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.BYTE, (byte)n);
        });
        ((Protocol1_21_4To1_21_2)this.protocol).cancelServerbound(ServerboundPackets1_21_2.PICK_ITEM);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        StructuredDataContainer structuredDataContainer = (item = super.handleItemToClient(userConnection, item)).dataContainer();
        CustomModelData1_21_4 customModelData1_21_4 = structuredDataContainer.get(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
        if (customModelData1_21_4 != null) {
            this.saveTag(this.createCustomTag(item), this.customModelDataToTag(customModelData1_21_4), "custom_model_data");
            if (ViaBackwards.getConfig().mapCustomModelData() && customModelData1_21_4.floats().length > 0) {
                int n = (int)customModelData1_21_4.floats()[0];
                structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, n);
            }
        }
        com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockItemPacketRewriter1_21_4.downgradeItemData(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        Tag tag;
        StructuredDataContainer structuredDataContainer = (item = super.handleItemToServer(userConnection, item)).dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag != null && (tag = compoundTag.remove(this.nbtTagName("custom_model_data"))) instanceof CompoundTag) {
            CompoundTag compoundTag2 = (CompoundTag)tag;
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, this.customModelDataFromTag(compoundTag2));
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockItemPacketRewriter1_21_4.updateItemData(item);
        return item;
    }

    private CustomModelData1_21_4 customModelDataFromTag(CompoundTag compoundTag) {
        IntArrayTag intArrayTag = compoundTag.getIntArrayTag("floats");
        float[] fArray = new float[intArrayTag.getValue().length];
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = Float.intBitsToFloat(intArrayTag.get(i));
        }
        ByteArrayTag byteArrayTag = compoundTag.getByteArrayTag("booleans");
        boolean[] blArray = new boolean[byteArrayTag.getValue().length];
        for (int i = 0; i < blArray.length; ++i) {
            blArray[i] = byteArrayTag.get(i) != 0;
        }
        ListTag<StringTag> listTag = compoundTag.getListTag("strings", StringTag.class);
        String[] stringArray = new String[listTag.size()];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = listTag.get(i).getValue();
        }
        IntArrayTag intArrayTag2 = compoundTag.getIntArrayTag("colors");
        return new CustomModelData1_21_4(fArray, blArray, stringArray, intArrayTag2.getValue());
    }

    private CompoundTag customModelDataToTag(CustomModelData1_21_4 customModelData1_21_4) {
        CompoundTag compoundTag = new CompoundTag();
        int[] nArray = new int[customModelData1_21_4.floats().length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = Float.floatToIntBits(customModelData1_21_4.floats()[i]);
        }
        compoundTag.put("floats", new IntArrayTag(nArray));
        byte[] byArray = new byte[customModelData1_21_4.booleans().length];
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)(customModelData1_21_4.booleans()[i] ? 1 : 0);
        }
        compoundTag.put("booleans", new ByteArrayTag(byArray));
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (String string : customModelData1_21_4.strings()) {
            listTag.add(new StringTag(string));
        }
        compoundTag.put("strings", listTag);
        compoundTag.put("colors", new IntArrayTag(customModelData1_21_4.colors()));
        return compoundTag;
    }
}

