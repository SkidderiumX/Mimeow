/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;

public record DamageResistant1_21_2(Key typesTagKey) {
    public static final Type<DamageResistant1_21_2> TYPE = new TransformingType<Key, DamageResistant1_21_2>(Types.IDENTIFIER, DamageResistant1_21_2.class, DamageResistant1_21_2::new, DamageResistant1_21_2::typesTagKey){

        @Override
        public void write(Ops ops, DamageResistant1_21_2 damageResistant1_21_2) {
            ops.writeMap(mapSerializer -> mapSerializer.write("types", Types.TAG_KEY, damageResistant1_21_2.typesTagKey));
        }
    };
}

