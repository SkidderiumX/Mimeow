/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.realmsclient.RealmsVersion;
import com.mojang.realmsclient.client.RealmsClientConfig;
import com.mojang.realmsclient.client.RealmsError;
import com.mojang.realmsclient.client.Request;
import com.mojang.realmsclient.dto.BackupList;
import com.mojang.realmsclient.dto.Ops;
import com.mojang.realmsclient.dto.PendingInvitesList;
import com.mojang.realmsclient.dto.PingResult;
import com.mojang.realmsclient.dto.PlayerInfo;
import com.mojang.realmsclient.dto.RealmsDescriptionDto;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.RealmsServerAddress;
import com.mojang.realmsclient.dto.RealmsServerList;
import com.mojang.realmsclient.dto.RealmsServerPlayerLists;
import com.mojang.realmsclient.dto.RealmsWorldOptions;
import com.mojang.realmsclient.dto.RealmsWorldResetDto;
import com.mojang.realmsclient.dto.ServerActivityList;
import com.mojang.realmsclient.dto.Subscription;
import com.mojang.realmsclient.dto.UploadInfo;
import com.mojang.realmsclient.dto.WorldDownload;
import com.mojang.realmsclient.dto.WorldTemplateList;
import com.mojang.realmsclient.exception.RealmsHttpException;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.exception.RetryCallException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsSharedConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsClient {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String sessionId;
    private final String username;
    private static String baseUrl = "mcoapi.minecraft.net";
    private static String protocol = "https";
    private static final String WORLDS_RESOURCE_PATH = "worlds";
    private static final String INVITES_RESOURCE_PATH = "invites";
    private static final String MCO_RESOURCE_PATH = "mco";
    private static final String SUBSCRIPTION_RESOURCE = "subscriptions";
    private static final String ACTIVITIES_RESOURCE = "activities";
    private static final String OPS_RESOURCE = "ops";
    private static final String REGIONS_RESOURCE = "regions/ping/stat";
    private static final String TRIALS_RESOURCE = "trial";
    private static final String PATH_INITIALIZE = "/$WORLD_ID/initialize";
    private static final String PATH_GET_ACTIVTIES = "/$WORLD_ID";
    private static final String PATH_GET_LIVESTATS = "/liveplayerlist";
    private static final String PATH_GET_SUBSCRIPTION = "/$WORLD_ID";
    private static final String PATH_GET_MINIGAMES = "/minigames";
    private static final String PATH_OP = "/$WORLD_ID/$PROFILE_UUID";
    private static final String PATH_PUT_INTO_MINIGAMES_MODE = "/minigames/$MINIGAME_ID/$WORLD_ID";
    private static final String PATH_AVAILABLE = "/available";
    private static final String PATH_TEMPLATES = "/templates";
    private static final String PATH_WORLD_JOIN = "/$ID/join";
    private static final String PATH_WORLD_GET = "/$ID";
    private static final String PATH_WORLD_INVITES = "/$WORLD_ID";
    private static final String PATH_WORLD_UNINVITE = "/$WORLD_ID/invite/$UUID";
    private static final String PATH_PENDING_INVITES_COUNT = "/count/pending";
    private static final String PATH_PENDING_INVITES = "/pending";
    private static final String PATH_ACCEPT_INVITE = "/accept/$INVITATION_ID";
    private static final String PATH_REJECT_INVITE = "/reject/$INVITATION_ID";
    private static final String PATH_UNINVITE_MYSELF = "/$WORLD_ID";
    private static final String PATH_WORLD_UPDATE = "/$WORLD_ID";
    private static final String PATH_SLOT = "/$WORLD_ID/slot/$SLOT_ID";
    private static final String PATH_WORLD_OPEN = "/$WORLD_ID/open";
    private static final String PATH_WORLD_CLOSE = "/$WORLD_ID/close";
    private static final String PATH_WORLD_RESET = "/$WORLD_ID/reset";
    private static final String PATH_DELETE_WORLD = "/$WORLD_ID";
    private static final String PATH_WORLD_BACKUPS = "/$WORLD_ID/backups";
    private static final String PATH_WORLD_DOWNLOAD = "/$WORLD_ID/backups/download/full";
    private static final String PATH_WORLD_UPLOAD = "/$WORLD_ID/backups/upload";
    private static final String PATH_CLIENT_COMPATIBLE = "/client/compatible";
    private static final String PATH_TOS_AGREED = "/tos/agreed";
    private static final String PATH_STAGE_AVAILABLE = "/stageAvailable";
    private static Gson gson = new Gson();

    public static RealmsClient createRealmsClient() {
        String string = Realms.userName();
        String string2 = Realms.sessionId();
        if (string == null || string2 == null) {
            return null;
        }
        return new RealmsClient(string2, string, Realms.getProxy());
    }

    public static void switchToStage() {
        baseUrl = "mcoapi-stage.minecraft.net";
        protocol = "https";
    }

    public static void switchToProd() {
        baseUrl = "mcoapi.minecraft.net";
        protocol = "https";
    }

    public static void switchToLocal() {
        baseUrl = "localhost:8080";
        protocol = "http";
    }

    public RealmsClient(String string, String string2, Proxy proxy) {
        this.sessionId = string;
        this.username = string2;
        RealmsClientConfig.setProxy(proxy);
    }

    public RealmsServerList listWorlds() throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH);
        String string2 = this.execute(Request.get(string));
        return RealmsServerList.parse(string2);
    }

    public RealmsServer getOwnWorld(long l) throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_GET.replace("$ID", String.valueOf(l)));
        String string2 = this.execute(Request.get(string));
        return RealmsServer.parse(string2);
    }

    public ServerActivityList getActivity(long l) throws RealmsServiceException {
        String string = this.url(ACTIVITIES_RESOURCE + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.get(string));
        return ServerActivityList.parse(string2);
    }

    public RealmsServerPlayerLists getLiveStats() throws RealmsServiceException {
        String string = this.url("activities/liveplayerlist");
        String string2 = this.execute(Request.get(string));
        return RealmsServerPlayerLists.parse(string2);
    }

    public RealmsServerAddress join(long l) throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_JOIN.replace("$ID", "" + l));
        String string2 = this.execute(Request.get(string, 5000, 30000));
        return RealmsServerAddress.parse(string2);
    }

    public void initializeWorld(long l, String string, String string2) throws RealmsServiceException, IOException {
        RealmsDescriptionDto realmsDescriptionDto = new RealmsDescriptionDto(string, string2);
        String string3 = this.url(WORLDS_RESOURCE_PATH + PATH_INITIALIZE.replace("$WORLD_ID", String.valueOf(l)));
        String string4 = gson.toJson(realmsDescriptionDto);
        this.execute(Request.post(string3, string4, 5000, 10000));
    }

    public Boolean mcoEnabled() throws RealmsServiceException, IOException {
        String string = this.url("mco/available");
        String string2 = this.execute(Request.get(string));
        return Boolean.valueOf(string2);
    }

    public Boolean stageAvailable() throws RealmsServiceException, IOException {
        String string = this.url("mco/stageAvailable");
        String string2 = this.execute(Request.get(string));
        return Boolean.valueOf(string2);
    }

    public CompatibleVersionResponse clientCompatible() throws RealmsServiceException, IOException {
        CompatibleVersionResponse compatibleVersionResponse;
        String string = this.url("mco/client/compatible");
        String string2 = this.execute(Request.get(string));
        try {
            compatibleVersionResponse = CompatibleVersionResponse.valueOf(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RealmsServiceException(500, "Could not check compatible version, got response: " + string2, -1, "");
        }
        return compatibleVersionResponse;
    }

    public void uninvite(long l, String string) throws RealmsServiceException {
        String string2 = this.url(INVITES_RESOURCE_PATH + PATH_WORLD_UNINVITE.replace("$WORLD_ID", String.valueOf(l)).replace("$UUID", string));
        this.execute(Request.delete(string2));
    }

    public void uninviteMyselfFrom(long l) throws RealmsServiceException {
        String string = this.url(INVITES_RESOURCE_PATH + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        this.execute(Request.delete(string));
    }

    public RealmsServer invite(long l, String string) throws RealmsServiceException, IOException {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.setName(string);
        String string2 = this.url(INVITES_RESOURCE_PATH + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        String string3 = this.execute(Request.post(string2, gson.toJson(playerInfo)));
        return RealmsServer.parse(string3);
    }

    public BackupList backupsFor(long l) throws RealmsServiceException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_BACKUPS.replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.get(string));
        return BackupList.parse(string2);
    }

    public void update(long l, String string, String string2) throws RealmsServiceException, UnsupportedEncodingException {
        RealmsDescriptionDto realmsDescriptionDto = new RealmsDescriptionDto(string, string2);
        String string3 = this.url(WORLDS_RESOURCE_PATH + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        this.execute(Request.post(string3, gson.toJson(realmsDescriptionDto)));
    }

    public void updateSlot(long l, int n, RealmsWorldOptions realmsWorldOptions) throws RealmsServiceException, UnsupportedEncodingException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_SLOT.replace("$WORLD_ID", String.valueOf(l)).replace("$SLOT_ID", String.valueOf(n)));
        String string2 = realmsWorldOptions.toJson();
        this.execute(Request.post(string, string2));
    }

    public boolean switchSlot(long l, int n) throws RealmsServiceException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_SLOT.replace("$WORLD_ID", String.valueOf(l)).replace("$SLOT_ID", String.valueOf(n)));
        String string2 = this.execute(Request.put(string, ""));
        return Boolean.valueOf(string2);
    }

    public void restoreWorld(long l, String string) throws RealmsServiceException {
        String string2 = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_BACKUPS.replace("$WORLD_ID", String.valueOf(l)), "backupId=" + string);
        this.execute(Request.put(string2, "", 40000, 40000));
    }

    public WorldTemplateList fetchWorldTemplates() throws RealmsServiceException {
        String string = this.url("worlds/templates");
        String string2 = this.execute(Request.get(string));
        return WorldTemplateList.parse(string2);
    }

    public WorldTemplateList fetchMinigames() throws RealmsServiceException {
        String string = this.url("worlds/minigames");
        String string2 = this.execute(Request.get(string));
        return WorldTemplateList.parse(string2);
    }

    public Boolean putIntoMinigameMode(long l, String string) throws RealmsServiceException {
        String string2 = PATH_PUT_INTO_MINIGAMES_MODE.replace("$MINIGAME_ID", string).replace("$WORLD_ID", String.valueOf(l));
        String string3 = this.url(WORLDS_RESOURCE_PATH + string2);
        return Boolean.valueOf(this.execute(Request.put(string3, "")));
    }

    public Ops op(long l, String string) throws RealmsServiceException {
        String string2 = PATH_OP.replace("$WORLD_ID", String.valueOf(l)).replace("$PROFILE_UUID", string);
        String string3 = this.url(OPS_RESOURCE + string2);
        return Ops.parse(this.execute(Request.post(string3, "")));
    }

    public Ops deop(long l, String string) throws RealmsServiceException {
        String string2 = PATH_OP.replace("$WORLD_ID", String.valueOf(l)).replace("$PROFILE_UUID", string);
        String string3 = this.url(OPS_RESOURCE + string2);
        return Ops.parse(this.execute(Request.delete(string3)));
    }

    public Boolean open(long l) throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_OPEN.replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.put(string, ""));
        return Boolean.valueOf(string2);
    }

    public Boolean close(long l) throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_CLOSE.replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.put(string, ""));
        return Boolean.valueOf(string2);
    }

    public Boolean resetWorldWithSeed(long l, String string, Integer n, boolean bl) throws RealmsServiceException, IOException {
        RealmsWorldResetDto realmsWorldResetDto = new RealmsWorldResetDto(string, -1L, n, bl);
        String string2 = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_RESET.replace("$WORLD_ID", String.valueOf(l)));
        String string3 = this.execute(Request.post(string2, gson.toJson(realmsWorldResetDto), 30000, 80000));
        return Boolean.valueOf(string3);
    }

    public Boolean resetWorldWithTemplate(long l, String string) throws RealmsServiceException, IOException {
        RealmsWorldResetDto realmsWorldResetDto = new RealmsWorldResetDto(null, Long.valueOf(string), -1, false);
        String string2 = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_RESET.replace("$WORLD_ID", String.valueOf(l)));
        String string3 = this.execute(Request.post(string2, gson.toJson(realmsWorldResetDto), 30000, 80000));
        return Boolean.valueOf(string3);
    }

    public Subscription subscriptionFor(long l) throws RealmsServiceException, IOException {
        String string = this.url(SUBSCRIPTION_RESOURCE + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.get(string));
        return Subscription.parse(string2);
    }

    public int pendingInvitesCount() throws RealmsServiceException {
        String string = this.url("invites/count/pending");
        String string2 = this.execute(Request.get(string));
        return Integer.parseInt(string2);
    }

    public PendingInvitesList pendingInvites() throws RealmsServiceException {
        String string = this.url("invites/pending");
        String string2 = this.execute(Request.get(string));
        return PendingInvitesList.parse(string2);
    }

    public void acceptInvitation(String string) throws RealmsServiceException {
        String string2 = this.url(INVITES_RESOURCE_PATH + PATH_ACCEPT_INVITE.replace("$INVITATION_ID", string));
        this.execute(Request.put(string2, ""));
    }

    public WorldDownload download(long l) throws RealmsServiceException {
        String string = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_DOWNLOAD.replace("$WORLD_ID", String.valueOf(l)));
        String string2 = this.execute(Request.get(string));
        return WorldDownload.parse(string2);
    }

    public UploadInfo upload(long l, String string) throws RealmsServiceException {
        String string2 = this.url(WORLDS_RESOURCE_PATH + PATH_WORLD_UPLOAD.replace("$WORLD_ID", String.valueOf(l)));
        UploadInfo uploadInfo = new UploadInfo();
        if (string != null) {
            uploadInfo.setToken(string);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();
        String string3 = gson.toJson(uploadInfo);
        return UploadInfo.parse(this.execute(Request.put(string2, string3)));
    }

    public void rejectInvitation(String string) throws RealmsServiceException {
        String string2 = this.url(INVITES_RESOURCE_PATH + PATH_REJECT_INVITE.replace("$INVITATION_ID", string));
        this.execute(Request.put(string2, ""));
    }

    public void agreeToTos() throws RealmsServiceException {
        String string = this.url("mco/tos/agreed");
        this.execute(Request.post(string, ""));
    }

    public void sendPingResults(PingResult pingResult) throws RealmsServiceException {
        String string = this.url(REGIONS_RESOURCE);
        this.execute(Request.post(string, gson.toJson(pingResult)));
    }

    public Boolean trialAvailable() throws RealmsServiceException, IOException {
        String string = this.url(TRIALS_RESOURCE);
        String string2 = this.execute(Request.get(string));
        return Boolean.valueOf(string2);
    }

    public RealmsServer createTrial(String string, String string2) throws RealmsServiceException, IOException {
        RealmsDescriptionDto realmsDescriptionDto = new RealmsDescriptionDto(string, string2);
        String string3 = gson.toJson(realmsDescriptionDto);
        String string4 = this.url(TRIALS_RESOURCE);
        String string5 = this.execute(Request.post(string4, string3, 5000, 10000));
        return RealmsServer.parse(string5);
    }

    public void deleteWorld(long l) throws RealmsServiceException, IOException {
        String string = this.url(WORLDS_RESOURCE_PATH + "/$WORLD_ID".replace("$WORLD_ID", String.valueOf(l)));
        this.execute(Request.delete(string));
    }

    private String url(String string) {
        return this.url(string, null);
    }

    private String url(String string, String string2) {
        try {
            URI uRI = new URI(protocol, baseUrl, "/" + string, string2, null);
            return uRI.toASCIIString();
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
            return null;
        }
    }

    private String execute(Request<?> request) throws RealmsServiceException {
        request.cookie("sid", this.sessionId);
        request.cookie("user", this.username);
        request.cookie("version", RealmsSharedConstants.VERSION_STRING);
        String string = RealmsVersion.getVersion();
        if (string != null) {
            request.cookie("realms_version", string);
        }
        try {
            int n = request.responseCode();
            if (n == 503) {
                int n2 = request.getRetryAfterHeader();
                throw new RetryCallException(n2);
            }
            String string2 = request.text();
            if (n < 200 || n >= 300) {
                if (n == 401) {
                    String string3 = request.getHeader("WWW-Authenticate");
                    LOGGER.info("Could not authorize you against Realms server: " + string3);
                    throw new RealmsServiceException(n, string3, -1, string3);
                }
                if (string2 == null || string2.length() == 0) {
                    LOGGER.error("Realms error code: " + n + " message: " + string2);
                    throw new RealmsServiceException(n, string2, n, "");
                }
                RealmsError realmsError = new RealmsError(string2);
                LOGGER.error("Realms http code: " + n + " -  error code: " + realmsError.getErrorCode() + " -  message: " + realmsError.getErrorMessage());
                throw new RealmsServiceException(n, string2, realmsError);
            }
            return string2;
        }
        catch (RealmsHttpException realmsHttpException) {
            throw new RealmsServiceException(500, "Could not connect to Realms: " + realmsHttpException.getMessage(), -1, "");
        }
    }

    public static enum CompatibleVersionResponse {
        COMPATIBLE,
        OUTDATED,
        OTHER;

    }
}

