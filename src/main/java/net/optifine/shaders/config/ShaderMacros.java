/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.config;

import net.minecraft.src.Config;
import net.minecraft.util.Util;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.ShaderMacro;

public class ShaderMacros {
    private static String PREFIX_MACRO = "MC_";
    public static final String MC_VERSION = "MC_VERSION";
    public static final String MC_GL_VERSION = "MC_GL_VERSION";
    public static final String MC_GLSL_VERSION = "MC_GLSL_VERSION";
    public static final String MC_OS_WINDOWS = "MC_OS_WINDOWS";
    public static final String MC_OS_MAC = "MC_OS_MAC";
    public static final String MC_OS_LINUX = "MC_OS_LINUX";
    public static final String MC_OS_OTHER = "MC_OS_OTHER";
    public static final String MC_GL_VENDOR_ATI = "MC_GL_VENDOR_ATI";
    public static final String MC_GL_VENDOR_INTEL = "MC_GL_VENDOR_INTEL";
    public static final String MC_GL_VENDOR_NVIDIA = "MC_GL_VENDOR_NVIDIA";
    public static final String MC_GL_VENDOR_XORG = "MC_GL_VENDOR_XORG";
    public static final String MC_GL_VENDOR_OTHER = "MC_GL_VENDOR_OTHER";
    public static final String MC_GL_RENDERER_RADEON = "MC_GL_RENDERER_RADEON";
    public static final String MC_GL_RENDERER_GEFORCE = "MC_GL_RENDERER_GEFORCE";
    public static final String MC_GL_RENDERER_QUADRO = "MC_GL_RENDERER_QUADRO";
    public static final String MC_GL_RENDERER_INTEL = "MC_GL_RENDERER_INTEL";
    public static final String MC_GL_RENDERER_GALLIUM = "MC_GL_RENDERER_GALLIUM";
    public static final String MC_GL_RENDERER_MESA = "MC_GL_RENDERER_MESA";
    public static final String MC_GL_RENDERER_OTHER = "MC_GL_RENDERER_OTHER";
    public static final String MC_FXAA_LEVEL = "MC_FXAA_LEVEL";
    public static final String MC_NORMAL_MAP = "MC_NORMAL_MAP";
    public static final String MC_SPECULAR_MAP = "MC_SPECULAR_MAP";
    public static final String MC_RENDER_QUALITY = "MC_RENDER_QUALITY";
    public static final String MC_SHADOW_QUALITY = "MC_SHADOW_QUALITY";
    public static final String MC_HAND_DEPTH = "MC_HAND_DEPTH";
    public static final String MC_OLD_HAND_LIGHT = "MC_OLD_HAND_LIGHT";
    public static final String MC_OLD_LIGHTING = "MC_OLD_LIGHTING";
    private static ShaderMacro[] extensionMacros;

    public static String getOs() {
        Util.EnumOS enumOS = Util.getOSType();
        switch (enumOS) {
            case WINDOWS: {
                return MC_OS_WINDOWS;
            }
            case OSX: {
                return MC_OS_MAC;
            }
            case LINUX: {
                return MC_OS_LINUX;
            }
        }
        return MC_OS_OTHER;
    }

    public static String getVendor() {
        String string = Config.openGlVendor;
        if (string == null) {
            return MC_GL_VENDOR_OTHER;
        }
        return (string = string.toLowerCase()).startsWith("ati") ? MC_GL_VENDOR_ATI : (string.startsWith("intel") ? MC_GL_VENDOR_INTEL : (string.startsWith("nvidia") ? MC_GL_VENDOR_NVIDIA : (string.startsWith("x.org") ? MC_GL_VENDOR_XORG : MC_GL_VENDOR_OTHER)));
    }

    public static String getRenderer() {
        String string = Config.openGlRenderer;
        if (string == null) {
            return MC_GL_RENDERER_OTHER;
        }
        return (string = string.toLowerCase()).startsWith("amd") ? MC_GL_RENDERER_RADEON : (string.startsWith("ati") ? MC_GL_RENDERER_RADEON : (string.startsWith("radeon") ? MC_GL_RENDERER_RADEON : (string.startsWith("gallium") ? MC_GL_RENDERER_GALLIUM : (string.startsWith("intel") ? MC_GL_RENDERER_INTEL : (string.startsWith("geforce") ? MC_GL_RENDERER_GEFORCE : (string.startsWith("nvidia") ? MC_GL_RENDERER_GEFORCE : (string.startsWith("quadro") ? MC_GL_RENDERER_QUADRO : (string.startsWith("nvs") ? MC_GL_RENDERER_QUADRO : (string.startsWith("mesa") ? MC_GL_RENDERER_MESA : MC_GL_RENDERER_OTHER)))))))));
    }

    public static String getPrefixMacro() {
        return PREFIX_MACRO;
    }

    public static ShaderMacro[] getExtensions() {
        if (extensionMacros == null) {
            String[] stringArray = Config.getOpenGlExtensions();
            ShaderMacro[] shaderMacroArray = new ShaderMacro[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                shaderMacroArray[i] = new ShaderMacro(PREFIX_MACRO + stringArray[i], "");
            }
            extensionMacros = shaderMacroArray;
        }
        return extensionMacros;
    }

    public static String getFixedMacroLines() {
        StringBuilder stringBuilder = new StringBuilder();
        ShaderMacros.addMacroLine(stringBuilder, MC_VERSION, Config.getMinecraftVersionInt());
        ShaderMacros.addMacroLine(stringBuilder, "MC_GL_VERSION " + Config.getGlVersion().toInt());
        ShaderMacros.addMacroLine(stringBuilder, "MC_GLSL_VERSION " + Config.getGlslVersion().toInt());
        ShaderMacros.addMacroLine(stringBuilder, ShaderMacros.getOs());
        ShaderMacros.addMacroLine(stringBuilder, ShaderMacros.getVendor());
        ShaderMacros.addMacroLine(stringBuilder, ShaderMacros.getRenderer());
        return stringBuilder.toString();
    }

    public static String getOptionMacroLines() {
        StringBuilder stringBuilder = new StringBuilder();
        if (Shaders.configAntialiasingLevel > 0) {
            ShaderMacros.addMacroLine(stringBuilder, MC_FXAA_LEVEL, Shaders.configAntialiasingLevel);
        }
        if (Shaders.configNormalMap) {
            ShaderMacros.addMacroLine(stringBuilder, MC_NORMAL_MAP);
        }
        if (Shaders.configSpecularMap) {
            ShaderMacros.addMacroLine(stringBuilder, MC_SPECULAR_MAP);
        }
        ShaderMacros.addMacroLine(stringBuilder, MC_RENDER_QUALITY, Shaders.configRenderResMul);
        ShaderMacros.addMacroLine(stringBuilder, MC_SHADOW_QUALITY, Shaders.configShadowResMul);
        ShaderMacros.addMacroLine(stringBuilder, MC_HAND_DEPTH, Shaders.configHandDepthMul);
        if (Shaders.isOldHandLight()) {
            ShaderMacros.addMacroLine(stringBuilder, MC_OLD_HAND_LIGHT);
        }
        if (Shaders.isOldLighting()) {
            ShaderMacros.addMacroLine(stringBuilder, MC_OLD_LIGHTING);
        }
        return stringBuilder.toString();
    }

    private static void addMacroLine(StringBuilder stringBuilder, String string, int n) {
        stringBuilder.append("#define ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(n);
        stringBuilder.append("\n");
    }

    private static void addMacroLine(StringBuilder stringBuilder, String string, float f) {
        stringBuilder.append("#define ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(f);
        stringBuilder.append("\n");
    }

    private static void addMacroLine(StringBuilder stringBuilder, String string) {
        stringBuilder.append("#define ");
        stringBuilder.append(string);
        stringBuilder.append("\n");
    }
}

