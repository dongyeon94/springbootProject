package com.toy.root.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.toy.root.chat.ChatMessage;
import com.toy.root.chat.ChatRoom;
import com.toy.root.chat.ChatRoomRepository;
import com.toy.root.chat.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private final SimpMessageSendingOperations messageSendingOperations;	
	private final ChatRoomRepository chatroomrepository;
	
	@MessageMapping("/chat/message")
	public void message(ChatMessage message) {
		if (ChatMessage.MessageType.JOIN.equals(message.getType())) {
			message.setMessage(message.getSender() + "님이 입장하셨습니다.");
		}
		messageSendingOperations.convertAndSend("/sub/chat/room/"+message.getRoomId(),message);
	}
	
	@GetMapping("/chat/room")
	public String rooms(Model model) {
		return "/chat/room";
	}
	
	@GetMapping("/chat/rooms")
	@ResponseBody
	public List<ChatRoom> room() {
		return chatroomrepository.findAllRoom();
	}
	
	@PostMapping("/chat/room")
	@ResponseBody
	public ChatRoom createRoom(@RequestParam String name) {
		return chatroomrepository.createChatRoom(name);
	}
	
	@GetMapping("/chat/room/enter/{roomId}")
	public String roomDetail(Model model, @PathVariable String roomId) {
		model.addAttribute("roomId", roomId);
		return "/chat/roomdetail";
	}
	
	@GetMapping("/chat/room/{roomId}")
	@ResponseBody
	public ChatRoom roomInfo(@PathVariable String roomId) {
		return chatroomrepository.findRoomById(roomId);
	}
	
//	private final ChatService chatService;
	
//	@PostMapping
//	public ChatRoom createRoom(@RequestParam String name) {
//		return chatService.createRoom(name);
//	}
//	
//	@GetMapping
//	public List<ChatRoom> findAllRoom(){
//		return chatService.findAllRoom();
//	}
}
