/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import keystrokesmod.oc502dfc7784;
import keystrokesmod.script.ScriptDefaults;
import keystrokesmod.script.ScriptManager;
import x.bb697955aafb5e4bf;
import x.oc2cf3d80e17;

public class SecureClassLoader
extends URLClassLoader {
    private static final List<String> WHITELISTED_PACKAGES;
    private static final Set<String> BLOCKED_CLASSES;

    public SecureClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        super(uRLArray, classLoader);
    }

    @Override
    protected Class<?> loadClass(String string, boolean bl) throws ClassNotFoundException {
        if (!this.isClassSafe(string)) {
            throw new ClassNotFoundException("Unsafe class detected: " + string);
        }
        return super.loadClass(string, bl);
    }

    private boolean isClassSafe(String string) {
        boolean bl = string.endsWith("Exception") || string.endsWith("Throwable");
        ScriptManager scriptManager = oc2cf3d80e17.\u013e != null ? oc2cf3d80e17.\u013e : oc502dfc7784.\u04a3;
        boolean bl2 = scriptManager != null && scriptManager.imports != null && scriptManager.imports.stream().anyMatch(string2 -> string.toLowerCase().startsWith(string2.toLowerCase()));
        boolean bl3 = string.startsWith("sc_") && !string.contains(".");
        boolean bl4 = WHITELISTED_PACKAGES.stream().anyMatch(string::startsWith);
        if (this.matchesClassOrNested(string, BLOCKED_CLASSES)) {
            return false;
        }
        return bl || bl2 || bl3 || bl4 || this.isFromClientCodeSource(string);
    }

    private boolean isFromClientCodeSource(String string) {
        try {
            Class<?> clazz = ((ClassLoader)((Object)bb697955aafb5e4bf.m8v5rf8mz8qy6("m8v5rf8mz8qy6", "xqYPNQAAmzBmWiPqIqTdA0cLj8Ghm1RYwNjP5hI8RsQAAAAABsY", -2887747334636956763L, (SecureClassLoader)this))).loadClass(string);
            CodeSource codeSource = ScriptDefaults.class.getProtectionDomain().getCodeSource();
            return codeSource != null && codeSource.equals(clazz.getProtectionDomain().getCodeSource());
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private boolean matchesClassOrNested(String string, Set<String> set) {
        for (String string2 : set) {
            if (!string.equals(string2) && !string.startsWith(string2 + "$")) continue;
            return true;
        }
        return false;
    }

    static {
        String[] stringArray = new String[0x5BD4BFE9 ^ 0x5BD4BFEF];
        stringArray[0] = "sun.reflect";
        stringArray[1] = "jdk.internal.reflect";
        stringArray[0x5BD4BFED ^ 0x5BD4BFEF] = "keystrokesmod";
        stringArray[0x5BD4BFEC ^ 0x5BD4BFEF] = "java.lang";
        stringArray[0x5BD4BFEB ^ 0x5BD4BFEF] = "java.util";
        stringArray[0x5BD4BFEA ^ 0x5BD4BFEF] = "java.awt";
        WHITELISTED_PACKAGES = Arrays.asList(stringArray);
        String[] stringArray2 = new String[0x5BD4BFFF ^ 0x5BD4BFEF];
        stringArray2[0] = "java.lang.Runtime";
        stringArray2[1] = "java.lang.Process";
        stringArray2[0x5BD4BFED ^ 0x5BD4BFEF] = "java.lang.ProcessBuilder";
        stringArray2[0x5BD4BFEC ^ 0x5BD4BFEF] = "java.lang.ProcessHandle";
        stringArray2[0x5BD4BFEB ^ 0x5BD4BFEF] = "java.lang.System";
        stringArray2[0x5BD4BFEA ^ 0x5BD4BFEF] = "java.lang.Class";
        stringArray2[0x5BD4BFE9 ^ 0x5BD4BFEF] = "java.lang.ClassLoader";
        stringArray2[0x5BD4BFE8 ^ 0x5BD4BFEF] = "java.lang.Thread";
        stringArray2[0x5BD4BFE7 ^ 0x5BD4BFEF] = "java.lang.ThreadGroup";
        stringArray2[0x5BD4BFE6 ^ 0x5BD4BFEF] = "java.lang.SecurityManager";
        stringArray2[0x5BD4BFE5 ^ 0x5BD4BFEF] = "java.lang.Compiler";
        stringArray2[0x5BD4BFE4 ^ 0x5BD4BFEF] = "java.lang.Package";
        stringArray2[0x5BD4BFE3 ^ 0x5BD4BFEF] = "java.lang.Module";
        stringArray2[0x5BD4BFE2 ^ 0x5BD4BFEF] = "java.awt.Desktop";
        stringArray2[0x5BD4BFE1 ^ 0x5BD4BFEF] = "java.awt.Robot";
        stringArray2[0x5BD4BFE0 ^ 0x5BD4BFEF] = "java.awt.Toolkit";
        BLOCKED_CLASSES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(stringArray2)));
    }
}

