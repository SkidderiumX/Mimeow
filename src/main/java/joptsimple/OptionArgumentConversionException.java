/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import joptsimple.OptionException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OptionArgumentConversionException
extends OptionException {
    private static final long serialVersionUID = -1L;
    private final String argument;

    OptionArgumentConversionException(Collection<String> collection, String string, Throwable throwable) {
        super(collection, throwable);
        this.argument = string;
    }

    @Override
    public String getMessage() {
        return "Cannot parse argument '" + this.argument + "' of option " + this.multipleOptionMessage();
    }
}

