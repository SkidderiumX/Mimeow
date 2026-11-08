/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.TranslatableMappings;
import com.viaversion.viabackwards.api.rewriters.text.TranslatableRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NBTComponentRewriter<C extends ClientboundPacketType>
extends com.viaversion.viaversion.rewriter.text.NBTComponentRewriter<C>
implements TranslatableRewriter {
    private final Map<String, String> translatables;

    public NBTComponentRewriter(BackwardsProtocol<C, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
        this.translatables = TranslatableMappings.translatablesFor(backwardsProtocol);
    }

    public NBTComponentRewriter(BackwardsProtocol<C, ?, ?, ?> backwardsProtocol, String string) {
        super(backwardsProtocol);
        this.translatables = TranslatableMappings.translatablesFor(string);
    }

    @Override
    protected void handleTranslate(JsonObject jsonObject, String string) {
        String string2 = this.mappedTranslationKey(string);
        if (string2 != null) {
            jsonObject.addProperty("translate", string2);
        }
    }

    @Override
    protected void handleTranslate(UserConnection userConnection, CompoundTag compoundTag, StringTag stringTag) {
        String string = this.mappedTranslationKey(stringTag.getValue());
        if (string != null) {
            compoundTag.put("translate", new StringTag(string));
        }
    }

    @Override
    public @Nullable String mappedTranslationKey(String string) {
        return this.translatables.get(string);
    }
}

