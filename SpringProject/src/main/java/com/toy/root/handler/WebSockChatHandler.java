package com.toy.root.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.root.chat.ChatMessage;
import com.toy.root.chat.ChatRoom;
import com.toy.root.chat.ChatService;

//import jdk.internal.jline.internal.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSockChatHandler extends TextWebSocketHandler{
	
	private final ObjectMapper objectMapper;
	private final ChatService chatService;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload {}",payload);
		
		ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
		ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//		room.handleActions(session, chatMessage, chatService);
//		TextMessage textMessage = new TextMessage("Welcome chatting server");
//		session.sendMessage(textMessage);
	}
	
	
	
}
