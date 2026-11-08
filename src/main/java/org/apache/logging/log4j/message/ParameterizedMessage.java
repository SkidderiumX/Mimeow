/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.message;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.Message;

public class ParameterizedMessage
implements Message {
    public static final String RECURSION_PREFIX = "[...";
    public static final String RECURSION_SUFFIX = "...]";
    public static final String ERROR_PREFIX = "[!!!";
    public static final String ERROR_SEPARATOR = "=>";
    public static final String ERROR_MSG_SEPARATOR = ":";
    public static final String ERROR_SUFFIX = "!!!]";
    private static final long serialVersionUID = -665975803997290697L;
    private static final int HASHVAL = 31;
    private static final char DELIM_START = '{';
    private static final char DELIM_STOP = '}';
    private static final char ESCAPE_CHAR = '\\';
    private final String messagePattern;
    private final String[] stringArgs;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private transient Throwable throwable;

    public ParameterizedMessage(String string, String[] stringArray, Throwable throwable) {
        this.messagePattern = string;
        this.stringArgs = stringArray;
        this.throwable = throwable;
    }

    public ParameterizedMessage(String string, Object[] objectArray, Throwable throwable) {
        this.messagePattern = string;
        this.throwable = throwable;
        this.stringArgs = this.parseArguments(objectArray);
    }

    public ParameterizedMessage(String string, Object[] objectArray) {
        this.messagePattern = string;
        this.stringArgs = this.parseArguments(objectArray);
    }

    public ParameterizedMessage(String string, Object object) {
        this(string, new Object[]{object});
    }

    public ParameterizedMessage(String string, Object object, Object object2) {
        this(string, new Object[]{object, object2});
    }

    private String[] parseArguments(Object[] objectArray) {
        String[] stringArray;
        if (objectArray == null) {
            return null;
        }
        int n = ParameterizedMessage.countArgumentPlaceholders(this.messagePattern);
        int n2 = objectArray.length;
        if (n < objectArray.length && this.throwable == null && objectArray[objectArray.length - 1] instanceof Throwable) {
            this.throwable = (Throwable)objectArray[objectArray.length - 1];
            --n2;
        }
        this.argArray = new Object[n2];
        for (int i = 0; i < n2; ++i) {
            this.argArray[i] = objectArray[i];
        }
        if (n == 1 && this.throwable == null && objectArray.length > 1) {
            stringArray = new String[]{ParameterizedMessage.deepToString(objectArray)};
        } else {
            stringArray = new String[n2];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = ParameterizedMessage.deepToString(objectArray[i]);
            }
        }
        return stringArray;
    }

    @Override
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            this.formattedMessage = this.formatMessage(this.messagePattern, this.stringArgs);
        }
        return this.formattedMessage;
    }

    @Override
    public String getFormat() {
        return this.messagePattern;
    }

    @Override
    public Object[] getParameters() {
        if (this.argArray != null) {
            return this.argArray;
        }
        return this.stringArgs;
    }

    @Override
    public Throwable getThrowable() {
        return this.throwable;
    }

    protected String formatMessage(String string, String[] stringArray) {
        return ParameterizedMessage.format(string, stringArray);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ParameterizedMessage parameterizedMessage = (ParameterizedMessage)object;
        if (this.messagePattern != null ? !this.messagePattern.equals(parameterizedMessage.messagePattern) : parameterizedMessage.messagePattern != null) {
            return false;
        }
        return Arrays.equals(this.stringArgs, parameterizedMessage.stringArgs);
    }

    public int hashCode() {
        int n = this.messagePattern != null ? this.messagePattern.hashCode() : 0;
        n = 31 * n + (this.stringArgs != null ? Arrays.hashCode(this.stringArgs) : 0);
        return n;
    }

    public static String format(String string, Object[] objectArray) {
        if (string == null || objectArray == null || objectArray.length == 0) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < string.length(); ++i) {
            int n3;
            char c = string.charAt(i);
            if (c == '\\') {
                ++n;
                continue;
            }
            if (c == '{' && i < string.length() - 1 && string.charAt(i + 1) == '}') {
                n3 = n / 2;
                for (int j = 0; j < n3; ++j) {
                    stringBuilder.append('\\');
                }
                if (n % 2 == 1) {
                    stringBuilder.append('{');
                    stringBuilder.append('}');
                } else {
                    if (n2 < objectArray.length) {
                        stringBuilder.append(objectArray[n2]);
                    } else {
                        stringBuilder.append('{').append('}');
                    }
                    ++n2;
                }
                ++i;
                n = 0;
                continue;
            }
            if (n > 0) {
                for (n3 = 0; n3 < n; ++n3) {
                    stringBuilder.append('\\');
                }
                n = 0;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static int countArgumentPlaceholders(String string) {
        if (string == null) {
            return 0;
        }
        int n = string.indexOf(123);
        if (n == -1) {
            return 0;
        }
        int n2 = 0;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\\') {
                bl = !bl;
                continue;
            }
            if (c == '{') {
                if (!bl && i < string.length() - 1 && string.charAt(i + 1) == '}') {
                    ++n2;
                    ++i;
                }
                bl = false;
                continue;
            }
            bl = false;
        }
        return n2;
    }

    public static String deepToString(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof String) {
            return (String)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<String> hashSet = new HashSet<String>();
        ParameterizedMessage.recursiveDeepToString(object, stringBuilder, hashSet);
        return stringBuilder.toString();
    }

    private static void recursiveDeepToString(Object object, StringBuilder stringBuilder, Set<String> set) {
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        if (object instanceof String) {
            stringBuilder.append(object);
            return;
        }
        Class<?> clazz = object.getClass();
        if (clazz.isArray()) {
            if (clazz == byte[].class) {
                stringBuilder.append(Arrays.toString((byte[])object));
            } else if (clazz == short[].class) {
                stringBuilder.append(Arrays.toString((short[])object));
            } else if (clazz == int[].class) {
                stringBuilder.append(Arrays.toString((int[])object));
            } else if (clazz == long[].class) {
                stringBuilder.append(Arrays.toString((long[])object));
            } else if (clazz == float[].class) {
                stringBuilder.append(Arrays.toString((float[])object));
            } else if (clazz == double[].class) {
                stringBuilder.append(Arrays.toString((double[])object));
            } else if (clazz == boolean[].class) {
                stringBuilder.append(Arrays.toString((boolean[])object));
            } else if (clazz == char[].class) {
                stringBuilder.append(Arrays.toString((char[])object));
            } else {
                String string = ParameterizedMessage.identityToString(object);
                if (set.contains(string)) {
                    stringBuilder.append(RECURSION_PREFIX).append(string).append(RECURSION_SUFFIX);
                } else {
                    set.add(string);
                    Object[] objectArray = (Object[])object;
                    stringBuilder.append("[");
                    boolean bl = true;
                    for (Object object2 : objectArray) {
                        if (bl) {
                            bl = false;
                        } else {
                            stringBuilder.append(", ");
                        }
                        ParameterizedMessage.recursiveDeepToString(object2, stringBuilder, new HashSet<String>(set));
                    }
                    stringBuilder.append("]");
                }
            }
        } else if (object instanceof Map) {
            String string = ParameterizedMessage.identityToString(object);
            if (set.contains(string)) {
                stringBuilder.append(RECURSION_PREFIX).append(string).append(RECURSION_SUFFIX);
            } else {
                set.add(string);
                Map map = (Map)object;
                stringBuilder.append("{");
                boolean bl = true;
                Iterator iterator2 = map.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry;
                    Map.Entry entry2 = entry = iterator2.next();
                    if (bl) {
                        bl = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    Object k = entry2.getKey();
                    Object v = entry2.getValue();
                    ParameterizedMessage.recursiveDeepToString(k, stringBuilder, new HashSet<String>(set));
                    stringBuilder.append("=");
                    ParameterizedMessage.recursiveDeepToString(v, stringBuilder, new HashSet<String>(set));
                }
                stringBuilder.append("}");
            }
        } else if (object instanceof Collection) {
            String string = ParameterizedMessage.identityToString(object);
            if (set.contains(string)) {
                stringBuilder.append(RECURSION_PREFIX).append(string).append(RECURSION_SUFFIX);
            } else {
                set.add(string);
                Collection collection = (Collection)object;
                stringBuilder.append("[");
                boolean bl = true;
                for (Object e : collection) {
                    if (bl) {
                        bl = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    ParameterizedMessage.recursiveDeepToString(e, stringBuilder, new HashSet<String>(set));
                }
                stringBuilder.append("]");
            }
        } else if (object instanceof Date) {
            Date date = (Date)object;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            stringBuilder.append(simpleDateFormat.format(date));
        } else {
            try {
                stringBuilder.append(object.toString());
            }
            catch (Throwable throwable) {
                stringBuilder.append(ERROR_PREFIX);
                stringBuilder.append(ParameterizedMessage.identityToString(object));
                stringBuilder.append(ERROR_SEPARATOR);
                String string = throwable.getMessage();
                String string2 = throwable.getClass().getName();
                stringBuilder.append(string2);
                if (!string2.equals(string)) {
                    stringBuilder.append(ERROR_MSG_SEPARATOR);
                    stringBuilder.append(string);
                }
                stringBuilder.append(ERROR_SUFFIX);
            }
        }
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object));
    }

    public String toString() {
        return "ParameterizedMessage[messagePattern=" + this.messagePattern + ", stringArgs=" + Arrays.toString(this.stringArgs) + ", throwable=" + this.throwable + "]";
    }
}

