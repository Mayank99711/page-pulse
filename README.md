# Page Pulse

Page Pulse is a Spring Boot-based web application that analyzes a website and generates a basic SEO and performance report. It helps users quickly inspect important SEO elements such as page title, meta description, heading structure, image accessibility, response time, and an overall SEO score.

---

## Project Overview

This project was developed as part of the Digital Heroes Software Development Internship Assignment.

The application accepts a website URL, fetches its HTML content using Jsoup, analyzes important SEO metrics, and displays the results in a clean and responsive dashboard.

---

## Features

- Analyze any valid website URL
- HTTP Status Code
- Response Time
- Page Title Detection
- Meta Description Detection
- H1 Tag Count
- Missing Image ALT Attributes
- Word Count
- SEO Score Calculation
- Responsive User Interface
- Input Validation
- Exception Handling

---

## Tech Stack

### Backend

- Java 17
- Spring Boot
- Maven
- Jsoup

### Frontend

- HTML5
- CSS3
- JavaScript

---

## Project Structure

```text
pagepulse
│
├── controller
├── service
├── dto
├── exception
├── static
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── application.properties
```

---

## How to Run

Clone the repository:

```bash
git clone https://github.com/Mayank99711/page-pulse.git
```

Go to the project folder:

```bash
cd page-pulse
```

Run the application:

```bash
mvn spring-boot:run
```

Open your browser:

```
http://localhost:9090
```

---

## API Endpoint

**POST**

```
/api/analyze
```

### Sample Request

```json
{
  "url": "https://spring.io"
}
```

### Sample Response

```json
{
  "httpStatus": 200,
  "responseTime": 1400,
  "title": "Spring | Home",
  "metaDescription": "...",
  "h1Count": 2,
  "missingAltImages": 1,
  "wordCount": 597,
  "seoScore": 100
}
```

---

## Screenshots after testing by using URL

##spring.io

![spring.io.png](screenshots%2Fspring.io.png)

##google.com

![google.com.png](screenshots%2Fgoogle.com.png)

##github.com

![github.com.png](screenshots%2Fgithub.com.png)

##https://openai.com

![httpsopenai.com.png](screenshots%2Fhttpsopenai.com.png)

##abcxyz123456789.com

![abcxyz123456789.com.png](screenshots%2Fabcxyz123456789.com.png)

##https://example.com/image.png

![httpsexample.comimage.png.png](screenshots%2Fhttpsexample.comimage.png.png)

---

## Future Improvements

- Broken Link Detection
- Lighthouse Integration
- Accessibility Score
- Performance Score
- PDF Report Download
- CSV Report Export
- Page Speed Insights Integration

---

## AI Usage

I used ChatGPT as a learning and review tool to discuss implementation ideas and improve documentation. The project implementation, debugging, testing, and final decisions were completed by me.
---

## Author

**Mayank Goyal**

GitHub:  
https://github.com/Mayank99711

---

## License

This project was created for the Digital Heroes Software Development Internship Assignment (2026).