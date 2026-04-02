package top.jzxue.week04.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jzxue.week04.common.ResultVO;
import top.jzxue.week04.entity.Student;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/students")
public class UserController {
    @GetMapping("/study")
    public ResultVO<Student> getStudy(){
        Student student = new Student();
        student.setId(213211L);
        student.setName("springmvc-student");
        student.setTime(LocalDateTime.now());
        return ResultVO.success(student);    }
}
