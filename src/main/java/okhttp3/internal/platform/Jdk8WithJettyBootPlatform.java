/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"})
public class Jdk8WithJettyBootPlatform
extends Platform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Method putMethod;
    @NotNull
    private final Method getMethod;
    @NotNull
    private final Method removeMethod;
    @NotNull
    private final Class<?> clientProviderClass;
    @NotNull
    private final Class<?> serverProviderClass;

    public Jdk8WithJettyBootPlatform(@NotNull Method method, @NotNull Method method2, @NotNull Method method3, @NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        Intrinsics.checkNotNullParameter(method, "putMethod");
        Intrinsics.checkNotNullParameter(method2, "getMethod");
        Intrinsics.checkNotNullParameter(method3, "removeMethod");
        Intrinsics.checkNotNullParameter(clazz, "clientProviderClass");
        Intrinsics.checkNotNullParameter(clazz2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = clazz;
        this.serverProviderClass = clazz2;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket, @Nullable String string, @NotNull List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        List<String> list2 = Platform.Companion.alpnProtocolNames(list);
        try {
            Object[] objectArray = new Class[]{this.clientProviderClass, this.serverProviderClass};
            Object object = Proxy.newProxyInstance(Platform.class.getClassLoader(), objectArray, (InvocationHandler)new AlpnProvider(list2));
            objectArray = new Object[]{sSLSocket, object};
            this.putMethod.invoke(null, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to set ALPN", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to set ALPN", illegalAccessException);
        }
    }

    @Override
    public void afterHandshake(@NotNull SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        try {
            Object[] objectArray = new Object[]{sSLSocket};
            this.removeMethod.invoke(null, objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to remove ALPN", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to remove ALPN", invocationTargetException);
        }
    }

    @Override
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        try {
            Object[] objectArray = new Object[]{sSLSocket};
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, objectArray));
            Intrinsics.checkNotNull(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            AlpnProvider alpnProvider = (AlpnProvider)invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            return alpnProvider.getUnsupported() ? null : alpnProvider.getSelected();
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to get ALPN selected protocol", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to get ALPN selected protocol", illegalAccessException);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002\u00a2\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"})
    private static final class AlpnProvider
    implements InvocationHandler {
        @NotNull
        private final List<String> protocols;
        private boolean unsupported;
        @Nullable
        private String selected;

        public AlpnProvider(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            this.protocols = list;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public final void setUnsupported(boolean bl) {
            this.unsupported = bl;
        }

        @Nullable
        public final String getSelected() {
            return this.selected;
        }

        public final void setSelected(@Nullable String string) {
            this.selected = string;
        }

        @Override
        @Nullable
        public Object invoke(@NotNull Object object, @NotNull Method method, @Nullable Object[] objectArray) throws Throwable {
            Intrinsics.checkNotNullParameter(object, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            Object[] objectArray2 = objectArray;
            if (objectArray == null) {
                objectArray2 = new Object[]{};
            }
            Object[] objectArray3 = objectArray2;
            String string = method.getName();
            Class<?> clazz = method.getReturnType();
            if (Intrinsics.areEqual(string, "supports") && Intrinsics.areEqual(Boolean.TYPE, clazz)) {
                return true;
            }
            if (Intrinsics.areEqual(string, "unsupported") && Intrinsics.areEqual(Void.TYPE, clazz)) {
                this.unsupported = true;
                return null;
            }
            if (Intrinsics.areEqual(string, "protocols") && objectArray3.length == 0) {
                return this.protocols;
            }
            if ((Intrinsics.areEqual(string, "selectProtocol") || Intrinsics.areEqual(string, "select")) && Intrinsics.areEqual(String.class, clazz) && objectArray3.length == 1 && objectArray3[0] instanceof List) {
                Object object2 = objectArray3[0];
                Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List)object2;
                int n = 0;
                int n2 = list.size();
                if (n <= n2) {
                    while (true) {
                        Object e = list.get(n);
                        Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.String");
                        String string2 = (String)e;
                        if (this.protocols.contains(string2)) {
                            this.selected = string2;
                            return this.selected;
                        }
                        if (n == n2) break;
                        ++n;
                    }
                }
                this.selected = this.protocols.get(0);
                return this.selected;
            }
            if ((Intrinsics.areEqual(string, "protocolSelected") || Intrinsics.areEqual(string, "selected")) && objectArray3.length == 1) {
                Object object3 = objectArray3[0];
                Intrinsics.checkNotNull(object3, "null cannot be cast to non-null type kotlin.String");
                this.selected = (String)object3;
                return null;
            }
            return method.invoke(this, Arrays.copyOf(objectArray3, objectArray3.length));
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            String string = System.getProperty("java.specification.version", "unknown");
            try {
                Intrinsics.checkNotNullExpressionValue(string, "jvmVersion");
                int n = Integer.parseInt(string);
                if (n >= 9) {
                    return null;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            try {
                String string2 = "org.eclipse.jetty.alpn.ALPN";
                Class<?> clazz = Class.forName(string2, true, null);
                Class<?> clazz2 = Class.forName(string2 + "$Provider", true, null);
                Class<?> clazz3 = Class.forName(string2 + "$ClientProvider", true, null);
                Class<?> clazz4 = Class.forName(string2 + "$ServerProvider", true, null);
                Object object = new Class[]{SSLSocket.class, clazz2};
                Method method = clazz.getMethod("put", (Class<?>)object);
                Object object2 = new Class[]{SSLSocket.class};
                object = clazz.getMethod("get", (Class<?>)object2);
                Class[] classArray = new Class[]{SSLSocket.class};
                object2 = clazz.getMethod("remove", classArray);
                Intrinsics.checkNotNullExpressionValue(method, "putMethod");
                Intrinsics.checkNotNullExpressionValue(object, "getMethod");
                Intrinsics.checkNotNullExpressionValue(object2, "removeMethod");
                Intrinsics.checkNotNullExpressionValue(clazz3, "clientProviderClass");
                Intrinsics.checkNotNullExpressionValue(clazz4, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method, (Method)object, (Method)object2, clazz3, clazz4);
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

