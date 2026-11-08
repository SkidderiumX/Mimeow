/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.dto;

public class PlayerInfo {
    private String name;
    private String uuid;
    private boolean operator = false;
    private boolean accepted = false;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String string) {
        this.uuid = string;
    }

    public boolean isOperator() {
        return this.operator;
    }

    public void setOperator(boolean bl) {
        this.operator = bl;
    }

    public boolean getAccepted() {
        return this.accepted;
    }

    public void setAccepted(boolean bl) {
        this.accepted = bl;
    }
}

