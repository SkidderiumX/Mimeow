/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import org.checkerframework.checker.nullness.qual.Nullable;

public record NonceStorage1_19_3(byte @Nullable [] nonce) implements StorableObject
{
}

