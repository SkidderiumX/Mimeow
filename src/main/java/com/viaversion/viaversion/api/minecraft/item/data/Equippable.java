/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderSetType;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Equippable(int equipmentSlot, Holder<SoundEvent> soundEvent, @Nullable String model, @Nullable String cameraOverlay, @Nullable HolderSet allowedEntities, boolean dispensable, boolean swappable, boolean damageOnHurt, boolean equipOnInteract, boolean canBeSheared, Holder<SoundEvent> shearingSound) implements Rewritable
{
    public static final Type<Equippable> TYPE1_21_2 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object object = Types.SOUND_EVENT.read(byteBuf);
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            String string2 = (String)Types.OPTIONAL_STRING.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            boolean bl2 = byteBuf.readBoolean();
            boolean bl3 = byteBuf.readBoolean();
            return new Equippable(n, (Holder<SoundEvent>)object, string, string2, holderSet, bl, bl2, bl3);
        }

        @Override
        public void write(ByteBuf byteBuf, Equippable equippable) {
            Types.VAR_INT.writePrimitive(byteBuf, equippable.equipmentSlot());
            Types.SOUND_EVENT.write(byteBuf, equippable.soundEvent());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.model());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, equippable.allowedEntities());
            byteBuf.writeBoolean(equippable.dispensable());
            byteBuf.writeBoolean(equippable.swappable());
            byteBuf.writeBoolean(equippable.damageOnHurt());
        }
    };
    public static final Type<Equippable> TYPE1_21_5 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object object = Types.SOUND_EVENT.read(byteBuf);
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            String string2 = (String)Types.OPTIONAL_STRING.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            boolean bl2 = byteBuf.readBoolean();
            boolean bl3 = byteBuf.readBoolean();
            boolean bl4 = byteBuf.readBoolean();
            return new Equippable(n, (Holder<SoundEvent>)object, string, string2, holderSet, bl, bl2, bl3, bl4);
        }

        @Override
        public void write(ByteBuf byteBuf, Equippable equippable) {
            Types.VAR_INT.writePrimitive(byteBuf, equippable.equipmentSlot());
            Types.SOUND_EVENT.write(byteBuf, equippable.soundEvent());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.model());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, equippable.allowedEntities());
            byteBuf.writeBoolean(equippable.dispensable());
            byteBuf.writeBoolean(equippable.swappable());
            byteBuf.writeBoolean(equippable.damageOnHurt());
            byteBuf.writeBoolean(equippable.equipOnInteract());
        }

        @Override
        public void write(Ops ops, Equippable equippable) {
            Holder<int> holder = Holder.of(ops.context().registryAccess().id(MappingData.MappingType.SOUND, "item.armor.equip_generic"));
            ops.writeMap(mapSerializer -> mapSerializer.write("slot", EnumTypes.EQUIPMENT_SLOT, equippable.equipmentSlot).writeOptional("equip_sound", Types.SOUND_EVENT, equippable.soundEvent, holder).writeOptional("asset_id", Types.IDENTIFIER, equippable.model != null ? Key.of(equippable.model) : null).writeOptional("camera_overlay", Types.IDENTIFIER, equippable.cameraOverlay != null ? Key.of(equippable.cameraOverlay) : null).writeOptional("allowed_entities", new HolderSetType(MappingData.MappingType.ENTITY_TYPE), equippable.allowedEntities).writeOptional("dispensable", Types.BOOLEAN, equippable.dispensable, true).writeOptional("swappable", Types.BOOLEAN, equippable.swappable, true).writeOptional("damage_on_hurt", Types.BOOLEAN, equippable.damageOnHurt, true).writeOptional("equip_on_interact", Types.BOOLEAN, equippable.equipOnInteract, false));
        }
    };
    public static final Type<Equippable> TYPE1_21_6 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object object = Types.SOUND_EVENT.read(byteBuf);
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            String string2 = (String)Types.OPTIONAL_STRING.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            boolean bl2 = byteBuf.readBoolean();
            boolean bl3 = byteBuf.readBoolean();
            boolean bl4 = byteBuf.readBoolean();
            boolean bl5 = byteBuf.readBoolean();
            Object object2 = Types.SOUND_EVENT.read(byteBuf);
            return new Equippable(n, (Holder<SoundEvent>)object, string, string2, holderSet, bl, bl2, bl3, bl4, bl5, (Holder<SoundEvent>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, Equippable equippable) {
            Types.VAR_INT.writePrimitive(byteBuf, equippable.equipmentSlot());
            Types.SOUND_EVENT.write(byteBuf, equippable.soundEvent());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.model());
            Types.OPTIONAL_STRING.write(byteBuf, equippable.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, equippable.allowedEntities());
            byteBuf.writeBoolean(equippable.dispensable());
            byteBuf.writeBoolean(equippable.swappable());
            byteBuf.writeBoolean(equippable.damageOnHurt());
            byteBuf.writeBoolean(equippable.equipOnInteract());
            byteBuf.writeBoolean(equippable.canBeSheared());
            Types.SOUND_EVENT.write(byteBuf, equippable.shearingSound());
        }

        @Override
        public void write(Ops ops, Equippable equippable) {
            Holder<int> holder = Holder.of(ops.context().registryAccess().id(MappingData.MappingType.SOUND, "item.armor.equip_generic"));
            Holder<int> holder2 = Holder.of(ops.context().registryAccess().id(MappingData.MappingType.SOUND, "item.shears.snip"));
            ops.writeMap(mapSerializer -> mapSerializer.write("slot", EnumTypes.EQUIPMENT_SLOT, equippable.equipmentSlot).writeOptional("equip_sound", Types.SOUND_EVENT, equippable.soundEvent, holder).writeOptional("asset_id", Types.IDENTIFIER, equippable.model != null ? Key.of(equippable.model) : null).writeOptional("camera_overlay", Types.IDENTIFIER, equippable.cameraOverlay != null ? Key.of(equippable.cameraOverlay) : null).writeOptional("allowed_entities", new HolderSetType(MappingData.MappingType.ENTITY_TYPE), equippable.allowedEntities).writeOptional("dispensable", Types.BOOLEAN, equippable.dispensable, true).writeOptional("swappable", Types.BOOLEAN, equippable.swappable, true).writeOptional("damage_on_hurt", Types.BOOLEAN, equippable.damageOnHurt, true).writeOptional("equip_on_interact", Types.BOOLEAN, equippable.equipOnInteract, false).writeOptional("can_be_sheared", Types.BOOLEAN, equippable.canBeSheared, false).writeOptional("shearing_sound", Types.SOUND_EVENT, equippable.shearingSound, holder2));
        }
    };

    public Equippable(int n, Holder<SoundEvent> holder, @Nullable String string, @Nullable String string2, @Nullable HolderSet holderSet, boolean bl, boolean bl2, boolean bl3) {
        this(n, holder, string, string2, holderSet, bl, bl2, bl3, true);
    }

    public Equippable(int n, Holder<SoundEvent> holder, @Nullable String string, @Nullable String string2, @Nullable HolderSet holderSet, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this(n, holder, string, string2, holderSet, bl, bl2, bl3, bl4, false, Holder.of(false));
    }

    @Override
    public Equippable rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, bl));
        Holder<SoundEvent> holder2 = SoundEvent.rewriteHolder(this.shearingSound, Rewritable.soundRewriteFunction(protocol, bl));
        HolderSet holderSet = this.allowedEntities != null ? this.allowedEntities.rewrite(Rewritable.entityRewriteFunction(protocol, bl)) : null;
        return holder == this.soundEvent && holder2 == this.shearingSound && holderSet == this.allowedEntities ? this : new Equippable(this.equipmentSlot, holder, this.model, this.cameraOverlay, holderSet, this.dispensable, this.swappable, this.damageOnHurt, this.equipOnInteract, this.canBeSheared, holder2);
    }
}

