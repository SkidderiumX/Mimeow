/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import java.util.Arrays;
import java.util.regex.Pattern;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.src.Config;
import net.optifine.util.StrUtils;
import org.apache.commons.lang3.StringEscapeUtils;

public class NbtTagValue {
    private String[] parents = null;
    private String name = null;
    private boolean negative = false;
    private int type = 0;
    private String value = null;
    private int valueFormat = 0;
    private static final int TYPE_TEXT = 0;
    private static final int TYPE_PATTERN = 1;
    private static final int TYPE_IPATTERN = 2;
    private static final int TYPE_REGEX = 3;
    private static final int TYPE_IREGEX = 4;
    private static final String PREFIX_PATTERN = "pattern:";
    private static final String PREFIX_IPATTERN = "ipattern:";
    private static final String PREFIX_REGEX = "regex:";
    private static final String PREFIX_IREGEX = "iregex:";
    private static final int FORMAT_DEFAULT = 0;
    private static final int FORMAT_HEX_COLOR = 1;
    private static final String PREFIX_HEX_COLOR = "#";
    private static final Pattern PATTERN_HEX_COLOR = Pattern.compile("^#[0-9a-f]{6}+$");

    public NbtTagValue(String string, String string2) {
        String[] stringArray = Config.tokenize(string, ".");
        this.parents = Arrays.copyOfRange(stringArray, 0, stringArray.length - 1);
        this.name = stringArray[stringArray.length - 1];
        if (string2.startsWith("!")) {
            this.negative = true;
            string2 = string2.substring(1);
        }
        if (string2.startsWith(PREFIX_PATTERN)) {
            this.type = 1;
            string2 = string2.substring(PREFIX_PATTERN.length());
        } else if (string2.startsWith(PREFIX_IPATTERN)) {
            this.type = 2;
            string2 = string2.substring(PREFIX_IPATTERN.length()).toLowerCase();
        } else if (string2.startsWith(PREFIX_REGEX)) {
            this.type = 3;
            string2 = string2.substring(PREFIX_REGEX.length());
        } else if (string2.startsWith(PREFIX_IREGEX)) {
            this.type = 4;
            string2 = string2.substring(PREFIX_IREGEX.length()).toLowerCase();
        } else {
            this.type = 0;
        }
        string2 = StringEscapeUtils.unescapeJava(string2);
        if (this.type == 0 && PATTERN_HEX_COLOR.matcher(string2).matches()) {
            this.valueFormat = 1;
        }
        this.value = string2;
    }

    public boolean matches(NBTTagCompound nBTTagCompound) {
        return this.negative ? !this.matchesCompound(nBTTagCompound) : this.matchesCompound(nBTTagCompound);
    }

    public boolean matchesCompound(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return false;
        }
        NBTBase nBTBase = nBTTagCompound;
        for (int i = 0; i < this.parents.length; ++i) {
            String string = this.parents[i];
            if ((nBTBase = NbtTagValue.getChildTag(nBTBase, string)) != null) continue;
            return false;
        }
        if (this.name.equals("*")) {
            return this.matchesAnyChild(nBTBase);
        }
        if ((nBTBase = NbtTagValue.getChildTag(nBTBase, this.name)) == null) {
            return false;
        }
        return this.matchesBase(nBTBase);
    }

    private boolean matchesAnyChild(NBTBase nBTBase) {
        NBTBase nBTBase2;
        NBTBase nBTBase3;
        if (nBTBase instanceof NBTTagCompound) {
            nBTBase3 = (NBTTagCompound)nBTBase;
            for (String string : ((NBTTagCompound)nBTBase3).getKeySet()) {
                nBTBase2 = ((NBTTagCompound)nBTBase3).getTag(string);
                if (!this.matchesBase(nBTBase2)) continue;
                return true;
            }
        }
        if (nBTBase instanceof NBTTagList) {
            nBTBase3 = (NBTTagList)nBTBase;
            int n = ((NBTTagList)nBTBase3).tagCount();
            for (int i = 0; i < n; ++i) {
                nBTBase2 = ((NBTTagList)nBTBase3).get(i);
                if (!this.matchesBase(nBTBase2)) continue;
                return true;
            }
        }
        return false;
    }

    private static NBTBase getChildTag(NBTBase nBTBase, String string) {
        if (nBTBase instanceof NBTTagCompound) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTBase;
            return nBTTagCompound.getTag(string);
        }
        if (nBTBase instanceof NBTTagList) {
            NBTTagList nBTTagList = (NBTTagList)nBTBase;
            if (string.equals("count")) {
                return new NBTTagInt(nBTTagList.tagCount());
            }
            int n = Config.parseInt(string, -1);
            return n >= 0 && n < nBTTagList.tagCount() ? nBTTagList.get(n) : null;
        }
        return null;
    }

    public boolean matchesBase(NBTBase nBTBase) {
        if (nBTBase == null) {
            return false;
        }
        String string = NbtTagValue.getNbtString(nBTBase, this.valueFormat);
        return this.matchesValue(string);
    }

    public boolean matchesValue(String string) {
        if (string == null) {
            return false;
        }
        switch (this.type) {
            case 0: {
                return string.equals(this.value);
            }
            case 1: {
                return this.matchesPattern(string, this.value);
            }
            case 2: {
                return this.matchesPattern(string.toLowerCase(), this.value);
            }
            case 3: {
                return this.matchesRegex(string, this.value);
            }
            case 4: {
                return this.matchesRegex(string.toLowerCase(), this.value);
            }
        }
        throw new IllegalArgumentException("Unknown NbtTagValue type: " + this.type);
    }

    private boolean matchesPattern(String string, String string2) {
        return StrUtils.equalsMask(string, string2, '*', '?');
    }

    private boolean matchesRegex(String string, String string2) {
        return string.matches(string2);
    }

    private static String getNbtString(NBTBase nBTBase, int n) {
        if (nBTBase == null) {
            return null;
        }
        if (nBTBase instanceof NBTTagString) {
            NBTTagString nBTTagString = (NBTTagString)nBTBase;
            return nBTTagString.getString();
        }
        if (nBTBase instanceof NBTTagInt) {
            NBTTagInt nBTTagInt = (NBTTagInt)nBTBase;
            return n == 1 ? PREFIX_HEX_COLOR + StrUtils.fillLeft(Integer.toHexString(nBTTagInt.getInt()), 6, '0') : Integer.toString(nBTTagInt.getInt());
        }
        if (nBTBase instanceof NBTTagByte) {
            NBTTagByte nBTTagByte = (NBTTagByte)nBTBase;
            return Byte.toString(nBTTagByte.getByte());
        }
        if (nBTBase instanceof NBTTagShort) {
            NBTTagShort nBTTagShort = (NBTTagShort)nBTBase;
            return Short.toString(nBTTagShort.getShort());
        }
        if (nBTBase instanceof NBTTagLong) {
            NBTTagLong nBTTagLong = (NBTTagLong)nBTBase;
            return Long.toString(nBTTagLong.getLong());
        }
        if (nBTBase instanceof NBTTagFloat) {
            NBTTagFloat nBTTagFloat = (NBTTagFloat)nBTBase;
            return Float.toString(nBTTagFloat.getFloat());
        }
        if (nBTBase instanceof NBTTagDouble) {
            NBTTagDouble nBTTagDouble = (NBTTagDouble)nBTBase;
            return Double.toString(nBTTagDouble.getDouble());
        }
        return nBTBase.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.parents.length; ++i) {
            String string = this.parents[i];
            if (i > 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(string);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append(".");
        }
        stringBuffer.append(this.name);
        stringBuffer.append(" = ");
        stringBuffer.append(this.value);
        return stringBuffer.toString();
    }
}

