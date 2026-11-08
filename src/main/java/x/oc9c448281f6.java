/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import x.oce6a3f39735;

public class oc9c448281f6
implements ProfileLookupCallback {
    final GameProfile[] val$holder;
    final oce6a3f39735 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc9c448281f6(oce6a3f39735 oce6a3f397352, GameProfile[] gameProfileArray) {
        this.this$0 = oce6a3f397352;
        this.val$holder = gameProfileArray;
    }

    @Override
    public void onProfileLookupSucceeded(GameProfile gameProfile) {
        this.val$holder[0] = gameProfile;
    }

    @Override
    public void onProfileLookupFailed(GameProfile gameProfile, Exception exception) {
    }
}

