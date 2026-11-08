/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.web;

import java.net.URI;
import javax.servlet.ServletContext;
import javax.servlet.UnavailableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.impl.ContextAnchor;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;
import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.core.selector.ContextSelector;
import org.apache.logging.log4j.core.selector.NamedContextSelector;
import org.apache.logging.log4j.core.web.Log4jWebInitializer;
import org.apache.logging.log4j.spi.LoggerContextFactory;

public class Log4jWebInitializerImpl
implements Log4jWebInitializer {
    private static final Object MUTEX = new Object();
    private final StrSubstitutor substitutor = new StrSubstitutor(new Interpolator());
    private final ServletContext servletContext;
    private String name;
    private NamedContextSelector selector;
    private LoggerContext loggerContext;
    private boolean initialized = false;
    private boolean deinitialized = false;

    private Log4jWebInitializerImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public synchronized void initialize() throws UnavailableException {
        if (this.deinitialized) {
            throw new IllegalStateException("Cannot initialize Log4jWebInitializer after it was destroyed.");
        }
        if (!this.initialized) {
            this.initialized = true;
            this.name = this.substitutor.replace(this.servletContext.getInitParameter("log4jContextName"));
            String string = this.substitutor.replace(this.servletContext.getInitParameter("log4jConfiguration"));
            boolean bl = "true".equals(this.servletContext.getInitParameter("isLog4jContextSelectorNamed"));
            if (bl) {
                this.initializeJndi(string);
            } else {
                this.initializeNonJndi(string);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initializeJndi(String string) throws UnavailableException {
        URI uRI = null;
        if (string != null) {
            try {
                uRI = new URI(string);
            }
            catch (Exception exception) {
                this.servletContext.log("Unable to convert configuration location [" + string + "] to a URI!", (Throwable)exception);
            }
        }
        if (this.name == null) {
            throw new UnavailableException("A log4jContextName context parameter is required");
        }
        LoggerContextFactory loggerContextFactory = LogManager.getFactory();
        if (!(loggerContextFactory instanceof Log4jContextFactory)) {
            this.servletContext.log("Potential problem: Factory is not an instance of Log4jContextFactory.");
            return;
        }
        ContextSelector contextSelector = ((Log4jContextFactory)loggerContextFactory).getSelector();
        if (!(contextSelector instanceof NamedContextSelector)) {
            this.servletContext.log("Potential problem: Selector is not an instance of NamedContextSelector.");
            return;
        }
        this.selector = (NamedContextSelector)contextSelector;
        LoggerContext loggerContext = this.selector.locateContext(this.name, this.servletContext, uRI);
        ContextAnchor.THREAD_CONTEXT.set(loggerContext);
        if (loggerContext.getStatus() == LoggerContext.Status.INITIALIZED) {
            loggerContext.start();
        }
        ContextAnchor.THREAD_CONTEXT.remove();
        this.loggerContext = loggerContext;
        this.servletContext.log("Created logger context for [" + this.name + "] using [" + loggerContext.getClass().getClassLoader() + "].");
    }

    private void initializeNonJndi(String string) {
        if (this.name == null) {
            this.name = this.servletContext.getServletContextName();
        }
        if (this.name == null && string == null) {
            this.servletContext.log("No Log4j context configuration provided. This is very unusual.");
            return;
        }
        this.loggerContext = Configurator.initialize(this.name, this.getClassLoader(), string, (Object)this.servletContext);
    }

    @Override
    public synchronized void deinitialize() {
        if (!this.initialized) {
            throw new IllegalStateException("Cannot deinitialize Log4jWebInitializer because it has not initialized.");
        }
        if (!this.deinitialized) {
            this.deinitialized = true;
            if (this.loggerContext != null) {
                this.servletContext.log("Removing LoggerContext for [" + this.name + "].");
                if (this.selector != null) {
                    this.selector.removeContext(this.name);
                }
                this.loggerContext.stop();
                this.loggerContext.setExternalContext(null);
                this.loggerContext = null;
            }
        }
    }

    @Override
    public void setLoggerContext() {
        if (this.loggerContext != null) {
            ContextAnchor.THREAD_CONTEXT.set(this.loggerContext);
        }
    }

    @Override
    public void clearLoggerContext() {
        ContextAnchor.THREAD_CONTEXT.remove();
    }

    private ClassLoader getClassLoader() {
        try {
            return this.servletContext.getClassLoader();
        }
        catch (Throwable throwable) {
            return Log4jWebInitializerImpl.class.getClassLoader();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static Log4jWebInitializer getLog4jWebInitializer(ServletContext servletContext) {
        Object object = MUTEX;
        synchronized (object) {
            Log4jWebInitializer log4jWebInitializer = (Log4jWebInitializer)servletContext.getAttribute(INITIALIZER_ATTRIBUTE);
            if (log4jWebInitializer == null) {
                log4jWebInitializer = new Log4jWebInitializerImpl(servletContext);
                servletContext.setAttribute(INITIALIZER_ATTRIBUTE, (Object)log4jWebInitializer);
            }
            return log4jWebInitializer;
        }
    }

    static {
        try {
            Class.forName("org.apache.logging.log4j.core.web.JNDIContextFilter");
            throw new IllegalStateException("You are using Log4j 2 in a web application with the old, extinct log4j-web artifact. This is not supported and could cause serious runtime problems. Pleaseremove the log4j-web JAR file from your application.");
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
    }
}

