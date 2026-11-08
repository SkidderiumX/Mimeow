/*
 * Decompiled with CFR 0.152.
 */
package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordRichPresence
extends Structure {
    public String state;
    public String details;
    public long startTimestamp;
    public long endTimestamp;
    public String largeImageKey;
    public String largeImageText;
    public String smallImageKey;
    public String smallImageText;
    public String partyId;
    public int partySize;
    public int partyMax;
    @Deprecated
    public String matchSecret;
    public String spectateSecret;
    public String joinSecret;
    @Deprecated
    public int instance;

    @Override
    public List<String> getFieldOrder() {
        return Arrays.asList("state", "details", "startTimestamp", "endTimestamp", "largeImageKey", "largeImageText", "smallImageKey", "smallImageText", "partyId", "partySize", "partyMax", "matchSecret", "joinSecret", "spectateSecret", "instance");
    }

    public static class Builder {
        private DiscordRichPresence p = new DiscordRichPresence();

        public Builder(String string) {
            this.p.state = string;
        }

        public Builder setDetails(String string) {
            this.p.details = string;
            return this;
        }

        public Builder setStartTimestamps(long l) {
            this.p.startTimestamp = l;
            return this;
        }

        public Builder setEndTimestamp(long l) {
            this.p.endTimestamp = l;
            return this;
        }

        public Builder setBigImage(String string, String string2) {
            if (string2 != null && !string2.equalsIgnoreCase("") && string == null) {
                throw new IllegalArgumentException("Image key must not be null when assigning a hover text.");
            }
            this.p.largeImageKey = string;
            this.p.largeImageText = string2;
            return this;
        }

        public Builder setSmallImage(String string, String string2) {
            if (string2 != null && !string2.equalsIgnoreCase("") && string == null) {
                throw new IllegalArgumentException("Image key must not be null when assigning a hover text.");
            }
            this.p.smallImageKey = string;
            this.p.smallImageText = string2;
            return this;
        }

        public Builder setParty(String string, int n, int n2) {
            this.p.partyId = string;
            this.p.partySize = n;
            this.p.partyMax = n2;
            return this;
        }

        @Deprecated
        public Builder setSecrets(String string, String string2, String string3) {
            this.p.matchSecret = string;
            this.p.joinSecret = string2;
            this.p.spectateSecret = string3;
            return this;
        }

        public Builder setSecrets(String string, String string2) {
            this.p.joinSecret = string;
            this.p.spectateSecret = string2;
            return this;
        }

        @Deprecated
        public Builder setInstance(boolean bl) {
            this.p.instance = bl ? 1 : 0;
            return this;
        }

        public DiscordRichPresence build() {
            return this.p;
        }
    }
}

