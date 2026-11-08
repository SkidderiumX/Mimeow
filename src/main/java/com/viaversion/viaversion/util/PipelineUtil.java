/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PipelineUtil {
    private static final MethodHandle DECODE_METHOD = PipelineUtil.privateHandleUnchecked(ByteToMessageDecoder.class, "decode", ChannelHandlerContext.class, ByteBuf.class, List.class);
    private static final MethodHandle ENCODE_METHOD = PipelineUtil.privateHandleUnchecked(MessageToByteEncoder.class, "encode", ChannelHandlerContext.class, Object.class, ByteBuf.class);
    private static final MethodHandle MTM_DECODE = PipelineUtil.privateHandleUnchecked(MessageToMessageDecoder.class, "decode", ChannelHandlerContext.class, Object.class, List.class);

    public static List<Object> callDecode(ByteToMessageDecoder byteToMessageDecoder, ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        try {
            DECODE_METHOD.invoke(byteToMessageDecoder, channelHandlerContext, object, arrayList);
        }
        catch (Error | Exception throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        return arrayList;
    }

    public static void callEncode(MessageToByteEncoder messageToByteEncoder, ChannelHandlerContext channelHandlerContext, Object object, ByteBuf byteBuf) throws Exception {
        try {
            ENCODE_METHOD.invoke(messageToByteEncoder, channelHandlerContext, object, byteBuf);
        }
        catch (Error | Exception throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    public static List<Object> callDecode(MessageToMessageDecoder messageToMessageDecoder, ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        try {
            MTM_DECODE.invoke(messageToMessageDecoder, channelHandlerContext, object, arrayList);
        }
        catch (Error | Exception throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        return arrayList;
    }

    public static boolean containsCause(Throwable throwable, Class<?> clazz) {
        do {
            if (!clazz.isAssignableFrom(throwable.getClass())) continue;
            return true;
        } while ((throwable = throwable.getCause()) != null);
        return false;
    }

    public static <T> @Nullable T getCause(Throwable throwable, Class<T> clazz) {
        while (throwable != null) {
            if (clazz.isAssignableFrom(throwable.getClass())) {
                return (T)throwable;
            }
            throwable = throwable.getCause();
        }
        return null;
    }

    public static @Nullable ChannelHandlerContext getContextBefore(String string, ChannelPipeline channelPipeline) {
        boolean bl = false;
        for (String string2 : channelPipeline.names()) {
            if (bl) {
                return channelPipeline.context(channelPipeline.get(string2));
            }
            if (!string2.equalsIgnoreCase(string)) continue;
            bl = true;
        }
        return null;
    }

    public static @Nullable ChannelHandlerContext getPreviousContext(String string, ChannelPipeline channelPipeline) {
        String string2 = null;
        for (String string3 : channelPipeline.toMap().keySet()) {
            if (string3.equals(string)) {
                return channelPipeline.context(string2);
            }
            string2 = string3;
        }
        return null;
    }

    private static MethodHandle privateHandle(Class<?> clazz, String string, Class<?> ... classArray) throws NoSuchMethodException, IllegalAccessException {
        Method method = clazz.getDeclaredMethod(string, classArray);
        method.setAccessible(true);
        return MethodHandles.lookup().unreflect(method);
    }

    private static MethodHandle privateHandleUnchecked(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            return PipelineUtil.privateHandle(clazz, string, classArray);
        }
        catch (IllegalAccessException | NoSuchMethodException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }
}

