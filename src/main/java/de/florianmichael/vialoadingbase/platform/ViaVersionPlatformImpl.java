/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.vialoadingbase.platform;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.UnsupportedSoftware;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.gson.JsonObject;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import de.florianmichael.vialoadingbase.platform.viaversion.VLBViaAPIWrapper;
import de.florianmichael.vialoadingbase.platform.viaversion.VLBViaConfig;
import de.florianmichael.vialoadingbase.util.VLBTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ViaVersionPlatformImpl
implements ViaPlatform<UserConnection> {
    private final ViaAPI<UserConnection> api = new VLBViaAPIWrapper();
    private final Logger logger;
    private final VLBViaConfig config;

    public ViaVersionPlatformImpl(Logger logger) {
        this.logger = logger;
        this.config = new VLBViaConfig(new File(ViaLoadingBase.getInstance().getRunDirectory(), "viaversion.yml"), logger);
    }

    public static List<ProtocolVersion> createVersionList() {
        List<ProtocolVersion> list = new ArrayList<ProtocolVersion>(ProtocolVersion.getProtocols()).stream().filter(protocolVersion -> protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_8)).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    @Override
    public VLBTask runAsync(Runnable runnable2) {
        return new VLBTask(Via.getManager().getScheduler().execute(runnable2));
    }

    @Override
    public VLBTask runRepeatingAsync(Runnable runnable2, long l) {
        return new VLBTask(Via.getManager().getScheduler().scheduleRepeating(runnable2, 0L, l * 50L, TimeUnit.MILLISECONDS));
    }

    @Override
    public VLBTask runSync(Runnable runnable2) {
        return this.runAsync(runnable2);
    }

    @Override
    public VLBTask runSync(Runnable runnable2, long l) {
        return new VLBTask(Via.getManager().getScheduler().schedule(runnable2, l * 50L, TimeUnit.MILLISECONDS));
    }

    @Override
    public VLBTask runRepeatingSync(Runnable runnable2, long l) {
        return this.runRepeatingAsync(runnable2, l);
    }

    @Override
    public boolean isProxy() {
        return true;
    }

    @Override
    public void onReload() {
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ViaVersionConfig getConf() {
        return this.config;
    }

    @Override
    public ViaAPI<UserConnection> getApi() {
        return this.api;
    }

    @Override
    public File getDataFolder() {
        return ViaLoadingBase.getInstance().getRunDirectory();
    }

    @Override
    public String getPluginVersion() {
        return "5.11.0";
    }

    @Override
    public String getPlatformName() {
        return "ViaLoadingBase";
    }

    @Override
    public String getPlatformVersion() {
        return "ViaMCP-5.11.0";
    }

    public VLBViaConfig getConfig() {
        return this.config;
    }

    @Override
    public Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
        return ViaPlatform.super.getUnsupportedSoftwareClasses();
    }

    @Override
    public boolean hasPlugin(String string) {
        return false;
    }

    @Override
    public JsonObject getDump() {
        if (ViaLoadingBase.getInstance().getDumpSupplier() == null) {
            return new JsonObject();
        }
        return ViaLoadingBase.getInstance().getDumpSupplier().get();
    }
}

