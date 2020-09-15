package com.gouzhong1223.newscenterrecruitment.mapper;

import com.gouzhong1223.newscenterrecruitment.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-15 20:19
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.mapper
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}