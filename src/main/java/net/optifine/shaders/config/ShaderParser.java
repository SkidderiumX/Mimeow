/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.optifine.shaders.config.ShaderLine;

public class ShaderParser {
    public static Pattern PATTERN_UNIFORM = Pattern.compile("\\s*uniform\\s+\\w+\\s+(\\w+).*");
    public static Pattern PATTERN_ATTRIBUTE = Pattern.compile("\\s*attribute\\s+\\w+\\s+(\\w+).*");
    public static Pattern PATTERN_CONST_INT = Pattern.compile("\\s*const\\s+int\\s+(\\w+)\\s*=\\s*([-+.\\w]+)\\s*;.*");
    public static Pattern PATTERN_CONST_FLOAT = Pattern.compile("\\s*const\\s+float\\s+(\\w+)\\s*=\\s*([-+.\\w]+)\\s*;.*");
    public static Pattern PATTERN_CONST_VEC4 = Pattern.compile("\\s*const\\s+vec4\\s+(\\w+)\\s*=\\s*(.+)\\s*;.*");
    public static Pattern PATTERN_CONST_BOOL = Pattern.compile("\\s*const\\s+bool\\s+(\\w+)\\s*=\\s*(\\w+)\\s*;.*");
    public static Pattern PATTERN_PROPERTY = Pattern.compile("\\s*(/\\*|//)?\\s*([A-Z]+):\\s*(\\w+)\\s*(\\*/.*|\\s*)");
    public static Pattern PATTERN_EXTENSION = Pattern.compile("\\s*#\\s*extension\\s+(\\w+)\\s*:\\s*(\\w+).*");
    public static Pattern PATTERN_DEFERRED_FSH = Pattern.compile(".*deferred[0-9]*\\.fsh");
    public static Pattern PATTERN_COMPOSITE_FSH = Pattern.compile(".*composite[0-9]*\\.fsh");
    public static Pattern PATTERN_FINAL_FSH = Pattern.compile(".*final\\.fsh");
    public static Pattern PATTERN_DRAW_BUFFERS = Pattern.compile("[0-7N]*");

    public static ShaderLine parseLine(String string) {
        Matcher matcher = PATTERN_UNIFORM.matcher(string);
        if (matcher.matches()) {
            return new ShaderLine(1, matcher.group(1), "", string);
        }
        Matcher matcher2 = PATTERN_ATTRIBUTE.matcher(string);
        if (matcher2.matches()) {
            return new ShaderLine(2, matcher2.group(1), "", string);
        }
        Matcher matcher3 = PATTERN_PROPERTY.matcher(string);
        if (matcher3.matches()) {
            return new ShaderLine(6, matcher3.group(2), matcher3.group(3), string);
        }
        Matcher matcher4 = PATTERN_CONST_INT.matcher(string);
        if (matcher4.matches()) {
            return new ShaderLine(3, matcher4.group(1), matcher4.group(2), string);
        }
        Matcher matcher5 = PATTERN_CONST_FLOAT.matcher(string);
        if (matcher5.matches()) {
            return new ShaderLine(4, matcher5.group(1), matcher5.group(2), string);
        }
        Matcher matcher6 = PATTERN_CONST_BOOL.matcher(string);
        if (matcher6.matches()) {
            return new ShaderLine(5, matcher6.group(1), matcher6.group(2), string);
        }
        Matcher matcher7 = PATTERN_EXTENSION.matcher(string);
        if (matcher7.matches()) {
            return new ShaderLine(7, matcher7.group(1), matcher7.group(2), string);
        }
        Matcher matcher8 = PATTERN_CONST_VEC4.matcher(string);
        return matcher8.matches() ? new ShaderLine(8, matcher8.group(1), matcher8.group(2), string) : null;
    }

    public static int getIndex(String string, String string2, int n, int n2) {
        if (string.length() != string2.length() + 1) {
            return -1;
        }
        if (!string.startsWith(string2)) {
            return -1;
        }
        int n3 = string.charAt(string2.length()) - 48;
        return n3 >= n && n3 <= n2 ? n3 : -1;
    }

    public static int getShadowDepthIndex(String string) {
        return string.equals("shadow") ? 0 : (string.equals("watershadow") ? 1 : ShaderParser.getIndex(string, "shadowtex", 0, 1));
    }

    public static int getShadowColorIndex(String string) {
        return string.equals("shadowcolor") ? 0 : ShaderParser.getIndex(string, "shadowcolor", 0, 1);
    }

    public static int getDepthIndex(String string) {
        return ShaderParser.getIndex(string, "depthtex", 0, 2);
    }

    public static int getColorIndex(String string) {
        int n = ShaderParser.getIndex(string, "gaux", 1, 4);
        return n > 0 ? n + 3 : ShaderParser.getIndex(string, "colortex", 4, 7);
    }

    public static boolean isDeferred(String string) {
        return PATTERN_DEFERRED_FSH.matcher(string).matches();
    }

    public static boolean isComposite(String string) {
        return PATTERN_COMPOSITE_FSH.matcher(string).matches();
    }

    public static boolean isFinal(String string) {
        return PATTERN_FINAL_FSH.matcher(string).matches();
    }

    public static boolean isValidDrawBuffers(String string) {
        return PATTERN_DRAW_BUFFERS.matcher(string).matches();
    }
}

