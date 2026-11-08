/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import x.oc11bafa49c6;
import x.oc2cf3d80e17;
import x.oc75d51ec7eb;
import x.occ9ed06a81d;

public class oc1dfcc931f9
implements Runnable {
    final GameProfile val$profile;
    final MinecraftProfileTexture val$skinTexture;
    final String val$normalized;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc1dfcc931f9(GameProfile gameProfile, MinecraftProfileTexture minecraftProfileTexture, String string) {
        this.val$profile = gameProfile;
        this.val$skinTexture = minecraftProfileTexture;
        this.val$normalized = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        int n = oc75d51ec7eb.\u03e9;
        try {
            block15: {
                block14: {
                    block12: {
                        occ9ed06a81d occ9ed06a81d2;
                        block13: {
                            if (this.val$profile.getName() == null) break block12;
                            occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                            if (n != 0) break block13;
                            if (occ9ed06a81d2 == null) break block12;
                            occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                        }
                        occ9ed06a81d2.\u0228(this.val$profile.getName());
                    }
                    ResourceLocation resourceLocation = Minecraft.getMinecraft().getSkinManager().loadSkin(this.val$skinTexture, MinecraftProfileTexture.Type.SKIN);
                    if (n != 0) break block14;
                    if (resourceLocation == null) break block15;
                    oc11bafa49c6.\u0197.put(this.val$normalized, resourceLocation);
                    oc11bafa49c6.\u0293.remove(this.val$normalized);
                    oc11bafa49c6.\u045f(this.val$normalized);
                }
                if (n == 0) return;
            }
            oc11bafa49c6.\u0476(this.val$normalized);
            return;
        }
        finally {
            oc11bafa49c6.\u0480.remove(this.val$normalized);
        }
    }
}

