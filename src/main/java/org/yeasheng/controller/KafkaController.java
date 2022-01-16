package org.yeasheng.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

/**
 * @author yansh
 * @version 2021/10/11
 **/
@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Resource
    KafkaTemplate<Object,Object> kafkaTemplate;


    @GetMapping("send")
    public String send(){
        System.out.println("start at " + ZonedDateTime.now() + "");
        for (int i = 0; i < 10; i++) {
            long now = System.currentTimeMillis();
            // 调用template,将消息发送到kafka
            // 第一个参数是topic名称，第二个参数是要发送的消息内容
            kafkaTemplate.send("test", "message: " + now);
        }
        return "success";
    }

    @GetMapping("receive")
    public String receive(){
        return "success";
    }
}
