/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

public enum JavaVersion {
    JAVA_0_9(1.5f, "0.9"),
    JAVA_1_1(1.1f, "1.1"),
    JAVA_1_2(1.2f, "1.2"),
    JAVA_1_3(1.3f, "1.3"),
    JAVA_1_4(1.4f, "1.4"),
    JAVA_1_5(1.5f, "1.5"),
    JAVA_1_6(1.6f, "1.6"),
    JAVA_1_7(1.7f, "1.7"),
    JAVA_1_8(1.8f, "1.8");

    private final float value;
    private final String name;

    private JavaVersion(float f, String string2) {
        this.value = f;
        this.name = string2;
    }

    public boolean atLeast(JavaVersion javaVersion) {
        return this.value >= javaVersion.value;
    }

    static JavaVersion getJavaVersion(String string) {
        return JavaVersion.get(string);
    }

    static JavaVersion get(String string) {
        if ("0.9".equals(string)) {
            return JAVA_0_9;
        }
        if ("1.1".equals(string)) {
            return JAVA_1_1;
        }
        if ("1.2".equals(string)) {
            return JAVA_1_2;
        }
        if ("1.3".equals(string)) {
            return JAVA_1_3;
        }
        if ("1.4".equals(string)) {
            return JAVA_1_4;
        }
        if ("1.5".equals(string)) {
            return JAVA_1_5;
        }
        if ("1.6".equals(string)) {
            return JAVA_1_6;
        }
        if ("1.7".equals(string)) {
            return JAVA_1_7;
        }
        if ("1.8".equals(string)) {
            return JAVA_1_8;
        }
        return null;
    }

    public String toString() {
        return this.name;
    }
}

