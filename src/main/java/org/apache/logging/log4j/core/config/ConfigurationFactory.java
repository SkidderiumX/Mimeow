/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.config.plugins.PluginType;
import org.apache.logging.log4j.core.helpers.FileUtils;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public abstract class ConfigurationFactory {
    public static final String CONFIGURATION_FACTORY_PROPERTY = "log4j.configurationFactory";
    public static final String CONFIGURATION_FILE_PROPERTY = "log4j.configurationFile";
    protected static final Logger LOGGER = StatusLogger.getLogger();
    protected static final String TEST_PREFIX = "log4j2-test";
    protected static final String DEFAULT_PREFIX = "log4j2";
    private static final String CLASS_LOADER_SCHEME = "classloader";
    private static final int CLASS_LOADER_SCHEME_LENGTH = "classloader".length() + 1;
    private static final String CLASS_PATH_SCHEME = "classpath";
    private static final int CLASS_PATH_SCHEME_LENGTH = "classpath".length() + 1;
    private static volatile List<ConfigurationFactory> factories = null;
    private static ConfigurationFactory configFactory = new Factory();
    protected final StrSubstitutor substitutor = new StrSubstitutor(new Interpolator());

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ConfigurationFactory getInstance() {
        if (factories != null) return configFactory;
        String string = TEST_PREFIX;
        synchronized (TEST_PREFIX) {
            if (factories != null) return configFactory;
            ArrayList<ConfigurationFactory> arrayList = new ArrayList<ConfigurationFactory>();
            String string2 = PropertiesUtil.getProperties().getStringProperty(CONFIGURATION_FACTORY_PROPERTY);
            if (string2 != null) {
                ConfigurationFactory.addFactory(arrayList, string2);
            }
            PluginManager pluginManager = new PluginManager("ConfigurationFactory");
            pluginManager.collectPlugins();
            Map<String, PluginType<?>> map = pluginManager.getPlugins();
            TreeSet<WeightedFactory> treeSet = new TreeSet<WeightedFactory>();
            for (PluginType<?> pluginType : map.values()) {
                try {
                    Class<ConfigurationFactory> clazz = pluginType.getPluginClass();
                    Order order = clazz.getAnnotation(Order.class);
                    if (order == null) continue;
                    int n = order.value();
                    treeSet.add(new WeightedFactory(n, clazz));
                }
                catch (Exception exception) {
                    LOGGER.warn("Unable to add class " + pluginType.getPluginClass());
                }
            }
            for (WeightedFactory weightedFactory : treeSet) {
                ConfigurationFactory.addFactory(arrayList, weightedFactory.factoryClass);
            }
            factories = Collections.unmodifiableList(arrayList);
            // ** MonitorExit[var0] (shouldn't be in output)
            return configFactory;
        }
    }

    private static void addFactory(List<ConfigurationFactory> list, String string) {
        try {
            ConfigurationFactory.addFactory(list, Class.forName(string));
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.error("Unable to load class " + string, (Throwable)classNotFoundException);
        }
        catch (Exception exception) {
            LOGGER.error("Unable to load class " + string, (Throwable)exception);
        }
    }

    private static void addFactory(List<ConfigurationFactory> list, Class<ConfigurationFactory> clazz) {
        try {
            list.add(clazz.newInstance());
        }
        catch (Exception exception) {
            LOGGER.error("Unable to create instance of " + clazz.getName(), (Throwable)exception);
        }
    }

    public static void setConfigurationFactory(ConfigurationFactory configurationFactory) {
        configFactory = configurationFactory;
    }

    public static void resetConfigurationFactory() {
        configFactory = new Factory();
    }

    public static void removeConfigurationFactory(ConfigurationFactory configurationFactory) {
        if (configFactory == configurationFactory) {
            configFactory = new Factory();
        }
    }

    protected abstract String[] getSupportedTypes();

    protected boolean isActive() {
        return true;
    }

    public abstract Configuration getConfiguration(ConfigurationSource var1);

    public Configuration getConfiguration(String string, URI uRI) {
        ConfigurationSource configurationSource;
        if (!this.isActive()) {
            return null;
        }
        if (uRI != null && (configurationSource = this.getInputFromURI(uRI)) != null) {
            return this.getConfiguration(configurationSource);
        }
        return null;
    }

    protected ConfigurationSource getInputFromURI(URI uRI) {
        ClassLoader classLoader;
        String string;
        ConfigurationSource configurationSource;
        boolean bl;
        String string2;
        File file = FileUtils.fileFromURI(uRI);
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new ConfigurationSource((InputStream)new FileInputStream(file), file);
            }
            catch (FileNotFoundException fileNotFoundException) {
                LOGGER.error("Cannot locate file " + uRI.getPath(), (Throwable)fileNotFoundException);
            }
        }
        boolean bl2 = (string2 = uRI.getScheme()) != null && string2.equals(CLASS_LOADER_SCHEME);
        boolean bl3 = bl = string2 != null && !bl2 && string2.equals(CLASS_PATH_SCHEME);
        if ((string2 == null || bl2 || bl) && (configurationSource = this.getInputFromResource(string = bl2 ? uRI.toString().substring(CLASS_LOADER_SCHEME_LENGTH) : (bl ? uRI.toString().substring(CLASS_PATH_SCHEME_LENGTH) : uRI.getPath()), classLoader = this.getClass().getClassLoader())) != null) {
            return configurationSource;
        }
        try {
            return new ConfigurationSource(uRI.toURL().openStream(), uRI.getPath());
        }
        catch (MalformedURLException malformedURLException) {
            LOGGER.error("Invalid URL " + uRI.toString(), (Throwable)malformedURLException);
        }
        catch (IOException iOException) {
            LOGGER.error("Unable to access " + uRI.toString(), (Throwable)iOException);
        }
        catch (Exception exception) {
            LOGGER.error("Unable to access " + uRI.toString(), (Throwable)exception);
        }
        return null;
    }

    protected ConfigurationSource getInputFromString(String string, ClassLoader classLoader) {
        try {
            URL uRL = new URL(string);
            return new ConfigurationSource(uRL.openStream(), FileUtils.fileFromURI(uRL.toURI()));
        }
        catch (Exception exception) {
            ConfigurationSource configurationSource = this.getInputFromResource(string, classLoader);
            if (configurationSource == null) {
                try {
                    File file = new File(string);
                    return new ConfigurationSource((InputStream)new FileInputStream(file), file);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    // empty catch block
                }
            }
            return configurationSource;
        }
    }

    protected ConfigurationSource getInputFromResource(String string, ClassLoader classLoader) {
        URL uRL = Loader.getResource(string, classLoader);
        if (uRL == null) {
            return null;
        }
        InputStream inputStream2 = null;
        try {
            inputStream2 = uRL.openStream();
        }
        catch (IOException iOException) {
            return null;
        }
        if (inputStream2 == null) {
            return null;
        }
        if (FileUtils.isFile(uRL)) {
            try {
                return new ConfigurationSource(inputStream2, FileUtils.fileFromURI(uRL.toURI()));
            }
            catch (URISyntaxException uRISyntaxException) {
                // empty catch block
            }
        }
        return new ConfigurationSource(inputStream2, string);
    }

    public static class ConfigurationSource {
        private File file;
        private String location;
        private InputStream stream;

        public ConfigurationSource() {
        }

        public ConfigurationSource(InputStream inputStream2) {
            this.stream = inputStream2;
            this.file = null;
            this.location = null;
        }

        public ConfigurationSource(InputStream inputStream2, File file) {
            this.stream = inputStream2;
            this.file = file;
            this.location = file.getAbsolutePath();
        }

        public ConfigurationSource(InputStream inputStream2, String string) {
            this.stream = inputStream2;
            this.location = string;
            this.file = null;
        }

        public File getFile() {
            return this.file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public String getLocation() {
            return this.location;
        }

        public void setLocation(String string) {
            this.location = string;
        }

        public InputStream getInputStream() {
            return this.stream;
        }

        public void setInputStream(InputStream inputStream2) {
            this.stream = inputStream2;
        }
    }

    private static class Factory
    extends ConfigurationFactory {
        private Factory() {
        }

        @Override
        public Configuration getConfiguration(String string, URI uRI) {
            Object object;
            if (uRI == null) {
                object = this.substitutor.replace(PropertiesUtil.getProperties().getStringProperty(ConfigurationFactory.CONFIGURATION_FILE_PROPERTY));
                if (object != null) {
                    ConfigurationSource configurationSource = null;
                    try {
                        configurationSource = this.getInputFromURI(new URI((String)object));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    if (configurationSource == null) {
                        ClassLoader classLoader = this.getClass().getClassLoader();
                        configurationSource = this.getInputFromString((String)object, classLoader);
                    }
                    if (configurationSource != null) {
                        for (ConfigurationFactory configurationFactory : factories) {
                            String[] stringArray = configurationFactory.getSupportedTypes();
                            if (stringArray == null) continue;
                            for (String string2 : stringArray) {
                                Configuration configuration;
                                if (!string2.equals("*") && !((String)object).endsWith(string2) || (configuration = configurationFactory.getConfiguration(configurationSource)) == null) continue;
                                return configuration;
                            }
                        }
                    }
                }
            } else {
                object = factories.iterator();
                while (object.hasNext()) {
                    ConfigurationFactory configurationFactory = (ConfigurationFactory)object.next();
                    String[] stringArray = configurationFactory.getSupportedTypes();
                    if (stringArray == null) continue;
                    for (String string3 : stringArray) {
                        Configuration configuration;
                        if (!string3.equals("*") && !uRI.toString().endsWith(string3) || (configuration = configurationFactory.getConfiguration(string, uRI)) == null) continue;
                        return configuration;
                    }
                }
            }
            if ((object = this.getConfiguration(true, string)) == null && (object = this.getConfiguration(true, null)) == null && (object = this.getConfiguration(false, string)) == null) {
                object = this.getConfiguration(false, null);
            }
            return object != null ? object : new DefaultConfiguration();
        }

        private Configuration getConfiguration(boolean bl, String string) {
            boolean bl2 = string != null && string.length() > 0;
            ClassLoader classLoader = this.getClass().getClassLoader();
            for (ConfigurationFactory configurationFactory : factories) {
                String string2 = bl ? ConfigurationFactory.TEST_PREFIX : ConfigurationFactory.DEFAULT_PREFIX;
                String[] stringArray = configurationFactory.getSupportedTypes();
                if (stringArray == null) continue;
                for (String string3 : stringArray) {
                    String string4;
                    ConfigurationSource configurationSource;
                    if (string3.equals("*") || (configurationSource = this.getInputFromResource(string4 = bl2 ? string2 + string + string3 : string2 + string3, classLoader)) == null) continue;
                    return configurationFactory.getConfiguration(configurationSource);
                }
            }
            return null;
        }

        @Override
        public String[] getSupportedTypes() {
            return null;
        }

        @Override
        public Configuration getConfiguration(ConfigurationSource configurationSource) {
            if (configurationSource != null) {
                String string = configurationSource.getLocation();
                for (ConfigurationFactory configurationFactory : factories) {
                    String[] stringArray = configurationFactory.getSupportedTypes();
                    if (stringArray == null) continue;
                    for (String string2 : stringArray) {
                        if (!string2.equals("*") && (string == null || !string.endsWith(string2))) continue;
                        Configuration configuration = configurationFactory.getConfiguration(configurationSource);
                        if (configuration != null) {
                            return configuration;
                        }
                        LOGGER.error("Cannot determine the ConfigurationFactory to use for {}", string);
                        return null;
                    }
                }
            }
            LOGGER.error("Cannot process configuration, input source is null");
            return null;
        }
    }

    private static class WeightedFactory
    implements Comparable<WeightedFactory> {
        private final int weight;
        private final Class<ConfigurationFactory> factoryClass;

        public WeightedFactory(int n, Class<ConfigurationFactory> clazz) {
            this.weight = n;
            this.factoryClass = clazz;
        }

        @Override
        public int compareTo(WeightedFactory weightedFactory) {
            int n = weightedFactory.weight;
            if (this.weight == n) {
                return 0;
            }
            if (this.weight > n) {
                return -1;
            }
            return 1;
        }
    }
}

