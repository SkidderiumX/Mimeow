/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.helpers;

import java.io.PrintStream;

public class Reporter {
    static final String SLF4J_DEBUG_PREFIX = "SLF4J(D): ";
    static final String SLF4J_INFO_PREFIX = "SLF4J(I): ";
    static final String SLF4J_WARN_PREFIX = "SLF4J(W): ";
    static final String SLF4J_ERROR_PREFIX = "SLF4J(E): ";
    public static final String SLF4J_INTERNAL_REPORT_STREAM_KEY = "slf4j.internal.report.stream";
    private static final String[] SYSOUT_KEYS = new String[]{"System.out", "stdout", "sysout"};
    public static final String SLF4J_INTERNAL_VERBOSITY_KEY = "slf4j.internal.verbosity";
    private static final TargetChoice TARGET_CHOICE = Reporter.getTargetChoice();
    private static final Level INTERNAL_VERBOSITY = Reporter.initVerbosity();

    private static TargetChoice getTargetChoice() {
        String string = System.getProperty(SLF4J_INTERNAL_REPORT_STREAM_KEY);
        if (string == null || string.isEmpty()) {
            return TargetChoice.Stderr;
        }
        for (String string2 : SYSOUT_KEYS) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return TargetChoice.Stdout;
        }
        return TargetChoice.Stderr;
    }

    private static Level initVerbosity() {
        String string = System.getProperty(SLF4J_INTERNAL_VERBOSITY_KEY);
        if (string == null || string.isEmpty()) {
            return Level.INFO;
        }
        if (string.equalsIgnoreCase("DEBUG")) {
            return Level.DEBUG;
        }
        if (string.equalsIgnoreCase("ERROR")) {
            return Level.ERROR;
        }
        if (string.equalsIgnoreCase("WARN")) {
            return Level.WARN;
        }
        return Level.INFO;
    }

    static boolean isEnabledFor(Level level) {
        return level.levelInt >= Reporter.INTERNAL_VERBOSITY.levelInt;
    }

    private static PrintStream getTarget() {
        switch (TARGET_CHOICE.ordinal()) {
            case 1: {
                return System.out;
            }
        }
        return System.err;
    }

    public static void debug(String string) {
        if (Reporter.isEnabledFor(Level.DEBUG)) {
            Reporter.getTarget().println(SLF4J_DEBUG_PREFIX + string);
        }
    }

    public static void info(String string) {
        if (Reporter.isEnabledFor(Level.INFO)) {
            Reporter.getTarget().println(SLF4J_INFO_PREFIX + string);
        }
    }

    public static final void warn(String string) {
        if (Reporter.isEnabledFor(Level.WARN)) {
            Reporter.getTarget().println(SLF4J_WARN_PREFIX + string);
        }
    }

    public static final void error(String string, Throwable throwable) {
        Reporter.getTarget().println(SLF4J_ERROR_PREFIX + string);
        Reporter.getTarget().println("SLF4J(E): Reported exception:");
        throwable.printStackTrace(Reporter.getTarget());
    }

    public static final void error(String string) {
        Reporter.getTarget().println(SLF4J_ERROR_PREFIX + string);
    }

    private static enum TargetChoice {
        Stderr,
        Stdout;

    }

    private static enum Level {
        DEBUG(0),
        INFO(1),
        WARN(2),
        ERROR(3);

        int levelInt;

        private Level(int n2) {
            this.levelInt = n2;
        }

        private int getLevelInt() {
            return this.levelInt;
        }
    }
}

