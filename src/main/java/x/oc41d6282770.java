/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import x.oc321b4679dd;
import x.oc89eb238246;
import x.oced29a282d7;

public class oc41d6282770
extends oc321b4679dd {
    final oced29a282d7 this$0;

    oc41d6282770(oced29a282d7 oced29a282d72, String string, String string2, String string3, int n) {
        this.this$0 = oced29a282d72;
        super(string, string2, string3, n);
    }

    @Override
    public void z$1bnplyl2p7uqx(String string) {
        super.z$1bnplyl2p7uqx(oced29a282d7.\u04f0(string));
        oced29a282d7.\u0197(this.\u00ca());
    }

    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block11: {
            JsonElement jsonElement;
            String string;
            block10: {
                int n = oc89eb238246.\u0127;
                if (jsonObject == null) {
                    return;
                }
                string = this.z$3lm3x0je4b2zv();
                jsonElement = jsonObject;
                if (n != 0) break block10;
                if (!jsonElement.has(string)) break block11;
                jsonElement = jsonObject.get(string);
            }
            if (jsonElement.isJsonPrimitive()) {
                this.z$1bnplyl2p7uqx(jsonObject.getAsJsonPrimitive(string).getAsString());
            }
        }
    }
}

