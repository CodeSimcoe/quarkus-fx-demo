package com.codesimcoe.quarkusfx.controller;

import com.codesimcoe.quarkusfx.common.Country;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Render a country cell, containing the flag's image and text
 */
public class CountryTableCell<T> extends TableCell<T, Country> {

  private final ImageView imageView = new ImageView();
  private final Label label = new Label();
  private final HBox hbox = new HBox(5, this.imageView, this.label);

  CountryTableCell() {
    this.hbox.setAlignment(Pos.CENTER_LEFT);
  }

  @Override
  protected void updateItem(final Country item, final boolean empty) {
    super.updateItem(item, empty);

    if (item == null || empty) {
      this.setGraphic(null);
      this.setText(null);
    } else {
      // Assuming Model class has getImagePath() and getText() methods
      this.imageView.setImage(item.getImage());
      this.label.setText(item.getText());

      this.setGraphic(this.hbox);
    }
  }
}
