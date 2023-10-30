module quarkusfx {

  requires jakarta.cdi;

  requires quarkus.core;
  requires quarkus.mongodb.panache;
  requires quarkus.mongodb.panache.common;

  requires org.mongodb.bson;

  requires javafx.controls;
  requires javafx.fxml;
}