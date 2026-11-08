/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.HashMap;
import java.util.Map;

public class WindowTracker
extends StoredObject {
    private final HashMap<Short, String> types = new HashMap();
    private final HashMap<Short, Item[]> brewingItems = new HashMap();
    private final Map<Short, Short> enchantmentProperties = new HashMap<Short, Short>();

    public WindowTracker(UserConnection userConnection) {
        super(userConnection);
    }

    public static void updateBrewingStand(UserConnection userConnection, Item item, short s) {
        if (item != null && item.identifier() != 377) {
            return;
        }
        int n = item == null ? 0 : item.amount();
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_8.OPEN_SCREEN, userConnection);
        packetWrapper.write(Types.UNSIGNED_BYTE, s);
        packetWrapper.write(Types.STRING, "minecraft:brewing_stand");
        TextComponent textComponent = new StringComponent().append((TextComponent)new TranslationComponent("container.brewing", new Object[0])).append(new StringComponent(": ").formatted(TextFormatting.DARK_GRAY)).append(new StringComponent(n + " ").formatted(TextFormatting.DARK_RED)).append(new TranslationComponent("item.blazePowder.name", new Object[0]).formatted(TextFormatting.DARK_RED));
        packetWrapper.write(Types.COMPONENT, TextComponentSerializer.V1_8.serializeJson(textComponent));
        packetWrapper.write(Types.UNSIGNED_BYTE, (short)420);
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
        Item[] itemArray = userConnection.get(WindowTracker.class).getBrewingItems(s);
        for (int i = 0; i < itemArray.length; ++i) {
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.CONTAINER_SET_SLOT, userConnection);
            packetWrapper2.write(Types.BYTE, (byte)s);
            packetWrapper2.write(Types.SHORT, (short)i);
            packetWrapper2.write(Types.ITEM1_8, itemArray[i]);
            packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
        }
    }

    public String get(short s) {
        return this.types.get(s);
    }

    public void put(short s, String string) {
        this.types.put(s, string);
    }

    public void remove(short s) {
        this.types.remove(s);
        this.brewingItems.remove(s);
    }

    /*
     * Exception decompiling
     */
    public Item[] getBrewingItems(short var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.UnsupportedOperationException
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.NewAnonymousArray.getDimSize(NewAnonymousArray.java:142)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.isNewArrayLambda(LambdaRewriter.java:455)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:409)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:167)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:105)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractMemberFunctionInvokation.applyExpressionRewriterToArgs(AbstractMemberFunctionInvokation.java:101)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractMemberFunctionInvokation.applyExpressionRewriter(AbstractMemberFunctionInvokation.java:88)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:103)
         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.rewriteExpressions(StructuredReturn.java:99)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewrite(LambdaRewriter.java:88)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.rewriteLambdas(Op04StructuredStatement.java:1137)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:912)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public short getEnchantmentValue(short s) {
        if (!this.enchantmentProperties.containsKey(s)) {
            return 0;
        }
        return this.enchantmentProperties.remove(s);
    }

    public void putEnchantmentProperty(short s, short s2) {
        this.enchantmentProperties.put(s, s2);
    }

    public void clearEnchantmentProperties() {
        this.enchantmentProperties.clear();
    }
}

