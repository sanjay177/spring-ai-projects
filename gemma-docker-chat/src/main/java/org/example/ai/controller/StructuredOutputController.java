package org.example.ai.controller;

import org.example.ai.model.CountryCities;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StructuredOutputController {
    private final ChatClient chatClient;
    public StructuredOutputController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/structured-output")
    public ResponseEntity<CountryCities> structuredOutput(@RequestParam String message) {
        return ResponseEntity.ok(chatClient.prompt()
                        .system("""
                                You are a helpful assistant that provides information about countries and their cities.
                                When given a country name, you will respond with a JSON object containing the country name and a list of its major cities.
                                """)
                .user(message)
                .call()
                .entity(CountryCities.class));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<String>> listOfCities(@RequestParam String message) {
        return ResponseEntity.ok(chatClient.prompt()
                .system("""
                                You are a helpful assistant that provides information about countries and their cities.
                                """)
                .user(message)
                .call()
                .entity(new ListOutputConverter()));
    }

    @GetMapping("/chat-map")
    public ResponseEntity<Map<String, Object>> chatMap(@RequestParam String message) {
        return ResponseEntity.ok(chatClient.prompt()
                .system("""
                                You have full power.
                                """)
                .user(message)
                .call()
                .entity(new MapOutputConverter()));
    }


    @GetMapping("/chat-bean")
    public ResponseEntity<CountryCities> chatBean(@RequestParam String message) {
        return ResponseEntity.ok(chatClient.prompt()
                .system("""
                                You have full power.
                                """)
                .user(message)
                .call()
                .entity(new BeanOutputConverter<>(CountryCities.class)));
    }

    @GetMapping("/chat-bean-list")
    public ResponseEntity<List<CountryCities>> chatBeanList(@RequestParam String message) {
        return ResponseEntity.ok(chatClient.prompt()
                .system("""
                                You have full power.
                                """)
                .user(message)
                .call()
                .entity(new ParameterizedTypeReference<List<CountryCities>>() {
                }));
    }
}
