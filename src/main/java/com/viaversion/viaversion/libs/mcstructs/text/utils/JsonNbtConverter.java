/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.MixedListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonNull;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public class JsonNbtConverter {
    @Nullable
    public static JsonElement toJson(@Nullable Tag tag) {
        if (tag == null) {
            return null;
        }
        if (tag instanceof NumberTag) {
            return new JsonPrimitive(((NumberTag)tag).getValue());
        }
        if (tag instanceof ByteArrayTag) {
            JsonArray jsonArray = new JsonArray();
            for (byte by : ((ByteArrayTag)tag).getValue()) {
                jsonArray.add(by);
            }
            return jsonArray;
        }
        if (tag instanceof StringTag) {
            return new JsonPrimitive(((StringTag)tag).getValue());
        }
        if (tag instanceof ListTag) {
            JsonArray jsonArray = new JsonArray();
            ListTag listTag = (ListTag)tag;
            Iterator iterator2 = listTag.getValue().iterator();
            while (iterator2.hasNext()) {
                Tag tag2;
                CompoundTag compoundTag;
                Tag tag3 = (Tag)iterator2.next();
                if (CompoundTag.class == listTag.getElementType() && (compoundTag = (CompoundTag)tag3).size() == 1 && (tag2 = compoundTag.get("")) != null) {
                    tag3 = tag2;
                }
                jsonArray.add(JsonNbtConverter.toJson(tag3));
            }
            return jsonArray;
        }
        if (tag instanceof CompoundTag) {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : ((CompoundTag)tag).getValue().entrySet()) {
                jsonObject.add((String)entry.getKey(), JsonNbtConverter.toJson((Tag)entry.getValue()));
            }
            return jsonObject;
        }
        if (tag instanceof IntArrayTag) {
            JsonArray jsonArray = new JsonArray();
            for (int n : ((IntArrayTag)tag).getValue()) {
                jsonArray.add(n);
            }
            return jsonArray;
        }
        if (tag instanceof LongArrayTag) {
            JsonArray jsonArray = new JsonArray();
            for (long l : ((LongArrayTag)tag).getValue()) {
                jsonArray.add(l);
            }
            return jsonArray;
        }
        throw new IllegalArgumentException("Unknown Nbt type: " + tag);
    }

    @Nullable
    public static Tag toNbt(@Nullable JsonElement jsonElement) {
        if (jsonElement == null) {
            return null;
        }
        if (jsonElement instanceof JsonObject) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            CompoundTag compoundTag = new CompoundTag();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                compoundTag.put(entry.getKey(), JsonNbtConverter.toNbt(entry.getValue()));
            }
            return compoundTag;
        }
        if (jsonElement instanceof JsonArray) {
            Object object;
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            ArrayList<Tag> arrayList = new ArrayList<Tag>();
            Tag tag = null;
            for (Object object2 : jsonArray) {
                Tag tag2 = JsonNbtConverter.toNbt((JsonElement)object2);
                arrayList.add(tag2);
                tag = JsonNbtConverter.getListType(tag, tag2);
            }
            if (tag == null) {
                return new ListTag();
            }
            if (tag instanceof MixedListTag) {
                object = new ListTag();
                for (Tag tag2 : arrayList) {
                    if (tag2 instanceof CompoundTag) {
                        ((ListTag)object).add((CompoundTag)tag2);
                        continue;
                    }
                    CompoundTag compoundTag = new CompoundTag();
                    compoundTag.put("", tag2);
                    ((ListTag)object).add(compoundTag);
                }
                return object;
            }
            if (tag instanceof ByteTag) {
                object = new byte[arrayList.size()];
                for (int i = 0; i < arrayList.size(); ++i) {
                    object[i] = ((NumberTag)arrayList.get(i)).asByte();
                }
                return new ByteArrayTag((byte[])object);
            }
            if (tag instanceof IntTag) {
                object = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); ++i) {
                    object[i] = ((NumberTag)arrayList.get(i)).asInt();
                }
                return new IntArrayTag((int[])object);
            }
            if (tag instanceof LongTag) {
                object = new long[arrayList.size()];
                for (int i = 0; i < arrayList.size(); ++i) {
                    object[i] = ((NumberTag)arrayList.get(i)).asLong();
                }
                return new LongArrayTag((long[])object);
            }
            return new ListTag(arrayList);
        }
        if (jsonElement instanceof JsonNull) {
            return null;
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (jsonPrimitive.isString()) {
                return new StringTag(jsonPrimitive.getAsString());
            }
            if (jsonPrimitive.isBoolean()) {
                return new ByteTag(jsonPrimitive.getAsBoolean());
            }
            BigDecimal bigDecimal = jsonPrimitive.getAsBigDecimal();
            try {
                long l = bigDecimal.longValueExact();
                if ((long)((byte)l) == l) {
                    return new ByteTag((byte)l);
                }
                if ((long)((short)l) == l) {
                    return new ShortTag((short)l);
                }
                if ((long)((int)l) == l) {
                    return new IntTag((int)l);
                }
                return new LongTag(l);
            }
            catch (ArithmeticException arithmeticException) {
                double d = bigDecimal.doubleValue();
                if ((double)((float)d) == d) {
                    return new FloatTag((float)d);
                }
                return new DoubleTag(d);
            }
        }
        throw new IllegalArgumentException("Unknown JsonElement type: " + jsonElement.getClass().getName());
    }

    private static Tag getListType(Tag tag, Tag tag2) {
        if (tag == null) {
            return tag2;
        }
        if (tag != tag2) {
            return new MixedListTag();
        }
        return tag;
    }
}

