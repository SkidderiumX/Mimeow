/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.internal.ReflectionAccessFilterHelper;

public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new ReflectionAccessFilter(){

        @Override
        public FilterResult check(Class<?> clazz) {
            return ReflectionAccessFilterHelper.isJavaType(clazz) ? FilterResult.BLOCK_INACCESSIBLE : FilterResult.INDECISIVE;
        }

        public String toString() {
            return "ReflectionAccessFilter#BLOCK_INACCESSIBLE_JAVA";
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new ReflectionAccessFilter(){

        @Override
        public FilterResult check(Class<?> clazz) {
            return ReflectionAccessFilterHelper.isJavaType(clazz) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }

        public String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_JAVA";
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new ReflectionAccessFilter(){

        @Override
        public FilterResult check(Class<?> clazz) {
            return ReflectionAccessFilterHelper.isAndroidType(clazz) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }

        public String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_ANDROID";
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new ReflectionAccessFilter(){

        @Override
        public FilterResult check(Class<?> clazz) {
            return ReflectionAccessFilterHelper.isAnyPlatformType(clazz) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }

        public String toString() {
            return "ReflectionAccessFilter#BLOCK_ALL_PLATFORM";
        }
    };

    public FilterResult check(Class<?> var1);

    public static enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL;

    }
}

