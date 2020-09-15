package com.gouzhong1223.newscenterrecruitment.services.impl;

import com.gouzhong1223.newscenterrecruitment.dto.rep.ResponseDto;
import com.gouzhong1223.newscenterrecruitment.entity.Student;
import com.gouzhong1223.newscenterrecruitment.mapper.StudentMapper;
import com.gouzhong1223.newscenterrecruitment.services.DataService;
import com.gouzhong1223.newscenterrecruitment.services.MailService;
import org.springframework.stereotype.Service;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-11 19:34
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.services.impl
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */
@Service
public class DataServiceImpl implements DataService {


    private final StudentMapper studentMapper;
    private final MailService mailService;

    public DataServiceImpl(StudentMapper studentMapper, MailService mailService) {
        this.studentMapper = studentMapper;
        this.mailService = mailService;
    }

    @Override
    public ResponseDto pushData(Student student) {
        if (studentMapper.selectByPrimaryKey(student.getStudentId()) == null) {
            try {
                studentMapper.insertSelective(student);
                mailService.sendSimpleMail(student.getEmail(), "这是一个标题", student.getStudentName());
            } catch (Exception e) {
                return ResponseDto.FAIL();
            }
            return ResponseDto.SUCCESS(student);
        }
        return ResponseDto.FAIL();
    }
}
