/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.util.BytesTrie;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;

public class UPropertyAliases {
    private static final int IX_VALUE_MAPS_OFFSET = 0;
    private static final int IX_BYTE_TRIES_OFFSET = 1;
    private static final int IX_NAME_GROUPS_OFFSET = 2;
    private static final int IX_RESERVED3_OFFSET = 3;
    private int[] valueMaps;
    private byte[] bytesTries;
    private String nameGroups;
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    private static final byte[] DATA_FORMAT = new byte[]{112, 110, 97, 109};
    public static final UPropertyAliases INSTANCE;

    private void load(InputStream inputStream2) throws IOException {
        int n;
        int n2;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
        ICUBinary.readHeader(bufferedInputStream, DATA_FORMAT, IS_ACCEPTABLE);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        int n3 = dataInputStream.readInt() / 4;
        if (n3 < 8) {
            throw new IOException("pnames.icu: not enough indexes");
        }
        int[] nArray = new int[n3];
        nArray[0] = n3 * 4;
        for (n2 = 1; n2 < n3; ++n2) {
            nArray[n2] = dataInputStream.readInt();
        }
        n2 = nArray[0];
        int n4 = nArray[1];
        int n5 = (n4 - n2) / 4;
        this.valueMaps = new int[n5];
        for (n = 0; n < n5; ++n) {
            this.valueMaps[n] = dataInputStream.readInt();
        }
        n2 = n4;
        n4 = nArray[2];
        n = n4 - n2;
        this.bytesTries = new byte[n];
        dataInputStream.readFully(this.bytesTries);
        n2 = n4;
        n4 = nArray[3];
        n = n4 - n2;
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append((char)dataInputStream.readByte());
        }
        this.nameGroups = stringBuilder.toString();
        inputStream2.close();
    }

    private UPropertyAliases() throws IOException {
        this.load(ICUData.getRequiredStream("data/icudt51b/pnames.icu"));
    }

    private int findProperty(int n) {
        int n2 = 1;
        for (int i = this.valueMaps[0]; i > 0; --i) {
            int n3 = this.valueMaps[n2];
            int n4 = this.valueMaps[n2 + 1];
            n2 += 2;
            if (n < n3) break;
            if (n < n4) {
                return n2 + (n - n3) * 2;
            }
            n2 += (n4 - n3) * 2;
        }
        return 0;
    }

    private int findPropertyValueNameGroup(int n, int n2) {
        if (n == 0) {
            return 0;
        }
        int n3 = ++n;
        ++n;
        int n4 = this.valueMaps[n3];
        if (n4 < 16) {
            while (n4 > 0) {
                int n5 = this.valueMaps[n];
                int n6 = this.valueMaps[n + 1];
                n += 2;
                if (n2 >= n5) {
                    if (n2 < n6) {
                        return this.valueMaps[n + n2 - n5];
                    }
                    n += n6 - n5;
                    --n4;
                    continue;
                }
                break;
            }
        } else {
            int n7;
            int n8 = n;
            int n9 = n + n4 - 16;
            while (n2 >= (n7 = this.valueMaps[n])) {
                if (n2 == n7) {
                    return this.valueMaps[n9 + n - n8];
                }
                if (++n < n9) continue;
            }
        }
        return 0;
    }

    private String getName(int n, int n2) {
        char c = this.nameGroups.charAt(n++);
        if (n2 < 0 || c <= n2) {
            throw new IllegalIcuArgumentException("Invalid property (value) name choice");
        }
        while (n2 > 0) {
            while ('\u0000' != this.nameGroups.charAt(n++)) {
            }
            --n2;
        }
        int n3 = n;
        while ('\u0000' != this.nameGroups.charAt(n)) {
            ++n;
        }
        if (n3 == n) {
            return null;
        }
        return this.nameGroups.substring(n3, n);
    }

    private static int asciiToLowercase(int n) {
        return 65 <= n && n <= 90 ? n + 32 : n;
    }

    private boolean containsName(BytesTrie bytesTrie, CharSequence charSequence) {
        BytesTrie.Result result = BytesTrie.Result.NO_VALUE;
        for (int i = 0; i < charSequence.length(); ++i) {
            int n = charSequence.charAt(i);
            if (n == 45 || n == 95 || n == 32 || 9 <= n && n <= 13) continue;
            if (!result.hasNext()) {
                return false;
            }
            n = UPropertyAliases.asciiToLowercase(n);
            result = bytesTrie.next(n);
        }
        return result.hasValue();
    }

    public String getPropertyName(int n, int n2) {
        int n3 = this.findProperty(n);
        if (n3 == 0) {
            throw new IllegalArgumentException("Invalid property enum " + n + " (0x" + Integer.toHexString(n) + ")");
        }
        return this.getName(this.valueMaps[n3], n2);
    }

    public String getPropertyValueName(int n, int n2, int n3) {
        int n4 = this.findProperty(n);
        if (n4 == 0) {
            throw new IllegalArgumentException("Invalid property enum " + n + " (0x" + Integer.toHexString(n) + ")");
        }
        int n5 = this.findPropertyValueNameGroup(this.valueMaps[n4 + 1], n2);
        if (n5 == 0) {
            throw new IllegalArgumentException("Property " + n + " (0x" + Integer.toHexString(n) + ") does not have named values");
        }
        return this.getName(n5, n3);
    }

    private int getPropertyOrValueEnum(int n, CharSequence charSequence) {
        BytesTrie bytesTrie = new BytesTrie(this.bytesTries, n);
        if (this.containsName(bytesTrie, charSequence)) {
            return bytesTrie.getValue();
        }
        return -1;
    }

    public int getPropertyEnum(CharSequence charSequence) {
        return this.getPropertyOrValueEnum(0, charSequence);
    }

    public int getPropertyValueEnum(int n, CharSequence charSequence) {
        int n2 = this.findProperty(n);
        if (n2 == 0) {
            throw new IllegalArgumentException("Invalid property enum " + n + " (0x" + Integer.toHexString(n) + ")");
        }
        if ((n2 = this.valueMaps[n2 + 1]) == 0) {
            throw new IllegalArgumentException("Property " + n + " (0x" + Integer.toHexString(n) + ") does not have named values");
        }
        return this.getPropertyOrValueEnum(this.valueMaps[n2], charSequence);
    }

    public static int compare(String string, String string2) {
        int n = 0;
        int n2 = 0;
        char c = '\u0000';
        char c2 = '\u0000';
        block6: while (true) {
            boolean bl;
            if (n < string.length()) {
                c = string.charAt(n);
                switch (c) {
                    case '\t': 
                    case '\n': 
                    case '\u000b': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case '-': 
                    case '_': {
                        ++n;
                        continue block6;
                    }
                }
            }
            block7: while (n2 < string2.length()) {
                c2 = string2.charAt(n2);
                switch (c2) {
                    case '\t': 
                    case '\n': 
                    case '\u000b': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case '-': 
                    case '_': {
                        ++n2;
                        continue block7;
                    }
                }
            }
            boolean bl2 = n == string.length();
            boolean bl3 = bl = n2 == string2.length();
            if (bl2) {
                if (bl) {
                    return 0;
                }
                c = '\u0000';
            } else if (bl) {
                c2 = '\u0000';
            }
            int n3 = UPropertyAliases.asciiToLowercase(c) - UPropertyAliases.asciiToLowercase(c2);
            if (n3 != 0) {
                return n3;
            }
            ++n;
            ++n2;
        }
    }

    static {
        try {
            INSTANCE = new UPropertyAliases();
        }
        catch (IOException iOException) {
            MissingResourceException missingResourceException = new MissingResourceException("Could not construct UPropertyAliases. Missing pnames.icu", "", "");
            missingResourceException.initCause(iOException);
            throw missingResourceException;
        }
    }

    private static final class IsAcceptable
    implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        public boolean isDataVersionAcceptable(byte[] byArray) {
            return byArray[0] == 2;
        }
    }
}

