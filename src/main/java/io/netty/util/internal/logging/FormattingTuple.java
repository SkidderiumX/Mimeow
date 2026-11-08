/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal.logging;

public class FormattingTuple {
    static final FormattingTuple NULL = new FormattingTuple(null);
    private final String message;
    private final Throwable throwable;
    private final Object[] argArray;

    FormattingTuple(String string) {
        this(string, null, null);
    }

    FormattingTuple(String string, Object[] objectArray, Throwable throwable) {
        this.message = string;
        this.throwable = throwable;
        this.argArray = throwable == null ? objectArray : FormattingTuple.trimmedCopy(objectArray);
    }

    static Object[] trimmedCopy(Object[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int n = objectArray.length - 1;
        Object[] objectArray2 = new Object[n];
        System.arraycopy(objectArray, 0, objectArray2, 0, n);
        return objectArray2;
    }

    public String getMessage() {
        return this.message;
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}

