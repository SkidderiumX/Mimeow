/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.profiler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.src.Config;
import net.optifine.Lagometer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import x.oc170ea29aae;

public class Profiler {
    private static final Logger logger = LogManager.getLogger();
    private final List<String> sectionList = Lists.newArrayList();
    private final List<Long> timestampList = Lists.newArrayList();
    public boolean profilingEnabled;
    private String profilingSection = "";
    private final Map<String, Long> profilingMap = Maps.newHashMap();
    public boolean profilerGlobalEnabled;
    private boolean profilerLocalEnabled = this.profilerGlobalEnabled = true;
    private static final String SCHEDULED_EXECUTABLES = "scheduledExecutables";
    private static final String TICK = "tick";
    private static final String PRE_RENDER_ERRORS = "preRenderErrors";
    private static final String RENDER = "render";
    private static final String DISPLAY = "display";
    private static final int HASH_SCHEDULED_EXECUTABLES = "scheduledExecutables".hashCode();
    private static final int HASH_TICK = "tick".hashCode();
    private static final int HASH_PRE_RENDER_ERRORS = "preRenderErrors".hashCode();
    private static final int HASH_RENDER = "render".hashCode();
    private static final int HASH_DISPLAY = "display".hashCode();

    public void clearProfiling() {
        this.profilingMap.clear();
        this.profilingSection = "";
        this.sectionList.clear();
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }

    public void startSection(String string) {
        int n;
        oc170ea29aae.\u0376(string);
        if (Lagometer.isActive()) {
            n = string.hashCode();
            if (n == HASH_SCHEDULED_EXECUTABLES && string.equals(SCHEDULED_EXECUTABLES)) {
                Lagometer.timerScheduledExecutables.start();
            } else if (n == HASH_TICK && string.equals(TICK) && Config.isMinecraftThread()) {
                Lagometer.timerScheduledExecutables.end();
                Lagometer.timerTick.start();
            } else if (n == HASH_PRE_RENDER_ERRORS && string.equals(PRE_RENDER_ERRORS)) {
                Lagometer.timerTick.end();
            }
        }
        if (Config.isFastRender()) {
            n = string.hashCode();
            if (n == HASH_RENDER && string.equals(RENDER)) {
                GlStateManager.clearEnabled = false;
            } else if (n == HASH_DISPLAY && string.equals(DISPLAY)) {
                GlStateManager.clearEnabled = true;
            }
        }
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            if (this.profilingSection.length() > 0) {
                this.profilingSection = this.profilingSection + ".";
            }
            this.profilingSection = this.profilingSection + string;
            this.sectionList.add(this.profilingSection);
            this.timestampList.add(System.nanoTime());
        }
    }

    public void endSection() {
        oc170ea29aae.\u011f();
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            long l = System.nanoTime();
            long l2 = this.timestampList.remove(this.timestampList.size() - 1);
            this.sectionList.remove(this.sectionList.size() - 1);
            long l3 = l - l2;
            if (this.profilingMap.containsKey(this.profilingSection)) {
                this.profilingMap.put(this.profilingSection, this.profilingMap.get(this.profilingSection) + l3);
            } else {
                this.profilingMap.put(this.profilingSection, l3);
            }
            if (l3 > 100000000L) {
                logger.warn("Something's taking too long! '" + this.profilingSection + "' took aprox " + (double)l3 / 1000000.0 + " ms");
            }
            this.profilingSection = !this.sectionList.isEmpty() ? this.sectionList.get(this.sectionList.size() - 1) : "";
        }
    }

    public List<Result> getProfilingData(String object) {
        if (!this.profilingEnabled) {
            return null;
        }
        long l = this.profilingMap.containsKey("root") ? this.profilingMap.get("root") : 0L;
        long l2 = this.profilingMap.containsKey(object) ? this.profilingMap.get(object) : -1L;
        ArrayList<Result> arrayList = Lists.newArrayList();
        if (((String)object).length() > 0) {
            object = (String)object + ".";
        }
        long l3 = 0L;
        for (String object2 : this.profilingMap.keySet()) {
            if (object2.length() <= ((String)object).length() || !object2.startsWith((String)object) || object2.indexOf(".", ((String)object).length() + 1) >= 0) continue;
            l3 += this.profilingMap.get(object2).longValue();
        }
        float f = l3;
        if (l3 < l2) {
            l3 = l2;
        }
        if (l < l3) {
            l = l3;
        }
        for (String string : this.profilingMap.keySet()) {
            if (string.length() <= ((String)object).length() || !string.startsWith((String)object) || string.indexOf(".", ((String)object).length() + 1) >= 0) continue;
            long l4 = this.profilingMap.get(string);
            double d = (double)l4 * 100.0 / (double)l3;
            double d2 = (double)l4 * 100.0 / (double)l;
            String string2 = string.substring(((String)object).length());
            arrayList.add(new Result(string2, d, d2));
        }
        for (String string : this.profilingMap.keySet()) {
            this.profilingMap.put(string, this.profilingMap.get(string) * 950L / 1000L);
        }
        if ((float)l3 > f) {
            arrayList.add(new Result("unspecified", (double)((float)l3 - f) * 100.0 / (double)l3, (double)((float)l3 - f) * 100.0 / (double)l));
        }
        Collections.sort(arrayList);
        arrayList.add(0, new Result((String)object, 100.0, (double)l3 * 100.0 / (double)l));
        return arrayList;
    }

    public void endStartSection(String string) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.startSection(string);
        } else {
            oc170ea29aae.\u011f();
            oc170ea29aae.\u0376(string);
        }
    }

    public String getNameOfLastSection() {
        return this.sectionList.size() == 0 ? "[UNKNOWN]" : this.sectionList.get(this.sectionList.size() - 1);
    }

    public void startSection(Class<?> clazz) {
        if (this.profilingEnabled) {
            this.startSection(clazz.getSimpleName());
        }
    }

    public static final class Result
    implements Comparable<Result> {
        public double field_76332_a;
        public double field_76330_b;
        public String field_76331_c;

        public Result(String string, double d, double d2) {
            this.field_76331_c = string;
            this.field_76332_a = d;
            this.field_76330_b = d2;
        }

        @Override
        public int compareTo(Result result) {
            return result.field_76332_a < this.field_76332_a ? -1 : (result.field_76332_a > this.field_76332_a ? 1 : result.field_76331_c.compareTo(this.field_76331_c));
        }

        public int getColor() {
            return (this.field_76331_c.hashCode() & 0xAAAAAA) + 0x444444;
        }
    }
}

