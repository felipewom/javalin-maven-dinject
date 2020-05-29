package com.example;

import com.example.config.AppConfig;
import io.dinject.SystemContext;
import io.dinject.controller.WebRoutes;
import io.javalin.Javalin;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "CPA Classificacao", description = "CPA Classificacao"))
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.logIfServerNotStarted = false;
            config.contextPath = AppConfig.getProperty("project.context", "/").toString();
        });

        // All WebRoutes / Controllers ... from DI Context
        List<WebRoutes> webRoutes = SystemContext.getBeans(WebRoutes.class);
        app.routes(() -> webRoutes.forEach(WebRoutes::registerRoutes));
        app.start(8080);
    }
}
