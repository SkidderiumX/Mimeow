/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReflectiveTypeAdapterFactory
implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final Excluder excluder;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    private boolean includeField(Field field, boolean bl) {
        return !this.excluder.excludeField(field, bl);
    }

    private List<String> getFieldNames(Field field) {
        List<String> list;
        String string;
        SerializedName serializedName = field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            string = this.fieldNamingPolicy.translateName(field);
            list = this.fieldNamingPolicy.alternateNames(field);
        } else {
            string = serializedName.value();
            list = Arrays.asList(serializedName.alternate());
        }
        if (list.isEmpty()) {
            return Collections.singletonList(string);
        }
        ArrayList<String> arrayList = new ArrayList<String>(list.size() + 1);
        arrayList.add(string);
        arrayList.addAll(list);
        return arrayList;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean bl;
        Class<T> clazz = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(clazz)) {
            return null;
        }
        if (ReflectionHelper.isAnonymousOrNonStaticLocal(clazz)) {
            return new TypeAdapter<T>(){

                @Override
                public T read(JsonReader jsonReader) throws IOException {
                    jsonReader.skipValue();
                    return null;
                }

                @Override
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    jsonWriter.nullValue();
                }

                public String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }
            };
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, clazz);
        if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + clazz + ". Register a TypeAdapter for this type or adjust the access filter.");
        }
        boolean bl2 = bl = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
        if (ReflectionHelper.isRecord(clazz)) {
            RecordAdapter<T> recordAdapter = new RecordAdapter<T>(clazz, this.getBoundFields(gson, typeToken, clazz, bl, true), bl);
            return recordAdapter;
        }
        ObjectConstructor<T> objectConstructor = this.constructorConstructor.get(typeToken, true);
        return new FieldReflectionAdapter<T>(objectConstructor, this.getBoundFields(gson, typeToken, clazz, bl, false));
    }

    private static <M extends AccessibleObject> void checkAccessible(Object object, M m) {
        if (!ReflectionAccessFilterHelper.canAccess(m, Modifier.isStatic(((Member)((Object)m)).getModifiers()) ? null : object)) {
            String string = ReflectionHelper.getAccessibleObjectDescription(m, true);
            throw new JsonIOException(string + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private BoundField createBoundField(Gson gson, Field field, final Method method, String string, TypeToken<?> typeToken, boolean bl, final boolean bl2) {
        boolean bl3;
        final boolean bl4 = Primitives.isPrimitive(typeToken.getRawType());
        int n = field.getModifiers();
        final boolean bl5 = Modifier.isStatic(n) && Modifier.isFinal(n);
        JsonAdapter jsonAdapter = field.getAnnotation(JsonAdapter.class);
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = null;
        if (jsonAdapter != null) {
            typeAdapterRuntimeTypeWrapper = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter, false);
        }
        boolean bl6 = bl3 = typeAdapterRuntimeTypeWrapper != null;
        if (typeAdapterRuntimeTypeWrapper == null) {
            typeAdapterRuntimeTypeWrapper = gson.getAdapter(typeToken);
        }
        final TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = typeAdapterRuntimeTypeWrapper;
        final TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper3 = bl ? (bl3 ? typeAdapterRuntimeTypeWrapper2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapterRuntimeTypeWrapper2, typeToken.getType())) : typeAdapterRuntimeTypeWrapper2;
        return new BoundField(string, field){

            @Override
            void write(JsonWriter jsonWriter, Object object) throws IOException, IllegalAccessException {
                Object object2;
                if (bl2) {
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.checkAccessible(object, this.field);
                    } else {
                        ReflectiveTypeAdapterFactory.checkAccessible(object, method);
                    }
                }
                if (method != null) {
                    try {
                        object2 = method.invoke(object, new Object[0]);
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        String string = ReflectionHelper.getAccessibleObjectDescription(method, false);
                        throw new JsonIOException("Accessor " + string + " threw exception", invocationTargetException.getCause());
                    }
                } else {
                    object2 = this.field.get(object);
                }
                if (object2 == object) {
                    return;
                }
                jsonWriter.name(this.serializedName);
                typeAdapterRuntimeTypeWrapper3.write(jsonWriter, object2);
            }

            @Override
            void readIntoArray(JsonReader jsonReader, int n, Object[] objectArray) throws IOException, JsonParseException {
                Object t = typeAdapterRuntimeTypeWrapper2.read(jsonReader);
                if (t == null && bl4) {
                    throw new JsonParseException("null is not allowed as value for record component '" + this.fieldName + "' of primitive type; at path " + jsonReader.getPath());
                }
                objectArray[n] = t;
            }

            @Override
            void readIntoField(JsonReader jsonReader, Object object) throws IOException, IllegalAccessException {
                Object t = typeAdapterRuntimeTypeWrapper2.read(jsonReader);
                if (t != null || !bl4) {
                    if (bl2) {
                        ReflectiveTypeAdapterFactory.checkAccessible(object, this.field);
                    } else if (bl5) {
                        String string = ReflectionHelper.getAccessibleObjectDescription(this.field, false);
                        throw new JsonIOException("Cannot set value of 'static final' " + string);
                    }
                    this.field.set(object, t);
                }
            }
        };
    }

    private static IllegalArgumentException createDuplicateFieldException(Class<?> clazz, String string, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + clazz.getName() + " declares multiple JSON fields named '" + string + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(field) + " and " + ReflectionHelper.fieldToString(field2) + "\nSee " + TroubleshootingGuide.createUrl("duplicate-fields"));
    }

    private FieldsData getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> clazz, boolean bl, boolean bl2) {
        if (clazz.isInterface()) {
            return FieldsData.EMPTY;
        }
        LinkedHashMap<String, BoundField> linkedHashMap = new LinkedHashMap<String, BoundField>();
        LinkedHashMap<String, BoundField> linkedHashMap2 = new LinkedHashMap<String, BoundField>();
        Class<?> clazz2 = clazz;
        while (clazz != Object.class) {
            Field[] fieldArray = clazz.getDeclaredFields();
            if (clazz != clazz2 && fieldArray.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, clazz);
                if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + clazz + " (supertype of " + clazz2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                bl = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            }
            for (Field field : fieldArray) {
                Object object;
                Object object2;
                boolean bl3 = this.includeField(field, true);
                boolean bl4 = this.includeField(field, false);
                if (!bl3 && !bl4) continue;
                Method method = null;
                if (bl2) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        bl4 = false;
                    } else {
                        method = ReflectionHelper.getAccessor(clazz, field);
                        if (!bl) {
                            ReflectionHelper.makeAccessible(method);
                        }
                        if (method.getAnnotation(SerializedName.class) != null && field.getAnnotation(SerializedName.class) == null) {
                            object2 = ReflectionHelper.getAccessibleObjectDescription(method, false);
                            throw new JsonIOException("@SerializedName on " + (String)object2 + " is not supported");
                        }
                    }
                }
                if (!bl && method == null) {
                    ReflectionHelper.makeAccessible(field);
                }
                object2 = GsonTypes.resolve(typeToken.getType(), clazz, field.getGenericType());
                List<String> list = this.getFieldNames(field);
                String string = list.get(0);
                BoundField boundField = this.createBoundField(gson, field, method, string, TypeToken.get((Type)object2), bl3, bl);
                if (bl4) {
                    object = list.iterator();
                    while (object.hasNext()) {
                        String string2 = object.next();
                        BoundField boundField2 = linkedHashMap.put(string2, boundField);
                        if (boundField2 == null) continue;
                        throw ReflectiveTypeAdapterFactory.createDuplicateFieldException(clazz2, string2, boundField2.field, field);
                    }
                }
                if (!bl3 || (object = linkedHashMap2.put(string, boundField)) == null) continue;
                throw ReflectiveTypeAdapterFactory.createDuplicateFieldException(clazz2, string, ((BoundField)object).field, field);
            }
            typeToken = TypeToken.get(GsonTypes.resolve(typeToken.getType(), clazz, clazz.getGenericSuperclass()));
            clazz = typeToken.getRawType();
        }
        return new FieldsData(linkedHashMap, new ArrayList<BoundField>(linkedHashMap2.values()));
    }

    private static final class RecordAdapter<T>
    extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> PRIMITIVE_DEFAULTS = RecordAdapter.primitiveDefaults();
        private final Constructor<T> constructor;
        private final Object[] constructorArgsDefaults;
        private final Map<String, Integer> componentIndices = new HashMap<String, Integer>();

        RecordAdapter(Class<T> clazz, FieldsData fieldsData, boolean bl) {
            super(fieldsData);
            this.constructor = ReflectionHelper.getCanonicalRecordConstructor(clazz);
            if (bl) {
                ReflectiveTypeAdapterFactory.checkAccessible(null, this.constructor);
            } else {
                ReflectionHelper.makeAccessible(this.constructor);
            }
            String[] stringArray = ReflectionHelper.getRecordComponentNames(clazz);
            for (int i = 0; i < stringArray.length; ++i) {
                this.componentIndices.put(stringArray[i], i);
            }
            Class<?>[] classArray = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[classArray.length];
            for (int i = 0; i < classArray.length; ++i) {
                this.constructorArgsDefaults[i] = PRIMITIVE_DEFAULTS.get(classArray[i]);
            }
        }

        private static Map<Class<?>, Object> primitiveDefaults() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte)0);
            hashMap.put(Short.TYPE, (short)0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, 0.0);
            hashMap.put(Character.TYPE, Character.valueOf('\u0000'));
            hashMap.put(Boolean.TYPE, false);
            return hashMap;
        }

        @Override
        Object[] createAccumulator() {
            return (Object[])this.constructorArgsDefaults.clone();
        }

        @Override
        void readField(Object[] objectArray, JsonReader jsonReader, BoundField boundField) throws IOException {
            Integer n = this.componentIndices.get(boundField.fieldName);
            if (n == null) {
                throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + boundField.fieldName + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
            }
            boundField.readIntoArray(jsonReader, n, objectArray);
        }

        @Override
        T finalize(Object[] objectArray) {
            try {
                return this.constructor.newInstance(objectArray);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(illegalAccessException);
            }
            catch (IllegalArgumentException | InstantiationException exception) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objectArray), exception);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' with args " + Arrays.toString(objectArray), invocationTargetException.getCause());
            }
        }
    }

    private static class FieldsData {
        static final FieldsData EMPTY = new FieldsData(Collections.emptyMap(), Collections.emptyList());
        final Map<String, BoundField> deserializedFields;
        final List<BoundField> serializedFields;

        FieldsData(Map<String, BoundField> map, List<BoundField> list) {
            this.deserializedFields = map;
            this.serializedFields = list;
        }
    }

    private static final class FieldReflectionAdapter<T>
    extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        FieldReflectionAdapter(ObjectConstructor<T> objectConstructor, FieldsData fieldsData) {
            super(fieldsData);
            this.constructor = objectConstructor;
        }

        @Override
        T createAccumulator() {
            return this.constructor.construct();
        }

        @Override
        void readField(T t, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t);
        }

        @Override
        T finalize(T t) {
            return t;
        }
    }

    public static abstract class BoundField {
        final String serializedName;
        final Field field;
        final String fieldName;

        protected BoundField(String string, Field field) {
            this.serializedName = string;
            this.field = field;
            this.fieldName = field.getName();
        }

        abstract void write(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;

        abstract void readIntoArray(JsonReader var1, int var2, Object[] var3) throws IOException, JsonParseException;

        abstract void readIntoField(JsonReader var1, Object var2) throws IOException, IllegalAccessException;
    }

    public static abstract class Adapter<T, A>
    extends TypeAdapter<T> {
        private final FieldsData fieldsData;

        Adapter(FieldsData fieldsData) {
            this.fieldsData = fieldsData;
        }

        @Override
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.fieldsData.serializedFields) {
                    boundField.write(jsonWriter, t);
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(illegalAccessException);
            }
            jsonWriter.endObject();
        }

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A a = this.createAccumulator();
            Map<String, BoundField> map = this.fieldsData.deserializedFields;
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String string = jsonReader.nextName();
                    BoundField boundField = map.get(string);
                    if (boundField == null) {
                        jsonReader.skipValue();
                        continue;
                    }
                    this.readField(a, jsonReader, boundField);
                }
            }
            catch (IllegalStateException illegalStateException) {
                throw new JsonSyntaxException(illegalStateException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(illegalAccessException);
            }
            jsonReader.endObject();
            return this.finalize(a);
        }

        abstract A createAccumulator();

        abstract void readField(A var1, JsonReader var2, BoundField var3) throws IllegalAccessException, IOException;

        abstract T finalize(A var1);
    }
}

