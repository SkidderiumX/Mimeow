/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.LegacyBlockItemRewriter;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.Protocol1_12To1_11_1;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.data.MapColorMappings1_11_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ServerboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_12
extends LegacyBlockItemRewriter<ClientboundPackets1_12, ServerboundPackets1_9_3, Protocol1_12To1_11_1> {
    public BlockItemPacketRewriter1_12(Protocol1_12To1_11_1 protocol1_12To1_11_1) {
        super(protocol1_12To1_11_1, "1.12");
    }

    @Override
    protected void registerPackets() {
        this.registerBlockChange(ClientboundPackets1_12.BLOCK_UPDATE);
        this.registerMultiBlockChange(ClientboundPackets1_12.CHUNK_BLOCKS_UPDATE);
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    for (int i = 0; i < n * 3; ++i) {
                        packetWrapper.passthrough(Types.BYTE);
                    }
                });
                this.handler(packetWrapper -> {
                    short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    if (s <= 0) {
                        return;
                    }
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    byte[] byArray = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    for (int i = 0; i < byArray.length; ++i) {
                        short s2 = (short)(byArray[i] & 0xFF);
                        if (s2 <= 143) continue;
                        s2 = (short)MapColorMappings1_11_1.getNearestOldColor(s2);
                        byArray[i] = (byte)s2;
                    }
                    packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                });
            }
        });
        this.registerSetSlot(ClientboundPackets1_12.CONTAINER_SET_SLOT);
        this.registerSetContent(ClientboundPackets1_12.CONTAINER_SET_CONTENT);
        this.registerSetEquippedItem(ClientboundPackets1_12.SET_EQUIPPED_ITEM);
        this.registerCustomPayloadTradeList(ClientboundPackets1_12.CUSTOM_PAYLOAD);
        ((Protocol1_12To1_11_1)this.protocol).registerServerbound(ServerboundPackets1_9_3.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.VAR_INT, 0) == 1) {
                        packetWrapper.set(Types.ITEM1_8, 0, null);
                        PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_12.CONTAINER_ACK);
                        packetWrapper2.write(Types.BYTE, packetWrapper.get(Types.BYTE, 0));
                        packetWrapper2.write(Types.SHORT, packetWrapper.get(Types.SHORT, 1));
                        packetWrapper2.write(Types.BOOLEAN, true);
                        packetWrapper.sendToServer(Protocol1_12To1_11_1.class);
                        packetWrapper.cancel();
                        packetWrapper2.sendToServer(Protocol1_12To1_11_1.class);
                        return;
                    }
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    BlockItemPacketRewriter1_12.this.handleItemToServer(packetWrapper.user(), item);
                });
            }
        });
        this.registerSetCreativeModeSlot(ServerboundPackets1_9_3.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_12To1_11_1.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.passthrough(chunkType1_9_3);
            this.handleChunk(chunk);
            for (CompoundTag compoundTag : chunk.getBlockEntities()) {
                String string = compoundTag.getString("id");
                if (string == null || !Key.stripMinecraftNamespace(string).equals("sign")) continue;
                this.handleSignText(compoundTag);
            }
        });
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    if (s == 9) {
                        CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                        BlockItemPacketRewriter1_12.this.handleSignText(compoundTag);
                    } else if (s == 11) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_12To1_11_1)this.protocol).getEntityRewriter().filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.dataType().type().equals(Types.ITEM1_8)) {
                entityData.setValue(this.handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.getValue()));
            }
        });
        ((Protocol1_12To1_11_1)this.protocol).registerServerbound(ServerboundPackets1_9_3.CLIENT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.VAR_INT, 0) == 2) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
    }

    private void handleSignText(CompoundTag compoundTag) {
        for (int i = 0; i < 4; ++i) {
            StringTag stringTag = compoundTag.getStringTag("Text" + (i + 1));
            if (stringTag == null) continue;
            stringTag.setValue(ComponentUtil.convertJsonOrEmpty(stringTag.getValue(), SerializerVersion.V1_12, SerializerVersion.V1_9).toString());
        }
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        super.handleItemToClient(userConnection, item);
        if (item.tag() != null) {
            CompoundTag compoundTag = new CompoundTag();
            if (this.handleNbtToClient(item.tag(), compoundTag)) {
                item.tag().put("Via|LongArrayTags", compoundTag);
            }
        }
        return item;
    }

    private boolean handleNbtToClient(CompoundTag compoundTag, CompoundTag compoundTag2) {
        Iterator<Map.Entry<String, Tag>> iterator2 = compoundTag.iterator();
        boolean bl = false;
        while (iterator2.hasNext()) {
            Map.Entry<String, Tag> entry = iterator2.next();
            Tag tag = entry.getValue();
            if (tag instanceof CompoundTag) {
                CompoundTag compoundTag3 = (CompoundTag)tag;
                tag = new CompoundTag();
                compoundTag2.put(entry.getKey(), tag);
                bl |= this.handleNbtToClient(compoundTag3, (CompoundTag)tag);
                continue;
            }
            tag = entry.getValue();
            if (!(tag instanceof LongArrayTag)) continue;
            LongArrayTag longArrayTag = (LongArrayTag)tag;
            compoundTag2.put(entry.getKey(), this.fromLongArrayTag(longArrayTag));
            iterator2.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, Item item) {
        Tag tag;
        if (item == null) {
            return null;
        }
        if ((item = super.handleItemToServer(userConnection, item)).tag() != null && (tag = item.tag().remove("Via|LongArrayTags")) instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            this.handleNbtToServer(item.tag(), compoundTag);
        }
        return item;
    }

    private void handleNbtToServer(CompoundTag compoundTag, CompoundTag compoundTag2) {
        for (Map.Entry<String, Tag> entry : compoundTag2) {
            if (entry.getValue() instanceof CompoundTag) {
                CompoundTag compoundTag3 = compoundTag.getCompoundTag(entry.getKey());
                this.handleNbtToServer(compoundTag3, (CompoundTag)entry.getValue());
                continue;
            }
            compoundTag.put(entry.getKey(), this.fromIntArrayTag((IntArrayTag)entry.getValue()));
        }
    }

    private IntArrayTag fromLongArrayTag(LongArrayTag longArrayTag) {
        int[] nArray = new int[longArrayTag.length() * 2];
        long[] lArray = longArrayTag.getValue();
        int n = 0;
        for (long l : lArray) {
            nArray[n++] = (int)(l >> 32);
            nArray[n++] = (int)l;
        }
        return new IntArrayTag(nArray);
    }

    private LongArrayTag fromIntArrayTag(IntArrayTag intArrayTag) {
        long[] lArray = new long[intArrayTag.length() / 2];
        int[] nArray = intArrayTag.getValue();
        int n = 0;
        int n2 = 0;
        while (n < nArray.length) {
            lArray[n2] = (long)nArray[n] << 32 | (long)nArray[n + 1] & 0xFFFFFFFFL;
            n += 2;
            ++n2;
        }
        return new LongArrayTag(lArray);
    }
}

