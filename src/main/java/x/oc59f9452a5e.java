/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc00651dad83;
import x.oc293826be15;

public class oc59f9452a5e
implements oc00651dad83 {
    final oc293826be15 this$0;

    oc59f9452a5e(oc293826be15 oc293826be152) {
        this.this$0 = oc293826be152;
    }

    @Override
    public void z$20w06ler7vqca(int n, int n2, int n3, int n4, int n5, byte[] byArray) {
        int n6 = this.this$0.\u0115.get(n)[0];
        byte[] byArray2 = this.this$0.\u03f0.get(n);
        for (int i = 0; i < n5; ++i) {
            System.arraycopy(byArray, (n3 + i) * n6 + n2, byArray2, (n3 + i) * n6 + n2, n4);
        }
        int[] nArray = this.this$0.\u0435.get(n);
        nArray[0] = nArray[0] + 1;
    }

    @Override
    public void z$3mrpfyp7hdljq(int n, int[] nArray) {
        int[] nArray2 = this.this$0.\u0115.get(n);
        if (nArray2 == null) {
            throw new IllegalStateException("Unknown caller atlas");
        }
        nArray[0] = nArray2[0];
        nArray[1] = nArray2[1];
    }

    @Override
    public int z$8519guy0xkde(int n, int n2, int n3, int n4, byte[] byArray) {
        int n5 = oc293826be15.\u0398++;
        int[] nArray = new int[0x8840A214 ^ 0x8840A216];
        nArray[0] = n2;
        nArray[1] = n3;
        this.this$0.\u0115.put(n5, nArray);
        this.this$0.\u03f0.put(n5, byArray == null ? new byte[n2 * n3] : (byte[])byArray.clone());
        this.this$0.\u0435.put(n5, new int[1]);
        return n5;
    }
}

