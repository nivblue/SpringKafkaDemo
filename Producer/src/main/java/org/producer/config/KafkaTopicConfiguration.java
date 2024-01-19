package org.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static org.producer.utils.Constants.TEST_TOPIC;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder
                .name(TEST_TOPIC)
                .build();
    }
}
