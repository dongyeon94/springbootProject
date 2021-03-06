package com.toy.root.chat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoom {
	
	private String roomId;
	private String name;

	public static ChatRoom create(String name) {
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.roomId = UUID.randomUUID().toString();
		chatRoom.name = name;
		return chatRoom;
	}
	
	
//	private Set<WebSocketSession> sessions = new HashSet<>();
//	
//	@Builder
//	public ChatRoom(String roomId, String name) {
//		this.roomId = roomId;
//		this.name = name;
//	}
//	
//	public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
//		if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
//			sessions.add(session);
//			chatMessage.setMessage(chatMessage.getSender()+"님이 입장했습니다.");
//		}
//		sendMessage(chatMessage,chatService);
//	}
//
//	private <T> void sendMessage(T message, ChatService chatService) {
//		sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
//	}
	

}
