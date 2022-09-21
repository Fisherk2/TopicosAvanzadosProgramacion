/*
 * NOMBRE: Fisher
 * FECHA: 7/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package Encriptado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Clase que genera un fichero que ademas actualiza y lee su contenido.
 *
 * @author Fisherk2
 */
public class Fichero {

    private File archivo;
    private final String NAME_FILE, FORMATO;

    public Fichero(String nombreArchivo, String formato) {
        NAME_FILE = nombreArchivo;
        FORMATO = formato;
        creacionFichero();
    }

    private void creacionFichero() {
        try {
            archivo = new File(NAME_FILE + FORMATO); //RUTA RELATIVA, se encuentra en la carpeta del proyecto.

            if (archivo.createNewFile()) {// Si el archivo a sido creado, enviara un mensaje
                System.out.println("El archivo " + FORMATO + " se ha creado exitosamente");

            }
        } catch (IOException ex) { // serr + tabulador = System.err.println();
            System.err.println("NO SE PUDO CREAR EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null,
                    "ERROR, EL ARCHIVO NO PUEDE CREARSE, VERIFIQUE BIEN LA DIRECCION DEL FICHERO");
        }
    }

    public void escribirFichero(String entrada) {
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(entrada);
            escribir.close();

        } catch (IOException ex) {
            System.err.println("ERROR, EL ARCHIVO NO SE PUDO ESCRIBIR SOBRE EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null,
                    "ERROR, EL ARCHIVO NO PUEDE ESCRIBIRSE, VERIFIQUE BIEN LA DIRECCION DEL FICHERO");
        }

    }

    public String leerFichero() {
        String cadena;
        String contenido = "";
        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);
            cadena = lectura.readLine(); // Leera la primer linea que se encuentra en el fichero
            while (cadena != null) {// Si no hay vacios en nuestro archivos, entonces se tiene que seguir leyendo el archivo
                contenido += cadena + "\n";
                cadena = lectura.readLine(); // Volvera a leer la siguiente linea hasta encontrar con un vacio
            }

        } catch (FileNotFoundException ex) {
            System.err.println("ERROR, NO SE PUEDE ENCONTRAR EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null,
                    "ERROR, EL ARCHIVO NO PUEDE ENCONTRARSE, VERIFIQUE BIEN LA DIRECCION ABSOLUTA DEL FICHERO");
        } catch (IOException ex) {
            System.err.println("ERROR, NO SE PUEDE LEER EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null,
                    "ERROR, EL ARCHIVO NO PUEDE LEER, VERIFIQUE BIEN EL CONTENIDO DEL FICHERO");

        }

        return contenido;
    }

    public String getPath() {
        return archivo.getAbsolutePath();
    }

}
