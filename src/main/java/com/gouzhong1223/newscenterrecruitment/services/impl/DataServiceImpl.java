package com.gouzhong1223.newscenterrecruitment.services.impl;

import com.gouzhong1223.newscenterrecruitment.common.ResultCode;
import com.gouzhong1223.newscenterrecruitment.dto.rep.ResponseDto;
import com.gouzhong1223.newscenterrecruitment.entity.Student;
import com.gouzhong1223.newscenterrecruitment.mapper.StudentMapper;
import com.gouzhong1223.newscenterrecruitment.services.DataService;
import com.gouzhong1223.newscenterrecruitment.services.MailService;
import com.gouzhong1223.newscenterrecruitment.utils.CheakEmail;
import com.gouzhong1223.newscenterrecruitment.utils.SmsUtils;
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
    private static final int STUDENT_ID_LENGTH = 10;

    public DataServiceImpl(StudentMapper studentMapper, MailService mailService) {
        this.studentMapper = studentMapper;
        this.mailService = mailService;
    }

    @Override
    public ResponseDto pushData(Student student) {

        // 验证学号
        if (String.valueOf(student.getStudentId()).length() != STUDENT_ID_LENGTH) {
            return new ResponseDto(ResultCode.FAIL.getCode(), "请填写正确的学号！");
        }

        // 验证手机号
        if (!SmsUtils.isMobile(student.getPhone())) {
            return new ResponseDto(ResultCode.FAIL.getCode(), "请填写正确的手机号！");
        }

        // 验证邮箱
        if (!CheakEmail.isEmail(student.getEmail())) {
            return new ResponseDto(ResultCode.FAIL.getCode(), "请填写正确的邮箱");
        }

        // 根据学号先去数据库查
        Student record = studentMapper.selectByPrimaryKey(student.getStudentId());

        if (record != null) {
            // 说明已经报过名，现在是修改报名信息的逻辑
            studentMapper.updateByPrimaryKeySelective(student);
            mailService.sendSimpleMail(student.getEmail(), "【重邮新闻中心】- 您已成功修改报名信息！", "亲爱的" + student.getStudentName() + "同学:\n" +
                    "您已成功修改您的报名信息！\n");
            return new ResponseDto(ResultCode.SUCCESS.getCode(), "修改报名信息成功！", student);
        } else {
            // 这是首次报名
            try {
                studentMapper.insertSelective(student);
                mailService.sendSimpleMail(student.getEmail(), "【重邮新闻中心】- 您已报名成功！", "亲爱的" + student.getStudentName() + "同学:\n" +
                        "我们已经收到您的意向部门信息，后续通知我们会通过 QQ 群的形式传播，请持续关注，谢谢！\n");
                return ResponseDto.SUCCESS(student);
            } catch (Exception e) {
                return ResponseDto.FAIL();
            }
        }
    }

}


