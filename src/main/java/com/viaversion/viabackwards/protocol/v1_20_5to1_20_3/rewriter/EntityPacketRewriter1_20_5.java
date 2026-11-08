/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.Protocol1_20_5To1_20_3;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.storage.RegistryDataStorage;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.storage.SecureChatStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.DimensionDataImpl;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.BannerPatternStorage;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityPacketRewriter1_20_5
extends EntityRewriter<ClientboundPacket1_20_5, Protocol1_20_5To1_20_3> {
    public EntityPacketRewriter1_20_5(Protocol1_20_5To1_20_3 protocol1_20_5To1_20_3) {
        super(protocol1_20_5To1_20_3, Types1_20_3.ENTITY_DATA_TYPES.optionalComponentType, Types1_20_3.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.SET_EQUIPMENT, packetWrapper -> {
            byte by;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            EntityType entityType = this.tracker(packetWrapper.user()).entityType(n);
            do {
                by = packetWrapper.read(Types.BYTE);
                Item item = ((Protocol1_20_5To1_20_3)this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(VersionedTypes.V1_20_5.item()));
                int n2 = by & 0x7F;
                if (n2 == 6) {
                    boolean bl = (by & 0xFFFFFF80) == 0;
                    by = (byte)(bl ? 4 : -124);
                    if (entityType != null && entityType.isOrHasParent(EntityTypes1_20_5.LLAMA)) {
                        packetWrapper.cancel();
                        this.sendCarpetColorUpdate(packetWrapper.user(), n, item);
                    }
                }
                packetWrapper.write(Types.BYTE, by);
                packetWrapper.write(Types.ITEM1_20_2, item);
            } while ((by & 0xFFFFFF80) != 0);
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_5.HORSE_SCREEN_OPEN, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, n + 1);
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA, packetWrapper -> {
            int n;
            Object object;
            Object object2;
            Tag tag;
            packetWrapper.cancel();
            String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
            if (string.equals("wolf_variant")) {
                return;
            }
            RegistryDataStorage registryDataStorage = packetWrapper.user().get(RegistryDataStorage.class);
            RegistryEntry[] registryEntryArray = packetWrapper.read(Types.REGISTRY_ENTRY_ARRAY);
            if (string.equals("banner_pattern")) {
                packetWrapper.user().get(BannerPatternStorage.class).setBannerPatterns(this.toMappings(registryEntryArray));
                return;
            }
            boolean bl = string.equals("trim_pattern");
            if (bl) {
                packetWrapper.user().get(ArmorTrimStorage.class).setTrimPatterns(this.toMappings(registryEntryArray));
            } else if (string.equals("trim_material")) {
                packetWrapper.user().get(ArmorTrimStorage.class).setTrimMaterials(this.toMappings(registryEntryArray));
            }
            if (string.equals("worldgen/biome")) {
                this.tracker(packetWrapper.user()).setBiomesSent(registryEntryArray.length);
                for (RegistryEntry object32 : registryEntryArray) {
                    if (object32.tag() == null || (tag = ((CompoundTag)(object2 = ((CompoundTag)object32.tag()).getCompoundTag("effects"))).getCompoundTag("particle")) == null) continue;
                    CompoundTag compoundTag = ((CompoundTag)tag).getCompoundTag("options");
                    String string2 = compoundTag.getString("type");
                    this.updateParticleFormat(compoundTag, Key.stripMinecraftNamespace(string2));
                }
            } else if (string.equals("dimension_type")) {
                object = new HashMap(registryEntryArray.length);
                String[] stringArray = new String[registryEntryArray.length];
                for (n = 0; n < registryEntryArray.length; ++n) {
                    RegistryEntry registryEntry = registryEntryArray[n];
                    Preconditions.checkNotNull(registryEntry.tag(), "Server unexpectedly sent null dimension data for " + registryEntry.key());
                    object2 = Key.stripMinecraftNamespace(registryEntry.key());
                    tag = (CompoundTag)registryEntry.tag();
                    this.updateDimensionTypeData((CompoundTag)tag);
                    object.put(object2, new DimensionDataImpl(n, (CompoundTag)tag));
                    stringArray[n] = object2;
                }
                registryDataStorage.setDimensionKeys(stringArray);
                this.tracker(packetWrapper.user()).setDimensions((Map<String, DimensionData>)object);
            }
            object = new CompoundTag();
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            ((CompoundTag)object).putString("type", string);
            ((CompoundTag)object).put("value", listTag);
            for (n = 0; n < registryEntryArray.length; ++n) {
                RegistryEntry registryEntry = registryEntryArray[n];
                Preconditions.checkNotNull(registryEntry.tag(), "Server unexpectedly sent null registry data entry for " + registryEntry.key());
                if (bl) {
                    object2 = (CompoundTag)registryEntry.tag();
                    tag = ((CompoundTag)object2).getStringTag("template_item");
                    if (Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().id(((StringTag)tag).getValue()) == -1) continue;
                }
                object2 = new CompoundTag();
                ((CompoundTag)object2).putString("name", registryEntry.key());
                ((CompoundTag)object2).putInt("id", n);
                ((CompoundTag)object2).put("element", registryEntry.tag());
                listTag.add((CompoundTag)object2);
            }
            registryDataStorage.registryData().put(string, (Tag)object);
        });
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING_ARRAY);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    RegistryDataStorage registryDataStorage = packetWrapper.user().get(RegistryDataStorage.class);
                    packetWrapper.write(Types.STRING, registryDataStorage.dimensionKeys()[n]);
                });
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.passthrough(Types.BYTE);
                    EntityPacketRewriter1_20_5.this.tracker(packetWrapper.user()).setInstaBuild(by == GameMode.CREATIVE.id());
                });
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.user().get(SecureChatStorage.class).setEnforcesSecureChat(bl);
                });
                this.handler(EntityPacketRewriter1_20_5.this.worldDataTrackerHandlerByKey());
                this.handler(EntityPacketRewriter1_20_5.this.playerTrackerHandler());
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    RegistryDataStorage registryDataStorage = packetWrapper.user().get(RegistryDataStorage.class);
                    packetWrapper.write(Types.STRING, registryDataStorage.dimensionKeys()[n]);
                });
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_20_5.this.worldDataTrackerHandlerByKey());
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.passthrough(Types.BYTE);
                    EntityPacketRewriter1_20_5.this.tracker(packetWrapper.user()).setInstaBuild(by == GameMode.CREATIVE.id());
                });
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_5.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.BYTE, (byte)MathUtil.clamp(n2, -128, 127));
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            if (n == 32) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putInt("padding_duration", 22);
                compoundTag.putBoolean("had_effect_last_tick", true);
                compoundTag.putFloat("factor_previous_frame", 0.0f);
                compoundTag.putFloat("factor_start", 1.0f);
                compoundTag.putFloat("factor_target", 1.0f);
                compoundTag.putFloat("factor_current", 1.0f);
                packetWrapper.write(Types.OPTIONAL_COMPOUND_TAG, compoundTag);
            } else {
                packetWrapper.write(Types.OPTIONAL_COMPOUND_TAG, null);
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_5.UPDATE_ATTRIBUTES, packetWrapper -> {
            int n;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            int n3 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n4;
                int n5;
                EntityType entityType;
                int n6 = packetWrapper.read(Types.VAR_INT);
                String string = Attributes1_20_5.idToKey(n6);
                int n7 = ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getAttributeMappings().getNewId(n6);
                if ("generic.jump_strength".equals(string) && ((entityType = this.tracker(packetWrapper.user()).entityType(n2)) == null || !entityType.isOrHasParent(EntityTypes1_20_5.HORSE))) {
                    n7 = -1;
                }
                if (n7 == -1) {
                    --n3;
                    packetWrapper.read(Types.DOUBLE);
                    n5 = packetWrapper.read(Types.VAR_INT);
                    for (n4 = 0; n4 < n5; ++n4) {
                        packetWrapper.read(Types.UUID);
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.BYTE);
                    }
                    continue;
                }
                packetWrapper.write(Types.STRING, string);
                packetWrapper.passthrough(Types.DOUBLE);
                n5 = packetWrapper.passthrough(Types.VAR_INT);
                for (n4 = 0; n4 < n5; ++n4) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
            packetWrapper.set(Types.VAR_INT, 1, n3);
        });
    }

    private KeyMappings toMappings(RegistryEntry[] registryEntryArray) {
        String[] stringArray = new String[registryEntryArray.length];
        for (int i = 0; i < registryEntryArray.length; ++i) {
            stringArray[i] = Key.stripMinecraftNamespace(registryEntryArray[i].key());
        }
        return new KeyMappings(stringArray);
    }

    private void updateParticleFormat(CompoundTag compoundTag, String string) {
        if ("block".equals(string) || "block_marker".equals(string) || "falling_dust".equals(string) || "dust_pillar".equals(string)) {
            Tag tag = compoundTag.remove("block_state");
            if (tag instanceof StringTag) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.put("Name", tag);
                tag = compoundTag2;
            }
            compoundTag.put("value", tag);
        } else if ("item".equals(string)) {
            Tag tag = compoundTag.remove("item");
            if (tag instanceof StringTag) {
                CompoundTag compoundTag3 = new CompoundTag();
                compoundTag3.put("id", tag);
                tag = compoundTag3;
            }
            compoundTag.put("value", tag);
        } else if ("dust_color_transition".equals(string)) {
            this.moveTag(compoundTag, "from_color", "fromColor");
            this.moveTag(compoundTag, "to_color", "toColor");
        } else if ("entity_effect".equals(string)) {
            Tag tag = compoundTag.remove("color");
            if (tag instanceof ListTag) {
                ListTag listTag = (ListTag)tag;
                tag = new FloatTag(this.encodeARGB(((NumberTag)listTag.get(0)).getValue().floatValue(), ((NumberTag)listTag.get(1)).getValue().floatValue(), ((NumberTag)listTag.get(2)).getValue().floatValue(), ((NumberTag)listTag.get(3)).getValue().floatValue()));
            }
            compoundTag.put("value", tag);
        }
    }

    private int encodeARGB(float f, float f2, float f3, float f4) {
        int n = this.encodeColorPart(f);
        int n2 = this.encodeColorPart(f2);
        int n3 = this.encodeColorPart(f3);
        int n4 = this.encodeColorPart(f4);
        return n << 24 | n2 << 16 | n3 << 8 | n4;
    }

    private int encodeColorPart(float f) {
        return (int)Math.floor(f * 255.0f);
    }

    private int removeAlpha(int n) {
        return n & 0xFFFFFF;
    }

    private void moveTag(CompoundTag compoundTag, String string, String string2) {
        Tag tag = compoundTag.remove(string);
        if (tag != null) {
            compoundTag.put(string2, tag);
        }
    }

    private void updateDimensionTypeData(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("monster_spawn_light_level");
        if (compoundTag2 != null) {
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag2.put("value", compoundTag3);
            compoundTag3.putInt("min_inclusive", compoundTag2.getInt("min_inclusive"));
            compoundTag3.putInt("max_inclusive", compoundTag2.getInt("max_inclusive"));
        }
    }

    private void sendCarpetColorUpdate(UserConnection userConnection, int n, Item item) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_20_3.SET_ENTITY_DATA, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        int n2 = -1;
        if (item != null && item.identifier() >= 445 && item.identifier() <= 460) {
            n2 = item.identifier() - 445;
        }
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(20, Types1_20_3.ENTITY_DATA_TYPES.varIntType, n2));
        packetWrapper.write(Types1_20_3.ENTITY_DATA_LIST, arrayList);
        packetWrapper.send(Protocol1_20_5To1_20_3.class);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n = entityData.dataType().typeId();
            if (n == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particlesType.typeId()) {
                Particle[] particleArray = (Particle[])entityData.value();
                int n2 = 0;
                for (Particle particle : particleArray) {
                    if (particle.id() != ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getParticleMappings().id("entity_effect")) continue;
                    n2 = (Integer)particle.removeArgument(0).getValue();
                }
                entityData.setTypeAndValue(Types1_20_3.ENTITY_DATA_TYPES.varIntType, this.removeAlpha(n2));
                return;
            }
            if (n == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).armadilloState.typeId() || n == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType.typeId()) {
                entityDataHandlerEvent.cancel();
                return;
            }
            int n3 = n;
            if (n >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).armadilloState.typeId()) {
                --n3;
            }
            if (n >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType.typeId()) {
                --n3;
            }
            if (n >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particlesType.typeId()) {
                --n3;
            }
            entityData.setDataType(Types1_20_3.ENTITY_DATA_TYPES.byId(n3));
        });
        this.registerEntityDataTypeHandler1_20_3(Types1_20_3.ENTITY_DATA_TYPES.itemType, Types1_20_3.ENTITY_DATA_TYPES.blockStateType, Types1_20_3.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20_3.ENTITY_DATA_TYPES.particleType, null, Types1_20_3.ENTITY_DATA_TYPES.componentType, Types1_20_3.ENTITY_DATA_TYPES.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_20_5.AREA_EFFECT_CLOUD).addIndex(9);
        this.filter().type(EntityTypes1_20_5.AREA_EFFECT_CLOUD).index(11).handler((entityDataHandlerEvent, entityData) -> {
            Particle particle = (Particle)entityData.value();
            if (particle.id() == ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getParticleMappings().mappedId("entity_effect")) {
                int n = (Integer)particle.removeArgument(0).getValue();
                entityDataHandlerEvent.createExtraData(new EntityData(9, Types1_20_3.ENTITY_DATA_TYPES.varIntType, this.removeAlpha(n)));
            }
        });
        this.filter().type(EntityTypes1_20_5.LLAMA).addIndex(20);
        this.filter().type(EntityTypes1_20_5.ARMADILLO).removeIndex(17);
        this.filter().type(EntityTypes1_20_5.WOLF).removeIndex(22);
        this.filter().type(EntityTypes1_20_5.OMINOUS_ITEM_SPAWNER).removeIndex(8);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_20_5.ARMADILLO, EntityTypes1_20_5.COW).tagName();
        this.mapEntityTypeWithData(EntityTypes1_20_5.BOGGED, EntityTypes1_20_5.STRAY).tagName();
        this.mapEntityTypeWithData(EntityTypes1_20_5.BREEZE_WIND_CHARGE, EntityTypes1_20_5.WIND_CHARGE);
        this.mapEntityTypeWithData(EntityTypes1_20_5.OMINOUS_ITEM_SPAWNER, EntityTypes1_20_5.TEXT_DISPLAY);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_5.getTypeFromId(n);
    }
}

