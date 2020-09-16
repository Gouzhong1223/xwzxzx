package com.gouzhong1223.newscenterrecruitment.services.impl;

import com.gouzhong1223.newscenterrecruitment.common.ResultCode;
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
        Student record = studentMapper.selectByPrimaryKey(student.getStudentId());
        if (record != null) {
            studentMapper.updateByPrimaryKeySelective(student);
            mailService.sendSimpleMail(student.getEmail(), "subject", student.getStudentName() + "修改成功！");
            return new ResponseDto(ResultCode.SUCCESS.getCode(), "修改报名信息成功！", student);
        } else {
            try {
                studentMapper.insertSelective(student);
                mailService.sendSimpleMail(student.getEmail(), "subject", student.getStudentName());
                return ResponseDto.SUCCESS(student);
            } catch (Exception e) {
                return ResponseDto.FAIL();
            }
        }
    }

}


