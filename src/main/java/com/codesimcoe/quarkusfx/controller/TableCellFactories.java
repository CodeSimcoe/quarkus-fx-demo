package com.codesimcoe.quarkusfx.controller;

import com.codesimcoe.quarkusfx.common.Country;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public final class TableCellFactories {

  private TableCellFactories() {
    //
  }

  public static <T> Callback<TableColumn<T, Country>, TableCell<T, Country>> newCountryTableCellFactory() {
    return column -> new CountryTableCell<>();
  }
}
