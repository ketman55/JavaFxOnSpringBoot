package com.lab.app.ketman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab.app.ketman.component.MyBean;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Component
public class Controller {

    @FXML
    private Label label;

    @Autowired
    private MyBean bean;

    @FXML
    public void onClickButton() {
        String text = this.bean.getText();
        this.label.setText(text);
    }
}
