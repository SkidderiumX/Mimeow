/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.EitherType;
import com.viaversion.viaversion.util.Either;

public record DamageType(Either<Integer, String> id) {
    public static final Type<DamageType> TYPE1_21_11 = TransformingType.of(new EitherType<Integer, String>(Types.VAR_INT, Types.STRING), DamageType.class, DamageType::new, DamageType::id);
}

