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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TareaApp extends Application {
    private final ObservableList<Tarea> tareas = FXCollections.observableArrayList();
    private final ListView<String> tareaListView = new ListView<>();
    private String logCorreo="";
    public static void main(String[] args) {
        launch(args);
    }
    
    public void setLogCorreo(String estado){
        this.logCorreo = estado;
    }
    
    public void login(){
        Stage login_ = new Stage();
        
        //campo para ingresa correo
        TextField correo = new TextField();
        correo.setPromptText("Ingrese con su correo");
        
        Button iniciarLoginButton = new Button("Login");
        iniciarLoginButton.setOnAction(event -> {
            String getCorreo = correo.getText();
            
            if (!getCorreo.isEmpty()) {
                correo.clear();
                login_.close(); 
                if(validarCorreo(getCorreo))
                    setLogCorreo(getCorreo);
            }
            
        });
        
        VBox rootLayout2 = new VBox(10, correo, iniciarLoginButton);
        rootLayout2.setPadding(new Insets(10));

        // Crear la escena
        Scene scene2 = new Scene(rootLayout2, 400, 350);

        login_.setScene(scene2);
        login_.showAndWait();
        
    }
    
    public boolean estalogueado(String x){
        boolean verificacion=false;
        if (!"".equals(x))
            verificacion=true;
        return verificacion;
    }
    
    
    
    @Override
    public void start(Stage primaryStage2) {
        primaryStage2.setTitle("Aplicación de Tareas");
        // Lista de Tareas
        
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
        agregarTareaButton.setOnAction(e->{
            if(!estalogueado(logCorreo))
                login();
            else
                mostrarPantallaSecundaria(tareaListView);
        });

        // Crear un diseño para organizar los elementos
        VBox rootLayout = new VBox(10, tareaListView, agregarTareaButton);
        rootLayout.setPadding(new Insets(10));

        // Crear la escena
        Scene scene = new Scene(rootLayout, 400, 350);

        primaryStage2.setScene(scene);
        primaryStage2.show();
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

    private boolean validarCorreo(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        }

   

    

   
}




