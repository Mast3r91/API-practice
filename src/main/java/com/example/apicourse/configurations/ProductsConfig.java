package com.example.apicourse.configurations;

import com.example.apicourse.domain.data.Topic;
import com.example.apicourse.domain.data.TopicRepos;
import com.example.apicourse.domain.service.TopicService;
import com.example.apicourse.domain.service.TopicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories(value = "com.example.apicourse.domain.data")
public class ApiCourseConfig {

    @Autowired
    private TopicRepos topicRepos;

    @Bean
    public TopicService topicService() {
        return new TopicServiceImp(topicRepos);
    }
}
