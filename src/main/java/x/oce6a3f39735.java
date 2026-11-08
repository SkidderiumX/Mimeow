/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import x.oc11bafa49c6;
import x.oc75d51ec7eb;
import x.oc9c448281f6;

public class oce6a3f39735
implements Runnable {
    final String val$username;
    final String val$normalized;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oce6a3f39735(String string, String string2) {
        this.val$username = string;
        this.val$normalized = string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block13: {
            int n = oc75d51ec7eb.\u03e9;
            try {
                GameProfile gameProfile;
                block14: {
                    GameProfile gameProfile2;
                    block12: {
                        block11: {
                            GameProfile[] gameProfileArray = new GameProfile[1];
                            oc11bafa49c6.\u015f.findProfilesByNames(new String[]{this.val$username}, Agent.MINECRAFT, new oc9c448281f6(this, gameProfileArray));
                            gameProfile2 = gameProfileArray[0];
                            if (n != 0) break block11;
                            if (gameProfile2 != null) break block12;
                            oc11bafa49c6.\u0549(this.val$normalized, null);
                            oc11bafa49c6.\u0476(this.val$normalized);
                        }
                        return;
                    }
                    Minecraft minecraft = Minecraft.getMinecraft();
                    gameProfile = minecraft.getSessionService().fillProfileProperties(gameProfile2, false);
                    if (n != 0) break block13;
                    if (gameProfile != null) break block14;
                    oc11bafa49c6.\u0549(this.val$normalized, null);
                    oc11bafa49c6.\u0476(this.val$normalized);
                    return;
                }
                oc11bafa49c6.\u0549(this.val$normalized, gameProfile);
                oc11bafa49c6.\u040b(this.val$normalized, gameProfile);
            }
            catch (Exception exception) {
                oc11bafa49c6.\u0549(this.val$normalized, null);
                oc11bafa49c6.\u0476(this.val$normalized);
            }
            finally {
                oc11bafa49c6.\u041b.remove(this.val$normalized);
            }
        }
    }
}

