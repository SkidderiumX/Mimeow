/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Objects;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.jspecify.annotations.Nullable;
import org.lwjgl.VersionImpl;

public class Version {
    public static final int VERSION_MAJOR = 3;
    public static final int VERSION_MINOR = 3;
    public static final int VERSION_REVISION = 6;
    public static final BuildType BUILD_TYPE = BuildType.STABLE;
    private static final String versionPlain = String.valueOf(3) + '.' + 3 + '.' + 6 + Version.BUILD_TYPE.postfix;
    private static final String version = versionPlain + VersionImpl.find();

    private Version() {
    }

    public static void main(String[] stringArray) {
        System.out.println(version);
        System.err.println(versionPlain);
    }

    public static String getVersion() {
        return version;
    }

    static String createImplementation(String string, String string2) {
        String string3 = "+" + (string2.startsWith("build ") && 6 < string2.length() ? string2.substring(6) : string2);
        if (string.contains("SNAPSHOT") || string.contains("snapshot")) {
            return "-snapshot" + string3;
        }
        return string3;
    }

    static @Nullable String findImplementationFromManifest() {
        ClassLoader classLoader = Version.class.getClassLoader();
        URL uRL = classLoader.getResource("org/lwjgl/Version.class");
        if (uRL != null) {
            String string = uRL.toString();
            try {
                if (string.startsWith("jar:")) {
                    URL uRL2 = Version.class.getResource("/META-INF/MANIFEST.MF");
                    String string2 = Version.readImplementationFromManifest(Objects.requireNonNull(uRL2));
                    if (string2 != null) {
                        return string2;
                    }
                } else if (string.startsWith("resource:")) {
                    Enumeration<URL> enumeration = classLoader.getResources("META-INF/MANIFEST.MF");
                    while (enumeration.hasMoreElements()) {
                        String string3 = Version.readImplementationFromManifest(enumeration.nextElement());
                        if (string3 == null) continue;
                        return string3;
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static @Nullable String readImplementationFromManifest(URL uRL) {
        try (InputStream inputStream2 = uRL.openStream();){
            Attributes attributes = new Manifest(inputStream2).getMainAttributes();
            if (!"lwjgl".equals(attributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE))) {
                String string = null;
                return string;
            }
            if (!"lwjgl.org".equals(attributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR))) {
                String string = null;
                return string;
            }
            String string = attributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            String string2 = attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            if (string == null || string2 == null) {
                String string3 = null;
                return string3;
            }
            String string4 = Version.createImplementation(string, string2);
            return string4;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static enum BuildType {
        ALPHA("a"),
        BETA("b"),
        STABLE("");

        public final String postfix;

        private BuildType(String string2) {
            this.postfix = string2;
        }
    }
}

