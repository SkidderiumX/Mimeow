/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import com.viaversion.viaversion.libs.gson.ExclusionStrategy;
import com.viaversion.viaversion.libs.gson.FieldNamingPolicy;
import com.viaversion.viaversion.libs.gson.FieldNamingStrategy;
import com.viaversion.viaversion.libs.gson.FormattingStyle;
import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.InstanceCreator;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonSerializer;
import com.viaversion.viaversion.libs.gson.LongSerializationPolicy;
import com.viaversion.viaversion.libs.gson.ReflectionAccessFilter;
import com.viaversion.viaversion.libs.gson.Strictness;
import com.viaversion.viaversion.libs.gson.ToNumberPolicy;
import com.viaversion.viaversion.libs.gson.ToNumberStrategy;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.ConstructorConstructor;
import com.viaversion.viaversion.libs.gson.internal.Excluder;
import com.viaversion.viaversion.libs.gson.internal.bind.ArrayTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.CollectionTypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.bind.DefaultDateTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.bind.MapTypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.bind.NumberTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.ObjectTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.bind.TreeTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.TypeAdapters;
import com.viaversion.viaversion.libs.gson.internal.sql.SqlTypesSupport;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class GsonBuilder {
    private static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final Strictness DEFAULT_STRICTNESS = null;
    private static final FormattingStyle DEFAULT_FORMATTING_STYLE = FormattingStyle.COMPACT;
    private static final boolean DEFAULT_ESCAPE_HTML = true;
    private static final boolean DEFAULT_SERIALIZE_NULLS = false;
    private static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    private static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    private static final String DEFAULT_DATE_PATTERN = null;
    private static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    private static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    private static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    static final ConstructorConstructor DEFAULT_CONSTRUCTOR_CONSTRUCTOR = new ConstructorConstructor(Collections.emptyMap(), true, Collections.emptyList());
    static final JsonAdapterAnnotationTypeAdapterFactory DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY = new JsonAdapterAnnotationTypeAdapterFactory(DEFAULT_CONSTRUCTOR_CONSTRUCTOR);
    static final GsonBuilder DEFAULT = new GsonBuilder();
    static final List<TypeAdapterFactory> DEFAULT_TYPE_ADAPTER_FACTORIES = DEFAULT.createFactories(DEFAULT_CONSTRUCTOR_CONSTRUCTOR, DEFAULT_JSON_ADAPTER_ANNOTATION_TYPE_ADAPTER_FACTORY);
    Excluder excluder = Excluder.DEFAULT;
    LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    FieldNamingStrategy fieldNamingPolicy = DEFAULT_FIELD_NAMING_STRATEGY;
    final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap();
    final List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();
    final List<TypeAdapterFactory> hierarchyFactories = new ArrayList<TypeAdapterFactory>();
    boolean serializeNulls = false;
    String datePattern = DEFAULT_DATE_PATTERN;
    int dateStyle = 2;
    int timeStyle = 2;
    boolean complexMapKeySerialization = false;
    boolean serializeSpecialFloatingPointValues = false;
    boolean escapeHtmlChars = true;
    FormattingStyle formattingStyle = DEFAULT_FORMATTING_STYLE;
    boolean generateNonExecutableJson = false;
    Strictness strictness = DEFAULT_STRICTNESS;
    boolean useJdkUnsafe = true;
    ToNumberStrategy objectToNumberStrategy = DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
    ToNumberStrategy numberToNumberStrategy = DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
    final ArrayDeque<ReflectionAccessFilter> reflectionFilters = new ArrayDeque();

    public GsonBuilder() {
    }

    GsonBuilder(Gson gson) {
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.formattingStyle = gson.formattingStyle;
        this.strictness = gson.strictness;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
        this.useJdkUnsafe = gson.useJdkUnsafe;
        this.objectToNumberStrategy = gson.objectToNumberStrategy;
        this.numberToNumberStrategy = gson.numberToNumberStrategy;
        this.reflectionFilters.addAll(gson.reflectionFilters);
    }

    @CanIgnoreReturnValue
    public GsonBuilder setVersion(double d) {
        if (Double.isNaN(d) || d < 0.0) {
            throw new IllegalArgumentException("Invalid version: " + d);
        }
        this.excluder = this.excluder.withVersion(d);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder excludeFieldsWithModifiers(int ... nArray) {
        Objects.requireNonNull(nArray);
        this.excluder = this.excluder.withModifiers(nArray);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = Objects.requireNonNull(longSerializationPolicy);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        return this.setFieldNamingStrategy(fieldNamingPolicy);
    }

    @CanIgnoreReturnValue
    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = Objects.requireNonNull(fieldNamingStrategy);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        this.objectToNumberStrategy = Objects.requireNonNull(toNumberStrategy);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy toNumberStrategy) {
        this.numberToNumberStrategy = Objects.requireNonNull(toNumberStrategy);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setExclusionStrategies(ExclusionStrategy ... exclusionStrategyArray) {
        Objects.requireNonNull(exclusionStrategyArray);
        for (ExclusionStrategy exclusionStrategy : exclusionStrategyArray) {
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
        }
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        Objects.requireNonNull(exclusionStrategy);
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setPrettyPrinting() {
        return this.setFormattingStyle(FormattingStyle.PRETTY);
    }

    @CanIgnoreReturnValue
    public GsonBuilder setFormattingStyle(FormattingStyle formattingStyle) {
        this.formattingStyle = Objects.requireNonNull(formattingStyle);
        return this;
    }

    @Deprecated
    @InlineMe(replacement="this.setStrictness(Strictness.LENIENT)", imports={"com.viaversion.viaversion.libs.gson.Strictness"})
    @CanIgnoreReturnValue
    public GsonBuilder setLenient() {
        return this.setStrictness(Strictness.LENIENT);
    }

    @CanIgnoreReturnValue
    public GsonBuilder setStrictness(Strictness strictness) {
        this.strictness = Objects.requireNonNull(strictness);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setDateFormat(String string) {
        if (string != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException("The date pattern '" + string + "' is not valid", illegalArgumentException);
            }
        }
        this.datePattern = string;
        return this;
    }

    @Deprecated
    @CanIgnoreReturnValue
    public GsonBuilder setDateFormat(int n) {
        this.dateStyle = GsonBuilder.checkDateFormatStyle(n);
        this.datePattern = null;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder setDateFormat(int n, int n2) {
        this.dateStyle = GsonBuilder.checkDateFormatStyle(n);
        this.timeStyle = GsonBuilder.checkDateFormatStyle(n2);
        this.datePattern = null;
        return this;
    }

    private static int checkDateFormatStyle(int n) {
        if (n < 0 || n > 3) {
            throw new IllegalArgumentException("Invalid style: " + n);
        }
        return n;
    }

    @CanIgnoreReturnValue
    public GsonBuilder registerTypeAdapter(Type type, Object object) {
        Object object2;
        Objects.requireNonNull(type);
        Objects.requireNonNull(object);
        if (!(object instanceof JsonSerializer || object instanceof JsonDeserializer || object instanceof InstanceCreator || object instanceof TypeAdapter)) {
            throw new IllegalArgumentException("Class " + object.getClass().getName() + " does not implement any supported type adapter class or interface");
        }
        if (GsonBuilder.hasNonOverridableAdapter(type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
        }
        if (object instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator)object);
        }
        if (object instanceof JsonSerializer || object instanceof JsonDeserializer) {
            object2 = TypeToken.get(type);
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(object2, object));
        }
        if (object instanceof TypeAdapter) {
            object2 = TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter)object);
            this.factories.add((TypeAdapterFactory)object2);
        }
        return this;
    }

    private static boolean hasNonOverridableAdapter(Type type) {
        return type == Object.class;
    }

    @CanIgnoreReturnValue
    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        Objects.requireNonNull(typeAdapterFactory);
        this.factories.add(typeAdapterFactory);
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder registerTypeHierarchyAdapter(Class<?> clazz, Object object) {
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(object);
        if (!(object instanceof JsonSerializer || object instanceof JsonDeserializer || object instanceof TypeAdapter)) {
            throw new IllegalArgumentException("Class " + object.getClass().getName() + " does not implement any supported type adapter class or interface");
        }
        if (object instanceof JsonDeserializer || object instanceof JsonSerializer) {
            this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(clazz, object));
        }
        if (object instanceof TypeAdapter) {
            TypeAdapterFactory typeAdapterFactory = TypeAdapters.newTypeHierarchyFactory(clazz, (TypeAdapter)object);
            this.factories.add(typeAdapterFactory);
        }
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    @CanIgnoreReturnValue
    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter reflectionAccessFilter) {
        Objects.requireNonNull(reflectionAccessFilter);
        this.reflectionFilters.addFirst(reflectionAccessFilter);
        return this;
    }

    public Gson create() {
        return new Gson(this);
    }

    List<TypeAdapterFactory> createFactories(ConstructorConstructor constructorConstructor, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        ArrayList<TypeAdapterFactory> arrayList = new ArrayList<TypeAdapterFactory>();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.getFactory(this.objectToNumberStrategy));
        arrayList.add(this.excluder);
        this.addUserDefinedAdapters(arrayList);
        this.addDateTypeAdapters(arrayList);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> typeAdapter = this.longSerializationPolicy.typeAdapter();
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, typeAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter()));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter()));
        arrayList.add(NumberTypeAdapter.getFactory(this.numberToNumberStrategy));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, TypeAdapters.atomicLongAdapter(typeAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, TypeAdapters.atomicLongArrayAdapter(typeAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.BIG_DECIMAL_FACTORY);
        arrayList.add(TypeAdapters.BIG_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.LAZILY_PARSED_NUMBER_FACTORY);
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DefaultDateTypeAdapter.DEFAULT_STYLE_FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        TypeAdapterFactory typeAdapterFactory = TypeAdapters.javaTimeTypeAdapterFactory();
        if (typeAdapterFactory != null) {
            arrayList.add(typeAdapterFactory);
        }
        arrayList.addAll(SqlTypesSupport.SQL_TYPE_FACTORIES);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor, this.complexMapKeySerialization));
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, this.fieldNamingPolicy, this.excluder, jsonAdapterAnnotationTypeAdapterFactory, GsonBuilder.newImmutableList(this.reflectionFilters)));
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    static <E> List<E> newImmutableList(Collection<E> collection) {
        if (collection.isEmpty()) {
            return Collections.emptyList();
        }
        if (collection.size() == 1) {
            return Collections.singletonList(collection instanceof List ? ((List)collection).get(0) : collection.iterator().next());
        }
        List<Object> list = Collections.unmodifiableList(Arrays.asList(collection.toArray()));
        return list;
    }

    private TypeAdapter<Number> doubleAdapter() {
        return this.serializeSpecialFloatingPointValues ? TypeAdapters.DOUBLE : TypeAdapters.DOUBLE_STRICT;
    }

    private TypeAdapter<Number> floatAdapter() {
        return this.serializeSpecialFloatingPointValues ? TypeAdapters.FLOAT : TypeAdapters.FLOAT_STRICT;
    }

    private void addUserDefinedAdapters(List<TypeAdapterFactory> list) {
        ArrayList<TypeAdapterFactory> arrayList;
        if (!this.factories.isEmpty()) {
            arrayList = new ArrayList<TypeAdapterFactory>(this.factories);
            Collections.reverse(arrayList);
            list.addAll(arrayList);
        }
        if (!this.hierarchyFactories.isEmpty()) {
            arrayList = new ArrayList<TypeAdapterFactory>(this.hierarchyFactories);
            Collections.reverse(arrayList);
            list.addAll(arrayList);
        }
    }

    private void addDateTypeAdapters(List<TypeAdapterFactory> list) {
        TypeAdapterFactory typeAdapterFactory;
        boolean bl = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory typeAdapterFactory2 = null;
        TypeAdapterFactory typeAdapterFactory3 = null;
        if (this.datePattern != null && !this.datePattern.trim().isEmpty()) {
            typeAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(this.datePattern);
            if (bl) {
                typeAdapterFactory2 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.datePattern);
                typeAdapterFactory3 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.datePattern);
            }
        } else if (this.dateStyle != 2 || this.timeStyle != 2) {
            typeAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(this.dateStyle, this.timeStyle);
            if (bl) {
                typeAdapterFactory2 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
                typeAdapterFactory3 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(this.dateStyle, this.timeStyle);
            }
        } else {
            return;
        }
        list.add(typeAdapterFactory);
        if (bl) {
            list.add(typeAdapterFactory2);
            list.add(typeAdapterFactory3);
        }
    }
}

