/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.SerializedLayout;
import org.apache.logging.log4j.core.net.JMSQueueManager;

@Plugin(name="JMSQueue", category="Core", elementType="appender", printObject=true)
public class JMSQueueAppender
extends AbstractAppender {
    private final JMSQueueManager manager;

    private JMSQueueAppender(String string, Filter filter, Layout<? extends Serializable> layout, JMSQueueManager jMSQueueManager, boolean bl) {
        super(string, filter, layout, bl);
        this.manager = jMSQueueManager;
    }

    @Override
    public void append(LogEvent logEvent) {
        try {
            this.manager.send(this.getLayout().toSerializable(logEvent));
        }
        catch (Exception exception) {
            throw new AppenderLoggingException(exception);
        }
    }

    @PluginFactory
    public static JMSQueueAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="factoryName") String string2, @PluginAttribute(value="providerURL") String string3, @PluginAttribute(value="urlPkgPrefixes") String string4, @PluginAttribute(value="securityPrincipalName") String string5, @PluginAttribute(value="securityCredentials") String string6, @PluginAttribute(value="factoryBindingName") String string7, @PluginAttribute(value="queueBindingName") String string8, @PluginAttribute(value="userName") String string9, @PluginAttribute(value="password") String string10, @PluginElement(value="Layout") Layout<? extends Serializable> serializedLayout, @PluginElement(value="Filter") Filter filter, @PluginAttribute(value="ignoreExceptions") String string11) {
        if (string == null) {
            LOGGER.error("No name provided for JMSQueueAppender");
            return null;
        }
        boolean bl = Booleans.parseBoolean(string11, true);
        JMSQueueManager jMSQueueManager = JMSQueueManager.getJMSQueueManager(string2, string3, string4, string5, string6, string7, string8, string9, string10);
        if (jMSQueueManager == null) {
            return null;
        }
        if (serializedLayout == null) {
            serializedLayout = SerializedLayout.createLayout();
        }
        return new JMSQueueAppender(string, filter, serializedLayout, jMSQueueManager, bl);
    }
}

