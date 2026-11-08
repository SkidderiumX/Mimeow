/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.spi.DefaultThreadContextMap;
import org.apache.logging.log4j.spi.DefaultThreadContextStack;
import org.apache.logging.log4j.spi.MutableThreadContextStack;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.spi.ThreadContextMap;
import org.apache.logging.log4j.spi.ThreadContextStack;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ProviderUtil;

public class ThreadContext {
    public static final Map<String, String> EMPTY_MAP;
    public static final ThreadContextStack EMPTY_STACK;
    private static final String DISABLE_MAP = "disableThreadContextMap";
    private static final String DISABLE_STACK = "disableThreadContextStack";
    private static final String DISABLE_ALL = "disableThreadContext";
    private static final String THREAD_CONTEXT_KEY = "log4j2.threadContextMap";
    private static boolean all;
    private static boolean useMap;
    private static boolean useStack;
    private static ThreadContextMap contextMap;
    private static ThreadContextStack contextStack;
    private static final Logger LOGGER;

    private ThreadContext() {
    }

    public static void put(String string, String string2) {
        contextMap.put(string, string2);
    }

    public static String get(String string) {
        return contextMap.get(string);
    }

    public static void remove(String string) {
        contextMap.remove(string);
    }

    public static void clear() {
        contextMap.clear();
    }

    public static boolean containsKey(String string) {
        return contextMap.containsKey(string);
    }

    public static Map<String, String> getContext() {
        return contextMap.getCopy();
    }

    public static Map<String, String> getImmutableContext() {
        Map<String, String> map = contextMap.getImmutableMapOrNull();
        return map == null ? EMPTY_MAP : map;
    }

    public static boolean isEmpty() {
        return contextMap.isEmpty();
    }

    public static void clearStack() {
        contextStack.clear();
    }

    public static ContextStack cloneStack() {
        return contextStack.copy();
    }

    public static ContextStack getImmutableStack() {
        return contextStack;
    }

    public static void setStack(Collection<String> collection) {
        if (collection.size() == 0 || !useStack) {
            return;
        }
        contextStack.clear();
        contextStack.addAll(collection);
    }

    public static int getDepth() {
        return contextStack.getDepth();
    }

    public static String pop() {
        return contextStack.pop();
    }

    public static String peek() {
        return contextStack.peek();
    }

    public static void push(String string) {
        contextStack.push(string);
    }

    public static void push(String string, Object ... objectArray) {
        contextStack.push(ParameterizedMessage.format(string, objectArray));
    }

    public static void removeStack() {
        contextStack.clear();
    }

    public static void trim(int n) {
        contextStack.trim(n);
    }

    static {
        Object object;
        EMPTY_MAP = Collections.emptyMap();
        EMPTY_STACK = new MutableThreadContextStack(new ArrayList<String>());
        LOGGER = StatusLogger.getLogger();
        PropertiesUtil propertiesUtil = PropertiesUtil.getProperties();
        all = propertiesUtil.getBooleanProperty(DISABLE_ALL);
        useStack = !propertiesUtil.getBooleanProperty(DISABLE_STACK) && !all;
        contextStack = new DefaultThreadContextStack(useStack);
        useMap = !propertiesUtil.getBooleanProperty(DISABLE_MAP) && !all;
        String string = propertiesUtil.getStringProperty(THREAD_CONTEXT_KEY);
        ClassLoader classLoader = ProviderUtil.findClassLoader();
        if (string != null) {
            try {
                object = classLoader.loadClass(string);
                if (ThreadContextMap.class.isAssignableFrom((Class<?>)object)) {
                    contextMap = (ThreadContextMap)((Class)object).newInstance();
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                LOGGER.error("Unable to locate configured LoggerContextFactory {}", string);
            }
            catch (Exception exception) {
                LOGGER.error("Unable to create configured LoggerContextFactory {}", string, exception);
            }
        }
        if (contextMap == null && ProviderUtil.hasProviders()) {
            object = LogManager.getFactory();
            Iterator<Provider> iterator2 = ProviderUtil.getProviders();
            while (iterator2.hasNext()) {
                Provider provider = iterator2.next();
                string = provider.getThreadContextMap();
                String string2 = provider.getClassName();
                if (string == null || !object.getClass().getName().equals(string2)) continue;
                try {
                    Class<?> clazz = classLoader.loadClass(string);
                    if (!ThreadContextMap.class.isAssignableFrom(clazz)) continue;
                    contextMap = (ThreadContextMap)clazz.newInstance();
                    break;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    LOGGER.error("Unable to locate configured LoggerContextFactory {}", string);
                    contextMap = new DefaultThreadContextMap(useMap);
                }
                catch (Exception exception) {
                    LOGGER.error("Unable to create configured LoggerContextFactory {}", string, exception);
                    contextMap = new DefaultThreadContextMap(useMap);
                }
            }
        }
        if (contextMap == null) {
            contextMap = new DefaultThreadContextMap(useMap);
        }
    }

    public static interface ContextStack
    extends Serializable {
        public void clear();

        public String pop();

        public String peek();

        public void push(String var1);

        public int getDepth();

        public List<String> asList();

        public void trim(int var1);

        public ContextStack copy();
    }
}

