package org.example.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api/v1")
public class ChatMemoryController {

    private final ChatClient chatClient;

    public ChatMemoryController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat-memory")
    public ResponseEntity<String> chatWithMemory(@RequestParam("message") String message, @RequestHeader("convId") String convId) {
        return ResponseEntity.ok(chatClient.prompt()
                .advisors(advisor -> advisor.param(CONVERSATION_ID, convId))
                .user(message)
                .call().content());
    }
}
