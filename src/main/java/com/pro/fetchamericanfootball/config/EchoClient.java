package com.pro.fetchamericanfootball.config;

import com.neovisionaries.ws.client.*;

public class EchoClient {
    private static final String SERVER = "ws://echo.websocket.org";

    /**
     * The timeout value in milliseconds for socket connection.
     */
    private static final int TIMEOUT = 5000;

    private static WebSocket connect() throws Exception
    {
        return new WebSocketFactory()
                .createSocket(SERVER)
                .addListener(new WebSocketAdapter() {
                    // A text message arrived from the server.
                    public void onTextMessage(WebSocket websocket, String message) {
                        System.out.println(message);
                    }
                })
                .addExtension(new WebSocketExtension("permessage-deflate"))
                .connect();
    }
}
