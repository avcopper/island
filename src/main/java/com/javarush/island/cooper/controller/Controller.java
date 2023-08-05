package com.javarush.island.cooper.controller;

import com.javarush.island.cooper.view.View;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
