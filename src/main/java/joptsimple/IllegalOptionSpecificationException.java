/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collections;
import joptsimple.OptionException;

public class IllegalOptionSpecificationException
extends OptionException {
    private static final long serialVersionUID = -1L;

    IllegalOptionSpecificationException(String string) {
        super(Collections.singletonList(string));
    }

    public String getMessage() {
        return this.singleOptionMessage() + " is not a legal option character";
    }
}

