/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Charsets;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.net.Facility;
import org.apache.logging.log4j.core.net.Priority;

@Plugin(name="SyslogLayout", category="Core", elementType="layout", printObject=true)
public class SyslogLayout
extends AbstractStringLayout {
    public static final Pattern NEWLINE_PATTERN = Pattern.compile("\\r?\\n");
    private final Facility facility;
    private final boolean includeNewLine;
    private final String escapeNewLine;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss ", Locale.ENGLISH);
    private final String localHostname = this.getLocalHostname();

    protected SyslogLayout(Facility facility, boolean bl, String string, Charset charset) {
        super(charset);
        this.facility = facility;
        this.includeNewLine = bl;
        this.escapeNewLine = string == null ? null : Matcher.quoteReplacement(string);
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(Priority.getPriority(this.facility, logEvent.getLevel()));
        stringBuilder.append(">");
        this.addDate(logEvent.getMillis(), stringBuilder);
        stringBuilder.append(" ");
        stringBuilder.append(this.localHostname);
        stringBuilder.append(" ");
        String string = logEvent.getMessage().getFormattedMessage();
        if (null != this.escapeNewLine) {
            string = NEWLINE_PATTERN.matcher(string).replaceAll(this.escapeNewLine);
        }
        stringBuilder.append(string);
        if (this.includeNewLine) {
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String getLocalHostname() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName();
        }
        catch (UnknownHostException unknownHostException) {
            LOGGER.error("Could not determine local host name", (Throwable)unknownHostException);
            return "UNKNOWN_LOCALHOST";
        }
    }

    private synchronized void addDate(long l, StringBuilder stringBuilder) {
        int n = stringBuilder.length() + 4;
        stringBuilder.append(this.dateFormat.format(new Date(l)));
        if (stringBuilder.charAt(n) == '0') {
            stringBuilder.setCharAt(n, ' ');
        }
    }

    @Override
    public Map<String, String> getContentFormat() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("structured", "false");
        hashMap.put("formatType", "logfilepatternreceiver");
        hashMap.put("dateFormat", this.dateFormat.toPattern());
        hashMap.put("format", "<LEVEL>TIMESTAMP PROP(HOSTNAME) MESSAGE");
        return hashMap;
    }

    @PluginFactory
    public static SyslogLayout createLayout(@PluginAttribute(value="facility") String string, @PluginAttribute(value="newLine") String string2, @PluginAttribute(value="newLineEscape") String string3, @PluginAttribute(value="charset") String string4) {
        Charset charset = Charsets.getSupportedCharset(string4);
        boolean bl = Boolean.parseBoolean(string2);
        Facility facility = Facility.toFacility(string, Facility.LOCAL0);
        return new SyslogLayout(facility, bl, string3, charset);
    }
}

