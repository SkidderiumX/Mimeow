/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import java.io.File;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverDescription;
import org.apache.logging.log4j.core.appender.rolling.RolloverDescriptionImpl;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;
import org.apache.logging.log4j.core.appender.rolling.helper.Action;
import org.apache.logging.log4j.core.appender.rolling.helper.FileRenameAction;
import org.apache.logging.log4j.core.appender.rolling.helper.GZCompressAction;
import org.apache.logging.log4j.core.appender.rolling.helper.ZipCompressAction;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Integers;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.status.StatusLogger;

@Plugin(name="DefaultRolloverStrategy", category="Core", printObject=true)
public class DefaultRolloverStrategy
implements RolloverStrategy {
    protected static final Logger LOGGER = StatusLogger.getLogger();
    private static final int MIN_WINDOW_SIZE = 1;
    private static final int DEFAULT_WINDOW_SIZE = 7;
    private final int maxIndex;
    private final int minIndex;
    private final boolean useMax;
    private final StrSubstitutor subst;
    private final int compressionLevel;

    protected DefaultRolloverStrategy(int n, int n2, boolean bl, int n3, StrSubstitutor strSubstitutor) {
        this.minIndex = n;
        this.maxIndex = n2;
        this.useMax = bl;
        this.compressionLevel = n3;
        this.subst = strSubstitutor;
    }

    @Override
    public RolloverDescription rollover(RollingFileManager rollingFileManager) throws SecurityException {
        if (this.maxIndex >= 0) {
            String string;
            int n = this.purge(this.minIndex, this.maxIndex, rollingFileManager);
            if (n < 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            rollingFileManager.getPatternProcessor().formatFileName(this.subst, stringBuilder, (Object)n);
            String string2 = rollingFileManager.getFileName();
            String string3 = string = stringBuilder.toString();
            AbstractAction abstractAction = null;
            if (string.endsWith(".gz")) {
                string = string.substring(0, string.length() - 3);
                abstractAction = new GZCompressAction(new File(string), new File(string3), true);
            } else if (string.endsWith(".zip")) {
                string = string.substring(0, string.length() - 4);
                abstractAction = new ZipCompressAction(new File(string), new File(string3), true, this.compressionLevel);
            }
            FileRenameAction fileRenameAction = new FileRenameAction(new File(string2), new File(string), false);
            return new RolloverDescriptionImpl(string2, false, fileRenameAction, abstractAction);
        }
        return null;
    }

    private int purge(int n, int n2, RollingFileManager rollingFileManager) {
        return this.useMax ? this.purgeAscending(n, n2, rollingFileManager) : this.purgeDescending(n, n2, rollingFileManager);
    }

    private int purgeDescending(int n, int n2, RollingFileManager rollingFileManager) {
        Object object;
        int n3;
        int n4 = 0;
        ArrayList<FileRenameAction> arrayList = new ArrayList<FileRenameAction>();
        StringBuilder stringBuilder = new StringBuilder();
        rollingFileManager.getPatternProcessor().formatFileName(stringBuilder, (Object)n);
        Object object2 = this.subst.replace(stringBuilder);
        if (((String)object2).endsWith(".gz")) {
            n4 = 3;
        } else if (((String)object2).endsWith(".zip")) {
            n4 = 4;
        }
        for (n3 = n; n3 <= n2; ++n3) {
            Object object3;
            object = new File((String)object2);
            boolean bl = false;
            if (n4 > 0) {
                object3 = new File(((String)object2).substring(0, ((String)object2).length() - n4));
                if (((File)object).exists()) {
                    if (((File)object3).exists()) {
                        ((File)object3).delete();
                    }
                } else {
                    object = object3;
                    bl = true;
                }
            }
            if (!((File)object).exists()) break;
            if (n3 == n2) {
                if (((File)object).delete()) break;
                return -1;
            }
            stringBuilder.setLength(0);
            rollingFileManager.getPatternProcessor().formatFileName(stringBuilder, (Object)(n3 + 1));
            Object object4 = object3 = this.subst.replace(stringBuilder);
            if (bl) {
                object4 = ((String)object3).substring(0, ((String)object3).length() - n4);
            }
            arrayList.add(new FileRenameAction((File)object, new File((String)object4), true));
            object2 = object3;
        }
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            object = (Action)arrayList.get(n3);
            try {
                if (object.execute()) continue;
                return -1;
            }
            catch (Exception exception) {
                LOGGER.warn("Exception during purge in RollingFileAppender", (Throwable)exception);
                return -1;
            }
        }
        return n;
    }

    private int purgeAscending(int n, int n2, RollingFileManager rollingFileManager) {
        Object object;
        int n3;
        int n4 = 0;
        ArrayList<FileRenameAction> arrayList = new ArrayList<FileRenameAction>();
        StringBuilder stringBuilder = new StringBuilder();
        rollingFileManager.getPatternProcessor().formatFileName(stringBuilder, (Object)n2);
        Object object2 = this.subst.replace(stringBuilder);
        if (((String)object2).endsWith(".gz")) {
            n4 = 3;
        } else if (((String)object2).endsWith(".zip")) {
            n4 = 4;
        }
        int n5 = 0;
        for (n3 = n2; n3 >= n; --n3) {
            Object object3;
            object = new File((String)object2);
            if (n3 == n2 && ((File)object).exists()) {
                n5 = n2;
            } else if (n5 == 0 && ((File)object).exists()) {
                n5 = n3 + 1;
                break;
            }
            boolean bl = false;
            if (n4 > 0) {
                object3 = new File(((String)object2).substring(0, ((String)object2).length() - n4));
                if (((File)object).exists()) {
                    if (((File)object3).exists()) {
                        ((File)object3).delete();
                    }
                } else {
                    object = object3;
                    bl = true;
                }
            }
            if (((File)object).exists()) {
                if (n3 == n) {
                    if (((File)object).delete()) break;
                    return -1;
                }
                stringBuilder.setLength(0);
                rollingFileManager.getPatternProcessor().formatFileName(stringBuilder, (Object)(n3 - 1));
                Object object4 = object3 = this.subst.replace(stringBuilder);
                if (bl) {
                    object4 = ((String)object3).substring(0, ((String)object3).length() - n4);
                }
                arrayList.add(new FileRenameAction((File)object, new File((String)object4), true));
                object2 = object3;
                continue;
            }
            stringBuilder.setLength(0);
            rollingFileManager.getPatternProcessor().formatFileName(stringBuilder, (Object)(n3 - 1));
            object2 = this.subst.replace(stringBuilder);
        }
        if (n5 == 0) {
            n5 = n;
        }
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            object = (Action)arrayList.get(n3);
            try {
                if (object.execute()) continue;
                return -1;
            }
            catch (Exception exception) {
                LOGGER.warn("Exception during purge in RollingFileAppender", (Throwable)exception);
                return -1;
            }
        }
        return n5;
    }

    public String toString() {
        return "DefaultRolloverStrategy(min=" + this.minIndex + ", max=" + this.maxIndex + ")";
    }

    @PluginFactory
    public static DefaultRolloverStrategy createStrategy(@PluginAttribute(value="max") String string, @PluginAttribute(value="min") String string2, @PluginAttribute(value="fileIndex") String string3, @PluginAttribute(value="compressionLevel") String string4, @PluginConfiguration Configuration configuration) {
        int n;
        int n2;
        boolean bl;
        boolean bl2 = bl = string3 == null ? true : string3.equalsIgnoreCase("max");
        if (string2 != null) {
            n2 = Integer.parseInt(string2);
            if (n2 < 1) {
                LOGGER.error("Minimum window size too small. Limited to 1");
                n2 = 1;
            }
        } else {
            n2 = 1;
        }
        if (string != null) {
            n = Integer.parseInt(string);
            if (n < n2) {
                n = n2 < 7 ? 7 : n2;
                LOGGER.error("Maximum window size must be greater than the minimum windows size. Set to " + n);
            }
        } else {
            n = 7;
        }
        int n3 = Integers.parseInt(string4, -1);
        return new DefaultRolloverStrategy(n2, n, bl, n3, configuration.getStrSubstitutor());
    }
}

