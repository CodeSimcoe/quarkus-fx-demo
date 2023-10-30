package com.codesimcoe.quarkusfx.application;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class QuarkusFxApp {

	@Inject
	FXMLLoader fxmlLoader;

	public void start(@Observes @StartupScene Stage stage) {

		try {
			URL fxml = this.getClass().getResource("/app.fxml");
			Parent fxmlParent = this.fxmlLoader.load(fxml.openStream());
			stage.setScene(new Scene(fxmlParent, 800, 600));
			stage.setTitle("Hello World Quarkus and JavaFX!");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}