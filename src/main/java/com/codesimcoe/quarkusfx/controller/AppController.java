package com.codesimcoe.quarkusfx.controller;

import com.codesimcoe.quarkusfx.common.Country;
import com.codesimcoe.quarkusfx.ingredients.Hop;
import com.codesimcoe.quarkusfx.ingredients.HopService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Singleton
public class AppController {

  @Inject
  HopService hopService;

  @FXML
  private TableView<Hop> tableView;

  @FXML
  private TableColumn<Hop, String> nameColumn;

  @FXML
  private TableColumn<Hop, Float> alphaAcidsColumn;

  @FXML
  private TableColumn<Hop, Country> countryColumn;

  @FXML
  private TableColumn<Hop, Void> deleteColumn;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField alphaAcidsTextField;

  @FXML
  private ComboBox<Country> countryComboBox;

  @FXML
  private void initialize() {

    this.countryComboBox.getItems().addAll(Country.values());

    this.alphaAcidsColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAlphaAcids()));
    this.countryColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCountry()));
    this.nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

    // Alpha acids are stored as a float, but we want to display them as a percentage.
    this.alphaAcidsColumn.setCellFactory(column -> new TableCell<>() {

      @Override
      protected void updateItem(final Float item, final boolean empty) {
        super.updateItem(item, empty);
        this.setText(empty ? null : String.format("%.2f%%", 100 * item));
      }
    });

    this.countryColumn.setCellFactory(TableCellFactories.newCountryTableCellFactory());

    this.deleteColumn.setCellFactory(column -> new TableCell<>() {

      private static final Image IMAGE = new Image("images/delete-24.png");
      private final ImageView imageView = new ImageView(IMAGE);
      private final Button button = new Button("", this.imageView);

      {
        this.button.setOnAction(event -> {
          Hop hop = this.getTableView().getItems().get(this.getIndex());
          AppController.this.deleteData(hop);
        });
        this.button.setStyle("-fx-padding: 2");
      }

      @Override
      protected void updateItem(final Void item, final boolean empty) {
        super.updateItem(item, empty);
        this.setGraphic(empty ? null : this.button);
      }
    });

    this.loadData();
  }

  private void deleteData(final Hop hop) {
    CompletableFuture.runAsync(() -> {
      try {
        this.hopService.deleteHop(hop);
        Platform.runLater(() -> this.tableView.getItems().remove(hop));
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  private void loadData() {
    CompletableFuture.runAsync(() -> {
      try {
        List<Hop> hops = this.hopService.listHops();
        Platform.runLater(() -> {
          this.tableView.getItems().clear();
          this.tableView.getItems().addAll(hops);
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  @FXML
  private void addData() {
    String name = this.nameTextField.getText();
    float alphaAcids = Float.parseFloat(this.alphaAcidsTextField.getText()) / 100;
    Country country = this.countryComboBox.getValue();

    Hop hop = new Hop();
    hop.setName(name);
    hop.setAlphaAcids(alphaAcids);
    hop.setCountry(country);

    CompletableFuture.runAsync(() -> {
      try {
        this.hopService.saveHop(hop);

        Platform.runLater(() -> {
          this.nameTextField.clear();
          this.alphaAcidsTextField.clear();
          this.countryComboBox.getSelectionModel().clearSelection();
          this.tableView.getItems().add(hop);
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}