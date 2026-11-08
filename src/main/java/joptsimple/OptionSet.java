/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import joptsimple.AbstractOptionSpec;
import joptsimple.MultipleArgumentsForOptionException;
import joptsimple.OptionSpec;
import joptsimple.internal.Objects;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OptionSet {
    private final List<OptionSpec<?>> detectedSpecs = new ArrayList();
    private final Map<String, AbstractOptionSpec<?>> detectedOptions = new HashMap();
    private final Map<AbstractOptionSpec<?>, List<String>> optionsToArguments = new IdentityHashMap();
    private final Map<String, AbstractOptionSpec<?>> recognizedSpecs;
    private final Map<String, List<?>> defaultValues;

    OptionSet(Map<String, AbstractOptionSpec<?>> map) {
        this.defaultValues = OptionSet.defaultValues(map);
        this.recognizedSpecs = map;
    }

    public boolean hasOptions() {
        return !this.detectedOptions.isEmpty();
    }

    public boolean has(String string) {
        return this.detectedOptions.containsKey(string);
    }

    public boolean has(OptionSpec<?> optionSpec) {
        return this.optionsToArguments.containsKey(optionSpec);
    }

    public boolean hasArgument(String string) {
        AbstractOptionSpec<?> abstractOptionSpec = this.detectedOptions.get(string);
        return abstractOptionSpec != null && this.hasArgument(abstractOptionSpec);
    }

    public boolean hasArgument(OptionSpec<?> optionSpec) {
        Objects.ensureNotNull(optionSpec);
        List<String> list = this.optionsToArguments.get(optionSpec);
        return list != null && !list.isEmpty();
    }

    public Object valueOf(String string) {
        Objects.ensureNotNull(string);
        AbstractOptionSpec<?> abstractOptionSpec = this.detectedOptions.get(string);
        if (abstractOptionSpec == null) {
            List list = this.defaultValuesFor(string);
            return list.isEmpty() ? null : list.get(0);
        }
        return this.valueOf(abstractOptionSpec);
    }

    public <V> V valueOf(OptionSpec<V> optionSpec) {
        Objects.ensureNotNull(optionSpec);
        List<V> list = this.valuesOf(optionSpec);
        switch (list.size()) {
            case 0: {
                return null;
            }
            case 1: {
                return list.get(0);
            }
        }
        throw new MultipleArgumentsForOptionException(optionSpec.options());
    }

    public List<?> valuesOf(String string) {
        Objects.ensureNotNull(string);
        AbstractOptionSpec<?> abstractOptionSpec = this.detectedOptions.get(string);
        return abstractOptionSpec == null ? this.defaultValuesFor(string) : this.valuesOf(abstractOptionSpec);
    }

    public <V> List<V> valuesOf(OptionSpec<V> optionSpec) {
        Objects.ensureNotNull(optionSpec);
        List<String> list = this.optionsToArguments.get(optionSpec);
        if (list == null || list.isEmpty()) {
            return this.defaultValueFor(optionSpec);
        }
        AbstractOptionSpec abstractOptionSpec = (AbstractOptionSpec)optionSpec;
        ArrayList arrayList = new ArrayList();
        for (String string : list) {
            arrayList.add(abstractOptionSpec.convert(string));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<OptionSpec<?>> specs() {
        List<OptionSpec<?>> list = this.detectedSpecs;
        list.remove(this.detectedOptions.get("[arguments]"));
        return Collections.unmodifiableList(list);
    }

    public Map<OptionSpec<?>, List<?>> asMap() {
        HashMap hashMap = new HashMap();
        for (AbstractOptionSpec<?> abstractOptionSpec : this.recognizedSpecs.values()) {
            if (abstractOptionSpec.representsNonOptions()) continue;
            hashMap.put(abstractOptionSpec, this.valuesOf(abstractOptionSpec));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<?> nonOptionArguments() {
        return Collections.unmodifiableList(this.valuesOf(this.detectedOptions.get("[arguments]")));
    }

    void add(AbstractOptionSpec<?> abstractOptionSpec) {
        this.addWithArgument(abstractOptionSpec, null);
    }

    void addWithArgument(AbstractOptionSpec<?> abstractOptionSpec, String string) {
        this.detectedSpecs.add(abstractOptionSpec);
        for (String string2 : abstractOptionSpec.options()) {
            this.detectedOptions.put(string2, abstractOptionSpec);
        }
        List<String> list = this.optionsToArguments.get(abstractOptionSpec);
        if (list == null) {
            list = new ArrayList<String>();
            this.optionsToArguments.put(abstractOptionSpec, list);
        }
        if (string != null) {
            list.add(string);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        }
        OptionSet optionSet = (OptionSet)object;
        HashMap hashMap = new HashMap(this.optionsToArguments);
        HashMap hashMap2 = new HashMap(optionSet.optionsToArguments);
        return ((Object)this.detectedOptions).equals(optionSet.detectedOptions) && ((Object)hashMap).equals(hashMap2);
    }

    public int hashCode() {
        HashMap hashMap = new HashMap(this.optionsToArguments);
        return ((Object)this.detectedOptions).hashCode() ^ ((Object)hashMap).hashCode();
    }

    private <V> List<V> defaultValuesFor(String string) {
        if (this.defaultValues.containsKey(string)) {
            return this.defaultValues.get(string);
        }
        return Collections.emptyList();
    }

    private <V> List<V> defaultValueFor(OptionSpec<V> optionSpec) {
        return this.defaultValuesFor(optionSpec.options().iterator().next());
    }

    private static Map<String, List<?>> defaultValues(Map<String, AbstractOptionSpec<?>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, AbstractOptionSpec<?>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().defaultValues());
        }
        return hashMap;
    }
}

