/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_13;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.SNbtDeserializer_v1_12;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.StringReader_v1_12;

public class SNbtDeserializer_v1_13
extends SNbtDeserializer_v1_12 {
    @Override
    protected Tag readListOrArray(StringReader_v1_12 stringReader_v1_12) throws SNbtDeserializeException {
        if (stringReader_v1_12.canRead(3) && !this.isQuote(stringReader_v1_12.charAt(1)) && stringReader_v1_12.charAt(2) == ';') {
            return this.readArray(stringReader_v1_12);
        }
        return this.readList(stringReader_v1_12);
    }
}

