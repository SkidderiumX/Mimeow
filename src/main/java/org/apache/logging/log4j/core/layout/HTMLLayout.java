/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Charsets;
import org.apache.logging.log4j.core.helpers.Constants;
import org.apache.logging.log4j.core.helpers.Transform;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

@Plugin(name="HTMLLayout", category="Core", elementType="layout", printObject=true)
public class HTMLLayout
extends AbstractStringLayout {
    private static final int BUF_SIZE = 256;
    private static final String TRACE_PREFIX = "<br />&nbsp;&nbsp;&nbsp;&nbsp;";
    private static final String REGEXP = Constants.LINE_SEP.equals("\n") ? "\n" : Constants.LINE_SEP + "|\n";
    private static final String DEFAULT_TITLE = "Log4j Log Messages";
    private static final String DEFAULT_CONTENT_TYPE = "text/html";
    private final long jvmStartTime = ManagementFactory.getRuntimeMXBean().getStartTime();
    private final boolean locationInfo;
    private final String title;
    private final String contentType;
    private final String font;
    private final String fontSize;
    private final String headerSize;

    private HTMLLayout(boolean bl, String string, String string2, Charset charset, String string3, String string4, String string5) {
        super(charset);
        this.locationInfo = bl;
        this.title = string;
        this.contentType = string2;
        this.font = string3;
        this.fontSize = string4;
        this.headerSize = string5;
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        Serializable serializable;
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(Constants.LINE_SEP).append("<tr>").append(Constants.LINE_SEP);
        stringBuilder.append("<td>");
        stringBuilder.append(logEvent.getMillis() - this.jvmStartTime);
        stringBuilder.append("</td>").append(Constants.LINE_SEP);
        String string = Transform.escapeHtmlTags(logEvent.getThreadName());
        stringBuilder.append("<td title=\"").append(string).append(" thread\">");
        stringBuilder.append(string);
        stringBuilder.append("</td>").append(Constants.LINE_SEP);
        stringBuilder.append("<td title=\"Level\">");
        if (logEvent.getLevel().equals((Object)Level.DEBUG)) {
            stringBuilder.append("<font color=\"#339933\">");
            stringBuilder.append(Transform.escapeHtmlTags(String.valueOf((Object)logEvent.getLevel())));
            stringBuilder.append("</font>");
        } else if (logEvent.getLevel().isAtLeastAsSpecificAs(Level.WARN)) {
            stringBuilder.append("<font color=\"#993300\"><strong>");
            stringBuilder.append(Transform.escapeHtmlTags(String.valueOf((Object)logEvent.getLevel())));
            stringBuilder.append("</strong></font>");
        } else {
            stringBuilder.append(Transform.escapeHtmlTags(String.valueOf((Object)logEvent.getLevel())));
        }
        stringBuilder.append("</td>").append(Constants.LINE_SEP);
        String string2 = Transform.escapeHtmlTags(logEvent.getLoggerName());
        if (string2.isEmpty()) {
            string2 = "root";
        }
        stringBuilder.append("<td title=\"").append(string2).append(" logger\">");
        stringBuilder.append(string2);
        stringBuilder.append("</td>").append(Constants.LINE_SEP);
        if (this.locationInfo) {
            serializable = logEvent.getSource();
            stringBuilder.append("<td>");
            stringBuilder.append(Transform.escapeHtmlTags(serializable.getFileName()));
            stringBuilder.append(':');
            stringBuilder.append(serializable.getLineNumber());
            stringBuilder.append("</td>").append(Constants.LINE_SEP);
        }
        stringBuilder.append("<td title=\"Message\">");
        stringBuilder.append(Transform.escapeHtmlTags(logEvent.getMessage().getFormattedMessage()).replaceAll(REGEXP, "<br />"));
        stringBuilder.append("</td>").append(Constants.LINE_SEP);
        stringBuilder.append("</tr>").append(Constants.LINE_SEP);
        if (logEvent.getContextStack().getDepth() > 0) {
            stringBuilder.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : ").append(this.fontSize);
            stringBuilder.append(";\" colspan=\"6\" ");
            stringBuilder.append("title=\"Nested Diagnostic Context\">");
            stringBuilder.append("NDC: ").append(Transform.escapeHtmlTags(logEvent.getContextStack().toString()));
            stringBuilder.append("</td></tr>").append(Constants.LINE_SEP);
        }
        if (logEvent.getContextMap().size() > 0) {
            stringBuilder.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : ").append(this.fontSize);
            stringBuilder.append(";\" colspan=\"6\" ");
            stringBuilder.append("title=\"Mapped Diagnostic Context\">");
            stringBuilder.append("MDC: ").append(Transform.escapeHtmlTags(logEvent.getContextMap().toString()));
            stringBuilder.append("</td></tr>").append(Constants.LINE_SEP);
        }
        if ((serializable = logEvent.getThrown()) != null) {
            stringBuilder.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : ").append(this.fontSize);
            stringBuilder.append(";\" colspan=\"6\">");
            this.appendThrowableAsHTML((Throwable)serializable, stringBuilder);
            stringBuilder.append("</td></tr>").append(Constants.LINE_SEP);
        }
        return stringBuilder.toString();
    }

    @Override
    public Map<String, String> getContentFormat() {
        return new HashMap<String, String>();
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

    private void appendThrowableAsHTML(Throwable throwable, StringBuilder stringBuilder) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            throwable.printStackTrace(printWriter);
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        printWriter.flush();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            String string = lineNumberReader.readLine();
            while (string != null) {
                arrayList.add(string);
                string = lineNumberReader.readLine();
            }
        }
        catch (IOException iOException) {
            if (iOException instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            arrayList.add(iOException.toString());
        }
        boolean bl = true;
        for (String string : arrayList) {
            if (!bl) {
                stringBuilder.append(TRACE_PREFIX);
            } else {
                bl = false;
            }
            stringBuilder.append(Transform.escapeHtmlTags(string));
            stringBuilder.append(Constants.LINE_SEP);
        }
    }

    @Override
    public byte[] getHeader() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ");
        stringBuilder.append("\"http://www.w3.org/TR/html4/loose.dtd\">");
        stringBuilder.append(Constants.LINE_SEP);
        stringBuilder.append("<html>").append(Constants.LINE_SEP);
        stringBuilder.append("<head>").append(Constants.LINE_SEP);
        stringBuilder.append("<meta charset=\"").append(this.getCharset()).append("\"/>").append(Constants.LINE_SEP);
        stringBuilder.append("<title>").append(this.title).append("</title>").append(Constants.LINE_SEP);
        stringBuilder.append("<style type=\"text/css\">").append(Constants.LINE_SEP);
        stringBuilder.append("<!--").append(Constants.LINE_SEP);
        stringBuilder.append("body, table {font-family:").append(this.font).append("; font-size: ");
        stringBuilder.append(this.headerSize).append(";}").append(Constants.LINE_SEP);
        stringBuilder.append("th {background: #336699; color: #FFFFFF; text-align: left;}").append(Constants.LINE_SEP);
        stringBuilder.append("-->").append(Constants.LINE_SEP);
        stringBuilder.append("</style>").append(Constants.LINE_SEP);
        stringBuilder.append("</head>").append(Constants.LINE_SEP);
        stringBuilder.append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">").append(Constants.LINE_SEP);
        stringBuilder.append("<hr size=\"1\" noshade>").append(Constants.LINE_SEP);
        stringBuilder.append("Log session start time " + new Date() + "<br>").append(Constants.LINE_SEP);
        stringBuilder.append("<br>").append(Constants.LINE_SEP);
        stringBuilder.append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">");
        stringBuilder.append(Constants.LINE_SEP);
        stringBuilder.append("<tr>").append(Constants.LINE_SEP);
        stringBuilder.append("<th>Time</th>").append(Constants.LINE_SEP);
        stringBuilder.append("<th>Thread</th>").append(Constants.LINE_SEP);
        stringBuilder.append("<th>Level</th>").append(Constants.LINE_SEP);
        stringBuilder.append("<th>Logger</th>").append(Constants.LINE_SEP);
        if (this.locationInfo) {
            stringBuilder.append("<th>File:Line</th>").append(Constants.LINE_SEP);
        }
        stringBuilder.append("<th>Message</th>").append(Constants.LINE_SEP);
        stringBuilder.append("</tr>").append(Constants.LINE_SEP);
        return stringBuilder.toString().getBytes(this.getCharset());
    }

    @Override
    public byte[] getFooter() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("</table>").append(Constants.LINE_SEP);
        stringBuilder.append("<br>").append(Constants.LINE_SEP);
        stringBuilder.append("</body></html>");
        return stringBuilder.toString().getBytes(this.getCharset());
    }

    @PluginFactory
    public static HTMLLayout createLayout(@PluginAttribute(value="locationInfo") String string, @PluginAttribute(value="title") String string2, @PluginAttribute(value="contentType") String string3, @PluginAttribute(value="charset") String string4, @PluginAttribute(value="fontSize") String string5, @PluginAttribute(value="fontName") String string6) {
        Charset charset = Charsets.getSupportedCharset(string4, Charsets.UTF_8);
        if (string6 == null) {
            string6 = "arial,sans-serif";
        }
        FontSize fontSize = FontSize.getFontSize(string5);
        string5 = fontSize.getFontSize();
        String string7 = fontSize.larger().getFontSize();
        boolean bl = Boolean.parseBoolean(string);
        if (string2 == null) {
            string2 = DEFAULT_TITLE;
        }
        if (string3 == null) {
            string3 = "text/html; charset=" + charset;
        }
        return new HTMLLayout(bl, string2, string3, charset, string6, string5, string7);
    }

    private static enum FontSize {
        SMALLER("smaller"),
        XXSMALL("xx-small"),
        XSMALL("x-small"),
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large"),
        XLARGE("x-large"),
        XXLARGE("xx-large"),
        LARGER("larger");

        private final String size;

        private FontSize(String string2) {
            this.size = string2;
        }

        public String getFontSize() {
            return this.size;
        }

        public static FontSize getFontSize(String string) {
            for (FontSize fontSize : FontSize.values()) {
                if (!fontSize.size.equals(string)) continue;
                return fontSize;
            }
            return SMALL;
        }

        public FontSize larger() {
            return this.ordinal() < XXLARGE.ordinal() ? FontSize.values()[this.ordinal() + 1] : this;
        }
    }
}

