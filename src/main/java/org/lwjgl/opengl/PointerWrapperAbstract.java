/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.PointerWrapper;

public class PointerWrapperAbstract
implements PointerWrapper {
    protected final long pointer;

    protected PointerWrapperAbstract(long l) {
        this.pointer = l;
    }

    public boolean isValid() {
        return this.pointer != 0L;
    }

    public final void checkValid() {
        if (LWJGLUtil.DEBUG && !this.isValid()) {
            throw new IllegalStateException("This " + this.getClass().getSimpleName() + " pointer is not valid.");
        }
    }

    @Override
    public final long getPointer() {
        this.checkValid();
        return this.pointer;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PointerWrapperAbstract)) {
            return false;
        }
        PointerWrapperAbstract pointerWrapperAbstract = (PointerWrapperAbstract)object;
        return this.pointer == pointerWrapperAbstract.pointer;
    }

    public int hashCode() {
        return (int)(this.pointer ^ this.pointer >>> 32);
    }

    public String toString() {
        return this.getClass().getSimpleName() + " pointer (0x" + Long.toHexString(this.pointer).toUpperCase() + ")";
    }
}

