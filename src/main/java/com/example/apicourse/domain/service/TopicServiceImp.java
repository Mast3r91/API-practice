package com.example.apicourse.domain.service;

import com.example.apicourse.domain.data.Topic;
import com.example.apicourse.domain.data.TopicRepos;
import com.example.apicourse.domain.model.TopicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Spring business service
public class TopicServiceImp  implements TopicService{


    private TopicRepos topicRepos;

    @Autowired
    public TopicServiceImp(TopicRepos topicRepos) {
        this.topicRepos = topicRepos;
    }

    public List<TopicModel> getAllTopics() {
        return this.topicRepos.findAll().stream().map(topic -> new TopicModel(topic.getId(), topic.getName(), topic.getDescription())).collect(Collectors.toList());
    }

    public TopicModel getSpecificTopic(String id) {
        //call Repos
        Optional<Topic> topic=this.topicRepos.findById(id);
        return new TopicModel(topic.get().getId(), topic.get().getName(), topic.get().getDescription());
    }

    //POST
    public void addTopic(String name,String desc, String id) {
        this.topicRepos.save(new Topic(id, name, desc));
    }

        //PUT
    public void updateSpecificTopic(String name,String desc, String id) {
        // you have to get first then update then save.
//        Topic topic = this.topicRepos.findById(id); // i got an object identified by this id
//        topic.setName(name);
//        topic.setDescription(desc);
        // i did not update id (problem)

//        this.topicRepos.save(topic);
    }
        //DELETE
    public void deleteSpecificTopic(String id) {
        this.topicRepos.deleteById(id);
    }
}

