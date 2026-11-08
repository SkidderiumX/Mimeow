/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.dump;

import java.util.Set;

public record VersionInfo(String javaVersion, String operatingSystem, int serverProtocol, String serverVersion, Set<String> enabledProtocols, String platformName, String platformVersion, String pluginVersion, String implementationVersion, Set<String> subPlatforms) {
}

