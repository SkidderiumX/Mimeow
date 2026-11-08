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
import org.apache.logging.log4j.core.net.JMSTopicManager;

@Plugin(name="JMSTopic", category="Core", elementType="appender", printObject=true)
public class JMSTopicAppender
extends AbstractAppender {
    private final JMSTopicManager manager;

    private JMSTopicAppender(String string, Filter filter, Layout<? extends Serializable> layout, JMSTopicManager jMSTopicManager, boolean bl) {
        super(string, filter, layout, bl);
        this.manager = jMSTopicManager;
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
    public static JMSTopicAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="factoryName") String string2, @PluginAttribute(value="providerURL") String string3, @PluginAttribute(value="urlPkgPrefixes") String string4, @PluginAttribute(value="securityPrincipalName") String string5, @PluginAttribute(value="securityCredentials") String string6, @PluginAttribute(value="factoryBindingName") String string7, @PluginAttribute(value="topicBindingName") String string8, @PluginAttribute(value="userName") String string9, @PluginAttribute(value="password") String string10, @PluginElement(value="Layout") Layout<? extends Serializable> serializedLayout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="ignoreExceptions") String string11) {
        if (string == null) {
            LOGGER.error("No name provided for JMSQueueAppender");
            return null;
        }
        boolean bl = Booleans.parseBoolean(string11, true);
        JMSTopicManager jMSTopicManager = JMSTopicManager.getJMSTopicManager(string2, string3, string4, string5, string6, string7, string8, string9, string10);
        if (jMSTopicManager == null) {
            return null;
        }
        if (serializedLayout == null) {
            serializedLayout = SerializedLayout.createLayout();
        }
        return new JMSTopicAppender(string, filter, serializedLayout, jMSTopicManager, bl);
    }
}

