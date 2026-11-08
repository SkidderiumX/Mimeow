/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import net.minecraft.client.renderer.GlStateManager;
import x.oc300d357d7b;

public class oc7969790760 {
    private final List<oc300d357d7b> \u04cb = new ArrayList<oc300d357d7b>();
    private static List<Object[]> \u00d6;

    private oc7969790760() {
    }

    public static oc7969790760 \u045e() {
        List<Object[]> list = \u00d6;
        if (list == null) {
            \u00d6 = list = oc7969790760.\u02e3();
        }
        oc7969790760 oc79697907602 = new oc7969790760();
        try {
            for (Object[] objectArray : list) {
                oc79697907602.\u04cb.add(new oc300d357d7b((Field)objectArray[0], objectArray[1]));
            }
            return oc79697907602;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new IllegalStateException("Cannot snapshot Minecraft's GL state cache", reflectiveOperationException);
        }
    }

    private static List<Object[]> \u02e3() {
        oc7969790760 oc79697907602 = new oc7969790760();
        Set<Object> set = Collections.newSetFromMap(new IdentityHashMap());
        try {
            for (Field field : GlStateManager.class.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                if (field.getType().isPrimitive()) {
                    if (Modifier.isFinal(field.getModifiers())) continue;
                    oc79697907602.\u04cb.add(new oc300d357d7b(field, null));
                    continue;
                }
                oc79697907602.\u043a(field.get(null), set);
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new IllegalStateException("Cannot snapshot Minecraft's GL state cache", reflectiveOperationException);
        }
        if (oc79697907602.\u04cb.isEmpty()) {
            throw new IllegalStateException("Minecraft's GL cache layout is unsupported");
        }
        ArrayList arrayList = new ArrayList(oc79697907602.\u04cb.size());
        for (oc300d357d7b oc300d357d7b2 : oc79697907602.\u04cb) {
            Object[] objectArray = new Object[0x78AD1623 ^ 0x78AD1621];
            objectArray[0] = oc300d357d7b2.\u0399;
            objectArray[1] = oc300d357d7b2.\u0165;
            arrayList.add(objectArray);
        }
        return arrayList;
    }

    private void \u043a(Object object, Set<Object> set) throws IllegalAccessException {
        block4: {
            Class<?> clazz;
            block5: {
                if (object == null || !set.add(object)) break block4;
                clazz = object.getClass();
                if (clazz.isArray()) break block5;
                if (!clazz.getName().startsWith(GlStateManager.class.getName() + "$")) break block4;
                for (Field field : clazz.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) continue;
                    field.setAccessible(true);
                    if (field.getType().isPrimitive()) {
                        if (Modifier.isFinal(field.getModifiers())) continue;
                        this.\u04cb.add(new oc300d357d7b(field, object));
                        continue;
                    }
                    this.\u043a(field.get(object), set);
                }
                break block4;
            }
            if (!clazz.getComponentType().isPrimitive()) {
                for (int i = 0; i < Array.getLength(object); ++i) {
                    this.\u043a(Array.get(object, i), set);
                }
            }
        }
    }

    public int \u04e6() {
        return this.\u04cb.size();
    }

    public void \u04fa() {
        try {
            for (oc300d357d7b oc300d357d7b2 : this.\u04cb) {
                oc300d357d7b2.\u00e2();
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Cannot restore Minecraft's GL state cache", illegalAccessException);
        }
    }
}

