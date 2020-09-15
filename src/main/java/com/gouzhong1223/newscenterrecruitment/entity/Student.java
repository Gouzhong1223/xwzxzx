package com.gouzhong1223.newscenterrecruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-15 20:19
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.entity
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */

/**
 * 学生信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * 学号
     */
    private Integer studentId;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 学院
     */
    private String studentCollege;

    /**
     * 意向部门
     */
    private String departments;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;
}
