/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.MessagePattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagePatternUtil {
    private MessagePatternUtil() {
    }

    public static MessageNode buildMessageNode(String string) {
        return MessagePatternUtil.buildMessageNode(new MessagePattern(string));
    }

    public static MessageNode buildMessageNode(MessagePattern messagePattern) {
        int n = messagePattern.countParts() - 1;
        if (n < 0) {
            throw new IllegalArgumentException("The MessagePattern is empty");
        }
        if (messagePattern.getPartType(0) != MessagePattern.Part.Type.MSG_START) {
            throw new IllegalArgumentException("The MessagePattern does not represent a MessageFormat pattern");
        }
        return MessagePatternUtil.buildMessageNode(messagePattern, 0, n);
    }

    private static MessageNode buildMessageNode(MessagePattern messagePattern, int n, int n2) {
        int n3 = messagePattern.getPart(n).getLimit();
        MessageNode messageNode = new MessageNode();
        int n4 = n + 1;
        while (true) {
            MessagePattern.Part part;
            int n5;
            if (n3 < (n5 = (part = messagePattern.getPart(n4)).getIndex())) {
                messageNode.addContentsNode(new TextNode(messagePattern.getPatternString().substring(n3, n5)));
            }
            if (n4 == n2) break;
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.ARG_START) {
                int n6 = messagePattern.getLimitPartIndex(n4);
                messageNode.addContentsNode(MessagePatternUtil.buildArgNode(messagePattern, n4, n6));
                n4 = n6;
                part = messagePattern.getPart(n4);
            } else if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                messageNode.addContentsNode(MessageContentsNode.createReplaceNumberNode());
            }
            n3 = part.getLimit();
            ++n4;
        }
        return messageNode.freeze();
    }

    private static ArgNode buildArgNode(MessagePattern messagePattern, int n, int n2) {
        ArgNode argNode = ArgNode.createArgNode();
        MessagePattern.Part part = messagePattern.getPart(n);
        MessagePattern.ArgType argType = argNode.argType = part.getArgType();
        part = messagePattern.getPart(++n);
        argNode.name = messagePattern.getSubstring(part);
        if (part.getType() == MessagePattern.Part.Type.ARG_NUMBER) {
            argNode.number = part.getValue();
        }
        ++n;
        switch (argType) {
            case SIMPLE: {
                argNode.typeName = messagePattern.getSubstring(messagePattern.getPart(n++));
                if (n >= n2) break;
                argNode.style = messagePattern.getSubstring(messagePattern.getPart(n));
                break;
            }
            case CHOICE: {
                argNode.typeName = "choice";
                argNode.complexStyle = MessagePatternUtil.buildChoiceStyleNode(messagePattern, n, n2);
                break;
            }
            case PLURAL: {
                argNode.typeName = "plural";
                argNode.complexStyle = MessagePatternUtil.buildPluralStyleNode(messagePattern, n, n2, argType);
                break;
            }
            case SELECT: {
                argNode.typeName = "select";
                argNode.complexStyle = MessagePatternUtil.buildSelectStyleNode(messagePattern, n, n2);
                break;
            }
            case SELECTORDINAL: {
                argNode.typeName = "selectordinal";
                argNode.complexStyle = MessagePatternUtil.buildPluralStyleNode(messagePattern, n, n2, argType);
                break;
            }
        }
        return argNode;
    }

    private static ComplexArgStyleNode buildChoiceStyleNode(MessagePattern messagePattern, int n, int n2) {
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(MessagePattern.ArgType.CHOICE);
        while (n < n2) {
            int n3 = n;
            MessagePattern.Part part = messagePattern.getPart(n);
            double d = messagePattern.getNumericValue(part);
            int n4 = messagePattern.getLimitPartIndex(n += 2);
            VariantNode variantNode = new VariantNode();
            variantNode.selector = messagePattern.getSubstring(messagePattern.getPart(n3 + 1));
            variantNode.numericValue = d;
            variantNode.msgNode = MessagePatternUtil.buildMessageNode(messagePattern, n, n4);
            complexArgStyleNode.addVariant(variantNode);
            n = n4 + 1;
        }
        return complexArgStyleNode.freeze();
    }

    private static ComplexArgStyleNode buildPluralStyleNode(MessagePattern messagePattern, int n, int n2, MessagePattern.ArgType argType) {
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(argType);
        MessagePattern.Part part = messagePattern.getPart(n);
        if (part.getType().hasNumericValue()) {
            complexArgStyleNode.explicitOffset = true;
            complexArgStyleNode.offset = messagePattern.getNumericValue(part);
            ++n;
        }
        while (n < n2) {
            MessagePattern.Part part2 = messagePattern.getPart(n++);
            double d = -1.23456789E8;
            MessagePattern.Part part3 = messagePattern.getPart(n);
            if (part3.getType().hasNumericValue()) {
                d = messagePattern.getNumericValue(part3);
                ++n;
            }
            int n3 = messagePattern.getLimitPartIndex(n);
            VariantNode variantNode = new VariantNode();
            variantNode.selector = messagePattern.getSubstring(part2);
            variantNode.numericValue = d;
            variantNode.msgNode = MessagePatternUtil.buildMessageNode(messagePattern, n, n3);
            complexArgStyleNode.addVariant(variantNode);
            n = n3 + 1;
        }
        return complexArgStyleNode.freeze();
    }

    private static ComplexArgStyleNode buildSelectStyleNode(MessagePattern messagePattern, int n, int n2) {
        ComplexArgStyleNode complexArgStyleNode = new ComplexArgStyleNode(MessagePattern.ArgType.SELECT);
        while (n < n2) {
            MessagePattern.Part part = messagePattern.getPart(n++);
            int n3 = messagePattern.getLimitPartIndex(n);
            VariantNode variantNode = new VariantNode();
            variantNode.selector = messagePattern.getSubstring(part);
            variantNode.msgNode = MessagePatternUtil.buildMessageNode(messagePattern, n, n3);
            complexArgStyleNode.addVariant(variantNode);
            n = n3 + 1;
        }
        return complexArgStyleNode.freeze();
    }

    public static class VariantNode
    extends Node {
        private String selector;
        private double numericValue = -1.23456789E8;
        private MessageNode msgNode;

        public String getSelector() {
            return this.selector;
        }

        public boolean isSelectorNumeric() {
            return this.numericValue != -1.23456789E8;
        }

        public double getSelectorValue() {
            return this.numericValue;
        }

        public MessageNode getMessage() {
            return this.msgNode;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.isSelectorNumeric()) {
                stringBuilder.append(this.numericValue).append(" (").append(this.selector).append(") {");
            } else {
                stringBuilder.append(this.selector).append(" {");
            }
            return stringBuilder.append(this.msgNode.toString()).append('}').toString();
        }

        private VariantNode() {
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ComplexArgStyleNode
    extends Node {
        private MessagePattern.ArgType argType;
        private double offset;
        private boolean explicitOffset;
        private List<VariantNode> list = new ArrayList<VariantNode>();

        public MessagePattern.ArgType getArgType() {
            return this.argType;
        }

        public boolean hasExplicitOffset() {
            return this.explicitOffset;
        }

        public double getOffset() {
            return this.offset;
        }

        public List<VariantNode> getVariants() {
            return this.list;
        }

        public VariantNode getVariantsByType(List<VariantNode> list, List<VariantNode> list2) {
            if (list != null) {
                list.clear();
            }
            list2.clear();
            VariantNode variantNode = null;
            for (VariantNode variantNode2 : this.list) {
                if (variantNode2.isSelectorNumeric()) {
                    list.add(variantNode2);
                    continue;
                }
                if ("other".equals(variantNode2.getSelector())) {
                    if (variantNode != null) continue;
                    variantNode = variantNode2;
                    continue;
                }
                list2.add(variantNode2);
            }
            return variantNode;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('(').append(this.argType.toString()).append(" style) ");
            if (this.hasExplicitOffset()) {
                stringBuilder.append("offset:").append(this.offset).append(' ');
            }
            return stringBuilder.append(this.list.toString()).toString();
        }

        private ComplexArgStyleNode(MessagePattern.ArgType argType) {
            this.argType = argType;
        }

        private void addVariant(VariantNode variantNode) {
            this.list.add(variantNode);
        }

        private ComplexArgStyleNode freeze() {
            this.list = Collections.unmodifiableList(this.list);
            return this;
        }
    }

    public static class ArgNode
    extends MessageContentsNode {
        private MessagePattern.ArgType argType;
        private String name;
        private int number = -1;
        private String typeName;
        private String style;
        private ComplexArgStyleNode complexStyle;

        public MessagePattern.ArgType getArgType() {
            return this.argType;
        }

        public String getName() {
            return this.name;
        }

        public int getNumber() {
            return this.number;
        }

        public String getTypeName() {
            return this.typeName;
        }

        public String getSimpleStyle() {
            return this.style;
        }

        public ComplexArgStyleNode getComplexStyle() {
            return this.complexStyle;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('{').append(this.name);
            if (this.argType != MessagePattern.ArgType.NONE) {
                stringBuilder.append(',').append(this.typeName);
                if (this.argType == MessagePattern.ArgType.SIMPLE) {
                    if (this.style != null) {
                        stringBuilder.append(',').append(this.style);
                    }
                } else {
                    stringBuilder.append(',').append(this.complexStyle.toString());
                }
            }
            return stringBuilder.append('}').toString();
        }

        private ArgNode() {
            super(MessageContentsNode.Type.ARG);
        }

        private static ArgNode createArgNode() {
            return new ArgNode();
        }
    }

    public static class TextNode
    extends MessageContentsNode {
        private String text;

        public String getText() {
            return this.text;
        }

        public String toString() {
            return "\u00ab" + this.text + "\u00bb";
        }

        private TextNode(String string) {
            super(MessageContentsNode.Type.TEXT);
            this.text = string;
        }
    }

    public static class MessageContentsNode
    extends Node {
        private Type type;

        public Type getType() {
            return this.type;
        }

        public String toString() {
            return "{REPLACE_NUMBER}";
        }

        private MessageContentsNode(Type type) {
            this.type = type;
        }

        private static MessageContentsNode createReplaceNumberNode() {
            return new MessageContentsNode(Type.REPLACE_NUMBER);
        }

        /*
         * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
         */
        public static enum Type {
            TEXT,
            ARG,
            REPLACE_NUMBER;

        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class MessageNode
    extends Node {
        private List<MessageContentsNode> list = new ArrayList<MessageContentsNode>();

        public List<MessageContentsNode> getContents() {
            return this.list;
        }

        public String toString() {
            return this.list.toString();
        }

        private MessageNode() {
        }

        private void addContentsNode(MessageContentsNode messageContentsNode) {
            MessageContentsNode messageContentsNode2;
            if (messageContentsNode instanceof TextNode && !this.list.isEmpty() && (messageContentsNode2 = this.list.get(this.list.size() - 1)) instanceof TextNode) {
                TextNode textNode = (TextNode)messageContentsNode2;
                textNode.text = textNode.text + ((TextNode)messageContentsNode).text;
                return;
            }
            this.list.add(messageContentsNode);
        }

        private MessageNode freeze() {
            this.list = Collections.unmodifiableList(this.list);
            return this;
        }
    }

    public static class Node {
        private Node() {
        }
    }
}

