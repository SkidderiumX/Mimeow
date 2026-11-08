/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Iterator;
import net.minecraft.world.NextTickListEntry;
import x.oc170ea29aae;
import x.oc1fa97e926f;

public class oc0e5aa4f07e
implements Iterator<NextTickListEntry> {
    private NextTickListEntry \u00e6;
    private boolean \u03fb;
    final Iterator val$delegate;
    final oc1fa97e926f this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc0e5aa4f07e(oc1fa97e926f oc1fa97e926f2, Iterator iterator2) {
        this.this$0 = oc1fa97e926f2;
        this.val$delegate = iterator2;
    }

    @Override
    public boolean hasNext() {
        return this.val$delegate.hasNext();
    }

    @Override
    public NextTickListEntry next() {
        this.\u00e6 = (NextTickListEntry)this.val$delegate.next();
        this.\u03fb = true;
        return this.\u00e6;
    }

    @Override
    public void remove() {
        block4: {
            oc0e5aa4f07e oc0e5aa4f07e2;
            block5: {
                boolean bl = oc170ea29aae.\u0406;
                oc0e5aa4f07e2 = this;
                if (bl) break block4;
                if (oc0e5aa4f07e2.\u03fb) break block5;
                throw new IllegalStateException();
            }
            this.this$0.remove(this.\u00e6);
            oc0e5aa4f07e2 = this;
        }
        oc0e5aa4f07e2.\u03fb = false;
    }
}

