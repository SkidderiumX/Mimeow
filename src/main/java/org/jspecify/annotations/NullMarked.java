package org.jspecify.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Compilation stub for JSpecify's @NullMarked annotation.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.MODULE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface NullMarked {
}
