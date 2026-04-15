package org.example.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Not meant for big data
 */
@RestController
@RequestMapping("/api/v1")
public class PromptStuffingController {

    @Value("classpath:promptTemplates/systemPromptTemplate.st")
    Resource promptTemplateResource;
    private final ChatClient chatClient;

    public PromptStuffingController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/prompt-stuffing")
    public String promptStuffResponse(@RequestParam String message) {
        return chatClient.prompt()
                .system(promptTemplateResource)
                .user(message)
                .call().content();
    }
}
