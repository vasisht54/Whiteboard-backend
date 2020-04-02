package com.example.wbdvsp20vasishtserverjava.controllers;

import com.example.wbdvsp20vasishtserverjava.models.Widget;
import com.example.wbdvsp20vasishtserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WidgetController {
    private WidgetService widgetService = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @PostMapping("/api/widgets")
    public void createWidget(@RequestBody Widget widget) {
        widgetService.createWidget(widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public void deleteWidget(@PathVariable("widgetId") String wid) {
        widgetService.deleteWidget(wid);
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId")  String wid) {
        return widgetService.findWidgetById(wid);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world!";
    }
}
