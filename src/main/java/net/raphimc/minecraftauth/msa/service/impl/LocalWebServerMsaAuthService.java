/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service.impl;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.utils.URLWrapper;
import net.raphimc.minecraftauth.msa.exception.MsaRequestException;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;

public class LocalWebServerMsaAuthService
extends MsaAuthService {
    private final Consumer<URL> callback;
    private final int timeoutMs;

    public LocalWebServerMsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, Consumer<URL> consumer) {
        this(httpClient, msaApplicationConfig, consumer, 300000);
    }

    public LocalWebServerMsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, Consumer<URL> consumer, int n) {
        super(httpClient, msaApplicationConfig);
        if (this.applicationConfig.getRedirectUri() == null) {
            throw new IllegalArgumentException("The application config must have a redirect uri set");
        }
        this.callback = consumer;
        this.timeoutMs = n;
    }

    /*
     * Exception decompiling
     */
    @Override
    public MsaToken acquireToken() throws IOException, InterruptedException, TimeoutException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static /* synthetic */ void lambda$acquireToken$0(CompletableFuture completableFuture, HttpExchange httpExchange) throws IOException {
        try {
            URLWrapper.QueryParametersWrapper queryParametersWrapper = URLWrapper.of(httpExchange.getRequestURI()).wrapQueryParameters();
            Optional<String> optional = queryParametersWrapper.getFirstValue("error");
            Optional<String> optional2 = queryParametersWrapper.getFirstValue("error_description");
            if (optional.isPresent() && optional2.isPresent()) {
                HttpResponse httpResponse = new HttpResponse(null, 500, new byte[0], Collections.emptyMap());
                throw new MsaRequestException(httpResponse, optional.get(), optional2.get());
            }
            Optional<String> optional3 = queryParametersWrapper.getFirstValue("code");
            if (!optional3.isPresent()) {
                throw new IllegalStateException("Failed to extract auth code from response url");
            }
            byte[] byArray = "You have been logged in! You can now close this window.".getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(200, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.complete(optional3.get());
        }
        catch (Throwable throwable) {
            byte[] byArray = ("Login failed. Error message: " + throwable.getMessage()).getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(500, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.completeExceptionally(throwable);
        }
    }
}

