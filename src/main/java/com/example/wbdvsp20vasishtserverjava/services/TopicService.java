package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Topic;
import com.example.wbdvsp20vasishtserverjava.models.Topic;
import com.example.wbdvsp20vasishtserverjava.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    
    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> findAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    public boolean deleteTopic(int tid) {
        topicRepository.deleteById(tid);
        return true;
    }

    public List<Topic> findTopicsForLesson(int lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    public int updateTopic(int tid, Topic topic) {
        topic.setId(tid);
        topicRepository.save(topic);
        return 1;
    }

    public Topic findTopicById(int tid) {
        return topicRepository.findById(tid).get();
    }
}
