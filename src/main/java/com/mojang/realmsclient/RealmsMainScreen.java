/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.RealmsVersion;
import com.mojang.realmsclient.client.Ping;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.PingResult;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.RealmsServerPlayerList;
import com.mojang.realmsclient.dto.RealmsServerPlayerLists;
import com.mojang.realmsclient.dto.RegionPingResult;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.exception.RetryCallException;
import com.mojang.realmsclient.gui.ChatFormatting;
import com.mojang.realmsclient.gui.RealmsDataFetcher;
import com.mojang.realmsclient.gui.screens.RealmsClientOutdatedScreen;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsCreateRealmScreen;
import com.mojang.realmsclient.gui.screens.RealmsCreateTrialScreen;
import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongConfirmationScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.gui.screens.RealmsParentalConsentScreen;
import com.mojang.realmsclient.gui.screens.RealmsPendingInvitesScreen;
import com.mojang.realmsclient.util.RealmsTasks;
import com.mojang.realmsclient.util.RealmsUtil;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.RealmsDefaultVertexFormat;
import net.minecraft.realms.RealmsMth;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSharedConstants;
import net.minecraft.realms.Tezzelator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RealmsMainScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static boolean overrideConfigure = false;
    private static boolean stageEnabled = false;
    private static boolean localEnabled = false;
    private boolean dontSetConnectedToRealms = false;
    protected static final int BUTTON_BACK_ID = 0;
    protected static final int BUTTON_PLAY_ID = 1;
    private static final int LEAVE_ID = 2;
    private static final int BUTTON_BUY_ID = 3;
    private static final int BUTTON_TRY_ID = 4;
    protected static final int RESOURCEPACK_ID = 100;
    private RealmsServer resourcePackServer;
    private static final String ON_ICON_LOCATION = "realms:textures/gui/realms/on_icon.png";
    private static final String OFF_ICON_LOCATION = "realms:textures/gui/realms/off_icon.png";
    private static final String EXPIRED_ICON_LOCATION = "realms:textures/gui/realms/expired_icon.png";
    private static final String EXPIRES_SOON_ICON_LOCATION = "realms:textures/gui/realms/expires_soon_icon.png";
    private static final String LEAVE_ICON_LOCATION = "realms:textures/gui/realms/leave_icon.png";
    private static final String INVITATION_ICONS_LOCATION = "realms:textures/gui/realms/invitation_icons.png";
    private static final String INVITE_ICON_LOCATION = "realms:textures/gui/realms/invite_icon.png";
    private static final String WORLDICON_LOCATION = "realms:textures/gui/realms/world_icon.png";
    private static final String LOGO_LOCATION = "realms:textures/gui/title/realms.png";
    private static final String CONFIGURE_LOCATION = "realms:textures/gui/realms/configure_icon.png";
    private static final String QUESTIONMARK_LOCATION = "realms:textures/gui/realms/questionmark.png";
    private static final String POPUP_LOCATION = "realms:textures/gui/realms/popup.png";
    private static final String DARKEN_LOCATION = "realms:textures/gui/realms/darken.png";
    private static final String CROSS_ICON_LOCATION = "realms:textures/gui/realms/cross_icon.png";
    private static final String TRIAL_ICON_LOCATION = "realms:textures/gui/realms/trial_icon.png";
    private static final String BUTTON_LOCATION = "minecraft:textures/gui/widgets.png";
    private static final String[] IMAGES_LOCATION = new String[]{"realms:textures/gui/realms/images/one.png", "realms:textures/gui/realms/images/two.png", "realms:textures/gui/realms/images/three.png", "realms:textures/gui/realms/images/four.png", "realms:textures/gui/realms/images/five.png"};
    private static RealmsDataFetcher realmsDataFetcher = new RealmsDataFetcher();
    private static int lastScrollYPosition = -1;
    private RealmsScreen lastScreen;
    private volatile ServerSelectionList serverSelectionList;
    private long selectedServerId = -1L;
    private RealmsButton playButton;
    private RealmsButton backButton;
    private String toolTip;
    private List<RealmsServer> realmsServers = Lists.newArrayList();
    private volatile int numberOfPendingInvites = 0;
    private int animTick;
    private static volatile boolean mcoEnabled;
    private static volatile boolean mcoEnabledCheck;
    private static boolean checkedMcoAvailability;
    private boolean hasFetchedServers = false;
    private boolean popupOpenedByUser = false;
    private boolean justClosedPopup = false;
    private volatile boolean trialsAvailable;
    private volatile boolean createdTrial = false;
    private volatile boolean showingPopup = false;
    private int carouselIndex = 0;
    private int carouselTick = 0;
    boolean hasSwitchedCarouselImage = false;
    private static RealmsScreen realmsGenericErrorScreen;
    private static boolean regionsPinged;
    private int mindex = 0;
    private char[] mchars = new char[]{'3', '2', '1', '4', '5', '6'};
    private int sindex = 0;
    private char[] schars = new char[]{'9', '8', '7', '1', '2', '3'};
    private int clicks = 0;
    private int lindex = 0;
    private char[] lchars = new char[]{'9', '8', '7', '4', '5', '6'};
    private static ReentrantLock connectLock;
    private boolean expiredHover = false;
    private boolean updateBreaksAdventureNoteHover = false;

    public RealmsMainScreen(RealmsScreen realmsScreen) {
        this.lastScreen = realmsScreen;
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        if (!this.shouldShowPopup()) {
            this.serverSelectionList.mouseEvent();
        }
    }

    public boolean shouldShowMessageInList() {
        if (!(mcoEnabled && mcoEnabled && this.hasFetchedServers)) {
            return false;
        }
        if (this.trialsAvailable && !this.createdTrial) {
            return true;
        }
        for (RealmsServer realmsServer : this.realmsServers) {
            if (!realmsServer.ownerUUID.equals(Realms.getUUID())) continue;
            return false;
        }
        return true;
    }

    public boolean shouldShowPopup() {
        if (!(mcoEnabledCheck && mcoEnabled && this.hasFetchedServers)) {
            return false;
        }
        if (this.popupOpenedByUser) {
            return true;
        }
        if (this.trialsAvailable && !this.createdTrial && this.realmsServers.isEmpty()) {
            return true;
        }
        return this.realmsServers.isEmpty();
    }

    @Override
    public void init() {
        connectLock = new ReentrantLock();
        this.checkIfMcoEnabled();
        if (!this.dontSetConnectedToRealms) {
            Realms.setConnectedToRealms(false);
        }
        if (realmsGenericErrorScreen != null) {
            Realms.setScreen(realmsGenericErrorScreen);
            return;
        }
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        if (mcoEnabledCheck && mcoEnabled) {
            realmsDataFetcher.forceUpdate();
        }
        this.showingPopup = false;
        this.postInit();
    }

    public void addButtons() {
        this.playButton = RealmsMainScreen.newButton(1, this.width() / 2 - 98, this.height() - 32, 98, 20, RealmsMainScreen.getLocalizedString("mco.selectServer.play"));
        this.buttonsAdd(this.playButton);
        this.backButton = RealmsMainScreen.newButton(0, this.width() / 2 + 6, this.height() - 32, 98, 20, RealmsMainScreen.getLocalizedString("gui.back"));
        this.buttonsAdd(this.backButton);
        RealmsServer realmsServer = this.findServer(this.selectedServerId);
        this.playButton.active(realmsServer != null && realmsServer.state == RealmsServer.State.OPEN && !realmsServer.expired);
    }

    public void postInit() {
        if (mcoEnabledCheck && mcoEnabled && this.hasFetchedServers) {
            this.addButtons();
        }
        this.serverSelectionList = new ServerSelectionList();
        this.serverSelectionList.setLeftPos(-15);
        if (lastScrollYPosition != -1) {
            this.serverSelectionList.scroll(lastScrollYPosition);
        }
    }

    @Override
    public void tick() {
        List<RealmsServer> list;
        this.justClosedPopup = false;
        ++this.animTick;
        --this.clicks;
        if (this.clicks < 0) {
            this.clicks = 0;
        }
        if (this.noParentalConsent()) {
            Realms.setScreen(new RealmsParentalConsentScreen(this.lastScreen));
            return;
        }
        if (!mcoEnabledCheck || !mcoEnabled) {
            return;
        }
        realmsDataFetcher.init();
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.SERVER_LIST)) {
            list = realmsDataFetcher.getServers();
            if (list != null) {
                boolean bl = false;
                for (RealmsServer realmsServer : list) {
                    if (!this.isSelfOwnedNonExpiredServer(realmsServer)) continue;
                    bl = true;
                }
                this.realmsServers = list;
                if (!regionsPinged && bl) {
                    regionsPinged = true;
                    this.pingRegions();
                }
            }
            if (!this.hasFetchedServers) {
                this.hasFetchedServers = true;
                this.addButtons();
            }
        }
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.PENDING_INVITE)) {
            this.numberOfPendingInvites = realmsDataFetcher.getPendingInvitesCount();
        }
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.TRIAL_AVAILABLE) && !this.createdTrial) {
            boolean bl = realmsDataFetcher.isTrialAvailable();
            if (bl != this.trialsAvailable && this.shouldShowPopup()) {
                this.trialsAvailable = bl;
                this.showingPopup = false;
            } else {
                this.trialsAvailable = bl;
            }
        }
        if (realmsDataFetcher.isFetchedSinceLastTry(RealmsDataFetcher.Task.LIVE_STATS)) {
            list = realmsDataFetcher.getLivestats();
            block1: for (RealmsServerPlayerList realmsServerPlayerList : ((RealmsServerPlayerLists)((Object)list)).servers) {
                for (RealmsServer realmsServer : this.realmsServers) {
                    if (realmsServer.id != realmsServerPlayerList.serverId) continue;
                    realmsServer.updateServerPing(realmsServerPlayerList);
                    continue block1;
                }
            }
        }
        realmsDataFetcher.markClean();
        if (this.shouldShowPopup()) {
            ++this.carouselTick;
        }
    }

    private void pingRegions() {
        new Thread(){

            @Override
            public void run() {
                List<RegionPingResult> list = Ping.pingAllRegions();
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                PingResult pingResult = new PingResult();
                pingResult.pingResults = list;
                pingResult.worldIds = RealmsMainScreen.this.getOwnedNonExpiredWorldIds();
                try {
                    realmsClient.sendPingResults(pingResult);
                }
                catch (Throwable throwable) {
                    LOGGER.warn("Could not send ping result to Realms: ", throwable);
                }
            }
        }.start();
    }

    private List<Long> getOwnedNonExpiredWorldIds() {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (RealmsServer realmsServer : this.realmsServers) {
            if (!this.isSelfOwnedNonExpiredServer(realmsServer)) continue;
            arrayList.add(realmsServer.id);
        }
        return arrayList;
    }

    private boolean noParentalConsent() {
        return mcoEnabledCheck && !mcoEnabled;
    }

    @Override
    public void removed() {
        Keyboard.enableRepeatEvents(false);
        this.stopRealmsFetcher();
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        switch (realmsButton.id()) {
            case 1: {
                this.play(this.findServer(this.selectedServerId));
                break;
            }
            case 0: {
                if (this.justClosedPopup) break;
                Realms.setScreen(this.lastScreen);
                break;
            }
            case 4: {
                this.createTrial();
                break;
            }
            case 3: {
                RealmsUtil.browseTo("https://minecraft.net/realms");
                break;
            }
            default: {
                return;
            }
        }
    }

    private void createTrial() {
        if (!this.trialsAvailable || this.createdTrial) {
            return;
        }
        this.createdTrial = true;
        Realms.setScreen(new RealmsCreateTrialScreen(this));
    }

    private void checkIfMcoEnabled() {
        if (!checkedMcoAvailability) {
            checkedMcoAvailability = true;
            new Thread("MCO Availability Checker #1"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        RealmsClient.CompatibleVersionResponse compatibleVersionResponse = realmsClient.clientCompatible();
                        if (compatibleVersionResponse.equals((Object)RealmsClient.CompatibleVersionResponse.OUTDATED)) {
                            Realms.setScreen(realmsGenericErrorScreen = new RealmsClientOutdatedScreen(RealmsMainScreen.this.lastScreen, true));
                            return;
                        }
                        if (compatibleVersionResponse.equals((Object)RealmsClient.CompatibleVersionResponse.OTHER)) {
                            Realms.setScreen(realmsGenericErrorScreen = new RealmsClientOutdatedScreen(RealmsMainScreen.this.lastScreen, false));
                            return;
                        }
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        checkedMcoAvailability = false;
                        LOGGER.error("Couldn't connect to realms: ", realmsServiceException.toString());
                        if (realmsServiceException.httpResultCode == 401) {
                            realmsGenericErrorScreen = new RealmsGenericErrorScreen(realmsServiceException, RealmsMainScreen.this.lastScreen);
                        }
                        Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, RealmsMainScreen.this.lastScreen));
                        return;
                    }
                    catch (IOException iOException) {
                        checkedMcoAvailability = false;
                        LOGGER.error("Couldn't connect to realms: ", iOException.getMessage());
                        Realms.setScreen(new RealmsGenericErrorScreen(iOException.getMessage(), RealmsMainScreen.this.lastScreen));
                        return;
                    }
                    boolean bl = false;
                    for (int i = 0; i < 3; ++i) {
                        try {
                            Boolean bl2 = realmsClient.mcoEnabled();
                            if (bl2.booleanValue()) {
                                LOGGER.info("Realms is available for this user");
                                mcoEnabled = true;
                            } else {
                                LOGGER.info("Realms is not available for this user");
                                mcoEnabled = false;
                            }
                            mcoEnabledCheck = true;
                        }
                        catch (RetryCallException retryCallException) {
                            bl = true;
                        }
                        catch (RealmsServiceException realmsServiceException) {
                            LOGGER.error("Couldn't connect to Realms: " + realmsServiceException.toString());
                        }
                        catch (IOException iOException) {
                            LOGGER.error("Couldn't parse response connecting to Realms: " + iOException.getMessage());
                        }
                        if (!bl) break;
                        try {
                            Thread.sleep(5000L);
                            continue;
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }.start();
        }
    }

    private void switchToStage() {
        if (!stageEnabled) {
            new Thread("MCO Stage Availability Checker #1"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        Boolean bl = realmsClient.stageAvailable();
                        if (bl.booleanValue()) {
                            RealmsClient.switchToStage();
                            LOGGER.info("Switched to stage");
                            realmsDataFetcher.forceUpdate();
                            localEnabled = false;
                            stageEnabled = true;
                        } else {
                            stageEnabled = false;
                        }
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't connect to Realms: " + realmsServiceException.toString());
                    }
                    catch (IOException iOException) {
                        LOGGER.error("Couldn't parse response connecting to Realms: " + iOException.getMessage());
                    }
                }
            }.start();
        }
    }

    private void switchToLocal() {
        if (!localEnabled) {
            new Thread("MCO Local Availability Checker #1"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        Boolean bl = realmsClient.stageAvailable();
                        if (bl.booleanValue()) {
                            RealmsClient.switchToLocal();
                            LOGGER.info("Switched to local");
                            realmsDataFetcher.forceUpdate();
                            stageEnabled = false;
                            localEnabled = true;
                        } else {
                            localEnabled = false;
                        }
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't connect to Realms: " + realmsServiceException.toString());
                    }
                    catch (IOException iOException) {
                        LOGGER.error("Couldn't parse response connecting to Realms: " + iOException.getMessage());
                    }
                }
            }.start();
        }
    }

    private void switchToProd() {
        if (stageEnabled || localEnabled) {
            stageEnabled = false;
            localEnabled = false;
            RealmsClient.switchToProd();
            realmsDataFetcher.forceUpdate();
        }
    }

    private void stopRealmsFetcher() {
        realmsDataFetcher.stop();
    }

    private void configureClicked(RealmsServer realmsServer) {
        if (Realms.getUUID().equals(realmsServer.ownerUUID) || overrideConfigure) {
            this.saveListScrollPosition();
            Realms.setScreen(new RealmsConfigureWorldScreen(this, realmsServer.id));
        }
    }

    private void leaveClicked(RealmsServer realmsServer) {
        if (!Realms.getUUID().equals(realmsServer.ownerUUID)) {
            this.saveListScrollPosition();
            String string = RealmsMainScreen.getLocalizedString("mco.configure.world.leave.question.line1");
            String string2 = RealmsMainScreen.getLocalizedString("mco.configure.world.leave.question.line2");
            Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Info, string, string2, true, 2));
        }
    }

    private void saveListScrollPosition() {
        lastScrollYPosition = this.serverSelectionList.getScroll();
    }

    private RealmsServer findServer(long l) {
        for (RealmsServer realmsServer : this.realmsServers) {
            if (realmsServer.id != l) continue;
            return realmsServer;
        }
        return null;
    }

    private int findIndex(long l) {
        for (int i = 0; i < this.realmsServers.size(); ++i) {
            if (this.realmsServers.get((int)i).id != l) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (n == 2) {
            if (bl) {
                new Thread("Realms-leave-server"){

                    @Override
                    public void run() {
                        try {
                            RealmsServer realmsServer = RealmsMainScreen.this.findServer(RealmsMainScreen.this.selectedServerId);
                            if (realmsServer != null) {
                                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                                realmsClient.uninviteMyselfFrom(realmsServer.id);
                                realmsDataFetcher.removeItem(realmsServer);
                                RealmsMainScreen.this.realmsServers.remove(realmsServer);
                                RealmsMainScreen.this.selectedServerId = -1L;
                                RealmsMainScreen.this.playButton.active(false);
                            }
                        }
                        catch (RealmsServiceException realmsServiceException) {
                            LOGGER.error("Couldn't configure world");
                            Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, (RealmsScreen)RealmsMainScreen.this));
                        }
                    }
                }.start();
            }
            Realms.setScreen(this);
        } else if (n == 100) {
            if (!bl) {
                if (connectLock.isHeldByCurrentThread()) {
                    connectLock.unlock();
                }
                Realms.setScreen(this);
            } else {
                this.connectToServer(this.resourcePackServer);
            }
        }
    }

    public void removeSelection() {
        this.selectedServerId = -1L;
    }

    @Override
    public void keyPressed(char c, int n) {
        switch (n) {
            case 28: 
            case 156: {
                this.mindex = 0;
                this.sindex = 0;
                this.lindex = 0;
                if (this.shouldShowPopup()) {
                    return;
                }
                if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
                    RealmsServer realmsServer = this.findServer(this.selectedServerId);
                    if (realmsServer == null) break;
                    this.configureClicked(realmsServer);
                    break;
                }
                this.buttonClicked(this.playButton);
                break;
            }
            case 1: {
                this.mindex = 0;
                this.sindex = 0;
                this.lindex = 0;
                if (this.shouldShowPopup() && this.popupOpenedByUser) {
                    this.popupOpenedByUser = false;
                    break;
                }
                Realms.setScreen(this.lastScreen);
                break;
            }
            case 200: {
                if (this.selectedServerId != -1L && !this.shouldShowPopup()) {
                    int n2;
                    RealmsServer realmsServer;
                    RealmsServer realmsServer2 = this.findServer(this.selectedServerId);
                    int n3 = this.realmsServers.indexOf(realmsServer2);
                    if (n3 == 0) {
                        this.serverSelectionList.scroll(0 - this.serverSelectionList.getScroll());
                        return;
                    }
                    if (realmsServer2 != null && n3 > 0 && (realmsServer = this.realmsServers.get(n2 = n3 - 1)) != null) {
                        this.selectedServerId = realmsServer.id;
                        int n4 = Math.max(0, this.serverSelectionList.getMaxPosition() - (this.height() - 40 - 32 - 4));
                        int n5 = (int)Math.floor((this.height() - 40 - 32) / 36);
                        int n6 = this.serverSelectionList.getScroll();
                        int n7 = (int)Math.ceil((float)n6 / 36.0f);
                        int n8 = n4 / this.realmsServers.size();
                        int n9 = n8 * n2;
                        int n10 = n9 - this.serverSelectionList.getScroll();
                        if (n2 < n7 || n2 > n7 + n5) {
                            this.serverSelectionList.scroll(n10);
                        }
                        return;
                    }
                }
                if (this.shouldShowPopup() || this.realmsServers.isEmpty()) break;
                this.selectedServerId = this.realmsServers.get((int)0).id;
                this.serverSelectionList.scroll(0 - this.serverSelectionList.getScroll());
                break;
            }
            case 208: {
                if (this.selectedServerId != -1L && !this.shouldShowPopup()) {
                    RealmsServer realmsServer = this.findServer(this.selectedServerId);
                    int n11 = this.realmsServers.indexOf(realmsServer);
                    int n12 = Math.max(0, this.serverSelectionList.getMaxPosition() - (this.height() - 40 - 32));
                    if (n11 == this.realmsServers.size() - 1) {
                        this.serverSelectionList.scroll(n12 - this.serverSelectionList.getScroll() + 36);
                        return;
                    }
                    if (realmsServer != null && n11 > -1 && n11 < this.realmsServers.size() - 1) {
                        int n13 = n11 + 1;
                        RealmsServer realmsServer3 = this.realmsServers.get(n13);
                        if (n13 == this.realmsServers.size() - 1) {
                            this.selectedServerId = realmsServer3.id;
                            this.serverSelectionList.scroll(n12 - this.serverSelectionList.getScroll() + 36);
                            return;
                        }
                        if (realmsServer3 != null) {
                            this.selectedServerId = realmsServer3.id;
                            int n14 = (int)Math.floor((this.height() - 40 - 32) / 36);
                            int n15 = this.serverSelectionList.getScroll();
                            int n16 = (int)Math.ceil((float)n15 / 36.0f);
                            int n17 = n12 / this.realmsServers.size();
                            int n18 = n17 * n13;
                            int n19 = n18 - this.serverSelectionList.getScroll();
                            if (n19 > 0) {
                                n19 += n17;
                            }
                            if (n13 < n16 || n13 >= n16 + n14) {
                                this.serverSelectionList.scroll(n19);
                            }
                            return;
                        }
                    }
                }
                if (this.shouldShowPopup() || this.realmsServers.isEmpty()) break;
                this.selectedServerId = this.realmsServers.get((int)0).id;
                this.serverSelectionList.scroll(-(this.serverSelectionList.getItemCount() * 36));
                break;
            }
            default: {
                if (this.mchars[this.mindex] == c) {
                    ++this.mindex;
                    if (this.mindex == this.mchars.length) {
                        this.mindex = 0;
                        overrideConfigure = !overrideConfigure;
                    }
                } else {
                    this.mindex = 0;
                }
                if (this.schars[this.sindex] == c) {
                    ++this.sindex;
                    if (this.sindex == this.schars.length) {
                        this.sindex = 0;
                        if (!stageEnabled) {
                            this.switchToStage();
                        } else {
                            this.switchToProd();
                        }
                    }
                } else {
                    this.sindex = 0;
                }
                if (this.lchars[this.lindex] == c) {
                    ++this.lindex;
                    if (this.lindex != this.lchars.length) break;
                    this.lindex = 0;
                    if (!localEnabled) {
                        this.switchToLocal();
                        break;
                    }
                    this.switchToProd();
                    break;
                }
                this.lindex = 0;
            }
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.expiredHover = false;
        this.updateBreaksAdventureNoteHover = false;
        this.toolTip = null;
        this.renderBackground();
        this.serverSelectionList.render(n, n2, f);
        this.drawRealmsLogo(this.width() / 2 - 50, 7);
        if ((!this.shouldShowPopup() || this.popupOpenedByUser) && mcoEnabledCheck && mcoEnabled && this.hasFetchedServers) {
            this.renderMoreInfo(n, n2);
        }
        this.drawInvitationPendingIcon(n, n2);
        if (stageEnabled) {
            this.renderStage();
        }
        if (localEnabled) {
            this.renderLocal();
        }
        if (this.shouldShowPopup()) {
            this.drawPopup(n, n2);
        } else {
            if (this.showingPopup) {
                this.buttonsClear();
                this.buttonsAdd(this.playButton);
                this.buttonsAdd(this.backButton);
                RealmsServer realmsServer = this.findServer(this.selectedServerId);
                this.playButton.active(realmsServer != null && realmsServer.state == RealmsServer.State.OPEN && !realmsServer.expired);
            }
            this.showingPopup = false;
        }
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
        super.render(n, n2, f);
        if (this.trialsAvailable && !this.createdTrial && this.shouldShowPopup()) {
            RealmsScreen.bind(TRIAL_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            int n3 = 0;
            if ((System.currentTimeMillis() / 800L & 1L) == 1L) {
                n3 = 8;
            }
            int n4 = this.height() / 2 - 83 - 3;
            int n5 = n4 + 147 - 20;
            RealmsScreen.blit(this.width() / 2 + 52 + 83, n5 - 4, 0.0f, n3, 8, 8, 8.0f, 16.0f);
            GL11.glPopMatrix();
        }
    }

    private void drawRealmsLogo(int n, int n2) {
        RealmsScreen.bind(LOGO_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        RealmsScreen.blit(n * 2, n2 * 2 - 5, 0.0f, 0.0f, 200, 50, 200.0f, 50.0f);
        GL11.glPopMatrix();
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.inPendingInvitationArea(n, n2)) {
            RealmsPendingInvitesScreen realmsPendingInvitesScreen = new RealmsPendingInvitesScreen(this.lastScreen);
            Realms.setScreen(realmsPendingInvitesScreen);
        } else if (this.toolTip != null && this.toolTip.equals(RealmsMainScreen.getLocalizedString("mco.selectServer.info"))) {
            this.popupOpenedByUser = !this.popupOpenedByUser;
        } else if (this.toolTip != null && this.toolTip.equals(RealmsMainScreen.getLocalizedString("mco.selectServer.close"))) {
            this.popupOpenedByUser = false;
        } else if (this.isOutsidePopup(n, n2) && this.popupOpenedByUser) {
            this.popupOpenedByUser = false;
            this.justClosedPopup = true;
        }
    }

    private boolean isOutsidePopup(int n, int n2) {
        int n3 = (this.width() - 310) / 2;
        int n4 = this.height() / 2 - 83 - 3;
        return n < n3 - 5 || n > n3 + 315 || n2 < n4 - 5 || n2 > n4 + 171;
    }

    private void drawPopup(int n, int n2) {
        int n3;
        int n4 = (this.width() - 310) / 2;
        int n5 = this.height() / 2 - 83 - 3;
        int n6 = n5 + 147 - 20;
        if (!this.showingPopup) {
            this.carouselIndex = 0;
            this.carouselTick = 0;
            this.hasSwitchedCarouselImage = true;
            if (this.hasFetchedServers && this.realmsServers.isEmpty()) {
                this.buttonsClear();
                this.buttonsAdd(RealmsMainScreen.newButton(0, this.width() / 2 - 49, this.height() - 32, 98, 20, RealmsMainScreen.getLocalizedString("gui.back")));
            }
            if (this.trialsAvailable && !this.createdTrial) {
                this.buttonsAdd(RealmsMainScreen.newButton(4, this.width() / 2 + 52, n6 -= 10, 98, 20, RealmsMainScreen.getLocalizedString("mco.selectServer.trial")));
                n6 = n5 + 170 - 20 - 10;
            }
            this.buttonsAdd(RealmsMainScreen.newButton(3, this.width() / 2 + 52, n6, 98, 20, RealmsMainScreen.getLocalizedString("mco.selectServer.buy")));
            this.playButton.active(false);
        }
        if (this.hasFetchedServers) {
            this.showingPopup = true;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.7f);
        GL11.glEnable(3042);
        RealmsScreen.bind(DARKEN_LOCATION);
        GL11.glPushMatrix();
        int n7 = 0;
        int n8 = 32;
        RealmsScreen.blit(n7, n8, 0.0f, 0.0f, this.width(), this.height() - 40 - 32, 310.0f, 166.0f);
        GL11.glPopMatrix();
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        RealmsScreen.bind(POPUP_LOCATION);
        GL11.glPushMatrix();
        RealmsScreen.blit(n4, n5, 0.0f, 0.0f, 310, 166, 310.0f, 166.0f);
        GL11.glPopMatrix();
        RealmsScreen.bind(IMAGES_LOCATION[this.carouselIndex]);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n4 + 7, n5 + 7, 0.0f, 0.0f, 195, 152, 195.0f, 152.0f);
        GL11.glPopMatrix();
        if (this.carouselTick % 100 < 5) {
            if (!this.hasSwitchedCarouselImage) {
                this.carouselIndex = this.carouselIndex == IMAGES_LOCATION.length - 1 ? 0 : ++this.carouselIndex;
                this.hasSwitchedCarouselImage = true;
            }
        } else {
            this.hasSwitchedCarouselImage = false;
        }
        if (this.popupOpenedByUser) {
            boolean bl = false;
            n3 = n4 + 4;
            int n9 = n5 + 4;
            if (n >= n3 && n <= n3 + 12 && n2 >= n9 && n2 <= n9 + 12) {
                this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.close");
                bl = true;
            }
            RealmsScreen.bind(CROSS_ICON_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            RealmsScreen.blit(n3, n9, 0.0f, bl ? 12.0f : 0.0f, 12, 12, 12.0f, 24.0f);
            GL11.glPopMatrix();
            if (bl) {
                this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.close");
            }
        }
        List<String> list = this.fontSplit(RealmsMainScreen.getLocalizedString("mco.selectServer.popup"), 100);
        n3 = 0;
        for (String string : list) {
            this.drawString(string, this.width() / 2 + 52, n5 + 10 * ++n3 - 3, 0x4C4C4C, false);
        }
    }

    private void drawInvitationPendingIcon(int n, int n2) {
        int n3;
        int n4 = this.numberOfPendingInvites;
        boolean bl = this.inPendingInvitationArea(n, n2);
        int n5 = this.width() / 2 + 50;
        int n6 = 8;
        if (n4 != 0) {
            float f = 0.25f + (1.0f + RealmsMth.sin((float)this.animTick * 0.5f)) * 0.25f;
            n3 = 0xFF000000 | (int)(f * 64.0f) << 16 | (int)(f * 64.0f) << 8 | (int)(f * 64.0f) << 0;
            this.fillGradient(n5 - 2, 6, n5 + 18, 26, n3, n3);
            n3 = 0xFF000000 | (int)(f * 255.0f) << 16 | (int)(f * 255.0f) << 8 | (int)(f * 255.0f) << 0;
            this.fillGradient(n5 - 2, 6, n5 + 18, 7, n3, n3);
            this.fillGradient(n5 - 2, 6, n5 - 1, 26, n3, n3);
            this.fillGradient(n5 + 17, 6, n5 + 18, 26, n3, n3);
            this.fillGradient(n5 - 2, 25, n5 + 18, 26, n3, n3);
        }
        RealmsScreen.bind(INVITE_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n5, 2, bl ? 16.0f : 0.0f, 0.0f, 15, 25, 31.0f, 25.0f);
        GL11.glPopMatrix();
        if (n4 != 0) {
            int n7 = (Math.min(n4, 6) - 1) * 8;
            n3 = (int)(Math.max(0.0f, Math.max(RealmsMth.sin((float)(10 + this.animTick) * 0.57f), RealmsMth.cos((float)this.animTick * 0.35f))) * -6.0f);
            RealmsScreen.bind(INVITATION_ICONS_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            RealmsScreen.blit(n5 + 4, 12 + n3, n7, bl ? 8.0f : 0.0f, 8, 8, 48.0f, 16.0f);
            GL11.glPopMatrix();
        }
        if (bl) {
            int n8 = n + 12;
            n3 = n2;
            String string = n4 == 0 ? RealmsMainScreen.getLocalizedString("mco.invites.nopending") : RealmsMainScreen.getLocalizedString("mco.invites.pending");
            int n9 = this.fontWidth(string);
            this.fillGradient(n8 - 3, n3 - 3, n8 + n9 + 3, n3 + 8 + 3, -1073741824, -1073741824);
            this.fontDrawShadow(string, n8, n3, -1);
        }
    }

    private boolean inPendingInvitationArea(int n, int n2) {
        int n3 = this.width() / 2 + 50;
        int n4 = this.width() / 2 + 66;
        int n5 = 11;
        int n6 = 23;
        if (this.numberOfPendingInvites != 0) {
            n3 -= 3;
            n4 += 3;
            n5 -= 5;
            n6 += 5;
        }
        return n3 <= n && n <= n4 && n5 <= n2 && n2 <= n6;
    }

    public void play(RealmsServer realmsServer) {
        if (realmsServer != null) {
            try {
                if (!connectLock.tryLock(1L, TimeUnit.SECONDS)) {
                    return;
                }
                if (connectLock.getHoldCount() > 1) {
                    return;
                }
            }
            catch (InterruptedException interruptedException) {
                return;
            }
            this.dontSetConnectedToRealms = true;
            if (realmsServer.resourcePackUrl != null && realmsServer.resourcePackHash != null) {
                this.resourcePackServer = realmsServer;
                this.saveListScrollPosition();
                String string = RealmsMainScreen.getLocalizedString("mco.configure.world.resourcepack.question.line1");
                String string2 = RealmsMainScreen.getLocalizedString("mco.configure.world.resourcepack.question.line2");
                Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Info, string, string2, true, 100));
            } else {
                this.connectToServer(realmsServer);
            }
        }
    }

    private void connectToServer(RealmsServer realmsServer) {
        RealmsLongRunningMcoTaskScreen realmsLongRunningMcoTaskScreen = new RealmsLongRunningMcoTaskScreen(this, new RealmsTasks.RealmsConnectTask(this, realmsServer));
        realmsLongRunningMcoTaskScreen.start();
        Realms.setScreen(realmsLongRunningMcoTaskScreen);
    }

    private boolean isSelfOwnedServer(RealmsServer realmsServer) {
        return realmsServer.ownerUUID != null && realmsServer.ownerUUID.equals(Realms.getUUID());
    }

    private boolean isSelfOwnedNonExpiredServer(RealmsServer realmsServer) {
        return realmsServer.ownerUUID != null && realmsServer.ownerUUID.equals(Realms.getUUID()) && !realmsServer.expired;
    }

    private void drawExpired(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(EXPIRED_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.expired");
        }
    }

    private void drawExpiring(int n, int n2, int n3, int n4, int n5) {
        RealmsScreen.bind(EXPIRES_SOON_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        if (this.animTick % 20 < 10) {
            RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 20.0f, 28.0f);
        } else {
            RealmsScreen.blit(n, n2, 10.0f, 0.0f, 10, 28, 20.0f, 28.0f);
        }
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            this.toolTip = n5 <= 0 ? RealmsMainScreen.getLocalizedString("mco.selectServer.expires.soon") : (n5 == 1 ? RealmsMainScreen.getLocalizedString("mco.selectServer.expires.day") : RealmsMainScreen.getLocalizedString("mco.selectServer.expires.days", n5));
        }
    }

    private void drawOpen(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(ON_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.open");
        }
    }

    private void drawClose(int n, int n2, int n3, int n4) {
        RealmsScreen.bind(OFF_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, 0.0f, 0.0f, 10, 28, 10.0f, 28.0f);
        GL11.glPopMatrix();
        if (n3 >= n && n3 <= n + 9 && n4 >= n2 && n4 <= n2 + 27 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.closed");
        }
    }

    private void drawLeave(int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (n3 >= n && n3 <= n + 28 && n4 >= n2 && n4 <= n2 + 28 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            bl = true;
        }
        RealmsScreen.bind(LEAVE_ICON_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, bl ? 28.0f : 0.0f, 0.0f, 28, 28, 56.0f, 28.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.leave");
        }
    }

    private void drawConfigure(int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (n3 >= n && n3 <= n + 28 && n4 >= n2 && n4 <= n2 + 28 && n4 < this.height() - 40 && n4 > 32 && !this.shouldShowPopup()) {
            bl = true;
        }
        RealmsScreen.bind(CONFIGURE_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n, n2, bl ? 28.0f : 0.0f, 0.0f, 28, 28, 56.0f, 28.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.configure");
        }
    }

    protected void renderMousehoverTooltip(String string, int n, int n2) {
        if (string == null) {
            return;
        }
        int n3 = 0;
        int n4 = 0;
        for (String string2 : string.split("\n")) {
            int n5 = this.fontWidth(string2);
            if (n5 <= n4) continue;
            n4 = n5;
        }
        int n6 = n - n4 - 5;
        int n7 = n2;
        if (n6 < 0) {
            n6 = n + 12;
        }
        for (String string3 : string.split("\n")) {
            this.fillGradient(n6 - 3, n7 - (n3 == 0 ? 3 : 0) + n3, n6 + n4 + 3, n7 + 8 + 3 + n3, -1073741824, -1073741824);
            this.fontDrawShadow(string3, n6, n7 + n3, 0xFFFFFF);
            n3 += 10;
        }
    }

    private void renderMoreInfo(int n, int n2) {
        int n3 = this.width() - 17 - 20;
        int n4 = 6;
        boolean bl = false;
        if (n >= n3 && n <= n3 + 20 && n2 >= 6 && n2 <= 26) {
            bl = true;
        }
        RealmsScreen.bind(QUESTIONMARK_LOCATION);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        RealmsScreen.blit(n3, 6, bl ? 20.0f : 0.0f, 0.0f, 20, 20, 40.0f, 20.0f);
        GL11.glPopMatrix();
        if (bl) {
            this.toolTip = RealmsMainScreen.getLocalizedString("mco.selectServer.info");
        }
    }

    private void renderLocal() {
        String string = "LOCAL!";
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width() / 2 - 25, 20.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        this.drawString(string, 0, 0, 0x7FFF7F);
        GL11.glPopMatrix();
    }

    private void renderStage() {
        String string = "STAGE!";
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width() / 2 - 25, 20.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        this.drawString(string, 0, 0, -256);
        GL11.glPopMatrix();
    }

    public RealmsScreen newScreen() {
        return new RealmsMainScreen(this.lastScreen);
    }

    public void closePopup() {
        if (this.shouldShowPopup() && this.popupOpenedByUser) {
            this.popupOpenedByUser = false;
        }
    }

    static {
        realmsGenericErrorScreen = null;
        regionsPinged = false;
        connectLock = new ReentrantLock();
        String string = RealmsVersion.getVersion();
        if (string != null) {
            LOGGER.info("Realms library version == " + string);
        }
    }

    private class ServerSelectionList
    extends RealmsClickableScrolledSelectionList {
        public ServerSelectionList() {
            super(RealmsMainScreen.this.width() + 15, RealmsMainScreen.this.height(), 32, RealmsMainScreen.this.height() - 40, 36);
        }

        @Override
        public int getItemCount() {
            if (RealmsMainScreen.this.shouldShowMessageInList()) {
                return RealmsMainScreen.this.realmsServers.size() + 1;
            }
            return RealmsMainScreen.this.realmsServers.size();
        }

        @Override
        public void selectItem(int n, boolean bl, int n2, int n3) {
            if (RealmsMainScreen.this.shouldShowMessageInList()) {
                if (n == 0) {
                    RealmsMainScreen.this.popupOpenedByUser = true;
                    return;
                }
                --n;
            }
            if (n >= RealmsMainScreen.this.realmsServers.size()) {
                return;
            }
            RealmsServer realmsServer = (RealmsServer)RealmsMainScreen.this.realmsServers.get(n);
            if (realmsServer.state == RealmsServer.State.UNINITIALIZED) {
                RealmsMainScreen.this.selectedServerId = -1L;
                Realms.setScreen(new RealmsCreateRealmScreen(realmsServer, RealmsMainScreen.this));
            } else {
                RealmsMainScreen.this.selectedServerId = realmsServer.id;
            }
            RealmsMainScreen.this.playButton.active(realmsServer.state == RealmsServer.State.OPEN && !realmsServer.expired);
            if (bl && RealmsMainScreen.this.playButton.active()) {
                RealmsMainScreen.this.play(RealmsMainScreen.this.findServer(RealmsMainScreen.this.selectedServerId));
            }
        }

        @Override
        public boolean isSelectedItem(int n) {
            if (RealmsMainScreen.this.shouldShowMessageInList()) {
                if (n == 0) {
                    return false;
                }
                --n;
            }
            return n == RealmsMainScreen.this.findIndex(RealmsMainScreen.this.selectedServerId);
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 36;
        }

        @Override
        public int getScrollbarPosition() {
            return super.getScrollbarPosition() + 15;
        }

        @Override
        protected void renderItem(int n, int n2, int n3, int n4, Tezzelator tezzelator, int n5, int n6) {
            if (RealmsMainScreen.this.shouldShowMessageInList()) {
                if (n == 0) {
                    this.renderTrialItem(n, n2, n3);
                    return;
                }
                --n;
            }
            if (n < RealmsMainScreen.this.realmsServers.size()) {
                this.renderMcoServerItem(n, n2, n3);
            }
        }

        private void renderTrialItem(int n, int n2, int n3) {
            int n4 = n3 + 8;
            int n5 = 0;
            String string = RealmsScreen.getLocalizedString("mco.trial.message");
            boolean bl = false;
            if (n2 <= this.xm() && this.xm() <= this.getScrollbarPosition() && n3 <= this.ym() && this.ym() <= n3 + 32) {
                bl = true;
            }
            int n6 = 0x7FFF7F;
            if (bl && !RealmsMainScreen.this.shouldShowPopup()) {
                n6 = 6077788;
            }
            for (String string2 : string.split("\\\\n")) {
                RealmsMainScreen.this.drawCenteredString(string2, RealmsMainScreen.this.width() / 2, n4 + n5, n6);
                n5 += 10;
            }
        }

        @Override
        public void renderSelected(int n, int n2, int n3, Tezzelator tezzelator) {
            int n4 = this.getScrollbarPosition() - 300;
            int n5 = this.getScrollbarPosition() - 5;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3553);
            tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_TEX_COLOR);
            tezzelator.vertex(n4, n2 + n3 + 2, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 + n3 + 2, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 - 2, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4, n2 - 2, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 + n3 + 1, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 + n3 + 1, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 - 1, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 - 1, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.end();
            GL11.glEnable(3553);
        }

        @Override
        public void itemClicked(int n, int n2, int n3, int n4, int n5) {
            if (RealmsMainScreen.this.shouldShowMessageInList()) {
                if (n2 == 0) {
                    return;
                }
                --n2;
            }
            if (n2 >= RealmsMainScreen.this.realmsServers.size()) {
                return;
            }
            RealmsServer realmsServer = (RealmsServer)RealmsMainScreen.this.realmsServers.get(n2);
            if (realmsServer == null) {
                return;
            }
            if (RealmsMainScreen.this.toolTip != null && RealmsMainScreen.this.toolTip.equals(RealmsScreen.getLocalizedString("mco.selectServer.configure"))) {
                RealmsMainScreen.this.selectedServerId = realmsServer.id;
                RealmsMainScreen.this.configureClicked(realmsServer);
            } else if (RealmsMainScreen.this.toolTip != null && RealmsMainScreen.this.toolTip.equals(RealmsScreen.getLocalizedString("mco.selectServer.leave"))) {
                RealmsMainScreen.this.selectedServerId = realmsServer.id;
                RealmsMainScreen.this.leaveClicked(realmsServer);
            } else if (RealmsMainScreen.this.isSelfOwnedServer(realmsServer) && realmsServer.expired && RealmsMainScreen.this.expiredHover) {
                String string = "https://account.mojang.com/buy/realms?sid=" + realmsServer.remoteSubscriptionId + "&pid=" + Realms.getUUID() + "&ref=" + (realmsServer.expiredTrial ? "expiredTrial" : "expiredRealm");
                this.browseURL(string);
            } else if (RealmsMainScreen.this.isSelfOwnedServer(realmsServer) && RealmsMainScreen.this.updateBreaksAdventureNoteHover) {
                this.browseURL("https://beta.minecraft.net/realms/adventure-maps-in-1-9");
            }
        }

        @Override
        public void customMouseEvent(int n, int n2, int n3, float f, int n4) {
            if (Mouse.isButtonDown(0) && this.ym() >= n && this.ym() <= n2) {
                int n5 = this.width() / 2 - 160;
                int n6 = this.getScrollbarPosition();
                int n7 = this.ym() - n - n3 + (int)f - 4;
                int n8 = n7 / n4;
                if (this.xm() >= n5 && this.xm() <= n6 && n8 >= 0 && n7 >= 0 && n8 < this.getItemCount()) {
                    this.itemClicked(n7, n8, this.xm(), this.ym(), this.width());
                    RealmsMainScreen.this.clicks = RealmsMainScreen.this.clicks + (RealmsSharedConstants.TICKS_PER_SECOND / 3 + 1);
                    this.selectItem(n8, RealmsMainScreen.this.clicks >= RealmsSharedConstants.TICKS_PER_SECOND / 2, this.xm(), this.ym());
                }
            }
        }

        private void renderMcoServerItem(int n, int n2, int n3) {
            RealmsServer realmsServer = (RealmsServer)RealmsMainScreen.this.realmsServers.get(n);
            if (realmsServer.state == RealmsServer.State.UNINITIALIZED) {
                RealmsScreen.bind(RealmsMainScreen.WORLDICON_LOCATION);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3008);
                GL11.glPushMatrix();
                RealmsScreen.blit(n2 + 10, n3 + 6, 0.0f, 0.0f, 40, 20, 40.0f, 20.0f);
                GL11.glPopMatrix();
                float f = 0.5f + (1.0f + RealmsMth.sin((float)RealmsMainScreen.this.animTick * 0.25f)) * 0.25f;
                int n4 = 0xFF000000 | (int)(127.0f * f) << 16 | (int)(255.0f * f) << 8 | (int)(127.0f * f);
                RealmsMainScreen.this.drawCenteredString(RealmsScreen.getLocalizedString("mco.selectServer.uninitialized"), n2 + 10 + 40 + 75, n3 + 12, n4);
                return;
            }
            int n5 = 225;
            int n6 = 2;
            if (realmsServer.expired) {
                RealmsMainScreen.this.drawExpired(n2 + n5 - 14, n3 + n6, this.xm(), this.ym());
            } else if (realmsServer.state == RealmsServer.State.CLOSED) {
                RealmsMainScreen.this.drawClose(n2 + n5 - 14, n3 + n6, this.xm(), this.ym());
            } else if (RealmsMainScreen.this.isSelfOwnedServer(realmsServer) && realmsServer.daysLeft < 7) {
                RealmsMainScreen.this.drawExpiring(n2 + n5 - 14, n3 + n6, this.xm(), this.ym(), realmsServer.daysLeft);
            } else if (realmsServer.state == RealmsServer.State.OPEN) {
                RealmsMainScreen.this.drawOpen(n2 + n5 - 14, n3 + n6, this.xm(), this.ym());
            }
            if (!RealmsMainScreen.this.isSelfOwnedServer(realmsServer) && !overrideConfigure) {
                RealmsMainScreen.this.drawLeave(n2 + n5, n3 + n6, this.xm(), this.ym());
            } else {
                RealmsMainScreen.this.drawConfigure(n2 + n5, n3 + n6, this.xm(), this.ym());
            }
            if (!realmsServer.serverPing.nrOfPlayers.equals("0")) {
                String string = (Object)((Object)ChatFormatting.GRAY) + "" + realmsServer.serverPing.nrOfPlayers;
                RealmsMainScreen.this.drawString(string, n2 + 207 - RealmsMainScreen.this.fontWidth(string), n3 + 3, 0x808080);
                if (this.xm() >= n2 + 207 - RealmsMainScreen.this.fontWidth(string) && this.xm() <= n2 + 207 && this.ym() >= n3 + 1 && this.ym() <= n3 + 10 && this.ym() < RealmsMainScreen.this.height() - 40 && this.ym() > 32 && !RealmsMainScreen.this.shouldShowPopup()) {
                    RealmsMainScreen.this.toolTip = realmsServer.serverPing.playerList;
                }
            }
            if (RealmsMainScreen.this.isSelfOwnedServer(realmsServer) && realmsServer.expired) {
                boolean bl = false;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3042);
                RealmsScreen.bind(RealmsMainScreen.BUTTON_LOCATION);
                GL11.glPushMatrix();
                GL11.glBlendFunc(770, 771);
                String string = RealmsScreen.getLocalizedString("mco.selectServer.expiredList");
                String string2 = RealmsScreen.getLocalizedString("mco.selectServer.expiredRenew");
                if (realmsServer.expiredTrial) {
                    string = RealmsScreen.getLocalizedString("mco.selectServer.expiredTrial");
                    string2 = RealmsScreen.getLocalizedString("mco.selectServer.expiredSubscribe");
                }
                int n7 = RealmsMainScreen.this.fontWidth(string2) + 20;
                int n8 = 16;
                int n9 = n2 + RealmsMainScreen.this.fontWidth(string) + 8;
                int n10 = n3 + 13;
                if (this.xm() >= n9 && this.xm() < n9 + n7 && this.ym() > n10 && this.ym() <= n10 + n8 & this.ym() < RealmsMainScreen.this.height() - 40 && this.ym() > 32 && !RealmsMainScreen.this.shouldShowPopup()) {
                    bl = true;
                    RealmsMainScreen.this.expiredHover = true;
                }
                int n11 = bl ? 2 : 1;
                RealmsScreen.blit(n9, n10, 0.0f, 46 + n11 * 20, n7 / 2, n8 / 2, 256.0f, 256.0f);
                RealmsScreen.blit(n9 + n7 / 2, n10, 200 - n7 / 2, 46 + n11 * 20, n7 / 2, n8 / 2, 256.0f, 256.0f);
                RealmsScreen.blit(n9, n10 + n8 / 2, 0.0f, 46 + n11 * 20 + 12, n7 / 2, n8 / 2, 256.0f, 256.0f);
                RealmsScreen.blit(n9 + n7 / 2, n10 + n8 / 2, 200 - n7 / 2, 46 + n11 * 20 + 12, n7 / 2, n8 / 2, 256.0f, 256.0f);
                GL11.glPopMatrix();
                GL11.glDisable(3042);
                int n12 = n3 + 11 + 5;
                int n13 = bl ? 0xFFFFA0 : 0xFFFFFF;
                RealmsMainScreen.this.drawString(string, n2 + 2, n12 + 1, 15553363);
                RealmsMainScreen.this.drawCenteredString(string2, n9 + n7 / 2, n12 + 1, n13);
            } else {
                if (realmsServer.worldType.equals((Object)RealmsServer.WorldType.MINIGAME)) {
                    int n14 = 0xCCAC5C;
                    String string = RealmsScreen.getLocalizedString("mco.selectServer.minigame") + " ";
                    int n15 = RealmsMainScreen.this.fontWidth(string);
                    RealmsMainScreen.this.drawString(string, n2 + 2, n3 + 12, n14);
                    RealmsMainScreen.this.drawString(realmsServer.getMinigameName(), n2 + 2 + n15, n3 + 19872, 0x6C6C6C);
                } else {
                    RealmsMainScreen.this.drawString(realmsServer.getDescription(), n2 + 2, n3 + 12, 0x6C6C6C);
                }
                if (!RealmsMainScreen.this.isSelfOwnedServer(realmsServer)) {
                    RealmsMainScreen.this.drawString(realmsServer.owner, n2 + 2, n3 + 12 + 11, 0x4C4C4C);
                } else if (realmsServer.worldType.equals((Object)RealmsServer.WorldType.ADVENTUREMAP) && RealmsSharedConstants.VERSION_STRING.equals("1.8.9")) {
                    String string = RealmsScreen.getLocalizedString("mco.selectServer.updateBreaksAdventure", "1.9") + " ";
                    RealmsMainScreen.this.updateBreaksAdventureNoteHover = this.renderRealmNote(n, n2, n3, string);
                }
            }
            RealmsMainScreen.this.drawString(realmsServer.getName(), n2 + 2, n3 + 1, 0xFFFFFF);
            RealmsScreen.bindFace(realmsServer.ownerUUID, realmsServer.owner);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RealmsScreen.blit(n2 - 36, n3, 8.0f, 8.0f, 8, 8, 32, 32, 64.0f, 64.0f);
            RealmsScreen.blit(n2 - 36, n3, 40.0f, 8.0f, 8, 8, 32, 32, 64.0f, 64.0f);
        }

        private boolean renderRealmNote(int n, int n2, int n3, String string) {
            String string2 = RealmsScreen.getLocalizedString("mco.selectServer.note") + " ";
            int n4 = RealmsMainScreen.this.fontWidth(string2);
            int n5 = RealmsMainScreen.this.fontWidth(string);
            int n6 = n4 + n5;
            int n7 = n2 + 2;
            int n8 = n3 + 12 + 11;
            boolean bl = this.xm() >= n7 && this.xm() < n7 + n6 && this.ym() > n8 && this.ym() <= n8 + RealmsMainScreen.this.fontLineHeight();
            int n9 = 15553363;
            int n10 = 0xFFFFFF;
            if (bl) {
                n9 = 12535109;
                n10 = 0xA0A0A0;
                string2 = "\u00a7n" + string2;
                string = "\u00a7n" + string;
            }
            RealmsMainScreen.this.drawString(string2, n7, n8, n9, true);
            RealmsMainScreen.this.drawString(string, n7 + n4, n8, n10, true);
            return bl;
        }

        private void browseURL(String string) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(string), null);
            RealmsUtil.browseTo(string);
        }
    }
}

