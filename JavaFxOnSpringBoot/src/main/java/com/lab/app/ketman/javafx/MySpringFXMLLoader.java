package com.lab.app.ketman.javafx;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

@Component // ★コンポーネントとして登録
public class MySpringFXMLLoader {

    @Autowired
    private ApplicationContext context;

    public Parent load(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(); // ★オリジナルの FXMLLoader を生成

        loader.setControllerFactory(this.context::getBean); // ★ControllerFactory に ApplicationContext を利用する

        return loader.load(MySpringFXMLLoader.class.getClassLoader().getResourceAsStream(path));
    }
}
