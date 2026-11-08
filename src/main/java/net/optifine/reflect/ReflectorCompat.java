/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.reflect;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.optifine.reflect.Reflector;

public class ReflectorCompat {
    public static Object EVENT_RESULT_ALLOW = Reflector.getFieldValue(Reflector.Event_Result_ALLOW);
    public static Object EVENT_RESULT_DENY = Reflector.getFieldValue(Reflector.Event_Result_DENY);
    public static Object EVENT_RESULT_DEFAULT = Reflector.getFieldValue(Reflector.Event_Result_DEFAULT);

    public static void OptionalLoaderClientHandler_trackBrokenTexture(ResourceLocation resourceLocation, String string) {
        if (!Reflector.OptionalLoaderClientHandler_trackBrokenTexture.exists()) {
            Object object = Reflector.call(Reflector.OptionalLoaderClientHandler_instance, new Object[0]);
            Reflector.call(object, Reflector.OptionalLoaderClientHandler_trackBrokenTexture, resourceLocation, string);
        }
    }

    public static void OptionalLoaderClientHandler_trackMissingTexture(ResourceLocation resourceLocation) {
        if (!Reflector.OptionalLoaderClientHandler_trackMissingTexture.exists()) {
            Object object = Reflector.call(Reflector.OptionalLoaderClientHandler_instance, new Object[0]);
            Reflector.call(object, Reflector.OptionalLoaderClientHandler_trackMissingTexture, resourceLocation);
        }
    }

    public static void putLaunchBlackboard(String string, Object object) {
        Map map = (Map)Reflector.getFieldValue(Reflector.Launch_blackboard);
        if (map != null) {
            map.put(string, object);
        }
    }

    public static boolean renderFirstPersonHand(RenderGlobal renderGlobal, float f, int n) {
        return !Reflector.CompatHooksClient_renderFirstPersonHand.exists() ? false : Reflector.callBoolean(Reflector.CompatHooksClient_renderFirstPersonHand, renderGlobal, Float.valueOf(f), n);
    }

    public static InputStream getOptiFineResourceStream(String string) {
        byte[] byArray;
        if (!Reflector.OptiFineClassTransformer_instance.exists()) {
            return null;
        }
        Object object = Reflector.getFieldValue(Reflector.OptiFineClassTransformer_instance);
        if (object == null) {
            return null;
        }
        if (string.startsWith("/")) {
            string = string.substring(1);
        }
        if ((byArray = (byte[])Reflector.call(object, Reflector.OptiFineClassTransformer_getOptiFineResource, string)) == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }

    public static boolean blockHasTileEntity(IBlockState iBlockState) {
        Block block = iBlockState.getBlock();
        return !Reflector.CompatBlock_hasTileEntity.exists() ? block.hasTileEntity() : Reflector.callBoolean(block, Reflector.CompatBlock_hasTileEntity, iBlockState);
    }

    public static boolean isItemDamaged(ItemStack itemStack) {
        return !Reflector.CompatItem_showDurabilityBar.exists() ? itemStack.isItemDamaged() : Reflector.callBoolean(itemStack.getItem(), Reflector.CompatItem_showDurabilityBar, itemStack);
    }

    public static boolean armorHasOverlay(ItemArmor itemArmor, ItemStack itemStack) {
        int n = itemArmor.getColor(itemStack);
        return n != -1;
    }

    public static MapData getMapData(ItemMap itemMap, ItemStack itemStack, World world2) {
        return Reflector.CompatHooksClient.exists() ? ((ItemMap)itemStack.getItem()).getMapData(itemStack, world2) : itemMap.getMapData(itemStack, world2);
    }

    public static String[] getCompatModIds() {
        if (!Reflector.Loader.exists()) {
            return new String[0];
        }
        Object object = Reflector.call(Reflector.Loader_instance, new Object[0]);
        List list = (List)Reflector.call(object, Reflector.Loader_getActiveModList, new Object[0]);
        if (list == null) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Object e : list) {
            String string;
            if (!Reflector.ModContainer.isInstance(e) || (string = Reflector.callString(e, Reflector.ModContainer_getModId, new Object[0])) == null) continue;
            arrayList.add(string);
        }
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    public static boolean canEntitySpawn(EntityLiving entityLiving, World world2, float f, float f2, float f3) {
        Object object = Reflector.call(Reflector.CompatEventFactory_canEntitySpawn, entityLiving, world2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
        return object == EVENT_RESULT_ALLOW || object == EVENT_RESULT_DEFAULT && entityLiving.getCanSpawnHere() && entityLiving.isNotColliding();
    }

    public static boolean doSpecialSpawn(EntityLiving entityLiving, World world2, float f, int n, float f2) {
        return Reflector.CompatEventFactory_doSpecialSpawn.exists() ? Reflector.callBoolean(Reflector.CompatEventFactory_doSpecialSpawn, entityLiving, world2, Float.valueOf(f), n, Float.valueOf(f2)) : false;
    }
}

