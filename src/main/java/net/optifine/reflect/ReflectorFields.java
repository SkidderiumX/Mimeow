/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.reflect;

import net.optifine.reflect.ReflectorClass;
import net.optifine.reflect.ReflectorField;

public class ReflectorFields {
    private ReflectorClass reflectorClass;
    private Class fieldType;
    private int fieldCount;
    private ReflectorField[] reflectorFields;

    public ReflectorFields(ReflectorClass reflectorClass, Class clazz, int n) {
        this.reflectorClass = reflectorClass;
        this.fieldType = clazz;
        if (reflectorClass.exists() && clazz != null) {
            this.reflectorFields = new ReflectorField[n];
            for (int i = 0; i < this.reflectorFields.length; ++i) {
                this.reflectorFields[i] = new ReflectorField(reflectorClass, clazz, i);
            }
        }
    }

    public ReflectorClass getReflectorClass() {
        return this.reflectorClass;
    }

    public Class getFieldType() {
        return this.fieldType;
    }

    public int getFieldCount() {
        return this.fieldCount;
    }

    public ReflectorField getReflectorField(int n) {
        return n >= 0 && n < this.reflectorFields.length ? this.reflectorFields[n] : null;
    }
}

