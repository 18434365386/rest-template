package com.dx.gupiao.utils;

import com.dx.gupiao.config.KeyConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RestTemplateUtils {
    @Autowired
//    private RestTemplate restTemplate;
    private KeyConf keyConf;
    private static final String URL = "http://web.juhe.cn:8080/finance/stock/hs?gid=%s&key=%s";


//    /**
//     * 通过GET请求获取ResponseEntity对象，包容有状态码，响应头和响应数据
//     *
//     * @param id
//     * @return
//     */
//    public ResponseEntity<User> getForEntity(Long id) {
//        ResponseEntity<User> responseEntity = restTemplate.getForEntity("localhost:8080/api/user/getById?id=" + id, User.class);
//        return responseEntity;
//    }

    /**
     * 通过GET请求获取响应结果
     * @param code
     * @return
     */
    public StockDapandata getForObject(String code){
        String url =String.format(URL,code,keyConf.getAppKey());
        RestTemplate restTemplate = new RestTemplate();
        // 1、传入底层执行引擎
        restTemplate.setMessageConverters(parseContentType());
        // 2、通过Get请求获取响应结果
        StockResponse response = restTemplate.getForObject(url, StockResponse.class);
//        System.out.println(response);
        StockDapandata stockDapandata = response.getResult().get(0).getDapandata();
//        System.out.println(stockDapandata);
//        StockDTO stockDTO = new StockDTO();
//        stockDTO.setName(stockDapandata.getName());
        return stockDapandata;
    }
    /**
     * 支持所有的contentType类型
     * @return 类型转换
     */
    private List<HttpMessageConverter<?>> parseContentType() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        return messageConverters;
    }
//
//    /**
//     * 通过GET请求获得响应结果
//     *
//     * @param id
//     * @return
//     */
//    public User getForObject(Long id) {
//        User user = restTemplate.getForObject("localhost:8080/api/user/getById?id=" + id, User.class);
//        return user;
//    }
//
//    /**
//     * 通过POST请求获取ResponseEntity对象，包容有状态码，响应头和响应数据
//     *
//     * @param user
//     * @return
//     */
//    public ResponseEntity<String> postForEntity(User user) {
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("localhost:8080/api/user/insert", user, String.class);
//        return responseEntity;
//    }
//
//
//    /**
//     * 通过exchange实现GET请求获取ResponseEntity对象，包容有状态码，响应头和响应数据
//     *
//     * @param id
//     * @return
//     */
//    public ResponseEntity<String> exchangeToGet(Long id) {
//        ResponseEntity<String> responseEntity = restTemplate.exchange("localhost:8080/api/user/getById?id=" + id, HttpMethod.GET, null, String.class);
//        return responseEntity;
//    }
//
//
//    /**
//     * 通过exchange实现POST请求获取ResponseEntity对象，包容有状态码，响应头和响应数据
//     *
//     * @param user
//     * @return
//     */
//    public ResponseEntity<String> exchangeToPost(User user) {
//        //heads信息
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        //heads信息和body信息组装
//        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
//        ResponseEntity<String> response = restTemplate.exchange("localhost:8080/api/user/insert", HttpMethod.POST, httpEntity, String.class);
//        return response;
//    }
}