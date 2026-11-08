/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import java.nio.charset.Charset;
import org.apache.logging.log4j.status.StatusLogger;

public class Charsets {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset getSupportedCharset(String string) {
        return Charsets.getSupportedCharset(string, Charset.defaultCharset());
    }

    public static Charset getSupportedCharset(String string, Charset charset) {
        Charset charset2 = null;
        if (string != null && Charset.isSupported(string)) {
            charset2 = Charset.forName(string);
        }
        if (charset2 == null) {
            charset2 = charset;
            if (string != null) {
                StatusLogger.getLogger().error("Charset " + string + " is not supported for layout, using " + charset2.displayName());
            }
        }
        return charset2;
    }

    private Charsets() {
    }
}

