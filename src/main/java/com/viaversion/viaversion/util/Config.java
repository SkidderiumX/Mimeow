/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.libs.snakeyaml.DumperOptions;
import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.Yaml;
import com.viaversion.viaversion.libs.snakeyaml.constructor.SafeConstructor;
import com.viaversion.viaversion.libs.snakeyaml.nodes.NodeId;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Tag;
import com.viaversion.viaversion.libs.snakeyaml.representer.Representer;
import com.viaversion.viaversion.util.CommentStore;
import com.viaversion.viaversion.util.ConfigSection;
import com.viaversion.viaversion.util.InputStreamSupplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class Config
extends ConfigSection {
    private static final ThreadLocal<Yaml> YAML = ThreadLocal.withInitial(() -> {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        dumperOptions.setPrettyFlow(false);
        dumperOptions.setSplitLines(false);
        dumperOptions.setIndent(2);
        return new Yaml(new CustomSafeConstructor(), new Representer(dumperOptions), dumperOptions);
    });
    private final CommentStore commentStore = new CommentStore('.', 2);
    private final File configFile;
    protected final Logger logger;
    private ConfigSection originalRoot;

    protected Config(File file, Logger logger) {
        super(null, "");
        this.configFile = file;
        this.logger = logger;
    }

    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viaversion/config.yml");
    }

    public InputStream getDefaultConfigInputStream() {
        return this.getClass().getClassLoader().getResourceAsStream("assets/viaversion/config.yml");
    }

    public Map<String, Object> loadConfig(File file) {
        URL uRL = this.getDefaultConfigURL();
        if (uRL != null) {
            return this.loadConfig(file, uRL);
        }
        return this.loadConfig(file, this::getDefaultConfigInputStream);
    }

    public synchronized Map<String, Object> loadConfig(File file, URL uRL) {
        return this.loadConfig(file, uRL::openStream);
    }

    private synchronized Map<String, Object> loadConfig(File file, InputStreamSupplier inputStreamSupplier) {
        Object object;
        Object object2;
        this.originalRoot = null;
        List<String> list = this.getUnsupportedOptions();
        try {
            object2 = inputStreamSupplier.get();
            try {
                this.commentStore.storeComments((InputStream)object2);
                for (String object3 : list) {
                    List<String> list2 = this.commentStore.header(object3);
                    if (list2 == null) continue;
                    list2.clear();
                }
            }
            finally {
                if (object2 != null) {
                    ((InputStream)object2).close();
                }
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to load default config comments", iOException);
        }
        object2 = null;
        if (file.exists()) {
            try {
                object = new FileInputStream(file);
                try {
                    object2 = (Map)YAML.get().load((InputStream)object);
                }
                finally {
                    ((FileInputStream)object).close();
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException("Failed to load config", iOException);
            }
            catch (Exception exception) {
                this.logger.severe("Failed to load config, make sure your input is valid");
                throw new RuntimeException("Failed to load config (malformed input?)", exception);
            }
        }
        try (InputStream iOException = inputStreamSupplier.get();){
            object = (Map)YAML.get().load(iOException);
        }
        catch (IOException iOException2) {
            throw new RuntimeException("Failed to load default config", iOException2);
        }
        for (String string : list) {
            object.remove(string);
        }
        if (object2 != null) {
            this.merge(null, (Map<String, Object>)object2, (Map<String, Object>)object);
        }
        this.handleConfig((Map<String, Object>)object);
        ConfigSection configSection = this.originalRoot = object2 != null ? new ConfigSection(this, "", (Map<String, Object>)object2) : null;
        if (!object.equals(object2)) {
            this.save(file, (Map<String, Object>)object);
        }
        return object;
    }

    private void merge(@Nullable String string2, Map<String, Object> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String string3 = entry.getKey();
            Object object = entry.getValue();
            if (object instanceof Map) {
                Map map3 = (Map)object;
                Object object3 = map2.get(string3);
                if (object3 instanceof Map) {
                    Map map4 = (Map)object3;
                    this.merge(string3, map3, map4);
                    continue;
                }
            }
            if (string2 != null && this.getSectionsWithModifiableKeys().contains(string2)) {
                map2.put(string3, object);
                continue;
            }
            map2.computeIfPresent(string3, (string, object2) -> object);
        }
    }

    protected void handleConfig(Map<String, Object> map) {
    }

    public synchronized void save(File file, Map<String, Object> map) {
        try {
            this.commentStore.writeComments(YAML.get().dump(map), file);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public List<String> getUnsupportedOptions() {
        return List.of();
    }

    public Set<String> getSectionsWithModifiableKeys() {
        return Set.of();
    }

    public void save() {
        if (this.configFile.getParentFile() != null) {
            this.configFile.getParentFile().mkdirs();
        }
        this.save(this.configFile, this.values);
    }

    public void save(File file) {
        this.save(file, this.values);
    }

    public void reload() {
        if (this.configFile.getParentFile() != null) {
            this.configFile.getParentFile().mkdirs();
        }
        this.values = Collections.synchronizedMap(this.loadConfig(this.configFile));
    }

    @Override
    public Config root() {
        return this;
    }

    @Override
    public Logger logger() {
        return this.logger;
    }

    public @Nullable ConfigSection originalRootSection() {
        return this.originalRoot;
    }

    private static final class CustomSafeConstructor
    extends SafeConstructor {
        public CustomSafeConstructor() {
            super(new LoaderOptions());
            this.yamlClassConstructors.put(NodeId.mapping, new SafeConstructor.ConstructYamlMap());
            this.yamlConstructors.put(Tag.OMAP, new SafeConstructor.ConstructYamlOmap());
        }
    }
}

