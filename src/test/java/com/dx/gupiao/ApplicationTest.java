package com.dx.gupiao;

import com.dx.gupiao.pojo.StockDTO;
import com.dx.gupiao.utils.RestTemplateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private RestTemplateUtils restTemplateUtils;
    @Test
    public void test(){
        StockDTO stockDTO = restTemplateUtils.getForObject("sh600519");
        System.out.println(stockDTO);
    }
}
