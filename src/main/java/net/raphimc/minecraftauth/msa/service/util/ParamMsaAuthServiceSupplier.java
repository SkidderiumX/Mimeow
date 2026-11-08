/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service.util;

import net.lenni0451.commons.httpclient.HttpClient;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;

@FunctionalInterface
public interface ParamMsaAuthServiceSupplier<T> {
    public MsaAuthService get(HttpClient var1, MsaApplicationConfig var2, T var3);
}

