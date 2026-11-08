/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender;

import java.io.Serializable;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.ErrorHandler;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.DefaultErrorHandler;
import org.apache.logging.log4j.core.filter.AbstractFilterable;
import org.apache.logging.log4j.core.helpers.Integers;

public abstract class AbstractAppender
extends AbstractFilterable
implements Appender {
    private final boolean ignoreExceptions;
    private ErrorHandler handler = new DefaultErrorHandler(this);
    private final Layout<? extends Serializable> layout;
    private final String name;
    private boolean started = false;

    public static int parseInt(String string, int n) {
        try {
            return Integers.parseInt(string, n);
        }
        catch (NumberFormatException numberFormatException) {
            LOGGER.error("Could not parse \"{}\" as an integer,  using default value {}: {}", string, n, numberFormatException);
            return n;
        }
    }

    protected AbstractAppender(String string, Filter filter, Layout<? extends Serializable> layout) {
        this(string, filter, layout, true);
    }

    protected AbstractAppender(String string, Filter filter, Layout<? extends Serializable> layout, boolean bl) {
        super(filter);
        this.name = string;
        this.layout = layout;
        this.ignoreExceptions = bl;
    }

    public void error(String string) {
        this.handler.error(string);
    }

    public void error(String string, LogEvent logEvent, Throwable throwable) {
        this.handler.error(string, logEvent, throwable);
    }

    public void error(String string, Throwable throwable) {
        this.handler.error(string, throwable);
    }

    @Override
    public ErrorHandler getHandler() {
        return this.handler;
    }

    @Override
    public Layout<? extends Serializable> getLayout() {
        return this.layout;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean ignoreExceptions() {
        return this.ignoreExceptions;
    }

    @Override
    public boolean isStarted() {
        return this.started;
    }

    @Override
    public void setHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            LOGGER.error("The handler cannot be set to null");
        }
        if (this.isStarted()) {
            LOGGER.error("The handler cannot be changed once the appender is started");
            return;
        }
        this.handler = errorHandler;
    }

    @Override
    public void start() {
        this.startFilter();
        this.started = true;
    }

    @Override
    public void stop() {
        this.started = false;
        this.stopFilter();
    }

    public String toString() {
        return this.name;
    }
}

