/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;

public record LastDeathPosition(GlobalBlockPosition position) implements StorableObject
{
}

