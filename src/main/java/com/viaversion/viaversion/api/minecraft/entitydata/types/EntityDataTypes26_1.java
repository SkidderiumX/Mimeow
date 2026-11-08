/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.entitydata.types;

import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.AbstractEntityDataTypes;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class EntityDataTypes26_1
extends AbstractEntityDataTypes {
    public final EntityDataType byteType = this.add(0, Types.BYTE);
    public final EntityDataType varIntType = this.add(1, Types.VAR_INT);
    public final EntityDataType longType = this.add(2, Types.VAR_LONG);
    public final EntityDataType floatType = this.add(3, Types.FLOAT);
    public final EntityDataType stringType = this.add(4, Types.STRING);
    public final EntityDataType componentType = this.add(5, Types.TRUSTED_TAG);
    public final EntityDataType optionalComponentType = this.add(6, Types.TRUSTED_OPTIONAL_TAG);
    public final EntityDataType itemType;
    public final EntityDataType booleanType = this.add(8, Types.BOOLEAN);
    public final EntityDataType rotationsType = this.add(9, Types.ROTATIONS);
    public final EntityDataType blockPositionType = this.add(10, Types.BLOCK_POSITION1_14);
    public final EntityDataType optionalBlockPositionType = this.add(11, Types.OPTIONAL_POSITION_1_14);
    public final EntityDataType directionType = this.add(12, Types.VAR_INT);
    public final EntityDataType optionalUUIDType = this.add(13, Types.OPTIONAL_UUID);
    public final EntityDataType blockStateType = this.add(14, Types.VAR_INT);
    public final EntityDataType optionalBlockStateType = this.add(15, Types.VAR_INT);
    public final EntityDataType particleType;
    public final EntityDataType particlesType;
    public final EntityDataType villagerDataType = this.add(18, Types.VILLAGER_DATA);
    public final EntityDataType optionalVarIntType = this.add(19, Types.OPTIONAL_VAR_INT);
    public final EntityDataType poseType = this.add(20, Types.VAR_INT);
    public final EntityDataType catVariantType = this.add(21, Types.VAR_INT);
    public final EntityDataType catSoundVariant = this.add(22, Types.VAR_INT);
    public final EntityDataType cowVariantType = this.add(23, Types.VAR_INT);
    public final EntityDataType cowSoundVariant = this.add(24, Types.VAR_INT);
    public final EntityDataType wolfVariantType = this.add(25, Types.VAR_INT);
    public final EntityDataType wolfSoundVariantType = this.add(26, Types.VAR_INT);
    public final EntityDataType frogVariantType = this.add(27, Types.VAR_INT);
    public final EntityDataType pigVariantType = this.add(28, Types.VAR_INT);
    public final EntityDataType pigSoundVariant = this.add(29, Types.VAR_INT);
    public final EntityDataType chickenVariantType = this.add(30, Types.VAR_INT);
    public final EntityDataType chickenSoundVariant = this.add(31, Types.VAR_INT);
    public final EntityDataType zombieNautilusVariantType = this.add(32, Types.VAR_INT);
    public final EntityDataType optionalGlobalPosition = this.add(33, Types.OPTIONAL_GLOBAL_POSITION);
    public final EntityDataType paintingVariantType = this.add(34, PaintingVariant.TYPE1_21_2);
    public final EntityDataType snifferState = this.add(35, Types.VAR_INT);
    public final EntityDataType armadilloState = this.add(36, Types.VAR_INT);
    public final EntityDataType copperGolemState = this.add(37, Types.VAR_INT);
    public final EntityDataType weatheringCopperState = this.add(38, Types.VAR_INT);
    public final EntityDataType vector3FType = this.add(39, Types.VECTOR3F);
    public final EntityDataType quaternionType = this.add(40, Types.QUATERNION);
    public final EntityDataType mannequinProfileType = this.add(41, Types.RESOLVABLE_PROFILE);
    public final EntityDataType humanoidArmType = this.add(42, Types.VAR_INT);

    public EntityDataTypes26_1(VersionedTypesHolder versionedTypesHolder) {
        super(43);
        this.itemType = this.add(7, versionedTypesHolder.item());
        this.particleType = this.add(16, versionedTypesHolder.particle());
        this.particlesType = this.add(17, versionedTypesHolder.particles());
    }
}

