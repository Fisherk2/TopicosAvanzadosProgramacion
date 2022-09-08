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
 * Clase que genera un fichero .TXT que ademas actualiza y lee su contenido.
 *
 * @author Fisherk2
 */
public class FileTXT {

    private File txt;
    private String path;

    public FileTXT() {
        creacionFichero();
    }

    private void creacionFichero() {
        try {
            txt = new File("C:\\Users\\msi\\Desktop\\ITL\\5to semestre\\Topicos Avanzados de programacion\\Topicos Programacion\\Entrada.txt");
            if (txt.createNewFile()) {//Si el archivo a sido creado, enviara un mensaje
                System.out.println("\n---------------------------\n"
                        + "El archivo TXT se ha creado exitosamente");
            }
        } catch (IOException ex) { //serr + tabulador = System.err.println();
            System.err.println("NO SE PUDO CREAR EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null, "ERROR, EL ARCHIVO NO PUEDE CREARSE, VERIFIQUE BIEN LA DIRECCION ABSOLUTA DEL FICHERO");
        }
    }

    public void escribirFichero(String entrada) {
        try {
            FileWriter escribir = new FileWriter(txt);
            escribir.write(entrada);
            //Siempre que se va utilizar la clase FileWriter se debe cerrar el archivo cuando se termine de utilizar.
            escribir.close();

        } catch (IOException ex) {
            System.err.println("ERROR, EL ARCHIVO NO SE PUDO ESCRIBIR SOBRE EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null, "ERROR, EL ARCHIVO NO PUEDE ESCRIBIRSE, VERIFIQUE BIEN LA DIRECCION ABSOLUTA DEL FICHERO");
        }

    }

    public String leerFichero() {
        String cadena;
        String contenido = "";
        try {
            FileReader lector = new FileReader(txt);
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine(); //Leera la primer linea que se encuentra en el fichero hasta que llegue a un null

            while (cadena != null) {//Si no hay vacios en nuestro archivos, entonces se tiene que seguir leyendo el archivo
                System.out.println("\n" + cadena);
                contenido += cadena + "\n";
                cadena = lectura.readLine(); //Volvera a leer la siguiente linea hasta encontrar con un vacio
            }

        } catch (FileNotFoundException ex) {
            System.err.println("ERROR, NO SE PUEDE ENCONTRAR EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null, "ERROR, EL ARCHIVO NO PUEDE ENCONTRARSE, VERIFIQUE BIEN LA DIRECCION ABSOLUTA DEL FICHERO");
        } catch (IOException ex) {
            System.err.println("ERROR, NO SE PUEDE LEER EL ARCHIVO " + ex);
            JOptionPane.showMessageDialog(null, "ERROR, EL ARCHIVO NO PUEDE LEER, VERIFIQUE BIEN EL CONTENIDO DEL FICHERO");

        }

        return contenido;
    }

    public String getPath() {
        return txt.getPath();
    }

}
