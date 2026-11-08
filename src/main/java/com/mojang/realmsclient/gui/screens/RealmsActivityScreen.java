/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.dto.ServerActivity;
import com.mojang.realmsclient.dto.ServerActivityList;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.util.RealmsUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsDefaultVertexFormat;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsScrolledSelectionList;
import net.minecraft.realms.Tezzelator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class RealmsActivityScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private final RealmsScreen lastScreen;
    private final RealmsServer serverData;
    private volatile List<ActivityRow> activityMap = new ArrayList<ActivityRow>();
    private DetailsList list;
    private int matrixWidth;
    private String toolTip;
    private volatile List<Day> dayList = new ArrayList<Day>();
    private List<Color> colors = Arrays.asList(new Color(79, 243, 29), new Color(243, 175, 29), new Color(243, 29, 190), new Color(29, 165, 243), new Color(29, 243, 130), new Color(243, 29, 64), new Color(29, 74, 243));
    private int colorIndex = 0;
    private long periodInMillis;
    private int maxKeyWidth = 0;
    private Boolean noActivity = false;
    private int activityPoint = 0;
    private int dayWidth = 0;
    private double hourWidth = 0.0;
    private double minuteWidth = 0.0;
    private int BUTTON_BACK_ID = 0;

    public RealmsActivityScreen(RealmsScreen realmsScreen, RealmsServer realmsServer) {
        this.lastScreen = realmsScreen;
        this.serverData = realmsServer;
        this.getActivities();
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.list.mouseEvent();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.matrixWidth = this.width();
        this.list = new DetailsList();
        this.buttonsAdd(RealmsActivityScreen.newButton(this.BUTTON_BACK_ID, this.width() / 2 - 100, this.height() - 30, 200, 20, RealmsActivityScreen.getLocalizedString("gui.back")));
    }

    private Color getColor() {
        if (this.colorIndex > this.colors.size() - 1) {
            this.colorIndex = 0;
        }
        return this.colors.get(this.colorIndex++);
    }

    private void getActivities() {
        new Thread(){

            @Override
            public void run() {
                RealmsClient realmsClient = RealmsClient.createRealmsClient();
                try {
                    Day day;
                    String string;
                    ServerActivityList serverActivityList = realmsClient.getActivity(((RealmsActivityScreen)RealmsActivityScreen.this).serverData.id);
                    RealmsActivityScreen.this.activityMap = RealmsActivityScreen.this.convertToActivityMatrix(serverActivityList);
                    ArrayList<Day> arrayList = new ArrayList<Day>();
                    for (ActivityRow activityRow : RealmsActivityScreen.this.activityMap) {
                        for (Activity activity : activityRow.activities) {
                            string = new SimpleDateFormat("dd/MM").format(new Date(activity.start));
                            day = new Day(string, activity.start);
                            if (arrayList.contains(day)) continue;
                            arrayList.add(day);
                        }
                    }
                    Collections.sort(arrayList);
                    for (ActivityRow activityRow : RealmsActivityScreen.this.activityMap) {
                        for (Activity activity : activityRow.activities) {
                            string = new SimpleDateFormat("dd/MM").format(new Date(activity.start));
                            day = new Day(string, activity.start);
                            activity.dayIndex = arrayList.indexOf(day) + 1;
                        }
                    }
                    RealmsActivityScreen.this.dayList = arrayList;
                }
                catch (RealmsServiceException realmsServiceException) {
                    realmsServiceException.printStackTrace();
                }
            }
        }.start();
    }

    private List<ActivityRow> convertToActivityMatrix(ServerActivityList serverActivityList) {
        ArrayList<ActivityRow> arrayList = Lists.newArrayList();
        this.periodInMillis = serverActivityList.periodInMillis;
        long l = System.currentTimeMillis() - serverActivityList.periodInMillis;
        for (ServerActivity object : serverActivityList.serverActivities) {
            ActivityRow activityRow = this.find(object.profileUuid, arrayList);
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            calendar.setTimeInMillis(object.joinTime);
            Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
            calendar2.setTimeInMillis(object.leaveTime);
            Activity activity = new Activity(l, calendar.getTimeInMillis(), calendar2.getTimeInMillis());
            if (activityRow == null) {
                String string = "";
                try {
                    string = RealmsUtil.nameCache.get(object.profileUuid);
                }
                catch (Exception exception) {
                    LOGGER.error("Could not get name for " + object.profileUuid, (Throwable)exception);
                    continue;
                }
                activityRow = new ActivityRow(object.profileUuid, new ArrayList<Activity>(), string, object.profileUuid);
                activityRow.activities.add(activity);
                arrayList.add(activityRow);
                continue;
            }
            activityRow.activities.add(activity);
        }
        Collections.sort(arrayList);
        for (ActivityRow activityRow : arrayList) {
            activityRow.color = this.getColor();
            Collections.sort(activityRow.activities);
        }
        this.noActivity = arrayList.size() == 0;
        return arrayList;
    }

    private ActivityRow find(String string, List<ActivityRow> list) {
        for (ActivityRow activityRow : list) {
            if (!activityRow.key.equals(string)) continue;
            return activityRow;
        }
        return null;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (realmsButton.id() == this.BUTTON_BACK_ID) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        if (n == 1) {
            Realms.setScreen(this.lastScreen);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        int n3;
        this.toolTip = null;
        this.renderBackground();
        for (ActivityRow activityRow : this.activityMap) {
            n3 = this.fontWidth(activityRow.name);
            if (n3 <= this.maxKeyWidth) continue;
            this.maxKeyWidth = n3 + 10;
        }
        int n4 = 25;
        this.activityPoint = this.maxKeyWidth + n4;
        int n5 = this.matrixWidth - this.activityPoint - 10;
        n3 = this.dayList.size() < 1 ? 1 : this.dayList.size();
        this.dayWidth = n5 / n3;
        this.hourWidth = (double)this.dayWidth / 24.0;
        this.minuteWidth = this.hourWidth / 60.0;
        this.list.render(n, n2, f);
        if (this.activityMap != null && this.activityMap.size() > 0) {
            Tezzelator tezzelator = Tezzelator.instance;
            GL11.glDisable(3553);
            tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_COLOR);
            tezzelator.vertex(this.activityPoint, this.height() - 40, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(this.activityPoint + 1, this.height() - 40, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(this.activityPoint + 1, 30.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(this.activityPoint, 30.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.end();
            GL11.glEnable(3553);
            for (Day day : this.dayList) {
                int n6 = this.dayList.indexOf(day) + 1;
                this.drawString(day.day, this.activityPoint + (n6 - 1) * this.dayWidth + (this.dayWidth - this.fontWidth(day.day)) / 2 + 2, this.height() - 52, 0xFFFFFF);
                GL11.glDisable(3553);
                tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_COLOR);
                tezzelator.vertex(this.activityPoint + n6 * this.dayWidth, this.height() - 40, 0.0).color(128, 128, 128, 255).endVertex();
                tezzelator.vertex(this.activityPoint + n6 * this.dayWidth + 1, this.height() - 40, 0.0).color(128, 128, 128, 255).endVertex();
                tezzelator.vertex(this.activityPoint + n6 * this.dayWidth + 1, 30.0, 0.0).color(128, 128, 128, 255).endVertex();
                tezzelator.vertex(this.activityPoint + n6 * this.dayWidth, 30.0, 0.0).color(128, 128, 128, 255).endVertex();
                tezzelator.end();
                GL11.glEnable(3553);
            }
        }
        super.render(n, n2, f);
        this.drawCenteredString(RealmsActivityScreen.getLocalizedString("mco.activity.title"), this.width() / 2, 10, 0xFFFFFF);
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
        if (this.noActivity.booleanValue()) {
            this.drawCenteredString(RealmsActivityScreen.getLocalizedString("mco.activity.noactivity", TimeUnit.DAYS.convert(this.periodInMillis, TimeUnit.MILLISECONDS)), this.width() / 2, this.height() / 2 - 20, 0xFFFFFF);
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
            this.fontDrawShadow(string3, n6, n7 + n3, -1);
            n3 += 10;
        }
    }

    public class DetailsList
    extends RealmsScrolledSelectionList {
        public DetailsList() {
            super(RealmsActivityScreen.this.width(), RealmsActivityScreen.this.height(), 30, RealmsActivityScreen.this.height() - 40, RealmsActivityScreen.this.fontLineHeight() + 1);
        }

        @Override
        public int getItemCount() {
            return RealmsActivityScreen.this.activityMap.size();
        }

        @Override
        public void selectItem(int n, boolean bl, int n2, int n3) {
        }

        @Override
        public boolean isSelectedItem(int n) {
            return false;
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * (RealmsActivityScreen.this.fontLineHeight() + 1) + 15;
        }

        @Override
        protected void renderItem(int n, int n2, int n3, int n4, Tezzelator tezzelator, int n5, int n6) {
            if (RealmsActivityScreen.this.activityMap != null && RealmsActivityScreen.this.activityMap.size() > n) {
                ActivityRow activityRow = (ActivityRow)RealmsActivityScreen.this.activityMap.get(n);
                RealmsActivityScreen.this.drawString(activityRow.name, 20, n3, ((ActivityRow)((RealmsActivityScreen)RealmsActivityScreen.this).activityMap.get((int)n)).uuid.equals(Realms.getUUID()) ? 0x7FFF7F : 0xFFFFFF);
                int n7 = activityRow.color.r;
                int n8 = activityRow.color.g;
                int n9 = activityRow.color.b;
                GL11.glDisable(3553);
                tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_COLOR);
                tezzelator.vertex(RealmsActivityScreen.this.activityPoint - 8, (double)n3 + 6.5, 0.0).color(n7, n8, n9, 255).endVertex();
                tezzelator.vertex(RealmsActivityScreen.this.activityPoint - 3, (double)n3 + 6.5, 0.0).color(n7, n8, n9, 255).endVertex();
                tezzelator.vertex(RealmsActivityScreen.this.activityPoint - 3, (double)n3 + 1.5, 0.0).color(n7, n8, n9, 255).endVertex();
                tezzelator.vertex(RealmsActivityScreen.this.activityPoint - 8, (double)n3 + 1.5, 0.0).color(n7, n8, n9, 255).endVertex();
                tezzelator.end();
                GL11.glEnable(3553);
                RealmsScreen.bindFace(((ActivityRow)((RealmsActivityScreen)RealmsActivityScreen.this).activityMap.get((int)n)).uuid, ((ActivityRow)((RealmsActivityScreen)RealmsActivityScreen.this).activityMap.get((int)n)).name);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                RealmsScreen.blit(10, n3, 8.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
                RealmsScreen.blit(10, n3, 40.0f, 8.0f, 8, 8, 8, 8, 64.0f, 64.0f);
                ArrayList<ActivityRender> arrayList = new ArrayList<ActivityRender>();
                for (Activity object : activityRow.activities) {
                    int n10 = object.minuteIndice();
                    int n11 = object.hourIndice();
                    double d = RealmsActivityScreen.this.minuteWidth * (double)TimeUnit.MINUTES.convert(object.end - object.start, TimeUnit.MILLISECONDS);
                    if (d < 3.0) {
                        d = 3.0;
                    }
                    double d2 = (double)(RealmsActivityScreen.this.activityPoint + (RealmsActivityScreen.this.dayWidth * object.dayIndex - RealmsActivityScreen.this.dayWidth)) + (double)n11 * RealmsActivityScreen.this.hourWidth + (double)n10 * RealmsActivityScreen.this.minuteWidth;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    Date date = new Date(object.start);
                    Date date2 = new Date(object.end);
                    int n12 = (int)Math.ceil((double)TimeUnit.SECONDS.convert(object.end - object.start, TimeUnit.MILLISECONDS) / 60.0);
                    if (n12 < 1) {
                        n12 = 1;
                    }
                    String string = "[" + simpleDateFormat.format(date) + " - " + simpleDateFormat.format(date2) + "] " + n12 + (n12 > 1 ? " minutes" : " minute");
                    boolean bl = false;
                    for (ActivityRender activityRender : arrayList) {
                        if (!(activityRender.start + activityRender.width >= d2 - 0.5)) continue;
                        double d3 = activityRender.start + activityRender.width - d2;
                        double d4 = Math.max(0.0, d2 - (activityRender.start + activityRender.width));
                        activityRender.width = activityRender.width - Math.max(0.0, d3) + d + d4;
                        activityRender.tooltip = activityRender.tooltip + "\n" + string;
                        bl = true;
                        break;
                    }
                    if (bl) continue;
                    arrayList.add(new ActivityRender(d2, d, string));
                }
                for (ActivityRender activityRender : arrayList) {
                    GL11.glDisable(3553);
                    tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_COLOR);
                    tezzelator.vertex(activityRender.start, (double)n3 + 6.5, 0.0).color(n7, n8, n9, 255).endVertex();
                    tezzelator.vertex(activityRender.start + activityRender.width, (double)n3 + 6.5, 0.0).color(n7, n8, n9, 255).endVertex();
                    tezzelator.vertex(activityRender.start + activityRender.width, (double)n3 + 1.5, 0.0).color(n7, n8, n9, 255).endVertex();
                    tezzelator.vertex(activityRender.start, (double)n3 + 1.5, 0.0).color(n7, n8, n9, 255).endVertex();
                    tezzelator.end();
                    GL11.glEnable(3553);
                    if (!((double)this.xm() >= activityRender.start) || !((double)this.xm() <= activityRender.start + activityRender.width) || !((double)this.ym() >= (double)n3 + 1.5) || !((double)this.ym() <= (double)n3 + 6.5)) continue;
                    RealmsActivityScreen.this.toolTip = activityRender.tooltip.trim();
                }
            }
        }

        @Override
        public int getScrollbarPosition() {
            return this.width() - 7;
        }
    }

    public static class ActivityRender {
        double start;
        double width;
        String tooltip;

        private ActivityRender(double d, double d2, String string) {
            this.start = d;
            this.width = d2;
            this.tooltip = string;
        }
    }

    public static class Activity
    implements Comparable<Activity> {
        long base;
        long start;
        long end;
        int dayIndex;

        private Activity(long l, long l2, long l3) {
            this.base = l;
            this.start = l2;
            this.end = l3;
        }

        @Override
        public int compareTo(Activity activity) {
            return (int)(this.start - activity.start);
        }

        public int hourIndice() {
            String string = new SimpleDateFormat("HH").format(new Date(this.start));
            return Integer.parseInt(string);
        }

        public int minuteIndice() {
            String string = new SimpleDateFormat("mm").format(new Date(this.start));
            return Integer.parseInt(string);
        }
    }

    public static class ActivityRow
    implements Comparable<ActivityRow> {
        String key;
        List<Activity> activities;
        Color color;
        String name;
        String uuid;

        @Override
        public int compareTo(ActivityRow activityRow) {
            return this.name.compareTo(activityRow.name);
        }

        ActivityRow(String string, List<Activity> list, String string2, String string3) {
            this.key = string;
            this.activities = list;
            this.name = string2;
            this.uuid = string3;
        }
    }

    public static class Day
    implements Comparable<Day> {
        String day;
        Long timestamp;

        @Override
        public int compareTo(Day day) {
            return this.timestamp.compareTo(day.timestamp);
        }

        Day(String string, Long l) {
            this.day = string;
            this.timestamp = l;
        }

        public boolean equals(Object object) {
            if (!(object instanceof Day)) {
                return false;
            }
            Day day = (Day)object;
            return this.day.equals(day.day);
        }
    }

    public static class Color {
        int r;
        int g;
        int b;

        Color(int n, int n2, int n3) {
            this.r = n;
            this.g = n2;
            this.b = n3;
        }
    }
}

