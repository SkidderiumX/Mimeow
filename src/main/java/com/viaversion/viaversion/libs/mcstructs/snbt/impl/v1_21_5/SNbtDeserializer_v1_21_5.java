/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_21_5;

import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.StringReader_v1_12;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_14.SNbtDeserializer_v1_14;
import java.util.ArrayList;

public class SNbtDeserializer_v1_21_5
extends SNbtDeserializer_v1_14 {
    @Override
    protected ListTag<Tag> readList(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        stringReader_v1_12.jumpTo('[');
        stringReader_v1_12.skipWhitespaces();
        if (!stringReader_v1_12.canRead()) {
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        while (stringReader_v1_12.peek() != ']') {
            arrayList.add(this.readValue(stringReader_v1_12));
            if (!this.hasNextValue(stringReader_v1_12)) break;
            if (stringReader_v1_12.canRead()) continue;
            throw this.makeException(stringReader_v1_12, "Expected value");
        }
        stringReader_v1_12.jumpTo(']');
        return null;
    }
}

