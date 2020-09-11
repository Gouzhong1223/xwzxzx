package com.gouzhong1223.newscenterrecruitment.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.gouzhong1223.newscenterrecruitment.dto.rep.ResponseDto;
import com.gouzhong1223.newscenterrecruitment.services.DataService;
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
    @Override
    public ResponseDto pushData(JSONObject jsonObject) {
        //TODO 暂时不知道那边会发什么数据，先不写
        return null;
    }
}
