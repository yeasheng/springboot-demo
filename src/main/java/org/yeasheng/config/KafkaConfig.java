package org.yeasheng.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

/**
 * kafka配置
 *
 * @author yansh
 * @version 2021/10/11
 **/
@EnableKafka
public class KafkaConfig {

    /**
     * 新建一个主题
     *
     * @return 新的topic
     */
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test")// 指定主题名称
                .partitions(30) // 指定分区数量，这个数量通常要大于消费者的数量，按消费者线程数计算
                .replicas(2) // 指定副本数量
                .compact()
                .build();
    }
}
