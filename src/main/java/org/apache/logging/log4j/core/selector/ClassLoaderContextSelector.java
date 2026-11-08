/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.selector;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.core.impl.ContextAnchor;
import org.apache.logging.log4j.core.impl.ReflectiveCallerClassUtility;
import org.apache.logging.log4j.core.selector.ContextSelector;
import org.apache.logging.log4j.status.StatusLogger;

public class ClassLoaderContextSelector
implements ContextSelector {
    private static final AtomicReference<LoggerContext> CONTEXT = new AtomicReference();
    private static final PrivateSecurityManager SECURITY_MANAGER;
    private static final StatusLogger LOGGER;
    private static final ConcurrentMap<String, AtomicReference<WeakReference<LoggerContext>>> CONTEXT_MAP;

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl) {
        return this.getContext(string, classLoader, bl, null);
    }

    @Override
    public LoggerContext getContext(String string, ClassLoader classLoader, boolean bl, URI uRI) {
        boolean bl2;
        Class<?> clazz;
        if (bl) {
            LoggerContext loggerContext = ContextAnchor.THREAD_CONTEXT.get();
            if (loggerContext != null) {
                return loggerContext;
            }
            return this.getDefault();
        }
        if (classLoader != null) {
            return this.locateContext(classLoader, uRI);
        }
        if (ReflectiveCallerClassUtility.isSupported()) {
            try {
                clazz = Class.class;
                bl2 = false;
                int n = 2;
                while (clazz != null && (clazz = ReflectiveCallerClassUtility.getCaller(n)) != null) {
                    if (clazz.getName().equals(string)) {
                        bl2 = true;
                    } else if (bl2) break;
                    ++n;
                }
                if (clazz != null) {
                    return this.locateContext(clazz.getClassLoader(), uRI);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (SECURITY_MANAGER != null && (clazz = SECURITY_MANAGER.getCaller(string)) != null) {
            ClassLoader classLoader2 = clazz.getClassLoader() != null ? clazz.getClassLoader() : ClassLoader.getSystemClassLoader();
            return this.locateContext(classLoader2, uRI);
        }
        clazz = new Throwable();
        bl2 = false;
        String string2 = null;
        Object object = ((Throwable)((Object)clazz)).getStackTrace();
        int n = ((StackTraceElement[])object).length;
        for (int i = 0; i < n; ++i) {
            StackTraceElement stackTraceElement = object[i];
            if (stackTraceElement.getClassName().equals(string)) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            string2 = stackTraceElement.getClassName();
            break;
        }
        if (string2 != null) {
            try {
                return this.locateContext(Loader.loadClass(string2).getClassLoader(), uRI);
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        if ((object = ContextAnchor.THREAD_CONTEXT.get()) != null) {
            return object;
        }
        return this.getDefault();
    }

    @Override
    public void removeContext(LoggerContext loggerContext) {
        for (Map.Entry entry : CONTEXT_MAP.entrySet()) {
            LoggerContext loggerContext2 = (LoggerContext)((WeakReference)((AtomicReference)entry.getValue()).get()).get();
            if (loggerContext2 != loggerContext) continue;
            CONTEXT_MAP.remove(entry.getKey());
        }
    }

    @Override
    public List<LoggerContext> getLoggerContexts() {
        ArrayList<LoggerContext> arrayList = new ArrayList<LoggerContext>();
        Collection collection = CONTEXT_MAP.values();
        for (AtomicReference atomicReference : collection) {
            LoggerContext loggerContext = (LoggerContext)((WeakReference)atomicReference.get()).get();
            if (loggerContext == null) continue;
            arrayList.add(loggerContext);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private LoggerContext locateContext(ClassLoader classLoader, URI uRI) {
        String string = classLoader.toString();
        AtomicReference atomicReference = (AtomicReference)CONTEXT_MAP.get(string);
        if (atomicReference == null) {
            Object object;
            Object object2;
            if (uRI == null) {
                for (object2 = classLoader.getParent(); object2 != null; object2 = ((ClassLoader)object2).getParent()) {
                    LoggerContext loggerContext;
                    atomicReference = (AtomicReference)CONTEXT_MAP.get(object2.toString());
                    if (atomicReference == null || (loggerContext = (LoggerContext)((Reference)(object = (WeakReference)atomicReference.get())).get()) == null) continue;
                    return loggerContext;
                }
            }
            object2 = new LoggerContext(string, null, uRI);
            object = new AtomicReference<WeakReference<Object>>();
            ((AtomicReference)object).set(new WeakReference<Object>(object2));
            CONTEXT_MAP.putIfAbsent(classLoader.toString(), (AtomicReference<WeakReference<LoggerContext>>)object);
            object2 = (LoggerContext)((WeakReference)((AtomicReference)CONTEXT_MAP.get(string)).get()).get();
            return object2;
        }
        WeakReference weakReference = (WeakReference)atomicReference.get();
        LoggerContext loggerContext = (LoggerContext)weakReference.get();
        if (loggerContext != null) {
            if (loggerContext.getConfigLocation() == null && uRI != null) {
                LOGGER.debug("Setting configuration to {}", uRI);
                loggerContext.setConfigLocation(uRI);
            } else if (loggerContext.getConfigLocation() != null && uRI != null && !loggerContext.getConfigLocation().equals(uRI)) {
                LOGGER.warn("locateContext called with URI {}. Existing LoggerContext has URI {}", uRI, loggerContext.getConfigLocation());
            }
            return loggerContext;
        }
        loggerContext = new LoggerContext(string, null, uRI);
        atomicReference.compareAndSet(weakReference, new WeakReference<LoggerContext>(loggerContext));
        return loggerContext;
    }

    private LoggerContext getDefault() {
        LoggerContext loggerContext = CONTEXT.get();
        if (loggerContext != null) {
            return loggerContext;
        }
        CONTEXT.compareAndSet(null, new LoggerContext("Default"));
        return CONTEXT.get();
    }

    static {
        LOGGER = StatusLogger.getLogger();
        CONTEXT_MAP = new ConcurrentHashMap<String, AtomicReference<WeakReference<LoggerContext>>>();
        if (ReflectiveCallerClassUtility.isSupported()) {
            SECURITY_MANAGER = null;
        } else {
            PrivateSecurityManager privateSecurityManager;
            try {
                privateSecurityManager = new PrivateSecurityManager();
                if (privateSecurityManager.getCaller(ClassLoaderContextSelector.class.getName()) == null) {
                    privateSecurityManager = null;
                    LOGGER.error("Unable to obtain call stack from security manager.");
                }
            }
            catch (Exception exception) {
                privateSecurityManager = null;
                LOGGER.debug("Unable to install security manager", (Throwable)exception);
            }
            SECURITY_MANAGER = privateSecurityManager;
        }
    }

    private static class PrivateSecurityManager
    extends SecurityManager {
        private PrivateSecurityManager() {
        }

        public Class<?> getCaller(String string) {
            Class<?>[] classArray = this.getClassContext();
            boolean bl = false;
            for (Class<?> clazz : classArray) {
                if (clazz.getName().equals(string)) {
                    bl = true;
                    continue;
                }
                if (!bl) continue;
                return clazz;
            }
            return null;
        }
    }
}

