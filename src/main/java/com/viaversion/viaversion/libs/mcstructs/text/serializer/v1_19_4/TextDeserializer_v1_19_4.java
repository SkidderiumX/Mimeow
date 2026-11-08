package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_19_4;

import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonDeserializationContext;
import com.viaversion.viaversion.libs.gson.JsonDeserializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.utils.JsonUtils;
import java.lang.reflect.Type;

public class TextDeserializer_v1_19_4 implements JsonDeserializer<TextComponent> {
   public TextComponent deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      if (var1.isJsonPrimitive()) {
         return new StringComponent(var1.getAsString());
      } else if (var1.isJsonArray()) {
         JsonArray var13 = var1.getAsJsonArray();
         TextComponent var14 = null;

         for (JsonElement var22 : var13) {
            TextComponent var25 = this.deserialize(var22, var22.getClass(), var3);
            if (var14 == null) {
               var14 = var25;
            } else {
               var14.append(var25);
            }
         }

         return var14;
      } else if (!var1.isJsonObject()) {
         throw new JsonParseException("Don't know how to turn " + var1 + " into a Component");
      } else {
         JsonObject var4 = var1.getAsJsonObject();
         Object var5;
         if (var4.has("text")) {
            var5 = new StringComponent(JsonUtils.getString(var4, "text"));
         } else if (var4.has("translate")) {
            String var6 = JsonUtils.getString(var4, "translate");
            String var7 = JsonUtils.getString(var4, "fallback", null);
            if (var4.has("with")) {
               JsonArray var8 = var4.getAsJsonArray("with");
               Object[] var9 = new Object[var8.size()];

               for (int var10 = 0; var10 < var8.size(); var10++) {
                  TextComponent var11 = this.deserialize(var8.get(var10), var2, var3);
                  var9[var10] = var11;
                  if (var11 instanceof StringComponent) {
                     StringComponent var12 = (StringComponent)var11;
                     if (var12.getStyle().isEmpty() && var12.getSiblings().isEmpty()) {
                        var9[var10] = var12.getText();
                     }
                  }
               }

               var5 = new TranslationComponent(var6, var9).setFallback(var7);
            } else {
               var5 = new TranslationComponent(var6, new Object[0]).setFallback(var7);
            }
         } else if (var4.has("score")) {
            JsonObject var15 = var4.getAsJsonObject("score");
            if (!var15.has("name") || !var15.has("objective")) {
               throw new JsonParseException("A score component needs at least a name and an objective");
            }

            var5 = new ScoreComponent(JsonUtils.getString(var15, "name"), JsonUtils.getString(var15, "objective"));
         } else if (var4.has("selector")) {
            if (var4.has("separator")) {
               var5 = new SelectorComponent(JsonUtils.getString(var4, "selector"), this.deserialize(var4.get("separator"), var2, var3));
            } else {
               var5 = new SelectorComponent(JsonUtils.getString(var4, "selector"), null);
            }
         } else if (var4.has("keybind")) {
            var5 = new KeybindComponent(JsonUtils.getString(var4, "keybind"));
         } else {
            if (!var4.has("nbt")) {
               throw new JsonParseException("Don't know how to turn " + var1 + " into a Component");
            }

            String var16 = JsonUtils.getString(var4, "nbt");
            boolean var20 = JsonUtils.getBoolean(var4, "interpret", false);
            TextComponent var23 = null;
            if (var4.has("separator")) {
               var23 = this.deserialize(var4.get("separator"), var2, var3);
            }

            if (var4.has("block")) {
               var5 = new NbtComponent(var16, var20, var23, new BlockNbtSource(JsonUtils.getString(var4, "block")));
            } else if (var4.has("entity")) {
               var5 = new NbtComponent(var16, var20, var23, new EntityNbtSource(JsonUtils.getString(var4, "entity")));
            } else {
               if (!var4.has("storage")) {
                  throw new JsonParseException("Don't know how to turn " + var1 + " into a Component");
               }

               var5 = new NbtComponent(var16, var20, var23, new StorageNbtSource(Identifier.of(JsonUtils.getString(var4, "storage"))));
            }
         }

         if (var4.has("extra")) {
            JsonArray var17 = var4.getAsJsonArray("extra");
            if (var17.isEmpty()) {
               throw new JsonParseException("Unexpected empty array of components");
            }

            for (JsonElement var24 : var17) {
               var5.append(this.deserialize(var24, var2, var3));
            }
         }

         Style var18 = (Style)var3.deserialize(var4, Style.class);
         if (var18 != null) {
            var5.setStyle(var18);
         }

         return (TextComponent)var5;
      }
   }
}
