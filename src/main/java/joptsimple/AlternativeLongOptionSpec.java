/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collections;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionMissingRequiredArgumentException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AlternativeLongOptionSpec
extends ArgumentAcceptingOptionSpec<String> {
    AlternativeLongOptionSpec() {
        super(Collections.singletonList("W"), true, "Alternative form of long options");
        this.describedAs("opt=value");
    }

    @Override
    protected void detectOptionArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        if (!argumentList.hasMore()) {
            throw new OptionMissingRequiredArgumentException(this.options());
        }
        argumentList.treatNextAsLongOption();
    }
}

