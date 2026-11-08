/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.SerializationException;

public class SerializationUtils {
    public static <T extends Serializable> T clone(T t) {
        if (t == null) {
            return null;
        }
        byte[] byArray = SerializationUtils.serialize(t);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ObjectInputStream objectInputStream = null;
        try {
            Serializable serializable;
            objectInputStream = new ClassLoaderAwareObjectInputStream(byteArrayInputStream, t.getClass().getClassLoader());
            Serializable serializable2 = serializable = (Serializable)objectInputStream.readObject();
            return (T)serializable2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", classNotFoundException);
        }
        catch (IOException iOException) {
            throw new SerializationException("IOException while reading cloned object data", iOException);
        }
        finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            }
            catch (IOException iOException) {
                throw new SerializationException("IOException on closing cloned object data InputStream.", iOException);
            }
        }
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (T)((Serializable)SerializationUtils.deserialize(SerializationUtils.serialize(t)));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream2) {
        if (outputStream2 == null) {
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream2);
            objectOutputStream.writeObject(serializable);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        SerializationUtils.serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static <T> T deserialize(InputStream inputStream2) {
        Object object;
        if (inputStream2 == null) {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        ObjectInputStream objectInputStream = null;
        try {
            Object object2;
            objectInputStream = new ObjectInputStream(inputStream2);
            object = object2 = objectInputStream.readObject();
        }
        catch (ClassCastException classCastException) {
            throw new SerializationException(classCastException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new SerializationException(classNotFoundException);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
        return (T)object;
    }

    public static <T> T deserialize(byte[] byArray) {
        if (byArray == null) {
            throw new IllegalArgumentException("The byte[] must not be null");
        }
        return SerializationUtils.deserialize(new ByteArrayInputStream(byArray));
    }

    public static class ClassLoaderAwareObjectInputStream
    extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(InputStream inputStream2, ClassLoader classLoader) throws IOException {
            super(inputStream2);
            this.classLoader = classLoader;
            primitiveTypes.put("byte", Byte.TYPE);
            primitiveTypes.put("short", Short.TYPE);
            primitiveTypes.put("int", Integer.TYPE);
            primitiveTypes.put("long", Long.TYPE);
            primitiveTypes.put("float", Float.TYPE);
            primitiveTypes.put("double", Double.TYPE);
            primitiveTypes.put("boolean", Boolean.TYPE);
            primitiveTypes.put("char", Character.TYPE);
            primitiveTypes.put("void", Void.TYPE);
        }

        @Override
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            String string = objectStreamClass.getName();
            try {
                return Class.forName(string, false, this.classLoader);
            }
            catch (ClassNotFoundException classNotFoundException) {
                try {
                    return Class.forName(string, false, Thread.currentThread().getContextClassLoader());
                }
                catch (ClassNotFoundException classNotFoundException2) {
                    Class<?> clazz = primitiveTypes.get(string);
                    if (clazz != null) {
                        return clazz;
                    }
                    throw classNotFoundException2;
                }
            }
        }
    }
}

