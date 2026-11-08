/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.Protocol1_20_5To1_20_3;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockPacketRewriter1_20_5
extends BlockRewriter<ClientboundPacket1_20_5> {
    public BlockPacketRewriter1_20_5(Protocol1_20_5To1_20_3 protocol1_20_5To1_20_3) {
        super(protocol1_20_5To1_20_3, Types.BLOCK_POSITION1_14, Types.COMPOUND_TAG, ChunkType1_20_2::new, null);
    }

    @Override
    public void handleBlockEntity(UserConnection userConnection, BlockEntity blockEntity) {
        this.updateBlockEntityTag(blockEntity.tag());
    }

    public void updateBlockEntityTag(@Nullable CompoundTag compoundTag) {
        if (compoundTag == null) {
            return;
        }
        Tag tag = compoundTag.remove("profile");
        if (tag instanceof StringTag) {
            compoundTag.put("SkullOwner", tag);
        } else if (tag instanceof CompoundTag) {
            this.updateProfileTag(compoundTag, (CompoundTag)tag);
        }
        ListTag<CompoundTag> listTag = compoundTag.getListTag("patterns", CompoundTag.class);
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                String string = compoundTag2.getString("pattern", "");
                String string2 = compoundTag2.getString("color");
                String string3 = BannerPatterns1_20_5.fullIdToCompact(Key.stripMinecraftNamespace(string));
                if (string3 == null || string2 == null) continue;
                compoundTag2.remove("pattern");
                compoundTag2.remove("color");
                compoundTag2.putString("Pattern", string3);
                compoundTag2.putInt("Color", BlockPacketRewriter1_20_5.colorId(string2));
            }
            compoundTag.remove("patterns");
            compoundTag.put("Patterns", listTag);
        }
    }

    private void updateProfileTag(CompoundTag compoundTag, CompoundTag compoundTag2) {
        ListTag<CompoundTag> listTag;
        IntArrayTag intArrayTag;
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag.put("SkullOwner", compoundTag3);
        String string = compoundTag2.getString("name");
        if (string != null) {
            compoundTag3.putString("Name", string);
        }
        if ((intArrayTag = compoundTag2.getIntArrayTag("id")) != null) {
            compoundTag3.put("Id", intArrayTag);
        }
        if ((listTag = compoundTag2.getListTag("properties", CompoundTag.class)) == null) {
            return;
        }
        CompoundTag compoundTag4 = new CompoundTag();
        for (CompoundTag compoundTag5 : listTag) {
            String string2 = compoundTag5.getString("name", "");
            String string3 = compoundTag5.getString("value", "");
            String string4 = compoundTag5.getString("signature");
            ListTag<CompoundTag> listTag2 = compoundTag4.getListTag(string2, CompoundTag.class);
            if (listTag2 == null) {
                listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
            }
            CompoundTag compoundTag6 = new CompoundTag();
            compoundTag6.putString("Value", string3);
            if (string4 != null) {
                compoundTag6.putString("Signature", string4);
            }
            listTag2.add(compoundTag6);
            compoundTag4.put(string2, listTag2);
        }
        compoundTag3.put("Properties", compoundTag4);
    }

    private static int colorId(String string) {
        return switch (string) {
            case "orange" -> 1;
            case "magenta" -> 2;
            case "light_blue" -> 3;
            case "yellow" -> 4;
            case "lime" -> 5;
            case "pink" -> 6;
            case "gray" -> 7;
            case "light_gray" -> 8;
            case "cyan" -> 9;
            case "purple" -> 10;
            case "blue" -> 11;
            case "brown" -> 12;
            case "green" -> 13;
            case "red" -> 14;
            case "black" -> 15;
            default -> 0;
        };
    }
}

