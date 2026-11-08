/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.uniform;

import java.nio.FloatBuffer;
import net.optifine.shaders.uniform.ShaderUniformBase;
import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniformM4
extends ShaderUniformBase {
    private boolean transpose;
    private FloatBuffer matrix;

    public ShaderUniformM4(String string) {
        super(string);
    }

    public void setValue(boolean bl, FloatBuffer floatBuffer) {
        this.transpose = bl;
        this.matrix = floatBuffer;
        int n = this.getLocation();
        if (n >= 0) {
            ARBShaderObjects.glUniformMatrix4fvARB(n, bl, floatBuffer);
            this.checkGLError();
        }
    }

    public float getValue(int n, int n2) {
        if (this.matrix == null) {
            return 0.0f;
        }
        int n3 = this.transpose ? n2 * 4 + n : n * 4 + n2;
        float f = this.matrix.get(n3);
        return f;
    }

    @Override
    protected void onProgramSet(int n) {
    }

    @Override
    protected void resetValue() {
        this.matrix = null;
    }
}

