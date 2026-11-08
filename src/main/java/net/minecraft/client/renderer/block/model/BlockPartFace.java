/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.JsonUtils;

public class BlockPartFace {
    public static final EnumFacing FACING_DEFAULT = null;
    public final EnumFacing cullFace;
    public final int tintIndex;
    public final String texture;
    public final BlockFaceUV blockFaceUV;

    public BlockPartFace(EnumFacing enumFacing, int n, String string, BlockFaceUV blockFaceUV) {
        this.cullFace = enumFacing;
        this.tintIndex = n;
        this.texture = string;
        this.blockFaceUV = blockFaceUV;
    }

    public static class Deserializer
    implements JsonDeserializer<BlockPartFace> {
        Deserializer() {
        }

        @Override
        public BlockPartFace deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            EnumFacing enumFacing = this.parseCullFace(jsonObject);
            int n = this.parseTintIndex(jsonObject);
            String string = this.parseTexture(jsonObject);
            BlockFaceUV blockFaceUV = (BlockFaceUV)jsonDeserializationContext.deserialize(jsonObject, (Type)((Object)BlockFaceUV.class));
            return new BlockPartFace(enumFacing, n, string, blockFaceUV);
        }

        protected int parseTintIndex(JsonObject jsonObject) {
            return JsonUtils.getInt(jsonObject, "tintindex", -1);
        }

        private String parseTexture(JsonObject jsonObject) {
            return JsonUtils.getString(jsonObject, "texture");
        }

        private EnumFacing parseCullFace(JsonObject jsonObject) {
            String string = JsonUtils.getString(jsonObject, "cullface", "");
            return EnumFacing.byName(string);
        }
    }
}

