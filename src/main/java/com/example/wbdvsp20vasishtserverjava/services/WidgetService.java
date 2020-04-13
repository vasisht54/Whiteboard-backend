package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.SortByOrder;
import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.*;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();

    {
        widgetList.add(new Widget("1","Heading Widget A", "5e867262d9496e00174f5e7c", "HEADING", 1, "Sample Heading text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("2", "Heading Widget B", "5e867262d9496e00174f5e7c","HEADING",1, "Sample Heading text",null,3,0,0,null,null,null));
        widgetList.add(new Widget("3","Doggo", "5e867262d9496e00174f5e7c", "IMAGE",3, "Irrelevant","https://www.rd.com/wp-content/uploads/2009/02/3D4D57AA-5E09-474E-BC53-0E6D03A18F5C-760x506.jpg",1,0,0,null,null,null));

        widgetList.add(new Widget("4","Heading Widget Z", "5e867261d9496e00174f5e7b", "HEADING",1, "Sample Heading text",null,4,0,0,null,null,null));
        widgetList.add(new Widget("5","Paragraph Widget X", "5e867261d9496e00174f5e7b", "PARAGRAPH",2, "Sample Paragraph text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("6","List Widget", "5e867261d9496e00174f5e7b", "LIST",3, "One\nTwo\nThree",null, 1,0,0,null,null,"OL"));
    }

    public Widget createWidget(Widget widget) {
        widgetList.add(widget);
        widgetList.sort(new SortByOrder());
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
        results.sort(new SortByOrder());
        return results;
    }

    public int updateWidget(String wid, Widget widget) {
        for(Widget w: widgetList) {
            if(w.getId().equals(wid)) {
                widgetList.set(widgetList.indexOf(findWidgetById(wid)),widget);
                return 1;
            }
        }
        widgetList.sort(new SortByOrder());
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
        return widgetsForTopic.get(widgetsForTopic.size()-1).getOrder();
    }

    private int getOrderOfFirstWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        return widgetsForTopic.get(0).getOrder();
    }

    public int updateWidgetOrder(String widgetId, Widget widget, String direction) {

        int currWidgetOrder = widget.getOrder();
        System.out.println("Title =" + widget.getTitle() + "\n order" + widget.getOrder());
        List<Widget> widgetsForTopic = findWidgetsForTopic(widget.getTopicId());

        if(direction.equals("DOWN")) {

            if(currWidgetOrder == getOrderOfLastWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget nextWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))+1);
            int nextWidgetOrder = nextWidget.getOrder();

            widget.setOrder(nextWidgetOrder);
            nextWidget.setOrder(currWidgetOrder);

            widgetList.set(widgetList.indexOf(findWidgetById(widgetId)), widget);
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

            widgetList.set(widgetList.indexOf(findWidgetById(widgetId)), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(prevWidget.getId())), prevWidget);

        }
        return 1;
    }
}
