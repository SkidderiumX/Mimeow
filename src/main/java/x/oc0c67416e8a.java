/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import x.oc69da1aa7f5;
import x.oc804fdd8d75;
import x.ocb7a9bf3f2f;

public class oc0c67416e8a
implements HttpHandler {
    private final ocb7a9bf3f2f \u0239;

    oc0c67416e8a(ocb7a9bf3f2f ocb7a9bf3f2f2) {
        this.\u0239 = ocb7a9bf3f2f2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Object object;
        int n = 0xC1480FA2 ^ 0xC1480E56;
        int n2 = oc804fdd8d75.\u0186;
        Object object2 = "No code in the query";
        try {
            block36: {
                block35: {
                    block34: {
                        object = ocb7a9bf3f2f.\u040a(httpExchange.getRequestURI().getRawQuery());
                        if (n2 != 0) break block34;
                        if (!object.containsKey("code")) break block35;
                        this.\u0239.\u045b.z$3bfiasuxgob78((String)object.get("code"), this.\u0239.\u0376, this.\u0239.\u015c);
                        n = 0xC1480E9E ^ 0xC1480E56;
                        object2 = "Login Success";
                    }
                    if (n2 == 0) break block36;
                    boolean bl = true;
                    oc69da1aa7f5.\u04ac = bl;
                }
                this.\u0239.\u045b.z$1fihlpu2c23e3("No code in the query");
            }
            object = ((String)object2).getBytes(StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            this.\u0239.\u045b.z$1fihlpu2c23e3(exception.toString());
            object2 = "Error: " + String.valueOf(exception);
            return;
        }
        try {
            httpExchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
            httpExchange.sendResponseHeaders(n, ((Object)object).length);
            OutputStream outputStream2 = httpExchange.getResponseBody();
            if (n2 != 0) return;
            try {
                outputStream2.write((byte[])object);
                if (outputStream2 == null) return;
            }
            catch (Throwable throwable) {
                if (n2 != 0) throw throwable;
                if (outputStream2 == null) throw throwable;
                try {
                    outputStream2.close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            outputStream2.close();
            return;
        }
        finally {
            block32: {
                byte[] byArray = ((String)object2).getBytes(StandardCharsets.UTF_8);
                try {
                    block33: {
                        httpExchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
                        httpExchange.sendResponseHeaders(n, byArray.length);
                        OutputStream outputStream3 = httpExchange.getResponseBody();
                        if (n2 != 0) break block32;
                        try {
                            outputStream3.write(byArray);
                            if (outputStream3 == null) break block33;
                        }
                        catch (Throwable throwable) {
                            if (n2 != 0) throw throwable;
                            if (outputStream3 == null) throw throwable;
                            try {
                                outputStream3.close();
                                throw throwable;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                            throw throwable;
                        }
                        outputStream3.close();
                    }
                    httpExchange.close();
                    this.\u0239.\u01bc(false);
                }
                catch (Throwable throwable) {
                    httpExchange.close();
                    this.\u0239.\u01bc(false);
                    throw throwable;
                }
            }
        }
    }
}

