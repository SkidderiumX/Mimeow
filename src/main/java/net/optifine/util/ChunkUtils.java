/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorClass;
import net.optifine.reflect.ReflectorField;

public class ChunkUtils {
    private static ReflectorClass chunkClass = new ReflectorClass(Chunk.class);
    private static ReflectorField fieldHasEntities = ChunkUtils.findFieldHasEntities();
    private static ReflectorField fieldPrecipitationHeightMap = new ReflectorField(chunkClass, int[].class, 0);

    public static boolean hasEntities(Chunk chunk) {
        return Reflector.getFieldValueBoolean(chunk, fieldHasEntities, true);
    }

    public static int getPrecipitationHeight(Chunk chunk, BlockPos blockPos) {
        int[] nArray = (int[])Reflector.getFieldValue(chunk, fieldPrecipitationHeightMap);
        if (nArray != null && nArray.length == 256) {
            int n;
            int n2 = blockPos.getX() & 0xF;
            int n3 = n2 | (n = blockPos.getZ() & 0xF) << 4;
            int n4 = nArray[n3];
            if (n4 >= 0) {
                return n4;
            }
            BlockPos blockPos2 = chunk.getPrecipitationHeight(blockPos);
            return blockPos2.getY();
        }
        return -1;
    }

    private static ReflectorField findFieldHasEntities() {
        try {
            Field field;
            Field field3;
            Object object2;
            Chunk chunk = new Chunk(null, 0, 0);
            ArrayList arrayList = new ArrayList();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            Field[] fieldArray = Chunk.class.getDeclaredFields();
            for (int i = 0; i < fieldArray.length; ++i) {
                object2 = fieldArray[i];
                if (((Field)object2).getType() != Boolean.TYPE) continue;
                ((Field)object2).setAccessible(true);
                arrayList.add(object2);
                arrayList2.add(((Field)object2).get(chunk));
            }
            chunk.setHasEntities(false);
            ArrayList<Object> arrayList3 = new ArrayList<Object>();
            for (Object object3 : arrayList) {
                field3 = (Field)object3;
                arrayList3.add(field3.get(chunk));
            }
            chunk.setHasEntities(true);
            object2 = new ArrayList<Object>();
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                field = field3 = iterator2.next();
                object2.add(field.get(chunk));
            }
            ArrayList<Field> arrayList4 = new ArrayList<Field>();
            for (int i = 0; i < arrayList.size(); ++i) {
                field = (Field)arrayList.get(i);
                Boolean bl = (Boolean)arrayList3.get(i);
                Boolean bl2 = (Boolean)object2.get(i);
                if (bl.booleanValue() || !bl2.booleanValue()) continue;
                arrayList4.add(field);
                Boolean bl3 = (Boolean)arrayList2.get(i);
                field.set(chunk, bl3);
            }
            if (arrayList4.size() == 1) {
                Field field2 = (Field)arrayList4.get(0);
                return new ReflectorField(field2);
            }
        }
        catch (Exception exception) {
            Config.warn(exception.getClass().getName() + " " + exception.getMessage());
        }
        Config.warn("Error finding Chunk.hasEntities");
        return new ReflectorField(new ReflectorClass(Chunk.class), "hasEntities");
    }
}

