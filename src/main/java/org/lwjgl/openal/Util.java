/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;
import org.lwjgl.openal.OpenALException;
import org.lwjgl.openal.xAL;

public class Util {
    private Util() {
    }

    public static void checkALCError(ALCdevice aLCdevice) {
        int n = ALC10.alcGetError(aLCdevice.device);
        if (n != 0) {
            throw new OpenALException(ALC10.alcGetString(xAL.getDevice().device, n));
        }
    }

    public static void checkALError() {
        int n = AL10.alGetError();
        if (n != 0) {
            throw new OpenALException(n);
        }
    }

    public static void checkALCValidDevice(ALCdevice aLCdevice) {
        if (!aLCdevice.isValid()) {
            throw new OpenALException("Invalid device: " + String.valueOf(aLCdevice));
        }
    }

    public static void checkALCValidContext(ALCcontext aLCcontext) {
        if (!aLCcontext.isValid()) {
            throw new OpenALException("Invalid context: " + String.valueOf(aLCcontext));
        }
    }
}

