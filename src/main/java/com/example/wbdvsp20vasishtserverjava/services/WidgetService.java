package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.*;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();


    public Widget createWidget(Widget widget) {
        widgetList.add(widget);
        widgetList.sort(Comparator.comparingInt(Widget::getOrder));
        return widget;
    }

    public List<Widget> findAllWidgets() {
        return widgetList;
    }

    public boolean deleteWidget(String wid) {
        return widgetList.remove(findWidgetById(wid));
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> results = new ArrayList<>();
        for(Widget w: widgetList) {
            if(w.getTopicId().equals(topicId)) {
                results.add(w);
            }
        }
        results.sort(Comparator.comparingInt(Widget::getOrder));
        return results;
    }

    public int updateWidget(String wid, Widget widget) {
        for(Widget w: widgetList) {
            if(w.getId().equals(wid)) {
                widgetList.set(widgetList.indexOf(findWidgetById(wid)),widget);
                return 1;
            }
        }
        widgetList.sort(Comparator.comparingInt(Widget::getOrder));
        return 0;
    }

    public Widget findWidgetById(String wid) {
        for(Widget w: widgetList) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }

        return null;
    }

    private int getOrderOfLastWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        widgetsForTopic.sort(Comparator.comparingInt(Widget::getOrder));
        Widget lastWidget = widgetsForTopic.get(widgetsForTopic.size()-1);
        return widgetsForTopic.get(widgetsForTopic.size()-1).getOrder();
    }

    private int getOrderOfFirstWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        widgetsForTopic.sort(Comparator.comparingInt(Widget::getOrder));
        Widget firstWidget = widgetsForTopic.get(0);
        return widgetsForTopic.get(0).getOrder();
    }

    public int updateWidgetOrder(String widgetId, Widget widget, String direction) {

        widget = widgetList.get(widgetList.indexOf(findWidgetById(widget.getId())));

        int currWidgetOrder = widget.getOrder();
        List<Widget> widgetsForTopic = findWidgetsForTopic(widget.getTopicId());

        if(direction.equals("DOWN")) {

            if(currWidgetOrder == getOrderOfLastWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget nextWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))+1);
            int nextWidgetOrder = nextWidget.getOrder();

            widget.setOrder(nextWidgetOrder);
            nextWidget.setOrder(currWidgetOrder);

            widgetList.set(widgetList.indexOf(findWidgetById(widget.getId())), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(nextWidget.getId())), nextWidget);

        }
        else {

            if(currWidgetOrder == getOrderOfFirstWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget prevWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))-1);
            int prevWidgetOrder = prevWidget.getOrder();

            widget.setOrder(prevWidgetOrder);
            prevWidget.setOrder(currWidgetOrder);


            widgetList.set(widgetList.indexOf(findWidgetById(widget.getId())), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(prevWidget.getId())), prevWidget);

        }
        return 1;
    }
}
