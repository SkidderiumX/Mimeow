/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oca9cc61aada;
import x.occ2f8dff8d8;
import x.oce4cea752dd;

public class oc97fc249870
extends oc69da1aa7f5 {
    public oca9cc61aada \u02a4;
    public oca9cc61aada \u01ff;
    public occ2f8dff8d8 \u042e;
    public static int j;

    public oc97fc249870() {
        super("Weather", oce4cea752dd.\u04b6);
        this.\u0105("Changes the time and weather shown.");
        this.\u02a4 = new oca9cc61aada("Time", 0.0, 0.0, 24.0, 0.1);
        this.\u028c(this.\u02a4);
        this.\u01ff = new oca9cc61aada("Lightning", 0.0, 0.0, 1.0, 0.01);
        this.\u028c(this.\u01ff);
        this.\u042e = new occ2f8dff8d8("Rain", false);
        this.\u028c(this.\u042e);
    }
}

