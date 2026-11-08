/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.converter.ConsumerTracking;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import lombok.Generated;

public class TranslationComponent
extends TextComponent {
    private static final Pattern ARG_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
    private String key;
    private Object[] args;
    @Nullable
    private String fallback;
    private Translator translator = Translator.GLOBAL;

    public TranslationComponent(String string, List<?> list) {
        this.key = string;
        this.args = list.toArray();
    }

    public TranslationComponent(String string, Object ... objectArray) {
        this.key = string;
        this.args = objectArray;
    }

    public String getKey() {
        return this.key;
    }

    public TranslationComponent setKey(String string) {
        this.key = string;
        return this;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public TranslationComponent setArgs(Object[] objectArray) {
        this.args = objectArray;
        return this;
    }

    @Nullable
    public String getFallback() {
        return this.fallback;
    }

    public TranslationComponent setFallback(@Nullable String string) {
        this.fallback = string;
        return this;
    }

    public TranslationComponent setTranslator(@Nullable Translator translator) {
        this.translator = translator == null ? Translator.GLOBAL : translator;
        return this;
    }

    public TextComponent resolveIntoComponents() {
        ArrayList<TextComponent> arrayList = new ArrayList<TextComponent>();
        String string = this.translator.translate(this.key);
        if (string == null) {
            string = this.fallback;
        }
        if (string == null) {
            string = this.key;
        }
        Matcher matcher = ARG_PATTERN.matcher(string);
        int n = 0;
        int n2 = 0;
        while (matcher.find(n2)) {
            int n3 = matcher.start();
            int n4 = matcher.end();
            if (n3 > n2) {
                arrayList.add(new StringComponent(String.format(string.substring(n2, n3), new Object[0])));
            }
            n2 = n4;
            String string2 = matcher.group(2);
            String string3 = string.substring(n3, n4);
            if (string2.equals("%") && string3.equals("%%")) {
                arrayList.add(new StringComponent("%"));
                continue;
            }
            if (!string2.equals("s")) {
                throw new IllegalStateException("Unsupported format: '" + string3 + "'");
            }
            String string4 = matcher.group(1);
            int n5 = string4 == null ? n++ : Integer.parseInt(string4) - 1;
            if (n5 >= this.args.length) continue;
            Object object = this.args[n5];
            if (object instanceof TextComponent) {
                arrayList.add((TextComponent)object);
                continue;
            }
            if (object == null) {
                arrayList.add(new StringComponent("null"));
                continue;
            }
            arrayList.add(new StringComponent(object.toString()));
        }
        if (n2 < string.length()) {
            arrayList.add(new StringComponent(String.format(string.substring(n2), new Object[0])));
        }
        StringComponent stringComponent = new StringComponent();
        stringComponent.setStyle(this.getStyle());
        arrayList.forEach(stringComponent::append);
        return stringComponent;
    }

    @Override
    public String asLegacyFormatString() {
        return this.resolveIntoComponents().asLegacyFormatString();
    }

    @Override
    public String asSingleString() {
        return this.resolveIntoComponents().asUnformattedString();
    }

    @Override
    public void asSingleString(ConsumerTracking consumerTracking, TextComponent.ComponentConsumer componentConsumer) {
        if (componentConsumer instanceof TranslatableContentConsumer) {
            if (consumerTracking != null) {
                consumerTracking.setCurrentConsumer(componentConsumer);
            }
            this.resolveIntoComponents().visit(consumerTracking, componentConsumer);
        } else {
            TranslatableContentConsumer translatableContentConsumer = new TranslatableContentConsumer(componentConsumer);
            if (consumerTracking != null) {
                consumerTracking.setCurrentConsumer(translatableContentConsumer);
            }
            this.resolveIntoComponents().visit(consumerTracking, translatableContentConsumer);
        }
    }

    @Override
    public TextComponent shallowCopy() {
        Object[] objectArray = new Object[this.args.length];
        for (int i = 0; i < this.args.length; ++i) {
            Object object = this.args[i];
            objectArray[i] = object instanceof TextComponent ? ((TextComponent)object).copy() : object;
        }
        TranslationComponent translationComponent = new TranslationComponent(this.key, objectArray);
        translationComponent.translator = this.translator;
        return translationComponent.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), list -> !list.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("key", this.key).add("args", this.args, objectArray -> ((Object[])objectArray).length > 0, Arrays::toString).add("translator", this.translator, translator -> translator != Translator.GLOBAL).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TranslationComponent)) {
            return false;
        }
        TranslationComponent translationComponent = (TranslationComponent)object;
        if (!translationComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        String string = this.getKey();
        String string2 = translationComponent.getKey();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        if (!Arrays.deepEquals(this.getArgs(), translationComponent.getArgs())) {
            return false;
        }
        String string3 = this.getFallback();
        String string4 = translationComponent.getFallback();
        if (string3 == null ? string4 != null : !string3.equals(string4)) {
            return false;
        }
        Translator translator = this.translator;
        Translator translator2 = translationComponent.translator;
        return !(translator == null ? translator2 != null : !translator.equals(translator2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof TranslationComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        String string = this.getKey();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        n2 = n2 * 59 + Arrays.deepHashCode(this.getArgs());
        String string2 = this.getFallback();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        Translator translator = this.translator;
        n2 = n2 * 59 + (translator == null ? 43 : translator.hashCode());
        return n2;
    }

    private static final class TranslatableContentConsumer
    implements TextComponent.ComponentConsumer {
        private static final IllegalArgumentException EX = new IllegalArgumentException("Too long");
        private final TextComponent.ComponentConsumer runnable;
        private int visited;

        private TranslatableContentConsumer(TextComponent.ComponentConsumer componentConsumer) {
            this.runnable = componentConsumer;
        }

        @Override
        public void accept(String string) {
            if (this.visited++ > 32) {
                throw EX;
            }
            this.runnable.accept(string);
        }

        @Override
        public TextComponent.ComponentConsumer withConsumer(TextComponent.ComponentConsumer componentConsumer) {
            TranslatableContentConsumer translatableContentConsumer = new TranslatableContentConsumer(componentConsumer);
            translatableContentConsumer.visited = this.visited;
            return translatableContentConsumer;
        }
    }
}

