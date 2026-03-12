package top.jzxue.springbootweek02.Service;

import org.springframework.stereotype.Service;
import top.jzxue.springbootweek02.entity.Phone;
import top.jzxue.springbootweek02.entity.Student;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    private static final Map<Long,Student>STUDENT_DATA = new ConcurrentHashMap<>();
    static {
        Student student1 = Student.builder().id(1001L).name("张三").gender("男").birthday(LocalDate.of(1999,10,25)).phone(Phone.builder().band("phohe").price(9999.99).color("black").build()).build();
        Student student2 = Student.builder().id(1002L).name("张三丰").gender("男").birthday(LocalDate.of(2003,2,15)).phone(Phone.builder().band("phohe").price(9999.99).color("black").build()).build();
        STUDENT_DATA.put(student1.getId(), student1);
        STUDENT_DATA.put(student2.getId(), student2);
    }
    //创建学生
    public void createStudent(Student student){
        STUDENT_DATA.put(student.getId(), student);
    }
    //根据id查询学生
    public Student getStudentById(Long id){
        return STUDENT_DATA.get(id);
    }
    //根据姓名查询学生
    public Student getName(String name){
        return STUDENT_DATA.values().stream().filter(stu -> stu.getName().equals(name)).findFirst().orElse(null);
    }
    //查询学生列表
    public Iterable<Student>getAllStudent(){
        return STUDENT_DATA.values();
    }
    //根据id更新学生信息
    public void updateStudentById(Long id,Student student){
        STUDENT_DATA.put(id,student);
    }
    public void deleterStudentById(Long id){
        STUDENT_DATA.remove(id);
    }
}
