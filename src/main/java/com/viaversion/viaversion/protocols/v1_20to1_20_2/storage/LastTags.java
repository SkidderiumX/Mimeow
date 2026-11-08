/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastTags
implements StorableObject {
    private final List<RegistryTags> registryTags = new ArrayList<RegistryTags>();
    private boolean sentDuringConfigPhase;

    public LastTags(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            ArrayList<TagData> arrayList = new ArrayList<TagData>();
            String string = packetWrapper.passthrough(Types.STRING);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int j = 0; j < n2; ++j) {
                String string2 = packetWrapper.passthrough(Types.STRING);
                int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                arrayList.add(new TagData(string2, nArray));
            }
            this.registryTags.add(new RegistryTags(string, arrayList));
        }
    }

    public boolean sendLastTags(UserConnection userConnection) {
        if (this.registryTags.isEmpty()) {
            return false;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.UPDATE_TAGS, userConnection);
        packetWrapper.write(Types.VAR_INT, this.registryTags.size());
        for (RegistryTags registryTags : this.registryTags) {
            packetWrapper.write(Types.STRING, registryTags.registryKey);
            packetWrapper.write(Types.VAR_INT, registryTags.tags.size());
            for (TagData tagData : registryTags.tags) {
                packetWrapper.write(Types.STRING, tagData.identifier());
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, Arrays.copyOf(tagData.entries(), tagData.entries().length));
            }
        }
        packetWrapper.send(Protocol1_20To1_20_2.class);
        return true;
    }

    public void setSentDuringConfigPhase(boolean bl) {
        this.sentDuringConfigPhase = bl;
    }

    public boolean sentDuringConfigPhase() {
        return this.sentDuringConfigPhase;
    }

    private record RegistryTags(String registryKey, List<TagData> tags) {
    }
}

