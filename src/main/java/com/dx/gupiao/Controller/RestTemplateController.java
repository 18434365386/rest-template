package com.dx.gupiao.Controller;

import com.dx.gupiao.utils.StockDapandata;
import com.dx.gupiao.utils.StockResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RestTemplateController {

    // 1、声明topic
    private static final String TOPIC_NAME="json";


    // 2、注入kafka
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    // 3、模拟发送消息
    @ResponseBody
    public void sendMessage(StockDapandata stockDapandata){
        kafkaTemplate.send(TOPIC_NAME,"这是一个消息,num="+stockDapandata).addCallback(success->{
            // 消息发送的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println(""+ topic + "-" + partition + "-" + offset);
//            log.info("收到bigData推送的数据'{}'", stockDapandata.toString());
        }, failure -> {
            System.out.println("发送消息失败：" + failure.getMessage());
        });
    }
}
