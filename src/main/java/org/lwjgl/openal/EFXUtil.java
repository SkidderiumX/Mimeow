/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.EXTEfx;
import org.lwjgl.openal.OpenALException;

public class EFXUtil {
    private static final int EFFECT = 1111;
    private static final int FILTER = 2222;

    private EFXUtil() {
    }

    public static boolean isEfxSupported() {
        return ALC.getCapabilities().ALC_EXT_EFX;
    }

    public static boolean isEffectSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 32768: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown or invalid effect type: " + n);
            }
        }
        return EFXUtil.testSupportGeneric(1111, n);
    }

    public static boolean isFilterSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown or invalid filter type: " + n);
            }
        }
        return EFXUtil.testSupportGeneric(2222, n);
    }

    private static boolean testSupportGeneric(int n, int n2) {
        switch (n) {
            case 1111: 
            case 2222: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid objectType: " + n);
            }
        }
        boolean bl = false;
        if (EFXUtil.isEfxSupported()) {
            int n3;
            AL10.alGetError();
            int n4 = 0;
            try {
                switch (n) {
                    case 1111: {
                        n4 = EXTEfx.alGenEffects();
                        break;
                    }
                    case 2222: {
                        n4 = EXTEfx.alGenFilters();
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid objectType: " + n);
                    }
                }
                n3 = AL10.alGetError();
            }
            catch (OpenALException openALException) {
                n3 = openALException.getMessage().contains("AL_OUT_OF_MEMORY") ? 40965 : 40964;
            }
            if (n3 == 0) {
                int n5;
                AL10.alGetError();
                try {
                    switch (n) {
                        case 1111: {
                            EXTEfx.alEffecti(n4, 32769, n2);
                            break;
                        }
                        case 2222: {
                            EXTEfx.alFilteri(n4, 32769, n2);
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Invalid objectType: " + n);
                        }
                    }
                    n5 = AL10.alGetError();
                }
                catch (OpenALException openALException) {
                    n5 = 40963;
                }
                if (n5 == 0) {
                    bl = true;
                }
                try {
                    switch (n) {
                        case 1111: {
                            EXTEfx.alDeleteEffects(n4);
                            break;
                        }
                        case 2222: {
                            EXTEfx.alDeleteFilters(n4);
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Invalid objectType: " + n);
                        }
                    }
                }
                catch (OpenALException openALException) {}
            } else if (n3 == 40965) {
                throw new OpenALException(AL10.alGetString(n3));
            }
        }
        return bl;
    }
}

