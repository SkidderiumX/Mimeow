/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;

public interface FunctionProviderLocal
extends FunctionProvider {
    default public long getFunctionAddress(long l, CharSequence charSequence) {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l2 = this.getFunctionAddress(l, memoryStack.ASCII(charSequence));
            return l2;
        }
    }

    public long getFunctionAddress(long var1, ByteBuffer var3);
}

