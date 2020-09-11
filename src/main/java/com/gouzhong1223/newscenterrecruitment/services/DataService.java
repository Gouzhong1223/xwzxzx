package com.gouzhong1223.newscenterrecruitment.services;

import com.alibaba.fastjson.JSONObject;
import com.gouzhong1223.newscenterrecruitment.dto.rep.ResponseDto;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-11 19:34
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.services
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */
public interface DataService {

    /**
     * 提交数据
     *
     * @param jsonObject 前端发送过来的数据
     * @return
     */
    ResponseDto pushData(JSONObject jsonObject);
}
