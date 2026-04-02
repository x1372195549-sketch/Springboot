package top.jzxue.week04.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Student {
    private Long id;
    private String name;
    private LocalDateTime Time;
    public Student(){

    }
}
