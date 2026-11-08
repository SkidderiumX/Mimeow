/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.helpers.Constants;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.ThrowablePatternConverter;

@Plugin(name="RootThrowablePatternConverter", category="Converter")
@ConverterKeys(value={"rEx", "rThrowable", "rException"})
public class RootThrowablePatternConverter
extends ThrowablePatternConverter {
    private RootThrowablePatternConverter(String[] stringArray) {
        super("RootThrowable", "throwable", stringArray);
    }

    public static RootThrowablePatternConverter newInstance(String[] stringArray) {
        return new RootThrowablePatternConverter(stringArray);
    }

    @Override
    public void format(LogEvent logEvent, StringBuilder stringBuilder) {
        Throwable throwable;
        ThrowableProxy throwableProxy = null;
        if (logEvent instanceof Log4jLogEvent) {
            throwableProxy = ((Log4jLogEvent)logEvent).getThrownProxy();
        }
        if ((throwable = logEvent.getThrown()) != null && this.options.anyLines()) {
            if (throwableProxy == null) {
                super.format(logEvent, stringBuilder);
                return;
            }
            String string = throwableProxy.getRootCauseStackTrace(this.options.getPackages());
            int n = stringBuilder.length();
            if (n > 0 && !Character.isWhitespace(stringBuilder.charAt(n - 1))) {
                stringBuilder.append(" ");
            }
            if (!this.options.allLines() || !Constants.LINE_SEP.equals(this.options.getSeparator())) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String[] stringArray = string.split(Constants.LINE_SEP);
                int n2 = this.options.minLines(stringArray.length) - 1;
                for (int i = 0; i <= n2; ++i) {
                    stringBuilder2.append(stringArray[i]);
                    if (i >= n2) continue;
                    stringBuilder2.append(this.options.getSeparator());
                }
                stringBuilder.append(stringBuilder2.toString());
            } else {
                stringBuilder.append(string);
            }
        }
    }
}

