package com.example.wbdvsp20vasishtserverjava.repositories;

import com.example.wbdvsp20vasishtserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tId", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(@Param("tId") int topicId);
}
