/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import x.oc8ce2882092;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface oc66fa4f2195 {
    public oc8ce2882092 priority() default oc8ce2882092.NORMAL;

    public boolean receiveCanceled() default false;
}

