/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.SocketAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.LoggerFields;
import org.apache.logging.log4j.core.layout.RFC5424Layout;
import org.apache.logging.log4j.core.layout.SyslogLayout;
import org.apache.logging.log4j.core.net.AbstractSocketManager;
import org.apache.logging.log4j.core.net.Advertiser;
import org.apache.logging.log4j.core.net.Protocol;
import org.apache.logging.log4j.util.EnglishEnums;

@Plugin(name="Syslog", category="Core", elementType="appender", printObject=true)
public class SyslogAppender
extends SocketAppender {
    protected static final String RFC5424 = "RFC5424";

    protected SyslogAppender(String string, Layout<? extends Serializable> layout, Filter filter, boolean bl, boolean bl2, AbstractSocketManager abstractSocketManager, Advertiser advertiser) {
        super(string, layout, filter, abstractSocketManager, bl, bl2, advertiser);
    }

    @PluginFactory
    public static SyslogAppender createAppender(@PluginAttribute(value="host") String string, @PluginAttribute(value="port") String string2, @PluginAttribute(value="protocol") String string3, @PluginAttribute(value="reconnectionDelay") String string4, @PluginAttribute(value="immediateFail") String string5, @PluginAttribute(value="name") String string6, @PluginAttribute(value="immediateFlush") String string7, @PluginAttribute(value="ignoreExceptions") String string8, @PluginAttribute(value="facility") String string9, @PluginAttribute(value="id") String string10, @PluginAttribute(value="enterpriseNumber") String string11, @PluginAttribute(value="includeMDC") String string12, @PluginAttribute(value="mdcId") String string13, @PluginAttribute(value="mdcPrefix") String string14, @PluginAttribute(value="eventPrefix") String string15, @PluginAttribute(value="newLine") String string16, @PluginAttribute(value="newLineEscape") String string17, @PluginAttribute(value="appName") String string18, @PluginAttribute(value="messageId") String string19, @PluginAttribute(value="mdcExcludes") String string20, @PluginAttribute(value="mdcIncludes") String string21, @PluginAttribute(value="mdcRequired") String string22, @PluginAttribute(value="format") String string23, @PluginElement(value="Filters") Filter filter, @PluginConfiguration Configuration configuration, @PluginAttribute(value="charset") String string24, @PluginAttribute(value="exceptionPattern") String string25, @PluginElement(value="LoggerFields") LoggerFields[] loggerFieldsArray, @PluginAttribute(value="advertise") String string26) {
        SyslogLayout syslogLayout;
        boolean bl = Booleans.parseBoolean(string7, true);
        boolean bl2 = Booleans.parseBoolean(string8, true);
        int n = AbstractAppender.parseInt(string4, 0);
        boolean bl3 = Booleans.parseBoolean(string5, true);
        int n2 = AbstractAppender.parseInt(string2, 0);
        boolean bl4 = Boolean.parseBoolean(string26);
        AbstractStringLayout abstractStringLayout = syslogLayout = RFC5424.equalsIgnoreCase(string23) ? RFC5424Layout.createLayout(string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string25, "false", loggerFieldsArray, configuration) : SyslogLayout.createLayout(string9, string16, string17, string24);
        if (string6 == null) {
            LOGGER.error("No name provided for SyslogAppender");
            return null;
        }
        Protocol protocol = EnglishEnums.valueOf(Protocol.class, string3);
        AbstractSocketManager abstractSocketManager = SyslogAppender.createSocketManager(protocol, string, n2, n, bl3, syslogLayout);
        if (abstractSocketManager == null) {
            return null;
        }
        return new SyslogAppender(string6, (Layout<? extends Serializable>)syslogLayout, filter, bl2, bl, abstractSocketManager, bl4 ? configuration.getAdvertiser() : null);
    }
}

