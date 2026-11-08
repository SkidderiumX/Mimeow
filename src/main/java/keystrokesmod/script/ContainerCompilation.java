/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.lang.reflect.InvocationTargetException;
import javax.tools.JavaFileManager;
import javax.tools.StandardJavaFileManager;

public class ContainerCompilation {
    private ContainerCompilation() {
    }

    public static JavaFileManager fileManager(StandardJavaFileManager standardJavaFileManager, ClassLoader classLoader) {
        try {
            return (JavaFileManager)classLoader.getClass().getMethod("compilerFileManager", StandardJavaFileManager.class).invoke(classLoader, standardJavaFileManager);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return standardJavaFileManager;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new IllegalStateException("Unable to access script classpath", reflectiveOperationException);
        }
    }
}

