/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import paulscode.sound.SimpleThread;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;

public class StreamThread
extends SimpleThread {
    private SoundSystemLogger logger;
    private List<Source> streamingSources;
    private final Object listLock = new Object();

    public StreamThread() {
        this.logger = SoundSystemConfig.getLogger();
        this.streamingSources = new LinkedList<Source>();
    }

    protected void cleanup() {
        this.kill();
        super.cleanup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        this.snooze(3600000L);
        while (!this.dying()) {
            while (!this.dying() && !this.streamingSources.isEmpty()) {
                Object object = this.listLock;
                synchronized (object) {
                    ListIterator<Source> listIterator2 = this.streamingSources.listIterator();
                    while (!this.dying() && listIterator2.hasNext()) {
                        Source source2 = listIterator2.next();
                        if (source2 == null) {
                            listIterator2.remove();
                            continue;
                        }
                        if (source2.stopped()) {
                            if (source2.rawDataStream) continue;
                            listIterator2.remove();
                            continue;
                        }
                        if (!source2.active()) {
                            if (source2.toLoop || source2.rawDataStream) {
                                source2.toPlay = true;
                            }
                            listIterator2.remove();
                            continue;
                        }
                        if (source2.paused()) continue;
                        source2.checkFadeOut();
                        if (source2.stream() || source2.rawDataStream || source2.channel != null && source2.channel.processBuffer()) continue;
                        if (source2.nextCodec == null) {
                            source2.readBuffersFromNextSoundInSequence();
                        }
                        if (source2.toLoop) {
                            if (source2.playing()) continue;
                            SoundSystemConfig.notifyEOS(source2.sourcename, source2.getSoundSequenceQueueSize());
                            if (source2.checkFadeOut()) {
                                source2.preLoad = true;
                                continue;
                            }
                            source2.incrementSoundSequence();
                            source2.preLoad = true;
                            continue;
                        }
                        if (source2.playing()) continue;
                        SoundSystemConfig.notifyEOS(source2.sourcename, source2.getSoundSequenceQueueSize());
                        if (source2.checkFadeOut()) continue;
                        if (source2.incrementSoundSequence()) {
                            source2.preLoad = true;
                            continue;
                        }
                        listIterator2.remove();
                    }
                }
                if (this.dying() || this.streamingSources.isEmpty()) continue;
                this.snooze(20L);
            }
            if (this.dying() || !this.streamingSources.isEmpty()) continue;
            this.snooze(3600000L);
        }
        this.cleanup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void watch(Source source2) {
        if (source2 == null) {
            return;
        }
        if (this.streamingSources.contains(source2)) {
            return;
        }
        Object object = this.listLock;
        synchronized (object) {
            ListIterator<Source> listIterator2 = this.streamingSources.listIterator();
            while (listIterator2.hasNext()) {
                Source source3 = listIterator2.next();
                if (source3 == null) {
                    listIterator2.remove();
                    continue;
                }
                if (source2.channel != source3.channel) continue;
                source3.stop();
                listIterator2.remove();
            }
            this.streamingSources.add(source2);
        }
    }

    private void message(String string) {
        this.logger.message(string, 0);
    }

    private void importantMessage(String string) {
        this.logger.importantMessage(string, 0);
    }

    private boolean errorCheck(boolean bl, String string) {
        return this.logger.errorCheck(bl, "StreamThread", string, 0);
    }

    private void errorMessage(String string) {
        this.logger.errorMessage("StreamThread", string, 0);
    }
}

