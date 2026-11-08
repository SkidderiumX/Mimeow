/*
 * Decompiled with CFR 0.152.
 */
package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;
import net.arikia.dev.drpc.callbacks.ErroredCallback;
import net.arikia.dev.drpc.callbacks.JoinGameCallback;
import net.arikia.dev.drpc.callbacks.JoinRequestCallback;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.arikia.dev.drpc.callbacks.SpectateGameCallback;

public class DiscordEventHandlers
extends Structure {
    public ReadyCallback ready;
    public DisconnectedCallback disconnected;
    public ErroredCallback errored;
    public JoinGameCallback joinGame;
    public SpectateGameCallback spectateGame;
    public JoinRequestCallback joinRequest;

    @Override
    public List<String> getFieldOrder() {
        return Arrays.asList("ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest");
    }

    public static class Builder {
        DiscordEventHandlers h = new DiscordEventHandlers();

        public Builder setReadyEventHandler(ReadyCallback readyCallback) {
            this.h.ready = readyCallback;
            return this;
        }

        public Builder setDisconnectedEventHandler(DisconnectedCallback disconnectedCallback) {
            this.h.disconnected = disconnectedCallback;
            return this;
        }

        public Builder setErroredEventHandler(ErroredCallback erroredCallback) {
            this.h.errored = erroredCallback;
            return this;
        }

        public Builder setJoinGameEventHandler(JoinGameCallback joinGameCallback) {
            this.h.joinGame = joinGameCallback;
            return this;
        }

        public Builder setSpectateGameEventHandler(SpectateGameCallback spectateGameCallback) {
            this.h.spectateGame = spectateGameCallback;
            return this;
        }

        public Builder setJoinRequestEventHandler(JoinRequestCallback joinRequestCallback) {
            this.h.joinRequest = joinRequestCallback;
            return this;
        }

        public DiscordEventHandlers build() {
            return this.h;
        }
    }
}

