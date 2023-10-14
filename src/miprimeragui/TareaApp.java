/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package miprimeragui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TareaApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplicación de Tareas");

        // Crear el botón para abrir la pantalla secundaria
        Button agregarTareaButton = new Button("Agregar Tarea");
        agregarTareaButton.setOnAction(e -> mostrarPantallaSecundaria());

        // Crear el diseño principal de la ventana principal
        VBox rootLayout = new VBox(10, agregarTareaButton);
        rootLayout.setPadding(new Insets(10));

        // Crear la escena principal
        Scene scene = new Scene(rootLayout, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarPantallaSecundaria() {
        Stage secondaryStage = new Stage();
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.initStyle(StageStyle.UTILITY);
        secondaryStage.setTitle("Agregar Tarea");

        // Crear un campo de texto para ingresar la tarea
        TextField tareaTextField = new TextField();
        tareaTextField.setPromptText("Ingrese una tarea");

        // Crear un botón para guardar la tarea
        Button guardarTareaButton = new Button("Guardar Tarea");
        guardarTareaButton.setOnAction(event -> {
            String tarea = tareaTextField.getText();
            if (!tarea.isEmpty()) {
                // Puedes agregar la lógica para guardar la tarea aquí
                System.out.println("Tarea Guardada: " + tarea);
                tareaTextField.clear();
            }
        });

        // Crear el diseño de la pantalla secundaria
        VBox secondaryLayout = new VBox(10, tareaTextField, guardarTareaButton);
        secondaryLayout.setPadding(new Insets(10));

        // Crear la escena de la pantalla secundaria
        Scene secondaryScene = new Scene(secondaryLayout, 300, 150);
        secondaryStage.setScene(secondaryScene);

        secondaryStage.showAndWait();
    }
}

