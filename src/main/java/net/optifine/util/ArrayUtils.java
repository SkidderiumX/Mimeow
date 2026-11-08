/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ArrayUtils {
    public static boolean contains(Object[] objectArray, Object object) {
        if (objectArray == null) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            Object object2 = objectArray[i];
            if (object2 != object) continue;
            return true;
        }
        return false;
    }

    public static int[] addIntsToArray(int[] nArray, int[] nArray2) {
        if (nArray != null && nArray2 != null) {
            int n = nArray.length;
            int n2 = n + nArray2.length;
            int[] nArray3 = new int[n2];
            System.arraycopy(nArray, 0, nArray3, 0, n);
            for (int i = 0; i < nArray2.length; ++i) {
                nArray3[i + n] = nArray2[i];
            }
            return nArray3;
        }
        throw new NullPointerException("The given array is NULL");
    }

    public static int[] addIntToArray(int[] nArray, int n) {
        return ArrayUtils.addIntsToArray(nArray, new int[]{n});
    }

    public static Object[] addObjectsToArray(Object[] objectArray, Object[] objectArray2) {
        if (objectArray == null) {
            throw new NullPointerException("The given array is NULL");
        }
        if (objectArray2.length == 0) {
            return objectArray;
        }
        int n = objectArray.length;
        int n2 = n + objectArray2.length;
        Object[] objectArray3 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
        System.arraycopy(objectArray, 0, objectArray3, 0, n);
        System.arraycopy(objectArray2, 0, objectArray3, n, objectArray2.length);
        return objectArray3;
    }

    public static Object[] addObjectToArray(Object[] objectArray, Object object) {
        if (objectArray == null) {
            throw new NullPointerException("The given array is NULL");
        }
        int n = objectArray.length;
        int n2 = n + 1;
        Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
        System.arraycopy(objectArray, 0, objectArray2, 0, n);
        objectArray2[n] = object;
        return objectArray2;
    }

    public static Object[] addObjectToArray(Object[] objectArray, Object object, int n) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(objectArray));
        arrayList.add(n, object);
        Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), arrayList.size());
        return arrayList.toArray(objectArray2);
    }

    public static String arrayToString(boolean[] blArray, String string) {
        if (blArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(blArray.length * 5);
        for (int i = 0; i < blArray.length; ++i) {
            boolean bl = blArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(bl));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(float[] fArray) {
        return ArrayUtils.arrayToString(fArray, ", ");
    }

    public static String arrayToString(float[] fArray, String string) {
        if (fArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(fArray.length * 5);
        for (int i = 0; i < fArray.length; ++i) {
            float f = fArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(f));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(float[] fArray, String string, String string2) {
        if (fArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(fArray.length * 5);
        for (int i = 0; i < fArray.length; ++i) {
            float f = fArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.format(string2, Float.valueOf(f)));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(int[] nArray) {
        return ArrayUtils.arrayToString(nArray, ", ");
    }

    public static String arrayToString(int[] nArray, String string) {
        if (nArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(nArray.length * 5);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(n));
        }
        return stringBuffer.toString();
    }

    public static String arrayToHexString(int[] nArray, String string) {
        if (nArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(nArray.length * 5);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append("0x");
            stringBuffer.append(Integer.toHexString(n));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(Object[] objectArray) {
        return ArrayUtils.arrayToString(objectArray, ", ");
    }

    public static String arrayToString(Object[] objectArray, String string) {
        if (objectArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(objectArray.length * 5);
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            if (i > 0) {
                stringBuffer.append(string);
            }
            stringBuffer.append(String.valueOf(object));
        }
        return stringBuffer.toString();
    }

    public static Object[] collectionToArray(Collection collection, Class clazz) {
        if (collection == null) {
            return null;
        }
        if (clazz == null) {
            return null;
        }
        if (clazz.isPrimitive()) {
            throw new IllegalArgumentException("Can not make arrays with primitive elements (int, double), element class: " + String.valueOf(clazz));
        }
        Object[] objectArray = (Object[])Array.newInstance(clazz, collection.size());
        return collection.toArray(objectArray);
    }

    public static boolean equalsOne(int n, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return true;
        }
        return false;
    }

    public static boolean equalsOne(Object object, Object[] objectArray) {
        if (objectArray == null) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            Object object2 = objectArray[i];
            if (!ArrayUtils.equals(object, object2)) continue;
            return true;
        }
        return false;
    }

    public static boolean equals(Object object, Object object2) {
        return object == object2 ? true : (object == null ? false : object.equals(object2));
    }

    public static boolean isSameOne(Object object, Object[] objectArray) {
        if (objectArray == null) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            Object object2 = objectArray[i];
            if (object != object2) continue;
            return true;
        }
        return false;
    }

    public static Object[] removeObjectFromArray(Object[] objectArray, Object object) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(objectArray));
        arrayList.remove(object);
        Object[] objectArray2 = ArrayUtils.collectionToArray(arrayList, objectArray.getClass().getComponentType());
        return objectArray2;
    }

    public static int[] toPrimitive(Integer[] integerArray) {
        if (integerArray == null) {
            return null;
        }
        if (integerArray.length == 0) {
            return new int[0];
        }
        int[] nArray = new int[integerArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = integerArray[i];
        }
        return nArray;
    }
}

