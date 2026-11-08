/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.exceptions;

import com.viaversion.nbt.tag.Tag;

public class SNbtSerializeException
extends Exception {
    public SNbtSerializeException(Tag tag) {
        super("Unable to serialize nbt type " + tag.getClass().getSimpleName());
    }
}

