/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import x.oc10354c7bb8;
import x.oc75d51ec7eb;
import x.oce6fde6f14a;

public class oc3383be5a70
implements oce6fde6f14a {
    private final oc10354c7bb8 \u0566;
    private Set<String> \u00c1;
    private Map<String, Object> \u0575;
    private int \u04b8;
    public static int \u01e5;

    public oc3383be5a70(oc10354c7bb8 oc10354c7bb82) {
        this.\u0566 = oc10354c7bb82;
        this.\u0222();
    }

    @Override
    public void z$1o3njpmxa1ma5() {
        int n = this.\u0566.\u0478().hashCode();
        if (n != this.\u04b8) {
            this.\u0222();
        }
    }

    @Override
    public boolean z$2terxsjcchy0a() {
        boolean bl;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                bl = this.\u0566.\u0478().isEmpty();
                if (n != 0) break block2;
                if (bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean z$11r2n2rw0zig9(IBlockState iBlockState) {
        int n;
        block32: {
            oc3383be5a70 oc3383be5a702;
            String string;
            block34: {
                block33: {
                    int n2;
                    int n3;
                    block30: {
                        Block block;
                        block31: {
                            Block block2;
                            block28: {
                                Block block3;
                                block29: {
                                    Block block4;
                                    block26: {
                                        block27: {
                                            IBlockState iBlockState2;
                                            block24: {
                                                block25: {
                                                    n3 = oc75d51ec7eb.\u03e9;
                                                    iBlockState2 = iBlockState;
                                                    if (n3 != 0) break block24;
                                                    if (iBlockState2 != null) break block25;
                                                    return false;
                                                }
                                                iBlockState2 = iBlockState;
                                            }
                                            block = iBlockState2.getBlock();
                                            block4 = block;
                                            if (n3 != 0) break block26;
                                            if (block4 != null) break block27;
                                            return false;
                                        }
                                        block4 = Block.blockRegistry.getNameForObject(block);
                                    }
                                    block3 = block4;
                                    block2 = block3;
                                    if (n3 != 0) break block28;
                                    if (block2 != null) break block29;
                                    return false;
                                }
                                block2 = block3;
                            }
                            string = ((Object)block2).toString();
                            n2 = this.\u0575.containsKey(string);
                            if (n3 != 0) break block30;
                            if (n2 == 0) break block31;
                            return true;
                        }
                        n2 = block.getMetaFromState(iBlockState);
                    }
                    int n4 = n2;
                    n = n4;
                    if (n3 != 0) break block32;
                    if (n == 0) break block33;
                    oc3383be5a702 = this;
                    if (n3 != 0) break block34;
                    if (!oc3383be5a702.\u00c1.contains(string + ":" + n4)) break block33;
                    return true;
                }
                oc3383be5a702 = this;
            }
            n = oc3383be5a702.\u00c1.contains(string);
        }
        return n != 0;
    }

    @Override
    public boolean z$3mptsutoy1cyd(BlockPos blockPos, IBlockState iBlockState) {
        return this.z$11r2n2rw0zig9(iBlockState);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0222() {
        List<String> list = this.\u0566.\u0478();
        this.\u04b8 = list.hashCode();
        this.\u00c1 = new HashSet<String>();
        this.\u0575 = new HashMap<String, Object>();
        Iterator<String> iterator2 = list.iterator();
        int n = oc75d51ec7eb.\u03e9;
        while (iterator2.hasNext()) {
            block5: {
                boolean bl;
                String string;
                block6: {
                    string = iterator2.next();
                    bl = string.endsWith(":*");
                    if (n != 0) break block5;
                    if (!bl) break block6;
                    String string2 = string.substring(0, string.length() - (0xBCE4C3FD ^ 0xBCE4C3FF));
                    this.\u0575.put(string2, null);
                    if (n == 0) break block5;
                }
                bl = this.\u00c1.add(string);
            }
            if (n == 0) continue;
        }
    }
}

