/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.env;

import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.TypeDescription;
import com.viaversion.viaversion.libs.snakeyaml.constructor.AbstractConstruct;
import com.viaversion.viaversion.libs.snakeyaml.constructor.Constructor;
import com.viaversion.viaversion.libs.snakeyaml.error.MissingEnvironmentVariableException;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Node;
import com.viaversion.viaversion.libs.snakeyaml.nodes.ScalarNode;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Tag;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvScalarConstructor
extends Constructor {
    public static final Tag ENV_TAG = new Tag("!ENV");
    public static final Pattern ENV_FORMAT = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\S+)?)?)\\s*\\}$");

    public EnvScalarConstructor() {
        super(new LoaderOptions());
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public EnvScalarConstructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(typeDescription, collection, loaderOptions);
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public String apply(String string, String string2, String string3, String string4) {
        if (string4 != null && !string4.isEmpty()) {
            return string4;
        }
        if (string2 != null) {
            if (string2.equals("?") && string4 == null) {
                throw new MissingEnvironmentVariableException("Missing mandatory variable " + string + ": " + string3);
            }
            if (string2.equals(":?")) {
                if (string4 == null) {
                    throw new MissingEnvironmentVariableException("Missing mandatory variable " + string + ": " + string3);
                }
                if (string4.isEmpty()) {
                    throw new MissingEnvironmentVariableException("Empty mandatory variable " + string + ": " + string3);
                }
            }
            if (string2.startsWith(":") ? string4 == null || string4.isEmpty() : string4 == null) {
                return string3;
            }
        }
        return "";
    }

    public String getEnv(String string) {
        return System.getenv(string);
    }

    private class ConstructEnv
    extends AbstractConstruct {
        private ConstructEnv() {
        }

        @Override
        public Object construct(Node node) {
            String string = EnvScalarConstructor.this.constructScalar((ScalarNode)node);
            Matcher matcher = ENV_FORMAT.matcher(string);
            matcher.matches();
            String string2 = matcher.group("name");
            String string3 = matcher.group("value");
            String string4 = matcher.group("separator");
            return EnvScalarConstructor.this.apply(string2, string4, string3 != null ? string3 : "", EnvScalarConstructor.this.getEnv(string2));
        }
    }
}

