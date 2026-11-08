/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.socks;

public enum SocksAddressType {
    IPv4(1),
    DOMAIN(3),
    IPv6(4),
    UNKNOWN(-1);

    private final byte b;

    private SocksAddressType(byte by) {
        this.b = by;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte by) {
        return SocksAddressType.valueOf(by);
    }

    public static SocksAddressType valueOf(byte by) {
        for (SocksAddressType socksAddressType : SocksAddressType.values()) {
            if (socksAddressType.b != by) continue;
            return socksAddressType;
        }
        return UNKNOWN;
    }

    public byte byteValue() {
        return this.b;
    }
}

