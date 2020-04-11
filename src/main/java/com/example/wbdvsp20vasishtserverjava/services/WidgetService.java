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
        return widget;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    public boolean deleteWidget(int wid) {
        return false;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {

        return null;
    }

    public int updateWidget(int wid, Widget widget) {

        return 0;
    }

    public Widget findWidgetById(int wid) {
        return widgetRepository.findById(wid).get();
    }

    private int getOrderOfLastWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        return widgetsForTopic.get(widgetsForTopic.size()-1).getOrderSequence();
    }

    private int getOrderOfFirstWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        return widgetsForTopic.get(0).getOrderSequence();
    }

    public int updateWidgetOrder(int widgetId, Widget widget, String direction) {

        int currWidgetOrder = widget.getOrderSequence();
        System.out.println("Title =" + widget.getTitle() + "\n order" + widget.getOrderSequence());
        List<Widget> widgetsForTopic = findWidgetsForTopic(widget.getTopicId());

        if(direction.equals("DOWN")) {

            if(currWidgetOrder == getOrderOfLastWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget nextWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))+1);
            int nextWidgetOrder = nextWidget.getOrderSequence();

            widget.setOrderSequence(nextWidgetOrder);
            nextWidget.setOrderSequence(currWidgetOrder);
/*

            widgetList.set(widgetList.indexOf(findWidgetById(widgetId)), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(nextWidget.getId())), nextWidget);
*/

        }
        else {

            if(currWidgetOrder == getOrderOfFirstWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget prevWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))-1);
            int prevWidgetOrder = prevWidget.getOrderSequence();

            widget.setOrderSequence(prevWidgetOrder);
            prevWidget.setOrderSequence(currWidgetOrder);
/*
            widgetList.set(widgetList.indexOf(findWidgetById(widgetId)), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(prevWidget.getId())), prevWidget);*/

        }
        return 1;
    }
}
