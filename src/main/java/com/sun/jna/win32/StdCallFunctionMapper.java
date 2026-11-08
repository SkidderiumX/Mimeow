/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.win32;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.Pointer;
import java.lang.reflect.Method;

public class StdCallFunctionMapper
implements FunctionMapper {
    protected int getArgumentNativeStackSize(Class clazz) {
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            clazz = NativeMappedConverter.getInstance(clazz).nativeType();
        }
        if (clazz.isArray()) {
            return Pointer.SIZE;
        }
        try {
            return Native.getNativeSize(clazz);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + clazz);
        }
    }

    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        String string = method.getName();
        int n = 0;
        Class<?>[] classArray = method.getParameterTypes();
        for (int i = 0; i < classArray.length; ++i) {
            n += this.getArgumentNativeStackSize(classArray[i]);
        }
        String string2 = string + "@" + n;
        int n2 = 1;
        try {
            string = nativeLibrary.getFunction(string2, n2).getName();
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            try {
                string = nativeLibrary.getFunction("_" + string2, n2).getName();
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {
                // empty catch block
            }
        }
        return string;
    }
}

