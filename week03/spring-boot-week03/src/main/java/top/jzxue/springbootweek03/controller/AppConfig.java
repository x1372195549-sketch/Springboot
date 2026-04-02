package top.jzxue.springbootweek03.controller;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name;
    private String version;
    private String description;
}

