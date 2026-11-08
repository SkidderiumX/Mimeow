/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class XblRequestException
extends ApiHttpRequestException {
    public static final long AM_E_XASD_UNEXPECTED = 2279407619L;
    public static final long AM_E_XASU_UNEXPECTED = 2279407620L;
    public static final long AM_E_XAST_UNEXPECTED = 2279407621L;
    public static final long AM_E_XSTS_UNEXPECTED = 2279407622L;
    public static final long AM_E_XDEVICE_UNEXPECTED = 2279407623L;
    public static final long AM_E_DEVMODE_NOT_AUTHORIZED = 2279407624L;
    public static final long AM_E_NOT_AUTHORIZED = 2279407625L;
    public static final long AM_E_FORBIDDEN = 2279407626L;
    public static final long AM_E_UNKNOWN_TARGET = 2279407627L;
    public static final long AM_E_INVALID_NSAL_DATA = 2279407628L;
    public static final long AM_E_TITLE_NOT_AUTHENTICATED = 2279407629L;
    public static final long AM_E_TITLE_NOT_AUTHORIZED = 2279407630L;
    public static final long AM_E_DEVICE_NOT_AUTHENTICATED = 2279407631L;
    public static final long AM_E_INVALID_USER_INDEX = 2279407632L;
    public static final long XO_E_DEVMODE_NOT_AUTHORIZED = 2148916224L;
    public static final long XO_E_SYSTEM_UPDATE_REQUIRED = 2148916225L;
    public static final long XO_E_CONTENT_UPDATE_REQUIRED = 2148916226L;
    public static final long XO_E_ENFORCEMENT_BAN = 2148916227L;
    public static final long XO_E_THIRD_PARTY_BAN = 2148916228L;
    public static final long XO_E_ACCOUNT_PARENTALLY_RESTRICTED = 2148916229L;
    public static final long XO_E_DEVICE_SUBSCRIPTION_NOT_ACTIVATED = 2148916230L;
    public static final long XO_E_ACCOUNT_BILLING_MAINTENANCE_REQUIRED = 2148916232L;
    public static final long XO_E_ACCOUNT_CREATION_REQUIRED = 2148916233L;
    public static final long XO_E_ACCOUNT_TERMS_OF_USE_NOT_ACCEPTED = 2148916234L;
    public static final long XO_E_ACCOUNT_COUNTRY_NOT_AUTHORIZED = 2148916235L;
    public static final long XO_E_ACCOUNT_AGE_VERIFICATION_REQUIRED = 2148916236L;
    public static final long XO_E_ACCOUNT_CURFEW = 2148916237L;
    public static final long XO_E_ACCOUNT_CHILD_NOT_IN_FAMILY = 2148916238L;
    public static final long XO_E_ACCOUNT_CSV_TRANSITION_REQUIRED = 2148916239L;
    public static final long XO_E_ACCOUNT_MAINTENANCE_REQUIRED = 2148916240L;
    public static final long XO_E_ACCOUNT_TYPE_NOT_ALLOWED = 2148916241L;
    public static final long XO_E_CONTENT_ISOLATION = 2148916242L;
    public static final long XO_E_ACCOUNT_NAME_CHANGE_REQUIRED = 2148916243L;
    public static final long XO_E_DEVICE_CHALLENGE_REQUIRED = 2148916244L;
    public static final long XO_E_SIGNIN_COUNT_BY_DEVICE_TYPE_EXCEEDED = 2148916246L;
    public static final long XO_E_PIN_CHALLENGE_REQUIRED = 2148916247L;
    public static final long XO_E_RETAIL_ACCOUNT_NOT_ALLOWED = 2148916248L;
    public static final long XO_E_SANDBOX_NOT_ALLOWED = 2148916249L;
    public static final long XO_E_ACCOUNT_SERVICE_UNAVAILABLE_UNKNOWN_USER = 2148916250L;
    public static final long XO_E_GREEN_SIGNED_CONTENT_NOT_AUTHORIZED = 2148916251L;
    public static final long XO_E_CONTENT_NOT_AUTHORIZED = 2148916252L;
    public static final long XO_E_EXPIRED_DEVICE_TOKEN = 2148916256L;
    public static final long XO_E_EXPIRED_TITLE_TOKEN = 2148916257L;
    public static final long XO_E_EXPIRED_USER_TOKEN = 2148916258L;
    public static final long XO_E_INVALID_DEVICE_TOKEN = 2148916259L;
    public static final long XO_E_INVALID_TITLE_TOKEN = 2148916260L;
    public static final long XO_E_INVALID_USER_TOKEN = 2148916261L;
    private static final Map<Long, String> ERRORS = new HashMap<Long, String>();
    private static final Map<Long, String> ERROR_MESSAGES = new HashMap<Long, String>();
    private final long errorCode;

    public XblRequestException(HttpResponse httpResponse, long l) {
        super(httpResponse, ERRORS.getOrDefault(l, String.valueOf(l)), ERROR_MESSAGES.getOrDefault(l, "An unknown error occurred"));
        this.errorCode = l;
    }

    @Generated
    public long getErrorCode() {
        return this.errorCode;
    }

    static {
        ERRORS.put(2279407619L, "AM_E_XASD_UNEXPECTED");
        ERRORS.put(2279407620L, "AM_E_XASU_UNEXPECTED");
        ERRORS.put(2279407621L, "AM_E_XAST_UNEXPECTED");
        ERRORS.put(2279407622L, "AM_E_XSTS_UNEXPECTED");
        ERRORS.put(2279407623L, "AM_E_XDEVICE_UNEXPECTED");
        ERRORS.put(2279407624L, "AM_E_DEVMODE_NOT_AUTHORIZED");
        ERRORS.put(2279407625L, "AM_E_NOT_AUTHORIZED");
        ERRORS.put(2279407626L, "AM_E_FORBIDDEN");
        ERRORS.put(2279407627L, "AM_E_UNKNOWN_TARGET");
        ERRORS.put(2279407628L, "AM_E_INVALID_NSAL_DATA");
        ERRORS.put(2279407629L, "AM_E_TITLE_NOT_AUTHENTICATED");
        ERRORS.put(2279407630L, "AM_E_TITLE_NOT_AUTHORIZED");
        ERRORS.put(2279407631L, "AM_E_DEVICE_NOT_AUTHENTICATED");
        ERRORS.put(2279407632L, "AM_E_INVALID_USER_INDEX");
        ERRORS.put(2148916224L, "XO_E_DEVMODE_NOT_AUTHORIZED");
        ERRORS.put(2148916225L, "XO_E_SYSTEM_UPDATE_REQUIRED");
        ERRORS.put(2148916226L, "XO_E_CONTENT_UPDATE_REQUIRED");
        ERRORS.put(2148916227L, "XO_E_ENFORCEMENT_BAN");
        ERRORS.put(2148916228L, "XO_E_THIRD_PARTY_BAN");
        ERRORS.put(2148916229L, "XO_E_ACCOUNT_PARENTALLY_RESTRICTED");
        ERRORS.put(2148916230L, "XO_E_DEVICE_SUBSCRIPTION_NOT_ACTIVATED");
        ERRORS.put(2148916232L, "XO_E_ACCOUNT_BILLING_MAINTENANCE_REQUIRED");
        ERRORS.put(2148916233L, "XO_E_ACCOUNT_CREATION_REQUIRED");
        ERRORS.put(2148916234L, "XO_E_ACCOUNT_TERMS_OF_USE_NOT_ACCEPTED");
        ERRORS.put(2148916235L, "XO_E_ACCOUNT_COUNTRY_NOT_AUTHORIZED");
        ERRORS.put(2148916236L, "XO_E_ACCOUNT_AGE_VERIFICATION_REQUIRED");
        ERRORS.put(2148916237L, "XO_E_ACCOUNT_CURFEW");
        ERRORS.put(2148916238L, "XO_E_ACCOUNT_CHILD_NOT_IN_FAMILY");
        ERRORS.put(2148916239L, "XO_E_ACCOUNT_CSV_TRANSITION_REQUIRED");
        ERRORS.put(2148916240L, "XO_E_ACCOUNT_MAINTENANCE_REQUIRED");
        ERRORS.put(2148916241L, "XO_E_ACCOUNT_TYPE_NOT_ALLOWED");
        ERRORS.put(2148916242L, "XO_E_CONTENT_ISOLATION");
        ERRORS.put(2148916243L, "XO_E_ACCOUNT_NAME_CHANGE_REQUIRED");
        ERRORS.put(2148916244L, "XO_E_DEVICE_CHALLENGE_REQUIRED");
        ERRORS.put(2148916246L, "XO_E_SIGNIN_COUNT_BY_DEVICE_TYPE_EXCEEDED");
        ERRORS.put(2148916247L, "XO_E_PIN_CHALLENGE_REQUIRED");
        ERRORS.put(2148916248L, "XO_E_RETAIL_ACCOUNT_NOT_ALLOWED");
        ERRORS.put(2148916249L, "XO_E_SANDBOX_NOT_ALLOWED");
        ERRORS.put(2148916250L, "XO_E_ACCOUNT_SERVICE_UNAVAILABLE_UNKNOWN_USER");
        ERRORS.put(2148916251L, "XO_E_GREEN_SIGNED_CONTENT_NOT_AUTHORIZED");
        ERRORS.put(2148916252L, "XO_E_CONTENT_NOT_AUTHORIZED");
        ERRORS.put(2148916256L, "XO_E_EXPIRED_DEVICE_TOKEN");
        ERRORS.put(2148916257L, "XO_E_EXPIRED_TITLE_TOKEN");
        ERRORS.put(2148916258L, "XO_E_EXPIRED_USER_TOKEN");
        ERRORS.put(2148916259L, "XO_E_INVALID_DEVICE_TOKEN");
        ERRORS.put(2148916260L, "XO_E_INVALID_TITLE_TOKEN");
        ERRORS.put(2148916261L, "XO_E_INVALID_USER_TOKEN");
        ERROR_MESSAGES.put(2148916227L, "Your account was banned by Xbox for violating one or more Community Standards for Xbox.");
        ERROR_MESSAGES.put(2148916229L, "Your account is currently restricted and your guardian has not given you permission to play online. Login to https://account.microsoft.com/family/ and have your guardian change your permissions.");
        ERROR_MESSAGES.put(2148916233L, "Your account doesn't have an Xbox profile. Please create one at https://www.xbox.com/live");
        ERROR_MESSAGES.put(2148916234L, "Your account has not accepted Xbox's Terms of Service. Please login at https://www.xbox.com/live and accept them.");
        ERROR_MESSAGES.put(2148916235L, "Your account is from a country where Xbox Live is not available/banned.");
        ERROR_MESSAGES.put(2148916236L, "Your account requires proof of age. Please login to https://login.live.com/login.srf and provide proof of age.");
        ERROR_MESSAGES.put(2148916237L, "Your account has reached the its limit for playtime. Your account has been blocked from logging in.");
        ERROR_MESSAGES.put(2148916238L, "Your account is a child (under 18) and cannot proceed unless the account is added to a Family by an adult.");
    }
}

