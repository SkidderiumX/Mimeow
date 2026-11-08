/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.platform;

public interface ViaPlatformLoader {
    public static final ViaPlatformLoader NOOP = new ViaPlatformLoader(){

        @Override
        public void load() {
        }

        @Override
        public void unload() {
        }
    };

    public void load();

    public void unload();
}

