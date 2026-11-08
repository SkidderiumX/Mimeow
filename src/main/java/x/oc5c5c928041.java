/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Iterator;
import net.minecraft.world.NextTickListEntry;
import x.oc1fa97e926f;

public class oc5c5c928041
implements Iterator<NextTickListEntry> {
    private NextTickListEntry \u0246;
    final Iterator val$delegate;
    final oc1fa97e926f this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc5c5c928041(oc1fa97e926f oc1fa97e926f2, Iterator iterator2) {
        this.this$0 = oc1fa97e926f2;
        this.val$delegate = iterator2;
    }

    @Override
    public boolean hasNext() {
        return this.val$delegate.hasNext();
    }

    @Override
    public NextTickListEntry next() {
        this.\u0246 = (NextTickListEntry)this.val$delegate.next();
        return this.\u0246;
    }

    @Override
    public void remove() {
        this.val$delegate.remove();
        this.this$0.F(this.\u0246);
    }
}

