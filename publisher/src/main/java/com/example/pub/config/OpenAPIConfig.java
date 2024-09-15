//package com.example.pub.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class OpenAPIConfig {
//    int port = 8056;
//
//    private final String prodUrl = "http://localhost:" + port;
//    private final String devUrl = "http://localhost:" + port;
//
//    @Bean
//    public OpenAPI myOpenAPI() {
//        Server devServer = new Server()
//                .url(devUrl)
//                .description("Server URL in Development environment");
//
//        Server prodServer = new Server()
//                .url(prodUrl)
//                .description("Server URL in Production environment");
//
//        Contact contact = new Contact()
//                .email("farzan.6118@gmail.com")
//                .name("Farzan Saketi")
//                .url(devUrl);
//
//        License mitLicense = new License()
//                .name("MIT License")
//                .url(devUrl);
//
//        Info info = new Info()
//                .title("Video Streaming Service API")
//                .version("1.0")
//                .contact(contact)
//                .description("This API exposes endpoints to manage tutorials.")
//                .termsOfService("https://github.com/Farzan6118/")
//                .license(mitLicense);
//
////        Components components = new Components()
////                .addSecuritySchemes("BEARER KEY", new SecurityScheme()
////                        .type(SecurityScheme.Type.HTTP)
////                        .scheme("bearer")
////                        .in(SecurityScheme.In.HEADER));
//
//        return new OpenAPI()
//                .info(info)
//                .servers(List.of(devServer, prodServer))
////                .components(components)
//                ;
//    }
//}