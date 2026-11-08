/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.HashMap;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.optifine.http.FileUploadThread;
import net.optifine.http.IFileUploadListener;
import net.optifine.shaders.Shaders;

public class CrashReporter {
    public static void onCrashReport(CrashReport crashReport, CrashReportCategory crashReportCategory) {
        try {
            Throwable throwable = crashReport.getCrashCause();
            if (throwable == null) {
                return;
            }
            if (throwable.getClass().getName().contains(".optionalLoader.client.SplashProgress")) {
                return;
            }
            if (throwable.getClass() == Throwable.class) {
                return;
            }
            CrashReporter.extendCrashReport(crashReportCategory);
            GameSettings gameSettings = Config.getGameSettings();
            if (gameSettings == null) {
                return;
            }
            if (!gameSettings.snooperEnabled) {
                return;
            }
            String string = "http://optifine.net/crashReport";
            String string2 = CrashReporter.makeReport(crashReport);
            byte[] byArray = string2.getBytes("ASCII");
            IFileUploadListener iFileUploadListener = new IFileUploadListener(){

                @Override
                public void fileUploadFinished(String string, byte[] byArray, Throwable throwable) {
                }
            };
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("OF-Version", Config.getVersion());
            hashMap.put("OF-Summary", CrashReporter.makeSummary(crashReport));
            FileUploadThread fileUploadThread = new FileUploadThread(string, hashMap, byArray, iFileUploadListener);
            fileUploadThread.setPriority(10);
            fileUploadThread.start();
            Thread.sleep(1000L);
        }
        catch (Exception exception) {
            Config.dbg(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }

    private static String makeReport(CrashReport crashReport) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OptiFineVersion: " + Config.getVersion() + "\n");
        stringBuffer.append("Summary: " + CrashReporter.makeSummary(crashReport) + "\n");
        stringBuffer.append("\n");
        stringBuffer.append(crashReport.getCompleteReport());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private static String makeSummary(CrashReport crashReport) {
        Throwable throwable = crashReport.getCrashCause();
        if (throwable == null) {
            return "Unknown";
        }
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        String string = "unknown";
        if (stackTraceElementArray.length > 0) {
            string = stackTraceElementArray[0].toString().trim();
        }
        String string2 = throwable.getClass().getName() + ": " + throwable.getMessage() + " (" + crashReport.getDescription() + ") [" + string + "]";
        return string2;
    }

    public static void extendCrashReport(CrashReportCategory crashReportCategory) {
        crashReportCategory.addCrashSection("OptiFine Version", Config.getVersion());
        crashReportCategory.addCrashSection("OptiFine Build", Config.getBuild());
        if (Config.getGameSettings() != null) {
            crashReportCategory.addCrashSection("Render Distance Chunks", "" + Config.getChunkViewDistance());
            crashReportCategory.addCrashSection("Mipmaps", "" + Config.getMipmapLevels());
            crashReportCategory.addCrashSection("Anisotropic Filtering", "" + Config.getAnisotropicFilterLevel());
            crashReportCategory.addCrashSection("Antialiasing", "" + Config.getAntialiasingLevel());
            crashReportCategory.addCrashSection("Multitexture", "" + Config.isMultiTexture());
        }
        crashReportCategory.addCrashSection("Shaders", Shaders.getShaderPackName());
        crashReportCategory.addCrashSection("OpenGlVersion", Config.openGlVersion);
        crashReportCategory.addCrashSection("OpenGlRenderer", Config.openGlRenderer);
        crashReportCategory.addCrashSection("OpenGlVendor", Config.openGlVendor);
        crashReportCategory.addCrashSection("CpuCount", "" + Config.getAvailableProcessors());
    }
}

