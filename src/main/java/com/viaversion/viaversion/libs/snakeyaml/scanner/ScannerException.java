/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.scanner;

import com.viaversion.viaversion.libs.snakeyaml.error.Mark;
import com.viaversion.viaversion.libs.snakeyaml.error.MarkedYAMLException;

public class ScannerException
extends MarkedYAMLException {
    private static final long serialVersionUID = 4782293188600445954L;

    public ScannerException(String string, Mark mark, String string2, Mark mark2, String string3) {
        super(string, mark, string2, mark2, string3);
    }

    public ScannerException(String string, Mark mark, String string2, Mark mark2) {
        this(string, mark, string2, mark2, (String)null);
    }
}

