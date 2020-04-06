package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();

    {
        widgetList.add(new Widget("1","Heading Widget A", "5e867262d9496e00174f5e7c", "HEADING", 1, "Sample Heading text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("2", "Heading Widget B", "5e867262d9496e00174f5e7c","HEADING",1, "Sample Heading text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("3","Heading Widget C", "5e867262d9496e00174f5e7c", "HEADING",1, "Sample Heading text",null,1,0,0,null,null,null));

        widgetList.add(new Widget("4","Paragraph Widget X", "5e867261d9496e00174f5e7b", "PARAGRAPH",1, "Sample Paragraph text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("5","Heading Widget Z", "5e867261d9496e00174f5e7b", "HEADING",1, "Sample Heading text",null,1,0,0,null,null,null));
        widgetList.add(new Widget("6","Paragraph Widget Y", "5e867261d9496e00174f5e7b", "PARAGRAPH",1, "Sample Paragraph text",null, 1,0,0,null,null,null));
    }

    public Widget createWidget(Widget widget) {
        widgetList.add(widget);
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
        return results;
    }

    public int updateWidget(String wid, Widget widget) {
        for(Widget w: widgetList) {
            if(w.getId().equals(wid)) {
                widgetList.set(widgetList.indexOf(findWidgetById(wid)),widget);
                return 1;
            }
        }
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
}
