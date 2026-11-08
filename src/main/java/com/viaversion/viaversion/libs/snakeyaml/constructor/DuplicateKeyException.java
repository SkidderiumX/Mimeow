/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.constructor;

import com.viaversion.viaversion.libs.snakeyaml.constructor.ConstructorException;
import com.viaversion.viaversion.libs.snakeyaml.error.Mark;

public class DuplicateKeyException
extends ConstructorException {
    protected DuplicateKeyException(Mark mark, Object object, Mark mark2) {
        super("while constructing a mapping", mark, "found duplicate key " + object, mark2);
    }
}

