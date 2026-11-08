/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.HashMap;
import org.lwjgl.openal.ALCcontext;

public class ALCdevice {
    public final long device;
    private boolean valid;
    private final HashMap<Long, ALCcontext> contexts = new HashMap();

    ALCdevice(long l) {
        this.device = l;
        this.valid = true;
    }

    public boolean equals(Object object) {
        if (object instanceof ALCdevice) {
            return ((ALCdevice)object).device == this.device;
        }
        return super.equals(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void addContext(ALCcontext aLCcontext) {
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            this.contexts.put(aLCcontext.context, aLCcontext);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void removeContext(ALCcontext aLCcontext) {
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            this.contexts.remove(aLCcontext.context);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setInvalid() {
        this.valid = false;
        HashMap<Long, ALCcontext> hashMap = this.contexts;
        synchronized (hashMap) {
            for (ALCcontext aLCcontext : this.contexts.values()) {
                aLCcontext.setInvalid();
            }
        }
        this.contexts.clear();
    }

    public boolean isValid() {
        return this.valid;
    }
}

