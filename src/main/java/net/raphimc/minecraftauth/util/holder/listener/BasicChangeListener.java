/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.holder.listener;

import net.raphimc.minecraftauth.util.holder.listener.ChangeListener;

@FunctionalInterface
public interface BasicChangeListener
extends ChangeListener {
    public void onChange();

    @Override
    default public <T> void onChange(T t, T t2) {
        this.onChange();
    }
}

