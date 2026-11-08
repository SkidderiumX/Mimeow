/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service.impl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CompletableFuture;
import net.raphimc.minecraftauth.msa.service.impl.JfxWebViewMsaAuthService;
import net.raphimc.minecraftauth.msa.service.impl.JfxWebViewMsaAuthService$UserClosedWindowException;

public class JfxWebViewMsaAuthService$1
extends WindowAdapter {
    final CompletableFuture val$authCodeFuture;
    final JfxWebViewMsaAuthService this$0;

    JfxWebViewMsaAuthService$1(JfxWebViewMsaAuthService jfxWebViewMsaAuthService, CompletableFuture completableFuture) {
        this.this$0 = jfxWebViewMsaAuthService;
        this.val$authCodeFuture = completableFuture;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if (!this.val$authCodeFuture.isDone()) {
            this.val$authCodeFuture.completeExceptionally(new JfxWebViewMsaAuthService$UserClosedWindowException());
        }
    }
}

