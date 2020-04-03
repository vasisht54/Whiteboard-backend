package com.example.wbdvsp20vasishtserverjava.controllers;

import com.example.wbdvsp20vasishtserverjava.models.Widget;
import com.example.wbdvsp20vasishtserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    private WidgetService widgetService = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/topics/{tId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tId") String topicId) {
        return widgetService.findWidgetsForTopic(topicId);
    }

    @PutMapping("/api/widgets/{wId}")
    public int updateWidget(@PathVariable("wId") String widgetId, @RequestBody Widget widget) {
        return widgetService.updateWidget(widgetId, widget);
    }

    @PostMapping("/api/widgets")
    public void createWidget(@RequestBody Widget widget) {
        widgetService.createWidget(widget);
    }

    @DeleteMapping("/api/widgets/{wId}")
    public int deleteWidget(@PathVariable("wId") String widgetId) {
        boolean res = widgetService.deleteWidget(widgetId);
        return res ? 1 : 0;
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
