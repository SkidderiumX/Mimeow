/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN>
extends ChannelDuplexHandler {
    private final MessageToMessageEncoder<Object> encoder = new MessageToMessageEncoder<Object>(){

        @Override
        public boolean acceptOutboundMessage(Object object) throws Exception {
            return MessageToMessageCodec.this.acceptOutboundMessage(object);
        }

        @Override
        protected void encode(ChannelHandlerContext channelHandlerContext, Object object, List<Object> list) throws Exception {
            MessageToMessageCodec.this.encode(channelHandlerContext, object, list);
        }
    };
    private final MessageToMessageDecoder<Object> decoder = new MessageToMessageDecoder<Object>(){

        @Override
        public boolean acceptInboundMessage(Object object) throws Exception {
            return MessageToMessageCodec.this.acceptInboundMessage(object);
        }

        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, Object object, List<Object> list) throws Exception {
            MessageToMessageCodec.this.decode(channelHandlerContext, object, list);
        }
    };
    private final TypeParameterMatcher inboundMsgMatcher;
    private final TypeParameterMatcher outboundMsgMatcher;

    protected MessageToMessageCodec() {
        this.inboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "INBOUND_IN");
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "OUTBOUND_IN");
    }

    protected MessageToMessageCodec(Class<? extends INBOUND_IN> clazz, Class<? extends OUTBOUND_IN> clazz2) {
        this.inboundMsgMatcher = TypeParameterMatcher.get(clazz);
        this.outboundMsgMatcher = TypeParameterMatcher.get(clazz2);
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        this.decoder.channelRead(channelHandlerContext, object);
    }

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) throws Exception {
        this.encoder.write(channelHandlerContext, object, channelPromise);
    }

    public boolean acceptInboundMessage(Object object) throws Exception {
        return this.inboundMsgMatcher.match(object);
    }

    public boolean acceptOutboundMessage(Object object) throws Exception {
        return this.outboundMsgMatcher.match(object);
    }

    protected abstract void encode(ChannelHandlerContext var1, OUTBOUND_IN var2, List<Object> var3) throws Exception;

    protected abstract void decode(ChannelHandlerContext var1, INBOUND_IN var2, List<Object> var3) throws Exception;
}

