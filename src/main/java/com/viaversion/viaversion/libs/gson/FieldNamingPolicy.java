package com.viaversion.viaversion.libs.gson;

import java.lang.reflect.*;
import java.util.*;

public enum FieldNamingPolicy implements FieldNamingStrategy
{
    IDENTITY {
        @Override
        public String translateName(final Field field) {
            return field.getName();
        }
    }, 
    UPPER_CAMEL_CASE {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }, 
    UPPER_CAMEL_CASE_WITH_SPACES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), ' '));
        }
    }, 
    UPPER_CASE_WITH_UNDERSCORES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_UNDERSCORES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_DASHES {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_DOTS {
        @Override
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };
    
    static String separateCamelCase(final String s, final char c) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (Character.isUpperCase(char1) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(char1);
        }
        return sb.toString();
    }
    
    static String upperCaseFirstLetter(final String s) {
        final int length = s.length();
        int i = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            if (Character.isLetter(char1)) {
                if (Character.isUpperCase(char1)) {
                    return s;
                }
                final char upperCase = Character.toUpperCase(char1);
                if (i == 0) {
                    return upperCase + s.substring(1);
                }
                return s.substring(0, i) + upperCase + s.substring(i + 1);
            }
            else {
                ++i;
            }
        }
        return s;
    }
}
