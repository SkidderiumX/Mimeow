/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

public class ALCcontext {
    final long context;
    private boolean valid;

    ALCcontext(long l) {
        this.context = l;
        this.valid = true;
    }

    public boolean equals(Object object) {
        if (object instanceof ALCcontext) {
            return ((ALCcontext)object).context == this.context;
        }
        return super.equals(object);
    }

    static IntBuffer createAttributeList(int n, int n2, int n3) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(7);
        intBuffer.put(4103);
        intBuffer.put(n);
        intBuffer.put(4104);
        intBuffer.put(n2);
        intBuffer.put(4105);
        intBuffer.put(n3);
        intBuffer.put(0);
        return intBuffer;
    }

    void setInvalid() {
        this.valid = false;
    }

    public boolean isValid() {
        return this.valid;
    }
}

