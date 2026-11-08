/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.oc84f20a0bc5;

public class oc1a421bd3db {
    final BlockPos \u029a;
    final EnumFacing \u0553;
    final BlockPos \u0547;

    oc1a421bd3db(BlockPos blockPos, EnumFacing enumFacing, BlockPos blockPos2) {
        this.\u029a = blockPos;
        this.\u0553 = enumFacing;
        this.\u0547 = blockPos2;
    }

    public boolean equals(Object object) {
        boolean bl;
        block25: {
            block23: {
                oc1a421bd3db oc1a421bd3db2;
                oc1a421bd3db oc1a421bd3db3;
                int n;
                block24: {
                    block22: {
                        Object object2;
                        block20: {
                            block21: {
                                block18: {
                                    block19: {
                                        n = oc84f20a0bc5.\u0117;
                                        object2 = this;
                                        if (n != 0) break block18;
                                        if (object2 != object) break block19;
                                        return true;
                                    }
                                    object2 = object;
                                }
                                if (n != 0) break block20;
                                if (object2 instanceof oc1a421bd3db) break block21;
                                return false;
                            }
                            object2 = object;
                        }
                        oc1a421bd3db3 = (oc1a421bd3db)object2;
                        oc1a421bd3db2 = this;
                        if (n != 0) break block22;
                        if (!oc1a421bd3db2.\u029a.equals(oc1a421bd3db3.\u029a)) break block23;
                        oc1a421bd3db2 = this;
                    }
                    if (n != 0) break block24;
                    if (oc1a421bd3db2.\u0553 != oc1a421bd3db3.\u0553) break block23;
                    oc1a421bd3db2 = this;
                }
                bl = oc1a421bd3db2.\u0547.equals(oc1a421bd3db3.\u0547);
                if (n != 0) break block25;
                if (!bl) break block23;
                bl = true;
                break block25;
            }
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        Object[] objectArray = new Object[0x83E3D236 ^ 0x83E3D235];
        objectArray[0] = this.\u029a;
        objectArray[1] = this.\u0553;
        objectArray[0x83E3D237 ^ 0x83E3D235] = this.\u0547;
        return Objects.hash(objectArray);
    }
}

