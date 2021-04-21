package com.belstu.thesisproject.vcs;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
//import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/** Signaling server to WebRTC video conferencing */
@Component
public class SocketHandler extends TextWebSocketHandler {

  List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message)
          throws InterruptedException, IOException {
    for (WebSocketSession webSocketSession : sessions) {
      if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
        webSocketSession.sendMessage(message);
      }
    }
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.add(session);
  }
//  private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
//  @OnOpen
//  public void whenOpening(Session session) throws IOException, EncodeException {
//    System.out.println("Open!");
//    // Add websocket session to a global set to use in OnMessage.
//    sessions.add(session);
//  }
//
//  @OnMessage
//  public void process(String data, Session session) throws IOException {
//    System.out.println("Got signal - " + data);
//    /*
//     * When signal is received, send it to other participants other than self. In
//     * real world, signal should be sent to only participant's who belong to
//     * particular video conference.
//     */
//    for (Session sess : sessions) {
//      if (!sess.equals(session)) {
//        sess.getBasicRemote().sendText(data);
//      }
//    }
//  }
//
//  @OnClose
//  public void whenClosing(Session session) {
//    System.out.println("Close!");
//    sessions.remove(session);
//  }
}
