/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miprimeragui;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {
    public static void main(String[] args) {
        String si = "ajajjajajja ajajja soy alex";
        write(si);
    }
    public static void write(String file){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivo.txt"))) {
            writer.write(file);
            } catch (IOException e) {
        }
    }
}

