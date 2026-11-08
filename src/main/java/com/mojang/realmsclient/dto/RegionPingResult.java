/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

public class RegionPingResult {
    private String regionName;
    private int ping;

    public RegionPingResult(String string, int n) {
        this.regionName = string;
        this.ping = n;
    }

    public int ping() {
        return this.ping;
    }

    public String toString() {
        return String.format("%s --> %.2f ms", this.regionName, this.ping);
    }
}

