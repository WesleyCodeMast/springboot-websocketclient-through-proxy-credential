package com.pro.fetchamericanfootball.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neovisionaries.ws.client.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CustomWebSocketService {
    private String uri = "wss://api.hardrocksportsbook.com/graphql-ws";
    private String proxyHost = "shp-bomenterprise2-us-v00075.tp-ns.com";
    private int proxyPort = 80;
    private String proxyUsername = "bomenterprise2";
    private String proxyPassword = "j2novj15tyupak";

    public void connectTest() throws IOException, WebSocketException {

        WebSocketFactory factory = new WebSocketFactory();
        ProxySettings settings = factory.getProxySettings();
        settings.setServer(proxyHost + ":" + proxyPort);
        settings.setCredentials(proxyUsername, proxyPassword);
        WebSocket ws = factory.createSocket(uri);

        ws.connect();
        System.out.println(" ***************************** this is websocket connected ***************************** " + "/n");

        JSONObject requestObject = new JSONObject();
        JSONObject sportsbookLoginRequest = new JSONObject();
        sportsbookLoginRequest.put("application", "sportsbook");
        sportsbookLoginRequest.put("channel", "NEW_JERSEY_ONLINE");
        sportsbookLoginRequest.put("locale", "enus-us-x-nj");
        requestObject.put("SportsbookLoginRequest", sportsbookLoginRequest);
        String jsonString = requestObject.toString();
        ws.sendText(jsonString);

        JSONObject request0 = new JSONObject();
        JSONObject subscriptionRequest = new JSONObject();
        JSONObject subscribe = new JSONObject();
        subscriptionRequest.put("subscribe", subscribe);

        JSONArray marketTypes = new JSONArray();
        marketTypes.put("AMERICAN_FOOTBALL:FTOT:ML");
        marketTypes.put("AMERICAN_FOOTBALL:FTOT:OU");
        marketTypes.put("AMERICAN_FOOTBALL:FTOT:SPRD");
        subscribe.put("marketTypes", marketTypes);
        request0.put("SubscriptionRequest", subscriptionRequest);

        ws.addListener(new WebSocketAdapter() {

            @Override
            public void onTextMessage(WebSocket websocket, String text) throws JsonProcessingException {

                System.out.println(" ***************************** this is websocket message ***************************** " + "/n");
                System.out.println(text);
                JSONObject requestObject = new JSONObject();
                JSONObject keepAlive = new JSONObject();
                keepAlive.put("reqId", 1);

                requestObject.put("KeepAlive", keepAlive);
                String jsonString = requestObject.toString();


                if(text != null && text.equals("{\"Response\":{\"status\":\"ok\",\"reqId\":\"0\"}}")) {

                    if (websocket.getState() == WebSocketState.OPEN ){

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        String[] customIds = {
                            "2385989811720421422",
                            "1728536284135948354",
                            "7282620507966144574",
                            "6950161225427451975",
                            "1643376497224581164",
                            "6400821026934751303",
                            "6882543631141175353",
                            "6491212461969768498",
                            "6728401297156603924",
                            "1457626914793193516",
                            "175191057721196590",
                            "6048827497587146814",
                            "8915778365928767548",
                            "3080386642940002312",
                            "2246446759373701176",
                            "2918215652869931028",
                            "438643882164224056",
                            "1076378245069013050",
                            "4427923607629070404",
                            "6664673581031227454",
                            "1137170517846655020",
                            "2712781125810126906",
                            "8917819116049137714",
                            "2610559036559196221",
                            "7223792469627633712",
                            "5528259284708360201",
                            "4072777860753653805",
                            "6032678820690788415",
                            "7301322646569615432",
                            "738149118967021613",
                            "5378488655797813315",
                            "8594558723933601855",
                            "3230536423275495494",
                            "1353439014011273266",
                            "3213331732770848813",
                            "870858094950481982",
                            "1910140236693504020",
                            "5264697105062821940",
                            "8633599461258166330",
                            "8059798427582332948",
                            "9186517195709743154",
                            "6298687013873516595",
                            "7490428840868315204",
                            "4388202157347438611",
                            "3376818722999894066",
                            "7029566225018257471",
                            "1244302005234303033",
                            "3691568782004453431",
                            "7950991306653433877",
                            "5468468667023622208",
                            "3203087750941900864",
                            "1499025257444147268",
                            "8910266136181604407",
                            "4832853158655688756",
                            "5262411689244753981",
                            "7721500861746905133",
                            "6942185081021399098",
                            "5448650313832333367",
                            "6813437619126140995"
                        };

                        JSONArray ids = new JSONArray(customIds);
                        subscribe.put("ids", ids);

                        WebSocketFrame f1 = WebSocketFrame.createTextFrame(request0.toString());
                        websocket.sendFrame(f1);
                    }
                }

                websocket.sendText(jsonString);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onConnected(WebSocket websocket, Map<String, List<String>> headers) {
                System.out.println(" ***************************** this is websocket connected ***************************** " + "/n");
            }

            @Override
            public void onError(WebSocket websocket, WebSocketException cause) {
                cause.printStackTrace();
                System.out.println(" *********" +
                        "******************** this is websocket error ***************************** " + "/n");
                System.out.println(cause.toString() + "/n");

            }

            @Override
            public void onStateChanged(WebSocket websocket, WebSocketState newState) {
                System.out.println(newState.toString() + "/n");
                System.out.println(" ***************************** this is websocket statechanged ***************************** " + "/n");
            }

            @Override
            public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) {
                System.out.println(" ***************************** this is websocket disconnected ***************************** " + "/n");
                try {
                    websocket.connect();
                } catch (WebSocketException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket frame ***************************** " + "/n");
            }

            @Override
            public void onContinuationFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket continuationframe ***************************** " + "/n");
            }

            @Override
            public void onTextFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket textframe ***************************** " + "/n");
                System.out.println(frame.toString());
            }

            @Override
            public void onBinaryFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket binary frame ***************************** " + "/n");
            }

            @Override
            public void onCloseFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(frame.getCloseReason());
                System.out.println(" ***************************** this is websocket closeframe ***************************** " + "/n");
            }

            @Override
            public void onPingFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket pingframe ***************************** " + "/n");
            }

            @Override
            public void onPongFrame(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket pongframe ***************************** " + "/n");
            }

            @Override
            public void onBinaryMessage(WebSocket websocket, byte[] binary) {
                System.out.println(" ***************************** this is websocket binarymessage ***************************** " + "/n");
                System.out.println(binary.toString() + "/n");
            }

            @Override
            public void onFrameSent(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket framesent ***************************** " + "/n");
                System.out.println(frame.toString() + "/n");
            }

            @Override
            public void onFrameUnsent(WebSocket websocket, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket frameunsent ***************************** " + "/n");
            }

            @Override
            public void onFrameError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket frameerror ***************************** " + "/n");
            }

            @Override
            public void onMessageError(WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) {
                System.out.println(" ***************************** this is websocket messageerror ***************************** " + "/n");
            }

            @Override
            public void onTextMessageError(WebSocket websocket, WebSocketException cause, byte[] data) {
                System.out.println(" ***************************** this is websocket textmessageerror ***************************** " + "/n");
                System.out.println(data.toString());
                cause.printStackTrace();
            }

            @Override
            public void onSendError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) {
                System.out.println(" ***************************** this is websocket sendError ***************************** " + "/n");
                cause.printStackTrace();
            }

            @Override
            public void onUnexpectedError(WebSocket websocket, WebSocketException cause) {
                System.out.println(" ***************************** this is websocket Unexpected error ***************************** " + "/n");
                cause.printStackTrace();
            }
        });
    }
}