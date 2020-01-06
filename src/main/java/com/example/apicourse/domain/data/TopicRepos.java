package com.example.apicourse.domain.data;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepos extends MongoRepository<Topic, String > {
}
