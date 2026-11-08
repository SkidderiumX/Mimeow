/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.NetworkManager;
import net.minecraft.util.Timer;

public interface oc8ecfa69e1b {
    public Timer getTimer();

    public NetworkManager getMyNetworkManager();

    public int getRightClickDelayTimer();

    public void setRightClickDelayTimer(int var1);

    public void setLeftClickCounter(int var1);

    public void callRightClickMouse();

    public void callClickMouse();

    public void invokeDispatchKeypresses();
}

