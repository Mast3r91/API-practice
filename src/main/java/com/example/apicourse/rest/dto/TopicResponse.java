package com.example.apicourse.rest.dto;

public class TopicResponse {
    private String name;
    private String description;

    public TopicResponse() {
    }

    public TopicResponse(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
