package com.gouzhong1223.newscenterrecruitment.controller;

import com.gouzhong1223.newscenterrecruitment.dto.rep.ResponseDto;
import com.gouzhong1223.newscenterrecruitment.entity.Student;
import com.gouzhong1223.newscenterrecruitment.services.DataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-09-11 19:25
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.newscenterrecruitment.controller
 * @ProjectName : newscenterrecruitment
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("index")
public class IndexController {

    private final DataService dataService;

    public IndexController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("pushData")
    public ResponseDto pushData(@RequestBody Student student) {
        return dataService.pushData(student);
    }

    public static void main(String[] args) {

    }

    public synchronized void test() throws InterruptedException {
        Object o = new Object();
        o.wait();
        Thread.sleep(1);
    }


    public static synchronized void test2() {

    }

}
