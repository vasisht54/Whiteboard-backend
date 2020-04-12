package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.SortByOrder;
import com.example.wbdvsp20vasishtserverjava.models.Widget;
import com.example.wbdvsp20vasishtserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    public boolean deleteWidget(int wid) {
        widgetRepository.deleteById(wid);
        return true;
    }

    public List<Widget> findWidgetsForTopic(int topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public int updateWidget(int wid, Widget widget) {
        widget.setId(wid);
        widgetRepository.save(widget);
        return 1;
    }

    public Widget findWidgetById(int wid) {
        return widgetRepository.findById(wid).get();
    }
}
