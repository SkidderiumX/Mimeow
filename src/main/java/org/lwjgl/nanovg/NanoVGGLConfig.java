/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.lang.reflect.Method;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryUtil;

public class NanoVGGLConfig {
    private NanoVGGLConfig() {
    }

    static void configGL(long l) {
        NanoVGGLConfig.config(l, NanoVGGLConfig.getFunctionProvider("org.lwjgl.opengl.GL"));
    }

    static void configGLES(long l) {
        NanoVGGLConfig.config(l, NanoVGGLConfig.getFunctionProvider("org.lwjgl.opengles.GLES"));
    }

    private static FunctionProvider getFunctionProvider(String string) {
        try {
            Class<?> clazz = Class.forName(string);
            Method method = clazz.getMethod("getCapabilities", new Class[0]);
            method.invoke(null, new Object[0]);
            Method method2 = clazz.getMethod("getFunctionProvider", new Class[0]);
            return (FunctionProvider)method2.invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void config(long l, FunctionProvider functionProvider) {
        String[] stringArray = new String[]{"glActiveTexture", "glAttachShader", "glBindAttribLocation", "glBindBuffer", "glBindBufferRange", "glBindFramebuffer", "glBindRenderbuffer", "glBindTexture", "glBindVertexArray", "glBlendFunc", "glBlendFuncSeparate", "glBufferData", "glCheckFramebufferStatus", "glColorMask", "glCompileShader", "glCreateProgram", "glCreateShader", "glCullFace", "glDeleteBuffers", "glDeleteFramebuffers", "glDeleteProgram", "glDeleteRenderbuffers", "glDeleteShader", "glDeleteTextures", "glDeleteVertexArrays", "glDetachShader", "glDisable", "glDisableVertexAttribArray", "glDrawArrays", "glEnable", "glEnableVertexAttribArray", "glFinish", "glFlush", "glFramebufferRenderbuffer", "glFramebufferTexture2D", "glFrontFace", "glGenBuffers", "glGenFramebuffers", "glGenRenderbuffers", "glGenTextures", "glGenVertexArrays", "glGenerateMipmap", "glGetError", "glGetIntegerv", "glGetProgramiv", "glGetProgramInfoLog", "glGetShaderiv", "glGetShaderInfoLog", "glGetUniformBlockIndex", "glGetUniformLocation", "glLinkProgram", "glPixelStorei", "glRenderbufferStorage", "glShaderSource", "glStencilFunc", "glStencilMask", "glStencilOp", "glStencilOpSeparate", "glTexImage2D", "glTexParameteri", "glTexSubImage2D", "glUniform1i", "glUniform2fv", "glUniform4fv", "glUniformBlockBinding", "glUseProgram", "glVertexAttribPointer"};
        PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(l, stringArray.length);
        for (int i = 0; i < stringArray.length; ++i) {
            pointerBuffer.put(i, functionProvider.getFunctionAddress(stringArray[i]));
        }
    }
}

