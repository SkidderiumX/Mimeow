/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import joptsimple.AbstractOptionSpec;
import joptsimple.AlternativeLongOptionSpec;
import joptsimple.ArgumentList;
import joptsimple.BuiltinHelpFormatter;
import joptsimple.HelpFormatter;
import joptsimple.MissingRequiredOptionException;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionDeclarer;
import joptsimple.OptionException;
import joptsimple.OptionParserState;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.OptionSpecBuilder;
import joptsimple.OptionSpecTokenizer;
import joptsimple.ParserRules;
import joptsimple.UnconfiguredOptionException;
import joptsimple.internal.AbbreviationMap;
import joptsimple.util.KeyValuePair;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OptionParser
implements OptionDeclarer {
    private final AbbreviationMap<AbstractOptionSpec<?>> recognizedOptions;
    private final Map<Collection<String>, Set<OptionSpec<?>>> requiredIf;
    private final Map<Collection<String>, Set<OptionSpec<?>>> requiredUnless;
    private OptionParserState state;
    private boolean posixlyCorrect;
    private boolean allowsUnrecognizedOptions;
    private HelpFormatter helpFormatter = new BuiltinHelpFormatter();

    public OptionParser() {
        this.recognizedOptions = new AbbreviationMap();
        this.requiredIf = new HashMap();
        this.requiredUnless = new HashMap();
        this.state = OptionParserState.moreOptions(false);
        this.recognize(new NonOptionArgumentSpec());
    }

    public OptionParser(String string) {
        this();
        new OptionSpecTokenizer(string).configure(this);
    }

    @Override
    public OptionSpecBuilder accepts(String string) {
        return this.acceptsAll(Collections.singletonList(string));
    }

    @Override
    public OptionSpecBuilder accepts(String string, String string2) {
        return this.acceptsAll(Collections.singletonList(string), string2);
    }

    @Override
    public OptionSpecBuilder acceptsAll(Collection<String> collection) {
        return this.acceptsAll(collection, "");
    }

    @Override
    public OptionSpecBuilder acceptsAll(Collection<String> collection, String string) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("need at least one option");
        }
        ParserRules.ensureLegalOptions(collection);
        return new OptionSpecBuilder(this, collection, string);
    }

    @Override
    public NonOptionArgumentSpec<String> nonOptions() {
        NonOptionArgumentSpec<String> nonOptionArgumentSpec = new NonOptionArgumentSpec<String>();
        this.recognize(nonOptionArgumentSpec);
        return nonOptionArgumentSpec;
    }

    @Override
    public NonOptionArgumentSpec<String> nonOptions(String string) {
        NonOptionArgumentSpec<String> nonOptionArgumentSpec = new NonOptionArgumentSpec<String>(string);
        this.recognize(nonOptionArgumentSpec);
        return nonOptionArgumentSpec;
    }

    @Override
    public void posixlyCorrect(boolean bl) {
        this.posixlyCorrect = bl;
        this.state = OptionParserState.moreOptions(bl);
    }

    boolean posixlyCorrect() {
        return this.posixlyCorrect;
    }

    @Override
    public void allowsUnrecognizedOptions() {
        this.allowsUnrecognizedOptions = true;
    }

    boolean doesAllowsUnrecognizedOptions() {
        return this.allowsUnrecognizedOptions;
    }

    @Override
    public void recognizeAlternativeLongOptions(boolean bl) {
        if (bl) {
            this.recognize(new AlternativeLongOptionSpec());
        } else {
            this.recognizedOptions.remove(String.valueOf("W"));
        }
    }

    void recognize(AbstractOptionSpec<?> abstractOptionSpec) {
        this.recognizedOptions.putAll(abstractOptionSpec.options(), abstractOptionSpec);
    }

    public void printHelpOn(OutputStream outputStream2) throws IOException {
        this.printHelpOn(new OutputStreamWriter(outputStream2));
    }

    public void printHelpOn(Writer writer) throws IOException {
        writer.write(this.helpFormatter.format(this.recognizedOptions.toJavaUtilMap()));
        writer.flush();
    }

    public void formatHelpWith(HelpFormatter helpFormatter) {
        if (helpFormatter == null) {
            throw new NullPointerException();
        }
        this.helpFormatter = helpFormatter;
    }

    public Map<String, OptionSpec<?>> recognizedOptions() {
        return new HashMap(this.recognizedOptions.toJavaUtilMap());
    }

    public OptionSet parse(String ... stringArray) {
        ArgumentList argumentList = new ArgumentList(stringArray);
        OptionSet optionSet = new OptionSet(this.recognizedOptions.toJavaUtilMap());
        optionSet.add(this.recognizedOptions.get("[arguments]"));
        while (argumentList.hasMore()) {
            this.state.handleArgument(this, argumentList, optionSet);
        }
        this.reset();
        this.ensureRequiredOptions(optionSet);
        return optionSet;
    }

    private void ensureRequiredOptions(OptionSet optionSet) {
        Collection<String> collection = this.missingRequiredOptions(optionSet);
        boolean bl = this.isHelpOptionPresent(optionSet);
        if (!collection.isEmpty() && !bl) {
            throw new MissingRequiredOptionException(collection);
        }
    }

    private Collection<String> missingRequiredOptions(OptionSet optionSet) {
        AbstractOptionSpec<?> abstractOptionSpec;
        HashSet<String> hashSet = new HashSet<String>();
        for (AbstractOptionSpec<?> abstractOptionSpec2 : this.recognizedOptions.toJavaUtilMap().values()) {
            if (!abstractOptionSpec2.isRequired() || optionSet.has(abstractOptionSpec2)) continue;
            hashSet.addAll(abstractOptionSpec2.options());
        }
        for (Map.Entry entry : this.requiredIf.entrySet()) {
            abstractOptionSpec = this.specFor((String)((Collection)entry.getKey()).iterator().next());
            if (!this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || optionSet.has(abstractOptionSpec)) continue;
            hashSet.addAll(abstractOptionSpec.options());
        }
        for (Map.Entry entry : this.requiredUnless.entrySet()) {
            abstractOptionSpec = this.specFor((String)((Collection)entry.getKey()).iterator().next());
            if (this.optionsHasAnyOf(optionSet, (Collection)entry.getValue()) || optionSet.has(abstractOptionSpec)) continue;
            hashSet.addAll(abstractOptionSpec.options());
        }
        return hashSet;
    }

    private boolean optionsHasAnyOf(OptionSet optionSet, Collection<OptionSpec<?>> collection) {
        for (OptionSpec<?> optionSpec : collection) {
            if (!optionSet.has(optionSpec)) continue;
            return true;
        }
        return false;
    }

    private boolean isHelpOptionPresent(OptionSet optionSet) {
        boolean bl = false;
        for (AbstractOptionSpec<?> abstractOptionSpec : this.recognizedOptions.toJavaUtilMap().values()) {
            if (!abstractOptionSpec.isForHelp() || !optionSet.has(abstractOptionSpec)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    void handleLongOptionToken(String string, ArgumentList argumentList, OptionSet optionSet) {
        KeyValuePair keyValuePair = OptionParser.parseLongOptionWithArgument(string);
        if (!this.isRecognized(keyValuePair.key)) {
            throw OptionException.unrecognizedOption(keyValuePair.key);
        }
        AbstractOptionSpec<?> abstractOptionSpec = this.specFor(keyValuePair.key);
        abstractOptionSpec.handleOption(this, argumentList, optionSet, keyValuePair.value);
    }

    void handleShortOptionToken(String string, ArgumentList argumentList, OptionSet optionSet) {
        KeyValuePair keyValuePair = OptionParser.parseShortOptionWithArgument(string);
        if (this.isRecognized(keyValuePair.key)) {
            this.specFor(keyValuePair.key).handleOption(this, argumentList, optionSet, keyValuePair.value);
        } else {
            this.handleShortOptionCluster(string, argumentList, optionSet);
        }
    }

    private void handleShortOptionCluster(String string, ArgumentList argumentList, OptionSet optionSet) {
        char[] cArray = OptionParser.extractShortOptionsFrom(string);
        this.validateOptionCharacters(cArray);
        for (int i = 0; i < cArray.length; ++i) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor(cArray[i]);
            if (abstractOptionSpec.acceptsArguments() && cArray.length > i + 1) {
                String string2 = String.valueOf(cArray, i + 1, cArray.length - 1 - i);
                abstractOptionSpec.handleOption(this, argumentList, optionSet, string2);
                break;
            }
            abstractOptionSpec.handleOption(this, argumentList, optionSet, null);
        }
    }

    void handleNonOptionArgument(String string, ArgumentList argumentList, OptionSet optionSet) {
        this.specFor("[arguments]").handleOption(this, argumentList, optionSet, string);
    }

    void noMoreOptions() {
        this.state = OptionParserState.noMoreOptions();
    }

    boolean looksLikeAnOption(String string) {
        return ParserRules.isShortOptionToken(string) || ParserRules.isLongOptionToken(string);
    }

    boolean isRecognized(String string) {
        return this.recognizedOptions.contains(string);
    }

    void requiredIf(Collection<String> collection, String string) {
        this.requiredIf(collection, this.specFor(string));
    }

    void requiredIf(Collection<String> collection, OptionSpec<?> optionSpec) {
        this.putRequiredOption(collection, optionSpec, this.requiredIf);
    }

    void requiredUnless(Collection<String> collection, String string) {
        this.requiredUnless(collection, this.specFor(string));
    }

    void requiredUnless(Collection<String> collection, OptionSpec<?> optionSpec) {
        this.putRequiredOption(collection, optionSpec, this.requiredUnless);
    }

    private void putRequiredOption(Collection<String> collection, OptionSpec<?> optionSpec, Map<Collection<String>, Set<OptionSpec<?>>> map) {
        for (String string : collection) {
            AbstractOptionSpec<?> abstractOptionSpec = this.specFor(string);
            if (abstractOptionSpec != null) continue;
            throw new UnconfiguredOptionException(collection);
        }
        Set<OptionSpec<?>> set = map.get(collection);
        if (set == null) {
            set = new HashSet();
            map.put(collection, set);
        }
        set.add(optionSpec);
    }

    private AbstractOptionSpec<?> specFor(char c) {
        return this.specFor(String.valueOf(c));
    }

    private AbstractOptionSpec<?> specFor(String string) {
        return this.recognizedOptions.get(string);
    }

    private void reset() {
        this.state = OptionParserState.moreOptions(this.posixlyCorrect);
    }

    private static char[] extractShortOptionsFrom(String string) {
        char[] cArray = new char[string.length() - 1];
        string.getChars(1, string.length(), cArray, 0);
        return cArray;
    }

    private void validateOptionCharacters(char[] cArray) {
        for (char c : cArray) {
            String string = String.valueOf(c);
            if (!this.isRecognized(string)) {
                throw OptionException.unrecognizedOption(string);
            }
            if (!this.specFor(string).acceptsArguments()) continue;
            return;
        }
    }

    private static KeyValuePair parseLongOptionWithArgument(String string) {
        return KeyValuePair.valueOf(string.substring(2));
    }

    private static KeyValuePair parseShortOptionWithArgument(String string) {
        return KeyValuePair.valueOf(string.substring(1));
    }
}

