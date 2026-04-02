package top.jzxue.week04.entity;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
class TeamTest {

    @Resource
    private top.jzxue.week04.entity.Team team;

    @Test
    void testTeam() {
        log.info("team: {}", team);

        // 1. 校验负责人姓名长度 2-10位
        assertTrue(team.getLeader().length() >= 2 && team.getLeader().length() <= 10);
        // 2. 校验年龄 30-60
        assertTrue(team.getAge() >= 30 && team.getAge() <= 60);
        // 3. 校验邮箱格式（用@Email的内置规则）
        assertTrue(team.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
        // 4. 校验手机号11位数字
        assertTrue(team.getPhone().matches("^[0-9]{11}$"));
        // 5. 校验创建时间早于当前时间
        assertTrue(team.getCreateTime().isBefore(LocalDate.now()));
    }
}