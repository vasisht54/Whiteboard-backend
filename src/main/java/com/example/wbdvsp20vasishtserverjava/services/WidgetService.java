package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.*;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();

    {
        widgetList.add(new Widget("1","Heading Widget A", "5e941afeeed0a90017abafd5", "HEADING", 1, "Sample Heading text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("2", "Heading Widget B", "5e941afeeed0a90017abafd5","HEADING",3, "Sample Heading text",null,3,0,0,null,null,null));
        widgetList.add(new Widget("3","Doggo", "5e941afeeed0a90017abafd5", "IMAGE",2, "Irrelevant","https://www.rd.com/wp-content/uploads/2009/02/3D4D57AA-5E09-474E-BC53-0E6D03A18F5C-760x506.jpg",1,0,0,null,null,null));

        widgetList.add(new Widget("4","Heading Widget Z", "5e941b18eed0a90017abafd6", "HEADING",1, "Sample Heading text",null,4,0,0,null,null,null));
        widgetList.add(new Widget("5","Paragraph Widget X", "5e941b18eed0a90017abafd6", "PARAGRAPH",2, "Sample Paragraph text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("6","List Widget", "5e941b18eed0a90017abafd6", "LIST",3, "One\nTwo\nThree",null, 1,0,0,null,null,"OL"));
    }

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
        System.out.println("Last widget title = " + lastWidget.getTitle() + "; Order = " + lastWidget.getOrder());
        return widgetsForTopic.get(widgetsForTopic.size()-1).getOrder();
    }

    private int getOrderOfFirstWidgetOfTopic(String topicId) {
        List<Widget> widgetsForTopic = findWidgetsForTopic(topicId);
        widgetsForTopic.sort(Comparator.comparingInt(Widget::getOrder));
        Widget firstWidget = widgetsForTopic.get(0);
        System.out.println("First widget title = " + firstWidget.getTitle() + "; Order = " + firstWidget.getOrder());
        return widgetsForTopic.get(0).getOrder();
    }

    public int updateWidgetOrder(String widgetId, Widget widget, String direction) {

        System.out.println("Initially,");
        for(Widget w : widgetList) {
            System.out.println(w);
        }
        System.out.println();

        widget = widgetList.get(widgetList.indexOf(findWidgetById(widget.getId())));

        int currWidgetOrder = widget.getOrder();
        System.out.println("Current widget  =" + widget);
        List<Widget> widgetsForTopic = findWidgetsForTopic(widget.getTopicId());

        if(direction.equals("DOWN")) {

            if(currWidgetOrder == getOrderOfLastWidgetOfTopic(widget.getTopicId())) {
                return 0;
            }

            Widget nextWidget = widgetsForTopic.get(widgetsForTopic.indexOf(findWidgetById(widgetId))+1);
            int nextWidgetOrder = nextWidget.getOrder();

            widget.setOrder(nextWidgetOrder);
            System.out.println("Widget " + widget.getTitle() + " order is set to " + widget.getOrder());
            nextWidget.setOrder(currWidgetOrder);
            System.out.println("Widget " + nextWidget.getTitle() + " order is set to " + nextWidget.getOrder());


            //System.out.println("Index of " + widget.getTitle() + " = " + widgetList.indexOf(findWidgetById(widget.getId())));
            System.out.println("We're just about to set " + widget + " to index = " + widgetList.indexOf((findWidgetById(widget.getId()))));
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
            System.out.println("Widget " + widget.getTitle() + " order is set to " + widget.getOrder());
            prevWidget.setOrder(currWidgetOrder);
            System.out.println("Widget " + prevWidget.getTitle() + " order is set to " + prevWidget.getOrder());


            //System.out.println("Index of " + widget.getTitle() + " = " + widgetList.indexOf(findWidgetById(widget.getId())));
            System.out.println("We're just about to set " + widget + " to index = " + widgetList.indexOf((findWidgetById(widget.getId()))));
            widgetList.set(widgetList.indexOf(findWidgetById(widget.getId())), widget);
            widgetList.set(widgetList.indexOf(findWidgetById(prevWidget.getId())), prevWidget);

        }

        for(Widget w : widgetList) {
            System.out.println(w);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        return 1;
    }
}
