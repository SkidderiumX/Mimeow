/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.config;

import net.minecraft.src.Config;
import net.optifine.util.StrUtils;
import org.lwjgl.util.vector.Vector4f;

public class ShaderLine {
    private int type;
    private String name;
    private String value;
    private String line;
    public static final int TYPE_UNIFORM = 1;
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_CONST_INT = 3;
    public static final int TYPE_CONST_FLOAT = 4;
    public static final int TYPE_CONST_BOOL = 5;
    public static final int TYPE_PROPERTY = 6;
    public static final int TYPE_EXTENSION = 7;
    public static final int TYPE_CONST_VEC4 = 8;

    public ShaderLine(int n, String string, String string2, String string3) {
        this.type = n;
        this.name = string;
        this.value = string2;
        this.line = string3;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isUniform() {
        return this.type == 1;
    }

    public boolean isUniform(String string) {
        return this.isUniform() && string.equals(this.name);
    }

    public boolean isAttribute() {
        return this.type == 2;
    }

    public boolean isAttribute(String string) {
        return this.isAttribute() && string.equals(this.name);
    }

    public boolean isProperty() {
        return this.type == 6;
    }

    public boolean isConstInt() {
        return this.type == 3;
    }

    public boolean isConstFloat() {
        return this.type == 4;
    }

    public boolean isConstBool() {
        return this.type == 5;
    }

    public boolean isExtension() {
        return this.type == 7;
    }

    public boolean isConstVec4() {
        return this.type == 8;
    }

    public boolean isProperty(String string) {
        return this.isProperty() && string.equals(this.name);
    }

    public boolean isProperty(String string, String string2) {
        return this.isProperty(string) && string2.equals(this.value);
    }

    public boolean isConstInt(String string) {
        return this.isConstInt() && string.equals(this.name);
    }

    public boolean isConstIntSuffix(String string) {
        return this.isConstInt() && this.name.endsWith(string);
    }

    public boolean isConstFloat(String string) {
        return this.isConstFloat() && string.equals(this.name);
    }

    public boolean isConstBool(String string) {
        return this.isConstBool() && string.equals(this.name);
    }

    public boolean isExtension(String string) {
        return this.isExtension() && string.equals(this.name);
    }

    public boolean isConstBoolSuffix(String string) {
        return this.isConstBool() && this.name.endsWith(string);
    }

    public boolean isConstBoolSuffix(String string, boolean bl) {
        return this.isConstBoolSuffix(string) && this.getValueBool() == bl;
    }

    public boolean isConstBool(String string, String string2) {
        return this.isConstBool(string) || this.isConstBool(string2);
    }

    public boolean isConstBool(String string, String string2, String string3) {
        return this.isConstBool(string) || this.isConstBool(string2) || this.isConstBool(string3);
    }

    public boolean isConstBool(String string, boolean bl) {
        return this.isConstBool(string) && this.getValueBool() == bl;
    }

    public boolean isConstBool(String string, String string2, boolean bl) {
        return this.isConstBool(string, string2) && this.getValueBool() == bl;
    }

    public boolean isConstBool(String string, String string2, String string3, boolean bl) {
        return this.isConstBool(string, string2, string3) && this.getValueBool() == bl;
    }

    public boolean isConstVec4Suffix(String string) {
        return this.isConstVec4() && this.name.endsWith(string);
    }

    public int getValueInt() {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Invalid integer: " + this.value + ", line: " + this.line);
        }
    }

    public float getValueFloat() {
        try {
            return Float.parseFloat(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("Invalid float: " + this.value + ", line: " + this.line);
        }
    }

    public Vector4f getValueVec4() {
        if (this.value == null) {
            return null;
        }
        String string = this.value.trim();
        string = StrUtils.removePrefix(string, "vec4");
        String[] stringArray = Config.tokenize(string = StrUtils.trim(string, " ()"), ", ");
        if (stringArray.length != 4) {
            return null;
        }
        float[] fArray = new float[4];
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            float f = Config.parseFloat(string2 = StrUtils.removeSuffix(string2, new String[]{"F", "f"}), Float.MAX_VALUE);
            if (f == Float.MAX_VALUE) {
                return null;
            }
            fArray[i] = f;
        }
        return new Vector4f(fArray[0], fArray[1], fArray[2], fArray[3]);
    }

    public boolean getValueBool() {
        String string = this.value.toLowerCase();
        if (!string.equals("true") && !string.equals("false")) {
            throw new RuntimeException("Invalid boolean: " + this.value + ", line: " + this.line);
        }
        return Boolean.valueOf(this.value);
    }
}

