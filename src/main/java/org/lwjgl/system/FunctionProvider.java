/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryStack;

@FunctionalInterface
public interface FunctionProvider {
    default public long getFunctionAddress(CharSequence charSequence) {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l = this.getFunctionAddress(memoryStack.ASCII(charSequence));
            return l;
        }
    }

    public long getFunctionAddress(ByteBuffer var1);
}

