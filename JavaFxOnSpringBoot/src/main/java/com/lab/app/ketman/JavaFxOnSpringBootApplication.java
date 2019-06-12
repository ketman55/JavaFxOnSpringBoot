package com.lab.app.ketman;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.lab.app.ketman.javafx.MySpringFXMLLoader;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class JavaFxOnSpringBootApplication extends Application { // ★Application を継承

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) throws IOException {
		// ★ApplicationContext は後で使うので static 変数に保存しておく
		context = SpringApplication.run(JavaFxOnSpringBootApplication.class, args); // ★Spring Boot を起動
		launch(args); // ★JavaFX を起動
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// ★自作の FXMLLoader を Spring のコンテナから取得
		MySpringFXMLLoader loader = context.getBean(MySpringFXMLLoader.class);

		// ★fxml をロード
		Parent root = loader.load("sample.fxml");

		// ★あとは普通の JavaFX と同じ
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		context.close(); // ★アプリ終了時に stop() メソッドがコールバックされるので、 Spring コンテナを終了させる
	}
}