package com.kxw.data.kafka.admin;

import org.apache.kafka.clients.admin.*;

import java.util.List;
import java.util.Map;

/**
 * Create by kangxiongwei on 2019/5/19 10:47 AM
 */
public class KafkaDataAdmin {

    /**
     * 创建主题
     *
     * @param conf
     * @param topics
     */
    public void createTopic(Map<String, Object> conf, List<NewTopic> topics) {
        AdminClient client = KafkaAdminClient.create(conf);
        client.createTopics(topics);
        client.close();
    }

    /**
     * 删除主题
     *
     * @param conf
     * @param topics
     */
    public void deleteTopic(Map<String, Object> conf, List<String> topics) {
        AdminClient client = KafkaAdminClient.create(conf);
        client.deleteTopics(topics);
        client.close();
    }

}
