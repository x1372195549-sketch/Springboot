package top.jzxue.springbootweek03.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AppConfigTest {
    @Resource
    private AppConfig appConfig;

    @Test
    void  getAppName(){
        log.info("应用名称: {}",appConfig.getName());
        log.info("版本号: {}",appConfig.getVersion());
        log.info("应用描述: {}",appConfig.getDescription());
    }



}