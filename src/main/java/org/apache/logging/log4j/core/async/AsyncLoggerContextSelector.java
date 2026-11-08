/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLoggerContext;
import org.apache.logging.log4j.core.selector.ContextSelector;

public class AsyncLoggerContextSelector
implements ContextSelector {
    private static final AsyncLoggerContext CONTEXT = new AsyncLoggerContext("AsyncLoggerContext");

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl) {
        return CONTEXT;
    }

    @Override
    public List<LoggerContext> getLoggerContexts() {
        ArrayList<AsyncLoggerContext> arrayList = new ArrayList<AsyncLoggerContext>();
        arrayList.add(CONTEXT);
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl, URI uRI) {
        return CONTEXT;
    }

    @Override
    public void removeContext(LoggerContext loggerContext) {
    }
}

