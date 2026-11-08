/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import java.util.BitSet;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class AcknowledgedMessagesStorage
implements StorableObject {
    private static final int MAX_HISTORY = 20;
    private static final int MINIMUM_DELAYED_ACK_COUNT = 20;
    private static final BitSet DUMMY_LAST_SEEN_MESSAGES = new BitSet();
    private Boolean secureChatEnforced;
    private ChatSession chatSession;
    private BitSet lastSeenMessages = new BitSet();
    private int delayedAckCount;

    public int updateFromMessage(int n, BitSet bitSet) {
        int n2 = this.delayedAckCount;
        this.delayedAckCount = 0;
        this.lastSeenMessages = bitSet;
        return n + n2;
    }

    public int accumulateAckCount(int n) {
        this.delayedAckCount += n;
        int n2 = this.delayedAckCount - 20;
        if (n2 >= 20) {
            this.lastSeenMessages = DUMMY_LAST_SEEN_MESSAGES;
            this.delayedAckCount = 20;
            return n2;
        }
        return 0;
    }

    public BitSet createSpoofedAck() {
        return this.lastSeenMessages;
    }

    public void setSecureChatEnforced(boolean bl) {
        this.secureChatEnforced = bl;
    }

    public @Nullable Boolean secureChatEnforced() {
        return this.secureChatEnforced;
    }

    public boolean isSecureChatEnforced() {
        return this.secureChatEnforced == null || this.secureChatEnforced != false;
    }

    public void queueChatSession(UUID uUID, ProfileKey profileKey) {
        this.chatSession = new ChatSession(uUID, profileKey);
    }

    public void sendQueuedChatSession(PacketWrapper packetWrapper) {
        if (this.chatSession == null) {
            return;
        }
        PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_20_3.CHAT_SESSION_UPDATE);
        packetWrapper2.write(Types.UUID, this.chatSession.sessionId());
        packetWrapper2.write(Types.PROFILE_KEY, this.chatSession.profileKey());
        packetWrapper2.sendToServer(Protocol1_20_3To1_20_5.class);
        this.chatSession = null;
    }

    public void clear() {
        this.lastSeenMessages = new BitSet();
        this.delayedAckCount = 0;
    }

    public record ChatSession(UUID sessionId, ProfileKey profileKey) {
    }
}

