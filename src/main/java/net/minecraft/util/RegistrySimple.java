/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.util.IRegistry;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrySimple<K, V>
implements IRegistry<K, V> {
    private static final Logger logger = LogManager.getLogger();
    protected final Map<K, V> registryObjects = this.createUnderlyingMap();

    protected Map<K, V> createUnderlyingMap() {
        return Maps.newHashMap();
    }

    @Override
    public V getObject(K k) {
        return this.registryObjects.get(k);
    }

    @Override
    public void putObject(K k, V v) {
        Validate.notNull(k);
        Validate.notNull(v);
        if (this.registryObjects.containsKey(k)) {
            logger.debug("Adding duplicate key '" + String.valueOf(k) + "' to registry");
        }
        this.registryObjects.put(k, v);
    }

    public Set<K> getKeys() {
        return Collections.unmodifiableSet(this.registryObjects.keySet());
    }

    public boolean containsKey(K k) {
        return this.registryObjects.containsKey(k);
    }

    @Override
    public Iterator<V> iterator() {
        return this.registryObjects.values().iterator();
    }
}

