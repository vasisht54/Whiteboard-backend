package com.example.wbdvsp20vasishtserverjava.controllers;

import com.example.wbdvsp20vasishtserverjava.models.Widget;
import com.example.wbdvsp20vasishtserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/widgets/{wId}/{direction}")
    public int updateWidgetOrder(@PathVariable("wId") String widgetId, @PathVariable("direction") String direction,
                                 @RequestBody Widget widget) {
        return widgetService.updateWidgetOrder(widgetId, widget, direction);
    }

    @PostMapping("/api/topics/{tId}/widgets")
    public Widget createWidget(@PathVariable("tId") String topicId, @RequestBody Widget widget) {
        widget.setTopicId(topicId);
        return widgetService.createWidget(widget);
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
