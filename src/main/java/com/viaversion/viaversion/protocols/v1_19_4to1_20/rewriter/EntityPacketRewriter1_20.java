/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_4to1_20.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.Quaternion;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19_4;
import com.viaversion.viaversion.api.type.types.version.Types1_20;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_4to1_20.Protocol1_19_4To1_20;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;

public class EntityPacketRewriter1_20
extends EntityRewriter<ClientboundPackets1_19_4, Protocol1_19_4To1_20> {
    private static final Quaternion Y_FLIPPED_ROTATION = new Quaternion(0.0f, 1.0f, 0.0f, 0.0f);

    public EntityPacketRewriter1_20(Protocol1_19_4To1_20 protocol1_19_4To1_20) {
        super(protocol1_19_4To1_20);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_19_4.SET_ENTITY_DATA, Types1_19_4.ENTITY_DATA_LIST, Types1_20.ENTITY_DATA_LIST);
        ((Protocol1_19_4To1_20)this.protocol).registerClientbound(ClientboundPackets1_19_4.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.create(Types.VAR_INT, 0);
                this.handler(EntityPacketRewriter1_20.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_20.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_20.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> {
                    Object object;
                    CompoundTag compoundTag3;
                    CompoundTag compoundTag2 = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag2, "damage_type");
                    int n = -1;
                    boolean bl = false;
                    boolean bl2 = false;
                    for (CompoundTag compoundTag3 : listTag) {
                        int n2 = compoundTag3.getInt("id");
                        n = Math.max(n, n2);
                        String string = Key.namespaced(compoundTag3.getString("name"));
                        if (string.equals("minecraft:outside_border")) {
                            bl = true;
                            continue;
                        }
                        if (!string.equals("minecraft:generic_kill")) continue;
                        bl2 = true;
                    }
                    if (!bl) {
                        object = new CompoundTag();
                        compoundTag3 = new CompoundTag();
                        compoundTag3.put("scaling", new StringTag("always"));
                        compoundTag3.put("exhaustion", new FloatTag(0.0f));
                        compoundTag3.put("message_id", new StringTag("badRespawnPoint"));
                        ((CompoundTag)object).put("id", new IntTag(n + 1));
                        ((CompoundTag)object).put("name", new StringTag("minecraft:outside_border"));
                        ((CompoundTag)object).put("element", compoundTag3);
                        listTag.add((CompoundTag)object);
                    }
                    if (!bl2) {
                        object = new CompoundTag();
                        compoundTag3 = new CompoundTag();
                        compoundTag3.put("scaling", new StringTag("always"));
                        compoundTag3.put("exhaustion", new FloatTag(0.0f));
                        compoundTag3.put("message_id", new StringTag("badRespawnPoint"));
                        ((CompoundTag)object).put("id", new IntTag(n + 2));
                        ((CompoundTag)object).put("name", new StringTag("minecraft:generic_kill"));
                        ((CompoundTag)object).put("element", compoundTag3);
                        listTag.add((CompoundTag)object);
                    }
                });
            }
        });
        ((Protocol1_19_4To1_20)this.protocol).registerClientbound(ClientboundPackets1_19_4.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.create(Types.VAR_INT, 0);
                this.handler(EntityPacketRewriter1_20.this.worldDataTrackerHandlerByKey());
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_20.ENTITY_DATA_TYPES::byId);
        this.registerEntityDataTypeHandler(Types1_20.ENTITY_DATA_TYPES.itemType, Types1_20.ENTITY_DATA_TYPES.blockStateType, Types1_20.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20.ENTITY_DATA_TYPES.particleType, null);
        this.registerBlockStateHandler(EntityTypes1_19_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_4.ITEM_DISPLAY).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.trackedEntity().hasSentEntityData() || entityDataHandlerEvent.hasExtraData()) {
                return;
            }
            if (entityDataHandlerEvent.dataAtIndex(12) == null) {
                entityDataHandlerEvent.createExtraData(new EntityData(12, Types1_20.ENTITY_DATA_TYPES.quaternionType, Y_FLIPPED_ROTATION));
            }
        });
        this.filter().type(EntityTypes1_19_4.ITEM_DISPLAY).index(12).handler((entityDataHandlerEvent, entityData) -> {
            Quaternion quaternion = (Quaternion)entityData.value();
            entityData.setValue(this.rotateY180(quaternion));
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_4.getTypeFromId(n);
    }

    private Quaternion rotateY180(Quaternion quaternion) {
        return new Quaternion(-quaternion.z(), quaternion.w(), quaternion.x(), -quaternion.y());
    }
}

