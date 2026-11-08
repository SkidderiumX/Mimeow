/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.Subscription;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsGenericErrorScreen;
import com.mojang.realmsclient.gui.screens.RealmsLongConfirmationScreen;
import com.mojang.realmsclient.util.RealmsUtil;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class RealmsSubscriptionInfoScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private final RealmsScreen lastScreen;
    private final RealmsServer serverData;
    private final RealmsScreen mainScreen;
    private final int BUTTON_BACK_ID = 0;
    private final int BUTTON_DELETE_ID = 1;
    private int daysLeft;
    private String startDate;
    private Subscription.SubscriptionType type;
    private final String PURCHASE_LINK = "https://account.mojang.com/buy/realms";
    private boolean onLink;

    public RealmsSubscriptionInfoScreen(RealmsScreen realmsScreen, RealmsServer realmsServer, RealmsScreen realmsScreen2) {
        this.lastScreen = realmsScreen;
        this.serverData = realmsServer;
        this.mainScreen = realmsScreen2;
    }

    @Override
    public void init() {
        this.getSubscription(this.serverData.id);
        Keyboard.enableRepeatEvents(true);
        this.buttonsAdd(RealmsSubscriptionInfoScreen.newButton(0, this.width() / 2 - 100, RealmsConstants.row(12), RealmsSubscriptionInfoScreen.getLocalizedString("gui.back")));
        if (this.serverData.expired) {
            this.buttonsAdd(RealmsSubscriptionInfoScreen.newButton(1, this.width() / 2 - 100, RealmsConstants.row(10), RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.delete.button")));
        }
    }

    private void getSubscription(long l) {
        RealmsClient realmsClient = RealmsClient.createRealmsClient();
        try {
            Subscription subscription = realmsClient.subscriptionFor(l);
            this.daysLeft = subscription.daysLeft;
            this.startDate = this.localPresentation(subscription.startDate);
            this.type = subscription.type;
        }
        catch (RealmsServiceException realmsServiceException) {
            LOGGER.error("Couldn't get subscription");
            Realms.setScreen(new RealmsGenericErrorScreen(realmsServiceException, this.lastScreen));
        }
        catch (IOException iOException) {
            LOGGER.error("Couldn't parse response subscribing");
        }
    }

    @Override
    public void confirmResult(boolean bl, int n) {
        if (n == 1 && bl) {
            new Thread("Realms-delete-realm"){

                @Override
                public void run() {
                    try {
                        RealmsClient realmsClient = RealmsClient.createRealmsClient();
                        realmsClient.deleteWorld(((RealmsSubscriptionInfoScreen)RealmsSubscriptionInfoScreen.this).serverData.id);
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't delete world");
                        LOGGER.error(realmsServiceException);
                    }
                    catch (IOException iOException) {
                        LOGGER.error("Couldn't delete world");
                        iOException.printStackTrace();
                    }
                    Realms.setScreen(RealmsSubscriptionInfoScreen.this.mainScreen);
                }
            }.start();
        }
        Realms.setScreen(this);
    }

    private String localPresentation(long l) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        gregorianCalendar.setTimeInMillis(l);
        return SimpleDateFormat.getDateTimeInstance().format(gregorianCalendar.getTime());
    }

    @Override
    public void removed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        if (realmsButton.id() == 0) {
            Realms.setScreen(this.lastScreen);
        } else if (realmsButton.id() == 1) {
            String string = RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.delete.question.line1");
            String string2 = RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.delete.question.line2");
            Realms.setScreen(new RealmsLongConfirmationScreen(this, RealmsLongConfirmationScreen.Type.Warning, string, string2, true, 1));
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (this.onLink) {
            String string = "https://account.mojang.com/buy/realms?sid=" + this.serverData.remoteSubscriptionId + "&pid=" + Realms.getUUID();
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(string), null);
            RealmsUtil.browseTo(string);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.renderBackground();
        int n3 = this.width() / 2 - 100;
        this.drawCenteredString(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.title"), this.width() / 2, 17, 0xFFFFFF);
        this.drawString(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.start"), n3, RealmsConstants.row(0), 0xA0A0A0);
        this.drawString(this.startDate, n3, RealmsConstants.row(1), 0xFFFFFF);
        if (this.type == Subscription.SubscriptionType.NORMAL) {
            this.drawString(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.timeleft"), n3, RealmsConstants.row(3), 0xA0A0A0);
        } else if (this.type == Subscription.SubscriptionType.RECURRING) {
            this.drawString(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.recurring.daysleft"), n3, RealmsConstants.row(3), 0xA0A0A0);
        }
        this.drawString(this.daysLeftPresentation(this.daysLeft), n3, RealmsConstants.row(4), 0xFFFFFF);
        this.drawString(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.extendHere"), n3, RealmsConstants.row(6), 0xA0A0A0);
        int n4 = RealmsConstants.row(7);
        int n5 = this.fontWidth("https://account.mojang.com/buy/realms");
        int n6 = this.width() / 2 - n5 / 2 - 1;
        int n7 = n4 - 1;
        int n8 = n6 + n5 + 1;
        int n9 = n4 + 1 + this.fontLineHeight();
        if (n6 <= n && n <= n8 && n7 <= n2 && n2 <= n9) {
            this.onLink = true;
            this.drawString("https://account.mojang.com/buy/realms", this.width() / 2 - n5 / 2, n4, 7107012);
        } else {
            this.onLink = false;
            this.drawString("https://account.mojang.com/buy/realms", this.width() / 2 - n5 / 2, n4, 0x3366BB);
        }
        super.render(n, n2, f);
    }

    private String daysLeftPresentation(int n) {
        if (n == -1 && this.serverData.expired) {
            return RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.expired");
        }
        if (n <= 1) {
            return RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.less_than_a_day");
        }
        int n2 = n / 30;
        int n3 = n % 30;
        StringBuilder stringBuilder = new StringBuilder();
        if (n2 > 0) {
            stringBuilder.append(n2).append(" ");
            if (n2 == 1) {
                stringBuilder.append(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.month").toLowerCase());
            } else {
                stringBuilder.append(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.months").toLowerCase());
            }
        }
        if (n3 > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(n3).append(" ");
            if (n3 == 1) {
                stringBuilder.append(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.day").toLowerCase());
            } else {
                stringBuilder.append(RealmsSubscriptionInfoScreen.getLocalizedString("mco.configure.world.subscription.days").toLowerCase());
            }
        }
        return stringBuilder.toString();
    }
}

