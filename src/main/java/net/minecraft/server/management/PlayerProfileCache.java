/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import com.google.common.base.Charsets;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;

public class PlayerProfileCache {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private final Map<String, ProfileEntry> usernameToProfileEntryMap = Maps.newHashMap();
    private final Map<UUID, ProfileEntry> uuidToProfileEntryMap = Maps.newHashMap();
    private final LinkedList<GameProfile> gameProfiles = Lists.newLinkedList();
    private final MinecraftServer mcServer;
    protected final Gson gson;
    private final File usercacheFile;
    private static final ParameterizedType TYPE = new ParameterizedType(){

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{ProfileEntry.class};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    };

    public PlayerProfileCache(MinecraftServer minecraftServer, File file) {
        this.mcServer = minecraftServer;
        this.usercacheFile = file;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(ProfileEntry.class, new Serializer());
        this.gson = gsonBuilder.create();
        this.load();
    }

    private static GameProfile getGameProfile(MinecraftServer minecraftServer, String string) {
        final GameProfile[] gameProfileArray = new GameProfile[1];
        ProfileLookupCallback profileLookupCallback = new ProfileLookupCallback(){

            @Override
            public void onProfileLookupSucceeded(GameProfile gameProfile) {
                gameProfileArray[0] = gameProfile;
            }

            @Override
            public void onProfileLookupFailed(GameProfile gameProfile, Exception exception) {
                gameProfileArray[0] = null;
            }
        };
        minecraftServer.getGameProfileRepository().findProfilesByNames(new String[]{string}, Agent.MINECRAFT, profileLookupCallback);
        if (!minecraftServer.isServerInOnlineMode() && gameProfileArray[0] == null) {
            UUID uUID = EntityPlayer.getUUID(new GameProfile(null, string));
            GameProfile gameProfile = new GameProfile(uUID, string);
            profileLookupCallback.onProfileLookupSucceeded(gameProfile);
        }
        return gameProfileArray[0];
    }

    public void addEntry(GameProfile gameProfile) {
        this.addEntry(gameProfile, null);
    }

    private void addEntry(GameProfile gameProfile, Date date) {
        Object object;
        UUID uUID = gameProfile.getId();
        if (date == null) {
            object = Calendar.getInstance();
            ((Calendar)object).setTime(new Date());
            ((Calendar)object).add(2, 1);
            date = ((Calendar)object).getTime();
        }
        object = gameProfile.getName().toLowerCase(Locale.ROOT);
        ProfileEntry profileEntry = new ProfileEntry(gameProfile, date);
        if (this.uuidToProfileEntryMap.containsKey(uUID)) {
            ProfileEntry profileEntry2 = this.uuidToProfileEntryMap.get(uUID);
            this.usernameToProfileEntryMap.remove(profileEntry2.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(gameProfile);
        }
        this.usernameToProfileEntryMap.put(gameProfile.getName().toLowerCase(Locale.ROOT), profileEntry);
        this.uuidToProfileEntryMap.put(uUID, profileEntry);
        this.gameProfiles.addFirst(gameProfile);
        this.save();
    }

    public GameProfile getGameProfileForUsername(String string) {
        String string2 = string.toLowerCase(Locale.ROOT);
        ProfileEntry profileEntry = this.usernameToProfileEntryMap.get(string2);
        if (profileEntry != null && new Date().getTime() >= profileEntry.expirationDate.getTime()) {
            this.uuidToProfileEntryMap.remove(profileEntry.getGameProfile().getId());
            this.usernameToProfileEntryMap.remove(profileEntry.getGameProfile().getName().toLowerCase(Locale.ROOT));
            this.gameProfiles.remove(profileEntry.getGameProfile());
            profileEntry = null;
        }
        if (profileEntry != null) {
            GameProfile gameProfile = profileEntry.getGameProfile();
            this.gameProfiles.remove(gameProfile);
            this.gameProfiles.addFirst(gameProfile);
        } else {
            GameProfile gameProfile = PlayerProfileCache.getGameProfile(this.mcServer, string2);
            if (gameProfile != null) {
                this.addEntry(gameProfile);
                profileEntry = this.usernameToProfileEntryMap.get(string2);
            }
        }
        this.save();
        return profileEntry == null ? null : profileEntry.getGameProfile();
    }

    public String[] getUsernames() {
        ArrayList<String> arrayList = Lists.newArrayList(this.usernameToProfileEntryMap.keySet());
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public GameProfile getProfileByUUID(UUID uUID) {
        ProfileEntry profileEntry = this.uuidToProfileEntryMap.get(uUID);
        return profileEntry == null ? null : profileEntry.getGameProfile();
    }

    private ProfileEntry getByUUID(UUID uUID) {
        ProfileEntry profileEntry = this.uuidToProfileEntryMap.get(uUID);
        if (profileEntry != null) {
            GameProfile gameProfile = profileEntry.getGameProfile();
            this.gameProfiles.remove(gameProfile);
            this.gameProfiles.addFirst(gameProfile);
        }
        return profileEntry;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newReader(this.usercacheFile, Charsets.UTF_8);
            List list = (List)this.gson.fromJson((Reader)bufferedReader, (Type)TYPE);
            this.usernameToProfileEntryMap.clear();
            this.uuidToProfileEntryMap.clear();
            this.gameProfiles.clear();
            for (ProfileEntry profileEntry : Lists.reverse(list)) {
                if (profileEntry == null) continue;
                this.addEntry(profileEntry.getGameProfile(), profileEntry.getExpirationDate());
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            IOUtils.closeQuietly(bufferedReader);
        }
        catch (JsonParseException jsonParseException) {
            IOUtils.closeQuietly(bufferedReader);
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedReader);
            throw throwable;
        }
        IOUtils.closeQuietly(bufferedReader);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void save() {
        String string = this.gson.toJson(this.getEntriesWithLimit(1000));
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newWriter(this.usercacheFile, Charsets.UTF_8);
            bufferedWriter.write(string);
        }
        catch (FileNotFoundException fileNotFoundException) {
            IOUtils.closeQuietly(bufferedWriter);
        }
        catch (IOException iOException) {
            IOUtils.closeQuietly(bufferedWriter);
            return;
        }
        catch (Throwable throwable) {
            IOUtils.closeQuietly(bufferedWriter);
            throw throwable;
        }
        IOUtils.closeQuietly(bufferedWriter);
        return;
    }

    private List<ProfileEntry> getEntriesWithLimit(int n) {
        ArrayList<ProfileEntry> arrayList = Lists.newArrayList();
        for (GameProfile gameProfile : Lists.newArrayList(Iterators.limit(this.gameProfiles.iterator(), n))) {
            ProfileEntry profileEntry = this.getByUUID(gameProfile.getId());
            if (profileEntry == null) continue;
            arrayList.add(profileEntry);
        }
        return arrayList;
    }

    public class ProfileEntry {
        private final GameProfile gameProfile;
        private final Date expirationDate;

        private ProfileEntry(GameProfile gameProfile, Date date) {
            this.gameProfile = gameProfile;
            this.expirationDate = date;
        }

        public GameProfile getGameProfile() {
            return this.gameProfile;
        }

        public Date getExpirationDate() {
            return this.expirationDate;
        }
    }

    public class Serializer
    implements JsonDeserializer<ProfileEntry>,
    JsonSerializer<ProfileEntry> {
        private Serializer() {
        }

        @Override
        public JsonElement serialize(ProfileEntry profileEntry, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", profileEntry.getGameProfile().getName());
            UUID uUID = profileEntry.getGameProfile().getId();
            jsonObject.addProperty("uuid", uUID == null ? "" : uUID.toString());
            jsonObject.addProperty("expiresOn", dateFormat.format(profileEntry.getExpirationDate()));
            return jsonObject;
        }

        @Override
        public ProfileEntry deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonElement jsonElement2 = jsonObject.get("name");
                JsonElement jsonElement3 = jsonObject.get("uuid");
                JsonElement jsonElement4 = jsonObject.get("expiresOn");
                if (jsonElement2 != null && jsonElement3 != null) {
                    String string = jsonElement3.getAsString();
                    String string2 = jsonElement2.getAsString();
                    Date date = null;
                    if (jsonElement4 != null) {
                        try {
                            date = dateFormat.parse(jsonElement4.getAsString());
                        }
                        catch (ParseException parseException) {
                            date = null;
                        }
                    }
                    if (string2 != null && string != null) {
                        UUID uUID;
                        try {
                            uUID = UUID.fromString(string);
                        }
                        catch (Throwable throwable) {
                            return null;
                        }
                        PlayerProfileCache playerProfileCache = PlayerProfileCache.this;
                        Objects.requireNonNull(playerProfileCache);
                        ProfileEntry profileEntry = playerProfileCache.new ProfileEntry(new GameProfile(uUID, string2), date);
                        return profileEntry;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
    }
}

