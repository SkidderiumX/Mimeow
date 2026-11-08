/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.SyslogAppender;
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
import org.apache.logging.log4j.core.net.TLSSocketManager;
import org.apache.logging.log4j.core.net.ssl.SSLConfiguration;

@Plugin(name="TLSSyslog", category="Core", elementType="appender", printObject=true)
public class TLSSyslogAppender
extends SyslogAppender {
    protected TLSSyslogAppender(String string, Layout<? extends Serializable> layout, Filter filter, boolean bl, boolean bl2, AbstractSocketManager abstractSocketManager, Advertiser advertiser) {
        super(string, layout, filter, bl, bl2, abstractSocketManager, advertiser);
    }

    @PluginFactory
    public static TLSSyslogAppender createAppender(@PluginAttribute(value="host") String string, @PluginAttribute(value="port") String string2, @PluginElement(value="ssl") SSLConfiguration sSLConfiguration, @PluginAttribute(value="reconnectionDelay") String string3, @PluginAttribute(value="immediateFail") String string4, @PluginAttribute(value="name") String string5, @PluginAttribute(value="immediateFlush") String string6, @PluginAttribute(value="ignoreExceptions") String string7, @PluginAttribute(value="facility") String string8, @PluginAttribute(value="id") String string9, @PluginAttribute(value="enterpriseNumber") String string10, @PluginAttribute(value="includeMDC") String string11, @PluginAttribute(value="mdcId") String string12, @PluginAttribute(value="mdcPrefix") String string13, @PluginAttribute(value="eventPrefix") String string14, @PluginAttribute(value="newLine") String string15, @PluginAttribute(value="newLineEscape") String string16, @PluginAttribute(value="appName") String string17, @PluginAttribute(value="messageId") String string18, @PluginAttribute(value="mdcExcludes") String string19, @PluginAttribute(value="mdcIncludes") String string20, @PluginAttribute(value="mdcRequired") String string21, @PluginAttribute(value="format") String string22, @PluginElement(value="filters") Filter filter, @PluginConfiguration Configuration configuration, @PluginAttribute(value="charset") String string23, @PluginAttribute(value="exceptionPattern") String string24, @PluginElement(value="LoggerFields") LoggerFields[] loggerFieldsArray, @PluginAttribute(value="advertise") String string25) {
        SyslogLayout syslogLayout;
        boolean bl = Booleans.parseBoolean(string6, true);
        boolean bl2 = Booleans.parseBoolean(string7, true);
        int n = AbstractAppender.parseInt(string3, 0);
        boolean bl3 = Booleans.parseBoolean(string4, true);
        int n2 = AbstractAppender.parseInt(string2, 0);
        boolean bl4 = Boolean.parseBoolean(string25);
        AbstractStringLayout abstractStringLayout = syslogLayout = "RFC5424".equalsIgnoreCase(string22) ? RFC5424Layout.createLayout(string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string24, "true", loggerFieldsArray, configuration) : SyslogLayout.createLayout(string8, string15, string16, string23);
        if (string5 == null) {
            LOGGER.error("No name provided for TLSSyslogAppender");
            return null;
        }
        AbstractSocketManager abstractSocketManager = TLSSyslogAppender.createSocketManager(sSLConfiguration, string, n2, n, bl3, (Layout<? extends Serializable>)syslogLayout);
        if (abstractSocketManager == null) {
            return null;
        }
        return new TLSSyslogAppender(string5, (Layout<? extends Serializable>)syslogLayout, filter, bl2, bl, abstractSocketManager, bl4 ? configuration.getAdvertiser() : null);
    }

    public static AbstractSocketManager createSocketManager(SSLConfiguration sSLConfiguration, String string, int n, int n2, boolean bl, Layout<? extends Serializable> layout) {
        return TLSSocketManager.getSocketManager(sSLConfiguration, string, n, n2, bl, layout);
    }
}

