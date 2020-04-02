package com.example.wbdvsp20vasishtserverjava.services;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    private List<Widget> widgetList = new ArrayList<>();

    public void createWidget(Widget widget) {
        widgetList.add(widget);
    }

    public List<Widget> findAllWidgets() {
        return widgetList;
    }

    public void deleteWidget(String wid) {
        widgetList.remove(findWidgetById(wid));
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
