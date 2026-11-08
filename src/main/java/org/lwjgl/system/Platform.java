/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.util.function.Function;
import java.util.regex.Pattern;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;

public enum Platform {
    FREEBSD("FreeBSD", "freebsd"){
        private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");

        @Override
        String mapLibraryName(String string) {
            if (this.SO.matcher(string).find()) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    }
    ,
    LINUX("Linux", "linux"){
        private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");

        @Override
        String mapLibraryName(String string) {
            if (this.SO.matcher(string).find()) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    }
    ,
    MACOSX("macOS", "macos"){
        private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");

        @Override
        String mapLibraryName(String string) {
            if (this.DYLIB.matcher(string).find()) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    }
    ,
    WINDOWS("Windows", "windows"){

        @Override
        String mapLibraryName(String string) {
            if (string.endsWith(".dll")) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    };

    private static final Platform current;
    private static final Function<String, String> bundledLibraryNameMapper;
    private static final Function<String, String> bundledLibraryPathMapper;
    private final String name;
    private final String nativePath;

    private Platform(String string2, String string3) {
        this.name = string2;
        this.nativePath = string3;
    }

    public String getName() {
        return this.name;
    }

    abstract String mapLibraryName(String var1);

    public static Platform get() {
        return current;
    }

    public static Architecture getArchitecture() {
        return Architecture.current;
    }

    public static String mapLibraryNameBundled(String string) {
        return bundledLibraryNameMapper.apply(string);
    }

    static String mapLibraryPathBundled(String string) {
        return bundledLibraryPathMapper.apply(string);
    }

    private static Function<String, String> getMapper(@Nullable Object object, Function<String, String> function, Function<String, String> function2) {
        if (object == null || "default".equals(object)) {
            return function;
        }
        if ("legacy".equals(object)) {
            return function2;
        }
        if (object instanceof Function) {
            return (Function)object;
        }
        String string = object.toString();
        try {
            return (Function)Class.forName(string).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Throwable throwable) {
            if (Checks.DEBUG) {
                throwable.printStackTrace(APIUtil.DEBUG_STREAM);
            }
            APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", string));
            return function;
        }
    }

    static {
        String string2 = System.getProperty("os.name");
        if (string2.startsWith("Windows")) {
            current = WINDOWS;
        } else if (string2.startsWith("FreeBSD")) {
            current = FREEBSD;
        } else if (string2.startsWith("Linux") || string2.startsWith("SunOS") || string2.startsWith("Unix")) {
            current = LINUX;
        } else if (string2.startsWith("Mac OS X") || string2.startsWith("Darwin")) {
            current = MACOSX;
        } else {
            throw new LinkageError("Unknown platform: " + string2);
        }
        bundledLibraryNameMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER.get("default"), string -> string, string -> Architecture.current.is64Bit ? string : string + "32");
        bundledLibraryPathMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER.get("default"), string -> Platform.current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + string, string -> string.substring(string.lastIndexOf(47)));
    }

    public static final class Architecture
    extends Enum<Architecture> {
        public static final /* enum */ Architecture X64;
        public static final /* enum */ Architecture X86;
        public static final /* enum */ Architecture ARM64;
        public static final /* enum */ Architecture ARM32;
        public static final /* enum */ Architecture PPC64LE;
        public static final /* enum */ Architecture RISCV64;
        static final Architecture current;
        final boolean is64Bit;
        private static final /* synthetic */ Architecture[] $VALUES;

        public static Architecture[] values() {
            return (Architecture[])$VALUES.clone();
        }

        public static Architecture valueOf(String string) {
            return Enum.valueOf(Architecture.class, string);
        }

        private Architecture(boolean bl) {
            this.is64Bit = bl;
        }

        static {
            boolean bl;
            X64 = new Architecture(true);
            X86 = new Architecture(false);
            ARM64 = new Architecture(true);
            ARM32 = new Architecture(false);
            PPC64LE = new Architecture(true);
            RISCV64 = new Architecture(true);
            $VALUES = new Architecture[]{X64, X86, ARM64, ARM32, PPC64LE, RISCV64};
            String string = System.getProperty("os.arch");
            boolean bl2 = bl = string.contains("64") || string.startsWith("armv8");
            if (string.startsWith("arm") || string.startsWith("aarch")) {
                current = bl ? ARM64 : ARM32;
            } else if (string.startsWith("ppc")) {
                if (!"ppc64le".equals(string)) {
                    throw new UnsupportedOperationException("Only PowerPC 64 LE is supported.");
                }
                current = PPC64LE;
            } else if (string.startsWith("riscv")) {
                if (!"riscv64".equals(string)) {
                    throw new UnsupportedOperationException("Only RISC-V 64 is supported.");
                }
                current = RISCV64;
            } else {
                current = bl ? X64 : X86;
            }
        }
    }
}

