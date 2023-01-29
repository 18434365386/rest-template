package com.dx.gupiao;

import com.dx.gupiao.controller.RestTemplateController;

import com.dx.gupiao.service.RestTemplateService;
import com.dx.gupiao.utils.StockDapandata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private RestTemplateController restTemplateController;

    @Autowired
//    private RestTemplateDao restTemplateDao;
    @Test
    public void test(){
        StockDapandata stockDapandata = restTemplateService.getForObject("sh600519");
        restTemplateController.sendMessage(stockDapandata);
        System.out.println(stockDapandata);
//        restTemplateDao.dao("sh600519");
    }
}
