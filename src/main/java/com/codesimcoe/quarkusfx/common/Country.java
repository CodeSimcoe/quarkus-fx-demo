package com.codesimcoe.quarkusfx.common;

import javafx.scene.image.Image;

public enum Country {
  AUSTRALIA("Australia", "australia"),
  CZECH_REPUBLIC("Czech Republic", "czech-republic"),
  FRANCE("France", "france"),
  GERMANY("Germany", "germany"),
  JAPAN("Japan", "japan"),
  NEW_ZEALAND("New Zealand", "new-zealand"),
  UNITED_KINGDOM("United Kingdom", "united-kingdom"),
  UNITED_STATES("United States", "united-states");

  private final String text;
  private final Image image;

  Country(final String text, final String prefix) {
    this.text = text;
    this.image = new Image("images/flags/" + prefix + "-32.png");
  }

  public String getText() {
    return this.text;
  }

  public Image getImage() {
    return this.image;
  }
}