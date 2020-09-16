package com.gouzhong1223.newscenterrecruitment.mapper;


import com.gouzhong1223.newscenterrecruitment.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-15 20:29
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.mapper
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test01() {
        Student student = new Student(1, "11", "111", "111", "111", "1111");
        studentMapper.insertSelective(student);
    }
}
