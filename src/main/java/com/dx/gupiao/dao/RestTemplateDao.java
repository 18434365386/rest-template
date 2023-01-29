//package com.dx.gupiao.dao;
//
//import com.dx.gupiao.controller.RestTemplateController;
//import com.dx.gupiao.service.RestTemplateService;
//import com.dx.gupiao.utils.StockDapandata;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RestTemplateDao {
//    private RestTemplateController restTemplateController;
//    private RestTemplateService restTemplateService;
//    public void dao(String code){
//        StockDapandata stockDapandata = restTemplateService.getForObject(code);
//        restTemplateController.sendMessage(stockDapandata);
//    }
//}
