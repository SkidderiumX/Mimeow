/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collections;
import joptsimple.OptionException;

public class UnacceptableNumberOfNonOptionsException
extends OptionException {
    private static final long serialVersionUID = -1L;
    private final int minimum;
    private final int maximum;
    private final int actual;

    UnacceptableNumberOfNonOptionsException(int n, int n2, int n3) {
        super(Collections.singletonList("[arguments]"));
        this.minimum = n;
        this.maximum = n2;
        this.actual = n3;
    }

    public String getMessage() {
        return String.format("actual = %d, minimum = %d, maximum = %d", this.actual, this.minimum, this.maximum);
    }
}

