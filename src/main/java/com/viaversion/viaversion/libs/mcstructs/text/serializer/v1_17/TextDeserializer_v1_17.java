package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_17;

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

public class TextDeserializer_v1_17 implements JsonDeserializer<TextComponent> {
   public TextComponent deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      if (var1.isJsonPrimitive()) {
         return new StringComponent(var1.getAsString());
      } else if (var1.isJsonArray()) {
         JsonArray var12 = var1.getAsJsonArray();
         TextComponent var13 = null;

         for (JsonElement var21 : var12) {
            TextComponent var24 = this.deserialize(var21, var21.getClass(), var3);
            if (var13 == null) {
               var13 = var24;
            } else {
               var13.append(var24);
            }
         }

         return var13;
      } else if (!var1.isJsonObject()) {
         throw new JsonParseException("Don't know how to turn " + var1 + " into a Component");
      } else {
         JsonObject var4 = var1.getAsJsonObject();
         Object var5;
         if (var4.has("text")) {
            var5 = new StringComponent(JsonUtils.getString(var4, "text"));
         } else if (var4.has("translate")) {
            String var6 = JsonUtils.getString(var4, "translate");
            if (var4.has("with")) {
               JsonArray var7 = var4.getAsJsonArray("with");
               Object[] var8 = new Object[var7.size()];

               for (int var9 = 0; var9 < var7.size(); var9++) {
                  TextComponent var10 = this.deserialize(var7.get(var9), var2, var3);
                  var8[var9] = var10;
                  if (var10 instanceof StringComponent) {
                     StringComponent var11 = (StringComponent)var10;
                     if (var11.getStyle().isEmpty() && var11.getSiblings().isEmpty()) {
                        var8[var9] = var11.getText();
                     }
                  }
               }

               var5 = new TranslationComponent(var6, var8);
            } else {
               var5 = new TranslationComponent(var6, new Object[0]);
            }
         } else if (var4.has("score")) {
            JsonObject var14 = var4.getAsJsonObject("score");
            if (!var14.has("name") || !var14.has("objective")) {
               throw new JsonParseException("A score component needs at least a name and an objective");
            }

            var5 = new ScoreComponent(JsonUtils.getString(var14, "name"), JsonUtils.getString(var14, "objective"));
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

            String var15 = JsonUtils.getString(var4, "nbt");
            boolean var19 = JsonUtils.getBoolean(var4, "interpret", false);
            TextComponent var22 = null;
            if (var4.has("separator")) {
               var22 = this.deserialize(var4.get("separator"), var2, var3);
            }

            if (var4.has("block")) {
               var5 = new NbtComponent(var15, var19, var22, new BlockNbtSource(JsonUtils.getString(var4, "block")));
            } else if (var4.has("entity")) {
               var5 = new NbtComponent(var15, var19, var22, new EntityNbtSource(JsonUtils.getString(var4, "entity")));
            } else {
               if (!var4.has("storage")) {
                  throw new JsonParseException("Don't know how to turn " + var1 + " into a Component");
               }

               var5 = new NbtComponent(var15, var19, var22, new StorageNbtSource(Identifier.of(JsonUtils.getString(var4, "storage"))));
            }
         }

         if (var4.has("extra")) {
            JsonArray var16 = var4.getAsJsonArray("extra");
            if (var16.isEmpty()) {
               throw new JsonParseException("Unexpected empty array of components");
            }

            for (JsonElement var23 : var16) {
               var5.append(this.deserialize(var23, var2, var3));
            }
         }

         Style var17 = (Style)var3.deserialize(var4, Style.class);
         if (var17 != null) {
            var5.setStyle(var17);
         }

         return (TextComponent)var5;
      }
   }
}
