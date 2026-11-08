/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.viamcp;

import com.viaversion.viabackwards.protocol.v1_17to1_16_4.Protocol1_17To1_16_4;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import de.florianmichael.viamcp.gui.AsyncVersionSlider;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ViaMCP {
    public static final int NATIVE_VERSION = 47;
    public static volatile ViaMCP INSTANCE;
    private final AtomicBoolean transactionFixInstalled = new AtomicBoolean();
    private AsyncVersionSlider asyncVersionSlider;

    private ViaMCP() {
        ViaLoadingBase.ViaLoadingBaseBuilder.create().runDirectory(new File("ViaMCP")).nativeVersion(47).build();
        this.installTransactionCompatibility();
    }

    public static synchronized ViaMCP create() {
        if (INSTANCE == null) {
            INSTANCE = new ViaMCP();
        }
        return INSTANCE;
    }

    public static ViaMCP getInstance() {
        return INSTANCE;
    }

    public static boolean isReady() {
        return INSTANCE != null && ViaLoadingBase.getInstance() != null;
    }

    public static boolean isTargetVersionAtLeast(ProtocolVersion protocolVersion) {
        ViaLoadingBase viaLoadingBase = ViaLoadingBase.getInstance();
        return viaLoadingBase != null && viaLoadingBase.getTargetVersion() != null && viaLoadingBase.getTargetVersion().newerThanOrEqualTo(protocolVersion);
    }

    public static boolean isTargetVersionNewerThanNative() {
        ViaLoadingBase viaLoadingBase = ViaLoadingBase.getInstance();
        return viaLoadingBase != null && viaLoadingBase.getTargetVersion() != null && viaLoadingBase.getTargetVersion().getVersion() != 47;
    }

    public void initAsyncSlider() {
        this.initAsyncSlider(5, 5, 110, 20);
    }

    public void initAsyncSlider(int n, int n2, int n3, int n4) {
        this.asyncVersionSlider = new AsyncVersionSlider(-1, n, n2, Math.max(n3, 110), n4);
    }

    public AsyncVersionSlider getAsyncVersionSlider() {
        return this.asyncVersionSlider;
    }

    private void installTransactionCompatibility() {
        ProtocolManager protocolManager = Via.getManager().getProtocolManager();
        Runnable runnable2 = () -> {
            if (!this.transactionFixInstalled.compareAndSet(false, true)) {
                return;
            }
            Protocol1_17To1_16_4 protocol1_17To1_16_4 = protocolManager.getProtocol(Protocol1_17To1_16_4.class);
            if (protocol1_17To1_16_4 == null) {
                this.transactionFixInstalled.set(false);
                ViaLoadingBase.LOGGER.warning("ViaBackwards 1.17 transaction protocol is unavailable");
                return;
            }
            protocol1_17To1_16_4.replaceClientbound(ClientboundPackets1_17.PING, packetWrapper -> packetWrapper.setPacketType(ClientboundPackets1_16_2.CONTAINER_ACK));
            protocol1_17To1_16_4.replaceServerbound(ServerboundPackets1_16_2.CONTAINER_ACK, packetWrapper -> packetWrapper.setPacketType(ServerboundPackets1_17.PONG));
            ViaLoadingBase.LOGGER.info("Installed the ViaMCP 1.17+ transaction bridge");
        };
        protocolManager.completeMappingDataLoading(Protocol1_17To1_16_4.class);
        runnable2.run();
    }
}

