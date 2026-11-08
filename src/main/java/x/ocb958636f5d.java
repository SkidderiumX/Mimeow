/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonObject;
import x.oc321b4679dd;
import x.oc89eb238246;
import x.oced29a282d7;

public class ocb958636f5d
extends oc321b4679dd {
    final oced29a282d7 this$0;

    ocb958636f5d(oced29a282d7 oced29a282d72, String string, String string2, String string3, int n) {
        this.this$0 = oced29a282d72;
        super(string, string2, string3, n);
    }

    @Override
    public void z$1bnplyl2p7uqx(String string) {
        super.z$1bnplyl2p7uqx(oced29a282d7.\u01e2(string));
        oced29a282d7.\u00fb(this.\u00ca());
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block11: {
            String string;
            JsonObject jsonObject2;
            String string2;
            block10: {
                int n = oc89eb238246.\u0127;
                if (jsonObject == null) {
                    return;
                }
                string2 = this.z$3lm3x0je4b2zv();
                jsonObject2 = jsonObject;
                string = string2;
                if (n != 0) break block10;
                if (!jsonObject2.has(string)) break block11;
                jsonObject2 = jsonObject;
                string = string2;
            }
            if (jsonObject2.get(string).isJsonPrimitive()) {
                this.z$1bnplyl2p7uqx(jsonObject.getAsJsonPrimitive(string2).getAsString());
            }
        }
    }
}

