### Basic AI Chat
A simple REST API for AI-powered chat conversations using OpenAI's GPT models.

#### Features
- RESTful API endpoint for chat interactions
- Integration with OpenAI's language models
- Spring Boot web application

#### Prerequisites
- Java 21 or higher
- Maven 3.6+
- OpenAI API key

#### Configuration
Set your OpenAI API key as an environment variable:
```bash
export OPENAI_API_KEY=your_openai_api_key_here
```

#### Building and Running

1. Clone the repository
2. Navigate to the project root
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   cd basic-ai-chat
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

#### API Usage

Send a GET request to the chat endpoint:

```
GET /api/v1/chat?message=Hello, how are you?
```

Example using curl:
```bash
curl "http://localhost:8080/api/v1/chat?message=Tell%20me%20a%20joke"
```

#### Project Structure
```
spring-ai-projects/
├── pom.xml                          # Parent POM
├── basic-ai-chat/                   # Basic AI Chat module
│   ├── pom.xml
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── org/example/ai/
│   │   │   │       ├── BasicAiChatApplication.java
│   │   │   │       └── controller/
│   │   │   │           └── ChatController.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   └── target/
└── src/                            # Additional source files
    └── main/java/org/example/ai/Main.java
```

#### Technologies Used
- **Spring Boot 4.0.5** - Application framework
- **Spring AI 2.0.0-M4** - AI integration framework
- **OpenAI GPT** - Language model
- **Maven** - Build tool
- **Java 21** - Programming language

## License
This project is licensed under the MIT License.