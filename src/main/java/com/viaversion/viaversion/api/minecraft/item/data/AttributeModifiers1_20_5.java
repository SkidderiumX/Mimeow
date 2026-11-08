/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.UUID;

public record AttributeModifiers1_20_5(AttributeModifier[] modifiers, boolean showInTooltip) implements Copyable,
Rewritable
{
    public static final Type<AttributeModifiers1_20_5> TYPE = new Type<AttributeModifiers1_20_5>(AttributeModifiers1_20_5.class){

        @Override
        public AttributeModifiers1_20_5 read(ByteBuf byteBuf) {
            AttributeModifier[] attributeModifierArray = (AttributeModifier[])AttributeModifier.ARRAY_TYPE.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new AttributeModifiers1_20_5(attributeModifierArray, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, AttributeModifiers1_20_5 attributeModifiers1_20_5) {
            AttributeModifier.ARRAY_TYPE.write(byteBuf, attributeModifiers1_20_5.modifiers());
            byteBuf.writeBoolean(attributeModifiers1_20_5.showInTooltip());
        }
    };

    @Override
    public AttributeModifiers1_20_5 copy() {
        return new AttributeModifiers1_20_5(Copyable.copy(this.modifiers), this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_20_5 rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        FullMappings fullMappings = protocol.getMappingData().getAttributeMappings();
        if (fullMappings == null) {
            return this;
        }
        ArrayList<AttributeModifier> arrayList = new ArrayList<AttributeModifier>(this.modifiers.length);
        for (AttributeModifier attributeModifier : this.modifiers) {
            int n;
            int n2 = n = bl ? fullMappings.getNewId(attributeModifier.attribute()) : fullMappings.inverse().getNewId(attributeModifier.attribute());
            if (n == -1) continue;
            arrayList.add(new AttributeModifier(n, attributeModifier.modifier(), attributeModifier.slotType()));
        }
        return new AttributeModifiers1_20_5((AttributeModifier[])arrayList.toArray(AttributeModifier[]::new), this.showInTooltip);
    }

    public record AttributeModifier(int attribute, ModifierData modifier, int slotType) {
        public static final Type<AttributeModifier> TYPE = new Type<AttributeModifier>(AttributeModifier.class){

            @Override
            public AttributeModifier read(ByteBuf byteBuf) {
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                ModifierData modifierData = (ModifierData)ModifierData.TYPE.read(byteBuf);
                int n2 = Types.VAR_INT.readPrimitive(byteBuf);
                return new AttributeModifier(n, modifierData, n2);
            }

            @Override
            public void write(ByteBuf byteBuf, AttributeModifier attributeModifier) {
                Types.VAR_INT.writePrimitive(byteBuf, attributeModifier.attribute);
                ModifierData.TYPE.write(byteBuf, attributeModifier.modifier);
                Types.VAR_INT.writePrimitive(byteBuf, attributeModifier.slotType);
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE = new ArrayType<AttributeModifier>(TYPE);
    }

    public record ModifierData(UUID uuid, String name, double amount, int operation) {
        public static final Type<ModifierData> TYPE = new Type<ModifierData>(ModifierData.class){

            @Override
            public ModifierData read(ByteBuf byteBuf) {
                UUID uUID = (UUID)Types.UUID.read(byteBuf);
                String string = (String)Types.STRING.read(byteBuf);
                double d = byteBuf.readDouble();
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                return new ModifierData(uUID, string, d, n);
            }

            @Override
            public void write(ByteBuf byteBuf, ModifierData modifierData) {
                Types.UUID.write(byteBuf, modifierData.uuid);
                Types.STRING.write(byteBuf, modifierData.name);
                byteBuf.writeDouble(modifierData.amount);
                Types.VAR_INT.writePrimitive(byteBuf, modifierData.operation);
            }
        };
    }
}

