/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import joptsimple.UnrecognizedOptionException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class OptionException
extends RuntimeException {
    private static final long serialVersionUID = -1L;
    private final List<String> options = new ArrayList<String>();

    protected OptionException(Collection<String> collection) {
        this.options.addAll(collection);
    }

    protected OptionException(Collection<String> collection, Throwable throwable) {
        super(throwable);
        this.options.addAll(collection);
    }

    public Collection<String> options() {
        return Collections.unmodifiableCollection(this.options);
    }

    protected final String singleOptionMessage() {
        return this.singleOptionMessage(this.options.get(0));
    }

    protected final String singleOptionMessage(String string) {
        return "'" + string + "'";
    }

    protected final String multipleOptionMessage() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator<String> iterator2 = this.options.iterator();
        while (iterator2.hasNext()) {
            stringBuilder.append(this.singleOptionMessage(iterator2.next()));
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    static OptionException unrecognizedOption(String string) {
        return new UnrecognizedOptionException(string);
    }
}

