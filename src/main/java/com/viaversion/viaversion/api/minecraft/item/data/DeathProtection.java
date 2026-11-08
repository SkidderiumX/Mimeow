/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;

public record DeathProtection(Consumable1_21_2.ConsumeEffect<?>[] deathEffects) implements Copyable
{
    public static final Type<DeathProtection> TYPE = new TransformingType<Consumable1_21_2.ConsumeEffect<?>[], DeathProtection>(Consumable1_21_2.ConsumeEffect.ARRAY_TYPE, DeathProtection.class, DeathProtection::new, DeathProtection::deathEffects){

        @Override
        public void write(Ops ops, DeathProtection deathProtection) {
            ops.writeMap(mapSerializer -> mapSerializer.write("death_effects", Consumable1_21_2.ConsumeEffect.ARRAY_TYPE, deathProtection.deathEffects));
        }
    };

    @Override
    public DeathProtection copy() {
        return new DeathProtection(Copyable.copy(this.deathEffects));
    }
}

