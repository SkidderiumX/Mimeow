/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;

public record Template(List<String> segments, List<String> variables) {
    private static final int MAX_LENGTH = 2000000;

    public static Template fromString(String string) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        int n = 0;
        int n2 = string.indexOf(36);
        while (n2 != -1) {
            if (n2 != string.length() - 1 && string.charAt(n2 + 1) == '(') {
                builder.add(string.substring(n, n2));
                int n3 = string.indexOf(41, n2 + 1);
                if (n3 == -1) {
                    throw new IllegalArgumentException("Unterminated macro variable");
                }
                String string2 = string.substring(n2 + 2, n3);
                if (!Template.isValidVariableName(string2)) {
                    throw new IllegalArgumentException("Invalid macro variable name '" + string2 + "'");
                }
                builder2.add(string2);
                n = n3 + 1;
                n2 = string.indexOf(36, n);
                continue;
            }
            n2 = string.indexOf(36, n2 + 1);
        }
        if (n == 0) {
            throw new IllegalArgumentException("No variables in macro");
        }
        if (n != string.length()) {
            builder.add(string.substring(n));
        }
        return new Template((List<String>)((Object)builder.build()), (List<String>)((Object)builder2.build()));
    }

    private static boolean isValidVariableName(String string) {
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (Character.isLetterOrDigit(c) || c == '_') continue;
            return false;
        }
        return true;
    }

    public String instantiate(Map<String, String> map) {
        return this.substitute(this.variables().stream().map(string -> map.getOrDefault(string, "")).toList());
    }

    private String substitute(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.variables.size(); ++i) {
            stringBuilder.append(this.segments.get(i)).append(list.get(i));
            if (stringBuilder.length() <= 2000000) continue;
            throw new IllegalArgumentException("Output too long (> 2000000)");
        }
        if (this.segments.size() > this.variables.size()) {
            stringBuilder.append(this.segments.get(this.segments.size() - 1));
            if (stringBuilder.length() > 2000000) {
                throw new IllegalArgumentException("Output too long (> 2000000)");
            }
        }
        return stringBuilder.toString();
    }
}

