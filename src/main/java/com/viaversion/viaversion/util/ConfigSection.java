/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ConfigSection {
    protected final Config root;
    protected final String path;
    protected Map<String, Object> values;

    ConfigSection(Config config2, String string) {
        this(config2, string, new HashMap<String, Object>());
    }

    ConfigSection(Config config2, String string, Map<String, Object> map) {
        this.root = config2;
        this.path = string;
        this.values = map;
    }

    public void set(String string, Object object) {
        this.values.put(string, object);
    }

    public Map<String, Object> getValues() {
        return this.values;
    }

    public <T> @Nullable T get(String string) {
        return this.get(string, null);
    }

    public boolean contains(String string) {
        return this.get(string) != null;
    }

    public <T> @Nullable T get(String string, @Nullable T t) {
        String[] stringArray = string.split("\\.");
        ConfigSection configSection = this;
        for (int i = 0; i < stringArray.length - 1; ++i) {
            if ((configSection = configSection.getSection(stringArray[i])) != null) continue;
            return t;
        }
        String string2 = stringArray[stringArray.length - 1];
        Object object = configSection.values.get(string2);
        return (T)(object != null ? object : t);
    }

    public boolean getBoolean(String string, boolean bl) {
        Object object = this.values.get(string);
        return object instanceof Boolean ? (Boolean)object : bl;
    }

    public @Nullable String getString(String string, @Nullable String string2) {
        String string3;
        Object object = this.values.get(string);
        return object instanceof String ? (string3 = (String)object) : string2;
    }

    public int getInt(String string, int n) {
        int n2;
        Object object = this.values.get(string);
        if (object instanceof Number) {
            Number number = (Number)object;
            n2 = number.intValue();
        } else {
            n2 = n;
        }
        return n2;
    }

    public double getDouble(String string, double d) {
        double d2;
        Object object = this.values.get(string);
        if (object instanceof Number) {
            Number number = (Number)object;
            d2 = number.doubleValue();
        } else {
            d2 = d;
        }
        return d2;
    }

    public List<Integer> getIntegerList(String string) {
        Object object = this.values.get(string);
        return object != null ? (List)object : new ArrayList();
    }

    public List<String> getStringList(String string) {
        Object object = this.values.get(string);
        return object != null ? (List)object : new ArrayList();
    }

    public <T> List<T> getListSafe(String string, Class<T> clazz, String string2) {
        Object object = this.values.get(string);
        if (object instanceof List) {
            List list = (List)object;
            ArrayList<T> arrayList = new ArrayList<T>(list.size());
            for (Object e : list) {
                if (clazz.isInstance(e)) {
                    arrayList.add(clazz.cast(e));
                    continue;
                }
                if (string2 == null) continue;
                this.logger().warning(String.format(string2, e));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public @Nullable JsonElement getSerializedComponent(String string) {
        Object object = this.values.get(string);
        if (object != null && !((String)object).isEmpty()) {
            return ComponentUtil.legacyToJson((String)object);
        }
        return null;
    }

    public @Nullable ConfigSection getSection(String string) {
        Object t = this.get(string);
        return t instanceof Map ? new ConfigSection(this.root(), this.fullKeyInPath(string), (Map)t) : null;
    }

    private String fullKeyInPath(String string) {
        return this.path.isEmpty() ? string : this.path + "." + string;
    }

    public Config root() {
        return this.root;
    }

    protected Logger logger() {
        return this.root().logger();
    }
}

