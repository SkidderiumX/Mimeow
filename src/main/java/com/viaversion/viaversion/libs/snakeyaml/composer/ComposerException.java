/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.composer;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.error.MarkedYAMLException;

public class ComposerException
extends MarkedYAMLException {
    private static final long serialVersionUID = 2146314636913113935L;

    protected ComposerException(String string, Mark mark, String string2, Mark mark2) {
        super(string, mark, string2, mark2);
    }

    protected ComposerException(String string, Mark mark) {
        this(null, null, string, mark);
    }
}

