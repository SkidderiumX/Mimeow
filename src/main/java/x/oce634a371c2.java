/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import x.oc06b9308b3c;

public class oce634a371c2 {
    private static final String \u0126 = "#version 110\nvarying vec2 position;\nvarying vec2 coverage;\nvoid main() {\n    position = gl_Vertex.xy;\n    coverage = gl_MultiTexCoord0.xy;\n    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}\n";
    private static final String \u01c6 = "#version 110\nuniform vec4 inner;\nuniform vec4 outer;\nuniform vec3 paintX;\nuniform vec3 paintY;\nuniform vec2 extent;\nuniform float radius;\nuniform float feather;\nuniform float strokeMultiplier;\nuniform float fringe;\nvarying vec2 position;\nvarying vec2 coverage;\nvoid main() {\n    float mask = 1.0;\n    if (fringe > 0.5)\n        mask = clamp((1.0 - abs(coverage.x * 2.0 - 1.0)) * strokeMultiplier, 0.0, 1.0) * min(1.0, coverage.y);\n    float amount = 0.0;\n    if (feather != 0.0) {\n        vec2 p = vec2(dot(paintX, vec3(position, 1.0)), dot(paintY, vec3(position, 1.0)));\n        vec2 d = abs(p) - extent + vec2(radius);\n        float distance = min(max(d.x, d.y), 0.0) + length(max(d, 0.0)) - radius;\n        amount = clamp((distance + feather * 0.5) / feather, 0.0, 1.0);\n    }\n    vec4 color = mix(inner, outer, amount);\n    gl_FragColor = vec4(color.rgb, color.a * mask);\n}\n";
    private static boolean \u026b;
    private static int \u04b0;
    private static int \u0120;
    private static int \u0221;
    private static int \u02b1;
    private static int \u00dc;
    private static int \u02a8;
    private static int \u04c5;
    private static int \u01f9;
    private static int \u01f1;
    private static int \u018c;

    private oce634a371c2() {
    }

    static boolean \u03cb() {
        if (!\u026b) {
            \u026b = true;
            try {
                if (GLContext.getCapabilities().OpenGL20) {
                    \u04b0 = oce634a371c2.\u03c0();
                }
            }
            catch (LinkageError | RuntimeException throwable) {
                \u04b0 = 0;
            }
        }
        return \u04b0 != 0;
    }

    static void \u04e2() {
        \u026b = false;
        \u04b0 = 0;
    }

    private static int \u04be(int n, String string) {
        int n2 = GL20.glCreateShader(n);
        GL20.glShaderSource(n2, (CharSequence)string);
        GL20.glCompileShader(n2);
        if (GL20.glGetShaderi(n2, 0xD4D9460F ^ 0xD4D9CD8E) == 0) {
            GL20.glDeleteShader(n2);
            throw new IllegalStateException("canvas shader did not compile");
        }
        return n2;
    }

    private static int \u03c0() {
        int n = oce634a371c2.\u04be(0x106A4919 ^ 0x106AC228, "#version 110\nvarying vec2 position;\nvarying vec2 coverage;\nvoid main() {\n    position = gl_Vertex.xy;\n    coverage = gl_MultiTexCoord0.xy;\n    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}\n");
        int n2 = oce634a371c2.\u04be(0x106A4918 ^ 0x106AC228, "#version 110\nuniform vec4 inner;\nuniform vec4 outer;\nuniform vec3 paintX;\nuniform vec3 paintY;\nuniform vec2 extent;\nuniform float radius;\nuniform float feather;\nuniform float strokeMultiplier;\nuniform float fringe;\nvarying vec2 position;\nvarying vec2 coverage;\nvoid main() {\n    float mask = 1.0;\n    if (fringe > 0.5)\n        mask = clamp((1.0 - abs(coverage.x * 2.0 - 1.0)) * strokeMultiplier, 0.0, 1.0) * min(1.0, coverage.y);\n    float amount = 0.0;\n    if (feather != 0.0) {\n        vec2 p = vec2(dot(paintX, vec3(position, 1.0)), dot(paintY, vec3(position, 1.0)));\n        vec2 d = abs(p) - extent + vec2(radius);\n        float distance = min(max(d.x, d.y), 0.0) + length(max(d, 0.0)) - radius;\n        amount = clamp((distance + feather * 0.5) / feather, 0.0, 1.0);\n    }\n    vec4 color = mix(inner, outer, amount);\n    gl_FragColor = vec4(color.rgb, color.a * mask);\n}\n");
        int n3 = GL20.glCreateProgram();
        GL20.glAttachShader(n3, n);
        GL20.glAttachShader(n3, n2);
        GL20.glLinkProgram(n3);
        GL20.glDeleteShader(n);
        GL20.glDeleteShader(n2);
        if (GL20.glGetProgrami(n3, 0x106A49AA ^ 0x106AC228) == 0) {
            GL20.glDeleteProgram(n3);
            throw new IllegalStateException("canvas shader did not link");
        }
        \u0120 = GL20.glGetUniformLocation(n3, "inner");
        \u0221 = GL20.glGetUniformLocation(n3, "outer");
        \u02b1 = GL20.glGetUniformLocation(n3, "paintX");
        \u00dc = GL20.glGetUniformLocation(n3, "paintY");
        \u02a8 = GL20.glGetUniformLocation(n3, "extent");
        \u04c5 = GL20.glGetUniformLocation(n3, "radius");
        \u01f9 = GL20.glGetUniformLocation(n3, "feather");
        \u01f1 = GL20.glGetUniformLocation(n3, "strokeMultiplier");
        \u018c = GL20.glGetUniformLocation(n3, "fringe");
        return n3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void V(int n, List<float[]> list, oc06b9308b3c oc06b9308b3c2, float f, boolean bl) {
        int n2 = GL11.glGetInteger(0xDE1C23A8 ^ 0xDE1CA825);
        GL20.glUseProgram(\u04b0);
        try {
            float[] fArray = oc06b9308b3c2.\u013f;
            float f2 = fArray[0] * fArray[0xDE1CA826 ^ 0xDE1CA825] - fArray[1] * fArray[0xDE1CA827 ^ 0xDE1CA825];
            float f3 = oc06b9308b3c2.\u04b2;
            if (f2 == 0.0f) {
                f3 = 0.0f;
            } else {
                GL20.glUniform3f(\u02b1, fArray[0xDE1CA826 ^ 0xDE1CA825] / f2, -fArray[0xDE1CA827 ^ 0xDE1CA825] / f2, (fArray[0xDE1CA827 ^ 0xDE1CA825] * fArray[0xDE1CA820 ^ 0xDE1CA825] - fArray[0xDE1CA826 ^ 0xDE1CA825] * fArray[0xDE1CA821 ^ 0xDE1CA825]) / f2);
                GL20.glUniform3f(\u00dc, -fArray[1] / f2, fArray[0] / f2, (fArray[1] * fArray[0xDE1CA821 ^ 0xDE1CA825] - fArray[0] * fArray[0xDE1CA820 ^ 0xDE1CA825]) / f2);
            }
            GL20.glUniform4f(\u0120, oc06b9308b3c2.\u0180[0], oc06b9308b3c2.\u0180[1], oc06b9308b3c2.\u0180[0xDE1CA827 ^ 0xDE1CA825], oc06b9308b3c2.\u0180[0xDE1CA826 ^ 0xDE1CA825]);
            GL20.glUniform4f(\u0221, oc06b9308b3c2.\u02af[0], oc06b9308b3c2.\u02af[1], oc06b9308b3c2.\u02af[0xDE1CA827 ^ 0xDE1CA825], oc06b9308b3c2.\u02af[0xDE1CA826 ^ 0xDE1CA825]);
            GL20.glUniform2f(\u02a8, oc06b9308b3c2.\u026a[0], oc06b9308b3c2.\u026a[1]);
            GL20.glUniform1f(\u04c5, oc06b9308b3c2.\u02a9);
            GL20.glUniform1f(\u01f9, f3);
            GL20.glUniform1f(\u01f1, f);
            GL20.glUniform1f(\u018c, bl ? 1.0f : 0.0f);
            GL11.glBegin(n);
            try {
                for (float[] fArray2 : list) {
                    GL11.glTexCoord2f(fArray2.length > (0xDE1CA827 ^ 0xDE1CA825) ? fArray2[0xDE1CA827 ^ 0xDE1CA825] : 0.5f, fArray2.length > (0xDE1CA826 ^ 0xDE1CA825) ? fArray2[0xDE1CA826 ^ 0xDE1CA825] : 1.0f);
                    GL11.glVertex2f(fArray2[0], fArray2[1]);
                }
            }
            finally {
                GL11.glEnd();
            }
        }
        finally {
            GL20.glUseProgram(n2);
        }
    }
}

