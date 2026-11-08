/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpClient;
import net.raphimc.minecraftauth.bedrock.model.MinecraftCertificateChain;
import net.raphimc.minecraftauth.bedrock.model.MinecraftMultiplayerToken;
import net.raphimc.minecraftauth.bedrock.model.MinecraftSession;
import net.raphimc.minecraftauth.bedrock.request.MinecraftAuthenticationRequest;
import net.raphimc.minecraftauth.bedrock.request.MinecraftMultiplayerSessionStartRequest;
import net.raphimc.minecraftauth.bedrock.request.MinecraftSessionStartRequest;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.request.MsaRefreshTokenRequest;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;
import net.raphimc.minecraftauth.msa.service.util.MsaAuthServiceSupplier;
import net.raphimc.minecraftauth.msa.service.util.ParamMsaAuthServiceSupplier;
import net.raphimc.minecraftauth.playfab.model.PlayFabEntityToken;
import net.raphimc.minecraftauth.playfab.model.PlayFabToken;
import net.raphimc.minecraftauth.playfab.request.PlayFabGetEntityTokenRequest;
import net.raphimc.minecraftauth.playfab.request.PlayFabLoginWithXboxRequest;
import net.raphimc.minecraftauth.util.CryptUtil;
import net.raphimc.minecraftauth.util.JsonUtil;
import net.raphimc.minecraftauth.util.holder.Holder;
import net.raphimc.minecraftauth.util.holder.listener.ChangeListeners;
import net.raphimc.minecraftauth.xbl.model.XblDeviceToken;
import net.raphimc.minecraftauth.xbl.model.XblSisuTokens;
import net.raphimc.minecraftauth.xbl.model.XblTitleToken;
import net.raphimc.minecraftauth.xbl.model.XblUserProfile;
import net.raphimc.minecraftauth.xbl.model.XblUserToken;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;
import net.raphimc.minecraftauth.xbl.request.XblDeviceAuthenticateRequest;
import net.raphimc.minecraftauth.xbl.request.XblSisuAuthorizeRequest;
import net.raphimc.minecraftauth.xbl.request.XblUserAuthenticateRequest;
import net.raphimc.minecraftauth.xbl.request.XblUserProfileSettingsRequest;
import net.raphimc.minecraftauth.xbl.request.XblXstsAuthorizeRequest;

public class BedrockAuthManager {
    private final HttpClient httpClient;
    private final String gameVersion;
    private final MsaApplicationConfig msaApplicationConfig;
    private final String deviceType;
    private final KeyPair deviceKeyPair;
    private final UUID deviceId;
    private final KeyPair sessionKeyPair;
    private final ChangeListeners changeListeners = new ChangeListeners();
    private final Object sisuTokensLock = new Object();
    private final Holder<MsaToken> msaToken = new Holder<MsaToken>(this::refreshMsaToken);
    private final Holder<XblDeviceToken> xblDeviceToken = new Holder<XblDeviceToken>(this::refreshXblDeviceToken);
    private final Holder<XblUserToken> xblUserToken = new Holder<XblUserToken>(this::refreshXblUserToken, this.sisuTokensLock);
    private final Holder<XblTitleToken> xblTitleToken = new Holder<XblTitleToken>(this::refreshXblTitleToken, this.sisuTokensLock);
    private final Holder<XblXstsToken> bedrockXstsToken = new Holder<XblXstsToken>(this::refreshBedrockXstsToken, this.sisuTokensLock);
    private final Holder<XblXstsToken> playFabXstsToken = new Holder<XblXstsToken>(this::refreshPlayFabXstsToken);
    private final Holder<XblXstsToken> realmsXstsToken = new Holder<XblXstsToken>(this::refreshRealmsXstsToken);
    private final Holder<XblXstsToken> xboxLiveXstsToken = new Holder<XblXstsToken>(this::refreshXboxLiveXstsToken);
    private final Holder<XblUserProfile> xboxUserProfile = new Holder<XblUserProfile>(this::refreshXboxUserProfile);
    private final Holder<PlayFabToken> playFabToken = new Holder<PlayFabToken>(this::refreshPlayFabToken);
    private final Holder<PlayFabEntityToken> playFabMasterToken = new Holder<PlayFabEntityToken>(this::refreshPlayFabMasterToken);
    private final Holder<MinecraftSession> minecraftSession = new Holder<MinecraftSession>(this::refreshMinecraftSession);
    private final Holder<MinecraftMultiplayerToken> minecraftMultiplayerToken = new Holder<MinecraftMultiplayerToken>(this::refreshMinecraftMultiplayerToken);
    private final Holder<MinecraftCertificateChain> minecraftCertificateChain = new Holder<MinecraftCertificateChain>(this::refreshMinecraftCertificateChain);

    public static BedrockAuthManager fromJson(HttpClient httpClient, String string, JsonObject jsonObject) {
        return BedrockAuthManager.fromJson(httpClient, string, new GsonObject(jsonObject));
    }

    public static BedrockAuthManager fromJson(HttpClient httpClient, String string, GsonObject gsonObject) {
        return new BedrockAuthManager(httpClient, string, MsaApplicationConfig.fromJson(gsonObject.reqObject("msaApplicationConfig")), gsonObject.reqString("deviceType"), JsonUtil.decodeKeyPair(gsonObject.reqObject("deviceKeyPair")), UUID.fromString(gsonObject.reqString("deviceId")), JsonUtil.decodeKeyPair(gsonObject.reqObject("sessionKeyPair")), MsaToken.fromJson(gsonObject.reqObject("msaToken")), gsonObject.optObject("xblDeviceToken").map(XblDeviceToken::fromJson).orElse(null), gsonObject.optObject("xblUserToken").map(XblUserToken::fromJson).orElse(null), gsonObject.optObject("xblTitleToken").map(XblTitleToken::fromJson).orElse(null), gsonObject.optObject("bedrockXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("playFabXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("realmsXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("xboxLiveXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("xboxUserProfile").map(XblUserProfile::fromJson).orElse(null), gsonObject.optObject("playFabToken").map(PlayFabToken::fromJson).orElse(null), gsonObject.optObject("playFabMasterToken").map(PlayFabEntityToken::fromJson).orElse(null), gsonObject.optObject("minecraftSession").map(MinecraftSession::fromJson).orElse(null), gsonObject.optObject("minecraftMultiplayerToken").map(MinecraftMultiplayerToken::fromJson).orElse(null), gsonObject.optObject("minecraftCertificateChain").map(MinecraftCertificateChain::fromJson).orElse(null));
    }

    public static JsonObject toJson(BedrockAuthManager bedrockAuthManager) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.add("msaApplicationConfig", MsaApplicationConfig.toJson(bedrockAuthManager.msaApplicationConfig));
        jsonObject.addProperty("deviceType", bedrockAuthManager.deviceType);
        jsonObject.add("deviceKeyPair", JsonUtil.encodeKeyPair(bedrockAuthManager.deviceKeyPair));
        jsonObject.addProperty("deviceId", bedrockAuthManager.deviceId.toString());
        jsonObject.add("sessionKeyPair", JsonUtil.encodeKeyPair(bedrockAuthManager.sessionKeyPair));
        jsonObject.add("msaToken", MsaToken.toJson(bedrockAuthManager.msaToken.getCached()));
        if (bedrockAuthManager.xblDeviceToken.hasValue()) {
            jsonObject.add("xblDeviceToken", XblDeviceToken.toJson(bedrockAuthManager.xblDeviceToken.getCached()));
        }
        if (bedrockAuthManager.xblUserToken.hasValue()) {
            jsonObject.add("xblUserToken", XblUserToken.toJson(bedrockAuthManager.xblUserToken.getCached()));
        }
        if (bedrockAuthManager.xblTitleToken.hasValue()) {
            jsonObject.add("xblTitleToken", XblTitleToken.toJson(bedrockAuthManager.xblTitleToken.getCached()));
        }
        if (bedrockAuthManager.bedrockXstsToken.hasValue()) {
            jsonObject.add("bedrockXstsToken", XblXstsToken.toJson(bedrockAuthManager.bedrockXstsToken.getCached()));
        }
        if (bedrockAuthManager.playFabXstsToken.hasValue()) {
            jsonObject.add("playFabXstsToken", XblXstsToken.toJson(bedrockAuthManager.playFabXstsToken.getCached()));
        }
        if (bedrockAuthManager.realmsXstsToken.hasValue()) {
            jsonObject.add("realmsXstsToken", XblXstsToken.toJson(bedrockAuthManager.realmsXstsToken.getCached()));
        }
        if (bedrockAuthManager.xboxLiveXstsToken.hasValue()) {
            jsonObject.add("xboxLiveXstsToken", XblXstsToken.toJson(bedrockAuthManager.xboxLiveXstsToken.getCached()));
        }
        if (bedrockAuthManager.xboxUserProfile.hasValue()) {
            jsonObject.add("xboxUserProfile", XblUserProfile.toJson(bedrockAuthManager.xboxUserProfile.getCached()));
        }
        if (bedrockAuthManager.playFabToken.hasValue()) {
            jsonObject.add("playFabToken", PlayFabToken.toJson(bedrockAuthManager.playFabToken.getCached()));
        }
        if (bedrockAuthManager.playFabMasterToken.hasValue()) {
            jsonObject.add("playFabMasterToken", PlayFabEntityToken.toJson(bedrockAuthManager.playFabMasterToken.getCached()));
        }
        if (bedrockAuthManager.minecraftSession.hasValue()) {
            jsonObject.add("minecraftSession", MinecraftSession.toJson(bedrockAuthManager.minecraftSession.getCached()));
        }
        if (bedrockAuthManager.minecraftMultiplayerToken.hasValue()) {
            jsonObject.add("minecraftMultiplayerToken", MinecraftMultiplayerToken.toJson(bedrockAuthManager.minecraftMultiplayerToken.getCached()));
        }
        if (bedrockAuthManager.minecraftCertificateChain.hasValue()) {
            jsonObject.add("minecraftCertificateChain", MinecraftCertificateChain.toJson(bedrockAuthManager.minecraftCertificateChain.getCached()));
        }
        return jsonObject;
    }

    public static Builder create(HttpClient httpClient, String string) {
        return new Builder(httpClient, string);
    }

    private BedrockAuthManager(HttpClient httpClient, String string, MsaApplicationConfig msaApplicationConfig, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, MsaToken msaToken) {
        this.httpClient = httpClient;
        this.gameVersion = string;
        this.msaApplicationConfig = msaApplicationConfig;
        this.deviceType = string2;
        this.deviceKeyPair = keyPair;
        this.deviceId = uUID;
        this.sessionKeyPair = keyPair2;
        this.msaToken.set(msaToken);
        this.hookChangeListeners();
    }

    private BedrockAuthManager(HttpClient httpClient, String string, MsaApplicationConfig msaApplicationConfig, String string2, KeyPair keyPair, UUID uUID, KeyPair keyPair2, MsaToken msaToken, XblDeviceToken xblDeviceToken, XblUserToken xblUserToken, XblTitleToken xblTitleToken, XblXstsToken xblXstsToken, XblXstsToken xblXstsToken2, XblXstsToken xblXstsToken3, XblXstsToken xblXstsToken4, XblUserProfile xblUserProfile, PlayFabToken playFabToken, PlayFabEntityToken playFabEntityToken, MinecraftSession minecraftSession, MinecraftMultiplayerToken minecraftMultiplayerToken, MinecraftCertificateChain minecraftCertificateChain) {
        this.httpClient = httpClient;
        this.gameVersion = string;
        this.msaApplicationConfig = msaApplicationConfig;
        this.deviceType = string2;
        this.deviceKeyPair = keyPair;
        this.deviceId = uUID;
        this.sessionKeyPair = keyPair2;
        this.msaToken.set(msaToken);
        this.xblDeviceToken.set(xblDeviceToken);
        this.xblUserToken.set(xblUserToken);
        this.xblTitleToken.set(xblTitleToken);
        this.bedrockXstsToken.set(xblXstsToken);
        this.playFabXstsToken.set(xblXstsToken2);
        this.realmsXstsToken.set(xblXstsToken3);
        this.xboxLiveXstsToken.set(xblXstsToken4);
        this.xboxUserProfile.set(xblUserProfile);
        this.playFabToken.set(playFabToken);
        this.playFabMasterToken.set(playFabEntityToken);
        this.minecraftSession.set(minecraftSession);
        this.minecraftMultiplayerToken.set(minecraftMultiplayerToken);
        this.minecraftCertificateChain.set(minecraftCertificateChain);
        this.hookChangeListeners();
    }

    private MsaToken refreshMsaToken() throws IOException {
        if (this.msaToken.getCached().getRefreshToken() == null) {
            throw new IllegalStateException("Can't refresh MSA token, because it was created without a refresh token. The user has to sign in again.");
        }
        return (MsaToken)this.httpClient.executeAndHandle(new MsaRefreshTokenRequest(this.msaApplicationConfig, this.msaToken.getCached()));
    }

    private XblDeviceToken refreshXblDeviceToken() throws IOException {
        return (XblDeviceToken)this.httpClient.executeAndHandle(new XblDeviceAuthenticateRequest(this.deviceType, this.deviceId, this.deviceKeyPair));
    }

    private XblUserToken refreshXblUserToken() throws IOException {
        if (this.msaApplicationConfig.isTitleClientId()) {
            this.refreshSisuTokens();
            return this.xblUserToken.getCached();
        }
        return (XblUserToken)this.httpClient.executeAndHandle(new XblUserAuthenticateRequest(this.msaApplicationConfig, this.msaToken.getUpToDate()));
    }

    private XblTitleToken refreshXblTitleToken() throws IOException {
        if (!this.msaApplicationConfig.isTitleClientId()) {
            throw new UnsupportedOperationException("Can't refresh XBL title token, because the MSA application client ID is not a title client ID");
        }
        this.refreshSisuTokens();
        return this.xblTitleToken.getCached();
    }

    private XblXstsToken refreshBedrockXstsToken() throws IOException {
        if (this.msaApplicationConfig.isTitleClientId()) {
            this.refreshSisuTokens();
            return this.bedrockXstsToken.getCached();
        }
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), null, "https://multiplayer.minecraft.net/"));
    }

    private XblXstsToken refreshPlayFabXstsToken() throws IOException {
        XblTitleToken xblTitleToken = this.msaApplicationConfig.isTitleClientId() ? this.xblTitleToken.getUpToDate() : null;
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), xblTitleToken, "https://b980a380.minecraft.playfabapi.com/"));
    }

    private XblXstsToken refreshRealmsXstsToken() throws IOException {
        XblTitleToken xblTitleToken = this.msaApplicationConfig.isTitleClientId() ? this.xblTitleToken.getUpToDate() : null;
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), xblTitleToken, "https://pocket.realms.minecraft.net/"));
    }

    private XblXstsToken refreshXboxLiveXstsToken() throws IOException {
        XblTitleToken xblTitleToken = this.msaApplicationConfig.isTitleClientId() ? this.xblTitleToken.getUpToDate() : null;
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), xblTitleToken, "http://xboxlive.com"));
    }

    private XblUserProfile refreshXboxUserProfile() throws IOException {
        return (XblUserProfile)this.httpClient.executeAndHandle(new XblUserProfileSettingsRequest(this.xboxLiveXstsToken.getUpToDate(), "me", "Gamertag", "AppDisplayName", "AppDisplayPicRaw"));
    }

    private PlayFabToken refreshPlayFabToken() throws IOException {
        return (PlayFabToken)this.httpClient.executeAndHandle(new PlayFabLoginWithXboxRequest(this.playFabXstsToken.getUpToDate(), "20CA2"));
    }

    private PlayFabEntityToken refreshPlayFabMasterToken() throws IOException {
        PlayFabToken playFabToken = this.playFabToken.getUpToDate();
        return (PlayFabEntityToken)this.httpClient.executeAndHandle(new PlayFabGetEntityTokenRequest(playFabToken.getEntityToken(), "20CA2", playFabToken.getPlayFabId(), "master_player_account"));
    }

    private MinecraftSession refreshMinecraftSession() throws IOException {
        return (MinecraftSession)this.httpClient.executeAndHandle(new MinecraftSessionStartRequest(this.playFabToken.getUpToDate(), this.gameVersion, this.deviceId));
    }

    private MinecraftMultiplayerToken refreshMinecraftMultiplayerToken() throws IOException {
        return (MinecraftMultiplayerToken)this.httpClient.executeAndHandle(new MinecraftMultiplayerSessionStartRequest(this.minecraftSession.getUpToDate(), this.sessionKeyPair));
    }

    private MinecraftCertificateChain refreshMinecraftCertificateChain() throws IOException {
        return (MinecraftCertificateChain)this.httpClient.executeAndHandle(new MinecraftAuthenticationRequest(this.bedrockXstsToken.getUpToDate(), this.sessionKeyPair));
    }

    private void refreshSisuTokens() throws IOException {
        XblSisuTokens xblSisuTokens = (XblSisuTokens)this.httpClient.executeAndHandle(new XblSisuAuthorizeRequest(this.msaApplicationConfig, this.msaToken.getUpToDate(), this.xblDeviceToken.getUpToDate(), this.deviceKeyPair, "https://multiplayer.minecraft.net/"));
        this.xblUserToken.set(xblSisuTokens.getUserToken());
        this.xblTitleToken.set(xblSisuTokens.getTitleToken());
        this.bedrockXstsToken.set(xblSisuTokens.getXstsToken());
    }

    private void hookChangeListeners() {
        this.msaToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblDeviceToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblUserToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblTitleToken.getChangeListeners().add(this.changeListeners::invoke);
        this.bedrockXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.playFabXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.realmsXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xboxLiveXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xboxUserProfile.getChangeListeners().add(this.changeListeners::invoke);
        this.playFabToken.getChangeListeners().add(this.changeListeners::invoke);
        this.playFabMasterToken.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftSession.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftMultiplayerToken.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftCertificateChain.getChangeListeners().add(this.changeListeners::invoke);
    }

    @Generated
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Generated
    public String getGameVersion() {
        return this.gameVersion;
    }

    @Generated
    public MsaApplicationConfig getMsaApplicationConfig() {
        return this.msaApplicationConfig;
    }

    @Generated
    public String getDeviceType() {
        return this.deviceType;
    }

    @Generated
    public KeyPair getDeviceKeyPair() {
        return this.deviceKeyPair;
    }

    @Generated
    public UUID getDeviceId() {
        return this.deviceId;
    }

    @Generated
    public KeyPair getSessionKeyPair() {
        return this.sessionKeyPair;
    }

    @Generated
    public ChangeListeners getChangeListeners() {
        return this.changeListeners;
    }

    @Generated
    public Holder<MsaToken> getMsaToken() {
        return this.msaToken;
    }

    @Generated
    public Holder<XblDeviceToken> getXblDeviceToken() {
        return this.xblDeviceToken;
    }

    @Generated
    public Holder<XblUserToken> getXblUserToken() {
        return this.xblUserToken;
    }

    @Generated
    public Holder<XblTitleToken> getXblTitleToken() {
        return this.xblTitleToken;
    }

    @Generated
    public Holder<XblXstsToken> getBedrockXstsToken() {
        return this.bedrockXstsToken;
    }

    @Generated
    public Holder<XblXstsToken> getPlayFabXstsToken() {
        return this.playFabXstsToken;
    }

    @Generated
    public Holder<XblXstsToken> getRealmsXstsToken() {
        return this.realmsXstsToken;
    }

    @Generated
    public Holder<XblXstsToken> getXboxLiveXstsToken() {
        return this.xboxLiveXstsToken;
    }

    @Generated
    public Holder<XblUserProfile> getXboxUserProfile() {
        return this.xboxUserProfile;
    }

    @Generated
    public Holder<PlayFabToken> getPlayFabToken() {
        return this.playFabToken;
    }

    @Generated
    public Holder<PlayFabEntityToken> getPlayFabMasterToken() {
        return this.playFabMasterToken;
    }

    @Generated
    public Holder<MinecraftSession> getMinecraftSession() {
        return this.minecraftSession;
    }

    @Generated
    public Holder<MinecraftMultiplayerToken> getMinecraftMultiplayerToken() {
        return this.minecraftMultiplayerToken;
    }

    @Generated
    public Holder<MinecraftCertificateChain> getMinecraftCertificateChain() {
        return this.minecraftCertificateChain;
    }

    public static class Builder {
        private final HttpClient httpClient;
        private final String gameVersion;
        private MsaApplicationConfig msaApplicationConfig = new MsaApplicationConfig("0000000048183522", "service::user.auth.xboxlive.com::MBI_SSL");
        private String deviceType = "Android";
        private KeyPair deviceKeyPair;
        private UUID deviceId;
        private KeyPair sessionKeyPair;

        public BedrockAuthManager login(MsaAuthServiceSupplier msaAuthServiceSupplier) throws IOException, InterruptedException, TimeoutException {
            MsaAuthService msaAuthService = msaAuthServiceSupplier.get(this.httpClient, this.msaApplicationConfig);
            return this.login(msaAuthService.acquireToken());
        }

        public <T> BedrockAuthManager login(ParamMsaAuthServiceSupplier<T> paramMsaAuthServiceSupplier, T t) throws IOException, InterruptedException, TimeoutException {
            MsaAuthService msaAuthService = paramMsaAuthServiceSupplier.get(this.httpClient, this.msaApplicationConfig, t);
            return this.login(msaAuthService.acquireToken());
        }

        public BedrockAuthManager login(String string) throws IOException {
            return this.login((MsaToken)this.httpClient.executeAndHandle(new MsaRefreshTokenRequest(this.msaApplicationConfig, string)));
        }

        public BedrockAuthManager login(MsaToken msaToken) {
            return new BedrockAuthManager(this.httpClient, this.gameVersion, this.msaApplicationConfig, this.deviceType, this.deviceKeyPair != null ? this.deviceKeyPair : CryptUtil.generateEcdsa256KeyPair(), this.deviceId != null ? this.deviceId : UUID.randomUUID(), this.sessionKeyPair != null ? this.sessionKeyPair : CryptUtil.generateEcdsa384KeyPair(), msaToken);
        }

        @Generated
        public Builder msaApplicationConfig(MsaApplicationConfig msaApplicationConfig) {
            this.msaApplicationConfig = msaApplicationConfig;
            return this;
        }

        @Generated
        public Builder deviceType(String string) {
            this.deviceType = string;
            return this;
        }

        @Generated
        public Builder deviceKeyPair(KeyPair keyPair) {
            this.deviceKeyPair = keyPair;
            return this;
        }

        @Generated
        public Builder deviceId(UUID uUID) {
            this.deviceId = uUID;
            return this;
        }

        @Generated
        public Builder sessionKeyPair(KeyPair keyPair) {
            this.sessionKeyPair = keyPair;
            return this;
        }

        @Generated
        private Builder(HttpClient httpClient, String string) {
            this.httpClient = httpClient;
            this.gameVersion = string;
        }
    }
}

