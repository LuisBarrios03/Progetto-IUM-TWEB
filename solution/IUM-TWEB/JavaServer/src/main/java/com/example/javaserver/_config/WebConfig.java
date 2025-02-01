package com.example.javaserver._config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebConfig  implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    public WebConfig() {
        logger.info("WebConfig caricata con successo!");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Aggiungi il mapping per permettere richieste da localhost:3000
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Solo richieste dal frontend in localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE") // I metodi consentiti
                .allowedHeaders("*") // Header consentiti
                .allowCredentials(true); // Se hai bisogno di permettere credenziali (cookie, auth token)
    }
}
