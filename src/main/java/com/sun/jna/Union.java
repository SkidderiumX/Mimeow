/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.TypeMapper;
import com.sun.jna.WString;
import java.util.Iterator;
public abstract class Union
extends Structure {

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
    static /* synthetic */ Class class$com$sun$jna$Structure;

    private Structure.StructField activeField;
    Structure.StructField biggestField;

    protected Union() {
    }

    protected Union(Pointer pointer) {
        super(pointer);
    }

    protected Union(Pointer pointer, int n) {
        super(pointer, n);
    }

    protected Union(TypeMapper typeMapper) {
        super(typeMapper);
    }

    protected Union(Pointer pointer, int n, TypeMapper typeMapper) {
        super(pointer, n, typeMapper);
    }

    public void setType(Class clazz) {
        this.ensureAllocated();
        Iterator iterator2 = this.fields().values().iterator();
        while (iterator2.hasNext()) {
            Structure.StructField structField = (Structure.StructField)iterator2.next();
            if (structField.type != clazz) continue;
            this.activeField = structField;
            return;
        }
        throw new IllegalArgumentException("No field of type " + clazz + " in " + this);
    }

    public void setType(String string) {
        this.ensureAllocated();
        Structure.StructField structField = (Structure.StructField)this.fields().get(string);
        if (structField == null) {
            throw new IllegalArgumentException("No field named " + string + " in " + this);
        }
        this.activeField = structField;
    }

    public Object readField(String string) {
        this.ensureAllocated();
        this.setType(string);
        return super.readField(string);
    }

    public void writeField(String string) {
        this.ensureAllocated();
        this.setType(string);
        super.writeField(string);
    }

    public void writeField(String string, Object object) {
        this.ensureAllocated();
        this.setType(string);
        super.writeField(string, object);
    }

    public Object getTypedValue(Class clazz) {
        this.ensureAllocated();
        Iterator iterator2 = this.fields().values().iterator();
        while (iterator2.hasNext()) {
            Structure.StructField structField = (Structure.StructField)iterator2.next();
            if (structField.type != clazz) continue;
            this.activeField = structField;
            this.read();
            return this.getField(this.activeField);
        }
        throw new IllegalArgumentException("No field of type " + clazz + " in " + this);
    }

    public Object setTypedValue(Object object) {
        Structure.StructField structField = this.findField(object.getClass());
        if (structField != null) {
            this.activeField = structField;
            this.setField(structField, object);
            return this;
        }
        throw new IllegalArgumentException("No field of type " + object.getClass() + " in " + this);
    }

    private Structure.StructField findField(Class clazz) {
        this.ensureAllocated();
        Iterator iterator2 = this.fields().values().iterator();
        while (iterator2.hasNext()) {
            Structure.StructField structField = (Structure.StructField)iterator2.next();
            if (!structField.type.isAssignableFrom(clazz)) continue;
            return structField;
        }
        return null;
    }

    void writeField(Structure.StructField structField) {
        if (structField == this.activeField) {
            super.writeField(structField);
        }
    }

    Object readField(Structure.StructField structField) {
        if (structField == this.activeField || !Structure.class.isAssignableFrom(structField.type) && !String.class.isAssignableFrom(structField.type) && !WString.class.isAssignableFrom(structField.type)) {
            return super.readField(structField);
        }
        return null;
    }

    int calculateSize(boolean bl, boolean bl2) {
        int n = super.calculateSize(bl, bl2);
        if (n != -1) {
            int n2 = 0;
            Iterator iterator2 = this.fields().values().iterator();
            while (iterator2.hasNext()) {
                Structure.StructField structField = (Structure.StructField)iterator2.next();
                structField.offset = 0;
                if (structField.size <= n2 && (structField.size != n2 || !(class$com$sun$jna$Structure == null ? Union.class$("com.sun.jna.Structure") : class$com$sun$jna$Structure).isAssignableFrom(structField.type))) continue;
                n2 = structField.size;
                this.biggestField = structField;
            }
            n = this.calculateAlignedSize(n2);
            if (n > 0 && this instanceof Structure.ByValue && !bl2) {
                this.getTypeInfo();
            }
        }
        return n;
    }

    protected int getNativeAlignment(Class clazz, Object object, boolean bl) {
        return super.getNativeAlignment(clazz, object, true);
    }

    Pointer getTypeInfo() {
        if (this.biggestField == null) {
            return null;
        }
        return super.getTypeInfo();
    }
}

