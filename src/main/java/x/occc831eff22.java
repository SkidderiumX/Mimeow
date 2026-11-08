/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import x.N;

public class occc831eff22
extends N {
    private final List<N> \u00c6 = new ArrayList<N>();
    private boolean \u03d8;
    public static int d;

    public occc831eff22(String string) {
        super(string);
    }

    public List<N> \u0298() {
        return this.\u00c6;
    }

    public void \u03c1(N n) {
        this.\u00c6.add(n);
    }

    public void \u0448(N n) {
        this.\u00c6.remove(n);
    }

    public boolean \u01ab() {
        return this.\u03d8;
    }

    public void \u04f6(boolean bl) {
        this.\u03d8 = bl;
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
    }
}

