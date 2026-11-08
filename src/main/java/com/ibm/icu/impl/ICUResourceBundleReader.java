/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.VersionInfo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ICUResourceBundleReader
implements ICUBinary.Authenticate {
    private static final byte[] DATA_FORMAT_ID = new byte[]{82, 101, 115, 66};
    private static final int URES_INDEX_LENGTH = 0;
    private static final int URES_INDEX_KEYS_TOP = 1;
    private static final int URES_INDEX_BUNDLE_TOP = 3;
    private static final int URES_INDEX_ATTRIBUTES = 5;
    private static final int URES_INDEX_16BIT_TOP = 6;
    private static final int URES_INDEX_POOL_CHECKSUM = 7;
    private static final int URES_ATT_NO_FALLBACK = 1;
    private static final int URES_ATT_IS_POOL_BUNDLE = 2;
    private static final int URES_ATT_USES_POOL_BUNDLE = 4;
    private static final boolean DEBUG = false;
    private byte[] dataVersion;
    private String s16BitUnits;
    private byte[] poolBundleKeys;
    private String poolBundleKeysAsString;
    private int rootRes;
    private int localKeyLimit;
    private boolean noFallback;
    private boolean isPoolBundle;
    private boolean usesPoolBundle;
    private int[] indexes;
    private byte[] keyStrings;
    private String keyStringsAsString;
    private byte[] resourceBytes;
    private int resourceBottom;
    private static ReaderCache CACHE = new ReaderCache();
    private static final ICUResourceBundleReader NULL_READER = new ICUResourceBundleReader();
    private static byte[] emptyBytes = new byte[0];
    private static ByteBuffer emptyByteBuffer = ByteBuffer.allocate(0).asReadOnlyBuffer();
    private static char[] emptyChars = new char[0];
    private static int[] emptyInts = new int[0];
    private static String emptyString = "";
    private static final String ICU_RESOURCE_SUFFIX = ".res";

    private ICUResourceBundleReader() {
    }

    private ICUResourceBundleReader(InputStream inputStream2, String string, String string2, ClassLoader classLoader) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
        try {
            this.dataVersion = ICUBinary.readHeader(bufferedInputStream, DATA_FORMAT_ID, this);
            this.readData(bufferedInputStream);
            inputStream2.close();
        }
        catch (IOException iOException) {
            String string3 = ICUResourceBundleReader.getFullName(string, string2);
            throw new RuntimeException("Data file " + string3 + " is corrupt - " + iOException.getMessage());
        }
        if (this.usesPoolBundle) {
            ICUResourceBundleReader iCUResourceBundleReader = ICUResourceBundleReader.getReader(string, "pool", classLoader);
            if (!iCUResourceBundleReader.isPoolBundle) {
                throw new IllegalStateException("pool.res is not a pool bundle");
            }
            if (iCUResourceBundleReader.indexes[7] != this.indexes[7]) {
                throw new IllegalStateException("pool.res has a different checksum than this bundle");
            }
            this.poolBundleKeys = iCUResourceBundleReader.keyStrings;
            this.poolBundleKeysAsString = iCUResourceBundleReader.keyStringsAsString;
        }
    }

    static ICUResourceBundleReader getReader(String string, String string2, ClassLoader classLoader) {
        ReaderInfo readerInfo = new ReaderInfo(string, string2, classLoader);
        ICUResourceBundleReader iCUResourceBundleReader = (ICUResourceBundleReader)CACHE.getInstance(readerInfo, readerInfo);
        if (iCUResourceBundleReader == NULL_READER) {
            return null;
        }
        return iCUResourceBundleReader;
    }

    private void readData(InputStream inputStream2) throws IOException {
        int n;
        int n2;
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        this.rootRes = dataInputStream.readInt();
        int n3 = dataInputStream.readInt();
        int n4 = n3 & 0xFF;
        this.indexes = new int[n4];
        this.indexes[0] = n3;
        for (n2 = 1; n2 < n4; ++n2) {
            this.indexes[n2] = dataInputStream.readInt();
        }
        this.resourceBottom = 1 + n4 << 2;
        if (n4 > 5) {
            n2 = this.indexes[5];
            this.noFallback = (n2 & 1) != 0;
            this.isPoolBundle = (n2 & 2) != 0;
            this.usesPoolBundle = (n2 & 4) != 0;
        }
        n2 = this.indexes[3] * 4;
        if (this.indexes[1] > 1 + n4) {
            int n5;
            n = 1 + n4 << 2;
            this.resourceBottom = n5 = this.indexes[1] << 2;
            if (this.isPoolBundle) {
                n5 -= n;
                n = 0;
            } else {
                this.localKeyLimit = n5;
            }
            this.keyStrings = new byte[n5];
            dataInputStream.readFully(this.keyStrings, n, n5 - n);
            if (this.isPoolBundle) {
                while (n < n5 && this.keyStrings[n5 - 1] == -86) {
                    this.keyStrings[--n5] = 0;
                }
                this.keyStringsAsString = new String(this.keyStrings, "US-ASCII");
            }
        }
        if (n4 > 6 && this.indexes[6] > this.indexes[1]) {
            n = (this.indexes[6] - this.indexes[1]) * 2;
            char[] cArray = new char[n];
            byte[] byArray = new byte[n * 2];
            dataInputStream.readFully(byArray);
            for (int i = 0; i < n; ++i) {
                cArray[i] = (char)(byArray[i * 2] << 8 | byArray[i * 2 + 1] & 0xFF);
            }
            this.s16BitUnits = new String(cArray);
            this.resourceBottom = this.indexes[6] << 2;
        } else {
            this.s16BitUnits = "\u0000";
        }
        this.resourceBytes = new byte[n2 - this.resourceBottom];
        dataInputStream.readFully(this.resourceBytes);
    }

    VersionInfo getVersion() {
        return VersionInfo.getInstance(this.dataVersion[0], this.dataVersion[1], this.dataVersion[2], this.dataVersion[3]);
    }

    public boolean isDataVersionAcceptable(byte[] byArray) {
        return byArray[0] == 1 && byArray[1] >= 1 || byArray[0] == 2;
    }

    int getRootResource() {
        return this.rootRes;
    }

    boolean getNoFallback() {
        return this.noFallback;
    }

    boolean getUsesPoolBundle() {
        return this.usesPoolBundle;
    }

    static int RES_GET_TYPE(int n) {
        return n >>> 28;
    }

    private static int RES_GET_OFFSET(int n) {
        return n & 0xFFFFFFF;
    }

    private int getResourceByteOffset(int n) {
        return (n << 2) - this.resourceBottom;
    }

    static int RES_GET_INT(int n) {
        return n << 4 >> 4;
    }

    static int RES_GET_UINT(int n) {
        return n & 0xFFFFFFF;
    }

    static boolean URES_IS_TABLE(int n) {
        return n == 2 || n == 5 || n == 4;
    }

    private char getChar(int n) {
        return (char)(this.resourceBytes[n] << 8 | this.resourceBytes[n + 1] & 0xFF);
    }

    private char[] getChars(int n, int n2) {
        char[] cArray = new char[n2];
        for (int i = 0; i < n2; ++i) {
            cArray[i] = (char)(this.resourceBytes[n] << 8 | this.resourceBytes[n + 1] & 0xFF);
            n += 2;
        }
        return cArray;
    }

    private int getInt(int n) {
        return this.resourceBytes[n] << 24 | (this.resourceBytes[n + 1] & 0xFF) << 16 | (this.resourceBytes[n + 2] & 0xFF) << 8 | this.resourceBytes[n + 3] & 0xFF;
    }

    private int[] getInts(int n, int n2) {
        int[] nArray = new int[n2];
        for (int i = 0; i < n2; ++i) {
            nArray[i] = this.resourceBytes[n] << 24 | (this.resourceBytes[n + 1] & 0xFF) << 16 | (this.resourceBytes[n + 2] & 0xFF) << 8 | this.resourceBytes[n + 3] & 0xFF;
            n += 4;
        }
        return nArray;
    }

    private char[] getTable16KeyOffsets(int n) {
        char c;
        if ((c = this.s16BitUnits.charAt(n++)) > '\u0000') {
            return this.s16BitUnits.substring(n, n + c).toCharArray();
        }
        return emptyChars;
    }

    private char[] getTableKeyOffsets(int n) {
        char c = this.getChar(n);
        if (c > '\u0000') {
            return this.getChars(n + 2, c);
        }
        return emptyChars;
    }

    private int[] getTable32KeyOffsets(int n) {
        int n2 = this.getInt(n);
        if (n2 > 0) {
            return this.getInts(n + 4, n2);
        }
        return emptyInts;
    }

    private String makeKeyStringFromBytes(int n) {
        byte by;
        StringBuilder stringBuilder = new StringBuilder();
        while ((by = this.keyStrings[n++]) != 0) {
            stringBuilder.append((char)by);
        }
        return stringBuilder.toString();
    }

    private String makeKeyStringFromString(int n) {
        int n2 = n;
        while (this.poolBundleKeysAsString.charAt(n2) != '\u0000') {
            ++n2;
        }
        return this.poolBundleKeysAsString.substring(n, n2);
    }

    private ByteSequence RES_GET_KEY16(char c) {
        if (c < this.localKeyLimit) {
            return new ByteSequence(this.keyStrings, c);
        }
        return new ByteSequence(this.poolBundleKeys, c - this.localKeyLimit);
    }

    private String getKey16String(int n) {
        if (n < this.localKeyLimit) {
            return this.makeKeyStringFromBytes(n);
        }
        return this.makeKeyStringFromString(n - this.localKeyLimit);
    }

    private ByteSequence RES_GET_KEY32(int n) {
        if (n >= 0) {
            return new ByteSequence(this.keyStrings, n);
        }
        return new ByteSequence(this.poolBundleKeys, n & Integer.MAX_VALUE);
    }

    private String getKey32String(int n) {
        if (n >= 0) {
            return this.makeKeyStringFromBytes(n);
        }
        return this.makeKeyStringFromString(n & Integer.MAX_VALUE);
    }

    private static int compareKeys(CharSequence charSequence, ByteSequence byteSequence) {
        int n;
        for (n = 0; n < charSequence.length(); ++n) {
            byte by = byteSequence.charAt(n);
            if (by == 0) {
                return 1;
            }
            int n2 = charSequence.charAt(n) - by;
            if (n2 == 0) continue;
            return n2;
        }
        return -byteSequence.charAt(n);
    }

    private int compareKeys(CharSequence charSequence, char c) {
        return ICUResourceBundleReader.compareKeys(charSequence, this.RES_GET_KEY16(c));
    }

    private int compareKeys32(CharSequence charSequence, int n) {
        return ICUResourceBundleReader.compareKeys(charSequence, this.RES_GET_KEY32(n));
    }

    String getString(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        if (ICUResourceBundleReader.RES_GET_TYPE(n) == 6) {
            int n3;
            char c = this.s16BitUnits.charAt(n2);
            if ((c & 0xFFFFFC00) != 56320) {
                if (c == '\u0000') {
                    return emptyString;
                }
                int n4 = n2 + 1;
                while (this.s16BitUnits.charAt(n4) != '\u0000') {
                    ++n4;
                }
                return this.s16BitUnits.substring(n2, n4);
            }
            if (c < '\udfef') {
                n3 = c & 0x3FF;
                ++n2;
            } else if (c < '\udfff') {
                n3 = c - 57327 << 16 | this.s16BitUnits.charAt(n2 + 1);
                n2 += 2;
            } else {
                n3 = this.s16BitUnits.charAt(n2 + 1) << 16 | this.s16BitUnits.charAt(n2 + 2);
                n2 += 3;
            }
            return this.s16BitUnits.substring(n2, n2 + n3);
        }
        if (n == n2) {
            if (n == 0) {
                return emptyString;
            }
            n2 = this.getResourceByteOffset(n2);
            int n5 = this.getInt(n2);
            return new String(this.getChars(n2 + 4, n5));
        }
        return null;
    }

    String getAlias(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        if (ICUResourceBundleReader.RES_GET_TYPE(n) == 3) {
            if (n2 == 0) {
                return emptyString;
            }
            n2 = this.getResourceByteOffset(n2);
            int n3 = this.getInt(n2);
            return new String(this.getChars(n2 + 4, n3));
        }
        return null;
    }

    byte[] getBinary(int n, byte[] byArray) {
        int n2 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        if (ICUResourceBundleReader.RES_GET_TYPE(n) == 1) {
            if (n2 == 0) {
                return emptyBytes;
            }
            n2 = this.getResourceByteOffset(n2);
            int n3 = this.getInt(n2);
            if (byArray == null || byArray.length != n3) {
                byArray = new byte[n3];
            }
            System.arraycopy(this.resourceBytes, n2 + 4, byArray, 0, n3);
            return byArray;
        }
        return null;
    }

    ByteBuffer getBinary(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        if (ICUResourceBundleReader.RES_GET_TYPE(n) == 1) {
            if (n2 == 0) {
                return emptyByteBuffer.duplicate();
            }
            n2 = this.getResourceByteOffset(n2);
            int n3 = this.getInt(n2);
            return ByteBuffer.wrap(this.resourceBytes, n2 + 4, n3).slice().asReadOnlyBuffer();
        }
        return null;
    }

    int[] getIntVector(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        if (ICUResourceBundleReader.RES_GET_TYPE(n) == 14) {
            if (n2 == 0) {
                return emptyInts;
            }
            n2 = this.getResourceByteOffset(n2);
            int n3 = this.getInt(n2);
            return this.getInts(n2 + 4, n3);
        }
        return null;
    }

    Container getArray(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_TYPE(n);
        int n3 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        switch (n2) {
            case 8: 
            case 9: {
                if (n3 != 0) break;
                return new Container(this);
            }
            default: {
                return null;
            }
        }
        switch (n2) {
            case 8: {
                return new Array(this, n3);
            }
            case 9: {
                return new Array16(this, n3);
            }
        }
        return null;
    }

    Table getTable(int n) {
        int n2 = ICUResourceBundleReader.RES_GET_TYPE(n);
        int n3 = ICUResourceBundleReader.RES_GET_OFFSET(n);
        switch (n2) {
            case 2: 
            case 4: 
            case 5: {
                if (n3 != 0) break;
                return new Table(this);
            }
            default: {
                return null;
            }
        }
        switch (n2) {
            case 2: {
                return new Table1632(this, n3);
            }
            case 5: {
                return new Table16(this, n3);
            }
            case 4: {
                return new Table32(this, n3);
            }
        }
        return null;
    }

    public static String getFullName(String string, String string2) {
        if (string == null || string.length() == 0) {
            if (string2.length() == 0) {
                string2 = ULocale.getDefault().toString();
                return string2;
            }
            return string2 + ICU_RESOURCE_SUFFIX;
        }
        if (string.indexOf(46) == -1) {
            if (string.charAt(string.length() - 1) != '/') {
                return string + "/" + string2 + ICU_RESOURCE_SUFFIX;
            }
            return string + string2 + ICU_RESOURCE_SUFFIX;
        }
        string = string.replace('.', '/');
        if (string2.length() == 0) {
            return string + ICU_RESOURCE_SUFFIX;
        }
        return string + "_" + string2 + ICU_RESOURCE_SUFFIX;
    }

    private static final class Table32
    extends Table {
        int getContainerResource(int n) {
            return this.getContainer32Resource(n);
        }

        Table32(ICUResourceBundleReader iCUResourceBundleReader, int n) {
            super(iCUResourceBundleReader);
            n = iCUResourceBundleReader.getResourceByteOffset(n);
            this.key32Offsets = iCUResourceBundleReader.getTable32KeyOffsets(n);
            this.size = this.key32Offsets.length;
            this.itemsOffset = n + 4 * (1 + this.size);
        }
    }

    private static final class Table16
    extends Table {
        int getContainerResource(int n) {
            return this.getContainer16Resource(n);
        }

        Table16(ICUResourceBundleReader iCUResourceBundleReader, int n) {
            super(iCUResourceBundleReader);
            this.keyOffsets = iCUResourceBundleReader.getTable16KeyOffsets(n);
            this.size = this.keyOffsets.length;
            this.itemsOffset = n + 1 + this.size;
        }
    }

    private static final class Table1632
    extends Table {
        int getContainerResource(int n) {
            return this.getContainer32Resource(n);
        }

        Table1632(ICUResourceBundleReader iCUResourceBundleReader, int n) {
            super(iCUResourceBundleReader);
            n = iCUResourceBundleReader.getResourceByteOffset(n);
            this.keyOffsets = iCUResourceBundleReader.getTableKeyOffsets(n);
            this.size = this.keyOffsets.length;
            this.itemsOffset = n + 2 * (this.size + 2 & 0xFFFFFFFE);
        }
    }

    public static class Table
    extends Container {
        protected char[] keyOffsets;
        protected int[] key32Offsets;
        private static final int URESDATA_ITEM_NOT_FOUND = -1;

        String getKey(int n) {
            if (n < 0 || this.size <= n) {
                return null;
            }
            return this.keyOffsets != null ? this.reader.getKey16String(this.keyOffsets[n]) : this.reader.getKey32String(this.key32Offsets[n]);
        }

        int findTableItem(CharSequence charSequence) {
            int n = 0;
            int n2 = this.size;
            while (n < n2) {
                int n3 = n + n2 >>> 1;
                int n4 = this.keyOffsets != null ? this.reader.compareKeys(charSequence, this.keyOffsets[n3]) : this.reader.compareKeys32(charSequence, this.key32Offsets[n3]);
                if (n4 < 0) {
                    n2 = n3;
                    continue;
                }
                if (n4 > 0) {
                    n = n3 + 1;
                    continue;
                }
                return n3;
            }
            return -1;
        }

        int getTableResource(String string) {
            return this.getContainerResource(this.findTableItem(string));
        }

        Table(ICUResourceBundleReader iCUResourceBundleReader) {
            super(iCUResourceBundleReader);
        }
    }

    private static final class Array16
    extends Container {
        int getContainerResource(int n) {
            return this.getContainer16Resource(n);
        }

        Array16(ICUResourceBundleReader iCUResourceBundleReader, int n) {
            super(iCUResourceBundleReader);
            this.size = iCUResourceBundleReader.s16BitUnits.charAt(n);
            this.itemsOffset = n + 1;
        }
    }

    private static final class Array
    extends Container {
        int getContainerResource(int n) {
            return this.getContainer32Resource(n);
        }

        Array(ICUResourceBundleReader iCUResourceBundleReader, int n) {
            super(iCUResourceBundleReader);
            n = iCUResourceBundleReader.getResourceByteOffset(n);
            this.size = iCUResourceBundleReader.getInt(n);
            this.itemsOffset = n + 4;
        }
    }

    public static class Container {
        protected ICUResourceBundleReader reader;
        protected int size;
        protected int itemsOffset;

        int getSize() {
            return this.size;
        }

        int getContainerResource(int n) {
            return -1;
        }

        protected int getContainer16Resource(int n) {
            if (n < 0 || this.size <= n) {
                return -1;
            }
            return 0x60000000 | this.reader.s16BitUnits.charAt(this.itemsOffset + n);
        }

        protected int getContainer32Resource(int n) {
            if (n < 0 || this.size <= n) {
                return -1;
            }
            return this.reader.getInt(this.itemsOffset + 4 * n);
        }

        Container(ICUResourceBundleReader iCUResourceBundleReader) {
            this.reader = iCUResourceBundleReader;
        }
    }

    private static final class ByteSequence {
        private byte[] bytes;
        private int offset;

        public ByteSequence(byte[] byArray, int n) {
            this.bytes = byArray;
            this.offset = n;
        }

        public byte charAt(int n) {
            return this.bytes[this.offset + n];
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ReaderCache
    extends SoftCache<ReaderInfo, ICUResourceBundleReader, ReaderInfo> {
        private ReaderCache() {
        }

        @Override
        protected ICUResourceBundleReader createInstance(ReaderInfo readerInfo, ReaderInfo readerInfo2) {
            String string = ICUResourceBundleReader.getFullName(readerInfo2.baseName, readerInfo2.localeID);
            InputStream inputStream2 = ICUData.getStream(readerInfo2.loader, string);
            if (inputStream2 == null) {
                return NULL_READER;
            }
            return new ICUResourceBundleReader(inputStream2, readerInfo2.baseName, readerInfo2.localeID, readerInfo2.loader);
        }
    }

    private static class ReaderInfo {
        final String baseName;
        final String localeID;
        final ClassLoader loader;

        ReaderInfo(String string, String string2, ClassLoader classLoader) {
            this.baseName = string == null ? "" : string;
            this.localeID = string2 == null ? "" : string2;
            this.loader = classLoader;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof ReaderInfo)) {
                return false;
            }
            ReaderInfo readerInfo = (ReaderInfo)object;
            return this.baseName.equals(readerInfo.baseName) && this.localeID.equals(readerInfo.localeID) && this.loader.equals(readerInfo.loader);
        }

        public int hashCode() {
            return this.baseName.hashCode() ^ this.localeID.hashCode() ^ this.loader.hashCode();
        }
    }
}

