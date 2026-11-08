/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.introspector;

import java.beans.FeatureDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.FieldProperty;
import org.yaml.snakeyaml.introspector.GenericProperty;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.util.ArrayUtils;

public class MethodProperty
extends GenericProperty {
    private final PropertyDescriptor property;
    private final boolean readable;
    private final boolean writable;
    private static final String TRANSIENT = "transient";

    private static Type discoverGenericType(PropertyDescriptor propertyDescriptor) {
        Type[] typeArray;
        Method method = propertyDescriptor.getReadMethod();
        if (method != null) {
            return method.getGenericReturnType();
        }
        Method method2 = propertyDescriptor.getWriteMethod();
        if (method2 != null && (typeArray = method2.getGenericParameterTypes()).length > 0) {
            return typeArray[0];
        }
        return null;
    }

    public MethodProperty(PropertyDescriptor propertyDescriptor) {
        super(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), MethodProperty.discoverGenericType(propertyDescriptor));
        this.property = propertyDescriptor;
        this.readable = propertyDescriptor.getReadMethod() != null;
        this.writable = propertyDescriptor.getWriteMethod() != null;
    }

    @Override
    public void set(Object object, Object object2) throws Exception {
        if (!this.writable) {
            throw new YAMLException("No writable property '" + this.getName() + "' on class: " + object.getClass().getName());
        }
        this.property.getWriteMethod().invoke(object, object2);
    }

    @Override
    public Object get(Object object) {
        try {
            this.property.getReadMethod().setAccessible(true);
            return this.property.getReadMethod().invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            throw new YAMLException("Unable to find getter for property '" + this.property.getName() + "' on object " + object + ":" + exception);
        }
    }

    @Override
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.isReadable() && this.isWritable() ? ArrayUtils.toUnmodifiableCompositeList(this.property.getReadMethod().getAnnotations(), this.property.getWriteMethod().getAnnotations()) : (this.isReadable() ? ArrayUtils.toUnmodifiableList(this.property.getReadMethod().getAnnotations()) : ArrayUtils.toUnmodifiableList(this.property.getWriteMethod().getAnnotations()));
        return list;
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> clazz) {
        A a = null;
        if (this.isReadable()) {
            a = this.property.getReadMethod().getAnnotation(clazz);
        }
        if (a == null && this.isWritable()) {
            a = this.property.getWriteMethod().getAnnotation(clazz);
        }
        return a;
    }

    @Override
    public boolean isWritable() {
        return this.writable;
    }

    @Override
    public boolean isReadable() {
        return this.readable;
    }

    private static boolean isTransient(FeatureDescriptor featureDescriptor) {
        return Boolean.TRUE.equals(featureDescriptor.getValue(TRANSIENT));
    }

    static boolean addPublicFields(Class<?> clazz, Map<String, Property> map) {
        Object object;
        boolean bl = false;
        try {
            object = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            int n = ((PropertyDescriptor[])object).length;
            for (int i = 0; i < n; ++i) {
                PropertyDescriptor propertyDescriptor = object[i];
                Method accessibleObject = propertyDescriptor.getReadMethod();
                if (accessibleObject != null && accessibleObject.getName().equals("getClass") || MethodProperty.isTransient(propertyDescriptor)) continue;
                map.put(propertyDescriptor.getName(), new MethodProperty(propertyDescriptor));
            }
        }
        catch (IntrospectionException introspectionException) {
            throw new YAMLException(introspectionException);
        }
        for (object = clazz; object != null; object = ((Class)object).getSuperclass()) {
            for (Field field : ((Class)object).getDeclaredFields()) {
                int n = field.getModifiers();
                if (Modifier.isStatic(n) || Modifier.isTransient(n)) continue;
                if (Modifier.isPublic(n)) {
                    map.put(field.getName(), new FieldProperty(field));
                    continue;
                }
                bl = true;
            }
        }
        return bl;
    }
}

