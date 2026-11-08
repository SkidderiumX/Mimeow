/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import joptsimple.ArgumentList;
import joptsimple.OptionArgumentConversionException;
import joptsimple.OptionDescriptor;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;
import joptsimple.internal.Reflection;
import joptsimple.internal.ReflectionException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractOptionSpec<V>
implements OptionSpec<V>,
OptionDescriptor {
    private final List<String> options = new ArrayList<String>();
    private final String description;
    private boolean forHelp;

    protected AbstractOptionSpec(String string) {
        this(Collections.singletonList(string), "");
    }

    protected AbstractOptionSpec(Collection<String> collection, String string) {
        this.arrangeOptions(collection);
        this.description = string;
    }

    @Override
    public final Collection<String> options() {
        return Collections.unmodifiableList(this.options);
    }

    @Override
    public final List<V> values(OptionSet optionSet) {
        return optionSet.valuesOf(this);
    }

    @Override
    public final V value(OptionSet optionSet) {
        return optionSet.valueOf(this);
    }

    @Override
    public String description() {
        return this.description;
    }

    public final AbstractOptionSpec<V> forHelp() {
        this.forHelp = true;
        return this;
    }

    @Override
    public final boolean isForHelp() {
        return this.forHelp;
    }

    @Override
    public boolean representsNonOptions() {
        return false;
    }

    protected abstract V convert(String var1);

    protected V convertWith(ValueConverter<V> valueConverter, String string) {
        try {
            return Reflection.convertWith(valueConverter, string);
        }
        catch (ReflectionException reflectionException) {
            throw new OptionArgumentConversionException(this.options(), string, reflectionException);
        }
        catch (ValueConversionException valueConversionException) {
            throw new OptionArgumentConversionException(this.options(), string, valueConversionException);
        }
    }

    protected String argumentTypeIndicatorFrom(ValueConverter<V> valueConverter) {
        if (valueConverter == null) {
            return null;
        }
        String string = valueConverter.valuePattern();
        return string == null ? valueConverter.valueType().getName() : string;
    }

    abstract void handleOption(OptionParser var1, ArgumentList var2, OptionSet var3, String var4);

    private void arrangeOptions(Collection<String> collection) {
        if (collection.size() == 1) {
            this.options.addAll(collection);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (String string : collection) {
            if (string.length() == 1) {
                arrayList.add(string);
                continue;
            }
            arrayList2.add(string);
        }
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        this.options.addAll(arrayList);
        this.options.addAll(arrayList2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof AbstractOptionSpec)) {
            return false;
        }
        AbstractOptionSpec abstractOptionSpec = (AbstractOptionSpec)object;
        return ((Object)this.options).equals(abstractOptionSpec.options);
    }

    public int hashCode() {
        return ((Object)this.options).hashCode();
    }

    public String toString() {
        return this.options.toString();
    }
}

