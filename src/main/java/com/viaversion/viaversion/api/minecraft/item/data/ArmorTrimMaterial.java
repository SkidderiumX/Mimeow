/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Map;

public record ArmorTrimMaterial(String assetName, int itemId, float itemModelIndex, Map<String, String> overrideArmorMaterials, Tag description) implements Copyable,
Rewritable
{
    public static final HolderType<ArmorTrimMaterial> TYPE1_20_5 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            Object2ObjectArrayMap<String, String> object2ObjectArrayMap = new Object2ObjectArrayMap<String, String>();
            for (int i = 0; i < n2; ++i) {
                int n3 = Types.VAR_INT.readPrimitive(byteBuf);
                String string2 = (String)Types.STRING.read(byteBuf);
                object2ObjectArrayMap.put(Integer.toString(n3), string2);
            }
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new ArmorTrimMaterial(string, n, f, object2ObjectArrayMap, tag);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimMaterial armorTrimMaterial) {
            Types.STRING.write(byteBuf, armorTrimMaterial.assetName());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.itemId());
            byteBuf.writeFloat(armorTrimMaterial.itemModelIndex());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials().entrySet()) {
                Types.VAR_INT.writePrimitive(byteBuf, Integer.parseInt(entry.getKey()));
                Types.STRING.write(byteBuf, entry.getValue());
            }
            Types.TAG.write(byteBuf, armorTrimMaterial.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_2 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = byteBuf.readFloat();
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            Object2ObjectArrayMap<String, String> object2ObjectArrayMap = new Object2ObjectArrayMap<String, String>();
            for (int i = 0; i < n2; ++i) {
                String string2 = (String)Types.STRING.read(byteBuf);
                String string3 = (String)Types.STRING.read(byteBuf);
                object2ObjectArrayMap.put(string2, string3);
            }
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new ArmorTrimMaterial(string, n, f, object2ObjectArrayMap, tag);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimMaterial armorTrimMaterial) {
            Types.STRING.write(byteBuf, armorTrimMaterial.assetName());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.itemId());
            byteBuf.writeFloat(armorTrimMaterial.itemModelIndex());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(byteBuf, entry.getKey());
                Types.STRING.write(byteBuf, entry.getValue());
            }
            Types.TAG.write(byteBuf, armorTrimMaterial.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_4 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            Object2ObjectArrayMap<String, String> object2ObjectArrayMap = new Object2ObjectArrayMap<String, String>();
            for (int i = 0; i < n2; ++i) {
                String string2 = (String)Types.STRING.read(byteBuf);
                String string3 = (String)Types.STRING.read(byteBuf);
                object2ObjectArrayMap.put(string2, string3);
            }
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new ArmorTrimMaterial(string, n, object2ObjectArrayMap, tag);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimMaterial armorTrimMaterial) {
            Types.STRING.write(byteBuf, armorTrimMaterial.assetName());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.itemId());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(byteBuf, entry.getKey());
                Types.STRING.write(byteBuf, entry.getValue());
            }
            Types.TAG.write(byteBuf, armorTrimMaterial.description());
        }
    };
    public static final HolderType<ArmorTrimMaterial> TYPE1_21_5 = new HolderType<ArmorTrimMaterial>(){

        @Override
        public ArmorTrimMaterial readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object2ObjectArrayMap<String, String> object2ObjectArrayMap = new Object2ObjectArrayMap<String, String>();
            for (int i = 0; i < n; ++i) {
                String string2 = (String)Types.STRING.read(byteBuf);
                String string3 = (String)Types.STRING.read(byteBuf);
                object2ObjectArrayMap.put(string2, string3);
            }
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new ArmorTrimMaterial(string, object2ObjectArrayMap, tag);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimMaterial armorTrimMaterial) {
            Types.STRING.write(byteBuf, armorTrimMaterial.assetName());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimMaterial.overrideArmorMaterials().size());
            for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials().entrySet()) {
                Types.STRING.write(byteBuf, entry.getKey());
                Types.STRING.write(byteBuf, entry.getValue());
            }
            Types.TAG.write(byteBuf, armorTrimMaterial.description());
        }

        @Override
        public void writeDirect(Ops ops, ArmorTrimMaterial armorTrimMaterial) {
            ops.writeMap(mapSerializer2 -> {
                mapSerializer2.write("asset_name", Types.STRING, armorTrimMaterial.assetName());
                if (!armorTrimMaterial.overrideArmorMaterials.isEmpty()) {
                    mapSerializer2.writeMap("override_armor_assets", mapSerializer -> {
                        for (Map.Entry<String, String> entry : armorTrimMaterial.overrideArmorMaterials.entrySet()) {
                            mapSerializer.write(Types.IDENTIFIER, Key.of(entry.getKey()), Types.STRING, entry.getValue());
                        }
                    });
                }
                mapSerializer2.write("description", Types.TEXT_COMPONENT_TAG, armorTrimMaterial.description());
            });
        }

        @Override
        protected Key identifier(Ops ops, int n) {
            return ops.context().registryAccess().registryKey("trim_material", n);
        }
    };

    public ArmorTrimMaterial(String string, int n, Map<String, String> map, Tag tag) {
        this(string, n, 0.0f, map, tag);
    }

    public ArmorTrimMaterial(String string, Map<String, String> map, Tag tag) {
        this(string, 0, 0.0f, map, tag);
    }

    @Override
    public ArmorTrimMaterial rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return new ArmorTrimMaterial(this.assetName, Rewritable.rewriteItem(protocol, bl, this.itemId), this.itemModelIndex, this.overrideArmorMaterials, this.description);
    }

    @Override
    public ArmorTrimMaterial copy() {
        return new ArmorTrimMaterial(this.assetName, this.itemId, this.itemModelIndex, new Object2ObjectArrayMap<String, String>(this.overrideArmorMaterials), this.description);
    }
}

