/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler;
import io.netty.util.AttributeKey;
import java.util.List;

public class WebSocketServerProtocolHandler
extends WebSocketProtocolHandler {
    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class.getName() + ".HANDSHAKER");
    private final String websocketPath;
    private final String subprotocols;
    private final boolean allowExtensions;
    private final int maxFramePayloadLength;

    public WebSocketServerProtocolHandler(String string) {
        this(string, null, false);
    }

    public WebSocketServerProtocolHandler(String string, String string2) {
        this(string, string2, false);
    }

    public WebSocketServerProtocolHandler(String string, String string2, boolean bl) {
        this(string, string2, bl, 65536);
    }

    public WebSocketServerProtocolHandler(String string, String string2, boolean bl, int n) {
        this.websocketPath = string;
        this.subprotocols = string2;
        this.allowExtensions = bl;
        this.maxFramePayloadLength = n;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipeline = channelHandlerContext.pipeline();
        if (channelPipeline.get(WebSocketServerProtocolHandshakeHandler.class) == null) {
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), WebSocketServerProtocolHandshakeHandler.class.getName(), new WebSocketServerProtocolHandshakeHandler(this.websocketPath, this.subprotocols, this.allowExtensions, this.maxFramePayloadLength));
        }
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof CloseWebSocketFrame) {
            WebSocketServerHandshaker webSocketServerHandshaker = WebSocketServerProtocolHandler.getHandshaker(channelHandlerContext);
            if (webSocketServerHandshaker != null) {
                webSocketFrame.retain();
                webSocketServerHandshaker.close(channelHandlerContext.channel(), (CloseWebSocketFrame)webSocketFrame);
            } else {
                channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
            }
            return;
        }
        super.decode(channelHandlerContext, webSocketFrame, list);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        if (throwable instanceof WebSocketHandshakeException) {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(throwable.getMessage().getBytes()));
            channelHandlerContext.channel().writeAndFlush(defaultFullHttpResponse).addListener(ChannelFutureListener.CLOSE);
        } else {
            channelHandlerContext.close();
        }
    }

    static WebSocketServerHandshaker getHandshaker(ChannelHandlerContext channelHandlerContext) {
        return channelHandlerContext.attr(HANDSHAKER_ATTR_KEY).get();
    }

    static void setHandshaker(ChannelHandlerContext channelHandlerContext, WebSocketServerHandshaker webSocketServerHandshaker) {
        channelHandlerContext.attr(HANDSHAKER_ATTR_KEY).set(webSocketServerHandshaker);
    }

    static ChannelHandler forbiddenHttpRequestResponder() {
        return new ChannelInboundHandlerAdapter(){

            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
                if (object instanceof FullHttpRequest) {
                    ((FullHttpRequest)object).release();
                    DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN);
                    channelHandlerContext.channel().writeAndFlush(defaultFullHttpResponse);
                } else {
                    channelHandlerContext.fireChannelRead(object);
                }
            }
        };
    }

    public static enum ServerHandshakeStateEvent {
        HANDSHAKE_COMPLETE;

    }
}

