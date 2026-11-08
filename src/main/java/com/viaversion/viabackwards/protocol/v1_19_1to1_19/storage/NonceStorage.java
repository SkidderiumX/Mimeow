/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public record NonceStorage(byte[] nonce) implements StorableObject
{
}

