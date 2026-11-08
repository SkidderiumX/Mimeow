/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.platform;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.platform.ViaInjector;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.platform.WrappedChannelInitializer;
import com.viaversion.viaversion.util.Pair;
import com.viaversion.viaversion.util.ReflectionUtil;
import com.viaversion.viaversion.util.SynchronizedListWrapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class LegacyViaInjector
implements ViaInjector {
    protected final List<ChannelFuture> injectedFutures = new ArrayList<ChannelFuture>();
    protected final List<Pair<Field, Object>> injectedLists = new ArrayList<Pair<Field, Object>>();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void inject() throws ReflectiveOperationException {
        Object object2 = this.getServerConnection();
        if (object2 == null) {
            throw new RuntimeException("Failed to find the core component 'ServerConnection'");
        }
        for (Field field : object2.getClass().getDeclaredFields()) {
            if (!List.class.isAssignableFrom(field.getType()) || !field.getGenericType().getTypeName().contains(ChannelFuture.class.getName())) continue;
            field.setAccessible(true);
            List list = (List)field.get(object2);
            SynchronizedListWrapper<Object> synchronizedListWrapper = new SynchronizedListWrapper<Object>(list, object -> {
                try {
                    this.injectChannelFuture((ChannelFuture)object);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    throw new RuntimeException(reflectiveOperationException);
                }
            });
            List list2 = list;
            synchronized (list2) {
                for (ChannelFuture channelFuture : list) {
                    this.injectChannelFuture(channelFuture);
                }
                field.set(object2, synchronizedListWrapper);
            }
            this.injectedLists.add(new Pair<Field, Object>(field, object2));
        }
    }

    private void injectChannelFuture(ChannelFuture channelFuture) throws ReflectiveOperationException {
        List<String> list = channelFuture.channel().pipeline().names();
        ChannelHandler channelHandler = null;
        for (String string : list) {
            ChannelHandler channelHandler2 = channelFuture.channel().pipeline().get(string);
            try {
                ReflectionUtil.get(channelHandler2, "childHandler", ChannelInitializer.class);
                channelHandler = channelHandler2;
                break;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
            }
        }
        if (channelHandler == null) {
            channelHandler = channelFuture.channel().pipeline().first();
        }
        try {
            ChannelInitializer channelInitializer = ReflectionUtil.get(channelHandler, "childHandler", ChannelInitializer.class);
            ReflectionUtil.set(channelHandler, "childHandler", this.createChannelInitializer(channelInitializer));
            this.injectedFutures.add(channelFuture);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.blame(channelHandler);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void uninject() throws ReflectiveOperationException {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        for (ChannelFuture object5 : this.injectedFutures) {
            object4 = object5.channel().pipeline();
            object3 = object4.first();
            if (object3 == null) {
                Via.getPlatform().getLogger().info("Empty pipeline, nothing to uninject");
                continue;
            }
            object2 = object4.names().iterator();
            while (object2.hasNext()) {
                object = object2.next();
                ChannelHandler channelHandler = object4.get((String)object);
                if (channelHandler == null) {
                    Via.getPlatform().getLogger().warning("Could not get handler " + (String)object);
                    continue;
                }
                try {
                    if (!(ReflectionUtil.get(channelHandler, "childHandler", ChannelInitializer.class) instanceof WrappedChannelInitializer)) continue;
                    object3 = channelHandler;
                    break;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                }
            }
            try {
                object2 = ReflectionUtil.get(object3, "childHandler", ChannelInitializer.class);
                if (!(object2 instanceof WrappedChannelInitializer)) continue;
                object = (WrappedChannelInitializer)object2;
                ReflectionUtil.set(object3, "childHandler", object.original());
            }
            catch (Exception exception) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Failed to remove injection handler, reload won't work with connections, please reboot!", exception);
            }
        }
        this.injectedFutures.clear();
        for (Pair pair : this.injectedLists) {
            try {
                object4 = (Field)pair.key();
                object3 = ((Field)object4).get(pair.value());
                if (!(object3 instanceof SynchronizedListWrapper)) continue;
                object = object2 = ((SynchronizedListWrapper)object3).originalList();
                synchronized (object) {
                    ((Field)object4).set(pair.value(), object2);
                }
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Via.getPlatform().getLogger().severe("Failed to remove injection, reload won't work with connections, please reboot!");
            }
        }
        this.injectedLists.clear();
    }

    @Override
    public boolean lateProtocolVersionSetting() {
        return true;
    }

    @Override
    public JsonObject getDump() {
        Object object;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("injectedChannelInitializers", jsonArray);
        for (ChannelFuture object22 : this.injectedFutures) {
            JsonObject reflectiveOperationException = new JsonObject();
            jsonArray.add(reflectiveOperationException);
            reflectiveOperationException.addProperty("futureClass", object22.getClass().getName());
            reflectiveOperationException.addProperty("channelClass", object22.channel().getClass().getName());
            JsonArray jsonArray2 = new JsonArray();
            reflectiveOperationException.add("pipeline", jsonArray2);
            for (String string : object22.channel().pipeline().names()) {
                object = new JsonObject();
                jsonArray2.add((JsonElement)object);
                ((JsonObject)object).addProperty("name", string);
                ChannelHandler channelHandler = object22.channel().pipeline().get(string);
                if (channelHandler == null) {
                    ((JsonObject)object).addProperty("status", "INVALID");
                    continue;
                }
                ((JsonObject)object).addProperty("class", channelHandler.getClass().getName());
                try {
                    ChannelInitializer channelInitializer = ReflectionUtil.get(channelHandler, "childHandler", ChannelInitializer.class);
                    ((JsonObject)object).addProperty("childClass", channelInitializer.getClass().getName());
                    if (!(channelInitializer instanceof WrappedChannelInitializer)) continue;
                    WrappedChannelInitializer wrappedChannelInitializer = (WrappedChannelInitializer)((Object)channelInitializer);
                    ((JsonObject)object).addProperty("oldInit", wrappedChannelInitializer.original().getClass().getName());
                }
                catch (ReflectiveOperationException reflectiveOperationException2) {}
            }
        }
        JsonObject jsonObject3 = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        try {
            for (Pair pair : this.injectedLists) {
                Field field = (Field)pair.key();
                Object object2 = field.get(pair.value());
                jsonObject2.addProperty(field.getName(), object2.getClass().getName());
                if (!(object2 instanceof SynchronizedListWrapper)) continue;
                object = (SynchronizedListWrapper)object2;
                jsonObject3.addProperty(field.getName(), ((SynchronizedListWrapper)object).originalList().getClass().getName());
            }
            jsonObject.add("wrappedLists", jsonObject3);
            jsonObject.add("currentLists", jsonObject2);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
        return jsonObject;
    }

    protected abstract @Nullable Object getServerConnection() throws ReflectiveOperationException;

    protected abstract WrappedChannelInitializer createChannelInitializer(ChannelInitializer<Channel> var1);

    protected abstract void blame(ChannelHandler var1) throws ReflectiveOperationException;
}

