/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;
import org.apache.logging.log4j.core.layout.SerializedLayout;
import org.apache.logging.log4j.core.net.AbstractSocketManager;
import org.apache.logging.log4j.core.net.Advertiser;
import org.apache.logging.log4j.core.net.DatagramSocketManager;
import org.apache.logging.log4j.core.net.Protocol;
import org.apache.logging.log4j.core.net.TCPSocketManager;
import org.apache.logging.log4j.util.EnglishEnums;

@Plugin(name="Socket", category="Core", elementType="appender", printObject=true)
public class SocketAppender
extends AbstractOutputStreamAppender {
    private Object advertisement;
    private final Advertiser advertiser;

    protected SocketAppender(String string, Layout<? extends Serializable> layout, Filter filter, AbstractSocketManager abstractSocketManager, boolean bl, boolean bl2, Advertiser advertiser) {
        super(string, layout, filter, bl, bl2, abstractSocketManager);
        if (advertiser != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>(layout.getContentFormat());
            hashMap.putAll(abstractSocketManager.getContentFormat());
            hashMap.put("contentType", layout.getContentType());
            hashMap.put("name", string);
            this.advertisement = advertiser.advertise(hashMap);
        }
        this.advertiser = advertiser;
    }

    @Override
    public void stop() {
        super.stop();
        if (this.advertiser != null) {
            this.advertiser.unadvertise(this.advertisement);
        }
    }

    @PluginFactory
    public static SocketAppender createAppender(@PluginAttribute(value="host") String string, @PluginAttribute(value="port") String string2, @PluginAttribute(value="protocol") String string3, @PluginAttribute(value="reconnectionDelay") String string4, @PluginAttribute(value="immediateFail") String string5, @PluginAttribute(value="name") String string6, @PluginAttribute(value="immediateFlush") String string7, @PluginAttribute(value="ignoreExceptions") String string8, @PluginElement(value="Layout") Layout<? extends Serializable> serializedLayout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="advertise") String string9, @PluginConfiguration Configuration configuration) {
        AbstractSocketManager abstractSocketManager;
        boolean bl = Booleans.parseBoolean(string7, true);
        boolean bl2 = Boolean.parseBoolean(string9);
        boolean bl3 = Booleans.parseBoolean(string8, true);
        boolean bl4 = Booleans.parseBoolean(string5, true);
        int n = AbstractAppender.parseInt(string4, 0);
        int n2 = AbstractAppender.parseInt(string2, 0);
        if (serializedLayout == null) {
            serializedLayout = SerializedLayout.createLayout();
        }
        if (string6 == null) {
            LOGGER.error("No name provided for SocketAppender");
            return null;
        }
        Protocol protocol = EnglishEnums.valueOf(Protocol.class, string3 != null ? string3 : Protocol.TCP.name());
        if (protocol.equals((Object)Protocol.UDP)) {
            bl = true;
        }
        if ((abstractSocketManager = SocketAppender.createSocketManager(protocol, string, n2, n, bl4, serializedLayout)) == null) {
            return null;
        }
        return new SocketAppender(string6, serializedLayout, filter, abstractSocketManager, bl3, bl, bl2 ? configuration.getAdvertiser() : null);
    }

    protected static AbstractSocketManager createSocketManager(Protocol protocol, String string, int n, int n2, boolean bl, Layout<? extends Serializable> layout) {
        switch (protocol) {
            case TCP: {
                return TCPSocketManager.getSocketManager(string, n, n2, bl, layout);
            }
            case UDP: {
                return DatagramSocketManager.getSocketManager(string, n, layout);
            }
        }
        return null;
    }
}

