package com.example.apicourse.topics;

import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service // Spring business service
public class TopicService {

    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "EasyBook"),
            new Topic("java", "CORE", "For Beginners"),
            new Topic("Maths", "Calculus", "For Dummies")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getSpecificTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //POST
    public void addTopic(Topic topic) {
        topics.add(topic);
    }


    public void updateAllTopics(Topic topic) {
        topics.clear();
        topics.add(topic);
    }

        //PUT
    public void updateSpecificTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i,topic);
                return; // if you find the result, immediately exit for-loop and not continue the rest of indices.
            }
        }

    }
        //DELETE
    public void deleteSpecificTopic(String id) {
        topics.removeIf(t-> t.getId().equals(id));

    }
}

