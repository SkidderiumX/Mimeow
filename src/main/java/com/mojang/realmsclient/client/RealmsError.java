/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.util.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsError {
    private static final Logger LOGGER = LogManager.getLogger();
    private String errorMessage;
    private int errorCode;

    public RealmsError(String string) {
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(string).getAsJsonObject();
            this.errorMessage = JsonUtils.getStringOr("errorMsg", jsonObject, "");
            this.errorCode = JsonUtils.getIntOr("errorCode", jsonObject, -1);
        }
        catch (Exception exception) {
            LOGGER.error("Could not parse RealmsError: " + exception.getMessage());
        }
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}

