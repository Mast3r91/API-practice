package com.example.apicourse.domain.service;

import com.example.apicourse.domain.data.Topic;
import com.example.apicourse.domain.model.TopicModel;

import java.util.List;

public interface TopicService {
    // method header
    public List<TopicModel> getAllTopics();

    public TopicModel getSpecificTopic(String id);

    public void addTopic(String name,String desc, String id);

    public void updateSpecificTopic(String name,String desc, String id);

    public void deleteSpecificTopic(String id);
}
