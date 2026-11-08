/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpClient;
import net.raphimc.minecraftauth.java.model.MinecraftEntitlements;
import net.raphimc.minecraftauth.java.model.MinecraftPlayerCertificates;
import net.raphimc.minecraftauth.java.model.MinecraftProfile;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.java.request.MinecraftEntitlementsRequest;
import net.raphimc.minecraftauth.java.request.MinecraftLauncherLoginRequest;
import net.raphimc.minecraftauth.java.request.MinecraftPlayerCertificatesRequest;
import net.raphimc.minecraftauth.java.request.MinecraftProfileRequest;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.request.MsaRefreshTokenRequest;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;
import net.raphimc.minecraftauth.msa.service.util.MsaAuthServiceSupplier;
import net.raphimc.minecraftauth.msa.service.util.ParamMsaAuthServiceSupplier;
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

public class JavaAuthManager {
    private final HttpClient httpClient;
    private final MsaApplicationConfig msaApplicationConfig;
    private final String deviceType;
    private final KeyPair deviceKeyPair;
    private final UUID deviceId;
    private final ChangeListeners changeListeners = new ChangeListeners();
    private final Object sisuTokensLock = new Object();
    private final Holder<MsaToken> msaToken = new Holder<MsaToken>(this::refreshMsaToken);
    private final Holder<XblDeviceToken> xblDeviceToken = new Holder<XblDeviceToken>(this::refreshXblDeviceToken);
    private final Holder<XblUserToken> xblUserToken = new Holder<XblUserToken>(this::refreshXblUserToken, this.sisuTokensLock);
    private final Holder<XblTitleToken> xblTitleToken = new Holder<XblTitleToken>(this::refreshXblTitleToken, this.sisuTokensLock);
    private final Holder<XblXstsToken> javaXstsToken = new Holder<XblXstsToken>(this::refreshJavaXstsToken, this.sisuTokensLock);
    private final Holder<XblXstsToken> xboxLiveXstsToken = new Holder<XblXstsToken>(this::refreshXboxLiveXstsToken);
    private final Holder<XblUserProfile> xboxUserProfile = new Holder<XblUserProfile>(this::refreshXboxUserProfile);
    private final Holder<MinecraftToken> minecraftToken = new Holder<MinecraftToken>(this::refreshMinecraftToken);
    private final Holder<MinecraftEntitlements> minecraftEntitlements = new Holder<MinecraftEntitlements>(this::refreshMinecraftEntitlements);
    private final Holder<MinecraftProfile> minecraftProfile = new Holder<MinecraftProfile>(this::refreshMinecraftProfile);
    private final Holder<MinecraftPlayerCertificates> minecraftPlayerCertificates = new Holder<MinecraftPlayerCertificates>(this::refreshMinecraftPlayerCertificates);

    public static JavaAuthManager fromJson(HttpClient httpClient, JsonObject jsonObject) {
        return JavaAuthManager.fromJson(httpClient, new GsonObject(jsonObject));
    }

    public static JavaAuthManager fromJson(HttpClient httpClient, GsonObject gsonObject) {
        return new JavaAuthManager(httpClient, MsaApplicationConfig.fromJson(gsonObject.reqObject("msaApplicationConfig")), gsonObject.reqString("deviceType"), JsonUtil.decodeKeyPair(gsonObject.reqObject("deviceKeyPair")), UUID.fromString(gsonObject.reqString("deviceId")), MsaToken.fromJson(gsonObject.reqObject("msaToken")), gsonObject.optObject("xblDeviceToken").map(XblDeviceToken::fromJson).orElse(null), gsonObject.optObject("xblUserToken").map(XblUserToken::fromJson).orElse(null), gsonObject.optObject("xblTitleToken").map(XblTitleToken::fromJson).orElse(null), gsonObject.optObject("javaXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("xboxLiveXstsToken").map(XblXstsToken::fromJson).orElse(null), gsonObject.optObject("xboxUserProfile").map(XblUserProfile::fromJson).orElse(null), gsonObject.optObject("minecraftToken").map(MinecraftToken::fromJson).orElse(null), gsonObject.optObject("minecraftEntitlements").map(MinecraftEntitlements::fromJson).orElse(null), gsonObject.optObject("minecraftProfile").map(MinecraftProfile::fromJson).orElse(null), gsonObject.optObject("minecraftPlayerCertificates").map(MinecraftPlayerCertificates::fromJson).orElse(null));
    }

    public static JsonObject toJson(JavaAuthManager javaAuthManager) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.add("msaApplicationConfig", MsaApplicationConfig.toJson(javaAuthManager.msaApplicationConfig));
        jsonObject.addProperty("deviceType", javaAuthManager.deviceType);
        jsonObject.add("deviceKeyPair", JsonUtil.encodeKeyPair(javaAuthManager.deviceKeyPair));
        jsonObject.addProperty("deviceId", javaAuthManager.deviceId.toString());
        jsonObject.add("msaToken", MsaToken.toJson(javaAuthManager.msaToken.getCached()));
        if (javaAuthManager.xblDeviceToken.hasValue()) {
            jsonObject.add("xblDeviceToken", XblDeviceToken.toJson(javaAuthManager.xblDeviceToken.getCached()));
        }
        if (javaAuthManager.xblUserToken.hasValue()) {
            jsonObject.add("xblUserToken", XblUserToken.toJson(javaAuthManager.xblUserToken.getCached()));
        }
        if (javaAuthManager.xblTitleToken.hasValue()) {
            jsonObject.add("xblTitleToken", XblTitleToken.toJson(javaAuthManager.xblTitleToken.getCached()));
        }
        if (javaAuthManager.javaXstsToken.hasValue()) {
            jsonObject.add("javaXstsToken", XblXstsToken.toJson(javaAuthManager.javaXstsToken.getCached()));
        }
        if (javaAuthManager.xboxLiveXstsToken.hasValue()) {
            jsonObject.add("xboxLiveXstsToken", XblXstsToken.toJson(javaAuthManager.xboxLiveXstsToken.getCached()));
        }
        if (javaAuthManager.xboxUserProfile.hasValue()) {
            jsonObject.add("xboxUserProfile", XblUserProfile.toJson(javaAuthManager.xboxUserProfile.getCached()));
        }
        if (javaAuthManager.minecraftToken.hasValue()) {
            jsonObject.add("minecraftToken", MinecraftToken.toJson(javaAuthManager.minecraftToken.getCached()));
        }
        if (javaAuthManager.minecraftEntitlements.hasValue()) {
            jsonObject.add("minecraftEntitlements", MinecraftEntitlements.toJson(javaAuthManager.minecraftEntitlements.getCached()));
        }
        if (javaAuthManager.minecraftProfile.hasValue()) {
            jsonObject.add("minecraftProfile", MinecraftProfile.toJson(javaAuthManager.minecraftProfile.getCached()));
        }
        if (javaAuthManager.minecraftPlayerCertificates.hasValue()) {
            jsonObject.add("minecraftPlayerCertificates", MinecraftPlayerCertificates.toJson(javaAuthManager.minecraftPlayerCertificates.getCached()));
        }
        return jsonObject;
    }

    public static Builder create(HttpClient httpClient) {
        return new Builder(httpClient);
    }

    private JavaAuthManager(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, String string, KeyPair keyPair, UUID uUID, MsaToken msaToken) {
        this.httpClient = httpClient;
        this.msaApplicationConfig = msaApplicationConfig;
        this.deviceType = string;
        this.deviceKeyPair = keyPair;
        this.deviceId = uUID;
        this.msaToken.set(msaToken);
        this.hookChangeListeners();
    }

    private JavaAuthManager(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, String string, KeyPair keyPair, UUID uUID, MsaToken msaToken, XblDeviceToken xblDeviceToken, XblUserToken xblUserToken, XblTitleToken xblTitleToken, XblXstsToken xblXstsToken, XblXstsToken xblXstsToken2, XblUserProfile xblUserProfile, MinecraftToken minecraftToken, MinecraftEntitlements minecraftEntitlements, MinecraftProfile minecraftProfile, MinecraftPlayerCertificates minecraftPlayerCertificates) {
        this.httpClient = httpClient;
        this.msaApplicationConfig = msaApplicationConfig;
        this.deviceType = string;
        this.deviceKeyPair = keyPair;
        this.deviceId = uUID;
        this.msaToken.set(msaToken);
        this.xblDeviceToken.set(xblDeviceToken);
        this.xblUserToken.set(xblUserToken);
        this.xblTitleToken.set(xblTitleToken);
        this.javaXstsToken.set(xblXstsToken);
        this.xboxLiveXstsToken.set(xblXstsToken2);
        this.xboxUserProfile.set(xblUserProfile);
        this.minecraftToken.set(minecraftToken);
        this.minecraftEntitlements.set(minecraftEntitlements);
        this.minecraftProfile.set(minecraftProfile);
        this.minecraftPlayerCertificates.set(minecraftPlayerCertificates);
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

    private XblXstsToken refreshJavaXstsToken() throws IOException {
        if (this.msaApplicationConfig.isTitleClientId()) {
            this.refreshSisuTokens();
            return this.javaXstsToken.getCached();
        }
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), null, "rp://api.minecraftservices.com/"));
    }

    private XblXstsToken refreshXboxLiveXstsToken() throws IOException {
        XblTitleToken xblTitleToken = this.msaApplicationConfig.isTitleClientId() ? this.xblTitleToken.getUpToDate() : null;
        return (XblXstsToken)this.httpClient.executeAndHandle(new XblXstsAuthorizeRequest(this.xblDeviceToken.getUpToDate(), this.xblUserToken.getUpToDate(), xblTitleToken, "http://xboxlive.com"));
    }

    private XblUserProfile refreshXboxUserProfile() throws IOException {
        return (XblUserProfile)this.httpClient.executeAndHandle(new XblUserProfileSettingsRequest(this.xboxLiveXstsToken.getUpToDate(), "me", "Gamertag", "AppDisplayName", "AppDisplayPicRaw"));
    }

    private MinecraftToken refreshMinecraftToken() throws IOException {
        return (MinecraftToken)this.httpClient.executeAndHandle(new MinecraftLauncherLoginRequest(this.javaXstsToken.getUpToDate()));
    }

    private MinecraftEntitlements refreshMinecraftEntitlements() throws IOException {
        return (MinecraftEntitlements)this.httpClient.executeAndHandle(new MinecraftEntitlementsRequest(this.minecraftToken.getUpToDate()));
    }

    private MinecraftProfile refreshMinecraftProfile() throws IOException {
        return (MinecraftProfile)this.httpClient.executeAndHandle(new MinecraftProfileRequest(this.minecraftToken.getUpToDate()));
    }

    private MinecraftPlayerCertificates refreshMinecraftPlayerCertificates() throws IOException {
        return (MinecraftPlayerCertificates)this.httpClient.executeAndHandle(new MinecraftPlayerCertificatesRequest(this.minecraftToken.getUpToDate()));
    }

    private void refreshSisuTokens() throws IOException {
        XblSisuTokens xblSisuTokens = (XblSisuTokens)this.httpClient.executeAndHandle(new XblSisuAuthorizeRequest(this.msaApplicationConfig, this.msaToken.getUpToDate(), this.xblDeviceToken.getUpToDate(), this.deviceKeyPair, "rp://api.minecraftservices.com/"));
        this.xblUserToken.set(xblSisuTokens.getUserToken());
        this.xblTitleToken.set(xblSisuTokens.getTitleToken());
        this.javaXstsToken.set(xblSisuTokens.getXstsToken());
    }

    private void hookChangeListeners() {
        this.msaToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblDeviceToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblUserToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xblTitleToken.getChangeListeners().add(this.changeListeners::invoke);
        this.javaXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xboxLiveXstsToken.getChangeListeners().add(this.changeListeners::invoke);
        this.xboxUserProfile.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftToken.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftEntitlements.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftProfile.getChangeListeners().add(this.changeListeners::invoke);
        this.minecraftPlayerCertificates.getChangeListeners().add(this.changeListeners::invoke);
    }

    @Generated
    public HttpClient getHttpClient() {
        return this.httpClient;
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
    public Holder<XblXstsToken> getJavaXstsToken() {
        return this.javaXstsToken;
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
    public Holder<MinecraftToken> getMinecraftToken() {
        return this.minecraftToken;
    }

    @Generated
    public Holder<MinecraftEntitlements> getMinecraftEntitlements() {
        return this.minecraftEntitlements;
    }

    @Generated
    public Holder<MinecraftProfile> getMinecraftProfile() {
        return this.minecraftProfile;
    }

    @Generated
    public Holder<MinecraftPlayerCertificates> getMinecraftPlayerCertificates() {
        return this.minecraftPlayerCertificates;
    }

    public static class Builder {
        private final HttpClient httpClient;
        private MsaApplicationConfig msaApplicationConfig = new MsaApplicationConfig("00000000402b5328", "service::user.auth.xboxlive.com::MBI_SSL");
        private String deviceType = "Win32";
        private KeyPair deviceKeyPair;
        private UUID deviceId;

        public JavaAuthManager login(MsaAuthServiceSupplier msaAuthServiceSupplier) throws IOException, InterruptedException, TimeoutException {
            MsaAuthService msaAuthService = msaAuthServiceSupplier.get(this.httpClient, this.msaApplicationConfig);
            return this.login(msaAuthService.acquireToken());
        }

        public <T> JavaAuthManager login(ParamMsaAuthServiceSupplier<T> paramMsaAuthServiceSupplier, T t) throws IOException, InterruptedException, TimeoutException {
            MsaAuthService msaAuthService = paramMsaAuthServiceSupplier.get(this.httpClient, this.msaApplicationConfig, t);
            return this.login(msaAuthService.acquireToken());
        }

        public JavaAuthManager login(String string) throws IOException {
            return this.login((MsaToken)this.httpClient.executeAndHandle(new MsaRefreshTokenRequest(this.msaApplicationConfig, string)));
        }

        public JavaAuthManager login(MsaToken msaToken) {
            return new JavaAuthManager(this.httpClient, this.msaApplicationConfig, this.deviceType, this.deviceKeyPair != null ? this.deviceKeyPair : CryptUtil.generateEcdsa256KeyPair(), this.deviceId != null ? this.deviceId : UUID.randomUUID(), msaToken);
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
        private Builder(HttpClient httpClient) {
            this.httpClient = httpClient;
        }
    }
}

