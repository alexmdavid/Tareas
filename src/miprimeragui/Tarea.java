/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miprimeragui;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private LocalDate fecha;

    public Tarea(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return descripcion + " - " + fecha;
    }
}

