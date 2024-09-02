
# Weather-App-Springboot-thymeleaf

This project is a Spring Boot-based Weather Application that provides real-time weather information for a specified city. It uses Thymeleaf for rendering views and integrates HTML and CSS for the frontend design.

## Features
- **Real-Time Weather Data:** Fetches and displays current weather conditions for any city using the OpenWeatherMap API.
- **Error Handling:** Includes custom error messages for scenarios like city not found.
- **User Interface:** Utilizes Thymeleaf, HTML, and CSS for a responsive and visually appealing user experience.

## Technologies Used
- **Java:** Core application logic.
- **Spring Boot:** Framework for building the application.
- **Thymeleaf:** Template engine for rendering HTML views.
- **HTML/CSS:** Frontend technologies for creating and styling web pages.
- **RestTemplate:** For making HTTP requests to external APIs.
- **OpenWeatherMap API:** Provides weather data.

## How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/weather-app.git
```

### 2. Navigate to the Project Directory
```bash
cd weather-app
```

### 3. Add Your API Key
- Create a file named `application.properties` in the `src/main/resources` directory.
- Add your OpenWeatherMap API key:
  ```properties
  api.key=YOUR_API_KEY
  ```

### 4. Build and Run the Application
- **Using Maven:**
  ```bash
  mvn clean install
  mvn spring-boot:run
  ```
- **Directly from IDE:** Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse) and run `WeatherAppApplication` as a Java application.

### 5. Access the Application
- Open your web browser and go to `http://localhost:8080`.

## Endpoints
- **Home Page:** `/` - Displays the index page.
- **Weather Page:** `/weather` - Provides weather details for the city specified in the query parameter `city`.

## Error Handling
- **City Not Found:** If the city is not found or an error occurs, an appropriate error message will be displayed on the weather page.

## Project Structure
```
src
 └── main
     └── java
         └── com
             └── myproject
                 └── weather_app
                     ├── controllers
                         └── WeatherController.java
                     ├── model
                     └── WeatherAppApplication.java
     └── resources
         ├── static
             └── css
                 └── styles.css
         ├── templates
             ├── index.html
             └── weather.html
         └── application.properties
```


## Contributing
Feel free to fork the repository and submit pull requests. Contributions are welcome!

