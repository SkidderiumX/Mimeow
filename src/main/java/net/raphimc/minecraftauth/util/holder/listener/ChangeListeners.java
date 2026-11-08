/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.holder.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.raphimc.minecraftauth.util.holder.listener.BasicChangeListener;
import net.raphimc.minecraftauth.util.holder.listener.ChangeListener;
import org.jetbrains.annotations.ApiStatus;

public class ChangeListeners {
    private final List<ChangeListener> changeListeners = new ArrayList<ChangeListener>();

    public synchronized void add(ChangeListener changeListener) {
        this.changeListeners.add(changeListener);
    }

    public synchronized void add(BasicChangeListener basicChangeListener) {
        this.changeListeners.add(basicChangeListener);
    }

    public synchronized boolean remove(ChangeListener changeListener) {
        return this.changeListeners.remove(changeListener);
    }

    public synchronized boolean remove(BasicChangeListener basicChangeListener) {
        return this.changeListeners.remove(basicChangeListener);
    }

    @ApiStatus.Internal
    public synchronized <T> void invoke(T t, T t2) {
        if (!Objects.equals(t, t2)) {
            for (ChangeListener changeListener : this.changeListeners) {
                changeListener.onChange(t, t2);
            }
        }
    }
}

