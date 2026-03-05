package top.jzxue.hellosample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jzxue.hellosample.vo.ResultVO;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return ResultVO.success("Hello Spring Boot");
    }
}