/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.Generated;
import net.lenni0451.commons.httpclient.utils.URLCoder;
import org.jetbrains.annotations.ApiStatus;

public class URLWrapper {
    private String protocol;
    private String host;
    private int port = -1;
    private String path;
    private String query;
    private String userInfo;
    private String fragment;

    public static URLWrapper empty() {
        return new URLWrapper();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public static URLWrapper of(String string) throws MalformedURLException {
        return URLWrapper.ofURL(string);
    }

    public static URLWrapper ofURL(String string) throws MalformedURLException {
        return new URLWrapper(new URL(string));
    }

    public static URLWrapper ofURI(String string) throws IllegalArgumentException {
        return new URLWrapper(URI.create(string));
    }

    public static URLWrapper of(URL uRL) {
        return new URLWrapper(uRL);
    }

    public static URLWrapper of(URI uRI) {
        return new URLWrapper(uRI);
    }

    public URLWrapper() {
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public URLWrapper(String string) throws MalformedURLException {
        this(new URL(string));
    }

    public URLWrapper(URL uRL) {
        this.protocol = uRL.getProtocol();
        this.host = this.emptyToNull(uRL.getHost());
        this.port = uRL.getPort();
        this.path = this.emptyToNull(uRL.getPath());
        this.query = this.emptyToNull(uRL.getQuery());
        this.userInfo = this.emptyToNull(uRL.getUserInfo());
        this.fragment = this.emptyToNull(uRL.getRef());
    }

    public URLWrapper(URI uRI) {
        this.protocol = this.emptyToNull(uRI.getScheme());
        this.host = this.emptyToNull(uRI.getHost());
        this.port = uRI.getPort();
        this.path = this.emptyToNull(uRI.getPath());
        this.query = this.emptyToNull(uRI.getQuery());
        this.userInfo = this.emptyToNull(uRI.getUserInfo());
        this.fragment = this.emptyToNull(uRI.getFragment());
    }

    public boolean hasProtocol() {
        return this.protocol != null;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getProtocolOr(String string) {
        return this.protocol == null ? string : this.protocol;
    }

    public URLWrapper setProtocol(String string) {
        this.protocol = this.emptyToNull(string);
        return this;
    }

    public boolean hasHost() {
        return this.host != null;
    }

    public String getHost() {
        return this.host;
    }

    public String getHostOr(String string) {
        return this.host == null ? string : this.host;
    }

    public URLWrapper setHost(String string) {
        this.host = this.emptyToNull(string);
        return this;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int getPort() {
        return this.port;
    }

    public int getPortOr(int n) {
        return this.port < 0 ? n : this.port;
    }

    public URLWrapper setPort(int n) {
        if (n > 65535) {
            throw new IllegalArgumentException("Port must not be greater than 65535");
        }
        this.port = n;
        return this;
    }

    public boolean hasPath() {
        return this.path != null;
    }

    public String getPath() {
        return this.path;
    }

    public String getPathOr(String string) {
        return this.path == null ? string : this.path;
    }

    public URLWrapper setPath(String string) {
        this.path = this.emptyToNull(string);
        return this;
    }

    public boolean hasQuery() {
        return this.query != null;
    }

    public String getQuery() {
        return this.query;
    }

    public String getQueryOr(String string) {
        return this.query;
    }

    public URLWrapper setQuery(String string) {
        this.query = this.emptyToNull(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public QueryWrapper wrapQuery() {
        return new QueryWrapper();
    }

    public QueryParametersWrapper wrapQueryParameters() {
        return new QueryParametersWrapper();
    }

    public boolean hasUserInfo() {
        return this.userInfo != null;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getUserInfoOr(String string) {
        return this.userInfo == null ? string : this.userInfo;
    }

    public URLWrapper setUserInfo(String string) {
        this.userInfo = this.emptyToNull(string);
        return this;
    }

    public boolean hasFragment() {
        return this.fragment != null;
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getFragmentOr(String string) {
        return this.fragment == null ? string : this.fragment;
    }

    public URLWrapper setFragment(String string) {
        this.fragment = this.emptyToNull(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public String getReference() {
        return this.getFragment();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public URLWrapper setReference(String string) {
        return this.setFragment(string);
    }

    public URL toURL() throws MalformedURLException {
        return new URL(this.toString());
    }

    public URI toURI() {
        return URI.create(this.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.protocol != null) {
            stringBuilder.append(this.protocol).append("://");
        }
        if (this.userInfo != null) {
            stringBuilder.append(this.userInfo).append("@");
        }
        if (this.host != null) {
            stringBuilder.append(this.host);
        }
        if (this.port >= 0) {
            stringBuilder.append(":").append(this.port);
        }
        if (this.path != null) {
            if (!this.path.startsWith("/")) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.path);
        }
        if (this.query != null) {
            stringBuilder.append("?").append(this.query);
        }
        if (this.fragment != null) {
            stringBuilder.append("#").append(this.fragment);
        }
        return stringBuilder.toString();
    }

    private String emptyToNull(String string) {
        return string == null || string.isEmpty() ? null : string;
    }

    public static class Parameter {
        private String key;
        @Nullable
        private String value;

        public Parameter(String string) {
            this.key = string;
        }

        public Parameter(String string, @Nullable String string2) {
            this.key = string;
            this.value = string2;
        }

        @Generated
        public String getKey() {
            return this.key;
        }

        @Nullable
        @Generated
        public String getValue() {
            return this.value;
        }

        @Generated
        public void setKey(String string) {
            this.key = string;
        }

        @Generated
        public void setValue(@Nullable String string) {
            this.value = string;
        }
    }

    public class QueryParametersWrapper {
        private final List<Parameter> parameters = new ArrayList<Parameter>();

        public QueryParametersWrapper() {
            String string = URLWrapper.this.getQuery();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.parameters.add(new Parameter(URLCoder.decode(stringArray[0]), URLCoder.decode(stringArray[1])));
                        continue;
                    }
                    this.parameters.add(new Parameter(URLCoder.decode(stringArray[0])));
                }
            }
        }

        public List<String> getValues(String string) {
            return this.parameters.stream().filter(parameter -> parameter.getKey().equals(string)).map(Parameter::getValue).filter(Objects::nonNull).collect(Collectors.toList());
        }

        public Optional<String> getFirstValue(String string) {
            return this.parameters.stream().filter(parameter -> parameter.getKey().equals(string)).map(Parameter::getValue).filter(Objects::nonNull).findFirst();
        }

        public boolean hasParameter(String string) {
            return this.parameters.stream().anyMatch(parameter -> parameter.getKey().equals(string));
        }

        public QueryParametersWrapper addParameter(String string, @Nullable String string2) {
            this.parameters.add(new Parameter(string, string2));
            return this;
        }

        public QueryParametersWrapper addParameter(Parameter parameter) {
            this.parameters.add(parameter);
            return this;
        }

        public QueryParametersWrapper addParameters(Iterable<Parameter> iterable) {
            iterable.forEach(this.parameters::add);
            return this;
        }

        public QueryParametersWrapper addParameters(Parameter[] parameterArray) {
            Collections.addAll(this.parameters, parameterArray);
            return this;
        }

        public QueryParametersWrapper addParameters(Map<String, String> map) {
            map.forEach((string, string2) -> this.parameters.add(new Parameter((String)string, (String)string2)));
            return this;
        }

        public QueryParametersWrapper setParameter(String string, @Nullable String string2) {
            this.parameters.removeIf(parameter -> parameter.getKey().equals(string));
            this.parameters.add(new Parameter(string, string2));
            return this;
        }

        public QueryParametersWrapper setParameters(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.setParameter(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public QueryParametersWrapper removeParameters(String string) {
            this.parameters.removeIf(parameter -> parameter.getKey().equals(string));
            return this;
        }

        public QueryParametersWrapper clearParameters() {
            this.parameters.clear();
            return this;
        }

        public URLWrapper apply() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Parameter parameter : this.parameters) {
                stringBuilder.append(URLCoder.encode(parameter.getKey()));
                if (parameter.getValue() != null) {
                    stringBuilder.append("=").append(URLCoder.encode(parameter.getValue()));
                }
                stringBuilder.append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            URLWrapper.this.setQuery(stringBuilder.toString());
            return URLWrapper.this;
        }

        @Generated
        public List<Parameter> getParameters() {
            return this.parameters;
        }
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public class QueryWrapper {
        private final Map<String, String> queries = new HashMap<String, String>();

        private QueryWrapper() {
            String string = URLWrapper.this.getQuery();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.queries.put(URLCoder.decode(stringArray[0]), URLCoder.decode(stringArray[1]));
                        continue;
                    }
                    this.queries.put(URLCoder.decode(stringArray[0]), "");
                }
            }
        }

        public Map<String, String> getQueries() {
            return Collections.unmodifiableMap(this.queries);
        }

        public Optional<String> getQuery(String string) {
            return Optional.ofNullable(this.queries.get(string));
        }

        public QueryWrapper setQuery(String string, String string2) {
            this.queries.put(string, string2);
            return this;
        }

        public QueryWrapper addQueries(Map<String, String> map) {
            this.queries.putAll(map);
            return this;
        }

        public QueryWrapper removeQuery(String string) {
            this.queries.remove(string);
            return this;
        }

        public boolean hasQuery(String string) {
            return this.queries.containsKey(string);
        }

        public URLWrapper apply() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : this.queries.entrySet()) {
                stringBuilder.append(URLCoder.encode(entry.getKey())).append("=").append(URLCoder.encode(entry.getValue())).append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            URLWrapper.this.setQuery(stringBuilder.toString());
            return URLWrapper.this;
        }

        public URLWrapper discard() {
            return URLWrapper.this;
        }
    }
}

