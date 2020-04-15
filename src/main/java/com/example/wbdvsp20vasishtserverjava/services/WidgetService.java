package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Topic;
import com.example.wbdvsp20vasishtserverjava.models.Widget;
import com.example.wbdvsp20vasishtserverjava.repositories.TopicRepository;
import com.example.wbdvsp20vasishtserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Widget createWidget(int topicId, Widget widget) {
        Topic topic = topicRepository.findById(topicId).get();
        widget.setTopic(topic);
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
        Topic topic = topicRepository.findById(topicId).get();
        return topic.getWidgets();
    }

    public int updateWidget(int wid, Widget widget) {
        widgetRepository.save(widget);
        return 1;
    }

    public Widget findWidgetById(int wid) {
        return widgetRepository.findById(wid).get();
    }

    private int getOrderOfLastWidgetOfTopic(int topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        widgetsForTopic.sort(Comparator.comparingInt(Widget::getOrderSequence));
        return widgetsForTopic.get(widgetsForTopic.size()-1).getOrderSequence();
    }

    private int getOrderOfFirstWidgetOfTopic(int topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        widgetsForTopic.sort(Comparator.comparingInt(Widget::getOrderSequence));
        return widgetsForTopic.get(0).getOrderSequence();
    }

    public int updateWidgetOrder(int widgetId, Widget widget, String direction) {

        widget = widgetRepository.findById(widgetId).get();

        int currWidgetOrder = widget.getOrderSequence();
        List<Widget> widgetsForTopic = findWidgetsForTopic(widget.getTopic().get_id());

        if(direction.equals("DOWN")) {

            if(currWidgetOrder == getOrderOfLastWidgetOfTopic(widget.getTopic().get_id())) {
                return 0;
            }

            Widget nextWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))+1);
            int nextWidgetOrder = nextWidget.getOrderSequence();

            widget.setOrderSequence(nextWidgetOrder);
            nextWidget.setOrderSequence(currWidgetOrder);

            widgetRepository.save(widget);
            widgetRepository.save(nextWidget);
        }
        else {

            if(currWidgetOrder == getOrderOfFirstWidgetOfTopic(widget.getTopic().get_id())) {
                return 0;
            }

            Widget prevWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))-1);
            int prevWidgetOrder = prevWidget.getOrderSequence();

            widget.setOrderSequence(prevWidgetOrder);
            prevWidget.setOrderSequence(currWidgetOrder);


            widgetRepository.save(widget);
            widgetRepository.save(prevWidget);

        }
        return 1;
    }
}