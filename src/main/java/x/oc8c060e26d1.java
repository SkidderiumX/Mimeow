/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;
import x.oca9cc61aada;
import x.oce4cea752dd;

public class oc8c060e26d1
extends oc69da1aa7f5 {
    public static oc8c060e26d1 \u04bd;
    public final oca9cc61aada \u0450;
    public static boolean \u0426;

    public oc8c060e26d1() {
        super("ItemPhysics", oce4cea752dd.\u014e, 0);
        this.\u0105("Adds rotation and resting motion to dropped items.");
        this.\u0450 = new oca9cc61aada("Rotation speed", 1.0, 0.0, 5.0, 0.1);
        this.\u028c(this.\u0450);
    }

    @Override
    public void onEnable() {
        \u04bd = this;
    }

    @Override
    public void onDisable() {
        \u04bd = null;
    }
}

