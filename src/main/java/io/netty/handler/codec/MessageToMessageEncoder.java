package io.netty.handler.codec;

import io.netty.channel.*;
import io.netty.util.*;
import io.netty.util.internal.*;
import java.util.*;

public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter
{
    private final TypeParameterMatcher matcher;
    
    protected MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }
    
    protected MessageToMessageEncoder(final Class<? extends I> clazz) {
        this.matcher = TypeParameterMatcher.get(clazz);
    }
    
    public boolean acceptOutboundMessage(final Object o) throws Exception {
        return this.matcher.match(o);
    }
    
    @Override
    public void write(final ChannelHandlerContext channelHandlerContext, final Object o, final ChannelPromise channelPromise) throws Exception {
        ArrayList<Object> instance = null;
        try {
            if (this.acceptOutboundMessage(o)) {
                instance = RecyclableArrayList.newInstance();
                try {
                    this.encode(channelHandlerContext, o, instance);
                }
                finally {
                    ReferenceCountUtil.release(o);
                }
                if (instance.isEmpty()) {
                    ((RecyclableArrayList)instance).recycle();
                    instance = null;
                    throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                }
            }
            else {
                channelHandlerContext.write(o, channelPromise);
            }
        }
        catch (final EncoderException ex) {
            throw ex;
        }
        catch (final Throwable t) {
            throw new EncoderException(t);
        }
        finally {
            if (instance != null) {
                final int index = instance.size() - 1;
                if (index == 0) {
                    channelHandlerContext.write(instance.get(0), channelPromise);
                }
                else if (index > 0) {
                    final ChannelPromise voidPromise = channelHandlerContext.voidPromise();
                    final boolean b = channelPromise == voidPromise;
                    for (int i = 0; i < index; ++i) {
                        ChannelPromise promise;
                        if (b) {
                            promise = voidPromise;
                        }
                        else {
                            promise = channelHandlerContext.newPromise();
                        }
                        channelHandlerContext.write(instance.get(i), promise);
                    }
                    channelHandlerContext.write(instance.get(index), channelPromise);
                }
                ((RecyclableArrayList)instance).recycle();
            }
        }
    }
    
    protected abstract void encode(final ChannelHandlerContext p0, final I p1, final List<Object> p2) throws Exception;
}
