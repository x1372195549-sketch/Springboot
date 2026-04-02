package top.jzxue.week04.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jzxue.week04.common.ResultVO;
import top.jzxue.week04.entity.Team;
import top.jzxue.week04.exception.BusinessException;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/api/Team")
@Slf4j
public class TeamController {
    @PostMapping("/add")
    public ResultVO<String> addTeam(@Validated @RequestBody Team team, HttpServletRequest request) {
        log.info("添加团队：{}", team);
        String token = request.getHeader("token");
        if (token ==null||token.isBlank()){
            throw new BusinessException(401,"请先登录");
        }
        if (!"admin".equals(token)){
            throw new BusinessException(403,"没有权限");
        }

        return ResultVO.success("添加成功");
    }
}
