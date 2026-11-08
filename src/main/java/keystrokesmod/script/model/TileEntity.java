/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import keystrokesmod.script.model.Vec3;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;

public class TileEntity {
    private net.minecraft.tileentity.TileEntity tileEntity;
    private Vec3 position;
    public String type;
    public String name;

    public TileEntity(net.minecraft.tileentity.TileEntity tileEntity) {
        this.tileEntity = tileEntity;
        this.position = new Vec3(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ());
        this.type = tileEntity.getBlockType().getClass().getSimpleName();
        this.name = ((ResourceLocation)Block.blockRegistry.getNameForObject(tileEntity.getBlockType())).toString().replace("minecraft:", "");
    }

    public Vec3 getPosition() {
        return this.position;
    }

    public Object[] getSkullData() {
        if (this.tileEntity instanceof TileEntitySkull) {
            TileEntitySkull tileEntitySkull = (TileEntitySkull)this.tileEntity;
            Object[] objectArray = new Object[0x9201816 ^ 0x9201813];
            objectArray[0] = tileEntitySkull.getSkullType();
            objectArray[1] = tileEntitySkull.getSkullRotation();
            objectArray[0x9201811 ^ 0x9201813] = null;
            objectArray[0x9201810 ^ 0x9201813] = null;
            objectArray[0x9201817 ^ 0x9201813] = null;
            Object[] objectArray2 = objectArray;
            if (tileEntitySkull.getPlayerProfile() == null) {
                objectArray2[0x9201810 ^ 0x9201813] = null;
                objectArray2[0x9201811 ^ 0x9201813] = null;
            } else {
                objectArray2[0x9201811 ^ 0x9201813] = tileEntitySkull.getPlayerProfile().getName();
                objectArray2[0x9201810 ^ 0x9201813] = tileEntitySkull.getPlayerProfile().getId();
            }
            return objectArray2;
        }
        return null;
    }
}

