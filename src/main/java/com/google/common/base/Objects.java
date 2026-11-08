/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public class Objects {
    private Objects() {
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object object, @Nullable Object object2) {
        return object == object2 || object != null && object.equals(object2);
    }

    public static int hashCode(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static ToStringHelper toStringHelper(Object object) {
        return new ToStringHelper(Objects.simpleName(object.getClass()));
    }

    public static ToStringHelper toStringHelper(Class<?> clazz) {
        return new ToStringHelper(Objects.simpleName(clazz));
    }

    public static ToStringHelper toStringHelper(String string) {
        return new ToStringHelper(string);
    }

    private static String simpleName(Class<?> clazz) {
        String string = clazz.getName();
        int n = (string = string.replaceAll("\\$[0-9]+", "\\$")).lastIndexOf(36);
        if (n == -1) {
            n = string.lastIndexOf(46);
        }
        return string.substring(n + 1);
    }

    public static <T> T firstNonNull(@Nullable T t, @Nullable T t2) {
        return t != null ? t : Preconditions.checkNotNull(t2);
    }

    public static final class ToStringHelper {
        private final String className;
        private ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(String string) {
            this.holderTail = this.holderHead = new ValueHolder();
            this.omitNullValues = false;
            this.className = Preconditions.checkNotNull(string);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String string, @Nullable Object object) {
            return this.addHolder(string, object);
        }

        public ToStringHelper add(String string, boolean bl) {
            return this.addHolder(string, String.valueOf(bl));
        }

        public ToStringHelper add(String string, char c) {
            return this.addHolder(string, String.valueOf(c));
        }

        public ToStringHelper add(String string, double d) {
            return this.addHolder(string, String.valueOf(d));
        }

        public ToStringHelper add(String string, float f) {
            return this.addHolder(string, String.valueOf(f));
        }

        public ToStringHelper add(String string, int n) {
            return this.addHolder(string, String.valueOf(n));
        }

        public ToStringHelper add(String string, long l) {
            return this.addHolder(string, String.valueOf(l));
        }

        public ToStringHelper addValue(@Nullable Object object) {
            return this.addHolder(object);
        }

        public ToStringHelper addValue(boolean bl) {
            return this.addHolder(String.valueOf(bl));
        }

        public ToStringHelper addValue(char c) {
            return this.addHolder(String.valueOf(c));
        }

        public ToStringHelper addValue(double d) {
            return this.addHolder(String.valueOf(d));
        }

        public ToStringHelper addValue(float f) {
            return this.addHolder(String.valueOf(f));
        }

        public ToStringHelper addValue(int n) {
            return this.addHolder(String.valueOf(n));
        }

        public ToStringHelper addValue(long l) {
            return this.addHolder(String.valueOf(l));
        }

        public String toString() {
            boolean bl = this.omitNullValues;
            String string = "";
            StringBuilder stringBuilder = new StringBuilder(32).append(this.className).append('{');
            ValueHolder valueHolder = this.holderHead.next;
            while (valueHolder != null) {
                if (!bl || valueHolder.value != null) {
                    stringBuilder.append(string);
                    string = ", ";
                    if (valueHolder.name != null) {
                        stringBuilder.append(valueHolder.name).append('=');
                    }
                    stringBuilder.append(valueHolder.value);
                }
                valueHolder = valueHolder.next;
            }
            return stringBuilder.append('}').toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder;
            this.holderTail = this.holderTail.next = (valueHolder = new ValueHolder());
            return valueHolder;
        }

        private ToStringHelper addHolder(@Nullable Object object) {
            ValueHolder valueHolder = this.addHolder();
            valueHolder.value = object;
            return this;
        }

        private ToStringHelper addHolder(String string, @Nullable Object object) {
            ValueHolder valueHolder = this.addHolder();
            valueHolder.value = object;
            valueHolder.name = Preconditions.checkNotNull(string);
            return this;
        }

        private static final class ValueHolder {
            String name;
            Object value;
            ValueHolder next;

            private ValueHolder() {
            }
        }
    }
}

