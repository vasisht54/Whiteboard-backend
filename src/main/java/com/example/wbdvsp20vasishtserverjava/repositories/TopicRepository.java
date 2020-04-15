package com.example.wbdvsp20vasishtserverjava.repositories;

import com.example.wbdvsp20vasishtserverjava.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic where topic.lessonId = :lId")
    public List<Topic> findTopicsForLesson(@Param("lId") String lessonId);
}
