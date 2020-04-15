package com.example.wbdvsp20vasishtserverjava.controllers;

import com.example.wbdvsp20vasishtserverjava.models.Topic;
import com.example.wbdvsp20vasishtserverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/api/lessons/{lId}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lId") String lessonId) {
        return topicService.findTopicsForLesson(lessonId);
    }

    @PutMapping("/api/topics/{tId}")
    public int updateTopic(@PathVariable("tId") int topicId, @RequestBody Topic topic) {
        return topicService.updateTopic(topicId, topic);
    }

    /*@PutMapping("/api/topics/{wId}/{direction}")
    public int updateTopicOrder(@PathVariable("wId") int topicId, @PathVariable("direction") String direction,
                                 @RequestBody Topic topic) {
        return topicService.updateTopicOrder(topicId, topic, direction);
    }*/

    @PostMapping("/api/lessons/{lId}/topics")
    public Topic createTopic(@RequestBody Topic topic, @PathVariable("lId") String lessonId) {
        topic.setLessonId(lessonId);
        return topicService.createTopic(topic);
    }

    @DeleteMapping("/api/topics/{tId}")
    public int deleteTopic(@PathVariable("tId") int topicId) {
        boolean res = topicService.deleteTopic(topicId);
        return res ? 1 : 0;
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId")  int tid) {
        return topicService.findTopicById(tid);
    }
}
