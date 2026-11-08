/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageDecoder<I>
extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    protected MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    protected MessageToMessageDecoder(Class<? extends I> clazz) {
        this.matcher = TypeParameterMatcher.get(clazz);
    }

    public boolean acceptInboundMessage(Object object) throws Exception {
        return this.matcher.match(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        block11: {
            RecyclableArrayList recyclableArrayList = RecyclableArrayList.newInstance();
            try {
                if (this.acceptInboundMessage(object)) {
                    Object object2 = object;
                    try {
                        this.decode(channelHandlerContext, object2, recyclableArrayList);
                        break block11;
                    }
                    finally {
                        ReferenceCountUtil.release(object2);
                    }
                }
                recyclableArrayList.add(object);
            }
            catch (DecoderException decoderException) {
                throw decoderException;
            }
            catch (Exception exception) {
                throw new DecoderException(exception);
            }
            finally {
                int n = recyclableArrayList.size();
                for (int i = 0; i < n; ++i) {
                    channelHandlerContext.fireChannelRead(recyclableArrayList.get(i));
                }
                recyclableArrayList.recycle();
            }
        }
    }

    protected abstract void decode(ChannelHandlerContext var1, I var2, List<Object> var3) throws Exception;
}

