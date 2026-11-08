/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.entities.EntityScaleHelper;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.SignStorage;
import com.viaversion.viabackwards.utils.VelocityUtil;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityPacketRewriter1_21_2
extends EntityRewriter<ClientboundPacket1_21_2, Protocol1_21_2To1_21> {
    private static final int REL_X = 0;
    private static final int REL_Y = 1;
    private static final int REL_Z = 2;
    private static final int REL_Y_ROT = 3;
    private static final int REL_X_ROT = 4;
    private static final int REL_DELTA_X = 5;
    private static final int REL_DELTA_Y = 6;
    private static final int REL_DELTA_Z = 7;
    private static final int REL_ROTATE_DELTA = 8;
    private static final int WATER_CREATURE_BABY_INDEX = 16;
    private boolean warned = ViaBackwards.getConfig().suppressEmulationWarnings();

    public EntityPacketRewriter1_21_2(Protocol1_21_2To1_21 protocol1_21_2To1_21) {
        super(protocol1_21_2To1_21, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            this.trackSpawnWithData1_19(packetWrapper, n3);
            EntityType entityType = EntityTypes1_21_2.getTypeFromId(n2);
            if (entityType.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
                packetWrapper.send(Protocol1_21_2To1_21.class);
                packetWrapper.cancel();
                ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                int n4 = entityType.isOrHasParent(EntityTypes1_21_2.ABSTRACT_CHEST_BOAT) ? this.chestBoatTypeFromEntityType(entityType) : this.boatTypeFromEntityType(entityType);
                arrayList.add(new EntityData(11, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).varIntType, n4));
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21.SET_ENTITY_DATA);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(VersionedTypes.V1_21.entityDataList, arrayList);
                packetWrapper2.send(Protocol1_21_2To1_21.class);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).getRegistryDataRewriter().addEnchantmentEffectRewriter("change_item_damage", compoundTag -> compoundTag.putString("type", "damage_item"));
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, packetWrapper -> {
            String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
            RegistryEntry[] registryEntryArray = packetWrapper.read(Types.REGISTRY_ENTRY_ARRAY);
            if (string.equals("instrument")) {
                packetWrapper.cancel();
                return;
            }
            if (string.equals("worldgen/biome")) {
                for (RegistryEntry registryEntry : registryEntryArray) {
                    CompoundTag compoundTag;
                    CompoundTag compoundTag2;
                    if (registryEntry.tag() == null || (compoundTag2 = (compoundTag = ((CompoundTag)registryEntry.tag()).getCompoundTag("effects")).getCompoundTag("particle")) == null) continue;
                    CompoundTag compoundTag3 = compoundTag2.getCompoundTag("options");
                    String string2 = compoundTag3.getString("type");
                    this.updateParticleFormat(compoundTag3, Key.stripMinecraftNamespace(string2));
                }
            }
            packetWrapper.write(Types.REGISTRY_ENTRY_ARRAY, ((Protocol1_21_2To1_21)this.protocol).getRegistryDataRewriter().handle(packetWrapper.user(), string, registryEntryArray));
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.LOGIN, new PacketHandlers(){

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
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.map(Types.VAR_INT);
                this.handler(EntityPacketRewriter1_21_2.this.worldDataTrackerHandlerByKey1_20_5(3));
                this.handler(EntityPacketRewriter1_21_2.this.playerTrackerHandler());
                this.read(Types.VAR_INT);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.RESPAWN, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.read(Types.VAR_INT);
            Object e = this.tracker(packetWrapper.user());
            if (e.currentWorld() != null && !e.currentWorld().equals(string)) {
                packetWrapper.user().put(new SignStorage());
            }
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n, string);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.ENTITY_POSITION_SYNC, ClientboundPackets1_21.TELEPORT_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.read(Types.DOUBLE);
            packetWrapper.read(Types.DOUBLE);
            packetWrapper.read(Types.DOUBLE);
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            this.writePackedRotation(packetWrapper, f, f2);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLAYER_ROTATION, ClientboundPackets1_21.PLAYER_LOOK_AT, packetWrapper -> {
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            double d = Math.toRadians(f);
            double d2 = Math.toRadians(f2);
            double d3 = -Math.cos(-d2);
            double d4 = Math.sin(-d - 3.1415927410125732) * d3;
            double d5 = Math.sin(-d2);
            double d6 = Math.cos(-d - 3.1415927410125732) * d3;
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.DOUBLE, playerStorage.x() + d4);
            packetWrapper.write(Types.DOUBLE, playerStorage.y() + d5);
            packetWrapper.write(Types.DOUBLE, playerStorage.z() + d6);
            packetWrapper.write(Types.BOOLEAN, false);
            PacketWrapper packetWrapper2 = PacketWrapper.create(ServerboundPackets1_21_2.MOVE_PLAYER_ROT, packetWrapper.user());
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f2));
            packetWrapper2.write(Types.UNSIGNED_BYTE, (short)0);
            packetWrapper2.sendToServer(Protocol1_21_2To1_21.class);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.TELEPORT_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            double d4 = packetWrapper.read(Types.DOUBLE);
            double d5 = packetWrapper.read(Types.DOUBLE);
            double d6 = packetWrapper.read(Types.DOUBLE);
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            this.writePackedRotation(packetWrapper, f, f2);
            int n2 = packetWrapper.read(Types.INT);
            packetWrapper.send(Protocol1_21_2To1_21.class);
            packetWrapper.cancel();
            this.handleRelativeArguments(packetWrapper, d, d2, d3, f, f2, n2, d4, d5, d6, n);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLAYER_POSITION, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            double d4 = packetWrapper.read(Types.DOUBLE);
            double d5 = packetWrapper.read(Types.DOUBLE);
            double d6 = packetWrapper.read(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            int n2 = packetWrapper.read(Types.INT);
            packetWrapper.write(Types.BYTE, (byte)n2);
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.send(Protocol1_21_2To1_21.class);
            packetWrapper.cancel();
            this.handleRelativeArguments(packetWrapper, d, d2, d3, f, f2, n2, d4, d5, d6, null);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLAYER_COMMAND, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            if (n == 0) {
                playerStorage.setPlayerCommandTrackedSneaking(true);
            } else if (n == 1) {
                playerStorage.setPlayerCommandTrackedSneaking(false);
            } else if (n == 3) {
                playerStorage.setPlayerCommandTrackedSprinting(true);
            } else if (n == 4) {
                playerStorage.setPlayerCommandTrackedSprinting(false);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLAYER_INPUT, packetWrapper -> {
            boolean bl;
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            byte by = packetWrapper.read(Types.BYTE);
            byte by2 = 0;
            if (f2 > 0.0f) {
                by2 = (byte)(by2 | 1);
            } else if (f2 < 0.0f) {
                by2 = (byte)(by2 | 2);
            }
            if (f > 0.0f) {
                by2 = (byte)(by2 | 4);
            } else if (f < 0.0f) {
                by2 = (byte)(by2 | 8);
            }
            if ((by & 1) != 0) {
                by2 = (byte)(by2 | 0x10);
            }
            boolean bl2 = bl = (by & 2) != 0;
            if (bl) {
                by2 = (byte)(by2 | 0x20);
            }
            packetWrapper.write(Types.BYTE, by2);
            this.sendSneakingPlayerCommand(packetWrapper, bl);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            this.fixOnGround(packetWrapper);
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            playerStorage.setPosition(d, d2, d3);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            this.fixOnGround(packetWrapper);
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            playerStorage.setPosition(d, d2, d3);
            playerStorage.setRotation(f, f2);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, packetWrapper -> {
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            this.fixOnGround(packetWrapper);
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            playerStorage.setRotation(f, f2);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_STATUS_ONLY, this::fixOnGround);
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_VEHICLE, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
            playerStorage.setPosition(d, d2, d3);
            playerStorage.setRotation(f, f2);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE, packetWrapper -> {
            int n;
            BitSet bitSet = packetWrapper.read(Types.PROFILE_ACTIONS_ENUM1_21_2);
            BitSet bitSet2 = new BitSet(6);
            for (n = 0; n < 6; ++n) {
                if (!bitSet.get(n)) continue;
                bitSet2.set(n);
            }
            packetWrapper.write(Types.PROFILE_ACTIONS_ENUM1_19_3, bitSet2);
            n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (bitSet.get(0)) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (bitSet.get(1) && packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.PROFILE_KEY);
                }
                if (bitSet.get(2)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(3)) {
                    packetWrapper.passthrough(Types.BOOLEAN);
                }
                if (bitSet.get(4)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(5)) {
                    Tag tag = packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG);
                    ((ComponentRewriterBase)((Protocol1_21_2To1_21)this.protocol).getComponentRewriter()).processTag(packetWrapper.user(), tag);
                }
                if (!bitSet.get(6)) continue;
                packetWrapper.read(Types.VAR_INT);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_PASSENGERS, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage != null && n == clientVehicleStorage.vehicleId()) {
                packetWrapper.user().remove(ClientVehicleStorage.class);
                this.sendSneakingPlayerCommand(packetWrapper, false);
            }
            int n2 = this.tracker(packetWrapper.user()).clientEntityId();
            for (int n3 : nArray) {
                if (n3 != n2) continue;
                packetWrapper.user().put(new ClientVehicleStorage(n));
                break;
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).appendClientbound(ClientboundPackets1_21_2.REMOVE_ENTITIES, packetWrapper -> {
            int[] nArray;
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage == null) {
                return;
            }
            for (int n : nArray = packetWrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0)) {
                if (n != clientVehicleStorage.vehicleId()) continue;
                packetWrapper.user().remove(ClientVehicleStorage.class);
                this.sendSneakingPlayerCommand(packetWrapper, false);
                break;
            }
        });
    }

    private void updateParticleFormat(CompoundTag compoundTag, String string) {
        if ("dust_color_transition".equals(string)) {
            this.replaceColor(compoundTag, "from_color");
            this.replaceColor(compoundTag, "to_color");
        } else if ("dust".equals(string)) {
            this.replaceColor(compoundTag, "color");
        }
    }

    private void replaceColor(CompoundTag compoundTag, String string) {
        IntTag intTag = compoundTag.getIntTag(string);
        if (intTag == null) {
            return;
        }
        int n = intTag.asInt();
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        compoundTag.put(string, new ListTag<FloatTag>(List.of(new FloatTag(f), new FloatTag(f2), new FloatTag(f3))));
    }

    private void writePackedRotation(PacketWrapper packetWrapper, float f, float f2) {
        packetWrapper.write(Types.BYTE, (byte)Math.floor(f * 256.0f / 360.0f));
        packetWrapper.write(Types.BYTE, (byte)Math.floor(f2 * 256.0f / 360.0f));
    }

    private void handleRelativeArguments(PacketWrapper packetWrapper, double d, double d2, double d3, float f, float f2, int n, double d4, double d5, double d6, @Nullable Integer n2) {
        PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
        if ((n & 1) != 0) {
            d += playerStorage.x();
        }
        if ((n & 2) != 0) {
            d2 += playerStorage.y();
        }
        if ((n & 4) != 0) {
            d3 += playerStorage.z();
        }
        if ((n & 8) != 0) {
            f += playerStorage.yaw();
        }
        if ((n & 0x10) != 0) {
            f2 += playerStorage.pitch();
        }
        if ((n & 0x100) != 0) {
            double d7 = Math.toRadians(playerStorage.yaw() - f);
            double d8 = Math.cos(d7);
            double d9 = Math.sin(d7);
            d4 = d4 * d8 + d6 * d9;
            d6 = d6 * d8 - d4 * d9;
            double d10 = Math.toRadians(playerStorage.pitch() - f2);
            double d11 = Math.cos(d10);
            double d12 = Math.sin(d10);
            d5 = d5 * d11 + d6 * d12;
            d6 = d6 * d11 - d5 * d12;
        }
        boolean bl = (n & 0x20) != 0;
        boolean bl2 = (n & 0x40) != 0;
        boolean bl3 = (n & 0x80) != 0;
        playerStorage.setPosition(d, d2, d3);
        playerStorage.setRotation(f, f2);
        if (bl && bl2 && bl3) {
            if (n2 != null && n2.intValue() != this.tracker(packetWrapper.user()).clientEntityId()) {
                return;
            }
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21.EXPLODE);
            packetWrapper2.write(Types.DOUBLE, 0.0);
            packetWrapper2.write(Types.DOUBLE, 20000.0);
            packetWrapper2.write(Types.DOUBLE, 0.0);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)d4));
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)d5));
            packetWrapper2.write(Types.FLOAT, Float.valueOf((float)d6));
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.write(VersionedTypes.V1_21.particle(), new Particle(0));
            packetWrapper2.write(VersionedTypes.V1_21.particle(), new Particle(0));
            packetWrapper2.write(Types.SOUND_EVENT, Holder.of(new SoundEvent("intentionally_empty", null)));
            packetWrapper2.send(Protocol1_21_2To1_21.class);
        } else if (!(bl || bl2 || bl3)) {
            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_21.SET_ENTITY_MOTION);
            packetWrapper3.write(Types.VAR_INT, n2 != null ? n2.intValue() : this.tracker(packetWrapper.user()).clientEntityId());
            packetWrapper3.write(Types.SHORT, VelocityUtil.toLegacyVelocity(d4));
            packetWrapper3.write(Types.SHORT, VelocityUtil.toLegacyVelocity(d5));
            packetWrapper3.write(Types.SHORT, VelocityUtil.toLegacyVelocity(d6));
            packetWrapper3.send(Protocol1_21_2To1_21.class);
        } else if (!this.warned) {
            ((Protocol1_21_2To1_21)this.protocol).getLogger().warning("Mixed combinations of relative and absolute delta movements are not supported for 1.21.1 players. This will result in incorrect movement for the player. ");
            this.warned = true;
        }
    }

    private void sendSneakingPlayerCommand(PacketWrapper packetWrapper, boolean bl) {
        PlayerStorage playerStorage = packetWrapper.user().get(PlayerStorage.class);
        if (playerStorage.setSneaking(bl)) {
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_21_2.PLAYER_COMMAND);
            packetWrapper2.write(Types.VAR_INT, this.tracker(packetWrapper.user()).clientEntityId());
            packetWrapper2.write(Types.VAR_INT, bl ? 0 : 1);
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.sendToServer(Protocol1_21_2To1_21.class);
        }
    }

    private int boatTypeFromEntityType(EntityType entityType) {
        if (entityType == EntityTypes1_21_2.OAK_BOAT) {
            return 0;
        }
        if (entityType == EntityTypes1_21_2.SPRUCE_BOAT) {
            return 1;
        }
        if (entityType == EntityTypes1_21_2.BIRCH_BOAT) {
            return 2;
        }
        if (entityType == EntityTypes1_21_2.JUNGLE_BOAT) {
            return 3;
        }
        if (entityType == EntityTypes1_21_2.ACACIA_BOAT) {
            return 4;
        }
        if (entityType == EntityTypes1_21_2.CHERRY_BOAT) {
            return 5;
        }
        if (entityType == EntityTypes1_21_2.DARK_OAK_BOAT) {
            return 6;
        }
        if (entityType == EntityTypes1_21_2.MANGROVE_BOAT) {
            return 7;
        }
        if (entityType == EntityTypes1_21_2.BAMBOO_RAFT) {
            return 8;
        }
        return 0;
    }

    private int chestBoatTypeFromEntityType(EntityType entityType) {
        if (entityType == EntityTypes1_21_2.OAK_CHEST_BOAT) {
            return 0;
        }
        if (entityType == EntityTypes1_21_2.SPRUCE_CHEST_BOAT) {
            return 1;
        }
        if (entityType == EntityTypes1_21_2.BIRCH_CHEST_BOAT) {
            return 2;
        }
        if (entityType == EntityTypes1_21_2.JUNGLE_CHEST_BOAT) {
            return 3;
        }
        if (entityType == EntityTypes1_21_2.ACACIA_CHEST_BOAT) {
            return 4;
        }
        if (entityType == EntityTypes1_21_2.CHERRY_CHEST_BOAT) {
            return 5;
        }
        if (entityType == EntityTypes1_21_2.DARK_OAK_CHEST_BOAT) {
            return 6;
        }
        if (entityType == EntityTypes1_21_2.MANGROVE_CHEST_BOAT) {
            return 7;
        }
        if (entityType == EntityTypes1_21_2.BAMBOO_CHEST_RAFT) {
            return 8;
        }
        return 0;
    }

    private void fixOnGround(PacketWrapper packetWrapper) {
        boolean bl = packetWrapper.read(Types.BOOLEAN);
        packetWrapper.write(Types.UNSIGNED_BYTE, bl ? (short)1 : 0);
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler1_20_3(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).itemType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).blockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particleType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).particlesType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).componentType, ((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_2.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_2.CREAKING).cancel(17);
        this.filter().type(EntityTypes1_21_2.CREAKING).cancel(16);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_BOAT).addIndex(11);
        this.filter().type(EntityTypes1_21_2.SALMON).removeIndex(17);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_ARROW).removeIndex(10);
        EntityScaleHelper entityScaleHelper = new EntityScaleHelper(this, ClientboundPackets1_21.UPDATE_ATTRIBUTES);
        entityScaleHelper.addBabyScale(EntityTypes1_21_2.SQUID, 0.5f, 16);
        entityScaleHelper.addBabyScale(EntityTypes1_21_2.GLOW_SQUID, 0.5f, 16);
        entityScaleHelper.addBabyScale(EntityTypes1_21_2.DOLPHIN, 0.65f, 16);
        this.filter().type(EntityTypes1_21_2.AGEABLE_WATER_CREATURE).removeIndex(16);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_2.getTypeFromId(n);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_21_2.CREAKING, EntityTypes1_21_2.WARDEN).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_2.CREAKING_TRANSIENT, EntityTypes1_21_2.WARDEN).tagName();
    }
}

