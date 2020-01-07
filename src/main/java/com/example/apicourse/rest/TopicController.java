package com.example.apicourse.rest;

import com.example.apicourse.domain.model.TopicModel;
import com.example.apicourse.domain.service.TopicService;
import com.example.apicourse.rest.dto.TopicRequest;
import com.example.apicourse.rest.dto.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topics")
    public List<TopicResponse> getAllTopics() {

        return topicService.getAllTopics().stream().map(topic -> new TopicResponse(topic.getName(), topic.getDescription())).collect(Collectors.toList());
    }

    @GetMapping(value = "/topics/{id}")
    public TopicResponse getSpecificTopic(@PathVariable String id) {
        TopicModel topicModel = topicService.getSpecificTopic(id);
        return new TopicResponse(topicModel.getName(), topicModel.getDescription());
    }

    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody TopicRequest topic) {
        topicService.addTopic(topic.getName(), topic.getDescription(), topic.getId());
    }

    @PutMapping(value = "/topics/{id}")
    public void updateAllToics(@RequestBody TopicRequest topic, @PathVariable String id) {
        topicService.updateSpecificTopic(topic.getName(), topic.getDescription(), id);
    }
    @DeleteMapping(value = "/topics/{id}")
    public void deleteSpecificTopic (@PathVariable String id) {
        topicService.deleteSpecificTopic(id);
    }

}
