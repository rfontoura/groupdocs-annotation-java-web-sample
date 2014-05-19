package com.groupdocs.annotation.samples.javaweb;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imy
 */
public class SignalrServlet extends AnnotationServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodUrl = request.getRequestURI()
                .substring((request.getContextPath() + request.getServletPath()).length());
        if (methodUrl.startsWith("/hubs")) {
            methodUrl = methodUrl.substring("/hubs".length());
            if (methodUrl.startsWith("/connect")) {
                doConnect(request, response);
            } else if (methodUrl.startsWith("/reconnect")) {
                doConnect(request, response);
            } else if (methodUrl.startsWith("/ping")) {
            } else {
                response.setContentType("application/javascript; charset=UTF-8");
                response.getOutputStream().write("(function(e,t){\"use strict\";function r(t,n){return function(){n.apply(t,e.makeArray(arguments))}}function i(t,n){var i,s,o,u,a;for(i in t){if(t.hasOwnProperty(i)){s=t[i];if(!s.hubName){continue}if(n){a=s.on}else{a=s.off}for(o in s.client){if(s.client.hasOwnProperty(o)){u=s.client[o];if(!e.isFunction(u)){continue}a.call(s,o,r(s,u))}}}}}if(typeof e.signalR!==\"function\"){throw new Error(\"SignalR: SignalR is not loaded. Please ensure jquery.signalR-x.js is referenced before ~/signalr/hubs.\")}var n=e.signalR;e.hubConnection.prototype.createHubProxies=function(){var t={};this.starting(function(){i(t,true);this._registerSubscribedHubs()}).disconnected(function(){i(t,false)});t.annotationHub=this.createHubProxy(\"annotationHub\");t.annotationHub.client={};t.annotationHub.server={broadcastDocumentScale:function(n,r,i,s){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastDocumentScale\"],e.makeArray(arguments)))},broadcastDocumentScroll:function(n,r,i,s,o,u){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastDocumentScroll\"],e.makeArray(arguments)))},broadcastMouseCursorPosition:function(n,r,i,s,o,u,a){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastMouseCursorPosition\"],e.makeArray(arguments)))},broadcastSlaveConnected:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"BroadcastSlaveConnected\"],e.makeArray(arguments)))},getClient:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetClient\"],e.makeArray(arguments)))},getConnectionIdsToCall:function(n,r){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetConnectionIdsToCall\"],e.makeArray(arguments)))},getConnectionUser:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"GetConnectionUser\"],e.makeArray(arguments)))},setDocumentGuidForConnection:function(n){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"SetDocumentGuidForConnection\"],e.makeArray(arguments)))},setUserGuidForConnection:function(n,r){return t.annotationHub.invoke.apply(t.annotationHub,e.merge([\"SetUserGuidForConnection\"],e.makeArray(arguments)))}};return t};n.hub=e.hubConnection(\"/signalr1_1_2\",{useDefaultPath:false});e.extend(n,n.hub.createHubProxies())})(window.jQuery,window)".getBytes());
                response.getOutputStream().close();
            }
        } else if (methodUrl.startsWith("/negotiate")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getOutputStream().write("{\"Url\":\"/signalr1_1_2/hubs\",\"ConnectionToken\":\"kZjUv3VPwqPPpQN3aUMennONGXyq49GNDDsEgslCqwkaZ4a7sto3Fr4A8-IJ474bjnPZwKrM2S3XvuGA-j2LDQla3gfX5wYUYyZ2uNjsa_aXO4SP2gdkXs0yEDLMHH9eUUo4Ii81xuCQWqqYjFTJNoTdmkvwiF_HcDK2LlRDVJsfjsf0H2gXpodU88r7ENl80\",\"ConnectionId\":\"dbc14300-0a4b-46ce-be3d-0e9cd06a8af3\",\"KeepAliveTimeout\":200.0,\"DisconnectTimeout\":300.0,\"TryWebSockets\":false,\"WebSocketServerUrl\":null,\"ProtocolVersion\":\"1.2\"}".getBytes());
            response.getOutputStream().close();
        } else if (methodUrl.startsWith("/send")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getOutputStream().write("{\"I\":\"0\"}".getBytes());
            response.getOutputStream().close();
        } else if (methodUrl.startsWith("/abort")) {
            response.getOutputStream().close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void doConnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        boolean initialized = false;
        InputStream inputStream = request.getInputStream();
        OutputStream outputStream = response.getOutputStream();
        while (true) {
            if (!initialized) {
                outputStream.write("data: initialized\n\n".getBytes());
                outputStream.flush();
                initialized = true;
            }
            if (inputStream.available() > 0) {
                String inputData = new DataInputStream(inputStream).readUTF();
                System.out.println(inputData);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
