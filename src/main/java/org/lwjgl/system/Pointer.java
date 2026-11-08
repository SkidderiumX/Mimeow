/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.Platform;

public interface Pointer {
    public static final int POINTER_SIZE = MemoryAccessJNI.getPointerSize();
    public static final int POINTER_SHIFT = POINTER_SIZE == 8 ? 3 : 2;
    public static final int CLONG_SIZE = POINTER_SIZE == 8 && Platform.get() == Platform.WINDOWS ? 4 : POINTER_SIZE;
    public static final int CLONG_SHIFT = CLONG_SIZE == 8 ? 3 : 2;
    public static final boolean BITS32 = POINTER_SIZE * 8 == 32;
    public static final boolean BITS64 = POINTER_SIZE * 8 == 64;

    public long address();

    public static abstract class Default
    implements Pointer {
        protected long address;

        protected Default(long l) {
            if (Checks.CHECKS && l == 0L) {
                throw new NullPointerException();
            }
            this.address = l;
        }

        @Override
        public long address() {
            return this.address;
        }

        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Pointer)) {
                return false;
            }
            Pointer pointer = (Pointer)object;
            return this.address == pointer.address();
        }

        public int hashCode() {
            return (int)(this.address ^ this.address >>> 32);
        }

        public String toString() {
            return String.format("%s pointer [0x%X]", this.getClass().getSimpleName(), this.address);
        }
    }
}

