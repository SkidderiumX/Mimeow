/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.routing;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.appender.routing.Route;
import org.apache.logging.log4j.core.appender.routing.Routes;
import org.apache.logging.log4j.core.config.AppenderControl;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Booleans;

@Plugin(name="Routing", category="Core", elementType="appender", printObject=true)
public class RoutingAppender
extends AbstractAppender {
    private static final String DEFAULT_KEY = "ROUTING_APPENDER_DEFAULT";
    private final Routes routes;
    private final Route defaultRoute;
    private final Configuration config;
    private final ConcurrentMap<String, AppenderControl> appenders = new ConcurrentHashMap<String, AppenderControl>();
    private final RewritePolicy rewritePolicy;

    private RoutingAppender(String string, Filter filter, boolean bl, Routes routes, RewritePolicy rewritePolicy, Configuration configuration) {
        super(string, filter, null, bl);
        this.routes = routes;
        this.config = configuration;
        this.rewritePolicy = rewritePolicy;
        Route route = null;
        for (Route route2 : routes.getRoutes()) {
            if (route2.getKey() != null) continue;
            if (route == null) {
                route = route2;
                continue;
            }
            this.error("Multiple default routes. Route " + route2.toString() + " will be ignored");
        }
        this.defaultRoute = route;
    }

    @Override
    public void start() {
        Map<String, Appender> map = this.config.getAppenders();
        for (Route route : this.routes.getRoutes()) {
            if (route.getAppenderRef() == null) continue;
            Appender appender = map.get(route.getAppenderRef());
            if (appender != null) {
                String string = route == this.defaultRoute ? DEFAULT_KEY : route.getKey();
                this.appenders.put(string, new AppenderControl(appender, null, null));
                continue;
            }
            LOGGER.error("Appender " + route.getAppenderRef() + " cannot be located. Route ignored");
        }
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        Map<String, Appender> map = this.config.getAppenders();
        for (Map.Entry entry : this.appenders.entrySet()) {
            String string = ((AppenderControl)entry.getValue()).getAppender().getName();
            if (map.containsKey(string)) continue;
            ((AppenderControl)entry.getValue()).getAppender().stop();
        }
    }

    @Override
    public void append(LogEvent logEvent) {
        String string;
        AppenderControl appenderControl;
        if (this.rewritePolicy != null) {
            logEvent = this.rewritePolicy.rewrite(logEvent);
        }
        if ((appenderControl = this.getControl(string = this.config.getStrSubstitutor().replace(logEvent, this.routes.getPattern()), logEvent)) != null) {
            appenderControl.callAppender(logEvent);
        }
    }

    private synchronized AppenderControl getControl(String string, LogEvent logEvent) {
        AppenderControl appenderControl = (AppenderControl)this.appenders.get(string);
        if (appenderControl != null) {
            return appenderControl;
        }
        Route route = null;
        for (Route route2 : this.routes.getRoutes()) {
            if (route2.getAppenderRef() != null || !string.equals(route2.getKey())) continue;
            route = route2;
            break;
        }
        if (route == null) {
            route = this.defaultRoute;
            appenderControl = (AppenderControl)this.appenders.get(DEFAULT_KEY);
            if (appenderControl != null) {
                return appenderControl;
            }
        }
        if (route != null) {
            Appender appender = this.createAppender(route, logEvent);
            if (appender == null) {
                return null;
            }
            appenderControl = new AppenderControl(appender, null, null);
            this.appenders.put(string, appenderControl);
        }
        return appenderControl;
    }

    private Appender createAppender(Route route, LogEvent logEvent) {
        Node node = route.getNode();
        for (Node node2 : node.getChildren()) {
            if (!node2.getType().getElementName().equals("appender")) continue;
            Node node3 = new Node(node2);
            this.config.createConfiguration(node3, logEvent);
            if (node3.getObject() instanceof Appender) {
                Appender appender = (Appender)node3.getObject();
                appender.start();
                return appender;
            }
            LOGGER.error("Unable to create Appender of type " + node2.getName());
            return null;
        }
        LOGGER.error("No Appender was configured for route " + route.getKey());
        return null;
    }

    @PluginFactory
    public static RoutingAppender createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="ignoreExceptions") String string2, @PluginElement(value="Routes") Routes routes, @PluginConfiguration Configuration configuration, @PluginElement(value="RewritePolicy") RewritePolicy rewritePolicy, @PluginElement(value="Filters") Filter filter) {
        boolean bl = Booleans.parseBoolean(string2, true);
        if (string == null) {
            LOGGER.error("No name provided for RoutingAppender");
            return null;
        }
        if (routes == null) {
            LOGGER.error("No routes defined for RoutingAppender");
            return null;
        }
        return new RoutingAppender(string, filter, bl, routes, rewritePolicy, configuration);
    }
}

