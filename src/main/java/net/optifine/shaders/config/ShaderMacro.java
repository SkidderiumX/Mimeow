/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.config;

public class ShaderMacro {
    private String name;
    private String value;

    public ShaderMacro(String string, String string2) {
        this.name = string;
        this.value = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String getSourceLine() {
        return "#define " + this.name + " " + this.value;
    }

    public String toString() {
        return this.getSourceLine();
    }
}

