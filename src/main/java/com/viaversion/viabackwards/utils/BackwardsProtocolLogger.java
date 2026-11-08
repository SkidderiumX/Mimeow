/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.utils;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.util.ProtocolLogger;

public class BackwardsProtocolLogger
extends ProtocolLogger {
    public BackwardsProtocolLogger(Class<? extends Protocol> clazz) {
        super(ViaBackwards.getPlatform().getLogger(), clazz);
    }
}

