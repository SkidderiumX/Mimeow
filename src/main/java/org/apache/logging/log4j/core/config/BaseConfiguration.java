/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationListener;
import org.apache.logging.log4j.core.config.ConfigurationMonitor;
import org.apache.logging.log4j.core.config.DefaultAdvertiser;
import org.apache.logging.log4j.core.config.DefaultConfigurationMonitor;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.Loggers;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.PluginAliases;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.config.plugins.PluginNode;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.apache.logging.log4j.core.filter.AbstractFilterable;
import org.apache.logging.log4j.core.helpers.NameUtil;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.MapLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.core.net.Advertiser;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class BaseConfiguration
extends AbstractFilterable
implements Configuration {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    protected Node rootNode;
    protected final List<ConfigurationListener> listeners = new CopyOnWriteArrayList<ConfigurationListener>();
    protected ConfigurationMonitor monitor = new DefaultConfigurationMonitor();
    private Advertiser advertiser = new DefaultAdvertiser();
    protected Map<String, String> advertisedConfiguration;
    private Node advertiserNode = null;
    private Object advertisement;
    protected boolean isShutdownHookEnabled = true;
    private String name;
    private ConcurrentMap<String, Appender> appenders = new ConcurrentHashMap<String, Appender>();
    private ConcurrentMap<String, LoggerConfig> loggers = new ConcurrentHashMap<String, LoggerConfig>();
    private final StrLookup tempLookup = new Interpolator();
    private final StrSubstitutor subst = new StrSubstitutor(this.tempLookup);
    private LoggerConfig root = new LoggerConfig();
    private final boolean started = false;
    private final ConcurrentMap<String, Object> componentMap = new ConcurrentHashMap<String, Object>();
    protected PluginManager pluginManager = new PluginManager("Core");

    protected BaseConfiguration() {
        this.rootNode = new Node();
    }

    @Override
    public Map<String, String> getProperties() {
        return (Map)this.componentMap.get("ContextProperties");
    }

    @Override
    public void start() {
        this.pluginManager.collectPlugins();
        this.setup();
        this.setupAdvertisement();
        this.doConfigure();
        for (Object object : this.loggers.values()) {
            ((AbstractFilterable)object).startFilter();
        }
        for (Object object : this.appenders.values()) {
            object.start();
        }
        this.root.startFilter();
        this.startFilter();
    }

    @Override
    public void stop() {
        Appender[] appenderArray = this.appenders.values().toArray(new Appender[this.appenders.size()]);
        for (int i = appenderArray.length - 1; i >= 0; --i) {
            appenderArray[i].stop();
        }
        for (LoggerConfig loggerConfig : this.loggers.values()) {
            loggerConfig.clearAppenders();
            loggerConfig.stopFilter();
        }
        this.root.stopFilter();
        this.stopFilter();
        if (this.advertiser != null && this.advertisement != null) {
            this.advertiser.unadvertise(this.advertisement);
        }
    }

    @Override
    public boolean isShutdownHookEnabled() {
        return this.isShutdownHookEnabled;
    }

    protected void setup() {
    }

    protected Level getDefaultStatus() {
        String string = PropertiesUtil.getProperties().getStringProperty("Log4jDefaultStatusLevel", Level.ERROR.name());
        try {
            return Level.toLevel(string);
        }
        catch (Exception exception) {
            return Level.ERROR;
        }
    }

    protected void createAdvertiser(String string, ConfigurationFactory.ConfigurationSource configurationSource, byte[] byArray, String string2) {
        if (string != null) {
            Node node = new Node(null, string, null);
            Map<String, String> map = node.getAttributes();
            map.put("content", new String(byArray));
            map.put("contentType", string2);
            map.put("name", "configuration");
            if (configurationSource.getLocation() != null) {
                map.put("location", configurationSource.getLocation());
            }
            this.advertiserNode = node;
        }
    }

    private void setupAdvertisement() {
        String string;
        PluginType<?> pluginType;
        if (this.advertiserNode != null && (pluginType = this.pluginManager.getPluginType(string = this.advertiserNode.getName())) != null) {
            Class<?> clazz = pluginType.getPluginClass();
            try {
                this.advertiser = (Advertiser)clazz.newInstance();
                this.advertisement = this.advertiser.advertise(this.advertiserNode.getAttributes());
            }
            catch (InstantiationException instantiationException) {
                System.err.println("InstantiationException attempting to instantiate advertiser: " + string);
            }
            catch (IllegalAccessException illegalAccessException) {
                System.err.println("IllegalAccessException attempting to instantiate advertiser: " + string);
            }
        }
    }

    public Object getComponent(String string) {
        return this.componentMap.get(string);
    }

    @Override
    public void addComponent(String string, Object object) {
        this.componentMap.putIfAbsent(string, object);
    }

    protected void doConfigure() {
        Object object;
        boolean bl = false;
        boolean bl2 = false;
        for (Node object2 : this.rootNode.getChildren()) {
            this.createConfiguration(object2, null);
            if (object2.getObject() == null) continue;
            if (object2.getName().equalsIgnoreCase("Properties")) {
                if (this.tempLookup == this.subst.getVariableResolver()) {
                    this.subst.setVariableResolver((StrLookup)object2.getObject());
                    continue;
                }
                LOGGER.error("Properties declaration must be the first element in the configuration");
                continue;
            }
            if (this.tempLookup == this.subst.getVariableResolver()) {
                object = (Map)this.componentMap.get("ContextProperties");
                MapLookup mapLookup = object == null ? null : new MapLookup((Map<String, String>)object);
                this.subst.setVariableResolver(new Interpolator(mapLookup));
            }
            if (object2.getName().equalsIgnoreCase("Appenders")) {
                this.appenders = (ConcurrentMap)object2.getObject();
                continue;
            }
            if (object2.getObject() instanceof Filter) {
                this.addFilter((Filter)object2.getObject());
                continue;
            }
            if (object2.getName().equalsIgnoreCase("Loggers")) {
                object = (Loggers)object2.getObject();
                this.loggers = ((Loggers)object).getMap();
                bl2 = true;
                if (((Loggers)object).getRoot() == null) continue;
                this.root = ((Loggers)object).getRoot();
                bl = true;
                continue;
            }
            LOGGER.error("Unknown object \"" + object2.getName() + "\" of type " + object2.getObject().getClass().getName() + " is ignored");
        }
        if (!bl2) {
            LOGGER.warn("No Loggers were configured, using default. Is the Loggers element missing?");
            this.setToDefault();
            return;
        }
        if (!bl) {
            LOGGER.warn("No Root logger was configured, creating default ERROR-level Root logger with Console appender");
            this.setToDefault();
        }
        for (Map.Entry entry : this.loggers.entrySet()) {
            object = (LoggerConfig)entry.getValue();
            for (AppenderRef appenderRef : ((LoggerConfig)object).getAppenderRefs()) {
                Appender appender = (Appender)this.appenders.get(appenderRef.getRef());
                if (appender != null) {
                    ((LoggerConfig)object).addAppender(appender, appenderRef.getLevel(), appenderRef.getFilter());
                    continue;
                }
                LOGGER.error("Unable to locate appender " + appenderRef.getRef() + " for logger " + ((LoggerConfig)object).getName());
            }
        }
        this.setParents();
    }

    private void setToDefault() {
        PatternLayout patternLayout = null;
        ConsoleAppender consoleAppender = null;
        LoggerConfig loggerConfig = null;
        String string = null;
        Level level = null;
        int n = 537809587;
        block7: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case -1056745158: {
                    level = Level.valueOf(string);
                    n = -279002553;
                    continue block7;
                }
                case -683327132: {
                    if (Level.valueOf(string) != null) {
                        n = -1056745158;
                        continue block7;
                    }
                    n = 1829466222;
                    continue block7;
                }
                case 537809587: {
                    this.setName("Default");
                    patternLayout = PatternLayout.createLayout("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n", null, null, null, null);
                    consoleAppender = ConsoleAppender.createAppender(patternLayout, null, "SYSTEM_OUT", "Console", "false", "true");
                    consoleAppender.start();
                    this.addAppender(consoleAppender);
                    loggerConfig = this.getRootLogger();
                    loggerConfig.addAppender(consoleAppender, null, null);
                    string = PropertiesUtil.getProperties().getStringProperty("org.apache.logging.log4j.level");
                    if (string != null) {
                        n = -683327132;
                        continue block7;
                    }
                    n = 1829466222;
                    continue block7;
                }
                case 1829466222: {
                    level = Level.ERROR;
                    n = -279002553;
                    continue block7;
                }
                case -279002553: 
            }
            break;
        }
        loggerConfig.setLevel(level);
    }

    public void setName(String string) {
        this.name = string;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addListener(ConfigurationListener configurationListener) {
        this.listeners.add(configurationListener);
    }

    @Override
    public void removeListener(ConfigurationListener configurationListener) {
        this.listeners.remove(configurationListener);
    }

    public Appender getAppender(String string) {
        return (Appender)this.appenders.get(string);
    }

    @Override
    public Map<String, Appender> getAppenders() {
        return this.appenders;
    }

    public void addAppender(Appender appender) {
        this.appenders.put(appender.getName(), appender);
    }

    @Override
    public StrSubstitutor getStrSubstitutor() {
        return this.subst;
    }

    @Override
    public void setConfigurationMonitor(ConfigurationMonitor configurationMonitor) {
        this.monitor = configurationMonitor;
    }

    @Override
    public ConfigurationMonitor getConfigurationMonitor() {
        return this.monitor;
    }

    @Override
    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    @Override
    public Advertiser getAdvertiser() {
        return this.advertiser;
    }

    @Override
    public synchronized void addLoggerAppender(org.apache.logging.log4j.core.Logger logger, Appender appender) {
        String string = logger.getName();
        this.appenders.putIfAbsent(appender.getName(), appender);
        LoggerConfig loggerConfig = this.getLoggerConfig(string);
        if (loggerConfig.getName().equals(string)) {
            loggerConfig.addAppender(appender, null, null);
        } else {
            LoggerConfig loggerConfig2 = new LoggerConfig(string, loggerConfig.getLevel(), loggerConfig.isAdditive());
            loggerConfig2.addAppender(appender, null, null);
            loggerConfig2.setParent(loggerConfig);
            this.loggers.putIfAbsent(string, loggerConfig2);
            this.setParents();
            logger.getContext().updateLoggers();
        }
    }

    @Override
    public synchronized void addLoggerFilter(org.apache.logging.log4j.core.Logger logger, Filter filter) {
        String string = logger.getName();
        LoggerConfig loggerConfig = this.getLoggerConfig(string);
        if (loggerConfig.getName().equals(string)) {
            loggerConfig.addFilter(filter);
        } else {
            LoggerConfig loggerConfig2 = new LoggerConfig(string, loggerConfig.getLevel(), loggerConfig.isAdditive());
            loggerConfig2.addFilter(filter);
            loggerConfig2.setParent(loggerConfig);
            this.loggers.putIfAbsent(string, loggerConfig2);
            this.setParents();
            logger.getContext().updateLoggers();
        }
    }

    @Override
    public synchronized void setLoggerAdditive(org.apache.logging.log4j.core.Logger logger, boolean bl) {
        String string = logger.getName();
        LoggerConfig loggerConfig = this.getLoggerConfig(string);
        if (loggerConfig.getName().equals(string)) {
            loggerConfig.setAdditive(bl);
        } else {
            LoggerConfig loggerConfig2 = new LoggerConfig(string, loggerConfig.getLevel(), bl);
            loggerConfig2.setParent(loggerConfig);
            this.loggers.putIfAbsent(string, loggerConfig2);
            this.setParents();
            logger.getContext().updateLoggers();
        }
    }

    public synchronized void removeAppender(String string) {
        for (LoggerConfig loggerConfig : this.loggers.values()) {
            loggerConfig.removeAppender(string);
        }
        Appender appender = (Appender)this.appenders.remove(string);
        if (appender != null) {
            appender.stop();
        }
    }

    @Override
    public LoggerConfig getLoggerConfig(String string) {
        if (this.loggers.containsKey(string)) {
            return (LoggerConfig)this.loggers.get(string);
        }
        String string2 = string;
        while ((string2 = NameUtil.getSubName(string2)) != null) {
            if (!this.loggers.containsKey(string2)) continue;
            return (LoggerConfig)this.loggers.get(string2);
        }
        return this.root;
    }

    public LoggerConfig getRootLogger() {
        return this.root;
    }

    @Override
    public Map<String, LoggerConfig> getLoggers() {
        return Collections.unmodifiableMap(this.loggers);
    }

    public LoggerConfig getLogger(String string) {
        return (LoggerConfig)this.loggers.get(string);
    }

    public void addLogger(String string, LoggerConfig loggerConfig) {
        this.loggers.put(string, loggerConfig);
        this.setParents();
    }

    public void removeLogger(String string) {
        this.loggers.remove(string);
        this.setParents();
    }

    @Override
    public void createConfiguration(Node node, LogEvent logEvent) {
        PluginType<?> pluginType = node.getType();
        if (pluginType != null && pluginType.isDeferChildren()) {
            node.setObject(this.createPluginObject(pluginType, node, logEvent));
        } else {
            for (Node node2 : node.getChildren()) {
                this.createConfiguration(node2, logEvent);
            }
            if (pluginType == null) {
                if (node.getParent() != null) {
                    LOGGER.error("Unable to locate plugin for " + node.getName());
                }
            } else {
                node.setObject(this.createPluginObject(pluginType, node, logEvent));
            }
        }
    }

    private <T> Object createPluginObject(PluginType<T> pluginType, Node node, LogEvent logEvent) {
        Class<?>[] classArray;
        Class<T> clazz = pluginType.getPluginClass();
        if (Map.class.isAssignableFrom(clazz)) {
            try {
                Map map = (Map)clazz.newInstance();
                for (Node node2 : node.getChildren()) {
                    map.put(node2.getName(), node2.getObject());
                }
                return map;
            }
            catch (Exception exception) {
                LOGGER.warn("Unable to create Map for " + pluginType.getElementName() + " of class " + clazz);
            }
        }
        if (List.class.isAssignableFrom(clazz)) {
            try {
                List list = (List)clazz.newInstance();
                for (Node node3 : node.getChildren()) {
                    list.add(node3.getObject());
                }
                return list;
            }
            catch (Exception exception) {
                LOGGER.warn("Unable to create List for " + pluginType.getElementName() + " of class " + clazz);
            }
        }
        Method method = null;
        for (Method method2 : clazz.getMethods()) {
            if (!method2.isAnnotationPresent(PluginFactory.class)) continue;
            method = method2;
            break;
        }
        if (method == null) {
            return null;
        }
        Method[] methodArray = method.getParameterAnnotations();
        if (methodArray.length != (classArray = method.getParameterTypes()).length) {
            LOGGER.error("Number of parameter annotations does not equal the number of paramters");
        }
        Object[] objectArray = new Object[classArray.length];
        int n = 0;
        Map<String, String> map = node.getAttributes();
        List<Node> list = node.getChildren();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Node> arrayList = new ArrayList<Node>();
        for (Method object : methodArray) {
            String[] stringArray = null;
            for (Method method2 : object) {
                if (!(method2 instanceof PluginAliases)) continue;
                stringArray = ((PluginAliases)((Object)method2)).value();
            }
            for (Method method2 : object) {
                Class<?> clazz2;
                String string;
                Object object2;
                if (method2 instanceof PluginAliases) continue;
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(" with params(");
                } else {
                    stringBuilder.append(", ");
                }
                if (method2 instanceof PluginNode) {
                    objectArray[n] = node;
                    stringBuilder.append("Node=").append(node.getName());
                    continue;
                }
                if (method2 instanceof PluginConfiguration) {
                    objectArray[n] = this;
                    if (this.name != null) {
                        stringBuilder.append("Configuration(").append(this.name).append(")");
                        continue;
                    }
                    stringBuilder.append("Configuration");
                    continue;
                }
                if (method2 instanceof PluginValue) {
                    object2 = ((PluginValue)((Object)method2)).value();
                    string = node.getValue();
                    if (string == null) {
                        string = this.getAttrValue("value", null, map);
                    }
                    clazz2 = this.subst.replace(logEvent, string);
                    stringBuilder.append((String)object2).append("=\"").append((String)((Object)clazz2)).append("\"");
                    objectArray[n] = clazz2;
                    continue;
                }
                if (method2 instanceof PluginAttribute) {
                    object2 = (PluginAttribute)((Object)method2);
                    string = object2.value();
                    clazz2 = this.subst.replace(logEvent, this.getAttrValue(string, stringArray, map));
                    stringBuilder.append(string).append("=\"").append((String)((Object)clazz2)).append("\"");
                    objectArray[n] = clazz2;
                    continue;
                }
                if (!(method2 instanceof PluginElement)) continue;
                object2 = (PluginElement)((Object)method2);
                string = object2.value();
                if (classArray[n].isArray()) {
                    Object object3;
                    Object object4;
                    clazz2 = classArray[n].getComponentType();
                    ArrayList<Object> arrayList2 = new ArrayList<Object>();
                    stringBuilder.append(string).append("={");
                    boolean bl = true;
                    for (Node node2 : list) {
                        object4 = node2.getType();
                        if (!object2.value().equalsIgnoreCase(((PluginType)object4).getElementName()) && !clazz2.isAssignableFrom(((PluginType)object4).getPluginClass())) continue;
                        arrayList.add(node2);
                        if (!bl) {
                            stringBuilder.append(", ");
                        }
                        bl = false;
                        object3 = node2.getObject();
                        if (object3 == null) {
                            LOGGER.error("Null object returned for " + node2.getName() + " in " + node.getName());
                            continue;
                        }
                        if (object3.getClass().isArray()) {
                            this.printArray(stringBuilder, (Object[])object3);
                            objectArray[n] = object3;
                            break;
                        }
                        stringBuilder.append(node2.toString());
                        arrayList2.add(object3);
                    }
                    stringBuilder.append("}");
                    if (objectArray[n] != null) break;
                    if (arrayList2.size() > 0 && !clazz2.isAssignableFrom(arrayList2.get(0).getClass())) {
                        LOGGER.error("Attempted to assign List containing class " + arrayList2.get(0).getClass().getName() + " to array of type " + clazz2 + " for attribute " + string);
                        break;
                    }
                    Object[] objectArray2 = (Object[])Array.newInstance(clazz2, arrayList2.size());
                    int n2 = 0;
                    object4 = arrayList2.iterator();
                    while (object4.hasNext()) {
                        objectArray2[n2] = object3 = object4.next();
                        ++n2;
                    }
                    objectArray[n] = objectArray2;
                    continue;
                }
                clazz2 = classArray[n];
                boolean bl = false;
                for (Node node3 : list) {
                    PluginType<?> pluginType2 = node3.getType();
                    if (!object2.value().equals(pluginType2.getElementName()) && !clazz2.isAssignableFrom(pluginType2.getPluginClass())) continue;
                    stringBuilder.append(node3.getName()).append("(").append(node3.toString()).append(")");
                    bl = true;
                    arrayList.add(node3);
                    objectArray[n] = node3.getObject();
                    break;
                }
                if (bl) continue;
                stringBuilder.append("null");
            }
            ++n;
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(")");
        }
        if (map.size() > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String string : map.keySet()) {
                if (stringBuilder2.length() == 0) {
                    stringBuilder2.append(node.getName());
                    stringBuilder2.append(" contains ");
                    if (map.size() == 1) {
                        stringBuilder2.append("an invalid element or attribute ");
                    } else {
                        stringBuilder2.append("invalid attributes ");
                    }
                } else {
                    stringBuilder2.append(", ");
                }
                stringBuilder2.append("\"");
                stringBuilder2.append(string);
                stringBuilder2.append("\"");
            }
            LOGGER.error(stringBuilder2.toString());
        }
        if (!pluginType.isDeferChildren() && arrayList.size() != list.size()) {
            for (Node node5 : list) {
                if (arrayList.contains(node5)) continue;
                String string = node.getType().getElementName();
                String string2 = string.equals(node.getName()) ? node.getName() : string + " " + node.getName();
                LOGGER.error(string2 + " has no parameter that matches element " + node5.getName());
            }
        }
        try {
            int n3 = method.getModifiers();
            if (!Modifier.isStatic(n3)) {
                LOGGER.error(method.getName() + " method is not static on class " + clazz.getName() + " for element " + node.getName());
                return null;
            }
            LOGGER.debug("Calling {} on class {} for element {}{}", method.getName(), clazz.getName(), node.getName(), stringBuilder.toString());
            return method.invoke(null, objectArray);
        }
        catch (Exception exception) {
            LOGGER.error("Unable to invoke method " + method.getName() + " in class " + clazz.getName() + " for element " + node.getName(), (Throwable)exception);
            return null;
        }
    }

    private void printArray(StringBuilder stringBuilder, Object ... objectArray) {
        boolean bl = true;
        for (Object object : objectArray) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object.toString());
            bl = false;
        }
    }

    private String getAttrValue(String string, String[] stringArray, Map<String, String> map) {
        for (String string2 : map.keySet()) {
            if (string2.equalsIgnoreCase(string)) {
                String string3 = map.get(string2);
                map.remove(string2);
                return string3;
            }
            if (stringArray == null) continue;
            for (String string4 : stringArray) {
                if (!string2.equalsIgnoreCase(string4)) continue;
                String string5 = map.get(string2);
                map.remove(string2);
                return string5;
            }
        }
        return null;
    }

    private void setParents() {
        for (Map.Entry entry : this.loggers.entrySet()) {
            LoggerConfig loggerConfig = (LoggerConfig)entry.getValue();
            String string = (String)entry.getKey();
            if (string.equals("")) continue;
            int n = string.lastIndexOf(46);
            if (n > 0) {
                LoggerConfig loggerConfig2 = this.getLoggerConfig(string = string.substring(0, n));
                if (loggerConfig2 == null) {
                    loggerConfig2 = this.root;
                }
                loggerConfig.setParent(loggerConfig2);
                continue;
            }
            loggerConfig.setParent(this.root);
        }
    }
}

