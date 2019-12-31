package com.example.apicourse.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping (value ="/topics")
    public List<Topic> getAllTopics (){
       return topicService.getAllTopics();
    }

    @GetMapping(value = "/topics/{id}")
    public Topic getSpecificTopic (@PathVariable String id){
        return topicService.getSpecificTopic(id);
    }

    @PostMapping(value ="/topics")
    public void addTopic (@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping (value = "/topics/{id}")
    public void updateAllToics (@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateSpecificTopic(topic, id);
    }

}
