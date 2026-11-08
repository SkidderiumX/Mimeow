/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.lookup;

import javax.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.impl.ContextAnchor;
import org.apache.logging.log4j.core.lookup.StrLookup;

@Plugin(name="web", category="Lookup")
public class WebLookup
implements StrLookup {
    private static final String ATTR_PREFIX = "attr.";
    private static final String INIT_PARAM_PREFIX = "initParam.";

    protected ServletContext getServletContext() {
        LoggerContext loggerContext = ContextAnchor.THREAD_CONTEXT.get();
        if (loggerContext == null) {
            loggerContext = (LoggerContext)LogManager.getContext(false);
        }
        if (loggerContext != null) {
            Object object = loggerContext.getExternalContext();
            return object != null && object instanceof ServletContext ? (ServletContext)object : null;
        }
        return null;
    }

    @Override
    public String lookup(String string) {
        ServletContext servletContext = this.getServletContext();
        if (servletContext == null) {
            return null;
        }
        if (string.startsWith(ATTR_PREFIX)) {
            String string2 = string.substring(ATTR_PREFIX.length());
            Object object = servletContext.getAttribute(string2);
            return object == null ? null : object.toString();
        }
        if (string.startsWith(INIT_PARAM_PREFIX)) {
            String string3 = string.substring(INIT_PARAM_PREFIX.length());
            return servletContext.getInitParameter(string3);
        }
        if ("rootDir".equals(string)) {
            String string4 = servletContext.getRealPath("/");
            if (string4 == null) {
                String string5 = "failed to resolve web:rootDir -- servlet container unable to translate virtual path  to real path (probably not deployed as exploded";
                throw new RuntimeException(string5);
            }
            return string4;
        }
        if ("contextPath".equals(string)) {
            return servletContext.getContextPath();
        }
        if ("servletContextName".equals(string)) {
            return servletContext.getServletContextName();
        }
        if ("serverInfo".equals(string)) {
            return servletContext.getServerInfo();
        }
        if ("effectiveMajorVersion".equals(string)) {
            return String.valueOf(servletContext.getEffectiveMajorVersion());
        }
        if ("effectiveMinorVersion".equals(string)) {
            return String.valueOf(servletContext.getEffectiveMinorVersion());
        }
        if ("majorVersion".equals(string)) {
            return String.valueOf(servletContext.getMajorVersion());
        }
        if ("minorVersion".equals(string)) {
            return String.valueOf(servletContext.getMinorVersion());
        }
        if (servletContext.getAttribute(string) != null) {
            return servletContext.getAttribute(string).toString();
        }
        if (servletContext.getInitParameter(string) != null) {
            return servletContext.getInitParameter(string);
        }
        servletContext.log(this.getClass().getName() + " unable to resolve key '" + string + "'");
        return null;
    }

    @Override
    public String lookup(LogEvent logEvent, String string) {
        return this.lookup(string);
    }
}

