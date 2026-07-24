# 🚀 Page Pulse

A Spring Boot web application that analyzes any website and generates a basic SEO report.

## Features

- HTTP Status
- Response Time
- Page Title
- Meta Description
- H1 Count
- Missing ALT Images
- Word Count
- SEO Score
- Error Handling

## Technology

- Java 17
- Spring Boot
- Maven
- Jsoup
- HTML
- CSS
- JavaScript

## Run

```bash
mvn spring-boot:run
```

Open

http://localhost:8080

## API

POST

```
/api/analyze
```

Request

```json
{
"url":"https://spring.io"
}
```

## Future Improvements

- Broken Link Detection
- Lighthouse Integration
- Accessibility Report
- Performance Score

## AI Usage

I used ChatGPT to brainstorm the project structure, improve documentation, and review implementation ideas. I customized the implementation and made the final development decisions myself.