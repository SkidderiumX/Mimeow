/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.AbstractFenceConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import java.util.ArrayList;
import java.util.List;

public class BasicFenceConnectionHandler
extends AbstractFenceConnectionHandler {
    static List<ConnectionData.ConnectorInitAction> init() {
        ArrayList<ConnectionData.ConnectorInitAction> arrayList = new ArrayList<ConnectionData.ConnectorInitAction>();
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:oak_fence"));
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:birch_fence"));
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:jungle_fence"));
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:dark_oak_fence"));
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:acacia_fence"));
        arrayList.add(new BasicFenceConnectionHandler("fence").getInitAction("minecraft:spruce_fence"));
        return arrayList;
    }

    public BasicFenceConnectionHandler(String string) {
        super(string);
    }
}

