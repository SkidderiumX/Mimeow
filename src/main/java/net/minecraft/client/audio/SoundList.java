/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.audio;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.audio.SoundCategory;

public class SoundList {
    private final List<SoundEntry> soundList = Lists.newArrayList();
    private boolean replaceExisting;
    private SoundCategory category;

    public List<SoundEntry> getSoundList() {
        return this.soundList;
    }

    public boolean canReplaceExisting() {
        return this.replaceExisting;
    }

    public void setReplaceExisting(boolean bl) {
        this.replaceExisting = bl;
    }

    public SoundCategory getSoundCategory() {
        return this.category;
    }

    public void setSoundCategory(SoundCategory soundCategory) {
        this.category = soundCategory;
    }

    public static class SoundEntry {
        private String name;
        private float volume = 1.0f;
        private float pitch = 1.0f;
        private int weight = 1;
        private Type type = Type.FILE;
        private boolean streaming = false;

        public String getSoundEntryName() {
            return this.name;
        }

        public void setSoundEntryName(String string) {
            this.name = string;
        }

        public float getSoundEntryVolume() {
            return this.volume;
        }

        public void setSoundEntryVolume(float f) {
            this.volume = f;
        }

        public float getSoundEntryPitch() {
            return this.pitch;
        }

        public void setSoundEntryPitch(float f) {
            this.pitch = f;
        }

        public int getSoundEntryWeight() {
            return this.weight;
        }

        public void setSoundEntryWeight(int n) {
            this.weight = n;
        }

        public Type getSoundEntryType() {
            return this.type;
        }

        public void setSoundEntryType(Type type) {
            this.type = type;
        }

        public boolean isStreaming() {
            return this.streaming;
        }

        public void setStreaming(boolean bl) {
            this.streaming = bl;
        }

        public static enum Type {
            FILE("file"),
            SOUND_EVENT("event");

            private final String field_148583_c;

            private Type(String string2) {
                this.field_148583_c = string2;
            }

            public static Type getType(String string) {
                for (Type type : Type.values()) {
                    if (!type.field_148583_c.equals(string)) continue;
                    return type;
                }
                return null;
            }
        }
    }
}

