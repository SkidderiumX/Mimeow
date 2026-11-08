/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.cooldown;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.ViaRewindConfig;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.ActionBarVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.BossBarVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.DisabledCooldownVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.TitleCooldownVisualization;
import com.viaversion.viaversion.api.connection.UserConnection;

public interface CooldownVisualization {
    public static final int MAX_PROGRESS_TEXT_LENGTH = 10;

    public static String buildProgressText(String string, double d) {
        int n = (int)Math.floor(10.0 * d);
        int n2 = 10 - n;
        StringBuilder stringBuilder = new StringBuilder("\u00a78");
        while (n-- > 0) {
            stringBuilder.append(string);
        }
        stringBuilder.append("\u00a77");
        while (n2-- > 0) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public void show(double var1) throws Exception;

    public void hide() throws Exception;

    public static interface Factory {
        public static final Factory DISABLED = userConnection -> new DisabledCooldownVisualization();

        public static Factory fromConfiguration() {
            try {
                return Factory.fromIndicator(ViaRewind.getConfig().getCooldownIndicator());
            }
            catch (IllegalArgumentException illegalArgumentException) {
                ViaRewind.getPlatform().getLogger().warning("Invalid cooldown-indicator setting");
                return DISABLED;
            }
        }

        public static Factory fromIndicator(ViaRewindConfig.CooldownIndicator cooldownIndicator) {
            return switch (cooldownIndicator) {
                default -> throw new IncompatibleClassChangeError();
                case ViaRewindConfig.CooldownIndicator.TITLE -> TitleCooldownVisualization::new;
                case ViaRewindConfig.CooldownIndicator.BOSS_BAR -> BossBarVisualization::new;
                case ViaRewindConfig.CooldownIndicator.ACTION_BAR -> ActionBarVisualization::new;
                case ViaRewindConfig.CooldownIndicator.DISABLED -> DISABLED;
            };
        }

        public CooldownVisualization create(UserConnection var1);
    }
}

