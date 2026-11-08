/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Charsets;
import org.apache.logging.log4j.core.helpers.Throwables;
import org.apache.logging.log4j.core.helpers.Transform;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MultiformatMessage;

@Plugin(name="JSONLayout", category="Core", elementType="layout", printObject=true)
public class JSONLayout
extends AbstractStringLayout {
    private static final int DEFAULT_SIZE = 256;
    private static final String DEFAULT_EOL = "\r\n";
    private static final String COMPACT_EOL = "";
    private static final String DEFAULT_INDENT = "  ";
    private static final String COMPACT_INDENT = "";
    private static final String[] FORMATS = new String[]{"json"};
    private final boolean locationInfo;
    private final boolean properties;
    private final boolean complete;
    private final String eol;
    private final String indent1;
    private final String indent2;
    private final String indent3;
    private final String indent4;
    private volatile boolean firstLayoutDone;

    protected JSONLayout(boolean bl, boolean bl2, boolean bl3, boolean bl4, Charset charset) {
        super(charset);
        this.locationInfo = bl;
        this.properties = bl2;
        this.complete = bl3;
        this.eol = bl4 ? "" : DEFAULT_EOL;
        this.indent1 = bl4 ? "" : DEFAULT_INDENT;
        this.indent2 = this.indent1 + this.indent1;
        this.indent3 = this.indent2 + this.indent1;
        this.indent4 = this.indent3 + this.indent1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toSerializable(LogEvent logEvent) {
        Throwable throwable;
        Object object;
        Object object2;
        StringBuilder stringBuilder = new StringBuilder(256);
        boolean bl = this.firstLayoutDone;
        if (!this.firstLayoutDone) {
            object2 = this;
            synchronized (object2) {
                bl = this.firstLayoutDone;
                if (!bl) {
                    this.firstLayoutDone = true;
                } else {
                    stringBuilder.append(',');
                    stringBuilder.append(this.eol);
                }
            }
        } else {
            stringBuilder.append(',');
            stringBuilder.append(this.eol);
        }
        stringBuilder.append(this.indent1);
        stringBuilder.append('{');
        stringBuilder.append(this.eol);
        stringBuilder.append(this.indent2);
        stringBuilder.append("\"logger\":\"");
        object2 = logEvent.getLoggerName();
        if (((String)object2).isEmpty()) {
            object2 = "root";
        }
        stringBuilder.append(Transform.escapeJsonControlCharacters((String)object2));
        stringBuilder.append("\",");
        stringBuilder.append(this.eol);
        stringBuilder.append(this.indent2);
        stringBuilder.append("\"timestamp\":\"");
        stringBuilder.append(logEvent.getMillis());
        stringBuilder.append("\",");
        stringBuilder.append(this.eol);
        stringBuilder.append(this.indent2);
        stringBuilder.append("\"level\":\"");
        stringBuilder.append(Transform.escapeJsonControlCharacters(String.valueOf((Object)logEvent.getLevel())));
        stringBuilder.append("\",");
        stringBuilder.append(this.eol);
        stringBuilder.append(this.indent2);
        stringBuilder.append("\"thread\":\"");
        stringBuilder.append(Transform.escapeJsonControlCharacters(logEvent.getThreadName()));
        stringBuilder.append("\",");
        stringBuilder.append(this.eol);
        Message message = logEvent.getMessage();
        if (message != null) {
            boolean bl2 = false;
            if (message instanceof MultiformatMessage) {
                for (String string : object = ((MultiformatMessage)message).getFormats()) {
                    if (!string.equalsIgnoreCase("JSON")) continue;
                    bl2 = true;
                    break;
                }
            }
            stringBuilder.append(this.indent2);
            stringBuilder.append("\"message\":\"");
            if (bl2) {
                stringBuilder.append(((MultiformatMessage)message).getFormattedMessage(FORMATS));
            } else {
                Transform.appendEscapingCDATA(stringBuilder, logEvent.getMessage().getFormattedMessage());
            }
            stringBuilder.append('\"');
        }
        if (logEvent.getContextStack().getDepth() > 0) {
            stringBuilder.append(",");
            stringBuilder.append(this.eol);
            stringBuilder.append("\"ndc\":");
            Transform.appendEscapingCDATA(stringBuilder, logEvent.getContextStack().toString());
            stringBuilder.append("\"");
        }
        if ((throwable = logEvent.getThrown()) != null) {
            stringBuilder.append(",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent2);
            stringBuilder.append("\"throwable\":\"");
            object = Throwables.toStringList(throwable);
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                String string = (String)iterator2.next();
                stringBuilder.append(Transform.escapeJsonControlCharacters(string));
                stringBuilder.append("\\\\n");
            }
            stringBuilder.append("\"");
        }
        if (this.locationInfo) {
            object = logEvent.getSource();
            stringBuilder.append(",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent2);
            stringBuilder.append("\"LocationInfo\":{");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent3);
            stringBuilder.append("\"class\":\"");
            stringBuilder.append(Transform.escapeJsonControlCharacters(((StackTraceElement)object).getClassName()));
            stringBuilder.append("\",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent3);
            stringBuilder.append("\"method\":\"");
            stringBuilder.append(Transform.escapeJsonControlCharacters(((StackTraceElement)object).getMethodName()));
            stringBuilder.append("\",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent3);
            stringBuilder.append("\"file\":\"");
            stringBuilder.append(Transform.escapeJsonControlCharacters(((StackTraceElement)object).getFileName()));
            stringBuilder.append("\",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent3);
            stringBuilder.append("\"line\":\"");
            stringBuilder.append(((StackTraceElement)object).getLineNumber());
            stringBuilder.append("\"");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent2);
            stringBuilder.append("}");
        }
        if (this.properties && logEvent.getContextMap().size() > 0) {
            stringBuilder.append(",");
            stringBuilder.append(this.eol);
            stringBuilder.append(this.indent2);
            stringBuilder.append("\"Properties\":[");
            stringBuilder.append(this.eol);
            object = logEvent.getContextMap().entrySet();
            int n = 1;
            Iterator iterator3 = object.iterator();
            while (iterator3.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator3.next();
                stringBuilder.append(this.indent3);
                stringBuilder.append('{');
                stringBuilder.append(this.eol);
                stringBuilder.append(this.indent4);
                stringBuilder.append("\"name\":\"");
                stringBuilder.append(Transform.escapeJsonControlCharacters((String)entry.getKey()));
                stringBuilder.append("\",");
                stringBuilder.append(this.eol);
                stringBuilder.append(this.indent4);
                stringBuilder.append("\"value\":\"");
                stringBuilder.append(Transform.escapeJsonControlCharacters(String.valueOf(entry.getValue())));
                stringBuilder.append("\"");
                stringBuilder.append(this.eol);
                stringBuilder.append(this.indent3);
                stringBuilder.append("}");
                if (n < object.size()) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(this.eol);
                ++n;
            }
            stringBuilder.append(this.indent2);
            stringBuilder.append("]");
        }
        stringBuilder.append(this.eol);
        stringBuilder.append(this.indent1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public byte[] getHeader() {
        if (!this.complete) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(this.eol);
        return stringBuilder.toString().getBytes(this.getCharset());
    }

    @Override
    public byte[] getFooter() {
        if (!this.complete) {
            return null;
        }
        return (this.eol + "]" + this.eol).getBytes(this.getCharset());
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("version", "2.0");
        return hashMap;
    }

    @Override
    public String getContentType() {
        return "application/json; charset=" + this.getCharset();
    }

    @PluginFactory
    public static JSONLayout createLayout(@PluginAttribute(value="locationInfo") String string, @PluginAttribute(value="properties") String string2, @PluginAttribute(value="complete") String string3, @PluginAttribute(value="compact") String string4, @PluginAttribute(value="charset") String string5) {
        Charset charset = Charsets.getSupportedCharset(string5, Charsets.UTF_8);
        boolean bl = Boolean.parseBoolean(string);
        boolean bl2 = Boolean.parseBoolean(string2);
        boolean bl3 = Boolean.parseBoolean(string3);
        boolean bl4 = Boolean.parseBoolean(string4);
        return new JSONLayout(bl, bl2, bl3, bl4, charset);
    }
}

