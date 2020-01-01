package com.example.apicourse.domain.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepos extends MongoRepository<Topic, String > {
}
