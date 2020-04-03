package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();

    {
        widgetList.add(new Widget("1", "Widget A", "5e867262d9496e00174f5e7c", "HEADING", 1, "sample text",null,0,0,0,null,null,null));
        widgetList.add(new Widget("2", "Widget B", "5e867262d9496e00174f5e7c","HEADING",1, "sample text",null,0,0,0,null,null,null));
        widgetList.add(new Widget("3", "Widget C", "5e867262d9496e00174f5e7c", "HEADING",1, "sample text",null,0,0,0,null,null,null));

        widgetList.add(new Widget("4", "Widget X", "5e867261d9496e00174f5e7b", "PARAGRAPH",1, "sample text",null,0,0,0,null,null,null));
        widgetList.add(new Widget("5", "Widget Y", "5e867261d9496e00174f5e7b", "PARAGRAPH",1, "sample text",null,0,0,0,null,null,null));
        widgetList.add(new Widget("6", "Widget Z", "5e867261d9496e00174f5e7b", "HEADING",1, "sample text",null,0,0,0,null,null,null));
    }

    public void createWidget(Widget widget) {
        widgetList.add(widget);
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
