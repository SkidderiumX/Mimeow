/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc410fad187d;
import x.oc606e718ce9;
import x.oc7969790760;
import x.oca41080eed8;

public class occ22af137a2
implements AutoCloseable {
    private static final oca41080eed8 \u04b4 = new oc410fad187d();
    private static int \u029a;
    private final oca41080eed8 \u043f;
    private final Runnable \u04e4;
    private boolean \u01fd;
    private boolean \u010a;
    private boolean \u0412;
    private boolean \u01ce;

    occ22af137a2(oca41080eed8 oca41080eed82, Runnable runnable2) {
        this.\u043f = oca41080eed82;
        this.\u04e4 = runnable2;
        try {
            oca41080eed82.z$73x5qqydaaar();
            this.\u01fd = true;
            oca41080eed82.z$3d6hjeg7c8mtf();
            this.\u010a = true;
        }
        catch (Error | RuntimeException throwable) {
            try {
                this.close();
            }
            catch (Error | RuntimeException throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public static occ22af137a2 \u0158() {
        oc7969790760 oc79697907602 = oc7969790760.\u045e();
        occ22af137a2 occ22af137a22 = new occ22af137a2(\u04b4, oc79697907602::\u04fa);
        ++\u029a;
        occ22af137a22.\u01ce = true;
        return occ22af137a22;
    }

    public static boolean \u03bb() {
        return \u029a > 0;
    }

    @Override
    public void close() {
        if (!this.\u0412) {
            this.\u0412 = true;
            if (this.\u01ce) {
                --\u029a;
            }
            Throwable throwable = null;
            if (this.\u010a) {
                throwable = occ22af137a2.\u02b3(this.\u043f::z$1emhea3cbblse, throwable);
            }
            if (this.\u01fd) {
                throwable = occ22af137a2.\u02b3(this.\u043f::z$g7u1h2mhac5x, throwable);
            }
            throwable = occ22af137a2.\u02b3(this.\u04e4, throwable);
            if (this.\u01ce && \u029a == 0 && throwable == null) {
                throwable = occ22af137a2.\u02b3(oc606e718ce9::\u018b, throwable);
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
        }
    }

    private static Throwable \u02b3(Runnable runnable2, Throwable throwable) {
        try {
            runnable2.run();
        }
        catch (Error | RuntimeException throwable2) {
            if (throwable == null) {
                return throwable2;
            }
            throwable.addSuppressed(throwable2);
        }
        return throwable;
    }
}

