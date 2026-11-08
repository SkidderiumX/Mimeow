/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.TagType;
import java.util.Map;
import java.util.Set;

public class TextComponentTagType
extends TagType {
    private static final Set<String> BOOLEAN_KEYS = Set.of("bold", "italic", "underlined", "strikethrough", "obfuscated", "interpret");

    @Override
    public void write(Ops ops, Tag tag) {
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            ops.writeMap(mapSerializer -> {
                for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                    this.write((Ops.MapSerializer)mapSerializer, entry.getKey(), entry.getValue());
                }
            });
        } else {
            super.write(ops, tag);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void write(Ops.MapSerializer mapSerializer, String string, Tag tag) {
        if (tag instanceof ByteTag) {
            ByteTag byteTag = (ByteTag)tag;
            if (BOOLEAN_KEYS.contains(string)) {
                mapSerializer.write(string, Types.BOOLEAN, byteTag.asBoolean());
                return;
            }
        }
        mapSerializer.write(string, this, tag);
    }
}

