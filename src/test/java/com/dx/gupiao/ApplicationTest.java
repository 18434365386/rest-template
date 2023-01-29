package com.dx.gupiao;

import com.dx.gupiao.controller.RestTemplateController;

import com.dx.gupiao.service.SZRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private SZRestService restTemplateService;

    @Autowired
    private RestTemplateController restTemplateController;

    @Autowired
//    private RestTemplateDao restTemplateDao;
    @Test
    public void test(){
        String data = restTemplateService.getForObject();
        restTemplateController.sendMessage(data);
        System.out.println(data);
//        restTemplateDao.dao("sh600519");
    }
}
