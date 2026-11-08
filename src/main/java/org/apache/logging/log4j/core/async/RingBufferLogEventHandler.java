/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.async;

import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceReportingEventHandler;
import org.apache.logging.log4j.core.async.RingBufferLogEvent;

public class RingBufferLogEventHandler
implements SequenceReportingEventHandler<RingBufferLogEvent> {
    private static final int NOTIFY_PROGRESS_THRESHOLD = 50;
    private Sequence sequenceCallback;
    private int counter;

    public void setSequenceCallback(Sequence sequence2) {
        this.sequenceCallback = sequence2;
    }

    public void onEvent(RingBufferLogEvent ringBufferLogEvent, long l, boolean bl) throws Exception {
        ringBufferLogEvent.execute(bl);
        ringBufferLogEvent.clear();
        if (++this.counter > 50) {
            this.sequenceCallback.set(l);
            this.counter = 0;
        }
    }
}

