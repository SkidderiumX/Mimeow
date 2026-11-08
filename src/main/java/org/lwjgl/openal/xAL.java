/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

public class xAL {
    static ALCdevice alcDevice;
    static ALCcontext alcContext;
    private static boolean created;

    public static void create() throws LWJGLException {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        intBuffer.put(4103);
        intBuffer.put(44100);
        intBuffer.put(4104);
        intBuffer.put(60);
        intBuffer.put(4105);
        intBuffer.put(0);
        intBuffer.put(0);
        intBuffer.flip();
        String string = ALC10.alcGetString(0L, 4100);
        long l = ALC10.alcOpenDevice(string);
        alcDevice = new ALCdevice(l);
        ALCCapabilities aLCCapabilities = ALC.createCapabilities(l);
        long l2 = ALC10.alcCreateContext(xAL.getDevice().device, intBuffer);
        alcContext = new ALCcontext(l2);
        ALC10.alcMakeContextCurrent(l2);
        AL.createCapabilities(aLCCapabilities);
        created = true;
    }

    public static boolean isCreated() {
        return created;
    }

    public static void destroy() {
        ALC10.alcDestroyContext(xAL.alcContext.context);
        ALC10.alcCloseDevice(xAL.alcDevice.device);
        alcContext = null;
        alcDevice = null;
        created = false;
    }

    public static ALCdevice getDevice() {
        return alcDevice;
    }

    static {
        created = false;
    }
}

