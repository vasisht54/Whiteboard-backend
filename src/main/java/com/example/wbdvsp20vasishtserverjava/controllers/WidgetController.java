package com.example.wbdvsp20vasishtserverjava.controllers;

import com.example.wbdvsp20vasishtserverjava.models.Widget;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WidgetController {

    private List<Widget> widgetList = new ArrayList<>();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        Widget w1 = new Widget("123", "Widget A");
        Widget w2 = new Widget("234", "Widget B");
        Widget w3 = new Widget("345", "Widget C");
        widgetList.add(w1);
        widgetList.add(w2);
        widgetList.add(w3);
        return widgetList;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world!";
    }
}
