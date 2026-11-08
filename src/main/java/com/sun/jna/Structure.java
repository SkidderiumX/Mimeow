/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Callback;
import com.sun.jna.FromNativeContext;
import com.sun.jna.FromNativeConverter;
import com.sun.jna.IntegerType;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.NativeString;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.StructureReadContext;
import com.sun.jna.StructureWriteContext;
import com.sun.jna.ToNativeContext;
import com.sun.jna.ToNativeConverter;
import com.sun.jna.TypeMapper;
import com.sun.jna.Union;
import com.sun.jna.WString;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.Adler32;
public abstract class Structure {
    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
    static /* synthetic */ Class class$com$sun$jna$Callback;
    static /* synthetic */ Class class$com$sun$jna$NativeMapped;
    static /* synthetic */ Class class$com$sun$jna$Pointer;
    static /* synthetic */ Class class$com$sun$jna$Structure;
    static /* synthetic */ Class class$com$sun$jna$Structure$ByReference;
    static /* synthetic */ Class class$com$sun$jna$WString;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$nio$Buffer;

    private static final boolean REVERSE_FIELDS;
    private static final boolean REQUIRES_FIELD_ORDER;
    static final boolean isPPC;
    static final boolean isSPARC;
    static final boolean isARM;
    public static final int ALIGN_DEFAULT = 0;
    public static final int ALIGN_NONE = 1;
    public static final int ALIGN_GNUC = 2;
    public static final int ALIGN_MSVC = 3;
    static final int MAX_GNUC_ALIGNMENT;
    protected static final int CALCULATE_SIZE = -1;
    static final Map layoutInfo;
    private Pointer memory;
    private int size = -1;
    private int alignType;
    private int structAlignment;
    private Map structFields;
    private final Map nativeStrings = new HashMap();
    private TypeMapper typeMapper;
    private long typeInfo;
    private List fieldOrder;
    private boolean autoRead = true;
    private boolean autoWrite = true;
    private Structure[] array;
    private static final ThreadLocal reads;
    private static final ThreadLocal busy;
    static /* synthetic */ Class class$java$lang$Void;

    protected Structure() {
        this((Pointer)null);
    }

    protected Structure(TypeMapper typeMapper) {
        this(null, 0, typeMapper);
    }

    protected Structure(Pointer pointer) {
        this(pointer, 0);
    }

    protected Structure(Pointer pointer, int n) {
        this(pointer, n, null);
    }

    protected Structure(Pointer pointer, int n, TypeMapper typeMapper) {
        this.setAlignType(n);
        this.setTypeMapper(typeMapper);
        if (pointer != null) {
            this.useMemory(pointer);
        } else {
            this.allocateMemory(-1);
        }
    }

    Map fields() {
        return this.structFields;
    }

    TypeMapper getTypeMapper() {
        return this.typeMapper;
    }

    protected void setTypeMapper(TypeMapper typeMapper) {
        Class<?> clazz;
        if (typeMapper == null && (clazz = this.getClass().getDeclaringClass()) != null) {
            typeMapper = Native.getTypeMapper(clazz);
        }
        this.typeMapper = typeMapper;
        this.size = -1;
        if (this.memory instanceof AutoAllocated) {
            this.memory = null;
        }
    }

    protected void setAlignType(int n) {
        if (n == 0) {
            Class<?> clazz = this.getClass().getDeclaringClass();
            if (clazz != null) {
                n = Native.getStructureAlignment(clazz);
            }
            if (n == 0) {
                n = Platform.isWindows() ? 3 : 2;
            }
        }
        this.alignType = n;
        this.size = -1;
        if (this.memory instanceof AutoAllocated) {
            this.memory = null;
        }
    }

    protected Memory autoAllocate(int n) {
        return new AutoAllocated(n);
    }

    protected void useMemory(Pointer pointer) {
        this.useMemory(pointer, 0);
    }

    protected void useMemory(Pointer pointer, int n) {
        try {
            this.memory = pointer.share(n);
            if (this.size == -1) {
                this.size = this.calculateSize(false);
            }
            if (this.size != -1) {
                this.memory = pointer.share(n, this.size);
            }
            this.array = null;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IllegalArgumentException("Structure exceeds provided memory bounds");
        }
    }

    protected void ensureAllocated() {
        this.ensureAllocated(false);
    }

    private void ensureAllocated(boolean bl) {
        if (this.memory == null) {
            this.allocateMemory(bl);
        } else if (this.size == -1) {
            this.size = this.calculateSize(true, bl);
        }
    }

    protected void allocateMemory() {
        this.allocateMemory(false);
    }

    private void allocateMemory(boolean bl) {
        this.allocateMemory(this.calculateSize(true, bl));
    }

    protected void allocateMemory(int n) {
        if (n == -1) {
            n = this.calculateSize(false);
        } else if (n <= 0) {
            throw new IllegalArgumentException("Structure size must be greater than zero: " + n);
        }
        if (n != -1) {
            if (this.memory == null || this.memory instanceof AutoAllocated) {
                this.memory = this.autoAllocate(n);
            }
            this.size = n;
        }
    }

    public int size() {
        this.ensureAllocated();
        if (this.size == -1) {
            this.size = this.calculateSize(true);
        }
        return this.size;
    }

    public void clear() {
        this.memory.clear(this.size());
    }

    public Pointer getPointer() {
        this.ensureAllocated();
        return this.memory;
    }

    static Set busy() {
        return (Set)busy.get();
    }

    static Map reading() {
        return (Map)reads.get();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void read() {
        this.ensureAllocated();
        if (Structure.busy().contains(this)) {
            return;
        }
        Structure.busy().add(this);
        if (this instanceof ByReference) {
            Structure.reading().put(this.getPointer(), this);
        }
        try {
            Iterator iterator2 = this.fields().values().iterator();
            while (iterator2.hasNext()) {
                this.readField((StructField)iterator2.next());
            }
        }
        finally {
            Structure.busy().remove(this);
            if (Structure.reading().get(this.getPointer()) == this) {
                Structure.reading().remove(this.getPointer());
            }
        }
    }

    protected int fieldOffset(String string) {
        this.ensureAllocated();
        StructField structField = (StructField)this.fields().get(string);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + string);
        }
        return structField.offset;
    }

    public Object readField(String string) {
        this.ensureAllocated();
        StructField structField = (StructField)this.fields().get(string);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + string);
        }
        return this.readField(structField);
    }

    Object getField(StructField structField) {
        try {
            return structField.field.get(this);
        }
        catch (Exception exception) {
            throw new Error("Exception reading field '" + structField.name + "' in " + this.getClass() + ": " + exception);
        }
    }

    void setField(StructField structField, Object object) {
        this.setField(structField, object, false);
    }

    void setField(StructField structField, Object object, boolean bl) {
        try {
            structField.field.set(this, object);
        }
        catch (IllegalAccessException illegalAccessException) {
            int n = structField.field.getModifiers();
            if (Modifier.isFinal(n)) {
                if (bl) {
                    throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + structField.name + "' within " + this.getClass() + ")");
                }
                throw new UnsupportedOperationException("Attempt to write to read-only field '" + structField.name + "' within " + this.getClass());
            }
            throw new Error("Unexpectedly unable to write to field '" + structField.name + "' within " + this.getClass() + ": " + illegalAccessException);
        }
    }

    static Structure updateStructureByReference(Class clazz, Structure structure, Pointer pointer) {
        if (pointer == null) {
            structure = null;
        } else {
            if (structure == null || !pointer.equals(structure.getPointer())) {
                Structure structure2 = (Structure)Structure.reading().get(pointer);
                if (structure2 != null && clazz.equals(structure2.getClass())) {
                    structure = structure2;
                } else {
                    structure = Structure.newInstance(clazz);
                    structure.useMemory(pointer);
                }
            }
            structure.autoRead();
        }
        return structure;
    }

    Object readField(StructField structField) {
        int n = structField.offset;
        Class clazz = structField.type;
        FromNativeConverter fromNativeConverter = structField.readConverter;
        if (fromNativeConverter != null) {
            clazz = fromNativeConverter.nativeType();
        }
        Object object = Structure.class.isAssignableFrom(clazz) || Callback.class.isAssignableFrom(clazz) || Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clazz) || Pointer.class.isAssignableFrom(clazz) || NativeMapped.class.isAssignableFrom(clazz) || clazz.isArray() ? this.getField(structField) : null;
        Object object2 = this.memory.getValue(n, clazz, object);
        if (fromNativeConverter != null) {
            object2 = fromNativeConverter.fromNative(object2, structField.context);
        }
        this.setField(structField, object2, true);
        return object2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write() {
        this.ensureAllocated();
        if (this instanceof ByValue) {
            this.getTypeInfo();
        }
        if (Structure.busy().contains(this)) {
            return;
        }
        Structure.busy().add(this);
        try {
            Iterator iterator2 = this.fields().values().iterator();
            while (iterator2.hasNext()) {
                StructField structField = (StructField)iterator2.next();
                if (structField.isVolatile) continue;
                this.writeField(structField);
            }
        }
        finally {
            Structure.busy().remove(this);
        }
    }

    public void writeField(String string) {
        this.ensureAllocated();
        StructField structField = (StructField)this.fields().get(string);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + string);
        }
        this.writeField(structField);
    }

    public void writeField(String string, Object object) {
        this.ensureAllocated();
        StructField structField = (StructField)this.fields().get(string);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + string);
        }
        this.setField(structField, object);
        this.writeField(structField);
    }

    void writeField(StructField structField) {
        CharSequence charSequence;
        if (structField.isReadOnly) {
            return;
        }
        int n = structField.offset;
        Object object = this.getField(structField);
        Class clazz = structField.type;
        ToNativeConverter toNativeConverter = structField.writeConverter;
        if (toNativeConverter != null) {
            object = toNativeConverter.toNative(object, new StructureWriteContext(this, structField.field));
            clazz = toNativeConverter.nativeType();
        }
        if (String.class == clazz || WString.class == clazz) {
            boolean bl;
            boolean bl2 = bl = clazz == WString.class;
            if (object != null) {
                charSequence = new NativeString(object.toString(), bl);
                this.nativeStrings.put(structField.name, charSequence);
                object = charSequence.getPointer();
            } else {
                object = null;
                this.nativeStrings.remove(structField.name);
            }
        }
        try {
            this.memory.setValue(n, object, clazz);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            charSequence = "Structure field \"" + structField.name + "\" was declared as " + structField.type + (structField.type == clazz ? "" : " (native type " + clazz + ")") + ", which is not supported within a Structure";
            throw new IllegalArgumentException((String)charSequence);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean hasFieldOrder() {
        Structure structure = this;
        synchronized (structure) {
            return this.fieldOrder != null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected List getFieldOrder() {
        Structure structure = this;
        synchronized (structure) {
            if (this.fieldOrder == null) {
                this.fieldOrder = new ArrayList();
            }
            return this.fieldOrder;
        }
    }

    protected void setFieldOrder(String[] stringArray) {
        this.getFieldOrder().addAll(Arrays.asList(stringArray));
        this.size = -1;
        if (this.memory instanceof AutoAllocated) {
            this.memory = null;
        }
    }

    protected void sortFields(List list, List list2) {
        block0: for (int i = 0; i < list2.size(); ++i) {
            String string = (String)list2.get(i);
            for (int j = 0; j < list.size(); ++j) {
                Field field = (Field)list.get(j);
                if (!string.equals(field.getName())) continue;
                Collections.swap(list, i, j);
                continue block0;
            }
        }
    }

    protected List getFields(boolean bl) {
        ArrayList arrayList = new ArrayList();
        Object object = this.getClass();
        while (!object.equals(class$com$sun$jna$Structure == null ? Structure.class$("com.sun.jna.Structure") : class$com$sun$jna$Structure)) {
            ArrayList<Field> arrayList2 = new ArrayList<Field>();
            Field[] fieldArray = ((Class)object).getDeclaredFields();
            for (int i = 0; i < fieldArray.length; ++i) {
                int n = fieldArray[i].getModifiers();
                if (Modifier.isStatic(n) || !Modifier.isPublic(n)) continue;
                arrayList2.add(fieldArray[i]);
            }
            if (REVERSE_FIELDS) {
                Collections.reverse(arrayList2);
            }
            arrayList.addAll(0, arrayList2);
            object = ((Class)object).getSuperclass();
        }
        if (REQUIRES_FIELD_ORDER || this.hasFieldOrder()) {
            object = this.getFieldOrder();
            if (object.size() < arrayList.size()) {
                if (bl) {
                    throw new Error("This VM does not store fields in a predictable order; you must use Structure.setFieldOrder to explicitly indicate the field order: " + System.getProperty("java.vendor") + ", " + System.getProperty("java.version"));
                }
                return null;
            }
            this.sortFields(arrayList, (List)object);
        }
        return arrayList;
    }

    private synchronized boolean fieldOrderMatch(List list) {
        return this.fieldOrder == list || this.fieldOrder != null && ((Object)this.fieldOrder).equals(list);
    }

    private int calculateSize(boolean bl) {
        return this.calculateSize(bl, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int calculateSize(boolean bl, boolean bl2) {
        LayoutInfo layoutInfo;
        boolean bl3 = true;
        Map map = Structure.layoutInfo;
        synchronized (map) {
            layoutInfo = (LayoutInfo)Structure.layoutInfo.get(this.getClass());
        }
        if (layoutInfo == null || this.alignType != layoutInfo.alignType || this.typeMapper != layoutInfo.typeMapper || !this.fieldOrderMatch(layoutInfo.fieldOrder)) {
            layoutInfo = this.deriveLayout(bl, bl2);
            bl3 = false;
        }
        if (layoutInfo != null) {
            this.structAlignment = layoutInfo.alignment;
            this.structFields = layoutInfo.fields;
            layoutInfo.alignType = this.alignType;
            layoutInfo.typeMapper = this.typeMapper;
            layoutInfo.fieldOrder = this.fieldOrder;
            if (!layoutInfo.variable) {
                map = Structure.layoutInfo;
                synchronized (map) {
                    Structure.layoutInfo.put(this.getClass(), layoutInfo);
                }
            }
            if (bl3) {
                this.initializeFields();
            }
            return layoutInfo.size;
        }
        return -1;
    }

    private LayoutInfo deriveLayout(boolean bl, boolean bl2) {
        LayoutInfo layoutInfo = new LayoutInfo();
        int n = 0;
        List list = this.getFields(bl);
        if (list == null) {
            return null;
        }
        boolean bl3 = true;
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Field field = (Field)iterator2.next();
            int n2 = field.getModifiers();
            Class clazz = field.getType();
            if (clazz.isArray()) {
                layoutInfo.variable = true;
            }
            StructField structField = new StructField();
            structField.isVolatile = Modifier.isVolatile(n2);
            structField.isReadOnly = Modifier.isFinal(n2);
            if (structField.isReadOnly) {
                if (!Platform.RO_FIELDS) {
                    throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + this.getClass() + ")");
                }
                field.setAccessible(true);
            }
            structField.field = field;
            structField.name = field.getName();
            structField.type = clazz;
            if ((class$com$sun$jna$Callback == null ? Structure.class$("com.sun.jna.Callback") : class$com$sun$jna$Callback).isAssignableFrom(clazz) && !clazz.isInterface()) {
                throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }
            if (clazz.isArray() && (class$com$sun$jna$Structure == null ? Structure.class$("com.sun.jna.Structure") : class$com$sun$jna$Structure).equals(clazz.getComponentType())) {
                String string = "Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined";
                throw new IllegalArgumentException(string);
            }
            int n3 = 1;
            if (Modifier.isPublic(field.getModifiers())) {
                Object object;
                ToNativeConverter toNativeConverter;
                Object object2 = this.getField(structField);
                if (object2 == null && clazz.isArray()) {
                    if (bl) {
                        throw new IllegalStateException("Array fields must be initialized");
                    }
                    return null;
                }
                Class clazz2 = clazz;
                if ((class$com$sun$jna$NativeMapped == null ? Structure.class$("com.sun.jna.NativeMapped") : class$com$sun$jna$NativeMapped).isAssignableFrom(clazz)) {
                    toNativeConverter = NativeMappedConverter.getInstance(clazz);
                    clazz2 = ((NativeMappedConverter)toNativeConverter).nativeType();
                    structField.writeConverter = toNativeConverter;
                    structField.readConverter = toNativeConverter;
                    structField.context = new StructureReadContext(this, field);
                } else if (this.typeMapper != null) {
                    toNativeConverter = this.typeMapper.getToNativeConverter(clazz);
                    object = this.typeMapper.getFromNativeConverter(clazz);
                    if (toNativeConverter != null && object != null) {
                        clazz2 = (object2 = toNativeConverter.toNative(object2, new StructureWriteContext(this, structField.field))) != null ? object2.getClass() : (class$com$sun$jna$Pointer == null ? Structure.class$("com.sun.jna.Pointer") : class$com$sun$jna$Pointer);
                        structField.writeConverter = toNativeConverter;
                        structField.readConverter = object;
                        structField.context = new StructureReadContext(this, field);
                    } else if (toNativeConverter != null || object != null) {
                        String string = "Structures require bidirectional type conversion for " + clazz;
                        throw new IllegalArgumentException(string);
                    }
                }
                if (object2 == null) {
                    object2 = this.initializeField(structField, clazz);
                }
                try {
                    structField.size = this.getNativeSize(clazz2, object2);
                    n3 = this.getNativeAlignment(clazz2, object2, bl3);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    if (!bl && this.typeMapper == null) {
                        return null;
                    }
                    object = "Invalid Structure field in " + this.getClass() + ", field name '" + structField.name + "', " + structField.type + ": " + illegalArgumentException.getMessage();
                    throw new IllegalArgumentException((String)object);
                }
                layoutInfo.alignment = Math.max(layoutInfo.alignment, n3);
                if (n % n3 != 0) {
                    n += n3 - n % n3;
                }
                structField.offset = n;
                n += structField.size;
                layoutInfo.fields.put(structField.name, structField);
            }
            bl3 = false;
        }
        if (n > 0) {
            int n4 = this.calculateAlignedSize(n, layoutInfo.alignment);
            if (this instanceof ByValue && !bl2) {
                this.getTypeInfo();
            }
            if (this.memory != null && !(this.memory instanceof AutoAllocated)) {
                this.memory = this.memory.share(0L, n4);
            }
            layoutInfo.size = n4;
            return layoutInfo;
        }
        throw new IllegalArgumentException("Structure " + this.getClass() + " has unknown size (ensure " + "all fields are public)");
    }

    private void initializeFields() {
        Iterator iterator2 = this.fields().values().iterator();
        while (iterator2.hasNext()) {
            StructField structField = (StructField)iterator2.next();
            this.initializeField(structField, structField.type);
        }
    }

    private Object initializeField(StructField structField, Class clazz) {
        Object object = null;
        if (Structure.class.isAssignableFrom(clazz) && !ByReference.class.isAssignableFrom(clazz)) {
            try {
                object = Structure.newInstance(clazz);
                this.setField(structField, object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                String string = "Can't determine size of nested structure: " + illegalArgumentException.getMessage();
                throw new IllegalArgumentException(string);
            }
        } else if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
            object = nativeMappedConverter.defaultValue();
            this.setField(structField, object);
        }
        return object;
    }

    int calculateAlignedSize(int n) {
        return this.calculateAlignedSize(n, this.structAlignment);
    }

    private int calculateAlignedSize(int n, int n2) {
        if (this.alignType != 1 && n % n2 != 0) {
            n += n2 - n % n2;
        }
        return n;
    }

    protected int getStructAlignment() {
        if (this.size == -1) {
            this.calculateSize(true);
        }
        return this.structAlignment;
    }

    protected int getNativeAlignment(Class clazz, Object object, boolean bl) {
        int n = 1;
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
            clazz = nativeMappedConverter.nativeType();
            object = nativeMappedConverter.toNative(object, new ToNativeContext());
        }
        int n2 = Native.getNativeSize(clazz, object);
        if (clazz.isPrimitive() || Long.class == clazz || Integer.class == clazz || Short.class == clazz || Character.class == clazz || Byte.class == clazz || Boolean.class == clazz || Float.class == clazz || Double.class == clazz) {
            n = n2;
        } else if (Pointer.class == clazz || Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clazz) || Callback.class.isAssignableFrom(clazz) || WString.class == clazz || String.class == clazz) {
            n = Pointer.SIZE;
        } else if (Structure.class.isAssignableFrom(clazz)) {
            if (ByReference.class.isAssignableFrom(clazz)) {
                n = Pointer.SIZE;
            } else {
                if (object == null) {
                    object = Structure.newInstance(clazz);
                }
                n = ((Structure)object).getStructAlignment();
            }
        } else if (clazz.isArray()) {
            n = this.getNativeAlignment(clazz.getComponentType(), null, bl);
        } else {
            throw new IllegalArgumentException("Type " + clazz + " has unknown " + "native alignment");
        }
        if (this.alignType == 1) {
            n = 1;
        } else if (this.alignType == 3) {
            n = Math.min(8, n);
        } else if (!(this.alignType != 2 || bl && Platform.isMac() && isPPC)) {
            n = Math.min(MAX_GNUC_ALIGNMENT, n);
        }
        return n;
    }

    public String toString() {
        return this.toString(Boolean.getBoolean("jna.dump_memory"));
    }

    public String toString(boolean bl) {
        return this.toString(0, true, true);
    }

    private String format(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(".");
        return string.substring(n + 1);
    }

    private String toString(int n, boolean bl, boolean bl2) {
        Object object;
        this.ensureAllocated();
        String string = System.getProperty("line.separator");
        String string2 = this.format(this.getClass()) + "(" + this.getPointer() + ")";
        if (!(this.getPointer() instanceof Memory)) {
            string2 = string2 + " (" + this.size() + " bytes)";
        }
        String string3 = "";
        for (int i = 0; i < n; ++i) {
            string3 = string3 + "  ";
        }
        String string4 = string;
        if (!bl) {
            string4 = "...}";
        } else {
            Iterator iterator2 = this.fields().values().iterator();
            while (iterator2.hasNext()) {
                object = (StructField)iterator2.next();
                Object object2 = this.getField((StructField)object);
                String string5 = this.format(((StructField)object).type);
                String string6 = "";
                string4 = string4 + string3;
                if (((StructField)object).type.isArray() && object2 != null) {
                    string5 = this.format(((StructField)object).type.getComponentType());
                    string6 = "[" + Array.getLength(object2) + "]";
                }
                string4 = string4 + "  " + string5 + " " + ((StructField)object).name + string6 + "@" + Integer.toHexString(((StructField)object).offset);
                if (object2 instanceof Structure) {
                    object2 = ((Structure)object2).toString(n + 1, !(object2 instanceof ByReference), bl2);
                }
                string4 = string4 + "=";
                string4 = object2 instanceof Long ? string4 + Long.toHexString((Long)object2) : (object2 instanceof Integer ? string4 + Integer.toHexString((Integer)object2) : (object2 instanceof Short ? string4 + Integer.toHexString(((Short)object2).shortValue()) : (object2 instanceof Byte ? string4 + Integer.toHexString(((Byte)object2).byteValue()) : string4 + String.valueOf(object2).trim())));
                string4 = string4 + string;
                if (iterator2.hasNext()) continue;
                string4 = string4 + string3 + "}";
            }
        }
        if (n == 0 && bl2) {
            int n2 = 4;
            string4 = string4 + string + "memory dump" + string;
            object = this.getPointer().getByteArray(0L, this.size());
            for (int i = 0; i < ((Object)object).length; ++i) {
                if (i % 4 == 0) {
                    string4 = string4 + "[";
                }
                if (object[i] >= 0 && object[i] < 16) {
                    string4 = string4 + "0";
                }
                string4 = string4 + Integer.toHexString(object[i] & 0xFF);
                if (i % 4 != 3 || i >= ((Object)object).length - 1) continue;
                string4 = string4 + "]" + string;
            }
            string4 = string4 + "]";
        }
        return string2 + " {" + string4;
    }

    public Structure[] toArray(Structure[] structureArray) {
        int n;
        this.ensureAllocated();
        if (this.memory instanceof AutoAllocated) {
            Memory memory = (Memory)this.memory;
            n = structureArray.length * this.size();
            if (memory.size() < (long)n) {
                this.useMemory(this.autoAllocate(n));
            }
        }
        structureArray[0] = this;
        int n2 = this.size();
        for (n = 1; n < structureArray.length; ++n) {
            structureArray[n] = Structure.newInstance(this.getClass());
            structureArray[n].useMemory(this.memory.share(n * n2, n2));
            structureArray[n].read();
        }
        if (!(this instanceof ByValue)) {
            this.array = structureArray;
        }
        return structureArray;
    }

    public Structure[] toArray(int n) {
        return this.toArray((Structure[])Array.newInstance(this.getClass(), n));
    }

    private Class baseClass() {
        if ((this instanceof ByReference || this instanceof ByValue) && Structure.class.isAssignableFrom(this.getClass().getSuperclass())) {
            return this.getClass().getSuperclass();
        }
        return this.getClass();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Structure)) {
            return false;
        }
        if (object.getClass() != this.getClass() && ((Structure)object).baseClass() != this.baseClass()) {
            return false;
        }
        Structure structure = (Structure)object;
        if (structure.getPointer().equals(this.getPointer())) {
            return true;
        }
        if (structure.size() == this.size()) {
            this.clear();
            this.write();
            byte[] byArray = this.getPointer().getByteArray(0L, this.size());
            structure.clear();
            structure.write();
            byte[] byArray2 = structure.getPointer().getByteArray(0L, structure.size());
            return Arrays.equals(byArray, byArray2);
        }
        return false;
    }

    public int hashCode() {
        this.clear();
        this.write();
        Adler32 adler32 = new Adler32();
        adler32.update(this.getPointer().getByteArray(0L, this.size()));
        return (int)adler32.getValue();
    }

    protected void cacheTypeInfo(Pointer pointer) {
        this.typeInfo = pointer.peer;
    }

    protected Pointer getFieldTypeInfo(StructField structField) {
        ToNativeConverter toNativeConverter;
        Class clazz = structField.type;
        Object object = this.getField(structField);
        if (this.typeMapper != null && (toNativeConverter = this.typeMapper.getToNativeConverter(clazz)) != null) {
            clazz = toNativeConverter.nativeType();
            object = toNativeConverter.toNative(object, new ToNativeContext());
        }
        return FFIType.get(object, clazz);
    }

    Pointer getTypeInfo() {
        Pointer pointer = Structure.getTypeInfo(this);
        this.cacheTypeInfo(pointer);
        return pointer;
    }

    public void setAutoSynch(boolean bl) {
        this.setAutoRead(bl);
        this.setAutoWrite(bl);
    }

    public void setAutoRead(boolean bl) {
        this.autoRead = bl;
    }

    public boolean getAutoRead() {
        return this.autoRead;
    }

    public void setAutoWrite(boolean bl) {
        this.autoWrite = bl;
    }

    public boolean getAutoWrite() {
        return this.autoWrite;
    }

    static Pointer getTypeInfo(Object object) {
        return FFIType.get(object);
    }

    public static Structure newInstance(Class clazz) throws IllegalArgumentException {
        try {
            Structure structure = (Structure)clazz.newInstance();
            if (structure instanceof ByValue) {
                structure.allocateMemory();
            }
            return structure;
        }
        catch (InstantiationException instantiationException) {
            String string = "Can't instantiate " + clazz + " (" + instantiationException + ")";
            throw new IllegalArgumentException(string);
        }
        catch (IllegalAccessException illegalAccessException) {
            String string = "Instantiation of " + clazz + " not allowed, is it public? (" + illegalAccessException + ")";
            throw new IllegalArgumentException(string);
        }
    }

    private static void structureArrayCheck(Structure[] structureArray) {
        Pointer pointer = structureArray[0].getPointer();
        int n = structureArray[0].size();
        for (int i = 1; i < structureArray.length; ++i) {
            if (structureArray[i].getPointer().peer == pointer.peer + (long)(n * i)) continue;
            String string = "Structure array elements must use contiguous memory (bad backing address at Structure array index " + i + ")";
            throw new IllegalArgumentException(string);
        }
    }

    public static void autoRead(Structure[] structureArray) {
        Structure.structureArrayCheck(structureArray);
        if (structureArray[0].array == structureArray) {
            structureArray[0].autoRead();
        } else {
            for (int i = 0; i < structureArray.length; ++i) {
                structureArray[i].autoRead();
            }
        }
    }

    public void autoRead() {
        if (this.getAutoRead()) {
            this.read();
            if (this.array != null) {
                for (int i = 1; i < this.array.length; ++i) {
                    this.array[i].autoRead();
                }
            }
        }
    }

    public static void autoWrite(Structure[] structureArray) {
        Structure.structureArrayCheck(structureArray);
        if (structureArray[0].array == structureArray) {
            structureArray[0].autoWrite();
        } else {
            for (int i = 0; i < structureArray.length; ++i) {
                structureArray[i].autoWrite();
            }
        }
    }

    public void autoWrite() {
        if (this.getAutoWrite()) {
            this.write();
            if (this.array != null) {
                for (int i = 1; i < this.array.length; ++i) {
                    this.array[i].autoWrite();
                }
            }
        }
    }

    protected int getNativeSize(Class clazz, Object object) {
        return Native.getNativeSize(clazz, object);
    }

    static {
        Field[] fieldArray = MemberOrder.class.getFields();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < fieldArray.length; ++i) {
            arrayList.add(fieldArray[i].getName());
        }
        List<String> list = Arrays.asList(MemberOrder.FIELDS);
        ArrayList<String> arrayList2 = new ArrayList<String>(list);
        Collections.reverse(arrayList2);
        REVERSE_FIELDS = ((Object)arrayList).equals(arrayList2);
        REQUIRES_FIELD_ORDER = !((Object)arrayList).equals(list) && !REVERSE_FIELDS;
        String string = System.getProperty("os.arch").toLowerCase();
        isPPC = "ppc".equals(string) || "powerpc".equals(string);
        isSPARC = "sparc".equals(string);
        isARM = "arm".equals(string);
        MAX_GNUC_ALIGNMENT = isSPARC || (isPPC || isARM) && Platform.isLinux() ? 8 : Native.LONG_SIZE;
        layoutInfo = new WeakHashMap();
        reads = new ThreadLocal(){

            protected synchronized Object initialValue() {
                return new HashMap();
            }
        };
        busy = new ThreadLocal(){

            protected synchronized Object initialValue() {
                return new StructureSet();
            }

            public class StructureSet
            extends AbstractCollection
            implements Set {
                private Structure[] elements;
                private int count;

                StructureSet() {
                }

                private void ensureCapacity(int n) {
                    if (this.elements == null) {
                        this.elements = new Structure[n * 3 / 2];
                    } else if (this.elements.length < n) {
                        Structure[] structureArray = new Structure[n * 3 / 2];
                        System.arraycopy(this.elements, 0, structureArray, 0, this.elements.length);
                        this.elements = structureArray;
                    }
                }

                public int size() {
                    return this.count;
                }

                public boolean contains(Object object) {
                    return this.indexOf(object) != -1;
                }

                public boolean add(Object object) {
                    if (!this.contains(object)) {
                        this.ensureCapacity(this.count + 1);
                        this.elements[this.count++] = (Structure)object;
                    }
                    return true;
                }

                private int indexOf(Object object) {
                    Structure structure = (Structure)object;
                    for (int i = 0; i < this.count; ++i) {
                        Structure structure2 = this.elements[i];
                        if (structure != structure2 && (structure.getClass() != structure2.getClass() || structure.size() != structure2.size() || !structure.getPointer().equals(structure2.getPointer()))) continue;
                        return i;
                    }
                    return -1;
                }

                public boolean remove(Object object) {
                    int n = this.indexOf(object);
                    if (n != -1) {
                        if (--this.count > 0) {
                            this.elements[n] = this.elements[this.count];
                            this.elements[this.count] = null;
                        }
                        return true;
                    }
                    return false;
                }

                public Iterator iterator() {
                    Structure[] structureArray = new Structure[this.count];
                    if (this.count > 0) {
                        System.arraycopy(this.elements, 0, structureArray, 0, this.count);
                    }
                    return Arrays.asList(structureArray).iterator();
                }
            }
        };
    }

    private class AutoAllocated
    extends Memory {
        public AutoAllocated(int n) {
            super(n);
            super.clear();
        }
    }

    public static class FFIType
    extends Structure {
        private static Map typeInfoMap = new WeakHashMap();
        private static final int FFI_TYPE_STRUCT = 13;
        public size_t size;
        public short alignment;
        public short type = (short)13;
        public Pointer elements;

        private FFIType(Structure structure) {
            Pointer[] pointerArray;
            structure.ensureAllocated(true);
            if (structure instanceof Union) {
                StructField structField = ((Union)structure).biggestField;
                pointerArray = new Pointer[]{FFIType.get(structure.getField(structField), structField.type), null};
            } else {
                pointerArray = new Pointer[structure.fields().size() + 1];
                int n = 0;
                Iterator iterator2 = structure.fields().values().iterator();
                while (iterator2.hasNext()) {
                    StructField structField = (StructField)iterator2.next();
                    pointerArray[n++] = structure.getFieldTypeInfo(structField);
                }
            }
            this.init(pointerArray);
        }

        private FFIType(Object object, Class clazz) {
            int n = Array.getLength(object);
            Pointer[] pointerArray = new Pointer[n + 1];
            Pointer pointer = FFIType.get(null, clazz.getComponentType());
            for (int i = 0; i < n; ++i) {
                pointerArray[i] = pointer;
            }
            this.init(pointerArray);
        }

        private void init(Pointer[] pointerArray) {
            this.elements = new Memory(Pointer.SIZE * pointerArray.length);
            this.elements.write(0L, pointerArray, 0, pointerArray.length);
            this.write();
        }

        static Pointer get(Object object) {
            if (object == null) {
                return FFITypes.ffi_type_pointer;
            }
            if (object instanceof Class) {
                return FFIType.get(null, (Class)object);
            }
            return FFIType.get(object, object.getClass());
        }

        private static Pointer get(Object object, Class clazz) {
            Object object2;
            TypeMapper typeMapper = Native.getTypeMapper(clazz);
            if (typeMapper != null && (object2 = typeMapper.getToNativeConverter(clazz)) != null) {
                clazz = object2.nativeType();
            }
            object2 = typeInfoMap;
            synchronized (object2) {
                Object v = typeInfoMap.get(clazz);
                if (v instanceof Pointer) {
                    return (Pointer)v;
                }
                if (v instanceof FFIType) {
                    return ((FFIType)v).getPointer();
                }
                if (Platform.HAS_BUFFERS && (class$java$nio$Buffer == null ? (class$java$nio$Buffer = Structure.class$("java.nio.Buffer")) : class$java$nio$Buffer).isAssignableFrom(clazz) || (class$com$sun$jna$Callback == null ? (class$com$sun$jna$Callback = Structure.class$("com.sun.jna.Callback")) : class$com$sun$jna$Callback).isAssignableFrom(clazz)) {
                    typeInfoMap.put(clazz, FFITypes.ffi_type_pointer);
                    return FFITypes.ffi_type_pointer;
                }
                if ((class$com$sun$jna$Structure == null ? (class$com$sun$jna$Structure = Structure.class$("com.sun.jna.Structure")) : class$com$sun$jna$Structure).isAssignableFrom(clazz)) {
                    if (object == null) {
                        object = FFIType.newInstance(clazz);
                    }
                    if ((class$com$sun$jna$Structure$ByReference == null ? (class$com$sun$jna$Structure$ByReference = Structure.class$("com.sun.jna.Structure$ByReference")) : class$com$sun$jna$Structure$ByReference).isAssignableFrom(clazz)) {
                        typeInfoMap.put(clazz, FFITypes.ffi_type_pointer);
                        return FFITypes.ffi_type_pointer;
                    }
                    FFIType fFIType = new FFIType((Structure)object);
                    typeInfoMap.put(clazz, fFIType);
                    return fFIType.getPointer();
                }
                if ((class$com$sun$jna$NativeMapped == null ? (class$com$sun$jna$NativeMapped = Structure.class$("com.sun.jna.NativeMapped")) : class$com$sun$jna$NativeMapped).isAssignableFrom(clazz)) {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
                    return FFIType.get(nativeMappedConverter.toNative(object, new ToNativeContext()), nativeMappedConverter.nativeType());
                }
                if (clazz.isArray()) {
                    FFIType fFIType = new FFIType(object, clazz);
                    typeInfoMap.put(object, fFIType);
                    return fFIType.getPointer();
                }
                throw new IllegalArgumentException("Unsupported Structure field type " + clazz);
            }
        }

        static {
            if (Native.POINTER_SIZE == 0) {
                throw new Error("Native library not initialized");
            }
            if (FFITypes.ffi_type_void == null) {
                throw new Error("FFI types not initialized");
            }
            typeInfoMap.put(Void.TYPE, FFITypes.ffi_type_void);
            typeInfoMap.put(class$java$lang$Void == null ? (class$java$lang$Void = Structure.class$("java.lang.Void")) : class$java$lang$Void, FFITypes.ffi_type_void);
            typeInfoMap.put(Float.TYPE, FFITypes.ffi_type_float);
            typeInfoMap.put(class$java$lang$Float == null ? (class$java$lang$Float = Structure.class$("java.lang.Float")) : class$java$lang$Float, FFITypes.ffi_type_float);
            typeInfoMap.put(Double.TYPE, FFITypes.ffi_type_double);
            typeInfoMap.put(class$java$lang$Double == null ? (class$java$lang$Double = Structure.class$("java.lang.Double")) : class$java$lang$Double, FFITypes.ffi_type_double);
            typeInfoMap.put(Long.TYPE, FFITypes.ffi_type_sint64);
            typeInfoMap.put(class$java$lang$Long == null ? (class$java$lang$Long = Structure.class$("java.lang.Long")) : class$java$lang$Long, FFITypes.ffi_type_sint64);
            typeInfoMap.put(Integer.TYPE, FFITypes.ffi_type_sint32);
            typeInfoMap.put(class$java$lang$Integer == null ? (class$java$lang$Integer = Structure.class$("java.lang.Integer")) : class$java$lang$Integer, FFITypes.ffi_type_sint32);
            typeInfoMap.put(Short.TYPE, FFITypes.ffi_type_sint16);
            typeInfoMap.put(class$java$lang$Short == null ? (class$java$lang$Short = Structure.class$("java.lang.Short")) : class$java$lang$Short, FFITypes.ffi_type_sint16);
            Pointer pointer = Native.WCHAR_SIZE == 2 ? FFITypes.ffi_type_uint16 : FFITypes.ffi_type_uint32;
            typeInfoMap.put(Character.TYPE, pointer);
            typeInfoMap.put(class$java$lang$Character == null ? (class$java$lang$Character = Structure.class$("java.lang.Character")) : class$java$lang$Character, pointer);
            typeInfoMap.put(Byte.TYPE, FFITypes.ffi_type_sint8);
            typeInfoMap.put(class$java$lang$Byte == null ? (class$java$lang$Byte = Structure.class$("java.lang.Byte")) : class$java$lang$Byte, FFITypes.ffi_type_sint8);
            typeInfoMap.put(class$com$sun$jna$Pointer == null ? (class$com$sun$jna$Pointer = Structure.class$("com.sun.jna.Pointer")) : class$com$sun$jna$Pointer, FFITypes.ffi_type_pointer);
            typeInfoMap.put(class$java$lang$String == null ? (class$java$lang$String = Structure.class$("java.lang.String")) : class$java$lang$String, FFITypes.ffi_type_pointer);
            typeInfoMap.put(class$com$sun$jna$WString == null ? (class$com$sun$jna$WString = Structure.class$("com.sun.jna.WString")) : class$com$sun$jna$WString, FFITypes.ffi_type_pointer);
            typeInfoMap.put(Boolean.TYPE, FFITypes.ffi_type_uint32);
            typeInfoMap.put(class$java$lang$Boolean == null ? (class$java$lang$Boolean = Structure.class$("java.lang.Boolean")) : class$java$lang$Boolean, FFITypes.ffi_type_uint32);
        }

        private static class FFITypes {
            private static Pointer ffi_type_void;
            private static Pointer ffi_type_float;
            private static Pointer ffi_type_double;
            private static Pointer ffi_type_longdouble;
            private static Pointer ffi_type_uint8;
            private static Pointer ffi_type_sint8;
            private static Pointer ffi_type_uint16;
            private static Pointer ffi_type_sint16;
            private static Pointer ffi_type_uint32;
            private static Pointer ffi_type_sint32;
            private static Pointer ffi_type_uint64;
            private static Pointer ffi_type_sint64;
            private static Pointer ffi_type_pointer;

            private FFITypes() {
            }
        }

        public static class size_t
        extends IntegerType {
            public size_t() {
                this(0L);
            }

            public size_t(long l) {
                super(Native.POINTER_SIZE, l);
            }
        }
    }

    public class StructField {
        public String name;
        public Class type;
        public Field field;
        public int size = -1;
        public int offset = -1;
        public boolean isVolatile;
        public boolean isReadOnly;
        public FromNativeConverter readConverter;
        public ToNativeConverter writeConverter;
        public FromNativeContext context;

        StructField() {
        }

        public String toString() {
            return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
        }
    }

    private class LayoutInfo {
        int size = -1;
        int alignment = 1;
        Map fields = Collections.synchronizedMap(new LinkedHashMap());
        int alignType = 0;
        TypeMapper typeMapper;
        List fieldOrder;
        boolean variable;

        private LayoutInfo() {
        }
    }

    private static class MemberOrder {
        private static final String[] FIELDS = new String[]{"first", "second", "middle", "penultimate", "last"};
        public int first;
        public int second;
        public int middle;
        public int penultimate;
        public int last;

        private MemberOrder() {
        }
    }

    public static interface ByReference {
    }

    public static interface ByValue {
    }
}

