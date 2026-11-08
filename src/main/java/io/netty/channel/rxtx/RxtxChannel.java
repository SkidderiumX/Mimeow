/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.rxtx;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.rxtx.DefaultRxtxChannelConfig;
import io.netty.channel.rxtx.RxtxChannelConfig;
import io.netty.channel.rxtx.RxtxChannelOption;
import io.netty.channel.rxtx.RxtxDeviceAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

public class RxtxChannel
extends OioByteStreamChannel {
    private static final RxtxDeviceAddress LOCAL_ADDRESS = new RxtxDeviceAddress("localhost");
    private final RxtxChannelConfig config = new DefaultRxtxChannelConfig(this);
    private boolean open = true;
    private RxtxDeviceAddress deviceAddress;
    private SerialPort serialPort;

    public RxtxChannel() {
        super(null);
    }

    @Override
    public RxtxChannelConfig config() {
        return this.config;
    }

    @Override
    public boolean isOpen() {
        return this.open;
    }

    @Override
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new RxtxUnsafe();
    }

    @Override
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        RxtxDeviceAddress rxtxDeviceAddress = (RxtxDeviceAddress)socketAddress;
        CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier((String)rxtxDeviceAddress.value());
        CommPort commPort = commPortIdentifier.open(this.getClass().getName(), 1000);
        commPort.enableReceiveTimeout(this.config().getOption(RxtxChannelOption.READ_TIMEOUT).intValue());
        this.deviceAddress = rxtxDeviceAddress;
        this.serialPort = (SerialPort)commPort;
    }

    protected void doInit() throws Exception {
        this.serialPort.setSerialPortParams(this.config().getOption(RxtxChannelOption.BAUD_RATE).intValue(), this.config().getOption(RxtxChannelOption.DATA_BITS).value(), this.config().getOption(RxtxChannelOption.STOP_BITS).value(), this.config().getOption(RxtxChannelOption.PARITY_BIT).value());
        this.serialPort.setDTR(this.config().getOption(RxtxChannelOption.DTR).booleanValue());
        this.serialPort.setRTS(this.config().getOption(RxtxChannelOption.RTS).booleanValue());
        this.activate(this.serialPort.getInputStream(), this.serialPort.getOutputStream());
    }

    @Override
    public RxtxDeviceAddress localAddress() {
        return (RxtxDeviceAddress)super.localAddress();
    }

    @Override
    public RxtxDeviceAddress remoteAddress() {
        return (RxtxDeviceAddress)super.remoteAddress();
    }

    @Override
    protected RxtxDeviceAddress localAddress0() {
        return LOCAL_ADDRESS;
    }

    @Override
    protected RxtxDeviceAddress remoteAddress0() {
        return this.deviceAddress;
    }

    @Override
    protected void doBind(SocketAddress socketAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDisconnect() throws Exception {
        this.doClose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void doClose() throws Exception {
        this.open = false;
        try {
            super.doClose();
        }
        finally {
            if (this.serialPort != null) {
                this.serialPort.removeEventListener();
                this.serialPort.close();
                this.serialPort = null;
            }
        }
    }

    private final class RxtxUnsafe
    extends AbstractChannel.AbstractUnsafe {
        private RxtxUnsafe() {
            super(RxtxChannel.this);
        }

        @Override
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable() || !this.ensureOpen(channelPromise)) {
                return;
            }
            try {
                final boolean bl = RxtxChannel.this.isActive();
                RxtxChannel.this.doConnect(socketAddress, socketAddress2);
                int n = RxtxChannel.this.config().getOption(RxtxChannelOption.WAIT_TIME);
                if (n > 0) {
                    RxtxChannel.this.eventLoop().schedule(new Runnable(){

                        @Override
                        public void run() {
                            try {
                                RxtxChannel.this.doInit();
                                RxtxUnsafe.this.safeSetSuccess(channelPromise);
                                if (!bl && RxtxChannel.this.isActive()) {
                                    RxtxChannel.this.pipeline().fireChannelActive();
                                }
                            }
                            catch (Throwable throwable) {
                                RxtxUnsafe.this.safeSetFailure(channelPromise, throwable);
                                RxtxUnsafe.this.closeIfClosed();
                            }
                        }
                    }, (long)n, TimeUnit.MILLISECONDS);
                } else {
                    RxtxChannel.this.doInit();
                    this.safeSetSuccess(channelPromise);
                    if (!bl && RxtxChannel.this.isActive()) {
                        RxtxChannel.this.pipeline().fireChannelActive();
                    }
                }
            }
            catch (Throwable throwable) {
                this.safeSetFailure(channelPromise, throwable);
                this.closeIfClosed();
            }
        }
    }
}

