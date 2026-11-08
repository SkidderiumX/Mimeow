/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.net.URI;
import java.util.Map;
import keystrokesmod.script.Manager;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import x.oc7ab2161b9f;

public class WebSocket {
    private final WebSocketClient client;

    public WebSocket(String string) {
        this.client = this.createWebSocketClient(string);
    }

    public WebSocket(String string, Map<String, String> map) {
        this.client = this.createWebSocketClient(string, map);
    }

    private WebSocketClient createWebSocketClient(String string) {
        return new WebSocketClient(WebSocket.toURI(string)){

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                WebSocket.this.onOpen(serverHandshake.getHttpStatus(), serverHandshake.getHttpStatusMessage());
            }

            @Override
            public void onMessage(String string) {
                WebSocket.this.onMessage(string);
            }

            @Override
            public void onClose(int n, String string, boolean bl) {
                WebSocket.this.onClose(n, string, bl);
            }

            @Override
            public void onError(Exception exception) {
                WebSocket.this.onError(exception);
            }
        };
    }

    private WebSocketClient createWebSocketClient(String string, Map<String, String> map) {
        return new WebSocketClient(WebSocket.toURI(string), map){

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                WebSocket.this.onOpen(serverHandshake.getHttpStatus(), serverHandshake.getHttpStatusMessage());
            }

            @Override
            public void onMessage(String string) {
                WebSocket.this.onMessage(string);
            }

            @Override
            public void onClose(int n, String string, boolean bl) {
                WebSocket.this.onClose(n, string, bl);
            }

            @Override
            public void onError(Exception exception) {
                WebSocket.this.onError(exception);
            }
        };
    }

    private static URI toURI(String string) {
        try {
            return new URI(string);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void onOpen(short s, String string) {
    }

    public void onMessage(String string) {
    }

    public void onClose(int n, String string, boolean bl) {
    }

    public void onError(Exception exception) {
    }

    public boolean connect(boolean bl) {
        if (!Manager.enableWebSockets.\u01ed()) {
            oc7ab2161b9f.\u00fd("&cFailed to connect to websockets, websockets are not enabled.");
            return false;
        }
        if (bl) {
            try {
                return this.client.connectBlocking();
            }
            catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
        }
        this.client.connect();
        return true;
    }

    public void send(String string) {
        this.client.send(string);
    }

    public void close(boolean bl) {
        if (bl) {
            try {
                this.client.closeBlocking();
            }
            catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
        } else {
            this.client.close();
        }
    }

    public boolean isOpen() {
        return this.client == null ? false : this.client.isOpen();
    }
}

