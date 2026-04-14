# Gemma Docker Chat

## Overview

The `gemma-docker-chat` module is a Spring Boot application built to provide a chat interface using the Gemma AI model. It leverages the `spring-ai-starter-model-openai` library to interact with the AI model and provides RESTful endpoints for communication.

## Features

- REST API for chat functionality.
- Integration with Gemma AI (based on OpenAI models).
- Configurable AI model and API settings.
- Docker-ready for easy deployment.

## Requirements

- Java 21
- Maven 3.8+
- Docker (optional, for containerized deployment)

## Configuration

The application uses the following properties for configuration, which can be set in the `application.properties` file:

```ini
spring.application.name=gemma-docker-chat
spring.ai.openai.chat.options.model=ai/gemma4
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.base-url=http://localhost:12434/engines