/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntArraySet;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.AcknowledgedMessagesStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ScoreboardTeamStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import com.viaversion.viaversion.util.TagUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityPacketRewriter1_20_5
extends EntityRewriter<ClientboundPacket1_20_3, Protocol1_20_3To1_20_5> {
    private static final UUID CREATIVE_BLOCK_INTERACTION_RANGE = UUID.fromString("736565d2-e1a7-403d-a3f8-1aeb3e302542");
    private static final UUID CREATIVE_ENTITY_INTERACTION_RANGE = UUID.fromString("98491ef6-97b1-4584-ae82-71a8cc85cf73");

    public EntityPacketRewriter1_20_5(Protocol1_20_3To1_20_5 protocol1_20_3To1_20_5) {
        super(protocol1_20_3To1_20_5);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_20_3.SET_ENTITY_DATA, Types1_20_3.ENTITY_DATA_LIST, VersionedTypes.V1_20_5.entityDataList);
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.SET_EQUIPMENT, packetWrapper -> {
            byte by;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            EntityType entityType = this.tracker(packetWrapper.user()).entityType(n);
            do {
                by = packetWrapper.read(Types.BYTE);
                int n2 = by & 0x7F;
                if (entityType != null && entityType.isOrHasParent(EntityTypes1_20_5.ABSTRACT_HORSE) && n2 == 4) {
                    boolean bl = (by & 0xFFFFFF80) == 0;
                    by = (byte)(bl ? 6 : -122);
                }
                packetWrapper.write(Types.BYTE, by);
                Item item = ((Protocol1_20_3To1_20_5)this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2));
                packetWrapper.write(VersionedTypes.V1_20_5.item, item);
            } while ((by & 0xFFFFFF80) != 0);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_3.REGISTRY_DATA, packetWrapper -> {
            RegistryEntry[] registryEntryArray;
            Tag tag;
            Object object;
            Object object2;
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.SELECT_KNOWN_PACKS);
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.send(Protocol1_20_3To1_20_5.class);
            CompoundTag compoundTag2 = packetWrapper.read(Types.COMPOUND_TAG);
            this.cacheDimensionData(packetWrapper.user(), compoundTag2);
            this.trackBiomeSize(packetWrapper.user(), compoundTag2);
            ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag2, "dimension_type");
            for (CompoundTag object42 : listTag) {
                CompoundTag compoundTag3 = object42.getCompoundTag("element");
                object2 = compoundTag3.getCompoundTag("monster_spawn_light_level");
                if (object2 == null) continue;
                object = (CompoundTag)((CompoundTag)object2).removeUnchecked("value");
                ((CompoundTag)object2).putInt("min_inclusive", object.getInt("min_inclusive"));
                ((CompoundTag)object2).putInt("max_inclusive", object.getInt("max_inclusive"));
            }
            ListTag<CompoundTag> listTag2 = TagUtil.getRegistryEntries(compoundTag2, "worldgen/biome");
            Iterator iterator2 = listTag2.iterator();
            while (iterator2.hasNext()) {
                CompoundTag compoundTag4 = (CompoundTag)iterator2.next();
                object2 = compoundTag4.getCompoundTag("element").getCompoundTag("effects");
                this.checkSoundTag(((CompoundTag)object2).getCompoundTag("mood_sound"), "sound");
                this.checkSoundTag(((CompoundTag)object2).getCompoundTag("additions_sound"), "sound");
                this.checkSoundTag(((CompoundTag)object2).getCompoundTag("music"), "sound");
                this.checkSoundTag((CompoundTag)object2, "ambient_sound");
                object = ((CompoundTag)object2).getCompoundTag("particle");
                if (object == null) continue;
                tag = object.getCompoundTag("options");
                registryEntryArray = ((CompoundTag)tag).getString("type");
                this.updateParticleFormat((CompoundTag)tag, Key.stripMinecraftNamespace((String)registryEntryArray));
            }
            for (Map.Entry<String, Tag> entry : compoundTag2.entrySet()) {
                Object object3;
                object2 = (CompoundTag)entry.getValue();
                object = ((CompoundTag)object2).getString("type");
                tag = ((CompoundTag)object2).getListTag("value", CompoundTag.class);
                registryEntryArray = new RegistryEntry[((ListTag)tag).stream().map(compoundTag -> compoundTag.getInt("id")).distinct().toArray().length];
                boolean bl = false;
                int n = -1;
                IntArraySet intArraySet = new IntArraySet();
                Object object4 = ((ListTag)tag).iterator();
                while (object4.hasNext()) {
                    object3 = (CompoundTag)object4.next();
                    String string = ((CompoundTag)object3).getString("name");
                    int n2 = ((CompoundTag)object3).getInt("id");
                    if (intArraySet.add(n2)) {
                        n = Math.max(n, n2);
                        if (n2 >= registryEntryArray.length) {
                            registryEntryArray = Arrays.copyOf(registryEntryArray, Math.max(registryEntryArray.length * 2, n2 + 1));
                            bl = true;
                        }
                    }
                    registryEntryArray[n2] = new RegistryEntry(string, ((CompoundTag)object3).get("element"));
                }
                object4 = Key.stripMinecraftNamespace((String)object);
                if (((String)object4).equals("damage_type")) {
                    if (Arrays.stream(registryEntryArray).noneMatch(registryEntry -> Key.namespaced(registryEntry.key()).equals("minecraft:spit"))) {
                        registryEntryArray = Arrays.copyOf(registryEntryArray, ++n + 1);
                        object3 = new CompoundTag();
                        ((CompoundTag)object3).putString("scaling", "when_caused_by_living_non_player");
                        ((CompoundTag)object3).putString("message_id", "mob");
                        ((CompoundTag)object3).putFloat("exhaustion", 0.1f);
                        registryEntryArray[n] = new RegistryEntry("minecraft:spit", (Tag)object3);
                    }
                    object3 = Arrays.stream(registryEntryArray).map(registryEntry -> Key.stripMinecraftNamespace(registryEntry.key())).collect(Collectors.toSet());
                    for (String string : ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().damageKeys()) {
                        if (object3.contains(string)) continue;
                        registryEntryArray = Arrays.copyOf(registryEntryArray, ++n + 1);
                        registryEntryArray[n] = new RegistryEntry(Key.namespaced(string), ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().damageType(string));
                    }
                }
                if (bl) {
                    int n3 = n + 1;
                    if (registryEntryArray.length != n3) {
                        registryEntryArray = Arrays.copyOf(registryEntryArray, n3);
                    }
                    this.replaceNullValues(registryEntryArray);
                }
                if (((String)object4).equals("trim_pattern")) {
                    packetWrapper.user().get(ArmorTrimStorage.class).setTrimPatterns(this.toMappings(registryEntryArray));
                } else if (((String)object4).equals("trim_material")) {
                    packetWrapper.user().get(ArmorTrimStorage.class).setTrimMaterials(this.toMappings(registryEntryArray));
                }
                object3 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
                object3.write(Types.STRING, object);
                object3.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
                object3.send(Protocol1_20_3To1_20_5.class);
            }
            packetWrapper.cancel();
            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            packetWrapper3.write(Types.STRING, "minecraft:wolf_variant");
            CompoundTag compoundTag5 = new CompoundTag();
            compoundTag5.putString("wild_texture", "entity/wolf/wolf");
            compoundTag5.putString("tame_texture", "entity/wolf/wolf_tame");
            compoundTag5.putString("angry_texture", "entity/wolf/wolf_angry");
            compoundTag5.put("biomes", new ListTag<StringTag>(StringTag.class));
            packetWrapper3.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{new RegistryEntry("minecraft:pale", compoundTag5)});
            packetWrapper3.send(Protocol1_20_3To1_20_5.class);
            object2 = packetWrapper.create(ClientboundConfigurationPackets1_20_5.REGISTRY_DATA);
            object2.write(Types.STRING, "minecraft:banner_pattern");
            object = BannerPatterns1_20_5.keys();
            tag = new RegistryEntry[((Key[])object).length];
            for (int i = 0; i < ((Key[])object).length; ++i) {
                CompoundTag compoundTag6 = new CompoundTag();
                Key key = object[i];
                compoundTag6.putString("asset_id", key.path());
                compoundTag6.putString("translation_key", "block.minecraft.banner." + key.path());
                tag[i] = new RegistryEntry(key.toString(), compoundTag6);
            }
            object2.write(Types.REGISTRY_ENTRY_ARRAY, tag);
            object2.send(Protocol1_20_3To1_20_5.class);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.LOGIN, new PacketHandlers(){

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
                    String string = packetWrapper.read(Types.STRING);
                    DimensionData dimensionData = EntityPacketRewriter1_20_5.this.tracker(packetWrapper.user()).dimensionData(string);
                    packetWrapper.write(Types.VAR_INT, dimensionData.id());
                });
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.map(Types.VAR_INT);
                this.handler(EntityPacketRewriter1_20_5.this.worldDataTrackerHandlerByKey1_20_5(3));
                this.handler(EntityPacketRewriter1_20_5.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    AcknowledgedMessagesStorage acknowledgedMessagesStorage = packetWrapper.user().get(AcknowledgedMessagesStorage.class);
                    if (acknowledgedMessagesStorage.secureChatEnforced() != null) {
                        packetWrapper.write(Types.BOOLEAN, acknowledgedMessagesStorage.isSecureChatEnforced());
                    } else {
                        packetWrapper.write(Types.BOOLEAN, Via.getConfig().enforceSecureChat());
                    }
                    acknowledgedMessagesStorage.clear();
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    boolean bl = by == GameMode.CREATIVE.id();
                    EntityPacketRewriter1_20_5.this.sendRangeAttributes(packetWrapper.user(), bl);
                    EntityPacketRewriter1_20_5.this.tracker(packetWrapper.user()).setInstaBuild(bl);
                });
            }
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.RESPAWN, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            DimensionData dimensionData = this.tracker(packetWrapper.user()).dimensionData(string);
            packetWrapper.write(Types.VAR_INT, dimensionData.id());
            packetWrapper.passthrough(Types.STRING);
            this.worldDataTrackerHandlerByKey1_20_5(0).handle(packetWrapper);
            packetWrapper.passthrough(Types.LONG);
            byte by = packetWrapper.passthrough(Types.BYTE);
            boolean bl = by == GameMode.CREATIVE.id();
            this.sendRangeAttributes(packetWrapper.user(), bl);
            this.tracker(packetWrapper.user()).setInstaBuild(bl);
            packetWrapper.user().put(new ScoreboardTeamStorage());
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.read(Types.BYTE);
            packetWrapper.write(Types.VAR_INT, Integer.valueOf(by));
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.read(Types.OPTIONAL_COMPOUND_TAG);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.UPDATE_ATTRIBUTES, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                int n2 = Attributes1_20_5.keyToId(string);
                packetWrapper.write(Types.VAR_INT, n2 != -1 ? n2 : 0);
                packetWrapper.passthrough(Types.DOUBLE);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n3; ++j) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.GAME_EVENT, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (s != 3) {
                return;
            }
            int n = (int)Math.floor(packetWrapper.passthrough(Types.FLOAT).floatValue() + 0.5f);
            boolean bl = n == GameMode.CREATIVE.id();
            this.sendRangeAttributes(packetWrapper.user(), bl);
            this.tracker(packetWrapper.user()).setInstaBuild(bl);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.PLAYER_ABILITIES, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            this.tracker(packetWrapper.user()).setInstaBuild((by & 8) != 0);
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
            this.moveTag(compoundTag, "value", "block_state");
        } else if ("item".equals(string)) {
            this.moveTag(compoundTag, "value", "item");
        } else if ("dust_color_transition".equals(string)) {
            this.moveTag(compoundTag, "fromColor", "from_color");
            this.moveTag(compoundTag, "toColor", "to_color");
        } else if ("entity_effect".equals(string)) {
            this.moveTag(compoundTag, "value", "color");
        }
    }

    private void moveTag(CompoundTag compoundTag, String string, String string2) {
        Tag tag = compoundTag.remove(string);
        if (tag != null) {
            compoundTag.put(string2, tag);
        }
    }

    private void checkSoundTag(@Nullable CompoundTag compoundTag, String string) {
        if (compoundTag == null) {
            return;
        }
        String string2 = compoundTag.getString(string);
        if (string2 != null && ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().soundId(string2) == -1) {
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("sound_id", string2);
            compoundTag.put(string, compoundTag2);
        }
    }

    private void replaceNullValues(RegistryEntry[] registryEntryArray) {
        RegistryEntry registryEntry = null;
        for (RegistryEntry registryEntry2 : registryEntryArray) {
            if (registryEntry2 == null) continue;
            registryEntry = registryEntry2;
            break;
        }
        for (int i = 0; i < registryEntryArray.length; ++i) {
            if (registryEntryArray[i] != null) continue;
            registryEntryArray[i] = registryEntry.withKey(UUIDUtil.randomUUID().toString());
        }
    }

    private void sendRangeAttributes(UserConnection userConnection, boolean bl) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_20_5.UPDATE_ATTRIBUTES, userConnection);
        packetWrapper.write(Types.VAR_INT, this.tracker(userConnection).clientEntityId());
        if (userConnection.getProtocolInfo().serverProtocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_7_6)) {
            packetWrapper.write(Types.VAR_INT, 3);
            this.writeAttribute(packetWrapper, "generic.step_height", 0.5, null, 0.0);
        } else {
            packetWrapper.write(Types.VAR_INT, 2);
        }
        this.writeAttribute(packetWrapper, "player.block_interaction_range", 4.5, bl ? CREATIVE_BLOCK_INTERACTION_RANGE : null, 0.5);
        if (userConnection.getProtocolInfo().serverProtocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_13_2)) {
            this.writeAttribute(packetWrapper, "player.entity_interaction_range", 3.0, bl ? CREATIVE_ENTITY_INTERACTION_RANGE : null, 1.0);
        } else {
            this.writeAttribute(packetWrapper, "player.entity_interaction_range", 3.0, bl ? CREATIVE_ENTITY_INTERACTION_RANGE : null, 2.0);
        }
        packetWrapper.scheduleSend(Protocol1_20_3To1_20_5.class);
    }

    private void writeAttribute(PacketWrapper packetWrapper, String string, double d, @Nullable UUID uUID, double d2) {
        packetWrapper.write(Types.VAR_INT, Attributes1_20_5.keyToId(string));
        packetWrapper.write(Types.DOUBLE, d);
        if (uUID != null) {
            packetWrapper.write(Types.VAR_INT, 1);
            packetWrapper.write(Types.UUID, uUID);
            packetWrapper.write(Types.DOUBLE, d2);
            packetWrapper.write(Types.BYTE, (byte)0);
        } else {
            packetWrapper.write(Types.VAR_INT, 0);
        }
    }

    static int withAlpha(int n) {
        return 0xFF000000 | n & 0xFFFFFF;
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(n -> {
            int n2 = n;
            if (n2 >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particlesType.typeId()) {
                ++n2;
            }
            if (n2 >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).wolfVariantType.typeId()) {
                ++n2;
            }
            if (n2 >= ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).armadilloState.typeId()) {
                ++n2;
            }
            return ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).byId(n2);
        });
        this.registerEntityDataTypeHandler(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).itemType, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).blockStateType, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particleType, null, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).componentType, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_20_5.LIVING_ENTITY).index(10).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n == 0) {
                entityData.setTypeAndValue(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particlesType, new Particle[0]);
                return;
            }
            Particle particle = new Particle(((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getParticleMappings().mappedId("entity_effect"));
            particle.add(Types.INT, EntityPacketRewriter1_20_5.withAlpha(n));
            entityData.setTypeAndValue(((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particlesType, new Particle[]{particle});
        });
        this.filter().type(EntityTypes1_20_5.LLAMA).handler((entityDataHandlerEvent, entityData) -> {
            int n = entityDataHandlerEvent.index();
            if (n == 20) {
                entityDataHandlerEvent.cancel();
                int n2 = (Integer)entityData.value();
                PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_20_5.SET_EQUIPMENT, entityDataHandlerEvent.user());
                packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                packetWrapper.write(Types.BYTE, (byte)6);
                packetWrapper.write(VersionedTypes.V1_20_5.item, new StructuredItem(n2 + 446, 1, new StructuredDataContainer()));
                packetWrapper.scheduleSend(Protocol1_20_3To1_20_5.class);
            } else if (n > 20) {
                entityDataHandlerEvent.setIndex(n - 1);
            }
        });
        this.filter().type(EntityTypes1_20_5.AREA_EFFECT_CLOUD).handler((entityDataHandlerEvent, entityData) -> {
            EntityData entityData2;
            int n = entityDataHandlerEvent.index();
            if (n == 9) {
                EntityData entityData3 = entityDataHandlerEvent.dataAtIndex(11);
                int n2 = (Integer)entityData.value();
                if (entityData3 == null) {
                    if (n2 != 0) {
                        Particle particle = new Particle(((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getParticleMappings().mappedId("entity_effect"));
                        particle.add(Types.INT, EntityPacketRewriter1_20_5.withAlpha(n2));
                        entityDataHandlerEvent.createExtraData(new EntityData(10, ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).particleType, particle));
                    }
                } else {
                    this.addColor(entityData3, n2);
                }
                entityDataHandlerEvent.cancel();
                return;
            }
            if (n == 11 && (entityData2 = entityDataHandlerEvent.dataAtIndex(9)) != null && entityData2.dataType() == ((EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes).varIntType) {
                this.addColor(entityData, (Integer)entityData2.value());
            }
            if (n > 9) {
                entityDataHandlerEvent.setIndex(n - 1);
            }
        });
        this.filter().type(EntityTypes1_20_5.ARROW).index(10).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n != -1) {
                entityData.setValue(EntityPacketRewriter1_20_5.withAlpha(n));
            }
        });
        this.filter().type(EntityTypes1_20_5.ITEM_PROJECTILE).index(8).handler((entityDataHandlerEvent, entityData) -> {
            Item item = (Item)entityData.value();
            if (item == null || item.isEmpty()) {
                entityDataHandlerEvent.cancel();
            }
        });
    }

    private void addColor(@Nullable EntityData entityData, int n) {
        if (entityData == null) {
            return;
        }
        Particle particle = (Particle)entityData.value();
        if (particle.id() == ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getParticleMappings().mappedId("entity_effect")) {
            particle.getArgument(0).setValue(EntityPacketRewriter1_20_5.withAlpha(n));
        }
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_5.getTypeFromId(n);
    }
}

