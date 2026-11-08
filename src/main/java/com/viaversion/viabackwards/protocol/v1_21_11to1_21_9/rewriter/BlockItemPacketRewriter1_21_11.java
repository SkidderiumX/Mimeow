/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.Protocol1_21_11To1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.storage.GameTimeStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttackRange;
import com.viaversion.viaversion.api.minecraft.item.data.DamageType;
import com.viaversion.viaversion.api.minecraft.item.data.KineticWeapon;
import com.viaversion.viaversion.api.minecraft.item.data.PiercingWeapon;
import com.viaversion.viaversion.api.minecraft.item.data.SwingAnimation;
import com.viaversion.viaversion.api.minecraft.item.data.UseEffects;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.util.Either;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_21_11
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_11, ServerboundPacket1_21_9, Protocol1_21_11To1_21_9> {
    public BlockItemPacketRewriter1_21_11(Protocol1_21_11To1_21_9 protocol1_21_11To1_21_9) {
        super(protocol1_21_11To1_21_9);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.SET_BORDER_LERP_SIZE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.VAR_LONG, packetWrapper.read(Types.VAR_LONG) * 50L);
        });
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.INITIALIZE_BORDER, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.VAR_LONG, packetWrapper.read(Types.VAR_LONG) * 50L);
        });
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.SET_TIME, packetWrapper -> {
            long l = packetWrapper.passthrough(Types.LONG);
            packetWrapper.user().get(GameTimeStorage.class).setGameTime(l);
        });
        ((Protocol1_21_11To1_21_9)this.protocol).registerServerbound(ServerboundPackets1_21_6.CLIENT_TICK_END, packetWrapper -> packetWrapper.user().get(GameTimeStorage.class).incrementGameTime());
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter.BlockItemPacketRewriter1_21_11.downgradeData(item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter.BlockItemPacketRewriter1_21_11.upgradeData(item, structuredDataContainer);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Tag tag;
        CompoundTag compoundTag2;
        Tag tag2;
        CompoundTag compoundTag3;
        float f;
        float f2;
        KineticWeapon.Condition condition;
        Object object;
        Object object2;
        int n;
        CompoundTag compoundTag4;
        int n2;
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        Tag tag3 = compoundTag.remove(this.nbtTagName("backup"));
        if (!(tag3 instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag5 = (CompoundTag)tag3;
        tag3 = compoundTag5.getCompoundTag("swing_animation");
        if (tag3 != null) {
            int n3 = ((CompoundTag)tag3).getInt("type");
            n2 = ((CompoundTag)tag3).getInt("duration");
            structuredDataContainer.set(StructuredDataKey.SWING_ANIMATION, new SwingAnimation(n3, n2));
        }
        if ((compoundTag4 = compoundTag5.getCompoundTag("kinetic_weapon")) != null) {
            n2 = compoundTag4.getInt("contact_cooldown_ticks");
            n = compoundTag4.getInt("delay_ticks");
            object2 = this.loadDamageCondition(compoundTag4, "damage_conditions");
            object = this.loadDamageCondition(compoundTag4, "dismount_conditions");
            condition = this.loadDamageCondition(compoundTag4, "knockback_conditions");
            f2 = compoundTag4.getFloat("forward_movement");
            f = compoundTag4.getFloat("damage_multiplier");
            Holder<SoundEvent> holder = compoundTag4.contains("sound") ? this.restoreSoundEventHolder(compoundTag4, "sound") : null;
            Holder<SoundEvent> holder2 = compoundTag4.contains("hit_sound") ? this.restoreSoundEventHolder(compoundTag4, "hit_sound") : null;
            structuredDataContainer.set(StructuredDataKey.KINETIC_WEAPON, new KineticWeapon(n2, n, (KineticWeapon.Condition)object2, (KineticWeapon.Condition)object, condition, f2, f, holder, holder2));
        }
        if ((compoundTag3 = compoundTag5.getCompoundTag("piercing_weapon")) != null) {
            n = compoundTag3.getBoolean("deals_knockback") ? 1 : 0;
            boolean bl = compoundTag3.getBoolean("dismounts");
            object = compoundTag3.contains("sound") ? this.restoreSoundEventHolder(compoundTag3, "sound") : null;
            condition = compoundTag3.contains("hit_sound") ? this.restoreSoundEventHolder(compoundTag3, "hit_sound") : null;
            structuredDataContainer.set(StructuredDataKey.PIERCING_WEAPON, new PiercingWeapon(n != 0, bl, (Holder<SoundEvent>)object, (Holder<SoundEvent>)((Object)condition)));
        }
        if ((tag2 = compoundTag5.get("damage_type_id")) != null) {
            if (tag2 instanceof StringTag) {
                object2 = (StringTag)tag2;
                structuredDataContainer.set(StructuredDataKey.DAMAGE_TYPE1_21_11, new DamageType(Either.right(((StringTag)object2).getValue())));
            } else if (tag2 instanceof IntTag) {
                object = (IntTag)tag2;
                structuredDataContainer.set(StructuredDataKey.DAMAGE_TYPE1_21_11, new DamageType(Either.left(((IntTag)object).asInt())));
            }
        }
        if ((object2 = compoundTag5.getCompoundTag("use_effects")) != null) {
            boolean bl = ((CompoundTag)object2).getBoolean("can_sprint");
            boolean bl2 = ((CompoundTag)object2).getBoolean("interact_vibrations");
            f2 = ((CompoundTag)object2).getFloat("speed_multiplier");
            structuredDataContainer.set(StructuredDataKey.USE_EFFECTS, new UseEffects(bl, bl2, f2));
        }
        if ((compoundTag2 = compoundTag5.getCompoundTag("attack_range")) != null) {
            float f3 = compoundTag2.getFloat("min_range");
            f2 = compoundTag2.getFloat("max_range");
            f = compoundTag2.getFloat("min_creative_reach");
            float f4 = compoundTag2.getFloat("max_creative_reach");
            float f5 = compoundTag2.getFloat("hitbox_margin");
            float f6 = compoundTag2.getFloat("mob_factor");
            structuredDataContainer.set(StructuredDataKey.ATTACK_RANGE, new AttackRange(f3, f2, f, f4, f5, f6));
        }
        if ((tag = compoundTag5.get("zombie_nautilus_variant")) != null) {
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag)tag;
                structuredDataContainer.set(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11, Either.right(stringTag.getValue()));
            } else if (tag instanceof IntTag) {
                IntTag intTag = (IntTag)tag;
                structuredDataContainer.set(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11, Either.left(intTag.asInt()));
            }
        }
        this.restoreFloatData(StructuredDataKey.MINIMUM_ATTACK_CHARGE, structuredDataContainer, compoundTag5);
    }

    private KineticWeapon.Condition loadDamageCondition(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 == null) {
            return null;
        }
        int n = compoundTag2.getInt("max_duration_ticks");
        float f = compoundTag2.getFloat("min_speed");
        float f2 = compoundTag2.getFloat("min_relative_speed");
        return new KineticWeapon.Condition(n, f, f2);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag2) {
        Object object;
        Object object2;
        UseEffects useEffects;
        Object object3;
        Object object4;
        Object object5;
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag2);
        SwingAnimation swingAnimation = structuredDataContainer.get(StructuredDataKey.SWING_ANIMATION);
        if (swingAnimation != null) {
            object5 = new CompoundTag();
            ((CompoundTag)object5).putInt("type", swingAnimation.type());
            ((CompoundTag)object5).putInt("duration", swingAnimation.duration());
            compoundTag2.put("swing_animation", (Tag)object5);
        }
        if ((object5 = structuredDataContainer.get(StructuredDataKey.KINETIC_WEAPON)) != null) {
            object4 = new CompoundTag();
            ((CompoundTag)object4).putInt("contact_cooldown_ticks", ((KineticWeapon)object5).contactCooldownTicks());
            ((CompoundTag)object4).putInt("delay_ticks", ((KineticWeapon)object5).delayTicks());
            this.saveDamageCondition((CompoundTag)object4, "damage_conditions", ((KineticWeapon)object5).damageConditions());
            this.saveDamageCondition((CompoundTag)object4, "dismount_conditions", ((KineticWeapon)object5).dismountConditions());
            this.saveDamageCondition((CompoundTag)object4, "knockback_conditions", ((KineticWeapon)object5).knockbackConditions());
            ((CompoundTag)object4).putFloat("forward_movement", ((KineticWeapon)object5).forwardMovement());
            ((CompoundTag)object4).putFloat("damage_multiplier", ((KineticWeapon)object5).damageMultiplier());
            if (((KineticWeapon)object5).sound() != null) {
                ((CompoundTag)object4).put("sound", this.holderToTag(((KineticWeapon)object5).sound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
            if (((KineticWeapon)object5).hitSound() != null) {
                ((CompoundTag)object4).put("hit_sound", this.holderToTag(((KineticWeapon)object5).hitSound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
            compoundTag2.put("kinetic_weapon", (Tag)object4);
        }
        if ((object4 = structuredDataContainer.get(StructuredDataKey.PIERCING_WEAPON)) != null) {
            object3 = new CompoundTag();
            ((CompoundTag)object3).putBoolean("deals_knockback", ((PiercingWeapon)object4).dealsKnockback());
            ((CompoundTag)object3).putBoolean("dismounts", ((PiercingWeapon)object4).dismounts());
            if (((PiercingWeapon)object4).sound() != null) {
                ((CompoundTag)object3).put("sound", this.holderToTag(((PiercingWeapon)object4).sound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
            if (((PiercingWeapon)object4).hitSound() != null) {
                ((CompoundTag)object3).put("hit_sound", this.holderToTag(((PiercingWeapon)object4).hitSound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
            compoundTag2.put("piercing_weapon", (Tag)object3);
        }
        if ((object3 = structuredDataContainer.get(StructuredDataKey.DAMAGE_TYPE1_21_11)) != null) {
            if (((DamageType)object3).id().isLeft()) {
                compoundTag2.putInt("damage_type_id", ((DamageType)object3).id().left());
            } else {
                compoundTag2.putString("damage_type_id", ((DamageType)object3).id().right());
            }
        }
        if ((useEffects = structuredDataContainer.get(StructuredDataKey.USE_EFFECTS)) != null) {
            object2 = new CompoundTag();
            ((CompoundTag)object2).putBoolean("can_sprint", useEffects.canSprint());
            ((CompoundTag)object2).putBoolean("interact_vibrations", useEffects.interactVibrations());
            ((CompoundTag)object2).putFloat("speed_multiplier", useEffects.speedMultiplier());
            compoundTag2.put("use_effects", (Tag)object2);
        }
        if ((object2 = structuredDataContainer.get(StructuredDataKey.ATTACK_RANGE)) != null) {
            object = new CompoundTag();
            ((CompoundTag)object).putFloat("min_range", ((AttackRange)object2).minRange());
            ((CompoundTag)object).putFloat("max_range", ((AttackRange)object2).maxRange());
            ((CompoundTag)object).putFloat("min_creative_reach", ((AttackRange)object2).minCreativeRange());
            ((CompoundTag)object).putFloat("max_creative_reach", ((AttackRange)object2).maxCreativeRange());
            ((CompoundTag)object).putFloat("hitbox_margin", ((AttackRange)object2).hitboxMargin());
            ((CompoundTag)object).putFloat("mob_factor", ((AttackRange)object2).mobFactor());
            compoundTag2.put("attack_range", (Tag)object);
        }
        if ((object = structuredDataContainer.get(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11)) != null) {
            if (object.isLeft()) {
                compoundTag2.putInt("zombie_nautilus_variant", (Integer)object.left());
            } else {
                compoundTag2.putString("zombie_nautilus_variant", (String)object.right());
            }
        }
        this.saveFloatData(StructuredDataKey.MINIMUM_ATTACK_CHARGE, structuredDataContainer, compoundTag2);
    }

    private void saveDamageCondition(CompoundTag compoundTag, String string, @Nullable KineticWeapon.Condition condition) {
        if (condition == null) {
            return;
        }
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putInt("max_duration_ticks", condition.maxDurationTicks());
        compoundTag2.putFloat("min_speed", condition.minSpeed());
        compoundTag2.putFloat("min_relative_speed", condition.minRelativeSpeed());
        compoundTag.put(string, compoundTag2);
    }
}

