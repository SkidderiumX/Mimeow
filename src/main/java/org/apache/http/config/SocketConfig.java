/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.config;

import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class SocketConfig
implements Cloneable {
    public static final SocketConfig DEFAULT = new Builder().build();
    private final int soTimeout;
    private final boolean soReuseAddress;
    private final int soLinger;
    private final boolean soKeepAlive;
    private final boolean tcpNoDelay;

    SocketConfig(int n, boolean bl, int n2, boolean bl2, boolean bl3) {
        this.soTimeout = n;
        this.soReuseAddress = bl;
        this.soLinger = n2;
        this.soKeepAlive = bl2;
        this.tcpNoDelay = bl3;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    protected SocketConfig clone() throws CloneNotSupportedException {
        return (SocketConfig)super.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append("]");
        return stringBuilder.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay());
    }

    public static class Builder {
        private int soTimeout;
        private boolean soReuseAddress;
        private int soLinger = -1;
        private boolean soKeepAlive;
        private boolean tcpNoDelay = true;

        Builder() {
        }

        public Builder setSoTimeout(int n) {
            this.soTimeout = n;
            return this;
        }

        public Builder setSoReuseAddress(boolean bl) {
            this.soReuseAddress = bl;
            return this;
        }

        public Builder setSoLinger(int n) {
            this.soLinger = n;
            return this;
        }

        public Builder setSoKeepAlive(boolean bl) {
            this.soKeepAlive = bl;
            return this;
        }

        public Builder setTcpNoDelay(boolean bl) {
            this.tcpNoDelay = bl;
            return this;
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay);
        }
    }
}

