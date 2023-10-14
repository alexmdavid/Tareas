/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package miprimeragui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TareaApp extends Application {
    private ObservableList<Tarea> tareas = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplicación de Tareas");

        // Lista de Tareas
        ListView<String> tareaListView = new ListView<>();
        tareaListView.setPrefHeight(200);
        tareaListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    String[] partes = item.split(" - ");
                    if (partes.length == 2) {
                        setText(partes[0] + " - Fecha: " + partes[1]);
                    } else {
                        setText(item);
                    }
                }
            }
        });

        // Crear un botón para agregar tarea
        Button agregarTareaButton = new Button("Agregar Tarea");
        agregarTareaButton.setOnAction(e -> mostrarPantallaSecundaria(tareaListView));

        // Crear un diseño para organizar los elementos
        VBox rootLayout = new VBox(10, tareaListView, agregarTareaButton);
        rootLayout.setPadding(new Insets(10));

        // Crear la escena
        Scene scene = new Scene(rootLayout, 400, 350);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarPantallaSecundaria(ListView<String> tareaListView) {
        Stage secondaryStage = new Stage();
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.initStyle(StageStyle.UTILITY);
        secondaryStage.setTitle("Agregar Tarea");

        // Crear un campo de texto para ingresar la tarea
        TextField tareaTextField = new TextField();
        tareaTextField.setPromptText("Ingrese una tarea");

        // Crear un DatePicker para seleccionar la fecha
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Seleccione la fecha");

        // Crear un botón para guardar la tarea
        Button guardarTareaButton = new Button("Guardar Tarea");
        guardarTareaButton.setOnAction(event -> {
            String tarea = tareaTextField.getText();
            if (!tarea.isEmpty()) {
                LocalDate fecha = datePicker.getValue();
                tareas.add(new Tarea(tarea, fecha));
                tareaListView.getItems().add(tarea + " - " + fecha);
                tareaTextField.clear();
                datePicker.getEditor().clear();
                secondaryStage.close();
            }
        });

        // Crear un diseño para organizar los elementos en la pantalla secundaria
        VBox secondaryLayout = new VBox(10, tareaTextField, datePicker, guardarTareaButton);
        secondaryLayout.setPadding(new Insets(10));

        // Crear la escena de la pantalla secundaria
        Scene secondaryScene = new Scene(secondaryLayout, 300, 200);
        secondaryStage.setScene(secondaryScene);

        secondaryStage.showAndWait();
    }
}




