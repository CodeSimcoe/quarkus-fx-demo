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

	public void start(@Observes @PrimaryStage Stage stage) {

		try {
			URL fxml = this.getClass().getResource("/app.fxml");
			Parent fxmlParent = this.fxmlLoader.load(fxml.openStream());

			Scene scene = new Scene(fxmlParent, 800, 600);
//			scene.getStylesheets().add(QuarkusFxApp.class.getResource("/hiberbee.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Hello World Quarkus and JavaFX!");
//			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}