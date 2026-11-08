/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.util;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.RealmsServerAddress;
import com.mojang.realmsclient.dto.WorldTemplate;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.exception.RetryCallException;
import com.mojang.realmsclient.gui.LongRunningTask;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen;
import com.mojang.realmsclient.gui.screens.RealmsTermsScreen;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsConnect;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsTasks {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int NUMBER_OF_RETRIES = 25;

    private static void pause(int n) {
        try {
            Thread.sleep(n * 1000);
        }
        catch (InterruptedException interruptedException) {
            LOGGER.error("", (Throwable)interruptedException);
        }
    }

    public static class TrialCreationTask
    extends LongRunningTask {
        private final String name;
        private final String motd;
        private final RealmsMainScreen lastScreen;

        public TrialCreationTask(String string, String string2, RealmsMainScreen realmsMainScreen) {
            this.name = string;
            this.motd = string2;
            this.lastScreen = realmsMainScreen;
        }

        @Override
        public void run() {
            String string = RealmsScreen.getLocalizedString("mco.create.world.wait");
            this.setTitle(string);
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            try {
                RealmsServer realmsServer = realmsClient.createTrial(this.name, this.motd);
                if (realmsServer != null) {
                    this.lastScreen.closePopup();
                    RealmsResetWorldScreen realmsResetWorldScreen = new RealmsResetWorldScreen(this.lastScreen, realmsServer, this.lastScreen.newScreen(), RealmsScreen.getLocalizedString("mco.selectServer.create"), RealmsScreen.getLocalizedString("mco.create.world.subtitle"), 0xA0A0A0, RealmsScreen.getLocalizedString("mco.create.world.skip"));
                    realmsResetWorldScreen.setResetTitle(RealmsScreen.getLocalizedString("mco.create.world.reset.title"));
                    Realms.setScreen(realmsResetWorldScreen);
                } else {
                    this.error(RealmsScreen.getLocalizedString("mco.trial.unavailable"));
                }
            }
            catch (RealmsServiceException realmsServiceException) {
                LOGGER.error("Couldn't create trial");
                this.error(realmsServiceException.toString());
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Couldn't create trial");
                this.error(unsupportedEncodingException.getLocalizedMessage());
            }
            catch (IOException iOException) {
                LOGGER.error("Could not parse response creating trial");
                this.error(iOException.getLocalizedMessage());
            }
            catch (Exception exception) {
                LOGGER.error("Could not create trial");
                this.error(exception.getLocalizedMessage());
            }
        }
    }

    public static class WorldCreationTask
    extends LongRunningTask {
        private final String name;
        private final String motd;
        private final long worldId;
        private final RealmsScreen lastScreen;

        public WorldCreationTask(long l, String string, String string2, RealmsScreen realmsScreen) {
            this.worldId = l;
            this.name = string;
            this.motd = string2;
            this.lastScreen = realmsScreen;
        }

        @Override
        public void run() {
            String string = RealmsScreen.getLocalizedString("mco.create.world.wait");
            this.setTitle(string);
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            try {
                realmsClient.initializeWorld(this.worldId, this.name, this.motd);
                Realms.setScreen(this.lastScreen);
            }
            catch (RealmsServiceException realmsServiceException) {
                LOGGER.error("Couldn't create world");
                this.error(realmsServiceException.toString());
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Couldn't create world");
                this.error(unsupportedEncodingException.getLocalizedMessage());
            }
            catch (IOException iOException) {
                LOGGER.error("Could not parse response creating world");
                this.error(iOException.getLocalizedMessage());
            }
            catch (Exception exception) {
                LOGGER.error("Could not create world");
                this.error(exception.getLocalizedMessage());
            }
        }
    }

    public static class RealmsConnectTask
    extends LongRunningTask {
        private final RealmsConnect realmsConnect;
        private final RealmsServer data;
        private final RealmsScreen onlineScreen;

        public RealmsConnectTask(RealmsScreen realmsScreen, RealmsServer realmsServer) {
            this.onlineScreen = realmsScreen;
            this.realmsConnect = new RealmsConnect(realmsScreen);
            this.data = realmsServer;
        }

        @Override
        public void run() {
            this.setTitle(RealmsScreen.getLocalizedString("mco.connect.connecting"));
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            boolean bl = false;
            boolean bl2 = false;
            int n = 5;
            RealmsServerAddress realmsServerAddress = null;
            boolean bl3 = false;
            for (int i = 0; i < 20 && !this.aborted(); ++i) {
                try {
                    realmsServerAddress = realmsClient.join(this.data.id);
                    bl = true;
                }
                catch (RetryCallException retryCallException) {
                    n = retryCallException.delaySeconds;
                }
                catch (RealmsServiceException realmsServiceException) {
                    if (realmsServiceException.errorCode == 6002) {
                        bl3 = true;
                        break;
                    }
                    bl2 = true;
                    this.error(realmsServiceException.toString());
                    LOGGER.error("Couldn't connect to world", (Throwable)realmsServiceException);
                    break;
                }
                catch (IOException iOException) {
                    LOGGER.error("Couldn't parse response connecting to world", (Throwable)iOException);
                }
                catch (Exception exception) {
                    bl2 = true;
                    LOGGER.error("Couldn't connect to world", (Throwable)exception);
                    this.error(exception.getLocalizedMessage());
                }
                if (bl) break;
                this.sleep(n);
            }
            if (bl3) {
                Realms.setScreen(new RealmsTermsScreen(this.onlineScreen, this.data));
            } else if (!this.aborted() && !bl2) {
                if (bl) {
                    if (this.data.resourcePackUrl != null && this.data.resourcePackHash != null) {
                        try {
                            final RealmsServerAddress realmsServerAddress2 = realmsServerAddress;
                            Futures.addCallback(Realms.downloadResourcePack(this.data.resourcePackUrl, this.data.resourcePackHash), new FutureCallback<Object>(){

                                @Override
                                public void onSuccess(@Nullable Object object) {
                                    net.minecraft.realms.RealmsServerAddress realmsServerAddress = net.minecraft.realms.RealmsServerAddress.parseString(realmsServerAddress2.address);
                                    RealmsConnectTask.this.realmsConnect.connect(realmsServerAddress.getHost(), realmsServerAddress.getPort());
                                }

                                @Override
                                public void onFailure(Throwable throwable) {
                                    LOGGER.error(throwable);
                                    RealmsConnectTask.this.error("Failed to download resource pack!");
                                }
                            });
                        }
                        catch (Exception exception) {
                            Realms.clearResourcePack();
                            LOGGER.error(exception);
                            this.error("Failed to download resource pack!");
                        }
                    } else {
                        net.minecraft.realms.RealmsServerAddress realmsServerAddress3 = net.minecraft.realms.RealmsServerAddress.parseString(realmsServerAddress.address);
                        this.realmsConnect.connect(realmsServerAddress3.getHost(), realmsServerAddress3.getPort());
                    }
                } else {
                    this.error(RealmsScreen.getLocalizedString("mco.errorMessage.connectionFailure"));
                }
            }
        }

        private void sleep(int n) {
            try {
                Thread.sleep(n * 1000);
            }
            catch (InterruptedException interruptedException) {
                LOGGER.warn(interruptedException.getLocalizedMessage());
            }
        }

        @Override
        public void abortTask() {
            this.realmsConnect.abort();
        }

        @Override
        public void tick() {
            this.realmsConnect.tick();
        }
    }

    public static class ResettingWorldTask
    extends LongRunningTask {
        private final String seed;
        private final WorldTemplate worldTemplate;
        private final int levelType;
        private final boolean generateStructures;
        private final long serverId;
        private final RealmsScreen lastScreen;
        private String title = RealmsScreen.getLocalizedString("mco.reset.world.resetting.screen.title");

        public ResettingWorldTask(long l, RealmsScreen realmsScreen, WorldTemplate worldTemplate) {
            this.seed = null;
            this.worldTemplate = worldTemplate;
            this.levelType = -1;
            this.generateStructures = true;
            this.serverId = l;
            this.lastScreen = realmsScreen;
        }

        public ResettingWorldTask(long l, RealmsScreen realmsScreen, String string, int n, boolean bl) {
            this.seed = string;
            this.worldTemplate = null;
            this.levelType = n;
            this.generateStructures = bl;
            this.serverId = l;
            this.lastScreen = realmsScreen;
        }

        public void setResetTitle(String string) {
            this.title = string;
        }

        @Override
        public void run() {
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            this.setTitle(this.title);
            for (int i = 0; i < 25; ++i) {
                try {
                    if (this.aborted()) {
                        return;
                    }
                    if (this.worldTemplate != null) {
                        realmsClient.resetWorldWithTemplate(this.serverId, this.worldTemplate.id);
                    } else {
                        realmsClient.resetWorldWithSeed(this.serverId, this.seed, this.levelType, this.generateStructures);
                    }
                    if (this.aborted()) {
                        return;
                    }
                    Realms.setScreen(this.lastScreen);
                    return;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsTasks.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Couldn't reset world");
                    this.error(exception.toString());
                    return;
                }
            }
        }
    }

    public static class SwitchMinigameTask
    extends LongRunningTask {
        private final long worldId;
        private final WorldTemplate worldTemplate;
        private final RealmsConfigureWorldScreen lastScreen;

        public SwitchMinigameTask(long l, WorldTemplate worldTemplate, RealmsConfigureWorldScreen realmsConfigureWorldScreen) {
            this.worldId = l;
            this.worldTemplate = worldTemplate;
            this.lastScreen = realmsConfigureWorldScreen;
        }

        @Override
        public void run() {
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            String string = RealmsScreen.getLocalizedString("mco.minigame.world.starting.screen.title");
            this.setTitle(string);
            for (int i = 0; i < 25; ++i) {
                try {
                    if (this.aborted()) {
                        return;
                    }
                    if (!realmsClient.putIntoMinigameMode(this.worldId, this.worldTemplate.id).booleanValue()) continue;
                    Realms.setScreen(this.lastScreen);
                    break;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsTasks.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Couldn't start mini game!");
                    this.error(exception.toString());
                }
            }
        }
    }

    public static class SwitchSlotTask
    extends LongRunningTask {
        private final long worldId;
        private final int slot;
        private final RealmsScreen lastScreen;
        private final int confirmId;

        public SwitchSlotTask(long l, int n, RealmsScreen realmsScreen, int n2) {
            this.worldId = l;
            this.slot = n;
            this.lastScreen = realmsScreen;
            this.confirmId = n2;
        }

        @Override
        public void run() {
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            String string = RealmsScreen.getLocalizedString("mco.minigame.world.slot.screen.title");
            this.setTitle(string);
            for (int i = 0; i < 25; ++i) {
                try {
                    if (this.aborted()) {
                        return;
                    }
                    if (!realmsClient.switchSlot(this.worldId, this.slot)) continue;
                    this.lastScreen.confirmResult(true, this.confirmId);
                    break;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsTasks.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Couldn't switch world!");
                    this.error(exception.toString());
                }
            }
        }
    }

    public static class CloseServerTask
    extends LongRunningTask {
        private final RealmsServer serverData;
        private final RealmsConfigureWorldScreen configureScreen;

        public CloseServerTask(RealmsServer realmsServer, RealmsConfigureWorldScreen realmsConfigureWorldScreen) {
            this.serverData = realmsServer;
            this.configureScreen = realmsConfigureWorldScreen;
        }

        @Override
        public void run() {
            this.setTitle(RealmsScreen.getLocalizedString("mco.configure.world.closing"));
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            for (int i = 0; i < 25; ++i) {
                if (this.aborted()) {
                    return;
                }
                try {
                    boolean bl = realmsClient.close(this.serverData.id);
                    if (!bl) continue;
                    this.configureScreen.stateChanged();
                    this.serverData.state = RealmsServer.State.CLOSED;
                    Realms.setScreen(this.configureScreen);
                    break;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsTasks.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Failed to close server", (Throwable)exception);
                    this.error("Failed to close the server");
                }
            }
        }
    }

    public static class OpenServerTask
    extends LongRunningTask {
        private final RealmsServer serverData;
        private final RealmsConfigureWorldScreen configureScreen;
        private final boolean join;
        private final RealmsScreen lastScreen;

        public OpenServerTask(RealmsServer realmsServer, RealmsConfigureWorldScreen realmsConfigureWorldScreen, RealmsScreen realmsScreen, boolean bl) {
            this.serverData = realmsServer;
            this.configureScreen = realmsConfigureWorldScreen;
            this.join = bl;
            this.lastScreen = realmsScreen;
        }

        @Override
        public void run() {
            this.setTitle(RealmsScreen.getLocalizedString("mco.configure.world.opening"));
            RealmsClient realmsClient = RealmsClient.createRealmsClient();
            for (int i = 0; i < 25; ++i) {
                if (this.aborted()) {
                    return;
                }
                try {
                    boolean bl = realmsClient.open(this.serverData.id);
                    if (!bl) continue;
                    this.configureScreen.stateChanged();
                    this.serverData.state = RealmsServer.State.OPEN;
                    if (this.join) {
                        ((RealmsMainScreen)this.lastScreen).play(this.serverData);
                        break;
                    }
                    Realms.setScreen(this.configureScreen);
                    break;
                }
                catch (RetryCallException retryCallException) {
                    if (this.aborted()) {
                        return;
                    }
                    RealmsTasks.pause(retryCallException.delaySeconds);
                    continue;
                }
                catch (Exception exception) {
                    if (this.aborted()) {
                        return;
                    }
                    LOGGER.error("Failed to open server", (Throwable)exception);
                    this.error("Failed to open the server");
                }
            }
        }
    }
}

