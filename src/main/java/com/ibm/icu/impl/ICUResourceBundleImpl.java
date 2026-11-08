/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import com.ibm.icu.util.UResourceTypeMismatchException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ICUResourceBundleImpl
extends ICUResourceBundle {
    protected ICUResourceBundleImpl(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
        super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
    }

    protected final ICUResourceBundle createBundleObject(String string, int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, boolean[] blArray) {
        if (blArray != null) {
            blArray[0] = false;
        }
        String string2 = this.resPath + "/" + string;
        switch (ICUResourceBundleReader.RES_GET_TYPE(n)) {
            case 0: 
            case 6: {
                return new ResourceString(this.reader, string, string2, n, this);
            }
            case 1: {
                return new ResourceBinary(this.reader, string, string2, n, this);
            }
            case 3: {
                if (blArray != null) {
                    blArray[0] = true;
                }
                return this.findResource(string, string2, n, hashMap, uResourceBundle);
            }
            case 7: {
                return new ResourceInt(this.reader, string, string2, n, this);
            }
            case 14: {
                return new ResourceIntVector(this.reader, string, string2, n, this);
            }
            case 8: 
            case 9: {
                return new ResourceArray(this.reader, string, string2, n, this);
            }
            case 2: 
            case 4: 
            case 5: {
                return new ResourceTable(this.reader, string, string2, n, this);
            }
        }
        throw new IllegalStateException("The resource type is unknown");
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ResourceTable
    extends ResourceContainer {
        @Override
        protected String getKey(int n) {
            return ((ICUResourceBundleReader.Table)this.value).getKey(n);
        }

        @Override
        protected Set<String> handleKeySet() {
            TreeSet<String> treeSet = new TreeSet<String>();
            ICUResourceBundleReader.Table table = (ICUResourceBundleReader.Table)this.value;
            for (int i = 0; i < table.getSize(); ++i) {
                treeSet.add(table.getKey(i));
            }
            return treeSet;
        }

        @Override
        protected int getTableResource(String string) {
            return ((ICUResourceBundleReader.Table)this.value).getTableResource(string);
        }

        @Override
        protected int getTableResource(int n) {
            return this.getContainerResource(n);
        }

        @Override
        protected UResourceBundle handleGetImpl(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, int[] nArray, boolean[] blArray) {
            int n = ((ICUResourceBundleReader.Table)this.value).findTableItem(string);
            if (nArray != null) {
                nArray[0] = n;
            }
            if (n < 0) {
                return null;
            }
            return this.createBundleObject(n, string, hashMap, uResourceBundle, blArray);
        }

        @Override
        protected UResourceBundle handleGetImpl(int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, boolean[] blArray) {
            String string = ((ICUResourceBundleReader.Table)this.value).getKey(n);
            if (string == null) {
                throw new IndexOutOfBoundsException();
            }
            return this.createBundleObject(n, string, hashMap, uResourceBundle, blArray);
        }

        ResourceTable(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
            this.value = iCUResourceBundleReader.getTable(n);
            this.createLookupCache();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ResourceArray
    extends ResourceContainer {
        @Override
        protected String[] handleGetStringArray() {
            String[] stringArray = new String[this.value.getSize()];
            UResourceBundleIterator uResourceBundleIterator = this.getIterator();
            int n = 0;
            while (uResourceBundleIterator.hasNext()) {
                stringArray[n++] = uResourceBundleIterator.next().getString();
            }
            return stringArray;
        }

        @Override
        public String[] getStringArray() {
            return this.handleGetStringArray();
        }

        @Override
        protected UResourceBundle handleGetImpl(String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, int[] nArray, boolean[] blArray) {
            int n;
            int n2 = n = string.length() > 0 ? Integer.valueOf(string) : -1;
            if (nArray != null) {
                nArray[0] = n;
            }
            if (n < 0) {
                throw new UResourceTypeMismatchException("Could not get the correct value for index: " + string);
            }
            return this.createBundleObject(n, string, hashMap, uResourceBundle, blArray);
        }

        @Override
        protected UResourceBundle handleGetImpl(int n, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, boolean[] blArray) {
            return this.createBundleObject(n, Integer.toString(n), hashMap, uResourceBundle, blArray);
        }

        ResourceArray(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
            this.value = iCUResourceBundleReader.getArray(n);
            this.createLookupCache();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ResourceContainer
    extends ICUResourceBundleImpl {
        protected ICUResourceBundleReader.Container value;

        @Override
        public int getSize() {
            return this.value.getSize();
        }

        protected int getContainerResource(int n) {
            return this.value.getContainerResource(n);
        }

        protected UResourceBundle createBundleObject(int n, String string, HashMap<String, String> hashMap, UResourceBundle uResourceBundle, boolean[] blArray) {
            int n2 = this.getContainerResource(n);
            if (n2 == -1) {
                throw new IndexOutOfBoundsException();
            }
            return this.createBundleObject(string, n2, hashMap, uResourceBundle, blArray);
        }

        ResourceContainer(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
        }
    }

    private static final class ResourceIntVector
    extends ICUResourceBundleImpl {
        private int[] value;

        public int[] getIntVector() {
            return this.value;
        }

        ResourceIntVector(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
            this.value = iCUResourceBundleReader.getIntVector(n);
        }
    }

    private static final class ResourceString
    extends ICUResourceBundleImpl {
        private String value;

        public String getString() {
            return this.value;
        }

        ResourceString(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
            this.value = iCUResourceBundleReader.getString(n);
        }
    }

    private static final class ResourceInt
    extends ICUResourceBundleImpl {
        public int getInt() {
            return ICUResourceBundleReader.RES_GET_INT(this.resource);
        }

        public int getUInt() {
            return ICUResourceBundleReader.RES_GET_UINT(this.resource);
        }

        ResourceInt(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
        }
    }

    private static final class ResourceBinary
    extends ICUResourceBundleImpl {
        public ByteBuffer getBinary() {
            return this.reader.getBinary(this.resource);
        }

        public byte[] getBinary(byte[] byArray) {
            return this.reader.getBinary(this.resource, byArray);
        }

        ResourceBinary(ICUResourceBundleReader iCUResourceBundleReader, String string, String string2, int n, ICUResourceBundleImpl iCUResourceBundleImpl) {
            super(iCUResourceBundleReader, string, string2, n, iCUResourceBundleImpl);
        }
    }
}

