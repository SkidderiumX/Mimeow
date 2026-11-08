/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.routing;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.routing.Route;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="Routes", category="Core", printObject=true)
public class Routes {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final String pattern;
    private final Route[] routes;

    private Routes(String string, Route ... routeArray) {
        this.pattern = string;
        this.routes = routeArray;
    }

    public String getPattern() {
        return this.pattern;
    }

    public Route[] getRoutes() {
        return this.routes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        boolean bl = true;
        for (Route route : this.routes) {
            if (!bl) {
                stringBuilder.append(",");
            }
            bl = false;
            stringBuilder.append(route.toString());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @PluginFactory
    public static Routes createRoutes(@PluginAttribute(value="pattern") String string, Route ... routeArray) {
        if (string == null) {
            LOGGER.error("A pattern is required");
            return null;
        }
        if (routeArray == null || routeArray.length == 0) {
            LOGGER.error("No routes configured");
            return null;
        }
        return new Routes(string, routeArray);
    }
}

