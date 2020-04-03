package com.example.wbdvsp20vasishtserverjava.models;

public class Widget {
    private String id;
    private String title = "New Widget";
    private String topicId;
    private String type = "HEADING";
    private int order;
    private String text;
    private String src;
    private int size;
    private int width;
    private int height;
    private String cssClass;
    private String style;
    private String value;

    public Widget(String id, String title, String topicId, String type, int order, String text, String src,
                  int size, int width, int height, String cssClass, String style, String value) {
        this.id = id;
        this.title = title;
        this.topicId = topicId;
        this.type = type;
        this.order = order;
        this.text = text;
        this.src = src;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
    }

    public Widget() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

