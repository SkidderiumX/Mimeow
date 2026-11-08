/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ProtocolPipeline {
    public void add(Protocol var1);

    public void add(Collection<Protocol> var1);

    public boolean contains(Class<? extends Protocol> var1);

    @Deprecated
    public <P extends Protocol> @Nullable P getProtocol(Class<P> var1);

    public void transform(Direction var1, State var2, PacketWrapper var3) throws InformativeException, CancelException;

    public List<Protocol> pipes(@Nullable Class<? extends Protocol> var1, boolean var2, Direction var3);

    public List<Protocol> pipes();

    public List<Protocol> reversedPipes();

    public int baseProtocolCount();

    public boolean hasNonBaseProtocols();

    public void cleanPipes();
}

