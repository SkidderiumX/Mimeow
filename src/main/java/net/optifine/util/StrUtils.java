/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StrUtils {
    public static boolean equalsMask(String string, String string2, char c, char c2) {
        if (string2 != null && string != null) {
            String string3;
            if (string2.indexOf(c) < 0) {
                return string2.indexOf(c2) < 0 ? string2.equals(string) : StrUtils.equalsMaskSingle(string, string2, c2);
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            String string4 = "" + c;
            if (string2.startsWith(string4)) {
                arrayList.add("");
            }
            StringTokenizer stringTokenizer = new StringTokenizer(string2, string4);
            while (stringTokenizer.hasMoreElements()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            if (string2.endsWith(string4)) {
                arrayList.add("");
            }
            if (!StrUtils.startsWithMaskSingle(string, string3 = (String)arrayList.get(0), c2)) {
                return false;
            }
            String string5 = (String)arrayList.get(arrayList.size() - 1);
            if (!StrUtils.endsWithMaskSingle(string, string5, c2)) {
                return false;
            }
            int n = 0;
            for (int i = 0; i < arrayList.size(); ++i) {
                String string6 = (String)arrayList.get(i);
                if (string6.length() <= 0) continue;
                int n2 = StrUtils.indexOfMaskSingle(string, string6, n, c2);
                if (n2 < 0) {
                    return false;
                }
                n = n2 + string6.length();
            }
            return true;
        }
        return string2 == string;
    }

    private static boolean equalsMaskSingle(String string, String string2, char c) {
        if (string != null && string2 != null) {
            if (string.length() != string2.length()) {
                return false;
            }
            for (int i = 0; i < string2.length(); ++i) {
                char c2 = string2.charAt(i);
                if (c2 == c || string.charAt(i) == c2) continue;
                return false;
            }
            return true;
        }
        return string == string2;
    }

    private static int indexOfMaskSingle(String string, String string2, int n, char c) {
        if (string != null && string2 != null) {
            if (n >= 0 && n <= string.length()) {
                if (string.length() < n + string2.length()) {
                    return -1;
                }
                int n2 = n;
                while (n2 + string2.length() <= string.length()) {
                    String string3 = string.substring(n2, n2 + string2.length());
                    if (StrUtils.equalsMaskSingle(string3, string2, c)) {
                        return n2;
                    }
                    ++n2;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    private static boolean endsWithMaskSingle(String string, String string2, char c) {
        if (string != null && string2 != null) {
            if (string.length() < string2.length()) {
                return false;
            }
            String string3 = string.substring(string.length() - string2.length(), string.length());
            return StrUtils.equalsMaskSingle(string3, string2, c);
        }
        return string == string2;
    }

    private static boolean startsWithMaskSingle(String string, String string2, char c) {
        if (string != null && string2 != null) {
            if (string.length() < string2.length()) {
                return false;
            }
            String string3 = string.substring(0, string2.length());
            return StrUtils.equalsMaskSingle(string3, string2, c);
        }
        return string == string2;
    }

    public static boolean equalsMask(String string, String[] stringArray, char c) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (!StrUtils.equalsMask(string, string2, c)) continue;
            return true;
        }
        return false;
    }

    public static boolean equalsMask(String string, String string2, char c) {
        if (string2 != null && string != null) {
            String string3;
            if (string2.indexOf(c) < 0) {
                return string2.equals(string);
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            String string4 = "" + c;
            if (string2.startsWith(string4)) {
                arrayList.add("");
            }
            StringTokenizer stringTokenizer = new StringTokenizer(string2, string4);
            while (stringTokenizer.hasMoreElements()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            if (string2.endsWith(string4)) {
                arrayList.add("");
            }
            if (!string.startsWith(string3 = (String)arrayList.get(0))) {
                return false;
            }
            String string5 = (String)arrayList.get(arrayList.size() - 1);
            if (!string.endsWith(string5)) {
                return false;
            }
            int n = 0;
            for (int i = 0; i < arrayList.size(); ++i) {
                String string6 = (String)arrayList.get(i);
                if (string6.length() <= 0) continue;
                int n2 = string.indexOf(string6, n);
                if (n2 < 0) {
                    return false;
                }
                n = n2 + string6.length();
            }
            return true;
        }
        return string2 == string;
    }

    public static String[] split(String string, String string2) {
        if (string != null && string.length() > 0) {
            if (string2 == null) {
                return new String[]{string};
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            int n = 0;
            for (int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                if (!StrUtils.equals(c, string2)) continue;
                arrayList.add(string.substring(n, i));
                n = i + 1;
            }
            arrayList.add(string.substring(n, string.length()));
            return arrayList.toArray(new String[arrayList.size()]);
        }
        return new String[0];
    }

    private static boolean equals(char c, String string) {
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) != c) continue;
            return true;
        }
        return false;
    }

    public static boolean equalsTrim(String string, String string2) {
        if (string != null) {
            string = string.trim();
        }
        if (string2 != null) {
            string2 = string2.trim();
        }
        return StrUtils.equals(string, (Object)string2);
    }

    public static boolean isEmpty(String string) {
        return string == null ? true : string.trim().length() <= 0;
    }

    public static String stringInc(String string) {
        String string2;
        int n = StrUtils.parseInt(string, -1);
        if (n == -1) {
            return "";
        }
        return (string2 = "" + ++n).length() > string.length() ? "" : StrUtils.fillLeft("" + n, string.length(), '0');
    }

    public static int parseInt(String string, int n) {
        if (string == null) {
            return n;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public static boolean isFilled(String string) {
        return !StrUtils.isEmpty(string);
    }

    public static String addIfNotContains(String object, String string) {
        for (int i = 0; i < string.length(); ++i) {
            if (((String)object).indexOf(string.charAt(i)) >= 0) continue;
            object = (String)object + string.charAt(i);
        }
        return object;
    }

    public static String fillLeft(String string, int n, char c) {
        if (string == null) {
            string = "";
        }
        if (string.length() >= n) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = n - string.length();
        while (stringBuffer.length() < n2) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString() + string;
    }

    public static String fillRight(String string, int n, char c) {
        if (string == null) {
            string = "";
        }
        if (string.length() >= n) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer(string);
        while (stringBuffer.length() < n) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static boolean equals(Object object, Object object2) {
        return object == object2 ? true : (object != null && object.equals(object2) ? true : object2 != null && object2.equals(object));
    }

    public static boolean startsWith(String string, String[] stringArray) {
        if (string == null) {
            return false;
        }
        if (stringArray == null) {
            return false;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (!string.startsWith(string2)) continue;
            return true;
        }
        return false;
    }

    public static boolean endsWith(String string, String[] stringArray) {
        if (string == null) {
            return false;
        }
        if (stringArray == null) {
            return false;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (!string.endsWith(string2)) continue;
            return true;
        }
        return false;
    }

    public static String removePrefix(String string, String string2) {
        if (string != null && string2 != null) {
            if (string.startsWith(string2)) {
                string = string.substring(string2.length());
            }
            return string;
        }
        return string;
    }

    public static String removeSuffix(String string, String string2) {
        if (string != null && string2 != null) {
            if (string.endsWith(string2)) {
                string = string.substring(0, string.length() - string2.length());
            }
            return string;
        }
        return string;
    }

    public static String replaceSuffix(String string, String string2, String string3) {
        if (string != null && string2 != null) {
            if (!string.endsWith(string2)) {
                return string;
            }
            if (string3 == null) {
                string3 = "";
            }
            string = string.substring(0, string.length() - string2.length());
            return string + string3;
        }
        return string;
    }

    public static String replacePrefix(String string, String string2, String string3) {
        if (string != null && string2 != null) {
            if (!string.startsWith(string2)) {
                return string;
            }
            if (string3 == null) {
                string3 = "";
            }
            string = string.substring(string2.length());
            return string3 + string;
        }
        return string;
    }

    public static int findPrefix(String[] stringArray, String string) {
        if (stringArray != null && string != null) {
            for (int i = 0; i < stringArray.length; ++i) {
                String string2 = stringArray[i];
                if (!string2.startsWith(string)) continue;
                return i;
            }
            return -1;
        }
        return -1;
    }

    public static int findSuffix(String[] stringArray, String string) {
        if (stringArray != null && string != null) {
            for (int i = 0; i < stringArray.length; ++i) {
                String string2 = stringArray[i];
                if (!string2.endsWith(string)) continue;
                return i;
            }
            return -1;
        }
        return -1;
    }

    public static String[] remove(String[] stringArray, int n, int n2) {
        if (stringArray == null) {
            return stringArray;
        }
        if (n2 > 0 && n < stringArray.length) {
            if (n >= n2) {
                return stringArray;
            }
            ArrayList<String> arrayList = new ArrayList<String>(stringArray.length);
            for (int i = 0; i < stringArray.length; ++i) {
                String string = stringArray[i];
                if (i >= n && i < n2) continue;
                arrayList.add(string);
            }
            String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
            return stringArray2;
        }
        return stringArray;
    }

    public static String removeSuffix(String string, String[] stringArray) {
        if (string != null && stringArray != null) {
            String string2;
            int n = string.length();
            for (int i = 0; i < stringArray.length && (string = StrUtils.removeSuffix(string, string2 = stringArray[i])).length() == n; ++i) {
            }
            return string;
        }
        return string;
    }

    public static String removePrefix(String string, String[] stringArray) {
        if (string != null && stringArray != null) {
            String string2;
            int n = string.length();
            for (int i = 0; i < stringArray.length && (string = StrUtils.removePrefix(string, string2 = stringArray[i])).length() == n; ++i) {
            }
            return string;
        }
        return string;
    }

    public static String removePrefixSuffix(String string, String[] stringArray, String[] stringArray2) {
        string = StrUtils.removePrefix(string, stringArray);
        string = StrUtils.removeSuffix(string, stringArray2);
        return string;
    }

    public static String removePrefixSuffix(String string, String string2, String string3) {
        return StrUtils.removePrefixSuffix(string, new String[]{string2}, new String[]{string3});
    }

    public static String getSegment(String string, String string2, String string3) {
        if (string != null && string2 != null && string3 != null) {
            int n = string.indexOf(string2);
            if (n < 0) {
                return null;
            }
            int n2 = string.indexOf(string3, n);
            return n2 < 0 ? null : string.substring(n, n2 + string3.length());
        }
        return null;
    }

    public static String addSuffixCheck(String string, String string2) {
        return string != null && string2 != null ? (string.endsWith(string2) ? string : string + string2) : string;
    }

    public static String addPrefixCheck(String string, String string2) {
        return string != null && string2 != null ? (string.endsWith(string2) ? string : string2 + string) : string;
    }

    public static String trim(String string, String string2) {
        if (string != null && string2 != null) {
            string = StrUtils.trimLeading(string, string2);
            string = StrUtils.trimTrailing(string, string2);
            return string;
        }
        return string;
    }

    public static String trimLeading(String string, String string2) {
        if (string != null && string2 != null) {
            int n = string.length();
            for (int i = 0; i < n; ++i) {
                char c = string.charAt(i);
                if (string2.indexOf(c) >= 0) continue;
                return string.substring(i);
            }
            return "";
        }
        return string;
    }

    public static String trimTrailing(String string, String string2) {
        if (string != null && string2 != null) {
            int n;
            char c;
            int n2;
            for (n2 = n = string.length(); n2 > 0 && string2.indexOf(c = string.charAt(n2 - 1)) >= 0; --n2) {
            }
            return n2 == n ? string : string.substring(0, n2);
        }
        return string;
    }
}

