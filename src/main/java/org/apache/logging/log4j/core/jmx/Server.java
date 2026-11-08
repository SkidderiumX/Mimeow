/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.jmx;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.management.InstanceAlreadyExistsException;
import javax.management.JMException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.jmx.AppenderAdmin;
import org.apache.logging.log4j.core.jmx.ContextSelectorAdmin;
import org.apache.logging.log4j.core.jmx.LoggerConfigAdmin;
import org.apache.logging.log4j.core.jmx.LoggerContextAdmin;
import org.apache.logging.log4j.core.jmx.StatusLoggerAdmin;
import org.apache.logging.log4j.core.selector.ContextSelector;
import org.apache.logging.log4j.status.StatusLogger;

public class Server {
    private static final String PROPERTY_DISABLE_JMX = "log4j2.disable.jmx";

    private Server() {
    }

    public static String escape(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length() * 2);
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '*': 
                case ',': 
                case ':': 
                case '=': 
                case '?': 
                case '\\': {
                    stringBuilder.append('\\');
                    bl = true;
                }
            }
            stringBuilder.append(c);
        }
        if (bl) {
            stringBuilder.insert(0, '\"');
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public static void registerMBeans(ContextSelector contextSelector) throws JMException {
        if (Boolean.getBoolean(PROPERTY_DISABLE_JMX)) {
            StatusLogger.getLogger().debug("JMX disabled for log4j2. Not registering MBeans.");
            return;
        }
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Server.registerMBeans(contextSelector, mBeanServer);
    }

    public static void registerMBeans(ContextSelector contextSelector, final MBeanServer mBeanServer) throws JMException {
        if (Boolean.getBoolean(PROPERTY_DISABLE_JMX)) {
            StatusLogger.getLogger().debug("JMX disabled for log4j2. Not registering MBeans.");
            return;
        }
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        Server.registerStatusLogger(mBeanServer, executorService);
        Server.registerContextSelector(contextSelector, mBeanServer, executorService);
        List<LoggerContext> list = contextSelector.getLoggerContexts();
        Server.registerContexts(list, mBeanServer, executorService);
        for (final LoggerContext loggerContext : list) {
            loggerContext.addPropertyChangeListener(new PropertyChangeListener(){

                @Override
                public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                    if (!"config".equals(propertyChangeEvent.getPropertyName())) {
                        return;
                    }
                    Server.unregisterLoggerConfigs(loggerContext, mBeanServer);
                    Server.unregisterAppenders(loggerContext, mBeanServer);
                    try {
                        Server.registerLoggerConfigs(loggerContext, mBeanServer, executorService);
                        Server.registerAppenders(loggerContext, mBeanServer, executorService);
                    }
                    catch (Exception exception) {
                        StatusLogger.getLogger().error("Could not register mbeans", (Throwable)exception);
                    }
                }
            });
        }
    }

    private static void registerStatusLogger(MBeanServer mBeanServer, Executor executor) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        StatusLoggerAdmin statusLoggerAdmin = new StatusLoggerAdmin(executor);
        mBeanServer.registerMBean(statusLoggerAdmin, statusLoggerAdmin.getObjectName());
    }

    private static void registerContextSelector(ContextSelector contextSelector, MBeanServer mBeanServer, Executor executor) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        ContextSelectorAdmin contextSelectorAdmin = new ContextSelectorAdmin(contextSelector);
        mBeanServer.registerMBean(contextSelectorAdmin, contextSelectorAdmin.getObjectName());
    }

    private static void registerContexts(List<LoggerContext> list, MBeanServer mBeanServer, Executor executor) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        for (LoggerContext loggerContext : list) {
            LoggerContextAdmin loggerContextAdmin = new LoggerContextAdmin(loggerContext, executor);
            mBeanServer.registerMBean(loggerContextAdmin, loggerContextAdmin.getObjectName());
        }
    }

    private static void unregisterLoggerConfigs(LoggerContext loggerContext, MBeanServer mBeanServer) {
        String string = "org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=LoggerConfig,name=%s";
        String string2 = String.format("org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=LoggerConfig,name=%s", loggerContext.getName(), "*");
        Server.unregisterAllMatching(string2, mBeanServer);
    }

    private static void unregisterAppenders(LoggerContext loggerContext, MBeanServer mBeanServer) {
        String string = "org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=Appender,name=%s";
        String string2 = String.format("org.apache.logging.log4j2:type=LoggerContext,ctx=%s,sub=Appender,name=%s", loggerContext.getName(), "*");
        Server.unregisterAllMatching(string2, mBeanServer);
    }

    private static void unregisterAllMatching(String string, MBeanServer mBeanServer) {
        try {
            ObjectName objectName = new ObjectName(string);
            Set<ObjectName> set = mBeanServer.queryNames(objectName, null);
            for (ObjectName objectName2 : set) {
                mBeanServer.unregisterMBean(objectName2);
            }
        }
        catch (Exception exception) {
            StatusLogger.getLogger().error("Could not unregister " + string, (Throwable)exception);
        }
    }

    private static void registerLoggerConfigs(LoggerContext loggerContext, MBeanServer mBeanServer, Executor executor) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        Map<String, LoggerConfig> map = loggerContext.getConfiguration().getLoggers();
        for (String string : map.keySet()) {
            LoggerConfig loggerConfig = map.get(string);
            LoggerConfigAdmin loggerConfigAdmin = new LoggerConfigAdmin(loggerContext.getName(), loggerConfig);
            mBeanServer.registerMBean(loggerConfigAdmin, loggerConfigAdmin.getObjectName());
        }
    }

    private static void registerAppenders(LoggerContext loggerContext, MBeanServer mBeanServer, Executor executor) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        Map<String, Appender> map = loggerContext.getConfiguration().getAppenders();
        for (String string : map.keySet()) {
            Appender appender = map.get(string);
            AppenderAdmin appenderAdmin = new AppenderAdmin(loggerContext.getName(), appender);
            mBeanServer.registerMBean(appenderAdmin, appenderAdmin.getObjectName());
        }
    }
}

