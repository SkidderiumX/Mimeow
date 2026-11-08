/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.vialoadingbase;

import com.viaversion.viaversion.ViaManagerImpl;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocol.ProtocolManagerImpl;
import de.florianmichael.vialoadingbase.model.Platform;
import de.florianmichael.vialoadingbase.platform.ViaBackwardsPlatformImpl;
import de.florianmichael.vialoadingbase.platform.ViaRewindPlatformImpl;
import de.florianmichael.vialoadingbase.platform.ViaVersionPlatformImpl;
import de.florianmichael.vialoadingbase.platform.viaversion.VLBViaCommandHandler;
import de.florianmichael.vialoadingbase.platform.viaversion.VLBViaInjector;
import de.florianmichael.vialoadingbase.platform.viaversion.VLBViaProviders;
import de.florianmichael.vialoadingbase.util.JLoggerToLog4j;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

public class ViaLoadingBase {
    public static final String VERSION = "ViaMCP-5.11.0";
    public static final Logger LOGGER = new JLoggerToLog4j(LogManager.getLogger("ViaLoadingBase"));
    public static final Platform PSEUDO_VIA_VERSION = new Platform("ViaVersion", () -> true, () -> {}, list -> list.addAll(ViaVersionPlatformImpl.createVersionList()));
    public static final Platform PLATFORM_VIA_BACKWARDS = new Platform("ViaBackwards", () -> ViaLoadingBase.inClassPath("com.viaversion.viabackwards.api.ViaBackwardsPlatform"), () -> new ViaBackwardsPlatformImpl(Via.getManager().getPlatform().getDataFolder()));
    public static final Platform PLATFORM_VIA_REWIND = new Platform("ViaRewind", () -> ViaLoadingBase.inClassPath("com.viaversion.viarewind.api.ViaRewindPlatform"), () -> new ViaRewindPlatformImpl(Via.getManager().getPlatform().getDataFolder()));
    public static final List<ProtocolVersion> PROTOCOLS = new ArrayList<ProtocolVersion>();
    private static volatile ViaLoadingBase instance;
    private final LinkedList<Platform> platforms;
    private final File runDirectory;
    private final int nativeVersion;
    private final BooleanSupplier forceNativeVersionCondition;
    private final Supplier<JsonObject> dumpSupplier;
    private final Consumer<ViaProviders> providers;
    private final Consumer<ViaManagerImpl.ViaManagerBuilder> managerBuilderConsumer;
    private final Consumer<ProtocolVersion> onProtocolReload;
    private volatile ProtocolVersion nativeProtocolVersion;
    private volatile ProtocolVersion targetProtocolVersion;

    public ViaLoadingBase(LinkedList<Platform> linkedList, File file, int n, BooleanSupplier booleanSupplier, Supplier<JsonObject> supplier, Consumer<ViaProviders> consumer, Consumer<ViaManagerImpl.ViaManagerBuilder> consumer2, Consumer<ProtocolVersion> consumer3) {
        this.platforms = linkedList;
        this.runDirectory = new File(file, "ViaLoadingBase");
        this.nativeVersion = n;
        this.forceNativeVersionCondition = booleanSupplier;
        this.dumpSupplier = supplier;
        this.providers = consumer;
        this.managerBuilderConsumer = consumer2;
        this.onProtocolReload = consumer3;
        instance = this;
        this.initPlatform();
    }

    public ProtocolVersion getTargetVersion() {
        if (this.forceNativeVersionCondition != null && this.forceNativeVersionCondition.getAsBoolean()) {
            return this.nativeProtocolVersion;
        }
        return this.targetProtocolVersion;
    }

    public void reload(ProtocolVersion protocolVersion) {
        this.targetProtocolVersion = protocolVersion;
        if (this.onProtocolReload != null) {
            this.onProtocolReload.accept(this.targetProtocolVersion);
        }
    }

    public void initPlatform() {
        PROTOCOLS.clear();
        for (Platform object2 : this.platforms) {
            object2.createProtocolPath();
        }
        this.targetProtocolVersion = this.nativeProtocolVersion = ProtocolVersion.getProtocol(this.nativeVersion);
        ViaVersionPlatformImpl viaVersionPlatformImpl = new ViaVersionPlatformImpl(LOGGER);
        ViaManagerImpl.ViaManagerBuilder viaManagerBuilder = ViaManagerImpl.builder().platform(viaVersionPlatformImpl).loader(new VLBViaProviders()).injector(new VLBViaInjector()).commandHandler(new VLBViaCommandHandler());
        if (this.managerBuilderConsumer != null) {
            this.managerBuilderConsumer.accept(viaManagerBuilder);
        }
        Via.init(viaManagerBuilder.build());
        ViaManagerImpl viaManagerImpl = (ViaManagerImpl)Via.getManager();
        viaManagerImpl.addEnableListener(() -> {
            for (Platform platform : this.platforms) {
                platform.build(LOGGER);
            }
        });
        viaManagerImpl.init();
        viaManagerImpl.onServerLoaded();
        viaManagerImpl.getProtocolManager().setMaxProtocolPathSize(Integer.MAX_VALUE);
        viaManagerImpl.getProtocolManager().setMaxPathDeltaIncrease(-1);
        ((ProtocolManagerImpl)viaManagerImpl.getProtocolManager()).refreshVersions();
        LOGGER.info("ViaLoadingBase has loaded " + Platform.COUNT + "/" + this.platforms.size() + " platforms");
    }

    public static ViaLoadingBase getInstance() {
        return instance;
    }

    public List<Platform> getSubPlatforms() {
        return this.platforms;
    }

    public File getRunDirectory() {
        return this.runDirectory;
    }

    public int getNativeVersion() {
        return this.nativeVersion;
    }

    public Supplier<JsonObject> getDumpSupplier() {
        return this.dumpSupplier;
    }

    public Consumer<ViaProviders> getProviders() {
        return this.providers;
    }

    public static boolean inClassPath(String string) {
        try {
            Class.forName(string);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Deprecated
    public static List<ProtocolVersion> getProtocols() {
        return PROTOCOLS;
    }

    public static class ViaLoadingBaseBuilder {
        private final LinkedList<Platform> platforms = new LinkedList();
        private File runDirectory;
        private Integer nativeVersion;
        private BooleanSupplier forceNativeVersionCondition;
        private Supplier<JsonObject> dumpSupplier;
        private Consumer<ViaProviders> providers;
        private Consumer<ViaManagerImpl.ViaManagerBuilder> managerBuilderConsumer;
        private Consumer<ProtocolVersion> onProtocolReload;

        public ViaLoadingBaseBuilder() {
            this.platforms.add(PSEUDO_VIA_VERSION);
            this.platforms.add(PLATFORM_VIA_BACKWARDS);
            this.platforms.add(PLATFORM_VIA_REWIND);
        }

        public static ViaLoadingBaseBuilder create() {
            return new ViaLoadingBaseBuilder();
        }

        public ViaLoadingBaseBuilder platform(Platform platform) {
            this.platforms.add(platform);
            return this;
        }

        public ViaLoadingBaseBuilder platform(Platform platform, int n) {
            this.platforms.add(n, platform);
            return this;
        }

        public ViaLoadingBaseBuilder runDirectory(File file) {
            this.runDirectory = file;
            return this;
        }

        public ViaLoadingBaseBuilder nativeVersion(int n) {
            this.nativeVersion = n;
            return this;
        }

        public ViaLoadingBaseBuilder forceNativeVersionCondition(BooleanSupplier booleanSupplier) {
            this.forceNativeVersionCondition = booleanSupplier;
            return this;
        }

        public ViaLoadingBaseBuilder dumpSupplier(Supplier<JsonObject> supplier) {
            this.dumpSupplier = supplier;
            return this;
        }

        public ViaLoadingBaseBuilder providers(Consumer<ViaProviders> consumer) {
            this.providers = consumer;
            return this;
        }

        public ViaLoadingBaseBuilder managerBuilderConsumer(Consumer<ViaManagerImpl.ViaManagerBuilder> consumer) {
            this.managerBuilderConsumer = consumer;
            return this;
        }

        public ViaLoadingBaseBuilder onProtocolReload(Consumer<ProtocolVersion> consumer) {
            this.onProtocolReload = consumer;
            return this;
        }

        public void build() {
            if (ViaLoadingBase.getInstance() != null) {
                LOGGER.severe("ViaLoadingBase has already started the platform!");
                return;
            }
            if (this.runDirectory == null || this.nativeVersion == null) {
                LOGGER.severe("Please check your ViaLoadingBaseBuilder arguments!");
                return;
            }
            new ViaLoadingBase(this.platforms, this.runDirectory, this.nativeVersion, this.forceNativeVersionCondition, this.dumpSupplier, this.providers, this.managerBuilderConsumer, this.onProtocolReload);
        }
    }
}

