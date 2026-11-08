/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OptionalArgumentOptionSpec<V>
extends ArgumentAcceptingOptionSpec<V> {
    OptionalArgumentOptionSpec(String string) {
        super(string, false);
    }

    OptionalArgumentOptionSpec(Collection<String> collection, String string) {
        super(collection, false, string);
    }

    @Override
    protected void detectOptionArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
        if (argumentList.hasMore()) {
            String string = argumentList.peek();
            if (!optionParser.looksLikeAnOption(string)) {
                this.handleOptionArgument(optionParser, optionSet, argumentList);
            } else if (this.isArgumentOfNumberType() && this.canConvertArgument(string)) {
                this.addArguments(optionSet, argumentList.next());
            } else {
                optionSet.add(this);
            }
        } else {
            optionSet.add(this);
        }
    }

    private void handleOptionArgument(OptionParser optionParser, OptionSet optionSet, ArgumentList argumentList) {
        if (optionParser.posixlyCorrect()) {
            optionSet.add(this);
            optionParser.noMoreOptions();
        } else {
            this.addArguments(optionSet, argumentList.next());
        }
    }
}

