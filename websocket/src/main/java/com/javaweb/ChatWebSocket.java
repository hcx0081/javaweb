package com.javaweb;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.javaweb.entity.Message;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

/**
 * {@code @Description:}
 */
@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfigurator.class)
public class ChatWebSocket {
    private static Map<HttpSession, ChatWebSocket> onlineUsers = new HashMap<>();
    private Session session;
    private HttpSession httpSession;
    
    @OnOpen
    public void open(Session session, EndpointConfig endpointConfig) throws IOException {
        System.out.println("建立连接");
        // 记录会话信息
        this.session = session;
        // 获取当前登录用户的HttpSession信息
        HttpSession httpSession = (HttpSession) endpointConfig.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        
        // 记录当前登录用户信息，及其对应的Endpoint实例
        if (httpSession.getAttribute("username") != null) {
            onlineUsers.put(httpSession, this);
        }
        
        // 获取所有登录用户的名称
        List<String> nameList = getNameList();
        
        // 广播发送
        Message message = new Message<>("", "", nameList, "user");
        broadcastOnlineUsers(onlineUsers.values(), JSONUtil.toJsonStr(message));
        
        System.out.println("当前在线用户数量：" + onlineUsers.size());
        System.out.println("当前在线用户：" + nameList);
    }
    
    private void broadcastOnlineUsers(Collection<ChatWebSocket> EndpointList, String user) throws IOException {
        for (ChatWebSocket chatWebSocket : EndpointList) {
            chatWebSocket.session.getBasicRemote().sendText(user);
        }
    }
    
    private List<String> getNameList() {
        List<String> nameList = new ArrayList<>();
        if (onlineUsers.size() > 0) {
            for (HttpSession httpSession : onlineUsers.keySet()) {
                String username = (String) httpSession.getAttribute("username");
                nameList.add(username);
            }
        }
        return nameList;
    }
    
    @OnMessage
    public void message(String str, Session session) throws IOException {
        Message message = JSONUtil.toBean(str, Message.class);
        // 如果是单播
        if ("single".equals(message.getType())) {
            JSONArray receiverArray = JSONUtil.parseArray(message.getReceiver());
            for (HttpSession httpSession : onlineUsers.keySet()) {
                for (Object receiver : receiverArray) {
                    if (httpSession.getAttribute("username").equals(receiver.toString())) {
                        ChatWebSocket webSocket = onlineUsers.get(httpSession);
                        webSocket.session.getBasicRemote().sendText(JSONUtil.toJsonStr(message));
                    }
                }
            }
        }
        // 如果是广播
        if ("broadcast".equals(message.getType())) {
            broadcastOnlineUsers(onlineUsers.values(), JSONUtil.toJsonStr(message));
        }
        System.out.println(message);
        System.out.println(session);
    }
    
    @OnClose
    public void close(Session session, CloseReason closeReason) throws IOException {
        String username = (String) httpSession.getAttribute("username");
        // 删除Endpoint实例
        System.out.println(onlineUsers.remove(this.httpSession));
        // 清除HttpSession
        this.httpSession.invalidate();
        
        
        System.out.println(username + "下线");
        System.out.println("当前在线用户数量：" + onlineUsers.size());
        // 获取所有登录用户的名称
        List<String> nameList = getNameList();
        System.out.println("当前在线用户：" + nameList);
        
        // 广播发送
        Message message = new Message<>("", "", nameList, "user");
        broadcastOnlineUsers(onlineUsers.values(), JSONUtil.toJsonStr(message));
    }
}