/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import joptsimple.AbstractOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NoArgumentOptionSpec
extends AbstractOptionSpec<Void> {
    NoArgumentOptionSpec(String string) {
        this(Collections.singletonList(string), "");
    }

    NoArgumentOptionSpec(Collection<String> collection, String string) {
        super(collection, string);
    }

    @Override
    void handleOption(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet, String string) {
        optionSet.add(this);
    }

    @Override
    public boolean acceptsArguments() {
        return false;
    }

    @Override
    public boolean requiresArgument() {
        return false;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public String argumentDescription() {
        return "";
    }

    @Override
    public String argumentTypeIndicator() {
        return "";
    }

    @Override
    protected Void convert(String string) {
        return null;
    }

    public List<Void> defaultValues() {
        return Collections.emptyList();
    }
}

