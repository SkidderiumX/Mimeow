/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(name="Policies", category="Core", printObject=true)
public class CompositeTriggeringPolicy
implements TriggeringPolicy {
    private final TriggeringPolicy[] policies;

    private CompositeTriggeringPolicy(TriggeringPolicy ... triggeringPolicyArray) {
        this.policies = triggeringPolicyArray;
    }

    @Override
    public void initialize(RollingFileManager rollingFileManager) {
        for (TriggeringPolicy triggeringPolicy : this.policies) {
            triggeringPolicy.initialize(rollingFileManager);
        }
    }

    @Override
    public boolean isTriggeringEvent(LogEvent logEvent) {
        for (TriggeringPolicy triggeringPolicy : this.policies) {
            if (!triggeringPolicy.isTriggeringEvent(logEvent)) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CompositeTriggeringPolicy{");
        boolean bl = true;
        for (TriggeringPolicy triggeringPolicy : this.policies) {
            if (!bl) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(triggeringPolicy.toString());
            bl = false;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @PluginFactory
    public static CompositeTriggeringPolicy createPolicy(TriggeringPolicy ... triggeringPolicyArray) {
        return new CompositeTriggeringPolicy(triggeringPolicyArray);
    }
}

