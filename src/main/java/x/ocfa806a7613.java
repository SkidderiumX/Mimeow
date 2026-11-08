/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import x.ocbf5a535fb8;
import x.occ0b63c0426;

public class ocfa806a7613 {
    public String \u0240;
    public String \u0173;
    private final TileEntity \u0439;
    public static int \u056c;

    public ocfa806a7613(TileEntity tileEntity) {
        this.\u0439 = tileEntity;
        Block block = tileEntity == null ? null : tileEntity.getBlockType();
        this.\u0240 = block == null ? "BlockAir" : block.getClass().getSimpleName();
        this.\u0173 = occ0b63c0426.\u025b(block);
    }

    public ocbf5a535fb8 \u012d() {
        ocbf5a535fb8 ocbf5a535fb82;
        block6: {
            ocfa806a7613 ocfa806a76132;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    ocfa806a76132 = this;
                    if (n != 0) break block4;
                    if (ocfa806a76132.\u0439 != null) break block5;
                    ocbf5a535fb82 = null;
                    break block6;
                }
                ocfa806a76132 = this;
            }
            ocbf5a535fb82 = ocbf5a535fb8.\u03e1(ocfa806a76132.\u0439.getPos());
        }
        return ocbf5a535fb82;
    }

    public Object[] \u04c1() {
        Object[] objectArray;
        block11: {
            GameProfile gameProfile;
            block10: {
                ocfa806a7613 ocfa806a76132;
                int n;
                block8: {
                    block9: {
                        n = occ0b63c0426.\u039f;
                        ocfa806a76132 = this;
                        if (n != 0) break block8;
                        if (ocfa806a76132.\u0439 instanceof TileEntitySkull) break block9;
                        return null;
                    }
                    ocfa806a76132 = this;
                }
                TileEntitySkull tileEntitySkull = (TileEntitySkull)ocfa806a76132.\u0439;
                Object[] objectArray2 = new Object[0x9143D3E1 ^ 0x9143D3E4];
                objectArray2[0] = tileEntitySkull.getSkullType();
                objectArray2[1] = tileEntitySkull.getSkullRotation();
                objectArray2[0x9143D3E6 ^ 0x9143D3E4] = null;
                objectArray2[0x9143D3E7 ^ 0x9143D3E4] = null;
                objectArray2[0x9143D3E0 ^ 0x9143D3E4] = null;
                objectArray = objectArray2;
                gameProfile = tileEntitySkull.getPlayerProfile();
                if (n != 0) break block10;
                if (gameProfile == null) break block11;
                objectArray[0x9143D3E6 ^ 0x9143D3E4] = gameProfile.getName();
            }
            objectArray[0x9143D3E7 ^ 0x9143D3E4] = gameProfile.getId();
        }
        return objectArray;
    }
}

