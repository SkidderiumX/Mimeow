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
import org.apache.logging.log4j.core.helpers.Strings;
import org.apache.logging.log4j.core.helpers.Throwables;
import org.apache.logging.log4j.core.helpers.Transform;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MultiformatMessage;

@Plugin(name="XMLLayout", category="Core", elementType="layout", printObject=true)
public class XMLLayout
extends AbstractStringLayout {
    private static final String XML_NAMESPACE = "http://logging.apache.org/log4j/2.0/events";
    private static final String ROOT_TAG = "Events";
    private static final int DEFAULT_SIZE = 256;
    private static final String DEFAULT_EOL = "\r\n";
    private static final String COMPACT_EOL = "";
    private static final String DEFAULT_INDENT = "  ";
    private static final String COMPACT_INDENT = "";
    private static final String DEFAULT_NS_PREFIX = "log4j";
    private static final String[] FORMATS = new String[]{"xml"};
    private final boolean locationInfo;
    private final boolean properties;
    private final boolean complete;
    private final String namespacePrefix;
    private final String eol;
    private final String indent1;
    private final String indent2;
    private final String indent3;

    protected XMLLayout(boolean bl, boolean bl2, boolean bl3, boolean bl4, String string, Charset charset) {
        super(charset);
        this.locationInfo = bl;
        this.properties = bl2;
        this.complete = bl3;
        this.eol = bl4 ? "" : DEFAULT_EOL;
        this.indent1 = bl4 ? "" : DEFAULT_INDENT;
        this.indent2 = this.indent1 + this.indent1;
        this.indent3 = this.indent2 + this.indent1;
        this.namespacePrefix = (Strings.isEmpty(string) ? DEFAULT_NS_PREFIX : string) + ":";
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        Throwable throwable;
        Object object;
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(this.indent1);
        stringBuilder.append('<');
        if (!this.complete) {
            stringBuilder.append(this.namespacePrefix);
        }
        stringBuilder.append("Event logger=\"");
        String string = logEvent.getLoggerName();
        if (string.isEmpty()) {
            string = "root";
        }
        stringBuilder.append(Transform.escapeHtmlTags(string));
        stringBuilder.append("\" timestamp=\"");
        stringBuilder.append(logEvent.getMillis());
        stringBuilder.append("\" level=\"");
        stringBuilder.append(Transform.escapeHtmlTags(String.valueOf((Object)logEvent.getLevel())));
        stringBuilder.append("\" thread=\"");
        stringBuilder.append(Transform.escapeHtmlTags(logEvent.getThreadName()));
        stringBuilder.append("\">");
        stringBuilder.append(this.eol);
        Message message = logEvent.getMessage();
        if (message != null) {
            boolean bl = false;
            if (message instanceof MultiformatMessage) {
                object = ((MultiformatMessage)message).getFormats();
                for (String string2 : object) {
                    if (!string2.equalsIgnoreCase("XML")) continue;
                    bl = true;
                    break;
                }
            }
            stringBuilder.append(this.indent2);
            stringBuilder.append('<');
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Message>");
            if (bl) {
                stringBuilder.append(((MultiformatMessage)message).getFormattedMessage(FORMATS));
            } else {
                stringBuilder.append("<![CDATA[");
                Transform.appendEscapingCDATA(stringBuilder, logEvent.getMessage().getFormattedMessage());
                stringBuilder.append("]]>");
            }
            stringBuilder.append("</");
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Message>");
            stringBuilder.append(this.eol);
        }
        if (logEvent.getContextStack().getDepth() > 0) {
            stringBuilder.append(this.indent2);
            stringBuilder.append('<');
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("NDC><![CDATA[");
            Transform.appendEscapingCDATA(stringBuilder, logEvent.getContextStack().toString());
            stringBuilder.append("]]></");
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("NDC>");
            stringBuilder.append(this.eol);
        }
        if ((throwable = logEvent.getThrown()) != null) {
            object = Throwables.toStringList(throwable);
            stringBuilder.append(this.indent2);
            stringBuilder.append('<');
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Throwable><![CDATA[");
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                String string3 = (String)iterator2.next();
                Transform.appendEscapingCDATA(stringBuilder, string3);
                stringBuilder.append(this.eol);
            }
            stringBuilder.append("]]></");
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Throwable>");
            stringBuilder.append(this.eol);
        }
        if (this.locationInfo) {
            object = logEvent.getSource();
            stringBuilder.append(this.indent2);
            stringBuilder.append('<');
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("LocationInfo class=\"");
            stringBuilder.append(Transform.escapeHtmlTags(((StackTraceElement)object).getClassName()));
            stringBuilder.append("\" method=\"");
            stringBuilder.append(Transform.escapeHtmlTags(((StackTraceElement)object).getMethodName()));
            stringBuilder.append("\" file=\"");
            stringBuilder.append(Transform.escapeHtmlTags(((StackTraceElement)object).getFileName()));
            stringBuilder.append("\" line=\"");
            stringBuilder.append(((StackTraceElement)object).getLineNumber());
            stringBuilder.append("\"/>");
            stringBuilder.append(this.eol);
        }
        if (this.properties && logEvent.getContextMap().size() > 0) {
            stringBuilder.append(this.indent2);
            stringBuilder.append('<');
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Properties>");
            stringBuilder.append(this.eol);
            for (Map.Entry entry : logEvent.getContextMap().entrySet()) {
                stringBuilder.append(this.indent3);
                stringBuilder.append('<');
                if (!this.complete) {
                    stringBuilder.append(this.namespacePrefix);
                }
                stringBuilder.append("Data name=\"");
                stringBuilder.append(Transform.escapeHtmlTags((String)entry.getKey()));
                stringBuilder.append("\" value=\"");
                stringBuilder.append(Transform.escapeHtmlTags(String.valueOf(entry.getValue())));
                stringBuilder.append("\"/>");
                stringBuilder.append(this.eol);
            }
            stringBuilder.append(this.indent2);
            stringBuilder.append("</");
            if (!this.complete) {
                stringBuilder.append(this.namespacePrefix);
            }
            stringBuilder.append("Properties>");
            stringBuilder.append(this.eol);
        }
        stringBuilder.append(this.indent1);
        stringBuilder.append("</");
        if (!this.complete) {
            stringBuilder.append(this.namespacePrefix);
        }
        stringBuilder.append("Event>");
        stringBuilder.append(this.eol);
        return stringBuilder.toString();
    }

    @Override
    public byte[] getHeader() {
        if (!this.complete) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"");
        stringBuilder.append(this.getCharset().name());
        stringBuilder.append("\"?>");
        stringBuilder.append(this.eol);
        stringBuilder.append('<');
        stringBuilder.append(ROOT_TAG);
        stringBuilder.append(" xmlns=\"http://logging.apache.org/log4j/2.0/events\">");
        stringBuilder.append(this.eol);
        return stringBuilder.toString().getBytes(this.getCharset());
    }

    @Override
    public byte[] getFooter() {
        if (!this.complete) {
            return null;
        }
        return ("</Events>" + this.eol).getBytes(this.getCharset());
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("xsd", "log4j-events.xsd");
        hashMap.put("version", "2.0");
        return hashMap;
    }

    @Override
    public String getContentType() {
        return "text/xml; charset=" + this.getCharset();
    }

    @PluginFactory
    public static XMLLayout createLayout(@PluginAttribute(value="locationInfo") String string, @PluginAttribute(value="properties") String string2, @PluginAttribute(value="complete") String string3, @PluginAttribute(value="compact") String string4, @PluginAttribute(value="namespacePrefix") String string5, @PluginAttribute(value="charset") String string6) {
        Charset charset = Charsets.getSupportedCharset(string6, Charsets.UTF_8);
        boolean bl = Boolean.parseBoolean(string);
        boolean bl2 = Boolean.parseBoolean(string2);
        boolean bl3 = Boolean.parseBoolean(string3);
        boolean bl4 = Boolean.parseBoolean(string4);
        return new XMLLayout(bl, bl2, bl3, bl4, string5, charset);
    }
}

