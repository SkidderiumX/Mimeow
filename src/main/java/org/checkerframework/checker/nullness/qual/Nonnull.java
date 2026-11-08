package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Compilation stub for the Checker Framework's @NonNull annotation.
 * Only the annotation itself is needed; no runtime checker is required.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
public @interface Nonnull {
    int sourceIndex() default -1;
    int valueIndex() default -1;
}
