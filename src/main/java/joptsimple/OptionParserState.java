/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import joptsimple.ArgumentList;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.ParserRules;
import joptsimple.UnrecognizedOptionException;

public abstract class OptionParserState {
    OptionParserState() {
    }

    static OptionParserState noMoreOptions() {
        return new OptionParserState(){

            protected void handleArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
                optionParser.handleNonOptionArgument(argumentList.next(), argumentList, optionSet);
            }
        };
    }

    static OptionParserState moreOptions(final boolean bl) {
        return new OptionParserState(){

            protected void handleArgument(OptionParser optionParser, ArgumentList argumentList, OptionSet optionSet) {
                String string;
                block6: {
                    string = argumentList.next();
                    try {
                        if (ParserRules.isOptionTerminator(string)) {
                            optionParser.noMoreOptions();
                            return;
                        }
                        if (ParserRules.isLongOptionToken(string)) {
                            optionParser.handleLongOptionToken(string, argumentList, optionSet);
                            return;
                        }
                        if (ParserRules.isShortOptionToken(string)) {
                            optionParser.handleShortOptionToken(string, argumentList, optionSet);
                            return;
                        }
                    }
                    catch (UnrecognizedOptionException unrecognizedOptionException) {
                        if (optionParser.doesAllowsUnrecognizedOptions()) break block6;
                        throw unrecognizedOptionException;
                    }
                }
                if (bl) {
                    optionParser.noMoreOptions();
                }
                optionParser.handleNonOptionArgument(string, argumentList, optionSet);
            }
        };
    }

    protected abstract void handleArgument(OptionParser var1, ArgumentList var2, OptionSet var3);
}

