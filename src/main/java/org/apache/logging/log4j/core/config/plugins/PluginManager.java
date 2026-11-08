/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config.plugins;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAliases;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.config.plugins.ResolverUtil;
import org.apache.logging.log4j.core.helpers.Closer;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.status.StatusLogger;

public class PluginManager {
    private static final long NANOS_PER_SECOND = 1000000000L;
    private static ConcurrentMap<String, ConcurrentMap<String, PluginType<?>>> pluginTypeMap = new ConcurrentHashMap();
    private static final CopyOnWriteArrayList<String> PACKAGES = new CopyOnWriteArrayList();
    private static final String PATH = "org/apache/logging/log4j/core/config/plugins/";
    private static final String FILENAME = "Log4j2Plugins.dat";
    private static final String LOG4J_PACKAGES = "org.apache.logging.log4j.core";
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static String rootDir;
    private Map<String, PluginType<?>> plugins = new HashMap();
    private final String type;
    private final Class<?> clazz;

    public PluginManager(String string) {
        this.type = string;
        this.clazz = null;
    }

    public PluginManager(String string, Class<?> clazz) {
        this.type = string;
        this.clazz = clazz;
    }

    public static void main(String[] stringArray) throws Exception {
        if (stringArray == null || stringArray.length < 1) {
            System.err.println("A target directory must be specified");
            System.exit(-1);
        }
        rootDir = stringArray[0].endsWith("/") || stringArray[0].endsWith("\\") ? stringArray[0] : stringArray[0] + "/";
        PluginManager pluginManager = new PluginManager("Core");
        String string = stringArray.length == 2 ? stringArray[1] : null;
        pluginManager.collectPlugins(false, string);
        PluginManager.encode(pluginTypeMap);
    }

    public static void addPackage(String string) {
        if (PACKAGES.addIfAbsent(string)) {
            pluginTypeMap.clear();
        }
    }

    public PluginType<?> getPluginType(String string) {
        return this.plugins.get(string.toLowerCase());
    }

    public Map<String, PluginType<?>> getPlugins() {
        return this.plugins;
    }

    public void collectPlugins() {
        this.collectPlugins(true, null);
    }

    public void collectPlugins(boolean bl, String string) {
        Object object2;
        if (pluginTypeMap.containsKey(this.type)) {
            this.plugins = (Map)pluginTypeMap.get(this.type);
            bl = false;
        }
        long l = System.nanoTime();
        ResolverUtil resolverUtil = new ResolverUtil();
        ClassLoader classLoader = Loader.getClassLoader();
        if (classLoader != null) {
            resolverUtil.setClassLoader(classLoader);
        }
        if (bl) {
            object2 = PluginManager.decode(classLoader);
            if (object2 != null) {
                pluginTypeMap = object2;
                this.plugins = (Map)object2.get(this.type);
            } else {
                LOGGER.warn("Plugin preloads not available from class loader {}", classLoader);
            }
        }
        if (this.plugins == null || this.plugins.size() == 0) {
            if (string == null) {
                if (!PACKAGES.contains(LOG4J_PACKAGES)) {
                    PACKAGES.add(LOG4J_PACKAGES);
                }
            } else {
                object2 = string.split(",");
                for (String object3 : object2) {
                    PACKAGES.add(object3);
                }
            }
        }
        object2 = new PluginTest(this.clazz);
        for (String string2 : PACKAGES) {
            resolverUtil.findInPackage((ResolverUtil.Test)object2, string2);
        }
        for (Class clazz : resolverUtil.getClasses()) {
            Plugin plugin = clazz.getAnnotation(Plugin.class);
            String string2 = plugin.category();
            if (!pluginTypeMap.containsKey(string2)) {
                pluginTypeMap.putIfAbsent(string2, new ConcurrentHashMap());
            }
            Map map = (Map)pluginTypeMap.get(string2);
            String string3 = plugin.elementType().equals("") ? plugin.name() : plugin.elementType();
            PluginType pluginType = new PluginType(clazz, string3, plugin.printObject(), plugin.deferChildren());
            map.put(plugin.name().toLowerCase(), pluginType);
            PluginAliases pluginAliases = clazz.getAnnotation(PluginAliases.class);
            if (pluginAliases == null) continue;
            for (String string4 : pluginAliases.value()) {
                string3 = plugin.elementType().equals("") ? string4 : plugin.elementType();
                pluginType = new PluginType(clazz, string3, plugin.printObject(), plugin.deferChildren());
                map.put(string4.trim().toLowerCase(), pluginType);
            }
        }
        long l2 = System.nanoTime() - l;
        this.plugins = (Map)pluginTypeMap.get(this.type);
        StringBuilder stringBuilder = new StringBuilder("Generated plugins");
        stringBuilder.append(" in ");
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        long l3 = l2 / 1000000000L;
        stringBuilder.append(decimalFormat.format(l3)).append('.');
        DecimalFormat decimalFormat2 = new DecimalFormat("000000000");
        stringBuilder.append(decimalFormat2.format(l2 %= 1000000000L)).append(" seconds");
        LOGGER.debug(stringBuilder.toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ConcurrentMap<String, ConcurrentMap<String, PluginType<?>>> decode(ClassLoader classLoader) {
        Enumeration<URL> enumeration;
        try {
            enumeration = classLoader.getResources("org/apache/logging/log4j/core/config/plugins/Log4j2Plugins.dat");
        }
        catch (IOException iOException) {
            LOGGER.warn("Unable to preload plugins", (Throwable)iOException);
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        while (enumeration.hasMoreElements()) {
            InputStream inputStream2;
            DataInputStream dataInputStream = null;
            try {
                URL uRL = enumeration.nextElement();
                LOGGER.debug("Found Plugin Map at {}", uRL.toExternalForm());
                inputStream2 = uRL.openStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
                dataInputStream = new DataInputStream(bufferedInputStream);
                int n = dataInputStream.readInt();
                for (int i = 0; i < n; ++i) {
                    String string = dataInputStream.readUTF();
                    int n2 = dataInputStream.readInt();
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap)concurrentHashMap.get(string);
                    if (concurrentHashMap2 == null) {
                        concurrentHashMap2 = new ConcurrentHashMap(n);
                    }
                    for (int j = 0; j < n2; ++j) {
                        String string2 = dataInputStream.readUTF();
                        String string3 = dataInputStream.readUTF();
                        String string4 = dataInputStream.readUTF();
                        boolean bl = dataInputStream.readBoolean();
                        boolean bl2 = dataInputStream.readBoolean();
                        Class<?> clazz = Class.forName(string3);
                        concurrentHashMap2.put(string2, new PluginType(clazz, string4, bl, bl2));
                    }
                    concurrentHashMap.putIfAbsent(string, concurrentHashMap2);
                }
                Closer.closeSilent(dataInputStream);
            }
            catch (Exception exception) {
                LOGGER.warn("Unable to preload plugins", (Throwable)exception);
                inputStream2 = null;
                return inputStream2;
            }
            finally {
                Closer.closeSilent(dataInputStream);
            }
        }
        return concurrentHashMap.size() == 0 ? null : concurrentHashMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void encode(ConcurrentMap<String, ConcurrentMap<String, PluginType<?>>> concurrentMap) {
        String string = rootDir + PATH + FILENAME;
        DataOutputStream dataOutputStream = null;
        try {
            File file = new File(rootDir + PATH);
            file.mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            dataOutputStream = new DataOutputStream(bufferedOutputStream);
            dataOutputStream.writeInt(concurrentMap.size());
            for (Map.Entry entry : concurrentMap.entrySet()) {
                dataOutputStream.writeUTF((String)entry.getKey());
                dataOutputStream.writeInt(((ConcurrentMap)entry.getValue()).size());
                for (Map.Entry entry2 : ((ConcurrentMap)entry.getValue()).entrySet()) {
                    dataOutputStream.writeUTF((String)entry2.getKey());
                    PluginType pluginType = (PluginType)entry2.getValue();
                    dataOutputStream.writeUTF(pluginType.getPluginClass().getName());
                    dataOutputStream.writeUTF(pluginType.getElementName());
                    dataOutputStream.writeBoolean(pluginType.isObjectPrintable());
                    dataOutputStream.writeBoolean(pluginType.isDeferChildren());
                }
            }
            Closer.closeSilent(dataOutputStream);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            Closer.closeSilent(dataOutputStream);
        }
    }

    public static class PluginTest
    extends ResolverUtil.ClassTest {
        private final Class<?> isA;

        public PluginTest(Class<?> clazz) {
            this.isA = clazz;
        }

        @Override
        public boolean matches(Class<?> clazz) {
            return clazz != null && clazz.isAnnotationPresent(Plugin.class) && (this.isA == null || this.isA.isAssignableFrom(clazz));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("annotated with @" + Plugin.class.getSimpleName());
            if (this.isA != null) {
                stringBuilder.append(" is assignable to " + this.isA.getSimpleName());
            }
            return stringBuilder.toString();
        }
    }
}

