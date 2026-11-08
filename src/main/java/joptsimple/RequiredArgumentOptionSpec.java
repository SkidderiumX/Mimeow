/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionMissingRequiredArgumentException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RequiredArgumentOptionSpec<V>
extends ArgumentAcceptingOptionSpec<V> {
    RequiredArgumentOptionSpec(String string) {
        super(string, true);
    }

    RequiredArgumentOptionSpec(Collection<String> collection, String string) {
        super(collection, true, string);
    }

    @Override
    protected void detectOptionArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        if (!argumentList.hasMore()) {
            throw new OptionMissingRequiredArgumentException(this.options());
        }
        this.addArguments(optionSet, argumentList.next());
    }
}

