/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.AbstractFenceConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import java.util.ArrayList;
import java.util.List;

public class GlassConnectionHandler
extends AbstractFenceConnectionHandler {
    static List<ConnectionData.ConnectorInitAction> init() {
        ArrayList<ConnectionData.ConnectorInitAction> arrayList = new ArrayList<ConnectionData.ConnectorInitAction>(18);
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:white_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:orange_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:magenta_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:light_blue_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:yellow_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:lime_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:pink_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:gray_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:light_gray_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:cyan_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:purple_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:blue_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:brown_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:green_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:red_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:black_stained_glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:glass_pane"));
        arrayList.add(new GlassConnectionHandler("pane").getInitAction("minecraft:iron_bars"));
        return arrayList;
    }

    public GlassConnectionHandler(String string) {
        super(string);
    }

    @Override
    protected byte getStates(UserConnection userConnection, BlockPosition blockPosition) {
        int n = super.getStates(userConnection, blockPosition);
        if (n != 0) {
            return (byte)n;
        }
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        return (byte)(protocolInfo.serverProtocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_8) && protocolInfo.serverProtocolVersion().isKnown() ? 15 : n);
    }
}

