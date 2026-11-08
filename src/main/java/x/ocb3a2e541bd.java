/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import x.oc02a3730b27;
import x.oc497d0cdf29;
import x.ocb683e2d821;

public class ocb3a2e541bd {
    Entity \u02a9;
    float \u057c;
    float p;
    float \u0566;
    float \u0556;

    private ocb3a2e541bd() {
    }

    void \u04c2(Entity entity) {
        block7: {
            Entity entity2;
            block8: {
                int n;
                block6: {
                    n = oc02a3730b27.\u0166;
                    entity2 = this.\u02a9;
                    if (n != 0) break block6;
                    if (entity2 != null) break block7;
                    entity2 = entity;
                }
                if (n != 0) break block8;
                if (entity2 == null) break block7;
                this.\u02a9 = entity;
                this.\u057c = entity.rotationYaw;
                this.p = entity.rotationPitch;
                this.\u0566 = entity.prevRotationYaw;
                this.\u0556 = entity.prevRotationPitch;
                entity2 = entity;
            }
            ocb683e2d821.\u01a0(entity2, ocb683e2d821.\u0508, ocb683e2d821.\u04ea, true);
        }
    }

    void \u0444() {
        block5: {
            block4: {
                int n = oc02a3730b27.\u0166;
                ocb3a2e541bd ocb3a2e541bd2 = this;
                if (n != 0) break block4;
                if (ocb3a2e541bd2.\u02a9 == null) break block5;
                ocb683e2d821.\u01a0(this.\u02a9, this.\u057c, this.p, false);
                this.\u02a9.prevRotationYaw = this.\u0566;
                this.\u02a9.prevRotationPitch = oc497d0cdf29.\u053c(-90.0f, 90.0f, this.\u0556);
                ocb3a2e541bd2 = this;
            }
            ocb3a2e541bd2.\u02a9 = null;
        }
    }
}

