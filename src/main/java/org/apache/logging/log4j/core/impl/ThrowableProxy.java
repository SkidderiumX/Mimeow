/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.ReflectiveCallerClassUtility;
import org.apache.logging.log4j.core.impl.StackTracePackageElement;
import org.apache.logging.log4j.status.StatusLogger;

public class ThrowableProxy
implements Serializable {
    private static final long serialVersionUID = -2752771578252251910L;
    private static final Logger LOGGER;
    private static final PrivateSecurityManager SECURITY_MANAGER;
    private static final Method GET_SUPPRESSED;
    private static final Method ADD_SUPPRESSED;
    private final ThrowableProxy proxyCause;
    private final Throwable throwable;
    private final String name;
    private final StackTracePackageElement[] callerPackageData;
    private int commonElementCount;

    public ThrowableProxy(Throwable throwable) {
        this.throwable = throwable;
        this.name = throwable.getClass().getName();
        HashMap<String, CacheEntry> hashMap = new HashMap<String, CacheEntry>();
        Stack<Class<?>> stack = this.getCurrentStack();
        this.callerPackageData = this.resolvePackageData(stack, hashMap, null, throwable.getStackTrace());
        this.proxyCause = throwable.getCause() == null ? null : new ThrowableProxy(throwable, stack, hashMap, throwable.getCause());
        this.setSuppressed(throwable);
    }

    private ThrowableProxy(Throwable throwable, Stack<Class<?>> stack, Map<String, CacheEntry> map, Throwable throwable2) {
        this.throwable = throwable2;
        this.name = throwable2.getClass().getName();
        this.callerPackageData = this.resolvePackageData(stack, map, throwable.getStackTrace(), throwable2.getStackTrace());
        this.proxyCause = throwable2.getCause() == null ? null : new ThrowableProxy(throwable, stack, map, throwable2.getCause());
        this.setSuppressed(throwable2);
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public ThrowableProxy getCause() {
        return this.proxyCause;
    }

    public String getName() {
        return this.name;
    }

    public int getCommonElementCount() {
        return this.commonElementCount;
    }

    public StackTracePackageElement[] getPackageData() {
        return this.callerPackageData;
    }

    public String toString() {
        String string = this.throwable.getMessage();
        return string != null ? this.name + ": " + string : this.name;
    }

    public String getRootCauseStackTrace() {
        return this.getRootCauseStackTrace(null);
    }

    public String getRootCauseStackTrace(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.proxyCause != null) {
            this.formatWrapper(stringBuilder, this.proxyCause);
            stringBuilder.append("Wrapped by: ");
        }
        stringBuilder.append(this.toString());
        stringBuilder.append("\n");
        this.formatElements(stringBuilder, 0, this.throwable.getStackTrace(), this.callerPackageData, list);
        return stringBuilder.toString();
    }

    public void formatWrapper(StringBuilder stringBuilder, ThrowableProxy throwableProxy) {
        this.formatWrapper(stringBuilder, throwableProxy, null);
    }

    public void formatWrapper(StringBuilder stringBuilder, ThrowableProxy throwableProxy, List<String> list) {
        Throwable throwable;
        Throwable throwable2 = throwable = throwableProxy.getCause() != null ? throwableProxy.getCause().getThrowable() : null;
        if (throwable != null) {
            this.formatWrapper(stringBuilder, throwableProxy.proxyCause);
            stringBuilder.append("Wrapped by: ");
        }
        stringBuilder.append(throwableProxy).append("\n");
        this.formatElements(stringBuilder, throwableProxy.commonElementCount, throwableProxy.getThrowable().getStackTrace(), throwableProxy.callerPackageData, list);
    }

    public String getExtendedStackTrace() {
        return this.getExtendedStackTrace(null);
    }

    public String getExtendedStackTrace(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(this.name);
        String string = this.throwable.getMessage();
        if (string != null) {
            stringBuilder.append(": ").append(this.throwable.getMessage());
        }
        stringBuilder.append("\n");
        this.formatElements(stringBuilder, 0, this.throwable.getStackTrace(), this.callerPackageData, list);
        if (this.proxyCause != null) {
            this.formatCause(stringBuilder, this.proxyCause, list);
        }
        return stringBuilder.toString();
    }

    public String getSuppressedStackTrace() {
        ThrowableProxy[] throwableProxyArray = this.getSuppressed();
        if (throwableProxyArray == null || throwableProxyArray.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("Suppressed Stack Trace Elements:\n");
        for (ThrowableProxy throwableProxy : throwableProxyArray) {
            stringBuilder.append(throwableProxy.getExtendedStackTrace());
        }
        return stringBuilder.toString();
    }

    private void formatCause(StringBuilder stringBuilder, ThrowableProxy throwableProxy, List<String> list) {
        stringBuilder.append("Caused by: ").append(throwableProxy).append("\n");
        this.formatElements(stringBuilder, throwableProxy.commonElementCount, throwableProxy.getThrowable().getStackTrace(), throwableProxy.callerPackageData, list);
        if (throwableProxy.getCause() != null) {
            this.formatCause(stringBuilder, throwableProxy.proxyCause, list);
        }
    }

    private void formatElements(StringBuilder stringBuilder, int n, StackTraceElement[] stackTraceElementArray, StackTracePackageElement[] stackTracePackageElementArray, List<String> list) {
        if (list == null || list.size() == 0) {
            for (int i = 0; i < stackTracePackageElementArray.length; ++i) {
                this.formatEntry(stackTraceElementArray[i], stackTracePackageElementArray[i], stringBuilder);
            }
        } else {
            int n2 = 0;
            for (int i = 0; i < stackTracePackageElementArray.length; ++i) {
                if (!this.isSuppressed(stackTraceElementArray[i], list)) {
                    if (n2 > 0) {
                        if (n2 == 1) {
                            stringBuilder.append("\t....\n");
                        } else {
                            stringBuilder.append("\t... suppressed ").append(n2).append(" lines\n");
                        }
                        n2 = 0;
                    }
                    this.formatEntry(stackTraceElementArray[i], stackTracePackageElementArray[i], stringBuilder);
                    continue;
                }
                ++n2;
            }
            if (n2 > 0) {
                if (n2 == 1) {
                    stringBuilder.append("\t...\n");
                } else {
                    stringBuilder.append("\t... suppressed ").append(n2).append(" lines\n");
                }
            }
        }
        if (n != 0) {
            stringBuilder.append("\t... ").append(n).append(" more").append("\n");
        }
    }

    private void formatEntry(StackTraceElement stackTraceElement, StackTracePackageElement stackTracePackageElement, StringBuilder stringBuilder) {
        stringBuilder.append("\tat ");
        stringBuilder.append(stackTraceElement);
        stringBuilder.append(" ");
        stringBuilder.append(stackTracePackageElement);
        stringBuilder.append("\n");
    }

    private boolean isSuppressed(StackTraceElement stackTraceElement, List<String> list) {
        String string = stackTraceElement.getClassName();
        for (String string2 : list) {
            if (!string.startsWith(string2)) continue;
            return true;
        }
        return false;
    }

    private Stack<Class<?>> getCurrentStack() {
        if (ReflectiveCallerClassUtility.isSupported()) {
            Stack stack = new Stack();
            int n = 1;
            Class<?> clazz = ReflectiveCallerClassUtility.getCaller(n);
            while (clazz != null) {
                stack.push(clazz);
                clazz = ReflectiveCallerClassUtility.getCaller(++n);
            }
            return stack;
        }
        if (SECURITY_MANAGER != null) {
            Class<?>[] classArray = SECURITY_MANAGER.getClasses();
            Stack stack = new Stack();
            for (Class<?> clazz : classArray) {
                stack.push(clazz);
            }
            return stack;
        }
        return new Stack();
    }

    StackTracePackageElement[] resolvePackageData(Stack<Class<?>> stack, Map<String, CacheEntry> map, StackTraceElement[] stackTraceElementArray, StackTraceElement[] stackTraceElementArray2) {
        int n;
        if (stackTraceElementArray != null) {
            int n2;
            int n3 = stackTraceElementArray.length - 1;
            for (n2 = stackTraceElementArray2.length - 1; n3 >= 0 && n2 >= 0 && stackTraceElementArray[n3].equals(stackTraceElementArray2[n2]); --n3, --n2) {
            }
            this.commonElementCount = stackTraceElementArray2.length - 1 - n2;
            n = n2 + 1;
        } else {
            this.commonElementCount = 0;
            n = stackTraceElementArray2.length;
        }
        StackTracePackageElement[] stackTracePackageElementArray = new StackTracePackageElement[n];
        Class<?> clazz = stack.isEmpty() ? null : stack.peek();
        ClassLoader classLoader = null;
        for (int i = n - 1; i >= 0; --i) {
            CacheEntry cacheEntry;
            String string = stackTraceElementArray2[i].getClassName();
            if (clazz != null && string.equals(clazz.getName())) {
                cacheEntry = this.resolvePackageElement(clazz, true);
                stackTracePackageElementArray[i] = cacheEntry.element;
                classLoader = cacheEntry.loader;
                stack.pop();
                clazz = stack.isEmpty() ? null : stack.peek();
                continue;
            }
            if (map.containsKey(string)) {
                cacheEntry = map.get(string);
                stackTracePackageElementArray[i] = cacheEntry.element;
                if (cacheEntry.loader == null) continue;
                classLoader = cacheEntry.loader;
                continue;
            }
            cacheEntry = this.resolvePackageElement(this.loadClass(classLoader, string), false);
            stackTracePackageElementArray[i] = cacheEntry.element;
            map.put(string, cacheEntry);
            if (cacheEntry.loader == null) continue;
            classLoader = cacheEntry.loader;
        }
        return stackTracePackageElementArray;
    }

    private CacheEntry resolvePackageElement(Class<?> clazz, boolean bl) {
        String string = "?";
        Object object = "?";
        ClassLoader classLoader = null;
        if (clazz != null) {
            Object object2;
            Object object3;
            try {
                object3 = clazz.getProtectionDomain().getCodeSource();
                if (object3 != null && (object2 = ((CodeSource)object3).getLocation()) != null) {
                    String string2 = ((URL)object2).toString().replace('\\', '/');
                    int n = string2.lastIndexOf("/");
                    if (n >= 0 && n == string2.length() - 1) {
                        n = string2.lastIndexOf("/", n - 1);
                        string = string2.substring(n + 1);
                    } else {
                        string = string2.substring(n + 1);
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            object3 = clazz.getPackage();
            if (object3 != null && (object2 = ((Package)object3).getImplementationVersion()) != null) {
                object = object2;
            }
            classLoader = clazz.getClassLoader();
        }
        return new CacheEntry(new StackTracePackageElement(string, (String)object, bl), classLoader);
    }

    private Class<?> loadClass(ClassLoader classLoader, String string) {
        Class<?> clazz;
        if (classLoader != null) {
            try {
                clazz = classLoader.loadClass(string);
                if (clazz != null) {
                    return clazz;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        try {
            clazz = Thread.currentThread().getContextClassLoader().loadClass(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            try {
                clazz = Class.forName(string);
            }
            catch (ClassNotFoundException classNotFoundException2) {
                try {
                    clazz = this.getClass().getClassLoader().loadClass(string);
                }
                catch (ClassNotFoundException classNotFoundException3) {
                    return null;
                }
            }
        }
        return clazz;
    }

    public ThrowableProxy[] getSuppressed() {
        if (GET_SUPPRESSED != null) {
            try {
                return (ThrowableProxy[])GET_SUPPRESSED.invoke(this.throwable, new Object[0]);
            }
            catch (Exception exception) {
                return null;
            }
        }
        return null;
    }

    private void setSuppressed(Throwable throwable) {
        if (GET_SUPPRESSED != null && ADD_SUPPRESSED != null) {
            try {
                Throwable[] throwableArray;
                for (Throwable throwable2 : throwableArray = (Throwable[])GET_SUPPRESSED.invoke(throwable, new Object[0])) {
                    ADD_SUPPRESSED.invoke(this, new ThrowableProxy(throwable2));
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    static {
        Method[] methodArray;
        Object object;
        LOGGER = StatusLogger.getLogger();
        if (ReflectiveCallerClassUtility.isSupported()) {
            SECURITY_MANAGER = null;
        } else {
            try {
                object = new PrivateSecurityManager();
                if (((PrivateSecurityManager)object).getClasses() == null) {
                    object = null;
                    LOGGER.error("Unable to obtain call stack from security manager.");
                }
            }
            catch (Exception exception) {
                object = null;
                LOGGER.debug("Unable to install security manager.", (Throwable)exception);
            }
            SECURITY_MANAGER = object;
        }
        object = null;
        Method method = null;
        for (Method method2 : methodArray = Throwable.class.getMethods()) {
            if (method2.getName().equals("getSuppressed")) {
                object = method2;
                continue;
            }
            if (!method2.getName().equals("addSuppressed")) continue;
            method = method2;
        }
        GET_SUPPRESSED = object;
        ADD_SUPPRESSED = method;
    }

    private static class PrivateSecurityManager
    extends SecurityManager {
        private PrivateSecurityManager() {
        }

        public Class<?>[] getClasses() {
            return this.getClassContext();
        }
    }

    public class CacheEntry {
        private final StackTracePackageElement element;
        private final ClassLoader loader;

        public CacheEntry(StackTracePackageElement stackTracePackageElement, ClassLoader classLoader) {
            this.element = stackTracePackageElement;
            this.loader = classLoader;
        }
    }
}

