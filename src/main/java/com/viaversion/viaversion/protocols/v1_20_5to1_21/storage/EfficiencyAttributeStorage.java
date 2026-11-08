/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import java.util.List;
import java.util.stream.Stream;

public class EfficiencyAttributeStorage
implements StorableObject {
    private static final EnchantAttributeModifier EFFICIENCY = new EnchantAttributeModifier("minecraft:enchantment.efficiency/mainhand", 19, 0.0, n -> n * n + 1);
    private static final EnchantAttributeModifier SOUL_SPEED = new EnchantAttributeModifier("minecraft:enchantment.soul_speed", 21, 0.1, n -> 0.04 + (double)(n - 1) * 0.01);
    private static final EnchantAttributeModifier SWIFT_SNEAK = new EnchantAttributeModifier("minecraft:enchantment.swift_sneak", 25, 0.3, n -> (double)n * 0.15);
    private static final EnchantAttributeModifier AQUA_AFFINITY = new EnchantAttributeModifier("minecraft:enchantment.aqua_affinity", 28, 0.2, n -> n * 4, 2);
    private static final EnchantAttributeModifier DEPTH_STRIDER = new EnchantAttributeModifier("minecraft:enchantment.depth_strider", 30, 0.0, n -> (double)n / 3.0);
    private static final ActiveEnchants DEFAULT = new ActiveEnchants(-1, new ActiveEnchant(EFFICIENCY, 0, 0), new ActiveEnchant(SOUL_SPEED, 0, 0), new ActiveEnchant(SWIFT_SNEAK, 0, 0), new ActiveEnchant(AQUA_AFFINITY, 0, 0), new ActiveEnchant(DEPTH_STRIDER, 0, 0));
    private final Object lock = new Object();
    private volatile boolean attributesSent = true;
    private volatile boolean loginSent;
    private ActiveEnchants activeEnchants = DEFAULT;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEnchants(int n, UserConnection userConnection, ActiveEnchants activeEnchants) {
        if (this.activeEnchants == activeEnchants) {
            return;
        }
        Object object = this.lock;
        synchronized (object) {
            this.activeEnchants = n == -1 ? activeEnchants : activeEnchants.withEntityId(n);
            this.attributesSent = false;
        }
        this.sendAttributesPacket(userConnection, false);
    }

    public ActiveEnchants activeEnchants() {
        return this.activeEnchants;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onLoginSent(int n, UserConnection userConnection) {
        Object object = this.lock;
        synchronized (object) {
            this.activeEnchants = this.activeEnchants.withEntityId(n);
        }
        this.loginSent = true;
        this.sendAttributesPacket(userConnection, false);
    }

    public void onRespawn(UserConnection userConnection) {
        this.sendAttributesPacket(userConnection, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendAttributesPacket(UserConnection userConnection, boolean bl) {
        ActiveEnchants activeEnchants;
        Object object = this.lock;
        synchronized (object) {
            if (!(bl || this.loginSent && !this.attributesSent)) {
                return;
            }
            activeEnchants = this.activeEnchants;
            this.attributesSent = true;
        }
        object = PacketWrapper.create(ClientboundPackets1_21.UPDATE_ATTRIBUTES, userConnection);
        object.write(Types.VAR_INT, activeEnchants.entityId());
        List<ActiveEnchant> list = Stream.of(activeEnchants.efficiency(), activeEnchants.soulSpeed(), activeEnchants.swiftSneak(), activeEnchants.aquaAffinity(), activeEnchants.depthStrider()).filter(activeEnchant -> bl || activeEnchant.previousLevel != activeEnchant.level).toList();
        object.write(Types.VAR_INT, list.size());
        for (ActiveEnchant activeEnchant2 : list) {
            EnchantAttributeModifier enchantAttributeModifier = activeEnchant2.modifier;
            object.write(Types.VAR_INT, enchantAttributeModifier.attributeId);
            object.write(Types.DOUBLE, enchantAttributeModifier.baseValue);
            if (activeEnchant2.level > 0) {
                object.write(Types.VAR_INT, 1);
                object.write(Types.STRING, enchantAttributeModifier.key);
                object.write(Types.DOUBLE, activeEnchant2.modifier.modifierFunction.get(activeEnchant2.level));
                object.write(Types.BYTE, enchantAttributeModifier.operation);
                continue;
            }
            object.write(Types.VAR_INT, 0);
        }
        object.scheduleSend(Protocol1_20_5To1_21.class);
    }

    public record ActiveEnchants(int entityId, ActiveEnchant efficiency, ActiveEnchant soulSpeed, ActiveEnchant swiftSneak, ActiveEnchant aquaAffinity, ActiveEnchant depthStrider) {
        private ActiveEnchants withEntityId(int n) {
            return this.entityId == n ? this : new ActiveEnchants(n, this.efficiency, this.soulSpeed, this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants efficiency(int n) {
            return this.efficiency.level == n ? this : new ActiveEnchants(this.entityId, new ActiveEnchant(this.efficiency, n), this.soulSpeed, this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants soulSpeed(int n) {
            return this.soulSpeed.level == n ? this : new ActiveEnchants(this.entityId, this.efficiency, new ActiveEnchant(this.soulSpeed, n), this.swiftSneak, this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants swiftSneak(int n) {
            return this.swiftSneak.level == n ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, new ActiveEnchant(this.swiftSneak, n), this.aquaAffinity, this.depthStrider);
        }

        public ActiveEnchants aquaAffinity(int n) {
            return this.aquaAffinity.level == n ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, this.swiftSneak, new ActiveEnchant(this.aquaAffinity, n), this.depthStrider);
        }

        public ActiveEnchants depthStrider(int n) {
            return this.depthStrider.level == n ? this : new ActiveEnchants(this.entityId, this.efficiency, this.soulSpeed, this.swiftSneak, this.aquaAffinity, new ActiveEnchant(this.depthStrider, n));
        }
    }

    public record ActiveEnchant(EnchantAttributeModifier modifier, int previousLevel, int level) {
        public ActiveEnchant(ActiveEnchant activeEnchant, int n) {
            this(activeEnchant.modifier, activeEnchant.level, n);
        }
    }

    public record EnchantAttributeModifier(String key, int attributeId, double baseValue, LevelToModifier modifierFunction, byte operation) {
        private EnchantAttributeModifier(String string, int n, double d, LevelToModifier levelToModifier) {
            this(string, n, d, levelToModifier, 0);
        }
    }

    @FunctionalInterface
    private static interface LevelToModifier {
        public double get(int var1);
    }
}

