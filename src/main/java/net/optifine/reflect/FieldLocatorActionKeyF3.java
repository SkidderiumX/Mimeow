/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Config;
import net.optifine.reflect.IFieldLocator;
import net.optifine.reflect.ReflectorRaw;

public class FieldLocatorActionKeyF3
implements IFieldLocator {
    @Override
    public Field getField() {
        Class<Minecraft> clazz = Minecraft.class;
        Field field = this.getFieldRenderChunksMany();
        if (field == null) {
            Config.log("(Reflector) Field not present: " + clazz.getName() + ".actionKeyF3 (field renderChunksMany not found)");
            return null;
        }
        Field field2 = ReflectorRaw.getFieldAfter(Minecraft.class, field, Boolean.TYPE, 0);
        if (field2 == null) {
            Config.log("(Reflector) Field not present: " + clazz.getName() + ".actionKeyF3");
            return null;
        }
        return field2;
    }

    private Field getFieldRenderChunksMany() {
        Minecraft minecraft = Minecraft.getMinecraft();
        boolean bl = minecraft.renderChunksMany;
        Field[] fieldArray = Minecraft.class.getDeclaredFields();
        minecraft.renderChunksMany = true;
        Field[] fieldArray2 = ReflectorRaw.getFields(minecraft, fieldArray, Boolean.TYPE, Boolean.TRUE);
        minecraft.renderChunksMany = false;
        Field[] fieldArray3 = ReflectorRaw.getFields(minecraft, fieldArray, Boolean.TYPE, Boolean.FALSE);
        minecraft.renderChunksMany = bl;
        HashSet<Field> hashSet = new HashSet<Field>(Arrays.asList(fieldArray2));
        HashSet<Field> hashSet2 = new HashSet<Field>(Arrays.asList(fieldArray3));
        HashSet<Field> hashSet3 = new HashSet<Field>(hashSet);
        hashSet3.retainAll(hashSet2);
        Field[] fieldArray4 = hashSet3.toArray(new Field[hashSet3.size()]);
        return fieldArray4.length != 1 ? null : fieldArray4[0];
    }
}

