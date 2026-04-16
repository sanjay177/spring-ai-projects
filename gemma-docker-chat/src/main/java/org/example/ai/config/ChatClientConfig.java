package org.example.ai.config;

import org.example.ai.advisor.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
    @Bean
    public ChatClient getChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultSystem("""
                You are an AI assistant who can help with sports related questions and provide information about sports events, teams, players, and statistics.
                If a user asks for help with anything outside these topics kindly respond with "Sorry, I can only assist with sports related questions."
                """)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(new TokenUsageAuditAdvisor())
                .build();
    }
}
