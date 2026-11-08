/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.dump;

import com.viaversion.viaversion.dump.VersionInfo;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.Map;

public record DumpTemplate(VersionInfo versionInfo, Map<String, Object> configuration, JsonObject platformDump, JsonObject injectionDump, JsonObject playerSample) {
}

