package top.jzxue.week04.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.jzxue.week04.entity.Student;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    @SuppressWarnings("deprecation")
    public MappingJackson2HttpMessageConverter customJacksonConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        // 1. 设置日期格式
        builder.serializerByType(LocalDateTime.class,
                new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // 2. 设置 Long 类型转 String（解决前端 JS 精度丢失问题）
        builder.serializerByType(Long.class, com.fasterxml.jackson.databind.ser.std.ToStringSerializer.instance);

        converter.setObjectMapper(builder.build());
        return converter;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射 /upload/** 请求到 本地绝对路径（和UPLOAD_DIR一致）
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("classpath:/static/upload/");
    }

}
