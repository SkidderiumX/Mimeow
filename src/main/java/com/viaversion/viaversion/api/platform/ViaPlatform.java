/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.platform;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.PlatformTask;
import com.viaversion.viaversion.api.platform.UnsupportedSoftware;
import com.viaversion.viaversion.api.platform.ViaPlatformTask;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.util.VersionInfo;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public interface ViaPlatform<T> {
    public Logger getLogger();

    default public Logger createLogger(String string) {
        return this.getLogger();
    }

    public String getPlatformName();

    public String getPlatformVersion();

    default public boolean isProxy() {
        return false;
    }

    default public String getPluginVersion() {
        return VersionInfo.getVersion();
    }

    default public PlatformTask runAsync(Runnable runnable2) {
        return new ViaPlatformTask(Via.getManager().getScheduler().execute(runnable2));
    }

    default public PlatformTask runRepeatingAsync(Runnable runnable2, long l) {
        return new ViaPlatformTask(Via.getManager().getScheduler().scheduleRepeating(runnable2, l * 50L, l * 50L, TimeUnit.MILLISECONDS));
    }

    default public PlatformTask runSync(Runnable runnable2) {
        return this.runAsync(runnable2);
    }

    default public PlatformTask runSync(Runnable runnable2, long l) {
        return new ViaPlatformTask(Via.getManager().getScheduler().schedule(runnable2, l * 50L, TimeUnit.MILLISECONDS));
    }

    default public PlatformTask runRepeatingSync(Runnable runnable2, long l) {
        return this.runRepeatingAsync(runnable2, l);
    }

    default public void sendMessage(UserConnection userConnection, String string) {
    }

    default public boolean kickPlayer(UserConnection userConnection, String string) {
        return false;
    }

    default public void modifyPlayerDetails(UserConnection userConnection, JsonObject jsonObject) {
    }

    default public void modifyServerDetails(UserConnection userConnection, JsonObject jsonObject) {
    }

    default public void sendCustomPayload(UserConnection userConnection, String string, byte[] byArray) {
    }

    default public void sendCustomPayloadToClient(UserConnection userConnection, String string, byte[] byArray) {
    }

    public ViaAPI<T> getApi();

    public ViaVersionConfig getConf();

    public File getDataFolder();

    default public void onReload() {
    }

    default public JsonObject getDump() {
        return new JsonObject();
    }

    default public Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
        return List.of();
    }

    default public boolean hasPlugin(String string) {
        return false;
    }

    default public boolean couldBeReloading() {
        return false;
    }
}

