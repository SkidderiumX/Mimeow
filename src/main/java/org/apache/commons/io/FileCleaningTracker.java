/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.io.FileDeleteStrategy;

public class FileCleaningTracker {
    ReferenceQueue<Object> q = new ReferenceQueue();
    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet());
    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
    volatile boolean exitWhenFinished = false;
    Thread reaper;

    public void track(File file, Object object) {
        this.track(file, object, (FileDeleteStrategy)null);
    }

    public void track(File file, Object object, FileDeleteStrategy fileDeleteStrategy) {
        if (file == null) {
            throw new NullPointerException("The file must not be null");
        }
        this.addTracker(file.getPath(), object, fileDeleteStrategy);
    }

    public void track(String string, Object object) {
        this.track(string, object, (FileDeleteStrategy)null);
    }

    public void track(String string, Object object, FileDeleteStrategy fileDeleteStrategy) {
        if (string == null) {
            throw new NullPointerException("The path must not be null");
        }
        this.addTracker(string, object, fileDeleteStrategy);
    }

    private synchronized void addTracker(String string, Object object, FileDeleteStrategy fileDeleteStrategy) {
        if (this.exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (this.reaper == null) {
            this.reaper = new Reaper();
            this.reaper.start();
        }
        this.trackers.add(new Tracker(string, fileDeleteStrategy, object, this.q));
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public List<String> getDeleteFailures() {
        return this.deleteFailures;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        if (this.reaper != null) {
            Thread thread2 = this.reaper;
            synchronized (thread2) {
                this.reaper.interrupt();
            }
        }
    }

    private static final class Tracker
    extends PhantomReference<Object> {
        private final String path;
        private final FileDeleteStrategy deleteStrategy;

        Tracker(String string, FileDeleteStrategy fileDeleteStrategy, Object object, ReferenceQueue<? super Object> referenceQueue) {
            super(object, referenceQueue);
            this.path = string;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public String getPath() {
            return this.path;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }

    private final class Reaper
    extends Thread {
        Reaper() {
            super("File Reaper");
            this.setPriority(10);
            this.setDaemon(true);
        }

        @Override
        public void run() {
            while (!FileCleaningTracker.this.exitWhenFinished || FileCleaningTracker.this.trackers.size() > 0) {
                try {
                    Tracker tracker = (Tracker)FileCleaningTracker.this.q.remove();
                    FileCleaningTracker.this.trackers.remove(tracker);
                    if (!tracker.delete()) {
                        FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
                    }
                    tracker.clear();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }
}

