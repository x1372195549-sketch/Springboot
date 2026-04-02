package top.jzxue.springbootweek03.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigControllerBase {
    @Value("${server.port}")
    private Integer port;

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @Value("${app.description}")
    private String description;

    @Resource
    private AppConfig appConfig;

    @GetMapping("/info")
    public String getInfo(){
        return """
                当前服务器端口是 %d
                当前项目名称是 %s
                当前项目版本是 %s
                当前项目是 %s
                """.formatted(port, name, version, description);
    }

    @GetMapping("/info2")
    public Map<String,Object> getConfigInfo2(){
        return Map.of(
                "appName",appConfig.getName(),
                "version",appConfig.getVersion(),
                "description",appConfig.getDescription()
        );
    }
}
