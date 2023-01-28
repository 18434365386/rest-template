package com.dx.gupiao;

import com.dx.gupiao.Service.RestTemplateService;
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
    private RestTemplateService restTemplateUtils;
    @Test
    public void test(){
        StockDapandata stockDapandata = restTemplateUtils.getForObject("sh600519");
        System.out.println(stockDapandata);
    }
}
