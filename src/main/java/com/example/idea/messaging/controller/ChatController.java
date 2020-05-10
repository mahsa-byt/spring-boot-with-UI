package com.example.idea.messaging.controller;

import com.example.idea.messaging.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	// for register user in chat
	@MessageMapping("/chat.register") // map client to server
	@SendTo("/topic/public")  // fo queue
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	//for continue chat message
	@MessageMapping("/chat.send") //
	@SendTo("/topic/public") //we have /topic/public in main.js
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}
