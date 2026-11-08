/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;

public class StatusCodes {
    public static final int CONTINUE = 100;
    public static final int SWITCHING_PROTOCOLS = 101;
    public static final int PROCESSING = 102;
    public static final int EARLY_HINTS = 103;
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NON_AUTHORITATIVE_INFORMATION = 203;
    public static final int NO_CONTENT = 204;
    public static final int RESET_CONTENT = 205;
    public static final int PARTIAL_CONTENT = 206;
    public static final int MULTI_STATUS = 207;
    public static final int ALREADY_REPORTED = 208;
    public static final int IM_USED = 226;
    public static final int MULTIPLE_CHOICES = 300;
    public static final int MOVED_PERMANENTLY = 301;
    public static final int MOVED_TEMPORARILY = 302;
    public static final int SEE_OTHER = 303;
    public static final int NOT_MODIFIED = 304;
    public static final int USE_PROXY = 305;
    public static final int UNUSED = 306;
    public static final int TEMPORARY_REDIRECT = 307;
    public static final int PERMANENT_REDIRECT = 308;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int PAYMENT_REQUIRED = 402;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int NOT_ACCEPTABLE = 406;
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int CONFLICT = 409;
    public static final int GONE = 410;
    public static final int LENGTH_REQUIRED = 411;
    public static final int PRECONDITION_FAILED = 412;
    public static final int PAYLOAD_TOO_LARGE = 413;
    public static final int URI_TOO_LONG = 414;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final int EXPECTATION_FAILED = 417;
    public static final int IM_A_TEAPOT = 418;
    public static final int MISDIRECTED_REQUEST = 421;
    public static final int UNPROCESSABLE_CONTENT = 422;
    public static final int LOCKED = 423;
    public static final int FAILED_DEPENDENCY = 424;
    public static final int TOO_EARLY = 425;
    public static final int UPGRADE_REQUIRED = 426;
    public static final int PRECONDITION_REQUIRED = 428;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
    public static final int UNAVAILABLE_FOR_LEGAL_REASONS = 451;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;
    public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final int VARIANT_ALSO_NEGOTIATES = 506;
    public static final int INSUFFICIENT_STORAGE = 507;
    public static final int LOOP_DETECTED = 508;
    public static final int NOT_EXTENDED = 510;
    public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;
    public static final Map<Integer, String> STATUS_CODES;

    @Generated
    private StatusCodes() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(100, "Continue");
        hashMap.put(101, "Switching Protocols");
        hashMap.put(102, "Processing");
        hashMap.put(103, "Early Hints");
        hashMap.put(200, "OK");
        hashMap.put(201, "Created");
        hashMap.put(202, "Accepted");
        hashMap.put(203, "Non-Authoritative Information");
        hashMap.put(204, "No Content");
        hashMap.put(205, "Reset Content");
        hashMap.put(206, "Partial Content");
        hashMap.put(207, "Multi-Status");
        hashMap.put(208, "Already Reported");
        hashMap.put(226, "IM Used");
        hashMap.put(300, "Multiple Choices");
        hashMap.put(301, "Moved Permanently");
        hashMap.put(302, "Moved Temporarily");
        hashMap.put(303, "See Other");
        hashMap.put(304, "Not Modified");
        hashMap.put(305, "Use Proxy");
        hashMap.put(306, "Unused");
        hashMap.put(307, "Temporary Redirect");
        hashMap.put(308, "Permanent Redirect");
        hashMap.put(400, "Bad Request");
        hashMap.put(401, "Unauthorized");
        hashMap.put(402, "Payment Required");
        hashMap.put(403, "Forbidden");
        hashMap.put(404, "Not Found");
        hashMap.put(405, "Method Not Allowed");
        hashMap.put(406, "Not Acceptable");
        hashMap.put(407, "Proxy Authentication Required");
        hashMap.put(408, "Request Timeout");
        hashMap.put(409, "Conflict");
        hashMap.put(410, "Gone");
        hashMap.put(411, "Length Required");
        hashMap.put(412, "Precondition Failed");
        hashMap.put(413, "Payload Too Large");
        hashMap.put(414, "URI Too Long");
        hashMap.put(415, "Unsupported Media Type");
        hashMap.put(416, "Range Not Satisfiable");
        hashMap.put(417, "Expectation Failed");
        hashMap.put(418, "I'm a teapot");
        hashMap.put(421, "Misdirected Request");
        hashMap.put(422, "Unprocessable Content");
        hashMap.put(423, "Locked");
        hashMap.put(424, "Failed Dependency");
        hashMap.put(425, "Too Early");
        hashMap.put(426, "Upgrade Required");
        hashMap.put(428, "Precondition Required");
        hashMap.put(429, "Too Many Requests");
        hashMap.put(431, "Request Header Fields Too Large");
        hashMap.put(451, "Unavailable For Legal Reasons");
        hashMap.put(500, "Internal Server Error");
        hashMap.put(501, "Not Implemented");
        hashMap.put(502, "Bad Gateway");
        hashMap.put(503, "Service Unavailable");
        hashMap.put(504, "Gateway Timeout");
        hashMap.put(505, "HTTP Version Not Supported");
        hashMap.put(506, "Variant Also Negotiates");
        hashMap.put(507, "Insufficient Storage");
        hashMap.put(508, "Loop Detected");
        hashMap.put(510, "Not Extended");
        hashMap.put(511, "Network Authentication Required");
        STATUS_CODES = Collections.unmodifiableMap(hashMap);
    }
}

