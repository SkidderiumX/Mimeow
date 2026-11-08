/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.helpers.Charsets;
import org.apache.logging.log4j.core.helpers.OptionConverter;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternFormatter;
import org.apache.logging.log4j.core.pattern.PatternParser;
import org.apache.logging.log4j.core.pattern.RegexReplacement;

@Plugin(name="PatternLayout", category="Core", elementType="layout", printObject=true)
public class PatternLayout
extends AbstractStringLayout {
    public static final String DEFAULT_CONVERSION_PATTERN = "%m%n";
    public static final String TTCC_CONVERSION_PATTERN = "%r [%t] %p %c %x - %m%n";
    public static final String SIMPLE_CONVERSION_PATTERN = "%d [%t] %p %c - %m%n";
    public static final String KEY = "Converter";
    private List<PatternFormatter> formatters;
    private final String conversionPattern;
    private final Configuration config;
    private final RegexReplacement replace;
    private final boolean alwaysWriteExceptions;

    private PatternLayout(Configuration configuration, RegexReplacement regexReplacement, String string, Charset charset, boolean bl) {
        super(charset);
        this.replace = regexReplacement;
        this.conversionPattern = string;
        this.config = configuration;
        this.alwaysWriteExceptions = bl;
        PatternParser patternParser = PatternLayout.createPatternParser(configuration);
        this.formatters = patternParser.parse(string == null ? DEFAULT_CONVERSION_PATTERN : string, this.alwaysWriteExceptions);
    }

    public void setConversionPattern(String string) {
        String string2 = OptionConverter.convertSpecialChars(string);
        if (string2 == null) {
            return;
        }
        PatternParser patternParser = PatternLayout.createPatternParser(this.config);
        this.formatters = patternParser.parse(string2, this.alwaysWriteExceptions);
    }

    public String getConversionPattern() {
        return this.conversionPattern;
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("structured", "false");
        hashMap.put("formatType", "conversion");
        hashMap.put("format", this.conversionPattern);
        return hashMap;
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PatternFormatter patternFormatter : this.formatters) {
            patternFormatter.format(logEvent, stringBuilder);
        }
        Object object = stringBuilder.toString();
        if (this.replace != null) {
            object = this.replace.format((String)object);
        }
        return object;
    }

    public static PatternParser createPatternParser(Configuration configuration) {
        if (configuration == null) {
            return new PatternParser(configuration, KEY, LogEventPatternConverter.class);
        }
        PatternParser patternParser = (PatternParser)configuration.getComponent(KEY);
        if (patternParser == null) {
            patternParser = new PatternParser(configuration, KEY, LogEventPatternConverter.class);
            configuration.addComponent(KEY, patternParser);
            patternParser = (PatternParser)configuration.getComponent(KEY);
        }
        return patternParser;
    }

    public String toString() {
        return this.conversionPattern;
    }

    @PluginFactory
    public static PatternLayout createLayout(@PluginAttribute(value="pattern") String string, @PluginConfiguration Configuration configuration, @PluginElement(value="Replace") RegexReplacement regexReplacement, @PluginAttribute(value="charset") String string2, @PluginAttribute(value="alwaysWriteExceptions") String string3) {
        Charset charset = Charsets.getSupportedCharset(string2);
        boolean bl = Booleans.parseBoolean(string3, true);
        return new PatternLayout(configuration, regexReplacement, string == null ? DEFAULT_CONVERSION_PATTERN : string, charset, bl);
    }
}

