/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Objects;

public record AttributeModifiers1_21(AttributeModifier[] modifiers, boolean showInTooltip) implements Copyable,
Rewritable
{
    public static final Type<AttributeModifiers1_21> TYPE1_21 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf byteBuf) {
            AttributeModifier[] attributeModifierArray = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new AttributeModifiers1_21(attributeModifierArray, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, AttributeModifiers1_21 attributeModifiers1_21) {
            AttributeModifier.ARRAY_TYPE1_21.write(byteBuf, attributeModifiers1_21.modifiers());
            byteBuf.writeBoolean(attributeModifiers1_21.showInTooltip());
        }
    };
    public static final Type<AttributeModifiers1_21> TYPE1_21_5 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf byteBuf) {
            AttributeModifier[] attributeModifierArray = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21.read(byteBuf);
            return new AttributeModifiers1_21(attributeModifierArray);
        }

        @Override
        public void write(ByteBuf byteBuf, AttributeModifiers1_21 attributeModifiers1_21) {
            AttributeModifier.ARRAY_TYPE1_21.write(byteBuf, attributeModifiers1_21.modifiers());
        }

        @Override
        public void write(Ops ops, AttributeModifiers1_21 attributeModifiers1_21) {
            ops.write(AttributeModifier.ARRAY_TYPE1_21, attributeModifiers1_21.modifiers);
        }
    };
    public static final Type<AttributeModifiers1_21> TYPE1_21_6 = new Type<AttributeModifiers1_21>(AttributeModifiers1_21.class){

        @Override
        public AttributeModifiers1_21 read(ByteBuf byteBuf) {
            AttributeModifier[] attributeModifierArray = (AttributeModifier[])AttributeModifier.ARRAY_TYPE1_21_6.read(byteBuf);
            return new AttributeModifiers1_21(attributeModifierArray);
        }

        @Override
        public void write(ByteBuf byteBuf, AttributeModifiers1_21 attributeModifiers1_21) {
            AttributeModifier.ARRAY_TYPE1_21_6.write(byteBuf, attributeModifiers1_21.modifiers());
        }

        @Override
        public void write(Ops ops, AttributeModifiers1_21 attributeModifiers1_21) {
            ops.write(AttributeModifier.ARRAY_TYPE1_21_6, attributeModifiers1_21.modifiers);
        }
    };

    public AttributeModifiers1_21(AttributeModifier[] attributeModifierArray) {
        this(attributeModifierArray, true);
    }

    public AttributeModifiers1_21 rewrite(Int2IntFunction int2IntFunction) {
        AttributeModifier[] attributeModifierArray = new AttributeModifier[this.modifiers.length];
        for (int i = 0; i < this.modifiers.length; ++i) {
            AttributeModifier attributeModifier = this.modifiers[i];
            attributeModifierArray[i] = new AttributeModifier(int2IntFunction.applyAsInt(attributeModifier.attribute()), attributeModifier.modifier(), attributeModifier.slotType(), attributeModifier.display());
        }
        return new AttributeModifiers1_21(attributeModifierArray, this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_21 copy() {
        return new AttributeModifiers1_21(Copyable.copy(this.modifiers), this.showInTooltip);
    }

    @Override
    public AttributeModifiers1_21 rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        FullMappings fullMappings = protocol.getMappingData().getAttributeMappings();
        if (fullMappings == null) {
            return this;
        }
        ArrayList<AttributeModifier> arrayList = new ArrayList<AttributeModifier>(this.modifiers.length);
        for (AttributeModifier attributeModifier : this.modifiers) {
            int n;
            int n2 = n = bl ? fullMappings.getNewId(attributeModifier.attribute()) : fullMappings.inverse().getNewId(attributeModifier.attribute());
            if (n == -1) continue;
            arrayList.add(new AttributeModifier(n, attributeModifier.modifier(), attributeModifier.slotType(), attributeModifier.display()));
        }
        return new AttributeModifiers1_21((AttributeModifier[])arrayList.toArray(AttributeModifier[]::new), this.showInTooltip);
    }

    public record AttributeModifier(int attribute, ModifierData modifier, int slotType, Display display) {
        private static final String[] EQUIPMENT_SLOT_GROUPS = new String[]{"any", "mainhand", "offhand", "hand", "feet", "legs", "chest", "head", "armor", "body", "saddle"};
        private static final String[] OPERATION = new String[]{"add_value", "add_multiplied_base", "add_multiplied_total"};
        public static final Type<AttributeModifier> TYPE1_21 = new Type<AttributeModifier>(AttributeModifier.class){

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

            @Override
            public void write(Ops ops, AttributeModifier attributeModifier) {
                Key key = ops.context().registryAccess().attributeModifier(attributeModifier.attribute);
                ops.writeMap(mapSerializer -> mapSerializer.write("type", Types.IDENTIFIER, key).write("id", Types.IDENTIFIER, Key.of(attributeModifier.modifier.id())).write("amount", Types.DOUBLE, attributeModifier.modifier.amount).write("operation", Types.STRING, OPERATION[attributeModifier.modifier.operation()]).writeOptional("slot", Types.STRING, EQUIPMENT_SLOT_GROUPS[attributeModifier.slotType()], "any"));
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE1_21 = new ArrayType<AttributeModifier>(TYPE1_21);
        public static final Type<AttributeModifier> TYPE1_21_6 = new Type<AttributeModifier>(AttributeModifier.class){

            @Override
            public AttributeModifier read(ByteBuf byteBuf) {
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                ModifierData modifierData = (ModifierData)ModifierData.TYPE.read(byteBuf);
                int n2 = Types.VAR_INT.readPrimitive(byteBuf);
                int n3 = Types.VAR_INT.readPrimitive(byteBuf);
                Display display = n3 == 2 ? new OverrideText((Tag)Types.TAG.read(byteBuf)) : new Display(n3);
                return new AttributeModifier(n, modifierData, n2, display);
            }

            @Override
            public void write(ByteBuf byteBuf, AttributeModifier attributeModifier) {
                Types.VAR_INT.writePrimitive(byteBuf, attributeModifier.attribute);
                ModifierData.TYPE.write(byteBuf, attributeModifier.modifier);
                Types.VAR_INT.writePrimitive(byteBuf, attributeModifier.slotType);
                attributeModifier.display.write(byteBuf);
            }

            @Override
            public void write(Ops ops, AttributeModifier attributeModifier) {
                Key key = ops.context().registryAccess().attributeModifier(attributeModifier.attribute);
                ops.writeMap(mapSerializer2 -> {
                    mapSerializer2.write("type", Types.IDENTIFIER, key).write("id", Types.IDENTIFIER, Key.of(attributeModifier.modifier.id())).write("amount", Types.DOUBLE, attributeModifier.modifier.amount).write("operation", Types.STRING, OPERATION[attributeModifier.modifier.operation()]).writeOptional("slot", Types.STRING, EQUIPMENT_SLOT_GROUPS[attributeModifier.slotType()], "any");
                    if (attributeModifier.display.equals(Display.DEFAULT)) {
                        return;
                    }
                    mapSerializer2.writeMap("display", mapSerializer -> {
                        mapSerializer.write("type", Types.STRING, Display.DISPLAY_TYPES[attributeModifier.display.id()]);
                        Display display = attributeModifier.display;
                        if (display instanceof OverrideText) {
                            OverrideText overrideText = (OverrideText)display;
                            mapSerializer.write("value", Types.TEXT_COMPONENT_TAG, overrideText.component);
                        }
                    });
                });
            }
        };
        public static final Type<AttributeModifier[]> ARRAY_TYPE1_21_6 = new ArrayType<AttributeModifier>(TYPE1_21_6);

        public AttributeModifier(int n, ModifierData modifierData, int n2) {
            this(n, modifierData, n2, Display.DEFAULT);
        }
    }

    public record ModifierData(String id, double amount, int operation) {
        public static final Type<ModifierData> TYPE = new Type<ModifierData>(ModifierData.class){

            @Override
            public ModifierData read(ByteBuf byteBuf) {
                String string = (String)Types.STRING.read(byteBuf);
                double d = byteBuf.readDouble();
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                return new ModifierData(string, d, n);
            }

            @Override
            public void write(ByteBuf byteBuf, ModifierData modifierData) {
                Types.STRING.write(byteBuf, modifierData.id);
                byteBuf.writeDouble(modifierData.amount);
                Types.VAR_INT.writePrimitive(byteBuf, modifierData.operation);
            }
        };
    }

    public static class Display
    implements Copyable {
        public static final String[] DISPLAY_TYPES = new String[]{"default", "hidden", "override"};
        public static final Display DEFAULT = new Display(0);
        private final int id;

        public Display(int n) {
            this.id = n;
        }

        public int id() {
            return this.id;
        }

        public void write(ByteBuf byteBuf) {
            Types.VAR_INT.writePrimitive(byteBuf, this.id);
        }

        @Override
        public Display copy() {
            return this;
        }

        public boolean equals(Object object) {
            if (!(object instanceof Display)) {
                return false;
            }
            Display display = (Display)object;
            return this.id == display.id;
        }

        public int hashCode() {
            return this.id;
        }
    }

    public static final class OverrideText
    extends Display {
        public static final int ID = 2;
        private final Tag component;

        public OverrideText(Tag tag) {
            super(2);
            this.component = tag;
        }

        public Tag component() {
            return this.component;
        }

        @Override
        public void write(ByteBuf byteBuf) {
            super.write(byteBuf);
            Types.TAG.write(byteBuf, this.component);
        }

        @Override
        public OverrideText copy() {
            return new OverrideText(this.component.copy());
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof OverrideText)) {
                return false;
            }
            OverrideText overrideText = (OverrideText)object;
            if (!super.equals(object)) {
                return false;
            }
            return Objects.equals(this.component, overrideText.component);
        }

        @Override
        public int hashCode() {
            int n = super.hashCode();
            n = 31 * n + Objects.hashCode(this.component);
            return n;
        }
    }
}

