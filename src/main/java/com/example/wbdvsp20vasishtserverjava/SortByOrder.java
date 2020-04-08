package com.example.wbdvsp20vasishtserverjava;

import com.example.wbdvsp20vasishtserverjava.models.Widget;

import java.util.Comparator;

public class SortByOrder implements Comparator<Widget> {

    @Override
    public int compare(Widget o1, Widget o2) {
        return o1.getOrder() - o2.getOrder();
    }
}
