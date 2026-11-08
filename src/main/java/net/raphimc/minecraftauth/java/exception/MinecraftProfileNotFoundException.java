/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.exception;

import net.raphimc.minecraftauth.java.exception.MinecraftServicesRequestException;

public class MinecraftProfileNotFoundException
extends MinecraftServicesRequestException {
    public MinecraftProfileNotFoundException(MinecraftServicesRequestException minecraftServicesRequestException) {
        super(minecraftServicesRequestException.getResponse(), minecraftServicesRequestException.getError(), "Your account doesn't have a Minecraft profile. Please log in to Minecraft and set up your profile.");
    }
}

